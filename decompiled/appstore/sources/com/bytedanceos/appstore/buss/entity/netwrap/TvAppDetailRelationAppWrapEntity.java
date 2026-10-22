package com.bytedanceos.appstore.buss.entity.netwrap;

import com.bytedanceos.appstore.buss.entity.CommonAppEntity;
import com.bytedanceos.common.model.AppInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\bHÆ\u0003J3\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\bHÖ\u0001R\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/bytedanceos/appstore/buss/entity/netwrap/TvAppDetailRelationAppWrapEntity;", "", "category", "Lcom/bytedanceos/appstore/buss/entity/netwrap/TvAppDetailRelationAppWrapCategoryEntity;", "apps", "", "Lcom/bytedanceos/appstore/buss/entity/CommonAppEntity;", "name", "", "(Lcom/bytedanceos/appstore/buss/entity/netwrap/TvAppDetailRelationAppWrapCategoryEntity;Ljava/util/List;Ljava/lang/String;)V", "getApps", "()Ljava/util/List;", "getCategory", "()Lcom/bytedanceos/appstore/buss/entity/netwrap/TvAppDetailRelationAppWrapCategoryEntity;", "getName", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "hashCode", "", "toString", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TvAppDetailRelationAppWrapEntity {

    @Nullable
    private final List<CommonAppEntity> apps;

    @Nullable
    private final TvAppDetailRelationAppWrapCategoryEntity category;

    @Nullable
    private final String name;

    public TvAppDetailRelationAppWrapEntity(@Nullable TvAppDetailRelationAppWrapCategoryEntity r10, @Nullable List<CommonAppEntity> r11, @Nullable String r12) {
        this.category = r10;
        this.apps = r11;
        this.name = r12;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TvAppDetailRelationAppWrapEntity copy$default(TvAppDetailRelationAppWrapEntity r10, TvAppDetailRelationAppWrapCategoryEntity r11, List r12, String r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r11 = r10.category;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r12 = r10.apps;
    L9:
        if ((r14 & 4) == 0) goto L12;
        r13 = r10.name;
    L12:
        return r10.copy(r11, r12, r13);
    }

    @Nullable
    public final TvAppDetailRelationAppWrapCategoryEntity component1() {
        return this.category;
    }

    @Nullable
    public final List<CommonAppEntity> component2() {
        return this.apps;
    }

    @Nullable
    public final String component3() {
        return this.name;
    }

    @NotNull
    public final TvAppDetailRelationAppWrapEntity copy(@Nullable TvAppDetailRelationAppWrapCategoryEntity r10, @Nullable List<CommonAppEntity> r11, @Nullable String r12) {
        return new TvAppDetailRelationAppWrapEntity(r10, r11, r12);
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof TvAppDetailRelationAppWrapEntity) == true) goto L8;
        return false;
    L8:
        TvAppDetailRelationAppWrapEntity r11 = (TvAppDetailRelationAppWrapEntity) r10;
        if (q.b(this.category, r11.category) == true) goto L12;
        return false;
    L12:
        if (q.b(this.apps, r11.apps) == true) goto L15;
        return false;
    L15:
        if (q.b(this.name, r11.name) == true) goto L17;
        return false;
    L17:
        return true;
    }

    @Nullable
    public final List<CommonAppEntity> getApps() {
        return this.apps;
    }

    @Nullable
    public final TvAppDetailRelationAppWrapCategoryEntity getCategory() {
        return this.category;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        TvAppDetailRelationAppWrapCategoryEntity r10 = this.category;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = r12 * 31;
        List<CommonAppEntity> r14 = this.apps;
        if (r14 != null) goto L9;
        int r15 = 0;
    L10:
        int r16 = (r13 + r15) * 31;
        String r17 = this.name;
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

    @NotNull
    public String toString() {
        return "TvAppDetailRelationAppWrapEntity(category=" + this.category + ", apps=" + this.apps + ", name=" + this.name + ')';
    }
}
