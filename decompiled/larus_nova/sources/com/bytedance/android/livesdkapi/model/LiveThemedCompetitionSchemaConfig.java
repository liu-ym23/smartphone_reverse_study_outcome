package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/LiveThemedCompetitionSchemaConfig;", "", "()V", "rank", "Lcom/bytedance/android/livesdkapi/model/Rank;", "getRank", "()Lcom/bytedance/android/livesdkapi/model/Rank;", "setRank", "(Lcom/bytedance/android/livesdkapi/model/Rank;)V", "setting", "Lcom/bytedance/android/livesdkapi/model/Setting;", "getSetting", "()Lcom/bytedance/android/livesdkapi/model/Setting;", "setSetting", "(Lcom/bytedance/android/livesdkapi/model/Setting;)V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LiveThemedCompetitionSchemaConfig {

    @SerializedName("rank")
    private Rank rank;

    @SerializedName("setting")
    private Setting setting;

    public LiveThemedCompetitionSchemaConfig() {
        this.rank = new Rank();
        this.setting = new Setting();
    }

    public final Rank getRank() {
        return this.rank;
    }

    public final Setting getSetting() {
        return this.setting;
    }

    public final void setRank(Rank r100) {
        this.rank = r100;
    }

    public final void setSetting(Setting r100) {
        this.setting = r100;
    }
}
