package com.bytedance.android.livesdk.chatroom.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00042\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/SimpleMediaInfo;", "Landroid/os/Parcelable;", "<init>", "()V", "CREATOR", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SimpleMediaInfo implements Parcelable {
    public static final a CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f106900a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f106901b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f106902c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f106903d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f106904e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f106905f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f106906g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f106907h;

    public static final class a implements Parcelable.Creator<SimpleMediaInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final SimpleMediaInfo createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new SimpleMediaInfo(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final SimpleMediaInfo[] newArray(int r100) {
            return new SimpleMediaInfo[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public SimpleMediaInfo() {
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public SimpleMediaInfo(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        this();
        this.f106900a = r100.readString();
        this.f106901b = r100.readLong();
        this.f106902c = r100.readInt();
        this.f106903d = r100.readInt();
        this.f106904e = r100.readString();
        this.f106905f = r100.readLong();
        this.f106906g = r100.readString();
        this.f106907h = r100.readString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.f106900a);
        r100.writeString(null);
        r100.writeLong(this.f106901b);
        r100.writeInt(this.f106902c);
        r100.writeInt(this.f106903d);
        r100.writeString(this.f106904e);
        r100.writeLong(this.f106905f);
        r100.writeString(this.f106906g);
        r100.writeString(this.f106907h);
    }
}
