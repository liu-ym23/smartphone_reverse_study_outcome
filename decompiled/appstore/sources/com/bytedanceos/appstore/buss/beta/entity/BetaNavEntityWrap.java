package com.bytedanceos.appstore.buss.beta.entity;

import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.ServerElements;
import com.chad.library.adapter.base.entity.node.BaseExpandNode;
import com.chad.library.adapter.base.entity.node.BaseNode;
import com.tmall.wireless.tangram.dataparser.concrete.Card;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.y;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\u0011\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\t\u0010 \u001a\u00020\nHÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003JC\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010#\u001a\u00020\n2\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020\u0003HÖ\u0001J\t\u0010'\u001a\u00020\u0005HÖ\u0001R\u001c\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006("}, d2 = {"Lcom/bytedanceos/appstore/buss/beta/entity/BetaNavEntityWrap;", "Lcom/chad/library/adapter/base/entity/node/BaseExpandNode;", ServerElements.GROUP_ID, "", "title", "", Card.KEY_ITEMS, "", "Lcom/bytedanceos/appstore/buss/beta/entity/BetaNavTitleEntity;", "showCount", "", "countNum", "(ILjava/lang/String;Ljava/util/List;ZI)V", "childNode", "Lcom/chad/library/adapter/base/entity/node/BaseNode;", "getChildNode", "()Ljava/util/List;", "getCountNum", "()I", "setCountNum", "(I)V", "getGroup_id", "getItems", "getShowCount", "()Z", "setShowCount", "(Z)V", "getTitle", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", AppInfo.SEARCH_SOURCE_EXTENAL, "", "hashCode", "toString", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class BetaNavEntityWrap extends BaseExpandNode {
    private int countNum;
    private final int group_id;

    @Nullable
    private final List<BetaNavTitleEntity> items;
    private boolean showCount;

    @NotNull
    private final String title;

    public BetaNavEntityWrap(int r10, @NotNull String r11, @Nullable List<BetaNavTitleEntity> r12, boolean r13, int r14) {
        q.g(r11, "title");
        this.group_id = r10;
        this.title = r11;
        this.items = r12;
        this.showCount = r13;
        this.countNum = r14;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BetaNavEntityWrap copy$default(BetaNavEntityWrap r10, int r11, String r12, List r13, boolean r14, int r15, int r16, Object r17) {
        if ((r16 & 1) == 0) goto L6;
        r11 = r10.group_id;
    L6:
        if ((r16 & 2) == 0) goto L8;
        r12 = r10.title;
    L8:
        String r18 = r12;
        if ((r16 & 4) == 0) goto L11;
        r13 = r10.items;
    L11:
        List r19 = r13;
        if ((r16 & 8) == 0) goto L14;
        r14 = r10.showCount;
    L14:
        boolean r20 = r14;
        if ((r16 & 16) == 0) goto L17;
        r15 = r10.countNum;
    L17:
        int r21 = r11;
        return r10.copy(r21, r18, r19, r20, r15);
    }

    public final int component1() {
        return this.group_id;
    }

    @NotNull
    public final String component2() {
        return this.title;
    }

    @Nullable
    public final List<BetaNavTitleEntity> component3() {
        return this.items;
    }

    public final boolean component4() {
        return this.showCount;
    }

    public final int component5() {
        return this.countNum;
    }

    @NotNull
    public final BetaNavEntityWrap copy(int r10, @NotNull String r11, @Nullable List<BetaNavTitleEntity> r12, boolean r13, int r14) {
        q.g(r11, "title");
        return new BetaNavEntityWrap(r10, r11, r12, r13, r14);
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof BetaNavEntityWrap) == true) goto L8;
        return false;
    L8:
        BetaNavEntityWrap r11 = (BetaNavEntityWrap) r10;
        if (this.group_id == r11.group_id) goto L12;
        return false;
    L12:
        if (q.b(this.title, r11.title) == true) goto L15;
        return false;
    L15:
        if (q.b(this.items, r11.items) == true) goto L18;
        return false;
    L18:
        if (this.showCount == r11.showCount) goto L21;
        return false;
    L21:
        if (this.countNum == r11.countNum) goto L23;
        return false;
    L23:
        return true;
    }

    @Override // com.chad.library.adapter.base.entity.node.BaseNode
    @Nullable
    public List<BaseNode> getChildNode() {
        List<BetaNavTitleEntity> r10 = this.items;
        if (r10 != null) goto L5;
        return null;
    L5:
        q.e(r10, "null cannot be cast to non-null type kotlin.collections.MutableList<com.chad.library.adapter.base.entity.node.BaseNode>");
        return y.c(r10);
    }

    public final int getCountNum() {
        return this.countNum;
    }

    public final int getGroup_id() {
        return this.group_id;
    }

    @Nullable
    public final List<BetaNavTitleEntity> getItems() {
        return this.items;
    }

    public final boolean getShowCount() {
        return this.showCount;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int r10 = ((Integer.hashCode(this.group_id) * 31) + this.title.hashCode()) * 31;
        List<BetaNavTitleEntity> r11 = this.items;
        if (r11 != null) goto L5;
        int r12 = 0;
    L7:
        return ((((r10 + r12) * 31) + Boolean.hashCode(this.showCount)) * 31) + Integer.hashCode(this.countNum);
    L5:
        r12 = r11.hashCode();
        goto L7
    }

    public final void setCountNum(int r10) {
        this.countNum = r10;
    }

    public final void setShowCount(boolean r10) {
        this.showCount = r10;
    }

    @NotNull
    public String toString() {
        return "BetaNavEntityWrap(group_id=" + this.group_id + ", title=" + this.title + ", items=" + this.items + ", showCount=" + this.showCount + ", countNum=" + this.countNum + ')';
    }
}
