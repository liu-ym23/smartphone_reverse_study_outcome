package com.obric.capabilitykit.entity.meta;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: loaded from: classes4.dex */
public final class MetaAddress extends MetaValue {
    public static final CREATOR CREATOR = null;
    public static final int VERSION = 0;
    private final String address;
    private final String addressType;

    public static final class CREATOR implements Parcelable.Creator<MetaAddress> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MetaAddress createFromParcel(Parcel r1) {
            o.e(r1, "parcel");
            return new MetaAddress(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MetaAddress createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MetaAddress[] newArray(int r1) {
            return new MetaAddress[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MetaAddress[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public MetaAddress(Parcel r3) {
        o.e(r3, "parcel");
        this(EntityExtKt.a(r3), r3.readString());
        readMetaValueExtensionField$capabilitykitcommon_release(r3, 0, r3.readInt());
    }

    public MetaAddress(String r2, String r3) {
        o.e(r2, SensitiveType.ADDRESS);
        super(10001);
        this.address = r2;
        this.addressType = r3;
    }

    public /* synthetic */ MetaAddress(String r1, String r2, int r3, h r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    public static /* synthetic */ MetaAddress copy$default(MetaAddress r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.address;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.addressType;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.address;
    }

    public final String component2() {
        return this.addressType;
    }

    public final MetaAddress copy(String r1, String r2) {
        o.e(r1, SensitiveType.ADDRESS);
        return new MetaAddress(r1, r2);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, MetaAddress.class) == true) goto L8;
        return false;
    L8:
        MetaAddress r6 = (MetaAddress) ZeusTransformUtils.preCheckCast(r5, MetaAddress.class, "com.obric.aiagent.plugin");
        if (o.a(this.address, r6.address) == true) goto L12;
        return false;
    L12:
        if (o.a(this.addressType, r6.addressType) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final String getAddress() {
        return this.address;
    }

    public final String getAddressType() {
        return this.addressType;
    }

    public int hashCode() {
        int r0 = this.address.hashCode() * 31;
        String r1 = this.addressType;
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
        return "MetaAddress(address=" + this.address + ", addressType=" + this.addressType + ')';
    }

    @Override // com.obric.capabilitykit.entity.meta.MetaValue, android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        o.e(r1, "parcel");
        r1.writeString(this.address);
        r1.writeString(this.addressType);
        r1.writeInt(0);
    }
}
