package com.obric.capabilitykit.entity.meta;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: loaded from: classes4.dex */
public final class MetaInstantMessaging extends MetaValue {
    public static final CREATOR CREATOR = null;
    public static final int VERSION = 0;
    private final String instantMessagingAccount;
    private final String instantMessagingType;

    public static final class CREATOR implements Parcelable.Creator<MetaInstantMessaging> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MetaInstantMessaging createFromParcel(Parcel r1) {
            o.e(r1, "parcel");
            return new MetaInstantMessaging(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MetaInstantMessaging createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MetaInstantMessaging[] newArray(int r1) {
            return new MetaInstantMessaging[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MetaInstantMessaging[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public MetaInstantMessaging(Parcel r3) {
        o.e(r3, "parcel");
        this(EntityExtKt.a(r3), EntityExtKt.a(r3));
        readMetaValueExtensionField$capabilitykitcommon_release(r3, 0, r3.readInt());
    }

    public MetaInstantMessaging(String r2, String r3) {
        o.e(r2, "instantMessagingType");
        o.e(r3, "instantMessagingAccount");
        super(MetaType.INSTANT_MESSAGING);
        this.instantMessagingType = r2;
        this.instantMessagingAccount = r3;
    }

    public static /* synthetic */ MetaInstantMessaging copy$default(MetaInstantMessaging r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.instantMessagingType;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.instantMessagingAccount;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.instantMessagingType;
    }

    public final String component2() {
        return this.instantMessagingAccount;
    }

    public final MetaInstantMessaging copy(String r1, String r2) {
        o.e(r1, "instantMessagingType");
        o.e(r2, "instantMessagingAccount");
        return new MetaInstantMessaging(r1, r2);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, MetaInstantMessaging.class) == true) goto L8;
        return false;
    L8:
        MetaInstantMessaging r6 = (MetaInstantMessaging) ZeusTransformUtils.preCheckCast(r5, MetaInstantMessaging.class, "com.obric.aiagent.plugin");
        if (o.a(this.instantMessagingType, r6.instantMessagingType) == true) goto L12;
        return false;
    L12:
        if (o.a(this.instantMessagingAccount, r6.instantMessagingAccount) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final String getInstantMessagingAccount() {
        return this.instantMessagingAccount;
    }

    public final String getInstantMessagingType() {
        return this.instantMessagingType;
    }

    public int hashCode() {
        return (this.instantMessagingType.hashCode() * 31) + this.instantMessagingAccount.hashCode();
    }

    @Override // com.obric.capabilitykit.entity.meta.MetaValue
    public void onReadMetaValueExtensionField$capabilitykitcommon_release(Parcel r1, ClassLoader r2, int r3) {
        o.e(r1, "parcel");
    }

    @Override // com.obric.capabilitykit.entity.meta.MetaValue
    public String toString() {
        return "MetaInstantMessaging(instantMessagingType=" + this.instantMessagingType + ", instantMessagingAccount=" + this.instantMessagingAccount + ')';
    }

    @Override // com.obric.capabilitykit.entity.meta.MetaValue, android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        o.e(r1, "parcel");
        r1.writeString(this.instantMessagingType);
        r1.writeString(this.instantMessagingAccount);
        r1.writeInt(0);
    }
}
