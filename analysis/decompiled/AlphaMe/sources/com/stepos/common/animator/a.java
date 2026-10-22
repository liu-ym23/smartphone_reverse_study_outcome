package com.stepos.common.animator;

import android.view.View;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public W.m f11268a;

    /* renamed from: b, reason: collision with root package name */
    public W.m f11269b;

    /* renamed from: c, reason: collision with root package name */
    public View f11270c;

    /* renamed from: d, reason: collision with root package name */
    public float f11271d;

    /* renamed from: e, reason: collision with root package name */
    public float f11272e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f11273f;

    public final void a(boolean z4) {
        W.m mVar = this.f11268a;
        if (mVar != null && mVar.f1967f) {
            mVar.c();
        }
        W.m mVar2 = this.f11269b;
        if (mVar2 != null && mVar2.f1967f) {
            mVar2.c();
        }
        W.f fVar = W.m.f1957s;
        View view = this.f11270c;
        W.m mVar3 = new W.m(view, fVar);
        W.n nVar = new W.n();
        nVar.f1985i = z4 ? this.f11272e : 1.0f;
        nVar.b(250.0f);
        nVar.a(0.89f);
        mVar3.f1974m = nVar;
        this.f11269b = mVar3;
        mVar3.i();
        W.m mVar4 = new W.m(view, W.m.f1956r);
        W.n nVar2 = new W.n();
        nVar2.f1985i = z4 ? this.f11271d : 1.0f;
        nVar2.b(250.0f);
        nVar2.a(0.89f);
        mVar4.f1974m = nVar2;
        this.f11268a = mVar4;
        mVar4.i();
    }
}
