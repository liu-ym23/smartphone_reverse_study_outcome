package com.obric.capabilitykit.entity.meta;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: loaded from: classes4.dex */
public final class MetaAnniversary extends MetaValue {
    public static final CREATOR CREATOR = null;
    public static final int VERSION = 0;
    private final String anniversaryDate;
    private final String anniversaryName;

    public static final class CREATOR implements Parcelable.Creator<MetaAnniversary> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MetaAnniversary createFromParcel(Parcel r1) {
            o.e(r1, "parcel");
            return new MetaAnniversary(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MetaAnniversary createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MetaAnniversary[] newArray(int r1) {
            return new MetaAnniversary[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MetaAnniversary[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public MetaAnniversary(Parcel r3) {
        o.e(r3, "parcel");
        this(EntityExtKt.a(r3), EntityExtKt.a(r3));
        readMetaValueExtensionField$capabilitykitcommon_release(r3, 0, r3.readInt());
    }

    public MetaAnniversary(String r2, String r3) {
        o.e(r2, "anniversaryName");
        o.e(r3, "anniversaryDate");
        super(10002);
        this.anniversaryName = r2;
        this.anniversaryDate = r3;
    }

    public static /* synthetic */ MetaAnniversary copy$default(MetaAnniversary r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.anniversaryName;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.anniversaryDate;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.anniversaryName;
    }

    public final String component2() {
        return this.anniversaryDate;
    }

    public final MetaAnniversary copy(String r1, String r2) {
        o.e(r1, "anniversaryName");
        o.e(r2, "anniversaryDate");
        return new MetaAnniversary(r1, r2);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, MetaAnniversary.class) == true) goto L8;
        return false;
    L8:
        MetaAnniversary r6 = (MetaAnniversary) ZeusTransformUtils.preCheckCast(r5, MetaAnniversary.class, "com.obric.aiagent.plugin");
        if (o.a(this.anniversaryName, r6.anniversaryName) == true) goto L12;
        return false;
    L12:
        if (o.a(this.anniversaryDate, r6.anniversaryDate) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final String getAnniversaryDate() {
        return this.anniversaryDate;
    }

    public final String getAnniversaryName() {
        return this.anniversaryName;
    }

    public int hashCode() {
        return (this.anniversaryName.hashCode() * 31) + this.anniversaryDate.hashCode();
    }

    @Override // com.obric.capabilitykit.entity.meta.MetaValue
    public void onReadMetaValueExtensionField$capabilitykitcommon_release(Parcel r1, ClassLoader r2, int r3) {
        o.e(r1, "parcel");
    }

    @Override // com.obric.capabilitykit.entity.meta.MetaValue
    public String toString() {
        return "MetaAnniversary(anniversaryName=" + this.anniversaryName + ", anniversaryDate=" + this.anniversaryDate + ')';
    }

    @Override // com.obric.capabilitykit.entity.meta.MetaValue, android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        o.e(r1, "parcel");
        r1.writeString(this.anniversaryName);
        r1.writeString(this.anniversaryDate);
        r1.writeInt(0);
    }
}
