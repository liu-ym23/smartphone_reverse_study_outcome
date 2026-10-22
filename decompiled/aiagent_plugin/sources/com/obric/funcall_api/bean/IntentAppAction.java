package com.obric.funcall_api.bean;

import android.graphics.Bitmap;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: IntentAppAction.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class IntentAppAction implements Serializable {
    public static final String ACTION_STR_KEY = "IMAppActionStr";
    public static final String BINDER_KEY = "IMAppAction";
    public static final Companion Companion = null;
    private static final String TAG = "IMAppAction";

    @SerializedName("content")
    private String content;

    @SerializedName("create_time")
    private final long createTime;

    @SerializedName("ext")
    private ConcurrentHashMap<String, String> ext;
    private final transient Gson gson;

    @SerializedName(DbHelper.COL_ID)
    private long id;

    @SerializedName("message_id")
    private final long messageId;
    private final int messageType;

    @SerializedName("question_id")
    private final long questionId;

    @SerializedName("screenshot")
    private Bitmap screenshot;

    /* JADX INFO: compiled from: IntentAppAction.kt */
    public static final class Companion {
        public /* synthetic */ Companion(h r1) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public IntentAppAction() {
        this(0, 0, 0, null, null, 0, 0, null, 255, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ IntentAppAction copy$default(IntentAppAction r13, long r14, long r16, long r18, String r20, Bitmap r21, int r22, long r23, ConcurrentHashMap r25, int r26, Object r27) {
        if ((r26 & 1) == 0) goto L5;
        long r2 = r13.messageId;
    L7:
        if ((r26 & 2) == 0) goto L9;
        long r4 = r13.questionId;
    L11:
        if ((r26 & 4) == 0) goto L13;
        long r6 = r13.createTime;
    L15:
        if ((r26 & 8) == 0) goto L17;
        String r8 = r13.content;
    L19:
        if ((r26 & 16) == 0) goto L21;
        Bitmap r9 = r13.screenshot;
    L23:
        if ((r26 & 32) == 0) goto L25;
        int r10 = r13.messageType;
    L27:
        if ((r26 & 64) == 0) goto L29;
        long r11 = r13.id;
    L31:
        if ((r26 & 128) == 0) goto L33;
        ConcurrentHashMap r1 = r13.ext;
    L35:
        return r13.copy(r2, r4, r6, r8, r9, r10, r11, r1);
    L33:
        r1 = r25;
        goto L35
    L29:
        r11 = r23;
        goto L31
    L25:
        r10 = r22;
        goto L27
    L21:
        r9 = r21;
        goto L23
    L17:
        r8 = r20;
        goto L19
    L13:
        r6 = r18;
        goto L15
    L9:
        r4 = r16;
        goto L11
    L5:
        r2 = r14;
        goto L7
    }

    public final long component1() {
        return this.messageId;
    }

    public final long component2() {
        return this.questionId;
    }

    public final long component3() {
        return this.createTime;
    }

    public final String component4() {
        return this.content;
    }

    public final Bitmap component5() {
        return this.screenshot;
    }

    public final int component6() {
        return this.messageType;
    }

    public final long component7() {
        return this.id;
    }

    public final ConcurrentHashMap<String, String> component8() {
        return this.ext;
    }

    public final IntentAppAction copy(long r15, long r17, long r19, String r21, Bitmap r22, int r23, long r24, ConcurrentHashMap<String, String> r26) {
        return new IntentAppAction(r15, r17, r19, r21, r22, r23, r24, r26);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, IntentAppAction.class) == true) goto L8;
        return false;
    L8:
        IntentAppAction r10 = (IntentAppAction) ZeusTransformUtils.preCheckCast(r9, IntentAppAction.class, "com.obric.aiagent.plugin");
        if (this.messageId == r10.messageId) goto L12;
        return false;
    L12:
        if (this.questionId == r10.questionId) goto L15;
        return false;
    L15:
        if (this.createTime == r10.createTime) goto L18;
        return false;
    L18:
        if (o.a(this.content, r10.content) == true) goto L21;
        return false;
    L21:
        if (o.a(this.screenshot, r10.screenshot) == true) goto L24;
        return false;
    L24:
        if (this.messageType == r10.messageType) goto L27;
        return false;
    L27:
        if (this.id == r10.id) goto L30;
        return false;
    L30:
        if (o.a(this.ext, r10.ext) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        int r0 = ((((Long.hashCode(this.messageId) * 31) + Long.hashCode(this.questionId)) * 31) + Long.hashCode(this.createTime)) * 31;
        String r1 = this.content;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Bitmap r5 = this.screenshot;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (((((r4 + r6) * 31) + Integer.hashCode(this.messageType)) * 31) + Long.hashCode(this.id)) * 31;
        ConcurrentHashMap<String, String> r8 = this.ext;
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

    public IntentAppAction(long r1, long r3, long r5, String r7, Bitmap r8, int r9, long r10, ConcurrentHashMap<String, String> r12) {
        this.messageId = r1;
        this.questionId = r3;
        this.createTime = r5;
        this.content = r7;
        this.screenshot = r8;
        this.messageType = r9;
        this.id = r10;
        this.ext = r12;
        this.gson = new Gson();
    }

    public /* synthetic */ IntentAppAction(long r15, long r17, long r19, String r21, Bitmap r22, int r23, long r24, ConcurrentHashMap r26, int r27, h r28) {
        long r2 = -1;
        if ((r27 & 1) == 0) goto L5;
        long r4 = -1;
    L7:
        if ((r27 & 2) == 0) goto L9;
        long r6 = -1;
    L11:
        if ((r27 & 4) == 0) goto L13;
        long r8 = -1;
    L15:
        if ((r27 & 8) == 0) goto L17;
        String r1 = "";
    L18:
        ConcurrentHashMap r11 = null;
        if ((r27 & 16) == 0) goto L21;
        Bitmap r10 = null;
    L23:
        if ((r27 & 32) == 0) goto L25;
        int r12 = 1;
    L27:
        if ((r27 & 64) != 0) goto L31;
        r2 = r24;
    L31:
        if ((r27 & 128) != 0) goto L34;
        r11 = r26;
    L34:
        this(r4, r6, r8, r1, r10, r12, r2, r11);
        return;
    L25:
        r12 = r23;
        goto L27
    L21:
        r10 = r22;
        goto L23
    L17:
        r1 = r21;
        goto L18
    L13:
        r8 = r19;
        goto L15
    L9:
        r6 = r17;
        goto L11
    L5:
        r4 = r15;
        goto L7
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

    public final String getContent() {
        return this.content;
    }

    public final void setContent(String r1) {
        this.content = r1;
    }

    public final Bitmap getScreenshot() {
        return this.screenshot;
    }

    public final void setScreenshot(Bitmap r1) {
        this.screenshot = r1;
    }

    public final int getMessageType() {
        return this.messageType;
    }

    public final long getId() {
        return this.id;
    }

    public final void setId(long r1) {
        this.id = r1;
    }

    public final ConcurrentHashMap<String, String> getExt() {
        return this.ext;
    }

    public final void setExt(ConcurrentHashMap<String, String> r1) {
        this.ext = r1;
    }

    public String toString() {
        return "messageId: " + this.messageId + "; questionId: " + this.questionId + "; createTime: " + this.createTime + "; content: " + this.content + "; messageType: " + this.messageType + "; id: " + this.id + "; ext: " + this.ext;
    }

    public final AppAction getAction() {
        return (AppAction) ZeusTransformUtils.preCheckCast(this.gson.fromJson(this.content, AppAction.class), AppAction.class, "com.obric.aiagent.plugin");
    }

    public final ECAData getECAData() {
        ECAContent r0 = (ECAContent) ZeusTransformUtils.preCheckCast(this.gson.fromJson(this.content, ECAContent.class), ECAContent.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L5;
        String r1 = r0.getEcaData();
    L7:
        return (ECAData) ZeusTransformUtils.preCheckCast(this.gson.fromJson(r1, ECAData.class), ECAData.class, "com.obric.aiagent.plugin");
    L5:
        r1 = null;
        goto L7
    }

    public final Integer getVersion() {
        ECAContent r2 = (ECAContent) ZeusTransformUtils.preCheckCast(this.gson.fromJson(this.content, ECAContent.class), ECAContent.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.getVersion();
    }

    public final ECAData getECAData(String r2) {
        o.e(r2, WsChannelMultiProcessSharedProvider.STRING_TYPE);
        return (ECAData) ZeusTransformUtils.preCheckCast(this.gson.fromJson(r2, ECAData.class), ECAData.class, "com.obric.aiagent.plugin");
    }

    public final ECAContent getECAContent() {
        return (ECAContent) ZeusTransformUtils.preCheckCast(this.gson.fromJson(this.content, ECAContent.class), ECAContent.class, "com.obric.aiagent.plugin");
    }
}
