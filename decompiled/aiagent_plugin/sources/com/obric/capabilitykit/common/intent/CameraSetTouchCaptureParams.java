package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.a.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: CameraSetTouchCaptureParams.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class CameraSetTouchCaptureParams implements Parcelable, IntentParams {
    public static final Parcelable.Creator<CameraSetTouchCaptureParams> CREATOR = null;
    private Boolean touchMode;

    /* JADX INFO: compiled from: CameraSetTouchCaptureParams.kt */
    public static final class Creator implements Parcelable.Creator<CameraSetTouchCaptureParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CameraSetTouchCaptureParams createFromParcel(Parcel r6) {
            int r0 = r6.readInt();
            o.e(r6, "parcel");
            int r4 = 1;
            if (r6.readInt() != 0) goto L6;
            Boolean r2 = null;
        L10:
            CameraSetTouchCaptureParams r1 = new CameraSetTouchCaptureParams(r2);
            int r3 = Math.min(r0, 0);
            ClassLoader r5 = getClass().getClassLoader();
        L11:
            if (r4 > r3) goto L13;
            r4 = r4 + 1;
        L13:
            if (r4 > r0) goto L15;
            a.a(r6, r5);
            r4 = r4 + 1;
            goto L13
        L15:
            return r1;
        L6:
            if (r6.readInt() == 0) goto L8;
            boolean r7 = true;
        L9:
            r2 = Boolean.valueOf(r7);
            goto L10
        L8:
            r7 = false;
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CameraSetTouchCaptureParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CameraSetTouchCaptureParams[] newArray(int r1) {
            return new CameraSetTouchCaptureParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CameraSetTouchCaptureParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CameraSetTouchCaptureParams() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ CameraSetTouchCaptureParams copy$default(CameraSetTouchCaptureParams r0, Boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.touchMode;
    L6:
        return r0.copy(r1);
    }

    public final Boolean component1() {
        return this.touchMode;
    }

    public final CameraSetTouchCaptureParams copy(Boolean r1) {
        return new CameraSetTouchCaptureParams(r1);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, CameraSetTouchCaptureParams.class) == true) goto L8;
        return false;
    L8:
        CameraSetTouchCaptureParams r6 = (CameraSetTouchCaptureParams) ZeusTransformUtils.preCheckCast(r5, CameraSetTouchCaptureParams.class, "com.obric.aiagent.plugin");
        if (o.a(this.touchMode, r6.touchMode) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        Boolean r0 = this.touchMode;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public String toString() {
        return "CameraSetTouchCaptureParams(touchMode=" + this.touchMode + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        r2.writeInt(0);
        o.e(r2, "out");
        Boolean r1 = this.touchMode;
        if (r1 != null) goto L5;
        r2.writeInt(0);
        return;
    L5:
        r2.writeInt(1);
        r2.writeInt(r1.booleanValue() ? 1 : 0);
    }

    public CameraSetTouchCaptureParams(Boolean r1) {
        this.touchMode = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.a.b(this);
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        return IntentParams.a.a(this);
    }

    public /* synthetic */ CameraSetTouchCaptureParams(Boolean r1, int r2, h r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }

    public final Boolean getTouchMode() {
        return this.touchMode;
    }

    public final void setTouchMode(Boolean r1) {
        this.touchMode = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, CameraSetTouchCaptureParams.class) == false) goto L5;
        Boolean r3 = this.touchMode;
        if (r3 != null) goto L10;
        r3 = ((CameraSetTouchCaptureParams) ZeusTransformUtils.preCheckCast(r4, CameraSetTouchCaptureParams.class, "com.obric.aiagent.plugin")).touchMode;
    L10:
        return (IntentParams) ZeusTransformUtils.preCheckCast(new CameraSetTouchCaptureParams(r3), IntentParams.class, "com.obric.aiagent.plugin");
    L5:
        return (IntentParams) ZeusTransformUtils.preCheckCast(this, IntentParams.class, "com.obric.aiagent.plugin");
    }
}
