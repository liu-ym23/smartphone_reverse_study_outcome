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
import java.util.List;

/* JADX INFO: compiled from: ContactsAddToFavoriteParams.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ContactsAddToFavoriteParams implements Parcelable, IUriSharableParams, IntentParams {
    public static final Parcelable.Creator<ContactsAddToFavoriteParams> CREATOR = null;
    private Boolean isAdd;
    private ContactEntity target;

    /* JADX INFO: compiled from: ContactsAddToFavoriteParams.kt */
    public static final class Creator implements Parcelable.Creator<ContactsAddToFavoriteParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ContactsAddToFavoriteParams createFromParcel(Parcel r7) {
            int r0 = r7.readInt();
            o.e(r7, "parcel");
            ContactEntity r2 = (ContactEntity) ZeusTransformUtils.preCheckCast(r7.readParcelable(ContactsAddToFavoriteParams.class.getClassLoader()), ContactEntity.class, "com.obric.aiagent.plugin");
            int r5 = 1;
            if (r7.readInt() != 0) goto L6;
            Boolean r3 = null;
        L10:
            ContactsAddToFavoriteParams r1 = new ContactsAddToFavoriteParams(r2, r3);
            int r4 = Math.min(r0, 0);
            ClassLoader r6 = getClass().getClassLoader();
        L11:
            if (r5 > r4) goto L13;
            r5 = r5 + 1;
        L13:
            if (r5 > r0) goto L15;
            a.a(r7, r6);
            r5 = r5 + 1;
            goto L13
        L15:
            return r1;
        L6:
            if (r7.readInt() == 0) goto L8;
            boolean r8 = true;
        L9:
            r3 = Boolean.valueOf(r8);
            goto L10
        L8:
            r8 = false;
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ContactsAddToFavoriteParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ContactsAddToFavoriteParams[] newArray(int r1) {
            return new ContactsAddToFavoriteParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ContactsAddToFavoriteParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ContactsAddToFavoriteParams() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ContactsAddToFavoriteParams copy$default(ContactsAddToFavoriteParams r0, ContactEntity r1, Boolean r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.target;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.isAdd;
    L9:
        return r0.copy(r1, r2);
    }

    public final ContactEntity component1() {
        return this.target;
    }

    public final Boolean component2() {
        return this.isAdd;
    }

    public final ContactsAddToFavoriteParams copy(ContactEntity r1, Boolean r2) {
        return new ContactsAddToFavoriteParams(r1, r2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ContactsAddToFavoriteParams.class) == true) goto L8;
        return false;
    L8:
        ContactsAddToFavoriteParams r6 = (ContactsAddToFavoriteParams) ZeusTransformUtils.preCheckCast(r5, ContactsAddToFavoriteParams.class, "com.obric.aiagent.plugin");
        if (o.a(this.target, r6.target) == true) goto L12;
        return false;
    L12:
        if (o.a(this.isAdd, r6.isAdd) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        ContactEntity r0 = this.target;
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
        return "ContactsAddToFavoriteParams(target=" + this.target + ", isAdd=" + this.isAdd + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r5, int r6) {
        r5.writeInt(0);
        o.e(r5, "out");
        r5.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(this.target, Parcelable.class, "com.obric.aiagent.plugin"), r6);
        Boolean r4 = this.isAdd;
        if (r4 != null) goto L5;
        r5.writeInt(0);
        return;
    L5:
        r5.writeInt(1);
        r5.writeInt(r4.booleanValue() ? 1 : 0);
    }

    public ContactsAddToFavoriteParams(ContactEntity r1, Boolean r2) {
        this.target = r1;
        this.isAdd = r2;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.a.b(this);
    }

    public /* synthetic */ ContactsAddToFavoriteParams(ContactEntity r2, Boolean r3, int r4, h r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }

    public final ContactEntity getTarget() {
        return this.target;
    }

    public final void setTarget(ContactEntity r1) {
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
        if (ZeusTransformUtils.instanceOf(r4, ContactsAddToFavoriteParams.class) == false) goto L5;
        ContactEntity r1 = this.target;
        if (r1 != null) goto L9;
        r1 = ((ContactsAddToFavoriteParams) ZeusTransformUtils.preCheckCast(r4, ContactsAddToFavoriteParams.class, "com.obric.aiagent.plugin")).target;
    L9:
        Boolean r3 = this.isAdd;
        if (r3 != null) goto L13;
        r3 = ((ContactsAddToFavoriteParams) ZeusTransformUtils.preCheckCast(r4, ContactsAddToFavoriteParams.class, "com.obric.aiagent.plugin")).isAdd;
    L13:
        return (IntentParams) ZeusTransformUtils.preCheckCast(new ContactsAddToFavoriteParams(r1, r3), IntentParams.class, "com.obric.aiagent.plugin");
    L5:
        return (IntentParams) ZeusTransformUtils.preCheckCast(this, IntentParams.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.capabilitykit.common.execution.urishare.IUriSharableParams
    public List<Object> getUriSharableParams() {
        return p.a(this.target);
    }
}
