package com.android.server.permission.access.permission;

import android.content.pm.PermissionInfo;
import android.os.UserHandle;
import com.android.server.permission.jarjar.kotlin.jvm.internal.DefaultConstructorMarker;
import com.android.server.permission.jarjar.kotlin.jvm.internal.Intrinsics;
import java.util.Arrays;
import libcore.util.EmptyArray;

/* JADX INFO: compiled from: Permission.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class Permission {
    public static final Companion Companion = null;
    private final int appId;
    private final boolean areGidsPerUser;
    private final int[] gids;
    private final boolean isReconciled;
    private final PermissionInfo permissionInfo;
    private final int type;

    /* JADX INFO: compiled from: Permission.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final String typeToString(int type) {
            switch(type) {
                case 0: goto L5;
                case 1: goto L7;
                case 2: goto L4;
                default: goto L7;
            };
        L4:
            return "TYPE_DYNAMIC";
        L5:
            return "TYPE_MANIFEST";
        L7:
            return String.valueOf(type);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ Permission copy$default(Permission r0, PermissionInfo r1, boolean r2, int r3, int r4, int[] r5, boolean r6, int r7, Object r8) {
        if ((r7 & 1) == 0) goto L6;
        r1 = r0.permissionInfo;
    L6:
        if ((r7 & 2) == 0) goto L9;
        r2 = r0.isReconciled;
    L9:
        if ((r7 & 4) == 0) goto L12;
        r3 = r0.type;
    L12:
        if ((r7 & 8) == 0) goto L15;
        r4 = r0.appId;
    L15:
        if ((r7 & 16) == 0) goto L18;
        r5 = r0.gids;
    L18:
        if ((r7 & 32) == 0) goto L20;
        r6 = r0.areGidsPerUser;
    L20:
        int[] r9 = r5;
        boolean r10 = r6;
        int r11 = r3;
        int r12 = r4;
        return r0.copy(r1, r2, r11, r12, r9, r10);
    }

    public final Permission copy(PermissionInfo r8, boolean r9, int r10, int r11, int[] r12, boolean r13) {
        return new Permission(r8, r9, r10, r11, r12, r13);
    }

    public boolean equals(Object r6) {
        if (this != r6) goto L6;
        return true;
    L6:
        if ((r6 instanceof Permission) == true) goto L8;
        return false;
    L8:
        Permission r1 = (Permission) r6;
        if (Intrinsics.areEqual(this.permissionInfo, r1.permissionInfo) == true) goto L12;
        return false;
    L12:
        if (this.isReconciled == r1.isReconciled) goto L15;
        return false;
    L15:
        if (this.type == r1.type) goto L18;
        return false;
    L18:
        if (this.appId == r1.appId) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.gids, r1.gids) == true) goto L24;
        return false;
    L24:
        if (this.areGidsPerUser == r1.areGidsPerUser) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        return (((((((((this.permissionInfo.hashCode() * 31) + Boolean.hashCode(this.isReconciled)) * 31) + Integer.hashCode(this.type)) * 31) + Integer.hashCode(this.appId)) * 31) + Arrays.hashCode(this.gids)) * 31) + Boolean.hashCode(this.areGidsPerUser);
    }

    public String toString() {
        return "Permission(permissionInfo=" + this.permissionInfo + ", isReconciled=" + this.isReconciled + ", type=" + this.type + ", appId=" + this.appId + ", gids=" + Arrays.toString(this.gids) + ", areGidsPerUser=" + this.areGidsPerUser + ")";
    }

    public Permission(PermissionInfo permissionInfo, boolean isReconciled, int type, int appId, int[] gids, boolean areGidsPerUser) {
        this.permissionInfo = permissionInfo;
        this.isReconciled = isReconciled;
        this.type = type;
        this.appId = appId;
        this.gids = gids;
        this.areGidsPerUser = areGidsPerUser;
    }

    public /* synthetic */ Permission(PermissionInfo r8, boolean r9, int r10, int r11, int[] r12, boolean r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 16) == 0) goto L5;
        int[] r5 = EmptyArray.INT;
    L7:
        if ((r14 & 32) == 0) goto L9;
        boolean r6 = false;
    L10:
        this(r8, r9, r10, r11, r5, r6);
        return;
    L9:
        r6 = r13;
        goto L10
    L5:
        r5 = r12;
        goto L7
    }

    public final PermissionInfo getPermissionInfo() {
        return this.permissionInfo;
    }

    public final boolean isReconciled() {
        return this.isReconciled;
    }

    public final int getType() {
        return this.type;
    }

    public final int getAppId() {
        return this.appId;
    }

    public final int[] getGids() {
        return this.gids;
    }

    public final boolean getAreGidsPerUser() {
        return this.areGidsPerUser;
    }

    public final int[] getGidsForUser(int userId) {
        if (this.areGidsPerUser == false) goto L7;
        int r0 = this.gids.length;
        int[] r1 = new int[r0];
        int r2 = 0;
    L5:
        if (r2 >= r0) goto L10;
        r1[r2] = UserHandle.getUid(userId, this.gids[r2]);
        r2 = r2 + 1;
        goto L5
    L10:
        return r1;
    L7:
        int[] r3 = this.gids;
        int[] r4 = Arrays.copyOf(r3, r3.length);
        Intrinsics.checkNotNullExpressionValue(r4, "copyOf(...)");
        return r4;
    }
}
