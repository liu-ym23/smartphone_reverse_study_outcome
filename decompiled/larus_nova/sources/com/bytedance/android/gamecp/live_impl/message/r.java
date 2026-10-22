package com.bytedance.android.gamecp.live_impl.message;

import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import com.bytedance.android.livesdkapi.message.ExternalMessageType;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.internal.FlexModelDelegate;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.im.TeamPlayTeamInfoMessage")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0003B\u0007¢\u0006\u0004\bI\u0010JJ\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J-\u0010\f\u001a\u00028\u0000\"\u000e\b\u0000\u0010\t*\b\u0012\u0004\u0012\u00020\u00030\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0016¢\u0006\u0004\b\f\u0010\rJ/\u0010\u000e\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\t*\b\u0012\u0004\u0012\u00020\u00030\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0016¢\u0006\u0004\b\u000e\u0010\rR \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\"\u0010\u0014\u001a\u00020\u00048\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010!\u001a\u00020\u00048\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b!\u0010\u0015\u001a\u0004\b\"\u0010\u0017\"\u0004\b#\u0010\u0019R$\u0010$\u001a\u0004\u0018\u00010\u001a8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b$\u0010\u001c\u001a\u0004\b%\u0010\u001e\"\u0004\b&\u0010 R\"\u0010'\u001a\u00020\u00048\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b'\u0010\u0015\u001a\u0004\b(\u0010\u0017\"\u0004\b)\u0010\u0019R$\u0010+\u001a\u0004\u0018\u00010*8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u00102\u001a\u0002018\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\"\u00108\u001a\u0002018\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b8\u00103\u001a\u0004\b9\u00105\"\u0004\b:\u00107R$\u0010;\u001a\u0004\u0018\u00010\u001a8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b;\u0010\u001c\u001a\u0004\b<\u0010\u001e\"\u0004\b=\u0010 R\"\u0010>\u001a\u00020\u00048\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b>\u0010\u0015\u001a\u0004\b?\u0010\u0017\"\u0004\b@\u0010\u0019R+\u0010H\u001a\u0012\u0012\u0004\u0012\u00020B0Aj\b\u0012\u0004\u0012\u00020B`C8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G¨\u0006K"}, d2 = {"Lcom/bytedance/android/gamecp/live_impl/message/r;", "Lpw/a;", "Lvh7/c$a;", "Lcom/bytedance/kmp/gamecp/base/message/model/b;", "", "getIntType", "Lcom/bytedance/android/livesdkapi/message/ExternalMessageType;", "getExternalMessageType", "Lvh7/e;", "R", "Ljava/lang/Class;", "type", "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/FlexModelDelegate;", "delegate", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/FlexModelDelegate;", "getDelegate", "()Lcom/bytedance/tools/kcp/modelx/runtime/internal/FlexModelDelegate;", "teamSize", "I", "getTeamSize", "()I", "setTeamSize", "(I)V", "", "playId", "Ljava/lang/String;", "getPlayId", "()Ljava/lang/String;", "setPlayId", "(Ljava/lang/String;)V", "status", "getStatus", "setStatus", "toast", "getToast", "setToast", "teamMemberNum", "getTeamMemberNum", "setTeamMemberNum", "Lcom/bytedance/kmp/gamecp/base/message/model/d;", "popup", "Lcom/bytedance/kmp/gamecp/base/message/model/d;", "getPopup", "()Lcom/bytedance/kmp/gamecp/base/message/model/d;", "setPopup", "(Lcom/bytedance/kmp/gamecp/base/message/model/d;)V", "", "anchorId", "J", "getAnchorId", "()J", "setAnchorId", "(J)V", "roomIdLong", "getRoomIdLong", "setRoomIdLong", "promoteGameId", "getPromoteGameId", "setPromoteGameId", "teamJoinMode", "getTeamJoinMode", "setTeamJoinMode", "", "Lcom/bytedance/kmp/gamecp/base/message/model/c;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "memberList$delegate", "Ljava/lang/Object;", "getMemberList", "()Ljava/util/List;", "memberList", "<init>", "()V", "gamecp-live-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class r extends pw.a implements vh7.c.a<com.bytedance.kmp.gamecp.base.message.model.b>, com.bytedance.kmp.gamecp.base.message.model.b, vh7.h {

    @SerializedName("members")
    protected List<com.bytedance.kmp.gamecp.base.message.model.c> _$$memberList;

    @SerializedName("anchor_id")
    protected long anchorId;
    private final transient FlexModelDelegate<com.bytedance.kmp.gamecp.base.message.model.b> delegate;

    @SerializedName(InstantPlayContext.PLAY_ID)
    protected String playId;

    @SerializedName("popup")
    protected com.bytedance.kmp.gamecp.base.message.model.d popup;

    @SerializedName("promote_game_id")
    protected String promoteGameId;

    @SerializedName("room_id")
    protected long roomIdLong;

    @SerializedName("status")
    protected int status;

    @SerializedName("team_join_mode")
    protected int teamJoinMode;

    @SerializedName("team_members_num")
    protected int teamMemberNum;

    @SerializedName("team_size")
    protected int teamSize;

    @SerializedName("toast")
    protected String toast;

    @Override // com.bytedance.android.livesdkapi.message.ExternalBaseMessage, com.bytedance.android.livesdkapi.message.BaseMessage, tlc.d, com.bytedance.android.livesdkapi.message.IExternalLiveMessage
    public int getIntType() {
        return 6014;
    }

    public r() {
        this.delegate = new FlexModelDelegate(com.bytedance.kmp.gamecp.base.message.model.b.class, this);
        this._$$memberList = new ArrayList();
    }

    @Override // com.bytedance.kmp.gamecp.base.message.model.b
    public long getAnchorId() {
        return this.anchorId;
    }

    @Override // vh7.c.a
    public FlexModelDelegate<com.bytedance.kmp.gamecp.base.message.model.b> getDelegate() {
        return this.delegate;
    }

    @Override // com.bytedance.android.livesdkapi.message.IExternalLiveMessage
    public ExternalMessageType getExternalMessageType() {
        return ExternalMessageType.EXTERNAL_GAME_PROMOTE;
    }

    @Override // com.bytedance.kmp.gamecp.base.message.model.b
    public final List<com.bytedance.kmp.gamecp.base.message.model.c> getMemberList() {
        return this._$$memberList;
    }

    @Override // com.bytedance.kmp.gamecp.base.message.model.b
    public String getPlayId() {
        return this.playId;
    }

    @Override // com.bytedance.kmp.gamecp.base.message.model.b
    public com.bytedance.kmp.gamecp.base.message.model.d getPopup() {
        return this.popup;
    }

    @Override // com.bytedance.kmp.gamecp.base.message.model.b
    public String getPromoteGameId() {
        return this.promoteGameId;
    }

    @Override // com.bytedance.kmp.gamecp.base.message.model.b
    public long getRoomIdLong() {
        return this.roomIdLong;
    }

    @Override // com.bytedance.kmp.gamecp.base.message.model.b
    public int getStatus() {
        return this.status;
    }

    @Override // com.bytedance.kmp.gamecp.base.message.model.b
    public int getTeamJoinMode() {
        return this.teamJoinMode;
    }

    @Override // com.bytedance.kmp.gamecp.base.message.model.b
    public int getTeamMemberNum() {
        return this.teamMemberNum;
    }

    @Override // com.bytedance.kmp.gamecp.base.message.model.b
    public int getTeamSize() {
        return this.teamSize;
    }

    @Override // com.bytedance.kmp.gamecp.base.message.model.b
    public String getToast() {
        return this.toast;
    }

    /* JADX WARN: Type inference failed for: r2v9, types: [com.bytedance.kmp.gamecp.base.message.model.d, java.lang.Object] */
    public r(am3.g r100) {
        this._$$memberList = new ArrayList();
        this.delegate = new FlexModelDelegate(com.bytedance.kmp.gamecp.base.message.model.b.class, this);
        getDelegate().setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L20;
        am3.g.a r103 = getDelegate().decodeExtensionFields(r102, r100);
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
            case 12: goto L8;
            default: goto L7;
        };
    L8:
        this.teamJoinMode = r100.i();
        goto L3
    L9:
        this.promoteGameId = am3.h.c(r100);
        goto L3
    L10:
        this.roomIdLong = r100.j();
        goto L3
    L11:
        this.anchorId = r100.j();
        goto L3
    L12:
        this.popup = vh7.f.a(r100, com.bytedance.kmp.gamecp.base.message.model.d.class);
        goto L3
    L13:
        this.teamMemberNum = r100.i();
        goto L3
    L14:
        this.toast = am3.h.c(r100);
        goto L3
    L15:
        this.status = r100.i();
        goto L3
    L16:
        this.playId = am3.h.c(r100);
        goto L3
    L17:
        this.teamSize = r100.i();
        goto L3
    L18:
        this._$$memberList.add((com.bytedance.kmp.gamecp.base.message.model.c) vh7.f.a(r100, com.bytedance.kmp.gamecp.base.message.model.c.class));
        goto L3
    L19:
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L7:
        am3.h.d(r103, r100);
        goto L3
    L20:
        r100.d(r101);
        getDelegate().setThreadSafe(true);
        if (this._$$memberList.isEmpty() == false) goto L52;
        this._$$memberList = new ArrayList();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // vh7.c.a, vh7.c
    public <R extends vh7.e<com.bytedance.kmp.gamecp.base.message.model.b>> R castTo(Class<R> r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        return (R) getDelegate().castTo(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // vh7.c.a, vh7.c
    public <R extends vh7.e<com.bytedance.kmp.gamecp.base.message.model.b>> R castToOrNull(Class<R> r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        return (R) getDelegate().castToOrNull(r100);
    }

    @Override // com.bytedance.kmp.gamecp.base.message.model.b
    public void setAnchorId(long r100) {
        this.anchorId = r100;
    }

    @Override // com.bytedance.kmp.gamecp.base.message.model.b
    public void setPlayId(String r100) {
        this.playId = r100;
    }

    @Override // com.bytedance.kmp.gamecp.base.message.model.b
    public void setPopup(com.bytedance.kmp.gamecp.base.message.model.d r100) {
        this.popup = r100;
    }

    @Override // com.bytedance.kmp.gamecp.base.message.model.b
    public void setPromoteGameId(String r100) {
        this.promoteGameId = r100;
    }

    @Override // com.bytedance.kmp.gamecp.base.message.model.b
    public void setRoomIdLong(long r100) {
        this.roomIdLong = r100;
    }

    @Override // com.bytedance.kmp.gamecp.base.message.model.b
    public void setStatus(int r100) {
        this.status = r100;
    }

    @Override // com.bytedance.kmp.gamecp.base.message.model.b
    public void setTeamJoinMode(int r100) {
        this.teamJoinMode = r100;
    }

    @Override // com.bytedance.kmp.gamecp.base.message.model.b
    public void setTeamMemberNum(int r100) {
        this.teamMemberNum = r100;
    }

    @Override // com.bytedance.kmp.gamecp.base.message.model.b
    public void setTeamSize(int r100) {
        this.teamSize = r100;
    }

    @Override // com.bytedance.kmp.gamecp.base.message.model.b
    public void setToast(String r100) {
        this.toast = r100;
    }
}
