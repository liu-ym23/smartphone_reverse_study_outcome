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
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\b\u0010\u0010\u001a\u00020\u000bH\u0016J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0012"}, d2 = {"Lcom/bytedanceos/appstore/buss/cms/beta/item/element/ElementSmallBannerItem;", "Lcom/bytedanceos/appstore/buss/cms/beta/item/ElementItem;", ElementTextEntity.Key.PICTURE, "", "(Ljava/lang/String;)V", "getPicture", "()Ljava/lang/String;", "setPicture", "component1", "copy", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "", "hashCode", "", "isAvailable", "toString", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ElementSmallBannerItem extends ElementItem {

    @Nullable
    private String picture;

    /* JADX WARN: Multi-variable type inference failed */
    public ElementSmallBannerItem() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ElementSmallBannerItem copy$default(ElementSmallBannerItem r10, String r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r11 = r10.picture;
    L6:
        return r10.copy(r11);
    }

    @Nullable
    public final String component1() {
        return this.picture;
    }

    @NotNull
    public final ElementSmallBannerItem copy(@Nullable String r10) {
        return new ElementSmallBannerItem(r10);
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof ElementSmallBannerItem) == true) goto L9;
        return false;
    L9:
        if (q.b(this.picture, ((ElementSmallBannerItem) r10).picture) == true) goto L11;
        return false;
    L11:
        return true;
    }

    @Nullable
    public final String getPicture() {
        return this.picture;
    }

    public int hashCode() {
        String r10 = this.picture;
        if (r10 != null) goto L6;
        return 0;
    L6:
        return r10.hashCode();
    }

    @Override // com.bytedanceos.appstore.buss.cms.beta.item.ElementItem
    public boolean isAvailable() {
        String r10 = this.picture;
        if (r10 != null) goto L5;
    L10:
        return false;
    L5:
        if (o.r(r10) == true) goto L10;
        if (jumpIsAvailable() == false) goto L10;
        return true;
    }

    public final void setPicture(@Nullable String r10) {
        this.picture = r10;
    }

    @NotNull
    public String toString() {
        return "ElementSmallBannerItem(picture=" + this.picture + ')';
    }

    public /* synthetic */ ElementSmallBannerItem(String r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L5;
        r10 = null;
    L5:
        this(r10);
    }

    public ElementSmallBannerItem(@Nullable String r10) {
        this.picture = r10;
    }
}
