package com.android.server.am;

import android.R;
import android.app.ActivityManager;
import android.app.ActivityManagerInternal;
import android.app.ActivityOptions;
import android.app.ActivityTaskManager;
import android.app.AppGlobals;
import android.app.BroadcastOptions;
import android.app.IActivityController;
import android.app.IActivityManager;
import android.app.IActivityTaskManager;
import android.app.IProcessObserver;
import android.app.IStopUserCallback;
import android.app.KeyguardManager;
import android.app.ProfilerInfo;
import android.app.UidObserver;
import android.app.UserSwitchObserver;
import android.app.WaitResult;
import android.app.usage.AppStandbyInfo;
import android.app.usage.ConfigurationStats;
import android.app.usage.IUsageStatsManager;
import android.compat.Compatibility;
import android.content.ComponentName;
import android.content.IIntentReceiver;
import android.content.Intent;
import android.content.pm.ConfigurationInfo;
import android.content.pm.FeatureInfo;
import android.content.pm.IPackageManager;
import android.content.pm.PackageManager;
import android.content.pm.ParceledListSlice;
import android.content.pm.ResolveInfo;
import android.content.pm.SharedLibraryInfo;
import android.content.pm.UserInfo;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.hardware.display.DisplayManager;
import android.hardware.tv.mediaquality.ParameterName;
import android.opengl.GLES10;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Debug;
import android.os.IProgressListener;
import android.os.ParcelFileDescriptor;
import android.os.RemoteCallback;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.ShellCommand;
import android.os.StrictMode;
import android.os.SystemClock;
import android.os.Trace;
import android.os.UserHandle;
import android.os.UserManager;
import android.os.ZygoteProcess;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.DebugUtils;
import android.util.DisplayMetrics;
import android.util.Slog;
import android.util.SparseArray;
import android.util.TeeWriter;
import android.util.proto.ProtoOutputStream;
import android.view.Choreographer;
import android.view.Display;
import com.android.internal.compat.CompatibilityChangeConfig;
import com.android.internal.util.MemInfoReader;
import com.android.server.LocalServices;
import com.android.server.am.nano.Capabilities;
import com.android.server.am.nano.Capability;
import com.android.server.am.nano.FrameworkCapability;
import com.android.server.am.nano.VMCapability;
import com.android.server.am.nano.VMInfo;
import com.android.server.companion.association.DisassociationProcessor;
import com.android.server.compat.PlatformCompat;
import com.android.server.media.projection.IMediaProjectionManagerServiceExt;
import com.android.server.pm.PackageManagerService;
import com.android.server.pm.UserManagerInternal;
import com.android.server.resmng.IResMngConfig;
import com.android.server.timezonedetector.ServiceConfigAccessor;
import com.android.server.utils.AnrTimer;
import com.android.server.utils.PriorityDump;
import com.android.server.utils.Slogf;
import dalvik.annotation.optimization.NeverCompile;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.URISyntaxException;
import java.time.Clock;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

/* JADX INFO: loaded from: classes.dex */
final class ActivityManagerShellCommand extends ShellCommand {
    private static final String[] CAPABILITIES = null;
    private static final DateTimeFormatter LOG_NAME_TIME_FORMATTER = null;
    public static final String NO_CLASS_ERROR_CODE = "Error type 3";
    private static final String PROFILER_OUTPUT_VERSION_FLAG = "--profiler-output-version";
    private static final String SHELL_PACKAGE_NAME = "com.android.shell";
    static final String TAG = "ActivityManager";
    private static final int USER_OPERATION_TIMEOUT_MS = 120000;
    private int mActivityType;
    private String mAgent;
    private boolean mAsync;
    private boolean mAttachAgentDuringBind;
    private boolean mAutoStop;
    private BroadcastOptions mBroadcastOptions;
    private int mClockType;
    private boolean mDismissKeyguardIfInsecure;
    private int mDisplayId;
    final boolean mDumping;
    final IActivityManager mInterface;
    final ActivityManagerService mInternal;
    private boolean mIsLockTask;
    private boolean mIsTaskOverlay;
    final IPackageManager mPm;
    private String mProfileFile;
    private int mProfilerOutputVersion;
    private String mReceiverPermission;
    private int mRepeat;
    private int mSamplingInterval;
    private boolean mShowSplashScreen;
    private int mStartFlags;
    private boolean mStopOption;
    private boolean mStreaming;
    private int mTaskDisplayAreaFeatureId;
    private int mTaskId;
    final IActivityTaskManager mTaskInterface;
    private int mUserId;
    private boolean mWaitOption;
    private int mWindowingMode;

    static final class IntentReceiver extends IIntentReceiver.Stub {
        private boolean mFinished;
        private final PrintWriter mPw;

        IntentReceiver(PrintWriter pw) {
            this.mFinished = false;
            this.mPw = pw;
        }

        public void performReceive(Intent intent, int resultCode, String data, Bundle extras, boolean ordered, boolean sticky, int sendingUser) {
            String line = "Broadcast completed: result=" + resultCode;
            if (data == null) goto L5;
            line = line + ", data=\"" + data + "\"";
        L5:
            if (extras == null) goto L7;
            line = line + ", extras: " + extras;
        L7:
            this.mPw.println(line);
            this.mPw.flush();
            monitor-enter(this);
            this.mFinished = true;     // Catch: Throwable -> L13
            notifyAll();     // Catch: Throwable -> L13
            monitor-exit(this);     // Catch: Throwable -> L13
            return;
        L13:
            th = move-exception;
            throw th;
        }

        public synchronized void waitForFinish() {
            monitor-enter(this);
        L19:
        L7:
            th = move-exception;
            throw th;
        L9:
            e = move-exception;
            throw new IllegalStateException(e);     // Catch: Throwable -> L7
        L4:
            if (this.mFinished == true) goto L12;
            wait();     // Catch: Throwable -> L7 InterruptedException -> L9
        L12:
            monitor-exit(this);
        }
    }

    static final class MyActivityController extends IActivityController.Stub {
        static final int RESULT_ANR_DIALOG = 0;
        static final int RESULT_ANR_KILL = 1;
        static final int RESULT_ANR_WAIT = 2;
        static final int RESULT_CRASH_DIALOG = 0;
        static final int RESULT_CRASH_KILL = 1;
        static final int RESULT_DEFAULT = 0;
        static final int RESULT_EARLY_ANR_CONTINUE = 0;
        static final int RESULT_EARLY_ANR_KILL = 1;
        static final int STATE_ANR = 3;
        static final int STATE_CRASHED = 1;
        static final int STATE_EARLY_ANR = 2;
        static final int STATE_NORMAL = 0;
        final boolean mAlwaysContinue;
        final boolean mAlwaysKill;
        final String mGdbPort;
        Process mGdbProcess;
        Thread mGdbThread;
        boolean mGotGdbPrint;
        final InputStream mInput;
        final IActivityManager mInterface;
        final boolean mMonkey;
        final PrintWriter mPw;
        int mResult;
        final boolean mSimpleMode;
        int mState;
        final String mTarget;

        MyActivityController(IActivityManager iam, PrintWriter pw, InputStream input, String gdbPort, boolean monkey, boolean simpleMode, String target, boolean alwaysContinue, boolean alwaysKill) {
            this.mInterface = iam;
            this.mPw = pw;
            this.mInput = input;
            this.mGdbPort = gdbPort;
            this.mMonkey = monkey;
            this.mSimpleMode = simpleMode;
            this.mTarget = target;
            this.mAlwaysContinue = alwaysContinue;
            this.mAlwaysKill = alwaysKill;
        }

        private boolean shouldHandlePackageOrProcess(String packageOrProcess) {
            if (this.mTarget != null) goto L7;
            return true;
        L7:
            return this.mTarget.equals(packageOrProcess);
        }

        public boolean activityResuming(String pkg) {
            if (shouldHandlePackageOrProcess(pkg) == true) goto L5;
            return true;
        L5:
            monitor-enter(this);
            this.mPw.println("** Activity resuming: " + pkg);     // Catch: Throwable -> L9
            this.mPw.flush();     // Catch: Throwable -> L9
            monitor-exit(this);     // Catch: Throwable -> L9
            return true;
        L9:
            th = move-exception;
            throw th;
        }

        public boolean activityStarting(Intent intent, String pkg) {
            if (shouldHandlePackageOrProcess(pkg) == true) goto L5;
            return true;
        L5:
            monitor-enter(this);
            this.mPw.println("** Activity starting: " + pkg);     // Catch: Throwable -> L9
            this.mPw.flush();     // Catch: Throwable -> L9
            monitor-exit(this);     // Catch: Throwable -> L9
            return true;
        L9:
            th = move-exception;
            throw th;
        }

        public boolean appCrashed(String processName, int pid, String shortMsg, String longMsg, long timeMillis, String stackTrace) {
            boolean r1 = true;
            if (shouldHandlePackageOrProcess(processName) == true) goto L5;
            return true;
        L5:
            monitor-enter(this);
        L9:
            th = move-exception;
            throw th;
        L7:
            if (this.mSimpleMode == false) goto L11;
            this.mPw.println("** PROCESS CRASHED: " + processName);     // Catch: Throwable -> L9
        L12:
            this.mPw.flush();     // Catch: Throwable -> L9
            if (this.mAlwaysContinue == false) goto L17;
            monitor-exit(this);     // Catch: Throwable -> L9
            return true;
        L17:
            if (this.mAlwaysKill == false) goto L20;
            monitor-exit(this);     // Catch: Throwable -> L9
            return false;
        L20:
            int result = waitControllerLocked(pid, 1);     // Catch: Throwable -> L9
            if (result != 1) goto L23;
            r1 = false;
        L23:
            monitor-exit(this);     // Catch: Throwable -> L9
            return r1;
        L11:
            this.mPw.println("** ERROR: PROCESS CRASHED");     // Catch: Throwable -> L9
            this.mPw.println("processName: " + processName);     // Catch: Throwable -> L9
            this.mPw.println("processPid: " + pid);     // Catch: Throwable -> L9
            this.mPw.println("shortMsg: " + shortMsg);     // Catch: Throwable -> L9
            this.mPw.println("longMsg: " + longMsg);     // Catch: Throwable -> L9
            this.mPw.println("timeMillis: " + timeMillis);     // Catch: Throwable -> L9
            this.mPw.println("uptime: " + SystemClock.uptimeMillis());     // Catch: Throwable -> L9
            this.mPw.println("stack:");     // Catch: Throwable -> L9
            this.mPw.print(stackTrace);     // Catch: Throwable -> L9
            this.mPw.println("#");     // Catch: Throwable -> L9
            goto L12
        }

        public int appEarlyNotResponding(String processName, int pid, String annotation) {
            if (shouldHandlePackageOrProcess(processName) == true) goto L5;
            return 0;
        L5:
            monitor-enter(this);
        L9:
            th = move-exception;
            throw th;
        L7:
            if (this.mSimpleMode == false) goto L11;
            this.mPw.println("** EARLY PROCESS NOT RESPONDING: " + processName);     // Catch: Throwable -> L9
        L12:
            this.mPw.flush();     // Catch: Throwable -> L9
            if (this.mAlwaysContinue == false) goto L17;
            monitor-exit(this);     // Catch: Throwable -> L9
            return 0;
        L17:
            if (this.mAlwaysKill == false) goto L20;
            monitor-exit(this);     // Catch: Throwable -> L9
            return -1;
        L20:
            int result = waitControllerLocked(pid, 2);     // Catch: Throwable -> L9
            if (result != 1) goto L24;
            monitor-exit(this);     // Catch: Throwable -> L9
            return -1;
        L24:
            monitor-exit(this);     // Catch: Throwable -> L9
            return 0;
        L11:
            this.mPw.println("** ERROR: EARLY PROCESS NOT RESPONDING");     // Catch: Throwable -> L9
            this.mPw.println("processName: " + processName);     // Catch: Throwable -> L9
            this.mPw.println("processPid: " + pid);     // Catch: Throwable -> L9
            this.mPw.println("annotation: " + annotation);     // Catch: Throwable -> L9
            this.mPw.println("uptime: " + SystemClock.uptimeMillis());     // Catch: Throwable -> L9
            goto L12
        }

        public int appNotResponding(String processName, int pid, String processStats) {
            if (shouldHandlePackageOrProcess(processName) == true) goto L5;
            return 0;
        L5:
            monitor-enter(this);
        L9:
            th = move-exception;
            throw th;
        L7:
            if (this.mSimpleMode == false) goto L11;
            this.mPw.println("** PROCESS NOT RESPONDING: " + processName);     // Catch: Throwable -> L9
        L12:
            this.mPw.flush();     // Catch: Throwable -> L9
            if (this.mAlwaysContinue == false) goto L17;
            monitor-exit(this);     // Catch: Throwable -> L9
            return 0;
        L17:
            if (this.mAlwaysKill == false) goto L20;
            monitor-exit(this);     // Catch: Throwable -> L9
            return -1;
        L20:
            int result = waitControllerLocked(pid, 3);     // Catch: Throwable -> L9
            if (result != 1) goto L25;
            monitor-exit(this);     // Catch: Throwable -> L9
            return -1;
        L25:
            if (result != 2) goto L28;
            monitor-exit(this);     // Catch: Throwable -> L9
            return 1;
        L28:
            monitor-exit(this);     // Catch: Throwable -> L9
            return 0;
        L11:
            this.mPw.println("** ERROR: PROCESS NOT RESPONDING");     // Catch: Throwable -> L9
            this.mPw.println("processName: " + processName);     // Catch: Throwable -> L9
            this.mPw.println("processPid: " + pid);     // Catch: Throwable -> L9
            this.mPw.println("uptime: " + SystemClock.uptimeMillis());     // Catch: Throwable -> L9
            this.mPw.println("processStats:");     // Catch: Throwable -> L9
            this.mPw.print(processStats);     // Catch: Throwable -> L9
            this.mPw.println("#");     // Catch: Throwable -> L9
            goto L12
        }

        public int systemNotResponding(String message) {
            if (this.mTarget == null) goto L5;
            return -1;
        L5:
            monitor-enter(this);
            this.mPw.println("** ERROR: PROCESS NOT RESPONDING");     // Catch: Throwable -> L9
            if (this.mSimpleMode == true) goto L11;
            this.mPw.println("message: " + message);     // Catch: Throwable -> L9
            this.mPw.println("#");     // Catch: Throwable -> L9
            this.mPw.println("Allowing system to die.");     // Catch: Throwable -> L9
        L11:
            this.mPw.flush();     // Catch: Throwable -> L9
            monitor-exit(this);     // Catch: Throwable -> L9
            return -1;
        L9:
            th = move-exception;
            throw th;
        }

        void killGdbLocked() {
            this.mGotGdbPrint = false;
            if (this.mGdbProcess == null) goto L6;
            this.mPw.println("Stopping gdbserver");
            this.mPw.flush();
            this.mGdbProcess.destroy();
            this.mGdbProcess = null;
        L6:
            if (this.mGdbThread == null) goto L9;
            this.mGdbThread.interrupt();
            this.mGdbThread = null;
            return;
        }

        int waitControllerLocked(int pid, int state) {
            if (this.mGdbPort == null) goto L14;
            killGdbLocked();
            this.mPw.println("Starting gdbserver on port " + this.mGdbPort);     // Catch: IOException -> L9
            this.mPw.println("Do the following:");     // Catch: IOException -> L9
            this.mPw.println("  adb forward tcp:" + this.mGdbPort + " tcp:" + this.mGdbPort);     // Catch: IOException -> L9
            PrintWriter r0 = this.mPw;     // Catch: IOException -> L9
            StringBuilder r1 = new StringBuilder();     // Catch: IOException -> L9
            r1.append("  gdbclient app_process :");     // Catch: IOException -> L9
            r1.append(this.mGdbPort);     // Catch: IOException -> L9
            r0.println(r1.toString());     // Catch: IOException -> L9
            this.mPw.flush();     // Catch: IOException -> L9
            this.mGdbProcess = Runtime.getRuntime().exec(new String[]{"gdbserver", ":" + this.mGdbPort, "--attach", Integer.toString(pid)});     // Catch: IOException -> L9
            final InputStreamReader converter = new InputStreamReader(this.mGdbProcess.getInputStream());     // Catch: IOException -> L9
            this.mGdbThread = new AnonymousClass1(this, converter);     // Catch: IOException -> L9
            this.mGdbThread.start();     // Catch: IOException -> L9
            wait(500);     // Catch: IOException -> L9 InterruptedException -> L11
        L9:
            e = move-exception;
            this.mPw.println("Failure starting gdbserver: " + e);
            this.mPw.flush();
            killGdbLocked();
        L14:
            this.mState = state;
            this.mPw.println("");
            printMessageForState();
            this.mPw.flush();
        L16:
            if (this.mState == 0) goto L21;
            wait();     // Catch: InterruptedException -> L19
            goto L16
        L21:
            killGdbLocked();
            return this.mResult;
        }

        void resumeController(int result) {
            monitor-enter(this);
            this.mState = 0;     // Catch: Throwable -> L7
            this.mResult = result;     // Catch: Throwable -> L7
            notifyAll();     // Catch: Throwable -> L7
            monitor-exit(this);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        void printMessageForState() {
            if (this.mAlwaysContinue == true) goto L7;
            if (this.mAlwaysKill == true) goto L7;
        L10:
            switch(this.mState) {
                case 0: goto L15;
                case 1: goto L14;
                case 2: goto L13;
                case 3: goto L12;
                default: goto L16;
            };
        L12:
            this.mPw.println("Waiting after ANR...  available commands:");
            this.mPw.println("(c)ontinue: show ANR dialog");
            this.mPw.println("(k)ill: immediately kill app");
            this.mPw.println("(w)ait: wait some more");
            goto L16
        L13:
            this.mPw.println("Waiting after early ANR...  available commands:");
            this.mPw.println("(c)ontinue: standard ANR processing");
            this.mPw.println("(k)ill: immediately kill app");
            goto L16
        L14:
            this.mPw.println("Waiting after crash...  available commands:");
            this.mPw.println("(c)ontinue: show crash dialog");
            this.mPw.println("(k)ill: immediately kill app");
            goto L16
        L15:
            this.mPw.println("Monitoring activity manager...  available commands:");
        L16:
            this.mPw.println("(q)uit: finish monitoring");
            return;
        L7:
            if (this.mSimpleMode == false) goto L10;
        }

        void run() throws RemoteException {
            printMessageForState();     // Catch: Throwable -> L27 IOException -> L29
            this.mPw.flush();     // Catch: Throwable -> L27 IOException -> L29
            this.mInterface.setActivityController(this, this.mMonkey);     // Catch: Throwable -> L27 IOException -> L29
            this.mState = 0;     // Catch: Throwable -> L27 IOException -> L29
            InputStreamReader converter = new InputStreamReader(this.mInput);     // Catch: Throwable -> L27 IOException -> L29
            BufferedReader in = new BufferedReader(converter);     // Catch: Throwable -> L27 IOException -> L29
        L4:
            String line = in.readLine();     // Catch: Throwable -> L27 IOException -> L29
            if (line == null) goto L81;
            boolean addNewline = true;
            if (line.length() > 0) goto L10;
            addNewline = false;
        L70:
            monitor-enter(this);     // Catch: Throwable -> L27 IOException -> L29
            if (addNewline == true) goto L90;
        L75:
            printMessageForState();     // Catch: Throwable -> L73
            this.mPw.flush();     // Catch: Throwable -> L73
            monitor-exit(this);     // Catch: Throwable -> L73
            goto L4
        L90:
            this.mPw.println("");     // Catch: Throwable -> L73
        L73:
            th = move-exception;
            throw th;     // Catch: Throwable -> L27 IOException -> L29
        L10:
            if ("q".equals(line) == true) goto L80;
            if ("quit".equals(line) == true) goto L80;
            if (this.mState != 1) goto L34;
            if ("c".equals(line) == true) goto L32;
            if ("continue".equals(line) == true) goto L32;
            if ("k".equals(line) == true) goto L31;
            if ("kill".equals(line) == true) goto L31;
            this.mPw.println("Invalid command: " + line);     // Catch: Throwable -> L27 IOException -> L29
        L31:
            resumeController(1);     // Catch: Throwable -> L27 IOException -> L29
        L32:
            resumeController(0);     // Catch: Throwable -> L27 IOException -> L29
            goto L70
        L34:
            if (this.mState != 3) goto L55;
            if ("c".equals(line) == true) goto L53;
            if ("continue".equals(line) == true) goto L53;
            if ("k".equals(line) == true) goto L52;
            if ("kill".equals(line) == true) goto L52;
            if ("w".equals(line) == true) goto L51;
            if ("wait".equals(line) == true) goto L51;
            this.mPw.println("Invalid command: " + line);     // Catch: Throwable -> L27 IOException -> L29
        L51:
            resumeController(2);     // Catch: Throwable -> L27 IOException -> L29
        L52:
            resumeController(1);     // Catch: Throwable -> L27 IOException -> L29
        L53:
            resumeController(0);     // Catch: Throwable -> L27 IOException -> L29
            goto L70
        L55:
            if (this.mState == 2) goto L57;
            this.mPw.println("Invalid command: " + line);     // Catch: Throwable -> L27 IOException -> L29
            goto L70
        L57:
            if ("c".equals(line) == true) goto L68;
            if ("continue".equals(line) == true) goto L68;
            if ("k".equals(line) == true) goto L67;
            if ("kill".equals(line) == true) goto L67;
            this.mPw.println("Invalid command: " + line);     // Catch: Throwable -> L27 IOException -> L29
        L67:
            resumeController(1);     // Catch: Throwable -> L27 IOException -> L29
        L68:
            resumeController(0);     // Catch: Throwable -> L27 IOException -> L29
        L80:
            resumeController(0);     // Catch: Throwable -> L27 IOException -> L29
        L81:
            this.mInterface.setActivityController(null, this.mMonkey);
            return;
        L29:
            e = move-exception;
            e.printStackTrace(this.mPw);     // Catch: Throwable -> L27
            this.mPw.flush();     // Catch: Throwable -> L27
        L27:
            th = move-exception;
            this.mInterface.setActivityController(null, this.mMonkey);
            throw th;
        }
    }

    static final class MyUidObserver extends UidObserver implements ActivityManagerService.OomAdjObserver {
        static final int STATE_NORMAL = 0;
        final InputStream mInput;
        final IActivityManager mInterface;
        final ActivityManagerService mInternal;
        final int mMask;
        final PrintWriter mPw;
        int mState;
        final int mUid;

        MyUidObserver(ActivityManagerService service, PrintWriter pw, InputStream input, int uid, int mask) {
            this.mInterface = service;
            this.mInternal = service;
            this.mPw = pw;
            this.mInput = input;
            this.mUid = uid;
            this.mMask = mask;
        }

        public void onUidStateChanged(int uid, int procState, long procStateSeq, int capability) {
            monitor-enter(this);
            StrictMode.ThreadPolicy oldPolicy = StrictMode.allowThreadDiskWrites();     // Catch: Throwable -> L8
            this.mPw.print(uid);     // Catch: Throwable -> L10
            this.mPw.print(" procstate ");     // Catch: Throwable -> L10
            this.mPw.print(ProcessList.makeProcStateString(procState));     // Catch: Throwable -> L10
            this.mPw.print(" seq ");     // Catch: Throwable -> L10
            this.mPw.print(procStateSeq);     // Catch: Throwable -> L10
            this.mPw.print(" capability ");     // Catch: Throwable -> L10
            this.mPw.println(this.mMask & capability);     // Catch: Throwable -> L10
            this.mPw.flush();     // Catch: Throwable -> L10
            StrictMode.setThreadPolicy(oldPolicy);     // Catch: Throwable -> L8
            monitor-exit(this);     // Catch: Throwable -> L8
            return;
        L10:
            th = move-exception;
            StrictMode.setThreadPolicy(oldPolicy);     // Catch: Throwable -> L8
            throw th;     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            throw th;
        }

        public void onUidGone(int uid, boolean disabled) {
            monitor-enter(this);
            StrictMode.ThreadPolicy oldPolicy = StrictMode.allowThreadDiskWrites();     // Catch: Throwable -> L13
            this.mPw.print(uid);     // Catch: Throwable -> L7
            this.mPw.print(" gone");     // Catch: Throwable -> L7
            if (disabled == false) goto L9;
            this.mPw.print(" disabled");     // Catch: Throwable -> L7
        L9:
            this.mPw.println();     // Catch: Throwable -> L7
            this.mPw.flush();     // Catch: Throwable -> L7
            StrictMode.setThreadPolicy(oldPolicy);     // Catch: Throwable -> L13
            monitor-exit(this);     // Catch: Throwable -> L13
            return;
        L7:
            th = move-exception;
            StrictMode.setThreadPolicy(oldPolicy);     // Catch: Throwable -> L13
            throw th;     // Catch: Throwable -> L13
        L13:
            th = move-exception;
            throw th;
        }

        public void onUidActive(int uid) {
            monitor-enter(this);
            StrictMode.ThreadPolicy oldPolicy = StrictMode.allowThreadDiskWrites();     // Catch: Throwable -> L8
            this.mPw.print(uid);     // Catch: Throwable -> L10
            this.mPw.println(" active");     // Catch: Throwable -> L10
            this.mPw.flush();     // Catch: Throwable -> L10
            StrictMode.setThreadPolicy(oldPolicy);     // Catch: Throwable -> L8
            monitor-exit(this);     // Catch: Throwable -> L8
            return;
        L10:
            th = move-exception;
            StrictMode.setThreadPolicy(oldPolicy);     // Catch: Throwable -> L8
            throw th;     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            throw th;
        }

        public void onUidIdle(int uid, boolean disabled) {
            monitor-enter(this);
            StrictMode.ThreadPolicy oldPolicy = StrictMode.allowThreadDiskWrites();     // Catch: Throwable -> L13
            this.mPw.print(uid);     // Catch: Throwable -> L7
            this.mPw.print(" idle");     // Catch: Throwable -> L7
            if (disabled == false) goto L9;
            this.mPw.print(" disabled");     // Catch: Throwable -> L7
        L9:
            this.mPw.println();     // Catch: Throwable -> L7
            this.mPw.flush();     // Catch: Throwable -> L7
            StrictMode.setThreadPolicy(oldPolicy);     // Catch: Throwable -> L13
            monitor-exit(this);     // Catch: Throwable -> L13
            return;
        L7:
            th = move-exception;
            StrictMode.setThreadPolicy(oldPolicy);     // Catch: Throwable -> L13
            throw th;     // Catch: Throwable -> L13
        L13:
            th = move-exception;
            throw th;
        }

