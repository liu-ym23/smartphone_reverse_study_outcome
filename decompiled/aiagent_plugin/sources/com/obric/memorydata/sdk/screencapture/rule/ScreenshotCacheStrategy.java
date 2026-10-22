package com.obric.memorydata.sdk.screencapture.rule;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: ScreenshotOption.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ScreenshotCacheStrategy implements Parcelable {
    public static final Parcelable.Creator<ScreenshotCacheStrategy> CREATOR = null;
    private final a strategy;
    private final String uniqueNodeViewId;

    /* JADX INFO: compiled from: ScreenshotOption.kt */
    public static final class Creator implements Parcelable.Creator<ScreenshotCacheStrategy> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ScreenshotCacheStrategy createFromParcel(Parcel r2) {
            o.e(r2, "parcel");
            return new ScreenshotCacheStrategy(a.valueOf(r2.readString()), r2.readString());
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ScreenshotCacheStrategy createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ScreenshotCacheStrategy[] newArray(int r1) {
            return new ScreenshotCacheStrategy[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ScreenshotCacheStrategy[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ ScreenshotCacheStrategy copy$default(ScreenshotCacheStrategy r0, a r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.strategy;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.uniqueNodeViewId;
    L9:
        return r0.copy(r1, r2);
    }

    public final a component1() {
        return this.strategy;
    }

    public final String component2() {
        return this.uniqueNodeViewId;
    }

    public final ScreenshotCacheStrategy copy(a r1, String r2) {
        o.e(r1, "strategy");
        return new ScreenshotCacheStrategy(r1, r2);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ScreenshotCacheStrategy.class) == true) goto L8;
        return false;
    L8:
        ScreenshotCacheStrategy r6 = (ScreenshotCacheStrategy) ZeusTransformUtils.preCheckCast(r5, ScreenshotCacheStrategy.class, "com.obric.aiagent.plugin");
        if (this.strategy == r6.strategy) goto L12;
        return false;
    L12:
        if (o.a(this.uniqueNodeViewId, r6.uniqueNodeViewId) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r0 = this.strategy.hashCode() * 31;
        String r1 = this.uniqueNodeViewId;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "ScreenshotCacheStrategy(strategy=" + this.strategy + ", uniqueNodeViewId=" + this.uniqueNodeViewId + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        o.e(r1, "dest");
        r1.writeString(this.strategy.name());
        r1.writeString(this.uniqueNodeViewId);
    }

    public ScreenshotCacheStrategy(a r2, String r3) {
        o.e(r2, "strategy");
        this.strategy = r2;
        this.uniqueNodeViewId = r3;
    }

    public /* synthetic */ ScreenshotCacheStrategy(a r1, String r2, int r3, h r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    public final a getStrategy() {
        return this.strategy;
    }

    public final String getUniqueNodeViewId() {
        return this.uniqueNodeViewId;
    }
}
