package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class EventTaskExecutionDetailRecord implements Parcelable {
    public static final Parcelable.Creator<EventTaskExecutionDetailRecord> CREATOR = null;
    private final String appName;
    private final String detailText;
    private final int detailType;
    private final long execTime;
    private final Map<String, String> ext;
    private final long id;
    private final String packageName;
    private final String sessionId;

    public static final class Creator implements Parcelable.Creator<EventTaskExecutionDetailRecord> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final EventTaskExecutionDetailRecord createFromParcel(Parcel r17) {
            int r1 = r17.readInt();
            o.e(r17, "parcel");
            long r4 = r17.readLong();
            String r6 = r17.readString();
            long r7 = r17.readLong();
            String r9 = r17.readString();
            String r10 = r17.readString();
            String r11 = r17.readString();
            int r12 = r17.readInt();
            if (r17.readInt() != 0) goto L5;
            LinkedHashMap r13 = null;
        L9:
            EventTaskExecutionDetailRecord r2 = new EventTaskExecutionDetailRecord(r4, r6, r7, r9, r10, r11, r12, r13);
            int r3 = Math.min(r1, 0);
            ClassLoader r5 = Creator.class.getClassLoader();
            int r8 = 1;
        L10:
            if (r8 > r3) goto L12;
            r8 = r8 + 1;
        L12:
            if (r8 > r1) goto L14;
            com.obric.a.a.a(r17, r5);
            r8 = r8 + 1;
            goto L12
        L14:
            return r2;
        L5:
            int r14 = r17.readInt();
            LinkedHashMap r15 = new LinkedHashMap(r14);
            int r16 = 0;
        L6:
            if (r16 == r14) goto L8;
            r15.put(r17.readString(), r17.readString());
            r16 = r16 + 1;
            goto L6
        L8:
            r13 = r15;
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ EventTaskExecutionDetailRecord createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final EventTaskExecutionDetailRecord[] newArray(int r1) {
            return new EventTaskExecutionDetailRecord[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ EventTaskExecutionDetailRecord[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new Creator();
    }

    public EventTaskExecutionDetailRecord(long r3, String r5, long r6, String r8, String r9, String r10, int r11, Map<String, String> r12) {
        Map<String, String> r13 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.aiagent.plugin");
        this.id = r3;
        this.sessionId = r5;
        this.execTime = r6;
        this.packageName = r8;
        this.appName = r9;
        this.detailText = r10;
        this.detailType = r11;
        this.ext = r13;
    }

    public /* synthetic */ EventTaskExecutionDetailRecord(long r13, String r15, long r16, String r18, String r19, String r20, int r21, Map r22, int r23, h r24) {
        Map r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r22, Map.class, "com.obric.aiagent.plugin");
        if ((r23 & 1) == 0) goto L5;
        long r2 = 0;
    L6:
        this(r2, r15, r16, r18, r19, r20, r21, r11);
        return;
    L5:
        r2 = r13;
        goto L6
    }

    public static /* synthetic */ EventTaskExecutionDetailRecord copy$default(EventTaskExecutionDetailRecord r12, long r13, String r15, long r16, String r18, String r19, String r20, int r21, Map r22, int r23, Object r24) {
        Map<String, String> r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r22, Map.class, "com.obric.aiagent.plugin");
        if ((r23 & 1) == 0) goto L5;
        long r3 = r12.id;
    L7:
        if ((r23 & 2) == 0) goto L9;
        String r5 = r12.sessionId;
    L11:
        if ((r23 & 4) == 0) goto L13;
        long r6 = r12.execTime;
    L15:
        if ((r23 & 8) == 0) goto L17;
        String r8 = r12.packageName;
    L19:
        if ((r23 & 16) == 0) goto L21;
        String r9 = r12.appName;
    L23:
        if ((r23 & 32) == 0) goto L25;
        String r10 = r12.detailText;
    L27:
        if ((r23 & 64) == 0) goto L29;
        int r11 = r12.detailType;
    L31:
        if ((r23 & 128) == 0) goto L33;
        Map<String, String> r1 = r12.ext;
    L35:
        return r12.copy(r3, r5, r6, r8, r9, r10, r11, r1);
    L33:
        r1 = r2;
        goto L35
    L29:
        r11 = r21;
        goto L31
    L25:
        r10 = r20;
        goto L27
    L21:
        r9 = r19;
        goto L23
    L17:
        r8 = r18;
        goto L19
    L13:
        r6 = r16;
        goto L15
    L9:
        r5 = r15;
        goto L11
    L5:
        r3 = r13;
        goto L7
    }

    public final long component1() {
        return this.id;
    }

    public final String component2() {
        return this.sessionId;
    }

    public final long component3() {
        return this.execTime;
    }

    public final String component4() {
        return this.packageName;
    }

    public final String component5() {
        return this.appName;
    }

    public final String component6() {
        return this.detailText;
    }

    public final int component7() {
        return this.detailType;
    }

    public final Map<String, String> component8() {
        return this.ext;
    }

    public final EventTaskExecutionDetailRecord copy(long r13, String r15, long r16, String r18, String r19, String r20, int r21, Map<String, String> r22) {
        return new EventTaskExecutionDetailRecord(r13, r15, r16, r18, r19, r20, r21, (Map) ZeusTransformUtils.wrapperContextForParams(r22, Map.class, "com.obric.aiagent.plugin"));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, EventTaskExecutionDetailRecord.class) == true) goto L8;
        return false;
    L8:
        EventTaskExecutionDetailRecord r10 = (EventTaskExecutionDetailRecord) ZeusTransformUtils.preCheckCast(r9, EventTaskExecutionDetailRecord.class, "com.obric.aiagent.plugin");
        if (this.id == r10.id) goto L12;
        return false;
    L12:
        if (o.a(this.sessionId, r10.sessionId) == true) goto L15;
        return false;
    L15:
        if (this.execTime == r10.execTime) goto L18;
        return false;
    L18:
        if (o.a(this.packageName, r10.packageName) == true) goto L21;
        return false;
    L21:
        if (o.a(this.appName, r10.appName) == true) goto L24;
        return false;
    L24:
        if (o.a(this.detailText, r10.detailText) == true) goto L27;
        return false;
    L27:
        if (this.detailType == r10.detailType) goto L30;
        return false;
    L30:
        if (o.a(this.ext, r10.ext) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final String getAppName() {
        return this.appName;
    }

    public final String getDetailText() {
        return this.detailText;
    }

    public final int getDetailType() {
        return this.detailType;
    }

    public final long getExecTime() {
        return this.execTime;
    }

    public final Map<String, String> getExt() {
        return this.ext;
    }

    public final long getId() {
        return this.id;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public int hashCode() {
        int r0 = Long.hashCode(this.id) * 31;
        String r1 = this.sessionId;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((r0 + r3) * 31) + Long.hashCode(this.execTime)) * 31;
        String r5 = this.packageName;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.appName;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.detailText;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (((r10 + r12) * 31) + Integer.hashCode(this.detailType)) * 31;
        Map<String, String> r14 = this.ext;
        if (r14 == null) goto L23;
        r2 = r14.hashCode();
    L23:
        return r13 + r2;
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "EventTaskExecutionDetailRecord(id=" + this.id + ", sessionId=" + this.sessionId + ", execTime=" + this.execTime + ", packageName=" + this.packageName + ", appName=" + this.appName + ", detailText=" + this.detailText + ", detailType=" + this.detailType + ", ext=" + this.ext + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r4, int r5) {
        r4.writeInt(0);
        o.e(r4, "out");
        r4.writeLong(this.id);
        r4.writeString(this.sessionId);
        r4.writeLong(this.execTime);
        r4.writeString(this.packageName);
        r4.writeString(this.appName);
        r4.writeString(this.detailText);
        r4.writeInt(this.detailType);
        Map<String, String> r3 = this.ext;
        if (r3 != null) goto L5;
        r4.writeInt(0);
        return;
    L5:
        r4.writeInt(1);
        r4.writeInt(r3.size());
        Iterator<Map.Entry<String, String>> r6 = r3.entrySet().iterator();
    L7:
        if (r6.hasNext() == false) goto L11;
        Map.Entry r7 = (Map.Entry) ZeusTransformUtils.preCheckCast(r6.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        r4.writeString((String) ZeusTransformUtils.preCheckCast(r7.getKey(), String.class, "com.obric.aiagent.plugin"));
        r4.writeString((String) ZeusTransformUtils.preCheckCast(r7.getValue(), String.class, "com.obric.aiagent.plugin"));
        goto L7
    }
}
