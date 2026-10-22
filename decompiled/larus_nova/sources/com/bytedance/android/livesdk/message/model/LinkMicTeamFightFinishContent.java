package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.LinkmicTeamfightFinishContent")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u001c\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b9\u0010:J\b\u0010\u0004\u001a\u00020\u0003H\u0016R$\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\"\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0016\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001c\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\"\u0010 \u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R$\u0010&\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010\u0006\u001a\u0004\b'\u0010\b\"\u0004\b(\u0010\nR(\u0010,\u001a\u0004\u0018\u00010\u00032\b\u0010)\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b*\u0010\b\"\u0004\b+\u0010\nR\u0016\u0010.\u001a\u0004\u0018\u00010\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b-\u0010\bR$\u00101\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020\u000e8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b/\u0010\u0012\"\u0004\b0\u0010\u0014R\u0014\u00103\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b2\u0010\u0019R\u0016\u00105\u001a\u0004\u0018\u00010\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b4\u0010\bR$\u00108\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020\u001f8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b6\u0010#\"\u0004\b7\u0010%¨\u0006;"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/LinkMicTeamFightFinishContent;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/base/model/message/o2;", "", "toString", "_finishToast", "Ljava/lang/String;", "get_finishToast", "()Ljava/lang/String;", "set_finishToast", "(Ljava/lang/String;)V", "_guestFinishToast", "get_guestFinishToast", "set_guestFinishToast", "", "_finishReason", "I", "get_finishReason", "()I", "set_finishReason", "(I)V", "", "_finishRoomId", "J", "get_finishRoomId", "()J", "set_finishRoomId", "(J)V", "finishUserId", "getFinishUserId", "setFinishUserId", "", "_needToast", "Z", "get_needToast", "()Z", "set_needToast", "(Z)V", "finishOpenId", "getFinishOpenId", "setFinishOpenId", "value", "getFinishToast", "setFinishToast", "finishToast", "getGuestFinishToast", "guestFinishToast", "getFinishReason", "setFinishReason", "finishReason", "getFinishRoomId", "finishRoomId", "getFinishUserIdString", "finishUserIdString", "getNeedToast", "setNeedToast", "needToast", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LinkMicTeamFightFinishContent extends FlexModelBase<com.bytedance.android.live.base.model.message.o2> implements com.bytedance.android.live.base.model.message.o2, vh7.h {

    @SerializedName("reason")
    protected int _finishReason;

    @SerializedName("finish_room_id")
    protected long _finishRoomId;

    @SerializedName("finish_toast")
    protected String _finishToast;

    @SerializedName("guest_finish_toast")
    protected String _guestFinishToast;
    private transient boolean _needToast;

    @SerializedName("finish_open_id")
    protected String finishOpenId;

    @SerializedName("finish_user_id")
    protected long finishUserId;

    public LinkMicTeamFightFinishContent() {
        super(com.bytedance.android.live.base.model.message.o2.class);
        this._needToast = true;
    }

    @Override // com.bytedance.android.live.base.model.message.o2
    public String getFinishUserIdString() {
        com.bytedance.android.live.base.model.user.o0.a r100 = com.bytedance.android.live.base.model.user.o0.f58946a;
        Long r101 = Long.valueOf(this.finishUserId);
        String r102 = this.finishOpenId;
        r100.getClass();
        return com.bytedance.android.live.base.model.user.o0.a.g(r101, r102);
    }

    public String toString() {
        return "FinishContent{finish_user_id='" + getFinishUserIdString() + "'toast='" + getFinishToast() + "', guestToast='" + getGuestFinishToast() + "', reason=" + getFinishReason() + '}';
    }

    public final String getFinishOpenId() {
        return this.finishOpenId;
    }

    @Override // com.bytedance.android.live.base.model.message.o2
    public int getFinishReason() {
        return this._finishReason;
    }

    @Override // com.bytedance.android.live.base.model.message.o2
    public long getFinishRoomId() {
        return this._finishRoomId;
    }

    @Override // com.bytedance.android.live.base.model.message.o2
    public String getFinishToast() {
        return this._finishToast;
    }

    public final long getFinishUserId() {
        return this.finishUserId;
    }

    @Override // com.bytedance.android.live.base.model.message.o2
    public String getGuestFinishToast() {
        return this._guestFinishToast;
    }

    @Override // com.bytedance.android.live.base.model.message.o2
    public boolean getNeedToast() {
        return this._needToast;
    }

    public final int get_finishReason() {
        return this._finishReason;
    }

    public final long get_finishRoomId() {
        return this._finishRoomId;
    }

    public final String get_finishToast() {
        return this._finishToast;
    }

    public final String get_guestFinishToast() {
        return this._guestFinishToast;
    }

    public final boolean get_needToast() {
        return this._needToast;
    }

    public LinkMicTeamFightFinishContent(am3.g r100) {
        super(com.bytedance.android.live.base.model.message.o2.class);
        this._needToast = true;
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L24;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._finishToast = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this._guestFinishToast = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this._finishReason = r100.i();
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this._finishRoomId = r100.j();
        goto L3
    L14:
        if (r102 != 5) goto L16;
        this.finishUserId = r100.j();
        goto L3
    L16:
        if (r102 != 5000) goto L17;
        this.finishOpenId = am3.h.c(r100);
        goto L3
    L17:
        am3.h.d(r103, r100);
        goto L3
    L24:
        r100.d(r101);
        setThreadSafe(true);
    }

    public final void setFinishOpenId(String r100) {
        this.finishOpenId = r100;
    }

    @Override // com.bytedance.android.live.base.model.message.o2
    public void setFinishReason(int r100) {
        this._finishReason = r100;
    }

    @Override // com.bytedance.android.live.base.model.message.o2
    public void setFinishToast(String r100) {
        this._finishToast = r100;
    }

    public final void setFinishUserId(long r100) {
        this.finishUserId = r100;
    }

    @Override // com.bytedance.android.live.base.model.message.o2
    public void setNeedToast(boolean r100) {
        this._needToast = r100;
    }

    public final void set_finishReason(int r100) {
        this._finishReason = r100;
    }

    public final void set_finishRoomId(long r100) {
        this._finishRoomId = r100;
    }

    public final void set_finishToast(String r100) {
        this._finishToast = r100;
    }

    public final void set_guestFinishToast(String r100) {
        this._guestFinishToast = r100;
    }

    public final void set_needToast(boolean r100) {
        this._needToast = r100;
    }
}
