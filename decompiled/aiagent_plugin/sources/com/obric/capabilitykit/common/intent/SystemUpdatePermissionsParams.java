package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.a.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.Arrays;

/* JADX INFO: compiled from: SystemUpdatePermissionsParams.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class SystemUpdatePermissionsParams implements Parcelable, IntentParams {
    public static final Parcelable.Creator<SystemUpdatePermissionsParams> CREATOR = null;
    private Permission[] permissions;

    /* JADX INFO: compiled from: SystemUpdatePermissionsParams.kt */
    public static final class Creator implements Parcelable.Creator<SystemUpdatePermissionsParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SystemUpdatePermissionsParams createFromParcel(Parcel r9) {
            int r0 = r9.readInt();
            o.e(r9, "parcel");
            if (r9.readInt() != 0) goto L5;
            Permission[] r1 = null;
        L9:
            SystemUpdatePermissionsParams r3 = new SystemUpdatePermissionsParams(r1);
            int r2 = Math.min(r0, 0);
            ClassLoader r8 = getClass().getClassLoader();
            int r4 = 1;
        L10:
            if (r4 > r2) goto L12;
            r4 = r4 + 1;
        L12:
            if (r4 > r0) goto L14;
            a.a(r9, r8);
            r4 = r4 + 1;
            goto L12
        L14:
            return r3;
        L5:
            int r5 = r9.readInt();
            Permission[] r6 = new Permission[r5];
            int r7 = 0;
        L6:
            if (r7 == r5) goto L8;
            r6[r7] = (Permission) ZeusTransformUtils.preCheckCast(Permission.CREATOR.createFromParcel(r9), Permission.class, "com.obric.aiagent.plugin");
            r7 = r7 + 1;
            goto L6
        L8:
            r1 = r6;
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SystemUpdatePermissionsParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SystemUpdatePermissionsParams[] newArray(int r1) {
            return new SystemUpdatePermissionsParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SystemUpdatePermissionsParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SystemUpdatePermissionsParams() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ SystemUpdatePermissionsParams copy$default(SystemUpdatePermissionsParams r0, Permission[] r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.permissions;
    L6:
        return r0.copy(r1);
    }

    public final Permission[] component1() {
        return this.permissions;
    }

    public final SystemUpdatePermissionsParams copy(Permission[] r1) {
        return new SystemUpdatePermissionsParams(r1);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, SystemUpdatePermissionsParams.class) == true) goto L8;
        return false;
    L8:
        SystemUpdatePermissionsParams r6 = (SystemUpdatePermissionsParams) ZeusTransformUtils.preCheckCast(r5, SystemUpdatePermissionsParams.class, "com.obric.aiagent.plugin");
        if (o.a(this.permissions, r6.permissions) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        Permission[] r0 = this.permissions;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return Arrays.hashCode(r0);
    }

    public String toString() {
        return "SystemUpdatePermissionsParams(permissions=" + Arrays.toString(this.permissions) + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r4, int r5) {
        int r0 = 0;
        r4.writeInt(0);
        o.e(r4, "out");
        Permission[] r3 = this.permissions;
        if (r3 != null) goto L5;
        r4.writeInt(0);
        return;
    L5:
        r4.writeInt(1);
        int r1 = r3.length;
        r4.writeInt(r1);
    L6:
        if (r0 == r1) goto L10;
        r3[r0].writeToParcel(r4, r5);
        r0 = r0 + 1;
        goto L6
    }

    public SystemUpdatePermissionsParams(Permission[] r1) {
        this.permissions = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.a.b(this);
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        return IntentParams.a.a(this);
    }

    public /* synthetic */ SystemUpdatePermissionsParams(Permission[] r1, int r2, h r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }

    public final Permission[] getPermissions() {
        return this.permissions;
    }

    public final void setPermissions(Permission[] r1) {
        this.permissions = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, SystemUpdatePermissionsParams.class) == false) goto L5;
        Permission[] r3 = this.permissions;
        if (r3 != null) goto L10;
        r3 = ((SystemUpdatePermissionsParams) ZeusTransformUtils.preCheckCast(r4, SystemUpdatePermissionsParams.class, "com.obric.aiagent.plugin")).permissions;
    L10:
        return (IntentParams) ZeusTransformUtils.preCheckCast(new SystemUpdatePermissionsParams(r3), IntentParams.class, "com.obric.aiagent.plugin");
    L5:
        return (IntentParams) ZeusTransformUtils.preCheckCast(this, IntentParams.class, "com.obric.aiagent.plugin");
    }
}
