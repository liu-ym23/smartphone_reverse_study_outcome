package com.bytedance.android.shopping.anchorv3.commentv2.api;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/commentv2/api/CommentFirstFrameData;", "Ljava/io/Serializable;", "()V", "data", "Lcom/bytedance/android/shopping/anchorv3/commentv2/api/CommentResponse;", "getData", "()Lcom/bytedance/android/shopping/anchorv3/commentv2/api/CommentResponse;", "setData", "(Lcom/bytedance/android/shopping/anchorv3/commentv2/api/CommentResponse;)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentFirstFrameData implements Serializable {

    @SerializedName("head_mixed_list")
    private CommentResponse data;

    public CommentFirstFrameData() {
    }

    public final CommentResponse getData() {
        return this.data;
    }

    public final void setData(CommentResponse r100) {
        this.data = r100;
    }
}
