package com.stepos.ailauncher.common.permission;

import android.app.Activity;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001b\u001a\u0004\b\u001c\u0010\u0010R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\"\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b \u0010!¨\u0006#"}, d2 = {"Lcom/stepos/ailauncher/common/permission/e;", "", "Lcom/stepos/ailauncher/common/permission/PermissionLaunchKind;", "kind", "Landroid/app/Activity;", "activity", "", "anchorTaskId", "Lcom/stepos/ailauncher/common/permission/PermissionUiScene;", "uiScene", "<init>", "(Lcom/stepos/ailauncher/common/permission/PermissionLaunchKind;Landroid/app/Activity;ILcom/stepos/ailauncher/common/permission/PermissionUiScene;)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/stepos/ailauncher/common/permission/PermissionLaunchKind;", "c", "()Lcom/stepos/ailauncher/common/permission/PermissionLaunchKind;", "Landroid/app/Activity;", Const.INTENT_KEY_APIKEY, "()Landroid/app/Activity;", "I", Const.INTENT_KEY_PKGNAME, "Lcom/stepos/ailauncher/common/permission/PermissionUiScene;", Const.INTENT_KEY_UMID, "()Lcom/stepos/ailauncher/common/permission/PermissionUiScene;", "e", "()Z", "usesIndependentTask", "permission_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.common.permission.e, reason: case insensitive filesystem and from toString */
/* loaded from: classes3.dex */
public final /* data */ class PermissionHost {
    private final Activity activity;
    private final int anchorTaskId;
    private final PermissionLaunchKind kind;
    private final PermissionUiScene uiScene;

    public PermissionHost(PermissionLaunchKind kind, Activity activity, int i10, PermissionUiScene uiScene) {
        kotlin.jvm.internal.p.i(kind, "kind");
        kotlin.jvm.internal.p.i(uiScene, "uiScene");
        this.kind = kind;
        this.activity = activity;
        this.anchorTaskId = i10;
        this.uiScene = uiScene;
    }

    /* renamed from: a, reason: from getter */
    public final Activity getActivity() {
        return this.activity;
    }

    /* renamed from: b, reason: from getter */
    public final int getAnchorTaskId() {
        return this.anchorTaskId;
    }

    /* renamed from: c, reason: from getter */
    public final PermissionLaunchKind getKind() {
        return this.kind;
    }

    /* renamed from: d, reason: from getter */
    public final PermissionUiScene getUiScene() {
        return this.uiScene;
    }

    public final boolean e() {
        return this.kind == PermissionLaunchKind.NEW_TASK_ANCHORED && this.anchorTaskId <= 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PermissionHost)) {
            return false;
        }
        PermissionHost permissionHost = (PermissionHost) other;
        return this.kind == permissionHost.kind && kotlin.jvm.internal.p.d(this.activity, permissionHost.activity) && this.anchorTaskId == permissionHost.anchorTaskId && this.uiScene == permissionHost.uiScene;
    }

    public int hashCode() {
        int iHashCode = this.kind.hashCode() * 31;
        Activity activity = this.activity;
        return ((((iHashCode + (activity == null ? 0 : activity.hashCode())) * 31) + Integer.hashCode(this.anchorTaskId)) * 31) + this.uiScene.hashCode();
    }

    public String toString() {
        return "PermissionHost(kind=" + this.kind + ", activity=" + this.activity + ", anchorTaskId=" + this.anchorTaskId + ", uiScene=" + this.uiScene + ")";
    }
}
