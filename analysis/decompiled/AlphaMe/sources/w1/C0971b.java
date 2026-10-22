package w1;

import android.graphics.Typeface;
import f1.AbstractC0557a;

/* renamed from: w1.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0971b extends C.b {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ AbstractC0557a f15807e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ C0973d f15808f;

    public C0971b(C0973d c0973d, AbstractC0557a abstractC0557a) {
        this.f15808f = c0973d;
        this.f15807e = abstractC0557a;
    }

    @Override // C.b
    public final void g(int i4) {
        this.f15808f.f15826n = true;
        this.f15807e.O(i4);
    }

    @Override // C.b
    public final void h(Typeface typeface) {
        C0973d c0973d = this.f15808f;
        c0973d.f15828p = Typeface.create(typeface, c0973d.f15816d);
        c0973d.f15826n = true;
        this.f15807e.P(c0973d.f15828p, false);
    }
}
