package com.android.server.wm;

import android.accessibilityservice.AccessibilityTrace;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManagerInternal;
import android.graphics.Insets;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Region;
import android.os.Binder;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import android.util.Pair;
import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.proto.ProtoOutputStream;
import android.view.Display;
import android.view.MagnificationSpec;
import android.view.ViewConfiguration;
import com.android.internal.os.SomeArgs;
import com.android.internal.util.DumpUtils;
import com.android.internal.util.TraceBuffer;
import com.android.internal.util.function.pooled.PooledLambda;
import com.android.server.LocalServices;
import com.android.server.storage.DeviceStorageMonitorServiceSmtEx;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
final class AccessibilityController {
    private static final Rect EMPTY_RECT = null;
    private static final Object STATIC_LOCK = null;
    private static final String TAG = null;
    private static final float[] sTempFloats = null;
    private final AccessibilityControllerInternalImpl mAccessibilityTracing;
    private final AccessibilityWindowsPopulator mAccessibilityWindowsPopulator;
    private boolean mAllObserversInitialized;
    private final SparseArray<DisplayMagnifier> mDisplayMagnifiers;
    private int mFocusedDisplay;
    private SparseArray<IBinder> mFocusedWindow;
    private final SparseBooleanArray mIsImeVisibleArray;
    private final WindowManagerService mService;
    private final SparseArray<WindowsForAccessibilityObserver> mWindowsForAccessibilityObserver;

    static final class AccessibilityControllerInternalImpl implements WindowManagerInternal.AccessibilityControllerInternal {
        private static AccessibilityControllerInternalImpl sInstance;
        private UiChangesForAccessibilityCallbacksDispatcher mCallbacksDispatcher;
        private volatile long mEnabledTracingFlags;
        private final Looper mLooper;
        private final AccessibilityTracing mTracing;

        private static final class UiChangesForAccessibilityCallbacksDispatcher {
            private static final boolean DEBUG_RECTANGLE_REQUESTED = false;
            private static final String LOG_TAG = "WindowManager";
            private final AccessibilityControllerInternalImpl mAccessibilityTracing;
            private final WindowManagerInternal.AccessibilityControllerInternal.UiChangesForAccessibilityCallbacks mCallbacks;
            private final Handler mHandler;

            UiChangesForAccessibilityCallbacksDispatcher(AccessibilityControllerInternalImpl accessibilityControllerInternal, Looper looper, WindowManagerInternal.AccessibilityControllerInternal.UiChangesForAccessibilityCallbacks callbacks) {
                this.mAccessibilityTracing = accessibilityControllerInternal;
                this.mCallbacks = callbacks;
                this.mHandler = new Handler(looper);
            }

            void onRectangleOnScreenRequested(int displayId, Rect rectangle) {
                if (this.mAccessibilityTracing.isTracingEnabled(2048) == false) goto L5;
                this.mAccessibilityTracing.logTrace("WindowManager.onRectangleOnScreenRequested", 2048, "rectangle={" + rectangle + "}");
            L5:
                final WindowManagerInternal.AccessibilityControllerInternal.UiChangesForAccessibilityCallbacks r0 = this.mCallbacks;
                r0.getClass();
                Message m = PooledLambda.obtainMessage(new AccessibilityController$AccessibilityControllerInternalImpl$UiChangesForAccessibilityCallbacksDispatcher$$ExternalSyntheticLambda0(r0), Integer.valueOf(displayId), Integer.valueOf(rectangle.left), Integer.valueOf(rectangle.top), Integer.valueOf(rectangle.right), Integer.valueOf(rectangle.bottom));
                this.mHandler.sendMessage(m);
            }
        }

        static AccessibilityControllerInternalImpl getInstance(WindowManagerService service) {
            Object r0 = AccessibilityController.m9587$$Nest$sfgetSTATIC_LOCK();
            monitor-enter(r0);
        L7:
            th = move-exception;
            throw th;
        L5:
            if (sInstance != null) goto L9;
            sInstance = new AccessibilityControllerInternalImpl(service);     // Catch: Throwable -> L7
        L9:
            AccessibilityControllerInternalImpl r1 = sInstance;     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        }

        private AccessibilityControllerInternalImpl(WindowManagerService service) {
            this.mLooper = service.mH.getLooper();
            this.mTracing = AccessibilityTracing.getInstance(service);
            this.mEnabledTracingFlags = 0;
        }

        @Override // com.android.server.wm.WindowManagerInternal.AccessibilityControllerInternal
        public void startTrace(long loggingTypes) {
            this.mEnabledTracingFlags = loggingTypes;
            this.mTracing.startTrace();
        }

        @Override // com.android.server.wm.WindowManagerInternal.AccessibilityControllerInternal
        public void stopTrace() {
            this.mTracing.stopTrace();
            this.mEnabledTracingFlags = 0;
        }

        @Override // com.android.server.wm.WindowManagerInternal.AccessibilityControllerInternal
        public boolean isAccessibilityTracingEnabled() {
            return this.mTracing.isEnabled();
        }

