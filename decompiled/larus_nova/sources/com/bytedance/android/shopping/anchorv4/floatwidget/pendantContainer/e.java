package com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.hybrid.utils.j;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.d2;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ecom.arch.slice.SlcContext;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.livesdk.chatroom.VideoPlayDataContext;
import com.bytedance.android.shopping.anchorv4.dto.ConfigModel;
import com.bytedance.android.shopping.anchorv4.helper.w;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.p;
import com.bytedance.android.shopping.utils.LargeFontModeUtil;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.lynx.tasm.LynxView;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.DataLoaderHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
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

/* JADX INFO: loaded from: classes12.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c> f166773a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f166774b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PendantContainerVO f166775c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FrameLayout f166776d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public w73.a f166777e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Context f166778f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ViewGroup f166779g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ViewGroup f166780h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ViewGroup f166781i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ViewGroup f166782j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f166783k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final SlcContext f166784l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final p f166785m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f166786n;

    public static final class a implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f166787a;

        public a(e r100) {
            this.f166787a = r100;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
            this.f166787a.e();
        }
    }

    public static final class b {
    }

    public static final class c implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LynxElementVO f166788a;

        @Override // ti.k
        public final void b() {
            Intrinsics.checkNotNullParameter("", "errorMessage");
            Intrinsics.checkNotNullParameter("", "errorMessage");
        }

        public c(LynxElementVO r100) {
            this.f166788a = r100;
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
            ConfigModel r101 = this.f166788a.getConfig();
            if (r101 != null) goto L5;
            return;
        L5:
            if (r101.getFontScale() == true) goto L7;
            return;
        L7:
            if (this.f166788a.getConfig().getFontScaleMaxRatio() != null) goto L9;
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
            this.f166788a.getConfig().getFontScaleMaxRatio().floatValue();
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
        if (this.f166775c != null) goto L5;
        return;
    L5:
        ViewGroup r100 = this.f166780h;
        if (r100 != null) goto L8;
        return;
    L8:
        if (r100.getHeight() <= 0) goto L10;
        boolean r101 = true;
    L12:
        if (r101 == true) goto L15;
        r100 = null;
    L15:
        if (r100 == null) goto L85;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L55
        Iterator<Map.Entry<String, com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c>> r103 = this.f166773a.entrySet().iterator();     // Catch: Throwable -> L55
    L19:
        if (r103.hasNext() == false) goto L53;
        Map.Entry<String, com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c> r104 = r103.next();     // Catch: Throwable -> L55
        com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c r105 = r104.getValue();     // Catch: Throwable -> L55
        if (r105 == null) goto L25;
        View r106 = r105.f166766a;     // Catch: Throwable -> L55
        if (r106 == null) goto L25;
        ViewGroup.LayoutParams r107 = r106.getLayoutParams();     // Catch: Throwable -> L55
    L27:
        if ((r107 instanceof FrameLayout.LayoutParams) == true) goto L29;
        r107 = null;
    L29:
        FrameLayout.LayoutParams r108 = (FrameLayout.LayoutParams) r107;     // Catch: Throwable -> L55
        if (r108 == null) goto L19;
        com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c r109 = r104.getValue();     // Catch: Throwable -> L55
        if (r109 == null) goto L34;
        LynxElementVO r110 = r109.f166771f;     // Catch: Throwable -> L55
    L35:
        if (r110 == null) goto L37;
        PendantGravity r111 = r110.getGravity();     // Catch: Throwable -> L55
    L38:
        if (r111 == null) goto L19;
        int r112 = f.f166790b[r111.ordinal()];     // Catch: Throwable -> L55
        if (r112 != 1) goto L43;
        int r113 = r110.getUseBottomMargin();     // Catch: Throwable -> L55
        int r114 = r110.getUseLeftMargin();     // Catch: Throwable -> L55
        r108.bottomMargin = this.f166780h.getHeight() + r113;     // Catch: Throwable -> L55
        r108.gravity = 8388691;     // Catch: Throwable -> L55
        r108.leftMargin = r114;     // Catch: Throwable -> L55
        goto L19
    L43:
        if (r112 != 2) goto L45;
        int r115 = r110.getUseTopMargin();     // Catch: Throwable -> L55
        int r116 = r110.getUseRightMargin();     // Catch: Throwable -> L55
        r108.topMargin = r115;     // Catch: Throwable -> L55
        r108.gravity = 8388661;     // Catch: Throwable -> L55
        r108.rightMargin = r116;     // Catch: Throwable -> L55
        goto L19
    L45:
        if (r112 != 3) goto L47;
        r108.bottomMargin = this.f166780h.getHeight() + r110.getUseBottomMargin();     // Catch: Throwable -> L55
        r108.rightMargin = r110.getUseRightMargin();     // Catch: Throwable -> L55
        r108.gravity = VideoPlayDataContext.PLAYING_GRAVITY;     // Catch: Throwable -> L55
        goto L19
    L47:
        if (r112 != 4) goto L19;
        r108.topMargin = r110.getUseTopMargin();     // Catch: Throwable -> L55
        r108.leftMargin = r110.getUseLeftMargin();     // Catch: Throwable -> L55
        r108.gravity = 8388659;     // Catch: Throwable -> L55
        goto L19
    L37:
        r111 = null;
        goto L38
    L34:
        r110 = null;
    L25:
        r107 = null;
        goto L27
    L53:
        Object r117 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L55
    L57:
        Throwable r118 = Result.m9452exceptionOrNullimpl(r117);
        if (r118 == null) goto L84;
        ECExceptionMonitor.e(r118);
        return;
    L84:
        return;
    L55:
        th = move-exception;
        Result.Companion r119 = Result.Companion;
        r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L57
    L85:
        return;
    L10:
        r101 = false;
        goto L12
    }

    public final void f() {
        Iterator<Map.Entry<String, com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c>> r100 = this.f166773a.entrySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L10;
        com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c r101 = r100.next().getValue();
        if (r101 == null) goto L4;
        l r102 = r101.f166767b;
        if (r102 == null) goto L4;
        r102.release();
        goto L4
    L10:
        this.f166773a.clear();
        FrameLayout r103 = this.f166776d;
        if (r103 == null) goto L13;
        r103.removeAllViews();
    L13:
        this.f166776d = null;
    }

    public final void a(PendantContainerVO r100) {
        if (this.f166776d != null) goto L54;
        FrameLayout r101 = new FrameLayout(this.f166778f);
        ViewGroup r102 = this.f166779g;
        if (r102 == null) goto L7;
        g(r102, r101, -1, -1);
    L7:
        Unit r103 = Unit.INSTANCE;
        this.f166776d = r101;
        w73.a r104 = this.f166777e;
        if (r104 == null) goto L54;
        int r105 = r104.f558497c;
        if (r105 <= 0) goto L54;
        int r106 = r105 + j56.a.b(this.f166778f);
        FrameLayout r107 = this.f166776d;
        if (r107 == null) goto L54;
        d2.a(r107, r106);
    L54:
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L48
        if (r100 != null) goto L17;
        return;
    L17:
        PendantContainerVO r109 = this.f166775c;     // Catch: Throwable -> L48
        if (r109 == null) goto L21;
        PendantContainerVO r110 = r109.merge(r100);     // Catch: Throwable -> L48
        if (r110 == null) goto L21;
    L22:
        this.f166775c = r110;     // Catch: Throwable -> L48
        List<LynxElementVO> r111 = r100.getLeftBottom();     // Catch: Throwable -> L48
        if (r111 == null) goto L28;
        Iterator<T> r112 = r111.iterator();     // Catch: Throwable -> L48
    L26:
        if (r112.hasNext() == false) goto L28;
        b((LynxElementVO) r112.next());     // Catch: Throwable -> L48
    L28:
        List<LynxElementVO> r113 = r100.getTopRight();     // Catch: Throwable -> L48
        if (r113 == null) goto L34;
        Iterator<T> r114 = r113.iterator();     // Catch: Throwable -> L48
    L32:
        if (r114.hasNext() == false) goto L34;
        b((LynxElementVO) r114.next());     // Catch: Throwable -> L48
    L34:
        List<LynxElementVO> r115 = r100.getTopLeft();     // Catch: Throwable -> L48
        if (r115 == null) goto L40;
        Iterator<T> r116 = r115.iterator();     // Catch: Throwable -> L48
    L38:
        if (r116.hasNext() == false) goto L40;
        b((LynxElementVO) r116.next());     // Catch: Throwable -> L48
    L40:
        List<LynxElementVO> r117 = r100.getRightBottom();     // Catch: Throwable -> L48
        if (r117 == null) goto L46;
        Iterator<T> r118 = r117.iterator();     // Catch: Throwable -> L48
    L44:
        if (r118.hasNext() == false) goto L46;
        b((LynxElementVO) r118.next());     // Catch: Throwable -> L48
    L46:
        e();     // Catch: Throwable -> L48
        Object r119 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L48
    L50:
        Throwable r120 = Result.m9452exceptionOrNullimpl(r119);
        if (r120 == null) goto L60;
        ECExceptionMonitor.e(r120);
        return;
    L60:
        return;
    L21:
        r110 = r100;
    L48:
        th = move-exception;
        Result.Companion r121 = Result.Companion;
        r119 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L50
    }

    public final void b(LynxElementVO r210) {
        if (r210 == null) goto L79;
        String r100 = r210.getSchema();
        if (r100 != null) goto L7;
        return;
    L7:
        if (a2.b(r100) == false) goto L9;
        String r101 = r100;
    L10:
        if (r101 == null) goto L81;
        com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c r102 = this.f166773a.get(r101);
        if (r102 == null) goto L25;
        FrameLayout r103 = this.f166776d;
        View r104 = r102.f166766a;
        if (r103 == null) goto L18;
        if (r104 == null) goto L18;
        g(r103, r104, d(this, r210.getWidth()), d(this, r210.getHeight()));
    L18:
        if (r210.getQueryData() != null) goto L20;
        return;
    L20:
        l r105 = r102.f166767b;
        if (r105 == null) goto L23;
        r105.updateData(r210.getQueryData());
        Unit r106 = Unit.INSTANCE;
    L24:
        if (r106 == null) goto L25;
        return;
    L23:
        r106 = null;
    L25:
        Uri.Builder r107 = UriProtector.parse(r101).buildUpon();
        Map<String, Object> r108 = r210.getQueryData();
        if (r108 == null) goto L31;
        Iterator<Map.Entry<String, Object>> r109 = r108.entrySet().iterator();
    L29:
        if (r109.hasNext() == false) goto L31;
        Map.Entry<String, Object> r110 = r109.next();
        r107.appendQueryParameter(r110.getKey(), String.valueOf(r110.getValue()));
    L31:
        r107.appendQueryParameter(LocationMonitorConst.IDENTIFIER, this.f166783k);
        r107.appendQueryParameter("send_visible_event", "1");
        JSONObject r111 = z1.g(r210.getMegaData());
        if (r111 == null) goto L48;
        Map<String, Object> r112 = r210.getLocation();
        if (r112 == null) goto L36;
        Object r113 = r112.get("anchor_parent_view_key");
    L38:
        if ((r113 instanceof String) == true) goto L40;
        r113 = null;
    L40:
        String r114 = (String) r113;
        Map<String, Object> r115 = r210.getLocation();
        if (r115 == null) goto L43;
        Object r116 = r115.get("anchor_view_key");
    L45:
        if ((r116 instanceof String) == true) goto L47;
        r116 = null;
    L47:
        KtSafeMethodExtensionKt.safePut(r111, "config", c(r114, (String) r116));
        goto L48
    L43:
        r116 = null;
        goto L45
    L36:
        r113 = null;
    L48:
        String r117 = UUID.randomUUID().toString();
        HashMap<String, JSONObject> r118 = j.f44312a;
        j.h(r117, r111);
        r107.appendQueryParameter("mega_object_id", r117);
        l r119 = ECLiveHybridUtil.b(this.f166778f, r107.build().toString(), null, null, new c(r210), null, null, false, null, null, true, DataLoaderHelper.DATALOADER_KEY_INT_UPDATE_FILE_INTERNAL);
        if (r119 == null) goto L83;
        w.a r120 = w.f166998b;
        Context r121 = this.f166778f;
        p r122 = this.f166785m;
        if (r122 == null) goto L53;
        Boolean r123 = r122.d();
    L54:
        boolean r124 = this.f166786n;
        r120.getClass();
        w.a.d(r119, r121, r123, r124);
        ConcurrentHashMap<String, com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c> r125 = this.f166773a;
        View r126 = r119.getHybridView();
        if (r126 == null) goto L75;
        FrameLayout r127 = this.f166776d;
        if (r127 == null) goto L59;
        g(r127, r126, d(this, r210.getWidth()), d(this, r210.getHeight()));
    L59:
        PendantGravity r128 = r210.getGravity();
        if (r128 == null) goto L74;
        int r129 = f.f166789a[r128.ordinal()];
        if (r129 != 1) goto L64;
        d2.a(r126, r210.getUseBottomMargin());
        d2.c(r126, r210.getUseLeftMargin());
        d2.b(r126, 8388691);
        goto L74
    L64:
        if (r129 != 2) goto L66;
        d2.f(r126, r210.getUseTopMargin());
        d2.e(r126, r210.getUseRightMargin());
        d2.b(r126, 8388661);
        goto L74
    L66:
        if (r129 != 3) goto L68;
        d2.a(r126, r210.getUseBottomMargin());
        d2.e(r126, r210.getUseRightMargin());
        d2.b(r126, VideoPlayDataContext.PLAYING_GRAVITY);
        goto L74
    L68:
        if (r129 != 4) goto L74;
        d2.f(r126, r210.getUseTopMargin());
        d2.c(r126, r210.getUseLeftMargin());
        d2.b(r126, 8388659);
    L74:
        Unit r130 = Unit.INSTANCE;
        View r131 = r126;
    L76:
        r125.put(r101, new com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c(r131, r119, r210.getLynxId(), r210.getState(), r210));
        Unit r132 = Unit.INSTANCE;
        return;
    L75:
        r131 = null;
        goto L76
    L53:
        r123 = null;
        goto L54
    L83:
        return;
    L81:
        return;
    L9:
        r101 = null;
        goto L10
    }

    public static int d(e r100, com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.a r101) {
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

    public final JSONObject c(String r100, String r101) {
        JSONObject r102 = new JSONObject();
        if (r100 == null) goto L41;
        if (r101 == null) goto L41;
        int r103 = r100.hashCode();
        if (r103 == 989642338) goto L19;
        if (r103 == 1362196748) goto L11;
    L26:
        View r104 = null;
    L27:
        int[] r105 = {0, 0};
        if (r104 == null) goto L30;
        r104.getLocationOnScreen(r105);
    L30:
        ArrayList r106 = new ArrayList(2);
        int r107 = 0;
        int r108 = 0;
    L31:
        if (r108 >= 2) goto L33;
        r106.add(Integer.valueOf(UIUtils.px2dip(this.f166778f, r105[r108])));
        r108 = r108 + 1;
        goto L31
    L33:
        KtSafeMethodExtensionKt.safePut(r102, "anchor_view_location", CollectionsKt.toList(r106).toString());
        int[] r109 = new int[2];
        Context r110 = this.f166778f;
        if (r104 == null) goto L36;
        int r111 = r104.getWidth();
    L37:
        r109[0] = UIUtils.px2dip(r110, r111);
        Context r112 = this.f166778f;
        if (r104 == null) goto L40;
        r107 = r104.getHeight();
    L40:
        r109[1] = UIUtils.px2dip(r112, r107);
        KtSafeMethodExtensionKt.safePut(r102, "anchor_view_size", ArraysKt.toList(r109).toString());
        goto L41
    L36:
        r111 = 0;
        goto L37
    L11:
        if (r100.equals("top_nav_slice") == false) goto L26;
        ViewGroup r113 = this.f166781i;
        if (r113 == null) goto L41;
        if (this.f166784l == null) goto L26;
        r104 = SlcRenderContext.f(r113, r101);
        goto L27
    L19:
        if (r100.equals("bottom_nav_slice") == false) goto L26;
        ViewGroup r114 = this.f166782j;
        if (r114 == null) goto L41;
        if (this.f166784l == null) goto L26;
        r104 = SlcRenderContext.f(r114, r101);
    L41:
        return r102;
    }

    public final void h(int r100, int r101) {
        if (this.f166775c != null) goto L21;
        return;
    L21:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L15
        Iterator<Map.Entry<String, com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c>> r103 = this.f166773a.entrySet().iterator();     // Catch: Throwable -> L15
    L7:
        if (r103.hasNext() == false) goto L13;
        com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c r104 = r103.next().getValue();     // Catch: Throwable -> L15
        if (r104 == null) goto L7;
        l r105 = r104.f166767b;     // Catch: Throwable -> L15
        if (r105 == null) goto L7;
        JSONObject r106 = new JSONObject();     // Catch: Throwable -> L15
        KtSafeMethodExtensionKt.safePut(r106, LocationMonitorConst.IDENTIFIER, this.f166783k);     // Catch: Throwable -> L15
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

    public static void g(ViewGroup r100, View r101, int r102, int r103) {
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

    public e(Context r100, ViewGroup r101, ViewGroup r102, ViewGroup r103, ViewGroup r104, String r105, SlcContext r106, p r107, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f166778f = r100;
        this.f166779g = r101;
        this.f166780h = r102;
        this.f166781i = r103;
        this.f166782j = r104;
        this.f166783k = r105;
        this.f166784l = r106;
        this.f166785m = r107;
        this.f166786n = r110;
        this.f166773a = new ConcurrentHashMap();
        if (r102 == null) goto L6;
        r102.addOnLayoutChangeListener(new a(this));
        return;
    }
}
