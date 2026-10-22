package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.a.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: RecorderOperateParams.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class RecorderOperateParams implements Parcelable, IntentParams {
    public static final Parcelable.Creator<RecorderOperateParams> CREATOR = null;
    private String action;
    String doraBluetoothId;
    String doraProductId;

    /* JADX INFO: compiled from: RecorderOperateParams.kt */
    public static final class Creator implements Parcelable.Creator<RecorderOperateParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final RecorderOperateParams createFromParcel(Parcel r10) {
            int r0 = r10.readInt();
            o.e(r10, "parcel");
            RecorderOperateParams r1 = new RecorderOperateParams(r10.readString(), null, null, 6, null);
            int r3 = Math.min(r0, 2);
            ClassLoader r9 = getClass().getClassLoader();
            int r5 = 1;
        L3:
            if (r5 > r3) goto L14;
            if (r5 != 1) goto L9;
            Object r7 = a.b(r10, r9);
            if (r7 == null) goto L13;
            r1.doraBluetoothId = (String) ZeusTransformUtils.preCheckCast(r7, String.class, "com.obric.aiagent.plugin");
        L13:
            r5 = r5 + 1;
            goto L3
        L9:
            if (r5 != 2) goto L13;
            Object r8 = a.b(r10, r9);
            if (r8 == null) goto L13;
            r1.doraProductId = (String) ZeusTransformUtils.preCheckCast(r8, String.class, "com.obric.aiagent.plugin");
        L14:
            if (r5 > r0) goto L16;
            a.a(r10, r9);
            r5 = r5 + 1;
            goto L14
        L16:
            return r1;
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ RecorderOperateParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final RecorderOperateParams[] newArray(int r1) {
            return new RecorderOperateParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ RecorderOperateParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public RecorderOperateParams() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ RecorderOperateParams copy$default(RecorderOperateParams r0, String r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.action;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.doraBluetoothId;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.doraProductId;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public static /* synthetic */ void getDoraBluetoothId$annotations() {
    }

    public static /* synthetic */ void getDoraProductId$annotations() {
    }

    public final String component1() {
        return this.action;
    }

    public final String component2() {
        return this.doraBluetoothId;
    }

    public final String component3() {
        return this.doraProductId;
    }

    public final RecorderOperateParams copy(String r1, String r2, String r3) {
        return new RecorderOperateParams(r1, r2, r3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, RecorderOperateParams.class) == true) goto L8;
        return false;
    L8:
        RecorderOperateParams r6 = (RecorderOperateParams) ZeusTransformUtils.preCheckCast(r5, RecorderOperateParams.class, "com.obric.aiagent.plugin");
        if (o.a(this.action, r6.action) == true) goto L12;
        return false;
    L12:
        if (o.a(this.doraBluetoothId, r6.doraBluetoothId) == true) goto L15;
        return false;
    L15:
        if (o.a(this.doraProductId, r6.doraProductId) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r0 = this.action;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.doraBluetoothId;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.doraProductId;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "RecorderOperateParams(action=" + this.action + ", doraBluetoothId=" + this.doraBluetoothId + ", doraProductId=" + this.doraProductId + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(2);
        o.e(r1, "out");
        r1.writeString(this.action);
        r1.writeValue(this.doraBluetoothId);
        r1.writeValue(this.doraProductId);
    }

    public RecorderOperateParams(String r1, String r2, String r3) {
        this.action = r1;
        this.doraBluetoothId = r2;
        this.doraProductId = r3;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.a.b(this);
    }

    public /* synthetic */ RecorderOperateParams(String r2, String r3, String r4, int r5, h r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }

    public final String getAction() {
        return this.action;
    }

    public final void setAction(String r1) {
        this.action = r1;
    }

    public final String getDoraBluetoothId() {
        return this.doraBluetoothId;
    }

    public final void setDoraBluetoothId(String r1) {
        this.doraBluetoothId = r1;
    }

    public final String getDoraProductId() {
        return this.doraProductId;
    }

    public final void setDoraProductId(String r1) {
        this.doraProductId = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        if (this.action == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r5) {
        if (ZeusTransformUtils.instanceOf(r5, RecorderOperateParams.class) == false) goto L5;
        String r1 = this.action;
        if (r1 != null) goto L9;
        r1 = ((RecorderOperateParams) ZeusTransformUtils.preCheckCast(r5, RecorderOperateParams.class, "com.obric.aiagent.plugin")).action;
    L9:
        String r3 = this.doraBluetoothId;
        if (r3 != null) goto L12;
        r3 = ((RecorderOperateParams) ZeusTransformUtils.preCheckCast(r5, RecorderOperateParams.class, "com.obric.aiagent.plugin")).doraBluetoothId;
    L12:
        String r4 = this.doraProductId;
        if (r4 != null) goto L16;
        r4 = ((RecorderOperateParams) ZeusTransformUtils.preCheckCast(r5, RecorderOperateParams.class, "com.obric.aiagent.plugin")).doraProductId;
    L16:
        return (IntentParams) ZeusTransformUtils.preCheckCast(new RecorderOperateParams(r1, r3, r4), IntentParams.class, "com.obric.aiagent.plugin");
    L5:
        return (IntentParams) ZeusTransformUtils.preCheckCast(this, IntentParams.class, "com.obric.aiagent.plugin");
    }
}
