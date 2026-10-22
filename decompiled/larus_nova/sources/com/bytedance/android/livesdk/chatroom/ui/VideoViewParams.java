package com.bytedance.android.livesdk.chatroom.ui;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/VideoViewParams;", "Landroid/os/Parcelable;", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VideoViewParams implements Parcelable {
    public static final Parcelable.Creator<VideoViewParams> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f112569a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f112570b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f112571c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f112572d;

    public static class a implements Parcelable.Creator<VideoViewParams> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final VideoViewParams createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "in");
            return new VideoViewParams(r100.readInt(), r100.readInt(), r100.readInt(), r100.readFloat());
        }

        @Override // android.os.Parcelable.Creator
        public final VideoViewParams[] newArray(int r100) {
            return new VideoViewParams[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final int hashCode() {
        return (((((this.f112569a * 31) + this.f112570b) * 31) + this.f112571c) * 31) + Float.floatToIntBits(this.f112572d);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeInt(this.f112569a);
        r100.writeInt(this.f112570b);
        r100.writeInt(this.f112571c);
        r100.writeFloat(this.f112572d);
    }

    public final String toString() {
        return "VideoViewParams[" + hashCode() + "]: width=" + this.f112569a + ", height=" + this.f112570b + ", marginTop=" + this.f112571c + ", xOffset=" + this.f112572d;
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof VideoViewParams) == true) goto L5;
        r100 = null;
    L5:
        VideoViewParams r101 = (VideoViewParams) r100;
        if (r101 != null) goto L8;
        return false;
    L8:
        if (r101.f112569a == this.f112569a) goto L10;
        return false;
    L10:
        if (r101.f112570b == this.f112570b) goto L12;
        return false;
    L12:
        if (r101.f112571c == this.f112571c) goto L14;
        return false;
    L14:
        if (r101.f112572d != this.f112572d) goto L22;
        return true;
    L22:
        return false;
    }

    public VideoViewParams(int r100, int r101, int r102, float r103) {
        this.f112569a = r100;
        this.f112570b = r101;
        this.f112571c = r102;
        this.f112572d = r103;
    }
}
