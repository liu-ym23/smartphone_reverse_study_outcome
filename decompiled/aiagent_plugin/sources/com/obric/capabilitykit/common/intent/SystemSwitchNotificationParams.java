package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.a.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: SystemSwitchNotificationParams.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class SystemSwitchNotificationParams implements Parcelable, IntentParams {
    public static final Parcelable.Creator<SystemSwitchNotificationParams> CREATOR = null;
    private Boolean enable;
    private String targetAppName;

    /* JADX INFO: compiled from: SystemSwitchNotificationParams.kt */
    public static final class Creator implements Parcelable.Creator<SystemSwitchNotificationParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SystemSwitchNotificationParams createFromParcel(Parcel r7) {
            int r0 = r7.readInt();
            o.e(r7, "parcel");
            String r2 = r7.readString();
            int r5 = 1;
            if (r7.readInt() != 0) goto L6;
            Boolean r3 = null;
        L10:
            SystemSwitchNotificationParams r1 = new SystemSwitchNotificationParams(r2, r3);
            int r4 = Math.min(r0, 0);
            ClassLoader r6 = getClass().getClassLoader();
        L11:
            if (r5 > r4) goto L13;
            r5 = r5 + 1;
        L13:
            if (r5 > r0) goto L15;
            a.a(r7, r6);
            r5 = r5 + 1;
            goto L13
        L15:
            return r1;
        L6:
            if (r7.readInt() == 0) goto L8;
            boolean r8 = true;
        L9:
            r3 = Boolean.valueOf(r8);
            goto L10
        L8:
            r8 = false;
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SystemSwitchNotificationParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SystemSwitchNotificationParams[] newArray(int r1) {
            return new SystemSwitchNotificationParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SystemSwitchNotificationParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SystemSwitchNotificationParams() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ SystemSwitchNotificationParams copy$default(SystemSwitchNotificationParams r0, String r1, Boolean r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.targetAppName;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.enable;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.targetAppName;
    }

    public final Boolean component2() {
        return this.enable;
    }

    public final SystemSwitchNotificationParams copy(String r1, Boolean r2) {
        return new SystemSwitchNotificationParams(r1, r2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, SystemSwitchNotificationParams.class) == true) goto L8;
        return false;
    L8:
        SystemSwitchNotificationParams r6 = (SystemSwitchNotificationParams) ZeusTransformUtils.preCheckCast(r5, SystemSwitchNotificationParams.class, "com.obric.aiagent.plugin");
        if (o.a(this.targetAppName, r6.targetAppName) == true) goto L12;
        return false;
    L12:
        if (o.a(this.enable, r6.enable) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r0 = this.targetAppName;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Boolean r4 = this.enable;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "SystemSwitchNotificationParams(targetAppName=" + this.targetAppName + ", enable=" + this.enable + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        r2.writeInt(0);
        o.e(r2, "out");
        r2.writeString(this.targetAppName);
        Boolean r1 = this.enable;
        if (r1 != null) goto L5;
        r2.writeInt(0);
        return;
    L5:
        r2.writeInt(1);
        r2.writeInt(r1.booleanValue() ? 1 : 0);
    }

    public SystemSwitchNotificationParams(String r1, Boolean r2) {
        this.targetAppName = r1;
        this.enable = r2;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.a.b(this);
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        return IntentParams.a.a(this);
    }

    public /* synthetic */ SystemSwitchNotificationParams(String r2, Boolean r3, int r4, h r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }

    public final String getTargetAppName() {
        return this.targetAppName;
    }

    public final void setTargetAppName(String r1) {
        this.targetAppName = r1;
    }

    public final Boolean getEnable() {
        return this.enable;
    }

    public final void setEnable(Boolean r1) {
        this.enable = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, SystemSwitchNotificationParams.class) == false) goto L5;
        String r1 = this.targetAppName;
        if (r1 != null) goto L9;
        r1 = ((SystemSwitchNotificationParams) ZeusTransformUtils.preCheckCast(r4, SystemSwitchNotificationParams.class, "com.obric.aiagent.plugin")).targetAppName;
    L9:
        Boolean r3 = this.enable;
        if (r3 != null) goto L13;
        r3 = ((SystemSwitchNotificationParams) ZeusTransformUtils.preCheckCast(r4, SystemSwitchNotificationParams.class, "com.obric.aiagent.plugin")).enable;
    L13:
        return (IntentParams) ZeusTransformUtils.preCheckCast(new SystemSwitchNotificationParams(r1, r3), IntentParams.class, "com.obric.aiagent.plugin");
    L5:
        return (IntentParams) ZeusTransformUtils.preCheckCast(this, IntentParams.class, "com.obric.aiagent.plugin");
    }
}
