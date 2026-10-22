package com.bytedanceos.appstore.buss.entity;

import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.ServerElements;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0011\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003J9\u0010\u0016\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0007HÖ\u0001R&\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR \u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R&\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\f¨\u0006\u001d"}, d2 = {"Lcom/bytedanceos/appstore/buss/entity/SearchResultRelatedEntityWrap;", "", ServerElements.AD_APPS, "", "Lcom/bytedanceos/appstore/buss/entity/SearchResultPromoteEntity;", "promoteApps", "category", "", "(Ljava/util/List;Ljava/util/List;Ljava/lang/String;)V", "getAdApps", "()Ljava/util/List;", "setAdApps", "(Ljava/util/List;)V", "getCategory", "()Ljava/lang/String;", "setCategory", "(Ljava/lang/String;)V", "getPromoteApps", "setPromoteApps", "component1", "component2", "component3", "copy", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "hashCode", "", "toString", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SearchResultRelatedEntityWrap {

    @SerializedName("ad_apps")
    @Nullable
    private List<SearchResultPromoteEntity> adApps;

    @SerializedName("category")
    @Nullable
    private String category;

    @SerializedName("promote_apps")
    @Nullable
    private List<SearchResultPromoteEntity> promoteApps;

    public SearchResultRelatedEntityWrap() {
        List r10 = null;
        List r11 = null;
        String r12 = null;
        this(r10, r11, r12, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SearchResultRelatedEntityWrap copy$default(SearchResultRelatedEntityWrap r10, List r11, List r12, String r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r11 = r10.adApps;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r12 = r10.promoteApps;
    L9:
        if ((r14 & 4) == 0) goto L12;
        r13 = r10.category;
    L12:
        return r10.copy(r11, r12, r13);
    }

    @Nullable
    public final List<SearchResultPromoteEntity> component1() {
        return this.adApps;
    }

    @Nullable
    public final List<SearchResultPromoteEntity> component2() {
        return this.promoteApps;
    }

    @Nullable
    public final String component3() {
        return this.category;
    }

    @NotNull
    public final SearchResultRelatedEntityWrap copy(@Nullable List<SearchResultPromoteEntity> r10, @Nullable List<SearchResultPromoteEntity> r11, @Nullable String r12) {
        return new SearchResultRelatedEntityWrap(r10, r11, r12);
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof SearchResultRelatedEntityWrap) == true) goto L8;
        return false;
    L8:
        SearchResultRelatedEntityWrap r11 = (SearchResultRelatedEntityWrap) r10;
        if (q.b(this.adApps, r11.adApps) == true) goto L12;
        return false;
    L12:
        if (q.b(this.promoteApps, r11.promoteApps) == true) goto L15;
        return false;
    L15:
        if (q.b(this.category, r11.category) == true) goto L17;
        return false;
    L17:
        return true;
    }

    @Nullable
    public final List<SearchResultPromoteEntity> getAdApps() {
        return this.adApps;
    }

    @Nullable
    public final String getCategory() {
        return this.category;
    }

    @Nullable
    public final List<SearchResultPromoteEntity> getPromoteApps() {
        return this.promoteApps;
    }

    public int hashCode() {
        List<SearchResultPromoteEntity> r10 = this.adApps;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = r12 * 31;
        List<SearchResultPromoteEntity> r14 = this.promoteApps;
        if (r14 != null) goto L9;
        int r15 = 0;
    L10:
        int r16 = (r13 + r15) * 31;
        String r17 = this.category;
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

    public final void setAdApps(@Nullable List<SearchResultPromoteEntity> r10) {
        this.adApps = r10;
    }

    public final void setCategory(@Nullable String r10) {
        this.category = r10;
    }

    public final void setPromoteApps(@Nullable List<SearchResultPromoteEntity> r10) {
        this.promoteApps = r10;
    }

    @NotNull
    public String toString() {
        return "SearchResultRelatedEntityWrap(adApps=" + this.adApps + ", promoteApps=" + this.promoteApps + ", category=" + this.category + ')';
    }

    public SearchResultRelatedEntityWrap(@Nullable List<SearchResultPromoteEntity> r10, @Nullable List<SearchResultPromoteEntity> r11, @Nullable String r12) {
        this.adApps = r10;
        this.promoteApps = r11;
        this.category = r12;
    }

    public /* synthetic */ SearchResultRelatedEntityWrap(List r10, List r11, String r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 1) == 0) goto L6;
        r10 = null;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r11 = null;
    L9:
        if ((r13 & 4) == 0) goto L11;
        r12 = null;
    L11:
        this(r10, r11, r12);
    }
}
