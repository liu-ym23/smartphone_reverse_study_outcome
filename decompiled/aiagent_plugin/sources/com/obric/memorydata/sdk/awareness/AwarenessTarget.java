package com.obric.memorydata.sdk.awareness;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: PersistentAwarenessModels.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AwarenessTarget implements Parcelable {
    public static final Parcelable.Creator<AwarenessTarget> CREATOR = null;
    private final String targetName;
    private final String targetType;

    /* JADX INFO: compiled from: PersistentAwarenessModels.kt */
    public static final class Creator implements Parcelable.Creator<AwarenessTarget> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AwarenessTarget createFromParcel(Parcel r2) {
            o.e(r2, "parcel");
            return new AwarenessTarget(r2.readString(), r2.readString());
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ AwarenessTarget createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AwarenessTarget[] newArray(int r1) {
            return new AwarenessTarget[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ AwarenessTarget[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ AwarenessTarget copy$default(AwarenessTarget r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.targetType;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.targetName;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.targetType;
    }

    public final String component2() {
        return this.targetName;
    }

    public final AwarenessTarget copy(String r1, String r2) {
        o.e(r1, "targetType");
        o.e(r2, "targetName");
        return new AwarenessTarget(r1, r2);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, AwarenessTarget.class) == true) goto L8;
        return false;
    L8:
        AwarenessTarget r6 = (AwarenessTarget) ZeusTransformUtils.preCheckCast(r5, AwarenessTarget.class, "com.obric.aiagent.plugin");
        if (o.a(this.targetType, r6.targetType) == true) goto L12;
        return false;
    L12:
        if (o.a(this.targetName, r6.targetName) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.targetType.hashCode() * 31) + this.targetName.hashCode();
    }

    public String toString() {
        return "AwarenessTarget(targetType=" + this.targetType + ", targetName=" + this.targetName + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        o.e(r1, "dest");
        r1.writeString(this.targetType);
        r1.writeString(this.targetName);
    }

    public AwarenessTarget(String r2, String r3) {
        o.e(r2, "targetType");
        o.e(r3, "targetName");
        this.targetType = r2;
        this.targetName = r3;
    }

    public final String getTargetType() {
        return this.targetType;
    }

    public final String getTargetName() {
        return this.targetName;
    }
}
