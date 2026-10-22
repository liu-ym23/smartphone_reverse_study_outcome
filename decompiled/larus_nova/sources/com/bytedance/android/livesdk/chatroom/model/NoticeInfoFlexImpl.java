package com.bytedance.android.livesdk.chatroom.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.tencent.connect.common.Constants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@ProtoMessage("webcast.api.linkmic_audience.PrepareInviteResponse.NoticeInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001e\u0010\u001fR+\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR+\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R+\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R+\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u0004\u001a\u00020\u00178V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0006\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/NoticeInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/chatroom/model/NoticeInfo;", "", "<set-?>", "needPush$delegate", "Ljava/lang/Object;", "getNeedPush", "()Z", "setNeedPush", "(Z)V", "needPush", "", "appId$delegate", "getAppId", "()J", "setAppId", "(J)V", "appId", "_userId$delegate", "get_userId", "set_userId", "_userId", "", "_openId$delegate", "get_openId", "()Ljava/lang/String;", "set_openId", "(Ljava/lang/String;)V", "_openId", "<init>", "()V", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class NoticeInfoFlexImpl extends FlexModelBase<NoticeInfo> implements NoticeInfo, vh7.h {

    @SerializedName(Constants.JumpUrlConstants.URL_KEY_OPENID)
    protected String _$$_openId;

    @SerializedName("user_id")
    protected long _$$_userId;

    @SerializedName("app_id")
    protected long _$$appId;

    @SerializedName("need_push")
    protected boolean _$$needPush;

    public NoticeInfoFlexImpl() {
        super(NoticeInfo.class);
        this._$$needPush = false;
        this._$$_openId = "";
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.NoticeInfo
    public final long getAppId() {
        return this._$$appId;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.NoticeInfo
    public final boolean getNeedPush() {
        return this._$$needPush;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.NoticeInfo
    public final String get_openId() {
        return this._$$_openId;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.NoticeInfo
    public final long get_userId() {
        return this._$$_userId;
    }

    public NoticeInfoFlexImpl(am3.g r100) {
        super(NoticeInfo.class);
        setThreadSafe(false);
        long r101 = r100.c();
        int r102 = 0;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L18;
        am3.g.a r104 = decodeExtensionFields(r103, r100);
        if (r103 != 1) goto L8;
        this._$$_userId = r100.j();
        r102 = r102 | 4;
        goto L3
    L8:
        if (r103 != 2) goto L10;
        this._$$needPush = am3.h.a(r100);
        r102 = r102 | 1;
        goto L3
    L10:
        if (r103 != 3) goto L12;
        this._$$appId = r100.j();
        r102 = r102 | 2;
        goto L3
    L12:
        if (r103 != 5000) goto L13;
        this._$$_openId = am3.h.c(r100);
        goto L3
    L13:
        am3.h.d(r104, r100);
        goto L3
    L18:
        r100.d(r101);
        setThreadSafe(true);
        if ((r102 & 1) != 0) goto L22;
        this._$$needPush = false;
    L22:
        if (this._$$_openId != null) goto L40;
        this._$$_openId = "";
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.NoticeInfo
    public final void setAppId(long r100) {
        this._$$appId = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.NoticeInfo
    public final void setNeedPush(boolean r100) {
        this._$$needPush = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.NoticeInfo
    public final void set_openId(String r100) {
        this._$$_openId = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.NoticeInfo
    public final void set_userId(long r100) {
        this._$$_userId = r100;
    }
}
