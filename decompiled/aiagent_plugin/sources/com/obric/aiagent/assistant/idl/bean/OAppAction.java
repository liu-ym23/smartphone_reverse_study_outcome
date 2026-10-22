package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.google.gson.Gson;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.obric.capabilitykit.common.TimeTransformAdapter;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.f;
import d.g;
import d.h.b.h;
import d.h.b.o;
import java.util.Map;

/* JADX INFO: compiled from: OAppAction.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class OAppAction implements Parcelable {
    public static final Parcelable.Creator<OAppAction> CREATOR = null;
    public static final a Companion = null;
    public static final int MESSAGE_TYPE_ACK = 2;
    public static final int MESSAGE_TYPE_MSG = 1;
    private static final f<Gson> gson$delegate = null;

    @SerializedName("app_type")
    private final int appType;

    @SerializedName("content")
    private final String content;

    @SerializedName("create_time")
    @JsonAdapter(TimeTransformAdapter.class)
    private final long createTime;

    @SerializedName("message_id")
    private final long messageId;

    @SerializedName("message_type")
    private final int messageType;

    @SerializedName("question_id")
    private final long questionId;

    @SerializedName("timeout_ms")
    private final int timeoutMs;

    /* JADX INFO: compiled from: OAppAction.kt */
    public static final class Creator implements Parcelable.Creator<OAppAction> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final OAppAction createFromParcel(Parcel r12) {
            o.e(r12, "parcel");
            return new OAppAction(r12.readInt(), r12.readLong(), r12.readLong(), r12.readLong(), r12.readString(), r12.readInt(), r12.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ OAppAction createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final OAppAction[] newArray(int r1) {
            return new OAppAction[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ OAppAction[] newArray(int r1) {
            return newArray(r1);
        }
    }

    /* JADX INFO: compiled from: OAppAction.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }

        public static final /* synthetic */ Gson a(a r0) {
            return r0.a();
        }

        private final Gson a() {
            return (Gson) ZeusTransformUtils.preCheckCast(OAppAction.access$getGson$delegate$cp().b(), Gson.class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: OAppAction.kt */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName(DbHelper.COL_ID)
        private final long f16257a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @SerializedName("question_id")
        private final long f16258b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @SerializedName("action_parameters")
        private final String f16259c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @SerializedName("action_result_data")
        private final String f16260d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @SerializedName("ext")
        private final Map<String, String> f16261e;

        public b() {
            this(0, 0, null, null, null, 31, null);
        }

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, b.class) == true) goto L8;
            return false;
        L8:
            b r10 = (b) ZeusTransformUtils.preCheckCast(r9, b.class, "com.obric.aiagent.plugin");
            if (this.f16257a == r10.f16257a) goto L12;
            return false;
        L12:
            if (this.f16258b == r10.f16258b) goto L15;
            return false;
        L15:
            if (o.a(this.f16259c, r10.f16259c) == true) goto L18;
            return false;
        L18:
            if (o.a(this.f16260d, r10.f16260d) == true) goto L21;
            return false;
        L21:
            if (o.a(this.f16261e, r10.f16261e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            int r0 = ((Long.hashCode(this.f16257a) * 31) + Long.hashCode(this.f16258b)) * 31;
            String r1 = this.f16259c;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            String r5 = this.f16260d;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (r4 + r6) * 31;
            Map<String, String> r8 = this.f16261e;
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
            return "OMpParams(id=" + this.f16257a + ", questionId=" + this.f16258b + ", actionParameters=" + this.f16259c + ", actionResultData=" + this.f16260d + ", ext=" + this.f16261e + ')';
        }

        public b(long r3, long r5, String r7, String r8, Map<String, String> r9) {
            Map<String, String> r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.aiagent.plugin");
            this.f16257a = r3;
            this.f16258b = r5;
            this.f16259c = r7;
            this.f16260d = r8;
            this.f16261e = r10;
        }

        public /* synthetic */ b(long r9, long r11, String r13, String r14, Map r15, int r16, h r17) {
            Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r15, Map.class, "com.obric.aiagent.plugin");
            long r2 = -1;
            if ((r16 & 1) == 0) goto L5;
            long r4 = -1;
        L7:
            if ((r16 & 2) != 0) goto L10;
            r2 = r11;
        L10:
            String r6 = "";
            if ((r16 & 4) == 0) goto L13;
            String r1 = "";
        L15:
            if ((r16 & 8) != 0) goto L19;
            r6 = r14;
        L19:
            if ((r16 & 16) == 0) goto L21;
            r0 = null;
        L21:
            this(r4, r2, r1, r6, r0);
            return;
        L13:
            r1 = r13;
            goto L15
        L5:
            r4 = r9;
            goto L7
        }

        public final long a() {
            return this.f16257a;
        }

        public final String b() {
            return this.f16259c;
        }

        public final Map<String, String> c() {
            return this.f16261e;
        }
    }

    public OAppAction() {
        this(0, 0, 0, 0, null, 0, 0, 127, null);
    }

    public static /* synthetic */ OAppAction copy$default(OAppAction r11, int r12, long r13, long r15, long r17, String r19, int r20, int r21, int r22, Object r23) {
        if ((r22 & 1) == 0) goto L5;
        int r1 = r11.appType;
    L7:
        if ((r22 & 2) == 0) goto L9;
        long r2 = r11.messageId;
    L11:
        if ((r22 & 4) == 0) goto L13;
        long r4 = r11.questionId;
    L15:
        if ((r22 & 8) == 0) goto L17;
        long r6 = r11.createTime;
    L19:
        if ((r22 & 16) == 0) goto L21;
        String r8 = r11.content;
    L23:
        if ((r22 & 32) == 0) goto L25;
        int r9 = r11.messageType;
    L27:
        if ((r22 & 64) == 0) goto L29;
        int r10 = r11.timeoutMs;
    L31:
        return r11.copy(r1, r2, r4, r6, r8, r9, r10);
    L29:
        r10 = r21;
        goto L31
    L25:
        r9 = r20;
        goto L27
    L21:
        r8 = r19;
        goto L23
    L17:
        r6 = r17;
        goto L19
    L13:
        r4 = r15;
        goto L15
    L9:
        r2 = r13;
        goto L11
    L5:
        r1 = r12;
        goto L7
    }

    public static /* synthetic */ Gson lambda$MIxgulB7uql3yp_5hUI7MgNrH7k() {
        return gson_delegate$lambda$0();
    }

    public final int component1() {
        return this.appType;
    }

    public final long component2() {
        return this.messageId;
    }

    public final long component3() {
        return this.questionId;
    }

    public final long component4() {
        return this.createTime;
    }

    public final String component5() {
        return this.content;
    }

    public final int component6() {
        return this.messageType;
    }

    public final int component7() {
        return this.timeoutMs;
    }

    public final OAppAction copy(int r13, long r14, long r16, long r18, String r20, int r21, int r22) {
        return new OAppAction(r13, r14, r16, r18, r20, r21, r22);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, OAppAction.class) == true) goto L8;
        return false;
    L8:
        OAppAction r10 = (OAppAction) ZeusTransformUtils.preCheckCast(r9, OAppAction.class, "com.obric.aiagent.plugin");
        if (this.appType == r10.appType) goto L12;
        return false;
    L12:
        if (this.messageId == r10.messageId) goto L15;
        return false;
    L15:
        if (this.questionId == r10.questionId) goto L18;
        return false;
    L18:
        if (this.createTime == r10.createTime) goto L21;
        return false;
    L21:
        if (o.a(this.content, r10.content) == true) goto L24;
        return false;
    L24:
        if (this.messageType == r10.messageType) goto L27;
        return false;
    L27:
        if (this.timeoutMs == r10.timeoutMs) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((Integer.hashCode(this.appType) * 31) + Long.hashCode(this.messageId)) * 31) + Long.hashCode(this.questionId)) * 31) + Long.hashCode(this.createTime)) * 31;
        String r1 = this.content;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((((r0 + r2) * 31) + Integer.hashCode(this.messageType)) * 31) + Integer.hashCode(this.timeoutMs);
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        o.e(r3, "dest");
        r3.writeInt(this.appType);
        r3.writeLong(this.messageId);
        r3.writeLong(this.questionId);
        r3.writeLong(this.createTime);
        r3.writeString(this.content);
        r3.writeInt(this.messageType);
        r3.writeInt(this.timeoutMs);
    }

    public static final /* synthetic */ f access$getGson$delegate$cp() {
        return gson$delegate;
    }

    public OAppAction(int r1, long r2, long r4, long r6, String r8, int r9, int r10) {
        this.appType = r1;
        this.messageId = r2;
        this.questionId = r4;
        this.createTime = r6;
        this.content = r8;
        this.messageType = r9;
        this.timeoutMs = r10;
    }

    public final int getAppType() {
        return this.appType;
    }

    public final long getMessageId() {
        return this.messageId;
    }

    public final long getQuestionId() {
        return this.questionId;
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    public /* synthetic */ OAppAction(int r11, long r12, long r14, long r16, String r18, int r19, int r20, int r21, h r22) {
        if ((r21 & 1) == 0) goto L5;
        int r0 = -1;
    L6:
        long r2 = -1;
        if ((r21 & 2) == 0) goto L9;
        long r4 = -1;
    L11:
        if ((r21 & 4) != 0) goto L15;
        r2 = r14;
    L15:
        if ((r21 & 8) == 0) goto L17;
        long r6 = System.currentTimeMillis();
    L19:
        if ((r21 & 16) == 0) goto L21;
        String r1 = "";
    L23:
        if ((r21 & 32) == 0) goto L25;
        int r8 = 1;
    L27:
        if ((r21 & 64) == 0) goto L29;
        int r9 = 0;
    L30:
        this(r0, r4, r2, r6, r1, r8, r9);
        return;
    L29:
        r9 = r20;
        goto L30
    L25:
        r8 = r19;
        goto L27
    L21:
        r1 = r18;
        goto L23
    L17:
        r6 = r16;
        goto L19
    L9:
        r4 = r12;
        goto L11
    L5:
        r0 = r11;
        goto L6
    }

    public final String getContent() {
        return this.content;
    }

    public final int getMessageType() {
        return this.messageType;
    }

    public final int getTimeoutMs() {
        return this.timeoutMs;
    }

    static {
        Companion = new a(null);
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
        gson$delegate = g.a($$Lambda$OAppAction$MIxgulB7uql3yp_5hUI7MgNrH7k.INSTANCE);
    }

    private static final Gson gson_delegate$lambda$0() {
        return new Gson();
    }

    public final b getMpParams() {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(this.content, CharSequence.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L13;
        return null;
    L13:
        return (b) ZeusTransformUtils.preCheckCast(a.a(Companion).fromJson(this.content, b.class), b.class, "com.obric.aiagent.plugin");
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public String toString() {
        return "[appType=" + this.appType + ". messageId=" + this.messageId + ", questionId=" + this.questionId + ". createTime=" + this.createTime + "messageType=" + this.messageType + ", timeoutMs=" + this.timeoutMs + ". content=" + this.content + ". ]";
    }
}
