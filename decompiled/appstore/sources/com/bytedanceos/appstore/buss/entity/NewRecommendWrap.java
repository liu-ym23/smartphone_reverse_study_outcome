package com.bytedanceos.appstore.buss.entity;

import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.ServerElements;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005¢\u0006\u0002\u0010\bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003JK\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00052\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\"\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\f¨\u0006!"}, d2 = {"Lcom/bytedanceos/appstore/buss/entity/NewRecommendWrap;", "", ServerElements.TOPICS, "Lcom/bytedanceos/appstore/buss/entity/AppEntityWrap;", "horizontals", "", "banners", "verticals", "(Lcom/bytedanceos/appstore/buss/entity/AppEntityWrap;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getBanners", "()Ljava/util/List;", "setBanners", "(Ljava/util/List;)V", "getHorizontals", "setHorizontals", "getTopics", "()Lcom/bytedanceos/appstore/buss/entity/AppEntityWrap;", "setTopics", "(Lcom/bytedanceos/appstore/buss/entity/AppEntityWrap;)V", "getVerticals", "setVerticals", "component1", "component2", "component3", "component4", "copy", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "hashCode", "", "toString", "", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class NewRecommendWrap {

    @Nullable
    private List<AppEntityWrap> banners;

    @Nullable
    private List<AppEntityWrap> horizontals;

    @Nullable
    private AppEntityWrap topics;

    @Nullable
    private List<AppEntityWrap> verticals;

    public NewRecommendWrap() {
        AppEntityWrap r10 = null;
        List r11 = null;
        List r12 = null;
        List r13 = null;
        this(r10, r11, r12, r13, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ NewRecommendWrap copy$default(NewRecommendWrap r10, AppEntityWrap r11, List r12, List r13, List r14, int r15, Object r16) {
        if ((r15 & 1) == 0) goto L6;
        r11 = r10.topics;
    L6:
        if ((r15 & 2) == 0) goto L9;
        r12 = r10.horizontals;
    L9:
        if ((r15 & 4) == 0) goto L12;
        r13 = r10.banners;
    L12:
        if ((r15 & 8) == 0) goto L15;
        r14 = r10.verticals;
    L15:
        return r10.copy(r11, r12, r13, r14);
    }

    @Nullable
    public final AppEntityWrap component1() {
        return this.topics;
    }

    @Nullable
    public final List<AppEntityWrap> component2() {
        return this.horizontals;
    }

    @Nullable
    public final List<AppEntityWrap> component3() {
        return this.banners;
    }

    @Nullable
    public final List<AppEntityWrap> component4() {
        return this.verticals;
    }

    @NotNull
    public final NewRecommendWrap copy(@Nullable AppEntityWrap r10, @Nullable List<AppEntityWrap> r11, @Nullable List<AppEntityWrap> r12, @Nullable List<AppEntityWrap> r13) {
        return new NewRecommendWrap(r10, r11, r12, r13);
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof NewRecommendWrap) == true) goto L8;
        return false;
    L8:
        NewRecommendWrap r11 = (NewRecommendWrap) r10;
        if (q.b(this.topics, r11.topics) == true) goto L12;
        return false;
    L12:
        if (q.b(this.horizontals, r11.horizontals) == true) goto L15;
        return false;
    L15:
        if (q.b(this.banners, r11.banners) == true) goto L18;
        return false;
    L18:
        if (q.b(this.verticals, r11.verticals) == true) goto L20;
        return false;
    L20:
        return true;
    }

    @Nullable
    public final List<AppEntityWrap> getBanners() {
        return this.banners;
    }

    @Nullable
    public final List<AppEntityWrap> getHorizontals() {
        return this.horizontals;
    }

    @Nullable
    public final AppEntityWrap getTopics() {
        return this.topics;
    }

    @Nullable
    public final List<AppEntityWrap> getVerticals() {
        return this.verticals;
    }

    public int hashCode() {
        AppEntityWrap r10 = this.topics;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = r12 * 31;
        List<AppEntityWrap> r14 = this.horizontals;
        if (r14 != null) goto L9;
        int r15 = 0;
    L10:
        int r16 = (r13 + r15) * 31;
        List<AppEntityWrap> r17 = this.banners;
        if (r17 != null) goto L13;
        int r18 = 0;
    L14:
        int r19 = (r16 + r18) * 31;
        List<AppEntityWrap> r20 = this.verticals;
        if (r20 == null) goto L19;
        r11 = r20.hashCode();
    L19:
        return r19 + r11;
    L13:
        r18 = r17.hashCode();
        goto L14
    L9:
        r15 = r14.hashCode();
        goto L10
    L5:
        r12 = r10.hashCode();
        goto L6
    }

    public final void setBanners(@Nullable List<AppEntityWrap> r10) {
        this.banners = r10;
    }

    public final void setHorizontals(@Nullable List<AppEntityWrap> r10) {
        this.horizontals = r10;
    }

    public final void setTopics(@Nullable AppEntityWrap r10) {
        this.topics = r10;
    }

    public final void setVerticals(@Nullable List<AppEntityWrap> r10) {
        this.verticals = r10;
    }

    @NotNull
    public String toString() {
        return "NewRecommendWrap(topics=" + this.topics + ", horizontals=" + this.horizontals + ", banners=" + this.banners + ", verticals=" + this.verticals + ')';
    }

    public NewRecommendWrap(@Nullable AppEntityWrap r10, @Nullable List<AppEntityWrap> r11, @Nullable List<AppEntityWrap> r12, @Nullable List<AppEntityWrap> r13) {
        this.topics = r10;
        this.horizontals = r11;
        this.banners = r12;
        this.verticals = r13;
    }

    public /* synthetic */ NewRecommendWrap(AppEntityWrap r10, List r11, List r12, List r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 1) == 0) goto L6;
        r10 = null;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r11 = null;
    L9:
        if ((r14 & 4) == 0) goto L12;
        r12 = null;
    L12:
        if ((r14 & 8) == 0) goto L14;
        r13 = null;
    L14:
        this(r10, r11, r12, r13);
    }
}
