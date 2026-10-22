package com.bytedance.android.live.network;

import com.bytedance.retrofit2.Converter;
import com.bytedance.retrofit2.Retrofit;
import com.bytedance.retrofit2.mime.TypedInput;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes46.dex */
public final class f extends Converter.Factory {
    public f() {
    }

    @Override // com.bytedance.retrofit2.Converter.Factory
    public final Converter<TypedInput, ?> responseBodyConverter(Type r100, Annotation[] r101, Retrofit r102) {
        if (r100 == am3.f.class) goto L7;
        return null;
    L7:
        return new e();
    }
}
