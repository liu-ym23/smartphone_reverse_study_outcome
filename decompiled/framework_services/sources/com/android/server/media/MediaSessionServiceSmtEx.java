package com.android.server.media;

import android.app.KeyguardManager;
import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.media.AudioSystem;
import android.media.IAudioService;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.ServiceManager;
import android.os.SystemProperties;
import android.os.UserHandle;
import android.provider.Settings;
import android.telecom.TelecomManager;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes2.dex */
public class MediaSessionServiceSmtEx {
    private static final Uri DESKTOP_URI = null;
    private static final String EXTRA_WAKELOCK_ACQUIRED = "android.media.AudioService.WAKELOCK_ACQUIRED";
    private static final String LAUNCH_VOICE_ACTIVITY = "android.intent.action.launchIatSpeech";
    private static final String METHOD_SHOW_SARA = "METHOD_SHOW_SARA";
    private static final String TAG = "MediaSessionService";
    private static final int VOICEASSISTANT_HEADSET = 3;
    private static final boolean VOICE_ENABLE = false;
    final int LOG_NB_EVENTS_VOLUME;
    private final IAudioService mAudioService;
    private ContentResolver mContentResolver;
    private final Context mContext;
    private KeyguardManager mKeyguardManager;
    private PowerManager.WakeLock mMediaEventWakeLock;
    private MediaSessionService mMediaSessionService;
    private PowerManager mPowerManager;
    private TelecomManager mTelecomManager;
    private final Uri mVoiceAssUri;
    private boolean mVoiceSearchEnabled;
    private final AudioEventLogger mVolumeLogger;

    static final class VolumeEvent extends AudioEventLogger.Event {
        static final int VOL_ADJUST_STREAM_VOL = 1;
        static final int VOL_ADJUST_SUGG_VOL = 0;
        static final int VOL_SET_STREAM_VOL = 2;
        final String mCaller;
        final int mOp;
        final int mStream;
        final int mVal1;
        final int mVal2;

        VolumeEvent(int op, int stream, int val1, int val2, String caller) {
            this.mOp = op;
            this.mStream = stream;
            this.mVal1 = val1;
            this.mVal2 = val2;
            this.mCaller = caller;
        }

        @Override // com.android.server.media.AudioEventLogger.Event
        public String eventToString() {
            switch(this.mOp) {
                case 0: goto L11;
                case 1: goto L9;
                case 2: goto L7;
                default: goto L5;
            };
        L5:
            return "FIXME invalid op:" + this.mOp;
        L7:
            return "setStreamVolume(stream:" + AudioSystem.streamToString(this.mStream) + " index:" + this.mVal1 + " flags:0x" + Integer.toHexString(this.mVal2) + ") from " + this.mCaller;
        L9:
            return "adjustStreamVolume(stream:" + AudioSystem.streamToString(this.mStream) + " dir:" + AudioManager.adjustToString(this.mVal1) + " flags:0x" + Integer.toHexString(this.mVal2) + ") from " + this.mCaller;
        L11:
            return "adjustSuggestedStreamVolume(sugg:" + AudioSystem.streamToString(this.mStream) + " dir:" + AudioManager.adjustToString(this.mVal1) + " flags:0x" + Integer.toHexString(this.mVal2) + ") from " + this.mCaller;
        }
    }

    static {
        boolean r1 = false;
        if (SystemProperties.getInt("ro.voice_assistant_enable", 0) != 1) goto L5;
        r1 = true;
    L5:
        VOICE_ENABLE = r1;
        DESKTOP_URI = Uri.parse("content://com.android.desktop.systemui");
    }

    public MediaSessionServiceSmtEx(MediaSessionService mediaSessionService, Context context) {
        this.mVoiceAssUri = Settings.Global.getUriFor("voice_input");
        this.LOG_NB_EVENTS_VOLUME = 40;
        this.mVolumeLogger = new AudioEventLogger(40, "volume changes (logged when command received by MediaSessionService)");
        this.mContext = context;
        this.mMediaSessionService = mediaSessionService;
        this.mTelecomManager = (TelecomManager) context.getSystemService("telecom");
        this.mPowerManager = (PowerManager) context.getSystemService("power");
        this.mContentResolver = context.getContentResolver();
        this.mKeyguardManager = (KeyguardManager) this.mContext.getSystemService("keyguard");
        this.mAudioService = getAudioService();
        boolean r2 = true;
        newWakeLock(1, "handleMediaEventExt");
        if (VOICE_ENABLE == true) goto L5;
        return;
    L5:
        if (Settings.Global.getInt(this.mContext.getContentResolver(), "voice_input", 1) == 1) goto L8;
        r2 = false;
    L8:
        this.mVoiceSearchEnabled = r2;
    }

