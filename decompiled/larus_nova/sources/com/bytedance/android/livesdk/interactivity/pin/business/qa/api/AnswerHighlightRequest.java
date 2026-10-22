package com.bytedance.android.livesdk.interactivity.pin.business.qa.api;

import am3.g;
import com.bytedance.android.live.base.model.user.o0;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: classes9.dex */
@ProtoMessage("webcast.api.room.AnswerHighlightRequest")
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0015\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\"\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u0007R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0007R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0007R\u0016\u0010\u0011\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\rR\u0016\u0010\u0012\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0007R\u0016\u0010\u0013\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\rR\u0016\u0010\u0014\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\rR\u0016\u0010\u0015\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\rR$\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/pin/business/qa/api/AnswerHighlightRequest;", "", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "toRequestFieldMap", "scene", "Ljava/lang/String;", "", ReportConstant.COMMON_ACTION_TYPE, "I", "", "roomId", "J", com.bytedance.android.ec.core.event.a.VALUE_QUESTION, "answer", "nickName", "_commenterId", "_commenterOpenId", "answerId", "questionMsgId", "answerMsgId", "value", "getCommenterId", "()Ljava/lang/String;", "setCommenterId", "(Ljava/lang/String;)V", "commenterId", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnswerHighlightRequest implements h {
    public static final int ACTION_TYPE_EDIT = 3;
    public static final int ACTION_TYPE_NOT_SUPPORT = 0;
    public static final int ACTION_TYPE_SET = 1;
    public static final int ACTION_TYPE_UNSET = 2;
    public static final a Companion = null;

    @SerializedName("commenter_id")
    public long _commenterId;

    @SerializedName("commenter_open_id")
    public String _commenterOpenId;

    @SerializedName("action_type")
    public int actionType;

    @SerializedName("answer")
    public String answer;

    @SerializedName("answer_id")
    public long answerId;

    @SerializedName("answer_msg_id")
    public long answerMsgId;

    @SerializedName("nick_name")
    public String nickName;

    @SerializedName(com.bytedance.android.ec.core.event.a.VALUE_QUESTION)
    public String question;

    @SerializedName("question_msg_id")
    public long questionMsgId;

    @SerializedName("room_id")
    public long roomId;

    @SerializedName("scene")
    public String scene;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public final String getCommenterId() {
        o0.a r100 = o0.f58946a;
        Long r101 = Long.valueOf(this._commenterId);
        String r102 = this._commenterOpenId;
        r100.getClass();
        return o0.a.g(r101, r102);
    }

    public final HashMap<String, String> toRequestFieldMap() {
        HashMap<String, String> r100 = new HashMap();
        String r101 = this.scene;
        if (r101 == null) goto L5;
        String r102 = r100.put("scene", r101);
    L5:
        r100.put("action_type", String.valueOf(this.actionType));
        r100.put("room_id", String.valueOf(this.roomId));
        String r103 = this.question;
        if (r103 == null) goto L8;
        String r104 = r100.put(com.bytedance.android.ec.core.event.a.VALUE_QUESTION, r103);
    L8:
        String r105 = this.answer;
        if (r105 == null) goto L11;
        String r106 = r100.put("answer", r105);
    L11:
        String r107 = this.nickName;
        if (r107 == null) goto L14;
        String r108 = r100.put("nick_name", r107);
    L14:
        r100.put("commenter_id", getCommenterId());
        r100.put("answer_id", String.valueOf(this.answerId));
        r100.put("question_msg_id", String.valueOf(this.questionMsgId));
        r100.put("answer_msg_id", String.valueOf(this.answerMsgId));
        return r100;
    }

    public AnswerHighlightRequest() {
        this._commenterOpenId = "0";
    }

    public AnswerHighlightRequest(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L20;
        if (r102 != 5000) goto L7;
        this._commenterOpenId = am3.h.c(r100);
        goto L3
    L7:
        switch(r102) {
            case 1: goto L18;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L13;
            case 7: goto L12;
            case 8: goto L11;
            case 9: goto L10;
            case 10: goto L9;
            default: goto L8;
        };
    L9:
        this.answerMsgId = r100.j();
        goto L3
    L10:
        this.questionMsgId = r100.j();
        goto L3
    L11:
        this.answerId = r100.j();
        goto L3
    L12:
        this._commenterId = r100.j();
        goto L3
    L13:
        this.nickName = am3.h.c(r100);
        goto L3
    L14:
        this.answer = am3.h.c(r100);
        goto L3
    L15:
        this.question = am3.h.c(r100);
        goto L3
    L16:
        this.roomId = r100.j();
        goto L3
    L17:
        this.actionType = r100.i();
        goto L3
    L18:
        this.scene = am3.h.c(r100);
        goto L3
    L8:
        am3.h.e(r100);
        goto L3
    L20:
        r100.d(r101);
        if (this._commenterOpenId != null) goto L51;
        this._commenterOpenId = "0";
        return;
    }

    public final void setCommenterId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        o0.f58946a.getClass();
        this._commenterId = 0;
        this._commenterOpenId = r100;
    }
}
