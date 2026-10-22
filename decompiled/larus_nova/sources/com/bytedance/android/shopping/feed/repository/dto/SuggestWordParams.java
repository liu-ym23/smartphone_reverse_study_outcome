package com.bytedance.android.shopping.feed.repository.dto;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/bytedance/android/shopping/feed/repository/dto/SuggestWordParams;", "Ljava/io/Serializable;", "()V", "challengeId", "", "getChallengeId", "()Ljava/lang/String;", "extraInfo", "Lcom/bytedance/android/shopping/feed/repository/dto/ExtraInfo;", "getExtraInfo", "()Lcom/bytedance/android/shopping/feed/repository/dto/ExtraInfo;", "reason", "getReason", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SuggestWordParams implements Serializable {

    @SerializedName("challenge_id")
    private final String challengeId;

    @SerializedName("extra_info")
    private final ExtraInfo extraInfo;

    @SerializedName("reason")
    private final String reason;

    public SuggestWordParams() {
    }

    public final String getChallengeId() {
        return this.challengeId;
    }

    public final ExtraInfo getExtraInfo() {
        return this.extraInfo;
    }

    public final String getReason() {
        return this.reason;
    }
}
