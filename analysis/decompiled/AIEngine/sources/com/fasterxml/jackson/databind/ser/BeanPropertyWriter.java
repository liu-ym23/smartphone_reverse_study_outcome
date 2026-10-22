package com.fasterxml.jackson.databind.ser;

import b3.f;
import b3.h;
import c3.a;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.io.SerializedString;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import com.fasterxml.jackson.databind.introspect.AnnotatedField;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.ser.impl.a;
import com.fasterxml.jackson.databind.ser.std.BeanSerializerBase;
import com.fasterxml.jackson.databind.util.NameTransformer;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import k3.e;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@a
/* loaded from: classes.dex */
public class BeanPropertyWriter extends PropertyWriter implements Serializable {

    /* renamed from: c, reason: collision with root package name */
    public final SerializedString f4290c;

    /* renamed from: d, reason: collision with root package name */
    public final PropertyName f4291d;

    /* renamed from: e, reason: collision with root package name */
    public final JavaType f4292e;
    public final JavaType h;

    /* renamed from: j, reason: collision with root package name */
    public JavaType f4293j;

    /* renamed from: k, reason: collision with root package name */
    public final AnnotatedMember f4294k;

    /* renamed from: l, reason: collision with root package name */
    public transient Method f4295l;

    /* renamed from: m, reason: collision with root package name */
    public transient Field f4296m;

    /* renamed from: n, reason: collision with root package name */
    public f<Object> f4297n;

    /* renamed from: o, reason: collision with root package name */
    public f<Object> f4298o;

    /* renamed from: p, reason: collision with root package name */
    public e f4299p;

    /* renamed from: q, reason: collision with root package name */
    public transient com.fasterxml.jackson.databind.ser.impl.a f4300q;
    public final boolean r;

    /* renamed from: s, reason: collision with root package name */
    public final Object f4301s;

    /* renamed from: t, reason: collision with root package name */
    public final Class<?>[] f4302t;

    /* renamed from: u, reason: collision with root package name */
    public final transient HashMap<Object, Object> f4303u;

    public BeanPropertyWriter(i3.e eVar, AnnotatedMember annotatedMember, q3.a aVar, JavaType javaType, f<?> fVar, e eVar2, JavaType javaType2, boolean z, Object obj, Class<?>[] clsArr) {
        super(eVar.c());
        this.f4294k = annotatedMember;
        this.f4290c = new SerializedString(eVar.getName());
        eVar.u();
        this.f4291d = null;
        this.f4292e = javaType;
        this.f4297n = fVar;
        this.f4300q = fVar == null ? a.b.f4334a : null;
        this.f4299p = eVar2;
        this.h = javaType2;
        if (annotatedMember instanceof AnnotatedField) {
            this.f4295l = null;
            this.f4296m = ((AnnotatedField) annotatedMember).f4118c;
        } else if (annotatedMember instanceof AnnotatedMethod) {
            this.f4295l = ((AnnotatedMethod) annotatedMember).f4124d;
            this.f4296m = null;
        } else {
            this.f4295l = null;
            this.f4296m = null;
        }
        this.r = z;
        this.f4301s = obj;
        this.f4298o = null;
        this.f4302t = clsArr;
    }

    @Override // com.fasterxml.jackson.databind.BeanProperty
    public final PropertyName b() {
        return new PropertyName(this.f4290c.f3610a, null);
    }

    @Override // com.fasterxml.jackson.databind.BeanProperty
    public final AnnotatedMember d() {
        return this.f4294k;
    }

    public f<Object> f(com.fasterxml.jackson.databind.ser.impl.a aVar, Class<?> cls, h hVar) {
        a.d dVar;
        JavaType javaType = this.f4293j;
        if (javaType != null) {
            JavaType javaTypeO = hVar.o(javaType, cls);
            aVar.getClass();
            f<Object> fVarU = hVar.u(javaTypeO, this);
            dVar = new a.d(fVarU, aVar.b(javaTypeO.f3690a, fVarU));
        } else {
            aVar.getClass();
            f<Object> fVarV = hVar.v(cls, this);
            dVar = new a.d(fVarV, aVar.b(cls, fVarV));
        }
        com.fasterxml.jackson.databind.ser.impl.a aVar2 = dVar.f4337b;
        if (aVar != aVar2) {
            this.f4300q = aVar2;
        }
        return dVar.f4336a;
    }

