package com.fasterxml.jackson.databind;

import b3.b;
import b3.c;
import b3.g;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.StreamReadCapability;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.cfg.CoercionAction;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.cfg.MutableCoercionConfig;
import com.fasterxml.jackson.databind.deser.DeserializerCache;
import com.fasterxml.jackson.databind.deser.ValueInstantiator;
import com.fasterxml.jackson.databind.deser.impl.TypeWrappedDeserializer;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.fasterxml.jackson.databind.exc.InvalidTypeIdException;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.fasterxml.jackson.databind.exc.ValueInstantiationException;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.type.LogicalType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.a;
import e3.e;
import e3.f;
import i3.d;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import q3.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class DeserializationContext extends b implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final DeserializerCache f3661a;

    /* renamed from: b, reason: collision with root package name */
    public final f f3662b;

    /* renamed from: c, reason: collision with root package name */
    public final DeserializationConfig f3663c;

    /* renamed from: d, reason: collision with root package name */
    public final int f3664d;

    /* renamed from: e, reason: collision with root package name */
    public final a3.f<StreamReadCapability> f3665e;
    public final transient w2.b h;

    /* renamed from: j, reason: collision with root package name */
    public transient q3.b f3666j;

    /* renamed from: k, reason: collision with root package name */
    public transient l f3667k;

    /* renamed from: l, reason: collision with root package name */
    public transient DateFormat f3668l;

    /* renamed from: m, reason: collision with root package name */
    public androidx.appcompat.widget.l f3669m;

    public DeserializationContext(f fVar) {
        if (fVar == null) {
            throw new NullPointerException("Cannot pass null DeserializerFactory");
        }
        this.f3662b = fVar;
        this.f3661a = new DeserializerCache();
        this.f3664d = 0;
        this.f3665e = null;
        this.f3663c = null;
    }

    public static void S(Class cls, w2.b bVar, JsonToken jsonToken) throws MismatchedInputException {
        throw new MismatchedInputException(bVar, "Trailing token (of type " + jsonToken + ") found after value (bound as " + a.y(cls) + "): not allowed as per `DeserializationFeature.FAIL_ON_TRAILING_TOKENS`");
    }

    public static MismatchedInputException X(w2.b bVar, JsonToken jsonToken, String str) {
        return new MismatchedInputException(bVar, b.a("Unexpected token (" + bVar.f13576c + "), expected " + jsonToken, str));
    }

    public final void A(JsonParser jsonParser, JavaType javaType) throws MismatchedInputException {
        B(javaType, jsonParser.K(), jsonParser, null, new Object[0]);
        throw null;
    }

    public final void B(JavaType javaType, JsonToken jsonToken, JsonParser jsonParser, String str, Object... objArr) throws MismatchedInputException {
        String str2;
        if (objArr.length > 0) {
            str = String.format(str, objArr);
        }
        this.f3663c.getClass();
        for (androidx.appcompat.widget.l lVar = null; lVar != null; lVar = (androidx.appcompat.widget.l) lVar.h) {
            ((e) lVar.f887g).getClass();
            javaType.getClass();
        }
        if (str == null) {
            String strR = a.r(javaType);
            if (jsonToken == null) {
                str = ai.onnxruntime.a.k("Unexpected end-of-input when trying read value of type ", strR);
            } else {
                switch (jsonToken.ordinal()) {
                    case 1:
                    case 2:
                    case 5:
                        str2 = "Object value";
                        break;
                    case 3:
                    case 4:
                        str2 = "Array value";
                        break;
                    case 6:
                        str2 = "Embedded Object";
                        break;
                    case 7:
                        str2 = "String value";
                        break;
                    case 8:
                        str2 = "Integer value";
                        break;
                    case 9:
                        str2 = "Floating-point value";
                        break;
                    case 10:
                    case 11:
                        str2 = "Boolean value";
                        break;
                    case 12:
                        str2 = "Null value";
                        break;
                    default:
                        str2 = "[Unavailable value]";
                        break;
                }
                StringBuilder sbS = ai.onnxruntime.a.s("Cannot deserialize value of type ", strR, " from ", str2, " (token `JsonToken.");
                sbS.append(jsonToken);
                sbS.append("`)");
                str = sbS.toString();
            }
        }
        if (jsonToken != null && jsonToken.f3600k) {
            jsonParser.V0();
        }
        R(str, new Object[0]);
        throw null;
    }

    public final void C(Class cls, JsonParser jsonParser) throws MismatchedInputException {
        B(k(cls), jsonParser.K(), jsonParser, null, new Object[0]);
        throw null;
    }

    public final void D(JavaType javaType, String str, String str2) throws InvalidTypeIdException {
        this.f3663c.getClass();
        for (androidx.appcompat.widget.l lVar = null; lVar != null; lVar = (androidx.appcompat.widget.l) lVar.h) {
            ((e) lVar.f887g).getClass();
        }
        if (J(DeserializationFeature.FAIL_ON_INVALID_SUBTYPE)) {
            throw f(javaType, str, str2);
        }
    }

    public final void E(Class cls, String str, String str2, Object... objArr) throws InvalidFormatException {
        if (objArr.length > 0) {
            str2 = String.format(str2, objArr);
        }
        this.f3663c.getClass();
        for (androidx.appcompat.widget.l lVar = null; lVar != null; lVar = (androidx.appcompat.widget.l) lVar.h) {
            ((e) lVar.f887g).getClass();
        }
        StringBuilder sbS = ai.onnxruntime.a.s("Cannot deserialize Map key of type ", a.y(cls), " from String ", b.b(str), ": ");
        sbS.append(str2);
        throw new InvalidFormatException(this.h, sbS.toString(), str);
    }

    public final void F(Class cls, Number number, String str, Object... objArr) throws InvalidFormatException {
        if (objArr.length > 0) {
            str = String.format(str, objArr);
        }
        this.f3663c.getClass();
        for (androidx.appcompat.widget.l lVar = null; lVar != null; lVar = (androidx.appcompat.widget.l) lVar.h) {
            ((e) lVar.f887g).getClass();
        }
        StringBuilder sbS = ai.onnxruntime.a.s("Cannot deserialize value of type ", a.y(cls), " from number ", String.valueOf(number), ": ");
        sbS.append(str);
        throw new InvalidFormatException(this.h, sbS.toString(), number);
    }

    public final void G(Class cls, String str, String str2, Object... objArr) throws InvalidFormatException {
        if (objArr.length > 0) {
            str2 = String.format(str2, objArr);
        }
        this.f3663c.getClass();
        for (androidx.appcompat.widget.l lVar = null; lVar != null; lVar = (androidx.appcompat.widget.l) lVar.h) {
            ((e) lVar.f887g).getClass();
        }
        throw W(str, cls, str2);
    }

    public final ValueInstantiationException H(Class cls, Throwable th) {
        String strI;
        if (th == null) {
            strI = "N/A";
        } else {
            strI = a.i(th);
            if (strI == null) {
                strI = a.y(th.getClass());
            }
        }
        String strL = ai.onnxruntime.a.l("Cannot construct instance of ", a.y(cls), ", problem: ", strI);
        k(cls);
        return new ValueInstantiationException(this.h, strL, th);
    }

    public final boolean I(StreamReadCapability streamReadCapability) {
        a3.f<StreamReadCapability> fVar = this.f3665e;
        fVar.getClass();
        return (fVar.f19a & streamReadCapability.b()) != 0;
    }

    public final boolean J(DeserializationFeature deserializationFeature) {
        return (this.f3664d & deserializationFeature.f3689b) != 0;
    }

    public abstract g K(Object obj);

    public final l L() {
        l lVar = this.f3667k;
        if (lVar == null) {
            return new l();
        }
        this.f3667k = null;
        return lVar;
    }

    public final Date M(String str) {
        try {
            DateFormat dateFormat = this.f3668l;
            if (dateFormat == null) {
                dateFormat = (DateFormat) this.f3663c.f3828b.h.clone();
                this.f3668l = dateFormat;
            }
            return dateFormat.parse(str);
        } catch (ParseException e10) {
            throw new IllegalArgumentException(ai.onnxruntime.a.l("Failed to parse Date value '", str, "': ", a.i(e10)));
        }
    }

    public final void N(d dVar, i3.e eVar, String str, Object... objArr) throws InvalidDefinitionException {
        if (objArr.length > 0) {
            str = String.format(str, objArr);
        }
        Annotation[] annotationArr = a.f4529a;
        StringBuilder sbS = ai.onnxruntime.a.s("Invalid definition for property ", a.c(eVar.getName()), " (of type ", a.y(dVar.f3041a.f3690a), "): ");
        sbS.append(str);
        throw new InvalidDefinitionException(this.h, sbS.toString());
    }

    public final void O(b3.a aVar, String str, Object... objArr) throws InvalidDefinitionException {
        if (objArr.length > 0) {
            str = String.format(str, objArr);
        }
        throw new InvalidDefinitionException(this.h, ai.onnxruntime.a.l("Invalid type definition for type ", a.y(aVar.f3041a.f3690a), ": ", str));
    }

    public final void P(c cVar, String str, Object... objArr) throws MismatchedInputException {
        if (objArr.length > 0) {
            str = String.format(str, objArr);
        }
        cVar.m();
        throw new MismatchedInputException(this.h, str);
    }

    public final void Q(BeanProperty beanProperty, String str, Object... objArr) throws MismatchedInputException {
        AnnotatedMember annotatedMemberD;
        if (objArr.length > 0) {
            str = String.format(str, objArr);
        }
        if (beanProperty != null) {
            beanProperty.getType();
        }
        MismatchedInputException mismatchedInputException = new MismatchedInputException(this.h, str, 0);
        if (beanProperty == null || (annotatedMemberD = beanProperty.d()) == null) {
            throw mismatchedInputException;
        }
        mismatchedInputException.f(new JsonMappingException.Reference(annotatedMemberD.h(), beanProperty.getName()));
        throw mismatchedInputException;
    }

    public final void R(String str, Object... objArr) throws MismatchedInputException {
        if (objArr.length > 0) {
            str = String.format(str, objArr);
        }
        throw new MismatchedInputException(this.h, str, 0);
    }

    public final void T(c<?> cVar, JsonToken jsonToken, String str, Object... objArr) throws MismatchedInputException {
        if (objArr.length > 0) {
            str = String.format(str, objArr);
        }
        cVar.m();
        throw X(this.h, jsonToken, str);
    }

    public final void U(JsonToken jsonToken, String str, Object... objArr) throws MismatchedInputException {
        if (objArr.length > 0) {
            str = String.format(str, objArr);
        }
        w2.b bVar = this.h;
        throw new MismatchedInputException(bVar, b.a("Unexpected token (" + bVar.f13576c + "), expected " + jsonToken, str), 0);
    }

    public final void V(l lVar) {
        l lVar2 = this.f3667k;
        if (lVar2 != null) {
            Object[] objArr = lVar.f11565d;
            int length = objArr == null ? 0 : objArr.length;
            Object[] objArr2 = lVar2.f11565d;
            if (length < (objArr2 != null ? objArr2.length : 0)) {
                return;
            }
        }
        this.f3667k = lVar;
    }

    public final InvalidFormatException W(String str, Class cls, String str2) {
        StringBuilder sbS = ai.onnxruntime.a.s("Cannot deserialize value of type ", a.y(cls), " from String ", b.b(str), ": ");
        sbS.append(str2);
        return new InvalidFormatException(this.h, sbS.toString(), str);
    }

    @Override // b3.b
    public final MapperConfig d() {
        return this.f3663c;
    }

    @Override // b3.b
    public final TypeFactory e() {
        return this.f3663c.f3828b.f3789a;
    }

    @Override // b3.b
    public final InvalidTypeIdException f(JavaType javaType, String str, String str2) {
        return new InvalidTypeIdException(this.h, b.a(ai.onnxruntime.a.l("Could not resolve type id '", str, "' as a subtype of ", a.r(javaType)), str2), 0);
    }

    @Override // b3.b
    public final Object j(String str) throws InvalidDefinitionException {
        throw new InvalidDefinitionException(this.h, str);
    }

    public final JavaType k(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        return this.f3663c.c(cls);
    }

    public abstract c l(Object obj);

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002a, code lost:
    
        if (r3.p(com.fasterxml.jackson.databind.DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT) != false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0035, code lost:
    
        if (r3.p(com.fasterxml.jackson.databind.DeserializationFeature.ACCEPT_FLOAT_AS_INT) != false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0073, code lost:
    
        if (r4 == com.fasterxml.jackson.databind.type.LogicalType.f4439p) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0077, code lost:
    
        return com.fasterxml.jackson.databind.cfg.CoercionAction.f3797b;
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0049 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x007e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.fasterxml.jackson.databind.cfg.CoercionAction m(com.fasterxml.jackson.databind.type.LogicalType r4, java.lang.Class<?> r5, com.fasterxml.jackson.databind.cfg.CoercionInputShape r6) {
        /*
            r3 = this;
            com.fasterxml.jackson.databind.DeserializationConfig r3 = r3.f3663c
            com.fasterxml.jackson.databind.cfg.CoercionConfigs r5 = r3.f3659o
            r5.getClass()
            com.fasterxml.jackson.databind.cfg.MutableCoercionConfig r0 = r5.f3804b
            com.fasterxml.jackson.databind.cfg.CoercionAction[] r0 = r0.f3802a
            int r1 = r6.ordinal()
            r0 = r0[r1]
            if (r0 == 0) goto L14
            return r0
        L14:
            int r0 = r6.ordinal()
            r1 = 2
            com.fasterxml.jackson.databind.type.LogicalType r2 = com.fasterxml.jackson.databind.type.LogicalType.h
            if (r0 == r1) goto L38
            r1 = 3
            if (r0 == r1) goto L2d
            r1 = 7
            if (r0 == r1) goto L24
            goto L45
        L24:
            com.fasterxml.jackson.databind.DeserializationFeature r4 = com.fasterxml.jackson.databind.DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT
            boolean r3 = r3.p(r4)
            if (r3 == 0) goto L78
            goto L7b
        L2d:
            if (r4 != r2) goto L45
            com.fasterxml.jackson.databind.DeserializationFeature r4 = com.fasterxml.jackson.databind.DeserializationFeature.ACCEPT_FLOAT_AS_INT
            boolean r3 = r3.p(r4)
            if (r3 == 0) goto L78
            goto L75
        L38:
            com.fasterxml.jackson.databind.type.LogicalType r0 = com.fasterxml.jackson.databind.type.LogicalType.f4435l
            if (r4 != r0) goto L45
            com.fasterxml.jackson.databind.DeserializationFeature r0 = com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_NUMBERS_FOR_ENUMS
            boolean r0 = r3.p(r0)
            if (r0 == 0) goto L45
            goto L78
        L45:
            com.fasterxml.jackson.databind.type.LogicalType r0 = com.fasterxml.jackson.databind.type.LogicalType.f4433j
            if (r4 == r0) goto L56
            if (r4 == r2) goto L56
            com.fasterxml.jackson.databind.type.LogicalType r0 = com.fasterxml.jackson.databind.type.LogicalType.f4434k
            if (r4 == r0) goto L56
            com.fasterxml.jackson.databind.type.LogicalType r0 = com.fasterxml.jackson.databind.type.LogicalType.f4438o
            if (r4 != r0) goto L54
            goto L56
        L54:
            r0 = 0
            goto L57
        L56:
            r0 = 1
        L57:
            if (r0 == 0) goto L62
            com.fasterxml.jackson.databind.MapperFeature r1 = com.fasterxml.jackson.databind.MapperFeature.ALLOW_COERCION_OF_SCALARS
            boolean r1 = r3.k(r1)
            if (r1 != 0) goto L62
            goto L78
        L62:
            com.fasterxml.jackson.databind.cfg.CoercionInputShape r1 = com.fasterxml.jackson.databind.cfg.CoercionInputShape.f3809e
            if (r6 != r1) goto L7e
            if (r0 != 0) goto L7b
            com.fasterxml.jackson.databind.DeserializationFeature r5 = com.fasterxml.jackson.databind.DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT
            boolean r3 = r3.p(r5)
            if (r3 == 0) goto L71
            goto L7b
        L71:
            com.fasterxml.jackson.databind.type.LogicalType r3 = com.fasterxml.jackson.databind.type.LogicalType.f4439p
            if (r4 != r3) goto L78
        L75:
            com.fasterxml.jackson.databind.cfg.CoercionAction r3 = com.fasterxml.jackson.databind.cfg.CoercionAction.f3797b
            return r3
        L78:
            com.fasterxml.jackson.databind.cfg.CoercionAction r3 = com.fasterxml.jackson.databind.cfg.CoercionAction.f3796a
            return r3
        L7b:
            com.fasterxml.jackson.databind.cfg.CoercionAction r3 = com.fasterxml.jackson.databind.cfg.CoercionAction.f3798c
            return r3
        L7e:
            com.fasterxml.jackson.databind.cfg.CoercionAction r3 = r5.f3803a
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.DeserializationContext.m(com.fasterxml.jackson.databind.type.LogicalType, java.lang.Class, com.fasterxml.jackson.databind.cfg.CoercionInputShape):com.fasterxml.jackson.databind.cfg.CoercionAction");
    }

    public final CoercionAction n(LogicalType logicalType, Class cls) {
        DeserializationConfig deserializationConfig = this.f3663c;
        MutableCoercionConfig mutableCoercionConfig = deserializationConfig.f3659o.f3804b;
        mutableCoercionConfig.getClass();
        Boolean bool = Boolean.FALSE;
        CoercionAction coercionAction = mutableCoercionConfig.f3802a[9];
        boolean zEquals = Boolean.TRUE.equals(bool);
        CoercionAction coercionAction2 = CoercionAction.f3796a;
        return !zEquals ? coercionAction2 : coercionAction != null ? coercionAction : deserializationConfig.p(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT) ? CoercionAction.f3798c : coercionAction2;
    }

    public final c<Object> o(JavaType javaType, BeanProperty beanProperty) {
        return z(this.f3661a.e(this, this.f3662b, javaType), beanProperty, javaType);
    }

    public final void p(Object obj) {
        Annotation[] annotationArr = a.f4529a;
        i(obj == null ? null : obj.getClass(), String.format("No 'injectableValues' configured, cannot inject value with id [%s]", obj));
        throw null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x010b, code lost:
    
        throw new java.lang.IllegalArgumentException("Unsuitable method (" + r6 + ") decorated with @JsonCreator (for Enum type " + r0.getName() + ")");
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v2, types: [b3.g] */
    /* JADX WARN: Type inference failed for: r5v4, types: [b3.g] */
    /* JADX WARN: Type inference failed for: r5v5, types: [com.fasterxml.jackson.databind.deser.std.StdKeyDeserializer] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final b3.g q(com.fasterxml.jackson.databind.JavaType r12, com.fasterxml.jackson.databind.BeanProperty r13) throws com.fasterxml.jackson.databind.exc.InvalidDefinitionException {
        /*
            Method dump skipped, instructions count: 348
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.DeserializationContext.q(com.fasterxml.jackson.databind.JavaType, com.fasterxml.jackson.databind.BeanProperty):b3.g");
    }

    public final c<Object> r(JavaType javaType) {
        return this.f3661a.e(this, this.f3662b, javaType);
    }

    public abstract com.fasterxml.jackson.databind.deser.impl.a s(Object obj, ObjectIdGenerator<?> objectIdGenerator, com.fasterxml.jackson.annotation.a aVar);

    public final c<Object> t(JavaType javaType) {
        DeserializerCache deserializerCache = this.f3661a;
        f fVar = this.f3662b;
        c<?> cVarZ = z(deserializerCache.e(this, fVar, javaType), null, javaType);
        k3.b bVarB = fVar.b(this.f3663c, javaType);
        return bVarB != null ? new TypeWrappedDeserializer(bVarB.f(null), cVarZ) : cVarZ;
    }

    public final q3.b u() {
        if (this.f3666j == null) {
            q3.b bVar = new q3.b();
            bVar.f11547a = null;
            bVar.f11548b = null;
            bVar.f11549c = null;
            bVar.f11550d = null;
            bVar.f11551e = null;
            bVar.f11552f = null;
            bVar.f11553g = null;
            this.f3666j = bVar;
        }
        return this.f3666j;
    }

    public final void v(c<?> cVar) throws InvalidDefinitionException {
        if (this.f3663c.k(MapperFeature.IGNORE_MERGE_FOR_UNMERGEABLE)) {
            return;
        }
        throw new InvalidDefinitionException(this.h, a0.a.k("Invalid configuration: values of type ", a.r(k(cVar.m())), " cannot be merged"));
    }

    public final void w(Class cls, Throwable th) throws ValueInstantiationException {
        this.f3663c.getClass();
        for (androidx.appcompat.widget.l lVar = null; lVar != null; lVar = (androidx.appcompat.widget.l) lVar.h) {
            ((e) lVar.f887g).getClass();
        }
        a.C(th);
        if (!J(DeserializationFeature.WRAP_EXCEPTIONS)) {
            a.D(th);
        }
        throw H(cls, th);
    }

    public final Object x(Class cls, ValueInstantiator valueInstantiator, String str, Object... objArr) throws MismatchedInputException {
        if (objArr.length > 0) {
            str = String.format(str, objArr);
        }
        this.f3663c.getClass();
        for (androidx.appcompat.widget.l lVar = null; lVar != null; lVar = (androidx.appcompat.widget.l) lVar.h) {
            ((e) lVar.f887g).getClass();
        }
        if (valueInstantiator == null) {
            i(cls, ai.onnxruntime.a.l("Cannot construct instance of ", a.y(cls), ": ", str));
            throw null;
        }
        if (valueInstantiator.l()) {
            throw new MismatchedInputException(this.h, ai.onnxruntime.a.l("Cannot construct instance of ", a.y(cls), " (although at least one Creator exists): ", str));
        }
        i(cls, ai.onnxruntime.a.l("Cannot construct instance of ", a.y(cls), " (no Creators, like default constructor, exist): ", str));
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final c<?> y(c<?> cVar, BeanProperty beanProperty, JavaType javaType) {
        if (!(cVar instanceof e3.c)) {
            return cVar;
        }
        this.f3669m = new androidx.appcompat.widget.l(javaType, this.f3669m);
        try {
            return ((e3.c) cVar).c(this, beanProperty);
        } finally {
            this.f3669m = (androidx.appcompat.widget.l) this.f3669m.h;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final c<?> z(c<?> cVar, BeanProperty beanProperty, JavaType javaType) {
        if (!(cVar instanceof e3.c)) {
            return cVar;
        }
        this.f3669m = new androidx.appcompat.widget.l(javaType, this.f3669m);
        try {
            return ((e3.c) cVar).c(this, beanProperty);
        } finally {
            this.f3669m = (androidx.appcompat.widget.l) this.f3669m.h;
        }
    }

    public DeserializationContext(DeserializationContext deserializationContext, DeserializationConfig deserializationConfig, w2.b bVar) {
        this.f3661a = deserializationContext.f3661a;
        this.f3662b = deserializationContext.f3662b;
        this.f3665e = bVar.T0();
        this.f3663c = deserializationConfig;
        this.f3664d = deserializationConfig.f3660p;
        this.h = bVar;
    }

    public DeserializationContext(DeserializationContext deserializationContext, DeserializationConfig deserializationConfig) {
        this.f3661a = deserializationContext.f3661a;
        this.f3662b = deserializationContext.f3662b;
        this.f3665e = null;
        this.f3663c = deserializationConfig;
        this.f3664d = deserializationConfig.f3660p;
        this.h = null;
    }
}
