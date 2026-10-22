package com.bytedanceos.appstore.buss.cms.beta.entity.element;

import com.bytedance.apm.constant.CommonKey;
import com.bytedanceos.common.model.AppInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/bytedanceos/appstore/buss/cms/beta/entity/element/ElementPictureInfoEntity;", "", CommonKey.KEY_VALUE, "", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "component1", "copy", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "hashCode", "", "toString", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ElementPictureInfoEntity {

    @Nullable
    private final String value;

    public ElementPictureInfoEntity(@Nullable String r10) {
        this.value = r10;
    }

    public static /* synthetic */ ElementPictureInfoEntity copy$default(ElementPictureInfoEntity r10, String r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r11 = r10.value;
    L6:
        return r10.copy(r11);
    }

    @Nullable
    public final String component1() {
        return this.value;
    }

    @NotNull
    public final ElementPictureInfoEntity copy(@Nullable String r10) {
        return new ElementPictureInfoEntity(r10);
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof ElementPictureInfoEntity) == true) goto L9;
        return false;
    L9:
        if (q.b(this.value, ((ElementPictureInfoEntity) r10).value) == true) goto L11;
        return false;
    L11:
        return true;
    }

    @Nullable
    public final String getValue() {
        return this.value;
    }

    public int hashCode() {
        String r10 = this.value;
        if (r10 != null) goto L6;
        return 0;
    L6:
        return r10.hashCode();
    }

    @NotNull
    public String toString() {
        return "ElementPictureInfoEntity(value=" + this.value + ')';
    }
}
