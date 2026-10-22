package com.bytedance.android.live.revenue.platform.network.impl;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0006\u0012\u0002\b\u00030\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"getFirstTypeArgumentClass", "Ljava/lang/Class;", "Ljava/lang/reflect/ParameterizedType;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 5, 1})
final class ResponsePBDataDecoder$getDataCollectionConstructorAndType$1 extends Lambda implements Function1<ParameterizedType, Class<?>> {
    public static final ResponsePBDataDecoder$getDataCollectionConstructorAndType$1 INSTANCE = null;

    static {
        INSTANCE = new ResponsePBDataDecoder$getDataCollectionConstructorAndType$1();
    }

    public ResponsePBDataDecoder$getDataCollectionConstructorAndType$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Class<?> invoke2(ParameterizedType r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getFirstTypeArgumentClass");
        Type r101 = (Type) ArraysKt.singleOrNull(r100.getActualTypeArguments());
        if ((r101 instanceof WildcardType) == false) goto L6;
        r101 = (Type) ArraysKt.singleOrNull(((WildcardType) r101).getUpperBounds());
    L6:
        if ((r101 instanceof Class) == true) goto L8;
        r101 = null;
    L8:
        Class<?> r102 = (Class) r101;
        if (r102 == null) goto L12;
        return r102;
    L12:
        throw new IllegalStateException(("Type [" + r100 + "] must be class or WildcardType").toString());
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Class<?> invoke(ParameterizedType r100) {
        return invoke2(r100);
    }
}
