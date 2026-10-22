package com.android.ttcjpaysdk.base.h5.cjjsb.base.dependency;

import androidx.exifinterface.media.ExifInterface;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J#\u0010\u0007\u001a\u0004\u0018\u0001H\b\"\u0004\b\u0000\u0010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\u0005H\u0016¢\u0006\u0002\u0010\nJ#\u0010\u000b\u001a\u0004\u0018\u0001H\b\"\u0004\b\u0000\u0010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\u0005H\u0002¢\u0006\u0002\u0010\nJ+\u0010\f\u001a\u00020\r\"\u0004\b\u0000\u0010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\u00052\b\u0010\u000e\u001a\u0004\u0018\u0001H\bH\u0016¢\u0006\u0002\u0010\u000fR\"\u0010\u0003\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/dependency/CJDependencyProvider;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/dependency/IDependencyProvider;", "()V", "providers", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/lang/Class;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/dependency/IInstanceProvider;", MonitorConstants.CONNECT_TYPE_GET, ExifInterface.GPS_DIRECTION_TRUE, "clazz", "(Ljava/lang/Class;)Ljava/lang/Object;", "getLastInstance", "put", "", "instance", "(Ljava/lang/Class;Ljava/lang/Object;)V", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJDependencyProvider implements IDependencyProvider {
    private final ConcurrentHashMap<Class<?>, IInstanceProvider<?>> providers;

    public CJDependencyProvider() {
        this.providers = new ConcurrentHashMap();
    }

    private final <T> T getLastInstance(Class<T> r100) {
        return (T) get(r100);
    }

    @Override // com.android.ttcjpaysdk.base.h5.cjjsb.base.dependency.IDependencyProvider
    public <T> T get(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        IInstanceProvider<?> r101 = this.providers.get(r100);
        if (r101 == null) goto L13;
        Object r102 = r101.provideInstance();
        if (r102 != null) goto L7;
        return null;
    L7:
        if (r100.isAssignableFrom(r102.getClass()) == true) goto L10;
        r102 = null;
    L10:
        if (r102 != null) goto L12;
        return null;
    L12:
        return (T) r102;
    L13:
        return null;
    }

    @Override // com.android.ttcjpaysdk.base.h5.cjjsb.base.dependency.IDependencyProvider
    public <T> void put(Class<T> r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        if (r101 == null) goto L5;
        this.providers.put(r100, new DefaultInstanceProvider(r101));
        return;
    L5:
        this.providers.put(r100, new DefaultInstanceProvider(null));
    }
}
