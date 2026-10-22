package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.a.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: CameraSetFilterParams.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class CameraSetFilterParams implements Parcelable, IntentParams {
    public static final Parcelable.Creator<CameraSetFilterParams> CREATOR = null;
    private String filter;

    /* JADX INFO: compiled from: CameraSetFilterParams.kt */
    public static final class Creator implements Parcelable.Creator<CameraSetFilterParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CameraSetFilterParams createFromParcel(Parcel r5) {
            int r0 = r5.readInt();
            o.e(r5, "parcel");
            CameraSetFilterParams r1 = new CameraSetFilterParams(r5.readString());
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
        public /* bridge */ /* synthetic */ CameraSetFilterParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CameraSetFilterParams[] newArray(int r1) {
            return new CameraSetFilterParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CameraSetFilterParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CameraSetFilterParams() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ CameraSetFilterParams copy$default(CameraSetFilterParams r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.filter;
    L6:
        return r0.copy(r1);
    }

    public final String component1() {
        return this.filter;
    }

    public final CameraSetFilterParams copy(String r1) {
        return new CameraSetFilterParams(r1);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, CameraSetFilterParams.class) == true) goto L8;
        return false;
    L8:
        CameraSetFilterParams r6 = (CameraSetFilterParams) ZeusTransformUtils.preCheckCast(r5, CameraSetFilterParams.class, "com.obric.aiagent.plugin");
        if (o.a(this.filter, r6.filter) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        String r0 = this.filter;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public String toString() {
        return "CameraSetFilterParams(filter=" + this.filter + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(0);
        o.e(r1, "out");
        r1.writeString(this.filter);
    }

    public CameraSetFilterParams(String r1) {
        this.filter = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.a.b(this);
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        return IntentParams.a.a(this);
    }

    public /* synthetic */ CameraSetFilterParams(String r1, int r2, h r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }

    public final String getFilter() {
        return this.filter;
    }

    public final void setFilter(String r1) {
        this.filter = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, CameraSetFilterParams.class) == false) goto L5;
        String r3 = this.filter;
        if (r3 != null) goto L10;
        r3 = ((CameraSetFilterParams) ZeusTransformUtils.preCheckCast(r4, CameraSetFilterParams.class, "com.obric.aiagent.plugin")).filter;
    L10:
        return (IntentParams) ZeusTransformUtils.preCheckCast(new CameraSetFilterParams(r3), IntentParams.class, "com.obric.aiagent.plugin");
    L5:
        return (IntentParams) ZeusTransformUtils.preCheckCast(this, IntentParams.class, "com.obric.aiagent.plugin");
    }
}
