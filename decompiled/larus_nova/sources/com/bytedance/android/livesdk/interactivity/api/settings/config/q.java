package com.bytedance.android.livesdk.interactivity.api.settings.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b \u0010!R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR\"\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006\""}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/settings/config/q;", "", "", "showMaxSize", "I", "e", "()I", "setShowMaxSize", "(I)V", "freqLimitHotRoom", "c", "setFreqLimitHotRoom", "freqLimitUnHotRoom", "d", "setFreqLimitUnHotRoom", "", "duplicatedCheckPeriod", "J", "b", "()J", "setDuplicatedCheckPeriod", "(J)V", "duplicatedCheckCount", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setDuplicatedCheckCount", "", "giftPanelEnable", "Z", "getGiftPanelEnable", "()Z", "setGiftPanelEnable", "(Z)V", "<init>", "()V", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class q {

    @SerializedName("duplicated_check_count")
    private int duplicatedCheckCount;

    @SerializedName("duplicated_check_period")
    private long duplicatedCheckPeriod;

    @SerializedName("freq_limit_hot_room")
    private int freqLimitHotRoom;

    @SerializedName("freq_limit_unhot_room")
    private int freqLimitUnHotRoom;

    @SerializedName("enable_gift_panel")
    private boolean giftPanelEnable;

    @SerializedName("show_max_size")
    private int showMaxSize;

    public q() {
        this.showMaxSize = 100;
        this.freqLimitHotRoom = 10000;
        this.freqLimitUnHotRoom = 3000;
        this.duplicatedCheckPeriod = 10000;
        this.duplicatedCheckCount = 3;
    }

    public final int a() {
        return this.duplicatedCheckCount;
    }

    public final long b() {
        return this.duplicatedCheckPeriod;
    }

    public final int c() {
        return this.freqLimitHotRoom;
    }

    public final int d() {
        return this.freqLimitUnHotRoom;
    }

    public final int e() {
        return this.showMaxSize;
    }
}
