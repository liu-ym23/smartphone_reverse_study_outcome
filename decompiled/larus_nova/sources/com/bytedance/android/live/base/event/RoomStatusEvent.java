package com.bytedance.android.live.base.event;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes45.dex */
public class RoomStatusEvent implements Parcelable {
    public static final Parcelable.Creator<RoomStatusEvent> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f58815a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f58816b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f58817c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f58818d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f58819e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<Long> f58820f;

    public class a implements Parcelable.Creator<RoomStatusEvent> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final RoomStatusEvent createFromParcel(Parcel r100) {
            return new RoomStatusEvent(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final RoomStatusEvent[] newArray(int r100) {
            return new RoomStatusEvent[r100];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public RoomStatusEvent() {
    }

    public RoomStatusEvent(Parcel r100) {
        this.f58815a = r100.readLong();
        this.f58816b = r100.readLong();
        this.f58817c = r100.readString();
        if (r100.readByte() == 0) goto L5;
        boolean r101 = true;
    L6:
        this.f58818d = r101;
        this.f58819e = r100.readInt();
        ArrayList r102 = new ArrayList();
        this.f58820f = r102;
        r100.readList(r102, List.class.getClassLoader());
        return;
    L5:
        r101 = false;
        goto L6
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeLong(this.f58815a);
        r100.writeLong(this.f58816b);
        r100.writeString(this.f58817c);
        r100.writeByte(this.f58818d ? 1 : 0);
        r100.writeInt(this.f58819e);
        r100.writeList(this.f58820f);
    }
}
