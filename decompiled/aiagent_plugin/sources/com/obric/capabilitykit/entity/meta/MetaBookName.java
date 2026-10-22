package com.obric.capabilitykit.entity.meta;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: loaded from: classes4.dex */
public final class MetaBookName extends MetaValue {
    public static final CREATOR CREATOR = null;
    public static final int VERSION = 0;
    private final String bookName;

    public static final class CREATOR implements Parcelable.Creator<MetaBookName> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MetaBookName createFromParcel(Parcel r1) {
            o.e(r1, "parcel");
            return new MetaBookName(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MetaBookName createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MetaBookName[] newArray(int r1) {
            return new MetaBookName[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MetaBookName[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public MetaBookName(Parcel r3) {
        o.e(r3, "parcel");
        this(EntityExtKt.a(r3));
        readMetaValueExtensionField$capabilitykitcommon_release(r3, 0, r3.readInt());
    }

    public MetaBookName(String r2) {
        o.e(r2, "bookName");
        super(10005);
        this.bookName = r2;
    }

    public static /* synthetic */ MetaBookName copy$default(MetaBookName r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.bookName;
    L6:
        return r0.copy(r1);
    }

    public final String component1() {
        return this.bookName;
    }

    public final MetaBookName copy(String r1) {
        o.e(r1, "bookName");
        return new MetaBookName(r1);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, MetaBookName.class) == true) goto L8;
        return false;
    L8:
        MetaBookName r6 = (MetaBookName) ZeusTransformUtils.preCheckCast(r5, MetaBookName.class, "com.obric.aiagent.plugin");
        if (o.a(this.bookName, r6.bookName) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final String getBookName() {
        return this.bookName;
    }

    public int hashCode() {
        return this.bookName.hashCode();
    }

    @Override // com.obric.capabilitykit.entity.meta.MetaValue
    public void onReadMetaValueExtensionField$capabilitykitcommon_release(Parcel r1, ClassLoader r2, int r3) {
        o.e(r1, "parcel");
    }

    @Override // com.obric.capabilitykit.entity.meta.MetaValue
    public String toString() {
        return "MetaBookName(bookName=" + this.bookName + ')';
    }

    @Override // com.obric.capabilitykit.entity.meta.MetaValue, android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        o.e(r1, "parcel");
        r1.writeString(this.bookName);
        r1.writeInt(0);
    }
}
