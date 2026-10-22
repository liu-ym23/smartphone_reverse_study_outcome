package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.UpdateGameScoreMessage")
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001:\u0002\u0012\u0013B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/rm;", "Lcom/bytedance/android/livesdk/message/model/o0;", "", "appId", "Ljava/lang/String;", "", "Lcom/bytedance/android/livesdk/message/model/rm$b;", "gameScores", "Ljava/util/List;", "", "roundId", "J", "", "gameStatus", "I", "msgTimeStamp", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class rm extends o0 implements vh7.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f153697a = 0;

    @SerializedName("app_id")
    public String appId;

    @SerializedName("game_scores")
    public List<b> gameScores;

    @SerializedName("game_status")
    public int gameStatus;

    @SerializedName("msg_time_stamp")
    public long msgTimeStamp;

    @SerializedName("round_id")
    public long roundId;

    public static final class a {
    }

    @ProtoMessage("webcast.im.UpdateGameScoreMessage.GameScoreInfo")
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0004¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/rm$b;", "", "", "joinUid", "Ljava/lang/String;", "", "joinGame", "Z", com.bytedance.android.ec.core.event.a.KEY_SCORE, "joinOpenId", "<init>", "()V", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class b implements vh7.h {

        @SerializedName("join_game")
        public boolean joinGame;

        @SerializedName("join_open_id")
        public String joinOpenId;

        @SerializedName("join_uid")
        public String joinUid;

        @SerializedName(com.bytedance.android.ec.core.event.a.KEY_SCORE)
        public String score;

        public b() {
        }

        public b(am3.g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L18;
            if (r102 != 1) goto L8;
            this.joinUid = am3.h.c(r100);
            goto L3
        L8:
            if (r102 != 2) goto L10;
            this.joinGame = am3.h.a(r100);
            goto L3
        L10:
            if (r102 != 3) goto L12;
            this.score = am3.h.c(r100);
            goto L3
        L12:
            if (r102 != 5000) goto L13;
            this.joinOpenId = am3.h.c(r100);
            goto L3
        L13:
            am3.h.e(r100);
            goto L3
        L18:
            r100.d(r101);
        }
    }

    static {
    }

    public rm() {
        this.type = MessageType.UPDATE_GAME_SCORE_MESSAGE;
    }

    public rm(am3.g r100) {
        this.gameScores = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L13;
        switch(r102) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            default: goto L6;
        };
    L7:
        this.msgTimeStamp = r100.j();
        goto L3
    L8:
        this.gameStatus = r100.i();
        goto L3
    L9:
        this.roundId = r100.j();
        goto L3
    L10:
        this.gameScores.add(new b(r100));
        goto L3
    L11:
        this.appId = am3.h.c(r100);
        goto L3
    L12:
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L13:
        r100.d(r101);
        this.type = MessageType.UPDATE_GAME_SCORE_MESSAGE;
    }
}
