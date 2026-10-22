package com.obric.memorydata.sdk.realtime;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: RealTimeContextResult.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class RealTimeContextResult implements Parcelable {
    public static final Parcelable.Creator<RealTimeContextResult> CREATOR = null;
    public static final a Companion = null;
    private final int code;
    private final String errorMsg;
    private final RealTimeContext realTimeContext;

    /* JADX INFO: compiled from: RealTimeContextResult.kt */
    public static final class Creator implements Parcelable.Creator<RealTimeContextResult> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final RealTimeContextResult createFromParcel(Parcel r5) {
            o.e(r5, "parcel");
            int r0 = r5.readInt();
            String r1 = r5.readString();
            if (r5.readInt() != 0) goto L5;
            RealTimeContext r6 = null;
        L7:
            return new RealTimeContextResult(r0, r1, (RealTimeContext) ZeusTransformUtils.preCheckCast(r6, RealTimeContext.class, "com.obric.aiagent.plugin"));
        L5:
            r6 = RealTimeContext.CREATOR.createFromParcel(r5);
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ RealTimeContextResult createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final RealTimeContextResult[] newArray(int r1) {
            return new RealTimeContextResult[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ RealTimeContextResult[] newArray(int r1) {
            return newArray(r1);
        }
    }

    /* JADX INFO: compiled from: RealTimeContextResult.kt */
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

    public static /* synthetic */ RealTimeContextResult copy$default(RealTimeContextResult r0, int r1, String r2, RealTimeContext r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.code;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.errorMsg;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.realTimeContext;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final int component1() {
        return this.code;
    }

    public final String component2() {
        return this.errorMsg;
    }

    public final RealTimeContext component3() {
        return this.realTimeContext;
    }

    public final RealTimeContextResult copy(int r1, String r2, RealTimeContext r3) {
        return new RealTimeContextResult(r1, r2, r3);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, RealTimeContextResult.class) == true) goto L8;
        return false;
    L8:
        RealTimeContextResult r6 = (RealTimeContextResult) ZeusTransformUtils.preCheckCast(r5, RealTimeContextResult.class, "com.obric.aiagent.plugin");
        if (this.code == r6.code) goto L12;
        return false;
    L12:
        if (o.a(this.errorMsg, r6.errorMsg) == true) goto L15;
        return false;
    L15:
        if (o.a(this.realTimeContext, r6.realTimeContext) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = Integer.hashCode(this.code) * 31;
        String r1 = this.errorMsg;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        RealTimeContext r5 = this.realTimeContext;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "RealTimeContextResult(code=" + this.code + ", errorMsg=" + this.errorMsg + ", realTimeContext=" + this.realTimeContext + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r2, int r3) {
        o.e(r2, "dest");
        r2.writeInt(this.code);
        r2.writeString(this.errorMsg);
        RealTimeContext r1 = this.realTimeContext;
        if (r1 != null) goto L5;
        r2.writeInt(0);
        return;
    L5:
        r2.writeInt(1);
        r1.writeToParcel(r2, r3);
    }

    public RealTimeContextResult(int r1, String r2, RealTimeContext r3) {
        this.code = r1;
        this.errorMsg = r2;
        this.realTimeContext = r3;
    }

    public final int getCode() {
        return this.code;
    }

    public final String getErrorMsg() {
        return this.errorMsg;
    }

    public final RealTimeContext getRealTimeContext() {
        return this.realTimeContext;
    }
}
