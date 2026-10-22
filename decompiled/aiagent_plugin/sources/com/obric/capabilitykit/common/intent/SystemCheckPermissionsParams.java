package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.a.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.Arrays;

/* JADX INFO: compiled from: SystemCheckPermissionsParams.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class SystemCheckPermissionsParams implements Parcelable, IntentParams {
    public static final Parcelable.Creator<SystemCheckPermissionsParams> CREATOR = null;
    private String appletId;
    private Permission[] permissions;

    /* JADX INFO: compiled from: SystemCheckPermissionsParams.kt */
    public static final class Creator implements Parcelable.Creator<SystemCheckPermissionsParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SystemCheckPermissionsParams createFromParcel(Parcel r10) {
            int r0 = r10.readInt();
            o.e(r10, "parcel");
            String r1 = r10.readString();
            if (r10.readInt() != 0) goto L5;
            Permission[] r2 = null;
        L9:
            SystemCheckPermissionsParams r4 = new SystemCheckPermissionsParams(r1, r2);
            int r3 = Math.min(r0, 0);
            ClassLoader r9 = getClass().getClassLoader();
            int r5 = 1;
        L10:
            if (r5 > r3) goto L12;
            r5 = r5 + 1;
        L12:
            if (r5 > r0) goto L14;
            a.a(r10, r9);
            r5 = r5 + 1;
            goto L12
        L14:
            return r4;
        L5:
            int r6 = r10.readInt();
            Permission[] r7 = new Permission[r6];
            int r8 = 0;
        L6:
            if (r8 == r6) goto L8;
            r7[r8] = (Permission) ZeusTransformUtils.preCheckCast(Permission.CREATOR.createFromParcel(r10), Permission.class, "com.obric.aiagent.plugin");
            r8 = r8 + 1;
            goto L6
        L8:
            r2 = r7;
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SystemCheckPermissionsParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SystemCheckPermissionsParams[] newArray(int r1) {
            return new SystemCheckPermissionsParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SystemCheckPermissionsParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SystemCheckPermissionsParams() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ SystemCheckPermissionsParams copy$default(SystemCheckPermissionsParams r0, String r1, Permission[] r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.appletId;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.permissions;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.appletId;
    }

    public final Permission[] component2() {
        return this.permissions;
    }

    public final SystemCheckPermissionsParams copy(String r1, Permission[] r2) {
        return new SystemCheckPermissionsParams(r1, r2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, SystemCheckPermissionsParams.class) == true) goto L8;
        return false;
    L8:
        SystemCheckPermissionsParams r6 = (SystemCheckPermissionsParams) ZeusTransformUtils.preCheckCast(r5, SystemCheckPermissionsParams.class, "com.obric.aiagent.plugin");
        if (o.a(this.appletId, r6.appletId) == true) goto L12;
        return false;
    L12:
        if (o.a(this.permissions, r6.permissions) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r0 = this.appletId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Permission[] r4 = this.permissions;
        if (r4 == null) goto L11;
        r1 = Arrays.hashCode(r4);
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "SystemCheckPermissionsParams(appletId=" + this.appletId + ", permissions=" + Arrays.toString(this.permissions) + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r4, int r5) {
        int r0 = 0;
        r4.writeInt(0);
        o.e(r4, "out");
        r4.writeString(this.appletId);
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

    public SystemCheckPermissionsParams(String r1, Permission[] r2) {
        this.appletId = r1;
        this.permissions = r2;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.a.b(this);
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        return IntentParams.a.a(this);
    }

    public /* synthetic */ SystemCheckPermissionsParams(String r2, Permission[] r3, int r4, h r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }

    public final String getAppletId() {
        return this.appletId;
    }

    public final void setAppletId(String r1) {
        this.appletId = r1;
    }

    public final Permission[] getPermissions() {
        return this.permissions;
    }

    public final void setPermissions(Permission[] r1) {
        this.permissions = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, SystemCheckPermissionsParams.class) == false) goto L5;
        String r1 = this.appletId;
        if (r1 != null) goto L9;
        r1 = ((SystemCheckPermissionsParams) ZeusTransformUtils.preCheckCast(r4, SystemCheckPermissionsParams.class, "com.obric.aiagent.plugin")).appletId;
    L9:
        Permission[] r3 = this.permissions;
        if (r3 != null) goto L13;
        r3 = ((SystemCheckPermissionsParams) ZeusTransformUtils.preCheckCast(r4, SystemCheckPermissionsParams.class, "com.obric.aiagent.plugin")).permissions;
    L13:
        return (IntentParams) ZeusTransformUtils.preCheckCast(new SystemCheckPermissionsParams(r1, r3), IntentParams.class, "com.obric.aiagent.plugin");
    L5:
        return (IntentParams) ZeusTransformUtils.preCheckCast(this, IntentParams.class, "com.obric.aiagent.plugin");
    }
}
