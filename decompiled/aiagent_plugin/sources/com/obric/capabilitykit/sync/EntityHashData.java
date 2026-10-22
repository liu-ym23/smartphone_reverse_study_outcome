package com.obric.capabilitykit.sync;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.bdturing.localstorage.DbHelper;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: loaded from: classes4.dex */
public final class EntityHashData implements Parcelable {
    public static final a CREATOR = null;
    private final int hashCodeValue;
    private final String id;

    public static final class a implements Parcelable.Creator<EntityHashData> {
        private a() {
        }

        public /* synthetic */ a(h r1) {
            this();
        }

        public EntityHashData a(Parcel r1) {
            o.e(r1, "parcel");
            return new EntityHashData(r1);
        }

        public EntityHashData[] a(int r1) {
            return new EntityHashData[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ EntityHashData createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ EntityHashData[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        CREATOR = new a(null);
    }

    public EntityHashData(Parcel r2) {
        o.e(r2, "parcel");
        String r0 = r2.readString();
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        this(r0, r2.readInt());
    }

    public EntityHashData(String r2, int r3) {
        o.e(r2, DbHelper.COL_ID);
        this.id = r2;
        this.hashCodeValue = r3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final int getHashCodeValue() {
        return this.hashCodeValue;
    }

    public final String getId() {
        return this.id;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        o.e(r1, "parcel");
        r1.writeString(this.id);
        r1.writeInt(this.hashCodeValue);
    }
}