    public final boolean g(JsonGenerator jsonGenerator, h hVar, f fVar) throws InvalidDefinitionException {
        if (fVar.i()) {
            return false;
        }
        if (hVar.f3044a.q(SerializationFeature.FAIL_ON_SELF_REFERENCES)) {
            if (!(fVar instanceof BeanSerializerBase)) {
                return false;
            }
            hVar.j("Direct self-reference leading to cycle");
            throw null;
        }
        if (!hVar.f3044a.q(SerializationFeature.WRITE_SELF_REFERENCES_AS_NULL)) {
            return false;
        }
        if (this.f4298o == null) {
            return true;
        }
        if (!jsonGenerator.K().d()) {
            jsonGenerator.I0(this.f4290c);
        }
        this.f4298o.f(null, jsonGenerator, hVar);
        return true;
    }

    @Override // q3.k
    public final String getName() {
        return this.f4290c.f3610a;
    }

    @Override // com.fasterxml.jackson.databind.BeanProperty
    public final JavaType getType() {
        return this.f4292e;
    }

    public void h(f<Object> fVar) {
        f<Object> fVar2 = this.f4298o;
        if (fVar2 != null && fVar2 != fVar) {
            throw new IllegalStateException(ai.onnxruntime.a.l("Cannot override _nullSerializer: had a ", com.fasterxml.jackson.databind.util.a.f(this.f4298o), ", trying to set to ", com.fasterxml.jackson.databind.util.a.f(fVar)));
        }
        this.f4298o = fVar;
    }

    public void i(f<Object> fVar) {
        f<Object> fVar2 = this.f4297n;
        if (fVar2 != null && fVar2 != fVar) {
            throw new IllegalStateException(ai.onnxruntime.a.l("Cannot override _serializer: had a ", com.fasterxml.jackson.databind.util.a.f(this.f4297n), ", trying to set to ", com.fasterxml.jackson.databind.util.a.f(fVar)));
        }
        this.f4297n = fVar;
    }

    public BeanPropertyWriter j(NameTransformer nameTransformer) {
        SerializedString serializedString = this.f4290c;
        String strA = nameTransformer.a(serializedString.f3610a);
        return strA.equals(serializedString.f3610a) ? this : new BeanPropertyWriter(this, PropertyName.a(strA));
    }

    public void k(Object obj, JsonGenerator jsonGenerator, h hVar) {
        Method method = this.f4295l;
        Object objInvoke = method == null ? this.f4296m.get(obj) : method.invoke(obj, null);
        if (objInvoke == null) {
            f<Object> fVar = this.f4298o;
            if (fVar != null) {
                fVar.f(null, jsonGenerator, hVar);
                return;
            } else {
                jsonGenerator.J0();
                return;
            }
        }
        f<Object> fVarF = this.f4297n;
        if (fVarF == null) {
            Class<?> cls = objInvoke.getClass();
            com.fasterxml.jackson.databind.ser.impl.a aVar = this.f4300q;
            f<Object> fVarC = aVar.c(cls);
            fVarF = fVarC == null ? f(aVar, cls, hVar) : fVarC;
        }
        Object obj2 = this.f4301s;
        if (obj2 != null) {
            if (JsonInclude.Include.f3466c == obj2) {
                if (fVarF.d(hVar, objInvoke)) {
                    m(jsonGenerator, hVar);
                    return;
                }
            } else if (obj2.equals(objInvoke)) {
                m(jsonGenerator, hVar);
                return;
            }
        }
        if (objInvoke == obj && g(jsonGenerator, hVar, fVarF)) {
            return;
        }
        e eVar = this.f4299p;
        if (eVar == null) {
            fVarF.f(objInvoke, jsonGenerator, hVar);
        } else {
            fVarF.g(objInvoke, jsonGenerator, hVar, eVar);
        }
    }

    public void l(Object obj, JsonGenerator jsonGenerator, h hVar) {
        Method method = this.f4295l;
        Object objInvoke = method == null ? this.f4296m.get(obj) : method.invoke(obj, null);
        SerializedString serializedString = this.f4290c;
        if (objInvoke == null) {
            if (this.f4298o != null) {
                jsonGenerator.I0(serializedString);
                this.f4298o.f(null, jsonGenerator, hVar);
                return;
            }
            return;
        }
        f<Object> fVarF = this.f4297n;
        if (fVarF == null) {
            Class<?> cls = objInvoke.getClass();
            com.fasterxml.jackson.databind.ser.impl.a aVar = this.f4300q;
            f<Object> fVarC = aVar.c(cls);
            fVarF = fVarC == null ? f(aVar, cls, hVar) : fVarC;
        }
        Object obj2 = this.f4301s;
        if (obj2 != null) {
            if (JsonInclude.Include.f3466c == obj2) {
                if (fVarF.d(hVar, objInvoke)) {
                    return;
                }
            } else if (obj2.equals(objInvoke)) {
                return;
            }
        }
        if (objInvoke == obj && g(jsonGenerator, hVar, fVarF)) {
            return;
        }
        jsonGenerator.I0(serializedString);
        e eVar = this.f4299p;
        if (eVar == null) {
            fVarF.f(objInvoke, jsonGenerator, hVar);
        } else {
            fVarF.g(objInvoke, jsonGenerator, hVar, eVar);
        }
    }

