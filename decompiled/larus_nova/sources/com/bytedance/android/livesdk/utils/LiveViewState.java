package com.bytedance.android.livesdk.utils;

import android.os.Handler;
import android.os.Looper;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.livesdk.utils.g2;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000*\n\b\u0000\u0010\u0002*\u0004\u0018\u00010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/utils/LiveViewState;", "Lcom/bytedance/android/livesdk/utils/g2;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/MutableLiveData;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livedynamic_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveViewState<T extends g2> extends MutableLiveData<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Handler f158762a;

    public static final class a<T extends g2> implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LiveViewState<T> f158763a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final T f158764b;

        @Override // java.lang.Runnable
        public final void run() {
            LiveViewState<T> r100 = this.f158763a;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.setValue(this.f158764b);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public a(LiveViewState<T> r100, T r101) {
            this.f158763a = r100;
            this.f158764b = r101;
        }
    }

    public LiveViewState() {
        this.f158762a = new Handler(Looper.getMainLooper());
    }

    @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
    public final void postValue(Object r100) {
        g2 r101 = (g2) r100;
        if (this.f158762a != null) goto L5;
        this.f158762a = new Handler(Looper.getMainLooper());
    L5:
        this.f158762a.post(new a(this, r101));
    }
}
