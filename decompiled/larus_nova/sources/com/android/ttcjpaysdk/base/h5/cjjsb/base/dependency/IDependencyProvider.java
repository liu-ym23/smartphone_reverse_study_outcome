package com.android.ttcjpaysdk.base.h5.cjjsb.base.dependency;

import androidx.exifinterface.media.ExifInterface;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J#\u0010\u0002\u001a\u0004\u0018\u0001H\u0003\"\u0004\b\u0000\u0010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0005H&¢\u0006\u0002\u0010\u0006J+\u0010\u0007\u001a\u00020\b\"\u0004\b\u0000\u0010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u00052\b\u0010\t\u001a\u0004\u0018\u0001H\u0003H&¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/dependency/IDependencyProvider;", "", MonitorConstants.CONNECT_TYPE_GET, ExifInterface.GPS_DIRECTION_TRUE, "clazz", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/Object;", "put", "", "instance", "(Ljava/lang/Class;Ljava/lang/Object;)V", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IDependencyProvider {
    <T> T get(Class<T> r100);

    <T> void put(Class<T> r100, T r101);
}