    public final void m(JsonGenerator jsonGenerator, h hVar) {
        f<Object> fVar = this.f4298o;
        if (fVar != null) {
            fVar.f(null, jsonGenerator, hVar);
        } else {
            jsonGenerator.J0();
        }
    }

    public Object readResolve() {
        AnnotatedMember annotatedMember = this.f4294k;
        if (annotatedMember instanceof AnnotatedField) {
            this.f4295l = null;
            this.f4296m = (Field) annotatedMember.j();
        } else if (annotatedMember instanceof AnnotatedMethod) {
            this.f4295l = (Method) annotatedMember.j();
            this.f4296m = null;
        }
        if (this.f4297n == null) {
            this.f4300q = a.b.f4334a;
        }
        return this;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder(40);
        sb2.append("property '");
        sb2.append(this.f4290c.f3610a);
        sb2.append("' (");
        if (this.f4295l != null) {
            sb2.append("via method ");
            sb2.append(this.f4295l.getDeclaringClass().getName());
            sb2.append("#");
            sb2.append(this.f4295l.getName());
        } else if (this.f4296m != null) {
            sb2.append("field \"");
            sb2.append(this.f4296m.getDeclaringClass().getName());
            sb2.append("#");
            sb2.append(this.f4296m.getName());
        } else {
            sb2.append("virtual");
        }
        f<Object> fVar = this.f4297n;
        if (fVar == null) {
            sb2.append(", no static serializer");
        } else {
            sb2.append(", static serializer of type ".concat(fVar.getClass().getName()));
        }
        sb2.append(')');
        return sb2.toString();
    }

    public BeanPropertyWriter(BeanPropertyWriter beanPropertyWriter, SerializedString serializedString) {
        super(beanPropertyWriter);
        this.f4290c = serializedString;
        this.f4291d = beanPropertyWriter.f4291d;
        this.f4294k = beanPropertyWriter.f4294k;
        this.f4292e = beanPropertyWriter.f4292e;
        this.f4295l = beanPropertyWriter.f4295l;
        this.f4296m = beanPropertyWriter.f4296m;
        this.f4297n = beanPropertyWriter.f4297n;
        this.f4298o = beanPropertyWriter.f4298o;
        if (beanPropertyWriter.f4303u != null) {
            this.f4303u = new HashMap<>(beanPropertyWriter.f4303u);
        }
        this.h = beanPropertyWriter.h;
        this.f4300q = beanPropertyWriter.f4300q;
        this.r = beanPropertyWriter.r;
        this.f4301s = beanPropertyWriter.f4301s;
        this.f4302t = beanPropertyWriter.f4302t;
        this.f4299p = beanPropertyWriter.f4299p;
        this.f4293j = beanPropertyWriter.f4293j;
    }

    public BeanPropertyWriter(BeanPropertyWriter beanPropertyWriter, PropertyName propertyName) {
        super(beanPropertyWriter);
        this.f4290c = new SerializedString(propertyName.f3755a);
        this.f4291d = beanPropertyWriter.f4291d;
        this.f4292e = beanPropertyWriter.f4292e;
        this.f4294k = beanPropertyWriter.f4294k;
        this.f4295l = beanPropertyWriter.f4295l;
        this.f4296m = beanPropertyWriter.f4296m;
        this.f4297n = beanPropertyWriter.f4297n;
        this.f4298o = beanPropertyWriter.f4298o;
        if (beanPropertyWriter.f4303u != null) {
            this.f4303u = new HashMap<>(beanPropertyWriter.f4303u);
        }
        this.h = beanPropertyWriter.h;
        this.f4300q = beanPropertyWriter.f4300q;
        this.r = beanPropertyWriter.r;
        this.f4301s = beanPropertyWriter.f4301s;
        this.f4302t = beanPropertyWriter.f4302t;
        this.f4299p = beanPropertyWriter.f4299p;
        this.f4293j = beanPropertyWriter.f4293j;
    }

    public BeanPropertyWriter() {
        super(PropertyMetadata.f3744m);
        this.f4294k = null;
        this.f4290c = null;
        this.f4291d = null;
        this.f4302t = null;
        this.f4292e = null;
        this.f4297n = null;
        this.f4300q = null;
        this.f4299p = null;
        this.h = null;
        this.f4295l = null;
        this.f4296m = null;
        this.r = false;
        this.f4301s = null;
        this.f4298o = null;
    }

    public BeanPropertyWriter(BeanPropertyWriter beanPropertyWriter) {
        this(beanPropertyWriter, beanPropertyWriter.f4290c);
    }
}
