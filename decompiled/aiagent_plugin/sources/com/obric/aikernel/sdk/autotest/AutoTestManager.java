package com.obric.aikernel.sdk.autotest;

import android.content.Context;
import android.os.Bundle;
import com.obric.aikernel.AIKBinder;
import com.obric.aikernel.core.data.IdlKeys;
import com.obric.aikernel.core.log.AIKLog;
import com.obric.aikernel.phx.SdkContext;
import com.obric.aikernel.sdk.ext.BundleExtKt;
import com.obric.aikernel.sdk.response.Response;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.d;
import d.c.b.a.f;
import d.h.a.b;
import d.h.a.m;
import d.h.b.o;
import d.h.b.p;
import kotlinx.coroutines.dg;
import org.json.JSONObject;

/* JADX INFO: compiled from: AutoTestManager.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AutoTestManager {
    public static final AutoTestManager INSTANCE = null;
    private static final String TAG = "AutoTestManager";

    /* JADX INFO: renamed from: com.obric.aikernel.sdk.autotest.AutoTestManager$autoTest$1, reason: invalid class name */
    /* JADX INFO: compiled from: AutoTestManager.kt */
    @f(b = "AutoTestManager.kt", c = {39, 40}, d = "autoTest", e = "com.obric.aikernel.sdk.autotest.AutoTestManager")
    static final class AnonymousClass1 extends d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ AutoTestManager this$0;

        AnonymousClass1(AutoTestManager r3, d.c.d<? super AnonymousClass1> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.autoTest(null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.sdk.autotest.AutoTestManager$autoTest$2, reason: invalid class name */
    /* JADX INFO: compiled from: AutoTestManager.kt */
    static final class AnonymousClass2 extends p implements b<Bundle, Response<Object>> {
        public static final AnonymousClass2 INSTANCE = null;

        /* JADX INFO: renamed from: com.obric.aikernel.sdk.autotest.AutoTestManager$autoTest$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: AutoTestManager.kt */
        static final class AnonymousClass1 extends p implements m<Bundle, String, Object> {
            public static final AnonymousClass1 INSTANCE = null;

            static {
                INSTANCE = new AnonymousClass1();
            }

            AnonymousClass1() {
                super(2);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(Bundle r1, String r2) {
                o.e(r1, "b");
                o.e(r2, "k");
                return r1.get(r2);
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(Bundle r3, String r4) {
                return invoke2((Bundle) ZeusTransformUtils.preCheckCast(r3, Bundle.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.aiagent.plugin"));
            }
        }

        static {
            INSTANCE = new AnonymousClass2();
        }

        AnonymousClass2() {
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ Response<Object> invoke(Bundle r3) {
            return invoke2((Bundle) ZeusTransformUtils.preCheckCast(r3, Bundle.class, "com.obric.aiagent.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Response<Object> invoke2(Bundle r3) {
            o.e(r3, "it");
            return BundleExtKt.toUserResponse(r3, (m) ZeusTransformUtils.preCheckCast(AnonymousClass1.INSTANCE, m.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.sdk.autotest.AutoTestManager$callAutoTestAsResponse$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AutoTestManager.kt */
    @f(b = "AutoTestManager.kt", c = {59}, d = "callAutoTestAsResponse", e = "com.obric.aikernel.sdk.autotest.AutoTestManager")
    static final class C11331<T> extends d {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ AutoTestManager this$0;

        C11331(AutoTestManager r3, d.c.d<? super C11331> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            this.result = r8;
            this.label |= Integer.MIN_VALUE;
            return AutoTestManager.access$callAutoTestAsResponse(this.this$0, null, null, 0, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        INSTANCE = new AutoTestManager();
    }

    private AutoTestManager() {
    }

    public static final /* synthetic */ Object access$callAutoTestAsResponse(AutoTestManager r9, AIKBinder r10, Bundle r11, long r12, b r14, d.c.d r15) {
        return r9.callAutoTestAsResponse((AIKBinder) ZeusTransformUtils.wrapperContextForParams(r10, AIKBinder.class, "com.obric.aiagent.plugin"), r11, r12, (b) ZeusTransformUtils.wrapperContextForParams(r14, b.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r15, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public final Object autoTest(Context r19, JSONObject r20, d.c.d<? super Response<Object>> r21) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r19, Context.class, "com.obric.aiagent.plugin");
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r21, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, AnonymousClass1.class) == false) goto L7;
        AnonymousClass1 r4 = (AnonymousClass1) ZeusTransformUtils.preCheckCast(r3, AnonymousClass1.class, "com.obric.aiagent.plugin");
        if ((r4.label & Integer.MIN_VALUE) == 0) goto L7;
        r4.label -= Integer.MIN_VALUE;
    L8:
        AnonymousClass1 r11 = r4;
        Object r5 = r11.result;
        Object r6 = d.c.a.b.a();
        int r7 = r11.label;
        if (r7 == 0) goto L16;
        if (r7 == 1) goto L15;
        if (r7 != 2) goto L14;
        d.o.a(r5);
    L31:
        return r5;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        Bundle r0 = (Bundle) ZeusTransformUtils.preCheckCast(r11.L$1, Bundle.class, "com.obric.aiagent.plugin");
        AutoTestManager r2 = (AutoTestManager) ZeusTransformUtils.preCheckCast(r11.L$0, AutoTestManager.class, "com.obric.aiagent.plugin");
        d.o.a(r5);
        AutoTestManager r8 = r2;
    L24:
        AIKBinder r9 = (AIKBinder) ZeusTransformUtils.preCheckCast(r5, AIKBinder.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L27;
        b r10 = (b) ZeusTransformUtils.preCheckCast(AnonymousClass2.INSTANCE, b.class, "com.obric.aiagent.plugin");
        r11.L$0 = null;
        r11.L$1 = null;
        r11.label = 2;
        r5 = r8.callAutoTestAsResponse(r9, r0, 5000, r10, r11);
        if (r5 != r6) goto L31;
        return r6;
    L27:
        return BundleExtKt.toBasicTypeResponse(BundleExtKt.setErr$default(new Bundle(), 102, null, 2, null));
    L16:
        d.o.a(r5);
        String r12 = r1.getPackageName();
        o.c(r12, "context.packageName");
        if (isAutoTestApp(r12) == false) goto L19;
        Bundle r13 = BundleExtKt.json2Bundle$default(r20, false, 2, null);
        SdkContext r14 = SdkContext.INSTANCE;
        r11.L$0 = this;
        r11.L$1 = r13;
        r11.label = 1;
        r5 = r14.getBinder(r11);
        if (r5 != r6) goto L23;
        return r6;
    L23:
        r8 = this;
        r0 = r13;
        goto L24
    L19:
        return BundleExtKt.toBasicTypeResponse(BundleExtKt.setErr$default(new Bundle(), 101, "only auto test app can call this method.", false, 4, null));
    L7:
        r4 = new AnonymousClass1(this, r3);
        goto L8
    }

    public final boolean isAutoTestApp(String r1) {
        o.e(r1, "packageName");
        return o.a(r1, AutoTestConstant.AUTO_TEST_APP_PACKAGE_NAME);
    }

    private final <T> Object callAutoTestAsResponse(AIKBinder r17, Bundle r18, long r19, b<? super Bundle, ? extends T> r21, d.c.d<? super T> r22) {
        AutoTestManager r0 = this;
        long r7 = r19;
        AIKBinder r5 = (AIKBinder) ZeusTransformUtils.wrapperContextForParams(r17, AIKBinder.class, "com.obric.aiagent.plugin");
        b r11 = (b) ZeusTransformUtils.wrapperContextForParams(r21, b.class, "com.obric.aiagent.plugin");
        d.c.d r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r22, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, C11331.class) == false) goto L7;
        C11331 r2 = (C11331) ZeusTransformUtils.preCheckCast(r1, C11331.class, "com.obric.aiagent.plugin");
        if ((r2.label & Integer.MIN_VALUE) == 0) goto L7;
        r2.label -= Integer.MIN_VALUE;
    L8:
        C11331 r12 = r2;
        Object r3 = r12.result;
        Object r13 = d.c.a.b.a();
        int r4 = r12.label;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        long r6 = r12.J$0;
        r11 = (b) ZeusTransformUtils.preCheckCast(r12.L$2, b.class, "com.obric.aiagent.plugin");
        Bundle r8 = (Bundle) ZeusTransformUtils.preCheckCast(r12.L$1, Bundle.class, "com.obric.aiagent.plugin");
        AutoTestManager r9 = (AutoTestManager) ZeusTransformUtils.preCheckCast(r12.L$0, AutoTestManager.class, "com.obric.aiagent.plugin");
        d.o.a(r3);
        r7 = r6;
        Bundle r10 = r8;
        r0 = r9;
    L17:
        Bundle r14 = (Bundle) ZeusTransformUtils.preCheckCast(r3, Bundle.class, "com.obric.aiagent.plugin");
        if (r14 != null) goto L21;
        AutoTestManager r15 = (AutoTestManager) ZeusTransformUtils.preCheckCast(r0, AutoTestManager.class, "com.obric.aiagent.plugin");
        AIKLog.INSTANCE.v(TAG, "callAutoTestlAsResponse " + r10.getString(IdlKeys.MethodName) + " timeout after " + r7 + " ms");
        r14 = BundleExtKt.setErr$default(new Bundle(), 107, "timeout after " + r7 + " ms", false, 4, null);
    L21:
        return r11.invoke(r14);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r3);
        r10 = r18;
        m r16 = (m) ZeusTransformUtils.preCheckCast(new AutoTestManager$callAutoTestAsResponse$responseBundle$1(r10, r19, r5, null), m.class, "com.obric.aiagent.plugin");
        r12.L$0 = r0;
        r12.L$1 = r10;
        r12.L$2 = r11;
        r12.J$0 = r7;
        r12.label = 1;
        r3 = dg.b(r7, r16, r12);
        if (r3 != r13) goto L17;
        return r13;
    L7:
        r2 = new C11331(r0, r1);
        goto L8
    }

    static /* synthetic */ Object callAutoTestAsResponse$default(AutoTestManager r9, AIKBinder r10, Bundle r11, long r12, b r14, d.c.d r15, int r16, Object r17) {
        AIKBinder r3 = (AIKBinder) ZeusTransformUtils.wrapperContextForParams(r10, AIKBinder.class, "com.obric.aiagent.plugin");
        b r7 = (b) ZeusTransformUtils.wrapperContextForParams(r14, b.class, "com.obric.aiagent.plugin");
        d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r15, d.c.d.class, "com.obric.aiagent.plugin");
        if ((r16 & 4) == 0) goto L5;
        long r5 = 3000;
    L7:
        return r9.callAutoTestAsResponse(r3, r11, r5, r7, r8);
    L5:
        r5 = r12;
        goto L7
    }
}
