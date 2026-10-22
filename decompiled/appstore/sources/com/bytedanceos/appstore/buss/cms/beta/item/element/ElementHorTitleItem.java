package com.bytedanceos.appstore.buss.cms.beta.item.element;

import com.bytedanceos.appstore.buss.cms.beta.item.ElementItem;
import com.bytedanceos.common.model.AppInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J7\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010!\u001a\u00020\u00062\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\b\u0010&\u001a\u00020\u0006H\u0016J\t\u0010'\u001a\u00020\u0003HÖ\u0001R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0011\"\u0004\b\u001b\u0010\u0013¨\u0006("}, d2 = {"Lcom/bytedanceos/appstore/buss/cms/beta/item/element/ElementHorTitleItem;", "Lcom/bytedanceos/appstore/buss/cms/beta/item/ElementItem;", "title", "", "subTitle", "showButton", "", "buttonText", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "appList", "", "Lcom/bytedanceos/common/model/AppInfo;", "getAppList", "()Ljava/util/List;", "setAppList", "(Ljava/util/List;)V", "getButtonText", "()Ljava/lang/String;", "setButtonText", "(Ljava/lang/String;)V", "getShowButton", "()Z", "setShowButton", "(Z)V", "getSubTitle", "setSubTitle", "getTitle", "setTitle", "component1", "component2", "component3", "component4", "copy", "equals", AppInfo.SEARCH_SOURCE_EXTENAL, "", "hashCode", "", "isAvailable", "toString", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ElementHorTitleItem extends ElementItem {

    @Nullable
    private List<? extends AppInfo> appList;

    @Nullable
    private String buttonText;
    private boolean showButton;

    @Nullable
    private String subTitle;

    @Nullable
    private String title;

    public ElementHorTitleItem() {
        String r10 = null;
        String r11 = null;
        boolean r12 = false;
        String r13 = null;
        this(r10, r11, r12, r13, 15, null);
    }

    public static /* synthetic */ ElementHorTitleItem copy$default(ElementHorTitleItem r10, String r11, String r12, boolean r13, String r14, int r15, Object r16) {
        if ((r15 & 1) == 0) goto L6;
        r11 = r10.title;
    L6:
        if ((r15 & 2) == 0) goto L9;
        r12 = r10.subTitle;
    L9:
        if ((r15 & 4) == 0) goto L12;
        r13 = r10.showButton;
    L12:
        if ((r15 & 8) == 0) goto L15;
        r14 = r10.buttonText;
    L15:
        return r10.copy(r11, r12, r13, r14);
    }

    @Nullable
    public final String component1() {
        return this.title;
    }

    @Nullable
    public final String component2() {
        return this.subTitle;
    }

    public final boolean component3() {
        return this.showButton;
    }

    @Nullable
    public final String component4() {
        return this.buttonText;
    }

    @NotNull
    public final ElementHorTitleItem copy(@Nullable String r10, @Nullable String r11, boolean r12, @Nullable String r13) {
        return new ElementHorTitleItem(r10, r11, r12, r13);
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof ElementHorTitleItem) == true) goto L8;
        return false;
    L8:
        ElementHorTitleItem r11 = (ElementHorTitleItem) r10;
        if (q.b(this.title, r11.title) == true) goto L12;
        return false;
    L12:
        if (q.b(this.subTitle, r11.subTitle) == true) goto L15;
        return false;
    L15:
        if (this.showButton == r11.showButton) goto L18;
        return false;
    L18:
        if (q.b(this.buttonText, r11.buttonText) == true) goto L20;
        return false;
    L20:
        return true;
    }

    @Nullable
    public final List<AppInfo> getAppList() {
        return this.appList;
    }

    @Nullable
    public final String getButtonText() {
        return this.buttonText;
    }

    public final boolean getShowButton() {
        return this.showButton;
    }

    @Nullable
    public final String getSubTitle() {
        return this.subTitle;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String r10 = this.title;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = r12 * 31;
        String r14 = this.subTitle;
        if (r14 != null) goto L9;
        int r15 = 0;
    L10:
        int r16 = (((r13 + r15) * 31) + Boolean.hashCode(this.showButton)) * 31;
        String r17 = this.buttonText;
        if (r17 == null) goto L15;
        r11 = r17.hashCode();
    L15:
        return r16 + r11;
    L9:
        r15 = r14.hashCode();
        goto L10
    L5:
        r12 = r10.hashCode();
        goto L6
    }

    @Override // com.bytedanceos.appstore.buss.cms.beta.item.ElementItem
    public boolean isAvailable() {
        String r10 = this.title;
        if (r10 != null) goto L5;
    L8:
        boolean r11 = true;
    L10:
        return !r11;
    L5:
        if (o.r(r10) == true) goto L8;
        r11 = false;
        goto L10
    }

    public final void setAppList(@Nullable List<? extends AppInfo> r10) {
        this.appList = r10;
    }

    public final void setButtonText(@Nullable String r10) {
        this.buttonText = r10;
    }

    public final void setShowButton(boolean r10) {
        this.showButton = r10;
    }

    public final void setSubTitle(@Nullable String r10) {
        this.subTitle = r10;
    }

    public final void setTitle(@Nullable String r10) {
        this.title = r10;
    }

    @NotNull
    public String toString() {
        return "ElementHorTitleItem(title=" + this.title + ", subTitle=" + this.subTitle + ", showButton=" + this.showButton + ", buttonText=" + this.buttonText + ')';
    }

    public /* synthetic */ ElementHorTitleItem(String r10, String r11, boolean r12, String r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 1) == 0) goto L6;
        r10 = null;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r11 = null;
    L9:
        if ((r14 & 4) == 0) goto L12;
        r12 = false;
    L12:
        if ((r14 & 8) == 0) goto L14;
        r13 = null;
    L14:
        this(r10, r11, r12, r13);
    }

    public ElementHorTitleItem(@Nullable String r10, @Nullable String r11, boolean r12, @Nullable String r13) {
        this.title = r10;
        this.subTitle = r11;
        this.showButton = r12;
        this.buttonText = r13;
    }
}
