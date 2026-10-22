package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.AbstractC0504y;
import androidx.exifinterface.media.ExifInterface;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: androidx.datastore.preferences.protobuf.p, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0496p {

    /* renamed from: b, reason: collision with root package name */
    private static boolean f10099b = true;

    /* renamed from: d, reason: collision with root package name */
    private static volatile C0496p f10101d;

    /* renamed from: a, reason: collision with root package name */
    private final Map<a, AbstractC0504y.e<?, ?>> f10103a;

    /* renamed from: c, reason: collision with root package name */
    private static final Class<?> f10100c = c();

    /* renamed from: e, reason: collision with root package name */
    static final C0496p f10102e = new C0496p(true);

    /* renamed from: androidx.datastore.preferences.protobuf.p$a */
    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final Object f10104a;

        /* renamed from: b, reason: collision with root package name */
        private final int f10105b;

        a(Object obj, int i5) {
            this.f10104a = obj;
            this.f10105b = i5;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f10104a == aVar.f10104a && this.f10105b == aVar.f10105b;
        }

        public int hashCode() {
            return (System.identityHashCode(this.f10104a) * ExifInterface.COLOR_SPACE_UNCALIBRATED) + this.f10105b;
        }
    }

    C0496p() {
        this.f10103a = new HashMap();
    }

    public static C0496p b() {
        C0496p c0496pA;
        C0496p c0496p = f10101d;
        if (c0496p != null) {
            return c0496p;
        }
        synchronized (C0496p.class) {
            try {
                c0496pA = f10101d;
                if (c0496pA == null) {
                    c0496pA = f10099b ? C0495o.a() : f10102e;
                    f10101d = c0496pA;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return c0496pA;
    }

    static Class<?> c() {
        try {
            return Class.forName("androidx.datastore.preferences.protobuf.Extension");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public <ContainingType extends S> AbstractC0504y.e<ContainingType, ?> a(ContainingType containingtype, int i5) {
        return (AbstractC0504y.e) this.f10103a.get(new a(containingtype, i5));
    }

    C0496p(boolean z5) {
        this.f10103a = Collections.EMPTY_MAP;
    }
}
