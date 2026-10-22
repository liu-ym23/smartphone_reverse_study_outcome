package com.obric.oui.texteffects.runtime;

import android.util.Log;
import android.view.View;
import bg.h;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class ExternalViewLayerBinding {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f17317g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f17318a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f17319b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0 f17320c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f17321d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f17322e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f17323f;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    static {
        f17317g = new a(null);
    }

    public ExternalViewLayerBinding(String r10, View r11, Function0 r12, int r13, float r14) {
        q.g(r10, "bindingKey");
        q.g(r11, "view");
        q.g(r12, "textWidthProvider");
        this.f17318a = r10;
        this.f17319b = r11;
        this.f17320c = r12;
        this.f17321d = r13;
        this.f17322e = r14;
        this.f17323f = r11.getResources().getDisplayMetrics().density;
    }

    public final void a(c r10, float r11) {
        q.g(r10, "frame");
        od.d r12 = r10.h();
        if (r12 == null) goto L6;
        c().setTranslationX(e(r12, r11));
    L6:
        od.d r13 = r10.i();
        if (r13 == null) goto L11;
        c().setTranslationY(e(r13, r11));
    L11:
        if (Float.isNaN(r10.b()) == true) goto L13;
        this.f17319b.setAlpha(h.j(r10.b(), 0.0f, 1.0f));
    L13:
        View r14 = this.f17319b;
        Float r15 = r10.m();
        int r16 = 0;
        if (r15 != null) goto L17;
    L20:
        r14.setVisibility(r16);
        if (com.obric.oui.texteffects.e.a() == true) goto L23;
        return;
    L23:
        if (com.obric.oui.texteffects.e.b() == false) goto L27;
        Log.d(q.p("OUITextEffects/", "ExternalBinding"), "apply binding=" + b() + ", alpha=" + c().getAlpha() + ", visibility=" + c().getVisibility() + ", translationX=" + c().getTranslationX() + ", translationY=" + c().getTranslationY());
        return;
    L27:
        return;
    L17:
        if (r15.floatValue() > 0.001f) goto L20;
        r16 = this.f17321d;
        goto L20
    }

    public final String b() {
        return this.f17318a;
    }

    public final View c() {
        return this.f17319b;
    }

    public final void d() {
        this.f17319b.setVisibility(this.f17321d);
        View r10 = this.f17319b;
        r10.setTranslationX(-r10.getMeasuredWidth());
    }

    public final float e(od.d r10, float r11) {
        if ((r10 instanceof od.d.b) == false) goto L6;
        return ((od.d.b) r10).a();
    L6:
        if ((r10 instanceof od.d.a) == false) goto L9;
        float r12 = ((od.d.a) r10).a();
        return this.f17323f * r12;
    L9:
        if ((r10 instanceof od.d.C0329d) == false) goto L12;
        return h.c(((Number) this.f17320c.invoke()).floatValue(), 0.0f) * ((od.d.C0329d) r10).a();
    L12:
        if ((r10 instanceof od.d.c) == false) goto L16;
        od.d.c r13 = (od.d.c) r10;
        float r14 = e(r13.a(), r11);
        return ((e(r13.c(), r11) - r14) * h.j(r13.b(), 0.0f, 1.0f)) + r14;
    L16:
        throw new NoWhenBranchMatchedException();
    }

    public /* synthetic */ ExternalViewLayerBinding(String r10, final View r11, Function0 r12, int r13, float r14, int r15, DefaultConstructorMarker r16) {
        if ((r15 & 4) == 0) goto L5;
        r12 = new AnonymousClass1(r11);
    L5:
        Function0 r17 = r12;
        if ((r15 & 8) == 0) goto L8;
        r13 = 4;
    L8:
        int r18 = r13;
        if ((r15 & 16) == 0) goto L11;
        r14 = 248.0f;
    L11:
        this(r10, r11, r17, r18, r14);
    }
}
