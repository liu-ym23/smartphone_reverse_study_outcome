package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.a.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: PCEntityPoisonLabelParams.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class PCEntityPoisonLabelParams implements Parcelable, IntentParams {
    public static final Parcelable.Creator<PCEntityPoisonLabelParams> CREATOR = null;
    private Integer labelVersion;
    private String operateList;

    /* JADX INFO: compiled from: PCEntityPoisonLabelParams.kt */
    public static final class Creator implements Parcelable.Creator<PCEntityPoisonLabelParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PCEntityPoisonLabelParams createFromParcel(Parcel r5) {
            int r0 = r5.readInt();
            o.e(r5, "parcel");
            if (r5.readInt() != 0) goto L5;
            Integer r2 = null;
        L6:
            PCEntityPoisonLabelParams r1 = new PCEntityPoisonLabelParams(r2, r5.readString());
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
        public /* bridge */ /* synthetic */ PCEntityPoisonLabelParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PCEntityPoisonLabelParams[] newArray(int r1) {
            return new PCEntityPoisonLabelParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PCEntityPoisonLabelParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PCEntityPoisonLabelParams() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ PCEntityPoisonLabelParams copy$default(PCEntityPoisonLabelParams r0, Integer r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.labelVersion;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.operateList;
    L9:
        return r0.copy(r1, r2);
    }

    public final Integer component1() {
        return this.labelVersion;
    }

    public final String component2() {
        return this.operateList;
    }

    public final PCEntityPoisonLabelParams copy(Integer r1, String r2) {
        return new PCEntityPoisonLabelParams(r1, r2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, PCEntityPoisonLabelParams.class) == true) goto L8;
        return false;
    L8:
        PCEntityPoisonLabelParams r6 = (PCEntityPoisonLabelParams) ZeusTransformUtils.preCheckCast(r5, PCEntityPoisonLabelParams.class, "com.obric.aiagent.plugin");
        if (o.a(this.labelVersion, r6.labelVersion) == true) goto L12;
        return false;
    L12:
        if (o.a(this.operateList, r6.operateList) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        Integer r0 = this.labelVersion;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.operateList;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "PCEntityPoisonLabelParams(labelVersion=" + this.labelVersion + ", operateList=" + this.operateList + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        int r4 = 0;
        r2.writeInt(0);
        o.e(r2, "out");
        Integer r0 = this.labelVersion;
        if (r0 == null) goto L6;
        r2.writeInt(1);
        r4 = r0.intValue();
    L6:
        r2.writeInt(r4);
        r2.writeString(this.operateList);
    }

    public PCEntityPoisonLabelParams(Integer r1, String r2) {
        this.labelVersion = r1;
        this.operateList = r2;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.a.b(this);
    }

    public /* synthetic */ PCEntityPoisonLabelParams(Integer r2, String r3, int r4, h r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }

    public final Integer getLabelVersion() {
        return this.labelVersion;
    }

    public final void setLabelVersion(Integer r1) {
        this.labelVersion = r1;
    }

    public final String getOperateList() {
        return this.operateList;
    }

    public final void setOperateList(String r1) {
        this.operateList = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        if (this.operateList == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, PCEntityPoisonLabelParams.class) == false) goto L5;
        Integer r1 = this.labelVersion;
        if (r1 != null) goto L9;
        r1 = ((PCEntityPoisonLabelParams) ZeusTransformUtils.preCheckCast(r4, PCEntityPoisonLabelParams.class, "com.obric.aiagent.plugin")).labelVersion;
    L9:
        String r3 = this.operateList;
        if (r3 != null) goto L13;
        r3 = ((PCEntityPoisonLabelParams) ZeusTransformUtils.preCheckCast(r4, PCEntityPoisonLabelParams.class, "com.obric.aiagent.plugin")).operateList;
    L13:
        return (IntentParams) ZeusTransformUtils.preCheckCast(new PCEntityPoisonLabelParams(r1, r3), IntentParams.class, "com.obric.aiagent.plugin");
    L5:
        return (IntentParams) ZeusTransformUtils.preCheckCast(this, IntentParams.class, "com.obric.aiagent.plugin");
    }
}