    PowerManager.WakeLock newWakeLock(int levelAndFlags, String tag) {
        this.mMediaEventWakeLock = this.mPowerManager.newWakeLock(levelAndFlags, tag);
        return this.mMediaEventWakeLock;
    }

    void onStart() {
        if (VOICE_ENABLE == false) goto L10;
        boolean r2 = true;
        if (Settings.Global.getInt(this.mContext.getContentResolver(), "voice_input", 1) == 1) goto L8;
        r2 = false;
    L8:
        this.mVoiceSearchEnabled = r2;
        return;
    }

    void settingsObserver(ContentObserver contentObserver) {
        this.mContentResolver.registerContentObserver(this.mVoiceAssUri, false, contentObserver, -1);
    }

    boolean settingsOnChange(boolean selfChange, Uri uri) {
        boolean r1 = false;
        if (this.mVoiceAssUri.equals(uri) == true) goto L5;
        return false;
    L5:
        if (Settings.Global.getInt(this.mContentResolver, "voice_input", 1) != 1) goto L7;
        r1 = true;
    L7:
        this.mVoiceSearchEnabled = r1;
        return true;
    }

    boolean checkIfAllowShowVolumePanel() {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            this = this;
            java.lang.String r0 = "MediaSessionService"
            android.telecom.TelecomManager r1 = r4.mTelecomManager
            r2 = 1
            if (r1 != 0) goto L19
            android.content.Context r1 = r4.mContext
            java.lang.String r3 = "telecom"
            java.lang.Object r1 = r1.getSystemService(r3)
            android.telecom.TelecomManager r1 = (android.telecom.TelecomManager) r1
            r4.mTelecomManager = r1
            android.telecom.TelecomManager r1 = r4.mTelecomManager
            if (r1 != 0) goto L19
            return r2
        L19:
            android.os.PowerManager r1 = r4.mPowerManager
            if (r1 != 0) goto L2f
            android.content.Context r1 = r4.mContext
            java.lang.String r3 = "power"
            java.lang.Object r1 = r1.getSystemService(r3)
            android.os.PowerManager r1 = (android.os.PowerManager) r1
            r4.mPowerManager = r1
            android.os.PowerManager r1 = r4.mPowerManager
            if (r1 != 0) goto L2f
            return r2
        L2f:
            android.telecom.TelecomManager r1 = r4.mTelecomManager     // Catch: android.os.RemoteException -> L41 java.lang.SecurityException -> L43
            boolean r1 = r1.isInCall()     // Catch: android.os.RemoteException -> L41 java.lang.SecurityException -> L43
            if (r1 != 0) goto L40
            android.media.IAudioService r1 = r4.mAudioService     // Catch: android.os.RemoteException -> L41 java.lang.SecurityException -> L43
            int r1 = r1.getMode()     // Catch: android.os.RemoteException -> L41 java.lang.SecurityException -> L43
            r3 = 3
            if (r1 != r3) goto L4f
        L40:
            goto L45
        L41:
            r1 = move-exception
            goto L50
        L43:
            r1 = move-exception
            goto L57
        L45:
            android.os.PowerManager r1 = r4.mPowerManager     // Catch: android.os.RemoteException -> L41 java.lang.SecurityException -> L43
            boolean r0 = r1.isScreenOn()     // Catch: android.os.RemoteException -> L41 java.lang.SecurityException -> L43
            if (r0 != 0) goto L4f
            r0 = 0
            return r0
        L4f:
            goto L60
        L50:
            java.lang.String r3 = "error get audio mode."
            android.util.Log.e(r0, r3, r1)
            goto L60
        L57:
            java.lang.String r3 = r1.toString()
            android.util.Log.d(r0, r3)
            goto L4f
        L60:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.server.media.MediaSessionServiceSmtEx.checkIfAllowShowVolumePanel():boolean");
    }

