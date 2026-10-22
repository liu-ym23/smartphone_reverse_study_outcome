package androidx.activity;

import android.window.BackEvent;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: androidx.activity.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0174b {

    /* renamed from: a, reason: collision with root package name */
    public final float f2380a;

    /* renamed from: b, reason: collision with root package name */
    public final float f2381b;

    /* renamed from: c, reason: collision with root package name */
    public final float f2382c;

    /* renamed from: d, reason: collision with root package name */
    public final int f2383d;

    public C0174b(BackEvent backEvent) {
        Intrinsics.checkNotNullParameter(backEvent, "backEvent");
        C0173a c0173a = C0173a.f2379a;
        float fD = c0173a.d(backEvent);
        float fE = c0173a.e(backEvent);
        float fB = c0173a.b(backEvent);
        int iC = c0173a.c(backEvent);
        this.f2380a = fD;
        this.f2381b = fE;
        this.f2382c = fB;
        this.f2383d = iC;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("BackEventCompat{touchX=");
        sb.append(this.f2380a);
        sb.append(", touchY=");
        sb.append(this.f2381b);
        sb.append(", progress=");
        sb.append(this.f2382c);
        sb.append(", swipeEdge=");
        return B0.g.o(sb, this.f2383d, '}');
    }
}
