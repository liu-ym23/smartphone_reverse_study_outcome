package com.bytedance.android.livesdk.config;

import com.byted.cast.mediacommon.MediaCaptureError;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0019R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/config/ec1;", "", "", "isOn", "Z", "b", "()Z", "setOn", "(Z)V", "", "", "errorCodes", "Ljava/util/List;", "getErrorCodes", "()Ljava/util/List;", "setErrorCodes", "(Ljava/util/List;)V", "", "coldTime", "J", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()J", "setColdTime", "(J)V", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ec1 {

    @SerializedName("cold_time")
    private long coldTime;

    @SerializedName("codes")
    private List<Integer> errorCodes;

    @SerializedName("is_on")
    private boolean isOn;

    public ec1() {
        this.errorCodes = CollectionsKt.mutableListOf(new Integer[]{20062, Integer.valueOf(MediaCaptureError.ERROR_CAST_CONNECTION_NOT_BUILT), 10012, 4003034, 4003050, 4003073, 4003093, 10011, 4003136, 30019});
        this.coldTime = 5000;
    }

    public final long a() {
        return this.coldTime;
    }

    public final boolean b() {
        return this.isOn;
    }

    public final boolean c(int r100) {
        List<Integer> r101 = this.errorCodes;
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if (r101.contains(Integer.valueOf(r100)) != true) goto L7;
        return true;
    }
}
