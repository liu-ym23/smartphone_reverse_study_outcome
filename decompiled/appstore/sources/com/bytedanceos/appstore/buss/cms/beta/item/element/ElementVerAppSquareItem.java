package com.bytedanceos.appstore.buss.cms.beta.item.element;

import com.bytedanceos.appstore.buss.cms.beta.item.ElementAppItem;
import com.bytedanceos.appstore.buss.entity.CommonAppEntity;
import com.bytedanceos.common.model.AppInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/bytedanceos/appstore/buss/cms/beta/item/element/ElementVerAppSquareItem;", "Lcom/bytedanceos/appstore/buss/cms/beta/item/ElementAppItem;", "entity", "Lcom/bytedanceos/appstore/buss/entity/CommonAppEntity;", "(Lcom/bytedanceos/appstore/buss/entity/CommonAppEntity;)V", "getEntity", "()Lcom/bytedanceos/appstore/buss/entity/CommonAppEntity;", "component1", "copy", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "", "hashCode", "", "toString", "", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ElementVerAppSquareItem extends ElementAppItem {

    @NotNull
    private final CommonAppEntity entity;

    public ElementVerAppSquareItem(@NotNull CommonAppEntity r10) {
        q.g(r10, "entity");
        this.entity = r10;
    }

    public static /* synthetic */ ElementVerAppSquareItem copy$default(ElementVerAppSquareItem r10, CommonAppEntity r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r11 = r10.entity;
    L6:
        return r10.copy(r11);
    }

    @NotNull
    public final CommonAppEntity component1() {
        return this.entity;
    }

    @NotNull
    public final ElementVerAppSquareItem copy(@NotNull CommonAppEntity r10) {
        q.g(r10, "entity");
        return new ElementVerAppSquareItem(r10);
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof ElementVerAppSquareItem) == true) goto L9;
        return false;
    L9:
        if (q.b(this.entity, ((ElementVerAppSquareItem) r10).entity) == true) goto L11;
        return false;
    L11:
        return true;
    }

    @NotNull
    public final CommonAppEntity getEntity() {
        return this.entity;
    }

    public int hashCode() {
        return this.entity.hashCode();
    }

    @NotNull
    public String toString() {
        return "ElementVerAppSquareItem(entity=" + this.entity + ')';
    }
}
