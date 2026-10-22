package com.bytedance.android.livesdk.chatroom.interact.model;

import com.bytedance.android.livesdkapi.depend.model.live.BattleConsecutiveRecordInfo;
import com.bytedance.android.livesdkapi.depend.model.live.BattleRecord;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@ProtoMessage("webcast.api.battle.RecordResponse.ResponseData")
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0019R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/interact/model/j;", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/BattleConsecutiveRecordInfo;", "battleConsecutiveRecordInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/BattleConsecutiveRecordInfo;", "getBattleConsecutiveRecordInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/live/BattleConsecutiveRecordInfo;", "setBattleConsecutiveRecordInfo", "(Lcom/bytedance/android/livesdkapi/depend/model/live/BattleConsecutiveRecordInfo;)V", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/BattleRecord;", "battleRecordList", "Ljava/util/List;", "getBattleRecordList", "()Ljava/util/List;", "setBattleRecordList", "(Ljava/util/List;)V", "", "noRecordTip", "Ljava/lang/String;", "getNoRecordTip", "()Ljava/lang/String;", "setNoRecordTip", "(Ljava/lang/String;)V", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class j implements vh7.h {

    @SerializedName("consecutive_record")
    protected BattleConsecutiveRecordInfo battleConsecutiveRecordInfo;

    @SerializedName("records")
    protected List<BattleRecord> battleRecordList;

    @SerializedName("no_record_tip")
    protected String noRecordTip;

    public j() {
    }

    public j(am3.g r100) {
        this.battleRecordList = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.battleConsecutiveRecordInfo = new BattleConsecutiveRecordInfo(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.battleRecordList.add(new BattleRecord(r100));
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.noRecordTip = am3.h.c(r100);
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
    }
}
