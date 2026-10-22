package com.bytedance.safetyguard.lxc.internal.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: ProxyIpcModels.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ActionFinishResultParcel implements Parcelable {
    public static final Parcelable.Creator<ActionFinishResultParcel> CREATOR = null;
    private final String message;
    private final int protocolVersion;
    private final ActionEgressResultParcel result;
    private final int resultCode;

    /* JADX INFO: compiled from: ProxyIpcModels.kt */
    public static final class Creator implements Parcelable.Creator<ActionFinishResultParcel> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ActionFinishResultParcel createFromParcel(Parcel r6) {
            o.e(r6, "parcel");
            int r0 = r6.readInt();
            String r1 = r6.readString();
            if (r6.readInt() != 0) goto L5;
            ActionEgressResultParcel r2 = null;
        L7:
            return new ActionFinishResultParcel(r0, r1, (ActionEgressResultParcel) ZeusTransformUtils.preCheckCast(r2, ActionEgressResultParcel.class, "com.obric.aiagent.plugin"), r6.readInt());
        L5:
            r2 = ActionEgressResultParcel.CREATOR.createFromParcel(r6);
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ActionFinishResultParcel createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ActionFinishResultParcel[] newArray(int r1) {
            return new ActionFinishResultParcel[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ActionFinishResultParcel[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ ActionFinishResultParcel copy$default(ActionFinishResultParcel r0, int r1, String r2, ActionEgressResultParcel r3, int r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.resultCode;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.message;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.result;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.protocolVersion;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final int component1() {
        return this.resultCode;
    }

    public final String component2() {
        return this.message;
    }

    public final ActionEgressResultParcel component3() {
        return this.result;
    }

    public final int component4() {
        return this.protocolVersion;
    }

    public final ActionFinishResultParcel copy(int r1, String r2, ActionEgressResultParcel r3, int r4) {
        return new ActionFinishResultParcel(r1, r2, r3, r4);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ActionFinishResultParcel.class) == true) goto L8;
        return false;
    L8:
        ActionFinishResultParcel r6 = (ActionFinishResultParcel) ZeusTransformUtils.preCheckCast(r5, ActionFinishResultParcel.class, "com.obric.aiagent.plugin");
        if (this.resultCode == r6.resultCode) goto L12;
        return false;
    L12:
        if (o.a(this.message, r6.message) == true) goto L15;
        return false;
    L15:
        if (o.a(this.result, r6.result) == true) goto L18;
        return false;
    L18:
        if (this.protocolVersion == r6.protocolVersion) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r0 = Integer.hashCode(this.resultCode) * 31;
        String r1 = this.message;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        ActionEgressResultParcel r5 = this.result;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return ((r4 + r2) * 31) + Integer.hashCode(this.protocolVersion);
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "ActionFinishResultParcel(resultCode=" + this.resultCode + ", message=" + this.message + ", result=" + this.result + ", protocolVersion=" + this.protocolVersion + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        o.e(r3, "out");
        r3.writeInt(this.resultCode);
        r3.writeString(this.message);
        ActionEgressResultParcel r0 = this.result;
        if (r0 != null) goto L5;
        r3.writeInt(0);
    L6:
        r3.writeInt(this.protocolVersion);
        return;
    L5:
        r3.writeInt(1);
        r0.writeToParcel(r3, r4);
        goto L6
    }

    public ActionFinishResultParcel(int r1, String r2, ActionEgressResultParcel r3, int r4) {
        this.resultCode = r1;
        this.message = r2;
        this.result = r3;
        this.protocolVersion = r4;
    }

    public /* synthetic */ ActionFinishResultParcel(int r2, String r3, ActionEgressResultParcel r4, int r5, int r6, h r7) {
        if ((r6 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = null;
    L9:
        if ((r6 & 8) == 0) goto L11;
        r5 = 3;
    L11:
        this(r2, r3, r4, r5);
    }

    public final int getResultCode() {
        return this.resultCode;
    }

    public final String getMessage() {
        return this.message;
    }

    public final ActionEgressResultParcel getResult() {
        return this.result;
    }

    public final int getProtocolVersion() {
        return this.protocolVersion;
    }
}
