package com.android.ttcjpaysdk.base.h5.utils;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/utils/GetDataRunnable;", "Ljava/lang/Runnable;", "key", "", "callback", "Lcom/android/ttcjpaysdk/base/h5/utils/IGetDataCallback;", "(Ljava/lang/String;Lcom/android/ttcjpaysdk/base/h5/utils/IGetDataCallback;)V", "getCallback", "()Lcom/android/ttcjpaysdk/base/h5/utils/IGetDataCallback;", "setCallback", "(Lcom/android/ttcjpaysdk/base/h5/utils/IGetDataCallback;)V", "isFinish", "", "getKey", "()Ljava/lang/String;", "setKey", "(Ljava/lang/String;)V", "run", "", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetDataRunnable implements Runnable {
    private IGetDataCallback callback;
    private boolean isFinish;
    private String key;

    @Override // java.lang.Runnable
    public void run() {
        com_android_ttcjpaysdk_base_h5_utils_GetDataRunnable_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public void com_android_ttcjpaysdk_base_h5_utils_GetDataRunnable__run$___twin___() {
    L3:
        if (this.isFinish == true) goto L14;
        CJPayPreFetchDataManager r100 = CJPayPreFetchDataManager.INSTANCE;
        if (Intrinsics.areEqual(r100.getRequestTagMap().get(this.key), Boolean.TRUE) == true) goto L6;
        Thread.sleep(50);
        goto L3
    L6:
        IGetDataCallback r101 = this.callback;
        if (r101 == null) goto L9;
        r101.onGetData(r100.getCacheDataMap().get(this.key));
    L9:
        this.isFinish = true;
        return;
    }

    public final IGetDataCallback getCallback() {
        return this.callback;
    }

    public final String getKey() {
        return this.key;
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_android_ttcjpaysdk_base_h5_utils_GetDataRunnable_com_larus_apm_impl_protector_RunnableLancet_run(GetDataRunnable r100) {
        r100.com_android_ttcjpaysdk_base_h5_utils_GetDataRunnable__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public final void setCallback(IGetDataCallback r100) {
        this.callback = r100;
    }

    public final void setKey(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.key = r100;
    }

    public GetDataRunnable(String r100, IGetDataCallback r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        this.key = r100;
        this.callback = r101;
    }
}
