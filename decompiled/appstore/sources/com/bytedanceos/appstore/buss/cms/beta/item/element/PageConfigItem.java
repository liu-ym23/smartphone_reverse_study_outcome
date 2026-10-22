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
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J+\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\b\u0010\u001b\u001a\u00020\u0005H\u0016J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/bytedanceos/appstore/buss/cms/beta/item/element/PageConfigItem;", "Lcom/bytedanceos/appstore/buss/cms/beta/item/ElementItem;", "pageTitle", "", "showSearch", "", "pageBackground", "(Ljava/lang/String;ZLjava/lang/String;)V", "getPageBackground", "()Ljava/lang/String;", "setPageBackground", "(Ljava/lang/String;)V", "getPageTitle", "setPageTitle", "getShowSearch", "()Z", "setShowSearch", "(Z)V", "component1", "component2", "component3", "copy", "equals", AppInfo.SEARCH_SOURCE_EXTENAL, "", "hashCode", "", "isAvailable", "toString", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PageConfigItem extends ElementItem {

    @Nullable
    private String pageBackground;

    @Nullable
    private String pageTitle;
    private boolean showSearch;

    public PageConfigItem() {
        String r10 = null;
        boolean r11 = false;
        String r12 = null;
        this(r10, r11, r12, 7, null);
    }

    public static /* synthetic */ PageConfigItem copy$default(PageConfigItem r10, String r11, boolean r12, String r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r11 = r10.pageTitle;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r12 = r10.showSearch;
    L9:
        if ((r14 & 4) == 0) goto L12;
        r13 = r10.pageBackground;
    L12:
        return r10.copy(r11, r12, r13);
    }

    @Nullable
    public final String component1() {
        return this.pageTitle;
    }

    public final boolean component2() {
        return this.showSearch;
    }

    @Nullable
    public final String component3() {
        return this.pageBackground;
    }

    @NotNull
    public final PageConfigItem copy(@Nullable String r10, boolean r11, @Nullable String r12) {
        return new PageConfigItem(r10, r11, r12);
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof PageConfigItem) == true) goto L8;
        return false;
    L8:
        PageConfigItem r11 = (PageConfigItem) r10;
        if (q.b(this.pageTitle, r11.pageTitle) == true) goto L12;
        return false;
    L12:
        if (this.showSearch == r11.showSearch) goto L15;
        return false;
    L15:
        if (q.b(this.pageBackground, r11.pageBackground) == true) goto L17;
        return false;
    L17:
        return true;
    }

    @Nullable
    public final String getPageBackground() {
        return this.pageBackground;
    }

    @Nullable
    public final String getPageTitle() {
        return this.pageTitle;
    }

    public final boolean getShowSearch() {
        return this.showSearch;
    }

    public int hashCode() {
        String r10 = this.pageTitle;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = ((r12 * 31) + Boolean.hashCode(this.showSearch)) * 31;
        String r14 = this.pageBackground;
        if (r14 == null) goto L11;
        r11 = r14.hashCode();
    L11:
        return r13 + r11;
    L5:
        r12 = r10.hashCode();
        goto L6
    }

    @Override // com.bytedanceos.appstore.buss.cms.beta.item.ElementItem
    public boolean isAvailable() {
        String r10 = this.pageTitle;
        if (r10 == null) goto L7;
        if (o.r(r10) == true) goto L7;
    L13:
        return true;
    L7:
        if (this.showSearch == true) goto L13;
        String r11 = this.pageBackground;
        if (r11 != null) goto L11;
    L12:
        return false;
    L11:
        if (o.r(r11) == false) goto L13;
        goto L12
    }

    public final void setPageBackground(@Nullable String r10) {
        this.pageBackground = r10;
    }

    public final void setPageTitle(@Nullable String r10) {
        this.pageTitle = r10;
    }

    public final void setShowSearch(boolean r10) {
        this.showSearch = r10;
    }

    @NotNull
    public String toString() {
        return "PageConfigItem(pageTitle=" + this.pageTitle + ", showSearch=" + this.showSearch + ", pageBackground=" + this.pageBackground + ')';
    }

    public /* synthetic */ PageConfigItem(String r10, boolean r11, String r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 1) == 0) goto L6;
        r10 = null;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r11 = false;
    L9:
        if ((r13 & 4) == 0) goto L11;
        r12 = null;
    L11:
        this(r10, r11, r12);
    }

    public PageConfigItem(@Nullable String r10, boolean r11, @Nullable String r12) {
        this.pageTitle = r10;
        this.showSearch = r11;
        this.pageBackground = r12;
    }
}
