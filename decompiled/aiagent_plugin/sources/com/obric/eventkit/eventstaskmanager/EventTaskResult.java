package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class EventTaskResult implements Parcelable {
    public static final Parcelable.Creator<EventTaskResult> CREATOR = null;
    private final int code;
    private final List<EventTask> data;
    private final String detailReason;
    private final String msg;

    public static final class Creator implements Parcelable.Creator<EventTaskResult> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final EventTaskResult createFromParcel(Parcel r8) {
            int r7 = r8.readInt();
            o.e(r8, "parcel");
            int r0 = r8.readInt();
            String r1 = r8.readString();
            if (r8.readInt() != 0) goto L5;
            ArrayList r2 = null;
        L9:
            EventTaskResult r5 = new EventTaskResult(r0, r1, r2, r8.readString());
            int r3 = Math.min(r7, 0);
            ClassLoader r4 = Creator.class.getClassLoader();
            int r6 = 1;
        L10:
            if (r6 > r3) goto L12;
            r6 = r6 + 1;
        L12:
            if (r6 > r7) goto L14;
            com.obric.a.a.a(r8, r4);
            r6 = r6 + 1;
            goto L12
        L14:
            return r5;
        L5:
            int r9 = r8.readInt();
            ArrayList r10 = new ArrayList(r9);
            int r11 = 0;
        L6:
            if (r11 == r9) goto L8;
            r10.add(r8.readParcelable(EventTaskResult.class.getClassLoader()));
            r11 = r11 + 1;
            goto L6
        L8:
            r2 = r10;
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ EventTaskResult createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final EventTaskResult[] newArray(int r1) {
            return new EventTaskResult[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ EventTaskResult[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new Creator();
    }

    public EventTaskResult(int r3, String r4, List<? extends EventTask> r5, String r6) {
        List<EventTask> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        this.code = r3;
        this.msg = r4;
        this.data = r7;
        this.detailReason = r6;
    }

    public /* synthetic */ EventTaskResult(int r2, String r3, List r4, String r5, int r6, h r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        if ((r6 & 8) == 0) goto L5;
        r5 = null;
    L5:
        this(r2, r3, r8, r5);
    }

    public static /* synthetic */ EventTaskResult copy$default(EventTaskResult r1, int r2, String r3, List r4, String r5, int r6, Object r7) {
        List<EventTask> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        if ((r6 & 1) == 0) goto L6;
        r2 = r1.code;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = r1.msg;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r8 = r1.data;
    L12:
        if ((r6 & 8) == 0) goto L15;
        r5 = r1.detailReason;
    L15:
        return r1.copy(r2, r3, r8, r5);
    }

    public final int component1() {
        return this.code;
    }

    public final String component2() {
        return this.msg;
    }

    public final List<EventTask> component3() {
        return this.data;
    }

    public final String component4() {
        return this.detailReason;
    }

    public final EventTaskResult copy(int r2, String r3, List<? extends EventTask> r4, String r5) {
        return new EventTaskResult(r2, r3, (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin"), r5);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, EventTaskResult.class) == true) goto L8;
        return false;
    L8:
        EventTaskResult r6 = (EventTaskResult) ZeusTransformUtils.preCheckCast(r5, EventTaskResult.class, "com.obric.aiagent.plugin");
        if (this.code == r6.code) goto L12;
        return false;
    L12:
        if (o.a(this.msg, r6.msg) == true) goto L15;
        return false;
    L15:
        if (o.a(this.data, r6.data) == true) goto L18;
        return false;
    L18:
        if (o.a(this.detailReason, r6.detailReason) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int getCode() {
        return this.code;
    }

    public final List<EventTask> getData() {
        return this.data;
    }

    public final String getDetailReason() {
        return this.detailReason;
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
        List<EventTask> r5 = this.data;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.detailReason;
        if (r8 == null) goto L15;
        r2 = r8.hashCode();
    L15:
        return r7 + r2;
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "EventTaskResult(code=" + this.code + ", msg=" + this.msg + ", data=" + this.data + ", detailReason=" + this.detailReason + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r5, int r6) {
        r5.writeInt(0);
        o.e(r5, "out");
        r5.writeInt(this.code);
        r5.writeString(this.msg);
        List<EventTask> r1 = this.data;
        if (r1 != null) goto L5;
        r5.writeInt(0);
    L9:
        r5.writeString(this.detailReason);
        return;
    L5:
        r5.writeInt(1);
        r5.writeInt(r1.size());
        Iterator<EventTask> r0 = r1.iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        r5.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(r0.next(), Parcelable.class, "com.obric.aiagent.plugin"), r6);
        goto L7
    }
}
