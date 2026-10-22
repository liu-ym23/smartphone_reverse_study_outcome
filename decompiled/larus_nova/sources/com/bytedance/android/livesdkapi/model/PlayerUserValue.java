package com.bytedance.android.livesdkapi.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\n\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\b¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/PlayerUserValue;", "", "()V", "crowdUserValue", "", "getCrowdUserValue", "()Ljava/lang/Integer;", "setCrowdUserValue", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "enable", "getEnable", "setEnable", "extraQuery", "", "getExtraQuery", "()Ljava/lang/String;", "setExtraQuery", "(Ljava/lang/String;)V", "extraWormholeTime", "getExtraWormholeTime", "setExtraWormholeTime", "suggestFastOpenDuration", "getSuggestFastOpenDuration", "setSuggestFastOpenDuration", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PlayerUserValue {
    public static final PlayerUserValue INSTANCE = null;
    private static Integer crowdUserValue;
    private static Integer enable;
    private static String extraQuery;
    private static Integer extraWormholeTime;
    private static Integer suggestFastOpenDuration;

    private PlayerUserValue() {
    }

    static {
        INSTANCE = new PlayerUserValue();
        enable = -1;
        crowdUserValue = -1;
        extraQuery = "";
        suggestFastOpenDuration = -1;
        extraWormholeTime = 0;
    }

    public final Integer getCrowdUserValue() {
        return crowdUserValue;
    }

    public final Integer getEnable() {
        return enable;
    }

    public final String getExtraQuery() {
        return extraQuery;
    }

    public final Integer getExtraWormholeTime() {
        return extraWormholeTime;
    }

    public final Integer getSuggestFastOpenDuration() {
        return suggestFastOpenDuration;
    }

    public final void setCrowdUserValue(Integer r100) {
        crowdUserValue = r100;
    }

    public final void setEnable(Integer r100) {
        enable = r100;
    }

    public final void setExtraQuery(String r100) {
        extraQuery = r100;
    }

    public final void setExtraWormholeTime(Integer r100) {
        extraWormholeTime = r100;
    }

    public final void setSuggestFastOpenDuration(Integer r100) {
        suggestFastOpenDuration = r100;
    }
}
