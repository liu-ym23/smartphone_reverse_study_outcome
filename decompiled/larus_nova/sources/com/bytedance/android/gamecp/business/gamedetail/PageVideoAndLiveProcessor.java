package com.bytedance.android.gamecp.business.gamedetail;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import bw.q;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.android.gamecp.common.track.GamecpTracker;
import com.bytedance.android.gamecp.common.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.gamecp.common.utils.p0;
import com.bytedance.android.gamecp.common.utils.y0;
import com.bytedance.android.livesdk.schema.AudienceGamePromoteDetailActionHandler;
import com.bytedance.bdlocation.exception.BDLocationException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import wu.h1;
import wu.v1;
import xr.r;
import xr.s;

/* JADX INFO: loaded from: classes44.dex */
public final class PageVideoAndLiveProcessor {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static boolean f53446p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static boolean f53447q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final a f53448r = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f53449a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f53450b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f53451c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f53452d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f53453e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final m f53454f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f53455g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final WeakReference<r> f53456h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final WeakReference<Object> f53457i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final DialogFragment f53458j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final FrameLayout f53459k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Bundle f53460l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f53461m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f53462n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f53463o;

    public static final class a {
        public a() {
        }

        public static HashMap a() {
            HashMap r100 = new HashMap();
            r100.put("position_type", "3");
            r100.put(MapBundleKey.OfflineMapKey.OFFLINE_RATION, "0.8");
            r100.put("horizontal_live_max_height", BDLocationException.ERROR_BPEA_WITHOUT_CERT);
            if (PageVideoAndLiveProcessor.f53447q == false) goto L10;
            int r101 = y0.f();
            int r102 = 325;
            if (r101 <= 0) goto L9;
            float r103 = y0.k(r101);
            if (r103 <= 0) goto L9;
            r102 = (int) ((325 / 812.0f) * r103);
        L9:
            r100.put(GXTemplateKey.FLEXBOX_MARGIN, String.valueOf(r102));
        L16:
            return r100;
        L10:
            int r104 = y0.f();
            int r105 = 253;
            if (r104 <= 0) goto L15;
            float r106 = y0.k(r104);
            if (r106 <= 0) goto L15;
            r105 = (int) ((253 / 812.0f) * r106);
        L15:
            r100.put(GXTemplateKey.FLEXBOX_MARGIN, String.valueOf(r105));
            goto L16
        }
    }

    public static final class b implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PageVideoAndLiveProcessor f53464a;

