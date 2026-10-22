package com.bytedanceos.appstore.buss.cms.beta.item;

import com.bytedanceos.appstore.buss.cms.beta.entity.element.ElementJumpInfoEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH&J\u0006\u0010\u000b\u001a\u00020\nR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/bytedanceos/appstore/buss/cms/beta/item/ElementItem;", "", "()V", "jumpInfo", "Lcom/bytedanceos/appstore/buss/cms/beta/entity/element/ElementJumpInfoEntity;", "getJumpInfo", "()Lcom/bytedanceos/appstore/buss/cms/beta/entity/element/ElementJumpInfoEntity;", "setJumpInfo", "(Lcom/bytedanceos/appstore/buss/cms/beta/entity/element/ElementJumpInfoEntity;)V", "isAvailable", "", "jumpIsAvailable", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class ElementItem {

    @Nullable
    private ElementJumpInfoEntity jumpInfo;

    public ElementItem() {
    }

    @Nullable
    public final ElementJumpInfoEntity getJumpInfo() {
        return this.jumpInfo;
    }

    public abstract boolean isAvailable();

    public final boolean jumpIsAvailable() {
        ElementJumpInfoEntity r10 = this.jumpInfo;
        if (r10 == null) goto L7;
        q.d(r10);
        if (r10.isAvailable() == false) goto L7;
        return true;
    L7:
        return false;
    }

    public final void setJumpInfo(@Nullable ElementJumpInfoEntity r10) {
        this.jumpInfo = r10;
    }
}
