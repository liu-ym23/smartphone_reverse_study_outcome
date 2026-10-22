package com.bytedance.android.shopping.anchorv4.voavhs.lynx;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.shopping.anchorv4.data.AnchorV4DataManager;
import com.bytedance.android.shopping.anchorv4.dto.base.Radius;
import com.bytedance.android.shopping.anchorv4.dto.business.ComponentDTO;
import com.bytedance.android.shopping.anchorv4.helper.q;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import ti.l;

/* JADX INFO: loaded from: classes13.dex */
public final class c extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public l f170013a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.b f170014b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f170015c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f170016d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final e f170017e;

    public final void a(a r110) {
        Intrinsics.checkNotNullParameter(r110, "data");
        String r100 = r110.f169991b;
        if (r100 == null) goto L48;
        int r101 = p73.c.f527998d;
        StringBuilder r102 = new StringBuilder("AnchorV4LynxNodeView getPreloadLynxCard: componentId：");
        ComponentDTO r103 = r110.f169995f;
        View r104 = null;
        if (r103 == null) goto L8;
        String r105 = r103.getComponentId();
    L9:
        r102.append(r105);
        r102.append(", lynxAddress：");
        r102.append(r110.f169991b);
        p73.c.a.a(r102.toString());
        String r106 = r110.f169991b;
        Context r107 = getContext();
        Intrinsics.checkNotNullParameter(r106, "schema");
        Intrinsics.checkNotNullParameter(r107, PerfLog.PARAM_KEY_CONTEXT_ID);
        JSONObject r108 = k.w(r110.f169992c);
        Intrinsics.checkNotNullParameter(r110, "id");
        Intrinsics.checkNotNullParameter(this, "view");
        if (this.f170017e.S(new p73.d(r106, r107, this, r108, r110, null, this.f170017e.d()), r110.identifier()) != null) goto L47;
        removeAllViews();
        View r109 = this.f170016d;
        if (r109 == null) goto L14;
        addView(r109);
    L14:
        StringBuilder r111 = new StringBuilder("AnchorV4LynxNodeView loadNormalLynxCard, componentId：");
        ComponentDTO r112 = r110.f169995f;
        if (r112 == null) goto L17;
        String r113 = r112.getComponentId();
    L18:
        r111.append(r113);
        r111.append(", lynxAddress：");
        r111.append(r110.f169991b);
        p73.c.a.a(r111.toString());
        String r114 = UriProtector.getQueryParameter(UriProtector.parse(r100), "url");
        if (r114 == null) goto L48;
        if (k.c(r114) == true) goto L24;
        r114 = null;
    L24:
        if (r114 == null) goto L48;
        String r115 = UriProtector.parse(r114).buildUpon().build().toString();
        JSONObject r116 = k.w(r110.f169992c);
        if (r116 == null) goto L29;
        r116.put(LocationMonitorConst.IDENTIFIER, AnchorV4DataManager.f166338d);
    L30:
        JSONObject r117 = r110.f169993d;
        l r118 = this.f170013a;
        if (r118 != null) goto L33;
        JSONObject r119 = new JSONObject();
        r119.put("module_param", r116);
        r119.put("mob_data", r117);
        this.f170013a = this.f170017e.U(getContext(), r115, com.bytedance.android.shopping.hybrid.a.b(r119), this, new b(r110));
        Unit r120 = Unit.INSTANCE;
    L43:
        this.f170015c = r115;
        l r121 = this.f170013a;
        if (r121 == null) goto L46;
        r104 = r121.getHybridView();
    L46:
        this.f170016d = r104;
        goto L47
    L33:
        if (this.f170015c.length() <= 0) goto L35;
        boolean r122 = true;
    L36:
        if (r122 == true) goto L38;
    L41:
        JSONObject r123 = new JSONObject();
        r123.put("module_param", r116);
        r123.put("mob_data", r117);
        Unit r124 = Unit.INSTANCE;
        r118.renderTemplate(r115, com.bytedance.android.shopping.hybrid.a.b(r123));
        goto L43
    L38:
        if (Intrinsics.areEqual(this.f170015c, r115) == false) goto L41;
        if (r116 == null) goto L41;
        JSONObject r125 = new JSONObject();
        r125.put("module_param", r116);
        r125.put("mob_data", r117);
        Unit r126 = Unit.INSTANCE;
        r118.updateData(com.bytedance.android.shopping.hybrid.a.b(r125));
        goto L43
    L35:
        r122 = false;
        goto L36
    L29:
        r116 = null;
        goto L30
    L17:
        r113 = null;
    L47:
        int r127 = q.f166972a;
        q.a(this, r110.f169996g, this.f170014b, 8, 0, CollectionsKt.listOf(new Integer[]{0, 0, 0, 0}));
        goto L48
    L8:
        r105 = null;
    L48:
        Unit r128 = Unit.INSTANCE;
    }

    @Override // android.view.View
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        this.f170014b.e(r100);
        super.draw(r100);
        this.f170014b.d(r100);
    }

    public c(Context r100, e r101) {
        Intrinsics.checkNotNullParameter(r101, "depend");
        if (r100 == null) goto L7;
        super(r100);
        this.f170017e = r101;
        com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.b r102 = new com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.b(this);
        this.f170014b = r102;
        this.f170015c = "";
        r102.f(new Radius(8, 8, 8, 8));
        return;
    L7:
        throw new IllegalStateException("Required value was null.".toString());
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        this.f170014b.c(r100, r101);
    }
}
