package com.bytedance.android.shopping.anchorv4.components;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.k1;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.host.api.service.IECHostService;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.livehostapi.business.IHostShare;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.shopping.anchorv4.data.AnchorV4DataManager;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.anchorv4.experiment.PdpAB;
import com.bytedance.android.shopping.anchorv4.helper.shot.ECScreenshotWatcher;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.discover.model.CardProtocolType;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class ScreenCaptureManager {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f165983j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f165984a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ScreenCaptureManager$screenShotListener$1 f165985b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f165986c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f165987d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c f165988e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Context f165989f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.bytedance.android.shopping.anchorv4.voavhs.headv2.q f165990g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final PageFinder f165991h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final n f165992i;

    public static final class a {
    }

    public static final class b implements v83.a {
        public b() {
        }
    }

    public static final class c implements v83.a {
        public c() {
        }
    }

    public static final class d implements com.bytedance.android.shopping.anchorv4.helper.shot.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ScreenCaptureManager f165993a;

        @Override // com.bytedance.android.shopping.anchorv4.helper.shot.e
        public final void onChange() {
            ScreenCaptureManager r100 = this.f165993a;
            if (r100.a() == false) goto L53;
            ih3.f r101 = ih3.f.f489805b;
            Bundle r102 = r100.b();
            CommonMeta r103 = r100.f165990g.a();
            Context r104 = null;
            if (r103 == null) goto L8;
            String r105 = r103.getSourcePage();
        L9:
            r101.d(r102, IHostShare.ShareType.SCREENSHOT, r105);
            int r106 = ECSdk.f48106a;
            IECHostService r107 = (IECHostService) ECSdk.a(IECHostService.class);
            if (r107 != null) goto L12;
        L14:
            String r108 = r100.f165992i.d();
            if (r108 != null) goto L17;
        L39:
            boolean r109 = false;
        L40:
            if (r109 == false) goto L50;
            String r110 = r100.f165992i.d();
            if (r110 != null) goto L44;
            return;
        L44:
            if (com.bytedance.android.shopping.anchorv3.a.b(r110) == false) goto L52;
            com.bytedance.android.ec.sdk.helper.p.f48130a.openSchema(r100.f165989f, r110);
            return;
        L52:
            return;
        L50:
            return;
        L17:
            if (StringsKt.isBlank(r108) == true) goto L39;
            Context r111 = r100.f165989f;     // Catch: Exception -> L47
            if ((r111 instanceof FragmentActivity) == true) goto L22;
            r111 = null;
        L22:
            FragmentActivity r112 = (FragmentActivity) r111;     // Catch: Exception -> L47
            if (r112 == null) goto L29;
            FragmentManager r113 = r112.getSupportFragmentManager();     // Catch: Exception -> L47
            if (r113 == null) goto L29;
            if (r113.findFragmentByTag("ec_photo_search_dialog_container_fragment") == null) goto L29;
        L38:
            r109 = true;
        L29:
            Context r114 = r100.f165989f;     // Catch: Exception -> L47
            if ((r114 instanceof FragmentActivity) == false) goto L33;
            r104 = r114;
        L33:
            FragmentActivity r115 = (FragmentActivity) r104;     // Catch: Exception -> L47
            if (r115 == null) goto L38;
            FragmentManager r116 = r115.getSupportFragmentManager();     // Catch: Exception -> L47
            if (r116 == null) goto L38;
            r116.findFragmentByTag("photo_search_share_dialog");     // Catch: Exception -> L47
        L12:
            if (r107.getRecommendStatus() == true) goto L14;
        L8:
            r105 = null;
            goto L9
        }

        public d(ScreenCaptureManager r100) {
            this.f165993a = r100;
        }

        @Override // com.bytedance.android.shopping.anchorv4.helper.shot.e
        public final void a(final String r110) {
            final ScreenCaptureManager r100 = this.f165993a;
            r100.getClass();
            if (r110 == null) goto L57;
            int r101 = ECSdk.f48106a;
            IECHostService r102 = (IECHostService) ECSdk.a(IECHostService.class);
            if (r102 == null) goto L11;
            if (r102.getRecommendStatus() == true) goto L11;
            return;
        L11:
            if (r100.f165992i.d() == null) goto L59;
            r100.e(r110);
            Bitmap r103 = BitmapFactory.decodeFile(r110);     // Catch: Exception -> L53
            if (r100.f165992i.a() == true) goto L51;
            com.bytedance.android.shopping.anchorv4.voavhs.headv2.q r104 = r100.f165990g;     // Catch: Exception -> L53
            String r105 = null;
            if (r104 == null) goto L21;
            CommonMeta r106 = r104.a();     // Catch: Exception -> L53
            if (r106 == null) goto L21;
            String r107 = r106.getScreenShotWithQr();     // Catch: Exception -> L53
        L23:
            if (Intrinsics.areEqual(r107, "1") == false) goto L51;
            if (r103 == null) goto L51;
            r100.f165989f.getResources().getDimensionPixelSize(R.dimen.commerce_anchor_v3_top_area_height);     // Catch: Exception -> L53
            int r108 = r100.f165989f.getResources().getDimensionPixelSize(R.dimen.commerce_anchor_v3_bottom_nav_area_height);     // Catch: Exception -> L53
            int r109 = k1.p();     // Catch: Exception -> L53
            Bitmap r111 = Bitmap.createBitmap(r103, 0, r109, k1.m(r100.f165989f), (((k1.j(r100.f165989f) - r109) - r108) - k1.h(r100.f165989f)) - k1.f(com.bytedance.android.shopping.anchorv3.utils.d0.f165305a.getActivity(r100.f165989f)));     // Catch: Exception -> L53
            kc.a r112 = BtmSDK.getBcmChainByFinder$default(BtmSDK.INSTANCE, r100.f165991h, 0, false, 6, null);     // Catch: Exception -> L53
            ih3.f r113 = ih3.f.f489805b;     // Catch: Exception -> L53
            Context r114 = r100.f165989f;     // Catch: Exception -> L53
            Bundle r115 = new Bundle();     // Catch: Exception -> L53
            r115.putInt("request_page", 1);     // Catch: Exception -> L53
            r115.putString("scene", "screen_shot");     // Catch: Exception -> L53
            r115.putInt(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ITEM_TYPE, 2);     // Catch: Exception -> L53
            r115.putString("item_id", r100.d());     // Catch: Exception -> L53
            CommonMeta r116 = r100.f165990g.a();     // Catch: Exception -> L53
            if (r116 == null) goto L28;
            String r117 = r116.getScreenShotParams();     // Catch: Exception -> L53
        L29:
            r115.putString("before_share_extra", r117);     // Catch: Exception -> L53
            if (r112 == null) goto L32;
            String r118 = r112.a().toString();     // Catch: Exception -> L53
        L33:
            r115.putString("bcm_chain", r118);     // Catch: Exception -> L53
            CommonMeta r119 = r100.f165990g.a();     // Catch: Exception -> L53
            if (r119 == null) goto L41;
            String r120 = r119.getScreenShotParams();     // Catch: Exception -> L53
            if (r120 == null) goto L41;
            JSONObject r121 = z1.g(r120);     // Catch: Exception -> L53
            if (r121 == null) goto L41;
            String r122 = r121.optString("channel_id");     // Catch: Exception -> L53
        L42:
            r115.putString("channel_id", r122);     // Catch: Exception -> L53
            CommonMeta r123 = r100.f165990g.a();     // Catch: Exception -> L53
            if (r123 == null) goto L50;
            String r124 = r123.getScreenShotParams();     // Catch: Exception -> L53
            if (r124 == null) goto L50;
            JSONObject r125 = z1.g(r124);     // Catch: Exception -> L53
            if (r125 == null) goto L50;
            r105 = r125.optString(WsConstants.KEY_CHANNEL_TYPE);     // Catch: Exception -> L53
        L50:
            r115.putString(WsConstants.KEY_CHANNEL_TYPE, r105);     // Catch: Exception -> L53
            Unit r126 = Unit.INSTANCE;     // Catch: Exception -> L53
            r113.i(r114, r115, r111, new ScreenCaptureManager$handleBitmap$$inlined$let$lambda$1(r110, r100, r110));     // Catch: Exception -> L53
            return;
        L41:
            r122 = null;
            goto L42
        L32:
            r118 = null;
            goto L33
        L28:
            r117 = null;
        L21:
            r107 = null;
        L51:
            r100.i(r110);     // Catch: Exception -> L53
            return;
        L53:
            r100.i(r110);
            return;
        L59:
            return;
        }
    }

    static {
    }

    public final boolean a() {
        this.f165990g.d();
        CommonMeta r100 = this.f165990g.a();
        Boolean r101 = null;
        if (r100 == null) goto L5;
        Boolean r102 = Boolean.valueOf(r100.isScreenShotPaused());
    L7:
        if (this.f165992i.a() == true) goto L9;
        CommonMeta r103 = this.f165990g.a();
        if (r103 == null) goto L13;
        r101 = Boolean.valueOf(r103.isGalleryOpen());
    L13:
        boolean r104 = this.f165990g.c();
        Boolean r105 = Boolean.FALSE;
        if (Intrinsics.areEqual(r101, r105) == true) goto L16;
    L19:
        return false;
    L16:
        if (Intrinsics.areEqual(r102, r105) == false) goto L19;
        if (r104 == false) goto L19;
        return true;
    L9:
        return Intrinsics.areEqual(r102, Boolean.FALSE);
    L5:
        r102 = null;
        goto L7
    }

    public final Bundle b() {
        CommonMeta r100 = this.f165990g.a();
        if (r100 == null) goto L5;
        String r101 = r100.getScreenShotParams();
    L6:
        Bundle r102 = new Bundle();
        JSONObject r103 = z1.g(r101);
        if (r103 == null) goto L18;
        String r104 = r103.optString("product_id");
        String r105 = "";
        if (r104 != null) goto L11;
        r104 = "";
    L11:
        r102.putString("product_id", r104);
        String r106 = r103.optString(com.bytedance.android.ec.core.event.a.KEY_SHOP_ID);
        if (r106 == null) goto L15;
        r105 = r106;
    L15:
        r102.putString(com.bytedance.android.ec.core.event.a.KEY_SHOP_ID, r105);
        if (this.f165992i.a() == false) goto L18;
        r102.putString("is_from_pdp_gallery", "1");
    L18:
        return r102;
    L5:
        r101 = null;
        goto L6
    }

    public final String d() {
        CommonMeta r100 = this.f165990g.a();
        if (r100 == null) goto L5;
        String r101 = r100.getScreenShotParams();
    L6:
        JSONObject r102 = z1.g(r101);
        if (r102 == null) goto L12;
        String r103 = r102.optString("product_id");
        if (r103 != null) goto L11;
        return null;
    L11:
        return r103;
    L12:
        return null;
    L5:
        r101 = null;
        goto L6
    }

    public final void f() {
        boolean r100 = ECServiceManager.f42805a;
        if (((s83.g) ECServiceManager.c(s83.g.class)).B() == false) goto L10;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L6
        ((s83.g) ECServiceManager.c(s83.g.class)).o(this.f165987d);     // Catch: Throwable -> L6
        ((s83.g) ECServiceManager.c(s83.g.class)).o(this.f165988e);     // Catch: Throwable -> L6
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        Result.Companion r102 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return;
    L10:
        if (((Boolean) PdpAB.f166752f.getValue()).booleanValue() == false) goto L25;
        com.bytedance.android.shopping.anchorv4.helper.shot.d r103 = (com.bytedance.android.shopping.anchorv4.helper.shot.d) this.f165984a.getValue();
        if (r103 == null) goto L25;
        if (r103.a() == false) goto L25;
        ECScreenshotWatcher r104 = (ECScreenshotWatcher) r103.f166988b.getValue();
        r104.getClass();
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L23
        Context r106 = r104.f166979e.getApplicationContext();     // Catch: Throwable -> L23
        if (r106 == null) goto L21;
        ContentResolver r107 = r106.getContentResolver();     // Catch: Throwable -> L23
        if (r107 == null) goto L21;
        r107.unregisterContentObserver((com.bytedance.android.shopping.anchorv4.helper.shot.b) r104.f166976b.getValue());     // Catch: Throwable -> L23
        r107.unregisterContentObserver((com.bytedance.android.shopping.anchorv4.helper.shot.b) r104.f166977c.getValue());     // Catch: Throwable -> L23
    L21:
        r104.f166978d = -1;     // Catch: Throwable -> L23
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L25:
        com.bytedance.android.ec.core.utils.i0 r109 = com.bytedance.android.ec.core.utils.i0.f45612f;
        com.bytedance.android.ec.core.utils.i0.f45608b.remove(this.f165989f);
        Context r110 = this.f165989f;
        r109.getClass();
        com.bytedance.android.ec.core.utils.i0.b(r110);
    }

    public final void g() {
        boolean r100 = ECServiceManager.f42805a;
        if (((s83.g) ECServiceManager.c(s83.g.class)).B() == false) goto L10;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L6
        ((s83.g) ECServiceManager.c(s83.g.class)).i0(this.f165987d);     // Catch: Throwable -> L6
        ((s83.g) ECServiceManager.c(s83.g.class)).i0(this.f165988e);     // Catch: Throwable -> L6
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        Result.Companion r102 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return;
    L10:
        if (((Boolean) PdpAB.f166752f.getValue()).booleanValue() == false) goto L32;
        com.bytedance.android.shopping.anchorv4.helper.shot.d r103 = (com.bytedance.android.shopping.anchorv4.helper.shot.d) this.f165984a.getValue();
        if (r103 == null) goto L30;
        int r104 = Build.VERSION.SDK_INT;
        if (r104 < 34) goto L19;
        if (r103.f166987a != null) goto L19;
        r103.f166987a = new com.bytedance.android.shopping.anchorv4.helper.shot.c(r103.f166989c, r103.f166990d);
    L19:
        if (r103.a() == false) goto L30;
        ECScreenshotWatcher r105 = (ECScreenshotWatcher) r103.f166988b.getValue();
        r105.getClass();
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L27
        if (r104 <= 28) goto L24;
        boolean r107 = true;
    L25:
        r105.f166979e.getApplicationContext().getContentResolver().registerContentObserver(MediaStore.Images.Media.INTERNAL_CONTENT_URI, r107, (com.bytedance.android.shopping.anchorv4.helper.shot.b) r105.f166976b.getValue());     // Catch: Throwable -> L27
        r105.f166979e.getApplicationContext().getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, r107, (com.bytedance.android.shopping.anchorv4.helper.shot.b) r105.f166977c.getValue());     // Catch: Throwable -> L27
        r105.f166978d = System.currentTimeMillis();     // Catch: Throwable -> L27
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L27
        goto L30
    L24:
        r107 = false;
    L27:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L30:
        if (((com.bytedance.android.shopping.anchorv4.helper.shot.d) this.f165984a.getValue()) != null) goto L39;
        com.bytedance.android.ec.core.utils.i0 r109 = com.bytedance.android.ec.core.utils.i0.f45612f;
        com.bytedance.android.ec.core.utils.i0.f45608b.put(this.f165989f, this.f165985b);
        Context r110 = this.f165989f;
        r109.getClass();
        com.bytedance.android.ec.core.utils.i0.a(r110);
        return;
    L39:
        return;
    L32:
        com.bytedance.android.ec.core.utils.i0 r111 = com.bytedance.android.ec.core.utils.i0.f45612f;
        com.bytedance.android.ec.core.utils.i0.f45608b.put(this.f165989f, this.f165985b);
        Context r112 = this.f165989f;
        r111.getClass();
        com.bytedance.android.ec.core.utils.i0.a(r112);
    }

    public final Context getContext() {
        return this.f165989f;
    }

    public final String c(String r100) {
        CommonMeta r101 = this.f165990g.a();
        String r102 = null;
        if (r101 == null) goto L5;
        String r103 = r101.getScreenShotParams();
    L6:
        JSONObject r104 = new JSONObject();
        JSONObject r105 = z1.g(r103);
        if (r105 == null) goto L20;
        String r106 = r105.optString("product_id");
        String r107 = "";
        if (r106 != null) goto L11;
        r106 = "";
    L11:
        r104.put("product_id", r106);
        String r108 = r105.optString(com.bytedance.android.ec.core.event.a.KEY_SHOP_ID);
        if (r108 == null) goto L15;
        r107 = r108;
    L15:
        r104.put(com.bytedance.android.ec.core.event.a.KEY_SHOP_ID, r107);
        r104.put("is_ec_shopping", "1");
        r104.put(com.bytedance.android.ec.core.event.a.KEY_SHARE_TYPE, IHostShare.ShareType.SCREENSHOT);
        CommonMeta r109 = this.f165990g.a();
        if (r109 == null) goto L18;
        r102 = r109.getSourcePage();
    L18:
        r104.put("enter_from", r102);
        r104.put(BdpAppEventConstant.SHARE_ID, r100);
    L20:
        return r104.toString();
    L5:
        r103 = null;
        goto L6
    }

    public final void e(String r100) {
        boolean r101 = ECServiceManager.f42805a;
        if (((s83.g) ECServiceManager.c(s83.g.class)).isSearchScreenshotBubbleMobOpen() == false) goto L37;
        JSONObject r102 = new JSONObject();
        r102.put(com.bytedance.android.ec.core.event.a.KEY_EVENT_ORIGIN_FEATURE, com.bytedance.android.ec.core.event.a.VALUE_TEMAI);     // Catch: Exception -> L29
        r102.put("screenshot_source", CardProtocolType.COMMODITY);     // Catch: Exception -> L29
        r102.put("product_id", d());     // Catch: Exception -> L29
        r102.put("bubble_identifier_key", r100);     // Catch: Exception -> L29
        CommonMeta r103 = this.f165990g.a();     // Catch: Exception -> L29
        if (r103 == null) goto L8;
        String r104 = r103.getShopId();     // Catch: Exception -> L29
    L9:
        r102.put(com.bytedance.android.ec.core.event.a.KEY_SHOP_ID, r104);     // Catch: Exception -> L29
        CommonMeta r105 = this.f165990g.a();     // Catch: Exception -> L29
        if (r105 == null) goto L12;
        Boolean r106 = r105.getOnSale();     // Catch: Exception -> L29
    L14:
        if (Intrinsics.areEqual(r106, Boolean.TRUE) == false) goto L16;
        int r107 = 1;
    L17:
        r102.put("is_sale", r107);     // Catch: Exception -> L29
        if (this.f165992i.a() == false) goto L20;
        r102.put(com.bytedance.android.ec.core.event.a.KEY_FROM_ENTRANCE, "gallery");     // Catch: Exception -> L29
    L20:
        Boolean r108 = this.f165992i.b();     // Catch: Exception -> L29
        if (r108 != null) goto L23;
    L27:
        r102.put("timestamp", System.currentTimeMillis());     // Catch: Exception -> L29
    L31:
        int r109 = ECSdk.f48106a;
        pi.b r110 = (pi.b) ECSdk.a(pi.b.class);
        if (r110 == null) goto L38;
        r110.monitorEvent("screenshot_photo_search_bubble", r102, null, null);
        return;
    L38:
        return;
    L23:
        if (r108.booleanValue() == false) goto L25;
        String r111 = "video";
    L26:
        r102.put(com.bytedance.android.ec.core.event.a.KEY_MEDIA_TYPE, r111);     // Catch: Exception -> L29
        goto L27
    L25:
        r111 = "image";
        goto L26
    L16:
        r107 = 0;
        goto L17
    L12:
        r106 = null;
        goto L14
    L8:
        r104 = null;
    L29:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L31
    }

    public final void i(String r100) {
        boolean r101 = ECServiceManager.f42805a;
        s83.g r102 = (s83.g) ECServiceManager.c(s83.g.class);
        Context r103 = this.f165989f;
        if ((r103 instanceof FragmentActivity) == true) goto L5;
        r103 = null;
    L5:
        r102.h((FragmentActivity) r103, r100, "", "0");
    }

    public final void h(String r100, String r101, boolean r110) {
        String r102 = this.f165992i.c();
        if (r102 == null) goto L6;
        Uri.Builder r103 = UriProtector.parse(r102).buildUpon();
        JSONObject r104 = new JSONObject();
        r104.put("image_url", r100);
        r104.put(LocationMonitorConst.IDENTIFIER, AnchorV4DataManager.f166338d);
        boolean r105 = ECServiceManager.f42805a;
        ((IECHostService) ECServiceManager.c(IECHostService.class)).getIECSaveQrCodeService();
        r104.put("isWechatInstalled", null);
        r104.put("isOpt", r110);
        r104.put("ecParams", c(r101));
        Unit r106 = Unit.INSTANCE;
        Uri.Builder r107 = r103.appendQueryParameter("mega_object", r104.toString()).appendQueryParameter(AppConstants.TRANS_STATUS_BAR, "0").appendQueryParameter("click_lynx_time_stamp", String.valueOf(System.currentTimeMillis()));
        ECLiveHybridUtil.k(th.a.e(this.f165989f, true), com.bytedance.android.ec.core.btm.c.f(r107.build().toString(), this.f165991h, "a1.b8094.c86220.d87487"), false, false, false, null, 252);
        return;
    }

    public final boolean j(String r100, String r101, String r102) {
        int r103 = ECSdk.f48106a;
        IECHostService r104 = (IECHostService) ECSdk.a(IECHostService.class);
        if (r104 != null) goto L5;
    L7:
        String r105 = this.f165992i.d();
        if (r105 != null) goto L10;
    L35:
        return false;
    L10:
        if (StringsKt.isBlank(r105) == false) goto L37;
        return false;
    L37:
        Context r106 = this.f165989f;     // Catch: Exception -> L36
        Context r107 = null;
        if ((r106 instanceof FragmentActivity) == true) goto L15;
        r106 = null;
    L15:
        FragmentActivity r108 = (FragmentActivity) r106;     // Catch: Exception -> L36
        if (r108 == null) goto L22;
        FragmentManager r109 = r108.getSupportFragmentManager();     // Catch: Exception -> L36
        if (r109 == null) goto L22;
        if (r109.findFragmentByTag("ec_photo_search_dialog_container_fragment") == null) goto L22;
        return true;
    L22:
        Context r110 = this.f165989f;     // Catch: Exception -> L36
        if ((r110 instanceof FragmentActivity) == false) goto L26;
        r107 = r110;
    L26:
        FragmentActivity r111 = (FragmentActivity) r107;     // Catch: Exception -> L36
        if (r111 == null) goto L33;
        FragmentManager r112 = r111.getSupportFragmentManager();     // Catch: Exception -> L36
        if (r112 == null) goto L33;
        if (r112.findFragmentByTag("photo_search_share_dialog") == null) goto L33;
        return true;
    L33:
        JSONObject r113 = new JSONObject();     // Catch: Exception -> L36
        r113.put("ecom_share_track_params", c(r101));     // Catch: Exception -> L36
        r113.put("screen_shot_with_qr", r102);     // Catch: Exception -> L36
        com.bytedance.android.ec.sdk.helper.p.f48130a.openSchema(this.f165989f, com.bytedance.android.ec.core.utils.p0.g(r105, "client_params", r113.toString()) + "&shot_file_path=" + r100);     // Catch: Exception -> L36
        return true;
    L5:
        if (r104.getRecommendStatus() == true) goto L7;
        return false;
    }

    public ScreenCaptureManager(Context r100, com.bytedance.android.shopping.anchorv4.voavhs.headv2.q r101, PageFinder r102, n r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "captureDependency");
        Intrinsics.checkNotNullParameter(r102, "pageFinder");
        Intrinsics.checkNotNullParameter(r103, "callback");
        this.f165989f = r100;
        this.f165990g = r101;
        this.f165991h = r102;
        this.f165992i = r103;
        this.f165984a = LazyKt.lazy(new ScreenCaptureManager$screenShotWatcherCompact$2(this));
        this.f165985b = new ScreenCaptureManager$screenShotListener$1(this);
        this.f165986c = new d(this);
        this.f165987d = new b();
        this.f165988e = new c();
    }
}
