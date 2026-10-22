package com.bytedance.android.ec.core.hybrid.prefetch;

import com.bytedance.retrofit2.Converter;
import com.bytedance.retrofit2.Retrofit;
import com.bytedance.retrofit2.mime.TypedInput;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes43.dex */
public final class n extends Converter.Factory {
    public n() {
    }

    @Override // com.bytedance.retrofit2.Converter.Factory
    public final Converter<TypedInput, ?> responseBodyConverter(Type r100, Annotation[] r101, Retrofit r102) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "annotations");
        Intrinsics.checkNotNullParameter(r102, "retrofit");
        int r103 = r101.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L9;
        if (Intrinsics.areEqual(JvmClassMappingKt.getAnnotationClass(r101[r104]), Reflection.getOrCreateKotlinClass(NaPrefetch.class)) == true) goto L7;
        r104 = r104 + 1;
        goto L3
    L7:
        return new m();
    L9:
        return null;
    }
}