        public void onUidCachedChanged(int uid, boolean cached) {
            monitor-enter(this);
            StrictMode.ThreadPolicy oldPolicy = StrictMode.allowThreadDiskWrites();     // Catch: Throwable -> L14
            this.mPw.print(uid);     // Catch: Throwable -> L7
            PrintWriter r1 = this.mPw;     // Catch: Throwable -> L7
            if (cached == false) goto L9;
            String r2 = " cached";
        L10:
            r1.println(r2);     // Catch: Throwable -> L7
            this.mPw.flush();     // Catch: Throwable -> L7
            StrictMode.setThreadPolicy(oldPolicy);     // Catch: Throwable -> L14
            monitor-exit(this);     // Catch: Throwable -> L14
            return;
        L9:
            r2 = " uncached";
        L7:
            th = move-exception;
            StrictMode.setThreadPolicy(oldPolicy);     // Catch: Throwable -> L14
            throw th;     // Catch: Throwable -> L14
        L14:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.am.ActivityManagerService.OomAdjObserver
        public void onOomAdjMessage(String msg) {
            monitor-enter(this);
            StrictMode.ThreadPolicy oldPolicy = StrictMode.allowThreadDiskWrites();     // Catch: Throwable -> L8
            this.mPw.print("# ");     // Catch: Throwable -> L10
            this.mPw.println(msg);     // Catch: Throwable -> L10
            this.mPw.flush();     // Catch: Throwable -> L10
            StrictMode.setThreadPolicy(oldPolicy);     // Catch: Throwable -> L8
            monitor-exit(this);     // Catch: Throwable -> L8
            return;
        L10:
            th = move-exception;
            StrictMode.setThreadPolicy(oldPolicy);     // Catch: Throwable -> L8
            throw th;     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            throw th;
        }

        void printMessageForState() {
            switch(this.mState) {
                case 0: goto L5;
                default: goto L6;
            };
        L5:
            this.mPw.println("Watching uid states...  available commands:");
        L6:
            this.mPw.println("(q)uit: finish watching");
        }

        void run() throws RemoteException {
            printMessageForState();     // Catch: Throwable -> L5 IOException -> L7
            this.mPw.flush();     // Catch: Throwable -> L5 IOException -> L7
            this.mInterface.registerUidObserver(this, 31, -1, null);     // Catch: Throwable -> L5 IOException -> L7
            if (this.mUid < 0) goto L9;
            this.mInternal.setOomAdjObserver(this.mUid, this);     // Catch: Throwable -> L5 IOException -> L7
        L9:
            this.mState = 0;     // Catch: Throwable -> L5 IOException -> L7
            InputStreamReader converter = new InputStreamReader(this.mInput);     // Catch: Throwable -> L5 IOException -> L7
            BufferedReader in = new BufferedReader(converter);     // Catch: Throwable -> L5 IOException -> L7
        L10:
            String line = in.readLine();     // Catch: Throwable -> L5 IOException -> L7
            if (line == null) goto L32;
            boolean addNewline = true;
            if (line.length() > 0) goto L16;
            addNewline = false;
        L21:
            monitor-enter(this);     // Catch: Throwable -> L5 IOException -> L7
            if (addNewline == true) goto L46;
        L26:
            printMessageForState();     // Catch: Throwable -> L24
            this.mPw.flush();     // Catch: Throwable -> L24
            monitor-exit(this);     // Catch: Throwable -> L24
            goto L10
        L46:
            this.mPw.println("");     // Catch: Throwable -> L24
        L24:
            th = move-exception;
            throw th;     // Catch: Throwable -> L5 IOException -> L7
        L16:
            if ("q".equals(line) == true) goto L32;
            if ("quit".equals(line) == true) goto L32;
            this.mPw.println("Invalid command: " + line);     // Catch: Throwable -> L5 IOException -> L7
        L32:
            if (this.mUid < 0) goto L34;
        L33:
            this.mInternal.clearOomAdjObserver();
        L34:
            this.mInterface.unregisterUidObserver(this);
            return;
        L7:
            e = move-exception;
            e.printStackTrace(this.mPw);     // Catch: Throwable -> L5
            this.mPw.flush();     // Catch: Throwable -> L5
            if (this.mUid < 0) goto L34;
        L5:
            th = move-exception;
            if (this.mUid < 0) goto L44;
            this.mInternal.clearOomAdjObserver();
        L44:
            this.mInterface.unregisterUidObserver(this);
            throw th;
        }
    }

    static final class ProcessObserver extends IProcessObserver.Stub {
        private IActivityManager mIam;
        private PrintWriter mPw;

        ProcessObserver(PrintWriter mPw, IActivityManager mIam) {
            this.mPw = mPw;
            this.mIam = mIam;
        }

        public void onForegroundActivitiesChanged(int pid, int uid, boolean foregroundActivities) {
            if (foregroundActivities == false) goto L15;
            int prcState = this.mIam.getUidProcessState(uid, PackageManagerService.PLATFORM_PACKAGE_NAME);     // Catch: RemoteException -> L6
            if (prcState != 2) goto L8;
            this.mPw.println("New foreground process: " + pid);     // Catch: RemoteException -> L6
        L9:
            this.mPw.flush();     // Catch: RemoteException -> L6
            return;
        L8:
            this.mPw.println("No top app found");     // Catch: RemoteException -> L6
        L11:
            this.mPw.println("Error occurred in binder call");
            this.mPw.flush();
            return;
        }

        public void onProcessStarted(int pid, int processUid, int packageUid, String packageName, String processName) {
        }

        public void onForegroundServicesChanged(int pid, int uid, int serviceTypes) {
        }

        public void onProcessDied(int pid, int uid) {
        }
    }

    private class ProgressWaiter extends IProgressListener.Stub {
        private final CountDownLatch mFinishedLatch;
        private final int mUserId;

        /* synthetic */ ProgressWaiter(ActivityManagerShellCommand r1, int r2, ActivityManagerShellCommandIA r3) {
            this(r1, r2);
        }

        private ProgressWaiter(ActivityManagerShellCommand r2, int userId) {
            this.mFinishedLatch = new CountDownLatch(1);
            this.mUserId = userId;
        }

        public void onStarted(int id, Bundle extras) {
        }

        public void onProgress(int id, int progress, Bundle extras) {
            Slogf.d(ActivityManagerShellCommand.TAG, "ProgressWaiter[user=%d]: onProgress(%d, %d)", new Object[]{Integer.valueOf(this.mUserId), Integer.valueOf(id), Integer.valueOf(progress)});
        }

        public void onFinished(int id, Bundle extras) {
            Slogf.d(ActivityManagerShellCommand.TAG, "ProgressWaiter[user=%d]: onFinished(%d)", new Object[]{Integer.valueOf(this.mUserId), Integer.valueOf(id)});
            this.mFinishedLatch.countDown();
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder();
            r0.append("ProgressWaiter[userId=");
            r0.append(this.mUserId);
            r0.append(", finished=");
            if (this.mFinishedLatch.getCount() != 0) goto L5;
            boolean r1 = true;
        L6:
            r0.append(r1);
            r0.append("]");
            return r0.toString();
        L5:
            r1 = false;
            goto L6
        }

        public boolean waitForFinish(long timeoutMillis) {
            return this.mFinishedLatch.await(timeoutMillis, TimeUnit.MILLISECONDS);
        L5:
            System.err.println("Thread interrupted unexpectedly.");
            return false;
        }
    }

    static final class StopUserCallback extends IStopUserCallback.Stub {
        private boolean mFinished;
        private final int mUserId;

        /* synthetic */ StopUserCallback(int r1, ActivityManagerShellCommandIA r2) {
            this(r1);
        }

        private StopUserCallback(int userId) {
            this.mFinished = false;
            this.mUserId = userId;
        }

        public synchronized void waitForFinish() {
            monitor-enter(this);
        L20:
        L7:
            th = move-exception;
            throw th;
        L9:
            e = move-exception;
            throw new IllegalStateException(e);     // Catch: Throwable -> L7
        L4:
            if (this.mFinished == true) goto L12;
            wait();     // Catch: Throwable -> L7 InterruptedException -> L9
        L12:
            Slogf.d(ActivityManagerShellCommand.TAG, "user %d finished stopping", new Object[]{Integer.valueOf(this.mUserId)});     // Catch: Throwable -> L7
            monitor-exit(this);
        }

