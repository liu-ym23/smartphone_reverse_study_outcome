package com.bytedance.android.format.model;

import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/format/model/e;", "", "", "avatarUid", "Ljava/lang/String;", "getAvatarUid", "()Ljava/lang/String;", "avatarCid", "getAvatarCid", "playId", "getPlayId", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e {

    @SerializedName("avatar_cid")
    private final String avatarCid;

    @SerializedName("avatar_uid")
    private final String avatarUid;

    @SerializedName(InstantPlayContext.PLAY_ID)
    private final String playId;

    public e() {
        this.avatarUid = null;
        this.avatarCid = null;
        this.playId = null;
    }
}
