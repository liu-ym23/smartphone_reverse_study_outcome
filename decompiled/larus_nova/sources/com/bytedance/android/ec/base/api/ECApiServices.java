package com.bytedance.android.ec.base.api;

import androidx.exifinterface.media.ExifInterface;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J'\u0010\u0006\u001a\u0004\u0018\u0001H\u0007\"\b\b\u0000\u0010\u0007*\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0005H\u0007¢\u0006\u0002\u0010\tJ-\u0010\n\u001a\u0002H\u0007\"\b\b\u0000\u0010\u0007*\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00052\u0006\u0010\u000b\u001a\u0002H\u0007H\u0007¢\u0006\u0002\u0010\fJ-\u0010\r\u001a\u00020\u000e\"\b\b\u0000\u0010\u0007*\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00052\u0006\u0010\u000f\u001a\u0002H\u0007H\u0007¢\u0006\u0002\u0010\u0010J \u0010\u0011\u001a\u00020\u000e\"\b\b\u0000\u0010\u0007*\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0005H\u0007R\u001e\u0010\u0003\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0004\u0012\u00020\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/ec/base/api/ECApiServices;", "", "()V", "registry", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/lang/Class;", "getService", ExifInterface.GPS_DIRECTION_TRUE, "clazz", "(Ljava/lang/Class;)Ljava/lang/Object;", "getServiceOrDefault", "default", "(Ljava/lang/Class;Ljava/lang/Object;)Ljava/lang/Object;", "registerService", "", "impl", "(Ljava/lang/Class;Ljava/lang/Object;)V", "unregisterService", "ec-base-api_release"}, k = 1, mv = {1, 4, 3})
public final class ECApiServices {
    public static final ECApiServices INSTANCE = null;
    private static final ConcurrentHashMap<Class<?>, Object> registry = null;

    private ECApiServices() {
    }

    static {
        INSTANCE = new ECApiServices();
        registry = new ConcurrentHashMap();
    }

    @JvmStatic
    public static final <T> T getService(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        T r101 = (T) registry.get(r100);
        if ((r101 instanceof Object) == true) goto L6;
        return null;
    L6:
        return r101;
    }

    @JvmStatic
    public static final <T> void unregisterService(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        registry.remove(r100);
    }

    @JvmStatic
    public static final <T> T getServiceOrDefault(Class<T> r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Intrinsics.checkNotNullParameter(r101, "default");
        T r102 = (T) getService(r100);
        if (r102 != null) goto L6;
        return r101;
    L6:
        return r102;
    }

    @JvmStatic
    public static final <T> void registerService(Class<T> r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Intrinsics.checkNotNullParameter(r101, "impl");
        registry.put(r100, r101);
    }
}
