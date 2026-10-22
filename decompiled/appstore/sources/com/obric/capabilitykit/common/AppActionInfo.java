package com.obric.capabilitykit.common;

import androidx.annotation.Keep;
import com.bytedanceos.common.model.AppInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/obric/capabilitykit/common/AppActionInfo;", "", "packageName", "", "appName", "action", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAction", "()Ljava/lang/String;", "getAppName", "getPackageName", "component1", "component2", "component3", "copy", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "hashCode", "", "toString", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AppActionInfo {

    @NotNull
    private final String action;

    @NotNull
    private final String appName;

    @NotNull
    private final String packageName;

    public AppActionInfo(@NotNull String r10, @NotNull String r11, @NotNull String r12) {
        kotlin.jvm.internal.q.g(r10, "packageName");
        kotlin.jvm.internal.q.g(r11, "appName");
        kotlin.jvm.internal.q.g(r12, "action");
        this.packageName = r10;
        this.appName = r11;
        this.action = r12;
    }

    public static /* synthetic */ AppActionInfo copy$default(AppActionInfo r10, String r11, String r12, String r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r11 = r10.packageName;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r12 = r10.appName;
    L9:
        if ((r14 & 4) == 0) goto L12;
        r13 = r10.action;
    L12:
        return r10.copy(r11, r12, r13);
    }

    @NotNull
    public final String component1() {
        return this.packageName;
    }

    @NotNull
    public final String component2() {
        return this.appName;
    }

    @NotNull
    public final String component3() {
        return this.action;
    }

    @NotNull
    public final AppActionInfo copy(@NotNull String r10, @NotNull String r11, @NotNull String r12) {
        kotlin.jvm.internal.q.g(r10, "packageName");
        kotlin.jvm.internal.q.g(r11, "appName");
        kotlin.jvm.internal.q.g(r12, "action");
        return new AppActionInfo(r10, r11, r12);
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof AppActionInfo) == true) goto L8;
        return false;
    L8:
        AppActionInfo r11 = (AppActionInfo) r10;
        if (kotlin.jvm.internal.q.b(this.packageName, r11.packageName) == true) goto L12;
        return false;
    L12:
        if (kotlin.jvm.internal.q.b(this.appName, r11.appName) == true) goto L15;
        return false;
    L15:
        if (kotlin.jvm.internal.q.b(this.action, r11.action) == true) goto L17;
        return false;
    L17:
        return true;
    }

    @NotNull
    public final String getAction() {
        return this.action;
    }

    @NotNull
    public final String getAppName() {
        return this.appName;
    }

    @NotNull
    public final String getPackageName() {
        return this.packageName;
    }

    public int hashCode() {
        return (((this.packageName.hashCode() * 31) + this.appName.hashCode()) * 31) + this.action.hashCode();
    }

    @NotNull
    public String toString() {
        return "AppActionInfo(packageName=" + this.packageName + ", appName=" + this.appName + ", action=" + this.action + ')';
    }
}
