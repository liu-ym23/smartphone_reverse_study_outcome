package com.bytedanceos.appstore.buss.entity.netwrap;

import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.ui.AppPermissionActivity;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\b\"\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/bytedanceos/appstore/buss/entity/netwrap/AppCollectEntity;", "", AppPermissionActivity.EXTRA_APP_PKG, "", "status", "opTime", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getOpTime", "()Ljava/lang/String;", "getPkg", "getStatus", "setStatus", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "hashCode", "", "toString", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AppCollectEntity {

    @SerializedName("op_time")
    @NotNull
    private final String opTime;

    @SerializedName("package")
    @NotNull
    private final String pkg;

    @NotNull
    private String status;

    public AppCollectEntity(@NotNull String r10, @NotNull String r11, @NotNull String r12) {
        q.g(r10, AppPermissionActivity.EXTRA_APP_PKG);
        q.g(r11, "status");
        q.g(r12, "opTime");
        this.pkg = r10;
        this.status = r11;
        this.opTime = r12;
    }

    public static /* synthetic */ AppCollectEntity copy$default(AppCollectEntity r10, String r11, String r12, String r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r11 = r10.pkg;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r12 = r10.status;
    L9:
        if ((r14 & 4) == 0) goto L12;
        r13 = r10.opTime;
    L12:
        return r10.copy(r11, r12, r13);
    }

    @NotNull
    public final String component1() {
        return this.pkg;
    }

    @NotNull
    public final String component2() {
        return this.status;
    }

    @NotNull
    public final String component3() {
        return this.opTime;
    }

    @NotNull
    public final AppCollectEntity copy(@NotNull String r10, @NotNull String r11, @NotNull String r12) {
        q.g(r10, AppPermissionActivity.EXTRA_APP_PKG);
        q.g(r11, "status");
        q.g(r12, "opTime");
        return new AppCollectEntity(r10, r11, r12);
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof AppCollectEntity) == true) goto L8;
        return false;
    L8:
        AppCollectEntity r11 = (AppCollectEntity) r10;
        if (q.b(this.pkg, r11.pkg) == true) goto L12;
        return false;
    L12:
        if (q.b(this.status, r11.status) == true) goto L15;
        return false;
    L15:
        if (q.b(this.opTime, r11.opTime) == true) goto L17;
        return false;
    L17:
        return true;
    }

    @NotNull
    public final String getOpTime() {
        return this.opTime;
    }

    @NotNull
    public final String getPkg() {
        return this.pkg;
    }

    @NotNull
    public final String getStatus() {
        return this.status;
    }

    public int hashCode() {
        return (((this.pkg.hashCode() * 31) + this.status.hashCode()) * 31) + this.opTime.hashCode();
    }

    public final void setStatus(@NotNull String r10) {
        q.g(r10, "<set-?>");
        this.status = r10;
    }

    @NotNull
    public String toString() {
        return "AppCollectEntity(pkg=" + this.pkg + ", status=" + this.status + ", opTime=" + this.opTime + ')';
    }

    public /* synthetic */ AppCollectEntity(String r10, String r11, String r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L5;
        r11 = "1";
    L5:
        this(r10, r11, r12);
    }
}
