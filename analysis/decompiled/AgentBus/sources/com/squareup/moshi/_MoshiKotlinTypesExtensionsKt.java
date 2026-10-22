package com.squareup.moshi;

import java.lang.annotation.Annotation;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Set;
import kotlin.Metadata;
import nb.i;
import q7.k;
import w7.d;
import w7.e0;
import w7.u;

@Metadata(d1 = {"\u00006\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a.\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0002\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00020\u00000\u0002H\u0086\b¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0018\u0010\u0006\u001a\u00020\u0005\"\u0006\b\u0000\u0010\u0001\u0018\u0001H\u0087\b¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0018\u0010\b\u001a\u00020\u0005\"\u0006\b\u0000\u0010\u0001\u0018\u0001H\u0087\b¢\u0006\u0004\b\b\u0010\u0007\u001a\u0013\u0010\u000b\u001a\u00020\n*\u00020\tH\u0007¢\u0006\u0004\b\u000b\u0010\f\u001a\u0015\u0010\u000b\u001a\u00020\n*\u0006\u0012\u0002\b\u00030\r¢\u0006\u0004\b\u000b\u0010\u000e\u001a\u0011\u0010\u000b\u001a\u00020\n*\u00020\u000f¢\u0006\u0004\b\u000b\u0010\u0010\"\u0019\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u0011*\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"", "T", "", "nextAnnotations", "(Ljava/util/Set;)Ljava/util/Set;", "Ljava/lang/reflect/WildcardType;", "subtypeOf", "()Ljava/lang/reflect/WildcardType;", "supertypeOf", "Lw7/u;", "Ljava/lang/reflect/GenericArrayType;", "asArrayType", "(Lw7/u;)Ljava/lang/reflect/GenericArrayType;", "Lw7/d;", "(Lw7/d;)Ljava/lang/reflect/GenericArrayType;", "Ljava/lang/reflect/Type;", "(Ljava/lang/reflect/Type;)Ljava/lang/reflect/GenericArrayType;", "Ljava/lang/Class;", "getRawType", "(Ljava/lang/reflect/Type;)Ljava/lang/Class;", "rawType", "moshi"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class _MoshiKotlinTypesExtensionsKt {
    public static final GenericArrayType asArrayType(u uVar) {
        k.e(uVar, "<this>");
        return asArrayType(e0.C(uVar));
    }

    public static final Class<?> getRawType(Type type) {
        k.e(type, "<this>");
        Class<?> rawType = Types.getRawType(type);
        k.d(rawType, "getRawType(this)");
        return rawType;
    }

    public static final <T extends Annotation> Set<Annotation> nextAnnotations(Set<? extends Annotation> set) {
        k.e(set, "<this>");
        throw new UnsupportedOperationException("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
    }

    public static final <T> WildcardType subtypeOf() {
        throw new UnsupportedOperationException("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
    }

    public static final <T> WildcardType supertypeOf() {
        throw new UnsupportedOperationException("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
    }

    public static final GenericArrayType asArrayType(d dVar) {
        k.e(dVar, "<this>");
        return asArrayType(i.t(dVar));
    }

    public static final GenericArrayType asArrayType(Type type) {
        k.e(type, "<this>");
        GenericArrayType genericArrayTypeArrayOf = Types.arrayOf(type);
        k.d(genericArrayTypeArrayOf, "arrayOf(this)");
        return genericArrayTypeArrayOf;
    }
}
