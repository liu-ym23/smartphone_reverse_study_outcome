package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.a.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: SystemPowerLockControlParams.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class SystemPowerLockControlParams implements Parcelable, IntentParams {
    public static final Parcelable.Creator<SystemPowerLockControlParams> CREATOR = null;
    private String action;

    /* JADX INFO: compiled from: SystemPowerLockControlParams.kt */
    public static final class Creator implements Parcelable.Creator<SystemPowerLockControlParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SystemPowerLockControlParams createFromParcel(Parcel r5) {
            int r0 = r5.readInt();
            o.e(r5, "parcel");
            SystemPowerLockControlParams r1 = new SystemPowerLockControlParams(r5.readString());
            int r2 = Math.min(r0, 0);
            ClassLoader r4 = getClass().getClassLoader();
            int r3 = 1;
        L3:
            if (r3 > r2) goto L5;
            r3 = r3 + 1;
        L5:
            if (r3 > r0) goto L7;
            a.a(r5, r4);
            r3 = r3 + 1;
            goto L5
        L7:
            return r1;
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SystemPowerLockControlParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SystemPowerLockControlParams[] newArray(int r1) {
            return new SystemPowerLockControlParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SystemPowerLockControlParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SystemPowerLockControlParams() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ SystemPowerLockControlParams copy$default(SystemPowerLockControlParams r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.action;
    L6:
        return r0.copy(r1);
    }

    public final String component1() {
        return this.action;
    }

    public final SystemPowerLockControlParams copy(String r1) {
        return new SystemPowerLockControlParams(r1);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, SystemPowerLockControlParams.class) == true) goto L8;
        return false;
    L8:
        SystemPowerLockControlParams r6 = (SystemPowerLockControlParams) ZeusTransformUtils.preCheckCast(r5, SystemPowerLockControlParams.class, "com.obric.aiagent.plugin");
        if (o.a(this.action, r6.action) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        String r0 = this.action;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public String toString() {
        return "SystemPowerLockControlParams(action=" + this.action + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(0);
        o.e(r1, "out");
        r1.writeString(this.action);
    }

    public SystemPowerLockControlParams(String r1) {
        this.action = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.a.b(this);
    }

    public /* synthetic */ SystemPowerLockControlParams(String r1, int r2, h r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }

    public final String getAction() {
        return this.action;
    }

    public final void setAction(String r1) {
        this.action = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        if (this.action == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, SystemPowerLockControlParams.class) == false) goto L5;
        String r3 = this.action;
        if (r3 != null) goto L10;
        r3 = ((SystemPowerLockControlParams) ZeusTransformUtils.preCheckCast(r4, SystemPowerLockControlParams.class, "com.obric.aiagent.plugin")).action;
    L10:
        return (IntentParams) ZeusTransformUtils.preCheckCast(new SystemPowerLockControlParams(r3), IntentParams.class, "com.obric.aiagent.plugin");
    L5:
        return (IntentParams) ZeusTransformUtils.preCheckCast(this, IntentParams.class, "com.obric.aiagent.plugin");
    }
}
