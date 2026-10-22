package com.bytedanceos.appstore.buss.entity;

import com.bytedanceos.common.model.AppInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0011\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0006HÖ\u0001R\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/bytedanceos/appstore/buss/entity/DetailRecommendAppEntityWrap;", "", "category", "", "Lcom/bytedanceos/appstore/buss/entity/AppEntityWrap;", "name", "", "(Ljava/util/List;Ljava/lang/String;)V", "getCategory", "()Ljava/util/List;", "setCategory", "(Ljava/util/List;)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "hashCode", "", "toString", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DetailRecommendAppEntityWrap {

    @Nullable
    private List<AppEntityWrap> category;

    @Nullable
    private String name;

    /* JADX WARN: Multi-variable type inference failed */
    public DetailRecommendAppEntityWrap() {
        Object[] r10 = 0 == true ? 1 : 0;
        this(null, r10, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DetailRecommendAppEntityWrap copy$default(DetailRecommendAppEntityWrap r10, List r11, String r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = r10.category;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r12 = r10.name;
    L9:
        return r10.copy(r11, r12);
    }

    @Nullable
    public final List<AppEntityWrap> component1() {
        return this.category;
    }

    @Nullable
    public final String component2() {
        return this.name;
    }

    @NotNull
    public final DetailRecommendAppEntityWrap copy(@Nullable List<AppEntityWrap> r10, @Nullable String r11) {
        return new DetailRecommendAppEntityWrap(r10, r11);
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof DetailRecommendAppEntityWrap) == true) goto L8;
        return false;
    L8:
        DetailRecommendAppEntityWrap r11 = (DetailRecommendAppEntityWrap) r10;
        if (q.b(this.category, r11.category) == true) goto L12;
        return false;
    L12:
        if (q.b(this.name, r11.name) == true) goto L14;
        return false;
    L14:
        return true;
    }

    @Nullable
    public final List<AppEntityWrap> getCategory() {
        return this.category;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        List<AppEntityWrap> r10 = this.category;
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

    public final void setCategory(@Nullable List<AppEntityWrap> r10) {
        this.category = r10;
    }

    public final void setName(@Nullable String r10) {
        this.name = r10;
    }

    @NotNull
    public String toString() {
        return "DetailRecommendAppEntityWrap(category=" + this.category + ", name=" + this.name + ')';
    }

    public DetailRecommendAppEntityWrap(@Nullable List<AppEntityWrap> r10, @Nullable String r11) {
        this.category = r10;
        this.name = r11;
    }

    public /* synthetic */ DetailRecommendAppEntityWrap(List r10, String r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = null;
    L6:
        if ((r12 & 2) == 0) goto L8;
        r11 = null;
    L8:
        this(r10, r11);
    }
}
