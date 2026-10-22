package j3;

import java.lang.reflect.Method;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: d, reason: collision with root package name */
    public static final b f9690d;

    /* renamed from: e, reason: collision with root package name */
    public static final RuntimeException f9691e;

    /* renamed from: a, reason: collision with root package name */
    public final Method f9692a;

    /* renamed from: b, reason: collision with root package name */
    public final Method f9693b;

    /* renamed from: c, reason: collision with root package name */
    public final Method f9694c;

    static {
        b bVar = null;
        try {
            e = null;
            bVar = new b();
        } catch (RuntimeException e10) {
            e = e10;
        }
        f9690d = bVar;
        f9691e = e;
    }

    public b() throws ClassNotFoundException {
        try {
            this.f9692a = Class.class.getMethod("getRecordComponents", null);
            Class<?> cls = Class.forName("java.lang.reflect.RecordComponent");
            this.f9693b = cls.getMethod("getName", null);
            this.f9694c = cls.getMethod("getType", null);
        } catch (Exception e10) {
            throw new RuntimeException(ai.onnxruntime.a.l("Failed to access Methods needed to support `java.lang.Record`: (", e10.getClass().getName(), ") ", e10.getMessage()), e10);
        }
    }

    public final Object[] a(Class<?> cls) {
        try {
            return (Object[]) this.f9692a.invoke(cls, null);
        } catch (Exception unused) {
            throw new IllegalArgumentException("Failed to access RecordComponents of type " + com.fasterxml.jackson.databind.util.a.y(cls));
        }
    }
}
