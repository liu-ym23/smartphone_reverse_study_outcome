package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.a.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: SystemShellParams.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class SystemShellParams implements Parcelable, IntentParams {
    public static final Parcelable.Creator<SystemShellParams> CREATOR = null;
    private String actionArgs;
    private String actionType;
    private String uniqueId;

    /* JADX INFO: compiled from: SystemShellParams.kt */
    public static final class Creator implements Parcelable.Creator<SystemShellParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SystemShellParams createFromParcel(Parcel r6) {
            int r0 = r6.readInt();
            o.e(r6, "parcel");
            SystemShellParams r1 = new SystemShellParams(r6.readString(), r6.readString(), r6.readString());
            int r2 = Math.min(r0, 0);
            ClassLoader r5 = getClass().getClassLoader();
            int r3 = 1;
        L3:
            if (r3 > r2) goto L5;
            r3 = r3 + 1;
        L5:
            if (r3 > r0) goto L7;
            a.a(r6, r5);
            r3 = r3 + 1;
            goto L5
        L7:
            return r1;
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SystemShellParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SystemShellParams[] newArray(int r1) {
            return new SystemShellParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SystemShellParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public SystemShellParams() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ SystemShellParams copy$default(SystemShellParams r0, String r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.uniqueId;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.actionType;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.actionArgs;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.uniqueId;
    }

    public final String component2() {
        return this.actionType;
    }

    public final String component3() {
        return this.actionArgs;
    }

    public final SystemShellParams copy(String r1, String r2, String r3) {
        return new SystemShellParams(r1, r2, r3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, SystemShellParams.class) == true) goto L8;
        return false;
    L8:
        SystemShellParams r6 = (SystemShellParams) ZeusTransformUtils.preCheckCast(r5, SystemShellParams.class, "com.obric.aiagent.plugin");
        if (o.a(this.uniqueId, r6.uniqueId) == true) goto L12;
        return false;
    L12:
        if (o.a(this.actionType, r6.actionType) == true) goto L15;
        return false;
    L15:
        if (o.a(this.actionArgs, r6.actionArgs) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r0 = this.uniqueId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.actionType;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.actionArgs;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "SystemShellParams(uniqueId=" + this.uniqueId + ", actionType=" + this.actionType + ", actionArgs=" + this.actionArgs + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(0);
        o.e(r1, "out");
        r1.writeString(this.uniqueId);
        r1.writeString(this.actionType);
        r1.writeString(this.actionArgs);
    }

    public SystemShellParams(String r1, String r2, String r3) {
        this.uniqueId = r1;
        this.actionType = r2;
        this.actionArgs = r3;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.a.b(this);
    }

    public /* synthetic */ SystemShellParams(String r2, String r3, String r4, int r5, h r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }

    public final String getUniqueId() {
        return this.uniqueId;
    }

    public final void setUniqueId(String r1) {
        this.uniqueId = r1;
    }

    public final String getActionType() {
        return this.actionType;
    }

    public final void setActionType(String r1) {
        this.actionType = r1;
    }

    public final String getActionArgs() {
        return this.actionArgs;
    }

    public final void setActionArgs(String r1) {
        this.actionArgs = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        if (this.uniqueId != null) goto L5;
    L9:
        return false;
    L5:
        if (this.actionType == null) goto L9;
        if (this.actionArgs == null) goto L9;
        return true;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r5) {
        if (ZeusTransformUtils.instanceOf(r5, SystemShellParams.class) == false) goto L5;
        String r1 = this.uniqueId;
        if (r1 != null) goto L9;
        r1 = ((SystemShellParams) ZeusTransformUtils.preCheckCast(r5, SystemShellParams.class, "com.obric.aiagent.plugin")).uniqueId;
    L9:
        String r3 = this.actionType;
        if (r3 != null) goto L12;
        r3 = ((SystemShellParams) ZeusTransformUtils.preCheckCast(r5, SystemShellParams.class, "com.obric.aiagent.plugin")).actionType;
    L12:
        String r4 = this.actionArgs;
        if (r4 != null) goto L16;
        r4 = ((SystemShellParams) ZeusTransformUtils.preCheckCast(r5, SystemShellParams.class, "com.obric.aiagent.plugin")).actionArgs;
    L16:
        return (IntentParams) ZeusTransformUtils.preCheckCast(new SystemShellParams(r1, r3, r4), IntentParams.class, "com.obric.aiagent.plugin");
    L5:
        return (IntentParams) ZeusTransformUtils.preCheckCast(this, IntentParams.class, "com.obric.aiagent.plugin");
    }
}
