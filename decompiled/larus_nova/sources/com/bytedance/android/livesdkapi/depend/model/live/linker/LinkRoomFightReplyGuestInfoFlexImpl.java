package com.bytedance.android.livesdkapi.depend.model.live.linker;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.tencent.connect.common.Constants;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.CrossRoomLinkReplyGuestInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001b\u0010\u001cR\u001b\u0010\u0006\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\t\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007R\u001b\u0010\u000b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007R+\u0010\u0013\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R+\u0010\u001a\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u00148V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\u0005\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkRoomFightReplyGuestInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkRoomFightReplyGuestInfo;", "", "isLowClientVersion$delegate", "Ljava/lang/Object;", "isLowClientVersion", "()Z", "isNotSupportApp$delegate", "isNotSupportApp", "isSelected$delegate", "isSelected", "", "<set-?>", "userId$delegate", "getUserId", "()J", "setUserId", "(J)V", "userId", "", "openId$delegate", "getOpenId", "()Ljava/lang/String;", "setOpenId", "(Ljava/lang/String;)V", "openId", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkRoomFightReplyGuestInfoFlexImpl extends FlexModelBase<LinkRoomFightReplyGuestInfo> implements LinkRoomFightReplyGuestInfo, h {

    @SerializedName("is_low_client_version")
    protected boolean _$$isLowClientVersion;

    @SerializedName("is_not_support_app")
    protected boolean _$$isNotSupportApp;

    @SerializedName("is_selected")
    protected boolean _$$isSelected;

    @SerializedName(Constants.JumpUrlConstants.URL_KEY_OPENID)
    protected String _$$openId;

    @SerializedName("user_id")
    protected long _$$userId;

    public LinkRoomFightReplyGuestInfoFlexImpl() {
        super(LinkRoomFightReplyGuestInfo.class);
        this._$$isLowClientVersion = false;
        this._$$isNotSupportApp = false;
        this._$$isSelected = false;
        this._$$openId = "";
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.linker.LinkRoomFightReplyGuestInfo
    public final String getOpenId() {
        return this._$$openId;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.linker.LinkRoomFightReplyGuestInfo
    public final long getUserId() {
        return this._$$userId;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.linker.LinkRoomFightReplyGuestInfo
    public final boolean isLowClientVersion() {
        return this._$$isLowClientVersion;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.linker.LinkRoomFightReplyGuestInfo
    public final boolean isNotSupportApp() {
        return this._$$isNotSupportApp;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.linker.LinkRoomFightReplyGuestInfo
    public final boolean isSelected() {
        return this._$$isSelected;
    }

    public LinkRoomFightReplyGuestInfoFlexImpl(g r100) {
        super(LinkRoomFightReplyGuestInfo.class);
        setThreadSafe(false);
        long r101 = r100.c();
        int r102 = 0;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L20;
        g.a r104 = decodeExtensionFields(r103, r100);
        if (r103 != 1) goto L8;
        this._$$userId = r100.j();
        r102 = r102 | 8;
        goto L3
    L8:
        if (r103 != 2) goto L10;
        this._$$isLowClientVersion = am3.h.a(r100);
        r102 = r102 | 1;
        goto L3
    L10:
        if (r103 != 3) goto L11;
        this._$$isSelected = am3.h.a(r100);
        r102 = r102 | 4;
        goto L3
    L11:
        if (r103 != 4) goto L13;
        this._$$isNotSupportApp = am3.h.a(r100);
        r102 = r102 | 2;
        goto L3
    L13:
        if (r103 != 5000) goto L14;
        this._$$openId = am3.h.c(r100);
        goto L3
    L14:
        am3.h.d(r104, r100);
        goto L3
    L20:
        r100.d(r101);
        setThreadSafe(true);
        if ((r102 & 1) != 0) goto L24;
        this._$$isLowClientVersion = false;
    L24:
        if ((r102 & 2) != 0) goto L27;
        this._$$isNotSupportApp = false;
    L27:
        if ((r102 & 4) != 0) goto L30;
        this._$$isSelected = false;
    L30:
        if (this._$$openId != null) goto L51;
        this._$$openId = "";
        return;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.linker.LinkRoomFightReplyGuestInfo
    public final void setOpenId(String r100) {
        this._$$openId = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.linker.LinkRoomFightReplyGuestInfo
    public final void setUserId(long r100) {
        this._$$userId = r100;
    }
}
