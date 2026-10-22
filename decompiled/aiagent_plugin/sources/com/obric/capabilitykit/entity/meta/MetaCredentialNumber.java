package com.obric.capabilitykit.entity.meta;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: loaded from: classes4.dex */
public final class MetaCredentialNumber extends MetaValue {
    public static final CREATOR CREATOR = null;
    public static final int VERSION = 0;
    private final String credentialNumber;
    private final String credentialType;

    public static final class CREATOR implements Parcelable.Creator<MetaCredentialNumber> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MetaCredentialNumber createFromParcel(Parcel r1) {
            o.e(r1, "parcel");
            return new MetaCredentialNumber(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MetaCredentialNumber createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MetaCredentialNumber[] newArray(int r1) {
            return new MetaCredentialNumber[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MetaCredentialNumber[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public MetaCredentialNumber(Parcel r3) {
        o.e(r3, "parcel");
        this(EntityExtKt.a(r3), EntityExtKt.a(r3));
        readMetaValueExtensionField$capabilitykitcommon_release(r3, 0, r3.readInt());
    }

    public MetaCredentialNumber(String r2, String r3) {
        o.e(r2, "credentialNumber");
        o.e(r3, "credentialType");
        super(MetaType.CREDENTIAL_NUMBER);
        this.credentialNumber = r2;
        this.credentialType = r3;
    }

    public static /* synthetic */ MetaCredentialNumber copy$default(MetaCredentialNumber r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.credentialNumber;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.credentialType;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.credentialNumber;
    }

    public final String component2() {
        return this.credentialType;
    }

    public final MetaCredentialNumber copy(String r1, String r2) {
        o.e(r1, "credentialNumber");
        o.e(r2, "credentialType");
        return new MetaCredentialNumber(r1, r2);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, MetaCredentialNumber.class) == true) goto L8;
        return false;
    L8:
        MetaCredentialNumber r6 = (MetaCredentialNumber) ZeusTransformUtils.preCheckCast(r5, MetaCredentialNumber.class, "com.obric.aiagent.plugin");
        if (o.a(this.credentialNumber, r6.credentialNumber) == true) goto L12;
        return false;
    L12:
        if (o.a(this.credentialType, r6.credentialType) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final String getCredentialNumber() {
        return this.credentialNumber;
    }

    public final String getCredentialType() {
        return this.credentialType;
    }

    public int hashCode() {
        return (this.credentialNumber.hashCode() * 31) + this.credentialType.hashCode();
    }

    @Override // com.obric.capabilitykit.entity.meta.MetaValue
    public void onReadMetaValueExtensionField$capabilitykitcommon_release(Parcel r1, ClassLoader r2, int r3) {
        o.e(r1, "parcel");
    }

    @Override // com.obric.capabilitykit.entity.meta.MetaValue
    public String toString() {
        return "MetaCredentialNumber(credentialNumber=" + this.credentialNumber + ", credentialType=" + this.credentialType + ')';
    }

    @Override // com.obric.capabilitykit.entity.meta.MetaValue, android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        o.e(r1, "parcel");
        r1.writeString(this.credentialNumber);
        r1.writeString(this.credentialType);
        r1.writeInt(0);
    }
}
