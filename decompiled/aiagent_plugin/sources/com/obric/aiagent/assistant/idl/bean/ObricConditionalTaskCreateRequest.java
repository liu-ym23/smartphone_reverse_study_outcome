package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.obric.autoaction.app.launcherpage.knowledge.KnowledgeActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: ObricConditionalTaskRequest.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ObricConditionalTaskCreateRequest implements Parcelable {
    public static final Parcelable.Creator<ObricConditionalTaskCreateRequest> CREATOR = null;

    @SerializedName("automatic_fields")
    private final String automaticFields;

    @SerializedName("create_time")
    private final String createTime;

    @SerializedName("create_type")
    private final String createType;

    @SerializedName("discover_id")
    private final String discoverId;

    @SerializedName("discover_query")
    private final String discoverQuery;

    @SerializedName("extra")
    private final Map<String, String> extra;

    @SerializedName("instruction")
    private final String instruction;

    @SerializedName("o_omni_instruction_type")
    private final String instructionType;

    @SerializedName("knowledge")
    private final String knowledge;

    @SerializedName("operate_type")
    private final String operateType;

    @SerializedName("origin_query")
    private final String originQuery;

    @SerializedName("short_query")
    private final String shortQuery;

    @SerializedName(KnowledgeActivity.KEY_TASK_ID)
    private final String taskId;

    @SerializedName("update_time")
    private final String updateTime;

    @SerializedName("user_select_model")
    private final String userSelectModel;

    /* JADX INFO: compiled from: ObricConditionalTaskRequest.kt */
    public static final class Creator implements Parcelable.Creator<ObricConditionalTaskCreateRequest> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ObricConditionalTaskCreateRequest createFromParcel(Parcel r18) {
            o.e(r18, "parcel");
            String r2 = r18.readString();
            String r3 = r18.readString();
            String r4 = r18.readString();
            String r5 = r18.readString();
            String r6 = r18.readString();
            String r7 = r18.readString();
            String r8 = r18.readString();
            String r9 = r18.readString();
            String r10 = r18.readString();
            String r11 = r18.readString();
            String r12 = r18.readString();
            if (r18.readInt() != 0) goto L5;
            LinkedHashMap r0 = null;
        L10:
            return new ObricConditionalTaskCreateRequest(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, (Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.aiagent.plugin"), r18.readString(), r18.readString(), r18.readString());
        L5:
            int r1 = r18.readInt();
            LinkedHashMap r13 = new LinkedHashMap(r1);
            int r14 = 0;
        L6:
            if (r14 == r1) goto L8;
            int r17 = r1;
            r13.put(r18.readString(), r18.readString());
            r14 = r14 + 1;
            r1 = r17;
            goto L6
        L8:
            r0 = r13;
            goto L10
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ObricConditionalTaskCreateRequest createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ObricConditionalTaskCreateRequest[] newArray(int r1) {
            return new ObricConditionalTaskCreateRequest[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ObricConditionalTaskCreateRequest[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public ObricConditionalTaskCreateRequest() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 32767, null);
    }

    public static /* synthetic */ ObricConditionalTaskCreateRequest copy$default(ObricConditionalTaskCreateRequest r16, String r17, String r18, String r19, String r20, String r21, String r22, String r23, String r24, String r25, String r26, String r27, Map r28, String r29, String r30, String r31, int r32, Object r33) {
        Map<String, String> r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r28, Map.class, "com.obric.aiagent.plugin");
        if ((r32 & 1) == 0) goto L5;
        String r3 = r16.taskId;
    L7:
        if ((r32 & 2) == 0) goto L9;
        String r4 = r16.instructionType;
    L11:
        if ((r32 & 4) == 0) goto L13;
        String r5 = r16.createType;
    L15:
        if ((r32 & 8) == 0) goto L17;
        String r6 = r16.instruction;
    L19:
        if ((r32 & 16) == 0) goto L21;
        String r7 = r16.originQuery;
    L23:
        if ((r32 & 32) == 0) goto L25;
        String r8 = r16.shortQuery;
    L27:
        if ((r32 & 64) == 0) goto L29;
        String r9 = r16.createTime;
    L31:
        if ((r32 & 128) == 0) goto L33;
        String r10 = r16.updateTime;
    L35:
        if ((r32 & 256) == 0) goto L37;
        String r11 = r16.knowledge;
    L39:
        if ((r32 & 512) == 0) goto L41;
        String r12 = r16.automaticFields;
    L43:
        if ((r32 & 1024) == 0) goto L45;
        String r13 = r16.operateType;
    L47:
        if ((r32 & 2048) == 0) goto L50;
        r2 = r16.extra;
    L50:
        if ((r32 & 4096) == 0) goto L52;
        String r14 = r16.discoverId;
    L54:
        if ((r32 & 8192) == 0) goto L56;
        String r15 = r16.discoverQuery;
    L58:
        if ((r32 & 16384) == 0) goto L60;
        String r1 = r16.userSelectModel;
    L62:
        return r16.copy(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r2, r14, r15, r1);
    L60:
        r1 = r31;
        goto L62
    L56:
        r15 = r30;
        goto L58
    L52:
        r14 = r29;
        goto L54
    L45:
        r13 = r27;
        goto L47
    L41:
        r12 = r26;
        goto L43
    L37:
        r11 = r25;
        goto L39
    L33:
        r10 = r24;
        goto L35
    L29:
        r9 = r23;
        goto L31
    L25:
        r8 = r22;
        goto L27
    L21:
        r7 = r21;
        goto L23
    L17:
        r6 = r20;
        goto L19
    L13:
        r5 = r19;
        goto L15
    L9:
        r4 = r18;
        goto L11
    L5:
        r3 = r17;
        goto L7
    }

    public final String component1() {
        return this.taskId;
    }

    public final String component10() {
        return this.automaticFields;
    }

    public final String component11() {
        return this.operateType;
    }

    public final Map<String, String> component12() {
        return this.extra;
    }

    public final String component13() {
        return this.discoverId;
    }

    public final String component14() {
        return this.discoverQuery;
    }

    public final String component15() {
        return this.userSelectModel;
    }

    public final String component2() {
        return this.instructionType;
    }

    public final String component3() {
        return this.createType;
    }

    public final String component4() {
        return this.instruction;
    }

    public final String component5() {
        return this.originQuery;
    }

    public final String component6() {
        return this.shortQuery;
    }

    public final String component7() {
        return this.createTime;
    }

    public final String component8() {
        return this.updateTime;
    }

    public final String component9() {
        return this.knowledge;
    }

    public final ObricConditionalTaskCreateRequest copy(String r18, String r19, String r20, String r21, String r22, String r23, String r24, String r25, String r26, String r27, String r28, Map<String, String> r29, String r30, String r31, String r32) {
        return new ObricConditionalTaskCreateRequest(r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, (Map) ZeusTransformUtils.wrapperContextForParams(r29, Map.class, "com.obric.aiagent.plugin"), r30, r31, r32);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ObricConditionalTaskCreateRequest.class) == true) goto L8;
        return false;
    L8:
        ObricConditionalTaskCreateRequest r6 = (ObricConditionalTaskCreateRequest) ZeusTransformUtils.preCheckCast(r5, ObricConditionalTaskCreateRequest.class, "com.obric.aiagent.plugin");
        if (o.a(this.taskId, r6.taskId) == true) goto L12;
        return false;
    L12:
        if (o.a(this.instructionType, r6.instructionType) == true) goto L15;
        return false;
    L15:
        if (o.a(this.createType, r6.createType) == true) goto L18;
        return false;
    L18:
        if (o.a(this.instruction, r6.instruction) == true) goto L21;
        return false;
    L21:
        if (o.a(this.originQuery, r6.originQuery) == true) goto L24;
        return false;
    L24:
        if (o.a(this.shortQuery, r6.shortQuery) == true) goto L27;
        return false;
    L27:
        if (o.a(this.createTime, r6.createTime) == true) goto L30;
        return false;
    L30:
        if (o.a(this.updateTime, r6.updateTime) == true) goto L33;
        return false;
    L33:
        if (o.a(this.knowledge, r6.knowledge) == true) goto L36;
        return false;
    L36:
        if (o.a(this.automaticFields, r6.automaticFields) == true) goto L39;
        return false;
    L39:
        if (o.a(this.operateType, r6.operateType) == true) goto L42;
        return false;
    L42:
        if (o.a(this.extra, r6.extra) == true) goto L45;
        return false;
    L45:
        if (o.a(this.discoverId, r6.discoverId) == true) goto L48;
        return false;
    L48:
        if (o.a(this.discoverQuery, r6.discoverQuery) == true) goto L51;
        return false;
    L51:
        if (o.a(this.userSelectModel, r6.userSelectModel) == true) goto L53;
        return false;
    L53:
        return true;
    }

    public int hashCode() {
        String r0 = this.taskId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.instructionType;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.createType;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.instruction;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.originQuery;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.shortQuery;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.createTime;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.updateTime;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        String r25 = this.knowledge;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        String r28 = this.automaticFields;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        String r31 = this.operateType;
        if (r31 != null) goto L45;
        int r32 = 0;
    L46:
        int r33 = (r30 + r32) * 31;
        Map<String, String> r34 = this.extra;
        if (r34 != null) goto L49;
        int r35 = 0;
    L50:
        int r36 = (r33 + r35) * 31;
        String r37 = this.discoverId;
        if (r37 != null) goto L53;
        int r38 = 0;
    L54:
        int r39 = (r36 + r38) * 31;
        String r40 = this.discoverQuery;
        if (r40 != null) goto L57;
        int r41 = 0;
    L58:
        int r42 = (r39 + r41) * 31;
        String r43 = this.userSelectModel;
        if (r43 == null) goto L63;
        r1 = r43.hashCode();
    L63:
        return r42 + r1;
    L57:
        r41 = r40.hashCode();
        goto L58
    L53:
        r38 = r37.hashCode();
        goto L54
    L49:
        r35 = r34.hashCode();
        goto L50
    L45:
        r32 = r31.hashCode();
        goto L46
    L41:
        r29 = r28.hashCode();
        goto L42
    L37:
        r26 = r25.hashCode();
        goto L38
    L33:
        r23 = r22.hashCode();
        goto L34
    L29:
        r20 = r19.hashCode();
        goto L30
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("ObricConditionalTaskCreateRequest(taskId=").append(this.taskId).append(", instructionType=").append(this.instructionType).append(", createType=").append(this.createType).append(", instruction=").append(this.instruction).append(", originQuery=").append(this.originQuery).append(", shortQuery=").append(this.shortQuery).append(", createTime=").append(this.createTime).append(", updateTime=").append(this.updateTime).append(", knowledge=").append(this.knowledge).append(", automaticFields=").append(this.automaticFields).append(", operateType=").append(this.operateType).append(", extra=");
        r0.append(this.extra).append(", discoverId=").append(this.discoverId).append(", discoverQuery=").append(this.discoverQuery).append(", userSelectModel=").append(this.userSelectModel).append(')');
        return r0.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r5, int r6) {
        o.e(r5, "dest");
        r5.writeString(this.taskId);
        r5.writeString(this.instructionType);
        r5.writeString(this.createType);
        r5.writeString(this.instruction);
        r5.writeString(this.originQuery);
        r5.writeString(this.shortQuery);
        r5.writeString(this.createTime);
        r5.writeString(this.updateTime);
        r5.writeString(this.knowledge);
        r5.writeString(this.automaticFields);
        r5.writeString(this.operateType);
        Map<String, String> r7 = this.extra;
        if (r7 != null) goto L5;
        r5.writeInt(0);
    L9:
        r5.writeString(this.discoverId);
        r5.writeString(this.discoverQuery);
        r5.writeString(this.userSelectModel);
        return;
    L5:
        r5.writeInt(1);
        r5.writeInt(r7.size());
        Iterator<Map.Entry<String, String>> r8 = r7.entrySet().iterator();
    L7:
        if (r8.hasNext() == false) goto L9;
        Map.Entry<String, String> r0 = r8.next();
        r5.writeString((String) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r0, Map.Entry.class, "com.obric.aiagent.plugin")).getKey(), String.class, "com.obric.aiagent.plugin"));
        r5.writeString((String) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r0, Map.Entry.class, "com.obric.aiagent.plugin")).getValue(), String.class, "com.obric.aiagent.plugin"));
        goto L7
    }

    public ObricConditionalTaskCreateRequest(String r5, String r6, String r7, String r8, String r9, String r10, String r11, String r12, String r13, String r14, String r15, Map<String, String> r16, String r17, String r18, String r19) {
        Map<String, String> r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r16, Map.class, "com.obric.aiagent.plugin");
        this.taskId = r5;
        this.instructionType = r6;
        this.createType = r7;
        this.instruction = r8;
        this.originQuery = r9;
        this.shortQuery = r10;
        this.createTime = r11;
        this.updateTime = r12;
        this.knowledge = r13;
        this.automaticFields = r14;
        this.operateType = r15;
        this.extra = r1;
        this.discoverId = r17;
        this.discoverQuery = r18;
        this.userSelectModel = r19;
    }

    public /* synthetic */ ObricConditionalTaskCreateRequest(String r17, String r18, String r19, String r20, String r21, String r22, String r23, String r24, String r25, String r26, String r27, Map r28, String r29, String r30, String r31, int r32, h r33) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r28, Map.class, "com.obric.aiagent.plugin");
        String r3 = null;
        if ((r32 & 1) == 0) goto L5;
        String r2 = null;
    L7:
        if ((r32 & 2) == 0) goto L9;
        String r4 = null;
    L11:
        if ((r32 & 4) == 0) goto L13;
        String r5 = null;
    L15:
        if ((r32 & 8) == 0) goto L17;
        String r6 = null;
    L19:
        if ((r32 & 16) == 0) goto L21;
        String r7 = null;
    L23:
        if ((r32 & 32) == 0) goto L25;
        String r8 = null;
    L27:
        if ((r32 & 64) == 0) goto L29;
        String r9 = null;
    L31:
        if ((r32 & 128) == 0) goto L33;
        String r10 = null;
    L35:
        if ((r32 & 256) == 0) goto L37;
        String r11 = null;
    L39:
        if ((r32 & 512) == 0) goto L41;
        String r12 = null;
    L43:
        if ((r32 & 1024) == 0) goto L45;
        String r13 = null;
    L47:
        if ((r32 & 2048) == 0) goto L50;
        r1 = null;
    L50:
        if ((r32 & 4096) == 0) goto L52;
        String r14 = null;
    L54:
        if ((r32 & 8192) == 0) goto L56;
        String r15 = null;
    L58:
        if ((r32 & 16384) != 0) goto L61;
        r3 = r31;
    L61:
        this(r2, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r1, r14, r15, r3);
        return;
    L56:
        r15 = r30;
        goto L58
    L52:
        r14 = r29;
        goto L54
    L45:
        r13 = r27;
        goto L47
    L41:
        r12 = r26;
        goto L43
    L37:
        r11 = r25;
        goto L39
    L33:
        r10 = r24;
        goto L35
    L29:
        r9 = r23;
        goto L31
    L25:
        r8 = r22;
        goto L27
    L21:
        r7 = r21;
        goto L23
    L17:
        r6 = r20;
        goto L19
    L13:
        r5 = r19;
        goto L15
    L9:
        r4 = r18;
        goto L11
    L5:
        r2 = r17;
        goto L7
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final String getInstructionType() {
        return this.instructionType;
    }

    public final String getCreateType() {
        return this.createType;
    }

    public final String getInstruction() {
        return this.instruction;
    }

    public final String getOriginQuery() {
        return this.originQuery;
    }

    public final String getShortQuery() {
        return this.shortQuery;
    }

    public final String getCreateTime() {
        return this.createTime;
    }

    public final String getUpdateTime() {
        return this.updateTime;
    }

    public final String getKnowledge() {
        return this.knowledge;
    }

    public final String getAutomaticFields() {
        return this.automaticFields;
    }

    public final String getOperateType() {
        return this.operateType;
    }

    public final Map<String, String> getExtra() {
        return this.extra;
    }

    public final String getDiscoverId() {
        return this.discoverId;
    }

    public final String getDiscoverQuery() {
        return this.discoverQuery;
    }

    public final String getUserSelectModel() {
        return this.userSelectModel;
    }
}
