package com.bytedance.android.shopping.deepfeed.ui.vh;

import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.ec.common.api.inflow.AnchorBenefitToast;
import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.shopping.deepfeed.event.DeepFeedProductEventTracker;
import com.bytedance.android.shopping.deepfeed.slice.service.DeepFeedSlcCommonService;
import com.bytedance.android.shopping.deepfeed.slice.view.list.DeepFeedSlcList;
import com.bytedance.android.shopping.deepfeed.slice.view.video.DeepFeedSliceVideoView;
import com.bytedance.android.shopping.deepfeed.utlis.DataUtilsKt$createDefaultIAction$1;
import com.bytedance.android.shopping.deepfeed.viewmodel.DeepFeedProductViewModel;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductV2;
import com.larus.bmhome.share.panel.ShareChannel;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import he3.h2;
import he3.k0;
import he3.n0;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/ui/vh/DeepFeedProductSlcVH;", "Lcom/bytedance/android/shopping/deepfeed/ui/vh/AbsDeepFeedProductVH;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class DeepFeedProductSlcVH extends AbsDeepFeedProductVH {

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final /* synthetic */ int f173813k0 = 0;
    public Map<String, Object> Q;
    public boolean R;
    public boolean S;
    public boolean T;
    public boolean U;
    public boolean V;
    public boolean W;
    public DeepFeedSlcCommonService X;
    public DeepFeedSlcList Y;
    public boolean Z;

    @Override // com.bytedance.android.shopping.deepfeed.ui.vh.AbsDeepFeedProductVH
    public final void d4() {
    }

    @Override // com.bytedance.android.shopping.deepfeed.ui.vh.AbsDeepFeedProductVH
    public final void e4() {
    }

    @Override // com.bytedance.android.shopping.deepfeed.ui.vh.AbsDeepFeedProductVH
    public final void f4() {
    }

    @Override // com.bytedance.android.shopping.deepfeed.ui.vh.AbsDeepFeedProductVH
    public final void g4() {
    }

    @Override // com.bytedance.android.shopping.deepfeed.ui.vh.AbsDeepFeedProductVH
    public final boolean l4() {
        return false;
    }

    @Override // com.bytedance.android.shopping.deepfeed.ui.vh.AbsDeepFeedProductVH
    public final void v4() {
    }

    @Override // com.bytedance.android.shopping.deepfeed.ui.vh.AbsDeepFeedProductVH
    @Deprecated(message = "在 slice 场景不需要这个方法了")
    public final void w4(int r100) {
    }

    public final DeepFeedSlcList C4() {
        DeepFeedSlcList r100 = this.Y;
        if (r100 != null) goto L9;
        DeepFeedSlcList r101 = B4(this.itemView);
        if (r101 == null) goto L7;
        this.Y = r101;
        return r101;
    L7:
        return null;
    L9:
        return r100;
    }

    public final void H4() {
        InFeedProductV2 r100 = this.f173751m;
        if (r100 == null) goto L9;
        he3.v r101 = r100.getDynamicData();
        if (r101 == null) goto L9;
        if (r101.f484852n != true) goto L9;
        return;
    L9:
        InFeedProductV2 r102 = this.f173751m;
        if (r102 == null) goto L14;
        he3.v r103 = r102.getDynamicData();
        if (r103 == null) goto L14;
        r103.f484852n = true;
    L14:
        Integer r104 = i4().findReportCardIndex(this.f173751m);
        if (r104 == null) goto L24;
        int r105 = r104.intValue();
        InFeedProductV2 r106 = this.f173751m;
        if (r106 == null) goto L19;
        Map<String, Object> r107 = com.bytedance.android.shopping.deepfeed.utlis.a.b(r106, com.bytedance.android.ec.core.event.a.KEY_SHOW_PRODUCT);
    L20:
        Map<String, Object> r108 = r107;
        DeepFeedProductEventTracker r109 = i4().getEventTracker();
        if (r109 == null) goto L25;
        r109.z(r105, this.f173751m, this.f173755q, null, this.f173752n, r108);
        return;
    L25:
        return;
    L19:
        r107 = null;
        goto L20
    }

    public final void Z1() {
        InFeedProductV2 r100 = this.f173751m;
        if (r100 == null) goto L7;
        he3.v r101 = r100.getDynamicData();
        if (r101 == null) goto L7;
        String r102 = r101.f484850l;
    L8:
        if (r102 != null) goto L11;
        r102 = "";
    L11:
        if (r102.length() != 0) goto L13;
        boolean r103 = true;
    L14:
        if (r103 == false) goto L16;
        return;
    L16:
        getAdapterPosition();
        getAdapterPosition();
        i4().curNoFullScreenCount();
        if (this.f173753o == false) goto L21;
        throw null;
    L21:
        throw null;
    L13:
        r103 = false;
    L7:
        r102 = null;
        goto L8
    }

    @Override // com.bytedance.jedi.ext.adapter.JediViewHolder
    public final void onDestroy() {
        if (this.X != null) goto L6;
        return;
    L6:
        throw null;
    }

    @Override // com.bytedance.android.shopping.deepfeed.ui.vh.AbsDeepFeedProductVH
    public void q4() {
        super.q4();
        throw null;
    }

    public static DeepFeedSlcList B4(View r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$findDeepFeedSlcList");
        if ((r100 instanceof DeepFeedSlcList) == false) goto L7;
        return (DeepFeedSlcList) r100;
    L7:
        if ((r100 instanceof ViewGroup) == false) goto L14;
        ViewGroup r101 = (ViewGroup) r100;
        int r102 = r101.getChildCount();
        int r103 = 0;
    L9:
        if (r103 >= r102) goto L18;
        DeepFeedSlcList r104 = B4(r101.getChildAt(r103));
        if (r104 != null) goto L12;
        r103 = r103 + 1;
        goto L9
    L12:
        return r104;
    L18:
        return null;
    L14:
        return null;
    }

    public final String A4(String r100) {
        Intrinsics.checkNotNullParameter(r100, "area");
        switch(r100.hashCode()) {
            case -1476195426: goto L45;
            case -1335224239: goto L42;
            case -1236338690: goto L39;
            case -906336856: goto L36;
            case -425218655: goto L33;
            case 97926: goto L30;
            case 3046176: goto L27;
            case 3529462: goto L24;
            case 106934601: goto L21;
            case 110371416: goto L18;
            case 798171989: goto L15;
            case 810061429: goto L12;
            case 949444906: goto L9;
            case 950398559: goto L6;
            default: goto L47;
        };
    L47:
        return null;
    L6:
        if (r100.equals("comment") == false) goto L47;
        return this.f173762x;
    L9:
        if (r100.equals(ShareChannel.COLLECT) == false) goto L47;
        return this.f173761w;
    L12:
        if (r100.equals(com.bytedance.android.ec.core.event.a.VALUE_VIDEO_TYPE_MAIN_VIDEO) == false) goto L47;
        return this.f173755q;
    L15:
        if (r100.equals("main_image") == false) goto L47;
        return this.f173755q;
    L18:
        if (r100.equals("title") == false) goto L47;
        return this.B;
    L21:
        if (r100.equals("price") == false) goto L47;
        return this.f173755q;
    L24:
        if (r100.equals("shop") == false) goto L47;
        return this.f173759u;
    L27:
        if (r100.equals("cart") == false) goto L47;
        return this.f173757s;
    L30:
        if (r100.equals("buy") == false) goto L47;
        return this.f173758t;
    L33:
        if (r100.equals(com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_DETAIL) == false) goto L47;
        return this.f173755q;
    L36:
        if (r100.equals("search") == false) goto L47;
        return this.f173760v;
    L39:
        if (r100.equals("add_cart") == false) goto L47;
        return this.f173757s;
    L42:
        if (r100.equals("detail") == false) goto L47;
        return this.A;
    L45:
        if (r100.equals("display_image") == false) goto L47;
        return this.f173764z;
    }

    public void E4(InFeedProductV2 r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        this.f173751m = r100;
        DeepFeedSlcCommonService r101 = this.X;
        if (r101 == null) goto L11;
        WeakReference<View> r102 = r101.f173422d;
        if (r102 == null) goto L7;
        r102.clear();
    L7:
        WeakReference<View> r103 = r101.f173423e;
        if (r103 == null) goto L10;
        r103.clear();
    L10:
        r101.f173422d = null;
        r101.f173423e = null;
        r101.f173424f = null;
        r101.f173425g = false;
    L11:
        this.Y = null;
        this.U = false;
        this.V = false;
        this.W = false;
        throw null;
    }

    public final void I4(final List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "list");
        Function0<Unit> r101 = new DeepFeedProductSlcVH$tagFromRecommend$1(this, r100);
        Intrinsics.checkNotNullParameter(r101, com.alipay.sdk.m.p.e.f25671s);
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        r101.invoke();
        return;
    L5:
        this.f173754p.post(new e(r101));
    }

    @Override // com.bytedance.jedi.ext.adapter.JediSimpleViewHolder
    public /* bridge */ /* synthetic */ void a4(InFeedProductV2 r100) {
        E4(r100);
    }

    @Override // com.bytedance.android.shopping.deepfeed.ui.vh.AbsDeepFeedProductVH
    public final void c4(int r100) {
        throw null;
    }

    @Override // com.bytedance.android.shopping.deepfeed.ui.vh.AbsDeepFeedProductVH
    public final void n4(boolean r100) {
        if (r100 != com.bytedance.android.shopping.deepfeed.utlis.f.f173979b) goto L6;
        return;
    L6:
        throw null;
    }

    @Override // com.bytedance.android.shopping.deepfeed.ui.vh.AbsDeepFeedProductVH
    public final void s4(String r110) {
        Intrinsics.checkNotNullParameter(r110, "finishMethod");
        DeepFeedSlcCommonService r100 = this.X;
        if (r100 == null) goto L15;
        Intrinsics.checkNotNullParameter(r110, "finishMethod");
        int r101 = com.bytedance.android.shopping.deepfeed.event.f.f173359a;
        String r102 = com.bytedance.android.shopping.deepfeed.event.f.a(r100.f173426h.f173751m);
        if (r102 == null) goto L16;
        DeepFeedSliceVideoView.f173648q.getClass();
        if (DeepFeedSliceVideoView.f173646o.add(r102) == true) goto L11;
        return;
    L11:
        if (((DeepFeedSliceVideoView.a.C2597a) ((LinkedHashMap) DeepFeedSliceVideoView.f173647p).get(r102)) == null) goto L18;
        DeepFeedProductViewModel r103 = r100.f173426h.i4();
        DeepFeedProductSlcVH r104 = r100.f173426h;
        r103.reportCardVideoProgress(r104.f173751m, 0, 0, false, r110, r104.f173755q, r104.itemView);
        return;
    L18:
        return;
    L16:
        return;
    }

    @Override // com.bytedance.android.shopping.deepfeed.ui.vh.AbsDeepFeedProductVH
    public final void u4(boolean r100) {
        this.f173753o = r100;
        if (r100 == false) goto L40;
        boolean r101 = true;
        if (this.U == true) goto L9;
        this.U = true;
        Function0<Unit> r102 = this.M;
        if (r102 == null) goto L9;
        Unit r103 = r102.invoke();
    L9:
        i4().onFocusInFeedProductChange(this.f173751m);
        Map<String, Object> r104 = this.Q;
        if (r104 == null) goto L12;
        this.f173754p.post(new q(r104, this));
    L12:
        Boolean r105 = Boolean.TRUE;
        Map<String, ? extends Object> r106 = MapsKt.mapOf(new Pair[]{TuplesKt.to("visible", r105), TuplesKt.to(ITTVideoEngineEventSource.KEY_MUTE, Boolean.valueOf(com.bytedance.android.shopping.deepfeed.utlis.f.f173979b)), TuplesKt.to("is_playing", r105)});
        InFeedProductV2 r107 = this.f173751m;
        if (r107 == null) goto L19;
        n0 r108 = r107.slcCard();
        if (r108 == null) goto L19;
        com.bytedance.android.shopping.deepfeed.slice.c r109 = r108.f484836d;
        if (r109 == null) goto L19;
        r109.a(r106);
    L19:
        int r110 = ie3.b.f489470a;
        ie3.b.a("show", "");
        j4();
        DeepFeedProductEventTracker r111 = i4().getEventTracker();
        if (r111 == null) goto L31;
        InFeedProductV2 r112 = this.f173751m;
        if (r112 != null) goto L24;
    L27:
        r101 = false;
    L28:
        if (r101 == true) goto L31;
    L37:
        Z1();
        return;
    L24:
        if (r111.f173285a.contains(r112) == true) goto L27;
        r111.f173285a.add(r112);
    L31:
        if (this.Z == false) goto L33;
        H4();
    L34:
        InFeedProductV2 r113 = this.f173751m;
        if (r113 == null) goto L37;
        i4().onCardShow(r113);
        goto L37
    L33:
        this.f173754p.post(new n(this));
        goto L34
    L40:
        throw null;
    }

    @Override // com.bytedance.android.shopping.deepfeed.ui.vh.AbsDeepFeedProductVH
    public final void y4(he3.l r100, com.bytedance.android.shopping.deepfeed.action.h r101) {
        Intrinsics.checkNotNullParameter(r100, "couponResp");
        Intrinsics.checkNotNullParameter(r101, "dfContext");
        InFeedProductV2 r102 = this.f173751m;
        if (r102 == null) goto L7;
        he3.v r103 = r102.getDynamicData();
        if (r103 == null) goto L7;
        r103.f484842d = r100;
    L7:
        InFeedProductV2 r104 = this.f173751m;
        if (r104 == null) goto L14;
        n0 r105 = r104.slcCard();
        if (r105 == null) goto L14;
        k0 r106 = r105.e();
        if (r106 == null) goto L14;
        h2 r107 = r106.f();
    L15:
        this.V = com.bytedance.android.shopping.deepfeed.utlis.h.c(r107);
        Map<Long, he3.j> r108 = r100.b();
        if (r108 == null) goto L53;
        Set<Long> r109 = r108.keySet();
        if (r109 == null) goto L54;
        Iterator<T> r110 = r109.iterator();
        if (r110.hasNext() == false) goto L55;
        he3.j r111 = r100.b().get(Long.valueOf(((Number) r110.next()).longValue()));
        if (r111 == null) goto L56;
        String r112 = u0.d(r111);
        if (r112 != null) goto L51;
        return;
    L51:
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L47
        InFeedProductV2 r114 = this.f173751m;     // Catch: Throwable -> L47
        if (r114 == null) goto L34;
        n0 r115 = r114.slcCard();     // Catch: Throwable -> L47
        if (r115 == null) goto L34;
        com.bytedance.android.shopping.deepfeed.slice.c r116 = r115.f484836d;     // Catch: Throwable -> L47
        if (r116 == null) goto L34;
        Map<String, ? extends Object> r117 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(AnchorBenefitToast.TYPE_COUPON, xc3.b.b(new JSONObject(r112))), TuplesKt.to("show_waist_coupon", Boolean.valueOf(this.V))});     // Catch: Throwable -> L47
        Intrinsics.checkNotNullParameter(r117, "data");     // Catch: Throwable -> L47
        r116.c(r117);     // Catch: Throwable -> L47
        r116.b();     // Catch: Throwable -> L47
    L34:
        if (this.V == true) goto L36;
    L45:
        Object r118 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L47
    L49:
        Result.m9448boximpl(r118);
        return;
    L36:
        if (this.W == true) goto L45;
        this.W = true;     // Catch: Throwable -> L47
        IHybridHostService r119 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L47
        if (r119 == null) goto L45;
        yj.s r120 = r119.getIHybridHostUserService();     // Catch: Throwable -> L47
        if (r120 == null) goto L45;
        String r121 = r120.getCurrentUserId();     // Catch: Throwable -> L47
        if (r121 == null) goto L45;
        com.bytedance.android.shopping.deepfeed.utlis.h.f173984a.put(r121, Long.valueOf(System.currentTimeMillis()));     // Catch: Throwable -> L47
        int r122 = ed3.b.f472197a;     // Catch: Throwable -> L47
        Intrinsics.checkNotNullParameter("mall_deep_feed_popup.".concat(r121), "key");     // Catch: Throwable -> L47
    L47:
        th = move-exception;
        Result.Companion r123 = Result.Companion;
        r118 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L49
    L56:
        return;
    L55:
        return;
    L54:
        return;
    L53:
        return;
    L14:
        r107 = null;
        goto L15
    }

    public final void F4(String r100, Map<String, ? extends Object> r101, View r102) {
        Intrinsics.checkNotNullParameter(r100, "actionName");
        Intrinsics.checkNotNullParameter(r102, "view");
        Intrinsics.checkNotNullParameter(r100, "actionName");
        new DataUtilsKt$createDefaultIAction$1(r100, r101);
        throw null;
    }
}
