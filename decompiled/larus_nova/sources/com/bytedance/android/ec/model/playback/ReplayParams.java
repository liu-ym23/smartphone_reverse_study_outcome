package com.bytedance.android.ec.model.playback;

import java.io.Serializable;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\b\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001e\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\b\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/ec/model/playback/ReplayParams;", "Ljava/io/Serializable;", "()V", "isFromLive", "", "()Ljava/lang/Boolean;", "setFromLive", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "isFromProductDetail", "setFromProductDetail", "newSourceType", "", "getNewSourceType", "()Ljava/lang/String;", "setNewSourceType", "(Ljava/lang/String;)V", "replayBackQueryEntranceInfo", "Lorg/json/JSONObject;", "getReplayBackQueryEntranceInfo", "()Lorg/json/JSONObject;", "setReplayBackQueryEntranceInfo", "(Lorg/json/JSONObject;)V", "targetEntranceInfo", "getTargetEntranceInfo", "setTargetEntranceInfo", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class ReplayParams implements Serializable {
    private Boolean isFromLive;
    private Boolean isFromProductDetail;
    private String newSourceType;
    private JSONObject replayBackQueryEntranceInfo;
    private String targetEntranceInfo;

    public ReplayParams() {
        Boolean r100 = Boolean.FALSE;
        this.isFromProductDetail = r100;
        this.isFromLive = r100;
    }

    public final String getNewSourceType() {
        return this.newSourceType;
    }

    public final JSONObject getReplayBackQueryEntranceInfo() {
        return this.replayBackQueryEntranceInfo;
    }

    public final String getTargetEntranceInfo() {
        return this.targetEntranceInfo;
    }

    public final Boolean isFromLive() {
        return this.isFromLive;
    }

    public final Boolean isFromProductDetail() {
        return this.isFromProductDetail;
    }

    public final void setFromLive(Boolean r100) {
        this.isFromLive = r100;
    }

    public final void setFromProductDetail(Boolean r100) {
        this.isFromProductDetail = r100;
    }

    public final void setNewSourceType(String r100) {
        this.newSourceType = r100;
    }

    public final void setReplayBackQueryEntranceInfo(JSONObject r100) {
        this.replayBackQueryEntranceInfo = r100;
    }

    public final void setTargetEntranceInfo(String r100) {
        this.targetEntranceInfo = r100;
    }
}
