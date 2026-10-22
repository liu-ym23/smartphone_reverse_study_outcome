package com.stepos.ailauncher.common.permission;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0011\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\rR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\u000fR\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0017\u0010\rR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0018\u0010\rR\"\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/stepos/ailauncher/common/permission/J;", "", "", "permission", "", "icon", "title", Const.JSON_KEY_DESC, "", "granted", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Z)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getPermission", "I", "getIcon", "getTitle", "getDesc", "Z", "getGranted", "()Z", "setGranted", "(Z)V", "permission_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.common.permission.J, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class PermissionRequest {
    private final String desc;
    private boolean granted;
    private final int icon;
    private final String permission;
    private final String title;

    public PermissionRequest(String permission, int i10, String title, String desc, boolean z10) {
        kotlin.jvm.internal.p.i(permission, "permission");
        kotlin.jvm.internal.p.i(title, "title");
        kotlin.jvm.internal.p.i(desc, "desc");
        this.permission = permission;
        this.icon = i10;
        this.title = title;
        this.desc = desc;
        this.granted = z10;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PermissionRequest)) {
            return false;
        }
        PermissionRequest permissionRequest = (PermissionRequest) other;
        return kotlin.jvm.internal.p.d(this.permission, permissionRequest.permission) && this.icon == permissionRequest.icon && kotlin.jvm.internal.p.d(this.title, permissionRequest.title) && kotlin.jvm.internal.p.d(this.desc, permissionRequest.desc) && this.granted == permissionRequest.granted;
    }

    public int hashCode() {
        return (((((((this.permission.hashCode() * 31) + Integer.hashCode(this.icon)) * 31) + this.title.hashCode()) * 31) + this.desc.hashCode()) * 31) + Boolean.hashCode(this.granted);
    }

    public String toString() {
        return "PermissionRequest(permission=" + this.permission + ", icon=" + this.icon + ", title=" + this.title + ", desc=" + this.desc + ", granted=" + this.granted + ")";
    }

    public /* synthetic */ PermissionRequest(String str, int i10, String str2, String str3, boolean z10, int i11, kotlin.jvm.internal.i iVar) {
        this(str, i10, str2, str3, (i11 & 16) != 0 ? false : z10);
    }
}
