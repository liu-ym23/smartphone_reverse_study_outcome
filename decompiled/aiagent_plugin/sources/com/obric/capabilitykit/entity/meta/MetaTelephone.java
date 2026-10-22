package com.obric.capabilitykit.entity.meta;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: loaded from: classes4.dex */
public final class MetaTelephone extends MetaValue {
    public static final CREATOR CREATOR = null;
    public static final int VERSION = 0;
    private final String contactType;
    private final String telephone;

    public static final class CREATOR implements Parcelable.Creator<MetaTelephone> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MetaTelephone createFromParcel(Parcel r1) {
            o.e(r1, "parcel");
            return new MetaTelephone(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MetaTelephone createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MetaTelephone[] newArray(int r1) {
            return new MetaTelephone[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MetaTelephone[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public MetaTelephone(Parcel r3) {
        o.e(r3, "parcel");
        this(EntityExtKt.a(r3), r3.readString());
        readMetaValueExtensionField$capabilitykitcommon_release(r3, 0, r3.readInt());
    }

    public MetaTelephone(String r2, String r3) {
        o.e(r2, SensitiveType.TELEPHONE);
        super(MetaType.TELEPHONE);
        this.telephone = r2;
        this.contactType = r3;
    }

    public /* synthetic */ MetaTelephone(String r1, String r2, int r3, h r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    public static /* synthetic */ MetaTelephone copy$default(MetaTelephone r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.telephone;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.contactType;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.telephone;
    }

    public final String component2() {
        return this.contactType;
    }

    public final MetaTelephone copy(String r1, String r2) {
        o.e(r1, SensitiveType.TELEPHONE);
        return new MetaTelephone(r1, r2);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, MetaTelephone.class) == true) goto L8;
        return false;
    L8:
        MetaTelephone r6 = (MetaTelephone) ZeusTransformUtils.preCheckCast(r5, MetaTelephone.class, "com.obric.aiagent.plugin");
        if (o.a(this.telephone, r6.telephone) == true) goto L12;
        return false;
    L12:
        if (o.a(this.contactType, r6.contactType) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final String getContactType() {
        return this.contactType;
    }

    public final String getTelephone() {
        return this.telephone;
    }

    public int hashCode() {
        int r0 = this.telephone.hashCode() * 31;
        String r1 = this.contactType;
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
        return "MetaTelephone(telephone=" + this.telephone + ", contactType=" + this.contactType + ')';
    }

    @Override // com.obric.capabilitykit.entity.meta.MetaValue, android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        o.e(r1, "parcel");
        r1.writeString(this.telephone);
        r1.writeString(this.contactType);
        r1.writeInt(0);
    }
}
