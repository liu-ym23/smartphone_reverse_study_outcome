package com.bytedance.android.format.model;

import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\"\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u0006\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/format/model/GetAiPlayDramaReGenerateResultRequest;", "", "avatarUid", "", "avatarCid", "playId", "isEdit", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getAvatarCid", "()Ljava/lang/String;", "setAvatarCid", "(Ljava/lang/String;)V", "getAvatarUid", "setAvatarUid", "()Ljava/lang/Boolean;", "setEdit", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getPlayId", "setPlayId", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GetAiPlayDramaReGenerateResultRequest {

    @SerializedName("avatar_cid")
    private String avatarCid;

    @SerializedName("avatar_uid")
    private String avatarUid;

    @SerializedName("is_edit")
    private Boolean isEdit;

    @SerializedName(InstantPlayContext.PLAY_ID)
    private String playId;

    public GetAiPlayDramaReGenerateResultRequest() {
        this(null, null, null, null, 15, null);
    }

    public final String getAvatarCid() {
        return this.avatarCid;
    }

    public final String getAvatarUid() {
        return this.avatarUid;
    }

    public final String getPlayId() {
        return this.playId;
    }

    public final Boolean isEdit() {
        return this.isEdit;
    }

    public final void setAvatarCid(String r100) {
        this.avatarCid = r100;
    }

    public final void setAvatarUid(String r100) {
        this.avatarUid = r100;
    }

    public final void setEdit(Boolean r100) {
        this.isEdit = r100;
    }

    public final void setPlayId(String r100) {
        this.playId = r100;
    }

    public GetAiPlayDramaReGenerateResultRequest(String r100, String r101, String r102, Boolean r103) {
        this.avatarUid = r100;
        this.avatarCid = r101;
        this.playId = r102;
        this.isEdit = r103;
    }

    public /* synthetic */ GetAiPlayDramaReGenerateResultRequest(String r100, String r101, String r102, Boolean r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = Boolean.FALSE;
    L14:
        this(r100, r101, r102, r103);
    }
}
