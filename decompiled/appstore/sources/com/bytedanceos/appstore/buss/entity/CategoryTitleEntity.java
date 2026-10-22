package com.bytedanceos.appstore.buss.entity;

import com.bytedanceos.common.model.AppInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/bytedanceos/appstore/buss/entity/CategoryTitleEntity;", "", "id", "", "name", "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "getName", "setName", "component1", "component2", "copy", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "hashCode", "", "toString", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class CategoryTitleEntity {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @Nullable
    private String f8430id;

    @Nullable
    private String name;

    /* JADX WARN: Multi-variable type inference failed */
    public CategoryTitleEntity() {
        Object[] r10 = 0 == true ? 1 : 0;
        this(null, r10, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ CategoryTitleEntity copy$default(CategoryTitleEntity r10, String r11, String r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = r10.f8430id;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r12 = r10.name;
    L9:
        return r10.copy(r11, r12);
    }

    @Nullable
    public final String component1() {
        return this.f8430id;
    }

    @Nullable
    public final String component2() {
        return this.name;
    }

    @NotNull
    public final CategoryTitleEntity copy(@Nullable String r10, @Nullable String r11) {
        return new CategoryTitleEntity(r10, r11);
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof CategoryTitleEntity) == true) goto L8;
        return false;
    L8:
        CategoryTitleEntity r11 = (CategoryTitleEntity) r10;
        if (q.b(this.f8430id, r11.f8430id) == true) goto L12;
        return false;
    L12:
        if (q.b(this.name, r11.name) == true) goto L14;
        return false;
    L14:
        return true;
    }

    @Nullable
    public final String getId() {
        return this.f8430id;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        String r10 = this.f8430id;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = r12 * 31;
        String r14 = this.name;
        if (r14 == null) goto L11;
        r11 = r14.hashCode();
    L11:
        return r13 + r11;
    L5:
        r12 = r10.hashCode();
        goto L6
    }

    public final void setId(@Nullable String r10) {
        this.f8430id = r10;
    }

    public final void setName(@Nullable String r10) {
        this.name = r10;
    }

    @NotNull
    public String toString() {
        return "CategoryTitleEntity(id=" + this.f8430id + ", name=" + this.name + ')';
    }

    public CategoryTitleEntity(@Nullable String r10, @Nullable String r11) {
        this.f8430id = r10;
        this.name = r11;
    }

    public /* synthetic */ CategoryTitleEntity(String r10, String r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = null;
    L6:
        if ((r12 & 2) == 0) goto L8;
        r11 = null;
    L8:
        this(r10, r11);
    }
}
