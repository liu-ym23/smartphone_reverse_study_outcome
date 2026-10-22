package com.bytedance.android.livesdkapi.depend.message;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.im.SportsQuiz")
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/message/SportsQuiz;", "", "()V", "betGoldBall", "", "bonus", "endTime", "options", "", "Lcom/bytedance/android/livesdkapi/depend/message/SportsQuizOption;", "quizId", "quizStatus", "", "selectedOption", "title", "", "totalReward", "type", "winOption", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SportsQuiz implements h {

    @SerializedName("bet_gold_ball")
    public long betGoldBall;

    @SerializedName("bonus")
    public long bonus;

    @SerializedName("end_time")
    public long endTime;

    @SerializedName("options")
    public List<SportsQuizOption> options;

    @SerializedName("quiz_id")
    public long quizId;

    @SerializedName("quiz_status")
    public int quizStatus;

    @SerializedName("selected_option")
    public long selectedOption;

    @SerializedName("title")
    public String title;

    @SerializedName("total_reward")
    public long totalReward;

    @SerializedName("type")
    public int type;

    @SerializedName("win_option")
    public long winOption;

    public SportsQuiz() {
    }

    public SportsQuiz(g r100) {
        this.options = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        switch(r102) {
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            case 7: goto L11;
            case 8: goto L10;
            case 9: goto L9;
            case 10: goto L8;
            case 11: goto L7;
            default: goto L6;
        };
    L7:
        this.bonus = r100.j();
        goto L3
    L8:
        this.selectedOption = r100.j();
        goto L3
    L9:
        this.betGoldBall = r100.j();
        goto L3
    L10:
        this.endTime = r100.j();
        goto L3
    L11:
        this.winOption = r100.j();
        goto L3
    L12:
        this.options.add(new SportsQuizOption(r100));
        goto L3
    L13:
        this.totalReward = r100.j();
        goto L3
    L14:
        this.quizStatus = r100.i();
        goto L3
    L15:
        this.type = r100.i();
        goto L3
    L16:
        this.title = am3.h.c(r100);
        goto L3
    L17:
        this.quizId = r100.j();
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
    }
}
