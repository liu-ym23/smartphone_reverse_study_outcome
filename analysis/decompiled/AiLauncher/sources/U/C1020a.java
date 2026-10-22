package U;

import U.C1037s;
import androidx.concurrent.futures.CallbackToFutureAdapter;

/* renamed from: U.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1020a extends C1037s.b {

    /* renamed from: a, reason: collision with root package name */
    public final int f6086a;

    /* renamed from: b, reason: collision with root package name */
    public final int f6087b;

    /* renamed from: c, reason: collision with root package name */
    public final CallbackToFutureAdapter.a<Void> f6088c;

    public C1020a(int i10, int i11, CallbackToFutureAdapter.a<Void> aVar) {
        this.f6086a = i10;
        this.f6087b = i11;
        if (aVar == null) {
            throw new NullPointerException("Null completer");
        }
        this.f6088c = aVar;
    }

    @Override // U.C1037s.b
    public CallbackToFutureAdapter.a<Void> a() {
        return this.f6088c;
    }

    @Override // U.C1037s.b
    public int b() {
        return this.f6086a;
    }

    @Override // U.C1037s.b
    public int c() {
        return this.f6087b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C1037s.b) {
            C1037s.b bVar = (C1037s.b) obj;
            if (this.f6086a == bVar.b() && this.f6087b == bVar.c() && this.f6088c.equals(bVar.a())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.f6088c.hashCode() ^ ((((this.f6086a ^ 1000003) * 1000003) ^ this.f6087b) * 1000003);
    }

    public String toString() {
        return "PendingSnapshot{jpegQuality=" + this.f6086a + ", rotationDegrees=" + this.f6087b + ", completer=" + this.f6088c + "}";
    }
}
