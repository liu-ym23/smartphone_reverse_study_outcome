package com.obric.capabilitykit.entity.meta;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: loaded from: classes4.dex */
public final class MetaEmailAddress extends MetaValue {
    public static final CREATOR CREATOR = null;
    public static final int VERSION = 0;
    private final String emailAddress;
    private final String emailAddressType;

    public static final class CREATOR implements Parcelable.Creator<MetaEmailAddress> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MetaEmailAddress createFromParcel(Parcel r1) {
            o.e(r1, "parcel");
            return new MetaEmailAddress(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MetaEmailAddress createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MetaEmailAddress[] newArray(int r1) {
            return new MetaEmailAddress[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MetaEmailAddress[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public MetaEmailAddress(Parcel r3) {
        o.e(r3, "parcel");
        this(EntityExtKt.a(r3), EntityExtKt.a(r3));
        readMetaValueExtensionField$capabilitykitcommon_release(r3, 0, r3.readInt());
    }

    public MetaEmailAddress(String r2, String r3) {
        o.e(r2, "emailAddress");
        super(10006);
        this.emailAddress = r2;
        this.emailAddressType = r3;
    }

    public /* synthetic */ MetaEmailAddress(String r1, String r2, int r3, h r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    public static /* synthetic */ MetaEmailAddress copy$default(MetaEmailAddress r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.emailAddress;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.emailAddressType;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.emailAddress;
    }

    public final String component2() {
        return this.emailAddressType;
    }

    public final MetaEmailAddress copy(String r1, String r2) {
        o.e(r1, "emailAddress");
        return new MetaEmailAddress(r1, r2);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, MetaEmailAddress.class) == true) goto L8;
        return false;
    L8:
        MetaEmailAddress r6 = (MetaEmailAddress) ZeusTransformUtils.preCheckCast(r5, MetaEmailAddress.class, "com.obric.aiagent.plugin");
        if (o.a(this.emailAddress, r6.emailAddress) == true) goto L12;
        return false;
    L12:
        if (o.a(this.emailAddressType, r6.emailAddressType) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final String getEmailAddress() {
        return this.emailAddress;
    }

    public final String getEmailAddressType() {
        return this.emailAddressType;
    }

    public int hashCode() {
        int r0 = this.emailAddress.hashCode() * 31;
        String r1 = this.emailAddressType;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    @Override // com.obric.capabilitykit.entity.meta.MetaValue
    public void onReadMetaValueExtensionField$capabilitykitcommon_release(Parcel r1, ClassLoader r2, int r3) {
        o.e(r1, "parcel");
    }

    @Override // com.obric.capabilitykit.entity.meta.MetaValue
    public String toString() {
        return "MetaEmailAddress(emailAddress=" + this.emailAddress + ", emailAddressType=" + this.emailAddressType + ')';
    }

    @Override // com.obric.capabilitykit.entity.meta.MetaValue, android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        o.e(r1, "parcel");
        r1.writeString(this.emailAddress);
        r1.writeString(this.emailAddressType);
        r1.writeInt(0);
    }
}
