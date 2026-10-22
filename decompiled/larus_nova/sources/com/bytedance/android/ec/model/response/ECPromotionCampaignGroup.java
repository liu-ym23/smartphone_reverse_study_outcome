package com.bytedance.android.ec.model.response;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R&\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR \u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001e\u0010\u0015\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\u001e\u0010\u001e\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0018\"\u0004\b \u0010\u001a¨\u0006!"}, d2 = {"Lcom/bytedance/android/ec/model/response/ECPromotionCampaignGroup;", "Ljava/io/Serializable;", "()V", "avatarList", "", "", "getAvatarList", "()Ljava/util/List;", "setAvatarList", "(Ljava/util/List;)V", "buttonText", "getButtonText", "()Ljava/lang/String;", "setButtonText", "(Ljava/lang/String;)V", "groupId", "getGroupId", "setGroupId", "groupLabel", "getGroupLabel", "setGroupLabel", "groupSize", "", "getGroupSize", "()I", "setGroupSize", "(I)V", "joined", "getJoined", "setJoined", "persent", "getPersent", "setPersent", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class ECPromotionCampaignGroup implements Serializable {

    @SerializedName("avatar_list")
    private List<String> avatarList;

    @SerializedName("button_text")
    private String buttonText;

    @SerializedName("group_id")
    private String groupId;

    @SerializedName("group_label")
    private String groupLabel;

    @SerializedName("group_size")
    private int groupSize;

    @SerializedName("joined")
    private int joined;

    @SerializedName("persent")
    private int persent;

    public ECPromotionCampaignGroup() {
    }

    public final List<String> getAvatarList() {
        return this.avatarList;
    }

    public final String getButtonText() {
        return this.buttonText;
    }

    public final String getGroupId() {
        return this.groupId;
    }

    public final String getGroupLabel() {
        return this.groupLabel;
    }

    public final int getGroupSize() {
        return this.groupSize;
    }

    public final int getJoined() {
        return this.joined;
    }

    public final int getPersent() {
        return this.persent;
    }

    public final void setAvatarList(List<String> r100) {
        this.avatarList = r100;
    }

    public final void setButtonText(String r100) {
        this.buttonText = r100;
    }

    public final void setGroupId(String r100) {
        this.groupId = r100;
    }

    public final void setGroupLabel(String r100) {
        this.groupLabel = r100;
    }

    public final void setGroupSize(int r100) {
        this.groupSize = r100;
    }

    public final void setJoined(int r100) {
        this.joined = r100;
    }

    public final void setPersent(int r100) {
        this.persent = r100;
    }
}
