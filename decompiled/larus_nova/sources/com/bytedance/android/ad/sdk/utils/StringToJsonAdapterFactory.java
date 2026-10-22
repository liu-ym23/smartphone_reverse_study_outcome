package com.bytedance.android.ad.sdk.utils;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/ad/sdk/utils/StringToJsonAdapterFactory;", "Lcom/google/gson/TypeAdapterFactory;", "<init>", "()V", "runtime-api_release"}, k = 1, mv = {1, 4, 0})
public final class StringToJsonAdapterFactory implements TypeAdapterFactory {
    public StringToJsonAdapterFactory() {
    }

    @Override // com.google.gson.TypeAdapterFactory
    public final <T> TypeAdapter<T> create(final Gson r100, final TypeToken<T> r101) {
        return new AnonymousClass1(r100, r101);
    }
}
