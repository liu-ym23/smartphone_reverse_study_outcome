package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class m {

    /* renamed from: b, reason: collision with root package name */
    public static volatile m f1862b;

    /* renamed from: c, reason: collision with root package name */
    public static final m f1863c;

    /* renamed from: a, reason: collision with root package name */
    public final Map<a, GeneratedMessageLite.e<?, ?>> f1864a;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final Object f1865a;

        /* renamed from: b, reason: collision with root package name */
        public final int f1866b;

        public a(int i10, i0 i0Var) {
            this.f1865a = i0Var;
            this.f1866b = i10;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f1865a == aVar.f1865a && this.f1866b == aVar.f1866b;
        }

        public final int hashCode() {
            return (System.identityHashCode(this.f1865a) * 65535) + this.f1866b;
        }
    }

    static {
        try {
            Class.forName("androidx.datastore.preferences.protobuf.Extension");
        } catch (ClassNotFoundException unused) {
        }
        f1863c = new m(0);
    }

    public m() {
        this.f1864a = new HashMap();
    }

    public static m a() {
        m mVar;
        m mVar2 = f1862b;
        if (mVar2 != null) {
            return mVar2;
        }
        synchronized (m.class) {
            try {
                mVar = f1862b;
                if (mVar == null) {
                    Class<?> cls = l.f1845a;
                    if (cls != null) {
                        try {
                            mVar = (m) cls.getDeclaredMethod("getEmptyRegistry", null).invoke(null, null);
                        } catch (Exception unused) {
                        }
                        f1862b = mVar;
                    } else {
                        mVar = f1863c;
                        f1862b = mVar;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return mVar;
    }

    public m(int i10) {
        this.f1864a = Collections.EMPTY_MAP;
    }
}
