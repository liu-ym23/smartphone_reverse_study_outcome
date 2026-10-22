package com.fasterxml.jackson.databind.type;

import com.fasterxml.jackson.databind.JavaType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.StringTokenizer;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class TypeParser implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final TypeFactory f4487a;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a extends StringTokenizer {

        /* renamed from: a, reason: collision with root package name */
        public final String f4488a;

        /* renamed from: b, reason: collision with root package name */
        public int f4489b;

        /* renamed from: c, reason: collision with root package name */
        public String f4490c;

        public a(String str) {
            super(str, "<,>", true);
            this.f4488a = str;
        }

        @Override // java.util.StringTokenizer
        public final boolean hasMoreTokens() {
            return this.f4490c != null || super.hasMoreTokens();
        }

        @Override // java.util.StringTokenizer
        public final String nextToken() {
            String str = this.f4490c;
            if (str != null) {
                this.f4490c = null;
                return str;
            }
            String strNextToken = super.nextToken();
            this.f4489b = strNextToken.length() + this.f4489b;
            return strNextToken.trim();
        }
    }

    public TypeParser(TypeFactory typeFactory) {
        this.f4487a = typeFactory;
    }

    public static IllegalArgumentException a(a aVar, String str) {
        String str2 = aVar.f4488a;
        StringBuilder sbS = ai.onnxruntime.a.s("Failed to parse type '", str2, "' (remaining: '", str2.substring(aVar.f4489b), "'): ");
        sbS.append(str);
        return new IllegalArgumentException(sbS.toString());
    }

    public final JavaType b(a aVar) {
        if (!aVar.hasMoreTokens()) {
            throw a(aVar, "Unexpected end-of-string");
        }
        String strNextToken = aVar.nextToken();
        try {
            Class<?> clsK = TypeFactory.k(strNextToken);
            boolean zHasMoreTokens = aVar.hasMoreTokens();
            TypeFactory typeFactory = this.f4487a;
            if (zHasMoreTokens) {
                String strNextToken2 = aVar.nextToken();
                if ("<".equals(strNextToken2)) {
                    ArrayList arrayList = new ArrayList();
                    while (aVar.hasMoreTokens()) {
                        arrayList.add(b(aVar));
                        if (!aVar.hasMoreTokens()) {
                            break;
                        }
                        String strNextToken3 = aVar.nextToken();
                        if (">".equals(strNextToken3)) {
                            JavaType[] javaTypeArr = TypeBindings.h;
                            if (!arrayList.isEmpty()) {
                                javaTypeArr = (JavaType[]) arrayList.toArray(javaTypeArr);
                            }
                            return typeFactory.c(null, clsK, TypeBindings.c(clsK, javaTypeArr));
                        }
                        if (!",".equals(strNextToken3)) {
                            throw a(aVar, "Unexpected token '" + strNextToken3 + "', expected ',' or '>')");
                        }
                    }
                    throw a(aVar, "Unexpected end-of-string");
                }
                aVar.f4490c = strNextToken2;
            }
            return typeFactory.c(null, clsK, TypeBindings.f4452j);
        } catch (Exception e10) {
            com.fasterxml.jackson.databind.util.a.D(e10);
            throw a(aVar, "Cannot locate class '" + strNextToken + "', problem: " + e10.getMessage());
        }
    }
}
