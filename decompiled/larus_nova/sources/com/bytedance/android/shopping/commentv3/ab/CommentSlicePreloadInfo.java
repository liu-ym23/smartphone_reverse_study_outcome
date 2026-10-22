package com.bytedance.android.shopping.commentv3.ab;

import com.bytedance.android.ecom.slice.ext.template.gecko.j;
import com.google.gson.annotations.SerializedName;
import ec3.b;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bR*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/android/shopping/commentv3/ab/CommentSlicePreloadInfo;", "Ljava/io/Serializable;", "", "Lcom/bytedance/android/ecom/slice/ext/template/gecko/j;", "preloadTmpList", "Ljava/util/List;", "getPreloadTmpList", "()Ljava/util/List;", "setPreloadTmpList", "(Ljava/util/List;)V", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentSlicePreloadInfo implements Serializable {

    @SerializedName("preload_tmp_list")
    private List<j> preloadTmpList;

    public CommentSlicePreloadInfo() {
        CommentSlicePreloadInfo r100 = b.f472075a;
        this.preloadTmpList = b.f472076b;
    }

    public final List<j> getPreloadTmpList() {
        return this.preloadTmpList;
    }

    public final void setPreloadTmpList(List<j> r100) {
        this.preloadTmpList = r100;
    }
}
