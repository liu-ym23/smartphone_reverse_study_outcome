package com.bytedanceos.appstore.buss.cms.beta.entity.element;

import com.bytedance.apm.constant.CommonKey;
import com.bytedanceos.appstore.buss.cms.beta.entity.BetaElementEntity;
import com.bytedanceos.common.model.AppInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0018\u0010\u0002\u001a\u0014\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0003\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u001b\u0010\b\u001a\u0014\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0003\u0018\u00010\u0003HÆ\u0003J%\u0010\t\u001a\u00020\u00002\u001a\b\u0002\u0010\u0002\u001a\u0014\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0003\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R#\u0010\u0002\u001a\u0014\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0003\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/bytedanceos/appstore/buss/cms/beta/entity/element/ElementArrayInfoEntity;", "", CommonKey.KEY_VALUE, "", "Lcom/bytedanceos/appstore/buss/cms/beta/entity/BetaElementEntity;", "(Ljava/util/List;)V", "getValue", "()Ljava/util/List;", "component1", "copy", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "hashCode", "", "toString", "", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ElementArrayInfoEntity {

    @Nullable
    private final List<List<BetaElementEntity<?>>> value;

    /* JADX WARN: Multi-variable type inference failed */
    public ElementArrayInfoEntity(@Nullable List<? extends List<? extends BetaElementEntity<?>>> r10) {
        this.value = r10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ElementArrayInfoEntity copy$default(ElementArrayInfoEntity r10, List r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r11 = r10.value;
    L6:
        return r10.copy(r11);
    }

    @Nullable
    public final List<List<BetaElementEntity<?>>> component1() {
        return this.value;
    }

    @NotNull
    public final ElementArrayInfoEntity copy(@Nullable List<? extends List<? extends BetaElementEntity<?>>> r10) {
        return new ElementArrayInfoEntity(r10);
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof ElementArrayInfoEntity) == true) goto L9;
        return false;
    L9:
        if (q.b(this.value, ((ElementArrayInfoEntity) r10).value) == true) goto L11;
        return false;
    L11:
        return true;
    }

    @Nullable
    public final List<List<BetaElementEntity<?>>> getValue() {
        return this.value;
    }

    public int hashCode() {
        List<List<BetaElementEntity<?>>> r10 = this.value;
        if (r10 != null) goto L6;
        return 0;
    L6:
        return r10.hashCode();
    }

    @NotNull
    public String toString() {
        return "ElementArrayInfoEntity(value=" + this.value + ')';
    }
}
