package com.bytedanceos.appstore.buss.cms.beta.item.element;

import com.bytedanceos.appstore.buss.cms.beta.item.ElementItem;
import com.bytedanceos.common.model.AppInfo;
import com.obric.appstore.network.entity.template.ElementTextEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\b\u0010\u0015\u001a\u00020\u0010H\u0016J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/bytedanceos/appstore/buss/cms/beta/item/element/ElementBlockItem;", "Lcom/bytedanceos/appstore/buss/cms/beta/item/ElementItem;", ElementTextEntity.Key.PICTURE, "", "title", "(Ljava/lang/String;Ljava/lang/String;)V", "getPicture", "()Ljava/lang/String;", "setPicture", "(Ljava/lang/String;)V", "getTitle", "setTitle", "component1", "component2", "copy", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "", "hashCode", "", "isAvailable", "toString", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ElementBlockItem extends ElementItem {

    @Nullable
    private String picture;

    @Nullable
    private String title;

    /* JADX WARN: Multi-variable type inference failed */
    public ElementBlockItem() {
        Object[] r10 = 0 == true ? 1 : 0;
        this(null, r10, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ElementBlockItem copy$default(ElementBlockItem r10, String r11, String r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = r10.picture;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r12 = r10.title;
    L9:
        return r10.copy(r11, r12);
    }

    @Nullable
    public final String component1() {
        return this.picture;
    }

    @Nullable
    public final String component2() {
        return this.title;
    }

    @NotNull
    public final ElementBlockItem copy(@Nullable String r10, @Nullable String r11) {
        return new ElementBlockItem(r10, r11);
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof ElementBlockItem) == true) goto L8;
        return false;
    L8:
        ElementBlockItem r11 = (ElementBlockItem) r10;
        if (q.b(this.picture, r11.picture) == true) goto L12;
        return false;
    L12:
        if (q.b(this.title, r11.title) == true) goto L14;
        return false;
    L14:
        return true;
    }

    @Nullable
    public final String getPicture() {
        return this.picture;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String r10 = this.picture;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = r12 * 31;
        String r14 = this.title;
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
        String r10 = this.picture;
        if (r10 != null) goto L5;
    L13:
        return false;
    L5:
        if (o.r(r10) == true) goto L13;
        String r11 = this.title;
        if (r11 == null) goto L13;
        if (o.r(r11) == true) goto L13;
        return true;
    }

    public final void setPicture(@Nullable String r10) {
        this.picture = r10;
    }

    public final void setTitle(@Nullable String r10) {
        this.title = r10;
    }

    @NotNull
    public String toString() {
        return "ElementBlockItem(picture=" + this.picture + ", title=" + this.title + ')';
    }

    public /* synthetic */ ElementBlockItem(String r10, String r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = null;
    L6:
        if ((r12 & 2) == 0) goto L8;
        r11 = null;
    L8:
        this(r10, r11);
    }

    public ElementBlockItem(@Nullable String r10, @Nullable String r11) {
        this.picture = r10;
        this.title = r11;
    }
}
