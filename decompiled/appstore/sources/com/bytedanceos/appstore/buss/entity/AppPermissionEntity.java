package com.bytedanceos.appstore.buss.entity;

import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.ServerElements;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0003J-\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/bytedanceos/appstore/buss/entity/AppPermissionEntity;", "", "name", "", ServerElements.LOGO, "permission", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getLogo", "()Ljava/lang/String;", "getName", "getPermission", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "hashCode", "", "toString", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AppPermissionEntity {

    @NotNull
    private final String logo;

    @NotNull
    private final String name;

    @NotNull
    private final List<String> permission;

    public AppPermissionEntity(@NotNull String r10, @NotNull String r11, @NotNull List<String> r12) {
        q.g(r10, "name");
        q.g(r11, ServerElements.LOGO);
        q.g(r12, "permission");
        this.name = r10;
        this.logo = r11;
        this.permission = r12;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AppPermissionEntity copy$default(AppPermissionEntity r10, String r11, String r12, List r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r11 = r10.name;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r12 = r10.logo;
    L9:
        if ((r14 & 4) == 0) goto L12;
        r13 = r10.permission;
    L12:
        return r10.copy(r11, r12, r13);
    }

    @NotNull
    public final String component1() {
        return this.name;
    }

    @NotNull
    public final String component2() {
        return this.logo;
    }

    @NotNull
    public final List<String> component3() {
        return this.permission;
    }

    @NotNull
    public final AppPermissionEntity copy(@NotNull String r10, @NotNull String r11, @NotNull List<String> r12) {
        q.g(r10, "name");
        q.g(r11, ServerElements.LOGO);
        q.g(r12, "permission");
        return new AppPermissionEntity(r10, r11, r12);
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof AppPermissionEntity) == true) goto L8;
        return false;
    L8:
        AppPermissionEntity r11 = (AppPermissionEntity) r10;
        if (q.b(this.name, r11.name) == true) goto L12;
        return false;
    L12:
        if (q.b(this.logo, r11.logo) == true) goto L15;
        return false;
    L15:
        if (q.b(this.permission, r11.permission) == true) goto L17;
        return false;
    L17:
        return true;
    }

    @NotNull
    public final String getLogo() {
        return this.logo;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final List<String> getPermission() {
        return this.permission;
    }

    public int hashCode() {
        return (((this.name.hashCode() * 31) + this.logo.hashCode()) * 31) + this.permission.hashCode();
    }

    @NotNull
    public String toString() {
        return "AppPermissionEntity(name=" + this.name + ", logo=" + this.logo + ", permission=" + this.permission + ')';
    }
}
