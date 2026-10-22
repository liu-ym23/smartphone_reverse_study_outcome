package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class TimerTaskResult implements Parcelable {
    public static final CREATOR CREATOR = null;
    private final int code;
    private final List<TimerTask> data;
    private final String msg;

    public static final class CREATOR implements Parcelable.Creator<TimerTaskResult> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TimerTaskResult createFromParcel(Parcel r1) {
            o.e(r1, "parcel");
            return new TimerTaskResult(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ TimerTaskResult createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TimerTaskResult[] newArray(int r1) {
            return new TimerTaskResult[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ TimerTaskResult[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public TimerTaskResult(int r3, String r4, List<TimerTask> r5) {
        List<TimerTask> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        this.code = r3;
        this.msg = r4;
        this.data = r6;
    }

    public TimerTaskResult(Parcel r4) {
        o.e(r4, "parcel");
        this(r4.readInt(), r4.readString(), r4.createTypedArrayList(TimerTask.CREATOR));
    }

    public static /* synthetic */ TimerTaskResult copy$default(TimerTaskResult r1, int r2, String r3, List r4, int r5, Object r6) {
        List<TimerTask> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        if ((r5 & 1) == 0) goto L6;
        r2 = r1.code;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = r1.msg;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r7 = r1.data;
    L12:
        return r1.copy(r2, r3, r7);
    }

    public final int component1() {
        return this.code;
    }

    public final String component2() {
        return this.msg;
    }

    public final List<TimerTask> component3() {
        return this.data;
    }

    public final TimerTaskResult copy(int r2, String r3, List<TimerTask> r4) {
        return new TimerTaskResult(r2, r3, (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin"));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, TimerTaskResult.class) == true) goto L8;
        return false;
    L8:
        TimerTaskResult r6 = (TimerTaskResult) ZeusTransformUtils.preCheckCast(r5, TimerTaskResult.class, "com.obric.aiagent.plugin");
        if (this.code == r6.code) goto L12;
        return false;
    L12:
        if (o.a(this.msg, r6.msg) == true) goto L15;
        return false;
    L15:
        if (o.a(this.data, r6.data) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int getCode() {
        return this.code;
    }

    public final List<TimerTask> getData() {
        return this.data;
    }

    public final String getMsg() {
        return this.msg;
    }

    public int hashCode() {
        int r0 = Integer.hashCode(this.code) * 31;
        String r1 = this.msg;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        List<TimerTask> r5 = this.data;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "TimerTaskResult(code=" + this.code + ", msg=" + this.msg + ", data=" + this.data + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        o.e(r1, "parcel");
        r1.writeInt(this.code);
        r1.writeString(this.msg);
        r1.writeTypedList(this.data);
    }
}
