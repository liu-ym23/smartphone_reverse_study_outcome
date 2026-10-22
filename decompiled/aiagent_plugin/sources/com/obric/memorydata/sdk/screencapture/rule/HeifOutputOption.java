package com.obric.memorydata.sdk.screencapture.rule;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: ScreenshotOption.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class HeifOutputOption implements Parcelable {
    public static final Parcelable.Creator<HeifOutputOption> CREATOR = null;
    private final int downScalePreference;
    private final int outputHeight;
    private final int outputWidth;
    private final int qp;

    /* JADX INFO: compiled from: ScreenshotOption.kt */
    public static final class Creator implements Parcelable.Creator<HeifOutputOption> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final HeifOutputOption createFromParcel(Parcel r4) {
            o.e(r4, "parcel");
            return new HeifOutputOption(r4.readInt(), r4.readInt(), r4.readInt(), r4.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ HeifOutputOption createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final HeifOutputOption[] newArray(int r1) {
            return new HeifOutputOption[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ HeifOutputOption[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public HeifOutputOption() {
        this(0, 0, 0, 0, 15, null);
    }

    public static /* synthetic */ HeifOutputOption copy$default(HeifOutputOption r0, int r1, int r2, int r3, int r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.outputWidth;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.outputHeight;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.qp;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.downScalePreference;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final int component1() {
        return this.outputWidth;
    }

    public final int component2() {
        return this.outputHeight;
    }

    public final int component3() {
        return this.qp;
    }

    public final int component4() {
        return this.downScalePreference;
    }

    public final HeifOutputOption copy(int r1, int r2, int r3, int r4) {
        return new HeifOutputOption(r1, r2, r3, r4);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, HeifOutputOption.class) == true) goto L8;
        return false;
    L8:
        HeifOutputOption r6 = (HeifOutputOption) ZeusTransformUtils.preCheckCast(r5, HeifOutputOption.class, "com.obric.aiagent.plugin");
        if (this.outputWidth == r6.outputWidth) goto L12;
        return false;
    L12:
        if (this.outputHeight == r6.outputHeight) goto L15;
        return false;
    L15:
        if (this.qp == r6.qp) goto L18;
        return false;
    L18:
        if (this.downScalePreference == r6.downScalePreference) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.outputWidth) * 31) + Integer.hashCode(this.outputHeight)) * 31) + Integer.hashCode(this.qp)) * 31) + Integer.hashCode(this.downScalePreference);
    }

    public String toString() {
        return "HeifOutputOption(outputWidth=" + this.outputWidth + ", outputHeight=" + this.outputHeight + ", qp=" + this.qp + ", downScalePreference=" + this.downScalePreference + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        o.e(r1, "dest");
        r1.writeInt(this.outputWidth);
        r1.writeInt(this.outputHeight);
        r1.writeInt(this.qp);
        r1.writeInt(this.downScalePreference);
    }

    public HeifOutputOption(int r1, int r2, int r3, int r4) {
        this.outputWidth = r1;
        this.outputHeight = r2;
        this.qp = r3;
        this.downScalePreference = r4;
    }

    public /* synthetic */ HeifOutputOption(int r2, int r3, int r4, int r5, int r6, h r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = 0;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = 35;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = 0;
    L14:
        this(r2, r3, r4, r5);
    }

    public final int getOutputWidth() {
        return this.outputWidth;
    }

    public final int getOutputHeight() {
        return this.outputHeight;
    }

    public final int getQp() {
        return this.qp;
    }

    public final int getDownScalePreference() {
        return this.downScalePreference;
    }
}
