package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.a.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: CameraSetWBParams.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class CameraSetWBParams implements Parcelable, IntentParams {
    public static final Parcelable.Creator<CameraSetWBParams> CREATOR = null;
    private String valueType;
    private Integer wb;

    /* JADX INFO: compiled from: CameraSetWBParams.kt */
    public static final class Creator implements Parcelable.Creator<CameraSetWBParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CameraSetWBParams createFromParcel(Parcel r5) {
            int r0 = r5.readInt();
            o.e(r5, "parcel");
            if (r5.readInt() != 0) goto L5;
            Integer r2 = null;
        L6:
            CameraSetWBParams r1 = new CameraSetWBParams(r2, r5.readString());
            int r3 = Math.min(r0, 0);
            ClassLoader r4 = getClass().getClassLoader();
            int r6 = 1;
        L7:
            if (r6 > r3) goto L9;
            r6 = r6 + 1;
        L9:
            if (r6 > r0) goto L11;
            a.a(r5, r4);
            r6 = r6 + 1;
            goto L9
        L11:
            return r1;
        L5:
            r2 = Integer.valueOf(r5.readInt());
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CameraSetWBParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CameraSetWBParams[] newArray(int r1) {
            return new CameraSetWBParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CameraSetWBParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CameraSetWBParams() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ CameraSetWBParams copy$default(CameraSetWBParams r0, Integer r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.wb;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.valueType;
    L9:
        return r0.copy(r1, r2);
    }

    public final Integer component1() {
        return this.wb;
    }

    public final String component2() {
        return this.valueType;
    }

    public final CameraSetWBParams copy(Integer r1, String r2) {
        return new CameraSetWBParams(r1, r2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, CameraSetWBParams.class) == true) goto L8;
        return false;
    L8:
        CameraSetWBParams r6 = (CameraSetWBParams) ZeusTransformUtils.preCheckCast(r5, CameraSetWBParams.class, "com.obric.aiagent.plugin");
        if (o.a(this.wb, r6.wb) == true) goto L12;
        return false;
    L12:
        if (o.a(this.valueType, r6.valueType) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        Integer r0 = this.wb;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.valueType;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "CameraSetWBParams(wb=" + this.wb + ", valueType=" + this.valueType + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        int r4 = 0;
        r2.writeInt(0);
        o.e(r2, "out");
        Integer r0 = this.wb;
        if (r0 == null) goto L6;
        r2.writeInt(1);
        r4 = r0.intValue();
    L6:
        r2.writeInt(r4);
        r2.writeString(this.valueType);
    }

    public CameraSetWBParams(Integer r1, String r2) {
        this.wb = r1;
        this.valueType = r2;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.a.b(this);
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        return IntentParams.a.a(this);
    }

    public /* synthetic */ CameraSetWBParams(Integer r2, String r3, int r4, h r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }

    public final Integer getWb() {
        return this.wb;
    }

    public final void setWb(Integer r1) {
        this.wb = r1;
    }

    public final String getValueType() {
        return this.valueType;
    }

    public final void setValueType(String r1) {
        this.valueType = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, CameraSetWBParams.class) == false) goto L5;
        Integer r1 = this.wb;
        if (r1 != null) goto L9;
        r1 = ((CameraSetWBParams) ZeusTransformUtils.preCheckCast(r4, CameraSetWBParams.class, "com.obric.aiagent.plugin")).wb;
    L9:
        String r3 = this.valueType;
        if (r3 != null) goto L13;
        r3 = ((CameraSetWBParams) ZeusTransformUtils.preCheckCast(r4, CameraSetWBParams.class, "com.obric.aiagent.plugin")).valueType;
    L13:
        return (IntentParams) ZeusTransformUtils.preCheckCast(new CameraSetWBParams(r1, r3), IntentParams.class, "com.obric.aiagent.plugin");
    L5:
        return (IntentParams) ZeusTransformUtils.preCheckCast(this, IntentParams.class, "com.obric.aiagent.plugin");
    }
}
