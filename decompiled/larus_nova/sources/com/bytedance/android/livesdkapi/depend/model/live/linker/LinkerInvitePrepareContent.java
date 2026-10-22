package com.bytedance.android.livesdkapi.depend.model.live.linker;

import am3.g;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.im.LinkPrepareApplyContent")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001e\u0010\u0013\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR \u0010\u0016\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\u001e\u0010\u0019\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\tR\u0018\u0010\u001c\u001a\u00060\u0005j\u0002`\u001d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0007R\u0016\u0010\u001f\u001a\u0004\u0018\u00010\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010\rR\u0018\u0010!\u001a\u00060\u0005j\u0002`\u001d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u0007R\u0014\u0010#\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\u0007R\u0016\u0010%\u001a\u0004\u0018\u00010\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\rR\u0018\u0010'\u001a\u00060\u0005j\u0002`\u001d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\u0007¨\u0006)"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerInvitePrepareContent;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerInvitePrepareContent;", "()V", "_count", "", "get_count", "()J", "set_count", "(J)V", "_fromOpenId", "", "get_fromOpenId", "()Ljava/lang/String;", "set_fromOpenId", "(Ljava/lang/String;)V", "_fromRoomId", "get_fromRoomId", "set_fromRoomId", "_fromUserId", "get_fromUserId", "set_fromUserId", "_secFromUserId", "get_secFromUserId", "set_secFromUserId", "_vendor", "get_vendor", "set_vendor", "count", "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "getCount", "fromOpenId", "getFromOpenId", "fromRoomId", "getFromRoomId", "fromUserId", "getFromUserId", "secFromUserId", "getSecFromUserId", Constants.OperatorKey.KEY_VENDOR, "getVendor", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LinkerInvitePrepareContent extends FlexModelBase<ILinkerInvitePrepareContent> implements ILinkerInvitePrepareContent, h {

    @SerializedName("count")
    protected long _count;

    @SerializedName("from_open_id")
    protected String _fromOpenId;

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ROOM_ID)
    protected long _fromRoomId;

    @SerializedName("from_user_id")
    protected long _fromUserId;

    @SerializedName("sec_from_user_id")
    protected String _secFromUserId;

    @SerializedName(Constants.OperatorKey.KEY_VENDOR)
    protected long _vendor;

    public LinkerInvitePrepareContent() {
        super(ILinkerInvitePrepareContent.class);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerInvitePrepareContentDef
    public long getCount() {
        return this._count;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerInvitePrepareContent
    public String getFromOpenId() {
        return this._fromOpenId;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerInvitePrepareContentDef
    public long getFromRoomId() {
        return this._fromRoomId;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerInvitePrepareContent
    public long getFromUserId() {
        return this._fromUserId;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerInvitePrepareContentDef
    public String getSecFromUserId() {
        return this._secFromUserId;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerInvitePrepareContentDef
    public long getVendor() {
        return this._vendor;
    }

    public final long get_count() {
        return this._count;
    }

    public final String get_fromOpenId() {
        return this._fromOpenId;
    }

    public final long get_fromRoomId() {
        return this._fromRoomId;
    }

    public final long get_fromUserId() {
        return this._fromUserId;
    }

    public final String get_secFromUserId() {
        return this._secFromUserId;
    }

    public final long get_vendor() {
        return this._vendor;
    }

    public LinkerInvitePrepareContent(g r100) {
        super(ILinkerInvitePrepareContent.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L24;
        g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._fromUserId = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this._fromRoomId = r100.j();
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this._vendor = r100.j();
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this._secFromUserId = am3.h.c(r100);
        goto L3
    L14:
        if (r102 != 5) goto L16;
        this._count = r100.j();
        goto L3
    L16:
        if (r102 != 5000) goto L17;
        this._fromOpenId = am3.h.c(r100);
        goto L3
    L17:
        am3.h.d(r103, r100);
        goto L3
    L24:
        r100.d(r101);
        setThreadSafe(true);
    }

    public final void set_count(long r100) {
        this._count = r100;
    }

    public final void set_fromOpenId(String r100) {
        this._fromOpenId = r100;
    }

    public final void set_fromRoomId(long r100) {
        this._fromRoomId = r100;
    }

    public final void set_fromUserId(long r100) {
        this._fromUserId = r100;
    }

    public final void set_secFromUserId(String r100) {
        this._secFromUserId = r100;
    }

    public final void set_vendor(long r100) {
        this._vendor = r100;
    }
}
