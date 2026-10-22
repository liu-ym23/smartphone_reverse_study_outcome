package com.ttnet.org.chromium.base;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Looper;
import android.os.MessageQueue;
import android.util.Log;
import android.util.Printer;
import android.view.View;
import android.view.ViewGroup;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes4.dex */
public class TraceEvent implements AutoCloseable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f37671a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static AtomicBoolean f37672b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static AtomicBoolean f37673c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f37674d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static ATrace f37675e;
    private final String f;

    /* JADX INFO: renamed from: com.ttnet.org.chromium.base.TraceEvent$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class ATrace implements MessageQueue.IdleHandler {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final String TAG = "ATrace";
        private Method mAsyncTraceBeginMethod;
        private Method mAsyncTraceEndMethod;
        private Method mGetSystemPropertyMethod;
        private boolean mIdleHandlerRegistered;
        private Method mIsTraceTagEnabledMethod;
        private final AtomicBoolean mNativeTracingReady;
        private boolean mShouldWriteToSystemTrace;
        private Class<?> mSystemPropertiesClass;
        private Method mTraceBeginMethod;
        private Class<?> mTraceClass;
        private Method mTraceEndMethod;
        private final long mTraceTag;
        private final AtomicBoolean mTraceTagActive;
        private final AtomicBoolean mUiThreadReady;

        private static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public String f37676a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public boolean f37677b;

            private a() {
                this.f37676a = "";
                this.f37677b = true;
            }

            /* synthetic */ a(AnonymousClass1 r1) {
                this();
            }
        }

        static {
        }

        public ATrace(long r10) {
            this.mNativeTracingReady = new AtomicBoolean();
            this.mUiThreadReady = new AtomicBoolean();
            this.mTraceTagActive = new AtomicBoolean();
            Class<?> r3 = ZeusTransformUtils.forName("android.os.Trace", "com.obric.aiagent.plugin");     // Catch: Exception -> L5
            this.mTraceClass = r3;     // Catch: Exception -> L5
            this.mIsTraceTagEnabledMethod = r3.getMethod("isTagEnabled", new Class[]{Long.TYPE});     // Catch: Exception -> L5
            this.mTraceBeginMethod = this.mTraceClass.getMethod("traceBegin", new Class[]{Long.TYPE, String.class});     // Catch: Exception -> L5
            this.mTraceEndMethod = this.mTraceClass.getMethod("traceEnd", new Class[]{Long.TYPE});     // Catch: Exception -> L5
            this.mAsyncTraceBeginMethod = this.mTraceClass.getMethod("asyncTraceBegin", new Class[]{Long.TYPE, String.class, Integer.TYPE});     // Catch: Exception -> L5
            this.mAsyncTraceEndMethod = this.mTraceClass.getMethod("asyncTraceEnd", new Class[]{Long.TYPE, String.class, Integer.TYPE});     // Catch: Exception -> L5
            Class<?> r0 = ZeusTransformUtils.forName("android.os.SystemProperties", "com.obric.aiagent.plugin");     // Catch: Exception -> L5
            this.mSystemPropertiesClass = r0;     // Catch: Exception -> L5
            this.mGetSystemPropertyMethod = r0.getMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class});     // Catch: Exception -> L5
        L7:
            this.mTraceTag = r10;
            pollConfig();
            return;
        L5:
            e = move-exception;
            j.d(TAG, "Reflection error", new Object[]{e});
            this.mIsTraceTagEnabledMethod = null;
            goto L7
        }

        private String getSystemProperty(String r4) {
            return (String) ZeusTransformUtils.preCheckCast(this.mGetSystemPropertyMethod.invoke(this.mSystemPropertiesClass, new Object[]{r4}), String.class, "com.obric.aiagent.plugin");
        L4:
            return null;
        }

        private Integer getIntegerSystemProperty(String r1) {
            String r0 = getSystemProperty(r1);
            if (r0 != null) goto L8;
            return null;
        L8:
            return Integer.decode(r0);
        L7:
            return null;
        }

        private boolean isTraceTagEnabled(long r4) {
            return ((Boolean) ZeusTransformUtils.preCheckCast(this.mIsTraceTagEnabledMethod.invoke(this.mTraceClass, new Object[]{Long.valueOf(r4)}), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
        L5:
            return false;
        }

        public boolean hasActiveSession() {
            return this.mTraceTagActive.get();
        }

        private boolean pollConfig() {
            boolean r0 = this.mTraceTagActive.get();
            boolean r1 = isTraceTagEnabled(this.mTraceTag);
            if (r0 != r1) goto L5;
            return false;
        L5:
            this.mTraceTagActive.set(r1);
            if (r1 == true) goto L9;
            EarlyTraceEvent.b();
            disableNativeATrace();
            this.mShouldWriteToSystemTrace = false;
            ThreadUtils.e().setMessageLogging(null);
            return true;
        L9:
            a r2 = getCategoryConfigFromATrace();
            this.mShouldWriteToSystemTrace = false;
            if (this.mNativeTracingReady.get() == false) goto L16;
            if (r2.f37677b == false) goto L14;
            enableNativeATrace(r2.f37676a);
        L20:
            if (r2.f37677b == true) goto L22;
            ThreadUtils.e().setMessageLogging(a.a());
        L22:
            return true;
        L14:
            setupATraceStartupTrace(r2.f37676a);
            goto L20
        L16:
            if (r2.f37677b == false) goto L18;
            this.mShouldWriteToSystemTrace = true;
            goto L20
        L18:
            EarlyTraceEvent.a();
            goto L20
        }

        private a getCategoryConfigFromATrace() {
            a r0 = new a(null);
            Integer r1 = getIntegerSystemProperty("debug.atrace.app_number");
            if (r1 != null) goto L5;
        L30:
            return r0;
        L5:
            if (r1.intValue() <= 0) goto L30;
            if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(d.a(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) == null) goto L30;
            String r2 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(d.a(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getPackageName();
            int r4 = 0;
        L10:
            if (r4 >= r1.intValue()) goto L30;
            String r5 = getSystemProperty("debug.atrace.app_" + r4);
            if (r5 == null) goto L29;
            if (r5.startsWith(r2) == false) goto L29;
            String r6 = r5.substring(r2.length());
            if (r6.startsWith("/") == false) goto L29;
            String[] r7 = r6.substring(1).split(":");
            int r8 = r7.length;
            int r9 = 0;
        L20:
            if (r9 >= r8) goto L29;
            String r10 = r7[r9];
            if (r10.equals("-atrace") == false) goto L25;
            r0.f37677b = false;
        L28:
            r9 = r9 + 1;
            goto L20
        L25:
            if (r0.f37676a.length() <= 0) goto L27;
            r0.f37676a += ",";
        L27:
            r0.f37676a += r10;
        L29:
            r4 = r4 + 1;
            goto L10
        }

        public void onNativeTracingReady() {
            this.mNativeTracingReady.set(true);
            this.mTraceTagActive.set(false);
            if (this.mUiThreadReady.get() == false) goto L6;
            ThreadUtils.b(new $$Lambda$TraceEvent$ATrace$4DuWoc4Q084rsdEHxWV0pFWbiHE(this));
            return;
        }

        public /* synthetic */ void lambda$onNativeTracingReady$0$TraceEvent$ATrace() {
            pollConfig();
        }

        public void onUiThreadReady() {
            this.mUiThreadReady.set(true);
            if (ThreadUtils.d() == true) goto L6;
            ThreadUtils.b(new $$Lambda$TraceEvent$ATrace$KycSHB56BRcah8i9gdOSAWj31k(this));
            return;
        L6:
            startPolling();
        }

        public /* synthetic */ void lambda$onUiThreadReady$1$TraceEvent$ATrace() {
            startPolling();
        }

        private void startPolling() {
            ThreadUtils.b();
            if (this.mIdleHandlerRegistered == true) goto L5;
            Looper.myQueue().addIdleHandler(this);
            this.mIdleHandlerRegistered = true;
        L5:
            pollConfig();
        }

        @Override // android.os.MessageQueue.IdleHandler
        public final boolean queueIdle() {
            pollConfig();
            return true;
        }

        private void enableNativeATrace(String r1) {
            v.d().a(r1);
        }

        private void disableNativeATrace() {
            v.d().a();
        }

        private void setupATraceStartupTrace(String r1) {
            v.d().b(r1);
        }

        public void traceBegin(String r7) {
            if (this.mShouldWriteToSystemTrace == true) goto L8;
            return;
        L8:
            this.mTraceBeginMethod.invoke(this.mTraceClass, new Object[]{Long.valueOf(this.mTraceTag), r7});     // Catch: Exception -> L7
            return;
        }

        public void traceEnd() {
            if (this.mShouldWriteToSystemTrace == true) goto L8;
            return;
        L8:
            this.mTraceEndMethod.invoke(this.mTraceClass, new Object[]{Long.valueOf(this.mTraceTag)});     // Catch: Exception -> L7
            return;
        }

        public void asyncTraceBegin(String r7, int r8) {
            if (this.mShouldWriteToSystemTrace == true) goto L8;
            return;
        L8:
            this.mAsyncTraceBeginMethod.invoke(this.mTraceClass, new Object[]{Long.valueOf(this.mTraceTag), r7, Integer.valueOf(r8)});     // Catch: Exception -> L7
            return;
        }

        public void asyncTraceEnd(String r7, int r8) {
            if (this.mShouldWriteToSystemTrace == true) goto L8;
            return;
        L8:
            this.mAsyncTraceEndMethod.invoke(this.mTraceClass, new Object[]{Long.valueOf(this.mTraceTag), r7, Integer.valueOf(r8)});     // Catch: Exception -> L7
            return;
        }
    }

    static class BasicLooperMonitor implements Printer {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        static final String FILTERED_EVENT_NAME = "Looper.dispatch: EVENT_NAME_FILTERED";
        static final String LOOPER_TASK_PREFIX = "Looper.dispatch: ";
        private static final int SHORTEST_LOG_PREFIX_LENGTH = 0;
        private String mCurrentTarget;

        static {
            SHORTEST_LOG_PREFIX_LENGTH = 18;
        }

        BasicLooperMonitor() {
        }

        @Override // android.util.Printer
        public void println(String r2) {
            if (r2.startsWith(">") == false) goto L5;
            beginHandling(r2);
            return;
        L5:
            endHandling(r2);
        }

        void beginHandling(String r3) {
            boolean r0 = EarlyTraceEvent.c();
            if (TraceEvent.c() == true) goto L5;
            if (r0 == true) goto L5;
            return;
        L5:
            this.mCurrentTarget = getTraceEventName(r3);
            if (TraceEvent.c() == false) goto L8;
            v.d().c(this.mCurrentTarget);
            return;
        L8:
            EarlyTraceEvent.a(this.mCurrentTarget, true);
        }

        void endHandling(String r2) {
            boolean r3 = EarlyTraceEvent.c();
            if (TraceEvent.c() == true) goto L6;
            if (r3 == true) goto L6;
        L11:
            this.mCurrentTarget = null;
            return;
        L6:
            if (this.mCurrentTarget == null) goto L11;
            if (TraceEvent.c() == false) goto L10;
            v.d().d(this.mCurrentTarget);
            goto L11
        L10:
            EarlyTraceEvent.b(this.mCurrentTarget, true);
            goto L11
        }

        static String getTraceEventName(String r2) {
            if (TraceEvent.d() == false) goto L7;
            return FILTERED_EVENT_NAME;
        L7:
            return LOOPER_TASK_PREFIX + getTarget(r2) + "(" + getTargetName(r2) + ")";
        }

        private static String getTarget(String r3) {
            int r0 = r3.indexOf(40, SHORTEST_LOG_PREFIX_LENGTH);
            if (r0 != (-1)) goto L5;
            int r2 = -1;
        L6:
            if (r2 != (-1)) goto L10;
            return "";
        L10:
            return r3.substring(r0 + 1, r2);
        L5:
            r2 = r3.indexOf(41, r0);
            goto L6
        }

        private static String getTargetName(String r3) {
            int r0 = r3.indexOf(125, SHORTEST_LOG_PREFIX_LENGTH);
            if (r0 != (-1)) goto L5;
            int r2 = -1;
        L6:
            if (r2 != (-1)) goto L8;
            r2 = r3.length();
        L8:
            if (r0 != (-1)) goto L12;
            return "";
        L12:
            return r3.substring(r0 + 2, r2);
        L5:
            r2 = r3.indexOf(58, r0);
            goto L6
        }
    }

    private static final class IdleTracingLooperMonitor extends BasicLooperMonitor implements MessageQueue.IdleHandler {
        private static final long FRAME_DURATION_MILLIS = 16;
        private static final String IDLE_EVENT_NAME = "Looper.queueIdle";
        private static final long MIN_INTERESTING_BURST_DURATION_MILLIS = 48;
        private static final long MIN_INTERESTING_DURATION_MILLIS = 16;
        private static final String TAG = "TraceEvent_LooperMonitor";
        private boolean mIdleMonitorAttached;
        private long mLastIdleStartedAt;
        private long mLastWorkStartedAt;
        private int mNumIdlesSeen;
        private int mNumTasksSeen;
        private int mNumTasksSinceLastIdle;

        public static /* synthetic */ int access$000(String r0, String r1) {
            return Log.v(r0, r1);
        }

        public static /* synthetic */ int access$001(int r0, String r1, String r2) {
            return Log.println(r0, r1, r2);
        }

        private IdleTracingLooperMonitor() {
        }

        /* synthetic */ IdleTracingLooperMonitor(AnonymousClass1 r1) {
            this();
        }

        private final void syncIdleMonitoring() {
            if (TraceEvent.c() == false) goto L8;
            if (this.mIdleMonitorAttached == true) goto L8;
            this.mLastIdleStartedAt = u.a();
            Looper.myQueue().addIdleHandler(this);
            this.mIdleMonitorAttached = true;
            INVOKESTATIC_com_ttnet_org_chromium_base_TraceEvent$IdleTracingLooperMonitor_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_v(TAG, "attached idle handler");
            return;
        L8:
            if (this.mIdleMonitorAttached == true) goto L10;
            return;
        L10:
            if (TraceEvent.c() == true) goto L15;
            Looper.myQueue().removeIdleHandler(this);
            this.mIdleMonitorAttached = false;
            INVOKESTATIC_com_ttnet_org_chromium_base_TraceEvent$IdleTracingLooperMonitor_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_v(TAG, "detached idle handler");
            return;
        }

        @Override // com.ttnet.org.chromium.base.TraceEvent.BasicLooperMonitor
        final void beginHandling(String r3) {
            if (this.mNumTasksSinceLastIdle != 0) goto L5;
            TraceEvent.b(IDLE_EVENT_NAME);
        L5:
            this.mLastWorkStartedAt = u.a();
            syncIdleMonitoring();
            super.beginHandling(r3);
        }

        @Override // com.ttnet.org.chromium.base.TraceEvent.BasicLooperMonitor
        final void endHandling(String r6) {
            long r0 = u.a() - this.mLastWorkStartedAt;
            if (r0 <= 16) goto L5;
            traceAndLog(5, "observed a task that took " + r0 + "ms: " + r6);
        L5:
            super.endHandling(r6);
            syncIdleMonitoring();
            this.mNumTasksSeen++;
            this.mNumTasksSinceLastIdle++;
        }

        private static void traceAndLog(int r1, String r2) {
            TraceEvent.b("TraceEvent.LooperMonitor:IdleStats", r2);
            INVOKESTATIC_com_ttnet_org_chromium_base_TraceEvent$IdleTracingLooperMonitor_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_println(r1, TAG, r2);
        }

        @Override // android.os.MessageQueue.IdleHandler
        public final boolean queueIdle() {
            long r0 = u.a();
            if (this.mLastIdleStartedAt != 0) goto L5;
            this.mLastIdleStartedAt = r0;
        L5:
            long r2 = r0 - this.mLastIdleStartedAt;
            this.mNumIdlesSeen++;
            TraceEvent.c(IDLE_EVENT_NAME, this.mNumTasksSinceLastIdle + " tasks since last idle.");
            if (r2 <= MIN_INTERESTING_BURST_DURATION_MILLIS) goto L8;
            traceAndLog(3, this.mNumTasksSeen + " tasks and " + this.mNumIdlesSeen + " idles processed so far, " + this.mNumTasksSinceLastIdle + " tasks bursted and " + r2 + "ms elapsed since last idle");
        L8:
            this.mLastIdleStartedAt = r0;
            this.mNumTasksSinceLastIdle = 0;
            return true;
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int INVOKESTATIC_com_ttnet_org_chromium_base_TraceEvent$IdleTracingLooperMonitor_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_v(String r1, String r2) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.v(r1, r2);
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int INVOKESTATIC_com_ttnet_org_chromium_base_TraceEvent$IdleTracingLooperMonitor_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_println(int r1, String r2, String r3) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L10;
            if (r1 == 6) goto L10;
            return 0;
        L10:
            return Log.println(r1, r2, r3);
        }
    }

    private static final class ViewHierarchyDumper implements MessageQueue.IdleHandler {
        private static final String EVENT_NAME = "TraceEvent.ViewHierarchyDumper";
        private static final long MIN_VIEW_DUMP_INTERVAL_MILLIS = 1000;
        private static boolean sEnabled;
        private static ViewHierarchyDumper sInstance;
        private long mLastDumpTs;

        private ViewHierarchyDumper() {
        }

        static /* synthetic */ void access$500(int r0, View r1, long r2) {
            dumpView(r0, r1, r2);
        }

        @Override // android.os.MessageQueue.IdleHandler
        public final boolean queueIdle() {
            long r0 = u.a();
            long r2 = this.mLastDumpTs;
            if (r2 != 0) goto L5;
        L6:
            this.mLastDumpTs = r0;
            v.d().c();
            return true;
        L5:
            if ((r0 - r2) > 1000) goto L6;
            return true;
        }

        public static void updateEnabledState() {
            if (ThreadUtils.d() == true) goto L7;
            ThreadUtils.b($$Lambda$TraceEvent$ViewHierarchyDumper$YLNfRrh2TZfapUEf1cVVped3ic.INSTANCE);
            return;
        L7:
            if (v.d().b() == false) goto L13;
            if (sInstance != null) goto L11;
            sInstance = new ViewHierarchyDumper();
        L11:
            enable();
            return;
        L13:
            if (sInstance == null) goto L17;
            disable();
            return;
        }

        static /* synthetic */ void lambda$updateEnabledState$0() {
            updateEnabledState();
        }

        private static void dumpView(int r11, View r12, long r13) {
            ThreadUtils.b();
            int r10 = r12.getId();
        L10:
            String r1 = "__name_not_found__";
        L11:
            String r7 = r1;
            v.d().a(r10, r11, r12.isShown(), r12.isDirty(), r12.getClass().getSimpleName(), r7, r13);
            if (ZeusTransformUtils.instanceOf(r12, ViewGroup.class) == false) goto L17;
            ViewGroup r14 = (ViewGroup) ZeusTransformUtils.preCheckCast(r12, ViewGroup.class, "com.obric.aiagent.plugin");
            int r15 = 0;
        L15:
            if (r15 >= r14.getChildCount()) goto L21;
            dumpView(r10, r14.getChildAt(r15), r13);
            r15 = r15 + 1;
            goto L15
        L21:
            return;
        L17:
            return;
        L4:
            if (ZeusTransformUtils.getResources(r12, "com.obric.aiagent.plugin") == null) goto L8;
            if (r10 == 0) goto L7;
            r1 = ZeusTransformUtils.getResources(r12, "com.obric.aiagent.plugin").getResourceName(r10);     // Catch: Resources.NotFoundException -> L10
            goto L11
        L7:
            r1 = "__no_id__";
            goto L11
        L8:
            r1 = "__no_resources__";
            goto L11
        }

        private static void enable() {
            ThreadUtils.b();
            if (sEnabled == true) goto L6;
            Looper.myQueue().addIdleHandler(sInstance);
            sEnabled = true;
            return;
        }

        private static void disable() {
            ThreadUtils.b();
            if (sEnabled == false) goto L6;
            Looper.myQueue().removeIdleHandler(sInstance);
            sEnabled = false;
            return;
        }
    }

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final BasicLooperMonitor f37678a = null;

        static /* synthetic */ BasicLooperMonitor a() {
            return f37678a;
        }

        static {
            if (c.b().a("enable-idle-tracing") == false) goto L5;
            BasicLooperMonitor r0 = new IdleTracingLooperMonitor(null);
        L6:
            f37678a = r0;
            return;
        L5:
            r0 = new BasicLooperMonitor();
            goto L6
        }
    }

    interface b {
        long a(String r1, long r2);

        void a();

        void a(int r1, int r2, boolean r3, boolean r4, String r5, String r6, long r7);

        void a(String r1);

        void a(String r1, String r2);

        void b(String r1);

        void b(String r1, String r2);

        boolean b();

        void c();

        void c(String r1);

        void c(String r1, String r2);

        void d(String r1);
    }

    static /* synthetic */ boolean c() {
        return f37671a;
    }

    static /* synthetic */ boolean d() {
        return f37674d;
    }

    static {
        f37672b = new AtomicBoolean();
        f37673c = new AtomicBoolean();
    }

    private TraceEvent(String r1, String r2) {
        this.f = r1;
        c(r1, r2);
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        b(this.f);
    }

    public static TraceEvent a(String r1, String r2) {
        if (EarlyTraceEvent.c() == true) goto L9;
        if (b() == true) goto L9;
        return null;
    L9:
        return new TraceEvent(r1, r2);
    }

    public static TraceEvent a(String r1) {
        return a(r1, null);
    }

    public static void setEnabled(boolean r1) {
        if (r1 == false) goto L5;
        EarlyTraceEvent.b();
    L5:
        if (f37671a == r1) goto L16;
        f37671a = r1;
        ATrace r0 = f37675e;
        if (r0 != null) goto L9;
    L10:
        Looper r2 = ThreadUtils.e();
        if (r1 == false) goto L13;
        BasicLooperMonitor r3 = a.a();
    L14:
        r2.setMessageLogging(r3);
        goto L16
    L13:
        r3 = null;
        goto L14
    L9:
        if (r0.hasActiveSession() == false) goto L10;
    L16:
        if (f37673c.get() == false) goto L19;
        ViewHierarchyDumper.updateEnabledState();
        return;
    }

    public static void setEventNameFilteringEnabled(boolean r0) {
        f37674d = r0;
    }

    static void a() {
        f37673c.set(true);
        ATrace r0 = f37675e;
        if (r0 == null) goto L6;
        r0.onUiThreadReady();
    L6:
        if (f37671a == false) goto L9;
        ViewHierarchyDumper.updateEnabledState();
        return;
    }

    public static boolean b() {
        return f37671a;
    }

    public static void b(String r1, String r2) {
        if (f37671a == false) goto L6;
        v.d().a(r1, r2);
        return;
    }

    public static void c(String r1, String r2) {
        EarlyTraceEvent.a(r1, false);
        if (f37671a == false) goto L5;
        v.d().b(r1, r2);
        return;
    L5:
        ATrace r3 = f37675e;
        if (r3 == null) goto L10;
        r3.traceBegin(r1);
        return;
    }

    public static void b(String r1) {
        d(r1, null);
    }

    public static void d(String r1, String r2) {
        EarlyTraceEvent.b(r1, false);
        if (f37671a == false) goto L5;
        v.d().c(r1, r2);
        return;
    L5:
        ATrace r3 = f37675e;
        if (r3 == null) goto L10;
        r3.traceEnd();
        return;
    }

    public static void dumpViewHierarchy(long r6) {
        if (ApplicationStatus.a() == true) goto L5;
        return;
    L5:
        Iterator<Activity> r0 = ApplicationStatus.c().iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        Activity r1 = (Activity) ZeusTransformUtils.preCheckCast(r0.next(), Activity.class, "com.obric.aiagent.plugin");
        long r4 = v.d().a(r1.getClass().getName(), r6);
        ViewHierarchyDumper.access$500(0, ZeusTransformUtils.getWindow(r1, "com.obric.aiagent.plugin").getDecorView().getRootView(), r4);
        goto L7
    }
}
