package f3;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.SettableAnyProperty;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public final f f8718a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f8719b;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a extends f {

        /* renamed from: c, reason: collision with root package name */
        public final SettableAnyProperty f8720c;

        /* renamed from: d, reason: collision with root package name */
        public final String f8721d;

        public a(f fVar, Object obj, SettableAnyProperty settableAnyProperty, String str) {
            super(fVar, obj);
            this.f8720c = settableAnyProperty;
            this.f8721d = str;
        }

        @Override // f3.f
        public final void a(Object obj) throws IllegalAccessException, JsonMappingException, IllegalArgumentException, InvocationTargetException {
            this.f8720c.c(obj, this.f8721d, this.f8719b);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class b extends f {

        /* renamed from: c, reason: collision with root package name */
        public final Object f8722c;

        public b(f fVar, Object obj, Object obj2) {
            super(fVar, obj);
            this.f8722c = obj2;
        }

        @Override // f3.f
        public final void a(Object obj) {
            ((Map) obj).put(this.f8722c, this.f8719b);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class c extends f {

        /* renamed from: c, reason: collision with root package name */
        public final SettableBeanProperty f8723c;

        public c(f fVar, Object obj, SettableBeanProperty settableBeanProperty) {
            super(fVar, obj);
            this.f8723c = settableBeanProperty;
        }

        @Override // f3.f
        public final void a(Object obj) {
            this.f8723c.z(obj, this.f8719b);
        }
    }

    public f(f fVar, Object obj) {
        this.f8718a = fVar;
        this.f8719b = obj;
    }

    public abstract void a(Object obj);
}
