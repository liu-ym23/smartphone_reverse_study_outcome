package androidx.camera.core.impl;

import D.B;
import androidx.camera.core.impl.SessionConfig;
import java.util.List;

/* loaded from: classes.dex */
public final class e extends SessionConfig.f {

    /* renamed from: a, reason: collision with root package name */
    public final DeferrableSurface f11388a;

    /* renamed from: b, reason: collision with root package name */
    public final List<DeferrableSurface> f11389b;

    /* renamed from: c, reason: collision with root package name */
    public final String f11390c;

    /* renamed from: d, reason: collision with root package name */
    public final int f11391d;

    /* renamed from: e, reason: collision with root package name */
    public final int f11392e;

    /* renamed from: f, reason: collision with root package name */
    public final B f11393f;

    public static final class b extends SessionConfig.f.a {

        /* renamed from: a, reason: collision with root package name */
        public DeferrableSurface f11394a;

        /* renamed from: b, reason: collision with root package name */
        public List<DeferrableSurface> f11395b;

        /* renamed from: c, reason: collision with root package name */
        public String f11396c;

        /* renamed from: d, reason: collision with root package name */
        public Integer f11397d;

        /* renamed from: e, reason: collision with root package name */
        public Integer f11398e;

        /* renamed from: f, reason: collision with root package name */
        public B f11399f;

        @Override // androidx.camera.core.impl.SessionConfig.f.a
        public SessionConfig.f a() {
            String str = "";
            if (this.f11394a == null) {
                str = " surface";
            }
            if (this.f11395b == null) {
                str = str + " sharedSurfaces";
            }
            if (this.f11397d == null) {
                str = str + " mirrorMode";
            }
            if (this.f11398e == null) {
                str = str + " surfaceGroupId";
            }
            if (this.f11399f == null) {
                str = str + " dynamicRange";
            }
            if (str.isEmpty()) {
                return new e(this.f11394a, this.f11395b, this.f11396c, this.f11397d.intValue(), this.f11398e.intValue(), this.f11399f);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // androidx.camera.core.impl.SessionConfig.f.a
        public SessionConfig.f.a b(B b10) {
            if (b10 == null) {
                throw new NullPointerException("Null dynamicRange");
            }
            this.f11399f = b10;
            return this;
        }

        @Override // androidx.camera.core.impl.SessionConfig.f.a
        public SessionConfig.f.a c(int i10) {
            this.f11397d = Integer.valueOf(i10);
            return this;
        }

        @Override // androidx.camera.core.impl.SessionConfig.f.a
        public SessionConfig.f.a d(String str) {
            this.f11396c = str;
            return this;
        }

        @Override // androidx.camera.core.impl.SessionConfig.f.a
        public SessionConfig.f.a e(List<DeferrableSurface> list) {
            if (list == null) {
                throw new NullPointerException("Null sharedSurfaces");
            }
            this.f11395b = list;
            return this;
        }

        @Override // androidx.camera.core.impl.SessionConfig.f.a
        public SessionConfig.f.a f(int i10) {
            this.f11398e = Integer.valueOf(i10);
            return this;
        }

        public SessionConfig.f.a g(DeferrableSurface deferrableSurface) {
            if (deferrableSurface == null) {
                throw new NullPointerException("Null surface");
            }
            this.f11394a = deferrableSurface;
            return this;
        }
    }

    @Override // androidx.camera.core.impl.SessionConfig.f
    public B b() {
        return this.f11393f;
    }

    @Override // androidx.camera.core.impl.SessionConfig.f
    public int c() {
        return this.f11391d;
    }

    @Override // androidx.camera.core.impl.SessionConfig.f
    public String d() {
        return this.f11390c;
    }

    @Override // androidx.camera.core.impl.SessionConfig.f
    public List<DeferrableSurface> e() {
        return this.f11389b;
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof SessionConfig.f) {
            SessionConfig.f fVar = (SessionConfig.f) obj;
            if (this.f11388a.equals(fVar.f()) && this.f11389b.equals(fVar.e()) && ((str = this.f11390c) != null ? str.equals(fVar.d()) : fVar.d() == null) && this.f11391d == fVar.c() && this.f11392e == fVar.g() && this.f11393f.equals(fVar.b())) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.camera.core.impl.SessionConfig.f
    public DeferrableSurface f() {
        return this.f11388a;
    }

    @Override // androidx.camera.core.impl.SessionConfig.f
    public int g() {
        return this.f11392e;
    }

    public int hashCode() {
        int iHashCode = (((this.f11388a.hashCode() ^ 1000003) * 1000003) ^ this.f11389b.hashCode()) * 1000003;
        String str = this.f11390c;
        return this.f11393f.hashCode() ^ ((((((iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003) ^ this.f11391d) * 1000003) ^ this.f11392e) * 1000003);
    }

    public String toString() {
        return "OutputConfig{surface=" + this.f11388a + ", sharedSurfaces=" + this.f11389b + ", physicalCameraId=" + this.f11390c + ", mirrorMode=" + this.f11391d + ", surfaceGroupId=" + this.f11392e + ", dynamicRange=" + this.f11393f + "}";
    }

    public e(DeferrableSurface deferrableSurface, List<DeferrableSurface> list, String str, int i10, int i11, B b10) {
        this.f11388a = deferrableSurface;
        this.f11389b = list;
        this.f11390c = str;
        this.f11391d = i10;
        this.f11392e = i11;
        this.f11393f = b10;
    }
}
