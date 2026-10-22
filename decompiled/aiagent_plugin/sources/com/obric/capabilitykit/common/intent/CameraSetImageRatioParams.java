package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.a.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: CameraSetImageRatioParams.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class CameraSetImageRatioParams implements Parcelable, IntentParams {
    public static final Parcelable.Creator<CameraSetImageRatioParams> CREATOR = null;
    private String ratio;

    /* JADX INFO: compiled from: CameraSetImageRatioParams.kt */
    public static final class Creator implements Parcelable.Creator<CameraSetImageRatioParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CameraSetImageRatioParams createFromParcel(Parcel r5) {
            int r0 = r5.readInt();
            o.e(r5, "parcel");
            CameraSetImageRatioParams r1 = new CameraSetImageRatioParams(r5.readString());
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
        public /* bridge */ /* synthetic */ CameraSetImageRatioParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CameraSetImageRatioParams[] newArray(int r1) {
            return new CameraSetImageRatioParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CameraSetImageRatioParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CameraSetImageRatioParams() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ CameraSetImageRatioParams copy$default(CameraSetImageRatioParams r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.ratio;
    L6:
        return r0.copy(r1);
    }

    public final String component1() {
        return this.ratio;
    }

    public final CameraSetImageRatioParams copy(String r1) {
        return new CameraSetImageRatioParams(r1);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, CameraSetImageRatioParams.class) == true) goto L8;
        return false;
    L8:
        CameraSetImageRatioParams r6 = (CameraSetImageRatioParams) ZeusTransformUtils.preCheckCast(r5, CameraSetImageRatioParams.class, "com.obric.aiagent.plugin");
        if (o.a(this.ratio, r6.ratio) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        String r0 = this.ratio;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public String toString() {
        return "CameraSetImageRatioParams(ratio=" + this.ratio + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(0);
        o.e(r1, "out");
        r1.writeString(this.ratio);
    }

    public CameraSetImageRatioParams(String r1) {
        this.ratio = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.a.b(this);
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        return IntentParams.a.a(this);
    }

    public /* synthetic */ CameraSetImageRatioParams(String r1, int r2, h r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }

    public final String getRatio() {
        return this.ratio;
    }

    public final void setRatio(String r1) {
        this.ratio = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, CameraSetImageRatioParams.class) == false) goto L5;
        String r3 = this.ratio;
        if (r3 != null) goto L10;
        r3 = ((CameraSetImageRatioParams) ZeusTransformUtils.preCheckCast(r4, CameraSetImageRatioParams.class, "com.obric.aiagent.plugin")).ratio;
    L10:
        return (IntentParams) ZeusTransformUtils.preCheckCast(new CameraSetImageRatioParams(r3), IntentParams.class, "com.obric.aiagent.plugin");
    L5:
        return (IntentParams) ZeusTransformUtils.preCheckCast(this, IntentParams.class, "com.obric.aiagent.plugin");
    }
}
