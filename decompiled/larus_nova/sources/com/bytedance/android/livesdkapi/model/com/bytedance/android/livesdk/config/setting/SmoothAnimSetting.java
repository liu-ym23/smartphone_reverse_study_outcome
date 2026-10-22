package com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.setting;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/setting/SmoothAnimSetting;", "", "()V", "duration", "", "getDuration", "()Ljava/lang/Long;", "setDuration", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "enable", "", "getEnable", "()Z", "setEnable", "(Z)V", "entranceList", "", "", "getEntranceList", "()Ljava/util/List;", "setEntranceList", "(Ljava/util/List;)V", "isDelayShowRoom", "setDelayShowRoom", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SmoothAnimSetting {

    @SerializedName("duration")
    private Long duration;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("entrance_list")
    private List<String> entranceList;

    @SerializedName("is_delay_show_room")
    private boolean isDelayShowRoom;

    public SmoothAnimSetting() {
        this.entranceList = new ArrayList();
        this.duration = 450L;
        this.isDelayShowRoom = true;
    }

    public final Long getDuration() {
        return this.duration;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final List<String> getEntranceList() {
        return this.entranceList;
    }

    public final boolean isDelayShowRoom() {
        return this.isDelayShowRoom;
    }

    public final void setDelayShowRoom(boolean r100) {
        this.isDelayShowRoom = r100;
    }

    public final void setDuration(Long r100) {
        this.duration = r100;
    }

    public final void setEnable(boolean r100) {
        this.enable = r100;
    }

    public final void setEntranceList(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.entranceList = r100;
    }
}
