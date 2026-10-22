package f5;

import com.google.gson.reflect.TypeToken;
import d5.u;
import d5.v;
import i5.a;
import java.io.IOException;
import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class e implements v, Cloneable {

    /* renamed from: c, reason: collision with root package name */
    public static final e f8742c = new e();

    /* renamed from: a, reason: collision with root package name */
    public final List<d5.a> f8743a;

    /* renamed from: b, reason: collision with root package name */
    public final List<d5.a> f8744b;

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a<T> extends u<T> {

        /* renamed from: a, reason: collision with root package name */
        public volatile u<T> f8745a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f8746b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f8747c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ d5.i f8748d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ TypeToken f8749e;

        public a(boolean z, boolean z3, d5.i iVar, TypeToken typeToken) {
            this.f8746b = z;
            this.f8747c = z3;
            this.f8748d = iVar;
            this.f8749e = typeToken;
        }

        @Override // d5.u
        public final T a(k5.a aVar) throws IOException {
            if (this.f8746b) {
                aVar.Y0();
                return null;
            }
            u<T> uVarF = this.f8745a;
            if (uVarF == null) {
                uVarF = this.f8748d.f(e.this, this.f8749e);
                this.f8745a = uVarF;
            }
            return uVarF.a(aVar);
        }

        @Override // d5.u
        public final void b(k5.b bVar, T t8) throws IOException {
            if (this.f8747c) {
                bVar.c0();
                return;
            }
            u<T> uVarF = this.f8745a;
            if (uVarF == null) {
                uVarF = this.f8748d.f(e.this, this.f8749e);
                this.f8745a = uVarF;
            }
            uVarF.b(bVar, t8);
        }
    }

    public e() {
        List<d5.a> list = Collections.EMPTY_LIST;
        this.f8743a = list;
        this.f8744b = list;
    }

    @Override // d5.v
    public final <T> u<T> b(d5.i iVar, TypeToken<T> typeToken) {
        Class<? super T> rawType = typeToken.getRawType();
        boolean zC = c(rawType, true);
        boolean zC2 = c(rawType, false);
        if (zC || zC2) {
            return new a(zC2, zC, iVar, typeToken);
        }
        return null;
    }

    public final boolean c(Class<?> cls, boolean z) {
        if (!z && !Enum.class.isAssignableFrom(cls)) {
            a.AbstractC0090a abstractC0090a = i5.a.f9539a;
            if (!Modifier.isStatic(cls.getModifiers()) && (cls.isAnonymousClass() || cls.isLocalClass())) {
                return true;
            }
        }
        Iterator<d5.a> it = (z ? this.f8743a : this.f8744b).iterator();
        while (it.hasNext()) {
            if (it.next().a()) {
                return true;
            }
        }
        return false;
    }

    public final Object clone() {
        try {
            return (e) super.clone();
        } catch (CloneNotSupportedException e10) {
            throw new AssertionError(e10);
        }
    }
}
