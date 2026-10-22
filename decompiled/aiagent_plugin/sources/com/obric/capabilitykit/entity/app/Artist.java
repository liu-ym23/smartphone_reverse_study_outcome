package com.obric.capabilitykit.entity.app;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.meta.MetaType;
import com.obric.capabilitykit.entity.meta.MetaValue;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: loaded from: classes4.dex */
public final class Artist extends MetaValue {
    public static final CREATOR CREATOR = null;
    public static final int VERSION = 0;
    private String id;
    private String name;

    public static final class CREATOR implements Parcelable.Creator<Artist> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Artist createFromParcel(Parcel r1) {
            o.e(r1, "parcel");
            return new Artist(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Artist createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Artist[] newArray(int r1) {
            return new Artist[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Artist[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public Artist(Parcel r3) {
        o.e(r3, "parcel");
        this(EntityExtKt.a(r3), EntityExtKt.a(r3));
        readMetaValueExtensionField$capabilitykitcommon_release(r3, 0, r3.readInt());
    }

    public Artist(String r2, String r3) {
        o.e(r2, DbHelper.COL_ID);
        o.e(r3, "name");
        super(MetaType.Artist);
        this.id = r2;
        this.name = r3;
    }

    public static /* synthetic */ Artist copy$default(Artist r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.id;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.name;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.name;
    }

    public final Artist copy(String r1, String r2) {
        o.e(r1, DbHelper.COL_ID);
        o.e(r2, "name");
        return new Artist(r1, r2);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, Artist.class) == true) goto L8;
        return false;
    L8:
        Artist r6 = (Artist) ZeusTransformUtils.preCheckCast(r5, Artist.class, "com.obric.aiagent.plugin");
        if (o.a(this.id, r6.id) == true) goto L12;
        return false;
    L12:
        if (o.a(this.name, r6.name) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        return (this.id.hashCode() * 31) + this.name.hashCode();
    }

    @Override // com.obric.capabilitykit.entity.meta.MetaValue
    public void onReadMetaValueExtensionField$capabilitykitcommon_release(Parcel r1, ClassLoader r2, int r3) {
        o.e(r1, "parcel");
    }

    public final void setId(String r2) {
        o.e(r2, "<set-?>");
        this.id = r2;
    }

    public final void setName(String r2) {
        o.e(r2, "<set-?>");
        this.name = r2;
    }

    @Override // com.obric.capabilitykit.entity.meta.MetaValue
    public String toString() {
        return "Artist(id=" + this.id + ", name=" + this.name + ')';
    }

    @Override // com.obric.capabilitykit.entity.meta.MetaValue, android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        o.e(r1, "parcel");
        r1.writeString(this.id);
        r1.writeString(this.name);
        r1.writeInt(0);
    }
}
