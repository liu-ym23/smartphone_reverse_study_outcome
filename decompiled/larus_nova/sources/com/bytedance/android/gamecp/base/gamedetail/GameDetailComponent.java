package com.bytedance.android.gamecp.base.gamedetail;

import androidx.fragment.app.FragmentManager;
import com.bytedance.ies.sve_core.PureWidget;
import com.bytedance.ies.sve_core.p;
import com.bytedance.ies.sve_list.SVEAdapter;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public abstract class GameDetailComponent<P extends com.bytedance.ies.sve_core.p> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PureWidget<P> f51521a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public l0 f51522b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public JSONObject f51523c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public P f51524d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f51525e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.bytedance.ies.sve_core.e f51526f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.bytedance.ies.sve_core.e f51527g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f51528h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f51529i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f51530j;

    public static final class a {
    }

    static {
    }

    public abstract PureWidget<P> a(l0 r100, SVEAdapter<d0, ?> r101, FragmentManager r102, Function1<? super PureWidget<P>, Unit> r103);

    public abstract P d(JSONObject r100, boolean r101, int r102);

    public void f(PureWidget<P> r100, JSONObject r101) {
    }

    public GameDetailComponent(String r100) {
        Intrinsics.checkNotNullParameter(r100, "componentClass");
        this.f51530j = r100;
    }

    public final PureWidget<P> b(l0 r100, SVEAdapter<d0, ?> r101, FragmentManager r102, final Function1<? super PureWidget<P>, Unit> r103) {
        long r104 = System.currentTimeMillis();
        final PureWidget<P> r105 = this.f51521a;
        this.f51522b = r100;
        PureWidget<P> r106 = a(r100, r101, r102, new GameDetailComponent$createWidgetInternal$result$1(this, r103, r105));
        this.f51521a = r106;
        this.f51529i = System.currentTimeMillis() - r104;
        if ((r106 instanceof g0) == false) goto L5;
        h0 r107 = ((g0) r106).Yo();
        r107.f51583a = this.f51528h;
        r107.f51584b = this.f51529i;
    L5:
        return r106;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PureWidget c(GameDetailComponent r100, l0 r101, SVEAdapter r102, FragmentManager r103, int r104) {
        if ((r104 & 1) == 0) goto L6;
        r101 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = null;
    L9:
        return r100.b(r101, r102, r103, null);
    }

    public final P e(JSONObject r100, com.bytedance.ies.sve_core.e r101, com.bytedance.ies.sve_core.e r110, boolean r111, int r112) {
        long r102 = System.currentTimeMillis();
        this.f51526f = r101;
        this.f51527g = r110;
        this.f51523c = r100;
        P r113 = null;
        P r114 = (P) d(r100, r111, r112);
        if (r114 == null) goto L15;
        this.f51524d = r114;     // Catch: Exception -> L13
        if (r100 == null) goto L12;
        PureWidget<P> r115 = this.f51521a;     // Catch: Exception -> L13
        if (r115 == null) goto L12;
        if (this.f51525e == true) goto L12;
        this.f51525e = true;     // Catch: Exception -> L13
        f(r115, r100);     // Catch: Exception -> L13
    L12:
        r113 = r114;
    L15:
        this.f51528h = System.currentTimeMillis() - r102;
        return r113;
    L13:
        e = move-exception;
        com.bytedance.android.gamecp.host_api.a.b().getLogService().logV3("dygame_tech_type_detail_widget_error", MapsKt.hashMapOf(new Pair[]{TuplesKt.to("widget", getClass().getSimpleName()), TuplesKt.to("step", "getProps"), TuplesKt.to("error_msg", e.getMessage())}));
        bw.k r103 = com.bytedance.android.gamecp.host_api.a.b().getHostMonitorService();
        JSONObject r116 = new JSONObject();
        r116.put("widget", r116.getClass().getSimpleName());
        Unit r104 = Unit.INSTANCE;
        JSONObject r105 = new JSONObject();
        r105.put("step", "getProps");
        JSONObject r106 = new JSONObject();
        r106.put("error_msg", String.valueOf(e.getMessage()));
        r103.monitorEvent("dygame_tech_type_detail_widget_error", r116, r105, r106);
        goto L15
    }
}
