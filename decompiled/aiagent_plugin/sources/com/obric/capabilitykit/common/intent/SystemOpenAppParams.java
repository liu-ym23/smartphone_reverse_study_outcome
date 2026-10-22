package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.a.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: SystemOpenAppParams.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class SystemOpenAppParams implements Parcelable, IntentParams {
    public static final Parcelable.Creator<SystemOpenAppParams> CREATOR = null;
    private String appName;
    String appletId;

    /* JADX INFO: compiled from: SystemOpenAppParams.kt */
    public static final class Creator implements Parcelable.Creator<SystemOpenAppParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Parcelable.Creator
        public final SystemOpenAppParams createFromParcel(Parcel r9) {
            int r0 = r9.readInt();
            o.e(r9, "parcel");
            SystemOpenAppParams r1 = new SystemOpenAppParams(r9.readString(), null, 2, 0 == true ? 1 : 0);
            int r3 = Math.min(r0, 1);
            ClassLoader r8 = getClass().getClassLoader();
            int r4 = 1;
        L3:
            if (r4 > r3) goto L9;
            if (r4 != 1) goto L8;
            Object r5 = a.b(r9, r8);
            if (r5 == null) goto L8;
            r1.appletId = (String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.aiagent.plugin");
        L8:
            r4 = r4 + 1;
        L9:
            if (r4 > r0) goto L11;
            a.a(r9, r8);
            r4 = r4 + 1;
            goto L9
        L11:
            return r1;
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SystemOpenAppParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SystemOpenAppParams[] newArray(int r1) {
            return new SystemOpenAppParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SystemOpenAppParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SystemOpenAppParams() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ SystemOpenAppParams copy$default(SystemOpenAppParams r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.appName;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.appletId;
    L9:
        return r0.copy(r1, r2);
    }

    public static /* synthetic */ void getAppletId$annotations() {
    }

    public final String component1() {
        return this.appName;
    }

    public final String component2() {
        return this.appletId;
    }

    public final SystemOpenAppParams copy(String r1, String r2) {
        return new SystemOpenAppParams(r1, r2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, SystemOpenAppParams.class) == true) goto L8;
        return false;
    L8:
        SystemOpenAppParams r6 = (SystemOpenAppParams) ZeusTransformUtils.preCheckCast(r5, SystemOpenAppParams.class, "com.obric.aiagent.plugin");
        if (o.a(this.appName, r6.appName) == true) goto L12;
        return false;
    L12:
        if (o.a(this.appletId, r6.appletId) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r0 = this.appName;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.appletId;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "SystemOpenAppParams(appName=" + this.appName + ", appletId=" + this.appletId + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(1);
        o.e(r1, "out");
        r1.writeString(this.appName);
        r1.writeValue(this.appletId);
    }

    public SystemOpenAppParams(String r1, String r2) {
        this.appName = r1;
        this.appletId = r2;
    }

    public /* synthetic */ SystemOpenAppParams(String r2, String r3, int r4, h r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }

    public final String getAppName() {
        return this.appName;
    }

    public final void setAppName(String r1) {
        this.appName = r1;
    }

    public final String getAppletId() {
        return this.appletId;
    }

    public final void setAppletId(String r1) {
        this.appletId = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        if (this.appName == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, SystemOpenAppParams.class) == false) goto L5;
        String r1 = this.appName;
        if (r1 != null) goto L9;
        r1 = ((SystemOpenAppParams) ZeusTransformUtils.preCheckCast(r4, SystemOpenAppParams.class, "com.obric.aiagent.plugin")).appName;
    L9:
        String r3 = this.appletId;
        if (r3 != null) goto L13;
        r3 = ((SystemOpenAppParams) ZeusTransformUtils.preCheckCast(r4, SystemOpenAppParams.class, "com.obric.aiagent.plugin")).appletId;
    L13:
        return (IntentParams) ZeusTransformUtils.preCheckCast(new SystemOpenAppParams(r1, r3), IntentParams.class, "com.obric.aiagent.plugin");
    L5:
        return (IntentParams) ZeusTransformUtils.preCheckCast(this, IntentParams.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        String r0 = this.appName;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.toString();
    }
}
