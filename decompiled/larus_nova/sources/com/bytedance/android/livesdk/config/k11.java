package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/config/k11;", "", "", "asyncView", "Z", "b", "()Z", "setAsyncView", "(Z)V", "smoothBitmap", "c", "setSmoothBitmap", "asyncSingleton", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setAsyncSingleton", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class k11 {

    @SerializedName("asyncSingleton")
    private boolean asyncSingleton;

    @SerializedName("asyncView")
    private boolean asyncView;

    @SerializedName("smoothBitmap")
    private boolean smoothBitmap;

    public k11() {
    }

    public final boolean a() {
        return this.asyncSingleton;
    }

    public final boolean b() {
        return this.asyncView;
    }

    public final boolean c() {
        return this.smoothBitmap;
    }
}
