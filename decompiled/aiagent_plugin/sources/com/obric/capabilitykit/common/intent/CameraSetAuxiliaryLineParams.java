package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.a.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: CameraSetAuxiliaryLineParams.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class CameraSetAuxiliaryLineParams implements Parcelable, IntentParams {
    public static final Parcelable.Creator<CameraSetAuxiliaryLineParams> CREATOR = null;
    private Boolean enable;
    private String mode;

    /* JADX INFO: compiled from: CameraSetAuxiliaryLineParams.kt */
    public static final class Creator implements Parcelable.Creator<CameraSetAuxiliaryLineParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CameraSetAuxiliaryLineParams createFromParcel(Parcel r7) {
            int r0 = r7.readInt();
            o.e(r7, "parcel");
            int r4 = 1;
            if (r7.readInt() != 0) goto L6;
            Boolean r2 = null;
        L10:
            CameraSetAuxiliaryLineParams r1 = new CameraSetAuxiliaryLineParams(r2, r7.readString());
            int r3 = Math.min(r0, 0);
            ClassLoader r6 = getClass().getClassLoader();
        L11:
            if (r4 > r3) goto L13;
            r4 = r4 + 1;
        L13:
            if (r4 > r0) goto L15;
            a.a(r7, r6);
            r4 = r4 + 1;
            goto L13
        L15:
            return r1;
        L6:
            if (r7.readInt() == 0) goto L8;
            boolean r5 = true;
        L9:
            r2 = Boolean.valueOf(r5);
            goto L10
        L8:
            r5 = false;
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CameraSetAuxiliaryLineParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CameraSetAuxiliaryLineParams[] newArray(int r1) {
            return new CameraSetAuxiliaryLineParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CameraSetAuxiliaryLineParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CameraSetAuxiliaryLineParams() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ CameraSetAuxiliaryLineParams copy$default(CameraSetAuxiliaryLineParams r0, Boolean r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.enable;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.mode;
    L9:
        return r0.copy(r1, r2);
    }

    public final Boolean component1() {
        return this.enable;
    }

    public final String component2() {
        return this.mode;
    }

    public final CameraSetAuxiliaryLineParams copy(Boolean r1, String r2) {
        return new CameraSetAuxiliaryLineParams(r1, r2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, CameraSetAuxiliaryLineParams.class) == true) goto L8;
        return false;
    L8:
        CameraSetAuxiliaryLineParams r6 = (CameraSetAuxiliaryLineParams) ZeusTransformUtils.preCheckCast(r5, CameraSetAuxiliaryLineParams.class, "com.obric.aiagent.plugin");
        if (o.a(this.enable, r6.enable) == true) goto L12;
        return false;
    L12:
        if (o.a(this.mode, r6.mode) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        Boolean r0 = this.enable;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.mode;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "CameraSetAuxiliaryLineParams(enable=" + this.enable + ", mode=" + this.mode + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [android.os.Parcel, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v4, types: [int] */
    /* JADX WARN: Type inference failed for: r3v5 */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        ?? r4 = 0;
        r2.writeInt(0);
        o.e(r2, "out");
        Boolean r0 = this.enable;
        if (r0 != null) goto L5;
    L4:
        r2.writeInt(r4);
        r2.writeString(this.mode);
        return;
    L5:
        r2.writeInt(1);
        r4 = r0.booleanValue();
        goto L4
    }

    public CameraSetAuxiliaryLineParams(Boolean r1, String r2) {
        this.enable = r1;
        this.mode = r2;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.a.b(this);
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        return IntentParams.a.a(this);
    }

    public /* synthetic */ CameraSetAuxiliaryLineParams(Boolean r2, String r3, int r4, h r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }

    public final Boolean getEnable() {
        return this.enable;
    }

    public final void setEnable(Boolean r1) {
        this.enable = r1;
    }

    public final String getMode() {
        return this.mode;
    }

    public final void setMode(String r1) {
        this.mode = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, CameraSetAuxiliaryLineParams.class) == false) goto L5;
        Boolean r1 = this.enable;
        if (r1 != null) goto L9;
        r1 = ((CameraSetAuxiliaryLineParams) ZeusTransformUtils.preCheckCast(r4, CameraSetAuxiliaryLineParams.class, "com.obric.aiagent.plugin")).enable;
    L9:
        String r3 = this.mode;
        if (r3 != null) goto L13;
        r3 = ((CameraSetAuxiliaryLineParams) ZeusTransformUtils.preCheckCast(r4, CameraSetAuxiliaryLineParams.class, "com.obric.aiagent.plugin")).mode;
    L13:
        return (IntentParams) ZeusTransformUtils.preCheckCast(new CameraSetAuxiliaryLineParams(r1, r3), IntentParams.class, "com.obric.aiagent.plugin");
    L5:
        return (IntentParams) ZeusTransformUtils.preCheckCast(this, IntentParams.class, "com.obric.aiagent.plugin");
    }
}
