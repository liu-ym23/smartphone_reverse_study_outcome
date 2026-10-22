package Y;

import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.t;
import androidx.camera.core.impl.u;
import androidx.camera.core.impl.v;
import androidx.camera.core.impl.z;
import java.util.UUID;

/* loaded from: classes.dex */
public class g implements z.b<f, h, g> {

    /* renamed from: a, reason: collision with root package name */
    public final u f6958a;

    public g() {
        this(u.k0());
    }

    @Override // D.C
    public t a() {
        return this.f6958a;
    }

    @Override // androidx.camera.core.impl.z.b
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public h d() {
        return new h(v.j0(this.f6958a));
    }

    public g c(UseCaseConfigFactory.CaptureType captureType) {
        a().t(z.f11551L, captureType);
        return this;
    }

    public g e(Class<f> cls) {
        a().t(P.m.f5354c, cls);
        if (a().g(P.m.f5353b, null) == null) {
            f(cls.getCanonicalName() + O6.l.DATE_SEPARATOR + UUID.randomUUID());
        }
        return this;
    }

    public g f(String str) {
        a().t(P.m.f5353b, str);
        return this;
    }

    public g(u uVar) {
        this.f6958a = uVar;
        Class cls = (Class) uVar.g(P.m.f5354c, null);
        if (cls == null || cls.equals(f.class)) {
            c(UseCaseConfigFactory.CaptureType.STREAM_SHARING);
            e(f.class);
            return;
        }
        throw new IllegalArgumentException("Invalid target class configuration for " + this + ": " + cls);
    }
}
