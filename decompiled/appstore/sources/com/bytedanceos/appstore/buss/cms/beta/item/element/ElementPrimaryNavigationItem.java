package com.bytedanceos.appstore.buss.cms.beta.item.element;

import com.bytedanceos.appstore.buss.cms.beta.item.ElementItem;
import com.bytedanceos.common.model.AppInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\b\u0010\u0015\u001a\u00020\u0010H\u0016J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/bytedanceos/appstore/buss/cms/beta/item/element/ElementPrimaryNavigationItem;", "Lcom/bytedanceos/appstore/buss/cms/beta/item/ElementItem;", "navTitle", "", "navPageId", "(Ljava/lang/String;Ljava/lang/String;)V", "getNavPageId", "()Ljava/lang/String;", "setNavPageId", "(Ljava/lang/String;)V", "getNavTitle", "setNavTitle", "component1", "component2", "copy", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "", "hashCode", "", "isAvailable", "toString", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ElementPrimaryNavigationItem extends ElementItem {

    @NotNull
    private String navPageId;

    @NotNull
    private String navTitle;

    /* JADX WARN: Multi-variable type inference failed */
    public ElementPrimaryNavigationItem() {
        Object[] r10 = 0 == true ? 1 : 0;
        this(null, r10, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ElementPrimaryNavigationItem copy$default(ElementPrimaryNavigationItem r10, String r11, String r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = r10.navTitle;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r12 = r10.navPageId;
    L9:
        return r10.copy(r11, r12);
    }

    @NotNull
    public final String component1() {
        return this.navTitle;
    }

    @NotNull
    public final String component2() {
        return this.navPageId;
    }

    @NotNull
    public final ElementPrimaryNavigationItem copy(@NotNull String r10, @NotNull String r11) {
        q.g(r10, "navTitle");
        q.g(r11, "navPageId");
        return new ElementPrimaryNavigationItem(r10, r11);
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof ElementPrimaryNavigationItem) == true) goto L8;
        return false;
    L8:
        ElementPrimaryNavigationItem r11 = (ElementPrimaryNavigationItem) r10;
        if (q.b(this.navTitle, r11.navTitle) == true) goto L12;
        return false;
    L12:
        if (q.b(this.navPageId, r11.navPageId) == true) goto L14;
        return false;
    L14:
        return true;
    }

    @NotNull
    public final String getNavPageId() {
        return this.navPageId;
    }

    @NotNull
    public final String getNavTitle() {
        return this.navTitle;
    }

    public int hashCode() {
        return (this.navTitle.hashCode() * 31) + this.navPageId.hashCode();
    }

    @Override // com.bytedanceos.appstore.buss.cms.beta.item.ElementItem
    public boolean isAvailable() {
        if (o.r(this.navTitle) == false) goto L5;
    L7:
        return false;
    L5:
        if (o.r(this.navPageId) == true) goto L7;
        return true;
    }

    public final void setNavPageId(@NotNull String r10) {
        q.g(r10, "<set-?>");
        this.navPageId = r10;
    }

    public final void setNavTitle(@NotNull String r10) {
        q.g(r10, "<set-?>");
        this.navTitle = r10;
    }

    @NotNull
    public String toString() {
        return "ElementPrimaryNavigationItem(navTitle=" + this.navTitle + ", navPageId=" + this.navPageId + ')';
    }

    public /* synthetic */ ElementPrimaryNavigationItem(String r10, String r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = "";
    L6:
        if ((r12 & 2) == 0) goto L8;
        r11 = "";
    L8:
        this(r10, r11);
    }

    public ElementPrimaryNavigationItem(@NotNull String r10, @NotNull String r11) {
        q.g(r10, "navTitle");
        q.g(r11, "navPageId");
        this.navTitle = r10;
        this.navPageId = r11;
    }
}
