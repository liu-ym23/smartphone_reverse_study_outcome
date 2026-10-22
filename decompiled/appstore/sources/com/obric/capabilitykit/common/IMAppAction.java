package com.obric.capabilitykit.common;

import android.util.Log;
import androidx.annotation.Keep;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.ServerElements;
import com.google.gson.Gson;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b5\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 Q2\u00020\u0001:\u0001QB\u008b\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010\u0012J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\t\u0010=\u001a\u00020\fHÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u0010\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u0010@\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\u0010\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u0010D\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010E\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010/J\t\u0010F\u001a\u00020\u0003HÆ\u0003J\u0094\u0001\u0010G\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÆ\u0001¢\u0006\u0002\u0010HJ\u0013\u0010I\u001a\u00020J2\b\u0010K\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010L\u001a\u00020\u0014J\u0006\u0010M\u001a\u00020NJ\t\u0010O\u001a\u00020\fHÖ\u0001J\t\u0010P\u001a\u00020\u0006HÖ\u0001R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R \u0010\n\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R \u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0016\"\u0004\b'\u0010\u0018R\u001e\u0010\u000e\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0016\"\u0004\b)\u0010\u0018R \u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001a\"\u0004\b+\u0010\u001cR\"\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b,\u0010\u001e\"\u0004\b-\u0010 R\"\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00102\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b3\u0010\u001e\"\u0004\b4\u0010 R\u001e\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0016\"\u0004\b6\u0010\u0018R\u001e\u0010\u000f\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:¨\u0006R"}, d2 = {"Lcom/obric/capabilitykit/common/IMAppAction;", "", "id", "", "messageId", "localMessageId", "", "replyId", "questionId", "createTime", ServerElements.CONTENT, "messageType", "", "actionId", "jobId", "version", "ext", "Lcom/obric/capabilitykit/common/IMAppActionExt;", "(JLjava/lang/Long;Ljava/lang/String;JLjava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;JJILcom/obric/capabilitykit/common/IMAppActionExt;)V", "action", "Lcom/obric/capabilitykit/common/AppAction;", "getActionId", "()J", "setActionId", "(J)V", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "getCreateTime", "()Ljava/lang/Long;", "setCreateTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getExt", "()Lcom/obric/capabilitykit/common/IMAppActionExt;", "setExt", "(Lcom/obric/capabilitykit/common/IMAppActionExt;)V", "getId", "setId", "getJobId", "setJobId", "getLocalMessageId", "setLocalMessageId", "getMessageId", "setMessageId", "getMessageType", "()Ljava/lang/Integer;", "setMessageType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getQuestionId", "setQuestionId", "getReplyId", "setReplyId", "getVersion", "()I", "setVersion", "(I)V", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(JLjava/lang/Long;Ljava/lang/String;JLjava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;JJILcom/obric/capabilitykit/common/IMAppActionExt;)Lcom/obric/capabilitykit/common/IMAppAction;", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "getAction", "getVersionInfo", "Lcom/obric/capabilitykit/common/VersionInfo;", "hashCode", "toString", "Companion", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class IMAppAction {

    @NotNull
    public static final b Companion = null;

    @NotNull
    private static final String TAG = "IMAppAction";

    @NotNull
    private static final Lazy<Gson> gson$delegate = null;

    @Nullable
    private transient AppAction action;

    @SerializedName(Ext.KEY_ACTION_ID)
    private long actionId;

    @SerializedName(ServerElements.CONTENT)
    @Nullable
    private String content;

    @SerializedName("create_time")
    @JsonAdapter(TimeTransformAdapter.class)
    @Nullable
    private Long createTime;

    @SerializedName("ext")
    @Nullable
    private IMAppActionExt ext;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private long f11252id;

    @SerializedName(Ext.KEY_JOB_ID)
    private long jobId;

    @SerializedName("local_message_id")
    @Nullable
    private String localMessageId;

    @SerializedName("message_id")
    @Nullable
    private Long messageId;

    @SerializedName("message_type")
    @Nullable
    private Integer messageType;

    @SerializedName("question_id")
    @Nullable
    private Long questionId;

    @SerializedName("reply_id")
    private long replyId;

    @SerializedName("version")
    private int version;

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/google/gson/Gson;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a extends Lambda implements Function0<Gson> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f11253a = null;

        static {
            f11253a = new a();
        }

        public a() {
            super(0);
        }

        @NotNull
        public final Gson a() {
            return new Gson();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Gson invoke() {
            return a();
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/obric/capabilitykit/common/IMAppAction$Companion;", "", "()V", "TAG", "", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "gson$delegate", "Lkotlin/Lazy;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b {
        private b() {
        }

        private final Gson a() {
            return (Gson) IMAppAction.access$getGson$delegate$cp().getValue();
        }

        public /* synthetic */ b(DefaultConstructorMarker r10) {
            this();
        }

        public static final /* synthetic */ Gson a(b r10) {
            return r10.a();
        }
    }

    static {
        Companion = new b(null);
        gson$delegate = kotlin.b.b(a.f11253a);
    }

    public IMAppAction() {
        long r10 = 0;
        Long r11 = null;
        String r12 = null;
        long r13 = 0;
        Long r14 = null;
        Long r15 = null;
        String r16 = null;
        Integer r17 = null;
        long r18 = 0;
        long r19 = 0;
        int r110 = 0;
        IMAppActionExt r111 = null;
        this(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, 4095, null);
    }

    public static final /* synthetic */ Lazy access$getGson$delegate$cp() {
        return gson$delegate;
    }

    public static /* synthetic */ IMAppAction copy$default(IMAppAction r16, long r17, Long r19, String r20, long r21, Long r23, Long r24, String r25, Integer r26, long r27, long r29, int r31, IMAppActionExt r32, int r33, Object r34) {
        if ((r33 & 1) == 0) goto L5;
        long r10 = r16.f11252id;
    L7:
        if ((r33 & 2) == 0) goto L9;
        Long r11 = r16.messageId;
    L11:
        if ((r33 & 4) == 0) goto L13;
        String r12 = r16.localMessageId;
    L15:
        if ((r33 & 8) == 0) goto L17;
        long r13 = r16.replyId;
    L19:
        if ((r33 & 16) == 0) goto L21;
        Long r14 = r16.questionId;
    L23:
        if ((r33 & 32) == 0) goto L25;
        Long r15 = r16.createTime;
    L27:
        if ((r33 & 64) == 0) goto L29;
        String r18 = r16.content;
    L31:
        if ((r33 & 128) == 0) goto L33;
        Integer r110 = r16.messageType;
    L35:
        if ((r33 & 256) == 0) goto L37;
        long r111 = r16.actionId;
    L39:
        if ((r33 & 512) == 0) goto L41;
        long r112 = r16.jobId;
    L42:
        long r210 = r112;
        if ((r33 & 1024) == 0) goto L45;
        int r113 = r16.version;
    L47:
        if ((r33 & 2048) == 0) goto L49;
        IMAppActionExt r22 = r16.ext;
    L51:
        return r16.copy(r10, r11, r12, r13, r14, r15, r18, r110, r111, r210, r113, r22);
    L49:
        r22 = r32;
        goto L51
    L45:
        r113 = r31;
        goto L47
    L41:
        r112 = r29;
        goto L42
    L37:
        r111 = r27;
        goto L39
    L33:
        r110 = r26;
        goto L35
    L29:
        r18 = r25;
        goto L31
    L25:
        r15 = r24;
        goto L27
    L21:
        r14 = r23;
        goto L23
    L17:
        r13 = r21;
        goto L19
    L13:
        r12 = r20;
        goto L15
    L9:
        r11 = r19;
        goto L11
    L5:
        r10 = r17;
        goto L7
    }

    public final long component1() {
        return this.f11252id;
    }

    public final long component10() {
        return this.jobId;
    }

    public final int component11() {
        return this.version;
    }

    @Nullable
    public final IMAppActionExt component12() {
        return this.ext;
    }

    @Nullable
    public final Long component2() {
        return this.messageId;
    }

    @Nullable
    public final String component3() {
        return this.localMessageId;
    }

    public final long component4() {
        return this.replyId;
    }

    @Nullable
    public final Long component5() {
        return this.questionId;
    }

    @Nullable
    public final Long component6() {
        return this.createTime;
    }

    @Nullable
    public final String component7() {
        return this.content;
    }

    @Nullable
    public final Integer component8() {
        return this.messageType;
    }

    public final long component9() {
        return this.actionId;
    }

    @NotNull
    public final IMAppAction copy(long r19, @Nullable Long r21, @Nullable String r22, long r23, @Nullable Long r25, @Nullable Long r26, @Nullable String r27, @Nullable Integer r28, long r29, long r31, int r33, @Nullable IMAppActionExt r34) {
        return new IMAppAction(r19, r21, r22, r23, r25, r26, r27, r28, r29, r31, r33, r34);
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof IMAppAction) == true) goto L8;
        return false;
    L8:
        IMAppAction r11 = (IMAppAction) r10;
        if (this.f11252id == r11.f11252id) goto L12;
        return false;
    L12:
        if (kotlin.jvm.internal.q.b(this.messageId, r11.messageId) == true) goto L15;
        return false;
    L15:
        if (kotlin.jvm.internal.q.b(this.localMessageId, r11.localMessageId) == true) goto L18;
        return false;
    L18:
        if (this.replyId == r11.replyId) goto L21;
        return false;
    L21:
        if (kotlin.jvm.internal.q.b(this.questionId, r11.questionId) == true) goto L24;
        return false;
    L24:
        if (kotlin.jvm.internal.q.b(this.createTime, r11.createTime) == true) goto L27;
        return false;
    L27:
        if (kotlin.jvm.internal.q.b(this.content, r11.content) == true) goto L30;
        return false;
    L30:
        if (kotlin.jvm.internal.q.b(this.messageType, r11.messageType) == true) goto L33;
        return false;
    L33:
        if (this.actionId == r11.actionId) goto L36;
        return false;
    L36:
        if (this.jobId == r11.jobId) goto L39;
        return false;
    L39:
        if (this.version == r11.version) goto L42;
        return false;
    L42:
        if (kotlin.jvm.internal.q.b(this.ext, r11.ext) == true) goto L44;
        return false;
    L44:
        return true;
    }

    @NotNull
    public final AppAction getAction() {
        AppAction r10 = this.action;
        if (r10 == null) goto L10;
    L9:
        return r10;
    L10:
        Object r11 = b.a(Companion).fromJson(this.content, AppAction.class);     // Catch: IllegalStateException -> L6
        this.action = (AppAction) r11;     // Catch: IllegalStateException -> L6
        r10 = (AppAction) r11;     // Catch: IllegalStateException -> L6
    L8:
        kotlin.jvm.internal.q.f(r10, "try {\n            gson.f…            }\n\n\n        }");
    L6:
        e = move-exception;
        Log.w(TAG, "AppAction content is illegal", e);
        r10 = new AppAction("", "", "", null, 0, null, null, null, null, null, 1016, null);
        this.action = r10;
        goto L8
    }

    public final long getActionId() {
        return this.actionId;
    }

    @Nullable
    public final String getContent() {
        return this.content;
    }

    @Nullable
    public final Long getCreateTime() {
        return this.createTime;
    }

    @Nullable
    public final IMAppActionExt getExt() {
        return this.ext;
    }

    public final long getId() {
        return this.f11252id;
    }

    public final long getJobId() {
        return this.jobId;
    }

    @Nullable
    public final String getLocalMessageId() {
        return this.localMessageId;
    }

    @Nullable
    public final Long getMessageId() {
        return this.messageId;
    }

    @Nullable
    public final Integer getMessageType() {
        return this.messageType;
    }

    @Nullable
    public final Long getQuestionId() {
        return this.questionId;
    }

    public final long getReplyId() {
        return this.replyId;
    }

    public final int getVersion() {
        return this.version;
    }

    @NotNull
    public final VersionInfo getVersionInfo() {
        Object r10 = b.a(Companion).fromJson(this.content, VersionInfo.class);     // Catch: IllegalStateException -> L4
        kotlin.jvm.internal.q.f(r10, "gson.fromJson(content, VersionInfo::class.java)");     // Catch: IllegalStateException -> L4
        return (VersionInfo) r10;
    L4:
        e = move-exception;
        Log.w(TAG, "AppAction content is illegal", e);
        return new VersionInfo(0);
    }

    public int hashCode() {
        int r10 = Long.hashCode(this.f11252id) * 31;
        Long r11 = this.messageId;
        int r12 = 0;
        if (r11 != null) goto L5;
        int r13 = 0;
    L6:
        int r14 = (r10 + r13) * 31;
        String r15 = this.localMessageId;
        if (r15 != null) goto L9;
        int r16 = 0;
    L10:
        int r17 = (((r14 + r16) * 31) + Long.hashCode(this.replyId)) * 31;
        Long r18 = this.questionId;
        if (r18 != null) goto L13;
        int r19 = 0;
    L14:
        int r20 = (r17 + r19) * 31;
        Long r21 = this.createTime;
        if (r21 != null) goto L17;
        int r22 = 0;
    L18:
        int r23 = (r20 + r22) * 31;
        String r24 = this.content;
        if (r24 != null) goto L21;
        int r25 = 0;
    L22:
        int r26 = (r23 + r25) * 31;
        Integer r27 = this.messageType;
        if (r27 != null) goto L25;
        int r28 = 0;
    L26:
        int r29 = (((((((r26 + r28) * 31) + Long.hashCode(this.actionId)) * 31) + Long.hashCode(this.jobId)) * 31) + Integer.hashCode(this.version)) * 31;
        IMAppActionExt r30 = this.ext;
        if (r30 == null) goto L31;
        r12 = r30.hashCode();
    L31:
        return r29 + r12;
    L25:
        r28 = r27.hashCode();
        goto L26
    L21:
        r25 = r24.hashCode();
        goto L22
    L17:
        r22 = r21.hashCode();
        goto L18
    L13:
        r19 = r18.hashCode();
        goto L14
    L9:
        r16 = r15.hashCode();
        goto L10
    L5:
        r13 = r11.hashCode();
        goto L6
    }

    public final void setActionId(long r10) {
        this.actionId = r10;
    }

    public final void setContent(@Nullable String r10) {
        this.content = r10;
    }

    public final void setCreateTime(@Nullable Long r10) {
        this.createTime = r10;
    }

    public final void setExt(@Nullable IMAppActionExt r10) {
        this.ext = r10;
    }

    public final void setId(long r10) {
        this.f11252id = r10;
    }

    public final void setJobId(long r10) {
        this.jobId = r10;
    }

    public final void setLocalMessageId(@Nullable String r10) {
        this.localMessageId = r10;
    }

    public final void setMessageId(@Nullable Long r10) {
        this.messageId = r10;
    }

    public final void setMessageType(@Nullable Integer r10) {
        this.messageType = r10;
    }

    public final void setQuestionId(@Nullable Long r10) {
        this.questionId = r10;
    }

    public final void setReplyId(long r10) {
        this.replyId = r10;
    }

    public final void setVersion(int r10) {
        this.version = r10;
    }

    @NotNull
    public String toString() {
        return "IMAppAction(id=" + this.f11252id + ", messageId=" + this.messageId + ", localMessageId=" + this.localMessageId + ", replyId=" + this.replyId + ", questionId=" + this.questionId + ", createTime=" + this.createTime + ", content=" + this.content + ", messageType=" + this.messageType + ", actionId=" + this.actionId + ", jobId=" + this.jobId + ", version=" + this.version + ", ext=" + this.ext + ')';
    }

    public IMAppAction(long r10, @Nullable Long r11, @Nullable String r12, long r13, @Nullable Long r14, @Nullable Long r15, @Nullable String r16, @Nullable Integer r17, long r18, long r19, int r110, @Nullable IMAppActionExt r111) {
        this.f11252id = r10;
        this.messageId = r11;
        this.localMessageId = r12;
        this.replyId = r13;
        this.questionId = r14;
        this.createTime = r15;
        this.content = r16;
        this.messageType = r17;
        this.actionId = r18;
        this.jobId = r19;
        this.version = r110;
        this.ext = r111;
    }

    public /* synthetic */ IMAppAction(long r19, Long r21, String r22, long r23, Long r25, Long r26, String r27, Integer r28, long r29, long r31, int r33, IMAppActionExt r34, int r35, DefaultConstructorMarker r36) {
        if ((r35 & 1) == 0) goto L5;
        long r10 = -1;
    L6:
        IMAppActionExt r11 = null;
        if ((r35 & 2) == 0) goto L9;
        Long r12 = null;
    L11:
        if ((r35 & 4) == 0) goto L13;
        String r13 = null;
    L15:
        if ((r35 & 8) == 0) goto L17;
        long r14 = 0;
    L19:
        if ((r35 & 16) == 0) goto L21;
        Long r15 = null;
    L23:
        if ((r35 & 32) == 0) goto L25;
        Long r16 = null;
    L27:
        if ((r35 & 64) == 0) goto L29;
        String r17 = null;
    L30:
        int r18 = 1;
        if ((r35 & 128) == 0) goto L33;
        Integer r110 = 1;
    L35:
        if ((r35 & 256) == 0) goto L37;
        long r111 = -1;
    L39:
        if ((r35 & 512) == 0) goto L41;
        long r112 = -1;
    L43:
        if ((r35 & 1024) != 0) goto L47;
        r18 = r33;
    L47:
        if ((r35 & 2048) != 0) goto L50;
        r11 = r34;
    L50:
        this(r10, r12, r13, r14, r15, r16, r17, r110, r111, r112, r18, r11);
        return;
    L41:
        r112 = r31;
        goto L43
    L37:
        r111 = r29;
        goto L39
    L33:
        r110 = r28;
        goto L35
    L29:
        r17 = r27;
        goto L30
    L25:
        r16 = r26;
        goto L27
    L21:
        r15 = r25;
        goto L23
    L17:
        r14 = r23;
        goto L19
    L13:
        r13 = r22;
        goto L15
    L9:
        r12 = r21;
        goto L11
    L5:
        r10 = r19;
        goto L6
    }
}
