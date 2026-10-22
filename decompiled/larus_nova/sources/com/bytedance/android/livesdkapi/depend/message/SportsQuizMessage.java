package com.bytedance.android.livesdkapi.depend.message;

import am3.g;
import com.bytedance.android.livesdk.message.model.o0;
import com.bytedance.android.livesdkapi.depend.live.vs.VSConstants;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.im.SportsQuizMessage")
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u001e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/message/SportsQuizMessage;", "Lcom/bytedance/android/livesdk/message/model/o0;", "", "matchId", "Ljava/lang/String;", "", "quizMsgType", "I", "", "Lcom/bytedance/android/livesdkapi/depend/message/SportsQuiz;", "quiz", "Ljava/util/List;", "<init>", "()V", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SportsQuizMessage extends o0 implements h {

    @SerializedName(VSConstants.VS_MATCH_ID)
    public String matchId;

    @SerializedName("quiz")
    public List<SportsQuiz> quiz;

    @SerializedName("quiz_msg_type")
    public int quizMsgType;

    public SportsQuizMessage() {
        this.type = MessageType.SPORTS_QUIZ_MESSAGE;
    }

    public SportsQuizMessage(g r100) {
        this.quiz = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.matchId = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.quizMsgType = r100.i();
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this.quiz.add(new SportsQuiz(r100));
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
        this.type = MessageType.SPORTS_QUIZ_MESSAGE;
    }
}
