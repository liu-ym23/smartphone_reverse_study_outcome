package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.a.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: PhoneCallParams.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class PhoneCallParams implements Parcelable, IntentParams {
    public static final Parcelable.Creator<PhoneCallParams> CREATOR = null;
    String simSlot;
    private ContactTarget target;
    private String type;

    /* JADX INFO: compiled from: PhoneCallParams.kt */
    public static final class Creator implements Parcelable.Creator<PhoneCallParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PhoneCallParams createFromParcel(Parcel r10) {
            int r0 = r10.readInt();
            o.e(r10, "parcel");
            if (r10.readInt() != 0) goto L5;
            ContactTarget r2 = null;
        L6:
            PhoneCallParams r1 = new PhoneCallParams((ContactTarget) ZeusTransformUtils.preCheckCast(r2, ContactTarget.class, "com.obric.aiagent.plugin"), r10.readString(), null, 4, null);
            int r3 = Math.min(r0, 1);
            ClassLoader r9 = getClass().getClassLoader();
            int r4 = 1;
        L7:
            if (r4 > r3) goto L13;
            if (r4 != 1) goto L12;
            Object r5 = a.b(r10, r9);
            if (r5 == null) goto L12;
            r1.simSlot = (String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.aiagent.plugin");
        L12:
            r4 = r4 + 1;
        L13:
            if (r4 > r0) goto L15;
            a.a(r10, r9);
            r4 = r4 + 1;
            goto L13
        L15:
            return r1;
        L5:
            r2 = ContactTarget.CREATOR.createFromParcel(r10);
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PhoneCallParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PhoneCallParams[] newArray(int r1) {
            return new PhoneCallParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PhoneCallParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public PhoneCallParams() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ PhoneCallParams copy$default(PhoneCallParams r0, ContactTarget r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.target;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.type;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.simSlot;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public static /* synthetic */ void getSimSlot$annotations() {
    }

    public final ContactTarget component1() {
        return this.target;
    }

    public final String component2() {
        return this.type;
    }

    public final String component3() {
        return this.simSlot;
    }

    public final PhoneCallParams copy(ContactTarget r1, String r2, String r3) {
        return new PhoneCallParams(r1, r2, r3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, PhoneCallParams.class) == true) goto L8;
        return false;
    L8:
        PhoneCallParams r6 = (PhoneCallParams) ZeusTransformUtils.preCheckCast(r5, PhoneCallParams.class, "com.obric.aiagent.plugin");
        if (o.a(this.target, r6.target) == true) goto L12;
        return false;
    L12:
        if (o.a(this.type, r6.type) == true) goto L15;
        return false;
    L15:
        if (o.a(this.simSlot, r6.simSlot) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        ContactTarget r0 = this.target;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.type;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.simSlot;
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
        return "PhoneCallParams(target=" + this.target + ", type=" + this.type + ", simSlot=" + this.simSlot + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeInt(1);
        o.e(r3, "out");
        ContactTarget r1 = this.target;
        if (r1 != null) goto L5;
        r3.writeInt(0);
    L6:
        r3.writeString(this.type);
        r3.writeValue(this.simSlot);
        return;
    L5:
        r3.writeInt(1);
        r1.writeToParcel(r3, r4);
        goto L6
    }

    public PhoneCallParams(ContactTarget r1, String r2, String r3) {
        this.target = r1;
        this.type = r2;
        this.simSlot = r3;
    }

    public /* synthetic */ PhoneCallParams(ContactTarget r2, String r3, String r4, int r5, h r6) {
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

    public final ContactTarget getTarget() {
        return this.target;
    }

    public final void setTarget(ContactTarget r1) {
        this.target = r1;
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(String r1) {
        this.type = r1;
    }

    public final String getSimSlot() {
        return this.simSlot;
    }

    public final void setSimSlot(String r1) {
        this.simSlot = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        if (this.target == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r5) {
        if (ZeusTransformUtils.instanceOf(r5, PhoneCallParams.class) == false) goto L5;
        ContactTarget r1 = this.target;
        if (r1 != null) goto L9;
        r1 = ((PhoneCallParams) ZeusTransformUtils.preCheckCast(r5, PhoneCallParams.class, "com.obric.aiagent.plugin")).target;
    L9:
        String r3 = this.type;
        if (r3 != null) goto L12;
        r3 = ((PhoneCallParams) ZeusTransformUtils.preCheckCast(r5, PhoneCallParams.class, "com.obric.aiagent.plugin")).type;
    L12:
        String r4 = this.simSlot;
        if (r4 != null) goto L16;
        r4 = ((PhoneCallParams) ZeusTransformUtils.preCheckCast(r5, PhoneCallParams.class, "com.obric.aiagent.plugin")).simSlot;
    L16:
        return (IntentParams) ZeusTransformUtils.preCheckCast(new PhoneCallParams(r1, r3, r4), IntentParams.class, "com.obric.aiagent.plugin");
    L5:
        return (IntentParams) ZeusTransformUtils.preCheckCast(this, IntentParams.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        ContactTarget r0 = this.target;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.toString();
    }
}
