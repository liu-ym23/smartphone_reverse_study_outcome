package com.obric.memorydata.sdk.screencapture.rule;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: ViewTreeOption.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ViewTreeOption implements Parcelable {
    public static final Parcelable.Creator<ViewTreeOption> CREATOR = null;
    private final long cacheValidDuration;
    private final boolean includeInvisibleNode;

    /* JADX INFO: compiled from: ViewTreeOption.kt */
    public static final class Creator implements Parcelable.Creator<ViewTreeOption> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ViewTreeOption createFromParcel(Parcel r4) {
            o.e(r4, "parcel");
            if (r4.readInt() == 0) goto L5;
            boolean r0 = true;
        L7:
            return new ViewTreeOption(r0, r4.readLong());
        L5:
            r0 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ViewTreeOption createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ViewTreeOption[] newArray(int r1) {
            return new ViewTreeOption[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ViewTreeOption[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public ViewTreeOption() {
        this(false, 0, 3, null);
    }

    public static /* synthetic */ ViewTreeOption copy$default(ViewTreeOption r0, boolean r1, long r2, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.includeInvisibleNode;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.cacheValidDuration;
    L9:
        return r0.copy(r1, r2);
    }

    public final boolean component1() {
        return this.includeInvisibleNode;
    }

    public final long component2() {
        return this.cacheValidDuration;
    }

    public final ViewTreeOption copy(boolean r1, long r2) {
        return new ViewTreeOption(r1, r2);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, ViewTreeOption.class) == true) goto L8;
        return false;
    L8:
        ViewTreeOption r8 = (ViewTreeOption) ZeusTransformUtils.preCheckCast(r7, ViewTreeOption.class, "com.obric.aiagent.plugin");
        if (this.includeInvisibleNode == r8.includeInvisibleNode) goto L12;
        return false;
    L12:
        if (this.cacheValidDuration == r8.cacheValidDuration) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (Boolean.hashCode(this.includeInvisibleNode) * 31) + Long.hashCode(this.cacheValidDuration);
    }

    public String toString() {
        return "ViewTreeOption(includeInvisibleNode=" + this.includeInvisibleNode + ", cacheValidDuration=" + this.cacheValidDuration + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        o.e(r3, "dest");
        r3.writeInt(this.includeInvisibleNode ? 1 : 0);
        r3.writeLong(this.cacheValidDuration);
    }

    public ViewTreeOption(boolean r1, long r2) {
        this.includeInvisibleNode = r1;
        this.cacheValidDuration = r2;
    }

    public /* synthetic */ ViewTreeOption(boolean r1, long r2, int r4, h r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = false;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r2 = 1000;
    L8:
        this(r1, r2);
    }

    public final boolean getIncludeInvisibleNode() {
        return this.includeInvisibleNode;
    }

    public final long getCacheValidDuration() {
        return this.cacheValidDuration;
    }
}
