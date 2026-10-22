package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.a.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: ContactsAddToBlocklistParams.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ContactsAddToBlocklistParams implements Parcelable, IntentParams {
    public static final Parcelable.Creator<ContactsAddToBlocklistParams> CREATOR = null;
    private Boolean isAdd;
    private BlockListTarget target;

    /* JADX INFO: compiled from: ContactsAddToBlocklistParams.kt */
    public static final class Creator implements Parcelable.Creator<ContactsAddToBlocklistParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ContactsAddToBlocklistParams createFromParcel(Parcel r8) {
            int r0 = r8.readInt();
            o.e(r8, "parcel");
            Boolean r3 = null;
            if (r8.readInt() != 0) goto L5;
            BlockListTarget r2 = null;
        L6:
            BlockListTarget r4 = (BlockListTarget) ZeusTransformUtils.preCheckCast(r2, BlockListTarget.class, "com.obric.aiagent.plugin");
            int r6 = 1;
            if (r8.readInt() != 0) goto L10;
        L14:
            ContactsAddToBlocklistParams r1 = new ContactsAddToBlocklistParams(r4, r3);
            int r5 = Math.min(r0, 0);
            ClassLoader r7 = getClass().getClassLoader();
        L15:
            if (r6 > r5) goto L17;
            r6 = r6 + 1;
        L17:
            if (r6 > r0) goto L19;
            a.a(r8, r7);
            r6 = r6 + 1;
            goto L17
        L19:
            return r1;
        L10:
            if (r8.readInt() == 0) goto L12;
            boolean r9 = true;
        L13:
            r3 = Boolean.valueOf(r9);
            goto L14
        L12:
            r9 = false;
            goto L13
        L5:
            r2 = BlockListTarget.CREATOR.createFromParcel(r8);
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ContactsAddToBlocklistParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ContactsAddToBlocklistParams[] newArray(int r1) {
            return new ContactsAddToBlocklistParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ContactsAddToBlocklistParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ContactsAddToBlocklistParams() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ContactsAddToBlocklistParams copy$default(ContactsAddToBlocklistParams r0, BlockListTarget r1, Boolean r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.target;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.isAdd;
    L9:
        return r0.copy(r1, r2);
    }

    public final BlockListTarget component1() {
        return this.target;
    }

    public final Boolean component2() {
        return this.isAdd;
    }

    public final ContactsAddToBlocklistParams copy(BlockListTarget r1, Boolean r2) {
        return new ContactsAddToBlocklistParams(r1, r2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ContactsAddToBlocklistParams.class) == true) goto L8;
        return false;
    L8:
        ContactsAddToBlocklistParams r6 = (ContactsAddToBlocklistParams) ZeusTransformUtils.preCheckCast(r5, ContactsAddToBlocklistParams.class, "com.obric.aiagent.plugin");
        if (o.a(this.target, r6.target) == true) goto L12;
        return false;
    L12:
        if (o.a(this.isAdd, r6.isAdd) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        BlockListTarget r0 = this.target;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Boolean r4 = this.isAdd;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "ContactsAddToBlocklistParams(target=" + this.target + ", isAdd=" + this.isAdd + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r4, int r5) {
        r4.writeInt(0);
        o.e(r4, "out");
        BlockListTarget r1 = this.target;
        if (r1 != null) goto L5;
        r4.writeInt(0);
    L6:
        Boolean r3 = this.isAdd;
        if (r3 != null) goto L9;
        r4.writeInt(0);
        return;
    L9:
        r4.writeInt(1);
        r4.writeInt(r3.booleanValue() ? 1 : 0);
        return;
    L5:
        r4.writeInt(1);
        r1.writeToParcel(r4, r5);
        goto L6
    }

    public ContactsAddToBlocklistParams(BlockListTarget r1, Boolean r2) {
        this.target = r1;
        this.isAdd = r2;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.a.b(this);
    }

    public /* synthetic */ ContactsAddToBlocklistParams(BlockListTarget r2, Boolean r3, int r4, h r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }

    public final BlockListTarget getTarget() {
        return this.target;
    }

    public final void setTarget(BlockListTarget r1) {
        this.target = r1;
    }

    public final Boolean isAdd() {
        return this.isAdd;
    }

    public final void setAdd(Boolean r1) {
        this.isAdd = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        if (this.target == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, ContactsAddToBlocklistParams.class) == false) goto L5;
        BlockListTarget r1 = this.target;
        if (r1 != null) goto L9;
        r1 = ((ContactsAddToBlocklistParams) ZeusTransformUtils.preCheckCast(r4, ContactsAddToBlocklistParams.class, "com.obric.aiagent.plugin")).target;
    L9:
        Boolean r3 = this.isAdd;
        if (r3 != null) goto L13;
        r3 = ((ContactsAddToBlocklistParams) ZeusTransformUtils.preCheckCast(r4, ContactsAddToBlocklistParams.class, "com.obric.aiagent.plugin")).isAdd;
    L13:
        return (IntentParams) ZeusTransformUtils.preCheckCast(new ContactsAddToBlocklistParams(r1, r3), IntentParams.class, "com.obric.aiagent.plugin");
    L5:
        return (IntentParams) ZeusTransformUtils.preCheckCast(this, IntentParams.class, "com.obric.aiagent.plugin");
    }
}
