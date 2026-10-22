package com.obric.capabilitykit.entity.meta;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: loaded from: classes4.dex */
public final class MetaFlightNumber extends MetaValue {
    public static final CREATOR CREATOR = null;
    public static final int VERSION = 0;
    private final String flightNumber;

    public static final class CREATOR implements Parcelable.Creator<MetaFlightNumber> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MetaFlightNumber createFromParcel(Parcel r1) {
            o.e(r1, "parcel");
            return new MetaFlightNumber(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MetaFlightNumber createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MetaFlightNumber[] newArray(int r1) {
            return new MetaFlightNumber[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MetaFlightNumber[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public MetaFlightNumber(Parcel r3) {
        o.e(r3, "parcel");
        this(EntityExtKt.a(r3));
        readMetaValueExtensionField$capabilitykitcommon_release(r3, 0, r3.readInt());
    }

    public MetaFlightNumber(String r2) {
        o.e(r2, "flightNumber");
        super(MetaType.FLIGHT_NUMBER);
        this.flightNumber = r2;
    }

    public static /* synthetic */ MetaFlightNumber copy$default(MetaFlightNumber r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.flightNumber;
    L6:
        return r0.copy(r1);
    }

    public final String component1() {
        return this.flightNumber;
    }

    public final MetaFlightNumber copy(String r1) {
        o.e(r1, "flightNumber");
        return new MetaFlightNumber(r1);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, MetaFlightNumber.class) == true) goto L8;
        return false;
    L8:
        MetaFlightNumber r6 = (MetaFlightNumber) ZeusTransformUtils.preCheckCast(r5, MetaFlightNumber.class, "com.obric.aiagent.plugin");
        if (o.a(this.flightNumber, r6.flightNumber) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final String getFlightNumber() {
        return this.flightNumber;
    }

    public int hashCode() {
        return this.flightNumber.hashCode();
    }

    @Override // com.obric.capabilitykit.entity.meta.MetaValue
    public void onReadMetaValueExtensionField$capabilitykitcommon_release(Parcel r1, ClassLoader r2, int r3) {
        o.e(r1, "parcel");
    }

    @Override // com.obric.capabilitykit.entity.meta.MetaValue
    public String toString() {
        return "MetaFlightNumber(flightNumber=" + this.flightNumber + ')';
    }

    @Override // com.obric.capabilitykit.entity.meta.MetaValue, android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        o.e(r1, "parcel");
        r1.writeString(this.flightNumber);
        r1.writeInt(0);
    }
}
