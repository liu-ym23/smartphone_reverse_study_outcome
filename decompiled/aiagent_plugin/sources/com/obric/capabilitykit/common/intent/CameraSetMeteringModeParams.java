package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.a.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: CameraSetMeteringModeParams.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class CameraSetMeteringModeParams implements Parcelable, IntentParams {
    public static final Parcelable.Creator<CameraSetMeteringModeParams> CREATOR = null;
    private String meteringMode;

    /* JADX INFO: compiled from: CameraSetMeteringModeParams.kt */
    public static final class Creator implements Parcelable.Creator<CameraSetMeteringModeParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CameraSetMeteringModeParams createFromParcel(Parcel r5) {
            int r0 = r5.readInt();
            o.e(r5, "parcel");
            CameraSetMeteringModeParams r1 = new CameraSetMeteringModeParams(r5.readString());
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
        public /* bridge */ /* synthetic */ CameraSetMeteringModeParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CameraSetMeteringModeParams[] newArray(int r1) {
            return new CameraSetMeteringModeParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CameraSetMeteringModeParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CameraSetMeteringModeParams() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ CameraSetMeteringModeParams copy$default(CameraSetMeteringModeParams r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.meteringMode;
    L6:
        return r0.copy(r1);
    }

    public final String component1() {
        return this.meteringMode;
    }

    public final CameraSetMeteringModeParams copy(String r1) {
        return new CameraSetMeteringModeParams(r1);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, CameraSetMeteringModeParams.class) == true) goto L8;
        return false;
    L8:
        CameraSetMeteringModeParams r6 = (CameraSetMeteringModeParams) ZeusTransformUtils.preCheckCast(r5, CameraSetMeteringModeParams.class, "com.obric.aiagent.plugin");
        if (o.a(this.meteringMode, r6.meteringMode) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        String r0 = this.meteringMode;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public String toString() {
        return "CameraSetMeteringModeParams(meteringMode=" + this.meteringMode + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(0);
        o.e(r1, "out");
        r1.writeString(this.meteringMode);
    }

    public CameraSetMeteringModeParams(String r1) {
        this.meteringMode = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.a.b(this);
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        return IntentParams.a.a(this);
    }

    public /* synthetic */ CameraSetMeteringModeParams(String r1, int r2, h r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }

    public final String getMeteringMode() {
        return this.meteringMode;
    }

    public final void setMeteringMode(String r1) {
        this.meteringMode = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, CameraSetMeteringModeParams.class) == false) goto L5;
        String r3 = this.meteringMode;
        if (r3 != null) goto L10;
        r3 = ((CameraSetMeteringModeParams) ZeusTransformUtils.preCheckCast(r4, CameraSetMeteringModeParams.class, "com.obric.aiagent.plugin")).meteringMode;
    L10:
        return (IntentParams) ZeusTransformUtils.preCheckCast(new CameraSetMeteringModeParams(r3), IntentParams.class, "com.obric.aiagent.plugin");
    L5:
        return (IntentParams) ZeusTransformUtils.preCheckCast(this, IntentParams.class, "com.obric.aiagent.plugin");
    }
}
