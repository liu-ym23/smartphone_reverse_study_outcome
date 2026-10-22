package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.cfg.MapperConfigBase;
import com.fasterxml.jackson.databind.introspect.AccessorNamingStrategy;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.HashSet;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class DefaultAccessorNamingStrategy extends AccessorNamingStrategy {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f4151a;

    /* renamed from: b, reason: collision with root package name */
    public final String f4152b;

    /* renamed from: c, reason: collision with root package name */
    public final String f4153c;

    /* renamed from: d, reason: collision with root package name */
    public final String f4154d;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class Provider extends AccessorNamingStrategy.Provider implements Serializable {

        /* renamed from: a, reason: collision with root package name */
        public final String f4155a = "set";

        /* renamed from: b, reason: collision with root package name */
        public final String f4156b = "with";

        /* renamed from: c, reason: collision with root package name */
        public final String f4157c = "get";

        /* renamed from: d, reason: collision with root package name */
        public final String f4158d = "is";
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a extends DefaultAccessorNamingStrategy {

        /* renamed from: e, reason: collision with root package name */
        public final HashSet f4159e;

        public a(MapperConfigBase mapperConfigBase, com.fasterxml.jackson.databind.introspect.a aVar) {
            super(mapperConfigBase, null, "get", "is");
            this.f4159e = new HashSet();
            Class<?> cls = aVar.f4175b;
            RuntimeException runtimeException = j3.b.f9691e;
            if (runtimeException != null) {
                throw runtimeException;
            }
            j3.b bVar = j3.b.f9690d;
            Object[] objArrA = bVar.a(cls);
            int length = objArrA.length;
            String[] strArr = new String[length];
            for (int i10 = 0; i10 < objArrA.length; i10++) {
                try {
                    strArr[i10] = (String) bVar.f9693b.invoke(objArrA[i10], null);
                } catch (Exception e10) {
                    throw new IllegalArgumentException(String.format("Failed to access name of field #%d (of %d) of Record type %s", Integer.valueOf(i10), Integer.valueOf(objArrA.length), com.fasterxml.jackson.databind.util.a.y(cls)), e10);
                }
            }
            for (int i11 = 0; i11 < length; i11++) {
                this.f4159e.add(strArr[i11]);
            }
        }

        @Override // com.fasterxml.jackson.databind.introspect.DefaultAccessorNamingStrategy
        public final String c(AnnotatedMethod annotatedMethod, String str) {
            return this.f4159e.contains(str) ? str : super.c(annotatedMethod, str);
        }
    }

    public DefaultAccessorNamingStrategy(MapperConfig mapperConfig, String str, String str2, String str3) {
        this.f4151a = mapperConfig.k(MapperFeature.USE_STD_BEAN_NAMING);
        this.f4154d = str;
        this.f4152b = str2;
        this.f4153c = str3;
    }

    public static String d(int i10, String str) {
        int length = str.length();
        if (length == i10) {
            return null;
        }
        char cCharAt = str.charAt(i10);
        char lowerCase = Character.toLowerCase(cCharAt);
        if (cCharAt == lowerCase) {
            return str.substring(i10);
        }
        StringBuilder sb2 = new StringBuilder(length - i10);
        sb2.append(lowerCase);
        while (true) {
            i10++;
            if (i10 >= length) {
                break;
            }
            char cCharAt2 = str.charAt(i10);
            char lowerCase2 = Character.toLowerCase(cCharAt2);
            if (cCharAt2 == lowerCase2) {
                sb2.append((CharSequence) str, i10, length);
                break;
            }
            sb2.append(lowerCase2);
        }
        return sb2.toString();
    }

    public static String e(int i10, String str) {
        int length = str.length();
        if (length == i10) {
            return null;
        }
        char cCharAt = str.charAt(i10);
        char lowerCase = Character.toLowerCase(cCharAt);
        if (cCharAt == lowerCase) {
            return str.substring(i10);
        }
        int i11 = i10 + 1;
        if (i11 < length && Character.isUpperCase(str.charAt(i11))) {
            return str.substring(i10);
        }
        StringBuilder sb2 = new StringBuilder(length - i10);
        sb2.append(lowerCase);
        sb2.append((CharSequence) str, i11, length);
        return sb2.toString();
    }

    public final String a(AnnotatedMethod annotatedMethod, String str) {
        String str2 = this.f4153c;
        if (str2 == null) {
            return null;
        }
        Class<?> returnType = annotatedMethod.f4124d.getReturnType();
        if ((returnType == Boolean.class || returnType == Boolean.TYPE) && str.startsWith(str2)) {
            return this.f4151a ? e(2, str) : d(2, str);
        }
        return null;
    }

    public final String b(String str) {
        String str2 = this.f4154d;
        if (str2 == null || !str.startsWith(str2)) {
            return null;
        }
        return this.f4151a ? e(str2.length(), str) : d(str2.length(), str);
    }

    public String c(AnnotatedMethod annotatedMethod, String str) {
        Method method = annotatedMethod.f4124d;
        String str2 = this.f4152b;
        if (str2 == null || !str.startsWith(str2)) {
            return null;
        }
        if ("getCallbacks".equals(str)) {
            Class<?> returnType = method.getReturnType();
            if (returnType.isArray()) {
                String name = returnType.getComponentType().getName();
                if (name.contains(".cglib") && (name.startsWith("net.sf.cglib") || name.startsWith("org.hibernate.repackage.cglib") || name.startsWith("org.springframework.cglib"))) {
                    return null;
                }
            }
        } else if ("getMetaClass".equals(str) && method.getReturnType().getName().startsWith("groovy.lang")) {
            return null;
        }
        return this.f4151a ? e(str2.length(), str) : d(str2.length(), str);
    }
}
