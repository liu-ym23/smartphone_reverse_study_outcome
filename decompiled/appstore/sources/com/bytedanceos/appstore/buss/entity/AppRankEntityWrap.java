package com.bytedanceos.appstore.buss.entity;

import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.ServerElements;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u0011\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J1\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/bytedanceos/appstore/buss/entity/AppRankEntityWrap;", "", ServerElements.AD_APPS, "apps", "", "Lcom/bytedanceos/appstore/buss/entity/CommonAppEntity;", ServerElements.LAST_APP_ID, "", "(Ljava/lang/Object;Ljava/util/List;I)V", "getAdApps", "()Ljava/lang/Object;", "setAdApps", "(Ljava/lang/Object;)V", "getApps", "()Ljava/util/List;", "setApps", "(Ljava/util/List;)V", "getLastId", "()I", "setLastId", "(I)V", "component1", "component2", "component3", "copy", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "hashCode", "toString", "", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AppRankEntityWrap {

    @Nullable
    private Object adApps;

    @Nullable
    private List<CommonAppEntity> apps;
    private int lastId;

    public AppRankEntityWrap(@Nullable Object r10, @Nullable List<CommonAppEntity> r11, int r12) {
        this.adApps = r10;
        this.apps = r11;
        this.lastId = r12;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AppRankEntityWrap copy$default(AppRankEntityWrap r10, Object r11, List r12, int r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r11 = r10.adApps;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r12 = r10.apps;
    L9:
        if ((r14 & 4) == 0) goto L12;
        r13 = r10.lastId;
    L12:
        return r10.copy(r11, r12, r13);
    }

    @Nullable
    public final Object component1() {
        return this.adApps;
    }

    @Nullable
    public final List<CommonAppEntity> component2() {
        return this.apps;
    }

    public final int component3() {
        return this.lastId;
    }

    @NotNull
    public final AppRankEntityWrap copy(@Nullable Object r10, @Nullable List<CommonAppEntity> r11, int r12) {
        return new AppRankEntityWrap(r10, r11, r12);
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof AppRankEntityWrap) == true) goto L8;
        return false;
    L8:
        AppRankEntityWrap r11 = (AppRankEntityWrap) r10;
        if (q.b(this.adApps, r11.adApps) == true) goto L12;
        return false;
    L12:
        if (q.b(this.apps, r11.apps) == true) goto L15;
        return false;
    L15:
        if (this.lastId == r11.lastId) goto L17;
        return false;
    L17:
        return true;
    }

    @Nullable
    public final Object getAdApps() {
        return this.adApps;
    }

    @Nullable
    public final List<CommonAppEntity> getApps() {
        return this.apps;
    }

    public final int getLastId() {
        return this.lastId;
    }

    public int hashCode() {
        Object r10 = this.adApps;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = r12 * 31;
        List<CommonAppEntity> r14 = this.apps;
        if (r14 == null) goto L11;
        r11 = r14.hashCode();
    L11:
        return ((r13 + r11) * 31) + Integer.hashCode(this.lastId);
    L5:
        r12 = r10.hashCode();
        goto L6
    }

    public final void setAdApps(@Nullable Object r10) {
        this.adApps = r10;
    }

    public final void setApps(@Nullable List<CommonAppEntity> r10) {
        this.apps = r10;
    }

    public final void setLastId(int r10) {
        this.lastId = r10;
    }

    @NotNull
    public String toString() {
        return "AppRankEntityWrap(adApps=" + this.adApps + ", apps=" + this.apps + ", lastId=" + this.lastId + ')';
    }
}
