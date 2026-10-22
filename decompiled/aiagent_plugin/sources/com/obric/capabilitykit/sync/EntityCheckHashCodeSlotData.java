package com.obric.capabilitykit.sync;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.h;
import d.h.b.o;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class EntityCheckHashCodeSlotData implements Parcelable {
    public static final a CREATOR = null;
    private final long endTime;
    private final List<EntityHashData> hashCodeData;
    private final long startTime;

    public static final class a implements Parcelable.Creator<EntityCheckHashCodeSlotData> {
        private a() {
        }

        public /* synthetic */ a(h r1) {
            this();
        }

        public EntityCheckHashCodeSlotData a(Parcel r1) {
            o.e(r1, "parcel");
            return new EntityCheckHashCodeSlotData(r1);
        }

        public EntityCheckHashCodeSlotData[] a(int r1) {
            return new EntityCheckHashCodeSlotData[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ EntityCheckHashCodeSlotData createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ EntityCheckHashCodeSlotData[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        CREATOR = new a(null);
    }

    public EntityCheckHashCodeSlotData(long r3, long r5, List<EntityHashData> r7) {
        List<EntityHashData> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        o.e(r8, "hashCodeData");
        this.startTime = r3;
        this.endTime = r5;
        this.hashCodeData = r8;
    }

    public EntityCheckHashCodeSlotData(Parcel r8) {
        o.e(r8, "parcel");
        long r2 = r8.readLong();
        long r4 = r8.readLong();
        List r9 = r8.createTypedArrayList(EntityHashData.CREATOR);
        if (r9 != null) goto L5;
        r9 = p.b();
    L5:
        this(r2, r4, r9);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final long getEndTime() {
        return this.endTime;
    }

    public final List<EntityHashData> getHashCodeData() {
        return this.hashCodeData;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        o.e(r3, "parcel");
        r3.writeLong(this.startTime);
        r3.writeLong(this.endTime);
        r3.writeTypedList(this.hashCodeData);
    }
}
