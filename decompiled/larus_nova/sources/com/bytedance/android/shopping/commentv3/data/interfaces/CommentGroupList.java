package com.bytedance.android.shopping.commentv3.data.interfaces;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R&\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR&\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR&\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/shopping/commentv3/data/interfaces/CommentGroupList;", "Ljava/io/Serializable;", "()V", "listGroups", "", "Lcom/bytedance/android/shopping/commentv3/data/interfaces/CommentGroup;", "getListGroups", "()Ljava/util/List;", "setListGroups", "(Ljava/util/List;)V", "multiPicGroups", "getMultiPicGroups", "setMultiPicGroups", "topGroups", "getTopGroups", "setTopGroups", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentGroupList implements Serializable {

    @SerializedName("list_components")
    private List<CommentGroup> listGroups;

    @SerializedName("multi_pic_components")
    private List<CommentGroup> multiPicGroups;

    @SerializedName("top_components")
    private List<CommentGroup> topGroups;

    public CommentGroupList() {
    }

    public final List<CommentGroup> getListGroups() {
        return this.listGroups;
    }

    public final List<CommentGroup> getMultiPicGroups() {
        return this.multiPicGroups;
    }

    public final List<CommentGroup> getTopGroups() {
        return this.topGroups;
    }

    public final void setListGroups(List<CommentGroup> r100) {
        this.listGroups = r100;
    }

    public final void setMultiPicGroups(List<CommentGroup> r100) {
        this.multiPicGroups = r100;
    }

    public final void setTopGroups(List<CommentGroup> r100) {
        this.topGroups = r100;
    }
}
