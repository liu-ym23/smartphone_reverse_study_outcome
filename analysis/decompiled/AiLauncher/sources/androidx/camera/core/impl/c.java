package androidx.camera.core.impl;

import D.B;
import android.util.Range;
import android.util.Size;
import androidx.camera.core.impl.UseCaseConfigFactory;
import java.util.List;

/* loaded from: classes.dex */
public final class c extends b {

    /* renamed from: a, reason: collision with root package name */
    public final SurfaceConfig f11375a;

    /* renamed from: b, reason: collision with root package name */
    public final int f11376b;

    /* renamed from: c, reason: collision with root package name */
    public final Size f11377c;

    /* renamed from: d, reason: collision with root package name */
    public final B f11378d;

    /* renamed from: e, reason: collision with root package name */
    public final List<UseCaseConfigFactory.CaptureType> f11379e;

    /* renamed from: f, reason: collision with root package name */
    public final Config f11380f;

    /* renamed from: g, reason: collision with root package name */
    public final int f11381g;

    /* renamed from: h, reason: collision with root package name */
    public final Range<Integer> f11382h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f11383i;

    /* renamed from: j, reason: collision with root package name */
    public final int f11384j;

    public c(SurfaceConfig surfaceConfig, int i10, Size size, B b10, List<UseCaseConfigFactory.CaptureType> list, Config config, int i11, Range<Integer> range, boolean z10, int i12) {
        if (surfaceConfig == null) {
            throw new NullPointerException("Null surfaceConfig");
        }
        this.f11375a = surfaceConfig;
        this.f11376b = i10;
        if (size == null) {
            throw new NullPointerException("Null size");
        }
        this.f11377c = size;
        if (b10 == null) {
            throw new NullPointerException("Null dynamicRange");
        }
        this.f11378d = b10;
        if (list == null) {
            throw new NullPointerException("Null captureTypes");
        }
        this.f11379e = list;
        this.f11380f = config;
        this.f11381g = i11;
        if (range == null) {
            throw new NullPointerException("Null targetFrameRate");
        }
        this.f11382h = range;
        this.f11383i = z10;
        this.f11384j = i12;
    }

    @Override // androidx.camera.core.impl.b
    public List<UseCaseConfigFactory.CaptureType> b() {
        return this.f11379e;
    }

    @Override // androidx.camera.core.impl.b
    public int c() {
        return this.f11384j;
    }

    @Override // androidx.camera.core.impl.b
    public B d() {
        return this.f11378d;
    }

    @Override // androidx.camera.core.impl.b
    public int e() {
        return this.f11376b;
    }

    public boolean equals(Object obj) {
        Config config;
        if (obj == this) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (this.f11375a.equals(bVar.i()) && this.f11376b == bVar.e() && this.f11377c.equals(bVar.h()) && this.f11378d.equals(bVar.d()) && this.f11379e.equals(bVar.b()) && ((config = this.f11380f) != null ? config.equals(bVar.f()) : bVar.f() == null) && this.f11381g == bVar.g() && this.f11382h.equals(bVar.j()) && this.f11383i == bVar.k() && this.f11384j == bVar.c()) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.camera.core.impl.b
    public Config f() {
        return this.f11380f;
    }

    @Override // androidx.camera.core.impl.b
    public int g() {
        return this.f11381g;
    }

    @Override // androidx.camera.core.impl.b
    public Size h() {
        return this.f11377c;
    }

    public int hashCode() {
        int iHashCode = (((((((((this.f11375a.hashCode() ^ 1000003) * 1000003) ^ this.f11376b) * 1000003) ^ this.f11377c.hashCode()) * 1000003) ^ this.f11378d.hashCode()) * 1000003) ^ this.f11379e.hashCode()) * 1000003;
        Config config = this.f11380f;
        return this.f11384j ^ ((((((((iHashCode ^ (config == null ? 0 : config.hashCode())) * 1000003) ^ this.f11381g) * 1000003) ^ this.f11382h.hashCode()) * 1000003) ^ (this.f11383i ? 1231 : 1237)) * 1000003);
    }

    @Override // androidx.camera.core.impl.b
    public SurfaceConfig i() {
        return this.f11375a;
    }

    @Override // androidx.camera.core.impl.b
    public Range<Integer> j() {
        return this.f11382h;
    }

    @Override // androidx.camera.core.impl.b
    public boolean k() {
        return this.f11383i;
    }

    public String toString() {
        return "AttachedSurfaceInfo{surfaceConfig=" + this.f11375a + ", imageFormat=" + this.f11376b + ", size=" + this.f11377c + ", dynamicRange=" + this.f11378d + ", captureTypes=" + this.f11379e + ", implementationOptions=" + this.f11380f + ", sessionType=" + this.f11381g + ", targetFrameRate=" + this.f11382h + ", strictFrameRateRequired=" + this.f11383i + ", customMaxFrameRate=" + this.f11384j + "}";
    }
}
