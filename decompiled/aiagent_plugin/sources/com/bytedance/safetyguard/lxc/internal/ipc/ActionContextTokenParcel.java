package com.bytedance.safetyguard.lxc.internal.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ProxyIpcModels.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ActionContextTokenParcel implements Parcelable {
    public static final Parcelable.Creator<ActionContextTokenParcel> CREATOR = null;
    private final long activationSequence;
    private final String sessionInstanceId;

    /* JADX INFO: compiled from: ProxyIpcModels.kt */
    public static final class Creator implements Parcelable.Creator<ActionContextTokenParcel> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ActionContextTokenParcel createFromParcel(Parcel r4) {
            o.e(r4, "parcel");
            return new ActionContextTokenParcel(r4.readString(), r4.readLong());
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ActionContextTokenParcel createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ActionContextTokenParcel[] newArray(int r1) {
            return new ActionContextTokenParcel[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ActionContextTokenParcel[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ ActionContextTokenParcel copy$default(ActionContextTokenParcel r0, String r1, long r2, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.sessionInstanceId;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.activationSequence;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.sessionInstanceId;
    }

    public final long component2() {
        return this.activationSequence;
    }

    public final ActionContextTokenParcel copy(String r1, long r2) {
        o.e(r1, "sessionInstanceId");
        return new ActionContextTokenParcel(r1, r2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, ActionContextTokenParcel.class) == true) goto L8;
        return false;
    L8:
        ActionContextTokenParcel r8 = (ActionContextTokenParcel) ZeusTransformUtils.preCheckCast(r7, ActionContextTokenParcel.class, "com.obric.aiagent.plugin");
        if (o.a(this.sessionInstanceId, r8.sessionInstanceId) == true) goto L12;
        return false;
    L12:
        if (this.activationSequence == r8.activationSequence) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.sessionInstanceId.hashCode() * 31) + Long.hashCode(this.activationSequence);
    }

    public String toString() {
        return "ActionContextTokenParcel(sessionInstanceId=" + this.sessionInstanceId + ", activationSequence=" + this.activationSequence + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        o.e(r3, "out");
        r3.writeString(this.sessionInstanceId);
        r3.writeLong(this.activationSequence);
    }

    public ActionContextTokenParcel(String r2, long r3) {
        o.e(r2, "sessionInstanceId");
        this.sessionInstanceId = r2;
        this.activationSequence = r3;
    }

    public final String getSessionInstanceId() {
        return this.sessionInstanceId;
    }

    public final long getActivationSequence() {
        return this.activationSequence;
    }
}
