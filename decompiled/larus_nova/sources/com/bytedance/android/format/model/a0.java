package com.bytedance.android.format.model;

import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/bytedance/android/format/model/a0;", "", "", "avatarUid", "Ljava/lang/String;", "getAvatarUid", "()Ljava/lang/String;", "avatarCid", "getAvatarCid", "playId", "getPlayId", DBDefinition.TASK_ID, "getTaskId", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a0 {

    @SerializedName("avatar_cid")
    private final String avatarCid;

    @SerializedName("avatar_uid")
    private final String avatarUid;

    @SerializedName(InstantPlayContext.PLAY_ID)
    private final String playId;

    @SerializedName(DBDefinition.TASK_ID)
    private final String taskId;

    public a0() {
        this.avatarUid = null;
        this.avatarCid = null;
        this.playId = null;
        this.taskId = null;
    }
}
