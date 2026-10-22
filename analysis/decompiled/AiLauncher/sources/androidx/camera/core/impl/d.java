package androidx.camera.core.impl;

import androidx.camera.core.impl.Config;

/* loaded from: classes.dex */
public final class d<T> extends Config.a<T> {

    /* renamed from: a, reason: collision with root package name */
    public final String f11385a;

    /* renamed from: b, reason: collision with root package name */
    public final Class<T> f11386b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f11387c;

    public d(String str, Class<T> cls, Object obj) {
        if (str == null) {
            throw new NullPointerException("Null id");
        }
        this.f11385a = str;
        if (cls == null) {
            throw new NullPointerException("Null valueClass");
        }
        this.f11386b = cls;
        this.f11387c = obj;
    }

    @Override // androidx.camera.core.impl.Config.a
    public String c() {
        return this.f11385a;
    }

    @Override // androidx.camera.core.impl.Config.a
    public Object d() {
        return this.f11387c;
    }

    @Override // androidx.camera.core.impl.Config.a
    public Class<T> e() {
        return this.f11386b;
    }

    public boolean equals(Object obj) {
        Object obj2;
        if (obj == this) {
            return true;
        }
        if (obj instanceof Config.a) {
            Config.a aVar = (Config.a) obj;
            if (this.f11385a.equals(aVar.c()) && this.f11386b.equals(aVar.e()) && ((obj2 = this.f11387c) != null ? obj2.equals(aVar.d()) : aVar.d() == null)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (((this.f11385a.hashCode() ^ 1000003) * 1000003) ^ this.f11386b.hashCode()) * 1000003;
        Object obj = this.f11387c;
        return (obj == null ? 0 : obj.hashCode()) ^ iHashCode;
    }

    public String toString() {
        return "Option{id=" + this.f11385a + ", valueClass=" + this.f11386b + ", token=" + this.f11387c + "}";
    }
}
