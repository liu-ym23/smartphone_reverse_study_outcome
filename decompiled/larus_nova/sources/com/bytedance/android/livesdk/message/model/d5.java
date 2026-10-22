package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.GamePlayTeamStatusMessage")
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/d5;", "Lcom/bytedance/android/livesdk/message/model/o0;", "", "Lcom/bytedance/android/livesdk/message/model/di;", "memberList", "Ljava/util/List;", "", "totalNum", "I", "", "playId", "J", "", "toast", "Ljava/lang/String;", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d5 extends o0 implements vh7.h {

    @SerializedName("member_list")
    public List<di> memberList;

    @SerializedName(InstantPlayContext.PLAY_ID)
    public long playId;

    @SerializedName("toast")
    public String toast;

    @SerializedName("total_num")
    public int totalNum;

    public final String toString() {
        StringBuilder r100 = new StringBuilder("GamePlayTeamStatusMessage(memberList=");
        List<di> r101 = this.memberList;
        if (r101 == null) goto L5;
        Integer r102 = Integer.valueOf(r101.size());
    L6:
        r100.append(r102);
        r100.append(", totalNum=");
        r100.append(this.totalNum);
        r100.append(", playId=");
        r100.append(this.playId);
        r100.append(')');
        return r100.toString();
    L5:
        r102 = null;
        goto L6
    }

    public d5() {
        this.type = MessageType.PLAY_TOGETHER_AUDIENCE_CHANGED_MESSAGE;
    }

    public d5(am3.g r100) {
        this.memberList = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L21;
        if (r102 != 1) goto L8;
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.memberList.add(new di(r100));
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.totalNum = r100.i();
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this.playId = r100.j();
        goto L3
    L14:
        if (r102 != 5) goto L15;
        this.toast = am3.h.c(r100);
        goto L3
    L15:
        am3.h.e(r100);
        goto L3
    L21:
        r100.d(r101);
        this.type = MessageType.PLAY_TOGETHER_AUDIENCE_CHANGED_MESSAGE;
    }
}
