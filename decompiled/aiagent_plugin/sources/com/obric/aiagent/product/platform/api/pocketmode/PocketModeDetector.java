package com.obric.aiagent.product.platform.api.pocketmode;

import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.product.feature.api.IFeatureServiceKt;
import com.obric.aiagent.product.feature.impl.a;
import com.obric.aiagent.product.platform.impl.pocketmode.b;
import com.obric.aiagent.product.platform.impl.pocketmode.c;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.aweme.framework.services.ServiceProvider;
import com.ss.android.ugc.aweme.framework.services.SingletonProvider;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.d;
import d.c.b.a.f;
import d.h.b.o;
import d.x;

/* JADX INFO: compiled from: PocketModeDetector.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PocketModeDetector implements IPocketModeDetector {
    public static final PocketModeDetector INSTANCE = null;
    private static final String TAG = "PocketModeDetector";
    private static IPocketModeDetector instance;

    /* JADX INFO: renamed from: com.obric.aiagent.product.platform.api.pocketmode.PocketModeDetector$awaitCheckPassed$1, reason: invalid class name */
    /* JADX INFO: compiled from: PocketModeDetector.kt */
    @f(b = "PocketModeDetector.kt", c = {69}, d = "awaitCheckPassed", e = "com.obric.aiagent.product.platform.api.pocketmode.PocketModeDetector")
    static final class AnonymousClass1 extends d {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ PocketModeDetector this$0;

        AnonymousClass1(PocketModeDetector r3, d.c.d<? super AnonymousClass1> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.awaitCheckPassed((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: renamed from: lambda$SZaiQVYPyBu--KVTDSnDoy0EF9M, reason: not valid java name */
    public static /* synthetic */ Object m223lambda$SZaiQVYPyBuKVTDSnDoy0EF9M() {
        return _init_$lambda$0();
    }

    public static /* synthetic */ Object lambda$xyffnhlBdE1vr10IegCGKVAnf6c() {
        return _init_$lambda$1();
    }

    private PocketModeDetector() {
    }

    static {
        INSTANCE = new PocketModeDetector();
    L19:
        th = move-exception;
        ILogDepend.Companion.e(TAG, "init IPocketModeDetector failed", th);     // Catch: Throwable -> L23
    L21:
        instance = (IPocketModeDetector) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IPocketModeDetector.class, false), IPocketModeDetector.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L23
        ILogDepend.Companion.i(TAG, "IPocketModeDetector instance: " + instance);     // Catch: Throwable -> L23
        return;
    L23:
        th = move-exception;
        instance = null;
        ILogDepend.Companion.e(TAG, "init IPocketModeDetector failed", th);
        return;
    L4:
        if (a.f18789a.a().isObricOs() == false) goto L10;
        ServiceManager.get().bind(IPocketModeDetector.class, (ServiceProvider) ZeusTransformUtils.preCheckCast(new SingletonProvider($$Lambda$PocketModeDetector$SZaiQVYPyBuKVTDSnDoy0EF9M.INSTANCE), ServiceProvider.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L7
    L17:
        ILogDepend.Companion.i(TAG, "bind IPocketModeDetector isOs=" + a.f18789a.a().isObricOs());     // Catch: Throwable -> L19
    L7:
        th = move-exception;
        ILogDepend.Companion.e(TAG, "bind ObricPocketModeDetector failed", th);     // Catch: Throwable -> L19
        goto L17
    L10:
        if (o.a(a.f18789a.a().getObricProductName(), IFeatureServiceKt.PRODUCT_GENESIS_R) == false) goto L12;
    L30:
        ServiceManager.get().bind(IPocketModeDetector.class, (ServiceProvider) ZeusTransformUtils.preCheckCast(new SingletonProvider($$Lambda$PocketModeDetector$xyffnhlBdE1vr10IegCGKVAnf6c.INSTANCE), ServiceProvider.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        ILogDepend.Companion.e(TAG, "bind GRPocketModeDetector failed", th);     // Catch: Throwable -> L19
        goto L17
    L12:
        if (o.a(a.f18789a.a().getObricProductName(), IFeatureServiceKt.PRODUCT_GENESIS_M) == false) goto L17;
        goto L17
    }

    private static final Object _init_$lambda$0() {
        return new c();
    }

    private static final Object _init_$lambda$1() {
        return new b();
    }

    @Override // com.obric.aiagent.product.platform.api.pocketmode.IPocketModeDetector
    public void checkAsync() {
        IPocketModeDetector r0 = instance;
        if (r0 == null) goto L6;
        r0.checkAsync();
        return;
    }

    @Override // com.obric.aiagent.product.platform.api.pocketmode.IPocketModeDetector
    public boolean isCheckPassed() {
        IPocketModeDetector r0 = instance;
        if (r0 == null) goto L5;
        Boolean r1 = Boolean.valueOf(r0.isCheckPassed());
    L7:
        return logAndReturn(r1, "isCheckPassed", true, true);
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.obric.aiagent.product.platform.api.pocketmode.IPocketModeDetector
    public void showProximityNearAlert() {
        IPocketModeDetector r0 = instance;
        if (r0 == null) goto L6;
        r0.showProximityNearAlert();
        return;
    }

    @Override // com.obric.aiagent.product.platform.api.pocketmode.IPocketModeDetector
    public void onUserActionBlocked(boolean r2, boolean r3, d.h.a.a<x> r4) {
        d.h.a.a<x> r1 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
        o.e(r1, "showToastAction");
        IPocketModeDetector r5 = instance;
        if (r5 == null) goto L6;
        r5.onUserActionBlocked(r2, r3, r1);
        return;
    }

    @Override // com.obric.aiagent.product.platform.api.pocketmode.IPocketModeDetector
    public Object awaitCheckPassed(d.c.d<? super Boolean> r6) {
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r7, AnonymousClass1.class) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) ZeusTransformUtils.preCheckCast(r7, AnonymousClass1.class, "com.obric.aiagent.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = d.c.a.b.a();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        PocketModeDetector this = (PocketModeDetector) ZeusTransformUtils.preCheckCast(r0.L$0, PocketModeDetector.class, "com.obric.aiagent.plugin");
        d.o.a(r8);
    L19:
        Boolean r9 = (Boolean) ZeusTransformUtils.preCheckCast(r8, Boolean.class, "com.obric.aiagent.plugin");
    L22:
        return d.c.b.a.b.a(this.logAndReturn(r9, "awaitCheckPassed", true, true));
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r8);
        IPocketModeDetector r10 = instance;
        if (r10 == null) goto L20;
        r0.L$0 = this;
        r0.label = 1;
        r8 = r10.awaitCheckPassed(r0);
        if (r8 != r2) goto L19;
        return r2;
    L20:
        r9 = null;
    L7:
        r0 = new AnonymousClass1(this, r7);
        goto L8
    }

    @Override // com.obric.aiagent.product.platform.api.pocketmode.IPocketModeDetector
    public void init() {
        IPocketModeDetector r0 = instance;
        if (r0 == null) goto L6;
        r0.init();
        return;
    }

    @Override // com.obric.aiagent.product.platform.api.pocketmode.IPocketModeDetector
    public boolean isPocketModeManuallyDismissed() {
        IPocketModeDetector r0 = instance;
        if (r0 == null) goto L5;
        Boolean r1 = Boolean.valueOf(r0.isPocketModeManuallyDismissed());
    L7:
        return logAndReturn$default(this, r1, "isPocketModeManuallyDismissed", false, false, 6, null);
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.obric.aiagent.product.platform.api.pocketmode.IPocketModeDetector
    public boolean isPocketModeEnabled() {
        IPocketModeDetector r0 = instance;
        if (r0 == null) goto L5;
        Boolean r1 = Boolean.valueOf(r0.isPocketModeEnabled());
    L7:
        return logAndReturn$default(this, r1, "isPocketModeEnabled", false, false, 6, null);
    L5:
        r1 = null;
        goto L7
    }

    static /* synthetic */ boolean logAndReturn$default(PocketModeDetector r1, Boolean r2, String r3, boolean r4, boolean r5, int r6, Object r7) {
        if ((r6 & 2) == 0) goto L6;
        r4 = false;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r5 = false;
    L9:
        return r1.logAndReturn(r2, r3, r4, r5);
    }

    private final boolean logAndReturn(Boolean r2, String r3, boolean r4, boolean r5) {
        if (r2 != null) goto L9;
        String r6 = "instance?." + r3 + "() is null, return " + r4;
        if (r5 == false) goto L7;
        ILogDepend.Companion.e(TAG, r6);
    L8:
        return r4;
    L7:
        ILogDepend.Companion.i(TAG, r6);
        goto L8
    L9:
        ILogDepend.Companion.i(TAG, r3 + ": " + r2);
        return r2.booleanValue();
    }

    @Override // com.obric.aiagent.product.platform.api.pocketmode.IPocketModeDetector
    public void hideProximityNearAlert() {
        IPocketModeDetector r0 = instance;
        if (r0 == null) goto L6;
        r0.hideProximityNearAlert();
        return;
    }

    @Override // com.obric.aiagent.product.platform.api.pocketmode.IPocketModeDetector
    public boolean isProximityNearAlertShowing() {
        IPocketModeDetector r0 = instance;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isProximityNearAlertShowing();
    }
}
