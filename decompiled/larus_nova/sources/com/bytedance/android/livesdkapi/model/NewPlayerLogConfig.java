package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/NewPlayerLogConfig;", "", "()V", "enableNewLog", "", "getEnableNewLog", "()Z", "enableWriteToIndependentFile", "getEnableWriteToIndependentFile", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class NewPlayerLogConfig {

    @SerializedName("enable_new_log")
    private final boolean enableNewLog;

    @SerializedName("enable_write_to_independent_file")
    private final boolean enableWriteToIndependentFile;

    public NewPlayerLogConfig() {
    }

    public final boolean getEnableNewLog() {
        return this.enableNewLog;
    }

    public final boolean getEnableWriteToIndependentFile() {
        return this.enableWriteToIndependentFile;
    }
}
