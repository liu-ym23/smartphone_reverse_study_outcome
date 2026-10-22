package com.obric.capabilitykit.entity.meta;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: loaded from: classes4.dex */
public final class MetaRelationship extends MetaValue {
    public static final CREATOR CREATOR = null;
    public static final int VERSION = 0;
    private final String relationType;
    private final String relationship;

    public static final class CREATOR implements Parcelable.Creator<MetaRelationship> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MetaRelationship createFromParcel(Parcel r1) {
            o.e(r1, "parcel");
            return new MetaRelationship(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MetaRelationship createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MetaRelationship[] newArray(int r1) {
            return new MetaRelationship[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MetaRelationship[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public MetaRelationship(Parcel r3) {
        o.e(r3, "parcel");
        this(EntityExtKt.a(r3), EntityExtKt.a(r3));
        readMetaValueExtensionField$capabilitykitcommon_release(r3, 0, r3.readInt());
    }

    public MetaRelationship(String r2, String r3) {
        o.e(r2, "relationType");
        o.e(r3, "relationship");
        super(MetaType.RELATIONSHIP);
        this.relationType = r2;
        this.relationship = r3;
    }

    public static /* synthetic */ MetaRelationship copy$default(MetaRelationship r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.relationType;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.relationship;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.relationType;
    }

    public final String component2() {
        return this.relationship;
    }

    public final MetaRelationship copy(String r1, String r2) {
        o.e(r1, "relationType");
        o.e(r2, "relationship");
        return new MetaRelationship(r1, r2);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, MetaRelationship.class) == true) goto L8;
        return false;
    L8:
        MetaRelationship r6 = (MetaRelationship) ZeusTransformUtils.preCheckCast(r5, MetaRelationship.class, "com.obric.aiagent.plugin");
        if (o.a(this.relationType, r6.relationType) == true) goto L12;
        return false;
    L12:
        if (o.a(this.relationship, r6.relationship) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final String getRelationType() {
        return this.relationType;
    }

    public final String getRelationship() {
        return this.relationship;
    }

    public int hashCode() {
        return (this.relationType.hashCode() * 31) + this.relationship.hashCode();
    }

    @Override // com.obric.capabilitykit.entity.meta.MetaValue
    public void onReadMetaValueExtensionField$capabilitykitcommon_release(Parcel r1, ClassLoader r2, int r3) {
        o.e(r1, "parcel");
    }

    @Override // com.obric.capabilitykit.entity.meta.MetaValue
    public String toString() {
        return "MetaRelationship(relationType=" + this.relationType + ", relationship=" + this.relationship + ')';
    }

    @Override // com.obric.capabilitykit.entity.meta.MetaValue, android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        o.e(r1, "parcel");
        r1.writeString(this.relationType);
        r1.writeString(this.relationship);
        r1.writeInt(0);
    }
}
