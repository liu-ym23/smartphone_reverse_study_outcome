package com.bytedanceos.appstore.buss.entity.netwrap;

import com.bytedanceos.appstore.buss.entity.AppInfoEntity;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.ServerElements;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/bytedanceos/appstore/buss/entity/netwrap/TvAppDetailWrap;", "", "appInfoEntity", "Lcom/bytedanceos/appstore/buss/entity/AppInfoEntity;", "relationApps", "Lcom/bytedanceos/appstore/buss/entity/netwrap/TvAppDetailRelationAppsEntity;", "classicsApps", "Lcom/bytedanceos/appstore/buss/entity/netwrap/TvAppDetailClassicsApps;", "(Lcom/bytedanceos/appstore/buss/entity/AppInfoEntity;Lcom/bytedanceos/appstore/buss/entity/netwrap/TvAppDetailRelationAppsEntity;Lcom/bytedanceos/appstore/buss/entity/netwrap/TvAppDetailClassicsApps;)V", "getAppInfoEntity", "()Lcom/bytedanceos/appstore/buss/entity/AppInfoEntity;", "getClassicsApps", "()Lcom/bytedanceos/appstore/buss/entity/netwrap/TvAppDetailClassicsApps;", "getRelationApps", "()Lcom/bytedanceos/appstore/buss/entity/netwrap/TvAppDetailRelationAppsEntity;", "component1", "component2", "component3", "copy", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "hashCode", "", "toString", "", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TvAppDetailWrap {

    @SerializedName(ServerElements.APP_INFO)
    @Nullable
    private final AppInfoEntity appInfoEntity;

    @SerializedName(ServerElements.APP_DETAIL_CLASSICS)
    @Nullable
    private final TvAppDetailClassicsApps classicsApps;

    @SerializedName(ServerElements.APP_DETAIL_RELATION)
    @Nullable
    private final TvAppDetailRelationAppsEntity relationApps;

    public TvAppDetailWrap(@Nullable AppInfoEntity r10, @Nullable TvAppDetailRelationAppsEntity r11, @Nullable TvAppDetailClassicsApps r12) {
        this.appInfoEntity = r10;
        this.relationApps = r11;
        this.classicsApps = r12;
    }

    public static /* synthetic */ TvAppDetailWrap copy$default(TvAppDetailWrap r10, AppInfoEntity r11, TvAppDetailRelationAppsEntity r12, TvAppDetailClassicsApps r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r11 = r10.appInfoEntity;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r12 = r10.relationApps;
    L9:
        if ((r14 & 4) == 0) goto L12;
        r13 = r10.classicsApps;
    L12:
        return r10.copy(r11, r12, r13);
    }

    @Nullable
    public final AppInfoEntity component1() {
        return this.appInfoEntity;
    }

    @Nullable
    public final TvAppDetailRelationAppsEntity component2() {
        return this.relationApps;
    }

    @Nullable
    public final TvAppDetailClassicsApps component3() {
        return this.classicsApps;
    }

    @NotNull
    public final TvAppDetailWrap copy(@Nullable AppInfoEntity r10, @Nullable TvAppDetailRelationAppsEntity r11, @Nullable TvAppDetailClassicsApps r12) {
        return new TvAppDetailWrap(r10, r11, r12);
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof TvAppDetailWrap) == true) goto L8;
        return false;
    L8:
        TvAppDetailWrap r11 = (TvAppDetailWrap) r10;
        if (q.b(this.appInfoEntity, r11.appInfoEntity) == true) goto L12;
        return false;
    L12:
        if (q.b(this.relationApps, r11.relationApps) == true) goto L15;
        return false;
    L15:
        if (q.b(this.classicsApps, r11.classicsApps) == true) goto L17;
        return false;
    L17:
        return true;
    }

    @Nullable
    public final AppInfoEntity getAppInfoEntity() {
        return this.appInfoEntity;
    }

    @Nullable
    public final TvAppDetailClassicsApps getClassicsApps() {
        return this.classicsApps;
    }

    @Nullable
    public final TvAppDetailRelationAppsEntity getRelationApps() {
        return this.relationApps;
    }

    public int hashCode() {
        AppInfoEntity r10 = this.appInfoEntity;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = r12 * 31;
        TvAppDetailRelationAppsEntity r14 = this.relationApps;
        if (r14 != null) goto L9;
        int r15 = 0;
    L10:
        int r16 = (r13 + r15) * 31;
        TvAppDetailClassicsApps r17 = this.classicsApps;
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
        return "TvAppDetailWrap(appInfoEntity=" + this.appInfoEntity + ", relationApps=" + this.relationApps + ", classicsApps=" + this.classicsApps + ')';
    }
}
