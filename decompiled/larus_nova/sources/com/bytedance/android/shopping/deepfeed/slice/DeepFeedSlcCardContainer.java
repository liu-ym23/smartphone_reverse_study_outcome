package com.bytedance.android.shopping.deepfeed.slice;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.TextureView;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.shopping.deepfeed.action.h;
import com.bytedance.android.shopping.deepfeed.data.repo.l;
import com.bytedance.android.shopping.deepfeed.data.repo.n;
import com.bytedance.android.shopping.deepfeed.data.repo.o;
import com.bytedance.android.shopping.deepfeed.event.DeepFeedProductEventTracker;
import com.bytedance.android.shopping.deepfeed.slice.action.v;
import com.bytedance.android.shopping.deepfeed.slice.action.w;
import com.bytedance.android.shopping.deepfeed.slice.view.list.DeepFeedSlcElementVH;
import com.bytedance.android.shopping.deepfeed.slice.view.list.DeepFeedSlcList;
import com.bytedance.android.shopping.deepfeed.slice.view.video.DeepFeedSliceVideoView;
import com.bytedance.android.shopping.deepfeed.ui.vh.DeepFeedProductSlcVH;
import com.bytedance.android.shopping.deepfeed.utlis.k;
import com.bytedance.android.shopping.deepfeed.viewmodel.DeepFeedProductViewModel;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductV2;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.services.apm.api.EnsureManager;
import com.larus.bmhome.share.panel.ShareChannel;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import he3.e1;
import he3.n0;
import he3.z0;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class DeepFeedSlcCardContainer implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f173373a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f173374b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, v> f173375c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f173376d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final DeepFeedProductSlcVH f173377e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final DeepFeedProductViewModel f173378f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final h f173379g;

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.w
    public final DeepFeedProductEventTracker A() {
        return this.f173378f.getEventTracker();
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.u
    public final void a() {
        this.f173379g.a();
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.w
    public final com.bytedance.android.shopping.deepfeed.action.d c() {
        return this.f173378f.getActionHelper();
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.w
    public final boolean i() {
        DeepFeedProductSlcVH r100 = this.f173377e;
        r100.getClass();
        r100.getAdapterPosition();
        throw null;
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.w
    public final vc3.b q() {
        return new vc3.b(this.f173377e.f173751m);
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.w
    public final boolean v() {
        this.f173379g.v();
        return false;
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.y
    public final void C(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        InFeedProductV2 r101 = this.f173377e.f173751m;
        if (r101 == null) goto L12;
        n0 r102 = r101.slcCard();
        if (r102 == null) goto L13;
        c r103 = r102.f484836d;
        if (r103 != null) goto L10;
        return;
    L10:
        xc3.a.b(r103, r100);
        return;
    L13:
        return;
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.w
    public final void b(boolean r100) {
        this.f173377e.getClass();
        throw null;
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.w
    public final vc3.c j(vc3.d r110) {
        Intrinsics.checkNotNullParameter(r110, "params");
        boolean r100 = false;
        if (r110.f554103b.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L10;
        String r102 = this.f173377e.A4(r110.f554102a);
    L8:
        String r103 = r102;
        String r104 = "";
        if (r110.f554105d == true) goto L28;
        DeepFeedProductSlcVH r105 = this.f173377e;
        if (Intrinsics.areEqual(r103, r105.f173755q) == false) goto L18;
    L21:
        r100 = true;
    L22:
        if (r100 == true) goto L28;
        if (r103 == null) goto L27;
        r104 = r103;
    L27:
        View r111 = r110.f554106e;
        Intrinsics.checkNotNullParameter(r104, "btm");
        Intrinsics.checkNotNullParameter(r111, "view");
        String r112 = le3.b.d(r104, r111, null);
    L33:
        String r106 = r112;
        DeepFeedProductSlcVH r113 = this.f173377e;
        Pair r114 = TuplesKt.to(r113.E, r113.F);
        InFeedProductV2 r107 = this.f173377e.f173751m;
        if (r107 == null) goto L38;
        he3.v r108 = r107.getDynamicData();
        if (r108 == null) goto L38;
        int r109 = r108.f484841c;
    L40:
        return new vc3.c(r107, r109, this.f173378f.getFeedParam(), r106, r103, (JSONArray) r114.getFirst(), (Long) r114.getSecond(), this.f173377e.D);
    L38:
        r109 = -1;
        goto L40
    L18:
        if (Intrinsics.areEqual(r103, r105.f173757s) == true) goto L21;
        if (Intrinsics.areEqual(r103, r105.f173758t) == false) goto L22;
    L28:
        InFeedProductV2 r115 = this.f173377e.f173751m;
        if (r103 == null) goto L32;
        r104 = r103;
    L32:
        r112 = com.bytedance.android.shopping.deepfeed.utlis.a.c(r115, r104, r110.f554106e);
        goto L33
    L10:
        if (r110.f554104c == false) goto L12;
        r102 = r110.f554103b + "_i" + (this.f173377e.getAdapterPosition() + 1);
        goto L8
    L12:
        r102 = r110.f554103b;
        goto L8
    L5:
        r101 = false;
        goto L6
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.w
    public final v r(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        return (v) ((LinkedHashMap) this.f173375c).get(r100);
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.w
    public final String s(String r100) {
        Intrinsics.checkNotNullParameter(r100, "link");
        boolean r101 = false;
        if (StringsKt.startsWith$default(r100, "$", false, 2, null) == false) goto L5;
        r100 = StringsKt.substringAfter$default(r100, "$", null, 2, null);
    L5:
        InFeedProductV2 r102 = this.f173377e.f173751m;
        if (r102 == null) goto L13;
        n0 r103 = r102.slcCard();
        if (r103 == null) goto L13;
        Map<String, String> r104 = r103.d();
        if (r104 == null) goto L13;
        String r105 = r104.get(r100);
        if (r105 == null) goto L13;
    L22:
        if (r105 != null) goto L24;
    L25:
        r101 = true;
    L26:
        if (r101 == false) goto L37;
        if (this.f173376d == false) goto L37;
        InFeedProductV2 r106 = this.f173377e.f173751m;
        if (r106 == null) goto L38;
        n0 r107 = r106.slcCard();
        if (r107 == null) goto L39;
        Map<String, String> r108 = r107.d();
        if (r108 != null) goto L41;
        return null;
    L41:
        return r108.get(com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_DETAIL);
    L39:
        return null;
    L38:
        return null;
    L37:
        return r105;
    L24:
        if (r105.length() != 0) goto L26;
    L13:
        l r109 = this.f173378f.getResp();
        if (r109 == null) goto L21;
        o r110 = r109.b();
        if (r110 == null) goto L18;
        Map<String, String> r111 = r110.b();
    L19:
        if (r111 == null) goto L21;
        r105 = r111.get(r100);
        goto L22
    L18:
        r111 = null;
    L21:
        r105 = null;
        goto L22
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.w
    public final void t(Function1<? super String, Unit> r110) {
        Intrinsics.checkNotNullParameter(r110, "callback");
        DeepFeedSlcList r100 = this.f173377e.C4();
        if (r100 == null) goto L57;
        Intrinsics.checkNotNullParameter(r110, "callback");
        RecyclerView.ViewHolder r101 = r100.findViewHolderForAdapterPosition(r100.f173563j);
        Object r102 = null;
        if ((r101 instanceof DeepFeedSlcElementVH) == true) goto L7;
        r101 = null;
    L7:
        DeepFeedSlcElementVH r103 = (DeepFeedSlcElementVH) r101;
        if (r103 != null) goto L10;
        r110.invoke(null);
        return;
    L10:
        String r104 = String.valueOf(r100.getContext().getCacheDir().getAbsolutePath());
        View r105 = DeepFeedSlcList.z(r103.f173557a);
        if ((r105 instanceof ad3.b) == false) goto L48;
        View r106 = (ad3.b) r105;
        r106.getClass();
        Intrinsics.checkNotNullParameter(r104, "filePathPrefix");
        Intrinsics.checkNotNullParameter(r110, "callback");
        if (r106.getWidth() > 0) goto L15;
    L46:
        r110.invoke(null);
        return;
    L15:
        if (r106.getHeight() <= 0) goto L46;
        int r107 = k.f173989a;
        Intrinsics.checkNotNullParameter(r106, "view");
        if ((r106 instanceof TextureView) == false) goto L22;
        Bitmap r108 = ((TextureView) r106).getBitmap();
        if (r108 == null) goto L22;
    L23:
        Intrinsics.checkNotNullParameter(r104, "filePathPrefix");
        if (r108 != null) goto L56;
    L45:
        r110.invoke(r102);
        return;
    L56:
        Result.Companion r109 = Result.Companion;     // Catch: Throwable -> L38
        PolarisFileWrapper r111 = new PolarisFileWrapper(r104.concat("/deep_feed_photo_search.jpeg"));     // Catch: Throwable -> L38
        File r112 = r111.getParentFile();     // Catch: Throwable -> L38
        if (r112 == null) goto L29;
        r112.mkdirs();     // Catch: Throwable -> L38
    L29:
        PolarisFileOutputStreamWrapper r113 = new PolarisFileOutputStreamWrapper(r111);     // Catch: Throwable -> L38
        r108.compress(Bitmap.CompressFormat.JPEG, 100, r113);     // Catch: Throwable -> L33
        r113.flush();     // Catch: Throwable -> L33
        Unit r114 = Unit.INSTANCE;     // Catch: Throwable -> L33
        CloseableKt.closeFinally(r113, null);     // Catch: Throwable -> L38
        Object r115 = Result.m9449constructorimpl(r111.getAbsolutePath());     // Catch: Throwable -> L38
    L41:
        if (Result.m9455isFailureimpl(r115) == true) goto L44;
        r102 = r115;
    L44:
        r102 = (String) r102;
        goto L45
    L33:
        th = move-exception;
        throw th;     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        CloseableKt.closeFinally(r113, th);     // Catch: Throwable -> L38
        throw th;     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        r115 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L22:
        r106.measure(View.MeasureSpec.makeMeasureSpec(r106.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(r106.getHeight(), 1073741824));
        r106.layout(r106.getLeft(), r106.getTop(), r106.getRight(), r106.getBottom());
        r108 = Bitmap.createBitmap(r106.getMeasuredWidth(), r106.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        r106.draw(new Canvas(r108));
        goto L23
    L48:
        if ((r105 instanceof DeepFeedSliceVideoView) == false) goto L50;
        ((DeepFeedSliceVideoView) r105).c(r104, r110);
        return;
    L50:
        r110.invoke(null);
        return;
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.w
    public final void w(int r100) {
        h r101 = this.f173379g;
        if (r101 == null) goto L6;
        r101.u(new com.bytedance.android.shopping.deepfeed.viewmodel.a(r100));
        return;
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.w
    public final void x(final Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "afterAction");
        this.f173378f.actionAfterCouponRequest(this.f173377e.f173751m, new DeepFeedSlcCardContainer$requestMixCoupon$1(r100));
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.w
    public final void y(boolean r100) {
        this.f173377e.n4(r100);
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.w
    public final void g(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "lynxUrl");
        Intrinsics.checkNotNullParameter(r101, "popupType");
        h r102 = this.f173379g;
        new DeepFeedSlcCardContainer$openPopup$1(this);
        r102.h();
        this.f173379g.g(r101);
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.w
    public final void h(View r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "targetView");
        Intrinsics.checkNotNullParameter(r101, "viewName");
        int r102 = r101.hashCode();
        if (r102 == (-1476195426)) goto L22;
        if (r102 == (-1030424504)) goto L13;
        if (r102 == 213085284) goto L10;
        return;
    L10:
        if (r101.equals("cart_view") == false) goto L25;
        this.f173373a = r100;
        return;
    L25:
        return;
    L13:
        if (r101.equals("recommend_view") == false) goto L27;
        InFeedProductV2 r103 = this.f173377e.f173751m;
        if (r103 == null) goto L28;
        he3.v r104 = r103.getDynamicData();
        if (r104 != null) goto L19;
        return;
    L19:
        if (r104.f484843e != true) goto L30;
        Pair r105 = k.b(r100);
        h r106 = this.f173379g;
        ((Number) r105.getFirst()).intValue();
        r100.getWidth();
        ((Number) r105.getSecond()).intValue();
        com.bytedance.android.shopping.extensions.b.b(4);
        r106.o();
        return;
    L30:
        return;
    L28:
        return;
    L27:
        return;
    L22:
        if (r101.equals("display_image") == false) goto L32;
        this.f173374b = r100;
        return;
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.w
    public final void m(Boolean r100, View r110) {
        Intrinsics.checkNotNullParameter(r110, "targetView");
        DeepFeedProductViewModel r101 = this.f173378f;
        DeepFeedProductSlcVH r102 = this.f173377e;
        r101.clickCollect(r102.f173751m, r102.A4(ShareChannel.COLLECT), r110, this.f173377e.f173752n, r100, new DeepFeedSlcCardContainer$clickCollect$1(this));
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.w
    public final void u(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "mainArea");
        DeepFeedProductSlcVH r102 = this.f173377e;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "mainArea");
        r102.getClass();
        r102.getClass();
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.w
    public final void z(int r100, String r101) {
        this.f173379g.p(new com.bytedance.android.shopping.deepfeed.viewmodel.b(r100, r101));
    }

    public DeepFeedSlcCardContainer(DeepFeedProductSlcVH r100, DeepFeedProductViewModel r101, h r102) {
        Intrinsics.checkNotNullParameter(r100, "vh");
        Intrinsics.checkNotNullParameter(r101, "viewModel");
        Intrinsics.checkNotNullParameter(r102, "dfContext");
        this.f173377e = r100;
        this.f173378f = r101;
        this.f173379g = r102;
        this.f173375c = new LinkedHashMap();
        int r103 = com.bytedance.android.ec.base.settings.a.f42813a;
        Object r104 = Boolean.FALSE;
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L166
        Object r106 = null;
        Object r107 = com.bytedance.android.ec.base.settings.d.f42818c.get("mall_deep_feed_default_use_detail_link");     // Catch: Throwable -> L57
        if (r107 != null) goto L9;
    L54:
        Object r108 = null;
    L55:
        Object r109 = Result.m9449constructorimpl(r108);     // Catch: Throwable -> L57
    L59:
        Throwable r110 = Result.m9452exceptionOrNullimpl(r109);     // Catch: Throwable -> L166
        if (r110 == null) goto L63;
        EnsureManager.ensureNotReachHere(r110);     // Catch: Throwable -> L166
    L63:
        if (Result.m9455isFailureimpl(r109) == false) goto L66;
        r109 = null;
    L66:
        if ((r109 instanceof Boolean) == true) goto L68;
        r109 = null;
    L68:
        Object r111 = (Boolean) r109;     // Catch: Throwable -> L166
        if (r111 != null) goto L75;
        Object r112 = com.bytedance.android.ec.base.settings.d.f42816a.get("mall_deep_feed_default_use_detail_link");     // Catch: Throwable -> L166
        if ((r112 instanceof Boolean) == true) goto L74;
        r112 = null;
    L74:
        r111 = (Boolean) r112;     // Catch: Throwable -> L166
    L75:
        if (r111 != null) goto L175;
        int r113 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L166
        Object r114 = com.bytedance.android.ec.base.settings.d.f42818c.get("mall_deep_feed_default_use_detail_link");     // Catch: Throwable -> L130
        if (r114 != null) goto L82;
    L127:
        Object r115 = null;
    L128:
        Object r116 = Result.m9449constructorimpl(r115);     // Catch: Throwable -> L130
    L132:
        Throwable r117 = Result.m9452exceptionOrNullimpl(r116);     // Catch: Throwable -> L156
        if (r117 == null) goto L136;
        EnsureManager.ensureNotReachHere(r117);     // Catch: Throwable -> L156
    L136:
        if (Result.m9455isFailureimpl(r116) == false) goto L139;
        r116 = null;
    L139:
        if ((r116 instanceof Boolean) == true) goto L141;
        r116 = null;
    L141:
        r111 = (Boolean) r116;     // Catch: Throwable -> L156
        if (r111 != null) goto L164;
        IHybridHostService r118 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L156
        if (r118 == null) goto L147;
        Object r119 = r118.getHostABValue("mall_deep_feed_default_use_detail_link", r104);     // Catch: Throwable -> L156
    L148:
        if (r119 != null) goto L150;
    L155:
        r111 = r104;
        goto L164
    L150:
        if ((r119 instanceof Boolean) == false) goto L153;
        r106 = r119;
    L153:
        Object r120 = (Boolean) r106;     // Catch: Throwable -> L156
        if (r120 == null) goto L155;
    L163:
        r111 = r120;
        goto L164
    L147:
        r119 = null;
    L164:
        com.bytedance.android.ec.base.settings.d.d("mall_deep_feed_default_use_detail_link", r111);     // Catch: Throwable -> L166
        goto L175
    L82:
        if ((r114 instanceof Boolean) == true) goto L84;
        Object r121 = null;
    L85:
        r115 = (Boolean) r121;     // Catch: Throwable -> L130
        if (r115 != null) goto L128;
        if ((r114 instanceof Number) == false) goto L115;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r122 = Float.valueOf(((Number) r114).floatValue());     // Catch: Throwable -> L130
        if ((r122 instanceof Boolean) == true) goto L95;
        r122 = null;
    L95:
        r115 = (Boolean) r122;     // Catch: Throwable -> L130
        goto L128
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r123 = Double.valueOf(((Number) r114).doubleValue());     // Catch: Throwable -> L130
        if ((r123 instanceof Boolean) == true) goto L101;
        r123 = null;
    L101:
        r115 = (Boolean) r123;     // Catch: Throwable -> L130
        goto L128
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L109;
        Integer r124 = Integer.valueOf(((Number) r114).intValue());     // Catch: Throwable -> L130
        if ((r124 instanceof Boolean) == true) goto L107;
        r124 = null;
    L107:
        r115 = (Boolean) r124;     // Catch: Throwable -> L130
        goto L128
    L109:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L115;
        Long r125 = Long.valueOf(((Number) r114).longValue());     // Catch: Throwable -> L130
        if ((r125 instanceof Boolean) == true) goto L113;
        r125 = null;
    L113:
        r115 = (Boolean) r125;     // Catch: Throwable -> L130
    L115:
        if ((r114 instanceof JSONObject) == false) goto L117;
    L181:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L123
        Object r126 = SDKSettingsCacheManager.a().fromJson(r114.toString(), Boolean.class);     // Catch: Throwable -> L123
        if ((r126 instanceof Boolean) == true) goto L121;
        r126 = null;
    L121:
        Object r127 = Result.m9449constructorimpl((Boolean) r126);     // Catch: Throwable -> L123
    L125:
        r115 = r127;
        if (Result.m9455isFailureimpl(r115) == false) goto L128;
    L123:
        th = move-exception;
        Result.Companion r128 = Result.Companion;     // Catch: Throwable -> L130
        r127 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L130
        goto L125
    L117:
        if ((r114 instanceof JSONArray) == false) goto L127;
    L84:
        r121 = r114;
    L130:
        th = move-exception;
        Result.Companion r129 = Result.Companion;     // Catch: Throwable -> L156
        r116 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L156
    L156:
        th = move-exception;
        Result.Companion r130 = Result.Companion;     // Catch: Throwable -> L166
        r120 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
        Throwable r131 = Result.m9452exceptionOrNullimpl(r120);     // Catch: Throwable -> L166
        if (r131 == null) goto L161;
        EnsureManager.ensureNotReachHere(r131);     // Catch: Throwable -> L166
    L161:
        if (Result.m9455isFailureimpl(r120) == false) goto L163;
        r120 = r104;
    L175:
        this.f173376d = ((Boolean) r111).booleanValue();
        return;
    L9:
        if ((r107 instanceof Boolean) == true) goto L11;
        Object r132 = null;
    L12:
        r108 = (Boolean) r132;     // Catch: Throwable -> L57
        if (r108 != null) goto L55;
        if ((r107 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L24;
        Float r133 = Float.valueOf(((Number) r107).floatValue());     // Catch: Throwable -> L57
        if ((r133 instanceof Boolean) == true) goto L22;
        r133 = null;
    L22:
        r108 = (Boolean) r133;     // Catch: Throwable -> L57
        goto L55
    L24:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L30;
        Double r134 = Double.valueOf(((Number) r107).doubleValue());     // Catch: Throwable -> L57
        if ((r134 instanceof Boolean) == true) goto L28;
        r134 = null;
    L28:
        r108 = (Boolean) r134;     // Catch: Throwable -> L57
        goto L55
    L30:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        Integer r135 = Integer.valueOf(((Number) r107).intValue());     // Catch: Throwable -> L57
        if ((r135 instanceof Boolean) == true) goto L34;
        r135 = null;
    L34:
        r108 = (Boolean) r135;     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r136 = Long.valueOf(((Number) r107).longValue());     // Catch: Throwable -> L57
        if ((r136 instanceof Boolean) == true) goto L40;
        r136 = null;
    L40:
        r108 = (Boolean) r136;     // Catch: Throwable -> L57
    L42:
        if ((r107 instanceof JSONObject) == false) goto L44;
    L177:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L50
        Object r137 = SDKSettingsCacheManager.a().fromJson(r107.toString(), Boolean.class);     // Catch: Throwable -> L50
        if ((r137 instanceof Boolean) == true) goto L48;
        r137 = null;
    L48:
        Object r138 = Result.m9449constructorimpl((Boolean) r137);     // Catch: Throwable -> L50
    L52:
        r108 = r138;
        if (Result.m9455isFailureimpl(r108) == false) goto L55;
    L50:
        th = move-exception;
        Result.Companion r139 = Result.Companion;     // Catch: Throwable -> L57
        r138 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L52
    L44:
        if ((r107 instanceof JSONArray) == false) goto L54;
    L11:
        r132 = r107;
    L57:
        th = move-exception;
        Result.Companion r140 = Result.Companion;     // Catch: Throwable -> L166
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L166:
        th = move-exception;
        Result.Companion r141 = Result.Companion;
        Object r142 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r143 = Result.m9452exceptionOrNullimpl(r142);
        if (r143 == null) goto L171;
        EnsureManager.ensureNotReachHere(r143);
    L171:
        if (Result.m9455isFailureimpl(r142) == true) goto L174;
        r104 = r142;
    L174:
        r111 = r104;
        goto L175
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.w
    public final void d(String r110, List<String> r111, View r112) {
        Intrinsics.checkNotNullParameter(r110, "query");
        Intrinsics.checkNotNullParameter(r111, "featureInfoList");
        Intrinsics.checkNotNullParameter(r112, "targetView");
        if (r110.length() != 0) goto L5;
        boolean r113 = true;
    L6:
        if (r113 == false) goto L9;
        return;
    L9:
        if (this.f173377e.getAdapterPosition() != (this.f173378f.curNoFullScreenCount() - 1)) goto L12;
        this.f173378f.addNoFullScreenCount();
    L12:
        if (this.f173377e.getAdapterPosition() < this.f173378f.curNoFullScreenCount()) goto L14;
        boolean r100 = true;
    L15:
        String r114 = UUID.randomUUID().toString();
        InFeedProductV2 r115 = this.f173377e.f173751m;
        if (r115 == null) goto L20;
        he3.v r116 = r115.getDynamicData();
        if (r116 == null) goto L20;
        r116.f484848j = true;
    L20:
        InFeedProductV2 r117 = this.f173377e.f173751m;
        if (r117 == null) goto L25;
        he3.v r118 = r117.getDynamicData();
        if (r118 == null) goto L25;
        r118.f484850l = r114;
    L25:
        this.f173377e.Z1();
        l r119 = this.f173378f.getResp();
        if (r119 == null) goto L42;
        Integer r101 = Integer.valueOf(this.f173377e.getAdapterPosition() + 1);
        InFeedProductV2 r102 = this.f173377e.f173751m;
        if (r102 == null) goto L32;
        z0 r103 = r102.getRespExtra();
        if (r103 == null) goto L32;
        Integer r104 = r103.b();
    L33:
        Integer r105 = r104;
        InFeedProductV2 r106 = this.f173377e.f173751m;
        if (r106 == null) goto L39;
        e1 r107 = com.bytedance.android.shopping.deepfeed.utlis.a.a(r106);
        if (r107 == null) goto L39;
        String r108 = r107.a();
        if (r108 == null) goto L39;
    L40:
        l.d(r119, new n(r110, r111, r101, r100, null, r105, r114, r108));
        return;
    L39:
        r108 = "";
    L32:
        r104 = null;
        goto L33
    L42:
        return;
    L14:
        r100 = false;
        goto L15
    L5:
        r113 = false;
        goto L6
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.y
    public final void p(int r100, int r101, Map<String, ? extends Object> r102) {
        Intrinsics.checkNotNullParameter(r102, "data");
        this.f173378f.updateModelRange(r100, r101, r102);
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.w
    public final vc3.a n(String r110, String r111, String r112, boolean r113, View r114) {
        Intrinsics.checkNotNullParameter(r110, "eventName");
        Intrinsics.checkNotNullParameter(r111, "area");
        Intrinsics.checkNotNullParameter(r112, "btm");
        Intrinsics.checkNotNullParameter(r114, "view");
        InFeedProductV2 r100 = this.f173377e.f173751m;
        String r101 = null;
        if (r100 == null) goto L5;
        Map<String, Object> r102 = com.bytedance.android.shopping.deepfeed.utlis.a.b(r100, r110);
    L7:
        if (r112.length() != 0) goto L9;
        boolean r115 = true;
    L10:
        if (r115 == false) goto L12;
        r112 = this.f173377e.A4(r111);
    L14:
        String r103 = r112;
        int r116 = le3.a.f508917a;
        InFeedProductV2 r117 = this.f173377e.f173751m;
        if (r117 == null) goto L19;
        e1 r118 = com.bytedance.android.shopping.deepfeed.utlis.a.a(r117);
        if (r118 == null) goto L19;
        r101 = r118.b();
    L19:
        JSONObject r104 = le3.a.a(r114, r101);
        InFeedProductV2 r119 = this.f173377e.f173751m;
        if (r119 == null) goto L24;
        he3.v r120 = r119.getDynamicData();
        if (r120 == null) goto L24;
        int r105 = r120.f484841c;
    L25:
        DeepFeedProductSlcVH r121 = this.f173377e;
        return new vc3.a(r102, r103, r105, r121.f173751m, r121.f173752n, this.f173378f.getFeedParam(), r104);
    L24:
        r105 = -1;
        goto L25
    L12:
        if (r113 == false) goto L14;
        r112 = r112 + "_i" + (this.f173377e.getAdapterPosition() + 1);
        goto L14
    L9:
        r115 = false;
        goto L10
    L5:
        r102 = null;
        goto L7
    }
}
