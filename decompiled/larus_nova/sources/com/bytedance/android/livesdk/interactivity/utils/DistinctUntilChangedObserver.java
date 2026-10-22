package com.bytedance.android.livesdk.interactivity.utils;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/utils/DistinctUntilChangedObserver;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class DistinctUntilChangedObserver<T> implements Observer<KVData> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T f141316a;

    public DistinctUntilChangedObserver() {
    }

    public abstract T a(KVData r100);

    public abstract boolean b(T r100, T r101);

    public abstract void c(T r100);

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        if (r101 == null) goto L14;
        T r102 = a(r101);
        T r103 = this.f141316a;
        if (r103 != null) goto L9;
        this.f141316a = r102;
        c(r102);
        return;
    L9:
        if (b(r103, r102) == true) goto L13;
        this.f141316a = r102;
        c(r102);
        return;
    L13:
        return;
    }
}
