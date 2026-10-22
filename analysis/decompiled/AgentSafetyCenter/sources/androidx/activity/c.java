package androidx.activity;

import android.window.BackEvent;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final float f655a;

    /* renamed from: b, reason: collision with root package name */
    public final float f656b;

    /* renamed from: c, reason: collision with root package name */
    public final float f657c;

    /* renamed from: d, reason: collision with root package name */
    public final int f658d;

    public c(BackEvent backEvent) {
        a aVar = a.f649a;
        float fD = aVar.d(backEvent);
        float fE = aVar.e(backEvent);
        float fB = aVar.b(backEvent);
        int iC = aVar.c(backEvent);
        this.f655a = fD;
        this.f656b = fE;
        this.f657c = fB;
        this.f658d = iC;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("BackEventCompat{touchX=");
        sb2.append(this.f655a);
        sb2.append(", touchY=");
        sb2.append(this.f656b);
        sb2.append(", progress=");
        sb2.append(this.f657c);
        sb2.append(", swipeEdge=");
        return b.l(sb2, this.f658d, '}');
    }
}
