package com.obric.eventkit.eventstaskmanager;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public final class StateInfo implements Parcelable {
    public static final CREATOR CREATOR = null;
    private final String content;
    private Map<String, String> ext;
    private final boolean isInIsland;
    private final String refMessageId;
    private final int requestType;
    private final boolean startWithAsr;
    private final String taskType;
    private final long timeOut;

    public static final class CREATOR implements Parcelable.Creator<StateInfo> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StateInfo createFromParcel(Parcel r1) {
            o.e(r1, "parcel");
            return new StateInfo(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ StateInfo createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StateInfo[] newArray(int r1) {
            return new StateInfo[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ StateInfo[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public StateInfo(int r3, String r4, String r5, String r6, long r7, boolean r9, boolean r10, Map<String, String> r11) {
        Map<String, String> r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.aiagent.plugin");
        this.requestType = r3;
        this.content = r4;
        this.refMessageId = r5;
        this.taskType = r6;
        this.timeOut = r7;
        this.isInIsland = r9;
        this.startWithAsr = r10;
        this.ext = r12;
    }

    public /* synthetic */ StateInfo(int r15, String r16, String r17, String r18, long r19, boolean r21, boolean r22, Map r23, int r24, h r25) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r23, Map.class, "com.obric.aiagent.plugin");
        if ((r24 & 2) == 0) goto L5;
        String r6 = null;
    L7:
        if ((r24 & 8) == 0) goto L9;
        String r8 = null;
    L11:
        if ((r24 & 16) == 0) goto L13;
        long r9 = 0;
    L15:
        if ((r24 & 32) == 0) goto L17;
        boolean r11 = false;
    L19:
        if ((r24 & 64) == 0) goto L21;
        boolean r12 = false;
    L23:
        if ((r24 & 128) == 0) goto L25;
        Map r13 = null;
    L26:
        this(r15, r6, r17, r8, r9, r11, r12, r13);
        return;
    L25:
        r13 = r1;
        goto L26
    L21:
        r12 = r22;
        goto L23
    L17:
        r11 = r21;
        goto L19
    L13:
        r9 = r19;
        goto L15
    L9:
        r8 = r18;
        goto L11
    L5:
        r6 = r16;
        goto L7
    }

    public StateInfo(Parcel r15) {
        o.e(r15, "parcel");
        this(r15.readInt(), r15.readString(), r15.readString(), r15.readString(), r15.readLong(), r15.readBoolean(), r15.readBoolean(), null, 128, null);
        if (Build.VERSION.SDK_INT < 33) goto L7;
        LinkedHashMap r1 = new LinkedHashMap();
        r15.readMap(r1, StateInfo.class.getClassLoader(), String.class, String.class);
        if ((!r1.isEmpty()) == false) goto L21;
        this.ext = r1;
        return;
    L21:
        return;
    L7:
        Bundle r16 = r15.readBundle(StateInfo.class.getClassLoader());
        if (r16 == null) goto L23;
        LinkedHashMap r0 = new LinkedHashMap();
        Set<String> r2 = r16.keySet();
        o.c(r2, "it.keySet()");
        Iterator<T> r3 = r2.iterator();
    L11:
        if (r3.hasNext() == false) goto L16;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.aiagent.plugin");
        o.c(r4, "key");
        String r5 = r16.getString(r4);
        if (r5 != null) goto L15;
        r5 = "";
    L15:
        o.c(r5, "it.getString(key) ?: \"\"");
        r0.put(r4, r5);
        goto L11
    L16:
        this.ext = r0;
        return;
    }

    public static /* synthetic */ StateInfo copy$default(StateInfo r11, int r12, String r13, String r14, String r15, long r16, boolean r18, boolean r19, Map r20, int r21, Object r22) {
        Map<String, String> r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r20, Map.class, "com.obric.aiagent.plugin");
        if ((r21 & 1) == 0) goto L5;
        int r3 = r11.requestType;
    L7:
        if ((r21 & 2) == 0) goto L9;
        String r4 = r11.content;
    L11:
        if ((r21 & 4) == 0) goto L13;
        String r5 = r11.refMessageId;
    L15:
        if ((r21 & 8) == 0) goto L17;
        String r6 = r11.taskType;
    L19:
        if ((r21 & 16) == 0) goto L21;
        long r7 = r11.timeOut;
    L23:
        if ((r21 & 32) == 0) goto L25;
        boolean r9 = r11.isInIsland;
    L27:
        if ((r21 & 64) == 0) goto L29;
        boolean r10 = r11.startWithAsr;
    L31:
        if ((r21 & 128) == 0) goto L33;
        Map<String, String> r1 = r11.ext;
    L35:
        return r11.copy(r3, r4, r5, r6, r7, r9, r10, r1);
    L33:
        r1 = r2;
        goto L35
    L29:
        r10 = r19;
        goto L31
    L25:
        r9 = r18;
        goto L27
    L21:
        r7 = r16;
        goto L23
    L17:
        r6 = r15;
        goto L19
    L13:
        r5 = r14;
        goto L15
    L9:
        r4 = r13;
        goto L11
    L5:
        r3 = r12;
        goto L7
    }

    public final int component1() {
        return this.requestType;
    }

    public final String component2() {
        return this.content;
    }

    public final String component3() {
        return this.refMessageId;
    }

    public final String component4() {
        return this.taskType;
    }

    public final long component5() {
        return this.timeOut;
    }

    public final boolean component6() {
        return this.isInIsland;
    }

    public final boolean component7() {
        return this.startWithAsr;
    }

    public final Map<String, String> component8() {
        return this.ext;
    }

    public final StateInfo copy(int r12, String r13, String r14, String r15, long r16, boolean r18, boolean r19, Map<String, String> r20) {
        return new StateInfo(r12, r13, r14, r15, r16, r18, r19, (Map) ZeusTransformUtils.wrapperContextForParams(r20, Map.class, "com.obric.aiagent.plugin"));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, StateInfo.class) == true) goto L8;
        return false;
    L8:
        StateInfo r10 = (StateInfo) ZeusTransformUtils.preCheckCast(r9, StateInfo.class, "com.obric.aiagent.plugin");
        if (this.requestType == r10.requestType) goto L12;
        return false;
    L12:
        if (o.a(this.content, r10.content) == true) goto L15;
        return false;
    L15:
        if (o.a(this.refMessageId, r10.refMessageId) == true) goto L18;
        return false;
    L18:
        if (o.a(this.taskType, r10.taskType) == true) goto L21;
        return false;
    L21:
        if (this.timeOut == r10.timeOut) goto L24;
        return false;
    L24:
        if (this.isInIsland == r10.isInIsland) goto L27;
        return false;
    L27:
        if (this.startWithAsr == r10.startWithAsr) goto L30;
        return false;
    L30:
        if (o.a(this.ext, r10.ext) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final String getContent() {
        return this.content;
    }

    public final Map<String, String> getExt() {
        return this.ext;
    }

    public final String getRefMessageId() {
        return this.refMessageId;
    }

    public final int getRequestType() {
        return this.requestType;
    }

    public final boolean getStartWithAsr() {
        return this.startWithAsr;
    }

    public final String getTaskType() {
        return this.taskType;
    }

    public final long getTimeOut() {
        return this.timeOut;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11, types: [int] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [int] */
    /* JADX WARN: Type inference failed for: r3v3 */
    public int hashCode() {
        int r0 = Integer.hashCode(this.requestType) * 31;
        String r1 = this.content;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.refMessageId;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.taskType;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (((r7 + r9) * 31) + Long.hashCode(this.timeOut)) * 31;
        boolean r11 = this.isInIsland;
        ?? r12 = 1;
        ?? r13 = r11;
        if (r11 == false) goto L17;
        r13 = 1;
    L17:
        int r14 = (r10 + r13) * 31;
        boolean r15 = this.startWithAsr;
        if (r15 == true) goto L21;
        r12 = r15;
    L21:
        int r16 = (r14 + r12) * 31;
        Map<String, String> r17 = this.ext;
        if (r17 == null) goto L26;
        r2 = r17.hashCode();
    L26:
        return r16 + r2;
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

    public final boolean isInIsland() {
        return this.isInIsland;
    }

    public final void setExt(Map<String, String> r3) {
        this.ext = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
    }

    public String toString() {
        return "StateInfo(requestType=" + this.requestType + ", content=" + this.content + ", refMessageId=" + this.refMessageId + ", taskType=" + this.taskType + ", timeOut=" + this.timeOut + ", isInIsland=" + this.isInIsland + ", startWithAsr=" + this.startWithAsr + ", ext=" + this.ext + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r5, int r6) {
        o.e(r5, "parcel");
        r5.writeInt(this.requestType);
        r5.writeString(this.content);
        r5.writeString(this.refMessageId);
        r5.writeString(this.taskType);
        r5.writeLong(this.timeOut);
        r5.writeBoolean(this.isInIsland);
        r5.writeBoolean(this.startWithAsr);
        if (Build.VERSION.SDK_INT < 33) goto L5;
        r5.writeMap(this.ext);
        return;
    L5:
        Bundle r7 = new Bundle();
        Map<String, String> r4 = this.ext;
        if (r4 == null) goto L11;
        Iterator<Map.Entry<String, String>> r8 = r4.entrySet().iterator();
    L9:
        if (r8.hasNext() == false) goto L11;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        r7.putString((String) ZeusTransformUtils.preCheckCast(r0.getKey(), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r0.getValue(), String.class, "com.obric.aiagent.plugin"));
    L11:
        r5.writeBundle(r7);
    }
}
