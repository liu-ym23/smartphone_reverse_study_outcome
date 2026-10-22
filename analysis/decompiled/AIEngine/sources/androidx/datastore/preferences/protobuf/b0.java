package androidx.datastore.preferences.protobuf;

import java.nio.charset.Charset;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b0 {

    /* renamed from: b, reason: collision with root package name */
    public static final a f1783b = new a();

    /* renamed from: a, reason: collision with root package name */
    public final b f1784a;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a implements h0 {
        @Override // androidx.datastore.preferences.protobuf.h0
        public final g0 a(Class<?> cls) {
            throw new IllegalStateException("This should never be called.");
        }

        @Override // androidx.datastore.preferences.protobuf.h0
        public final boolean b(Class<?> cls) {
            return false;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class b implements h0 {

        /* renamed from: a, reason: collision with root package name */
        public h0[] f1785a;

        @Override // androidx.datastore.preferences.protobuf.h0
        public final g0 a(Class<?> cls) {
            for (h0 h0Var : this.f1785a) {
                if (h0Var.b(cls)) {
                    return h0Var.a(cls);
                }
            }
            throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
        }

        @Override // androidx.datastore.preferences.protobuf.h0
        public final boolean b(Class<?> cls) {
            for (h0 h0Var : this.f1785a) {
                if (h0Var.b(cls)) {
                    return true;
                }
            }
            return false;
        }
    }

    public b0() {
        h0 h0Var;
        try {
            h0Var = (h0) Class.forName("androidx.datastore.preferences.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", null).invoke(null, null);
        } catch (Exception unused) {
            h0Var = f1783b;
        }
        h0[] h0VarArr = {s.f1879a, h0Var};
        b bVar = new b();
        bVar.f1785a = h0VarArr;
        Charset charset = u.f1888a;
        this.f1784a = bVar;
    }
}
