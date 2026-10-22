package com.android.server.media;

import android.app.ActivityThread;
import android.media.MediaMetadata;
import android.media.session.ISessionManager;
import android.media.session.MediaController;
import android.media.session.MediaSession;
import android.media.session.MediaSessionManager;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.ShellCommand;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.android.server.media.projection.IMediaProjectionManagerServiceExt;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class MediaShellCommand extends ShellCommand {
    private static MediaSessionManager sMediaSessionManager;
    private static ActivityThread sThread;
    private PrintWriter mErrorWriter;
    private InputStream mInput;
    private final String mPackageName;
    private ISessionManager mSessionService;
    private PrintWriter mWriter;

    class ControllerCallback extends MediaController.Callback {
        final /* synthetic */ MediaShellCommand this$0;

        ControllerCallback(MediaShellCommand this$0) {
            this.this$0 = this$0;
        }

        @Override // android.media.session.MediaController.Callback
        public void onSessionDestroyed() {
            MediaShellCommand.m5758$$Nest$fgetmWriter(this.this$0).println("onSessionDestroyed. Enter q to quit.");
        }

        @Override // android.media.session.MediaController.Callback
        public void onSessionEvent(String event, Bundle extras) {
            MediaShellCommand.m5758$$Nest$fgetmWriter(this.this$0).println("onSessionEvent event=" + event + ", extras=" + extras);
        }

        @Override // android.media.session.MediaController.Callback
        public void onPlaybackStateChanged(PlaybackState state) {
            MediaShellCommand.m5758$$Nest$fgetmWriter(this.this$0).println("onPlaybackStateChanged " + state);
        }

        @Override // android.media.session.MediaController.Callback
        public void onMetadataChanged(MediaMetadata metadata) {
            if (metadata != null) goto L4;
            String mmString = null;
        L5:
            MediaShellCommand.m5758$$Nest$fgetmWriter(this.this$0).println("onMetadataChanged " + mmString);
            return;
        L4:
            mmString = "title=" + metadata.getDescription();
            goto L5
        }

        @Override // android.media.session.MediaController.Callback
        public void onQueueChanged(List<MediaSession.QueueItem> queue) {
            PrintWriter r0 = MediaShellCommand.m5758$$Nest$fgetmWriter(this.this$0);
            StringBuilder r1 = new StringBuilder();
            r1.append("onQueueChanged, ");
            if (queue != null) goto L5;
            String r2 = "null queue";
        L6:
            r1.append(r2);
            r0.println(r1.toString());
            return;
        L5:
            r2 = " size=" + queue.size();
            goto L6
        }

        @Override // android.media.session.MediaController.Callback
        public void onQueueTitleChanged(CharSequence title) {
            MediaShellCommand.m5758$$Nest$fgetmWriter(this.this$0).println("onQueueTitleChange " + title);
        }

        @Override // android.media.session.MediaController.Callback
        public void onExtrasChanged(Bundle extras) {
            MediaShellCommand.m5758$$Nest$fgetmWriter(this.this$0).println("onExtrasChanged " + extras);
        }

        @Override // android.media.session.MediaController.Callback
        public void onAudioInfoChanged(MediaController.PlaybackInfo info) {
            MediaShellCommand.m5758$$Nest$fgetmWriter(this.this$0).println("onAudioInfoChanged " + info);
        }
    }

    private class ControllerMonitor {
        private final MediaController mController;
        private final ControllerCallback mControllerCallback;
        final /* synthetic */ MediaShellCommand this$0;

        /* JADX INFO: renamed from: -$$Nest$fgetmController, reason: not valid java name */
        static /* bridge */ /* synthetic */ MediaController m5759$$Nest$fgetmController(ControllerMonitor r0) {
            return r0.mController;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmControllerCallback, reason: not valid java name */
        static /* bridge */ /* synthetic */ ControllerCallback m5760$$Nest$fgetmControllerCallback(ControllerMonitor r0) {
            return r0.mControllerCallback;
        }

        ControllerMonitor(MediaShellCommand r2, MediaController controller) {
            this.this$0 = r2;
            this.mController = controller;
            this.mControllerCallback = new ControllerCallback(r2);
        }

        void printUsageMessage() {
            MediaShellCommand.m5758$$Nest$fgetmWriter(this.this$0).println("V2Monitoring session " + this.mController.getTag() + "...  available commands: play, pause, next, previous");     // Catch: RuntimeException -> L4
        L6:
            MediaShellCommand.m5758$$Nest$fgetmWriter(this.this$0).println("(q)uit: finish monitoring");
            return;
        L5:
            MediaShellCommand.m5758$$Nest$fgetmWriter(this.this$0).println("Error trying to monitor session!");
            goto L6
        }

        void run() throws RemoteException {
            printUsageMessage();
            final String r1 = "MediaCb";
            HandlerThread cbThread = new AnonymousClass1(this, r1);
            cbThread.start();
            InputStreamReader converter = new InputStreamReader(MediaShellCommand.m5757$$Nest$fgetmInput(this.this$0));     // Catch: Throwable -> L18 IOException -> L20
            BufferedReader in = new BufferedReader(converter);     // Catch: Throwable -> L18 IOException -> L20
        L4:
            MediaShellCommand.m5758$$Nest$fgetmWriter(this.this$0).flush();     // Catch: Throwable -> L18 IOException -> L20
            MediaShellCommand.m5756$$Nest$fgetmErrorWriter(this.this$0).flush();     // Catch: Throwable -> L18 IOException -> L20
            String line = in.readLine();     // Catch: Throwable -> L18 IOException -> L20
            if (line == null) goto L42;
            boolean addNewline = true;
            if (line.length() > 0) goto L11;
            addNewline = false;
        L32:
            monitor-enter(this);     // Catch: Throwable -> L18 IOException -> L20
            if (addNewline == true) goto L58;
        L37:
            printUsageMessage();     // Catch: Throwable -> L35
            monitor-exit(this);     // Catch: Throwable -> L35
            goto L4
        L58:
            MediaShellCommand.m5758$$Nest$fgetmWriter(this.this$0).println("");     // Catch: Throwable -> L35
        L35:
            th = move-exception;
            throw th;     // Catch: Throwable -> L18 IOException -> L20
        L11:
            if ("q".equals(line) == true) goto L42;
            if ("quit".equals(line) == true) goto L42;
            if ("play".equals(line) == false) goto L23;
            dispatchKeyCode(126);     // Catch: Throwable -> L18 IOException -> L20
            goto L32
        L23:
            if ("pause".equals(line) == false) goto L26;
            dispatchKeyCode(127);     // Catch: Throwable -> L18 IOException -> L20
            goto L32
        L26:
            if ("next".equals(line) == false) goto L29;
            dispatchKeyCode(87);     // Catch: Throwable -> L18 IOException -> L20
            goto L32
        L29:
            if ("previous".equals(line) == false) goto L31;
            dispatchKeyCode(88);     // Catch: Throwable -> L18 IOException -> L20
            goto L32
        L31:
            MediaShellCommand.m5756$$Nest$fgetmErrorWriter(this.this$0).println("Invalid command: " + line);     // Catch: Throwable -> L18 IOException -> L20
        L42:
            cbThread.getLooper().quit();
            this.mController.unregisterCallback(this.mControllerCallback);     // Catch: Exception -> L45
        L65:
            return;
        L20:
            e = move-exception;
            e.printStackTrace();     // Catch: Throwable -> L18
            cbThread.getLooper().quit();
            this.mController.unregisterCallback(this.mControllerCallback);     // Catch: Exception -> L45
        L18:
            th = move-exception;
            cbThread.getLooper().quit();
            this.mController.unregisterCallback(this.mControllerCallback);     // Catch: Exception -> L56
        L57:
            throw th;
        }

        private void dispatchKeyCode(int keyCode) {
            long now = SystemClock.uptimeMillis();
            KeyEvent down = new KeyEvent(now, now, 0, keyCode, 0, 0, -1, 0, 0, 257);
            KeyEvent up = new KeyEvent(now, now, 1, keyCode, 0, 0, -1, 0, 0, 257);
            this.mController.dispatchMediaButtonEvent(down);     // Catch: RuntimeException -> L5
            this.mController.dispatchMediaButtonEvent(up);     // Catch: RuntimeException -> L5
            return;
        L6:
            MediaShellCommand.m5756$$Nest$fgetmErrorWriter(this.this$0).println("Failed to dispatch " + keyCode);
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmErrorWriter, reason: not valid java name */
    static /* bridge */ /* synthetic */ PrintWriter m5756$$Nest$fgetmErrorWriter(MediaShellCommand r0) {
        return r0.mErrorWriter;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmInput, reason: not valid java name */
    static /* bridge */ /* synthetic */ InputStream m5757$$Nest$fgetmInput(MediaShellCommand r0) {
        return r0.mInput;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmWriter, reason: not valid java name */
    static /* bridge */ /* synthetic */ PrintWriter m5758$$Nest$fgetmWriter(MediaShellCommand r0) {
        return r0.mWriter;
    }

    public MediaShellCommand(String packageName) {
        this.mPackageName = packageName;
    }

    public int onCommand(String cmd) {
        this.mWriter = getOutPrintWriter();
        this.mErrorWriter = getErrPrintWriter();
        this.mInput = getRawInputStream();
        if (TextUtils.isEmpty(cmd) == false) goto L7;
        return handleDefaultCommands(cmd);
    L7:
        if (sThread != null) goto L9;
        Looper.prepare();
        sThread = ActivityThread.currentActivityThread();
        sMediaSessionManager = (MediaSessionManager) sThread.getSystemContext().getSystemService("media_session");
    L9:
        this.mSessionService = ISessionManager.Stub.asInterface(ServiceManager.checkService("media_session"));
        if (this.mSessionService == null) goto L36;
    L15:
        e = move-exception;
        showError(e.toString());
        return -1;
    L13:
        if (cmd.equals("dispatch") == false) goto L18;
        runDispatch();     // Catch: Exception -> L15
        return 0;
    L18:
        if (cmd.equals("list-sessions") == false) goto L21;
        runListSessions();     // Catch: Exception -> L15
        return 0;
    L21:
        if (cmd.equals("monitor") == false) goto L24;
        runMonitor();     // Catch: Exception -> L15
        return 0;
    L24:
        if (cmd.equals("volume") == false) goto L27;
        runVolume();     // Catch: Exception -> L15
        return 0;
    L27:
        if (cmd.equals("expire-temp-engaged-sessions") == false) goto L31;
        expireTempEngagedSessions();     // Catch: Exception -> L15
        return 0;
    L31:
        showError("Error: unknown command '" + cmd + "'");     // Catch: Exception -> L15
        return -1;
    L36:
        throw new IllegalStateException("Can't connect to media session service; is the system running?");
    }

    public void onHelp() {
        this.mWriter.println("usage: media_session [subcommand] [options]");
        this.mWriter.println("       media_session dispatch KEY");
        this.mWriter.println("       media_session list-sessions");
        this.mWriter.println("       media_session monitor <tag>");
        this.mWriter.println("       media_session volume [options]");
        this.mWriter.println("       media_session expire-temp-engaged-sessions");
        this.mWriter.println();
        this.mWriter.println("media_session dispatch: dispatch a media key to the system.");
        this.mWriter.println("                KEY may be: play, pause, play-pause, mute, headsethook,");
        this.mWriter.println("                stop, next, previous, rewind, record, fast-forward.");
        this.mWriter.println("media_session list-sessions: print a list of the current sessions.");
        this.mWriter.println("media_session monitor: monitor updates to the specified session.");
        this.mWriter.println("                       Use the tag from list-sessions.");
        this.mWriter.println("media_session volume:  " + VolumeCtrl.USAGE);
        this.mWriter.println("media_session expire-temp-engaged-sessions: Expires any ongoing");
        this.mWriter.println("                timers for media sessions in a temporary user-engaged");
        this.mWriter.println("                state.");
        this.mWriter.println();
    }

    private void sendMediaKey(KeyEvent event) {
        this.mSessionService.dispatchMediaKeyEvent(this.mPackageName, false, event, false);     // Catch: RemoteException -> L4
        return;
    }

    private void runMonitor() throws Exception {
        String id = getNextArgRequired();
        if (id != null) goto L6;
        showError("Error: must include a session id");
        return;
    L6:
        boolean success = false;
        List<MediaController> controllers = sMediaSessionManager.getActiveSessions(null);     // Catch: Exception -> L16
        Iterator<MediaController> r3 = controllers.iterator();     // Catch: Exception -> L16
    L9:
        if (r3.hasNext() == false) goto L24;
        MediaController controller = r3.next();     // Catch: Exception -> L16
        if (controller == null) goto L9;
        if (id.equals(controller.getTag()) == false) goto L9;
        ControllerMonitor monitor = new ControllerMonitor(this, controller);     // Catch: Exception -> L16 RemoteException -> L18
        monitor.run();     // Catch: Exception -> L16 RemoteException -> L18
        goto L9
    L15:
        success = true;
    L24:
        if (success == true) goto L37;
        this.mErrorWriter.println("No session found with id " + id);
        return;
    L37:
        return;
    L16:
        e = move-exception;
        this.mErrorWriter.println("***Error monitoring session*** " + e.getMessage());
        goto L24
    }

    private void runDispatch() throws Exception {
        String cmd = getNextArgRequired();
        if ("play".equals(cmd) == false) goto L6;
        int keycode = 126;
    L35:
        long now = SystemClock.uptimeMillis();
        sendMediaKey(new KeyEvent(now, now, 0, keycode, 0, 0, -1, 0, 0, 257));
        sendMediaKey(new KeyEvent(now, now, 1, keycode, 0, 0, -1, 0, 0, 257));
        return;
    L6:
        if ("pause".equals(cmd) == false) goto L9;
        keycode = 127;
        goto L35
    L9:
        if ("play-pause".equals(cmd) == false) goto L12;
        keycode = 85;
        goto L35
    L12:
        if ("mute".equals(cmd) == false) goto L15;
        keycode = 91;
        goto L35
    L15:
        if ("headsethook".equals(cmd) == false) goto L18;
        keycode = 79;
        goto L35
    L18:
        if (IMediaProjectionManagerServiceExt.NODE_STOP.equals(cmd) == false) goto L21;
        keycode = 86;
        goto L35
    L21:
        if ("next".equals(cmd) == false) goto L24;
        keycode = 87;
        goto L35
    L24:
        if ("previous".equals(cmd) == false) goto L27;
        keycode = 88;
        goto L35
    L27:
        if ("rewind".equals(cmd) == false) goto L30;
        keycode = 89;
        goto L35
    L30:
        if ("record".equals(cmd) == false) goto L33;
        keycode = 130;
        goto L35
    L33:
        if ("fast-forward".equals(cmd) == false) goto L37;
        keycode = 90;
        goto L35
    L37:
        showError("Error: unknown dispatch code '" + cmd + "'");
    }

    void log(String code, String msg) {
        this.mWriter.println(code + " " + msg);
    }

    void showError(String errMsg) {
        onHelp();
        this.mErrorWriter.println(errMsg);
    }

    private void runListSessions() {
        this.mWriter.println("Sessions:");
        List<MediaController> controllers = sMediaSessionManager.getActiveSessions(null);     // Catch: Exception -> L10
        Iterator<MediaController> r1 = controllers.iterator();     // Catch: Exception -> L10
    L5:
        if (r1.hasNext() == false) goto L25;
        MediaController controller = r1.next();     // Catch: Exception -> L10
        if (controller == null) goto L5;
        this.mWriter.println("  tag=" + controller.getTag() + ", package=" + controller.getPackageName());     // Catch: Exception -> L10 RuntimeException -> L12
    L25:
        return;
    L15:
        this.mErrorWriter.println("***Error listing sessions***");
    }

    private void runVolume() throws Exception {
        VolumeCtrl.run(this);
    }

    private void expireTempEngagedSessions() throws Exception {
        this.mSessionService.expireTempEngagedSessions();
    }
}
