package com.stepos.common.animator;

import com.stepos.common.widget.StepSeekBar;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public h1.f f6444a;

    /* renamed from: b, reason: collision with root package name */
    public h1.f f6445b;

    /* renamed from: c, reason: collision with root package name */
    public StepSeekBar f6446c;

    /* renamed from: d, reason: collision with root package name */
    public float f6447d;

    /* renamed from: e, reason: collision with root package name */
    public float f6448e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f6449f;

    public final void a(boolean z) {
        StepSeekBar stepSeekBar = this.f6446c;
        h1.f fVar = this.f6444a;
        if (fVar != null && fVar.f9232f) {
            fVar.f();
        }
        h1.f fVar2 = this.f6445b;
        if (fVar2 != null && fVar2.f9232f) {
            fVar2.f();
        }
        h1.f fVar3 = new h1.f(stepSeekBar, h1.d.f9223o);
        h1.g gVar = new h1.g();
        gVar.f9251i = z ? this.f6448e : 1.0f;
        gVar.b(250.0f);
        gVar.a(0.89f);
        fVar3.f9241t = gVar;
        this.f6445b = fVar3;
        fVar3.h();
        h1.f fVar4 = new h1.f(stepSeekBar, h1.d.f9222n);
        h1.g gVar2 = new h1.g();
        gVar2.f9251i = z ? this.f6447d : 1.0f;
        gVar2.b(250.0f);
        gVar2.a(0.89f);
        fVar4.f9241t = gVar2;
        this.f6444a = fVar4;
        fVar4.h();
    }
}
