package com.bytedanceos.appstore.buss.entity;

import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.ServerElements;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J;\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001b"}, d2 = {"Lcom/bytedanceos/appstore/buss/entity/TvSearchRecommendAppsEntity;", "", "name", "", "identity", ServerElements.SORT, ServerElements.INFO, "", "Lcom/bytedanceos/appstore/buss/entity/CommonAppEntity;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getIdentity", "()Ljava/lang/String;", "getInfo", "()Ljava/util/List;", "getName", "getSort", "component1", "component2", "component3", "component4", "copy", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "hashCode", "", "toString", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TvSearchRecommendAppsEntity {

    @Nullable
    private final String identity;

    @NotNull
    private final List<CommonAppEntity> info;

    @NotNull
    private final String name;

    @Nullable
    private final String sort;

    public TvSearchRecommendAppsEntity(@NotNull String r10, @Nullable String r11, @Nullable String r12, @NotNull List<CommonAppEntity> r13) {
        q.g(r10, "name");
        q.g(r13, ServerElements.INFO);
        this.name = r10;
        this.identity = r11;
        this.sort = r12;
        this.info = r13;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TvSearchRecommendAppsEntity copy$default(TvSearchRecommendAppsEntity r10, String r11, String r12, String r13, List r14, int r15, Object r16) {
        if ((r15 & 1) == 0) goto L6;
        r11 = r10.name;
    L6:
        if ((r15 & 2) == 0) goto L9;
        r12 = r10.identity;
    L9:
        if ((r15 & 4) == 0) goto L12;
        r13 = r10.sort;
    L12:
        if ((r15 & 8) == 0) goto L15;
        r14 = r10.info;
    L15:
        return r10.copy(r11, r12, r13, r14);
    }

    @NotNull
    public final String component1() {
        return this.name;
    }

    @Nullable
    public final String component2() {
        return this.identity;
    }

    @Nullable
    public final String component3() {
        return this.sort;
    }

    @NotNull
    public final List<CommonAppEntity> component4() {
        return this.info;
    }

    @NotNull
    public final TvSearchRecommendAppsEntity copy(@NotNull String r10, @Nullable String r11, @Nullable String r12, @NotNull List<CommonAppEntity> r13) {
        q.g(r10, "name");
        q.g(r13, ServerElements.INFO);
        return new TvSearchRecommendAppsEntity(r10, r11, r12, r13);
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof TvSearchRecommendAppsEntity) == true) goto L8;
        return false;
    L8:
        TvSearchRecommendAppsEntity r11 = (TvSearchRecommendAppsEntity) r10;
        if (q.b(this.name, r11.name) == true) goto L12;
        return false;
    L12:
        if (q.b(this.identity, r11.identity) == true) goto L15;
        return false;
    L15:
        if (q.b(this.sort, r11.sort) == true) goto L18;
        return false;
    L18:
        if (q.b(this.info, r11.info) == true) goto L20;
        return false;
    L20:
        return true;
    }

    @Nullable
    public final String getIdentity() {
        return this.identity;
    }

    @NotNull
    public final List<CommonAppEntity> getInfo() {
        return this.info;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final String getSort() {
        return this.sort;
    }

    public int hashCode() {
        int r10 = this.name.hashCode() * 31;
        String r11 = this.identity;
        int r12 = 0;
        if (r11 != null) goto L5;
        int r13 = 0;
    L6:
        int r14 = (r10 + r13) * 31;
        String r15 = this.sort;
        if (r15 == null) goto L11;
        r12 = r15.hashCode();
    L11:
        return ((r14 + r12) * 31) + this.info.hashCode();
    L5:
        r13 = r11.hashCode();
        goto L6
    }

    @NotNull
    public String toString() {
        return "TvSearchRecommendAppsEntity(name=" + this.name + ", identity=" + this.identity + ", sort=" + this.sort + ", info=" + this.info + ')';
    }
}
