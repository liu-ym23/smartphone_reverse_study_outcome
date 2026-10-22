package com.bytedance.android.ec.adapter.api.state;

import android.os.Bundle;
import com.bytedance.android.ec.model.ECUrlModel;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f42686a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f42687b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f42688c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f42689d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f42690e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f42691f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f42692g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f42693h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f42694i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f42695j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Function0<Boolean> f42696k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f42697l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Map<String, String> f42698m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Bundle f42699n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f42700o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Map<String, String> f42701p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Function0<Boolean> f42702q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Function0<Boolean> f42703r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Function0<Integer> f42704s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final ECUrlModel f42705t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final boolean f42706u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f42707v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final String f42708w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Function0<Boolean> f42709x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f42710y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final ECEcomData f42711z;

    /* JADX INFO: renamed from: com.bytedance.android.ec.adapter.api.state.a$a, reason: collision with other inner class name */
    public static final class C0778a {
    }

    static {
    }

    public final boolean a() {
        return this.f42696k.invoke().booleanValue();
    }

    public a(int r110, boolean r111, boolean r112, String r113, String r210, String r211, String r212, boolean r213, boolean r214, Function0 r215, int r216, Map r217, Bundle r218, int r219, Map r310, Function0 r311, Function0 r312, Function0 r313, ECUrlModel r314, boolean r315, Function0 r316, ECEcomData r317) {
        Intrinsics.checkNotNullParameter(r113, "roomUniqueKey");
        Intrinsics.checkNotNullParameter(r210, "roomId");
        Intrinsics.checkNotNullParameter(r211, "roomAnchorId");
        Intrinsics.checkNotNullParameter(r212, "roomAnchorSecId");
        Intrinsics.checkNotNullParameter(r215, "isLoginFunc");
        Intrinsics.checkNotNullParameter(r217, "reportParams");
        Intrinsics.checkNotNullParameter(r218, "extra");
        Intrinsics.checkNotNullParameter(r310, "enterRoomParams");
        Intrinsics.checkNotNullParameter(r311, "isKtvFun");
        Intrinsics.checkNotNullParameter(r312, "isInInteractionGameFun");
        Intrinsics.checkNotNullParameter(r313, "panelHeight");
        Intrinsics.checkNotNullParameter(r316, "isRoomVisibleFunc");
        Intrinsics.checkNotNullParameter(r317, "ecomData");
        this.f42687b = r110;
        this.f42688c = r111;
        this.f42689d = r112;
        this.f42690e = r113;
        this.f42691f = r210;
        this.f42692g = r211;
        this.f42693h = r212;
        this.f42694i = r213;
        this.f42695j = r214;
        this.f42696k = r215;
        this.f42697l = r216;
        this.f42698m = r217;
        this.f42699n = r218;
        this.f42700o = r219;
        this.f42701p = r310;
        this.f42702q = r311;
        this.f42703r = r312;
        this.f42704s = r313;
        this.f42705t = r314;
        this.f42706u = r315;
        this.f42707v = 0;
        this.f42708w = null;
        this.f42709x = r316;
        this.f42710y = 0;
        this.f42711z = r317;
        this.f42686a = ((Boolean) r312.invoke()).booleanValue();
    }
}
