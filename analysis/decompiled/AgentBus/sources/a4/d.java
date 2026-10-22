package a4;

import java.util.Collections;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class d implements g8.a, p9.d {

    /* renamed from: f, reason: collision with root package name */
    public final Object f172f;

    public d(g8.j jVar) {
        if (jVar != null) {
            this.f172f = jVar;
        } else {
            R(0);
            throw null;
        }
    }

    public static /* synthetic */ void R(int i2) {
        String str = i2 != 1 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i2 != 1 ? 3 : 2];
        if (i2 != 1) {
            objArr[0] = "annotations";
        } else {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotatedImpl";
        }
        if (i2 != 1) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotatedImpl";
        } else {
            objArr[1] = "getAnnotations";
        }
        if (i2 != 1) {
            objArr[2] = "<init>";
        }
        String str2 = String.format(str, objArr);
        if (i2 == 1) {
            throw new IllegalStateException(str2);
        }
    }

    public static /* synthetic */ void T(int i2) {
        String str = (i2 == 1 || i2 == 2) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i2 == 1 || i2 == 2) ? 2 : 3];
        if (i2 == 1 || i2 == 2) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/AbstractReceiverValue";
        } else {
            objArr[0] = "receiverType";
        }
        if (i2 == 1) {
            objArr[1] = "getType";
        } else if (i2 != 2) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/AbstractReceiverValue";
        } else {
            objArr[1] = "getOriginal";
        }
        if (i2 != 1 && i2 != 2) {
            objArr[2] = "<init>";
        }
        String str2 = String.format(str, objArr);
        if (i2 != 1 && i2 != 2) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public abstract com.google.crypto.tink.shaded.protobuf.a C0(com.google.crypto.tink.shaded.protobuf.h hVar);

    public abstract void D0(com.google.crypto.tink.shaded.protobuf.a aVar);

    @Override // g8.a
    public g8.j getAnnotations() {
        g8.j jVar = (g8.j) this.f172f;
        if (jVar != null) {
            return jVar;
        }
        R(1);
        throw null;
    }

    @Override // p9.d
    public v9.v getType() {
        v9.v vVar = (v9.v) this.f172f;
        if (vVar != null) {
            return vVar;
        }
        T(1);
        throw null;
    }

    public abstract com.google.crypto.tink.shaded.protobuf.a j0(com.google.crypto.tink.shaded.protobuf.a aVar);

    public Map u0() {
        return Collections.EMPTY_MAP;
    }

    public d(v9.v vVar) {
        if (vVar != null) {
            this.f172f = vVar;
        } else {
            T(0);
            throw null;
        }
    }

    public d(Class cls) {
        this.f172f = cls;
    }
}
