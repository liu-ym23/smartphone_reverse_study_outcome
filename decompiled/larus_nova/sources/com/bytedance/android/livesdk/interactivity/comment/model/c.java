package com.bytedance.android.livesdk.interactivity.comment.model;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes9.dex */
@ProtoMessage("webcast.api.interaction.GetTruthQuestionListResponse.TruthQuestionMeta")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u000fR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R*\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\b\u0010\t\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/model/c;", "", "", "questionId", "J", "b", "()J", "", "questionContent", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "setQuestionContent", "(Ljava/lang/String;)V", "getQuestionContent$annotations", "()V", "<init>", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c implements h {

    @SerializedName("content")
    protected String questionContent;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_QUESTION_ID)
    protected long questionId;

    public c() {
    }

    public final String a() {
        return this.questionContent;
    }

    public final long b() {
        return this.questionId;
    }

    public c(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.questionId = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.questionContent = am3.h.c(r100);
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
    }
}
