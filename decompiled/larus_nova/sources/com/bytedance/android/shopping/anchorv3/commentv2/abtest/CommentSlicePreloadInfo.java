package com.bytedance.android.shopping.anchorv3.commentv2.abtest;

import com.bytedance.android.ecom.slice.ext.template.gecko.j;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import x53.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bR*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/commentv2/abtest/CommentSlicePreloadInfo;", "Ljava/io/Serializable;", "", "Lcom/bytedance/android/ecom/slice/ext/template/gecko/j;", "preloadList", "Ljava/util/List;", "getPreloadList", "()Ljava/util/List;", "setPreloadList", "(Ljava/util/List;)V", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentSlicePreloadInfo implements Serializable {

    @SerializedName("preload_list")
    private List<j> preloadList;

    public CommentSlicePreloadInfo() {
        CommentSlicePreloadInfo r100 = a.f562513a;
        this.preloadList = a.f562514b;
    }

    public final List<j> getPreloadList() {
        return this.preloadList;
    }

    public final void setPreloadList(List<j> r100) {
        this.preloadList = r100;
    }
}
