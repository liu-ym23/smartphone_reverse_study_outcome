package com.fasterxml.jackson.databind.ser.impl;

import b3.h;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import java.util.Arrays;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class a {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: com.fasterxml.jackson.databind.ser.impl.a$a, reason: collision with other inner class name */
    public static final class C0033a extends a {

        /* renamed from: a, reason: collision with root package name */
        public final Class<?> f4330a;

        /* renamed from: b, reason: collision with root package name */
        public final Class<?> f4331b;

        /* renamed from: c, reason: collision with root package name */
        public final b3.f<Object> f4332c;

        /* renamed from: d, reason: collision with root package name */
        public final b3.f<Object> f4333d;

        public C0033a(e eVar, Class cls, b3.f fVar, Class cls2, b3.f fVar2) {
            this.f4330a = cls;
            this.f4332c = fVar;
            this.f4331b = cls2;
            this.f4333d = fVar2;
        }

        @Override // com.fasterxml.jackson.databind.ser.impl.a
        public final a b(Class<?> cls, b3.f<Object> fVar) {
            return new c(this, new f[]{new f(this.f4330a, this.f4332c), new f(this.f4331b, this.f4333d), new f(cls, fVar)});
        }

        @Override // com.fasterxml.jackson.databind.ser.impl.a
        public final b3.f<Object> c(Class<?> cls) {
            if (cls == this.f4330a) {
                return this.f4332c;
            }
            if (cls == this.f4331b) {
                return this.f4333d;
            }
            return null;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class b extends a {

        /* renamed from: a, reason: collision with root package name */
        public static final b f4334a = new b();

        @Override // com.fasterxml.jackson.databind.ser.impl.a
        public final a b(Class<?> cls, b3.f<Object> fVar) {
            return new e(this, cls, fVar);
        }

        @Override // com.fasterxml.jackson.databind.ser.impl.a
        public final b3.f<Object> c(Class<?> cls) {
            return null;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class c extends a {

        /* renamed from: a, reason: collision with root package name */
        public final f[] f4335a;

        public c(a aVar, f[] fVarArr) {
            this.f4335a = fVarArr;
        }

        @Override // com.fasterxml.jackson.databind.ser.impl.a
        public final a b(Class<?> cls, b3.f<Object> fVar) {
            f[] fVarArr = this.f4335a;
            int length = fVarArr.length;
            if (length == 8) {
                return this;
            }
            f[] fVarArr2 = (f[]) Arrays.copyOf(fVarArr, length + 1);
            fVarArr2[length] = new f(cls, fVar);
            return new c(this, fVarArr2);
        }

        @Override // com.fasterxml.jackson.databind.ser.impl.a
        public final b3.f<Object> c(Class<?> cls) {
            f[] fVarArr = this.f4335a;
            f fVar = fVarArr[0];
            if (fVar.f4340a == cls) {
                return fVar.f4341b;
            }
            f fVar2 = fVarArr[1];
            if (fVar2.f4340a == cls) {
                return fVar2.f4341b;
            }
            f fVar3 = fVarArr[2];
            if (fVar3.f4340a == cls) {
                return fVar3.f4341b;
            }
            switch (fVarArr.length) {
                case 8:
                    f fVar4 = fVarArr[7];
                    if (fVar4.f4340a == cls) {
                        return fVar4.f4341b;
                    }
                case 7:
                    f fVar5 = fVarArr[6];
                    if (fVar5.f4340a == cls) {
                        return fVar5.f4341b;
                    }
                case 6:
                    f fVar6 = fVarArr[5];
                    if (fVar6.f4340a == cls) {
                        return fVar6.f4341b;
                    }
                case 5:
                    f fVar7 = fVarArr[4];
                    if (fVar7.f4340a == cls) {
                        return fVar7.f4341b;
                    }
                case 4:
                    f fVar8 = fVarArr[3];
                    if (fVar8.f4340a == cls) {
                        return fVar8.f4341b;
                    }
                    return null;
                default:
                    return null;
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public final b3.f<Object> f4336a;

        /* renamed from: b, reason: collision with root package name */
        public final a f4337b;

        public d(b3.f<Object> fVar, a aVar) {
            this.f4336a = fVar;
            this.f4337b = aVar;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class e extends a {

        /* renamed from: a, reason: collision with root package name */
        public final Class<?> f4338a;

        /* renamed from: b, reason: collision with root package name */
        public final b3.f<Object> f4339b;

        public e(a aVar, Class<?> cls, b3.f<Object> fVar) {
            this.f4338a = cls;
            this.f4339b = fVar;
        }

        @Override // com.fasterxml.jackson.databind.ser.impl.a
        public final a b(Class<?> cls, b3.f<Object> fVar) {
            return new C0033a(this, this.f4338a, this.f4339b, cls, fVar);
        }

        @Override // com.fasterxml.jackson.databind.ser.impl.a
        public final b3.f<Object> c(Class<?> cls) {
            if (cls == this.f4338a) {
                return this.f4339b;
            }
            return null;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class f {

        /* renamed from: a, reason: collision with root package name */
        public final Class<?> f4340a;

        /* renamed from: b, reason: collision with root package name */
        public final b3.f<Object> f4341b;

        public f(Class<?> cls, b3.f<Object> fVar) {
            this.f4340a = cls;
            this.f4341b = fVar;
        }
    }

    public final d a(JavaType javaType, h hVar, BeanProperty beanProperty) {
        b3.f<Object> fVarQ = hVar.q(javaType, beanProperty);
        return new d(fVarQ, b(javaType.f3690a, fVarQ));
    }

    public abstract a b(Class<?> cls, b3.f<Object> fVar);

    public abstract b3.f<Object> c(Class<?> cls);
}