    void startVoiceInput(boolean needWakeLock, MediaSessionService.SessionManagerImpl.KeyEventWakeLockReceiver receiver) {
        PowerManager pm = (PowerManager) this.mContext.getSystemService("power");
        boolean r3 = false;
        if (this.mKeyguardManager != null) goto L5;
    L7:
        boolean isLocked = false;
    L9:
        if (VOICE_ENABLE == true) goto L11;
    L13:
        if (isLocked == false) goto L15;
    L17:
        Intent voiceIntent = new Intent("android.speech.action.VOICE_SEARCH_HANDS_FREE");
        if (isLocked == true) goto L20;
    L23:
        voiceIntent.putExtra("android.speech.extras.EXTRA_SECURE", r3);
        Log.i(TAG, "voice-based interactions: about to use ACTION_VOICE_SEARCH_HANDS_FREE");
        Intent voiceIntent2 = voiceIntent;
    L24:
        voiceIntent2.setFlags(276824064);
    L25:
        if (needWakeLock == false) goto L49;
        aquireWakeLockOnlyLocked();
    L49:
        voiceIntent2.setFlags(276824064);     // Catch: Throwable -> L32 ActivityNotFoundException -> L34
        if (MediaSessionService.DEBUG == false) goto L36;
        Log.d(TAG, "voiceIntent: " + voiceIntent2);     // Catch: Throwable -> L32 ActivityNotFoundException -> L34
    L36:
        this.mContext.startActivityAsUser(voiceIntent2, UserHandle.CURRENT);     // Catch: Throwable -> L32 ActivityNotFoundException -> L34
        if (MediaSessionService.DEBUG == false) goto L39;
        Log.d(TAG, "voiceIntent: " + voiceIntent2);     // Catch: Throwable -> L32 ActivityNotFoundException -> L34
    L39:
        if (needWakeLock == false) goto L45;
    L40:
        releaseWakeLockOnlyLocked();
        return;
    L45:
        return;
    L34:
        e = move-exception;
        Log.w(TAG, "No activity for search: " + e);     // Catch: Throwable -> L32
        if (needWakeLock == true) goto L40;
        return;
    L32:
        th = move-exception;
        if (needWakeLock == false) goto L48;
        releaseWakeLockOnlyLocked();
    L48:
        throw th;
    L20:
        if (this.mKeyguardManager.isKeyguardSecure() == false) goto L23;
        r3 = true;
        goto L23
    L15:
        if (pm.isScreenOn() == false) goto L17;
        voiceIntent2 = new Intent("android.speech.action.WEB_SEARCH");
        Log.i(TAG, "voice-based interactions: about to use ACTION_WEB_SEARCH");
        goto L24
    L11:
        if (this.mVoiceSearchEnabled == false) goto L13;
        voiceIntent2 = new Intent(LAUNCH_VOICE_ACTIVITY);
        voiceIntent2.putExtra("VoiceType", 3);
        voiceIntent2.putExtra("ScreenOff", needWakeLock);
        voiceIntent2.setFlags(276824064);
        goto L25
    L5:
        if (this.mKeyguardManager.isKeyguardLocked() == false) goto L7;
        isLocked = true;
        goto L9
    }

    void handleKeyEventDone(Bundle extras) {
        if (extras.containsKey(EXTRA_WAKELOCK_ACQUIRED) == false) goto L6;
        releaseWakeLockIfHeld();
        return;
    }

    public synchronized void releaseWakeLockIfHeld() {
        monitor-enter(this);
    L7:
        th = move-exception;
        throw th;
    L4:
        if (this.mMediaEventWakeLock.isHeld() == false) goto L9;
        this.mMediaEventWakeLock.release();     // Catch: Throwable -> L7
    L9:
        monitor-exit(this);
    }

    public synchronized void aquireWakeLockOnlyLocked() {
        monitor-enter(this);
        this.mMediaEventWakeLock.acquire();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void releaseWakeLockOnlyLocked() {
        monitor-enter(this);
        this.mMediaEventWakeLock.release();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
        pw.println("\n");
        this.mVolumeLogger.dump(pw);
    }

    private IAudioService getAudioService() {
        IBinder b = ServiceManager.getService("audio");
        return IAudioService.Stub.asInterface(b);
    }
}
