package com.bytedance.android.shopping.deepfeed;

import android.net.Uri;
import android.os.SystemClock;
import com.bytedance.android.ec.common.api.inflow.AnchorBenefitToast;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.downloadlib.constants.ComplianceConstants;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u00012\u0015\u0010\u0002\u001a\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0015\u0010\u0007\u001a\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "p1", "", "Lkotlin/ParameterName;", "name", "routeType", "p2", "schema", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class DeepFeedProductFragment$onCreate$3$2$1 extends FunctionReferenceImpl implements Function2<String, String, Unit> {
    public DeepFeedProductFragment$onCreate$3$2$1(com.bytedance.android.shopping.deepfeed.event.a r100) {
        super(2, r100, com.bytedance.android.shopping.deepfeed.event.a.class, "markRouteStarted", "markRouteStarted(Ljava/lang/String;Ljava/lang/String;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String r210, String r211) {
        Intrinsics.checkNotNullParameter(r210, "p1");
        Intrinsics.checkNotNullParameter(r211, "p2");
        com.bytedance.android.shopping.deepfeed.event.a r100 = (com.bytedance.android.shopping.deepfeed.event.a) this.receiver;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r210, "routeType");
        Intrinsics.checkNotNullParameter(r211, "schema");
        String r101 = null;
        r100.f173301f = null;
        Object r102 = "";
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L11
        Uri r104 = UriProtector.parse(r211);     // Catch: Throwable -> L11
        String r105 = r104.getHost();     // Catch: Throwable -> L11
        if (r105 != null) goto L6;
        r105 = "";
    L6:
        String r106 = r104.getPath();     // Catch: Throwable -> L11
        if (r106 != null) goto L9;
        r106 = "";
    L9:
        Object r107 = Result.m9449constructorimpl(r105.concat(r106));     // Catch: Throwable -> L11
    L14:
        if (Result.m9455isFailureimpl(r107) == true) goto L17;
        r102 = r107;
    L17:
        String r108 = (String) r102;
        if (StringsKt.equals(r210, "add_cart", true) == false) goto L21;
    L95:
        if (r101 == null) goto L118;
        com.bytedance.android.shopping.deepfeed.event.a.d r109 = r100.f173298c;
        if (Intrinsics.areEqual(r101, com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_DETAIL) == false) goto L105;
        if (r109 == null) goto L105;
        if (r109.f173335m != true) goto L105;
        if (r100.f(r109) == false) goto L105;
        String r110 = BitableAnalytic.ProgressInputType.DRAG;
    L106:
        long r111 = r100.f173297b + 1;
        r100.f173297b = r111;
        String r112 = r101;
        String r212 = r110;
        r100.f173301f = new com.bytedance.android.shopping.deepfeed.event.a.e(r111, r112, System.currentTimeMillis(), SystemClock.elapsedRealtime(), r212, r100.f173300e);
        if (Intrinsics.areEqual(r101, com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_DETAIL) == true) goto L109;
        return;
    L109:
        if (Intrinsics.areEqual(r110, BitableAnalytic.ProgressInputType.DRAG) == false) goto L116;
        if (r109 == null) goto L117;
        r100.b();
        r109.f173336n = "enter_detail";
        return;
    L117:
        return;
    L116:
        return;
    L105:
        r110 = "click";
        goto L106
    L118:
        return;
    L21:
        if (StringsKt.equals(r210, com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_DETAIL, true) == false) goto L24;
    L77:
        r101 = com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_DETAIL;
        goto L95
    L24:
        if (StringsKt.equals(r210, "cart", true) == false) goto L27;
    L65:
        r101 = "cart";
        goto L95
    L27:
        if (StringsKt.equals(r210, "comment", true) == false) goto L30;
    L92:
        r101 = "comment";
        goto L95
    L30:
        if (StringsKt.equals(r210, "shop", true) == false) goto L33;
    L91:
        r101 = "shop";
        goto L95
    L33:
        if (StringsKt.equals(r210, "search", true) == false) goto L36;
    L85:
        r101 = "search";
        goto L95
    L36:
        if (StringsKt.equals(r210, "pause_search", true) == true) goto L85;
        if (StringsKt.equals(r210, "live", true) == false) goto L42;
    L90:
        r101 = "live";
        goto L95
    L42:
        if (StringsKt.equals(r210, "buy", true) == false) goto L45;
    L93:
        r101 = "order_submit";
        goto L95
    L45:
        if (StringsKt.equals(r210, "coupon_list", true) == false) goto L47;
    L94:
        r101 = "coupon_list";
        goto L95
    L47:
        if (StringsKt.equals(r210, "coupon_waist", true) == true) goto L94;
        if (StringsKt.contains(r108, "order_submit", true) == true) goto L93;
        if (StringsKt.contains(r108, "confirm_order", true) == true) goto L93;
        if (StringsKt.contains(r108, AnchorBenefitToast.TYPE_COUPON, true) == false) goto L62;
        if (StringsKt.contains(r108, "list", true) == true) goto L94;
        if (StringsKt.contains(r108, "receive", true) == true) goto L94;
    L62:
        if (StringsKt.contains(r108, "cart", true) == false) goto L67;
        if (StringsKt.contains(r108, "add_cart", true) == false) goto L65;
    L67:
        if (StringsKt.contains(r108, "comment", true) == true) goto L92;
        if (StringsKt.contains(r108, "evaluation", true) == true) goto L92;
        if (StringsKt.contains(r108, "product", true) == false) goto L79;
        if (StringsKt.contains(r108, "detail", true) == true) goto L77;
        if (StringsKt.contains(r108, "anchorv3", true) == true) goto L77;
    L79:
        if (StringsKt.contains(r108, "shop", true) == true) goto L91;
        if (StringsKt.contains(r108, ComplianceConstants.ComplianceRequest.MARKET_STORE, true) == true) goto L91;
        if (StringsKt.contains(r108, "search", true) == true) goto L85;
        if (StringsKt.contains(r108, "live", true) == true) goto L90;
        if (StringsKt.contains(r108, "room", true) == false) goto L95;
    L11:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(String r100, String r101) {
        invoke2(r100, r101);
        return Unit.INSTANCE;
    }
}
