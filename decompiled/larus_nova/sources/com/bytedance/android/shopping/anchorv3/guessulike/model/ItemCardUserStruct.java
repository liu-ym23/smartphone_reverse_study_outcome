package com.bytedance.android.shopping.anchorv3.guessulike.model;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u000b\u0010\rR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\n¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/guessulike/model/ItemCardUserStruct;", "Ljava/io/Serializable;", "()V", "avatar", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getAvatar", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "id", "", "getId", "()Ljava/lang/String;", "isFollowed", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", InstantPlayContext.NICKNAME, "getNickname", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ItemCardUserStruct implements Serializable {

    @SerializedName("avatar")
    private final ECUrlModel avatar;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private final String f165110id;

    @SerializedName("is_followed")
    private final Boolean isFollowed;

    @SerializedName(InstantPlayContext.NICKNAME)
    private final String nickname;

    public ItemCardUserStruct() {
    }

    public final ECUrlModel getAvatar() {
        return this.avatar;
    }

    public final String getId() {
        return this.f165110id;
    }

    public final String getNickname() {
        return this.nickname;
    }

    public final Boolean isFollowed() {
        return this.isFollowed;
    }
}
