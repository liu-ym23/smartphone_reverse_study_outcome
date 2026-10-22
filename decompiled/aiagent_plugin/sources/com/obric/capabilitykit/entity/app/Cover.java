package com.obric.capabilitykit.entity.app;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.meta.MetaType;
import com.obric.capabilitykit.entity.meta.MetaValue;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: loaded from: classes4.dex */
public final class Cover extends MetaValue {
    public static final CREATOR CREATOR = null;
    public static final int VERSION = 0;
    private String name;

    public static final class CREATOR implements Parcelable.Creator<Cover> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Cover createFromParcel(Parcel r1) {
            o.e(r1, "parcel");
            return new Cover(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Cover createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Cover[] newArray(int r1) {
            return new Cover[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Cover[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public Cover(Parcel r3) {
        o.e(r3, "parcel");
        this(EntityExtKt.a(r3));
        readMetaValueExtensionField$capabilitykitcommon_release(r3, 0, r3.readInt());
    }

    public Cover(String r2) {
        o.e(r2, "name");
        super(MetaType.Cover);
        this.name = r2;
    }

    public static /* synthetic */ Cover copy$default(Cover r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.name;
    L6:
        return r0.copy(r1);
    }

    public final String component1() {
        return this.name;
    }

    public final Cover copy(String r1) {
        o.e(r1, "name");
        return new Cover(r1);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, Cover.class) == true) goto L8;
        return false;
    L8:
        Cover r6 = (Cover) ZeusTransformUtils.preCheckCast(r5, Cover.class, "com.obric.aiagent.plugin");
        if (o.a(this.name, r6.name) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    @Override // com.obric.capabilitykit.entity.meta.MetaValue
    public void onReadMetaValueExtensionField$capabilitykitcommon_release(Parcel r1, ClassLoader r2, int r3) {
        o.e(r1, "parcel");
    }

    public final void setName(String r2) {
        o.e(r2, "<set-?>");
        this.name = r2;
    }

    @Override // com.obric.capabilitykit.entity.meta.MetaValue
    public String toString() {
        return "Cover(name=" + this.name + ')';
    }

    @Override // com.obric.capabilitykit.entity.meta.MetaValue, android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        o.e(r1, "parcel");
        r1.writeString(this.name);
        r1.writeInt(0);
    }
}
