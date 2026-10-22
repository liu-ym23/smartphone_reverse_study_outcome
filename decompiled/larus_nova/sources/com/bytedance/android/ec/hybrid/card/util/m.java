package com.bytedance.android.ec.hybrid.card.util;

import com.bytedance.android.ec.hybrid.card.api.ECLynxLoadParam;
import com.bytedance.android.ec.hybrid.card.bridge.AppendEntranceInfoBridge;
import com.bytedance.android.ec.hybrid.card.bridge.BstSendBstExposureEventBridge;
import com.bytedance.android.ec.hybrid.card.bridge.CreateBtmChainBridge;
import com.bytedance.android.ec.hybrid.card.bridge.LynxSubscribeEventBridge;
import com.bytedance.android.ec.hybrid.card.event.ECEventCenter;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import zz6.IKitView;

/* JADX INFO: loaded from: classes44.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f46615a = 0;

    public static final class a implements g<IKitView> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.ec.hybrid.card.impl.h f46616a;

        @Override // com.bytedance.android.ec.hybrid.card.util.g
        public final IKitView get() {
            return this.f46616a.f46534a;
        }

        public a(com.bytedance.android.ec.hybrid.card.impl.h r100) {
            this.f46616a = r100;
        }
    }

    static {
    }

    public static Map a(com.bytedance.android.ec.hybrid.card.impl.h r110) {
        Intrinsics.checkNotNullParameter(r110, "processParams");
        ECLynxLoadParam r100 = r110.f46543j;
        if (r100 == null) goto L5;
        String r101 = r100.f46328s;
    L6:
        final uj.d r102 = new uj.d(r101, r110.f46536c, null, r110.f46540g, null, r110.f46539f, new a(r110), 20);
        Intrinsics.checkNotNullParameter(r102, "bridgeNeedParams");
        String r111 = r102.f550228a;
        if (r111 != null) goto L9;
        r111 = "";
    L9:
        String r103 = r102.f550229b;
        return MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("ec.publishEvent", new com.bytedance.android.ec.hybrid.card.bridge.f(r111)), TuplesKt.to("ec.clearEvent", new com.bytedance.android.ec.hybrid.card.bridge.e(r111)), TuplesKt.to("ec.subscribeEvent", new LynxSubscribeEventBridge(new n(r102), r111, r103)), TuplesKt.to("ec.unsubscribeEvent", new com.bytedance.android.ec.hybrid.card.bridge.g(r111, r103)), TuplesKt.to("setBcmParams", new com.bytedance.android.ec.hybrid.card.bridge.h(new ECLynxCardUtil$makeOriginBridge$3(r102))), TuplesKt.to("createBtmChain", new CreateBtmChainBridge(new ECLynxCardUtil$makeOriginBridge$4(r102))), TuplesKt.to("appendEntranceInfo", new AppendEntranceInfoBridge(new ECLynxCardUtil$makeOriginBridge$5(r102))), TuplesKt.to("sendBstExposureMethod", new BstSendBstExposureEventBridge(new ECLynxCardUtil$makeOriginBridge$6(r102)))});
    L5:
        r101 = null;
        goto L6
    }

    public static void b(com.bytedance.android.ec.hybrid.card.impl.h r100) {
        Intrinsics.checkNotNullParameter(r100, "processParams");
        IKitView r101 = r100.f46534a;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r100.f46545l != null) goto L18;
        ECLynxLoadParam r102 = r100.f46543j;
        String r103 = null;
        if (r102 == null) goto L9;
        String r104 = r102.f46313d;
    L10:
        l r105 = new l(r101, r104);
        if (r102 == null) goto L13;
        r103 = r102.f46328s;
    L13:
        if (r103 != null) goto L15;
        r103 = "";
    L15:
        ECEventCenter.e("ec.updateGlobalProps", r105, r103);
        Unit r106 = Unit.INSTANCE;
        r100.f46545l = r105;
        return;
    L9:
        r104 = null;
        goto L10
    }
}
