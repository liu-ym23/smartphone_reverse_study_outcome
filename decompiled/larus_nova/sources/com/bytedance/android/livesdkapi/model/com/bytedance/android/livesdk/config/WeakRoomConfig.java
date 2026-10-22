package com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/WeakRoomConfig;", "", "()V", "fixClearScreenWeak", "", "getFixClearScreenWeak", "()Z", "setFixClearScreenWeak", "(Z)V", "fixLiveRecordWeak", "getFixLiveRecordWeak", "()Ljava/lang/Boolean;", "setFixLiveRecordWeak", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WeakRoomConfig {

    @SerializedName("fix_clear_screen_weak")
    private boolean fixClearScreenWeak;

    @SerializedName("fix_live_record_weak")
    private Boolean fixLiveRecordWeak;

    public WeakRoomConfig() {
    }

    public final boolean getFixClearScreenWeak() {
        return this.fixClearScreenWeak;
    }

    public final Boolean getFixLiveRecordWeak() {
        return this.fixLiveRecordWeak;
    }

    public final void setFixClearScreenWeak(boolean r100) {
        this.fixClearScreenWeak = r100;
    }

    public final void setFixLiveRecordWeak(Boolean r100) {
        this.fixLiveRecordWeak = r100;
    }
}
