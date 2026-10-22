package com.bytedance.android.live.broadcast.api.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087D¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u0003\u0010\u0005R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087D¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/model/GameSuggestionResponseModel;", "Ljava/io/Serializable;", "()V", "isOpenSuggestion", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "isShowEntrance", "openMessageText", "", "getOpenMessageText", "()Ljava/lang/String;", "openTabText", "getOpenTabText", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GameSuggestionResponseModel implements Serializable {

    @SerializedName("is_open_suggestion")
    private final Boolean isOpenSuggestion;

    @SerializedName("is_show_entrance")
    private final Boolean isShowEntrance;

    @SerializedName("open_message_text")
    private final String openMessageText;

    @SerializedName("open_tab_text")
    private final String openTabText;

    public GameSuggestionResponseModel() {
        Boolean r100 = Boolean.FALSE;
        this.isShowEntrance = r100;
        this.isOpenSuggestion = r100;
    }

    public final String getOpenMessageText() {
        return this.openMessageText;
    }

    public final String getOpenTabText() {
        return this.openTabText;
    }

    public final Boolean isOpenSuggestion() {
        return this.isOpenSuggestion;
    }

    public final Boolean isShowEntrance() {
        return this.isShowEntrance;
    }
}
