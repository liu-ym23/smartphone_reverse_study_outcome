package com.obric.capabilitykit.sync;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.t;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B#\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bJ\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0012H\u0016R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/obric/capabilitykit/sync/EntityCheckHashCodeSlotData;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "startTime", "", "endTime", "hashCodeData", "", "Lcom/obric/capabilitykit/sync/EntityHashData;", "(JJLjava/util/List;)V", "getEndTime", "()J", "getHashCodeData", "()Ljava/util/List;", "getStartTime", "describeContents", "", "writeToParcel", "", "flags", "CREATOR", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class EntityCheckHashCodeSlotData implements Parcelable {

    @NotNull
    public static final a CREATOR = null;
    private final long endTime;

    @NotNull
    private final List<EntityHashData> hashCodeData;
    private final long startTime;

    public static final class a implements Parcelable.Creator {
        public a() {
        }

        public EntityCheckHashCodeSlotData a(Parcel r10) {
            q.g(r10, "parcel");
            return new EntityCheckHashCodeSlotData(r10);
        }

        public EntityCheckHashCodeSlotData[] b(int r10) {
            return new EntityCheckHashCodeSlotData[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Object createFromParcel(Parcel r10) {
            return a(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Object[] newArray(int r10) {
            return b(r10);
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        CREATOR = new a(null);
    }

    public EntityCheckHashCodeSlotData(long r10, long r11, @NotNull List<EntityHashData> r12) {
        q.g(r12, "hashCodeData");
        this.startTime = r10;
        this.endTime = r11;
        this.hashCodeData = r12;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final long getEndTime() {
        return this.endTime;
    }

    @NotNull
    public final List<EntityHashData> getHashCodeData() {
        return this.hashCodeData;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        q.g(r10, "parcel");
        r10.writeLong(this.startTime);
        r10.writeLong(this.endTime);
        r10.writeTypedList(this.hashCodeData);
    }

    public EntityCheckHashCodeSlotData(@NotNull Parcel r10) {
        q.g(r10, "parcel");
        long r11 = r10.readLong();
        long r12 = r10.readLong();
        List r13 = r10.createTypedArrayList(EntityHashData.CREATOR);
        if (r13 != null) goto L5;
        r13 = t.i();
    L5:
        this(r11, r12, r13);
    }
}
