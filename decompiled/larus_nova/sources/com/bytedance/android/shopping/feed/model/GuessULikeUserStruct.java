package com.bytedance.android.shopping.feed.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u0003\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/shopping/feed/model/GuessULikeUserStruct;", "Ljava/io/Serializable;", "()V", "isFollowed", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GuessULikeUserStruct implements Serializable {

    @SerializedName("is_followed")
    private final Boolean isFollowed;

    public GuessULikeUserStruct() {
    }

    public final Boolean isFollowed() {
        return this.isFollowed;
    }
}
