package com.obric.oui.popover.v2;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$style;
import com.obric.oui.material.MaterialToken;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public abstract class f {
    public boolean A;
    public Function1 B;
    public boolean C;
    public int D;
    public float E;
    public float F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f16328a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f16329b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f16330c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f16331d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f16332e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f16333f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f16334g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f16335h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f16336i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f16337j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public View f16338k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f16339l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f16340m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public OPopover.OnBubbleStartDismissListener f16341n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public OPopover.OnBubbleDismissListener f16342o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public OPopover.OnBubbleShowListener f16343p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f16344q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f16345r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f16346s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f16347t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f16348u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f16349v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f16350w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f16351x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f16352y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f16353z;

    public f(Context r10) {
        q.g(r10, "context");
        this.f16328a = r10;
        this.f16332e = ContextCompat.b(r10, R$color.oui_toast_background);
        this.f16336i = 800;
        this.f16337j = Long.MIN_VALUE;
        this.f16344q = true;
        this.f16346s = true;
        this.f16350w = true;
        this.f16351x = true;
        this.f16352y = R$style.OUIShadow_Oui_Shadow_Regular;
        this.A = true;
        this.B = MaterialToken.OUI_Bg_Popup;
        this.C = true;
        this.D = Color.parseColor("#08000000");
        this.E = 0.3f;
        this.F = 0.98f;
    }

    public final OPopover.OnBubbleStartDismissListener A() {
        return this.f16341n;
    }

    public final View B() {
        return this.f16338k;
    }

    public final int C() {
        return this.f16339l;
    }

    public final int D() {
        return this.f16334g;
    }

    public final int E() {
        return this.f16335h;
    }

    public final int F() {
        return this.f16352y;
    }

    public final boolean G() {
        return this.f16349v;
    }

    public f H() {
        return this;
    }

    public final f I(View r10) {
        q.g(r10, "view");
        this.f16338k = r10;
        return H();
    }

    public OPopover.a a() {
        return (OPopover.a) this;
    }

    public OPopover b() {
        return new OPopover(a());
    }

    public final Context c() {
        return this.f16328a;
    }

    public final long d() {
        return this.f16336i;
    }

    public final long e() {
        return this.f16337j;
    }

    public final int f() {
        return this.f16332e;
    }

    public final int g() {
        return this.f16348u;
    }

    public final int h() {
        return this.f16347t;
    }

    public final boolean i() {
        return this.C;
    }

    public final OPopover.OnBubbleDismissListener j() {
        return this.f16342o;
    }

    public final int k() {
        return this.f16331d;
    }

    public final boolean l() {
        return this.A;
    }

    public final boolean m() {
        return this.f16329b;
    }

    public final boolean n() {
        return this.f16345r;
    }

    public final int o() {
        return this.f16330c;
    }

    public final int p() {
        return this.f16340m;
    }

    public final boolean q() {
        return this.f16333f;
    }

    public final Function1 r() {
        return this.B;
    }

    public final boolean s() {
        return this.f16344q;
    }

    public final void setMDismissListener(@Nullable OPopover.OnBubbleDismissListener r10) {
        this.f16342o = r10;
    }

    public final void setMShowListener(@Nullable OPopover.OnBubbleShowListener r10) {
        this.f16343p = r10;
    }

    public final void setMStartDismissListener(@Nullable OPopover.OnBubbleStartDismissListener r10) {
        this.f16341n = r10;
    }

    public final boolean t() {
        return this.f16351x;
    }

    public final OPopover.OnBubbleShowListener u() {
        return this.f16343p;
    }

    public final boolean v() {
        return this.f16350w;
    }

    public final boolean w() {
        return this.f16353z;
    }

    public final float x() {
        return this.E;
    }

    public final int y() {
        return this.D;
    }

    public final float z() {
        return this.F;
    }
}
