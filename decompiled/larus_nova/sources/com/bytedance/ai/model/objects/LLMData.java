package com.bytedance.ai.model.objects;

import android.util.Base64;
import com.android.ttcjpaysdk.base.weboffline.CJPayWebOfflineWorker;
import com.bytedance.ai.utils.f;
import com.bytedance.ai.utils.g;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import m2.a;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010$\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u00108\u001a\u0004\u0018\u00010\u0005R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0007\"\u0004\b\u0019\u0010\tR\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0007\"\u0004\b\u001c\u0010\tR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0007\"\u0004\b\u001f\u0010\tR\u001c\u0010 \u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0007\"\u0004\b\"\u0010\tR\u001c\u0010#\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0007\"\u0004\b%\u0010\tR\u001e\u0010&\u001a\u0004\u0018\u00010'X\u0086\u000e¢\u0006\u0010\n\u0002\u0010,\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001e\u0010-\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b-\u0010\u0013\"\u0004\b.\u0010\u0015R\u001c\u0010/\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0007\"\u0004\b1\u0010\tR(\u00102\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u000103X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107¨\u00069"}, d2 = {"Lcom/bytedance/ai/model/objects/LLMData;", "", "<init>", "()V", "addtionalContext", "", "getAddtionalContext", "()Ljava/lang/String;", "setAddtionalContext", "(Ljava/lang/String;)V", "data", "Lcom/bytedance/ai/model/objects/RealData;", "getData", "()Lcom/bytedance/ai/model/objects/RealData;", "setData", "(Lcom/bytedance/ai/model/objects/RealData;)V", CJPayWebOfflineWorker.CJ_PAY_WEB_OFFLINE_FINISHED, "", "getFinished", "()Ljava/lang/Boolean;", "setFinished", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "targetBotId", "getTargetBotId", "setTargetBotId", RemoteMessageConst.MSGID, "getMsgId", "setMsgId", "conversationID", "getConversationID", "setConversationID", "realJSONData", "getRealJSONData", "setRealJSONData", "fromBotId", "getFromBotId", "setFromBotId", "createTime", "", "getCreateTime", "()Ljava/lang/Long;", "setCreateTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "isSystemAgent", "setSystemAgent", "questionId", "getQuestionId", "setQuestionId", "featureMap", "", "getFeatureMap", "()Ljava/util/Map;", "setFeatureMap", "(Ljava/util/Map;)V", "realPluginParams", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LLMData {
    private String addtionalContext;
    private String conversationID;
    private Long createTime;
    private RealData data;
    private Map<String, String> featureMap;
    private Boolean finished;
    private String fromBotId;
    private Boolean isSystemAgent;
    private String msgId;
    private String questionId;
    private String realJSONData;
    private String targetBotId;

    public final String realPluginParams() {
        Object r100 = null;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L33
        RealData r102 = this.data;     // Catch: Throwable -> L33
        if (r102 == null) goto L6;
        String r103 = r102.getDecodeType();     // Catch: Throwable -> L33
    L8:
        if (Intrinsics.areEqual(r103, "1") == false) goto L27;
        long r104 = System.currentTimeMillis();     // Catch: Throwable -> L33
        RealData r105 = this.data;     // Catch: Throwable -> L33
        if (r105 == null) goto L30;
        String r106 = r105.getPluginParams();     // Catch: Throwable -> L33
        if (r106 == null) goto L30;
        byte[] r107 = Base64.decode(r106, 0);     // Catch: Throwable -> L33
        if (r107 == null) goto L30;
        BufferedReader r108 = new BufferedReader(new InputStreamReader(new GZIPInputStream(new ByteArrayInputStream(r107)), Charsets.UTF_8));     // Catch: Throwable -> L33
        StringBuilder r109 = new StringBuilder();     // Catch: Throwable -> L33
    L41:
        String r110 = r108.readLine();     // Catch: Throwable -> L22
        if (r110 == null) goto L19;
        r109.append(r110);     // Catch: Throwable -> L22
        goto L41
    L19:
        Unit r111 = Unit.INSTANCE;     // Catch: Throwable -> L22
        CloseableKt.closeFinally(r108, null);     // Catch: Throwable -> L33
        g.f37637a.d("WorkerRuntime", "llmData base64+gzip success,  cost=" + (System.currentTimeMillis() - r104));     // Catch: Throwable -> L33
        String r112 = r109.toString();     // Catch: Throwable -> L33
    L31:
        Object r113 = Result.m9449constructorimpl(r112);     // Catch: Throwable -> L33
    L36:
        if (Result.m9455isFailureimpl(r113) == true) goto L40;
        r100 = r113;
    L40:
        return (String) r100;
    L22:
        th = move-exception;
        throw th;     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        CloseableKt.closeFinally(r108, th);     // Catch: Throwable -> L33
        throw th;     // Catch: Throwable -> L33
    L30:
        r112 = null;
        goto L31
    L27:
        RealData r114 = this.data;     // Catch: Throwable -> L33
        if (r114 == null) goto L30;
        r112 = r114.getPluginParams();     // Catch: Throwable -> L33
        goto L31
    L6:
        r103 = null;
    L33:
        th = move-exception;
        Result.Companion r115 = Result.Companion;
        r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L36
    }

    public LLMData() {
        String r100 = this.fromBotId;
        if (r100 == null) goto L14;
        boolean r101 = true;
        if (Intrinsics.areEqual(r100, "SYSTEM_CVS_ID") == false) goto L8;
    L13:
        Boolean r102 = Boolean.valueOf(r101);
    L15:
        this.isSystemAgent = r102;
        return;
    L8:
        if (f.g(r100) == true) goto L10;
    L12:
        r101 = false;
        goto L13
    L10:
        if (a.f511631a.contains(r100) == false) goto L12;
    L14:
        r102 = null;
        goto L15
    }

    public final String getAddtionalContext() {
        return this.addtionalContext;
    }

    public final String getConversationID() {
        return this.conversationID;
    }

    public final Long getCreateTime() {
        return this.createTime;
    }

    public final RealData getData() {
        return this.data;
    }

    public final Map<String, String> getFeatureMap() {
        return this.featureMap;
    }

    public final Boolean getFinished() {
        return this.finished;
    }

    public final String getFromBotId() {
        return this.fromBotId;
    }

    public final String getMsgId() {
        return this.msgId;
    }

    public final String getQuestionId() {
        return this.questionId;
    }

    public final String getRealJSONData() {
        return this.realJSONData;
    }

    public final String getTargetBotId() {
        return this.targetBotId;
    }

    public final Boolean isSystemAgent() {
        return this.isSystemAgent;
    }

    public final void setAddtionalContext(String r100) {
        this.addtionalContext = r100;
    }

    public final void setConversationID(String r100) {
        this.conversationID = r100;
    }

    public final void setCreateTime(Long r100) {
        this.createTime = r100;
    }

    public final void setData(RealData r100) {
        this.data = r100;
    }

    public final void setFeatureMap(Map<String, String> r100) {
        this.featureMap = r100;
    }

    public final void setFinished(Boolean r100) {
        this.finished = r100;
    }

    public final void setFromBotId(String r100) {
        this.fromBotId = r100;
    }

    public final void setMsgId(String r100) {
        this.msgId = r100;
    }

    public final void setQuestionId(String r100) {
        this.questionId = r100;
    }

    public final void setRealJSONData(String r100) {
        this.realJSONData = r100;
    }

    public final void setSystemAgent(Boolean r100) {
        this.isSystemAgent = r100;
    }

    public final void setTargetBotId(String r100) {
        this.targetBotId = r100;
    }
}
