package com.bytedanceos.appstore.buss.entity;

import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.ServerElements;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u0011\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0003J-\u0010\u0010\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0006HÖ\u0001R\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/bytedanceos/appstore/buss/entity/SearchAssociateEntityWrap;", "", "apps", "", "Lcom/bytedanceos/appstore/buss/entity/CommonAppEntity;", ServerElements.KEYWORDS, "", "(Ljava/util/List;Ljava/util/List;)V", "getApps", "()Ljava/util/List;", "setApps", "(Ljava/util/List;)V", "getKeywords", "setKeywords", "component1", "component2", "copy", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "hashCode", "", "toString", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SearchAssociateEntityWrap {

    @Nullable
    private List<CommonAppEntity> apps;

    @Nullable
    private List<String> keywords;

    public SearchAssociateEntityWrap(@Nullable List<CommonAppEntity> r10, @Nullable List<String> r11) {
        this.apps = r10;
        this.keywords = r11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SearchAssociateEntityWrap copy$default(SearchAssociateEntityWrap r10, List r11, List r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = r10.apps;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r12 = r10.keywords;
    L9:
        return r10.copy(r11, r12);
    }

    @Nullable
    public final List<CommonAppEntity> component1() {
        return this.apps;
    }

    @Nullable
    public final List<String> component2() {
        return this.keywords;
    }

    @NotNull
    public final SearchAssociateEntityWrap copy(@Nullable List<CommonAppEntity> r10, @Nullable List<String> r11) {
        return new SearchAssociateEntityWrap(r10, r11);
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof SearchAssociateEntityWrap) == true) goto L8;
        return false;
    L8:
        SearchAssociateEntityWrap r11 = (SearchAssociateEntityWrap) r10;
        if (q.b(this.apps, r11.apps) == true) goto L12;
        return false;
    L12:
        if (q.b(this.keywords, r11.keywords) == true) goto L14;
        return false;
    L14:
        return true;
    }

    @Nullable
    public final List<CommonAppEntity> getApps() {
        return this.apps;
    }

    @Nullable
    public final List<String> getKeywords() {
        return this.keywords;
    }

    public int hashCode() {
        List<CommonAppEntity> r10 = this.apps;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = r12 * 31;
        List<String> r14 = this.keywords;
        if (r14 == null) goto L11;
        r11 = r14.hashCode();
    L11:
        return r13 + r11;
    L5:
        r12 = r10.hashCode();
        goto L6
    }

    public final void setApps(@Nullable List<CommonAppEntity> r10) {
        this.apps = r10;
    }

    public final void setKeywords(@Nullable List<String> r10) {
        this.keywords = r10;
    }

    @NotNull
    public String toString() {
        return "SearchAssociateEntityWrap(apps=" + this.apps + ", keywords=" + this.keywords + ')';
    }
}
