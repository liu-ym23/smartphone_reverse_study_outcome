package com.obric.capabilitykit.entity.meta;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: loaded from: classes4.dex */
public final class MetaIdentityCard extends MetaValue {
    public static final CREATOR CREATOR = null;
    public static final int VERSION = 0;
    private final String identifyCardNumber;

    public static final class CREATOR implements Parcelable.Creator<MetaIdentityCard> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MetaIdentityCard createFromParcel(Parcel r1) {
            o.e(r1, "parcel");
            return new MetaIdentityCard(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MetaIdentityCard createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MetaIdentityCard[] newArray(int r1) {
            return new MetaIdentityCard[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MetaIdentityCard[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public MetaIdentityCard(Parcel r3) {
        o.e(r3, "parcel");
        this(EntityExtKt.a(r3));
        readMetaValueExtensionField$capabilitykitcommon_release(r3, 0, r3.readInt());
    }

    public MetaIdentityCard(String r2) {
        o.e(r2, "identifyCardNumber");
        super(MetaType.IDENTIFY_CARD_NUMBER);
        this.identifyCardNumber = r2;
    }

    public static /* synthetic */ MetaIdentityCard copy$default(MetaIdentityCard r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.identifyCardNumber;
    L6:
        return r0.copy(r1);
    }

    public final String component1() {
        return this.identifyCardNumber;
    }

    public final MetaIdentityCard copy(String r1) {
        o.e(r1, "identifyCardNumber");
        return new MetaIdentityCard(r1);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, MetaIdentityCard.class) == true) goto L8;
        return false;
    L8:
        MetaIdentityCard r6 = (MetaIdentityCard) ZeusTransformUtils.preCheckCast(r5, MetaIdentityCard.class, "com.obric.aiagent.plugin");
        if (o.a(this.identifyCardNumber, r6.identifyCardNumber) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final String getIdentifyCardNumber() {
        return this.identifyCardNumber;
    }

    public int hashCode() {
        return this.identifyCardNumber.hashCode();
    }

    @Override // com.obric.capabilitykit.entity.meta.MetaValue
    public void onReadMetaValueExtensionField$capabilitykitcommon_release(Parcel r1, ClassLoader r2, int r3) {
        o.e(r1, "parcel");
    }

    @Override // com.obric.capabilitykit.entity.meta.MetaValue
    public String toString() {
        return "MetaIdentityCard(identifyCardNumber=" + this.identifyCardNumber + ')';
    }

    @Override // com.obric.capabilitykit.entity.meta.MetaValue, android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        o.e(r1, "parcel");
        r1.writeString(this.identifyCardNumber);
        r1.writeInt(0);
    }
}
