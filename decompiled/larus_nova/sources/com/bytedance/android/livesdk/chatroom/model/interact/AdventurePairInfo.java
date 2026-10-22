package com.bytedance.android.livesdk.chatroom.model.interact;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@ProtoMessage("webcast.data.AdventurePairInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\bU\u0010VR\"\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0018\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\"\u0010\u001b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0005\u001a\u0004\b\u001c\u0010\u0007\"\u0004\b\u001d\u0010\tR\"\u0010\u001e\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0005\u001a\u0004\b\u001f\u0010\u0007\"\u0004\b \u0010\tR\"\u0010!\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\u0005\u001a\u0004\b\"\u0010\u0007\"\u0004\b#\u0010\tR$\u0010%\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u0010,\u001a\u00020+8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u00102\u001a\u00020+8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b2\u0010-\u001a\u0004\b3\u0010/\"\u0004\b4\u00101R\"\u00105\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b5\u0010\u0005\u001a\u0004\b6\u0010\u0007\"\u0004\b7\u0010\tR$\u00108\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b8\u0010\f\u001a\u0004\b9\u0010\u000e\"\u0004\b:\u0010\u0010R\u0014\u0010<\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b;\u0010\u0007R\u0016\u0010>\u001a\u0004\u0018\u00010\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b=\u0010\u000eR\u0016\u0010B\u001a\u0004\u0018\u00010?8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b@\u0010AR\u0016\u0010D\u001a\u0004\u0018\u00010?8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bC\u0010AR\u0014\u0010F\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bE\u0010\u0007R\u0014\u0010H\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bG\u0010\u0007R\u0014\u0010J\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bI\u0010\u0007R\u0016\u0010N\u001a\u0004\u0018\u00010K8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bL\u0010MR\u0014\u0010P\u001a\u00020+8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bO\u0010/R\u0014\u0010R\u001a\u00020+8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bQ\u0010/R\u0016\u0010T\u001a\u0004\u0018\u00010\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bS\u0010\u000e¨\u0006W"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/interact/AdventurePairInfo;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/chatroom/model/interact/g;", "", "_pairId", "J", "get_pairId", "()J", "set_pairId", "(J)V", "", "_pairIdStr", "Ljava/lang/String;", "get_pairIdStr", "()Ljava/lang/String;", "set_pairIdStr", "(Ljava/lang/String;)V", "Lcom/bytedance/android/livesdk/chatroom/model/interact/AdventureUserInfo;", "_fromUser", "Lcom/bytedance/android/livesdk/chatroom/model/interact/AdventureUserInfo;", "get_fromUser", "()Lcom/bytedance/android/livesdk/chatroom/model/interact/AdventureUserInfo;", "set_fromUser", "(Lcom/bytedance/android/livesdk/chatroom/model/interact/AdventureUserInfo;)V", "_toUser", "get_toUser", "set_toUser", "_score", "get_score", "set_score", "_nextStageScore", "get_nextStageScore", "set_nextStageScore", "_stageId", "get_stageId", "set_stageId", "Lcom/bytedance/android/livesdk/chatroom/model/interact/AdventureStageInfo;", "_stageInfo", "Lcom/bytedance/android/livesdk/chatroom/model/interact/AdventureStageInfo;", "get_stageInfo", "()Lcom/bytedance/android/livesdk/chatroom/model/interact/AdventureStageInfo;", "set_stageInfo", "(Lcom/bytedance/android/livesdk/chatroom/model/interact/AdventureStageInfo;)V", "", "_pairStatus", "I", "get_pairStatus", "()I", "set_pairStatus", "(I)V", "_callStatus", "get_callStatus", "set_callStatus", "callerUserId", "getCallerUserId", "setCallerUserId", "callerUserOpenId", "getCallerUserOpenId", "setCallerUserOpenId", "getPairId", "pairId", "getPairIdStr", "pairIdStr", "Lcom/bytedance/android/livesdk/chatroom/model/interact/k;", "getFromUser", "()Lcom/bytedance/android/livesdk/chatroom/model/interact/k;", "fromUser", "getToUser", "toUser", "getScore", com.bytedance.android.ec.core.event.a.KEY_SCORE, "getNextStageScore", "nextStageScore", "getStageId", "stageId", "Lcom/bytedance/android/livesdk/chatroom/model/interact/j;", "getStageInfo", "()Lcom/bytedance/android/livesdk/chatroom/model/interact/j;", "stageInfo", "getPairStatus", "pairStatus", "getCallStatus", "callStatus", "getCallerUserIdString", "callerUserIdString", "<init>", "()V", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AdventurePairInfo extends FlexModelBase<g> implements g, vh7.h {

    @SerializedName("call_status")
    protected int _callStatus;

    @SerializedName("from_user")
    protected AdventureUserInfo _fromUser;

    @SerializedName("next_stage_score")
    protected long _nextStageScore;

    @SerializedName("pair_id")
    protected long _pairId;

    @SerializedName("pair_id_str")
    protected String _pairIdStr;

    @SerializedName("pair_status")
    protected int _pairStatus;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_SCORE)
    protected long _score;

    @SerializedName("stage_id")
    protected long _stageId;

    @SerializedName("stage_info")
    protected AdventureStageInfo _stageInfo;

    @SerializedName("to_user")
    protected AdventureUserInfo _toUser;

    @SerializedName("caller_user_id")
    protected long callerUserId;

    @SerializedName("caller_user_open_id")
    protected String callerUserOpenId;

    public AdventurePairInfo() {
        super(g.class);
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.g
    public String getCallerUserIdString() {
        return String.valueOf(this.callerUserId);
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.g
    public int getCallStatus() {
        return this._callStatus;
    }

    public final long getCallerUserId() {
        return this.callerUserId;
    }

    public final String getCallerUserOpenId() {
        return this.callerUserOpenId;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.g
    public k getFromUser() {
        return this._fromUser;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.g
    public long getNextStageScore() {
        return this._nextStageScore;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.g
    public long getPairId() {
        return this._pairId;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.g
    public String getPairIdStr() {
        return this._pairIdStr;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.g
    public int getPairStatus() {
        return this._pairStatus;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.g
    public long getScore() {
        return this._score;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.g
    public long getStageId() {
        return this._stageId;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.g
    public j getStageInfo() {
        return this._stageInfo;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.g
    public k getToUser() {
        return this._toUser;
    }

    public final int get_callStatus() {
        return this._callStatus;
    }

    public final AdventureUserInfo get_fromUser() {
        return this._fromUser;
    }

    public final long get_nextStageScore() {
        return this._nextStageScore;
    }

    public final long get_pairId() {
        return this._pairId;
    }

    public final String get_pairIdStr() {
        return this._pairIdStr;
    }

    public final int get_pairStatus() {
        return this._pairStatus;
    }

    public final long get_score() {
        return this._score;
    }

    public final long get_stageId() {
        return this._stageId;
    }

    public final AdventureStageInfo get_stageInfo() {
        return this._stageInfo;
    }

    public final AdventureUserInfo get_toUser() {
        return this._toUser;
    }

    public AdventurePairInfo(am3.g r100) {
        super(g.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L21;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 5000) goto L7;
        this.callerUserOpenId = am3.h.c(r100);
        goto L3
    L7:
        switch(r102) {
            case 1: goto L19;
            case 2: goto L18;
            case 3: goto L17;
            case 4: goto L16;
            case 5: goto L15;
            case 6: goto L14;
            case 7: goto L13;
            case 8: goto L12;
            case 9: goto L11;
            case 10: goto L10;
            case 11: goto L9;
            default: goto L8;
        };
    L9:
        this._pairIdStr = am3.h.c(r100);
        goto L3
    L10:
        this.callerUserId = r100.j();
        goto L3
    L11:
        this._callStatus = r100.i();
        goto L3
    L12:
        this._pairStatus = r100.i();
        goto L3
    L13:
        this._stageInfo = new AdventureStageInfo(r100);
        goto L3
    L14:
        this._stageId = r100.j();
        goto L3
    L15:
        this._nextStageScore = r100.j();
        goto L3
    L16:
        this._score = r100.j();
        goto L3
    L17:
        this._toUser = new AdventureUserInfo(r100);
        goto L3
    L18:
        this._fromUser = new AdventureUserInfo(r100);
        goto L3
    L19:
        this._pairId = r100.j();
        goto L3
    L8:
        am3.h.d(r103, r100);
        goto L3
    L21:
        r100.d(r101);
        setThreadSafe(true);
    }

    public final void setCallerUserId(long r100) {
        this.callerUserId = r100;
    }

    public final void setCallerUserOpenId(String r100) {
        this.callerUserOpenId = r100;
    }

    public final void set_callStatus(int r100) {
        this._callStatus = r100;
    }

    public final void set_fromUser(AdventureUserInfo r100) {
        this._fromUser = r100;
    }

    public final void set_nextStageScore(long r100) {
        this._nextStageScore = r100;
    }

    public final void set_pairId(long r100) {
        this._pairId = r100;
    }

    public final void set_pairIdStr(String r100) {
        this._pairIdStr = r100;
    }

    public final void set_pairStatus(int r100) {
        this._pairStatus = r100;
    }

    public final void set_score(long r100) {
        this._score = r100;
    }

    public final void set_stageId(long r100) {
        this._stageId = r100;
    }

    public final void set_stageInfo(AdventureStageInfo r100) {
        this._stageInfo = r100;
    }

    public final void set_toUser(AdventureUserInfo r100) {
        this._toUser = r100;
    }
}
