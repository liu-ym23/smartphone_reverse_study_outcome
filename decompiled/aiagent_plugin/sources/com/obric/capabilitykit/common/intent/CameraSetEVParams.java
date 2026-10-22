package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.a.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: CameraSetEVParams.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class CameraSetEVParams implements Parcelable, IntentParams {
    public static final Parcelable.Creator<CameraSetEVParams> CREATOR = null;
    private Double ev;
    private String valueType;

    /* JADX INFO: compiled from: CameraSetEVParams.kt */
    public static final class Creator implements Parcelable.Creator<CameraSetEVParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CameraSetEVParams createFromParcel(Parcel r5) {
            int r0 = r5.readInt();
            o.e(r5, "parcel");
            if (r5.readInt() != 0) goto L5;
            Double r2 = null;
        L6:
            CameraSetEVParams r1 = new CameraSetEVParams(r2, r5.readString());
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
            r2 = Double.valueOf(r5.readDouble());
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CameraSetEVParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CameraSetEVParams[] newArray(int r1) {
            return new CameraSetEVParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CameraSetEVParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CameraSetEVParams() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ CameraSetEVParams copy$default(CameraSetEVParams r0, Double r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.ev;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.valueType;
    L9:
        return r0.copy(r1, r2);
    }

    public final Double component1() {
        return this.ev;
    }

    public final String component2() {
        return this.valueType;
    }

    public final CameraSetEVParams copy(Double r1, String r2) {
        return new CameraSetEVParams(r1, r2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, CameraSetEVParams.class) == true) goto L8;
        return false;
    L8:
        CameraSetEVParams r6 = (CameraSetEVParams) ZeusTransformUtils.preCheckCast(r5, CameraSetEVParams.class, "com.obric.aiagent.plugin");
        if (o.a(this.ev, r6.ev) == true) goto L12;
        return false;
    L12:
        if (o.a(this.valueType, r6.valueType) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        Double r0 = this.ev;
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
        return "CameraSetEVParams(ev=" + this.ev + ", valueType=" + this.valueType + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeInt(0);
        o.e(r3, "out");
        Double r0 = this.ev;
        if (r0 != null) goto L5;
        r3.writeInt(0);
    L6:
        r3.writeString(this.valueType);
        return;
    L5:
        r3.writeInt(1);
        r3.writeDouble(r0.doubleValue());
        goto L6
    }

    public CameraSetEVParams(Double r1, String r2) {
        this.ev = r1;
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

    public /* synthetic */ CameraSetEVParams(Double r2, String r3, int r4, h r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }

    public final Double getEv() {
        return this.ev;
    }

    public final void setEv(Double r1) {
        this.ev = r1;
    }

    public final String getValueType() {
        return this.valueType;
    }

    public final void setValueType(String r1) {
        this.valueType = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, CameraSetEVParams.class) == false) goto L5;
        Double r1 = this.ev;
        if (r1 != null) goto L9;
        r1 = ((CameraSetEVParams) ZeusTransformUtils.preCheckCast(r4, CameraSetEVParams.class, "com.obric.aiagent.plugin")).ev;
    L9:
        String r3 = this.valueType;
        if (r3 != null) goto L13;
        r3 = ((CameraSetEVParams) ZeusTransformUtils.preCheckCast(r4, CameraSetEVParams.class, "com.obric.aiagent.plugin")).valueType;
    L13:
        return (IntentParams) ZeusTransformUtils.preCheckCast(new CameraSetEVParams(r1, r3), IntentParams.class, "com.obric.aiagent.plugin");
    L5:
        return (IntentParams) ZeusTransformUtils.preCheckCast(this, IntentParams.class, "com.obric.aiagent.plugin");
    }
}
