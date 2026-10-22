package com.bytedanceos.appstore.buss.entity;

import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.ServerElements;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/bytedanceos/appstore/buss/entity/SearchBannerEntity;", "", "packageName", "", ServerElements.BRIEF, "name", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBrief", "()Ljava/lang/String;", "getName", "getPackageName", "component1", "component2", "component3", "copy", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "hashCode", "", "toString", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SearchBannerEntity {

    @NotNull
    private final String brief;

    @NotNull
    private final String name;

    @SerializedName("package")
    @NotNull
    private final String packageName;

    public SearchBannerEntity(@NotNull String r10, @NotNull String r11, @NotNull String r12) {
        q.g(r10, "packageName");
        q.g(r11, ServerElements.BRIEF);
        q.g(r12, "name");
        this.packageName = r10;
        this.brief = r11;
        this.name = r12;
    }

    public static /* synthetic */ SearchBannerEntity copy$default(SearchBannerEntity r10, String r11, String r12, String r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r11 = r10.packageName;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r12 = r10.brief;
    L9:
        if ((r14 & 4) == 0) goto L12;
        r13 = r10.name;
    L12:
        return r10.copy(r11, r12, r13);
    }

    @NotNull
    public final String component1() {
        return this.packageName;
    }

    @NotNull
    public final String component2() {
        return this.brief;
    }

    @NotNull
    public final String component3() {
        return this.name;
    }

    @NotNull
    public final SearchBannerEntity copy(@NotNull String r10, @NotNull String r11, @NotNull String r12) {
        q.g(r10, "packageName");
        q.g(r11, ServerElements.BRIEF);
        q.g(r12, "name");
        return new SearchBannerEntity(r10, r11, r12);
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof SearchBannerEntity) == true) goto L8;
        return false;
    L8:
        SearchBannerEntity r11 = (SearchBannerEntity) r10;
        if (q.b(this.packageName, r11.packageName) == true) goto L12;
        return false;
    L12:
        if (q.b(this.brief, r11.brief) == true) goto L15;
        return false;
    L15:
        if (q.b(this.name, r11.name) == true) goto L17;
        return false;
    L17:
        return true;
    }

    @NotNull
    public final String getBrief() {
        return this.brief;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getPackageName() {
        return this.packageName;
    }

    public int hashCode() {
        return (((this.packageName.hashCode() * 31) + this.brief.hashCode()) * 31) + this.name.hashCode();
    }

    @NotNull
    public String toString() {
        return "SearchBannerEntity(packageName=" + this.packageName + ", brief=" + this.brief + ", name=" + this.name + ')';
    }
}
