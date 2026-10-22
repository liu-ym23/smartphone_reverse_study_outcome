package com.bytedance.android.gamecp.common.network.networklib;

import am3.f;
import com.bytedance.retrofit2.Converter;
import com.bytedance.retrofit2.Retrofit;
import com.bytedance.retrofit2.mime.TypedInput;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes44.dex */
public final class d extends Converter.Factory {
    public d() {
    }

    @Override // com.bytedance.retrofit2.Converter.Factory
    public final Converter<TypedInput, ?> responseBodyConverter(Type r100, Annotation[] r101, Retrofit r102) {
        if (r100 == f.class) goto L7;
        return null;
    L7:
        return new c();
    }
}
