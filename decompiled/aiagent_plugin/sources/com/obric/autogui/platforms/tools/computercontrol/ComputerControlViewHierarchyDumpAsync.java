package com.obric.autogui.platforms.tools.computercontrol;

import android.app.assist.AssistStructure;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import com.android.extensions.computercontrol.AssistantComputerControlSession;
import com.android.extensions.computercontrol.AssistantTopActivityAssistDataReceiver;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.a.b;
import d.c.b.a.f;
import d.c.d;
import d.h.a.m;
import d.h.b.h;
import d.h.b.o;
import d.h.b.z;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import kotlinx.coroutines.de;
import kotlinx.coroutines.dg;
import kotlinx.coroutines.f.a;
import kotlinx.coroutines.f.c;
import kotlinx.coroutines.w;
import kotlinx.coroutines.y;

/* JADX INFO: compiled from: ComputerControlViewHierarchyDumpAsync.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ComputerControlViewHierarchyDumpAsync {
    private static final String BUNDLE_KEY_STRUCTURE = "structure";
    private static final Companion Companion = null;
    private static final String TAG = "CC-VHD-Async";
    private static final long VHD_TIMEOUT_MILLIS = 2500;
    private static final AtomicInteger mRequestId = null;
    private final AssistDataReceiver receiver;
    private final a sessionInvocationMutex;
    private volatile AssistDataRequestSession sessionOngoing;

    /* JADX INFO: compiled from: ComputerControlViewHierarchyDumpAsync.kt */
    private final class AssistDataReceiver extends AssistantTopActivityAssistDataReceiver {
        final /* synthetic */ ComputerControlViewHierarchyDumpAsync this$0;

        public AssistDataReceiver(ComputerControlViewHierarchyDumpAsync r1) {
            this.this$0 = r1;
        }

        public void onResultData(int r4, Bundle r5) {
            Loog.INSTANCE.i(ComputerControlViewHierarchyDumpAsync.TAG, "VHD via AssistData: " + r4 + ", " + r5);
            AssistDataRequestSession r3 = ComputerControlViewHierarchyDumpAsync.access$getSessionOngoing$p(this.this$0);
            boolean r0 = false;
            if (r3 != null) goto L5;
        L7:
            if (r0 == false) goto L10;
            if (r3 == null) goto L16;
            r3.onResultReady(r5);
            return;
        L16:
            return;
        L10:
            Loog r6 = Loog.INSTANCE;
            StringBuilder r7 = new StringBuilder().append(" - calling back VHD via AssistData: ").append(r4).append(", which is not consistent with the ongoing VHD requestId=");
            if (r3 == null) goto L13;
            Integer r8 = Integer.valueOf(r3.getRequestId());
        L14:
            r6.w(ComputerControlViewHierarchyDumpAsync.TAG, r7.append(r8).toString());
            return;
        L13:
            r8 = null;
            goto L14
        L5:
            if (r3.getRequestId() != r4) goto L7;
            r0 = true;
            goto L7
        }

        public void onScreenshotData(int r3, Bundle r4) {
            Loog.INSTANCE.d(ComputerControlViewHierarchyDumpAsync.TAG, "Screenshot via AssistData: " + r3 + ", " + r4);
        }
    }

    /* JADX INFO: compiled from: ComputerControlViewHierarchyDumpAsync.kt */
    private final class AssistDataRequestSession {
        private final int requestId;
        private final w<Object> result;
        private final AssistantComputerControlSession session;
        private final Collection<AssistDataRequestSession> sessionsAwaitingForResult;
        final /* synthetic */ ComputerControlViewHierarchyDumpAsync this$0;

        public AssistDataRequestSession(ComputerControlViewHierarchyDumpAsync r3, AssistantComputerControlSession r4) {
            AssistantComputerControlSession r5 = (AssistantComputerControlSession) ZeusTransformUtils.wrapperContextForParams(r4, AssistantComputerControlSession.class, "com.obric.aiagent.plugin");
            o.e(r5, SensitiveType.SESSION);
            this.this$0 = r3;
            this.session = r5;
            this.requestId = ComputerControlViewHierarchyDumpAsync.access$getMRequestId$cp().getAndIncrement();
            this.sessionsAwaitingForResult = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
            this.result = y.a(null, 1, null);
        }

        public static final /* synthetic */ w access$getResult$p(AssistDataRequestSession r0) {
            return r0.result;
        }

        public final int getRequestId() {
            return this.requestId;
        }

        public final Object request(d<Object> r17) {
            AssistDataRequestSession r0 = this;
            d r2 = (d) ZeusTransformUtils.wrapperContextForParams(r17, d.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r2, ComputerControlViewHierarchyDumpAsync$AssistDataRequestSession$request$1.class) == false) goto L7;
            ComputerControlViewHierarchyDumpAsync$AssistDataRequestSession$request$1 r4 = (ComputerControlViewHierarchyDumpAsync$AssistDataRequestSession$request$1) ZeusTransformUtils.preCheckCast(r2, ComputerControlViewHierarchyDumpAsync$AssistDataRequestSession$request$1.class, "com.obric.aiagent.plugin");
            if ((r4.label & Integer.MIN_VALUE) == 0) goto L7;
            r4.label -= Integer.MIN_VALUE;
        L8:
            Object r3 = r4.result;
            Object r5 = b.a();
            int r6 = r4.label;
            if (r6 == 0) goto L20;
            if (r6 == 1) goto L19;
            if (r6 == 2) goto L16;
            if (r6 != 3) goto L15;
            ComputerControlViewHierarchyDumpAsync r1 = (ComputerControlViewHierarchyDumpAsync) ZeusTransformUtils.preCheckCast(r4.L$3, ComputerControlViewHierarchyDumpAsync.class, "com.obric.aiagent.plugin");
            a r7 = (a) ZeusTransformUtils.preCheckCast(r4.L$2, a.class, "com.obric.aiagent.plugin");
            Object r8 = r4.L$1;
            AssistDataRequestSession r9 = (AssistDataRequestSession) ZeusTransformUtils.preCheckCast(r4.L$0, AssistDataRequestSession.class, "com.obric.aiagent.plugin");
            d.o.a(r3);
        L63:
            ComputerControlViewHierarchyDumpAsync.access$setSessionOngoing$p(r1, null);     // Catch: Throwable -> L51
            Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r9.sessionsAwaitingForResult, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L51
        L46:
            if (r10.hasNext() == false) goto L48;
            ((AssistDataRequestSession) ZeusTransformUtils.preCheckCast(r10.next(), AssistDataRequestSession.class, "com.obric.aiagent.plugin")).onResultReady(r8);     // Catch: Throwable -> L51
            goto L46
        L48:
            x r11 = x.f38692a;     // Catch: Throwable -> L51
            r7.b(null);
            return r8;
        L51:
            th = move-exception;
            r7.b(null);
            throw th;
        L15:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L16:
            z.a r12 = (z.a) ZeusTransformUtils.preCheckCast(r4.L$1, z.a.class, "com.obric.aiagent.plugin");
            AssistDataRequestSession r13 = (AssistDataRequestSession) ZeusTransformUtils.preCheckCast(r4.L$0, AssistDataRequestSession.class, "com.obric.aiagent.plugin");
            d.o.a(r3);     // Catch: de -> L57
        L38:
            if (r12.f38499a == true) goto L40;
            return r3;
        L40:
            a r14 = ComputerControlViewHierarchyDumpAsync.access$getSessionInvocationMutex$p(r13.this$0);
            ComputerControlViewHierarchyDumpAsync r15 = r13.this$0;
            r4.L$0 = r13;
            r4.L$1 = r3;
            r4.L$2 = r14;
            r4.L$3 = r15;
            r4.label = 3;
            if (r14.a(null, r4) != r5) goto L43;
            return r5;
        L43:
            r7 = r14;
            r9 = r13;
            r1 = r15;
            r8 = r3;
        L36:
            Loog.INSTANCE.e(ComputerControlViewHierarchyDumpAsync.TAG, "[VHD-Dump] timeout for VHDSession(" + r13.requestId + ").");
            r3 = null;
            goto L38
        L19:
            ComputerControlViewHierarchyDumpAsync r16 = (ComputerControlViewHierarchyDumpAsync) ZeusTransformUtils.preCheckCast(r4.L$3, ComputerControlViewHierarchyDumpAsync.class, "com.obric.aiagent.plugin");
            a r18 = (a) ZeusTransformUtils.preCheckCast(r4.L$2, a.class, "com.obric.aiagent.plugin");
            z.a r19 = (z.a) ZeusTransformUtils.preCheckCast(r4.L$1, z.a.class, "com.obric.aiagent.plugin");
            AssistDataRequestSession r110 = (AssistDataRequestSession) ZeusTransformUtils.preCheckCast(r4.L$0, AssistDataRequestSession.class, "com.obric.aiagent.plugin");
            d.o.a(r3);
            z.a r20 = r19;
            ComputerControlViewHierarchyDumpAsync r111 = r16;
            r0 = r110;
        L58:
            AssistDataRequestSession r112 = ComputerControlViewHierarchyDumpAsync.access$getSessionOngoing$p(r111);     // Catch: Throwable -> L54
            if (r112 != null) goto L26;
            ComputerControlViewHierarchyDumpAsync.access$setSessionOngoing$p(r111, r0);     // Catch: Throwable -> L54
            r20.f38499a = true;     // Catch: Throwable -> L54
            x r113 = x.f38692a;     // Catch: Throwable -> L54
        L27:
            r18.b(null);
            if (r20.f38499a == false) goto L59;
            r0.invokeInternal();
        L59:
            m r21 = (m) ZeusTransformUtils.preCheckCast(new ComputerControlViewHierarchyDumpAsync$AssistDataRequestSession$request$requestResult$1(r0, null), m.class, "com.obric.aiagent.plugin");     // Catch: de -> L35
            r4.L$0 = r0;     // Catch: de -> L35
            r4.L$1 = r20;     // Catch: de -> L35
            r4.L$2 = null;     // Catch: de -> L35
            r4.L$3 = null;     // Catch: de -> L35
            r4.label = 2;     // Catch: de -> L35
            Object r22 = dg.a(2500, r21, r4);     // Catch: de -> L35
            if (r22 != r5) goto L34;
            return r5;
        L34:
            r13 = r0;
            r12 = r20;
            r3 = r22;
        L35:
            r13 = r0;
            r12 = r20;
            goto L36
        L26:
            Loog.INSTANCE.i(ComputerControlViewHierarchyDumpAsync.TAG, "[VHD-Dump] awaiting for VHDSession(" + r0.requestId + ")'s result.");     // Catch: Throwable -> L54
            d.c.b.a.b.a(r112.sessionsAwaitingForResult.add(r0));     // Catch: Throwable -> L54
        L54:
            th = move-exception;
            r18.b(null);
            throw th;
        L20:
            d.o.a(r3);
            r20 = new z.a();
            r18 = ComputerControlViewHierarchyDumpAsync.access$getSessionInvocationMutex$p(r0.this$0);
            r111 = r0.this$0;
            r4.L$0 = r0;
            r4.L$1 = r20;
            r4.L$2 = r18;
            r4.L$3 = r111;
            r4.label = 1;
            if (r18.a(null, r4) != r5) goto L58;
            return r5;
        L7:
            r4 = new ComputerControlViewHierarchyDumpAsync$AssistDataRequestSession$request$1(r0, r2);
            goto L8
        }

        private final void invokeInternal() {
            boolean r2 = this.session.requestTopActivityAssistData(this.requestId, (AssistantTopActivityAssistDataReceiver) ZeusTransformUtils.preCheckCast(ComputerControlViewHierarchyDumpAsync.access$getReceiver$p(this.this$0), AssistantTopActivityAssistDataReceiver.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L5
        L7:
            if (r2 == true) goto L12;
            Loog.INSTANCE.e(ComputerControlViewHierarchyDumpAsync.TAG, "[VHD-Dump] failed invocation for VHDSession(" + this.requestId + ") (service_error).");
            onResultReady(null);
            return;
        L12:
            return;
        L5:
            th = move-exception;
            Loog.INSTANCE.e(ComputerControlViewHierarchyDumpAsync.TAG, "[VHD-Dump] failed invocation for VHDSession(" + this.requestId + ").", th);
            r2 = false;
            goto L7
        }

        public final void onResultReady(Object r1) {
            this.result.a(r1);
        }
    }

    /* JADX INFO: compiled from: ComputerControlViewHierarchyDumpAsync.kt */
    private static final class Companion {
        public /* synthetic */ Companion(h r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.platforms.tools.computercontrol.ComputerControlViewHierarchyDumpAsync$dumpTopWindow$1, reason: invalid class name */
    /* JADX INFO: compiled from: ComputerControlViewHierarchyDumpAsync.kt */
    @f(b = "ComputerControlViewHierarchyDumpAsync.kt", c = {127}, d = "dumpTopWindow", e = "com.obric.autogui.platforms.tools.computercontrol.ComputerControlViewHierarchyDumpAsync")
    static final class AnonymousClass1 extends d.c.b.a.d {
        long J$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ ComputerControlViewHierarchyDumpAsync this$0;

        AnonymousClass1(ComputerControlViewHierarchyDumpAsync r3, d<? super AnonymousClass1> r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.dumpTopWindow(null, (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin"));
        }
    }

    public ComputerControlViewHierarchyDumpAsync() {
        this.receiver = new AssistDataReceiver(this);
        this.sessionInvocationMutex = c.a(false, 1, null);
    }

    public static final /* synthetic */ AtomicInteger access$getMRequestId$cp() {
        return mRequestId;
    }

    public static final /* synthetic */ AssistDataReceiver access$getReceiver$p(ComputerControlViewHierarchyDumpAsync r0) {
        return r0.receiver;
    }

    public static final /* synthetic */ a access$getSessionInvocationMutex$p(ComputerControlViewHierarchyDumpAsync r0) {
        return r0.sessionInvocationMutex;
    }

    public static final /* synthetic */ AssistDataRequestSession access$getSessionOngoing$p(ComputerControlViewHierarchyDumpAsync r0) {
        return r0.sessionOngoing;
    }

    public static final /* synthetic */ void access$setSessionOngoing$p(ComputerControlViewHierarchyDumpAsync r0, AssistDataRequestSession r1) {
        r0.sessionOngoing = r1;
    }

    static {
        Companion = new Companion(null);
        mRequestId = new AtomicInteger(0);
    }

    public final Object dumpTopWindow(AssistantComputerControlSession r9, d<? super com.obric.autogui.common.d<AssistStructure>> r10) {
        AssistantComputerControlSession r11 = (AssistantComputerControlSession) ZeusTransformUtils.wrapperContextForParams(r9, AssistantComputerControlSession.class, "com.obric.aiagent.plugin");
        d r12 = (d) ZeusTransformUtils.wrapperContextForParams(r10, d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r12, AnonymousClass1.class) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) ZeusTransformUtils.preCheckCast(r12, AnonymousClass1.class, "com.obric.aiagent.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r13 = r0.result;
        Object r2 = b.a();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        long r8 = r0.J$0;
        AssistDataRequestSession r4 = (AssistDataRequestSession) ZeusTransformUtils.preCheckCast(r0.L$1, AssistDataRequestSession.class, "com.obric.aiagent.plugin");
        ComputerControlViewHierarchyDumpAsync r1 = (ComputerControlViewHierarchyDumpAsync) ZeusTransformUtils.preCheckCast(r0.L$0, ComputerControlViewHierarchyDumpAsync.class, "com.obric.aiagent.plugin");
        d.o.a(r13);
    L18:
        Loog.INSTANCE.i(TAG, " - dumpTopWindow done: l=" + (AOSystemTools.INSTANCE.nowTimeMillis() - r8) + ", reqId=" + r4.getRequestId() + ", data=" + r13);
        if (ZeusTransformUtils.instanceOf(r13, Bundle.class) == false) goto L27;
        Loog.INSTANCE.i(TAG, " - dumpTopWindow bundleSize = " + ((Bundle) ZeusTransformUtils.preCheckCast(r13, Bundle.class, "com.obric.aiagent.plugin")).size());
        Iterator<String> r14 = ((Bundle) ZeusTransformUtils.preCheckCast(r13, Bundle.class, "com.obric.aiagent.plugin")).keySet().iterator();
    L22:
        if (r14.hasNext() == false) goto L25;
        String r15 = (String) ZeusTransformUtils.preCheckCast(r14.next(), String.class, "com.obric.aiagent.plugin");
        Loog.INSTANCE.i(TAG, "   - " + r15 + " ==> " + ((Bundle) ZeusTransformUtils.preCheckCast(r13, Bundle.class, "com.obric.aiagent.plugin")).get(r15));
        goto L22
    L25:
        return com.obric.autogui.common.d.f29012a.a(r1.fetchResultFromBundle((Bundle) ZeusTransformUtils.preCheckCast(r13, Bundle.class, "com.obric.aiagent.plugin")));
    L27:
        return com.obric.autogui.common.d.f29012a.a("not supported");
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r13);
        AssistDataRequestSession r16 = new AssistDataRequestSession(this, r11);
        Loog.INSTANCE.i(TAG, " - dumpTopWindow called: reqId=" + r16.getRequestId());
        long r6 = AOSystemTools.INSTANCE.nowTimeMillis();
        r0.L$0 = this;
        r0.L$1 = r16;
        r0.J$0 = r6;
        r0.label = 1;
        Object r17 = r16.request(r0);
        if (r17 != r2) goto L17;
        return r2;
    L17:
        r1 = this;
        r4 = r16;
        r13 = r17;
        r8 = r6;
    L7:
        r0 = new AnonymousClass1(this, r12);
        goto L8
    }

    private final AssistStructure fetchResultFromBundle(Bundle r6) {
    L16:
        th = move-exception;
        Loog.INSTANCE.w(TAG, "expected AssistStructure for Bundle key `structure`, exc=" + th);
        return null;
    L5:
        if (Build.VERSION.SDK_INT < 33) goto L7;
        AssistStructure r7 = (AssistStructure) ZeusTransformUtils.preCheckCast(r6.getParcelable(BUNDLE_KEY_STRUCTURE, AssistStructure.class), AssistStructure.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
    L12:
        if (r7 != null) goto L15;
        Loog.INSTANCE.w(TAG, "expected non-null AssistStructure for Bundle key `structure`.");
        return null;
    L15:
        return r7;
    L7:
        Parcelable r8 = r6.getParcelable(BUNDLE_KEY_STRUCTURE);     // Catch: Throwable -> L16
        if (ZeusTransformUtils.instanceOf(r8, AssistStructure.class) == false) goto L11;
        r7 = (AssistStructure) ZeusTransformUtils.preCheckCast(r8, AssistStructure.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
        goto L12
    L11:
        r7 = null;
        goto L12
    }
}
