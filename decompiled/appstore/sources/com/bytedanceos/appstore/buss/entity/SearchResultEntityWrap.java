package com.bytedanceos.appstore.buss.entity;

import com.bytedanceos.common.model.AppInfo;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0011\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003J3\u0010\u0018\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR \u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\u0005\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Lcom/bytedanceos/appstore/buss/entity/SearchResultEntityWrap;", "", "apps", "", "Lcom/bytedanceos/appstore/buss/entity/CommonAppEntity;", "topadApps", "relatedApps", "Lcom/bytedanceos/appstore/buss/entity/SearchResultRelatedEntityWrap;", "(Ljava/util/List;Ljava/lang/Object;Lcom/bytedanceos/appstore/buss/entity/SearchResultRelatedEntityWrap;)V", "getApps", "()Ljava/util/List;", "setApps", "(Ljava/util/List;)V", "getRelatedApps", "()Lcom/bytedanceos/appstore/buss/entity/SearchResultRelatedEntityWrap;", "setRelatedApps", "(Lcom/bytedanceos/appstore/buss/entity/SearchResultRelatedEntityWrap;)V", "getTopadApps", "()Ljava/lang/Object;", "setTopadApps", "(Ljava/lang/Object;)V", "component1", "component2", "component3", "copy", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "hashCode", "", "toString", "", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SearchResultEntityWrap {

    @Nullable
    private List<CommonAppEntity> apps;

    @SerializedName("related_apps")
    @Nullable
    private SearchResultRelatedEntityWrap relatedApps;

    @SerializedName("topad_apps")
    @Nullable
    private Object topadApps;

    public SearchResultEntityWrap(@Nullable List<CommonAppEntity> r10, @Nullable Object r11, @Nullable SearchResultRelatedEntityWrap r12) {
        this.apps = r10;
        this.topadApps = r11;
        this.relatedApps = r12;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SearchResultEntityWrap copy$default(SearchResultEntityWrap r10, List r11, Object r12, SearchResultRelatedEntityWrap r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r11 = r10.apps;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r12 = r10.topadApps;
    L9:
        if ((r14 & 4) == 0) goto L12;
        r13 = r10.relatedApps;
    L12:
        return r10.copy(r11, r12, r13);
    }

    @Nullable
    public final List<CommonAppEntity> component1() {
        return this.apps;
    }

    @Nullable
    public final Object component2() {
        return this.topadApps;
    }

    @Nullable
    public final SearchResultRelatedEntityWrap component3() {
        return this.relatedApps;
    }

    @NotNull
    public final SearchResultEntityWrap copy(@Nullable List<CommonAppEntity> r10, @Nullable Object r11, @Nullable SearchResultRelatedEntityWrap r12) {
        return new SearchResultEntityWrap(r10, r11, r12);
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof SearchResultEntityWrap) == true) goto L8;
        return false;
    L8:
        SearchResultEntityWrap r11 = (SearchResultEntityWrap) r10;
        if (q.b(this.apps, r11.apps) == true) goto L12;
        return false;
    L12:
        if (q.b(this.topadApps, r11.topadApps) == true) goto L15;
        return false;
    L15:
        if (q.b(this.relatedApps, r11.relatedApps) == true) goto L17;
        return false;
    L17:
        return true;
    }

    @Nullable
    public final List<CommonAppEntity> getApps() {
        return this.apps;
    }

    @Nullable
    public final SearchResultRelatedEntityWrap getRelatedApps() {
        return this.relatedApps;
    }

    @Nullable
    public final Object getTopadApps() {
        return this.topadApps;
    }

    public int hashCode() {
        List<CommonAppEntity> r10 = this.apps;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = r12 * 31;
        Object r14 = this.topadApps;
        if (r14 != null) goto L9;
        int r15 = 0;
    L10:
        int r16 = (r13 + r15) * 31;
        SearchResultRelatedEntityWrap r17 = this.relatedApps;
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

    public final void setApps(@Nullable List<CommonAppEntity> r10) {
        this.apps = r10;
    }

    public final void setRelatedApps(@Nullable SearchResultRelatedEntityWrap r10) {
        this.relatedApps = r10;
    }

    public final void setTopadApps(@Nullable Object r10) {
        this.topadApps = r10;
    }

    @NotNull
    public String toString() {
        return "SearchResultEntityWrap(apps=" + this.apps + ", topadApps=" + this.topadApps + ", relatedApps=" + this.relatedApps + ')';
    }

    public /* synthetic */ SearchResultEntityWrap(List r10, Object r11, SearchResultRelatedEntityWrap r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 4) == 0) goto L5;
        r12 = null;
    L5:
        this(r10, r11, r12);
    }
}
