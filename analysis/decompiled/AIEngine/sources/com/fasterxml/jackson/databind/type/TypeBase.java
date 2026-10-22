package com.fasterxml.jackson.databind.type;

import b3.e;
import b3.h;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.WritableTypeId;
import com.fasterxml.jackson.databind.JavaType;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class TypeBase extends JavaType implements e {

    /* renamed from: l, reason: collision with root package name */
    public static final TypeBindings f4448l = TypeBindings.f4452j;
    public final JavaType h;

    /* renamed from: j, reason: collision with root package name */
    public final JavaType[] f4449j;

    /* renamed from: k, reason: collision with root package name */
    public final TypeBindings f4450k;

    public TypeBase(Class<?> cls, TypeBindings typeBindings, JavaType javaType, JavaType[] javaTypeArr, int i10, Object obj, Object obj2, boolean z) {
        super(cls, i10, obj, obj2, z);
        this.f4450k = typeBindings == null ? f4448l : typeBindings;
        this.h = javaType;
        this.f4449j = javaTypeArr;
    }

    public static void N(Class cls, StringBuilder sb2, boolean z) {
        if (!cls.isPrimitive()) {
            sb2.append('L');
            String name = cls.getName();
            int length = name.length();
            for (int i10 = 0; i10 < length; i10++) {
                char cCharAt = name.charAt(i10);
                if (cCharAt == '.') {
                    cCharAt = '/';
                }
                sb2.append(cCharAt);
            }
            if (z) {
                sb2.append(';');
                return;
            }
            return;
        }
        if (cls == Boolean.TYPE) {
            sb2.append('Z');
            return;
        }
        if (cls == Byte.TYPE) {
            sb2.append('B');
            return;
        }
        if (cls == Short.TYPE) {
            sb2.append('S');
            return;
        }
        if (cls == Character.TYPE) {
            sb2.append('C');
            return;
        }
        if (cls == Integer.TYPE) {
            sb2.append('I');
            return;
        }
        if (cls == Long.TYPE) {
            sb2.append('J');
            return;
        }
        if (cls == Float.TYPE) {
            sb2.append('F');
        } else if (cls == Double.TYPE) {
            sb2.append('D');
        } else {
            if (cls != Void.TYPE) {
                throw new IllegalStateException("Unrecognized primitive type: ".concat(cls.getName()));
            }
            sb2.append('V');
        }
    }

    public String O() {
        return this.f3690a.getName();
    }

    @Override // b3.e
    public final void a(JsonGenerator jsonGenerator, h hVar) {
        jsonGenerator.f1(O());
    }

    @Override // b3.e
    public final void b(JsonGenerator jsonGenerator, h hVar, k3.e eVar) {
        WritableTypeId writableTypeId = new WritableTypeId(JsonToken.VALUE_STRING, this);
        eVar.e(jsonGenerator, writableTypeId);
        a(jsonGenerator, hVar);
        eVar.f(jsonGenerator, writableTypeId);
    }

    @Override // com.fasterxml.jackson.core.type.a
    public final String e() {
        return O();
    }

    @Override // com.fasterxml.jackson.databind.JavaType
    public final JavaType f(int i10) {
        return this.f4450k.d(i10);
    }

    @Override // com.fasterxml.jackson.databind.JavaType
    public final int g() {
        return this.f4450k.f4454b.length;
    }

    @Override // com.fasterxml.jackson.databind.JavaType
    public final JavaType i(Class<?> cls) {
        JavaType javaTypeI;
        JavaType[] javaTypeArr;
        if (cls == this.f3690a) {
            return this;
        }
        if (cls.isInterface() && (javaTypeArr = this.f4449j) != null) {
            for (JavaType javaType : javaTypeArr) {
                JavaType javaTypeI2 = javaType.i(cls);
                if (javaTypeI2 != null) {
                    return javaTypeI2;
                }
            }
        }
        JavaType javaType2 = this.h;
        if (javaType2 == null || (javaTypeI = javaType2.i(cls)) == null) {
            return null;
        }
        return javaTypeI;
    }

    @Override // com.fasterxml.jackson.databind.JavaType
    public TypeBindings j() {
        return this.f4450k;
    }

    @Override // com.fasterxml.jackson.databind.JavaType
    public final List<JavaType> n() {
        JavaType[] javaTypeArr = this.f4449j;
        if (javaTypeArr == null) {
            return Collections.EMPTY_LIST;
        }
        int length = javaTypeArr.length;
        return length != 0 ? length != 1 ? Arrays.asList(javaTypeArr) : Collections.singletonList(javaTypeArr[0]) : Collections.EMPTY_LIST;
    }

    @Override // com.fasterxml.jackson.databind.JavaType
    public JavaType q() {
        return this.h;
    }
}
