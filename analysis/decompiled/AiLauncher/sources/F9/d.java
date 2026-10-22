package F9;

import E9.W;
import F9.c;
import java.util.Map;
import ma.AbstractC4927g;
import ya.S;

/* loaded from: classes5.dex */
public class d implements c {

    /* renamed from: a, reason: collision with root package name */
    public final S f2600a;

    /* renamed from: b, reason: collision with root package name */
    public final Map<ga.e, AbstractC4927g<?>> f2601b;

    /* renamed from: c, reason: collision with root package name */
    public final W f2602c;

    public d(S s10, Map<ga.e, AbstractC4927g<?>> map, W w10) {
        if (s10 == null) {
            b(0);
        }
        if (map == null) {
            b(1);
        }
        if (w10 == null) {
            b(2);
        }
        this.f2600a = s10;
        this.f2601b = map;
        this.f2602c = w10;
    }

    public static /* synthetic */ void b(int i10) {
        String str = (i10 == 3 || i10 == 4 || i10 == 5) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i10 == 3 || i10 == 4 || i10 == 5) ? 2 : 3];
        if (i10 == 1) {
            objArr[0] = "valueArguments";
        } else if (i10 == 2) {
            objArr[0] = "source";
        } else if (i10 == 3 || i10 == 4 || i10 == 5) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptorImpl";
        } else {
            objArr[0] = "annotationType";
        }
        if (i10 == 3) {
            objArr[1] = "getType";
        } else if (i10 == 4) {
            objArr[1] = "getAllValueArguments";
        } else if (i10 != 5) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptorImpl";
        } else {
            objArr[1] = "getSource";
        }
        if (i10 != 3 && i10 != 4 && i10 != 5) {
            objArr[2] = "<init>";
        }
        String str2 = String.format(str, objArr);
        if (i10 != 3 && i10 != 4 && i10 != 5) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // F9.c
    public Map<ga.e, AbstractC4927g<?>> a() {
        Map<ga.e, AbstractC4927g<?>> map = this.f2601b;
        if (map == null) {
            b(4);
        }
        return map;
    }

    @Override // F9.c
    public W e() {
        W w10 = this.f2602c;
        if (w10 == null) {
            b(5);
        }
        return w10;
    }

    @Override // F9.c
    public ga.c f() {
        return c.a.a(this);
    }

    @Override // F9.c
    public S getType() {
        S s10 = this.f2600a;
        if (s10 == null) {
            b(3);
        }
        return s10;
    }

    public String toString() {
        return kotlin.reflect.jvm.internal.impl.renderer.b.f35917h.N(this, null);
    }
}