        public b(PageVideoAndLiveProcessor r100) {
            this.f53464a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            r r101 = this.f53464a.f53456h.get();
            if (r101 == null) goto L9;
            Object r102 = r100.getAnimatedValue();
            if (r102 == null) goto L8;
            ((Float) r102).floatValue();
            float r103 = this.f53464a.f53452d;
            r101.a();
            return;
        L8:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    static {
        f53448r = new a();
    }

    public final boolean b() {
        if (this.f53453e == true) goto L5;
    L11:
        return false;
    L5:
        if (this.f53462n == false) goto L11;
        if (h1.f561319a.getValue().booleanValue() == false) goto L11;
        if (d() == false) goto L11;
        return true;
    }

    public final boolean c() {
        if (this.f53461m == true) goto L5;
        return false;
    L5:
        if (this.f53453e == true) goto L7;
        return false;
    L7:
        if (v1.f561403a.getValue().booleanValue() == true) goto L9;
        return false;
    L9:
        if (this.f53456h.get() != null) goto L11;
        return false;
    L11:
        if (e() == false) goto L59;
        Bundle r100 = this.f53460l;
        String r101 = null;
        if (r100 == null) goto L17;
        String r102 = r100.getString("is_fullscreen");
        if (r102 == null) goto L17;
        String r103 = StringsKt.trim(r102).toString();
    L19:
        if (Intrinsics.areEqual(r103, "1") == true) goto L60;
        HashMap<String, String> r104 = GamecpTracker.f56755a;
        com.bytedance.android.gamecp.common.track.filter.d r105 = GamecpTracker.i(zu.e.class, this.f53459k);
        if ((r105 instanceof com.bytedance.android.gamecp.common.track.filter.e) == true) goto L23;
        r105 = null;
    L23:
        com.bytedance.android.gamecp.common.track.filter.e r106 = (com.bytedance.android.gamecp.common.track.filter.e) r105;
        if (e() == false) goto L49;
        if (r106 == null) goto L28;
        r101 = r106.b();
    L28:
        if (Intrinsics.areEqual("click_comment", r101) == false) goto L49;
        r106.getClass();
        Object r107 = "";
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L40
        Map<String, String> r109 = r106.f56801a;     // Catch: Throwable -> L40
        if (r109 == null) goto L34;
        String r110 = r109.get("traffic_extra");     // Catch: Throwable -> L40
        if (r110 == null) goto L34;
    L35:
        String r111 = new JSONObject(r110).optString("enter_sub_method");     // Catch: Throwable -> L40
        if (r111 != null) goto L38;
        r111 = "";
    L38:
        Object r112 = Result.m9449constructorimpl(r111);     // Catch: Throwable -> L40
    L43:
        if (Result.m9455isFailureimpl(r112) == true) goto L47;
        r107 = r112;
    L47:
        if (Intrinsics.areEqual("click_comment_top", (String) r107) == false) goto L49;
        boolean r113 = true;
    L50:
        if (r113 == true) goto L61;
        return true;
    L61:
        return false;
    L34:
        r110 = SliceInitService.DEFAULT_SWITCH;
    L40:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L49:
        r113 = false;
        goto L50
    L60:
        return false;
    L17:
        r103 = null;
        goto L19
    L59:
        return false;
    }

    public final boolean d() {
        Bundle r100 = this.f53460l;
        if (r100 == null) goto L7;
        String r101 = r100.getString(AudienceGamePromoteDetailActionHandler.PARA_PROMOTER_SCENE);
        if (r101 == null) goto L7;
        String r102 = StringsKt.trim(r101).toString();
    L9:
        if (TextUtils.isEmpty(r102) == false) goto L13;
        return true;
    L13:
        return Intrinsics.areEqual(r102, String.valueOf(0));
    L7:
        r102 = null;
        goto L9
    }

    public final boolean e() {
        Bundle r100 = this.f53460l;
        if (r100 == null) goto L7;
        String r101 = r100.getString(AudienceGamePromoteDetailActionHandler.PARA_PROMOTER_SCENE);
        if (r101 == null) goto L7;
        String r102 = StringsKt.trim(r101).toString();
    L9:
        return Intrinsics.areEqual(r102, String.valueOf(1));
    L7:
        r102 = null;
        goto L9
    }

    public final void h() {
        if (this.f53453e == true) goto L5;
        return;
    L5:
        if (this.f53451c == false) goto L7;
        return;
    L7:
        if (e() == false) goto L12;
        q r100 = com.bytedance.android.gamecp.host_api.a.b().getHostVideoPlayerService();
        this.f53457i.get();
        r100.g();
        return;
    }

    public final void i() {
        if (this.f53453e == true) goto L5;
        return;
    L5:
        if (e() == false) goto L9;
        q r100 = com.bytedance.android.gamecp.host_api.a.b().getHostVideoPlayerService();
        this.f53457i.get();
        r100.S0();
        return;
    }

    public final void j() {
        if (this.f53451c == false) goto L5;
        return;
    L5:
        if (b() == true) goto L7;
        return;
    L7:
        if (f53446p == false) goto L9;
        f();
        return;
    L9:
        FrameLayout r100 = this.f53459k;
        if (r100 == null) goto L18;
        dw.g r101 = com.bytedance.android.gamecp.host_api.a.b().getLiveService().getLiveFloatViewService();
        if (r101 == null) goto L19;
        DialogFragment r102 = this.f53458j;
        boolean r103 = !this.f53463o;
        boolean r104 = this.f53455g;
        f53448r.getClass();
        r101.a(r102, r100, r103, r104, a.a());
        return;
    L19:
        return;
    }

    public final void k() {
        if (this.f53449a == false) goto L6;
        return;
    L6:
        if (c() == true) goto L8;
        return;
    L8:
        this.f53449a = true;
        ValueAnimator r100 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        r100.setInterpolator(new AccelerateDecelerateInterpolator());
        r100.setDuration(300);
        r100.addUpdateListener(new b(this));
        r100.start();
    }

    public static void f() {
        if (com.bytedance.android.gamecp.host_api.a.b().getLiveService().isLivePlayerClientMute() == true) goto L6;
        com.bytedance.android.gamecp.host_api.a.b().getLiveService().muteLivePlayerClient();
        return;
    }

    public final void a() {
        if (b() == false) goto L17;
        dw.g r100 = com.bytedance.android.gamecp.host_api.a.b().getLiveService().getLiveFloatViewService();
        if (r100 == null) goto L12;
        if (r100.isFloatViewShowing() != true) goto L12;
        dw.g r101 = com.bytedance.android.gamecp.host_api.a.b().getLiveService().getLiveFloatViewService();
        if (r101 == null) goto L12;
        r101.stopFloatView();
    L12:
        if (this.f53463o == true) goto L14;
        return;
    L14:
        if (com.bytedance.android.gamecp.host_api.a.b().getLiveService().isLivePlayerClientMute() == false) goto L19;
        com.bytedance.android.gamecp.host_api.a.b().getLiveService().unMuteLivePlayerClient();
        return;
    L19:
        return;
    }

    public final void g(boolean r100) {
        if (this.f53450b == false) goto L6;
    L9:
        if (r100 == true) goto L11;
    L16:
        l(true);
        return;
    L11:
        if (b() == true) goto L13;
    L15:
        UtilityKotlinExtentionsKt.g(800, false, true, new PageVideoAndLiveProcessor$onResume$1(this), 2);
        goto L16
    L13:
        if (this.f53455g == false) goto L15;
        f();
        goto L15
    L6:
        if (c() == false) goto L9;
        this.f53450b = true;
        ValueAnimator r101 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r101.setInterpolator(new AccelerateDecelerateInterpolator());
        r101.setDuration(300);
        r101.addUpdateListener(new n(this));
        r101.start();
        goto L9
    }

    public final void l(boolean r100) {
        if (e() == false) goto L8;
        FragmentActivity r101 = this.f53458j.getActivity();
        if (r101 == null) goto L9;
        com.bytedance.android.gamecp.host_api.a.b().getHostVideoPlayerService().V(r101);
        return;
    L9:
        return;
    }

    public PageVideoAndLiveProcessor(DialogFragment r100, FrameLayout r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "page");
        this.f53458j = r100;
        this.f53459k = r101;
        this.f53460l = r102;
        this.f53461m = true;
        this.f53462n = true;
        this.f53463o = true;
        this.f53452d = k.a();
        this.f53453e = true ^ p0.a();
        this.f53454f = new m(this);
        f53446p = false;
        f53447q = false;
        xr.f r103 = (xr.f) s.a(xr.f.class);
        Object r104 = null;
        if (r103 == null) goto L7;
        xr.k r105 = r103.z0();
        if (r105 == null) goto L7;
        r r106 = r105.getGameDetailPageHeightChangeListener();
    L8:
        this.f53456h = new WeakReference(r106);
        xr.f r107 = (xr.f) s.a(xr.f.class);
        if (r107 == null) goto L13;
        xr.k r108 = r107.z0();
        if (r108 == null) goto L13;
        r104 = r108.getVideoItemParams();
    L13:
        this.f53457i = new WeakReference(r104);
        return;
    L7:
        r106 = null;
        goto L8
    }
}
