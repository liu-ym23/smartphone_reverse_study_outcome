package g8;

import f8.n0;
import java.util.Map;
import v9.v;
import v9.z;

/* loaded from: classes.dex */
public final class d implements c {

    /* renamed from: a, reason: collision with root package name */
    public final v f3869a;

    /* renamed from: b, reason: collision with root package name */
    public final Map f3870b;

    /* renamed from: c, reason: collision with root package name */
    public final n0 f3871c;

    public d(z zVar, Map map, n0 n0Var) {
        if (zVar == null) {
            c(0);
            throw null;
        }
        if (map == null) {
            c(1);
            throw null;
        }
        this.f3869a = zVar;
        this.f3870b = map;
        this.f3871c = n0Var;
    }

    public static /* synthetic */ void c(int i2) {
        String str = (i2 == 3 || i2 == 4 || i2 == 5) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i2 == 3 || i2 == 4 || i2 == 5) ? 2 : 3];
        if (i2 == 1) {
            objArr[0] = "valueArguments";
        } else if (i2 == 2) {
            objArr[0] = "source";
        } else if (i2 == 3 || i2 == 4 || i2 == 5) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptorImpl";
        } else {
            objArr[0] = "annotationType";
        }
        if (i2 == 3) {
            objArr[1] = "getType";
        } else if (i2 == 4) {
            objArr[1] = "getAllValueArguments";
        } else if (i2 != 5) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptorImpl";
        } else {
            objArr[1] = "getSource";
        }
        if (i2 != 3 && i2 != 4 && i2 != 5) {
            objArr[2] = "<init>";
        }
        String str2 = String.format(str, objArr);
        if (i2 != 3 && i2 != 4 && i2 != 5) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // g8.c
    public final e9.c a() {
        return b.getFqName(this);
    }

    @Override // g8.c
    public final Map b() {
        Map map = this.f3870b;
        if (map != null) {
            return map;
        }
        c(4);
        throw null;
    }

    @Override // g8.c
    public final v getType() {
        v vVar = this.f3869a;
        if (vVar != null) {
            return vVar;
        }
        c(3);
        throw null;
    }

    @Override // g8.c
    public final n0 q() {
        n0 n0Var = this.f3871c;
        if (n0Var != null) {
            return n0Var;
        }
        c(5);
        throw null;
    }

    public final String toString() {
        return g9.g.f3939c.y(this, null);
    }
}
