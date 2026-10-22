package com.bytedance.android.ec.model.promotion;

import android.os.SystemClock;
import com.byted.cast.common.api.FirewallError;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import ql.c;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b6\u00107J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0007\u001a\u00020\u0006R$\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR*\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010 \u001a\u00020\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010\u001b\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR\"\u0010#\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010\u001b\u001a\u0004\b$\u0010\u001d\"\u0004\b%\u0010\u001fR$\u0010&\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010\n\u001a\u0004\b'\u0010\f\"\u0004\b(\u0010\u000eR$\u0010*\u001a\u0004\u0018\u00010)8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R$\u00100\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u0010\n\u001a\u0004\b1\u0010\f\"\u0004\b2\u0010\u000eR$\u00103\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u0010\n\u001a\u0004\b4\u0010\f\"\u0004\b5\u0010\u000e¨\u00068"}, d2 = {"Lcom/bytedance/android/ec/model/promotion/ECUIPingGroup;", "Ljava/io/Serializable;", "Lql/c;", "updatedGroupInfo", "", "updateGroupInfo", "", "isShowTime", "", "groupLabel", "Ljava/lang/String;", "getGroupLabel", "()Ljava/lang/String;", "setGroupLabel", "(Ljava/lang/String;)V", "buttonText", "getButtonText", "setButtonText", "", "avatarList", "Ljava/util/List;", "getAvatarList", "()Ljava/util/List;", "setAvatarList", "(Ljava/util/List;)V", "", "joined", "I", "getJoined", "()I", "setJoined", "(I)V", "groupSize", "getGroupSize", "setGroupSize", "persent", "getPersent", "setPersent", "groupId", "getGroupId", "setGroupId", "", "endTime", "Ljava/lang/Long;", "getEndTime", "()Ljava/lang/Long;", "setEndTime", "(Ljava/lang/Long;)V", "time", "getTime", "setTime", "updateAvatar", "getUpdateAvatar", "setUpdateAvatar", "<init>", "()V", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class ECUIPingGroup implements Serializable {
    private List<String> avatarList;
    private String buttonText;
    private Long endTime;
    private String groupId;
    private String groupLabel;
    private int groupSize;
    private int joined;
    private int persent;
    private String time;
    private String updateAvatar;

    public ECUIPingGroup() {
    }

    public final void updateGroupInfo(c r100) {
    }

    public final boolean isShowTime() {
        Long r100 = this.endTime;
        if (r100 != null) goto L5;
        return false;
    L5:
        if ((r100.longValue() - SystemClock.elapsedRealtime()) > FirewallError.FIREWALL_OK) goto L9;
        return true;
    L9:
        return false;
    }

    public final List<String> getAvatarList() {
        return this.avatarList;
    }

    public final String getButtonText() {
        return this.buttonText;
    }

    public final Long getEndTime() {
        return this.endTime;
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

    public final String getTime() {
        return this.time;
    }

    public final String getUpdateAvatar() {
        return this.updateAvatar;
    }

    public final void setAvatarList(List<String> r100) {
        this.avatarList = r100;
    }

    public final void setButtonText(String r100) {
        this.buttonText = r100;
    }

    public final void setEndTime(Long r100) {
        this.endTime = r100;
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

    public final void setTime(String r100) {
        this.time = r100;
    }

    public final void setUpdateAvatar(String r100) {
        this.updateAvatar = r100;
    }
}
