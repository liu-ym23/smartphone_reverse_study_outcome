package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: androidx.datastore.preferences.protobuf.n, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1351n {

    /* renamed from: b, reason: collision with root package name */
    public static boolean f13619b = true;

    /* renamed from: d, reason: collision with root package name */
    public static volatile C1351n f13621d;

    /* renamed from: a, reason: collision with root package name */
    public final Map<a, GeneratedMessageLite.e<?, ?>> f13623a;

    /* renamed from: c, reason: collision with root package name */
    public static final Class<?> f13620c = c();

    /* renamed from: e, reason: collision with root package name */
    public static final C1351n f13622e = new C1351n(true);

    /* renamed from: androidx.datastore.preferences.protobuf.n$a */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final Object f13624a;

        /* renamed from: b, reason: collision with root package name */
        public final int f13625b;

        public a(Object obj, int i10) {
            this.f13624a = obj;
            this.f13625b = i10;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f13624a == aVar.f13624a && this.f13625b == aVar.f13625b;
        }

        public int hashCode() {
            return (System.identityHashCode(this.f13624a) * 65535) + this.f13625b;
        }
    }

    public C1351n() {
        this.f13623a = new HashMap();
    }

    public static C1351n b() {
        C1351n c1351nA;
        C1351n c1351n = f13621d;
        if (c1351n != null) {
            return c1351n;
        }
        synchronized (C1351n.class) {
            try {
                c1351nA = f13621d;
                if (c1351nA == null) {
                    c1351nA = f13619b ? C1350m.a() : f13622e;
                    f13621d = c1351nA;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return c1351nA;
    }

    public static Class<?> c() {
        try {
            return Class.forName("androidx.datastore.preferences.protobuf.Extension");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public <ContainingType extends K> GeneratedMessageLite.e<ContainingType, ?> a(ContainingType containingtype, int i10) {
        return (GeneratedMessageLite.e) this.f13623a.get(new a(containingtype, i10));
    }

    public C1351n(boolean z10) {
        this.f13623a = Collections.EMPTY_MAP;
    }
}
