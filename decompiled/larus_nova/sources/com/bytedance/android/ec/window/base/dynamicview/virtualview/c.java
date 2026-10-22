package com.bytedance.android.ec.window.base.dynamicview.virtualview;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f49292b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final fo.a<Float> f49293c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final fo.a<Float> f49294d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final fo.a<Integer> f49295e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final fo.a<Integer> f49296f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final fo.a<Boolean> f49297g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final fo.a<Boolean> f49298h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final fo.b f49299a;

    public static final class a {
    }

    public void a(ConstraintLayout.LayoutParams r100) {
        Intrinsics.checkNotNullParameter(r100, "lp");
    }

    static {
        f49292b = new c();
        f49293c = new fo.a("constraint_option_horizontal_bias", new Float[0]);
        f49294d = new fo.a("constraint_option_vertical_bias", new Float[0]);
        f49295e = new fo.a("constraint_option_horizontal_chain_style", new Integer[]{2, 1, 0});
        f49296f = new fo.a("constraint_option_vertical_chain_style", new Integer[]{2, 1, 0});
        Boolean r100 = Boolean.TRUE;
        Boolean r101 = Boolean.FALSE;
        f49297g = new fo.a("constraint_option_width_constrained", new Boolean[]{r100, r101});
        f49298h = new fo.a("constraint_option_height_constrained", new Boolean[]{r100, r101});
    }

    public c() {
        this.f49299a = new fo.b();
    }
}
