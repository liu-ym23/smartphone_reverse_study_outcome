package com.bytedanceos.appstore.buss.entity.netwrap;

import com.bytedanceos.appstore.buss.entity.AppEntityWrap;
import com.bytedanceos.appstore.buss.entity.AppSubEntity;
import com.bytedanceos.appstore.buss.entity.AppSubWrap;
import com.bytedanceos.common.model.AppInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\tHÆ\u0003J?\u0010\u0016\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/bytedanceos/appstore/buss/entity/netwrap/AppGameSubWrap;", "", "top_apps", "", "Lcom/bytedanceos/appstore/buss/entity/AppSubEntity;", "group_apps", "Lcom/bytedanceos/appstore/buss/entity/AppSubWrap;", "other_apps", "hot_games", "Lcom/bytedanceos/appstore/buss/entity/AppEntityWrap;", "(Ljava/util/List;Lcom/bytedanceos/appstore/buss/entity/AppSubWrap;Lcom/bytedanceos/appstore/buss/entity/AppSubWrap;Lcom/bytedanceos/appstore/buss/entity/AppEntityWrap;)V", "getGroup_apps", "()Lcom/bytedanceos/appstore/buss/entity/AppSubWrap;", "getHot_games", "()Lcom/bytedanceos/appstore/buss/entity/AppEntityWrap;", "getOther_apps", "getTop_apps", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "hashCode", "", "toString", "", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AppGameSubWrap {

    @Nullable
    private final AppSubWrap group_apps;

    @Nullable
    private final AppEntityWrap hot_games;

    @Nullable
    private final AppSubWrap other_apps;

    @Nullable
    private final List<AppSubEntity> top_apps;

    public AppGameSubWrap(@Nullable List<AppSubEntity> r10, @Nullable AppSubWrap r11, @Nullable AppSubWrap r12, @Nullable AppEntityWrap r13) {
        this.top_apps = r10;
        this.group_apps = r11;
        this.other_apps = r12;
        this.hot_games = r13;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AppGameSubWrap copy$default(AppGameSubWrap r10, List r11, AppSubWrap r12, AppSubWrap r13, AppEntityWrap r14, int r15, Object r16) {
        if ((r15 & 1) == 0) goto L6;
        r11 = r10.top_apps;
    L6:
        if ((r15 & 2) == 0) goto L9;
        r12 = r10.group_apps;
    L9:
        if ((r15 & 4) == 0) goto L12;
        r13 = r10.other_apps;
    L12:
        if ((r15 & 8) == 0) goto L15;
        r14 = r10.hot_games;
    L15:
        return r10.copy(r11, r12, r13, r14);
    }

    @Nullable
    public final List<AppSubEntity> component1() {
        return this.top_apps;
    }

    @Nullable
    public final AppSubWrap component2() {
        return this.group_apps;
    }

    @Nullable
    public final AppSubWrap component3() {
        return this.other_apps;
    }

    @Nullable
    public final AppEntityWrap component4() {
        return this.hot_games;
    }

    @NotNull
    public final AppGameSubWrap copy(@Nullable List<AppSubEntity> r10, @Nullable AppSubWrap r11, @Nullable AppSubWrap r12, @Nullable AppEntityWrap r13) {
        return new AppGameSubWrap(r10, r11, r12, r13);
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof AppGameSubWrap) == true) goto L8;
        return false;
    L8:
        AppGameSubWrap r11 = (AppGameSubWrap) r10;
        if (q.b(this.top_apps, r11.top_apps) == true) goto L12;
        return false;
    L12:
        if (q.b(this.group_apps, r11.group_apps) == true) goto L15;
        return false;
    L15:
        if (q.b(this.other_apps, r11.other_apps) == true) goto L18;
        return false;
    L18:
        if (q.b(this.hot_games, r11.hot_games) == true) goto L20;
        return false;
    L20:
        return true;
    }

    @Nullable
    public final AppSubWrap getGroup_apps() {
        return this.group_apps;
    }

    @Nullable
    public final AppEntityWrap getHot_games() {
        return this.hot_games;
    }

    @Nullable
    public final AppSubWrap getOther_apps() {
        return this.other_apps;
    }

    @Nullable
    public final List<AppSubEntity> getTop_apps() {
        return this.top_apps;
    }

    public int hashCode() {
        List<AppSubEntity> r10 = this.top_apps;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = r12 * 31;
        AppSubWrap r14 = this.group_apps;
        if (r14 != null) goto L9;
        int r15 = 0;
    L10:
        int r16 = (r13 + r15) * 31;
        AppSubWrap r17 = this.other_apps;
        if (r17 != null) goto L13;
        int r18 = 0;
    L14:
        int r19 = (r16 + r18) * 31;
        AppEntityWrap r20 = this.hot_games;
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

    @NotNull
    public String toString() {
        return "AppGameSubWrap(top_apps=" + this.top_apps + ", group_apps=" + this.group_apps + ", other_apps=" + this.other_apps + ", hot_games=" + this.hot_games + ')';
    }
}
