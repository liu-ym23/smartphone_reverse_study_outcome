package xd;

import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f25865a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f25866b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f25867c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f25868d;

    public a(float r10, float r11) {
        this.f25865a = r10;
        this.f25866b = r11;
        this.f25867c = (int) r10;
        this.f25868d = (int) r11;
    }

    public final int a() {
        return this.f25867c;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof a) == true) goto L8;
        return false;
    L8:
        a r11 = (a) r10;
        if (q.b(Float.valueOf(this.f25865a), Float.valueOf(r11.f25865a)) == true) goto L12;
        return false;
    L12:
        if (q.b(Float.valueOf(this.f25866b), Float.valueOf(r11.f25866b)) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (Float.hashCode(this.f25865a) * 31) + Float.hashCode(this.f25866b);
    }

    public String toString() {
        return "AvailableWindowSize(width=" + this.f25865a + ", height=" + this.f25866b + ')';
    }
}
