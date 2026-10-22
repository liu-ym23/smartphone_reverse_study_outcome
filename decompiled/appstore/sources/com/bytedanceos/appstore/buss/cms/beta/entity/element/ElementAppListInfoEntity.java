package com.bytedanceos.appstore.buss.cms.beta.entity.element;

import com.bytedance.apm.constant.CommonKey;
import com.bytedanceos.appstore.buss.entity.CommonAppEntity;
import com.bytedanceos.common.model.AppInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\t\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/bytedanceos/appstore/buss/cms/beta/entity/element/ElementAppListInfoEntity;", "", CommonKey.KEY_VALUE, "", "Lcom/bytedanceos/appstore/buss/entity/CommonAppEntity;", "(Ljava/util/List;)V", "getValue", "()Ljava/util/List;", "component1", "copy", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "hashCode", "", "toString", "", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ElementAppListInfoEntity {

    @Nullable
    private final List<CommonAppEntity> value;

    public ElementAppListInfoEntity(@Nullable List<CommonAppEntity> r10) {
        this.value = r10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ElementAppListInfoEntity copy$default(ElementAppListInfoEntity r10, List r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r11 = r10.value;
    L6:
        return r10.copy(r11);
    }

    @Nullable
    public final List<CommonAppEntity> component1() {
        return this.value;
    }

    @NotNull
    public final ElementAppListInfoEntity copy(@Nullable List<CommonAppEntity> r10) {
        return new ElementAppListInfoEntity(r10);
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof ElementAppListInfoEntity) == true) goto L9;
        return false;
    L9:
        if (q.b(this.value, ((ElementAppListInfoEntity) r10).value) == true) goto L11;
        return false;
    L11:
        return true;
    }

    @Nullable
    public final List<CommonAppEntity> getValue() {
        return this.value;
    }

    public int hashCode() {
        List<CommonAppEntity> r10 = this.value;
        if (r10 != null) goto L6;
        return 0;
    L6:
        return r10.hashCode();
    }

    @NotNull
    public String toString() {
        return "ElementAppListInfoEntity(value=" + this.value + ')';
    }
}
