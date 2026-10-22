package a0;

import D.C0777n;
import a0.k;

/* renamed from: a0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1200a extends k.a {

    /* renamed from: a, reason: collision with root package name */
    public final int f7777a;

    /* renamed from: b, reason: collision with root package name */
    public final C0777n f7778b;

    public C1200a(int i10, C0777n c0777n) {
        this.f7777a = i10;
        if (c0777n == null) {
            throw new NullPointerException("Null cameraIdentifier");
        }
        this.f7778b = c0777n;
    }

    @Override // a0.k.a
    public C0777n b() {
        return this.f7778b;
    }

    @Override // a0.k.a
    public int c() {
        return this.f7777a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof k.a) {
            k.a aVar = (k.a) obj;
            if (this.f7777a == aVar.c() && this.f7778b.equals(aVar.b())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.f7778b.hashCode() ^ ((this.f7777a ^ 1000003) * 1000003);
    }

    public String toString() {
        return "Key{lifecycleOwnerHash=" + this.f7777a + ", cameraIdentifier=" + this.f7778b + "}";
    }
}
