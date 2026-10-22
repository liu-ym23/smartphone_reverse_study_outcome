package o7;

import java.lang.invoke.VarHandle;
import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d implements m7.o, Cloneable {

    /* renamed from: g, reason: collision with root package name */
    public static final d f9247g = new d();

    /* renamed from: c, reason: collision with root package name */
    public final List f9248c;

    /* renamed from: f, reason: collision with root package name */
    public final List f9249f;

    public d() {
        List list = Collections.EMPTY_LIST;
        this.f9248c = list;
        this.f9249f = list;
    }

    @Override // m7.o
    public final m7.n a(m7.e eVar, t7.a aVar) {
        Class rawType = aVar.getRawType();
        boolean zB = b(rawType, true);
        boolean zB2 = b(rawType, false);
        if (!zB && !zB2) {
            return null;
        }
        c cVar = new c();
        cVar.f9246f = this;
        cVar.f9242b = zB2;
        cVar.f9243c = zB;
        cVar.f9244d = eVar;
        cVar.f9245e = aVar;
        VarHandle.storeStoreFence();
        return cVar;
    }

    public final boolean b(Class cls, boolean z10) {
        if (!z10 && !Enum.class.isAssignableFrom(cls)) {
            ac.a aVar = r7.c.f10473a;
            if (!Modifier.isStatic(cls.getModifiers()) && (cls.isAnonymousClass() || cls.isLocalClass())) {
                return true;
            }
        }
        Iterator it = (z10 ? this.f9248c : this.f9249f).iterator();
        if (it.hasNext()) {
            throw androidx.activity.b.g(it);
        }
        return false;
    }

    public final Object clone() {
        try {
            return (d) super.clone();
        } catch (CloneNotSupportedException e10) {
            throw new AssertionError(e10);
        }
    }
}
