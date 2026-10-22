package com.bytedance.android.live.network.impl.factory;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.lang.reflect.ParameterizedType;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0006\u0012\u0002\b\u00030\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"getFirstTypeArgumentClass", "Ljava/lang/Class;", "Ljava/lang/reflect/ParameterizedType;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class MultiTypeRequestConverterFactory$handleCustomResponse$4 extends Lambda implements Function1<ParameterizedType, Class<?>> {
    public static final MultiTypeRequestConverterFactory$handleCustomResponse$4 INSTANCE = null;

    static {
        INSTANCE = new MultiTypeRequestConverterFactory$handleCustomResponse$4();
    }

    public MultiTypeRequestConverterFactory$handleCustomResponse$4() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Class<?> invoke2(ParameterizedType r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getFirstTypeArgumentClass");
        Object r101 = ArraysKt.singleOrNull(r100.getActualTypeArguments());
        if ((r101 instanceof Class) == true) goto L5;
        r101 = null;
    L5:
        Class<?> r102 = (Class) r101;
        if (r102 == null) goto L9;
        return r102;
    L9:
        throw new IllegalStateException(("First type argument of type [" + r100 + "] must be class.").toString());
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Class<?> invoke(ParameterizedType r100) {
        return invoke2(r100);
    }
}
