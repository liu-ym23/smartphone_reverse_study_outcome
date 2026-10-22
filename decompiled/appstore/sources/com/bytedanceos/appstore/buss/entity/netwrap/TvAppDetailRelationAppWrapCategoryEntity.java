package com.bytedanceos.appstore.buss.entity.netwrap;

import com.bytedanceos.common.model.AppInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedanceos/appstore/buss/entity/netwrap/TvAppDetailRelationAppWrapCategoryEntity;", "", "id", "", "name", "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "component1", "component2", "copy", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "hashCode", "", "toString", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TvAppDetailRelationAppWrapCategoryEntity {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @NotNull
    private final String f8436id;

    @NotNull
    private final String name;

    public TvAppDetailRelationAppWrapCategoryEntity(@NotNull String r10, @NotNull String r11) {
        q.g(r10, "id");
        q.g(r11, "name");
        this.f8436id = r10;
        this.name = r11;
    }

    public static /* synthetic */ TvAppDetailRelationAppWrapCategoryEntity copy$default(TvAppDetailRelationAppWrapCategoryEntity r10, String r11, String r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = r10.f8436id;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r12 = r10.name;
    L9:
        return r10.copy(r11, r12);
    }

    @NotNull
    public final String component1() {
        return this.f8436id;
    }

    @NotNull
    public final String component2() {
        return this.name;
    }

    @NotNull
    public final TvAppDetailRelationAppWrapCategoryEntity copy(@NotNull String r10, @NotNull String r11) {
        q.g(r10, "id");
        q.g(r11, "name");
        return new TvAppDetailRelationAppWrapCategoryEntity(r10, r11);
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof TvAppDetailRelationAppWrapCategoryEntity) == true) goto L8;
        return false;
    L8:
        TvAppDetailRelationAppWrapCategoryEntity r11 = (TvAppDetailRelationAppWrapCategoryEntity) r10;
        if (q.b(this.f8436id, r11.f8436id) == true) goto L12;
        return false;
    L12:
        if (q.b(this.name, r11.name) == true) goto L14;
        return false;
    L14:
        return true;
    }

    @NotNull
    public final String getId() {
        return this.f8436id;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        return (this.f8436id.hashCode() * 31) + this.name.hashCode();
    }

    @NotNull
    public String toString() {
        return "TvAppDetailRelationAppWrapCategoryEntity(id=" + this.f8436id + ", name=" + this.name + ')';
    }
}
