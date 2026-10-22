package com.obric.oui.popover.v2;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import com.obric.aiagent.plugin.R;
import com.obric.oui.material.MaterialToken;
import com.obric.oui.popover.v2.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: OPopoverBuilderDelegate.kt */
/* JADX INFO: loaded from: classes4.dex */
public class c<T extends c<T>> {
    private boolean A;
    private d.h.a.b<? super Boolean, com.obric.oui.material.c[]> B;
    private boolean C;
    private int D;
    private float E;
    private float F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f36062a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f36063b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f36064c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f36065d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f36066e;
    private boolean f;
    private int g;
    private int h;
    private long i;
    private long j;
    private View k;
    private int l;
    private int m;
    private OPopover.e n;
    private OPopover.c o;
    private OPopover.d p;
    private boolean q;
    private boolean r;
    private boolean s;
    private int t;
    private int u;
    private boolean v;
    private boolean w;
    private boolean x;
    private int y;
    private boolean z;

    public c(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        o.e(r5, "context");
        Context r6 = ZeusTransformUtils.wrapperContext(r5, "com.obric.aiagent.plugin");
        this.f36062a = r6;
        this.f36066e = androidx.core.content.a.c(r6, ZeusTransformUtils.mapRes(R.color.oui_toast_background, "color", "oui_toast_background"));
        this.i = 800;
        this.j = Long.MIN_VALUE;
        this.q = true;
        this.s = true;
        this.w = true;
        this.x = true;
        this.y = ZeusTransformUtils.mapRes(R.style.OUIShadow_Oui_Shadow_Regular, "style", "OUIShadow_Oui_Shadow_Regular");
        this.A = true;
        this.B = MaterialToken.OUI_Bg_Popup;
        this.C = true;
        this.D = Color.parseColor("#08000000");
        this.E = 0.3f;
        this.F = 0.98f;
    }

    public final Context getContext() {
        return this.f36062a;
    }

    public final boolean a() {
        return this.f36063b;
    }

    public final int b() {
        return this.f36064c;
    }

    public final int c() {
        return this.f36065d;
    }

    public final int d() {
        return this.f36066e;
    }

    public final boolean e() {
        return this.f;
    }

    public final int f() {
        return this.g;
    }

    public final int g() {
        return this.h;
    }

    public final long h() {
        return this.i;
    }

    public final long i() {
        return this.j;
    }

    public final View j() {
        return this.k;
    }

    public final int k() {
        return this.l;
    }

    public final int l() {
        return this.m;
    }

    public final OPopover.e m() {
        return this.n;
    }

    public final OPopover.c n() {
        return this.o;
    }

    public final OPopover.d o() {
        return this.p;
    }

    public final boolean p() {
        return this.q;
    }

    public final boolean q() {
        return this.r;
    }

    public final boolean r() {
        return this.s;
    }

    public final int s() {
        return this.t;
    }

    public final int t() {
        return this.u;
    }

    public final boolean u() {
        return this.v;
    }

    public final boolean v() {
        return this.w;
    }

    public final boolean w() {
        return this.x;
    }

    public final int x() {
        return this.y;
    }

    public final boolean y() {
        return this.z;
    }

    public final boolean z() {
        return this.A;
    }

    public final d.h.a.b<Boolean, com.obric.oui.material.c[]> A() {
        return this.B;
    }

    public final boolean B() {
        return this.C;
    }

    public final int C() {
        return this.D;
    }

    public final float D() {
        return this.E;
    }

    public final float E() {
        return this.F;
    }

    public T F() {
        return (T) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.aiagent.plugin");
    }

    public final T a(OPopover.d r3) {
        OPopover.d r4 = (OPopover.d) ZeusTransformUtils.wrapperContextForParams(r3, OPopover.d.class, "com.obric.aiagent.plugin");
        o.e(r4, "listener");
        this.p = r4;
        return (T) F();
    }

    public final T a(OPopover.c r3) {
        OPopover.c r4 = (OPopover.c) ZeusTransformUtils.wrapperContextForParams(r3, OPopover.c.class, "com.obric.aiagent.plugin");
        o.e(r4, "listener");
        this.o = r4;
        return (T) F();
    }

    public final T a(boolean r1) {
        this.x = r1;
        return (T) F();
    }

    public final T a(int r1) {
        this.y = r1;
        return (T) F();
    }

    public final T b(boolean r1) {
        this.C = r1;
        return (T) F();
    }

    public final T c(boolean r1) {
        this.f = r1;
        return (T) F();
    }

    public final T a(long r1) {
        this.j = r1;
        return (T) F();
    }

    public final T a(View r2) {
        o.e(r2, "view");
        this.k = r2;
        return (T) F();
    }

    public final T d(boolean r1) {
        this.v = r1;
        return (T) F();
    }

    public final T e(boolean r1) {
        this.A = r1;
        return (T) F();
    }

    public OPopover G() {
        return new OPopover(H());
    }

    public OPopover.a H() {
        return (OPopover.a) ZeusTransformUtils.preCheckCast(this, OPopover.a.class, "com.obric.aiagent.plugin");
    }
}