        boolean isTracingEnabled(long flags) {
            if ((this.mEnabledTracingFlags & flags) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        void logTrace(String where, long loggingTypes) {
            logTrace(where, loggingTypes, "");
        }

        void logTrace(String where, long loggingTypes, String callingParams) {
            logTrace(where, loggingTypes, callingParams, "".getBytes(), Binder.getCallingUid());
        }

        void logTrace(String where, long loggingTypes, String callingParams, byte[] a11yDump, int callingUid) {
            this.mTracing.logState(where, loggingTypes, callingParams, a11yDump, callingUid, new HashSet(Arrays.asList(new String[]{"logTrace"})));
        }

        @Override // com.android.server.wm.WindowManagerInternal.AccessibilityControllerInternal
        public void logTrace(String where, long loggingTypes, String callingParams, byte[] a11yDump, int callingUid, StackTraceElement[] stackTrace, Set<String> ignoreStackEntries) {
            this.mTracing.logState(where, loggingTypes, callingParams, a11yDump, callingUid, stackTrace, ignoreStackEntries);
        }

        @Override // com.android.server.wm.WindowManagerInternal.AccessibilityControllerInternal
        public void logTrace(String where, long loggingTypes, String callingParams, byte[] a11yDump, int callingUid, StackTraceElement[] callStack, long timeStamp, int processId, long threadId, Set<String> ignoreStackEntries) {
            this.mTracing.logState(where, loggingTypes, callingParams, a11yDump, callingUid, callStack, timeStamp, processId, threadId, ignoreStackEntries);
        }

        @Override // com.android.server.wm.WindowManagerInternal.AccessibilityControllerInternal
        public void setUiChangesForAccessibilityCallbacks(WindowManagerInternal.AccessibilityControllerInternal.UiChangesForAccessibilityCallbacks callbacks) {
            if (isTracingEnabled(2048) == false) goto L5;
            logTrace(AccessibilityController.m9588$$Nest$sfgetTAG() + ".setAccessibilityWindowManagerCallbacks", 2048, "callbacks={" + callbacks + "}");
        L5:
            if (callbacks == null) goto L12;
            if (this.mCallbacksDispatcher != null) goto L10;
            this.mCallbacksDispatcher = new UiChangesForAccessibilityCallbacksDispatcher(this, this.mLooper, callbacks);
            return;
        L10:
            throw new IllegalStateException("Accessibility window manager callback already set!");
        L12:
            if (this.mCallbacksDispatcher == null) goto L16;
            this.mCallbacksDispatcher = null;
            return;
        L16:
            throw new IllegalStateException("Accessibility window manager callback already cleared!");
        }

        public boolean hasWindowManagerEventDispatcher() {
            if (isTracingEnabled(3072) == false) goto L6;
            logTrace(AccessibilityController.m9588$$Nest$sfgetTAG() + ".hasCallbacks", 3072);
        L6:
            if (this.mCallbacksDispatcher == null) goto L8;
            return true;
        L8:
            return false;
        }

        public void onRectangleOnScreenRequested(int displayId, Rect rectangle) {
            if (isTracingEnabled(2048) == false) goto L6;
            logTrace(AccessibilityController.m9588$$Nest$sfgetTAG() + ".onRectangleOnScreenRequested", 2048, "rectangle={" + rectangle + "}");
        L6:
            if (this.mCallbacksDispatcher == null) goto L9;
            this.mCallbacksDispatcher.onRectangleOnScreenRequested(displayId, rectangle);
            return;
        }
    }

    private static final class AccessibilityTracing {
        private static final int BUFFER_CAPACITY = 12582912;
        private static final int CPU_STATS_COUNT = 5;
        private static final long MAGIC_NUMBER_VALUE = 4846245196254490945L;
        private static final String TAG = "AccessibilityTracing";
        private static final String TRACE_FILENAME = "/data/misc/a11ytrace/a11y_trace.winscope";
        private static AccessibilityTracing sInstance;
        private final TraceBuffer mBuffer;
        private volatile boolean mEnabled;
        private final LogHandler mHandler;
        private final Object mLock;
        private final WindowManagerService mService;
        private final File mTraceFile;

        private class LogHandler extends Handler {
            public static final int MESSAGE_LOG_TRACE_ENTRY = 1;
            public static final int MESSAGE_WRITE_FILE = 2;
            final /* synthetic */ AccessibilityTracing this$0;

            LogHandler(AccessibilityTracing r1, Looper looper) {
                this.this$0 = r1;
                super(looper);
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch(message.what) {
                    case 1: goto L13;
                    case 2: goto L5;
                    default: goto L63;
                };
            L5:
                Object r3 = AccessibilityTracing.m9592$$Nest$fgetmLock(this.this$0);
                monitor-enter(r3);
                AccessibilityTracing.m9596$$Nest$mwriteTraceToFileInternal(this.this$0);     // Catch: Throwable -> L10
                monitor-exit(r3);     // Catch: Throwable -> L10
                return;
            L10:
                th = move-exception;
                throw th;
            L13:
                SomeArgs args = (SomeArgs) message.obj;
                ProtoOutputStream os = new ProtoOutputStream();     // Catch: Exception -> L45
                PackageManagerInternal pmInternal = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);     // Catch: Exception -> L45
                long tokenOuter = os.start(2246267895810L);     // Catch: Exception -> L45
                long reportedTimeStampNanos = args.argl1;     // Catch: Exception -> L45
                long currentElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L45
                long timeDiffNanos = currentElapsedRealtimeNanos - reportedTimeStampNanos;     // Catch: Exception -> L45
                long currentTimeMillis = new Date().getTime();     // Catch: Exception -> L45
                long reportedTimeMillis = currentTimeMillis - (timeDiffNanos / 1000000);     // Catch: Exception -> L45
                SimpleDateFormat fm = new SimpleDateFormat("MM-dd HH:mm:ss.SSS");     // Catch: Exception -> L45
                os.write(1125281431553L, reportedTimeStampNanos);     // Catch: Exception -> L45
                os.write(1138166333442L, fm.format(Long.valueOf(reportedTimeMillis)).toString());     // Catch: Exception -> L45
                long loggingTypes = args.argl2;     // Catch: Exception -> L45
                List<String> loggingTypeNames = AccessibilityTrace.getNamesOfLoggingTypes(loggingTypes);     // Catch: Exception -> L45
                Iterator<String> r0 = loggingTypeNames.iterator();     // Catch: Exception -> L45
            L16:
                if (r0.hasNext() == false) goto L22;
                String type = r0.next();     // Catch: Exception -> L19
                SimpleDateFormat fm2 = fm;
                long loggingTypes2 = loggingTypes;
                os.write(2237677961219L, type);     // Catch: Exception -> L19
                fm = fm2;
                loggingTypes = loggingTypes2;
            L19:
                e = e;
            L47:
                Slog.e(AccessibilityTracing.TAG, "Exception while tracing state", e);
                return;
            L22:
                os.write(1138166333446L, (String) args.arg1);     // Catch: Exception -> L45
                os.write(1138166333444L, (String) args.arg2);     // Catch: Exception -> L45
                os.write(1138166333445L, (String) args.arg3);     // Catch: Exception -> L45
                os.write(1138166333447L, pmInternal.getNameForUid(message.arg1));     // Catch: Exception -> L45
                os.write(1138166333448L, (String) args.arg5);     // Catch: Exception -> L45
                String callingStack = AccessibilityTracing.m9595$$Nest$mtoStackTraceString(this.this$0, (StackTraceElement[]) args.arg6, (Set) args.arg4);     // Catch: Exception -> L45
                os.write(1138166333449L, callingStack);     // Catch: Exception -> L45
                os.write(1146756268042L, (byte[]) args.arg7);     // Catch: Exception -> L45
                long tokenInner = os.start(1146756268043L);     // Catch: Exception -> L45
                WindowManagerGlobalLock r2 = AccessibilityTracing.m9593$$Nest$fgetmService(this.this$0).mGlobalLock;     // Catch: Exception -> L45
                WindowManagerService.boostPriorityForLockedSection();     // Catch: Exception -> L45
                monitor-enter(r2);     // Catch: Exception -> L45
                AccessibilityTracing.m9593$$Nest$fgetmService(this.this$0).dumpDebugLocked(os, 0);     // Catch: Throwable -> L38
                monitor-exit(r2);     // Catch: Throwable -> L38
                WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Exception -> L36
                os.end(tokenInner);     // Catch: Exception -> L36
                os.write(1138166333452L, AccessibilityTracing.m9594$$Nest$mprintCpuStats(this.this$0, reportedTimeStampNanos));     // Catch: Exception -> L36
                os.end(tokenOuter);     // Catch: Exception -> L36
                Object r4 = AccessibilityTracing.m9592$$Nest$fgetmLock(this.this$0);     // Catch: Exception -> L36
                monitor-enter(r4);     // Catch: Exception -> L36
                AccessibilityTracing.m9591$$Nest$fgetmBuffer(this.this$0).add(os);     // Catch: Throwable -> L33
                monitor-exit(r4);     // Catch: Throwable -> L33
            L62:
                return;
            L33:
                th = move-exception;
                throw th;     // Catch: Exception -> L36
            L40:
                th = th;
            L42:
                monitor-exit(r2);     // Catch: Throwable -> L38
                WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Exception -> L36
                throw th;     // Catch: Exception -> L36
            L36:
                e = e;
            L38:
                th = th;
            L45:
                e = e;
                goto L47
            }
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmBuffer, reason: not valid java name */
        static /* bridge */ /* synthetic */ TraceBuffer m9591$$Nest$fgetmBuffer(AccessibilityTracing r0) {
            return r0.mBuffer;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
        static /* bridge */ /* synthetic */ Object m9592$$Nest$fgetmLock(AccessibilityTracing r0) {
            return r0.mLock;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmService, reason: not valid java name */
        static /* bridge */ /* synthetic */ WindowManagerService m9593$$Nest$fgetmService(AccessibilityTracing r0) {
            return r0.mService;
        }

        /* JADX INFO: renamed from: -$$Nest$mprintCpuStats, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m9594$$Nest$mprintCpuStats(AccessibilityTracing r0, long r1) {
            return r0.printCpuStats(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$mtoStackTraceString, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m9595$$Nest$mtoStackTraceString(AccessibilityTracing r0, StackTraceElement[] r1, Set r2) {
            return r0.toStackTraceString(r1, r2);
        }

        /* JADX INFO: renamed from: -$$Nest$mwriteTraceToFileInternal, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m9596$$Nest$mwriteTraceToFileInternal(AccessibilityTracing r0) {
            r0.writeTraceToFileInternal();
        }

        static AccessibilityTracing getInstance(WindowManagerService service) {
            Object r0 = AccessibilityController.m9587$$Nest$sfgetSTATIC_LOCK();
            monitor-enter(r0);
        L7:
            th = move-exception;
            throw th;
        L5:
            if (sInstance != null) goto L9;
            sInstance = new AccessibilityTracing(service);     // Catch: Throwable -> L7
        L9:
            AccessibilityTracing r1 = sInstance;     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        }

        AccessibilityTracing(WindowManagerService service) {
            this.mLock = new Object();
            this.mService = service;
            this.mTraceFile = new File(TRACE_FILENAME);
            this.mBuffer = new TraceBuffer(BUFFER_CAPACITY);
            HandlerThread workThread = new HandlerThread(TAG);
            workThread.start();
            this.mHandler = new LogHandler(this, workThread.getLooper());
        }

        void startTrace() {
            if (Build.IS_USER == false) goto L6;
            Slog.e(TAG, "Error: Tracing is not supported on user builds.");
            return;
        L6:
            Object r0 = this.mLock;
            monitor-enter(r0);
            this.mEnabled = true;     // Catch: Throwable -> L12
            this.mBuffer.resetBuffer();     // Catch: Throwable -> L12
            monitor-exit(r0);     // Catch: Throwable -> L12
            return;
        L12:
            th = move-exception;
            throw th;
        }

        void stopTrace() {
            if (Build.IS_USER == false) goto L6;
            Slog.e(TAG, "Error: Tracing is not supported on user builds.");
            return;
        L6:
            Object r0 = this.mLock;
            monitor-enter(r0);
            this.mEnabled = false;     // Catch: Throwable -> L14
            if (this.mEnabled == false) goto L16;
            Slog.e(TAG, "Error: tracing enabled while waiting for flush.");     // Catch: Throwable -> L14
            monitor-exit(r0);     // Catch: Throwable -> L14
            return;
        L16:
            writeTraceToFile();     // Catch: Throwable -> L14
            monitor-exit(r0);     // Catch: Throwable -> L14
            return;
        L14:
            th = move-exception;
            throw th;
        }

        boolean isEnabled() {
            return this.mEnabled;
        }

        void logState(String where, long loggingTypes) {
            if (this.mEnabled == true) goto L5;
            return;
        L5:
            logState(where, loggingTypes, "");
        }

        void logState(String where, long loggingTypes, String callingParams) {
            if (this.mEnabled == true) goto L5;
            return;
        L5:
            logState(where, loggingTypes, callingParams, "".getBytes());
        }

        void logState(String where, long loggingTypes, String callingParams, byte[] a11yDump) {
            if (this.mEnabled == true) goto L5;
            return;
        L5:
            logState(where, loggingTypes, callingParams, a11yDump, Binder.getCallingUid(), new HashSet(Arrays.asList(new String[]{"logState"})));
        }

        void logState(String where, long loggingTypes, String callingParams, byte[] a11yDump, int callingUid, Set<String> ignoreStackEntries) {
            if (this.mEnabled == true) goto L5;
            return;
        L5:
            StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
            ignoreStackEntries.add("logState");
            logState(where, loggingTypes, callingParams, a11yDump, callingUid, stackTraceElements, ignoreStackEntries);
        }

        void logState(String where, long loggingTypes, String callingParams, byte[] a11yDump, int callingUid, StackTraceElement[] stackTrace, Set<String> ignoreStackEntries) {
            if (this.mEnabled == true) goto L5;
            return;
        L5:
            log(where, loggingTypes, callingParams, a11yDump, callingUid, stackTrace, SystemClock.elapsedRealtimeNanos(), Process.myPid() + ":" + Application.getProcessName(), Thread.currentThread().getId() + ":" + Thread.currentThread().getName(), ignoreStackEntries);
        }

        void logState(String where, long loggingTypes, String callingParams, byte[] a11yDump, int callingUid, StackTraceElement[] callingStack, long timeStamp, int processId, long threadId, Set<String> ignoreStackEntries) {
            if (this.mEnabled == true) goto L5;
            return;
        L5:
            log(where, loggingTypes, callingParams, a11yDump, callingUid, callingStack, timeStamp, String.valueOf(processId), String.valueOf(threadId), ignoreStackEntries);
        }

        private String toStackTraceString(StackTraceElement[] stackTraceElements, Set<String> ignoreStackEntries) {
            if (stackTraceElements != null) goto L5;
            return "";
        L5:
            StringBuilder stringBuilder = new StringBuilder();
            int i = 0;
            int firstMatch = -1;
        L7:
            if (i >= stackTraceElements.length) goto L17;
            Iterator<String> r3 = ignoreStackEntries.iterator();
        L10:
            if (r3.hasNext() == false) goto L15;
            String ele = r3.next();
            if (stackTraceElements[i].toString().contains(ele) == false) goto L10;
            firstMatch = i;
        L15:
            if (firstMatch >= 0) goto L17;
            i = i + 1;
        L17:
            int lastMatch = firstMatch;
            if (i < stackTraceElements.length) goto L20;
        L32:
            int i2 = lastMatch + 1;
        L34:
            if (i2 >= stackTraceElements.length) goto L37;
            stringBuilder.append(stackTraceElements[i2].toString());
            stringBuilder.append("\n");
            i2 = i2 + 1;
            goto L34
        L37:
            return stringBuilder.toString();
        L20:
            i = i + 1;
            if (i >= stackTraceElements.length) goto L32;
            Iterator<String> r4 = ignoreStackEntries.iterator();
        L24:
            if (r4.hasNext() == false) goto L29;
            String ele2 = r4.next();
            if (stackTraceElements[i].toString().contains(ele2) == false) goto L24;
            lastMatch = i;
        L29:
            if (lastMatch == i) goto L20;
            goto L20
        }

        private void log(String where, long loggingTypes, String callingParams, byte[] a11yDump, int callingUid, StackTraceElement[] callingStack, long timeStamp, String processName, String threadName, Set<String> ignoreStackEntries) {
            SomeArgs args = SomeArgs.obtain();
            args.argl1 = timeStamp;
            args.argl2 = loggingTypes;
            args.arg1 = where;
            args.arg2 = processName;
            args.arg3 = threadName;
            args.arg4 = ignoreStackEntries;
            args.arg5 = callingParams;
            args.arg6 = callingStack;
            args.arg7 = a11yDump;
            this.mHandler.obtainMessage(1, callingUid, 0, args).sendToTarget();
        }

        void writeTraceToFile() {
            this.mHandler.sendEmptyMessage(2);
        }

        private void writeTraceToFileInternal() {
            ProtoOutputStream proto = new ProtoOutputStream();     // Catch: IOException -> L4
            proto.write(1125281431553L, MAGIC_NUMBER_VALUE);     // Catch: IOException -> L4
            long timeOffsetNs = TimeUnit.MILLISECONDS.toNanos(System.currentTimeMillis()) - SystemClock.elapsedRealtimeNanos();     // Catch: IOException -> L4
            proto.write(1125281431555L, timeOffsetNs);     // Catch: IOException -> L4
            this.mBuffer.writeTraceToFile(this.mTraceFile, proto);     // Catch: IOException -> L4
            return;
        L4:
            e = move-exception;
            Slog.e(TAG, "Unable to write buffer to file", e);
        }

        private String printCpuStats(long timeStampNanos) {
            Pair<String, String> stats = this.mService.mAmInternal.getAppProfileStatsForDebugging(timeStampNanos, 5);
            return ((String) stats.first) + ((String) stats.second);
        }
    }

    private static final class DisplayMagnifier {
        private static final boolean DEBUG_DISPLAY_SIZE = false;
        private static final boolean DEBUG_WINDOW_TRANSITIONS = false;
        private static final String LOG_TAG = "WindowManager";
        private final AccessibilityControllerInternalImpl mAccessibilityTracing;
        private final WindowManagerInternal.MagnificationCallbacks mCallbacks;
        private final Path mCircularPath;
        private final Display mDisplay;
        private final DisplayContent mDisplayContent;
        private final Context mDisplayContext;
        private final Handler mHandler;
        private boolean mIsFullscreenMagnificationActivated;
        private final Region mMagnificationRegion;
        private final MagnificationSpec mMagnificationSpec;
        private final Region mOldMagnificationRegion;
        private final Point mScreenSize;
        private final WindowManagerService mService;
        private int mTempLayer;
        private final Matrix mTempMatrix;
        private final Rect mTempRect1;
        private final Rect mTempRect2;
        private final Region mTempRegion1;
        private final Region mTempRegion2;
        private final Region mTempRegion3;
        private final Region mTempRegion4;
        private final SparseArray<WindowState> mTempWindowStates;
        private final UserContextChangedNotifier mUserContextChangedNotifier;

        private class MyHandler extends Handler {
            public static final int MESSAGE_NOTIFY_DISPLAY_SIZE_CHANGED = 4;
            public static final int MESSAGE_NOTIFY_IME_WINDOW_VISIBILITY_CHANGED = 5;
            public static final int MESSAGE_NOTIFY_MAGNIFICATION_REGION_CHANGED = 1;
            public static final int MESSAGE_NOTIFY_USER_CONTEXT_CHANGED = 3;
            final /* synthetic */ DisplayMagnifier this$0;

            MyHandler(DisplayMagnifier r1, Looper looper) {
                this.this$0 = r1;
                super(looper);
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch(message.what) {
                    case 1: goto L12;
                    case 2: goto L17;
                    case 3: goto L11;
                    case 4: goto L10;
                    case 5: goto L5;
                    default: goto L17;
                };
            L5:
                boolean shown = true;
                if (message.arg1 == 1) goto L9;
                shown = false;
            L9:
                DisplayMagnifier.m9598$$Nest$fgetmCallbacks(this.this$0).onImeWindowVisibilityChanged(shown);
                return;
            L10:
                DisplayMagnifier.m9598$$Nest$fgetmCallbacks(this.this$0).onDisplaySizeChanged();
                return;
            L11:
                DisplayMagnifier.m9598$$Nest$fgetmCallbacks(this.this$0).onUserContextChanged();
                return;
            L12:
                SomeArgs args = (SomeArgs) message.obj;
                Region magnifiedBounds = (Region) args.arg1;
                DisplayMagnifier.m9598$$Nest$fgetmCallbacks(this.this$0).onMagnificationRegionChanged(magnifiedBounds);
                magnifiedBounds.recycle();
                return;
            }
        }

        private class UserContextChangedNotifier {
            private final Handler mHandler;
            private boolean mHasDelayedNotificationForRecentsToFrontTransition;

            UserContextChangedNotifier(DisplayMagnifier r1, Handler handler) {
                this.mHandler = handler;
            }

            void onAppWindowTransition(int transition) {
                sendUserContextChangedNotification();
            }

            void onWMTransition(int type, int flags) {
                if ((flags & 128) == 0) goto L5;
                this.mHasDelayedNotificationForRecentsToFrontTransition = true;
                return;
            L5:
                sendUserContextChangedNotification();
            }

            void onWindowTransition(WindowState windowState, int transition) {
                if (transition == 2) goto L5;
                return;
            L5:
                if (windowState.isActivityTypeHomeOrRecents() == true) goto L7;
                return;
            L7:
                if (this.mHasDelayedNotificationForRecentsToFrontTransition == false) goto L12;
                this.mHasDelayedNotificationForRecentsToFrontTransition = false;
                return;
            }

            void onFocusLost(InputTarget target) {
                if (this.mHasDelayedNotificationForRecentsToFrontTransition == false) goto L6;
                sendUserContextChangedNotification();
                return;
            }

            private void sendUserContextChangedNotification() {
                this.mHasDelayedNotificationForRecentsToFrontTransition = false;
                this.mHandler.sendEmptyMessage(3);
            }
        }

        /* JADX INFO: renamed from: $r8$lambda$LQHd2e0QoyN5o2oS-7MpoKYnWvo, reason: not valid java name */
        public static /* synthetic */ void m9597$r8$lambda$LQHd2e0QoyN5o2oS7MpoKYnWvo(DisplayMagnifier r0, SparseArray r1, WindowState r2) {
            r0.lambda$populateWindowsOnScreen$0(r1, r2);
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmCallbacks, reason: not valid java name */
        static /* bridge */ /* synthetic */ WindowManagerInternal.MagnificationCallbacks m9598$$Nest$fgetmCallbacks(DisplayMagnifier r0) {
            return r0.mCallbacks;
        }

        DisplayMagnifier(WindowManagerService windowManagerService, DisplayContent displayContent, Display display, WindowManagerInternal.MagnificationCallbacks callbacks) {
            this.mTempRect1 = new Rect();
            this.mTempRect2 = new Rect();
            this.mTempRegion1 = new Region();
            this.mTempRegion2 = new Region();
            this.mTempRegion3 = new Region();
            this.mTempRegion4 = new Region();
            this.mIsFullscreenMagnificationActivated = false;
            this.mMagnificationRegion = new Region();
            this.mOldMagnificationRegion = new Region();
            this.mMagnificationSpec = new MagnificationSpec();
            this.mTempLayer = 0;
            this.mScreenSize = new Point();
            this.mTempWindowStates = new SparseArray();
            this.mTempMatrix = new Matrix();
            this.mDisplayContext = windowManagerService.mContext.createDisplayContext(display);
            this.mService = windowManagerService;
            this.mCallbacks = callbacks;
            this.mDisplayContent = displayContent;
            this.mDisplay = display;
            this.mHandler = new MyHandler(this, this.mService.mH.getLooper());
            this.mUserContextChangedNotifier = new UserContextChangedNotifier(this, this.mHandler);
            this.mAccessibilityTracing = AccessibilityController.getAccessibilityControllerInternal(this.mService);
            if (this.mDisplayContext.getResources().getConfiguration().isScreenRound() == false) goto L5;
            this.mCircularPath = new Path();
            getDisplaySizeLocked(this.mScreenSize);
            int centerXY = this.mScreenSize.x / 2;
            this.mCircularPath.addCircle(centerXY, centerXY, centerXY, Path.Direction.CW);
        L7:
            if (this.mAccessibilityTracing.isTracingEnabled(2048) == false) goto L9;
            this.mAccessibilityTracing.logTrace("WindowManager.DisplayMagnifier.constructor", 2048, "windowManagerService={" + windowManagerService + "}; displayContent={" + displayContent + "}; display={" + display + "}; callbacks={" + callbacks + "}");
        L9:
            recomputeBounds();
            return;
        L5:
            this.mCircularPath = null;
            goto L7
        }

        void setMagnificationSpec(MagnificationSpec spec) {
            if (this.mAccessibilityTracing.isTracingEnabled(2048) == false) goto L5;
            this.mAccessibilityTracing.logTrace("WindowManager.setMagnificationSpec", 2048, "spec={" + spec + "}");
        L5:
            updateMagnificationSpec(spec);
            recomputeBounds();
            this.mService.applyMagnificationSpecLocked(this.mDisplay.getDisplayId(), spec);
            this.mService.scheduleAnimationLocked();
        }

        void updateMagnificationSpec(MagnificationSpec spec) {
            if (spec == null) goto L4;
            this.mMagnificationSpec.initialize(spec.scale, spec.offsetX, spec.offsetY);
            return;
        L4:
            this.mMagnificationSpec.clear();
        }

        void setFullscreenMagnificationActivated(boolean activated) {
            if (this.mAccessibilityTracing.isTracingEnabled(2048) == false) goto L5;
            this.mAccessibilityTracing.logTrace("WindowManager.setFullscreenMagnificationActivated", 2048, "activated=" + activated);
        L5:
            this.mIsFullscreenMagnificationActivated = activated;
        }

        boolean isFullscreenMagnificationActivated() {
            if (this.mAccessibilityTracing.isTracingEnabled(2048) == false) goto L6;
            this.mAccessibilityTracing.logTrace("WindowManager.isFullscreenMagnificationActivated", 2048);
        L6:
            return this.mIsFullscreenMagnificationActivated;
        }

        void onDisplaySizeChanged(DisplayContent displayContent) {
            if (this.mAccessibilityTracing.isTracingEnabled(2048) == false) goto L5;
            this.mAccessibilityTracing.logTrace("WindowManager.onDisplaySizeChanged", 2048, "displayContent={" + displayContent + "}");
        L5:
            recomputeBounds();
            this.mHandler.sendEmptyMessage(4);
        }

        void onWMTransition(int displayId, int type, int flags) {
            if (this.mAccessibilityTracing.isTracingEnabled(2048) == false) goto L5;
            this.mAccessibilityTracing.logTrace("WindowManager.onWMTransition", 2048, "displayId=" + displayId + "; type=" + type + "; flags=" + flags);
        L5:
            boolean isMagnifierActivated = isFullscreenMagnificationActivated();
            if (isMagnifierActivated == true) goto L9;
            return;
        L9:
            if ((flags & 128) == 0) goto L11;
            boolean notify = true;
        L12:
            switch(type) {
                case 1: goto L14;
                case 2: goto L14;
                case 3: goto L14;
                case 4: goto L14;
                default: goto L15;
            };
        L14:
            notify = true;
        L15:
            if (notify == false) goto L18;
            this.mUserContextChangedNotifier.onWMTransition(type, flags);
            return;
        L18:
            return;
        L11:
            notify = false;
            goto L12
        }

        void onWindowTransition(WindowState windowState, int transition) {
            if (this.mAccessibilityTracing.isTracingEnabled(2048) == false) goto L5;
            this.mAccessibilityTracing.logTrace("WindowManager.onWindowTransition", 2048, "windowState={" + windowState + "}; transition=" + transition);
        L5:
            boolean isMagnifierActivated = isFullscreenMagnificationActivated();
            if (isMagnifierActivated == true) goto L8;
            return;
        L8:
            if (windowState.shouldMagnify() == false) goto L23;
            this.mUserContextChangedNotifier.onWindowTransition(windowState, transition);
            int type = windowState.mAttrs.type;
            switch(transition) {
                case 1: goto L13;
                case 2: goto L21;
                case 3: goto L13;
                default: goto L21;
            };
        L13:
            switch(type) {
                case 2: goto L15;
                case 4: goto L15;
                case 1000: goto L15;
                case 1001: goto L15;
                case 1002: goto L15;
                case 1003: goto L15;
                case 1005: goto L15;
                case 2001: goto L15;
                case 2002: goto L15;
                case 2003: goto L15;
                case 2005: goto L15;
                case 2006: goto L15;
                case 2007: goto L15;
                case 2008: goto L15;
                case 2009: goto L15;
                case 2010: goto L15;
                case 2020: goto L15;
                case 2024: goto L15;
                case 2035: goto L15;
                case 2038: goto L15;
                default: goto L22;
            };
        L15:
            Rect magnifiedRegionBounds = this.mTempRect2;
            getMagnifiedFrameInContentCoords(magnifiedRegionBounds);
            Rect touchableRegionBounds = this.mTempRect1;
            windowState.getTouchableRegion(this.mTempRegion1);
            this.mTempRegion1.getBounds(touchableRegionBounds);
            if (magnifiedRegionBounds.intersect(touchableRegionBounds) == true) goto L20;
            this.mCallbacks.onRectangleOnScreenRequested(touchableRegionBounds.left, touchableRegionBounds.top, touchableRegionBounds.right, touchableRegionBounds.bottom);
            return;
        L20:
            return;
        L22:
            return;
        L21:
            return;
        }

        void onFocusLost(InputTarget target) {
            boolean isMagnifierActivated = isFullscreenMagnificationActivated();
            if (isMagnifierActivated == true) goto L5;
            return;
        L5:
            this.mUserContextChangedNotifier.onFocusLost(target);
        }

        void getMagnifiedFrameInContentCoords(Rect rect) {
            this.mMagnificationRegion.getBounds(rect);
            rect.offset((int) (-this.mMagnificationSpec.offsetX), (int) (-this.mMagnificationSpec.offsetY));
            rect.scale(1.0f / this.mMagnificationSpec.scale);
        }

        void notifyImeWindowVisibilityChanged(boolean r6) {
            if (this.mAccessibilityTracing.isTracingEnabled(2048) == false) goto L5;
            this.mAccessibilityTracing.logTrace("WindowManager.notifyImeWindowVisibilityChanged", 2048, "shown=" + r6);
        L5:
            this.mHandler.obtainMessage(5, r6 ? 1 : 0, 0).sendToTarget();
        }

        MagnificationSpec getMagnificationSpecForWindow(WindowState windowState) {
            if (this.mAccessibilityTracing.isTracingEnabled(2048) == false) goto L6;
            this.mAccessibilityTracing.logTrace("WindowManager.getMagnificationSpecForWindow", 2048, "windowState={" + windowState + "}");
        L6:
            if (this.mMagnificationSpec == null) goto L14;
            if (this.mMagnificationSpec.isNop() == true) goto L14;
            if (windowState.shouldMagnify() == true) goto L14;
            return null;
        L14:
            return this.mMagnificationSpec;
        }

        void getMagnificationRegion(Region outMagnificationRegion) {
            if (this.mAccessibilityTracing.isTracingEnabled(2048) == false) goto L5;
            this.mAccessibilityTracing.logTrace("WindowManager.getMagnificationRegion", 2048, "outMagnificationRegion={" + outMagnificationRegion + "}");
        L5:
            recomputeBounds();
            outMagnificationRegion.set(this.mMagnificationRegion);
        }

        void destroy() {
            if (this.mAccessibilityTracing.isTracingEnabled(2048) == false) goto L6;
            this.mAccessibilityTracing.logTrace("WindowManager.destroy", 2048);
            return;
        }

        void recomputeMagnifiedRegionAndDrawMagnifiedRegionBorderIfNeeded() {
            if (this.mAccessibilityTracing.isTracingEnabled(2048) == false) goto L5;
            this.mAccessibilityTracing.logTrace("WindowManager.recomputeMagnifiedRegionAndDrawMagnifiedRegionBorderIfNeeded", 2048);
        L5:
            recomputeBounds();
        }

        void recomputeBounds() {
            getDisplaySizeLocked(this.mScreenSize);
            int screenWidth = this.mScreenSize.x;
            int screenHeight = this.mScreenSize.y;
            this.mMagnificationRegion.set(0, 0, 0, 0);
            Region availableBounds = this.mTempRegion1;
            availableBounds.set(0, 0, screenWidth, screenHeight);
            if (this.mCircularPath == null) goto L5;
            availableBounds.setPath(this.mCircularPath, availableBounds);
        L5:
            Region nonMagnifiedBounds = this.mTempRegion4;
            nonMagnifiedBounds.set(0, 0, 0, 0);
            SparseArray<WindowState> visibleWindows = this.mTempWindowStates;
            visibleWindows.clear();
            populateWindowsOnScreen(visibleWindows);
            int visibleWindowCount = visibleWindows.size();
            int i = visibleWindowCount - 1;
        L6:
            if (i < 0) goto L32;
            WindowState windowState = visibleWindows.valueAt(i);
            int windowType = windowState.mAttrs.type;
            if (isExcludedWindowType(windowType) == true) goto L31;
            if ((windowState.mAttrs.privateFlags & 2097152) != 0) goto L31;
            if ((windowState.mAttrs.privateFlags & 1048576) != 0) goto L31;
            Matrix matrix = this.mTempMatrix;
            AccessibilityController.m9590$$Nest$smpopulateTransformationMatrix(windowState, matrix);
            Region touchableRegion = this.mTempRegion3;
            windowState.getTouchableRegion(touchableRegion);
            Region windowBounds = this.mTempRegion2;
            touchableRegion.translate(-windowState.getFrame().left, -windowState.getFrame().top);
            applyMatrixToRegion(matrix, touchableRegion);
            windowBounds.set(touchableRegion);
            Region portionOfWindowAlreadyAccountedFor = this.mTempRegion3;
            portionOfWindowAlreadyAccountedFor.set(this.mMagnificationRegion);
            portionOfWindowAlreadyAccountedFor.op(nonMagnifiedBounds, Region.Op.UNION);
            windowBounds.op(portionOfWindowAlreadyAccountedFor, Region.Op.DIFFERENCE);
            if (windowState.shouldMagnify() == false) goto L17;
            this.mMagnificationRegion.op(windowBounds, Region.Op.UNION);
            this.mMagnificationRegion.op(availableBounds, Region.Op.INTERSECT);
        L19:
            if (AccessibilityController.isUntouchableNavigationBar(windowState, this.mTempRegion3) == false) goto L22;
            Rect navBarInsets = AccessibilityController.getSystemBarInsetsFrame(windowState);
            nonMagnifiedBounds.op(navBarInsets, Region.Op.UNION);
            availableBounds.op(navBarInsets, Region.Op.DIFFERENCE);
        L22:
            if (windowState.areAppWindowBoundsLetterboxed() == false) goto L24;
            Region letterboxBounds = getLetterboxBounds(windowState);
            nonMagnifiedBounds.op(letterboxBounds, Region.Op.UNION);
            availableBounds.op(letterboxBounds, Region.Op.DIFFERENCE);
        L24:
            Region windowBounds2 = this.mTempRegion2;
            windowBounds2.set(this.mMagnificationRegion);
            windowBounds2.op(nonMagnifiedBounds, Region.Op.UNION);
            windowBounds2.op(0, 0, screenWidth, screenHeight, Region.Op.INTERSECT);
            if (windowBounds2.isRect() == false) goto L31;
            Rect accountedFrame = this.mTempRect1;
            windowBounds2.getBounds(accountedFrame);
            if (accountedFrame.width() != screenWidth) goto L31;
            if (accountedFrame.height() != screenHeight) goto L31;
        L17:
            nonMagnifiedBounds.op(windowBounds, Region.Op.UNION);
            availableBounds.op(windowBounds, Region.Op.DIFFERENCE);
        L31:
            i = i - 1;
        L32:
            visibleWindows.clear();
            boolean magnifiedChanged = !this.mOldMagnificationRegion.equals(this.mMagnificationRegion);
            if (magnifiedChanged == false) goto L44;
            this.mOldMagnificationRegion.set(this.mMagnificationRegion);
            SomeArgs args = SomeArgs.obtain();
            args.arg1 = Region.obtain(this.mMagnificationRegion);
            this.mHandler.obtainMessage(1, args).sendToTarget();
            return;
        }

        private Region getLetterboxBounds(WindowState windowState) {
            ActivityRecord appToken = windowState.mActivityRecord;
            if (appToken == null) goto L5;
            Rect boundsWithoutLetterbox = windowState.getBounds();
            Rect letterboxInsets = appToken.getLetterboxInsets();
            Rect boundsIncludingLetterbox = Rect.copyOrNull(boundsWithoutLetterbox);
            boundsIncludingLetterbox.inset(Insets.subtract(Insets.NONE, Insets.of(letterboxInsets)));
            Region letterboxBounds = new Region();
            letterboxBounds.set(boundsIncludingLetterbox);
            letterboxBounds.op(boundsWithoutLetterbox, Region.Op.DIFFERENCE);
            return letterboxBounds;
        L5:
            return new Region();
        }

        private boolean isExcludedWindowType(int windowType) {
            if (windowType != 2027) goto L5;
        L8:
            return true;
        L5:
            if (windowType == 2039) goto L8;
            return false;
        }

        private void applyMatrixToRegion(Matrix matrix, Region region) {
            float[] transformArray = AccessibilityController.m9589$$Nest$sfgetsTempFloats();
            matrix.getValues(transformArray);
            region.scale(transformArray[0]);
            region.translate((int) transformArray[2], (int) transformArray[5]);
        }

        private void populateWindowsOnScreen(final SparseArray<WindowState> outWindows) {
            this.mTempLayer = 0;
            this.mDisplayContent.forAllWindows(new AccessibilityController$DisplayMagnifier$$ExternalSyntheticLambda0(this, outWindows), false);
        }

        private /* synthetic */ void lambda$populateWindowsOnScreen$0(SparseArray outWindows, WindowState w) {
            if (w.isOnScreen() == true) goto L5;
            return;
        L5:
            if (w.isVisible() == true) goto L7;
            return;
        L7:
            if (w.mAttrs.alpha == 0.0f) goto L12;
            this.mTempLayer++;
            outWindows.put(this.mTempLayer, w);
            return;
        }

        private void getDisplaySizeLocked(Point outSize) {
            Rect bounds = this.mDisplayContent.getConfiguration().windowConfiguration.getBounds();
            outSize.set(bounds.width(), bounds.height());
        }
    }

    private static final class WindowsForAccessibilityObserver {
        private static final boolean DEBUG = false;
        private static final String LOG_TAG = "WindowManager";
        private final AccessibilityWindowsPopulator mA11yWindowsPopulator;
        private final AccessibilityControllerInternalImpl mAccessibilityTracing;
        private final WindowManagerInternal.WindowsForAccessibilityCallback mCallback;
        private final int mDisplayId;
        private final Handler mHandler;
        private boolean mInitialized;
        private final long mRecurringAccessibilityEventsIntervalMillis;
        private final WindowManagerService mService;

        private class MyHandler extends Handler {
            public static final int MESSAGE_COMPUTE_CHANGED_WINDOWS = 1;
            final /* synthetic */ WindowsForAccessibilityObserver this$0;

            public MyHandler(WindowsForAccessibilityObserver r2, Looper looper) {
                this.this$0 = r2;
                super(looper, null, false);
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch(message.what) {
                    case 1: goto L5;
                    default: goto L7;
                };
            L5:
                this.this$0.computeChangedWindows(false);
                return;
            }
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmInitialized, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m9599$$Nest$fgetmInitialized(WindowsForAccessibilityObserver r0) {
            return r0.mInitialized;
        }

        WindowsForAccessibilityObserver(WindowManagerService windowManagerService, int displayId, WindowManagerInternal.WindowsForAccessibilityCallback callback, AccessibilityWindowsPopulator accessibilityWindowsPopulator) {
            this.mService = windowManagerService;
            this.mCallback = callback;
            this.mDisplayId = displayId;
            this.mHandler = new MyHandler(this, this.mService.mH.getLooper());
            this.mAccessibilityTracing = AccessibilityController.getAccessibilityControllerInternal(this.mService);
            this.mRecurringAccessibilityEventsIntervalMillis = ViewConfiguration.getSendRecurringAccessibilityEventsInterval();
            this.mA11yWindowsPopulator = accessibilityWindowsPopulator;
            computeChangedWindows(true);
        }

        void performComputeChangedWindows(boolean forceSend) {
            if (this.mAccessibilityTracing.isTracingEnabled(DeviceStorageMonitorServiceSmtEx.TrafficStats.KB_IN_BYTES) == false) goto L5;
            this.mAccessibilityTracing.logTrace("WindowManager.performComputeChangedWindows", DeviceStorageMonitorServiceSmtEx.TrafficStats.KB_IN_BYTES, "forceSend=" + forceSend);
        L5:
            this.mHandler.removeMessages(1);
            computeChangedWindows(forceSend);
        }

        void scheduleComputeChangedWindows() {
            if (this.mAccessibilityTracing.isTracingEnabled(DeviceStorageMonitorServiceSmtEx.TrafficStats.KB_IN_BYTES) == false) goto L6;
            this.mAccessibilityTracing.logTrace("WindowManager.scheduleComputeChangedWindows", DeviceStorageMonitorServiceSmtEx.TrafficStats.KB_IN_BYTES);
        L6:
            if (this.mHandler.hasMessages(1) == true) goto L9;
            this.mHandler.sendEmptyMessageDelayed(1, this.mRecurringAccessibilityEventsIntervalMillis);
            return;
        }

        void computeChangedWindows(boolean forceSend) {
            if (this.mAccessibilityTracing.isTracingEnabled(DeviceStorageMonitorServiceSmtEx.TrafficStats.KB_IN_BYTES) == false) goto L5;
            this.mAccessibilityTracing.logTrace("WindowManager.computeChangedWindows", DeviceStorageMonitorServiceSmtEx.TrafficStats.KB_IN_BYTES, "forceSend=" + forceSend);
        L5:
            List<AccessibilityWindowsPopulator.AccessibilityWindow> visibleWindows = new ArrayList();
            Point screenSize = new Point();
            WindowManagerGlobalLock r1 = this.mService.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r1);
            WindowState topFocusedWindowState = getTopFocusWindow();     // Catch: Throwable -> L28
            if (topFocusedWindowState != null) goto L14;
            monitor-exit(r1);     // Catch: Throwable -> L12
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L14:
            DisplayContent dc = this.mService.mRoot.getDisplayContent(this.mDisplayId);     // Catch: Throwable -> L28
            if (dc != null) goto L20;
            Slog.w(LOG_TAG, "display content is null, should be created later");     // Catch: Throwable -> L12
            monitor-exit(r1);     // Catch: Throwable -> L12
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L20:
            Display display = dc.getDisplay();     // Catch: Throwable -> L28
            display.getRealSize(screenSize);     // Catch: Throwable -> L28
            this.mA11yWindowsPopulator.populateVisibleWindowsOnScreenLocked(this.mDisplayId, visibleWindows);     // Catch: Throwable -> L28
            int topFocusedDisplayId = this.mService.mRoot.getTopFocusedDisplayContent().getDisplayId();     // Catch: Throwable -> L28
            IBinder topFocusedWindowToken = topFocusedWindowState.mClient.asBinder();     // Catch: Throwable -> L28
            monitor-exit(r1);     // Catch: Throwable -> L28
            WindowManagerService.resetPriorityAfterLockedSection();
            this.mCallback.onAccessibilityWindowsChanged(forceSend, topFocusedDisplayId, topFocusedWindowToken, screenSize, visibleWindows);
            Iterator<AccessibilityWindowsPopulator.AccessibilityWindow> r9 = visibleWindows.iterator();
        L24:
            if (r9.hasNext() == false) goto L26;
            AccessibilityWindowsPopulator.AccessibilityWindow window = r9.next();
            window.getWindowInfo().recycle();
            goto L24
        L26:
            this.mInitialized = true;
            return;
        L12:
            th = th;
        L38:
            monitor-exit(r1);     // Catch: Throwable -> L33
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        L33:
            th = th;
        L28:
            th = th;
            goto L38
        }

        private WindowState getTopFocusWindow() {
            return this.mService.mRoot.getTopFocusedDisplayContent().mCurrentFocus;
        }

        public String toString() {
            return "WindowsForAccessibilityObserver{mDisplayId=" + this.mDisplayId + ", mInitialized=" + this.mInitialized + '}';
        }
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetSTATIC_LOCK, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m9587$$Nest$sfgetSTATIC_LOCK() {
        return STATIC_LOCK;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetTAG, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m9588$$Nest$sfgetTAG() {
        return TAG;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetsTempFloats, reason: not valid java name */
    static /* bridge */ /* synthetic */ float[] m9589$$Nest$sfgetsTempFloats() {
        return sTempFloats;
    }

    /* JADX INFO: renamed from: -$$Nest$smpopulateTransformationMatrix, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9590$$Nest$smpopulateTransformationMatrix(WindowState r0, Matrix r1) {
        populateTransformationMatrix(r0, r1);
    }

    static {
        TAG = AccessibilityController.class.getSimpleName();
        STATIC_LOCK = new Object();
        EMPTY_RECT = new Rect();
        sTempFloats = new float[9];
    }

    static AccessibilityControllerInternalImpl getAccessibilityControllerInternal(WindowManagerService service) {
        return AccessibilityControllerInternalImpl.getInstance(service);
    }

    AccessibilityController(WindowManagerService service) {
        this.mDisplayMagnifiers = new SparseArray();
        this.mWindowsForAccessibilityObserver = new SparseArray();
        this.mFocusedWindow = new SparseArray();
        this.mFocusedDisplay = -1;
        this.mIsImeVisibleArray = new SparseBooleanArray();
        this.mAllObserversInitialized = true;
        this.mService = service;
        this.mAccessibilityTracing = getAccessibilityControllerInternal(service);
        this.mAccessibilityWindowsPopulator = new AccessibilityWindowsPopulator(this.mService, this);
    }

    boolean setMagnificationCallbacks(int displayId, WindowManagerInternal.MagnificationCallbacks callbacks) {
        if (this.mAccessibilityTracing.isTracingEnabled(2048) == false) goto L6;
        this.mAccessibilityTracing.logTrace(TAG + ".setMagnificationCallbacks", 2048, "displayId=" + displayId + "; callbacks={" + callbacks + "}");
    L6:
        if (callbacks != null) goto L8;
        DisplayMagnifier displayMagnifier = this.mDisplayMagnifiers.get(displayId);
        if (displayMagnifier == null) goto L22;
        displayMagnifier.destroy();
        this.mDisplayMagnifiers.remove(displayId);
        return true;
    L22:
        throw new IllegalStateException("Magnification callbacks already cleared!");
    L8:
        if (this.mDisplayMagnifiers.get(displayId) != null) goto L16;
        DisplayContent dc = this.mService.mRoot.getDisplayContent(displayId);
        if (dc == null) goto L24;
        Display display = dc.getDisplay();
        if (display == null) goto L25;
        DisplayMagnifier magnifier = new DisplayMagnifier(this.mService, dc, display, callbacks);
        magnifier.notifyImeWindowVisibilityChanged(this.mIsImeVisibleArray.get(displayId, false));
        this.mDisplayMagnifiers.put(displayId, magnifier);
        return true;
    L25:
        return false;
    L24:
        return false;
    L16:
        throw new IllegalStateException("Magnification callbacks already set!");
    }

    void setWindowsForAccessibilityCallback(int displayId, WindowManagerInternal.WindowsForAccessibilityCallback callback) {
        if (this.mAccessibilityTracing.isTracingEnabled(DeviceStorageMonitorServiceSmtEx.TrafficStats.KB_IN_BYTES) == false) goto L6;
        this.mAccessibilityTracing.logTrace(TAG + ".setWindowsForAccessibilityCallback", DeviceStorageMonitorServiceSmtEx.TrafficStats.KB_IN_BYTES, "displayId=" + displayId + "; callback={" + callback + "}");
    L6:
        if (callback != null) goto L8;
        WindowsForAccessibilityObserver windowsForA11yObserver = this.mWindowsForAccessibilityObserver.get(displayId);
        if (windowsForA11yObserver != null) goto L22;
        String errorMessage = "Windows for accessibility callback of display " + displayId + " already cleared!";
        Slog.e(TAG, errorMessage);
        if (Build.IS_DEBUGGABLE == false) goto L22;
        throw new IllegalStateException(errorMessage);
    L22:
        this.mWindowsForAccessibilityObserver.remove(displayId);
        if (this.mWindowsForAccessibilityObserver.size() > 0) goto L27;
        this.mAccessibilityWindowsPopulator.setWindowsNotification(false);
        return;
    L27:
        return;
    L8:
        if (this.mWindowsForAccessibilityObserver.get(displayId) == null) goto L14;
        String errorMessage2 = "Windows for accessibility callback of display " + displayId + " already set!";
        Slog.e(TAG, errorMessage2);
        if (Build.IS_DEBUGGABLE == true) goto L13;
        this.mWindowsForAccessibilityObserver.remove(displayId);
        goto L14
    L13:
        throw new IllegalStateException(errorMessage2);
    L14:
        this.mAccessibilityWindowsPopulator.setWindowsNotification(true);
        WindowsForAccessibilityObserver observer = new WindowsForAccessibilityObserver(this.mService, displayId, callback, this.mAccessibilityWindowsPopulator);
        this.mWindowsForAccessibilityObserver.put(displayId, observer);
        this.mAllObserversInitialized &= WindowsForAccessibilityObserver.m9599$$Nest$fgetmInitialized(observer);
    }

    void performComputeChangedWindowsNot(int displayId, boolean forceSend) {
        if (this.mAccessibilityTracing.isTracingEnabled(DeviceStorageMonitorServiceSmtEx.TrafficStats.KB_IN_BYTES) == false) goto L5;
        this.mAccessibilityTracing.logTrace(TAG + ".performComputeChangedWindowsNot", DeviceStorageMonitorServiceSmtEx.TrafficStats.KB_IN_BYTES, "displayId=" + displayId + "; forceSend=" + forceSend);
    L5:
        WindowsForAccessibilityObserver observer = null;
        WindowManagerGlobalLock r1 = this.mService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r1);
        WindowsForAccessibilityObserver windowsForA11yObserver = this.mWindowsForAccessibilityObserver.get(displayId);     // Catch: Throwable -> L15
        if (windowsForA11yObserver == null) goto L10;
        observer = windowsForA11yObserver;
    L10:
        monitor-exit(r1);     // Catch: Throwable -> L15
        WindowManagerService.resetPriorityAfterLockedSection();
        if (observer == null) goto L21;
        observer.performComputeChangedWindows(forceSend);
        return;
    L21:
        return;
    L15:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    void setMagnificationSpec(int displayId, MagnificationSpec spec) {
        if (this.mAccessibilityTracing.isTracingEnabled(3072) == false) goto L5;
        this.mAccessibilityTracing.logTrace(TAG + ".setMagnificationSpec", 3072, "displayId=" + displayId + "; spec={" + spec + "}");
    L5:
        this.mAccessibilityWindowsPopulator.setMagnificationSpec(displayId, spec);
        DisplayMagnifier displayMagnifier = this.mDisplayMagnifiers.get(displayId);
        if (displayMagnifier == null) goto L8;
        displayMagnifier.setMagnificationSpec(spec);
    L8:
        WindowsForAccessibilityObserver windowsForA11yObserver = this.mWindowsForAccessibilityObserver.get(displayId);
        if (windowsForA11yObserver == null) goto L12;
        windowsForA11yObserver.scheduleComputeChangedWindows();
        return;
    }

    void getMagnificationRegion(int displayId, Region outMagnificationRegion) {
        if (this.mAccessibilityTracing.isTracingEnabled(2048) == false) goto L5;
        this.mAccessibilityTracing.logTrace(TAG + ".getMagnificationRegion", 2048, "displayId=" + displayId + "; outMagnificationRegion={" + outMagnificationRegion + "}");
    L5:
        DisplayMagnifier displayMagnifier = this.mDisplayMagnifiers.get(displayId);
        if (displayMagnifier == null) goto L9;
        displayMagnifier.getMagnificationRegion(outMagnificationRegion);
        return;
    }

    void onDisplaySizeChanged(DisplayContent displayContent) {
        if (this.mAccessibilityTracing.isTracingEnabled(3072) == false) goto L5;
        this.mAccessibilityTracing.logTrace(TAG + ".onRotationChanged", 3072, "displayContent={" + displayContent + "}");
    L5:
        int displayId = displayContent.getDisplayId();
        DisplayMagnifier displayMagnifier = this.mDisplayMagnifiers.get(displayId);
        if (displayMagnifier == null) goto L9;
        displayMagnifier.onDisplaySizeChanged(displayContent);
        return;
    }

    void onWMTransition(int displayId, int type, int flags) {
        if (this.mAccessibilityTracing.isTracingEnabled(2048) == false) goto L5;
        this.mAccessibilityTracing.logTrace(TAG + ".onWMTransition", 2048, "displayId=" + displayId + "; type=" + type + "; flags=" + flags);
    L5:
        DisplayMagnifier displayMagnifier = this.mDisplayMagnifiers.get(displayId);
        if (displayMagnifier == null) goto L9;
        displayMagnifier.onWMTransition(displayId, type, flags);
        return;
    }

    void onWindowTransition(WindowState windowState, int transition) {
        if (this.mAccessibilityTracing.isTracingEnabled(3072) == false) goto L5;
        this.mAccessibilityTracing.logTrace(TAG + ".onWindowTransition", 3072, "windowState={" + windowState + "}; transition=" + transition);
    L5:
        int displayId = windowState.getDisplayId();
        DisplayMagnifier displayMagnifier = this.mDisplayMagnifiers.get(displayId);
        if (displayMagnifier == null) goto L9;
        displayMagnifier.onWindowTransition(windowState, transition);
        return;
    }

    void onWindowFocusChangedNot(int displayId) {
        if (this.mAccessibilityTracing.isTracingEnabled(DeviceStorageMonitorServiceSmtEx.TrafficStats.KB_IN_BYTES) == false) goto L5;
        this.mAccessibilityTracing.logTrace(TAG + ".onWindowFocusChangedNot", DeviceStorageMonitorServiceSmtEx.TrafficStats.KB_IN_BYTES, "displayId=" + displayId);
    L5:
        WindowsForAccessibilityObserver observer = null;
        WindowManagerGlobalLock r1 = this.mService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r1);
        WindowsForAccessibilityObserver windowsForA11yObserver = this.mWindowsForAccessibilityObserver.get(displayId);     // Catch: Throwable -> L16
        if (windowsForA11yObserver == null) goto L10;
        observer = windowsForA11yObserver;
    L10:
        monitor-exit(r1);     // Catch: Throwable -> L16
        WindowManagerService.resetPriorityAfterLockedSection();
        if (observer == null) goto L14;
        observer.performComputeChangedWindows(false);
    L14:
        sendCallbackToUninitializedObserversIfNeeded();
        return;
    L16:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    private void sendCallbackToUninitializedObserversIfNeeded() {
        WindowManagerGlobalLock r0 = this.mService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
    L9:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    L5:
        if (this.mAllObserversInitialized == false) goto L12;
        monitor-exit(r0);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L12:
        if (this.mService.mRoot.getTopFocusedDisplayContent().mCurrentFocus != null) goto L16;
        monitor-exit(r0);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L16:
        List<WindowsForAccessibilityObserver> unInitializedObservers = new ArrayList();     // Catch: Throwable -> L9
        int i = this.mWindowsForAccessibilityObserver.size() - 1;     // Catch: Throwable -> L9
    L17:
        if (i < 0) goto L22;
        WindowsForAccessibilityObserver observer = this.mWindowsForAccessibilityObserver.valueAt(i);     // Catch: Throwable -> L9
        if (WindowsForAccessibilityObserver.m9599$$Nest$fgetmInitialized(observer) == true) goto L21;
        unInitializedObservers.add(observer);     // Catch: Throwable -> L9
    L21:
        i = i - 1;     // Catch: Throwable -> L9
        goto L17
    L22:
        this.mAllObserversInitialized = true;     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        boolean areAllObserversInitialized = true;
        int i2 = unInitializedObservers.size() - 1;
    L25:
        if (i2 < 0) goto L27;
        WindowsForAccessibilityObserver observer2 = unInitializedObservers.get(i2);
        observer2.performComputeChangedWindows(true);
        areAllObserversInitialized = areAllObserversInitialized & WindowsForAccessibilityObserver.m9599$$Nest$fgetmInitialized(observer2);
        i2 = i2 - 1;
        goto L25
    L27:
        WindowManagerGlobalLock r3 = this.mService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r3);
        this.mAllObserversInitialized &= areAllObserversInitialized;     // Catch: Throwable -> L33
        monitor-exit(r3);     // Catch: Throwable -> L33
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L33:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    void onSomeWindowResizedOrMoved(int... displayIds) {
        onSomeWindowResizedOrMovedWithCallingUid(Binder.getCallingUid(), displayIds);
    }

    void onSomeWindowResizedOrMovedWithCallingUid(int callingUid, int... displayIds) {
        if (this.mAccessibilityTracing.isTracingEnabled(DeviceStorageMonitorServiceSmtEx.TrafficStats.KB_IN_BYTES) == false) goto L6;
        this.mAccessibilityTracing.logTrace(TAG + ".onSomeWindowResizedOrMoved", DeviceStorageMonitorServiceSmtEx.TrafficStats.KB_IN_BYTES, "displayIds={" + Arrays.toString(displayIds) + "}", "".getBytes(), callingUid);
    L6:
        int i = 0;
    L8:
        if (i >= displayIds.length) goto L14;
        WindowsForAccessibilityObserver windowsForA11yObserver = this.mWindowsForAccessibilityObserver.get(displayIds[i]);
        if (windowsForA11yObserver == null) goto L12;
        windowsForA11yObserver.scheduleComputeChangedWindows();
    L12:
        i = i + 1;
        goto L8
    }

    void recomputeMagnifiedRegionAndDrawMagnifiedRegionBorderIfNeeded(int displayId) {
        if (this.mAccessibilityTracing.isTracingEnabled(2048) == false) goto L5;
        this.mAccessibilityTracing.logTrace(TAG + ".recomputeMagnifiedRegionAndDrawMagnifiedRegionBorderIfNeeded", 2048, "displayId=" + displayId);
    L5:
        DisplayMagnifier displayMagnifier = this.mDisplayMagnifiers.get(displayId);
        if (displayMagnifier == null) goto L9;
        displayMagnifier.recomputeMagnifiedRegionAndDrawMagnifiedRegionBorderIfNeeded();
        return;
    }

    public Pair<Matrix, MagnificationSpec> getWindowTransformationMatrixAndMagnificationSpec(IBinder token) {
        WindowManagerGlobalLock r0 = this.mService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        Matrix transformationMatrix = new Matrix();     // Catch: Throwable -> L13
        MagnificationSpec magnificationSpec = new MagnificationSpec();     // Catch: Throwable -> L13
        WindowState windowState = this.mService.mWindowMap.get(token);     // Catch: Throwable -> L13
        if (windowState == null) goto L15;
        windowState.getTransformationMatrix(new float[9], transformationMatrix);     // Catch: Throwable -> L13
        if (hasCallbacks() == false) goto L15;
        MagnificationSpec otherMagnificationSpec = getMagnificationSpecForWindow(windowState);     // Catch: Throwable -> L13
        if (otherMagnificationSpec == null) goto L15;
        if (otherMagnificationSpec.isNop() == true) goto L15;
        magnificationSpec.setTo(otherMagnificationSpec);     // Catch: Throwable -> L13
    L15:
        Pair<Matrix, MagnificationSpec> r4 = new Pair(transformationMatrix, magnificationSpec);     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        WindowManagerService.resetPriorityAfterLockedSection();
        return r4;
    L13:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    MagnificationSpec getMagnificationSpecForWindow(WindowState windowState) {
        if (this.mAccessibilityTracing.isTracingEnabled(2048) == false) goto L5;
        this.mAccessibilityTracing.logTrace(TAG + ".getMagnificationSpecForWindow", 2048, "windowState={" + windowState + "}");
    L5:
        int displayId = windowState.getDisplayId();
        DisplayMagnifier displayMagnifier = this.mDisplayMagnifiers.get(displayId);
        if (displayMagnifier != null) goto L8;
        return null;
    L8:
        return displayMagnifier.getMagnificationSpecForWindow(windowState);
    }

    boolean hasCallbacks() {
        if (this.mAccessibilityTracing.isTracingEnabled(3072) == false) goto L6;
        this.mAccessibilityTracing.logTrace(TAG + ".hasCallbacks", 3072);
    L6:
        if (this.mDisplayMagnifiers.size() <= 0) goto L8;
    L11:
        return true;
    L8:
        if (this.mWindowsForAccessibilityObserver.size() > 0) goto L11;
        return false;
    }

    void setFullscreenMagnificationActivated(int displayId, boolean activated) {
        if (this.mAccessibilityTracing.isTracingEnabled(2048) == false) goto L5;
        this.mAccessibilityTracing.logTrace(TAG + ".setFullscreenMagnificationActivated", 2048, "displayId=" + displayId + "; activated=" + activated);
    L5:
        DisplayMagnifier displayMagnifier = this.mDisplayMagnifiers.get(displayId);
        if (displayMagnifier == null) goto L9;
        displayMagnifier.setFullscreenMagnificationActivated(activated);
        return;
    }

    void updateImeVisibilityIfNeeded(int displayId, boolean shown) {
        if (this.mAccessibilityTracing.isTracingEnabled(2048) == false) goto L5;
        this.mAccessibilityTracing.logTrace(TAG + ".updateImeVisibilityIfNeeded", 2048, "displayId=" + displayId + ";shown=" + shown);
    L5:
        boolean isDisplayImeVisible = this.mIsImeVisibleArray.get(displayId, false);
        if (isDisplayImeVisible != shown) goto L8;
        return;
    L8:
        this.mIsImeVisibleArray.put(displayId, shown);
        DisplayMagnifier displayMagnifier = this.mDisplayMagnifiers.get(displayId);
        if (displayMagnifier == null) goto L12;
        displayMagnifier.notifyImeWindowVisibilityChanged(shown);
        return;
    }

    private static void populateTransformationMatrix(WindowState windowState, Matrix outMatrix) {
        windowState.getTransformationMatrix(sTempFloats, outMatrix);
    }

    void dump(PrintWriter pw, String prefix) {
        DumpUtils.dumpSparseArrayValues(pw, prefix, this.mWindowsForAccessibilityObserver, "windows for accessibility observer");
        this.mAccessibilityWindowsPopulator.dump(pw, prefix);
    }

    void onFocusChanged(InputTarget lastTarget, InputTarget newTarget) {
        if (lastTarget == null) goto L6;
        this.mFocusedWindow.remove(lastTarget.getDisplayId());
        DisplayMagnifier displayMagnifier = this.mDisplayMagnifiers.get(lastTarget.getDisplayId());
        if (displayMagnifier == null) goto L6;
        displayMagnifier.onFocusLost(lastTarget);
    L6:
        if (newTarget == null) goto L9;
        int displayId = newTarget.getDisplayId();
        IBinder clientBinder = newTarget.getWindowToken();
        this.mFocusedWindow.put(displayId, clientBinder);
        return;
    }

    public void onDisplayRemoved(int displayId) {
        this.mIsImeVisibleArray.delete(displayId);
        this.mFocusedWindow.remove(displayId);
    }

    public void setFocusedDisplay(int focusedDisplayId) {
        this.mFocusedDisplay = focusedDisplayId;
    }

    IBinder getFocusedWindowToken() {
        return this.mFocusedWindow.get(this.mFocusedDisplay);
    }

    static boolean isUntouchableNavigationBar(WindowState windowState, Region touchableRegion) {
        if (windowState.mAttrs.type == 2019) goto L6;
        return false;
    L6:
        windowState.getTouchableRegion(touchableRegion);
        return touchableRegion.isEmpty();
    }

    static Rect getSystemBarInsetsFrame(WindowState win) {
        if (win == null) goto L4;
        InsetsSourceProvider provider = win.getControllableInsetProvider();
        if (provider == null) goto L9;
        return provider.getSource().getFrame();
    L9:
        return EMPTY_RECT;
    L4:
        return EMPTY_RECT;
    }
}
