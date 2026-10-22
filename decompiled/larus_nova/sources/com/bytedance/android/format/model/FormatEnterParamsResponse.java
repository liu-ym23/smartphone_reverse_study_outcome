package com.bytedance.android.format.model;

import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import com.bytedance.android.live.base.model.ImageModel;
import com.google.gson.annotations.SerializedName;
import com.larus.avlink.aiproactive.AiProactiveTaskViewModel;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0014\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001a\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\f\"\u0004\b\u001c\u0010\u000eR\u001e\u0010\u001d\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019R\u001e\u0010 \u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\f\"\u0004\b\"\u0010\u000e¨\u0006#"}, d2 = {"Lcom/bytedance/android/format/model/FormatEnterParamsResponse;", "Ljava/io/Serializable;", "()V", "avatarMedium", "Lcom/bytedance/android/live/base/model/ImageModel;", "getAvatarMedium", "()Lcom/bytedance/android/live/base/model/ImageModel;", "setAvatarMedium", "(Lcom/bytedance/android/live/base/model/ImageModel;)V", "interactiveMode", "", "getInteractiveMode", "()I", "setInteractiveMode", "(I)V", "isShow", "", "()Z", "setShow", "(Z)V", "playId", "", "getPlayId", "()Ljava/lang/String;", "setPlayId", "(Ljava/lang/String;)V", "playType", "getPlayType", "setPlayType", "roomId", "getRoomId", "setRoomId", "taskType", "getTaskType", "setTaskType", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FormatEnterParamsResponse implements Serializable {

    @SerializedName("avatar_medium")
    private ImageModel avatarMedium;

    @SerializedName("interactive_mode")
    private int interactiveMode;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_IS_SHOW)
    private boolean isShow;

    @SerializedName(InstantPlayContext.PLAY_ID)
    private String playId;

    @SerializedName("play_type")
    private int playType;

    @SerializedName("room_id")
    private String roomId;

    @SerializedName(AiProactiveTaskViewModel.PARAM_TASK_TYPE)
    private int taskType;

    public FormatEnterParamsResponse() {
        this.playId = "";
        this.roomId = "";
    }

    public final ImageModel getAvatarMedium() {
        return this.avatarMedium;
    }

    public final int getInteractiveMode() {
        return this.interactiveMode;
    }

    public final String getPlayId() {
        return this.playId;
    }

    public final int getPlayType() {
        return this.playType;
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public final int getTaskType() {
        return this.taskType;
    }

    public final boolean isShow() {
        return this.isShow;
    }

    public final void setAvatarMedium(ImageModel r100) {
        this.avatarMedium = r100;
    }

    public final void setInteractiveMode(int r100) {
        this.interactiveMode = r100;
    }

    public final void setPlayId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.playId = r100;
    }

    public final void setPlayType(int r100) {
        this.playType = r100;
    }

    public final void setRoomId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.roomId = r100;
    }

    public final void setShow(boolean r100) {
        this.isShow = r100;
    }

    public final void setTaskType(int r100) {
        this.taskType = r100;
    }
}
