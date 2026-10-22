package com.bytedance.retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes2.dex */
final class DefaultCallAdapterFactory extends CallAdapter.Factory {
    static final CallAdapter.Factory INSTANCE = null;

    DefaultCallAdapterFactory() {
    }

    static {
        INSTANCE = new DefaultCallAdapterFactory();
    }

    @Override // com.bytedance.retrofit2.CallAdapter.Factory
    public CallAdapter<?, ?> get(Type r1, Annotation[] r2, Retrofit r3) {
        if (getRawType(r1) == Call.class) goto L6;
        return null;
    L6:
        final Type r4 = Utils.getCallResponseType(r1);
        return new AnonymousClass1(this, r4);
    }
}
