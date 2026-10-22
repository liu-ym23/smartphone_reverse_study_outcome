package com.bytedance.android.livesdk.livecommerce.room.utils;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/room/utils/a;", "", "", "lastClickTimestamp", "J", "b", "()J", "d", "(J)V", "", "clickTimes", "I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()I", "c", "(I)V", "<init>", "()V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("click_times")
    private int clickTimes;

    @SerializedName("last_click_timestamp")
    private long lastClickTimestamp;

    public a() {
        this.lastClickTimestamp = System.currentTimeMillis();
    }

    public final int a() {
        return this.clickTimes;
    }

    public final long b() {
        return this.lastClickTimestamp;
    }

    public final void c(int r100) {
        this.clickTimes = r100;
    }

    public final void d(long r100) {
        this.lastClickTimestamp = r100;
    }
}
