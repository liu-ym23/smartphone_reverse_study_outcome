package J;

import J.C0855j;
import android.graphics.Bitmap;

/* renamed from: J.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0846a extends C0855j.b {

    /* renamed from: a, reason: collision with root package name */
    public final U.A<Bitmap> f3585a;

    /* renamed from: b, reason: collision with root package name */
    public final int f3586b;

    public C0846a(U.A<Bitmap> a10, int i10) {
        if (a10 == null) {
            throw new NullPointerException("Null packet");
        }
        this.f3585a = a10;
        this.f3586b = i10;
    }

    @Override // J.C0855j.b
    public int a() {
        return this.f3586b;
    }

    @Override // J.C0855j.b
    public U.A<Bitmap> b() {
        return this.f3585a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C0855j.b) {
            C0855j.b bVar = (C0855j.b) obj;
            if (this.f3585a.equals(bVar.b()) && this.f3586b == bVar.a()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.f3586b ^ ((this.f3585a.hashCode() ^ 1000003) * 1000003);
    }

    public String toString() {
        return "In{packet=" + this.f3585a + ", jpegQuality=" + this.f3586b + "}";
    }
}
