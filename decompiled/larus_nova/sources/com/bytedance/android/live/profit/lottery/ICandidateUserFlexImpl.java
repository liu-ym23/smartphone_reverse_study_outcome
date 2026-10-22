package com.bytedance.android.live.profit.lottery;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.sdk.account.platform.api.ITwitterService;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@ProtoMessage("webcast.data.CandidateUser")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\r\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\u000b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R\u001b\u0010\u0010\u001a\u00020\f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0013\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0005\u001a\u0004\b\u0012\u0010\u0007R\u001b\u0010\u0016\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0005\u001a\u0004\b\u0015\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/live/profit/lottery/ICandidateUserFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/profit/lottery/d;", "", "userName$delegate", "Ljava/lang/Object;", "getUserName", "()Ljava/lang/String;", "userName", "avatarUrl$delegate", "getAvatarUrl", "avatarUrl", "", "_userId$delegate", "get_userId", "()J", "_userId", "secUserId$delegate", "getSecUserId", "secUserId", "_userOpenId$delegate", "get_userOpenId", "_userOpenId", "<init>", "()V", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ICandidateUserFlexImpl extends FlexModelBase<d> implements d, vh7.h {

    @SerializedName("user_id")
    protected long _$$_userId;

    @SerializedName("user_open_id")
    protected String _$$_userOpenId;

    @SerializedName("avatar_url")
    protected String _$$avatarUrl;

    @SerializedName("sec_user_id")
    protected String _$$secUserId;

    @SerializedName(ITwitterService.ResponseConstants.USER_NAME)
    protected String _$$userName;

    public ICandidateUserFlexImpl() {
        super(d.class);
        this._$$userName = "";
        this._$$avatarUrl = "";
        this._$$secUserId = "";
        this._$$_userOpenId = "";
    }

    @Override // com.bytedance.android.live.profit.lottery.d
    public final String getAvatarUrl() {
        return this._$$avatarUrl;
    }

    @Override // com.bytedance.android.live.profit.lottery.d
    public final String getSecUserId() {
        return this._$$secUserId;
    }

    @Override // com.bytedance.android.live.profit.lottery.d
    public final String getUserName() {
        return this._$$userName;
    }

    @Override // com.bytedance.android.live.profit.lottery.d
    public final long get_userId() {
        return this._$$_userId;
    }

    @Override // com.bytedance.android.live.profit.lottery.d
    public final String get_userOpenId() {
        return this._$$_userOpenId;
    }

    public ICandidateUserFlexImpl(am3.g r100) {
        super(d.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L21;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._$$_userId = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this._$$userName = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this._$$avatarUrl = am3.h.c(r100);
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this._$$secUserId = am3.h.c(r100);
        goto L3
    L14:
        if (r102 != 5000) goto L15;
        this._$$_userOpenId = am3.h.c(r100);
        goto L3
    L15:
        am3.h.d(r103, r100);
        goto L3
    L21:
        r100.d(r101);
        setThreadSafe(true);
        if (this._$$userName != null) goto L25;
        this._$$userName = "";
    L25:
        if (this._$$avatarUrl != null) goto L28;
        this._$$avatarUrl = "";
    L28:
        if (this._$$secUserId != null) goto L31;
        this._$$secUserId = "";
    L31:
        if (this._$$_userOpenId != null) goto L52;
        this._$$_userOpenId = "";
        return;
    }
}
