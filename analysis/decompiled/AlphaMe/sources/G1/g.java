package G1;

import F1.A;
import F1.B;
import com.google.gson.reflect.TypeToken;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class g implements B, Cloneable {

    /* renamed from: c, reason: collision with root package name */
    public static final g f599c;

    /* renamed from: a, reason: collision with root package name */
    public List f600a;

    /* renamed from: b, reason: collision with root package name */
    public List f601b;

    static {
        g gVar = new g();
        gVar.f600a = Collections.emptyList();
        gVar.f601b = Collections.emptyList();
        f599c = gVar;
    }

    public static boolean c(Class cls) {
        return !Enum.class.isAssignableFrom(cls) && (cls.getModifiers() & 8) == 0 && (cls.isAnonymousClass() || cls.isLocalClass());
    }

    @Override // F1.B
    public final A a(F1.n nVar, TypeToken typeToken) {
        boolean z4;
        boolean z5;
        boolean zC = c(typeToken.getRawType());
        if (zC) {
            z4 = true;
        } else {
            b(true);
            z4 = false;
        }
        if (zC) {
            z5 = true;
        } else {
            b(false);
            z5 = false;
        }
        if (z4 || z5) {
            return new f(this, z5, z4, nVar, typeToken);
        }
        return null;
    }

    public final void b(boolean z4) {
        Iterator it = (z4 ? this.f600a : this.f601b).iterator();
        if (it.hasNext()) {
            B0.g.y(it.next());
            throw null;
        }
    }

    public final Object clone() {
        try {
            return (g) super.clone();
        } catch (CloneNotSupportedException e4) {
            throw new AssertionError(e4);
        }
    }
}
