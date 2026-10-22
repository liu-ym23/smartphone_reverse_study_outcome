package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.a.a;
import com.obric.capabilitykit.entity.app.CallHistoryEntity;
import com.obric.capabilitykit.entity.app.ContactEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: Params.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class BlockListTarget implements Parcelable {
    public static final Parcelable.Creator<BlockListTarget> CREATOR = null;
    private final CallHistoryEntity callHistory;
    private final ContactEntity contact;
    private final String telephone;

    /* JADX INFO: compiled from: Params.kt */
    public static final class Creator implements Parcelable.Creator<BlockListTarget> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final BlockListTarget createFromParcel(Parcel r7) {
            int r0 = r7.readInt();
            o.e(r7, "parcel");
            BlockListTarget r1 = new BlockListTarget((ContactEntity) ZeusTransformUtils.preCheckCast(r7.readParcelable(BlockListTarget.class.getClassLoader()), ContactEntity.class, "com.obric.aiagent.plugin"), (CallHistoryEntity) ZeusTransformUtils.preCheckCast(r7.readParcelable(BlockListTarget.class.getClassLoader()), CallHistoryEntity.class, "com.obric.aiagent.plugin"), r7.readString());
            int r2 = Math.min(r0, 0);
            ClassLoader r6 = getClass().getClassLoader();
            int r3 = 1;
        L3:
            if (r3 > r2) goto L5;
            r3 = r3 + 1;
        L5:
            if (r3 > r0) goto L7;
            a.a(r7, r6);
            r3 = r3 + 1;
            goto L5
        L7:
            return r1;
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ BlockListTarget createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final BlockListTarget[] newArray(int r1) {
            return new BlockListTarget[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ BlockListTarget[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ BlockListTarget copy$default(BlockListTarget r0, ContactEntity r1, CallHistoryEntity r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.contact;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.callHistory;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.telephone;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final ContactEntity component1() {
        return this.contact;
    }

    public final CallHistoryEntity component2() {
        return this.callHistory;
    }

    public final String component3() {
        return this.telephone;
    }

    public final BlockListTarget copy(ContactEntity r1, CallHistoryEntity r2, String r3) {
        return new BlockListTarget(r1, r2, r3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, BlockListTarget.class) == true) goto L8;
        return false;
    L8:
        BlockListTarget r6 = (BlockListTarget) ZeusTransformUtils.preCheckCast(r5, BlockListTarget.class, "com.obric.aiagent.plugin");
        if (o.a(this.contact, r6.contact) == true) goto L12;
        return false;
    L12:
        if (o.a(this.callHistory, r6.callHistory) == true) goto L15;
        return false;
    L15:
        if (o.a(this.telephone, r6.telephone) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        ContactEntity r0 = this.contact;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        CallHistoryEntity r4 = this.callHistory;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.telephone;
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
        return "BlockListTarget(contact=" + this.contact + ", callHistory=" + this.callHistory + ", telephone=" + this.telephone + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r4, int r5) {
        r4.writeInt(0);
        o.e(r4, "out");
        r4.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(this.contact, Parcelable.class, "com.obric.aiagent.plugin"), r5);
        r4.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(this.callHistory, Parcelable.class, "com.obric.aiagent.plugin"), r5);
        r4.writeString(this.telephone);
    }

    public BlockListTarget(ContactEntity r1, CallHistoryEntity r2, String r3) {
        this.contact = r1;
        this.callHistory = r2;
        this.telephone = r3;
    }

    public final ContactEntity getContact() {
        return this.contact;
    }

    public final CallHistoryEntity getCallHistory() {
        return this.callHistory;
    }

    public final String getTelephone() {
        return this.telephone;
    }
}
