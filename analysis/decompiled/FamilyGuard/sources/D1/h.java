package D1;

import A1.t;
import A1.u;
import java.io.IOException;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class h extends t<Object> {

    /* renamed from: b, reason: collision with root package name */
    public static final u f1069b = new a();

    /* renamed from: a, reason: collision with root package name */
    private final A1.e f1070a;

    static class a implements u {
        a() {
        }

        @Override // A1.u
        public <T> t<T> b(A1.e eVar, com.google.gson.reflect.a<T> aVar) {
            if (aVar.getRawType() == Object.class) {
                return new h(eVar);
            }
            return null;
        }
    }

    static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f1071a;

        static {
            int[] iArr = new int[G1.b.values().length];
            f1071a = iArr;
            try {
                iArr[G1.b.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1071a[G1.b.BEGIN_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1071a[G1.b.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1071a[G1.b.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1071a[G1.b.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1071a[G1.b.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    h(A1.e eVar) {
        this.f1070a = eVar;
    }

    @Override // A1.t
    public Object b(G1.a aVar) throws IOException {
        switch (b.f1071a[aVar.V().ordinal()]) {
            case 1:
                ArrayList arrayList = new ArrayList();
                aVar.a();
                while (aVar.w()) {
                    arrayList.add(b(aVar));
                }
                aVar.r();
                return arrayList;
            case 2:
                C1.h hVar = new C1.h();
                aVar.c();
                while (aVar.w()) {
                    hVar.put(aVar.L(), b(aVar));
                }
                aVar.u();
                return hVar;
            case 3:
                return aVar.T();
            case 4:
                return Double.valueOf(aVar.E());
            case 5:
                return Boolean.valueOf(aVar.D());
            case 6:
                aVar.O();
                return null;
            default:
                throw new IllegalStateException();
        }
    }

    @Override // A1.t
    public void d(G1.c cVar, Object obj) throws IOException {
        if (obj == null) {
            cVar.D();
            return;
        }
        t tVarL = this.f1070a.l(obj.getClass());
        if (!(tVarL instanceof h)) {
            tVarL.d(cVar, obj);
        } else {
            cVar.m();
            cVar.u();
        }
    }
}