        public synchronized void userStopped(int userId) {
            monitor-enter(this);
            Slogf.d(ActivityManagerShellCommand.TAG, "StopUserCallback: userStopped(%d)", new Object[]{Integer.valueOf(userId)});     // Catch: Throwable -> L6
            this.mFinished = true;     // Catch: Throwable -> L6
            notifyAll();     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        public synchronized void userStopAborted(int userId) {
            monitor-enter(this);
            Slogf.d(ActivityManagerShellCommand.TAG, "StopUserCallback: userStopAborted(%d)", new Object[]{Integer.valueOf(userId)});     // Catch: Throwable -> L6
            this.mFinished = true;     // Catch: Throwable -> L6
            notifyAll();     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        public String toString() {
            return "ProgressWaiter[userId=" + this.mUserId + ", finished=" + this.mFinished + "]";
        }
    }

    public static /* synthetic */ void $r8$lambda$1VXpcBixhQ_gdo_AjDR1GVXZUfs(ProgressWaiter r0) {
        lambda$onCommand$1(r0);
    }

    public static /* synthetic */ int $r8$lambda$8KPQIZounMsSvNAMzDRHaua8eyw(FeatureInfo r0, FeatureInfo r1) {
        return lambda$writeDeviceConfig$2(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$lGI2CtSUMM4YQ5gHs3CkTLLM7rc(ProgressWaiter r0, long r1) {
        lambda$onCommand$0(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAgent, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m1244$$Nest$fgetmAgent(ActivityManagerShellCommand r0) {
        return r0.mAgent;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBroadcastOptions, reason: not valid java name */
    static /* bridge */ /* synthetic */ BroadcastOptions m1245$$Nest$fgetmBroadcastOptions(ActivityManagerShellCommand r0) {
        return r0.mBroadcastOptions;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmStartFlags, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m1246$$Nest$fgetmStartFlags(ActivityManagerShellCommand r0) {
        return r0.mStartFlags;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmActivityType, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1247$$Nest$fputmActivityType(ActivityManagerShellCommand r0, int r1) {
        r0.mActivityType = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmAgent, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1248$$Nest$fputmAgent(ActivityManagerShellCommand r0, String r1) {
        r0.mAgent = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmAsync, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1249$$Nest$fputmAsync(ActivityManagerShellCommand r0, boolean r1) {
        r0.mAsync = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmAttachAgentDuringBind, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1250$$Nest$fputmAttachAgentDuringBind(ActivityManagerShellCommand r0, boolean r1) {
        r0.mAttachAgentDuringBind = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmAutoStop, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1251$$Nest$fputmAutoStop(ActivityManagerShellCommand r0, boolean r1) {
        r0.mAutoStop = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmBroadcastOptions, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1252$$Nest$fputmBroadcastOptions(ActivityManagerShellCommand r0, BroadcastOptions r1) {
        r0.mBroadcastOptions = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmClockType, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1253$$Nest$fputmClockType(ActivityManagerShellCommand r0, int r1) {
        r0.mClockType = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmDismissKeyguardIfInsecure, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1254$$Nest$fputmDismissKeyguardIfInsecure(ActivityManagerShellCommand r0, boolean r1) {
        r0.mDismissKeyguardIfInsecure = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmDisplayId, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1255$$Nest$fputmDisplayId(ActivityManagerShellCommand r0, int r1) {
        r0.mDisplayId = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmIsLockTask, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1256$$Nest$fputmIsLockTask(ActivityManagerShellCommand r0, boolean r1) {
        r0.mIsLockTask = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmIsTaskOverlay, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1257$$Nest$fputmIsTaskOverlay(ActivityManagerShellCommand r0, boolean r1) {
        r0.mIsTaskOverlay = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmProfileFile, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1258$$Nest$fputmProfileFile(ActivityManagerShellCommand r0, String r1) {
        r0.mProfileFile = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmProfilerOutputVersion, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1259$$Nest$fputmProfilerOutputVersion(ActivityManagerShellCommand r0, int r1) {
        r0.mProfilerOutputVersion = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmReceiverPermission, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1260$$Nest$fputmReceiverPermission(ActivityManagerShellCommand r0, String r1) {
        r0.mReceiverPermission = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmRepeat, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1261$$Nest$fputmRepeat(ActivityManagerShellCommand r0, int r1) {
        r0.mRepeat = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmSamplingInterval, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1262$$Nest$fputmSamplingInterval(ActivityManagerShellCommand r0, int r1) {
        r0.mSamplingInterval = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmShowSplashScreen, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1263$$Nest$fputmShowSplashScreen(ActivityManagerShellCommand r0, boolean r1) {
        r0.mShowSplashScreen = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmStartFlags, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1264$$Nest$fputmStartFlags(ActivityManagerShellCommand r0, int r1) {
        r0.mStartFlags = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmStopOption, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1265$$Nest$fputmStopOption(ActivityManagerShellCommand r0, boolean r1) {
        r0.mStopOption = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmStreaming, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1266$$Nest$fputmStreaming(ActivityManagerShellCommand r0, boolean r1) {
        r0.mStreaming = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmTaskDisplayAreaFeatureId, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1267$$Nest$fputmTaskDisplayAreaFeatureId(ActivityManagerShellCommand r0, int r1) {
        r0.mTaskDisplayAreaFeatureId = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmTaskId, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1268$$Nest$fputmTaskId(ActivityManagerShellCommand r0, int r1) {
        r0.mTaskId = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmUserId, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1269$$Nest$fputmUserId(ActivityManagerShellCommand r0, int r1) {
        r0.mUserId = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmWaitOption, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1270$$Nest$fputmWaitOption(ActivityManagerShellCommand r0, boolean r1) {
        r0.mWaitOption = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmWindowingMode, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1271$$Nest$fputmWindowingMode(ActivityManagerShellCommand r0, int r1) {
        r0.mWindowingMode = r1;
    }

    static {
        LOG_NAME_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss", Locale.ROOT);
        CAPABILITIES = new String[]{"start.suspend"};
    }

    ActivityManagerShellCommand(ActivityManagerService service, boolean dumping) {
        this.mStartFlags = 0;
        this.mWaitOption = false;
        this.mStopOption = false;
        this.mRepeat = 0;
        this.mInterface = service;
        this.mTaskInterface = service.mActivityTaskManager;
        this.mInternal = service;
        this.mPm = AppGlobals.getPackageManager();
        this.mDumping = dumping;
    }

    public int onCommand(String cmd) {
        if (cmd == null) goto L4;
        PrintWriter pw = getOutPrintWriter();
        int r5 = 0;
        switch(cmd.hashCode()) {
            case -2121667104: goto L306;
            case -1969672196: goto L303;
            case -1864717225: goto L300;
            case -1860393403: goto L297;
            case -1719979774: goto L294;
            case -1710503333: goto L291;
            case -1667670943: goto L288;
            case -1633327833: goto L285;
            case -1619282346: goto L282;
            case -1618876223: goto L279;
            case -1514943892: goto L276;
            case -1499335439: goto L273;
            case -1487597642: goto L270;
            case -1470725846: goto L267;
            case -1354812542: goto L264;
            case -1324660647: goto L261;
            case -1303445945: goto L258;
            case -1275145137: goto L255;
            case -1266402665: goto L252;
            case -1182154244: goto L249;
            case -1131287478: goto L246;
            case -1002578147: goto L243;
            case -965273485: goto L240;
            case -930080590: goto L237;
            case -907667276: goto L234;
            case -892396682: goto L231;
            case -878494906: goto L228;
            case -870018278: goto L225;
            case -863288131: goto L222;
            case -812219210: goto L219;
            case -747637291: goto L216;
            case -703047585: goto L213;
            case -699625063: goto L210;
            case -656088391: goto L207;
            case -606123342: goto L204;
            case -548621938: goto L201;
            case -541939658: goto L198;
            case -443938379: goto L195;
            case -387147436: goto L192;
            case -379899280: goto L189;
            case -354890749: goto L186;
            case -309425751: goto L183;
            case -225973678: goto L180;
            case -170987146: goto L177;
            case -149941524: goto L174;
            case -146027423: goto L171;
            case -138040195: goto L168;
            case -100644880: goto L165;
            case -74413870: goto L162;
            case -27715536: goto L159;
            case 3194994: goto L156;
            case 3198785: goto L153;
            case 3291998: goto L150;
            case 3552645: goto L147;
            case 88586660: goto L144;
            case 94921639: goto L141;
            case 109757064: goto L138;
            case 109757538: goto L135;
            case 113399775: goto L132;
            case 135017371: goto L129;
            case 185053203: goto L126;
            case 237240942: goto L123;
            case 549617690: goto L120;
            case 622433197: goto L117;
            case 661133534: goto L114;
            case 667014829: goto L111;
            case 680834441: goto L108;
            case 723112852: goto L105;
            case 759066228: goto L102;
            case 764545184: goto L99;
            case 782722708: goto L96;
            case 808179021: goto L93;
            case 810242677: goto L90;
            case 817137578: goto L87;
            case 822490030: goto L84;
            case 847202110: goto L81;
            case 900455412: goto L78;
            case 950483747: goto L75;
            case 1024703869: goto L72;
            case 1070798153: goto L69;
            case 1078591527: goto L66;
            case 1097506319: goto L63;
            case 1129261387: goto L60;
            case 1147479778: goto L57;
            case 1180451466: goto L54;
            case 1219773618: goto L51;
            case 1236319578: goto L48;
            case 1395483623: goto L45;
            case 1491372991: goto L42;
            case 1583986358: goto L39;
            case 1618908732: goto L36;
            case 1671764162: goto L33;
            case 1713645014: goto L30;
            case 1768693408: goto L27;
            case 1852789518: goto L24;
            case 1861559962: goto L21;
            case 1863290858: goto L18;
            case 2030969636: goto L15;
            case 2083239620: goto L10;
            default: goto L308;
        };     // Catch: RemoteException -> L12
    L308:
        byte r2 = -1;
    L309:
        switch(r2) {
            case 0: goto L496;
            case 1: goto L495;
            case 2: goto L495;
            case 3: goto L492;
            case 4: goto L491;
            case 5: goto L491;
            case 6: goto L489;
            case 7: goto L489;
            case 8: goto L489;
            case 9: goto L489;
            case 10: goto L487;
            case 11: goto L487;
            case 12: goto L485;
            case 13: goto L483;
            case 14: goto L481;
            case 15: goto L479;
            case 16: goto L476;
            case 17: goto L475;
            case 18: goto L473;
            case 19: goto L471;
            case 20: goto L469;
            case 21: goto L467;
            case 22: goto L465;
            case 23: goto L463;
            case 24: goto L461;
            case 25: goto L459;
            case 26: goto L457;
            case 27: goto L455;
            case 28: goto L453;
            case 29: goto L451;
            case 30: goto L449;
            case 31: goto L447;
            case 32: goto L445;
            case 33: goto L443;
            case 34: goto L441;
            case 35: goto L439;
            case 36: goto L437;
            case 37: goto L435;
            case 38: goto L433;
            case 39: goto L431;
            case 40: goto L429;
            case 41: goto L427;
            case 42: goto L425;
            case 43: goto L423;
            case 44: goto L421;
            case 45: goto L419;
            case 46: goto L417;
            case 47: goto L415;
            case 48: goto L413;
            case 49: goto L411;
            case 50: goto L409;
            case 51: goto L407;
            case 52: goto L405;
            case 53: goto L403;
            case 54: goto L401;
            case 55: goto L399;
            case 56: goto L397;
            case 57: goto L395;
            case 58: goto L393;
            case 59: goto L391;
            case 60: goto L389;
            case 61: goto L387;
            case 62: goto L385;
            case 63: goto L383;
            case 64: goto L381;
            case 65: goto L379;
            case 66: goto L377;
            case 67: goto L375;
            case 68: goto L373;
            case 69: goto L371;
            case 70: goto L369;
            case 71: goto L367;
            case 72: goto L365;
            case 73: goto L363;
            case 74: goto L361;
            case 75: goto L359;
            case 76: goto L357;
            case 77: goto L355;
            case 78: goto L353;
            case 79: goto L351;
            case 80: goto L349;
            case 81: goto L347;
            case 82: goto L345;
            case 83: goto L343;
            case 84: goto L341;
            case 85: goto L339;
            case 86: goto L337;
            case 87: goto L335;
            case 88: goto L333;
            case 89: goto L331;
            case 90: goto L329;
            case 91: goto L327;
            case 92: goto L325;
            case 93: goto L323;
            case 94: goto L321;
            case 95: goto L319;
            case 96: goto L317;
            case 97: goto L315;
            case 98: goto L313;
            default: goto L311;
        };     // Catch: RemoteException -> L12
    L476:
        getOutPrintWriter().println("Error: must be invoked through 'am instrument'.");     // Catch: RemoteException -> L12
        return -1;
    L492:
        final ProgressWaiter waiter = new ProgressWaiter(this, r5, null);     // Catch: RemoteException -> L12
        this.mInternal.mUiHandler.runWithScissors(new ActivityManagerShellCommand$$ExternalSyntheticLambda2(waiter), 60000);     // Catch: RemoteException -> L12
        waiter.waitForFinish(120000);     // Catch: RemoteException -> L12
        return runStartActivity(pw);
    L496:
        onHelp();     // Catch: RemoteException -> L12
        return 0;
    L311:
        return handleDefaultCommands(cmd);
    L313:
        return runClearBadProcess(pw);
    L315:
        return runSetMediaForegroundService(pw);
    L317:
        return runSetAppZygotePreloadTimeout(pw);
    L319:
        return runCapabilities(pw);
    L321:
        return runSetForegroundServiceDelegate(pw);
    L323:
        return runListDisplaysForStartingUsers(pw);
    L325:
        return runResetDropboxRateLimiter();
    L327:
        return runGetCurrentForegroundProcess(pw, this.mInternal);
    L329:
        return runGetBgRestrictionLevel(pw);
    L331:
        return runSetBgRestrictionLevel(pw);
    L333:
        return runListBgExemptionsConfig(pw);
    L335:
        return runSetBgAbusiveUids(pw);
    L337:
        return runSetStopUserOnSwitch(pw);
    L339:
        return runGetIsolatedProcesses(pw);
    L341:
        return runServiceRestartBackoff(pw);
    L343:
        return runMemoryFactor(pw);
    L345:
        return runRefreshSettingsCache();
    L347:
        return runCompat(pw);
    L349:
        return runClearIgnoreDeliveryGroupPolicy(pw);
    L351:
        return runSetIgnoreDeliveryGroupPolicy(pw);
    L353:
        return runWaitForBroadcastDispatch(pw);
    L355:
        return runWaitForApplicationBarrier(pw);
    L357:
        return runWaitForBroadcastBarrier(pw);
    L359:
        return runWaitForBroadcastIdle(pw);
    L361:
        return runNoHomeScreen(pw);
    L363:
        return runUpdateApplicationInfo(pw);
    L365:
        return runSupportsSplitScreenMultiwindow(pw);
    L367:
        return runSupportsMultiwindow(pw);
    L369:
        return runAttachAgent(pw);
    L371:
        return runWrite(pw);
    L373:
        return runTask(pw);
    L375:
        return runStack(pw);
    L377:
        return runDisplay(pw);
    L379:
        return runSendTrimMemory(pw);
    L381:
        return runGetStandbyBucket(pw);
    L383:
        return runSetStandbyBucket(pw);
    L385:
        return runGetInactive(pw);
    L387:
        return runSetInactive(pw);
    L389:
        return runSuppressResizeConfigChanges(pw);
    L391:
        return runGetConfig(pw);
    L393:
        return getUidState(pw);
    L395:
        return runUntrackAssociations(pw);
    L397:
        return runTrackAssociations(pw);
    L399:
        return runGetStartedUserState(pw);
    L401:
        return runIsUserStopped(pw);
    L403:
        return runStopUser(pw);
    L405:
        return runUnlockUser(pw);
    L407:
        return runStartUser(pw);
    L409:
        return runGetCurrentUser(pw);
    L411:
        return runSwitchUser(pw);
    L413:
        return runToUri(pw, 2);
    L415:
        return runToUri(pw, 1);
    L417:
        return runToUri(pw, 0);
    L419:
        return runPackageImportance(pw);
    L421:
        return runScreenCompat(pw);
    L423:
        return runIdleMaintenance(pw);
    L425:
        return runRestart(pw);
    L427:
        return runHang(pw);
    L429:
        return runWatchUids(pw);
    L431:
        return runMonitor(pw);
    L433:
        return runSetDeterministicUidIdle(pw);
    L435:
        return runMakeIdle(pw);
    L437:
        return runKillAll(pw);
    L439:
        return runKill(pw);
    L441:
        return runCrash(pw);
    L443:
        return runFgsNotificationRateLimit(pw);
    L445:
        return runClearRecentApps(pw);
    L447:
        return runStopApp(pw);
    L449:
        return runForceStop(pw);
    L451:
        return runBugReport(pw);
    L453:
        return runClearExitInfo(pw);
    L455:
        return runStartInfoDetailedMonitoring(pw);
    L457:
        return runClearStartInfo(pw);
    L459:
        return runClearWatchHeap(pw);
    L461:
        return runSetWatchHeap(pw);
    L463:
        return runClearDebugApp(pw);
    L465:
        return runSetAgentApp(pw);
    L467:
        return runSetDebugApp(pw);
    L469:
        return runDumpHeap(pw);
    L471:
        return runProfile(pw);
    L473:
        return runTraceTimer(pw);
    L475:
        return runTraceIpc(pw);
    L479:
        return runFreeze(pw, false);
    L481:
        return runFreeze(pw, true);
    L483:
        return runCompact(pw);
    L485:
        return runSendBroadcast(pw);
    L487:
        return runStopService(pw);
    L489:
        return runStartService(pw, true);
    L491:
        return runStartService(pw, false);
    L495:
        return runStartActivity(pw);
    L10:
        if (cmd.equals("switch-user") == false) goto L308;
        r2 = 49;
        goto L309
    L15:
        if (cmd.equals("clear-recent-apps") == false) goto L308;
        r2 = ParameterName.CVRR;
        goto L309
    L18:
        if (cmd.equals("stop-service") == false) goto L308;
        r2 = 11;
        goto L309
    L21:
        if (cmd.equals("idle-maintenance") == false) goto L308;
        r2 = ParameterName.ELEVEN_POINT_RED;
        goto L309
    L24:
        if (cmd.equals("no-home-screen") == false) goto L308;
        r2 = ParameterName.COLOR_TUNER_LUMINANCE_BLUE;
        goto L309
    L27:
        if (cmd.equals("set-stop-user-on-switch") == false) goto L308;
        r2 = ParameterName.ENHANCED_AUDIO_RETURN_CHANNEL_ENABLED;
        goto L309
    L30:
        if (cmd.equals("stop-app") == false) goto L308;
        r2 = ParameterName.VRR;
        goto L309
    L33:
        if (cmd.equals("display") == false) goto L308;
        r2 = ParameterName.COLOR_TUNER_SATURATION_GREEN;
        goto L309
    L36:
        if (cmd.equals("wait-for-broadcast-idle") == false) goto L308;
        r2 = 75;
        goto L309
    L39:
        if (cmd.equals("stop-user") == false) goto L308;
        r2 = 53;
        goto L309
    L42:
        if (cmd.equals("set-media-foreground-service") == false) goto L308;
        r2 = 97;
        goto L309
    L45:
        if (cmd.equals("instrument") == false) goto L308;
        r2 = 16;
        goto L309
    L48:
        if (cmd.equals("monitor") == false) goto L308;
        r2 = ParameterName.COLOR_TEMPERATURE_BLUE_GAIN;
        goto L309
    L51:
        if (cmd.equals("get-started-user-state") == false) goto L308;
        r2 = 55;
        goto L309
    L54:
        if (cmd.equals("refresh-settings-cache") == false) goto L308;
        r2 = ParameterName.SURROUND_SOUND_ENABLED;
        goto L309
    L57:
        if (cmd.equals("wait-for-broadcast-dispatch") == false) goto L308;
        r2 = ParameterName.COLOR_TUNER_LUMINANCE_FLESH;
        goto L309
    L60:
        if (cmd.equals("update-appinfo") == false) goto L308;
        r2 = ParameterName.COLOR_TUNER_LUMINANCE_GREEN;
        goto L309
    L63:
        if (cmd.equals(HostingRecord.HOSTING_TYPE_RESTART) == false) goto L308;
        r2 = 42;
        goto L309
    L66:
        if (cmd.equals("clear-debug-app") == false) goto L308;
        r2 = ParameterName.COLOR_TEMPERATURE;
        goto L309
    L69:
        if (cmd.equals("set-ignore-delivery-group-policy") == false) goto L308;
        r2 = ParameterName.BALANCE;
        goto L309
    L72:
        if (cmd.equals("attach-agent") == false) goto L308;
        r2 = ParameterName.COLOR_TUNER_SATURATION_YELLOW;
        goto L309
    L75:
        if (cmd.equals("compact") == false) goto L308;
        r2 = 13;
        goto L309
    L78:
        if (cmd.equals("start-fg-service") == false) goto L308;
        r2 = 9;
        goto L309
    L81:
        if (cmd.equals("clear-ignore-delivery-group-policy") == false) goto L308;
        r2 = ParameterName.BASS;
        goto L309
    L84:
        if (cmd.equals("set-agent-app") == false) goto L308;
        r2 = ParameterName.COLOR_TUNE;
        goto L309
    L87:
        if (cmd.equals("clear-watch-heap") == false) goto L308;
        r2 = ParameterName.AUTO_PICTUREQUALITY_ENABLED;
        goto L309
    L90:
        if (cmd.equals("set-watch-heap") == false) goto L308;
        r2 = ParameterName.GLOBE_DIMMING;
        goto L309
    L93:
        if (cmd.equals("to-intent-uri") == false) goto L308;
        r2 = ParameterName.LD_MODE;
        goto L309
    L96:
        if (cmd.equals("set-bg-abusive-uids") == false) goto L308;
        r2 = ParameterName.AUTO_VOLUME_CONTROL;
        goto L309
    L99:
        if (cmd.equals("supports-multiwindow") == false) goto L308;
        r2 = ParameterName.COLOR_TUNER_SATURATION_FLESH;
        goto L309
    L102:
        if (cmd.equals("start-in-vsync") == false) goto L308;
        r2 = 3;
        goto L309
    L105:
        if (cmd.equals("trace-ipc") == false) goto L308;
        r2 = ParameterName.DE_CONTOUR;
        goto L309
    L108:
        if (cmd.equals("supports-split-screen-multi-window") == false) goto L308;
        r2 = ParameterName.COLOR_TUNER_LUMINANCE_RED;
        goto L309
    L111:
        if (cmd.equals("bug-report") == false) goto L308;
        r2 = ParameterName.PC_MODE;
        goto L309
    L114:
        if (cmd.equals("wait-for-application-barrier") == false) goto L308;
        r2 = ParameterName.COLOR_TUNER_LUMINANCE_YELLOW;
        goto L309
    L117:
        if (cmd.equals("untrack-associations") == false) goto L308;
        r2 = ParameterName.COLOR_TUNER_SWITCH;
        goto L309
    L120:
        if (cmd.equals("start-activity") == false) goto L308;
        r2 = 2;
        goto L309
    L123:
        if (cmd.equals("to-app-uri") == false) goto L308;
        r2 = 48;
        goto L309
    L126:
        if (cmd.equals("startservice") == false) goto L308;
        r2 = 4;
        goto L309
    L129:
        if (cmd.equals("memory-factor") == false) goto L308;
        r2 = 83;
        goto L309
    L132:
        if (cmd.equals("write") == false) goto L308;
        r2 = ParameterName.COLOR_TUNER_SATURATION_MAGENTA;
        goto L309
    L135:
        if (cmd.equals(IMediaProjectionManagerServiceExt.NODE_START) == false) goto L308;
        r2 = 1;
        goto L309
    L138:
        if (cmd.equals("stack") == false) goto L308;
        r2 = ParameterName.COLOR_TUNER_SATURATION_BLUE;
        goto L309
    L141:
        if (cmd.equals("crash") == false) goto L308;
        r2 = 34;
        goto L309
    L144:
        if (cmd.equals("force-stop") == false) goto L308;
        r2 = ParameterName.LOW_LATENCY;
        goto L309
    L147:
        if (cmd.equals("task") == false) goto L308;
        r2 = ParameterName.COLOR_TUNER_SATURATION_CYAN;
        goto L309
    L150:
        if (cmd.equals("kill") == false) goto L308;
        r2 = 35;
        goto L309
    L153:
        if (cmd.equals("help") == false) goto L308;
        r2 = 0;
        goto L309
    L156:
        if (cmd.equals("hang") == false) goto L308;
        r2 = 41;
        goto L309
    L159:
        if (cmd.equals("make-uid-idle") == false) goto L308;
        r2 = 37;
        goto L309
    L162:
        if (cmd.equals("get-bg-restriction-level") == false) goto L308;
        r2 = ParameterName.DOLBY_AUDIO_PROCESSING;
        goto L309
    L165:
        if (cmd.equals("startforegroundservice") == false) goto L308;
        r2 = 6;
        goto L309
    L168:
        if (cmd.equals("clear-exit-info") == false) goto L308;
        r2 = ParameterName.GAMUT_MAPPING;
        goto L309
    L171:
        if (cmd.equals("watch-uids") == false) goto L308;
        r2 = ParameterName.COLOR_TEMPERATURE_RED_OFFSET;
        goto L309
    L174:
        if (cmd.equals("list-bg-exemptions-config") == false) goto L308;
        r2 = 88;
        goto L309
    L177:
        if (cmd.equals("set-inactive") == false) goto L308;
        r2 = ParameterName.COLOR_TUNER_HUE_CYAN;
        goto L309
    L180:
        if (cmd.equals("service-restart-backoff") == false) goto L308;
        r2 = ParameterName.SPEAKERS_ENABLED;
        goto L309
    L183:
        if (cmd.equals("profile") == false) goto L308;
        r2 = ParameterName.FILM_MODE;
        goto L309
    L186:
        if (cmd.equals("screen-compat") == false) goto L308;
        r2 = ParameterName.ELEVEN_POINT_GREEN;
        goto L309
    L189:
        if (cmd.equals("unfreeze") == false) goto L308;
        r2 = 15;
        goto L309
    L192:
        if (cmd.equals("track-associations") == false) goto L308;
        r2 = ParameterName.OSD_CONTRAST;
        goto L309
    L195:
        if (cmd.equals("fgs-notification-rate-limit") == false) goto L308;
        r2 = 33;
        goto L309
    L198:
        if (cmd.equals("observe-foreground-process") == false) goto L308;
        r2 = ParameterName.DOLBY_DIALOGUE_ENHANCER;
        goto L309
    L201:
        if (cmd.equals("is-user-stopped") == false) goto L308;
        r2 = 54;
        goto L309
    L204:
        if (cmd.equals("kill-all") == false) goto L308;
        r2 = 36;
        goto L309
    L207:
        if (cmd.equals("clear-start-info") == false) goto L308;
        r2 = ParameterName.AUTO_SUPER_RESOLUTION_ENABLED;
        goto L309
    L210:
        if (cmd.equals("get-config") == false) goto L308;
        r2 = ParameterName.COLOR_TUNER_HUE_GREEN;
        goto L309
    L213:
        if (cmd.equals("set-app-zygote-preload-timeout") == false) goto L308;
        r2 = 96;
        goto L309
    L216:
        if (cmd.equals("set-standby-bucket") == false) goto L308;
        r2 = ParameterName.COLOR_TUNER_HUE_YELLOW;
        goto L309
    L219:
        if (cmd.equals("get-current-user") == false) goto L308;
        r2 = 50;
        goto L309
    L222:
        if (cmd.equals("trace-timer") == false) goto L308;
        r2 = ParameterName.DYNAMIC_LUMA_CONTROL;
        goto L309
    L225:
        if (cmd.equals("to-uri") == false) goto L308;
        r2 = ParameterName.LOW_BLUE_LIGHT;
        goto L309
    L228:
        if (cmd.equals("set-bg-restriction-level") == false) goto L308;
        r2 = ParameterName.DTS_DRC;
        goto L309
    L231:
        if (cmd.equals("start-foreground-service") == false) goto L308;
        r2 = 8;
        goto L309
    L234:
        if (cmd.equals("unlock-user") == false) goto L308;
        r2 = 52;
        goto L309
    L237:
        if (cmd.equals("startfgservice") == false) goto L308;
        r2 = 7;
        goto L309
    L240:
        if (cmd.equals("stopservice") == false) goto L308;
        r2 = 10;
        goto L309
    L243:
        if (cmd.equals("get-uid-state") == false) goto L308;
        r2 = ParameterName.COLOR_TUNER_HUE_RED;
        goto L309
    L246:
        if (cmd.equals("start-service") == false) goto L308;
        r2 = 5;
        goto L309
    L249:
        if (cmd.equals("set-foreground-service-delegate") == false) goto L308;
        r2 = ParameterName.DIGITAL_OUTPUT_DELAY_MS;
        goto L309
    L252:
        if (cmd.equals(IResMngConfig.FEAT_FREEZE) == false) goto L308;
        r2 = 14;
        goto L309
    L255:
        if (cmd.equals("wait-for-broadcast-barrier") == false) goto L308;
        r2 = 76;
        goto L309
    L258:
        if (cmd.equals("send-trim-memory") == false) goto L308;
        r2 = ParameterName.COLOR_TUNER_SATURATION_RED;
        goto L309
    L261:
        if (cmd.equals("suppress-resize-config-changes") == false) goto L308;
        r2 = ParameterName.COLOR_TUNER_HUE_BLUE;
        goto L309
    L264:
        if (cmd.equals("compat") == false) goto L308;
        r2 = ParameterName.TREBLE;
        goto L309
    L267:
        if (cmd.equals("reset-dropbox-rate-limiter") == false) goto L308;
        r2 = ParameterName.DTS_VIRTUAL_X;
        goto L309
    L270:
        if (cmd.equals("capabilities") == false) goto L308;
        r2 = ParameterName.SOUND_STYLE;
        goto L309
    L273:
        if (cmd.equals("start-info-detailed-monitoring") == false) goto L308;
        r2 = ParameterName.LEVEL_RANGE;
        goto L309
    L276:
        if (cmd.equals("list-displays-for-starting-users") == false) goto L308;
        r2 = ParameterName.DIGITAL_OUTPUT;
        goto L309
    L279:
        if (cmd.equals("broadcast") == false) goto L308;
        r2 = 12;
        goto L309
    L282:
        if (cmd.equals("start-user") == false) goto L308;
        r2 = 51;
        goto L309
    L285:
        if (cmd.equals("clear-bad-process") == false) goto L308;
        r2 = 98;
        goto L309
    L288:
        if (cmd.equals("get-standby-bucket") == false) goto L308;
        r2 = ParameterName.COLOR_TUNER_HUE_FLESH;
        goto L309
    L291:
        if (cmd.equals("package-importance") == false) goto L308;
        r2 = ParameterName.ELEVEN_POINT_BLUE;
        goto L309
    L294:
        if (cmd.equals("get-inactive") == false) goto L308;
        r2 = ParameterName.COLOR_TUNER_HUE_MAGENTA;
        goto L309
    L297:
        if (cmd.equals("get-isolated-pids") == false) goto L308;
        r2 = ParameterName.SPEAKERS_DELAY_MS;
        goto L309
    L300:
        if (cmd.equals("set-deterministic-uid-idle") == false) goto L308;
        r2 = ParameterName.COLOR_TEMPERATURE_GREEN_GAIN;
        goto L309
    L303:
        if (cmd.equals("set-debug-app") == false) goto L308;
        r2 = ParameterName.BLUE_STRETCH;
        goto L309
    L306:
        if (cmd.equals("dumpheap") == false) goto L308;
        r2 = ParameterName.BLACK_STRETCH;
    L12:
        e = move-exception;
        pw.println("Remote exception: " + e);
        return -1;
    L4:
        return handleDefaultCommands(cmd);
    }

    private static /* synthetic */ void lambda$onCommand$1(final ProgressWaiter waiter) {
        Choreographer.getInstance().postFrameCallback(new ActivityManagerShellCommand$$ExternalSyntheticLambda3(waiter));
    }

    private static /* synthetic */ void lambda$onCommand$0(ProgressWaiter waiter, long frameTimeNanos) {
        waiter.onFinished(0, null);
    }

    int runSetMediaForegroundService(PrintWriter pw) throws RemoteException {
        this.mInternal.enforceCallingPermission("android.permission.CHANGE_COMPONENT_ENABLED_STATE", "runSetMediaForegroundService()");
        PrintWriter err = getErrPrintWriter();
        err.println("Error: flag com.android.media.flags.enable_notifying_activity_manager_with_media_session_status_change not enabled");
        return -1;
    }

    int runSetAppZygotePreloadTimeout(PrintWriter pw) throws RemoteException {
        String timeout = getNextArgRequired();
        int timeoutMs = Integer.parseInt(timeout);
        ZygoteProcess.setAppZygotePreloadTimeout(timeoutMs);
        return 0;
    }

    int runCapabilities(PrintWriter pw) throws RemoteException {
        PrintWriter err = getErrPrintWriter();
        boolean outputAsProtobuf = false;
    L3:
        String opt = getNextOption();
        if (opt == null) goto L10;
        if (opt.equals("--protobuf") == false) goto L8;
        outputAsProtobuf = true;
        goto L3
    L8:
        err.println("Error: Unknown option: " + opt);
        return -1;
    L10:
        String vmName = System.getProperty("java.vm.name", "?");
        String vmVersion = System.getProperty("java.vm.version", "?");
        if (outputAsProtobuf == false) goto L30;
        Capabilities capabilities = new Capabilities();
        capabilities.values = new Capability[CAPABILITIES.length];
        int i = 0;
    L14:
        if (i >= CAPABILITIES.length) goto L16;
        Capability cap = new Capability();
        cap.name = CAPABILITIES[i];
        capabilities.values[i] = cap;
        i = i + 1;
        goto L14
    L16:
        String[] vmCapabilities = Debug.getVmFeatureList();
        capabilities.vmCapabilities = new VMCapability[vmCapabilities.length];
        int i2 = 0;
    L18:
        if (i2 >= vmCapabilities.length) goto L20;
        VMCapability cap2 = new VMCapability();
        cap2.name = vmCapabilities[i2];
        capabilities.vmCapabilities[i2] = cap2;
        i2 = i2 + 1;
        goto L18
    L20:
        String[] fmCapabilities = Debug.getFeatureList();
        capabilities.frameworkCapabilities = new FrameworkCapability[fmCapabilities.length];
        int i3 = 0;
    L22:
        if (i3 >= fmCapabilities.length) goto L24;
        FrameworkCapability cap3 = new FrameworkCapability();
        cap3.name = fmCapabilities[i3];
        capabilities.frameworkCapabilities[i3] = cap3;
        i3 = i3 + 1;
        goto L22
    L24:
        VMInfo vmInfo = new VMInfo();
        vmInfo.name = vmName;
        vmInfo.version = vmVersion;
        capabilities.vmInfo = vmInfo;
        getRawOutputStream().write(Capabilities.toByteArray(capabilities));     // Catch: IOException -> L27
    L40:
        return 0;
    L28:
        pw.println("Error while serializing capabilities protobuffer");
        goto L40
    L30:
        pw.println("Format: 2");
        String[] r6 = CAPABILITIES;
        int r7 = r6.length;
        int r8 = 0;
    L31:
        if (r8 >= r7) goto L33;
        String capability = r6[r8];
        pw.println(capability);
        r8 = r8 + 1;
        goto L31
    L33:
        String[] r9 = Debug.getVmFeatureList();
        int r10 = r9.length;
        int r11 = 0;
    L34:
        if (r11 >= r10) goto L36;
        String capability2 = r9[r11];
        pw.println("vm:" + capability2);
        r11 = r11 + 1;
        goto L34
    L36:
        String[] r12 = Debug.getFeatureList();
        int r13 = r12.length;
        int r14 = 0;
    L37:
        if (r14 >= r13) goto L39;
        String capability3 = r12[r14];
        pw.println("framework:" + capability3);
        r14 = r14 + 1;
        goto L37
    L39:
        pw.println("vm_name:" + vmName);
        pw.println("vm_version:" + vmVersion);
        goto L40
    }

    private Intent makeIntent(int defUser) throws URISyntaxException {
        this.mStartFlags = 0;
        this.mWaitOption = false;
        this.mStopOption = false;
        this.mRepeat = 0;
        this.mProfileFile = null;
        this.mSamplingInterval = 0;
        this.mAutoStop = false;
        this.mStreaming = false;
        this.mUserId = defUser;
        this.mDisplayId = -1;
        this.mTaskDisplayAreaFeatureId = -1;
        this.mWindowingMode = 0;
        this.mActivityType = 0;
        this.mTaskId = -1;
        this.mIsTaskOverlay = false;
        this.mIsLockTask = false;
        this.mAsync = false;
        this.mBroadcastOptions = null;
        return Intent.parseCommandArgs(this, new AnonymousClass1(this));
    }

    int runStartActivity(PrintWriter pw) throws RemoteException {
        Intent intent = makeIntent(-2);     // Catch: URISyntaxException -> L146
        int r9 = -1;
        int r10 = 1;
        if (this.mUserId != (-1)) goto L8;
        getErrPrintWriter().println("Error: Can't start service with user 'all'");
        return 1;
    L8:
        String mimeType = intent.resolveType(this.mInternal.mContext);
    L10:
        if (this.mStopOption == true) goto L12;
        Intent intent2 = intent;
    L33:
        if (this.mProfileFile != null) goto L39;
        if (this.mAgent != null) goto L39;
        ProfilerInfo profilerInfo = null;
    L46:
        pw.println("Starting: " + intent2);
        pw.flush();
        intent2.addFlags(268435456);
        WaitResult result = null;
        long startTime = SystemClock.uptimeMillis();
        ActivityOptions options = null;
        if (this.mDisplayId == r9) goto L50;
        options = ActivityOptions.makeBasic();
        options.setLaunchDisplayId(this.mDisplayId);
    L50:
        if (this.mTaskDisplayAreaFeatureId == r9) goto L55;
        if (options != null) goto L53;
        options = ActivityOptions.makeBasic();
    L53:
        options.setLaunchTaskDisplayAreaFeatureId(this.mTaskDisplayAreaFeatureId);
    L55:
        if (this.mWindowingMode == 0) goto L60;
        if (options != null) goto L58;
        options = ActivityOptions.makeBasic();
    L58:
        options.setLaunchWindowingMode(this.mWindowingMode);
    L60:
        if (this.mActivityType == 0) goto L65;
        if (options != null) goto L63;
        options = ActivityOptions.makeBasic();
    L63:
        options.setLaunchActivityType(this.mActivityType);
    L65:
        if (this.mTaskId == r9) goto L72;
        if (options != null) goto L68;
        options = ActivityOptions.makeBasic();
    L68:
        options.setLaunchTaskId(this.mTaskId);
        if (this.mIsTaskOverlay == false) goto L72;
        options.setTaskOverlay(true, true);
    L72:
        if (this.mIsLockTask == false) goto L77;
        if (options != null) goto L75;
        options = ActivityOptions.makeBasic();
    L75:
        options.setLockTaskEnabled(true);
    L77:
        if (this.mShowSplashScreen == false) goto L81;
        if (options != null) goto L80;
        options = ActivityOptions.makeBasic();
    L80:
        int r5 = 1;
        options.setSplashScreenStyle(1);
    L83:
        if (this.mDismissKeyguardIfInsecure == false) goto L87;
        if (options != null) goto L86;
        options = ActivityOptions.makeBasic();
    L86:
        options.setDismissKeyguardIfInsecure();
        ActivityOptions options2 = options;
    L88:
        intent2.collectExtraIntentKeys();
        Bundle r6 = null;
        if (this.mWaitOption == false) goto L94;
        ActivityManagerService r3 = this.mInternal;
        int r12 = this.mStartFlags;
        if (options2 == null) goto L93;
        r6 = options2.toBundle();
    L93:
        Intent intent3 = intent2;
        int r19 = r9;
        int r22 = 0;
        result = r3.startActivityAndWait(null, "com.android.shell", null, intent3, mimeType, null, null, 0, r12, profilerInfo, r6, this.mUserId);
        Intent intent4 = intent3;
        int res = result.result;
    L98:
        long endTime = SystemClock.uptimeMillis();
        if (this.mWaitOption == false) goto L101;
        PrintWriter out = pw;
    L103:
        switch(res) {
            case -98: goto L144;
            case -97: goto L142;
            case -94: goto L140;
            case -93: goto L138;
            case -92: goto L136;
            case -91: goto L134;
            case 0: goto L110;
            case 1: goto L109;
            case 2: goto L108;
            case 3: goto L107;
            case 100: goto L106;
            default: goto L104;
        };
    L106:
        boolean launched = true;
        out.println("Warning: Activity not started because the  current activity is being kept for the user.");
    L111:
        out.flush();
        if (this.mWaitOption == false) goto L127;
        if (launched == false) goto L127;
        if (result != null) goto L116;
        result = new WaitResult();
        result.who = intent4.getComponent();
    L116:
        StringBuilder r11 = new StringBuilder();
        r11.append("Status: ");
        if (result.timeout == false) goto L119;
        String r13 = "timeout";
    L120:
        r11.append(r13);
        pw.println(r11.toString());
        pw.println("LaunchState: " + WaitResult.launchStateToString(result.launchState));
        if (result.who == null) goto L124;
        pw.println("Activity: " + result.who.flattenToShortString());
    L124:
        if (result.totalTime < 0) goto L126;
        pw.println("TotalTime: " + result.totalTime);
    L126:
        pw.println("WaitTime: " + (endTime - startTime));
        pw.println("Complete");
        pw.flush();
        goto L127
    L119:
        r13 = "ok";
    L127:
        this.mRepeat--;
        if (this.mRepeat <= 0) goto L131;
        this.mTaskInterface.unhandledBack();
    L131:
        if (this.mRepeat <= 0) goto L132;
        intent = intent4;
        r9 = r19;
        r10 = r5;
        goto L10
    L132:
        return r22;
    L107:
        launched = true;
        out.println("Warning: Activity not started, intent has been delivered to currently running top-most instance.");
        goto L111
    L108:
        launched = true;
        out.println("Warning: Activity not started, its current task has been brought to the front");
        goto L111
    L109:
        launched = true;
        out.println("Warning: Activity not started because intent should be handled by the caller");
        goto L111
    L110:
        launched = true;
        goto L111
    L104:
        out.println("Error: Activity not started, unknown error code " + res);
        return r5;
    L134:
        out.println("Error: Activity not started, unable to resolve " + intent4.toString());
        return r5;
    L136:
        out.println(NO_CLASS_ERROR_CODE);
        out.println("Error: Activity class " + intent4.getComponent().toShortString() + " does not exist.");
        return r5;
    L138:
        out.println("Error: Activity not started, you requested to both forward and receive its result");
        return r5;
    L140:
        out.println("Error: Activity not started, you do not have permission to access it.");
        return r5;
    L142:
        out.println("Error: Activity not started, voice control not allowed for: " + intent4);
        return r5;
    L144:
        out.println("Error: Not allowed to start background user activity that shouldn't be displayed for all users.");
        return r5;
    L101:
        out = getErrPrintWriter();
        goto L103
    L94:
        r19 = r9;
        r22 = 0;
        ActivityManagerService r4 = this.mInternal;
        int r14 = this.mStartFlags;
        if (options2 == null) goto L97;
        r6 = options2.toBundle();
    L97:
        Intent intent5 = intent2;
        res = r4.startActivityAsUserWithFeature(null, "com.android.shell", null, intent5, mimeType, null, null, 0, r14, profilerInfo, r6, this.mUserId);
        intent4 = intent5;
        goto L98
    L87:
        options2 = options;
        goto L88
    L81:
        r5 = 1;
    L39:
        if (this.mProfileFile == null) goto L44;
        ParcelFileDescriptor fd = openFileForSystem(this.mProfileFile, "w");
        if (fd == null) goto L42;
        ParcelFileDescriptor fd2 = fd;
    L45:
        ProfilerInfo profilerInfo2 = new ProfilerInfo(this.mProfileFile, fd2, this.mSamplingInterval, this.mAutoStop, this.mStreaming, this.mAgent, this.mAttachAgentDuringBind, this.mClockType, this.mProfilerOutputVersion);
        profilerInfo = profilerInfo2;
        goto L46
    L42:
        return r10;
    L44:
        fd2 = null;
        goto L45
    L12:
        if (intent.getComponent() == null) goto L14;
        String packageName = intent.getComponent().getPackageName();
        intent2 = intent;
    L24:
        pw.println("Stopping: " + packageName);
        pw.flush();
        this.mInterface.forceStopPackage(packageName, this.mUserId);
        Thread.sleep(250);     // Catch: InterruptedException -> L27
        goto L33
    L14:
        int userIdForQuery = this.mInternal.mUserController.handleIncomingUser(Binder.getCallingPid(), Binder.getCallingUid(), this.mUserId, false, 0, "ActivityManagerShellCommand", null);
        intent2 = intent;
        String mimeType2 = mimeType;
        mimeType = mimeType2;
        List<ResolveInfo> activities = this.mPm.queryIntentActivities(intent2, mimeType2, 0, userIdForQuery).getList();
        if (activities == null) goto L29;
        if (activities.size() <= 0) goto L29;
        if (activities.size() > r10) goto L21;
        packageName = activities.get(0).activityInfo.packageName;
        goto L24
    L21:
        getErrPrintWriter().println("Error: Intent matches multiple activities; can't stop: " + intent2);
        return r10;
    L29:
        getErrPrintWriter().println("Error: Intent does not match any activities: " + intent2);
        return r10;
    L146:
        e = move-exception;
        throw new RuntimeException(e.getMessage(), e);
    }

    int runStartService(PrintWriter pw, boolean asForeground) throws RemoteException {
        PrintWriter err = getErrPrintWriter();
        Intent intent = makeIntent(-2);     // Catch: URISyntaxException -> L26
        if (this.mUserId != (-1)) goto L8;
        err.println("Error: Can't start activity with user 'all'");
        return -1;
    L8:
        pw.println("Starting service: " + intent);
        pw.flush();
        intent.collectExtraIntentKeys();
        ComponentName cn = this.mInterface.startService(null, intent, intent.getType(), asForeground, "com.android.shell", null, this.mUserId);
        if (cn != null) goto L13;
        err.println("Error: Not found; no service started.");
        return -1;
    L13:
        if (cn.getPackageName().equals("!") == false) goto L17;
        err.println("Error: Requires permission " + cn.getClassName());
        return -1;
    L17:
        if (cn.getPackageName().equals("!!") == false) goto L21;
        err.println("Error: " + cn.getClassName());
        return -1;
    L21:
        if (cn.getPackageName().equals("?") == false) goto L24;
        err.println("Error: " + cn.getClassName());
        return -1;
    L24:
        return 0;
    L26:
        e = move-exception;
        throw new RuntimeException(e.getMessage(), e);
    }

    int runStopService(PrintWriter pw) throws RemoteException {
        PrintWriter err = getErrPrintWriter();
        Intent intent = makeIntent(-2);     // Catch: URISyntaxException -> L21
        if (this.mUserId != (-1)) goto L8;
        err.println("Error: Can't stop activity with user 'all'");
        return -1;
    L8:
        pw.println("Stopping service: " + intent);
        pw.flush();
        intent.collectExtraIntentKeys();
        int result = this.mInterface.stopService(null, intent, intent.getType(), this.mUserId);
        if (result != 0) goto L13;
        err.println("Service not stopped: was not running.");
        return -1;
    L13:
        if (result != 1) goto L16;
        err.println("Service stopped");
        return -1;
    L16:
        if (result != (-1)) goto L19;
        err.println("Error stopping service");
        return -1;
    L19:
        return 0;
    L21:
        e = move-exception;
        throw new RuntimeException(e.getMessage(), e);
    }

    int runSendBroadcast(PrintWriter pw) throws RemoteException {
        PrintWriter pw2 = new PrintWriter(new TeeWriter(new Writer[]{ActivityManagerDebugConfig.LOG_WRITER_INFO, pw}));
        Intent intent = makeIntent(-2);     // Catch: URISyntaxException -> L18
        intent.addFlags(4194304);
        IntentReceiver receiver = new IntentReceiver(pw2);
        Bundle r3 = null;
        if (this.mReceiverPermission != null) goto L7;
        String[] requiredPermissions = null;
    L8:
        pw2.println("Broadcasting: " + intent);
        pw2.flush();
        if (this.mBroadcastOptions != null) goto L11;
    L10:
        Bundle bundle = r3;
        int result = this.mInterface.broadcastIntentWithFeature(null, null, intent, null, receiver, 0, null, null, requiredPermissions, null, null, -1, bundle, true, false, this.mUserId);
        Slogf.i(TAG, "Enqueued broadcast %s: " + result, new Object[]{intent});
        if (result == 0) goto L15;
    L17:
        return 0;
    L15:
        if (this.mAsync == true) goto L17;
        Slog.i(TAG, "am broadcast " + intent.getAction() + " from " + Binder.getCallingPid());
        receiver.waitForFinish();
        goto L17
    L11:
        r3 = this.mBroadcastOptions.toBundle();
        goto L10
    L7:
        requiredPermissions = new String[]{this.mReceiverPermission};
    L18:
        e = move-exception;
        throw new RuntimeException(e.getMessage(), e);
    }

    int runTraceIpc(PrintWriter pw) throws RemoteException {
        String op = getNextArgRequired();
        if (op.equals(IMediaProjectionManagerServiceExt.NODE_START) == false) goto L7;
        return runTraceIpcStart(pw);
    L7:
        if (op.equals(IMediaProjectionManagerServiceExt.NODE_STOP) == true) goto L9;
        getErrPrintWriter().println("Error: unknown trace ipc command '" + op + "'");
        return -1;
    L9:
        return runTraceIpcStop(pw);
    }

    int runTraceIpcStart(PrintWriter pw) throws RemoteException {
        pw.println("Starting IPC tracing.");
        pw.flush();
        this.mInterface.startBinderTracking();
        return 0;
    }

    int runTraceIpcStop(PrintWriter pw) throws RemoteException {
        PrintWriter err = getErrPrintWriter();
        String filename = null;
    L3:
        String opt = getNextOption();
        if (opt == null) goto L10;
        if (opt.equals("--dump-file") == false) goto L8;
        filename = getNextArgRequired();
        goto L3
    L8:
        err.println("Error: Unknown option: " + opt);
        return -1;
    L10:
        if (filename != null) goto L13;
        err.println("Error: Specify filename to dump logs to.");
        return -1;
    L13:
        ParcelFileDescriptor fd = openFileForSystem(filename, "w");
        if (fd != null) goto L17;
        return -1;
    L17:
        if (this.mInterface.stopBinderTrackingAndDump(fd) == true) goto L20;
        err.println("STOP TRACE FAILED.");
        return -1;
    L20:
        pw.println("Stopped IPC tracing. Dumping logs to: " + filename);
        return 0;
    }

    private int runTraceTimer(PrintWriter pw) throws RemoteException {
        if (AnrTimer.traceFeatureEnabled() == true) goto L15;
        return -1;
    L15:
        String result = AnrTimer.traceTimers(peekRemainingArgs());     // Catch: IllegalArgumentException -> L9
        if (result == null) goto L11;
        pw.println(result);     // Catch: IllegalArgumentException -> L9
        return 0;
    L11:
        return 0;
    L9:
        e = move-exception;
        getErrPrintWriter().println("Error: bad trace-timer command: " + e);
        return -1;
    }

    private int runProfile(PrintWriter pw) throws RemoteException {
        PrintWriter err = getErrPrintWriter();
        int userId = -2;
        int profileType = 0;
        this.mSamplingInterval = 0;
        this.mStreaming = false;
        this.mClockType = 0;
        this.mProfilerOutputVersion = 1;
        String cmd = getNextArgRequired();
        if (IMediaProjectionManagerServiceExt.NODE_START.equals(cmd) == false) goto L26;
    L5:
        String opt = getNextOption();
        if (opt == null) goto L24;
        if (opt.equals("--user") == true) goto L9;
        if (opt.equals("--clock-type") == true) goto L12;
        if (opt.equals(PROFILER_OUTPUT_VERSION_FLAG) == true) goto L15;
        if (opt.equals("--streaming") == true) goto L18;
        if (opt.equals("--sampling") == false) goto L22;
        this.mSamplingInterval = Integer.parseInt(getNextArgRequired());
        goto L5
    L22:
        err.println("Error: Unknown option: " + opt);
        return -1;
    L18:
        this.mStreaming = true;
        goto L5
    L15:
        this.mProfilerOutputVersion = Integer.parseInt(getNextArgRequired());
        goto L5
    L12:
        String clock_type = getNextArgRequired();
        this.mClockType = ProfilerInfo.getClockTypeFromString(clock_type);
        goto L5
    L9:
        userId = UserHandle.parseUserArg(getNextArgRequired());
        goto L5
    L24:
        String process = getNextArgRequired();
        boolean start = true;
        String process2 = process;
    L52:
        if (userId != (-1)) goto L56;
        err.println("Error: Can't profile with user 'all'");
        return -1;
    L56:
        if (start == false) goto L58;
        if (profileType != 0) goto L58;
    L62:
        String profileFile = getNextArgRequired();
        ParcelFileDescriptor fd = openFileForSystem(profileFile, "w");
        if (fd != null) goto L65;
        return -1;
    L65:
        ProfilerInfo profilerInfo = new ProfilerInfo(profileFile, fd, this.mSamplingInterval, false, this.mStreaming, null, false, this.mClockType, this.mProfilerOutputVersion);
    L67:
        String process3 = process2;
        if (this.mInterface.profileControl(process2, userId, start, profilerInfo, profileType) == true) goto L71;
        err.println("PROFILE FAILED on process " + process3);
        return -1;
    L71:
        return 0;
    L58:
        if (profileType != 1) goto L66;
        if (start == true) goto L66;
        if (getRemainingArgsCount() > 0) goto L62;
    L66:
        profilerInfo = null;
        goto L67
    L26:
        if (IMediaProjectionManagerServiceExt.NODE_STOP.equals(cmd) == false) goto L36;
    L27:
        String opt2 = getNextOption();
        if (opt2 == null) goto L34;
        if (opt2.equals("--user") == false) goto L32;
        userId = UserHandle.parseUserArg(getNextArgRequired());
        goto L27
    L32:
        err.println("Error: Unknown option: " + opt2);
        return -1;
    L34:
        String process4 = getNextArgRequired();
        start = false;
        process2 = process4;
        goto L52
    L36:
        if ("lowoverhead".equals(cmd) == false) goto L46;
        profileType = 1;
        String cmd2 = getNextArgRequired();
        if (IMediaProjectionManagerServiceExt.NODE_START.equals(cmd2) == false) goto L41;
        boolean start2 = true;
    L43:
        String process5 = getNextArgRequired();
        start = start2;
        process2 = process5;
        goto L52
    L41:
        if (IMediaProjectionManagerServiceExt.NODE_STOP.equals(cmd2) == false) goto L45;
        start2 = false;
        goto L43
    L45:
        throw new IllegalArgumentException("Profile command not valid");
    L46:
        String cmd3 = getNextArgRequired();
        if (IMediaProjectionManagerServiceExt.NODE_START.equals(cmd3) == false) goto L50;
        start = true;
        process2 = cmd;
        goto L52
    L50:
        if (IMediaProjectionManagerServiceExt.NODE_STOP.equals(cmd3) == false) goto L73;
        start = false;
        process2 = cmd;
        goto L52
    L73:
        throw new IllegalArgumentException("Profile command " + cmd + " not valid");
    }

    @NeverCompile
    int runCompact(PrintWriter pw) throws RemoteException {
        String op = getNextArgRequired();
        boolean isFullCompact = op.equals("full");
        boolean isSomeCompact = op.equals("some");
        if (isFullCompact == true) goto L33;
        if (isSomeCompact == true) goto L33;
        if (op.equals("system") == false) goto L18;
        pw.println("Executing system compaction");
        ActivityManagerGlobalLock r4 = this.mInternal.mProcLock;
        ActivityManagerService.boostPriorityForProcLockedSection();
        monitor-enter(r4);
        this.mInternal.mOomAdjuster.mCachedAppOptimizer.compactAllSystem();     // Catch: Throwable -> L13
        monitor-exit(r4);     // Catch: Throwable -> L13
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        pw.println("Finished system compaction");
        return 0;
    L13:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        throw th;
    L18:
        if (op.equals("native") == false) goto L31;
        String op2 = getNextArgRequired();
        boolean isFullCompact2 = op2.equals("full");
        boolean isSomeCompact2 = op2.equals("some");
        String pidStr = getNextArgRequired();
        int pid = Integer.parseInt(pidStr);     // Catch: Exception -> L28
        if (isFullCompact2 == false) goto L23;
        this.mInternal.mOomAdjuster.mCachedAppOptimizer.compactNative(CachedAppOptimizer.CompactProfile.FULL, pid);
        return 0;
    L23:
        if (isSomeCompact2 == false) goto L26;
        this.mInternal.mOomAdjuster.mCachedAppOptimizer.compactNative(CachedAppOptimizer.CompactProfile.SOME, pid);
        return 0;
    L26:
        getErrPrintWriter().println("Error: unknown compaction type '" + op2 + "'");
        return -1;
    L29:
        getErrPrintWriter().println("Error: failed to parse '" + pidStr + "' as a PID");
        return -1;
    L31:
        getErrPrintWriter().println("Error: unknown compact command '" + op + "'");
        return -1;
    L33:
        ProcessRecord app = getProcessFromShell();
        if (app != null) goto L37;
        getErrPrintWriter().println("Error: could not find process");
        return -1;
    L37:
        pw.println("Process record found pid: " + app.mPid);
        if (isFullCompact == false) goto L48;
        pw.println("Executing full compaction for " + app.mPid);
        ActivityManagerGlobalLock r5 = this.mInternal.mProcLock;
        ActivityManagerService.boostPriorityForProcLockedSection();
        monitor-enter(r5);
        this.mInternal.mOomAdjuster.mCachedAppOptimizer.compactApp(app, CachedAppOptimizer.CompactProfile.FULL, CachedAppOptimizer.CompactSource.SHELL, true);     // Catch: Throwable -> L44
        monitor-exit(r5);     // Catch: Throwable -> L44
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        pw.println("Finished full compaction for " + app.mPid);
        return 0;
    L44:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        throw th;
    L48:
        if (isSomeCompact == false) goto L69;
        pw.println("Executing some compaction for " + app.mPid);
        ActivityManagerGlobalLock r6 = this.mInternal.mProcLock;
        ActivityManagerService.boostPriorityForProcLockedSection();
        monitor-enter(r6);
        this.mInternal.mOomAdjuster.mCachedAppOptimizer.compactApp(app, CachedAppOptimizer.CompactProfile.SOME, CachedAppOptimizer.CompactSource.SHELL, true);     // Catch: Throwable -> L54
        monitor-exit(r6);     // Catch: Throwable -> L54
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        pw.println("Finished some compaction for " + app.mPid);
        return 0;
    L54:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        throw th;
    L69:
        return 0;
    }

    @NeverCompile
    int runFreeze(PrintWriter pw, boolean freeze) throws RemoteException {
        String freezerOpt = getNextOption();
        boolean isSticky = false;
        if (freezerOpt == null) goto L5;
        isSticky = freezerOpt.equals("--sticky");
    L5:
        ProcessRecord proc = getProcessFromShell();
        if (proc != null) goto L9;
        return -1;
    L9:
        if (freeze == false) goto L11;
        String r3 = "Freezing";
    L12:
        pw.print(r3);
        pw.print(" process " + proc.processName);
        pw.println(" (" + proc.mPid + ") sticky=" + isSticky);
        ActivityManagerService r4 = this.mInternal;
        ActivityManagerService.boostPriorityForLockedSection();
        monitor-enter(r4);
        ActivityManagerGlobalLock r5 = this.mInternal.mProcLock;     // Catch: Throwable -> L27
        ActivityManagerService.boostPriorityForProcLockedSection();     // Catch: Throwable -> L27
        monitor-enter(r5);     // Catch: Throwable -> L27
        proc.mOptRecord.setFreezeSticky(isSticky);     // Catch: Throwable -> L19
        if (freeze == false) goto L21;
        this.mInternal.mOomAdjuster.mCachedAppOptimizer.forceFreezeAppAsyncLSP(proc);     // Catch: Throwable -> L19
    L22:
        monitor-exit(r5);     // Catch: Throwable -> L19
        ActivityManagerService.resetPriorityAfterProcLockedSection();     // Catch: Throwable -> L27
        monitor-exit(r4);     // Catch: Throwable -> L27
        ActivityManagerService.resetPriorityAfterLockedSection();
        return 0;
    L21:
        this.mInternal.mOomAdjuster.mCachedAppOptimizer.unfreezeAppLSP(proc, 0, true);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterProcLockedSection();     // Catch: Throwable -> L27
        throw th;     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterLockedSection();
        throw th;
    L11:
        r3 = "Unfreezing";
        goto L12
    }

    @NeverCompile
    ProcessRecord getProcessFromShell() throws RemoteException {
        ProcessRecord proc = null;
        String process = getNextArgRequired();
        int pid = Integer.parseInt(process);     // Catch: NumberFormatException -> L11
        ActivityManagerService.PidMap r3 = this.mInternal.mPidsSelfLocked;     // Catch: NumberFormatException -> L11
        monitor-enter(r3);     // Catch: NumberFormatException -> L11
        proc = this.mInternal.mPidsSelfLocked.get(pid);     // Catch: Throwable -> L8
        monitor-exit(r3);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;     // Catch: NumberFormatException -> L11
    L12:
        if (proc != null) goto L39;
        ActivityManagerGlobalLock r2 = this.mInternal.mProcLock;
        ActivityManagerService.boostPriorityForProcLockedSection();
        monitor-enter(r2);
        ArrayMap<String, SparseArray<ProcessRecord>> all = this.mInternal.mProcessList.getProcessNamesLOSP().getMap();     // Catch: Throwable -> L26
        SparseArray<ProcessRecord> procs = all.get(process);     // Catch: Throwable -> L26
        if (procs == null) goto L32;
        if (procs.size() == 0) goto L32;
        if (procs.size() <= 1) goto L29;
        getErrPrintWriter().println("Error: more than one processes found");     // Catch: Throwable -> L26
        monitor-exit(r2);     // Catch: Throwable -> L26
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        return null;
    L29:
        proc = procs.valueAt(0);     // Catch: Throwable -> L26
        monitor-exit(r2);     // Catch: Throwable -> L26
        ActivityManagerService.resetPriorityAfterProcLockedSection();
    L32:
        getErrPrintWriter().println("Error: could not find process");     // Catch: Throwable -> L26
        monitor-exit(r2);     // Catch: Throwable -> L26
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        return null;
    L26:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        throw th;
    L39:
        return proc;
    }

    int runDumpHeap(PrintWriter pw) throws RemoteException {
        PrintWriter err = getErrPrintWriter();
        boolean managed = true;
        boolean mallocInfo = false;
        String dumpBitmaps = null;
        int userId = -2;
        boolean runGc = false;
    L3:
        String opt = getNextOption();
        if (opt == null) goto L27;
        if (opt.equals("--user") == true) goto L7;
        if (opt.equals("-n") == true) goto L13;
        if (opt.equals("-g") == true) goto L16;
        if (opt.equals("-m") == true) goto L19;
        if (opt.equals("-b") == false) goto L25;
        dumpBitmaps = getNextArg();
        if (dumpBitmaps != null) goto L3;
        dumpBitmaps = "png";
        goto L3
    L25:
        err.println("Error: Unknown option: " + opt);
        return -1;
    L19:
        managed = false;
        mallocInfo = true;
        goto L3
    L16:
        runGc = true;
        goto L3
    L13:
        managed = false;
        goto L3
    L7:
        userId = UserHandle.parseUserArg(getNextArgRequired());
        if (userId != (-1)) goto L3;
        err.println("Error: Can't dump heap with user 'all'");
        return -1;
    L27:
        String process = getNextArgRequired();
        String heapFile = getNextArg();
        if (heapFile != null) goto L30;
        LocalDateTime localDateTime = LocalDateTime.now(Clock.systemDefaultZone());
        String logNameTimeString = LOG_NAME_TIME_FORMATTER.format(localDateTime);
        String heapFile2 = "/data/local/tmp/heapdump-" + logNameTimeString + ".prof";
    L31:
        String argAfterHeapFile = getNextArg();
        if (argAfterHeapFile == null) goto L35;
        err.println("Error: Arguments cannot be placed after the heap file");
        return -1;
    L35:
        ParcelFileDescriptor fd = openFileForSystem(heapFile2, "w");
        if (fd != null) goto L38;
        return -1;
    L38:
        pw.println("File: " + heapFile2);
        pw.flush();
        final CountDownLatch latch = new CountDownLatch(1);
        RemoteCallback finishCallback = new RemoteCallback(new AnonymousClass2(this, latch), null);
        if (this.mInterface.dumpHeap(process, userId, managed, mallocInfo, runGc, dumpBitmaps, heapFile2, fd, finishCallback) == true) goto L42;
        err.println("HEAP DUMP FAILED on process " + process);
        return -1;
    L42:
        pw.println("Waiting for dump to finish...");
        pw.flush();
        latch.await();     // Catch: InterruptedException -> L45
        return 0;
    L46:
        err.println("Caught InterruptedException");
        return 0;
    L30:
        heapFile2 = heapFile;
        goto L31
    }

    int runSetDebugApp(PrintWriter pw) throws RemoteException {
        boolean wait = false;
        boolean persistent = false;
    L3:
        String opt = getNextOption();
        if (opt == null) goto L13;
        if (opt.equals("-w") == true) goto L7;
        if (opt.equals("--persistent") == false) goto L11;
        persistent = true;
        goto L3
    L11:
        getErrPrintWriter().println("Error: Unknown option: " + opt);
        return -1;
    L7:
        wait = true;
        goto L3
    L13:
        String pkg = getNextArgRequired();
        this.mInterface.setDebugApp(pkg, wait, persistent);
        return 0;
    }

    int runSetAgentApp(PrintWriter pw) throws RemoteException {
        String pkg = getNextArgRequired();
        String agent = getNextArg();
        this.mInterface.setAgentApp(pkg, agent);
        return 0;
    }

    int runClearDebugApp(PrintWriter pw) throws RemoteException {
        this.mInterface.setDebugApp(null, false, true);
        return 0;
    }

    int runSetWatchHeap(PrintWriter pw) throws RemoteException {
        String proc = getNextArgRequired();
        String limit = getNextArgRequired();
        this.mInterface.setDumpHeapDebugLimit(proc, 0, Long.parseLong(limit), null);
        return 0;
    }

    int runClearWatchHeap(PrintWriter pw) throws RemoteException {
        String proc = getNextArgRequired();
        this.mInterface.setDumpHeapDebugLimit(proc, 0, -1, null);
        return 0;
    }

    int runClearStartInfo(PrintWriter pw) throws RemoteException {
        this.mInternal.enforceCallingPermission("android.permission.WRITE_SECURE_SETTINGS", "runClearStartInfo()");
        int userId = -2;
    L3:
        String opt = getNextOption();
        if (opt == null) goto L11;
        if (opt.equals("--user") == false) goto L8;
        userId = UserHandle.parseUserArg(getNextArgRequired());
        goto L3
    L8:
        getErrPrintWriter().println("Error: Unknown option: " + opt);
        return -1;
    L11:
        if (userId != (-2)) goto L16;
        UserInfo user = this.mInterface.getCurrentUser();
        if (user != null) goto L15;
        return -1;
    L15:
        userId = user.id;
    L16:
        this.mInternal.mProcessList.getAppStartInfoTracker().clearHistoryProcessStartInfo(getNextArg(), userId);
        return 0;
    }

    int runStartInfoDetailedMonitoring(PrintWriter pw) throws RemoteException {
        int userId = -2;
    L3:
        String opt = getNextOption();
        if (opt == null) goto L11;
        if (opt.equals("--user") == false) goto L8;
        userId = UserHandle.parseUserArg(getNextArgRequired());
        goto L3
    L8:
        getErrPrintWriter().println("Error: Unknown option: " + opt);
        return -1;
    L11:
        if (userId != (-2)) goto L16;
        UserInfo user = this.mInterface.getCurrentUser();
        if (user != null) goto L15;
        return -1;
    L15:
        userId = user.id;
    L16:
        this.mInternal.mProcessList.getAppStartInfoTracker().configureDetailedMonitoring(pw, getNextArg(), userId);
        return 0;
    }

    int runClearExitInfo(PrintWriter pw) throws RemoteException {
        this.mInternal.enforceCallingPermission("android.permission.WRITE_SECURE_SETTINGS", "runClearExitInfo()");
        int userId = -2;
    L3:
        String opt = getNextOption();
        if (opt == null) goto L11;
        if (opt.equals("--user") == false) goto L8;
        userId = UserHandle.parseUserArg(getNextArgRequired());
        goto L3
    L8:
        getErrPrintWriter().println("Error: Unknown option: " + opt);
        return -1;
    L11:
        if (userId != (-2)) goto L16;
        UserInfo user = this.mInterface.getCurrentUser();
        if (user != null) goto L15;
        return -1;
    L15:
        userId = user.id;
    L16:
        this.mInternal.mProcessList.mAppExitInfoTracker.clearHistoryProcessExitInfo(getNextArg(), userId);
        return 0;
    }

    int runBugReport(PrintWriter pw) throws RemoteException {
        boolean fullBugreport = true;
    L3:
        String opt = getNextOption();
        if (opt == null) goto L13;
        if (opt.equals("--progress") == true) goto L7;
        if (opt.equals("--telephony") == false) goto L11;
        fullBugreport = false;
        this.mInterface.requestTelephonyBugReport("", "");
        goto L3
    L11:
        getErrPrintWriter().println("Error: Unknown option: " + opt);
        return -1;
    L7:
        fullBugreport = false;
        this.mInterface.requestInteractiveBugReport();
        goto L3
    L13:
        if (fullBugreport == false) goto L15;
        this.mInterface.requestFullBugReport();
    L15:
        pw.println("Your lovely bug report is being created; please be patient.");
        return 0;
    }

    int runForceStop(PrintWriter pw) throws RemoteException {
        int userId = -1;
    L3:
        String opt = getNextOption();
        if (opt == null) goto L10;
        if (opt.equals("--user") == false) goto L8;
        userId = UserHandle.parseUserArg(getNextArgRequired());
        goto L3
    L8:
        getErrPrintWriter().println("Error: Unknown option: " + opt);
        return -1;
    L10:
        this.mInterface.forceStopPackage(getNextArgRequired(), userId);
        return 0;
    }

    int runStopApp(PrintWriter pw) throws RemoteException {
        int userId = 0;
    L3:
        String opt = getNextOption();
        if (opt == null) goto L10;
        if (opt.equals("--user") == false) goto L8;
        userId = UserHandle.parseUserArg(getNextArgRequired());
        goto L3
    L8:
        getErrPrintWriter().println("Error: Unknown option: " + opt);
        return -1;
    L10:
        this.mInterface.stopAppForUser(getNextArgRequired(), userId);
        return 0;
    }

    int runClearRecentApps(PrintWriter pw) throws RemoteException {
        this.mTaskInterface.removeAllVisibleRecentTasks();
        return 0;
    }

    int runFgsNotificationRateLimit(PrintWriter pw) throws RemoteException {
        String toggleValue = getNextArgRequired();
        switch(toggleValue.hashCode()) {
            case -1298848381: goto L9;
            case 1671308008: goto L6;
            default: goto L11;
        };
    L11:
        byte r1 = -1;
    L12:
        switch(r1) {
            case 0: goto L16;
            case 1: goto L15;
            default: goto L14;
        };
    L15:
        boolean enable = false;
    L17:
        this.mInterface.enableFgsNotificationRateLimit(enable);
        return 0;
    L16:
        enable = true;
        goto L17
    L14:
        throw new IllegalArgumentException("Argument must be either 'enable' or 'disable'");
    L6:
        if (toggleValue.equals("disable") == false) goto L11;
        r1 = 1;
        goto L12
    L9:
        if (toggleValue.equals("enable") == false) goto L11;
        r1 = 0;
        goto L12
    }

    int runCrash(PrintWriter pw) throws RemoteException {
        int userId = -1;
    L3:
        String opt = getNextOption();
        if (opt == null) goto L10;
        if (opt.equals("--user") == false) goto L8;
        userId = UserHandle.parseUserArg(getNextArgRequired());
        goto L3
    L8:
        getErrPrintWriter().println("Error: Unknown option: " + opt);
        return -1;
    L10:
        String arg = getNextArgRequired();
        int pid = Integer.parseInt(arg);     // Catch: NumberFormatException -> L13
        int pid2 = pid;
        String packageName = null;
    L16:
        if (userId != (-1)) goto L18;
        int[] userIds = this.mInternal.mUserController.getUserIds();
    L19:
        int r5 = userIds.length;
        int r6 = 0;
    L20:
        if (r6 >= r5) goto L26;
        int id = userIds[r6];
        if (this.mInternal.mUserController.hasUserRestriction("no_debugging_features", id) == false) goto L24;
        getOutPrintWriter().println("Shell does not have permission to crash packages for user " + id);
    L25:
        r6 = r6 + 1;
        goto L20
    L24:
        this.mInterface.crashApplicationWithType(-1, pid2, packageName, id, "shell-induced crash", false, 5);
        goto L25
    L26:
        return 0;
    L18:
        userIds = new int[]{userId};
    L14:
        pid2 = -1;
        packageName = arg;
        goto L16
    }

    int runKill(PrintWriter pw) throws RemoteException {
        int userId = -1;
    L3:
        String opt = getNextOption();
        if (opt == null) goto L10;
        if (opt.equals("--user") == false) goto L8;
        userId = UserHandle.parseUserArg(getNextArgRequired());
        goto L3
    L8:
        getErrPrintWriter().println("Error: Unknown option: " + opt);
        return -1;
    L10:
        this.mInterface.killBackgroundProcesses(getNextArgRequired(), userId);
        return 0;
    }

    int runKillAll(PrintWriter pw) throws RemoteException {
        this.mInterface.killAllBackgroundProcesses();
        return 0;
    }

    int runMakeIdle(PrintWriter pw) throws RemoteException {
        int userId = -1;
    L3:
        String opt = getNextOption();
        if (opt == null) goto L10;
        if (opt.equals("--user") == false) goto L8;
        userId = UserHandle.parseUserArg(getNextArgRequired());
        goto L3
    L8:
        getErrPrintWriter().println("Error: Unknown option: " + opt);
        return -1;
    L10:
        this.mInterface.makePackageIdle(getNextArgRequired(), userId);
        return 0;
    }

    int runSetDeterministicUidIdle(PrintWriter pw) throws RemoteException {
    L3:
        String opt = getNextOption();
        if (opt == null) goto L10;
        if (opt.equals("--user") == false) goto L8;
        UserHandle.parseUserArg(getNextArgRequired());
        goto L3
    L8:
        getErrPrintWriter().println("Error: Unknown option: " + opt);
        return -1;
    L10:
        boolean deterministic = Boolean.parseBoolean(getNextArgRequired());
        this.mInterface.setDeterministicUidIdle(deterministic);
        return 0;
    }

    int runMonitor(PrintWriter pw) throws RemoteException {
        String gdbPort = null;
        boolean monkey = false;
        boolean simpleMode = false;
        boolean alwaysContinue = false;
        boolean alwaysKill = false;
        String target = null;
    L3:
        String opt = getNextOption();
        if (opt == null) goto L25;
        if (opt.equals("--gdb") == true) goto L7;
        if (opt.equals("-p") == true) goto L10;
        if (opt.equals("-m") == true) goto L13;
        if (opt.equals("-s") == true) goto L16;
        if (opt.equals("-c") == true) goto L19;
        if (opt.equals("-k") == false) goto L23;
        alwaysKill = true;
        goto L3
    L23:
        getErrPrintWriter().println("Error: Unknown option: " + opt);
        return -1;
    L19:
        alwaysContinue = true;
        goto L3
    L16:
        simpleMode = true;
        goto L3
    L13:
        monkey = true;
        goto L3
    L10:
        target = getNextArgRequired();
        goto L3
    L7:
        gdbPort = getNextArgRequired();
        goto L3
    L25:
        if (alwaysContinue == false) goto L29;
        if (alwaysKill == false) goto L29;
        getErrPrintWriter().println("Error: -k and -c options can't be used together.");
        return -1;
    L29:
        MyActivityController controller = new MyActivityController(this.mInterface, pw, getRawInputStream(), gdbPort, monkey, simpleMode, target, alwaysContinue, alwaysKill);
        controller.run();
        return 0;
    }

    int runWatchUids(PrintWriter pw) throws RemoteException {
        int uid = -1;
        int mask = 15;
    L3:
        String opt = getNextOption();
        if (opt == null) goto L13;
        if (opt.equals("--oom") == true) goto L7;
        if (opt.equals("--mask") == false) goto L11;
        mask = Integer.parseInt(getNextArgRequired());
        goto L3
    L11:
        getErrPrintWriter().println("Error: Unknown option: " + opt);
        return -1;
    L7:
        uid = Integer.parseInt(getNextArgRequired());
        goto L3
    L13:
        MyUidObserver controller = new MyUidObserver(this.mInternal, pw, getRawInputStream(), uid, mask);
        controller.run();
        return 0;
    }

    int runHang(PrintWriter pw) throws RemoteException {
        boolean allowRestart = false;
    L3:
        String opt = getNextOption();
        if (opt == null) goto L10;
        if (opt.equals("--allow-restart") == false) goto L8;
        allowRestart = true;
        goto L3
    L8:
        getErrPrintWriter().println("Error: Unknown option: " + opt);
        return -1;
    L10:
        pw.println("Hanging the system...");
        pw.flush();
        this.mInterface.hang(getShellCallback().getShellCallbackBinder(), allowRestart);     // Catch: NullPointerException -> L14
        return 0;
    L15:
        pw.println("Hanging failed, since caller " + Binder.getCallingPid() + " did not provide a ShellCallback!");
        pw.flush();
        return 1;
    }

    int runRestart(PrintWriter pw) throws RemoteException {
        String opt = getNextOption();
        if (opt == null) goto L6;
        getErrPrintWriter().println("Error: Unknown option: " + opt);
        return -1;
    L6:
        pw.println("Restart the system...");
        pw.flush();
        this.mInterface.restart();
        return 0;
    }

    int runIdleMaintenance(PrintWriter pw) throws RemoteException {
        String opt = getNextOption();
        if (opt == null) goto L6;
        getErrPrintWriter().println("Error: Unknown option: " + opt);
        return -1;
    L6:
        pw.println("Performing idle maintenance...");
        this.mInterface.sendIdleJobTrigger();
        this.mInternal.performIdleMaintenance();
        return 0;
    }

    int runScreenCompat(PrintWriter pw) throws RemoteException {
        String mode = getNextArgRequired();
        if ("on".equals(mode) == false) goto L6;
        boolean enabled = true;
    L8:
        String packageName = getNextArgRequired();
    L22:
        IActivityManager r4 = this.mInterface;     // Catch: RemoteException -> L16
        if (enabled == false) goto L13;
        int r5 = 1;
    L14:
        r4.setPackageScreenCompatMode(packageName, r5);     // Catch: RemoteException -> L16
        goto L17
    L13:
        r5 = 0;
    L17:
        packageName = getNextArg();
        if (packageName != null) goto L22;
        return 0;
    L6:
        if ("off".equals(mode) == false) goto L20;
        enabled = false;
        goto L8
    L20:
        getErrPrintWriter().println("Error: enabled mode must be 'on' or 'off' at " + mode);
        return -1;
    }

    int runPackageImportance(PrintWriter pw) throws RemoteException {
        String packageName = getNextArgRequired();
        int procState = this.mInterface.getPackageProcessState(packageName, "com.android.shell");
        pw.println(ActivityManager.RunningAppProcessInfo.procStateToImportance(procState));
        return 0;
    }

    int runToUri(PrintWriter pw, int flags) throws RemoteException {
        Intent intent = makeIntent(-2);     // Catch: URISyntaxException -> L6
        pw.println(intent.toUri(flags));
        return 0;
    L6:
        e = move-exception;
        throw new RuntimeException(e.getMessage(), e);
    }

    private boolean switchUserAndWaitForComplete(final int userId) throws RemoteException {
        UserInfo currentUser = this.mInterface.getCurrentUser();
        if (currentUser != null) goto L5;
    L7:
        final CountDownLatch switchLatch = new CountDownLatch(1);
        UserSwitchObserver r1 = new AnonymousClass3(this, userId, switchLatch);
        this.mInterface.registerUserSwitchObserver(r1, ActivityManagerShellCommand.class.getName());     // Catch: Throwable -> L14
        boolean switched = this.mInterface.switchUser(userId);     // Catch: Throwable -> L14
        if (switched == true) goto L22;
        this.mInterface.unregisterUserSwitchObserver(r1);
        return false;
    L22:
        switched = switchLatch.await(120000, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L14 InterruptedException -> L16
    L18:
        this.mInterface.unregisterUserSwitchObserver(r1);
        return switched;
    L17:
        getErrPrintWriter().println("Error: Thread interrupted unexpectedly.");     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        this.mInterface.unregisterUserSwitchObserver(r1);
        throw th;
    L5:
        if (userId != currentUser.id) goto L7;
        return true;
    }

    int runSwitchUser(PrintWriter pw) throws RemoteException {
        boolean wait = false;
    L3:
        String opt = getNextOption();
        if (opt == null) goto L10;
        if ("-w".equals(opt) == false) goto L8;
        wait = true;
        goto L3
    L8:
        getErrPrintWriter().println("Error: unknown option: " + opt);
        return -1;
    L10:
        int userId = Integer.parseInt(getNextArgRequired());
        UserManager userManager = (UserManager) this.mInternal.mContext.getSystemService(UserManager.class);
        int userSwitchable = userManager.getUserSwitchability(UserHandle.of(userId));
        if (userSwitchable == 0) goto L14;
        getErrPrintWriter().println("Error: UserSwitchabilityResult=" + userSwitchable);
        return -1;
    L14:
        Trace.traceBegin(64, "shell_runSwitchUser");
        if (wait == false) goto L19;
        boolean switched = switchUserAndWaitForComplete(userId);     // Catch: Throwable -> L17
    L20:
        if (switched == false) goto L23;
        Trace.traceEnd(64);
        return 0;
    L23:
        pw.printf("Error: Failed to switch to user %d\n", new Object[]{Integer.valueOf(userId)});     // Catch: Throwable -> L17
        Trace.traceEnd(64);
        return 1;
    L19:
        switched = this.mInterface.switchUser(userId);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        Trace.traceEnd(64);
        throw th;
    }

    int runGetCurrentUser(PrintWriter pw) throws RemoteException {
        int userId = this.mInterface.getCurrentUserId();
        if (userId == (-10000)) goto L7;
        pw.println(userId);
        return 0;
    L7:
        throw new IllegalStateException("Current user not set");
    }

    /* JADX WARN: Multi-variable type inference failed */
    int runStartUser(PrintWriter r23) throws RemoteException {
        int r4 = -1;
        Object[] r3 = false;
    L3:
        String r0 = getNextOption();
        boolean r6 = true;
        char r7 = 1;
        if (r0 == null) goto L21;
        switch(r0.hashCode()) {
            case -1237221598: goto L12;
            case 1514: goto L9;
            default: goto L14;
        };
    L14:
        r7 = -1;
    L15:
        switch(r7) {
            case 0: goto L19;
            case 1: goto L18;
            default: goto L16;
        };
    L16:
        getErrPrintWriter().println("Error: unknown option: " + r0);
        return -1;
    L19:
        r3 = true;
        goto L3
    L18:
        r4 = getDisplayIdFromNextArg();
        goto L3
    L9:
        if (r0.equals("-w") == false) goto L66;
        r7 = 0;
        goto L15
    L66:
        r7 = -1;
        goto L15
    L12:
        if (r0.equals("--display") == true) goto L15;
        r7 = -1;
        goto L15
    L21:
        int r9 = Integer.parseInt(getNextArgRequired());
        IProgressListener r1 = null;
        if (r3 == false) goto L24;
        r1 = new ProgressWaiter(this, r9, r1);
    L24:
        IProgressListener r16 = r1;
        UserManagerInternal r10 = (UserManagerInternal) LocalServices.getService(UserManagerInternal.class);
        ActivityManagerInternal r17 = (ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class);
        int r11 = r10.getProfileParentId(r9);
        int r12 = r17.getCurrentUserId();
        if (r11 == r9) goto L27;
        boolean r2 = true;
    L28:
        boolean r18 = r2;
        if (r18 == false) goto L32;
        if (r11 != r12) goto L32;
    L33:
        Slogf.d(TAG, "runStartUser(): userId=%d, parentUserId=%d, currentUserId=%d, isProfile=%b, isVisibleProfile=%b, display=%d, waiter=%s", new Object[]{Integer.valueOf(r9), Integer.valueOf(r11), Integer.valueOf(r12), Boolean.valueOf(r18), Boolean.valueOf(r6), Integer.valueOf(r4), r16});
        String r13 = "";
        Trace.traceBegin(64, "shell_runStartUser" + r9);
        if (r6 == false) goto L38;
        Slogf.d(TAG, "calling startProfileWithListener(%d, %s)", new Object[]{Integer.valueOf(r9), r16});     // Catch: Throwable -> L36
        boolean r5 = this.mInterface.startProfileWithListener(r9, r16);     // Catch: Throwable -> L36
    L46:
        if (r3 == false) goto L50;
        if (r5 == false) goto L50;
        Slogf.d(TAG, "waiting %d ms", new Object[]{Integer.valueOf(USER_OPERATION_TIMEOUT_MS)});     // Catch: Throwable -> L36
        int r14 = 0;
        r5 = r16.waitForFinish(120000);     // Catch: Throwable -> L36
    L51:
        Trace.traceEnd(64);
        if (r5 == false) goto L54;
        r23.println("Success: user started" + r13);
    L55:
        return r14;
    L54:
        getErrPrintWriter().println("Error: could not start user" + r13);
    L50:
        r14 = 0;
        goto L51
    L38:
        if (r4 != (-1)) goto L41;
        Slogf.d(TAG, "calling startUserInBackgroundWithListener(%d)", new Object[]{Integer.valueOf(r9)});     // Catch: Throwable -> L36
        r5 = this.mInterface.startUserInBackgroundWithListener(r9, r16);     // Catch: Throwable -> L36
        goto L46
    L41:
        if (UserManager.isVisibleBackgroundUsersEnabled() == true) goto L45;
        r23.println("Not supported");     // Catch: Throwable -> L36
        Trace.traceEnd(64);
        return -1;
    L45:
        Slogf.d(TAG, "calling startUserInBackgroundVisibleOnDisplay(%d, %d, %s)", new Object[]{Integer.valueOf(r9), Integer.valueOf(r4), r16});     // Catch: Throwable -> L36
        r5 = this.mInterface.startUserInBackgroundVisibleOnDisplay(r9, r4, r16);     // Catch: Throwable -> L36
        r13 = " on display " + r4;     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        Trace.traceEnd(64);
        throw th;
    L32:
        r6 = false;
        goto L33
    L27:
        r2 = false;
        goto L28
    }

    int runUnlockUser(PrintWriter pw) throws RemoteException {
        int userId = Integer.parseInt(getNextArgRequired());
        String token = getNextArg();
        if (TextUtils.isEmpty(token) == false) goto L5;
    L8:
        String secret = getNextArg();
        if (TextUtils.isEmpty(secret) == false) goto L11;
    L14:
        boolean success = this.mInterface.unlockUser2(userId, null);
        if (success == false) goto L17;
        pw.println("Success: user unlocked");
        return 0;
    L17:
        getErrPrintWriter().println("Error: could not unlock user");
        return 0;
    L11:
        if ("!".equals(secret) == true) goto L14;
        getErrPrintWriter().println("Error: secret parameter not supported");
        return -1;
    L5:
        if ("!".equals(token) == true) goto L8;
        getErrPrintWriter().println("Error: token parameter not supported");
        return -1;
    }

    int runStopUser(PrintWriter pw) throws RemoteException {
        boolean wait = false;
        boolean force = false;
    L3:
        String opt = getNextOption();
        if (opt == null) goto L13;
        if ("-w".equals(opt) == true) goto L7;
        if ("-f".equals(opt) == false) goto L11;
        force = true;
        goto L3
    L11:
        getErrPrintWriter().println("Error: unknown option: " + opt);
        return -1;
    L7:
        wait = true;
        goto L3
    L13:
        int userId = Integer.parseInt(getNextArgRequired());
        IStopUserCallback r5 = null;
        if (wait == false) goto L16;
        r5 = new StopUserCallback(userId, r5);
    L16:
        Slogf.d(TAG, "Calling stopUser(%d, %b, %s)", new Object[]{Integer.valueOf(userId), Boolean.valueOf(force), r5});
        Trace.traceBegin(64, "shell_runStopUser-" + userId + "-[stopUser]");
        int res = this.mInterface.stopUserExceptCertainProfiles(userId, force, r5);     // Catch: Throwable -> L23
        if (res == 0) goto L31;
        String txt = "";
        switch(res) {
            case -4: goto L27;
            case -3: goto L26;
            case -2: goto L25;
            case -1: goto L22;
            default: goto L28;
        };     // Catch: Throwable -> L23
    L22:
        txt = " (Unknown user " + userId + ")";     // Catch: Throwable -> L23
        goto L28
    L25:
        txt = " (Can't stop current user)";
        goto L28
    L26:
        txt = " (System user cannot be stopped)";
        goto L28
    L27:
        txt = " (Can't stop user " + userId + " - one of its related users can't be stopped)";     // Catch: Throwable -> L23
    L28:
        getErrPrintWriter().println("Switch failed: " + res + txt);     // Catch: Throwable -> L23
        Trace.traceEnd(64);
        return -1;
    L31:
        if (r5 == null) goto L33;
        r5.waitForFinish();     // Catch: Throwable -> L23
    L33:
        Trace.traceEnd(64);
        return 0;
    L23:
        th = move-exception;
        Trace.traceEnd(64);
        throw th;
    }

    int runIsUserStopped(PrintWriter pw) {
        int userId = UserHandle.parseUserArg(getNextArgRequired());
        boolean stopped = this.mInternal.isUserStopped(userId);
        pw.println(stopped);
        return 0;
    }

    int runGetStartedUserState(PrintWriter pw) throws RemoteException {
        this.mInternal.enforceCallingPermission("android.permission.DUMP", "runGetStartedUserState()");
        int userId = Integer.parseInt(getNextArgRequired());
        pw.println(this.mInternal.getStartedUserState(userId));     // Catch: NullPointerException -> L5
        return 0;
    L6:
        pw.println("User is not started: " + userId);
        return 0;
    }

    int runTrackAssociations(PrintWriter pw) {
        this.mInternal.enforceCallingPermission("android.permission.SET_ACTIVITY_WATCHER", "runTrackAssociations()");
        ActivityManagerService r0 = this.mInternal;
        ActivityManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
    L7:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterLockedSection();
        throw th;
    L5:
        if (this.mInternal.mTrackingAssociations == true) goto L9;
        this.mInternal.mTrackingAssociations = true;     // Catch: Throwable -> L7
        pw.println("Association tracking started.");     // Catch: Throwable -> L7
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        ActivityManagerService.resetPriorityAfterLockedSection();
        return 0;
    L9:
        pw.println("Association tracking already enabled.");     // Catch: Throwable -> L7
        goto L10
    }

    int runUntrackAssociations(PrintWriter pw) {
        this.mInternal.enforceCallingPermission("android.permission.SET_ACTIVITY_WATCHER", "runUntrackAssociations()");
        ActivityManagerService r0 = this.mInternal;
        ActivityManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
    L7:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterLockedSection();
        throw th;
    L5:
        if (this.mInternal.mTrackingAssociations == false) goto L9;
        this.mInternal.mTrackingAssociations = false;     // Catch: Throwable -> L7
        this.mInternal.mAssociations.clear();     // Catch: Throwable -> L7
        pw.println("Association tracking stopped.");     // Catch: Throwable -> L7
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        ActivityManagerService.resetPriorityAfterLockedSection();
        return 0;
    L9:
        pw.println("Association tracking not running.");     // Catch: Throwable -> L7
        goto L10
    }

    int getUidState(PrintWriter pw) throws RemoteException {
        this.mInternal.enforceCallingPermission("android.permission.DUMP", "getUidState()");
        int state = this.mInternal.getUidState(Integer.parseInt(getNextArgRequired()));
        pw.print(state);
        pw.print(" (");
        pw.printf(DebugUtils.valueToString(ActivityManager.class, "PROCESS_STATE_", state), new Object[0]);
        pw.println(")");
        return 0;
    }

    private List<Configuration> getRecentConfigurations(int days) {
        IUsageStatsManager usm = IUsageStatsManager.Stub.asInterface(ServiceManager.getService("usagestats"));
        long now = System.currentTimeMillis();
        long nDaysAgo = now - ((long) ((((days * 24) * 60) * 60) * 1000));
        ParceledListSlice<ConfigurationStats> configStatsSlice = usm.queryConfigurationStats(4, nDaysAgo, now, "com.android.shell");     // Catch: RemoteException -> L7
        if (configStatsSlice == null) goto L6;
        final ArrayMap<Configuration, Integer> recentConfigs = new ArrayMap();     // Catch: RemoteException -> L7
        List<ConfigurationStats> configStatsList = configStatsSlice.getList();     // Catch: RemoteException -> L7
        int configStatsListSize = configStatsList.size();     // Catch: RemoteException -> L7
        int i = 0;
    L10:
        if (i >= configStatsListSize) goto L16;
        ConfigurationStats stats = configStatsList.get(i);     // Catch: RemoteException -> L7
        int indexOfKey = recentConfigs.indexOfKey(stats.getConfiguration());     // Catch: RemoteException -> L7
        if (indexOfKey >= 0) goto L14;
        recentConfigs.put(stats.getConfiguration(), Integer.valueOf(stats.getActivationCount()));     // Catch: RemoteException -> L7
    L15:
        i = i + 1;     // Catch: RemoteException -> L7
        goto L10
    L14:
        recentConfigs.setValueAt(indexOfKey, Integer.valueOf(recentConfigs.valueAt(indexOfKey).intValue() + stats.getActivationCount()));     // Catch: RemoteException -> L7
        goto L15
    L16:
        Comparator<Configuration> comparator = new AnonymousClass4(this, recentConfigs);     // Catch: RemoteException -> L7
        ArrayList<Configuration> configs = new ArrayList(recentConfigs.size());     // Catch: RemoteException -> L7
        configs.addAll(recentConfigs.keySet());     // Catch: RemoteException -> L7
        Collections.sort(configs, comparator);     // Catch: RemoteException -> L7
        return configs;
    L6:
        return Collections.emptyList();
    L19:
        return Collections.emptyList();
    }

    private static void addExtensionsForConfig(EGL10 egl, EGLDisplay display, EGLConfig config, int[] surfaceSize, int[] contextAttribs, Set<String> glExtensions) {
        EGLContext context = egl.eglCreateContext(display, config, EGL10.EGL_NO_CONTEXT, contextAttribs);
        if (context != EGL10.EGL_NO_CONTEXT) goto L5;
        return;
    L5:
        EGLSurface surface = egl.eglCreatePbufferSurface(display, config, surfaceSize);
        if (surface != EGL10.EGL_NO_SURFACE) goto L9;
        egl.eglDestroyContext(display, context);
        return;
    L9:
        egl.eglMakeCurrent(display, surface, surface, context);
        String extensionList = GLES10.glGetString(7939);
        if (TextUtils.isEmpty(extensionList) == true) goto L15;
        String[] r3 = extensionList.split(" ");
        int r4 = r3.length;
        int r5 = 0;
    L13:
        if (r5 >= r4) goto L15;
        String extension = r3[r5];
        glExtensions.add(extension);
        r5 = r5 + 1;
    L15:
        egl.eglMakeCurrent(display, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
        egl.eglDestroySurface(display, surface);
        egl.eglDestroyContext(display, context);
    }

    Set<String> getGlExtensionsFromDriver() {
        Set<String> glExtensions = new HashSet();
        EGL10 egl = (EGL10) EGLContext.getEGL();
        if (egl != null) goto L6;
        getErrPrintWriter().println("Warning: couldn't get EGL");
        return glExtensions;
    L6:
        EGLDisplay display = egl.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        int[] version = new int[2];
        egl.eglInitialize(display, version);
        int[] numConfigs = new int[1];
        if (egl.eglGetConfigs(display, null, 0, numConfigs) == true) goto L10;
        getErrPrintWriter().println("Warning: couldn't get EGL config count");
        return glExtensions;
    L10:
        EGLConfig[] configs = new EGLConfig[numConfigs[0]];
        if (egl.eglGetConfigs(display, configs, numConfigs[0], numConfigs) == true) goto L14;
        getErrPrintWriter().println("Warning: couldn't get EGL configs");
        return glExtensions;
    L14:
        int[] surfaceSize = {12375, 1, 12374, 1, 12344};
        int[] gles2 = {12440, 2, 12344};
        int[] attrib = new int[1];
        int i = 0;
    L16:
        if (i >= numConfigs[0]) goto L31;
        egl.eglGetConfigAttrib(display, configs[i], 12327, attrib);
        if (attrib[0] != 12368) goto L20;
        int[] gles3 = gles2;
    L30:
        i = i + 1;
        gles2 = gles3;
        goto L16
    L20:
        egl.eglGetConfigAttrib(display, configs[i], 12339, attrib);
        if ((attrib[0] & 1) != 0) goto L23;
        gles3 = gles2;
        goto L30
    L23:
        egl.eglGetConfigAttrib(display, configs[i], 12352, attrib);
        if ((attrib[0] & 1) == 0) goto L27;
        addExtensionsForConfig(egl, display, configs[i], surfaceSize, null, glExtensions);
    L27:
        if ((attrib[0] & 4) == 0) goto L29;
        gles3 = gles2;
        addExtensionsForConfig(egl, display, configs[i], surfaceSize, gles3, glExtensions);
        goto L30
    L29:
        gles3 = gles2;
        goto L30
    L31:
        egl.eglTerminate(display);
        return glExtensions;
    }

    private void writeDeviceConfig(ProtoOutputStream protoOutputStream, long fieldId, PrintWriter pw, Configuration config, DisplayMetrics displayMetrics) {
        long token = -1;
        if (protoOutputStream == null) goto L5;
        token = protoOutputStream.start(fieldId);
        protoOutputStream.write(1155346202625L, displayMetrics.widthPixels);
        protoOutputStream.write(1155346202626L, displayMetrics.heightPixels);
        protoOutputStream.write(1155346202627L, DisplayMetrics.DENSITY_DEVICE_STABLE);
    L5:
        if (pw == null) goto L7;
        pw.print("stable-width-px: ");
        pw.println(displayMetrics.widthPixels);
        pw.print("stable-height-px: ");
        pw.println(displayMetrics.heightPixels);
        pw.print("stable-density-dpi: ");
        pw.println(DisplayMetrics.DENSITY_DEVICE_STABLE);
    L7:
        MemInfoReader memreader = new MemInfoReader();
        memreader.readMemInfo();
        KeyguardManager kgm = (KeyguardManager) this.mInternal.mContext.getSystemService(KeyguardManager.class);
        if (protoOutputStream == null) goto L10;
        protoOutputStream.write(1116691496964L, memreader.getTotalSize());
        protoOutputStream.write(1133871366149L, ActivityManager.isLowRamDeviceStatic());
        protoOutputStream.write(1155346202630L, Runtime.getRuntime().availableProcessors());
        protoOutputStream.write(1133871366151L, kgm.isDeviceSecure());
    L10:
        if (pw == null) goto L56;
        pw.print("total-ram: ");
        pw.println(memreader.getTotalSize());
        pw.print("low-ram: ");
        pw.println(ActivityManager.isLowRamDeviceStatic());
        pw.print("max-cores: ");
        pw.println(Runtime.getRuntime().availableProcessors());
        pw.print("has-secure-screen-lock: ");
        pw.println(kgm.isDeviceSecure());
    L56:
        ConfigurationInfo configInfo = this.mTaskInterface.getDeviceConfigurationInfo();     // Catch: RemoteException -> L53
        if (configInfo.reqGlEsVersion == 0) goto L20;
        if (protoOutputStream == null) goto L18;
        protoOutputStream.write(1155346202632L, configInfo.reqGlEsVersion);
    L18:
        if (pw == null) goto L20;
        pw.print("opengl-version: 0x");
        pw.println(Integer.toHexString(configInfo.reqGlEsVersion));
    L20:
        Set<String> glExtensionsSet = getGlExtensionsFromDriver();
        String[] glExtensions = (String[]) glExtensionsSet.toArray(new String[glExtensionsSet.size()]);
        Arrays.sort(glExtensions);
        int i = 0;
    L22:
        if (i >= glExtensions.length) goto L28;
        if (protoOutputStream == null) goto L25;
        protoOutputStream.write(2237677961225L, glExtensions[i]);
    L25:
        if (pw == null) goto L27;
        pw.print("opengl-extensions: ");
        pw.println(glExtensions[i]);
    L27:
        i = i + 1;
        goto L22
    L28:
        PackageManager pm = this.mInternal.mContext.getPackageManager();
        List<SharedLibraryInfo> slibs = pm.getSharedLibraries(0);
        Collections.sort(slibs, Comparator.comparing(new ActivityManagerShellCommand$$ExternalSyntheticLambda0()));
        int i2 = 0;
    L30:
        if (i2 >= slibs.size()) goto L37;
        if (protoOutputStream == null) goto L34;
        protoOutputStream.write(2237677961226L, slibs.get(i2).getName());
    L34:
        if (pw == null) goto L36;
        pw.print("shared-libraries: ");
        pw.println(slibs.get(i2).getName());
    L36:
        i2 = i2 + 1;
        configInfo = configInfo;
        goto L30
    L37:
        FeatureInfo[] features = pm.getSystemAvailableFeatures();
        Arrays.sort(features, new ActivityManagerShellCommand$$ExternalSyntheticLambda1());
        int i3 = 0;
    L39:
        if (i3 >= features.length) goto L50;
        if (features[i3].name == null) goto L47;
        if (protoOutputStream == null) goto L45;
        protoOutputStream.write(2237677961227L, features[i3].name);
    L45:
        if (pw == null) goto L48;
        pw.print("features: ");
        pw.println(features[i3].name);
    L48:
        i3 = i3 + 1;
        features = features;
        goto L39
    L47:
        features = features;
        i3 = i3;
        goto L48
    L50:
        if (protoOutputStream == null) goto L68;
        protoOutputStream.end(token);
        return;
    L68:
        return;
    L53:
        e = move-exception;
        throw e.rethrowFromSystemServer();
    }

    private static /* synthetic */ int lambda$writeDeviceConfig$2(FeatureInfo o1, FeatureInfo o2) {
        if (o1.name != o2.name) goto L7;
        return 0;
    L7:
        if (o1.name != null) goto L11;
        return -1;
    L11:
        if (o2.name != null) goto L15;
        return 1;
    L15:
        return o1.name.compareTo(o2.name);
    }

    private int getDisplayIdFromNextArg() {
        int displayId = Integer.parseInt(getNextArgRequired());
        if (displayId < 0) goto L6;
        return displayId;
    L6:
        throw new IllegalArgumentException("--display must be a non-negative integer");
    }

    int runGetConfig(PrintWriter pw) throws RemoteException {
        int days = -1;
        int displayId = 0;
        boolean asProto = false;
        boolean inclDevice = false;
    L3:
        String opt = getNextOption();
        if (opt == null) goto L23;
        if (opt.equals("--days") == true) goto L7;
        if (opt.equals("--proto") == true) goto L14;
        if (opt.equals("--device") == true) goto L17;
        if (opt.equals("--display") == false) goto L21;
        displayId = getDisplayIdFromNextArg();
        goto L3
    L21:
        getErrPrintWriter().println("Error: Unknown option: " + opt);
        return -1;
    L17:
        inclDevice = true;
        goto L3
    L14:
        asProto = true;
        goto L3
    L7:
        days = Integer.parseInt(getNextArgRequired());
        if (days > 0) goto L3;
        throw new IllegalArgumentException("--days must be a positive integer");
    L23:
        Configuration config = this.mInterface.getConfiguration();
        if (config != null) goto L27;
        getErrPrintWriter().println("Activity manager has no configuration");
        return -1;
    L27:
        DisplayManager dm = (DisplayManager) this.mInternal.mContext.getSystemService(DisplayManager.class);
        Display display = dm.getDisplay(displayId);
        if (display != null) goto L31;
        getErrPrintWriter().println("Error: Display does not exist: " + displayId);
        return -1;
    L31:
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        if (asProto == false) goto L37;
        ProtoOutputStream proto = new ProtoOutputStream(getOutFileDescriptor());
        config.writeResConfigToProto(proto, 1146756268033L, metrics);
        if (inclDevice == false) goto L36;
        writeDeviceConfig(proto, 1146756268034L, null, config, metrics);
    L36:
        proto.flush();
        return 0;
    L37:
        pw.println("config: " + Configuration.resourceQualifierString(config, metrics));
        pw.println("abi: " + TextUtils.join(",", Build.SUPPORTED_ABIS));
        if (inclDevice == false) goto L40;
        ActivityManagerShellCommand r0 = this;
        PrintWriter r4 = pw;
        r0.writeDeviceConfig(null, -1, r4, config, metrics);
    L41:
        if (days < 0) goto L64;
        List<Configuration> recentConfigs = r0.getRecentConfigurations(days);
        int recentConfigSize = recentConfigs.size();
        if (recentConfigSize <= 0) goto L65;
        r4.println("recentConfigs:");
        int i = 0;
    L45:
        if (i >= recentConfigSize) goto L66;
        r4.println("  config: " + Configuration.resourceQualifierString(recentConfigs.get(i)));
        i = i + 1;
        goto L45
    L66:
        return 0;
    L65:
        return 0;
    L64:
        return 0;
    L40:
        r0 = this;
        r4 = pw;
        goto L41
    }

    int runSuppressResizeConfigChanges(PrintWriter pw) throws RemoteException {
        boolean suppress = Boolean.valueOf(getNextArgRequired()).booleanValue();
        this.mTaskInterface.suppressResizeConfigChanges(suppress);
        return 0;
    }

    int runSetInactive(PrintWriter pw) throws RemoteException {
        int userId = -2;
    L3:
        String opt = getNextOption();
        if (opt == null) goto L10;
        if (opt.equals("--user") == false) goto L8;
        userId = UserHandle.parseUserArg(getNextArgRequired());
        goto L3
    L8:
        getErrPrintWriter().println("Error: Unknown option: " + opt);
        return -1;
    L10:
        String packageName = getNextArgRequired();
        String value = getNextArgRequired();
        IUsageStatsManager usm = IUsageStatsManager.Stub.asInterface(ServiceManager.getService("usagestats"));
        usm.setAppInactive(packageName, Boolean.parseBoolean(value), userId);
        return 0;
    }

    private int bucketNameToBucketValue(String name) {
        String lower = name.toLowerCase();
        if (lower.startsWith("ac") == false) goto L7;
        return 10;
    L7:
        if (lower.startsWith("wo") == false) goto L11;
        return 20;
    L11:
        if (lower.startsWith("fr") == false) goto L15;
        return 30;
    L15:
        if (lower.startsWith("ra") == false) goto L19;
        return 40;
    L19:
        if (lower.startsWith("re") == false) goto L23;
        return 45;
    L23:
        if (lower.startsWith("ne") == false) goto L31;
        return 50;
    L31:
        int bucket = Integer.parseInt(lower);     // Catch: NumberFormatException -> L28
        return bucket;
    L29:
        getErrPrintWriter().println("Error: Unknown bucket: " + name);
        return -1;
    }

    int runSetStandbyBucket(PrintWriter pw) throws RemoteException {
        int userId = -2;
    L3:
        String opt = getNextOption();
        if (opt == null) goto L10;
        if (opt.equals("--user") == false) goto L8;
        userId = UserHandle.parseUserArg(getNextArgRequired());
        goto L3
    L8:
        getErrPrintWriter().println("Error: Unknown option: " + opt);
        return -1;
    L10:
        String packageName = getNextArgRequired();
        String value = getNextArgRequired();
        int bucket = bucketNameToBucketValue(value);
        if (bucket >= 0) goto L14;
        return -1;
    L14:
        if (peekNextArg() == null) goto L16;
        boolean multiple = true;
    L17:
        IUsageStatsManager usm = IUsageStatsManager.Stub.asInterface(ServiceManager.getService("usagestats"));
        if (multiple == true) goto L20;
        usm.setAppStandbyBucket(packageName, bucketNameToBucketValue(value), userId);
    L28:
        return 0;
    L20:
        ArrayList<AppStandbyInfo> bucketInfoList = new ArrayList();
        bucketInfoList.add(new AppStandbyInfo(packageName, bucket));
    L21:
        String packageName2 = getNextArg();
        if (packageName2 == null) goto L27;
        int bucket2 = bucketNameToBucketValue(getNextArgRequired());
        if (bucket2 < 0) goto L21;
        bucketInfoList.add(new AppStandbyInfo(packageName2, bucket2));
        goto L21
    L27:
        ParceledListSlice<AppStandbyInfo> slice = new ParceledListSlice(bucketInfoList);
        usm.setAppStandbyBuckets(slice, userId);
        goto L28
    L16:
        multiple = false;
        goto L17
    }

    int runGetStandbyBucket(PrintWriter pw) throws RemoteException {
        int userId = -2;
    L3:
        String opt = getNextOption();
        if (opt == null) goto L10;
        if (opt.equals("--user") == false) goto L8;
        userId = UserHandle.parseUserArg(getNextArgRequired());
        goto L3
    L8:
        getErrPrintWriter().println("Error: Unknown option: " + opt);
        return -1;
    L10:
        String packageName = getNextArg();
        IUsageStatsManager usm = IUsageStatsManager.Stub.asInterface(ServiceManager.getService("usagestats"));
        if (packageName == null) goto L13;
        int bucket = usm.getAppStandbyBucket(packageName, null, userId);
        pw.println(bucket);
        return 0;
    L13:
        ParceledListSlice<AppStandbyInfo> buckets = usm.getAppStandbyBuckets("com.android.shell", userId);
        Iterator r5 = buckets.getList().iterator();
    L15:
        if (r5.hasNext() == false) goto L22;
        AppStandbyInfo bucketInfo = (AppStandbyInfo) r5.next();
        pw.print(bucketInfo.mPackageName);
        pw.print(": ");
        pw.println(bucketInfo.mStandbyBucket);
        goto L15
    L22:
        return 0;
    }

    int runGetInactive(PrintWriter pw) throws RemoteException {
        int userId = -2;
    L3:
        String opt = getNextOption();
        if (opt == null) goto L10;
        if (opt.equals("--user") == false) goto L8;
        userId = UserHandle.parseUserArg(getNextArgRequired());
        goto L3
    L8:
        getErrPrintWriter().println("Error: Unknown option: " + opt);
        return -1;
    L10:
        String packageName = getNextArgRequired();
        IUsageStatsManager usm = IUsageStatsManager.Stub.asInterface(ServiceManager.getService("usagestats"));
        boolean isIdle = usm.isAppInactive(packageName, userId, "com.android.shell");
        pw.println("Idle=" + isIdle);
        return 0;
    }

    int runSendTrimMemory(PrintWriter pw) throws RemoteException {
        int userId = -2;
    L3:
        String opt = getNextOption();
        if (opt == null) goto L13;
        if (opt.equals("--user") == false) goto L11;
        userId = UserHandle.parseUserArg(getNextArgRequired());
        if (userId != (-1)) goto L3;
        getErrPrintWriter().println("Error: Can't use user 'all'");
        return -1;
    L11:
        getErrPrintWriter().println("Error: Unknown option: " + opt);
        return -1;
    L13:
        String proc = getNextArgRequired();
        String levelArg = getNextArgRequired();
        switch(levelArg.hashCode()) {
            case -1943119297: goto L35;
            case -847101650: goto L32;
            case -219160669: goto L29;
            case 163769603: goto L26;
            case 183181625: goto L23;
            case 1072631956: goto L20;
            case 2130809258: goto L17;
            default: goto L37;
        };
    L37:
        byte r5 = -1;
    L38:
        switch(r5) {
            case 0: goto L50;
            case 1: goto L49;
            case 2: goto L48;
            case 3: goto L47;
            case 4: goto L46;
            case 5: goto L45;
            case 6: goto L44;
            default: goto L56;
        };
    L44:
        int level = 80;
    L52:
        if (this.mInterface.setProcessMemoryTrimLevel(proc, userId, level) == true) goto L55;
        getErrPrintWriter().println("Unknown error: failed to set trim level");
        return -1;
    L55:
        return 0;
    L45:
        level = 15;
        goto L52
    L46:
        level = 60;
        goto L52
    L47:
        level = 10;
        goto L52
    L48:
        level = 40;
        goto L52
    L49:
        level = 5;
        goto L52
    L50:
        level = 20;
        goto L52
    L56:
        level = Integer.parseInt(levelArg);     // Catch: NumberFormatException -> L41
    L42:
        getErrPrintWriter().println("Error: Unknown level option: " + levelArg);
        return -1;
    L17:
        if (levelArg.equals("HIDDEN") == false) goto L62;
        r5 = 0;
        goto L38
    L62:
        r5 = -1;
        goto L38
    L20:
        if (levelArg.equals("RUNNING_LOW") == false) goto L63;
        r5 = 3;
        goto L38
    L63:
        r5 = -1;
        goto L38
    L23:
        if (levelArg.equals("COMPLETE") == false) goto L64;
        r5 = 6;
        goto L38
    L64:
        r5 = -1;
        goto L38
    L26:
        if (levelArg.equals("MODERATE") == false) goto L65;
        r5 = 4;
        goto L38
    L65:
        r5 = -1;
        goto L38
    L29:
        if (levelArg.equals("RUNNING_MODERATE") == false) goto L66;
        r5 = 1;
        goto L38
    L66:
        r5 = -1;
        goto L38
    L32:
        if (levelArg.equals("BACKGROUND") == false) goto L67;
        r5 = 2;
        goto L38
    L67:
        r5 = -1;
        goto L38
    L35:
        if (levelArg.equals("RUNNING_CRITICAL") == false) goto L68;
        r5 = 5;
        goto L38
    L68:
        r5 = -1;
        goto L38
    }

    int runDisplay(PrintWriter pw) throws RemoteException {
        String op = getNextArgRequired();
        switch(op.hashCode()) {
            case 1625698700: goto L6;
            default: goto L8;
        };
    L8:
        byte r1 = -1;
    L9:
        switch(r1) {
            case 0: goto L13;
            default: goto L10;
        };
    L10:
        getErrPrintWriter().println("Error: unknown command '" + op + "'");
        return -1;
    L13:
        return runDisplayMoveStack(pw);
    L6:
        if (op.equals("move-stack") == false) goto L8;
        r1 = 0;
        goto L9
    }

    int runStack(PrintWriter pw) throws RemoteException {
        String op = getNextArgRequired();
        switch(op.hashCode()) {
            case -934610812: goto L15;
            case 3237038: goto L12;
            case 3322014: goto L9;
            case 1022285313: goto L6;
            default: goto L17;
        };
    L17:
        byte r1 = -1;
    L18:
        switch(r1) {
            case 0: goto L28;
            case 1: goto L26;
            case 2: goto L24;
            case 3: goto L22;
            default: goto L19;
        };
    L19:
        getErrPrintWriter().println("Error: unknown command '" + op + "'");
        return -1;
    L22:
        return runRootTaskRemove(pw);
    L24:
        return runRootTaskInfo(pw);
    L26:
        return runStackList(pw);
    L28:
        return runStackMoveTask(pw);
    L6:
        if (op.equals("move-task") == false) goto L29;
        r1 = 0;
        goto L18
    L29:
        r1 = -1;
        goto L18
    L9:
        if (op.equals("list") == false) goto L30;
        r1 = 1;
        goto L18
    L30:
        r1 = -1;
        goto L18
    L12:
        if (op.equals("info") == false) goto L31;
        r1 = 2;
        goto L18
    L31:
        r1 = -1;
        goto L18
    L15:
        if (op.equals("remove") == false) goto L32;
        r1 = 3;
        goto L18
    L32:
        r1 = -1;
        goto L18
    }

    private Rect getBounds() {
        String leftStr = getNextArgRequired();
        int left = Integer.parseInt(leftStr);
        String topStr = getNextArgRequired();
        int top = Integer.parseInt(topStr);
        String rightStr = getNextArgRequired();
        int right = Integer.parseInt(rightStr);
        String bottomStr = getNextArgRequired();
        int bottom = Integer.parseInt(bottomStr);
        if (left >= 0) goto L6;
        getErrPrintWriter().println("Error: bad left arg: " + leftStr);
        return null;
    L6:
        if (top >= 0) goto L9;
        getErrPrintWriter().println("Error: bad top arg: " + topStr);
        return null;
    L9:
        if (right > 0) goto L12;
        getErrPrintWriter().println("Error: bad right arg: " + rightStr);
        return null;
    L12:
        if (bottom > 0) goto L16;
        getErrPrintWriter().println("Error: bad bottom arg: " + bottomStr);
        return null;
    L16:
        return new Rect(left, top, right, bottom);
    }

    int runDisplayMoveStack(PrintWriter pw) throws RemoteException {
        String rootTaskIdStr = getNextArgRequired();
        int rootTaskId = Integer.parseInt(rootTaskIdStr);
        String displayIdStr = getNextArgRequired();
        int displayId = Integer.parseInt(displayIdStr);
        this.mTaskInterface.moveRootTaskToDisplay(rootTaskId, displayId);
        return 0;
    }

    int runStackMoveTask(PrintWriter pw) throws RemoteException {
        String taskIdStr = getNextArgRequired();
        int taskId = Integer.parseInt(taskIdStr);
        String rootTaskIdStr = getNextArgRequired();
        int rootTaskId = Integer.parseInt(rootTaskIdStr);
        String toTopStr = getNextArgRequired();
        if ("true".equals(toTopStr) == false) goto L6;
        boolean toTop = true;
    L8:
        this.mTaskInterface.moveTaskToRootTask(taskId, rootTaskId, toTop);
        return 0;
    L6:
        if ("false".equals(toTopStr) == false) goto L10;
        toTop = false;
        goto L8
    L10:
        getErrPrintWriter().println("Error: bad toTop arg: " + toTopStr);
        return -1;
    }

    int runStackList(PrintWriter pw) throws RemoteException {
        List<ActivityTaskManager.RootTaskInfo> tasks = this.mTaskInterface.getAllRootTaskInfos();
        Iterator<ActivityTaskManager.RootTaskInfo> r1 = tasks.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ActivityTaskManager.RootTaskInfo info = r1.next();
        pw.println(info);
        goto L4
    L6:
        return 0;
    }

    int runRootTaskInfo(PrintWriter pw) throws RemoteException {
        int windowingMode = Integer.parseInt(getNextArgRequired());
        int activityType = Integer.parseInt(getNextArgRequired());
        ActivityTaskManager.RootTaskInfo info = this.mTaskInterface.getRootTaskInfo(windowingMode, activityType);
        pw.println(info);
        return 0;
    }

    int runRootTaskRemove(PrintWriter pw) throws RemoteException {
        String taskIdStr = getNextArgRequired();
        int taskId = Integer.parseInt(taskIdStr);
        this.mTaskInterface.removeTask(taskId);
        return 0;
    }

    int runTask(PrintWriter pw) throws RemoteException {
        String op = getNextArgRequired();
        if (op.equals("lock") == false) goto L7;
        return runTaskLock(pw);
    L7:
        if (op.equals("resizeable") == false) goto L11;
        return runTaskResizeable(pw);
    L11:
        if (op.equals("resize") == false) goto L15;
        return runTaskResize(pw);
    L15:
        if (op.equals("focus") == true) goto L17;
        getErrPrintWriter().println("Error: unknown command '" + op + "'");
        return -1;
    L17:
        return runTaskFocus(pw);
    }

    int runTaskLock(PrintWriter pw) throws RemoteException {
        String taskIdStr = getNextArgRequired();
        if (taskIdStr.equals(IMediaProjectionManagerServiceExt.NODE_STOP) == false) goto L5;
        this.mTaskInterface.stopSystemLockTaskMode();
    L6:
        StringBuilder r1 = new StringBuilder();
        r1.append("Activity manager is ");
        if (this.mTaskInterface.isInLockTaskMode() == false) goto L9;
        String r2 = "";
    L10:
        r1.append(r2);
        r1.append("in lockTaskMode");
        pw.println(r1.toString());
        return 0;
    L9:
        r2 = "not ";
        goto L10
    L5:
        int taskId = Integer.parseInt(taskIdStr);
        this.mTaskInterface.startSystemLockTaskMode(taskId);
        goto L6
    }

    int runTaskResizeable(PrintWriter pw) throws RemoteException {
        String taskIdStr = getNextArgRequired();
        int taskId = Integer.parseInt(taskIdStr);
        String resizeableStr = getNextArgRequired();
        int resizeableMode = Integer.parseInt(resizeableStr);
        this.mTaskInterface.setTaskResizeable(taskId, resizeableMode);
        return 0;
    }

    int runTaskResize(PrintWriter pw) throws RemoteException {
        String taskIdStr = getNextArgRequired();
        int taskId = Integer.parseInt(taskIdStr);
        Rect bounds = getBounds();
        if (bounds != null) goto L6;
        getErrPrintWriter().println("Error: invalid input bounds");
        return -1;
    L6:
        taskResize(taskId, bounds, 0, false);
        return 0;
    }

    void taskResize(int r4, Rect r5, int r6, boolean r7) throws RemoteException {
        this.mTaskInterface.resizeTask(r4, r5, r7 ? 1 : 0);
        Thread.sleep(r6);     // Catch: InterruptedException -> L5
        return;
    }

    int moveTask(int taskId, Rect taskRect, Rect stackRect, int stepSize, int maxToTravel, boolean movingForward, boolean horizontal, int delay_ms) throws RemoteException {
        if (movingForward == false) goto L15;
    L4:
        if (maxToTravel <= 0) goto L26;
        if (horizontal == true) goto L7;
    L8:
        if (horizontal == true) goto L26;
        if (taskRect.bottom >= stackRect.bottom) goto L26;
    L11:
        if (horizontal == false) goto L13;
        int maxMove = Math.min(stepSize, stackRect.right - taskRect.right);
        maxToTravel = maxToTravel - maxMove;
        taskRect.right += maxMove;
        taskRect.left += maxMove;
    L14:
        taskResize(taskId, taskRect, delay_ms, false);
        goto L4
    L13:
        int maxMove2 = Math.min(stepSize, stackRect.bottom - taskRect.bottom);
        maxToTravel = maxToTravel - maxMove2;
        taskRect.top += maxMove2;
        taskRect.bottom += maxMove2;
        goto L14
    L7:
        if (taskRect.right < stackRect.right) goto L11;
    L26:
        return maxToTravel;
    L15:
        if (maxToTravel >= 0) goto L26;
        if (horizontal == true) goto L18;
    L19:
        if (horizontal == true) goto L26;
        if (taskRect.top <= stackRect.top) goto L26;
    L22:
        if (horizontal == false) goto L24;
        int maxMove3 = Math.min(stepSize, taskRect.left - stackRect.left);
        maxToTravel = maxToTravel - maxMove3;
        taskRect.right -= maxMove3;
        taskRect.left -= maxMove3;
    L25:
        taskResize(taskId, taskRect, delay_ms, false);
        goto L15
    L24:
        int maxMove4 = Math.min(stepSize, taskRect.top - stackRect.top);
        maxToTravel = maxToTravel - maxMove4;
        taskRect.top -= maxMove4;
        taskRect.bottom -= maxMove4;
        goto L25
    L18:
        if (taskRect.left > stackRect.left) goto L22;
        goto L19
    }

    int getStepSize(int current, int target, int inStepSize, boolean greaterThanTarget) {
        int stepSize = 0;
        if (greaterThanTarget == false) goto L8;
        if (target >= current) goto L8;
        current = current - inStepSize;
        stepSize = inStepSize;
        if (target <= current) goto L8;
        stepSize = stepSize - (target - current);
    L8:
        if (greaterThanTarget == true) goto L14;
        if (target <= current) goto L15;
        int current2 = current + inStepSize;
        if (target < current2) goto L13;
        return inStepSize;
    L13:
        return inStepSize + (current2 - target);
    L15:
        return stepSize;
    L14:
        return stepSize;
    }

    int runTaskFocus(PrintWriter pw) throws RemoteException {
        int taskId = Integer.parseInt(getNextArgRequired());
        pw.println("Setting focus to task " + taskId);
        this.mTaskInterface.setFocusedTask(taskId);
        return 0;
    }

    int runWrite(PrintWriter pw) {
        this.mInternal.enforceCallingPermission("android.permission.SET_ACTIVITY_WATCHER", "registerUidObserver()");
        this.mInternal.mAtmInternal.flushRecentTasks();
        pw.println("All tasks persisted.");
        return 0;
    }

    int runAttachAgent(PrintWriter pw) {
        this.mInternal.enforceCallingPermission("android.permission.SET_ACTIVITY_WATCHER", "attach-agent");
        String process = getNextArgRequired();
        String agent = getNextArgRequired();
        String opt = getNextArg();
        if (opt == null) goto L6;
        pw.println("Error: Unknown option: " + opt);
        return -1;
    L6:
        this.mInternal.attachAgent(process, agent);
        return 0;
    }

    int runSupportsMultiwindow(PrintWriter pw) throws RemoteException {
        Resources res = getResources(pw);
        if (res != null) goto L6;
        return -1;
    L6:
        pw.println(ActivityTaskManager.supportsMultiWindow(this.mInternal.mContext));
        return 0;
    }

    int runSupportsSplitScreenMultiwindow(PrintWriter pw) throws RemoteException {
        Resources res = getResources(pw);
        if (res != null) goto L6;
        return -1;
    L6:
        pw.println(ActivityTaskManager.supportsSplitScreenMultiWindow(this.mInternal.mContext));
        return 0;
    }

    int runUpdateApplicationInfo(PrintWriter pw) throws RemoteException {
        int userid = UserHandle.parseUserArg(getNextArgRequired());
        ArrayList<String> packages = new ArrayList();
        packages.add(getNextArgRequired());
    L3:
        String packageName = getNextArg();
        if (packageName == null) goto L6;
        packages.add(packageName);
        goto L3
    L6:
        this.mInternal.scheduleApplicationInfoChanged(packages, userid);
        pw.println("Packages updated with most recent ApplicationInfos.");
        return 0;
    }

    int runNoHomeScreen(PrintWriter pw) throws RemoteException {
        Resources res = getResources(pw);
        if (res != null) goto L6;
        return -1;
    L6:
        pw.println(res.getBoolean(R.bool.config_omnipresentCommunalUser));
        return 0;
    }

    int runWaitForBroadcastIdle(PrintWriter pw) throws RemoteException {
        PrintWriter pw2 = new PrintWriter(new TeeWriter(new Writer[]{ActivityManagerDebugConfig.LOG_WRITER_INFO, pw}));
        boolean flushBroadcastLoopers = false;
    L3:
        String opt = getNextOption();
        if (opt == null) goto L10;
        if (opt.equals("--flush-broadcast-loopers") == false) goto L8;
        flushBroadcastLoopers = true;
        goto L3
    L8:
        getErrPrintWriter().println("Error: Unknown option: " + opt);
        return -1;
    L10:
        this.mInternal.waitForBroadcastIdle(pw2, flushBroadcastLoopers);
        return 0;
    }

    int runWaitForBroadcastBarrier(PrintWriter pw) throws RemoteException {
        PrintWriter pw2 = new PrintWriter(new TeeWriter(new Writer[]{ActivityManagerDebugConfig.LOG_WRITER_INFO, pw}));
        boolean flushBroadcastLoopers = false;
        boolean flushApplicationThreads = false;
    L3:
        String opt = getNextOption();
        if (opt == null) goto L13;
        if (opt.equals("--flush-broadcast-loopers") == true) goto L7;
        if (opt.equals("--flush-application-threads") == false) goto L11;
        flushApplicationThreads = true;
        goto L3
    L11:
        getErrPrintWriter().println("Error: Unknown option: " + opt);
        return -1;
    L7:
        flushBroadcastLoopers = true;
        goto L3
    L13:
        this.mInternal.waitForBroadcastBarrier(pw2, flushBroadcastLoopers, flushApplicationThreads);
        return 0;
    }

    int runWaitForApplicationBarrier(PrintWriter pw) throws RemoteException {
        PrintWriter pw2 = new PrintWriter(new TeeWriter(new Writer[]{ActivityManagerDebugConfig.LOG_WRITER_INFO, pw}));
        this.mInternal.waitForApplicationBarrier(pw2);
        return 0;
    }

    int runWaitForBroadcastDispatch(PrintWriter pw) throws RemoteException {
        PrintWriter pw2 = new PrintWriter(new TeeWriter(new Writer[]{ActivityManagerDebugConfig.LOG_WRITER_INFO, pw}));
        Intent intent = makeIntent(-2);     // Catch: URISyntaxException -> L6
        this.mInternal.waitForBroadcastDispatch(pw2, intent);
        return 0;
    L6:
        e = move-exception;
        throw new RuntimeException(e.getMessage(), e);
    }

    int runSetIgnoreDeliveryGroupPolicy(PrintWriter pw) throws RemoteException {
        String broadcastAction = getNextArgRequired();
        this.mInternal.setIgnoreDeliveryGroupPolicy(broadcastAction);
        return 0;
    }

    int runClearIgnoreDeliveryGroupPolicy(PrintWriter pw) throws RemoteException {
        String broadcastAction = getNextArgRequired();
        this.mInternal.clearIgnoreDeliveryGroupPolicy(broadcastAction);
        return 0;
    }

    int runRefreshSettingsCache() throws RemoteException {
        this.mInternal.refreshSettingsCache();
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r16v0, types: [android.util.ArraySet, java.util.Set] */
    /* JADX WARN: Type inference failed for: r16v10 */
    /* JADX WARN: Type inference failed for: r16v2 */
    /* JADX WARN: Type inference failed for: r17v0 */
    /* JADX WARN: Type inference failed for: r17v1 */
    /* JADX WARN: Type inference failed for: r17v2, types: [int] */
    /* JADX WARN: Type inference failed for: r17v3 */
    /* JADX WARN: Type inference failed for: r17v4 */
    /* JADX WARN: Type inference failed for: r17v5 */
    /* JADX WARN: Type inference failed for: r17v6 */
    /* JADX WARN: Type inference failed for: r17v7 */
    /* JADX WARN: Type inference failed for: r17v8 */
    /* JADX WARN: Type inference failed for: r17v9 */
    /* JADX WARN: Type inference failed for: r4v4 */
    private int runCompat(PrintWriter r20) throws RemoteException {
        PlatformCompat r2 = (PlatformCompat) ServiceManager.getService("platform_compat");
        String r3 = getNextArgRequired();
        byte r4 = 1;
        boolean r0 = !"--no-kill".equals(getNextOption());
        boolean r6 = false;
        int r7 = -1;
        long r8 = -1;
        ?? r13 = -1;
        if (r3.endsWith("-all") == false) goto L11;
        r3 = r3.substring(0, r3.lastIndexOf("-all"));
        r6 = true;
        if (r3.equals("reset") == false) goto L112;
    L20:
        String r10 = getNextArgRequired();
        if (r6 == false) goto L23;
    L25:
        ArraySet r1 = new ArraySet();
        ?? r16 = new ArraySet();
    L100:
        e = e;
        ?? r17 = -1;
    L102:
        r20.println(e.getMessage());
    L103:
        return r17;
    L117:
        switch(r3.hashCode()) {
            case -1298848381: goto L37;
            case 108404047: goto L35;
            case 1671308008: goto L30;
            default: goto L40;
        };
    L37:
        if (r3.equals("enable") == false) goto L121;
        r4 = 0;
    L41:
        r17 = -1;
        r13 = " for ";
        switch(r4) {
            case 0: goto L105;
            case 1: goto L61;
            case 2: goto L48;
            default: goto L43;
        };
    L43:
        r20.println("Invalid toggle value: '" + r3 + "'.");     // Catch: SecurityException -> L45
        r16 = r3;
        goto L103
    L61:
        if (r6 == false) goto L108;
        int r5 = r2.disableTargetSdkChanges(r10, r7);     // Catch: SecurityException -> L45
        if (r5 != 0) goto L66;
        r20.println("No changes were disabled.");     // Catch: SecurityException -> L45
        return -1;
    L66:
        r20.println("Disabled " + r5 + " changes gated by targetSdkVersion " + r7 + " for " + r10 + ".");     // Catch: SecurityException -> L45
    L78:
        return 0;
    L108:
        r16.add(Long.valueOf(r8));     // Catch: SecurityException -> L74
        CompatibilityChangeConfig r9 = new CompatibilityChangeConfig(new Compatibility.ChangeConfig(r1, r16));     // Catch: SecurityException -> L74
        if (r0 == false) goto L76;
        r2.setOverrides(r9, r10);     // Catch: SecurityException -> L74
    L77:
        r20.println("Disabled change " + r8 + " for " + r10 + ".");     // Catch: SecurityException -> L74
        goto L78
    L76:
        r2.setOverridesForTest(r9, r10);     // Catch: SecurityException -> L74
    L79:
        e = e;
        r17 = r17;
        goto L102
    L48:
        if (r6 == false) goto L54;
        if (r0 == false) goto L51;
        r2.clearOverrides(r10);     // Catch: SecurityException -> L45
    L52:
        r20.println("Reset all changes for " + r10 + " to default value.");     // Catch: SecurityException -> L45
        return 0;
    L51:
        r2.clearOverridesForTest(r10);     // Catch: SecurityException -> L45
        goto L52
    L54:
        if (r0 == false) goto L56;
        boolean r11 = r2.clearOverride(r8, r10);     // Catch: SecurityException -> L45
    L57:
        if (r11 == false) goto L59;
        r20.println("Reset change " + r8 + " for " + r10 + " to default value.");     // Catch: SecurityException -> L45
    L60:
        return 0;
    L59:
        r20.println("No override exists for changeId " + r8 + ".");     // Catch: SecurityException -> L45
        goto L60
    L56:
        r11 = r2.clearOverrideForTest(r8, r10);     // Catch: SecurityException -> L45
        goto L57
    L105:
        if (r6 == true) goto L110;
        r1.add(Long.valueOf(r8));     // Catch: SecurityException -> L90
        CompatibilityChangeConfig r12 = new CompatibilityChangeConfig(new Compatibility.ChangeConfig(r1, r16));     // Catch: SecurityException -> L90
        if (r0 == false) goto L97;
        r2.setOverrides(r12, r10);     // Catch: SecurityException -> L90
    L98:
        r20.println("Enabled change " + r8 + " for " + r10 + ".");     // Catch: SecurityException -> L90
    L99:
        return 0;
    L97:
        r2.setOverridesForTest(r12, r10);     // Catch: SecurityException -> L90
        goto L98
    L110:
        int r14 = r2.enableTargetSdkChanges(r10, r7);     // Catch: SecurityException -> L92
        if (r14 != 0) goto L87;
        r20.println("No changes were enabled.");     // Catch: SecurityException -> L74
        return -1;
    L87:
        StringBuilder r15 = new StringBuilder();     // Catch: SecurityException -> L92
        r15.append("Enabled ");     // Catch: SecurityException -> L90
        r15.append(r14);     // Catch: SecurityException -> L90
        r15.append(" changes gated by targetSdkVersion ");     // Catch: SecurityException -> L90
        r15.append(r7);     // Catch: SecurityException -> L90
        r15.append(" for ");     // Catch: SecurityException -> L90
        r15.append(r10);     // Catch: SecurityException -> L90
        r15.append(".");     // Catch: SecurityException -> L90
        r20.println(r15.toString());     // Catch: SecurityException -> L90
    L92:
        e = e;
        r17 = r17;
    L90:
        e = e;
        r17 = r17;
    L74:
        e = e;
        r17 = r17;
    L45:
        e = e;
        r17 = r17;
        goto L102
    L121:
        r4 = -1;
        goto L41
    L40:
        r4 = -1;
        goto L41
    L30:
        if (r3.equals("disable") == true) goto L41;
        r4 = -1;
        goto L41
    L35:
        if (r3.equals("reset") == false) goto L120;
        r4 = 2;
        goto L41
    L120:
        r4 = -1;
    L32:
        e = e;
        r17 = r13;
        goto L102
    L23:
        if (r2.isKnownChangeId(r8) == true) goto L25;
        r20.println("Warning! Change " + r8 + " is not known yet. Enabling/disabling it could have no effect.");
        goto L25
    L112:
        r7 = Integer.parseInt(getNextArgRequired());     // Catch: NumberFormatException -> L8
    L9:
        r20.println("Invalid targetSdkVersion!");
        return -1;
    L11:
        String r18 = getNextArgRequired();
        r8 = Long.parseLong(r18);     // Catch: NumberFormatException -> L14
    L17:
        if (r8 != (-1)) goto L20;
        r20.println("Unknown or invalid change: '" + r18 + "'.");
        return -1;
    L15:
        r8 = r2.lookupChangeId(r18);
        goto L17
    }

    private int runGetCurrentForegroundProcess(PrintWriter pw, IActivityManager iam) throws RemoteException {
        ProcessObserver observer = new ProcessObserver(pw, iam);
        iam.registerProcessObserver(observer);
        InputStream mInput = getRawInputStream();
        InputStreamReader converter = new InputStreamReader(mInput);
        BufferedReader in = new BufferedReader(converter);
    L30:
        String line = in.readLine();     // Catch: Throwable -> L16 IOException -> L18
        if (line == null) goto L22;
        boolean addNewline = true;
        if (line.length() > 0) goto L9;
        addNewline = false;
    L14:
        if (addNewline == false) goto L20;
        pw.println("");     // Catch: Throwable -> L16 IOException -> L18
    L20:
        pw.flush();     // Catch: Throwable -> L16 IOException -> L18
        goto L30
    L9:
        if ("q".equals(line) == true) goto L22;
        if ("quit".equals(line) == true) goto L22;
        pw.println("Invalid command: " + line);     // Catch: Throwable -> L16 IOException -> L18
    L22:
        iam.unregisterProcessObserver(observer);
        return 0;
    L18:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L16
        pw.flush();     // Catch: Throwable -> L16
        iam.unregisterProcessObserver(observer);
        return 0;
    L16:
        th = move-exception;
        iam.unregisterProcessObserver(observer);
        throw th;
    }

    private int runSetMemoryFactor(PrintWriter pw) throws RemoteException {
        String levelArg = getNextArgRequired();
        int level = -1;
        switch(levelArg.hashCode()) {
            case -1986416409: goto L15;
            case -1560189025: goto L12;
            case 75572: goto L9;
            case 163769603: goto L6;
            default: goto L17;
        };
    L17:
        byte r2 = -1;
    L18:
        switch(r2) {
            case 0: goto L29;
            case 1: goto L28;
            case 2: goto L27;
            case 3: goto L26;
            default: goto L32;
        };
    L26:
        level = 3;
    L30:
        this.mInternal.setMemFactorOverride(level);
        return 0;
    L27:
        level = 2;
        goto L30
    L28:
        level = 1;
        goto L30
    L29:
        level = 0;
        goto L30
    L32:
        level = Integer.parseInt(levelArg);     // Catch: NumberFormatException -> L21
    L22:
        if (level < 0) goto L24;
        if (level <= 3) goto L30;
    L24:
        getErrPrintWriter().println("Error: Unknown level option: " + levelArg);
        return -1;
    L6:
        if (levelArg.equals("MODERATE") == false) goto L34;
        r2 = 1;
        goto L18
    L34:
        r2 = -1;
        goto L18
    L9:
        if (levelArg.equals("LOW") == false) goto L35;
        r2 = 2;
        goto L18
    L35:
        r2 = -1;
        goto L18
    L12:
        if (levelArg.equals(PriorityDump.PRIORITY_ARG_CRITICAL) == false) goto L36;
        r2 = 3;
        goto L18
    L36:
        r2 = -1;
        goto L18
    L15:
        if (levelArg.equals(PriorityDump.PRIORITY_ARG_NORMAL) == false) goto L37;
        r2 = 0;
        goto L18
    L37:
        r2 = -1;
        goto L18
    }

    private int runShowMemoryFactor(PrintWriter pw) throws RemoteException {
        int level = this.mInternal.getMemoryTrimLevel();
        switch(level) {
            case -1: goto L9;
            case 0: goto L8;
            case 1: goto L7;
            case 2: goto L6;
            case 3: goto L5;
            default: goto L10;
        };
    L5:
        pw.println(PriorityDump.PRIORITY_ARG_CRITICAL);
        goto L10
    L6:
        pw.println("LOW");
        goto L10
    L7:
        pw.println("MODERATE");
        goto L10
    L8:
        pw.println(PriorityDump.PRIORITY_ARG_NORMAL);
        goto L10
    L9:
        pw.println("<UNKNOWN>");
    L10:
        pw.flush();
        return 0;
    }

    private int runResetMemoryFactor(PrintWriter pw) throws RemoteException {
        this.mInternal.setMemFactorOverride(-1);
        return 0;
    }

    private int runMemoryFactor(PrintWriter pw) throws RemoteException {
        this.mInternal.enforceCallingPermission("android.permission.WRITE_SECURE_SETTINGS", "runMemoryFactor()");
        String op = getNextArgRequired();
        switch(op.hashCode()) {
            case 113762: goto L12;
            case 3529469: goto L9;
            case 108404047: goto L6;
            default: goto L14;
        };
    L14:
        byte r1 = -1;
    L15:
        switch(r1) {
            case 0: goto L23;
            case 1: goto L21;
            case 2: goto L19;
            default: goto L16;
        };
    L16:
        getErrPrintWriter().println("Error: unknown command '" + op + "'");
        return -1;
    L19:
        return runResetMemoryFactor(pw);
    L21:
        return runShowMemoryFactor(pw);
    L23:
        return runSetMemoryFactor(pw);
    L6:
        if (op.equals("reset") == false) goto L24;
        r1 = 2;
        goto L15
    L24:
        r1 = -1;
        goto L15
    L9:
        if (op.equals("show") == false) goto L25;
        r1 = 1;
        goto L15
    L25:
        r1 = -1;
        goto L15
    L12:
        if (op.equals("set") == false) goto L26;
        r1 = 0;
        goto L15
    L26:
        r1 = -1;
        goto L15
    }

    private int runServiceRestartBackoff(PrintWriter pw) throws RemoteException {
        this.mInternal.enforceCallingPermission("android.permission.SET_PROCESS_LIMIT", "runServiceRestartBackoff()");
        String opt = getNextArgRequired();
        switch(opt.hashCode()) {
            case -1298848381: goto L12;
            case 3529469: goto L9;
            case 1671308008: goto L6;
            default: goto L14;
        };
    L14:
        byte r1 = -1;
    L16:
        switch(r1) {
            case 0: goto L27;
            case 1: goto L25;
            case 2: goto L20;
            default: goto L17;
        };
    L17:
        getErrPrintWriter().println("Error: unknown command '" + opt + "'");
        return -1;
    L25:
        this.mInternal.setServiceRestartBackoffEnabled(getNextArgRequired(), false, DisassociationProcessor.REASON_SHELL);
        return 0;
    L27:
        this.mInternal.setServiceRestartBackoffEnabled(getNextArgRequired(), true, DisassociationProcessor.REASON_SHELL);
        return 0;
    L20:
        if (this.mInternal.isServiceRestartBackoffEnabled(getNextArgRequired()) == false) goto L22;
        String r2 = ServiceConfigAccessor.PROVIDER_MODE_ENABLED;
    L23:
        pw.println(r2);
        return 0;
    L22:
        r2 = ServiceConfigAccessor.PROVIDER_MODE_DISABLED;
        goto L23
    L6:
        if (opt.equals("disable") == false) goto L29;
        r1 = 1;
        goto L16
    L29:
        r1 = -1;
        goto L16
    L9:
        if (opt.equals("show") == false) goto L30;
        r1 = 2;
        goto L16
    L30:
        r1 = -1;
        goto L16
    L12:
        if (opt.equals("enable") == false) goto L31;
        r1 = 0;
        goto L16
    L31:
        r1 = -1;
        goto L16
    }

    private int runGetIsolatedProcesses(PrintWriter pw) throws RemoteException {
        this.mInternal.enforceCallingPermission("android.permission.DUMP", "getIsolatedProcesses()");
        List<Integer> result = this.mInternal.mInternal.getIsolatedProcesses(Integer.parseInt(getNextArgRequired()));
        pw.print("[");
        if (result == null) goto L9;
        int i = 0;
        int size = result.size();
    L5:
        if (i >= size) goto L9;
        if (i <= 0) goto L8;
        pw.print(", ");
    L8:
        pw.print(result.get(i));
        i = i + 1;
    L9:
        pw.println("]");
        return 0;
    }

    private int runSetStopUserOnSwitch(PrintWriter pw) throws RemoteException {
        this.mInternal.enforceCallingPermission("android.permission.INTERACT_ACROSS_USERS_FULL", "setStopUserOnSwitch()");
        String arg = getNextArg();
        if (arg != null) goto L6;
        Slogf.i(TAG, "setStopUserOnSwitch(): resetting to default value");
        this.mInternal.setStopUserOnSwitch(-1);
        pw.println("Reset to default value");
        return 0;
    L6:
        boolean stop = Boolean.parseBoolean(arg);
        if (stop == false) goto L9;
        int value = 1;
    L10:
        Slogf.i(TAG, "runSetStopUserOnSwitch(): setting to %d (%b)", new Object[]{Integer.valueOf(value), Boolean.valueOf(stop)});
        this.mInternal.setStopUserOnSwitch(value);
        pw.println("Set to " + stop);
        return 0;
    L9:
        value = 0;
        goto L10
    }

    private int runSetBgAbusiveUids(PrintWriter pw) throws RemoteException {
        String arg = getNextArg();
        AppBatteryTracker batteryTracker = (AppBatteryTracker) this.mInternal.mAppRestrictionController.getAppStateTracker(AppBatteryTracker.class);
        if (batteryTracker != null) goto L7;
        getErrPrintWriter().println("Unable to get bg battery tracker");
        return -1;
    L7:
        if (arg != null) goto L10;
        batteryTracker.clearDebugUidPercentage();
        return 0;
    L10:
        String[] pairs = arg.split(",");
        int[] uids = new int[pairs.length];
        double[][] values = new double[pairs.length][];
        int i = 0;
    L33:
        if (i >= pairs.length) goto L29;
        String[] pair = pairs[i].split("=");     // Catch: NumberFormatException -> L17
        if (pair.length != 2) goto L15;
        uids[i] = Integer.parseInt(pair[0]);     // Catch: NumberFormatException -> L17
        String[] vals = pair[1].split(":");     // Catch: NumberFormatException -> L17
        if (vals.length != 5) goto L21;
        values[i] = new double[vals.length];     // Catch: NumberFormatException -> L17
        int j = 0;
    L25:
        if (j >= vals.length) goto L28;
        values[i][j] = Double.parseDouble(vals[j]);     // Catch: NumberFormatException -> L17
        j = j + 1;
        goto L25
    L28:
        i = i + 1;
        goto L33
    L21:
        getErrPrintWriter().println("Malformed input");     // Catch: NumberFormatException -> L17
        return -1;
    L15:
        getErrPrintWriter().println("Malformed input");     // Catch: NumberFormatException -> L17
        return -1;
    L29:
        batteryTracker.setDebugUidPercentage(uids, values);
        return 0;
    L31:
        getErrPrintWriter().println("Malformed input");
        return -1;
    }

    private int runListBgExemptionsConfig(PrintWriter pw) throws RemoteException {
        ArraySet<String> sysConfigs = this.mInternal.mAppRestrictionController.mBgRestrictionExemptioFromSysConfig;
        if (sysConfigs == null) goto L11;
        int i = 0;
        int size = sysConfigs.size();
    L5:
        if (i >= size) goto L7;
        pw.print(sysConfigs.valueAt(i));
        pw.print(' ');
        i = i + 1;
        goto L5
    L7:
        pw.println();
        return 0;
    L11:
        return 0;
    }

    private int restrictionNameToLevel(String name) {
        String lower = name.toLowerCase();
        switch(lower.hashCode()) {
            case -1790443964: goto L27;
            case -1502662066: goto L24;
            case -1349088399: goto L21;
            case -1078417287: goto L18;
            case -775446516: goto L15;
            case 824339380: goto L12;
            case 1351638995: goto L9;
            case 2052103358: goto L6;
            default: goto L29;
        };
    L29:
        byte r1 = -1;
    L30:
        switch(r1) {
            case 0: goto L46;
            case 1: goto L44;
            case 2: goto L42;
            case 3: goto L40;
            case 4: goto L38;
            case 5: goto L36;
            case 6: goto L34;
            case 7: goto L32;
            default: goto L31;
        };
    L31:
        return 0;
    L32:
        return 90;
    L34:
        return 70;
    L36:
        return 60;
    L38:
        return 50;
    L40:
        return 40;
    L42:
        return 30;
    L44:
        return 20;
    L46:
        return 10;
    L6:
        if (lower.equals("exempted") == false) goto L29;
        r1 = 1;
        goto L30
    L9:
        if (lower.equals("adaptive_bucket") == false) goto L29;
        r1 = 2;
        goto L30
    L12:
        if (lower.equals("unrestricted") == false) goto L29;
        r1 = 0;
        goto L30
    L15:
        if (lower.equals("background_restricted") == false) goto L29;
        r1 = 4;
        goto L30
    L18:
        if (lower.equals("force_stopped") == false) goto L29;
        r1 = 5;
        goto L30
    L21:
        if (lower.equals("custom") == false) goto L29;
        r1 = 7;
        goto L30
    L24:
        if (lower.equals("restricted_bucket") == false) goto L29;
        r1 = 3;
        goto L30
    L27:
        if (lower.equals("user_launch_only") == false) goto L29;
        r1 = 6;
        goto L30
    }

    int runSetBgRestrictionLevel(PrintWriter pw) throws RemoteException {
        int userId = -2;
    L3:
        String opt = getNextOption();
        if (opt == null) goto L10;
        if (opt.equals("--user") == false) goto L8;
        userId = UserHandle.parseUserArg(getNextArgRequired());
        goto L3
    L8:
        getErrPrintWriter().println("Error: Unknown option: " + opt);
        return -1;
    L10:
        String packageName = getNextArgRequired();
        String value = getNextArgRequired();
        int level = restrictionNameToLevel(value);
        if (level != 0) goto L21;
        pw.println("Error: invalid restriction level");
        return -1;
    L21:
        PackageManager pm = this.mInternal.mContext.getPackageManager();     // Catch: PackageManager.NameNotFoundException -> L18
        int uid = pm.getPackageUidAsUser(packageName, PackageManager.PackageInfoFlags.of(4194304), userId);     // Catch: PackageManager.NameNotFoundException -> L18
        this.mInternal.setBackgroundRestrictionLevel(packageName, uid, userId, level, 1024, 0);
        return 0;
    L19:
        pw.println("Error: userId:" + userId + " package:" + packageName + " is not found");
        return -1;
    }

    int runGetBgRestrictionLevel(PrintWriter pw) throws RemoteException {
        int userId = -2;
    L3:
        String opt = getNextOption();
        if (opt == null) goto L10;
        if (opt.equals("--user") == false) goto L8;
        userId = UserHandle.parseUserArg(getNextArgRequired());
        goto L3
    L8:
        getErrPrintWriter().println("Error: Unknown option: " + opt);
        return -1;
    L10:
        String packageName = getNextArgRequired();
        int level = this.mInternal.getBackgroundRestrictionLevel(packageName, userId);
        pw.println(ActivityManager.restrictionLevelToName(level));
        return 0;
    }

    int runSetForegroundServiceDelegate(PrintWriter pw) throws RemoteException {
        int userId = -2;
    L3:
        String opt = getNextOption();
        if (opt == null) goto L10;
        if (opt.equals("--user") == false) goto L8;
        userId = UserHandle.parseUserArg(getNextArgRequired());
        goto L3
    L8:
        getErrPrintWriter().println("Error: Unknown option: " + opt);
        return -1;
    L10:
        String packageName = getNextArgRequired();
        String action = getNextArgRequired();
        if (IMediaProjectionManagerServiceExt.NODE_START.equals(action) == false) goto L14;
        boolean isStart = true;
    L25:
        PackageManager pm = this.mInternal.mContext.getPackageManager();     // Catch: PackageManager.NameNotFoundException -> L20
        int uid = pm.getPackageUidAsUser(packageName, PackageManager.PackageInfoFlags.of(4194304), userId);     // Catch: PackageManager.NameNotFoundException -> L20
        this.mInternal.setForegroundServiceDelegate(packageName, uid, isStart, 12, "FgsDelegate");
        return 0;
    L21:
        pw.println("Error: userId:" + userId + " package:" + packageName + " is not found");
        return -1;
    L14:
        if (IMediaProjectionManagerServiceExt.NODE_STOP.equals(action) == false) goto L23;
        isStart = false;
        goto L25
    L23:
        pw.println("Error: action is either start or stop");
        return -1;
    }

    int runResetDropboxRateLimiter() throws RemoteException {
        this.mInternal.resetDropboxRateLimiter();
        return 0;
    }

    int runListDisplaysForStartingUsers(PrintWriter pw) throws RemoteException {
        int[] displayIds = this.mInterface.getDisplayIdsForStartingVisibleBackgroundUsers();
        if (displayIds != null) goto L5;
    L8:
        String r1 = "none";
    L9:
        pw.println(r1);
        return 0;
    L5:
        if (displayIds.length == 0) goto L8;
        r1 = Arrays.toString(displayIds);
        goto L9
    }

    int runClearBadProcess(PrintWriter pw) throws RemoteException {
        int userId = -2;
    L3:
        String opt = getNextOption();
        if (opt == null) goto L10;
        if ("--user".equals(opt) == false) goto L8;
        userId = UserHandle.parseUserArg(getNextArgRequired());
        goto L3
    L8:
        getErrPrintWriter().println("Error: unknown option " + opt);
        return -1;
    L10:
        String processName = getNextArgRequired();
        if (userId != (-2)) goto L13;
        userId = this.mInternal.getCurrentUserId();
    L13:
        pw.println("Clearing '" + processName + "' in u" + userId + " from bad processes list");
        this.mInternal.mAppErrors.clearBadProcessForUser(processName, userId);
        return 0;
    }

    private Resources getResources(PrintWriter pw) throws RemoteException {
        Configuration config = this.mInterface.getConfiguration();
        if (config != null) goto L6;
        pw.println("Error: Activity manager has no configuration");
        return null;
    L6:
        DisplayMetrics metrics = new DisplayMetrics();
        metrics.setToDefaults();
        return new Resources(AssetManager.getSystem(), metrics, config);
    }

    public void onHelp() {
        PrintWriter pw = getOutPrintWriter();
        dumpHelp(pw, this.mDumping);
    }

    @NeverCompile
    static void dumpHelp(PrintWriter pw, boolean dumping) {
        if (dumping == false) goto L4;
        pw.println("Activity manager dump options:");
        pw.println("  [-a] [-c] [-p PACKAGE] [-h] [WHAT] ...");
        pw.println("  WHAT may be one of:");
        pw.println("    a[ctivities]: activity stack state");
        pw.println("    r[recents]: recent activities state");
        pw.println("    b[roadcasts] [PACKAGE_NAME] [history [-s]]: broadcast state");
        pw.println("    broadcast-stats [PACKAGE_NAME]: aggregated broadcast statistics");
        pw.println("    i[ntents] [PACKAGE_NAME]: pending intent state");
        pw.println("    p[rocesses] [PACKAGE_NAME]: process state");
        pw.println("    o[om]: out of memory management");
        pw.println("    perm[issions]: URI permission grant state");
        pw.println("    prov[iders] [COMP_SPEC ...]: content provider state");
        pw.println("    provider [COMP_SPEC]: provider client-side state");
        pw.println("    s[ervices] [COMP_SPEC ...]: service state");
        pw.println("    allowed-associations: current package association restrictions");
        pw.println("    as[sociations]: tracked app associations");
        pw.println("    start-info [PACKAGE_NAME]: historical process start information");
        pw.println("    exit-info [PACKAGE_NAME]: historical process exit information");
        pw.println("    lmk: stats on low memory killer");
        pw.println("    lru: raw LRU process list");
        pw.println("    binder-proxies: stats on binder objects and IPCs");
        pw.println("    settings: currently applied config settings");
        pw.println("    cao: cached app optimizer state");
        pw.println("    timers: the current ANR timer state");
        pw.println("    service [COMP_SPEC]: service client-side state");
        pw.println("    package [PACKAGE_NAME]: all state related to given package");
        pw.println("    all: dump all activities");
        pw.println("    top: dump the top activity");
        pw.println("    users: user state");
        pw.println("  WHAT may also be a COMP_SPEC to dump activities.");
        pw.println("  COMP_SPEC may be a component name (com.foo/.myApp),");
        pw.println("    a partial substring in a component name, a");
        pw.println("    hex object identifier.");
        pw.println("  -a: include all available server state.");
        pw.println("  -c: include client state.");
        pw.println("  -p: limit output to given package.");
        pw.println("  -d: limit output to given display.");
        pw.println("  --checkin: output checkin format, resetting data.");
        pw.println("  --C: output checkin format, not resetting data.");
        pw.println("  --proto: output dump in protocol buffer format.");
        pw.printf("  %s: dump just the DUMPABLE-related state of an activity. Use the %s option to list the supported DUMPABLEs\n", new Object[]{"--dump-dumpable", "--list-dumpables"});
        pw.printf("  %s: show the available dumpables in an activity\n", new Object[]{"--list-dumpables"});
        return;
    L4:
        pw.println("Activity manager (activity) commands:");
        pw.println("  help");
        pw.println("      Print this help text.");
        pw.println("  start-activity [-D] [-N] [-W] [-P <FILE>] [--start-profiler <FILE>]");
        pw.println("          [--sampling INTERVAL] [--clock-type <TYPE>] [--streaming]");
        pw.println("          [--profiler-output-version NUMBER]");
        pw.println("          [-R COUNT] [-S] [--track-allocation]");
        pw.println("          [--user <USER_ID> | current] [--suspend] <INTENT>");
        pw.println("      Start an Activity.  Options are:");
        pw.println("      -D: enable debugging");
        pw.println("      --suspend: debugged app suspend threads at startup (only with -D)");
        pw.println("      -N: enable native debugging");
        pw.println("      -W: wait for launch to complete (initial display)");
        pw.println("      --start-profiler <FILE>: start profiler and send results to <FILE>");
        pw.println("      --sampling INTERVAL: use sample profiling with INTERVAL microseconds");
        pw.println("          between samples (use with --start-profiler)");
        pw.println("      --clock-type <TYPE>: type can be wall / thread-cpu / dual. Specify");
        pw.println("          the clock that is used to report the timestamps when profiling");
        pw.println("          The default value is dual. (use with --start-profiler)");
        pw.println("      --streaming: stream the profiling output to the specified file");
        pw.println("          (use with --start-profiler)");
        pw.println("      --profiler-output-version Specify the version of the");
        pw.println("          profiling output (use with --start-profiler)");
        pw.println("      -P <FILE>: like above, but profiling stops when app goes idle");
        pw.println("      --attach-agent <agent>: attach the given agent before binding");
        pw.println("      --attach-agent-bind <agent>: attach the given agent during binding");
        pw.println("      -R: repeat the activity launch <COUNT> times.  Prior to each repeat,");
        pw.println("          the top activity will be finished.");
        pw.println("      -S: force stop the target app before starting the activity");
        pw.println("      --track-allocation: enable tracking of object allocations");
        pw.println("      --user <USER_ID> | current: Specify which user to run as; if not");
        pw.println("          specified then run as the current user.");
        pw.println("      --windowingMode <WINDOWING_MODE>: The windowing mode to launch the activity into.");
        pw.println("      --activityType <ACTIVITY_TYPE>: The activity type to launch the activity as.");
        pw.println("      --display <DISPLAY_ID>: The display to launch the activity into.");
        pw.println("      --splashscreen-icon: Show the splash screen icon on launch.");
        pw.println("  start-in-vsync");
        pw.println("      Start an Activity with vsync aligned. See `start-activity` for the");
        pw.println("      possible options.");
        pw.println("  start-service [--user <USER_ID> | current] <INTENT>");
        pw.println("      Start a Service.  Options are:");
        pw.println("      --user <USER_ID> | current: Specify which user to run as; if not");
        pw.println("          specified then run as the current user.");
        pw.println("  start-foreground-service [--user <USER_ID> | current] <INTENT>");
        pw.println("      Start a foreground Service.  Options are:");
        pw.println("      --user <USER_ID> | current: Specify which user to run as; if not");
        pw.println("          specified then run as the current user.");
        pw.println("  stop-service [--user <USER_ID> | current] <INTENT>");
        pw.println("      Stop a Service.  Options are:");
        pw.println("      --user <USER_ID> | current: Specify which user to run as; if not");
        pw.println("          specified then run as the current user.");
        pw.println("  broadcast [--user <USER_ID> | all | current]");
        pw.println("          [--receiver-permission <PERMISSION>]");
        pw.println("          [--allow-background-activity-starts]");
        pw.println("          [--async] <INTENT>");
        pw.println("      Send a broadcast Intent.  Options are:");
        pw.println("      --user <USER_ID> | all | current: Specify which user to send to; if not");
        pw.println("          specified then send to all users.");
        pw.println("      --receiver-permission <PERMISSION>: Require receiver to hold permission.");
        pw.println("      --allow-background-activity-starts: The receiver may start activities");
        pw.println("          even if in the background.");
        pw.println("      --async: Send without waiting for the completion of the receiver.");
        pw.println("  compact {some|full} <PROCESS>");
        pw.println("      Perform a single process compaction. The given <PROCESS> argument");
        pw.println("          may be either a process name or pid.");
        pw.println("      some: execute file compaction.");
        pw.println("      full: execute anon + file compaction.");
        pw.println("  compact system");
        pw.println("      Perform a full system compaction.");
        pw.println("  compact native {some|full} <pid>");
        pw.println("      Perform a native compaction for process with <pid>.");
        pw.println("      some: execute file compaction.");
        pw.println("      full: execute anon + file compaction.");
        pw.println("  freeze [--sticky] <PROCESS>");
        pw.println("      Freeze a process. The given <PROCESS> argument");
        pw.println("          may be either a process name or pid.  Options are:");
        pw.println("      --sticky: persists the frozen state for the process lifetime or");
        pw.println("                  until an unfreeze is triggered via shell");
        pw.println("  unfreeze [--sticky] <PROCESS>");
        pw.println("      Unfreeze a process. The given <PROCESS> argument");
        pw.println("          may be either a process name or pid.  Options are:");
        pw.println("      --sticky: persists the unfrozen state for the process lifetime or");
        pw.println("                  until a freeze is triggered via shell");
        pw.println("  instrument [-r] [-e <NAME> <VALUE>] [-p <FILE>] [-w]");
        pw.println("          [--user <USER_ID> | current]");
        pw.println("          [--no-hidden-api-checks [--no-test-api-access]]");
        pw.println("          [--no-isolated-storage]");
        pw.println("          [--no-window-animation] [--abi <ABI>] <COMPONENT>");
        pw.println("      Start an Instrumentation.  Typically this target <COMPONENT> is in the");
        pw.println("      form <TEST_PACKAGE>/<RUNNER_CLASS> or only <TEST_PACKAGE> if there");
        pw.println("      is only one instrumentation.  Options are:");
        pw.println("      -r: print raw results (otherwise decode REPORT_KEY_STREAMRESULT).  Use with");
        pw.println("          [-e perf true] to generate raw output for performance measurements.");
        pw.println("      -e <NAME> <VALUE>: set argument <NAME> to <VALUE>.  For test runners a");
        pw.println("          common form is [-e <testrunner_flag> <value>[,<value>...]].");
        pw.println("      -p <FILE>: write profiling data to <FILE>");
        pw.println("      -m: Write output as protobuf to stdout (machine readable)");
        pw.println("      -f <Optional PATH/TO/FILE>: Write output as protobuf to a file (machine");
        pw.println("          readable). If path is not specified, default directory and file name will");
        pw.println("          be used: /sdcard/instrument-logs/log-yyyyMMdd-hhmmss-SSS.instrumentation_data_proto");
        pw.println("      -w: wait for instrumentation to finish before returning.  Required for");
        pw.println("          test runners.");
        pw.println("      --user <USER_ID> | current: Specify user instrumentation runs in;");
        pw.println("          current user if not specified.");
        pw.println("      --no-hidden-api-checks: disable restrictions on use of hidden API.");
        pw.println("      --no-test-api-access: do not allow access to test APIs, if hidden");
        pw.println("          API checks are enabled.");
        pw.println("      --no-isolated-storage: don't use isolated storage sandbox and ");
        pw.println("          mount full external storage");
        pw.println("      --no-window-animation: turn off window animations while running.");
        pw.println("      --abi <ABI>: Launch the instrumented process with the selected ABI.");
        pw.println("          This assumes that the process supports the selected ABI.");
        pw.println("  trace-ipc [start|stop] [--dump-file <FILE>]");
        pw.println("      Trace IPC transactions.");
        pw.println("      start: start tracing IPC transactions.");
        pw.println("      stop: stop tracing IPC transactions and dump the results to file.");
        pw.println("      --dump-file <FILE>: Specify the file the trace should be dumped to.");
        anrTimerHelp(pw);
        pw.println("  profile start [--user <USER_ID> current]");
        pw.println("          [--clock-type <TYPE>]");
        pw.println("          [--profiler-output-version VERSION]");
        pw.println("          [--sampling INTERVAL | --streaming] <PROCESS> <FILE>");
        pw.println("      Start profiler on a process.  The given <PROCESS> argument");
        pw.println("        may be either a process name or pid.  Options are:");
        pw.println("      --user <USER_ID> | current: When supplying a process name,");
        pw.println("          specify user of process to profile; uses current user if not");
        pw.println("          specified.");
        pw.println("      --clock-type <TYPE>: use the specified clock to report timestamps.");
        pw.println("          The type can be one of wall | thread-cpu | dual. The default");
        pw.println("          value is dual.");
        pw.println("      --profiler-output-versionVERSION: specifies the output");
        pw.println("          format version");
        pw.println("      --sampling INTERVAL: use sample profiling with INTERVAL microseconds");
        pw.println("          between samples.");
        pw.println("      --streaming: stream the profiling output to the specified file.");
        pw.println("  profile stop [--user <USER_ID> current] <PROCESS>");
        pw.println("      Stop profiler on a process.  The given <PROCESS> argument");
        pw.println("        may be either a process name or pid.  Options are:");
        pw.println("      --user <USER_ID> | current: When supplying a process name,");
        pw.println("          specify user of process to profile; uses current user if not");
        pw.println("          specified.");
        pw.println("  dumpheap [--user <USER_ID> current] [-n] [-g] [-b <format>] ");
        pw.println("           <PROCESS> <FILE>");
        pw.println("      Dump the heap of a process.  The given <PROCESS> argument may");
        pw.println("        be either a process name or pid.  Options are:");
        pw.println("      -n: dump native heap instead of managed heap");
        pw.println("      -g: force GC before dumping the heap");
        pw.println("      -b <format>: dump contents of bitmaps in the format specified,");
        pw.println("         which can be \"png\", \"jpg\" or \"webp\".");
        pw.println("      --user <USER_ID> | current: When supplying a process name,");
        pw.println("          specify user of process to dump; uses current user if not specified.");
        pw.println("  set-debug-app [-w] [--persistent] <PACKAGE>");
        pw.println("      Set application <PACKAGE> to debug.  Options are:");
        pw.println("      -w: wait for debugger when application starts");
        pw.println("      --persistent: retain this value");
        pw.println("  clear-debug-app");
        pw.println("      Clear the previously set-debug-app.");
        pw.println("  set-watch-heap <PROCESS> <MEM-LIMIT>");
        pw.println("      Start monitoring pss size of <PROCESS>, if it is at or");
        pw.println("      above <HEAP-LIMIT> then a heap dump is collected for the user to report.");
        pw.println("  clear-watch-heap");
        pw.println("      Clear the previously set-watch-heap.");
        pw.println("  clear-start-info [--user <USER_ID> | all | current] <PACKAGE>");
        pw.println("      Clear process start-info for the given package.");
        pw.println("      Clear start-info for all packages if no package is provided.");
        pw.println("  start-info-detailed-monitoring [--user <USER_ID> | all | current] <PACKAGE>");
        pw.println("      Enable application start info detailed monitoring for the given package.");
        pw.println("      Disable if no package is supplied.");
        pw.println("  clear-exit-info [--user <USER_ID> | all | current] <PACKAGE>");
        pw.println("      Clear process exit-info for the given package.");
        pw.println("      Clear exit-info for all packages if no package is provided.");
        pw.println("  bug-report [--progress | --telephony]");
        pw.println("      Request bug report generation; will launch a notification");
        pw.println("        when done to select where it should be delivered. Options are:");
        pw.println("     --progress: will launch a notification right away to show its progress.");
        pw.println("     --telephony: will dump only telephony sections.");
        pw.println("  fgs-notification-rate-limit {enable | disable}");
        pw.println("     Enable/disable rate limit on FGS notification deferral policy.");
        pw.println("  force-stop [--user <USER_ID> | all | current] <PACKAGE>");
        pw.println("      Completely stop the given application package.");
        pw.println("  stop-app [--user <USER_ID> | all | current] <PACKAGE>");
        pw.println("      Stop an app and all of its services.  Unlike `force-stop` this does");
        pw.println("      not cancel the app's scheduled alarms and jobs.");
        pw.println("  crash [--user <USER_ID>] <PACKAGE|PID>");
        pw.println("      Induce a VM crash in the specified package or process");
        pw.println("  kill [--user <USER_ID> | all | current] <PACKAGE>");
        pw.println("      Kill all background processes associated with the given application.");
        pw.println("  kill-all");
        pw.println("      Kill all processes that are safe to kill (cached, etc).");
        pw.println("  make-uid-idle [--user <USER_ID> | all | current] <PACKAGE>");
        pw.println("      If the given application's uid is in the background and waiting to");
        pw.println("      become idle (not allowing background services), do that now.");
        pw.println("  set-deterministic-uid-idle [--user <USER_ID> | all | current] <true|false>");
        pw.println("      If true, sets the timing of making UIDs idle consistent and");
        pw.println("      deterministic. If false, the timing will be variable depending on");
        pw.println("      other activity on the device. The default is false.");
        pw.println("  monitor [--gdb <port>] [-p <TARGET>] [-s] [-c] [-k]");
        pw.println("      Start monitoring for crashes or ANRs.");
        pw.println("      --gdb: start gdbserv on the given port at crash/ANR");
        pw.println("      -p: only show events related to a specific process / package");
        pw.println("      -s: simple mode, only show a summary line for each event");
        pw.println("      -c: assume the input is always [c]ontinue");
        pw.println("      -k: assume the input is always [k]ill");
        pw.println("         -c and -k are mutually exclusive.");
        pw.println("  watch-uids [--oom <uid>] [--mask <capabilities integer>]");
        pw.println("      Start watching for and reporting uid state changes.");
        pw.println("      --oom: specify a uid for which to report detailed change messages.");
        pw.println("      --mask: Specify PROCESS_CAPABILITY_XXX mask to report. ");
        pw.println("              By default, it only reports FOREGROUND_LOCATION (1)");
        pw.println("              FOREGROUND_CAMERA (2), FOREGROUND_MICROPHONE (4)");
        pw.println("              and NETWORK (8). New capabilities added on or after");
        pw.println("              Android UDC will not be reported by default.");
        pw.println("  hang [--allow-restart]");
        pw.println("      Hang the system.");
        pw.println("      --allow-restart: allow watchdog to perform normal system restart");
        pw.println("  restart");
        pw.println("      Restart the user-space system.");
        pw.println("  idle-maintenance");
        pw.println("      Perform idle maintenance now.");
        pw.println("  screen-compat [on|off] <PACKAGE>");
        pw.println("      Control screen compatibility mode of <PACKAGE>.");
        pw.println("  package-importance <PACKAGE>");
        pw.println("      Print current importance of <PACKAGE>.");
        pw.println("  to-uri [INTENT]");
        pw.println("      Print the given Intent specification as a URI.");
        pw.println("  to-intent-uri [INTENT]");
        pw.println("      Print the given Intent specification as an intent: URI.");
        pw.println("  to-app-uri [INTENT]");
        pw.println("      Print the given Intent specification as an android-app: URI.");
        pw.println("  switch-user <USER_ID>");
        pw.println("      Switch to put USER_ID in the foreground, starting");
        pw.println("      execution of that user if it is currently stopped.");
        pw.println("  get-current-user");
        pw.println("      Returns id of the current foreground user.");
        pw.println("  start-user [-w] [--display DISPLAY_ID] <USER_ID>");
        pw.println("      Start USER_ID in background if it is currently stopped;");
        pw.println("      use switch-user if you want to start the user in foreground.");
        pw.println("      -w: wait for start-user to complete and the user to be unlocked.");
        pw.println("      --display <DISPLAY_ID>: starts the user visible in that display, which allows the user to launch activities on it.");
        pw.println("        (not supported on all devices; typically only on automotive builds where the vehicle has passenger displays)");
        pw.println("  unlock-user <USER_ID>");
        pw.println("      Unlock the given user.  This will only work if the user doesn't");
        pw.println("      have an LSKF (PIN/pattern/password).");
        pw.println("  stop-user [-w] [-f] <USER_ID>");
        pw.println("      Stop execution of USER_ID, not allowing it to run any");
        pw.println("      code until a later explicit start or switch to it.");
        pw.println("      -w: wait for stop-user to complete.");
        pw.println("      -f: force stop, even if user has an unstoppable parent.");
        pw.println("  is-user-stopped <USER_ID>");
        pw.println("      Returns whether <USER_ID> has been stopped or not.");
        pw.println("  get-started-user-state <USER_ID>");
        pw.println("      Gets the current state of the given started user.");
        pw.println("  track-associations");
        pw.println("      Enable association tracking.");
        pw.println("  untrack-associations");
        pw.println("      Disable and clear association tracking.");
        pw.println("  get-uid-state <UID>");
        pw.println("      Gets the process state of an app given its <UID>.");
        pw.println("  attach-agent <PROCESS> <FILE>");
        pw.println("    Attach an agent to the specified <PROCESS>, which may be either a process name or a PID.");
        pw.println("  get-config [--days N] [--device] [--proto] [--display <DISPLAY_ID>]");
        pw.println("      Retrieve the configuration and any recent configurations of the device.");
        pw.println("      --days: also return last N days of configurations that have been seen.");
        pw.println("      --device: also output global device configuration info.");
        pw.println("      --proto: return result as a proto; does not include --days info.");
        pw.println("      --display: Specify for which display to run the command; if not ");
        pw.println("          specified then run for the default display.");
        pw.println("  supports-multiwindow");
        pw.println("      Returns true if the device supports multiwindow.");
        pw.println("  supports-split-screen-multi-window");
        pw.println("      Returns true if the device supports split screen multiwindow.");
        pw.println("  suppress-resize-config-changes <true|false>");
        pw.println("      Suppresses configuration changes due to user resizing an activity/task.");
        pw.println("  set-inactive [--user <USER_ID>] <PACKAGE> true|false");
        pw.println("      Sets the inactive state of an app.");
        pw.println("  get-inactive [--user <USER_ID>] <PACKAGE>");
        pw.println("      Returns the inactive state of an app.");
        pw.println("  set-standby-bucket [--user <USER_ID>] <PACKAGE> active|working_set|frequent|rare|restricted");
        pw.println("      Puts an app in the standby bucket.");
        pw.println("  get-standby-bucket [--user <USER_ID>] <PACKAGE>");
        pw.println("      Returns the standby bucket of an app.");
        pw.println("  send-trim-memory [--user <USER_ID>] <PROCESS>");
        pw.println("          [HIDDEN|RUNNING_MODERATE|BACKGROUND|RUNNING_LOW|MODERATE|RUNNING_CRITICAL|COMPLETE]");
        pw.println("      Send a memory trim event to a <PROCESS>.  May also supply a raw trim int level.");
        pw.println("  display [COMMAND] [...]: sub-commands for operating on displays.");
        pw.println("       move-stack <STACK_ID> <DISPLAY_ID>");
        pw.println("           Move <STACK_ID> from its current display to <DISPLAY_ID>.");
        pw.println("  stack [COMMAND] [...]: sub-commands for operating on activity stacks.");
        pw.println("       move-task <TASK_ID> <STACK_ID> [true|false]");
        pw.println("           Move <TASK_ID> from its current stack to the top (true) or");
        pw.println("           bottom (false) of <STACK_ID>.");
        pw.println("       list");
        pw.println("           List all of the activity stacks and their sizes.");
        pw.println("       info <WINDOWING_MODE> <ACTIVITY_TYPE>");
        pw.println("           Display the information about activity stack in <WINDOWING_MODE> and <ACTIVITY_TYPE>.");
        pw.println("       remove <STACK_ID>");
        pw.println("           Remove stack <STACK_ID>.");
        pw.println("  task [COMMAND] [...]: sub-commands for operating on activity tasks.");
        pw.println("       lock <TASK_ID>");
        pw.println("           Bring <TASK_ID> to the front and don't allow other tasks to run.");
        pw.println("       lock stop");
        pw.println("           End the current task lock.");
        pw.println("       resizeable <TASK_ID> [0|1|2|3]");
        pw.println("           Change resizeable mode of <TASK_ID> to one of the following:");
        pw.println("           0: unresizeable");
        pw.println("           1: crop_windows");
        pw.println("           2: resizeable");
        pw.println("           3: resizeable_and_pipable");
        pw.println("       resize <TASK_ID> <LEFT> <TOP> <RIGHT> <BOTTOM>");
        pw.println("           The task is resized only if it is in multi-window windowing");
        pw.println("           mode or freeform windowing mode.");
        pw.println("  update-appinfo <USER_ID> <PACKAGE_NAME> [<PACKAGE_NAME>...]");
        pw.println("      Update the ApplicationInfo objects of the listed packages for <USER_ID>");
        pw.println("      without restarting any processes.");
        pw.println("  write");
        pw.println("      Write all pending state to storage.");
        pw.println("  compat [COMMAND] [...]: sub-commands for toggling app-compat changes.");
        pw.println("         enable|disable [--no-kill] <CHANGE_ID|CHANGE_NAME> <PACKAGE_NAME>");
        pw.println("            Toggles a change either by id or by name for <PACKAGE_NAME>.");
        pw.println("            It kills <PACKAGE_NAME> (to allow the toggle to take effect) unless --no-kill is provided.");
        pw.println("         reset <CHANGE_ID|CHANGE_NAME> <PACKAGE_NAME>");
        pw.println("            Toggles a change either by id or by name for <PACKAGE_NAME>.");
        pw.println("            It kills <PACKAGE_NAME> (to allow the toggle to take effect).");
        pw.println("         enable-all|disable-all <targetSdkVersion> <PACKAGE_NAME>");
        pw.println("            Toggles all changes that are gated by <targetSdkVersion>.");
        pw.println("         reset-all [--no-kill] <PACKAGE_NAME>");
        pw.println("            Removes all existing overrides for all changes for ");
        pw.println("            <PACKAGE_NAME> (back to default behaviour).");
        pw.println("            It kills <PACKAGE_NAME> (to allow the toggle to take effect) unless --no-kill is provided.");
        pw.println("  memory-factor [command] [...]: sub-commands for overriding memory pressure factor");
        pw.println("         set <NORMAL|MODERATE|LOW|CRITICAL>");
        pw.println("            Overrides memory pressure factor. May also supply a raw int level");
        pw.println("         show");
        pw.println("            Shows the existing memory pressure factor");
        pw.println("         reset");
        pw.println("            Removes existing override for memory pressure factor");
        pw.println("  service-restart-backoff <COMMAND> [...]: sub-commands to toggle service restart backoff policy.");
        pw.println("         enable|disable <PACKAGE_NAME>");
        pw.println("            Toggles the restart backoff policy on/off for <PACKAGE_NAME>.");
        pw.println("         show <PACKAGE_NAME>");
        pw.println("            Shows the restart backoff policy state for <PACKAGE_NAME>.");
        pw.println("  get-isolated-pids <UID>");
        pw.println("         Get the PIDs of isolated processes with packages in this <UID>");
        pw.println("  set-stop-user-on-switch [true|false]");
        pw.println("         Sets whether the current user (and its profiles) should be stopped when switching to a different user.");
        pw.println("         Without arguments, it resets to the value defined by platform.");
        pw.println("  set-bg-abusive-uids [uid=percentage][,uid=percentage...]");
        pw.println("         Force setting the battery usage of the given UID.");
        pw.println("  set-bg-restriction-level [--user <USER_ID>] <PACKAGE> unrestricted|exempted|adaptive_bucket|restricted_bucket|background_restricted|hibernation");
        pw.println("         Set an app's background restriction level which in turn map to a app standby bucket.");
        pw.println("  get-bg-restriction-level [--user <USER_ID>] <PACKAGE>");
        pw.println("         Get an app's background restriction level.");
        pw.println("  list-displays-for-starting-users");
        pw.println("         Lists the id of displays that can be used to start users on background.");
        pw.println("  set-foreground-service-delegate [--user <USER_ID>] <PACKAGE> start|stop");
        pw.println("         Start/stop an app's foreground service delegate.");
        pw.println("  set-ignore-delivery-group-policy <ACTION>");
        pw.println("         Start ignoring delivery group policy set for a broadcast action");
        pw.println("  clear-ignore-delivery-group-policy <ACTION>");
        pw.println("         Stop ignoring delivery group policy set for a broadcast action");
        pw.println("  capabilities [--protobuf]");
        pw.println("         Output am supported features (text format). Options are:");
        pw.println("         --protobuf: format output using protobuffer");
        pw.println("  set-app-zygote-preload-timeout <TIMEOUT_IN_MS>");
        pw.println("         Set the timeout for preloading code in the app-zygote");
        pw.println("  set-media-foreground-service inactive|active [--user USER_ID] <PACKAGE> <NOTIFICATION_ID>");
        pw.println("         Set an app's media service inactive or active.");
        pw.println("  clear-bad-process [--user USER_ID] <PROCESS_NAME>");
        pw.println("         Clears a process from the bad processes list.");
        Intent.printIntentArgsHelp(pw, "");
    }

    static void anrTimerHelp(PrintWriter pw) {
        if (AnrTimer.traceFeatureEnabled() == true) goto L5;
        return;
    L5:
        String h = AnrTimer.traceTimers(new String[]{"help"});
        if (h != null) goto L8;
        return;
    L8:
        pw.println("  trace-timer <cmd>");
        String[] r1 = h.split("\n");
        int r2 = r1.length;
        int r3 = 0;
    L9:
        if (r3 >= r2) goto L11;
        String s = r1[r3];
        pw.println("         " + s);
        r3 = r3 + 1;
        goto L9
    }
}
