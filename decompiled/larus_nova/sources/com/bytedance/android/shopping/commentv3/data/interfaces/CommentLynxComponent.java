package com.bytedance.android.shopping.commentv3.data.interfaces;

import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R.\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR,\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR \u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/shopping/commentv3/data/interfaces/CommentLynxComponent;", "Lcom/bytedance/android/shopping/commentv3/data/interfaces/ICommentComponent;", "()V", "data", "", "", "", "getData", "()Ljava/util/Map;", "setData", "(Ljava/util/Map;)V", "style", "getStyle", "setStyle", ThumbGlideUrl.SOURCE_TEMPLATE, "Lcom/bytedance/android/shopping/commentv3/data/interfaces/CommentTemplate;", "getTemplate", "()Lcom/bytedance/android/shopping/commentv3/data/interfaces/CommentTemplate;", "setTemplate", "(Lcom/bytedance/android/shopping/commentv3/data/interfaces/CommentTemplate;)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentLynxComponent extends ICommentComponent {

    @SerializedName("data")
    private Map<String, ? extends Object> data;

    @SerializedName("style")
    private Map<String, ? extends Object> style;

    @SerializedName(ThumbGlideUrl.SOURCE_TEMPLATE)
    private CommentTemplate template;

    public CommentLynxComponent() {
    }

    public final Map<String, Object> getData() {
        return this.data;
    }

    public final Map<String, Object> getStyle() {
        return this.style;
    }

    public final CommentTemplate getTemplate() {
        return this.template;
    }

    public final void setData(Map<String, ? extends Object> r100) {
        this.data = r100;
    }

    public final void setStyle(Map<String, ? extends Object> r100) {
        this.style = r100;
    }

    public final void setTemplate(CommentTemplate r100) {
        this.template = r100;
    }
}
