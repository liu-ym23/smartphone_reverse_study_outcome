package com.android.ttcjpaysdk.base.h5.cjjsb.base.dependency;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0002\u0010\u0004J\r\u0010\b\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0003\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/dependency/DefaultInstanceProvider;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/dependency/IInstanceProvider;", "instance", "(Ljava/lang/Object;)V", "getInstance", "()Ljava/lang/Object;", "Ljava/lang/Object;", "provideInstance", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DefaultInstanceProvider<T> implements IInstanceProvider<T> {
    private final T instance;

    public final T getInstance() {
        return this.instance;
    }

    @Override // com.android.ttcjpaysdk.base.h5.cjjsb.base.dependency.IInstanceProvider
    public T provideInstance() {
        return this.instance;
    }

    public DefaultInstanceProvider(T r100) {
        this.instance = r100;
    }
}
