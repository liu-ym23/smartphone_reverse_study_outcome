package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.a.a;
import com.obric.capabilitykit.common.execution.urishare.IUriSharableParams;
import com.obric.capabilitykit.entity.app.ContactEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.h;
import d.h.b.o;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: ContactsDeleteParams.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ContactsDeleteParams implements Parcelable, IUriSharableParams, IntentParams {
    public static final Parcelable.Creator<ContactsDeleteParams> CREATOR = null;
    private ContactEntity[] targets;

    /* JADX INFO: compiled from: ContactsDeleteParams.kt */
    public static final class Creator implements Parcelable.Creator<ContactsDeleteParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ContactsDeleteParams createFromParcel(Parcel r9) {
            int r0 = r9.readInt();
            o.e(r9, "parcel");
            if (r9.readInt() != 0) goto L5;
            ContactEntity[] r1 = null;
        L9:
            ContactsDeleteParams r3 = new ContactsDeleteParams(r1);
            int r2 = Math.min(r0, 0);
            ClassLoader r8 = getClass().getClassLoader();
            int r4 = 1;
        L10:
            if (r4 > r2) goto L12;
            r4 = r4 + 1;
        L12:
            if (r4 > r0) goto L14;
            a.a(r9, r8);
            r4 = r4 + 1;
            goto L12
        L14:
            return r3;
        L5:
            int r5 = r9.readInt();
            ContactEntity[] r6 = new ContactEntity[r5];
            int r7 = 0;
        L6:
            if (r7 == r5) goto L8;
            r6[r7] = (ContactEntity) ZeusTransformUtils.preCheckCast(r9.readParcelable(ContactsDeleteParams.class.getClassLoader()), ContactEntity.class, "com.obric.aiagent.plugin");
            r7 = r7 + 1;
            goto L6
        L8:
            r1 = r6;
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ContactsDeleteParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ContactsDeleteParams[] newArray(int r1) {
            return new ContactsDeleteParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ContactsDeleteParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ContactsDeleteParams() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ContactsDeleteParams copy$default(ContactsDeleteParams r0, ContactEntity[] r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.targets;
    L6:
        return r0.copy(r1);
    }

    public final ContactEntity[] component1() {
        return this.targets;
    }

    public final ContactsDeleteParams copy(ContactEntity[] r1) {
        return new ContactsDeleteParams(r1);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ContactsDeleteParams.class) == true) goto L8;
        return false;
    L8:
        ContactsDeleteParams r6 = (ContactsDeleteParams) ZeusTransformUtils.preCheckCast(r5, ContactsDeleteParams.class, "com.obric.aiagent.plugin");
        if (o.a(this.targets, r6.targets) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        ContactEntity[] r0 = this.targets;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return Arrays.hashCode(r0);
    }

    public String toString() {
        return "ContactsDeleteParams(targets=" + Arrays.toString(this.targets) + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r6, int r7) {
        int r0 = 0;
        r6.writeInt(0);
        o.e(r6, "out");
        ContactEntity[] r5 = this.targets;
        if (r5 != null) goto L5;
        r6.writeInt(0);
        return;
    L5:
        r6.writeInt(1);
        int r1 = r5.length;
        r6.writeInt(r1);
    L6:
        if (r0 == r1) goto L10;
        r6.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(r5[r0], Parcelable.class, "com.obric.aiagent.plugin"), r7);
        r0 = r0 + 1;
        goto L6
    }

    public ContactsDeleteParams(ContactEntity[] r1) {
        this.targets = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.a.b(this);
    }

    public /* synthetic */ ContactsDeleteParams(ContactEntity[] r1, int r2, h r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }

    public final ContactEntity[] getTargets() {
        return this.targets;
    }

    public final void setTargets(ContactEntity[] r1) {
        this.targets = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        if (this.targets == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, ContactsDeleteParams.class) == false) goto L5;
        ContactEntity[] r3 = this.targets;
        if (r3 != null) goto L10;
        r3 = ((ContactsDeleteParams) ZeusTransformUtils.preCheckCast(r4, ContactsDeleteParams.class, "com.obric.aiagent.plugin")).targets;
    L10:
        return (IntentParams) ZeusTransformUtils.preCheckCast(new ContactsDeleteParams(r3), IntentParams.class, "com.obric.aiagent.plugin");
    L5:
        return (IntentParams) ZeusTransformUtils.preCheckCast(this, IntentParams.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.capabilitykit.common.execution.urishare.IUriSharableParams
    public List<Object> getUriSharableParams() {
        return p.a(this.targets);
    }
}
