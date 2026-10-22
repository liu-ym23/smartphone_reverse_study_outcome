package com.bytedance.android.live.utils;

import androidx.exifinterface.media.ExifInterface;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u0012\u0012\u0004\u0012\u00028\u00000\u0003j\b\u0012\u0004\u0012\u00028\u0000`\u00042\u0012\u0012\u0004\u0012\u00028\u00000\u0005j\b\u0012\u0004\u0012\u00028\u0000`\u0006B\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/utils/LiveEmptyObserverKt;", "", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/revenue/platform/api/core/android/lifecycle/Observer;", "Lio/reactivex/SingleObserver;", "Lcom/bytedance/revenue/platform/api/core/rx/SingleObserver;", "<init>", "()V", "live-utils-kmp_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LiveEmptyObserverKt<T> implements Observer<T>, SingleObserver<T> {
    public LiveEmptyObserverKt() {
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(T r100) {
    }

    @Override // io.reactivex.SingleObserver
    public final void onError(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
    }

    @Override // io.reactivex.SingleObserver
    public final void onSubscribe(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "d");
    }

    @Override // io.reactivex.SingleObserver
    public final void onSuccess(T r100) {
        Intrinsics.checkNotNullParameter(r100, "t");
    }
}
