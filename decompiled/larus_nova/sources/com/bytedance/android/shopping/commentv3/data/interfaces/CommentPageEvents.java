package com.bytedance.android.shopping.commentv3.data.interfaces;

import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R4\u0010\u0003\u001a\u0018\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR4\u0010\f\u001a\u0018\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/shopping/commentv3/data/interfaces/CommentPageEvents;", "Ljava/io/Serializable;", "()V", LynxVideoManagerLite.EVENT_ON_APPEAR, "", "", "", "", "getOnAppear", "()Ljava/util/List;", "setOnAppear", "(Ljava/util/List;)V", "onDisappear", "getOnDisappear", "setOnDisappear", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentPageEvents implements Serializable {

    @SerializedName("on_appear")
    private List<? extends Map<String, ? extends Object>> onAppear;

    @SerializedName("on_disappear")
    private List<? extends Map<String, ? extends Object>> onDisappear;

    public CommentPageEvents() {
    }

    public final List<Map<String, Object>> getOnAppear() {
        return this.onAppear;
    }

    public final List<Map<String, Object>> getOnDisappear() {
        return this.onDisappear;
    }

    public final void setOnAppear(List<? extends Map<String, ? extends Object>> r100) {
        this.onAppear = r100;
    }

    public final void setOnDisappear(List<? extends Map<String, ? extends Object>> r100) {
        this.onDisappear = r100;
    }
}
