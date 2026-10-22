package com.bytedance.android.ec.model.response.adapter;

import com.bytedance.android.ec.model.response.RelatedAction;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/ec/model/response/adapter/ECRelatedTypeAdapterFactory;", "Lcom/google/gson/TypeAdapterFactory;", "<init>", "()V", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class ECRelatedTypeAdapterFactory implements TypeAdapterFactory {
    public ECRelatedTypeAdapterFactory() {
    }

    @Override // com.google.gson.TypeAdapterFactory
    public final <T> TypeAdapter<T> create(Gson r100, TypeToken<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "gson");
        if (r101 == null) goto L5;
        Class<? super T> r102 = r101.getRawType();
    L7:
        if ((!Intrinsics.areEqual(r102, RelatedAction.RelatedType.class)) == false) goto L9;
        return null;
    L9:
        final TypeAdapter<T> r103 = r100.getDelegateAdapter(this, r101);
        return new AnonymousClass1(r103);
    L5:
        r102 = null;
        goto L7
    }
}
