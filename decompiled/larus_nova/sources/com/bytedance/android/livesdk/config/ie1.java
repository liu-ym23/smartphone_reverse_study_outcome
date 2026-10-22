package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\u0018\u00002\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/config/ie1;", "", "", "senderUri", "Ljava/lang/String;", "getSenderUri", "()Ljava/lang/String;", "setSenderUri", "(Ljava/lang/String;)V", "anchorUri", "getAnchorUri", "setAnchorUri", "inviteUri", "getInviteUri", "setInviteUri", "rewardUri", "getRewardUri", "setRewardUri", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ie1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ie1 f120446a = null;

    @SerializedName("anchor_uri")
    private String anchorUri;

    @SerializedName("invite_uri")
    private String inviteUri;

    @SerializedName("reward_uri")
    private String rewardUri;

    @SerializedName("sender_uri")
    private String senderUri;

    public static final class a {
    }

    public static final ie1 a() {
        return f120446a;
    }

    static {
        f120446a = new ie1();
    }

    public ie1() {
        this.senderUri = "";
        this.anchorUri = "";
        this.inviteUri = "";
        this.rewardUri = "";
    }
}
