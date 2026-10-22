package com.stepos.ailauncher.common.permission;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\u0080\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/stepos/ailauncher/common/permission/i;", "", "Lcom/stepos/ailauncher/common/permission/PermissionLaunchKind;", "kind", "Lcom/stepos/ailauncher/common/permission/PermissionUiScene;", "uiScene", "Lcom/stepos/ailauncher/common/permission/PermissionHostSource;", "source", "<init>", "(Lcom/stepos/ailauncher/common/permission/PermissionLaunchKind;Lcom/stepos/ailauncher/common/permission/PermissionUiScene;Lcom/stepos/ailauncher/common/permission/PermissionHostSource;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/stepos/ailauncher/common/permission/PermissionLaunchKind;", "getKind", "()Lcom/stepos/ailauncher/common/permission/PermissionLaunchKind;", "Lcom/stepos/ailauncher/common/permission/PermissionUiScene;", Const.INTENT_KEY_PKGNAME, "()Lcom/stepos/ailauncher/common/permission/PermissionUiScene;", "Lcom/stepos/ailauncher/common/permission/PermissionHostSource;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/ailauncher/common/permission/PermissionHostSource;", "permission_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.common.permission.i, reason: case insensitive filesystem and from toString */
/* loaded from: classes3.dex */
public final /* data */ class PermissionHostDecision {
    private final PermissionLaunchKind kind;
    private final PermissionHostSource source;
    private final PermissionUiScene uiScene;

    public PermissionHostDecision(PermissionLaunchKind kind, PermissionUiScene uiScene, PermissionHostSource source) {
        kotlin.jvm.internal.p.i(kind, "kind");
        kotlin.jvm.internal.p.i(uiScene, "uiScene");
        kotlin.jvm.internal.p.i(source, "source");
        this.kind = kind;
        this.uiScene = uiScene;
        this.source = source;
    }

    /* renamed from: a, reason: from getter */
    public final PermissionHostSource getSource() {
        return this.source;
    }

    /* renamed from: b, reason: from getter */
    public final PermissionUiScene getUiScene() {
        return this.uiScene;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PermissionHostDecision)) {
            return false;
        }
        PermissionHostDecision permissionHostDecision = (PermissionHostDecision) other;
        return this.kind == permissionHostDecision.kind && this.uiScene == permissionHostDecision.uiScene && this.source == permissionHostDecision.source;
    }

    public int hashCode() {
        return (((this.kind.hashCode() * 31) + this.uiScene.hashCode()) * 31) + this.source.hashCode();
    }

    public String toString() {
        return "PermissionHostDecision(kind=" + this.kind + ", uiScene=" + this.uiScene + ", source=" + this.source + ")";
    }
}
