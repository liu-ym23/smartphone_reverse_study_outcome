package com.bytedance.android.shopping.anchorv4.topnav;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B;\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u001e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/topnav/Config;", "Ljava/io/Serializable;", "scrollNodes", "", "Lcom/bytedance/android/shopping/anchorv4/topnav/TransitionNode;", "transitionNodes", "specialScrollNodes", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getScrollNodes", "()Ljava/util/List;", "getSpecialScrollNodes", "getTransitionNodes", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class Config implements Serializable {

    @SerializedName("scroll_nodes")
    private final List<TransitionNode> scrollNodes;

    @SerializedName("special_scroll_nodes")
    private final List<TransitionNode> specialScrollNodes;

    @SerializedName("transition_nodes")
    private final List<TransitionNode> transitionNodes;

    public Config() {
        this(null, null, null, 7, null);
    }

    public final List<TransitionNode> getScrollNodes() {
        return this.scrollNodes;
    }

    public final List<TransitionNode> getSpecialScrollNodes() {
        return this.specialScrollNodes;
    }

    public final List<TransitionNode> getTransitionNodes() {
        return this.transitionNodes;
    }

    public Config(List<TransitionNode> r100, List<TransitionNode> r101, List<TransitionNode> r102) {
        this.scrollNodes = r100;
        this.transitionNodes = r101;
        this.specialScrollNodes = r102;
    }

    public /* synthetic */ Config(List r100, List r101, List r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
