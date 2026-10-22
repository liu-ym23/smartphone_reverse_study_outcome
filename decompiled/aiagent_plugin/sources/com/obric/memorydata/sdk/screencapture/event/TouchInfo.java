package com.obric.memorydata.sdk.screencapture.event;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: TouchInfo.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class TouchInfo implements Parcelable {
    public static final Parcelable.Creator<TouchInfo> CREATOR = null;
    public static final a Companion = null;
    private final float x;
    private final float y;

    /* JADX INFO: compiled from: TouchInfo.kt */
    public static final class Creator implements Parcelable.Creator<TouchInfo> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final TouchInfo createFromParcel(Parcel r2) {
            o.e(r2, "parcel");
            return new TouchInfo(r2.readFloat(), r2.readFloat());
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ TouchInfo createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final TouchInfo[] newArray(int r1) {
            return new TouchInfo[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ TouchInfo[] newArray(int r1) {
            return newArray(r1);
        }
    }

    /* JADX INFO: compiled from: TouchInfo.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        Companion = new a(null);
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ TouchInfo copy$default(TouchInfo r0, float r1, float r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.x;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.y;
    L9:
        return r0.copy(r1, r2);
    }

    public final float component1() {
        return this.x;
    }

    public final float component2() {
        return this.y;
    }

    public final TouchInfo copy(float r1, float r2) {
        return new TouchInfo(r1, r2);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, TouchInfo.class) == true) goto L8;
        return false;
    L8:
        TouchInfo r6 = (TouchInfo) ZeusTransformUtils.preCheckCast(r5, TouchInfo.class, "com.obric.aiagent.plugin");
        if (Float.compare(this.x, r6.x) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.y, r6.y) == 0) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (Float.hashCode(this.x) * 31) + Float.hashCode(this.y);
    }

    public String toString() {
        return "TouchInfo(x=" + this.x + ", y=" + this.y + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        o.e(r1, "dest");
        r1.writeFloat(this.x);
        r1.writeFloat(this.y);
    }

    public TouchInfo(float r1, float r2) {
        this.x = r1;
        this.y = r2;
    }

    public final float getX() {
        return this.x;
    }

    public final float getY() {
        return this.y;
    }
}
