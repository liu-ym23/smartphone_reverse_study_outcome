package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.lynx;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.hybrid.utils.j;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.d2;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.livesdk.chatroom.VideoPlayDataContext;
import com.bytedance.android.shopping.anchorv4.dto.ConfigModel;
import com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.LynxElementVO;
import com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.PendantContainerVO;
import com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.PendantGravity;
import com.bytedance.android.shopping.prepurchase.business.pdp.view.i;
import com.bytedance.android.shopping.utils.LargeFontModeUtil;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.lynx.tasm.LynxView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import ti.k;
import ti.l;

/* JADX INFO: loaded from: classes13.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PendantContainerVO f181479a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c> f181480b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f181481c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f181482d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f181483e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final FrameLayout f181484f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.lynx.b f181485g;

    public static final class a {
    }

    public static final class b implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LynxElementVO f181486a;

        @Override // ti.k
        public final void b() {
            Intrinsics.checkNotNullParameter("", "errorMessage");
            Intrinsics.checkNotNullParameter("", "errorMessage");
        }

        public b(LynxElementVO r100) {
            this.f181486a = r100;
        }

        @Override // ti.k
        public final void onFirstScreen(View r100) {
            Intrinsics.checkNotNullParameter(r100, "lynxView");
            Intrinsics.checkNotNullParameter(r100, "lynxView");
        }

        @Override // ti.k
        public final void onLoadSuccess(View r100) {
            Intrinsics.checkNotNullParameter(r100, "lynxView");
            Intrinsics.checkNotNullParameter(r100, "lynxView");
            ConfigModel r101 = this.f181486a.getConfig();
            if (r101 != null) goto L5;
            return;
        L5:
            if (r101.getFontScale() == true) goto L7;
            return;
        L7:
            if (this.f181486a.getConfig().getFontScaleMaxRatio() != null) goto L9;
        L11:
            LargeFontModeUtil.a();
        L13:
            if ((r100 instanceof LynxView) == true) goto L15;
            r100 = null;
        L15:
            LynxView r102 = (LynxView) r100;
            return;
        L9:
            if (LargeFontModeUtil.a() <= 1) goto L11;
            this.f181486a.getConfig().getFontScaleMaxRatio().floatValue();
            goto L13
        }

        @Override // ti.k
        public final void onRuntimeReady(View r100) {
            Intrinsics.checkNotNullParameter(r100, "lynxView");
            Intrinsics.checkNotNullParameter(r100, "lynxView");
        }

        @Override // ti.k
        public final void g(View r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "view");
            Intrinsics.checkNotNullParameter(r100, "view");
        }

        @Override // ti.k
        public final void onLoadFailed(View r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "lynxView");
            Intrinsics.checkNotNullParameter(r100, "lynxView");
        }

        @Override // ti.k
        public final void onPageStart(View r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "lynxView");
            Intrinsics.checkNotNullParameter(r100, "lynxView");
        }

        @Override // ti.k
        public final void s(View r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "view");
            Intrinsics.checkNotNullParameter(r100, "view");
        }
    }

    static {
    }

    public final void e() {
        if (this.f181479a != null) goto L5;
        return;
    L5:
        e r100 = this.f181485g.b();
        if (r100.f181489a <= 0) goto L8;
    L57:
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L51
        Iterator<Map.Entry<String, com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c>> r102 = this.f181480b.entrySet().iterator();     // Catch: Throwable -> L51
    L16:
        if (r102.hasNext() == false) goto L49;
        Map.Entry<String, com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c> r103 = r102.next();     // Catch: Throwable -> L51
        com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c r104 = r103.getValue();     // Catch: Throwable -> L51
        PendantGravity r105 = null;
        if (r104 == null) goto L22;
        View r106 = r104.f166766a;     // Catch: Throwable -> L51
        if (r106 == null) goto L22;
        ViewGroup.LayoutParams r107 = r106.getLayoutParams();     // Catch: Throwable -> L51
    L24:
        if ((r107 instanceof FrameLayout.LayoutParams) == true) goto L26;
        r107 = null;
    L26:
        FrameLayout.LayoutParams r108 = (FrameLayout.LayoutParams) r107;     // Catch: Throwable -> L51
        if (r108 == null) goto L16;
        com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c r109 = r103.getValue();     // Catch: Throwable -> L51
        if (r109 == null) goto L31;
        LynxElementVO r110 = r109.f166771f;     // Catch: Throwable -> L51
    L32:
        if (r110 == null) goto L34;
        r105 = r110.getGravity();     // Catch: Throwable -> L51
    L34:
        if (r105 == null) goto L16;
        int r111 = d.f181488b[r105.ordinal()];     // Catch: Throwable -> L51
        if (r111 != 1) goto L39;
        int r112 = r110.getUseBottomMargin();     // Catch: Throwable -> L51
        int r113 = r110.getUseLeftMargin();     // Catch: Throwable -> L51
        r108.bottomMargin = r100.f181492d + r112;     // Catch: Throwable -> L51
        r108.gravity = 8388691;     // Catch: Throwable -> L51
        r108.leftMargin = r100.f181489a + r113;     // Catch: Throwable -> L51
        goto L16
    L39:
        if (r111 != 2) goto L41;
        int r114 = r110.getUseTopMargin() + r100.f181490b;     // Catch: Throwable -> L51
        int r115 = r110.getUseRightMargin() + r100.f181491c;     // Catch: Throwable -> L51
        r108.topMargin = r114;     // Catch: Throwable -> L51
        r108.gravity = 8388661;     // Catch: Throwable -> L51
        r108.rightMargin = r115;     // Catch: Throwable -> L51
        goto L16
    L41:
        if (r111 != 3) goto L43;
        r108.bottomMargin = r100.f181492d + r110.getUseBottomMargin();     // Catch: Throwable -> L51
        r108.rightMargin = r100.f181491c + r110.getUseRightMargin();     // Catch: Throwable -> L51
        r108.gravity = VideoPlayDataContext.PLAYING_GRAVITY;     // Catch: Throwable -> L51
        goto L16
    L43:
        if (r111 != 4) goto L16;
        r108.topMargin = r110.getUseTopMargin() + r100.f181490b;     // Catch: Throwable -> L51
        r108.leftMargin = r110.getUseLeftMargin() + r100.f181489a;     // Catch: Throwable -> L51
        r108.gravity = 8388659;     // Catch: Throwable -> L51
        goto L16
    L31:
        r110 = null;
    L22:
        r107 = null;
        goto L24
    L49:
        Object r116 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L51
    L53:
        Throwable r117 = Result.m9452exceptionOrNullimpl(r116);
        if (r117 == null) goto L79;
        ECExceptionMonitor.e(r117);
        return;
    L79:
        return;
    L51:
        th = move-exception;
        Result.Companion r118 = Result.Companion;
        r116 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L53
    L8:
        if (r100.f181490b > 0) goto L57;
        if (r100.f181491c > 0) goto L57;
        if (r100.f181492d > 0) goto L57;
    }

    public final void b(LynxElementVO r110) {
        if (r110 == null) goto L71;
        String r100 = r110.getSchema();
        if (r100 != null) goto L6;
        return;
    L6:
        if (a2.b(r100) == true) goto L9;
        r100 = null;
    L9:
        if (r100 == null) goto L73;
        com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c r101 = this.f181480b.get(r100);
        if (r101 == null) goto L24;
        FrameLayout r102 = this.f181484f;
        View r103 = r101.f166766a;
        if (r102 == null) goto L16;
        if (r103 == null) goto L16;
        f(r102, r103, d(this, r110.getWidth()), d(this, r110.getHeight()));
        a(r110, r103);
    L16:
        r101.f166771f = r110;
        if (r110.getQueryData() != null) goto L19;
        return;
    L19:
        l r104 = r101.f166767b;
        if (r104 == null) goto L22;
        r104.updateData(r110.getQueryData());
        Unit r105 = Unit.INSTANCE;
    L23:
        if (r105 == null) goto L24;
        return;
    L22:
        r105 = null;
    L24:
        Uri.Builder r106 = UriProtector.parse(r100).buildUpon();
        Map<String, Object> r107 = r110.getQueryData();
        if (r107 == null) goto L30;
        Iterator<Map.Entry<String, Object>> r108 = r107.entrySet().iterator();
    L28:
        if (r108.hasNext() == false) goto L30;
        Map.Entry<String, Object> r109 = r108.next();
        r106.appendQueryParameter(r109.getKey(), String.valueOf(r109.getValue()));
    L30:
        r106.appendQueryParameter(LocationMonitorConst.IDENTIFIER, this.f181483e);
        r106.appendQueryParameter("send_visible_event", "1");
        JSONObject r111 = z1.g(r110.getMegaData());
        if (r111 == null) goto L47;
        Map<String, Object> r112 = r110.getLocation();
        if (r112 == null) goto L35;
        Object r113 = r112.get("anchor_parent_view_key");
    L37:
        if ((r113 instanceof String) == true) goto L39;
        r113 = null;
    L39:
        String r114 = (String) r113;
        Map<String, Object> r115 = r110.getLocation();
        if (r115 == null) goto L42;
        Object r116 = r115.get("anchor_view_key");
    L44:
        if ((r116 instanceof String) == true) goto L46;
        r116 = null;
    L46:
        KtSafeMethodExtensionKt.safePut(r111, "config", c(r114, (String) r116));
        goto L47
    L42:
        r116 = null;
        goto L44
    L35:
        r113 = null;
    L47:
        String r117 = UUID.randomUUID().toString();
        HashMap<String, JSONObject> r118 = j.f44312a;
        j.h(r117, r111);
        r106.appendQueryParameter("mega_object_id", r117);
        l r119 = this.f181485g.a(this.f181484f.getContext(), r106.build().toString(), new b(r110));
        if (r119 == null) goto L75;
        ConcurrentHashMap<String, com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c> r120 = this.f181480b;
        View r121 = r119.getHybridView();
        if (r121 == null) goto L67;
        f(this.f181484f, r121, d(this, r110.getWidth()), d(this, r110.getHeight()));
        a(r110, r121);
        PendantGravity r122 = r110.getGravity();
        if (r122 == null) goto L66;
        int r123 = d.f181487a[r122.ordinal()];
        if (r123 != 1) goto L56;
        d2.a(r121, r110.getUseBottomMargin());
        d2.c(r121, r110.getUseLeftMargin());
        d2.b(r121, 8388691);
        goto L66
    L56:
        if (r123 != 2) goto L58;
        d2.f(r121, r110.getUseTopMargin());
        d2.e(r121, r110.getUseRightMargin());
        d2.b(r121, 8388661);
        goto L66
    L58:
        if (r123 != 3) goto L60;
        d2.a(r121, r110.getUseBottomMargin());
        d2.e(r121, r110.getUseRightMargin());
        d2.b(r121, VideoPlayDataContext.PLAYING_GRAVITY);
        goto L66
    L60:
        if (r123 != 4) goto L66;
        d2.f(r121, r110.getUseTopMargin());
        d2.c(r121, r110.getUseLeftMargin());
        d2.b(r121, 8388659);
    L66:
        Unit r124 = Unit.INSTANCE;
        View r125 = r121;
    L68:
        r120.put(r100, new com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c(r125, r119, r110.getLynxId(), r110.getState(), r110));
        Unit r126 = Unit.INSTANCE;
        return;
    L67:
        r125 = null;
        goto L68
    L75:
        return;
    L73:
        return;
    }

    public static int d(c r100, com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.a r101) {
        r100.getClass();
        if (r101 == null) goto L5;
        Integer r102 = r101.getType();
    L6:
        if (r102 != null) goto L9;
    L15:
        if (r102 != null) goto L18;
    L20:
        if (r102 != null) goto L23;
    L25:
        if (r102 != null) goto L28;
    L30:
        return -2;
    L28:
        if (r102.intValue() != 3) goto L30;
        return -1;
    L23:
        if (r102.intValue() != 2) goto L25;
    L18:
        if (r102.intValue() != 1) goto L20;
    L9:
        if (r102.intValue() != 0) goto L15;
        Integer r103 = r101.f166765b;
        if (r103 == null) goto L13;
        int r104 = r103.intValue();
    L32:
        return com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r104));
    L13:
        r104 = 0;
        goto L32
    L5:
        r102 = null;
        goto L6
    }

    public final void a(LynxElementVO r100, View r101) {
        if (ECSettingKeys.z0() == false) goto L14;
        Map<String, Object> r102 = r100.getLocation();
        if (r102 == null) goto L7;
        Object r103 = r102.get("anchor_parent_view_key");
    L9:
        if (Intrinsics.areEqual(r103, "bottom_nav_slice") == false) goto L11;
        float r104 = this.f181481c;
    L12:
        r101.setTranslationY(r104);
        return;
    L11:
        r104 = 0.0f;
        goto L12
    L7:
        r103 = null;
        goto L9
    }

    public final JSONObject c(String r100, String r110) {
        JSONObject r101 = new JSONObject();
        if (r100 == null) goto L33;
        if (r110 == null) goto L33;
        int r102 = r100.hashCode();
        if (r102 == 989642338) goto L14;
        if (r102 == 1362196748) goto L11;
    L16:
        i r103 = null;
    L18:
        if (r103 == null) goto L21;
        int[] r104 = r103.getLocationOnScreen();
        if (r104 == null) goto L21;
    L22:
        ArrayList r105 = new ArrayList(r104.length);
        int r106 = r104.length;
        int r107 = 0;
        int r108 = 0;
    L23:
        if (r108 >= r106) goto L25;
        r105.add(Integer.valueOf(UIUtils.px2dip(this.f181484f.getContext(), r104[r108])));
        r108 = r108 + 1;
        goto L23
    L25:
        KtSafeMethodExtensionKt.safePut(r101, "anchor_view_location", CollectionsKt.toList(r105).toString());
        int[] r111 = new int[2];
        Context r109 = this.f181484f.getContext();
        if (r103 == null) goto L28;
        int r112 = r103.getWidth();
    L29:
        r111[0] = UIUtils.px2dip(r109, r112);
        Context r113 = this.f181484f.getContext();
        if (r103 == null) goto L32;
        r107 = r103.getHeight();
    L32:
        r111[1] = UIUtils.px2dip(r113, r107);
        KtSafeMethodExtensionKt.safePut(r101, "anchor_view_size", ArraysKt.toList(r111).toString());
        goto L33
    L28:
        r112 = 0;
    L21:
        r104 = new int[]{0, 0};
        goto L22
    L11:
        if (r100.equals("top_nav_slice") == false) goto L16;
        r103 = this.f181485g.e(r110);
        goto L18
    L14:
        if (r100.equals("bottom_nav_slice") == false) goto L16;
        r103 = this.f181485g.c(r110);
    L33:
        return r101;
    }

    public final void g(int r100, int r101) {
        if (this.f181479a != null) goto L21;
        return;
    L21:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L15
        Iterator<Map.Entry<String, com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c>> r103 = this.f181480b.entrySet().iterator();     // Catch: Throwable -> L15
    L7:
        if (r103.hasNext() == false) goto L13;
        com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c r104 = r103.next().getValue();     // Catch: Throwable -> L15
        if (r104 == null) goto L7;
        l r105 = r104.f166767b;     // Catch: Throwable -> L15
        if (r105 == null) goto L7;
        JSONObject r106 = new JSONObject();     // Catch: Throwable -> L15
        KtSafeMethodExtensionKt.safePut(r106, LocationMonitorConst.IDENTIFIER, this.f181483e);     // Catch: Throwable -> L15
        KtSafeMethodExtensionKt.safePut(r106, "width", Integer.valueOf(com.bytedance.android.shopping.extensions.b.e(Integer.valueOf(r100))));     // Catch: Throwable -> L15
        KtSafeMethodExtensionKt.safePut(r106, "height", Integer.valueOf(com.bytedance.android.shopping.extensions.b.e(Integer.valueOf(r101))));     // Catch: Throwable -> L15
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L15
        r105.sendJsEvent("pdp_screen_size_change", r106);     // Catch: Throwable -> L15
        goto L7
    L13:
        Object r108 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L15
    L17:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);
        if (r109 == null) goto L30;
        ECExceptionMonitor.e(r109);
        return;
    L30:
        return;
    L15:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L17
    }

    public c(String r100, FrameLayout r101, LynxPendentComponent.a r102) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        Intrinsics.checkNotNullParameter(r101, "pendentContainer");
        Intrinsics.checkNotNullParameter(r102, "dependency");
        this.f181483e = r100;
        this.f181484f = r101;
        this.f181485g = r102;
        this.f181480b = new ConcurrentHashMap();
    }

    public static void f(ViewGroup r100, View r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        if (r101.getParent() == null) goto L9;
        ViewParent r104 = r101.getParent();
        if (r104 == null) goto L8;
        ((ViewGroup) r104).removeView(r101);
        goto L9
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L9:
        ViewGroup.LayoutParams r105 = r101.getLayoutParams();
        if (r105 != null) goto L12;
        r105 = new ViewGroup.LayoutParams(-2, -2);
    L12:
        r105.width = r102;
        r105.height = r103;
        Unit r106 = Unit.INSTANCE;
        r101.setLayoutParams(r105);
        r100.addView(r101);
    }
}
