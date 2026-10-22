package com.bytedanceos.appstore.buss.entity;

import com.bytedanceos.common.model.AppInfo;
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
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\t\u0010 \u001a\u00020\nHÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003JA\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010#\u001a\u00020\n2\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020\u0003HÖ\u0001J\t\u0010'\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000eR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006("}, d2 = {"Lcom/bytedanceos/appstore/buss/entity/NavEntityWrap;", "Lcom/chad/library/adapter/base/entity/node/BaseExpandNode;", "jsonType", "", "title", "", Card.KEY_ITEMS, "", "Lcom/bytedanceos/appstore/buss/entity/NavTitleEntity;", "showCount", "", "appCount", "(ILjava/lang/String;Ljava/util/List;ZI)V", "getAppCount", "()I", "setAppCount", "(I)V", "childNode", "Lcom/chad/library/adapter/base/entity/node/BaseNode;", "getChildNode", "()Ljava/util/List;", "getItems", "getJsonType", "getShowCount", "()Z", "setShowCount", "(Z)V", "getTitle", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", AppInfo.SEARCH_SOURCE_EXTENAL, "", "hashCode", "toString", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class NavEntityWrap extends BaseExpandNode {
    private int appCount;

    @NotNull
    private final List<NavTitleEntity> items;
    private final int jsonType;
    private boolean showCount;

    @NotNull
    private final String title;

    public NavEntityWrap(int r10, @NotNull String r11, @NotNull List<NavTitleEntity> r12, boolean r13, int r14) {
        q.g(r11, "title");
        q.g(r12, Card.KEY_ITEMS);
        this.jsonType = r10;
        this.title = r11;
        this.items = r12;
        this.showCount = r13;
        this.appCount = r14;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ NavEntityWrap copy$default(NavEntityWrap r10, int r11, String r12, List r13, boolean r14, int r15, int r16, Object r17) {
        if ((r16 & 1) == 0) goto L6;
        r11 = r10.jsonType;
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
        r15 = r10.appCount;
    L17:
        int r21 = r11;
        return r10.copy(r21, r18, r19, r20, r15);
    }

    public final int component1() {
        return this.jsonType;
    }

    @NotNull
    public final String component2() {
        return this.title;
    }

    @NotNull
    public final List<NavTitleEntity> component3() {
        return this.items;
    }

    public final boolean component4() {
        return this.showCount;
    }

    public final int component5() {
        return this.appCount;
    }

    @NotNull
    public final NavEntityWrap copy(int r10, @NotNull String r11, @NotNull List<NavTitleEntity> r12, boolean r13, int r14) {
        q.g(r11, "title");
        q.g(r12, Card.KEY_ITEMS);
        return new NavEntityWrap(r10, r11, r12, r13, r14);
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof NavEntityWrap) == true) goto L8;
        return false;
    L8:
        NavEntityWrap r11 = (NavEntityWrap) r10;
        if (this.jsonType == r11.jsonType) goto L12;
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
        if (this.appCount == r11.appCount) goto L23;
        return false;
    L23:
        return true;
    }

    public final int getAppCount() {
        return this.appCount;
    }

    @Override // com.chad.library.adapter.base.entity.node.BaseNode
    @Nullable
    public List<BaseNode> getChildNode() {
        List<NavTitleEntity> r10 = this.items;
        q.e(r10, "null cannot be cast to non-null type kotlin.collections.MutableList<com.chad.library.adapter.base.entity.node.BaseNode>");
        return y.c(r10);
    }

    @NotNull
    public final List<NavTitleEntity> getItems() {
        return this.items;
    }

    public final int getJsonType() {
        return this.jsonType;
    }

    public final boolean getShowCount() {
        return this.showCount;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return (((((((Integer.hashCode(this.jsonType) * 31) + this.title.hashCode()) * 31) + this.items.hashCode()) * 31) + Boolean.hashCode(this.showCount)) * 31) + Integer.hashCode(this.appCount);
    }

    public final void setAppCount(int r10) {
        this.appCount = r10;
    }

    public final void setShowCount(boolean r10) {
        this.showCount = r10;
    }

    @NotNull
    public String toString() {
        return "NavEntityWrap(jsonType=" + this.jsonType + ", title=" + this.title + ", items=" + this.items + ", showCount=" + this.showCount + ", appCount=" + this.appCount + ')';
    }
}
