package com.bytedance.android.livesdkapi.depend.model.live.linker;

import am3.g;
import android.text.TextUtils;
import com.byted.cast.common.TeaEventTrack;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.tencent.connect.common.Constants;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.BanUser")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010+\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020\u001fH\u0016J\b\u0010-\u001a\u00020\u0005H\u0016R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR \u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR \u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0007R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0007R\u0014\u0010\u001a\u001a\u00020\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u001f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010 R\u0016\u0010!\u001a\u0004\u0018\u00010\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u0007R\u0016\u0010#\u001a\u0004\u0018\u00010\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\u0007R\u0016\u0010%\u001a\u0004\u0018\u00010\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\u0007R\u001e\u0010'\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001d\"\u0004\b)\u0010*¨\u0006."}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/linker/BanUser;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/IBanUser;", "()V", "_anchorExplain", "", "get_anchorExplain", "()Ljava/lang/String;", "set_anchorExplain", "(Ljava/lang/String;)V", "_audienceExplain", "get_audienceExplain", "set_audienceExplain", "_openUserId", "get_openUserId", "set_openUserId", "_reason", "get_reason", "set_reason", "_url", "get_url", TeaEventTrack.ACTION_DRAMA_SET_URL, "anchorExplain", "getAnchorExplain", "audienceExplain", "getAudienceExplain", "awemeUserId", "", "getAwemeUserId", "()J", "isAnchorLinkBan", "", "()Z", "openUserId", "getOpenUserId", "reason", "getReason", "url", "getUrl", "userId", "getUserId", "setUserId", "(J)V", "isValidAudienceLinkBan", "isAnchor", "toString", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BanUser extends FlexModelBase<IBanUser> implements IBanUser, h {

    @SerializedName("anchor_explain")
    protected String _anchorExplain;

    @SerializedName("audience_explain")
    protected String _audienceExplain;

    @SerializedName(Constants.JumpUrlConstants.URL_KEY_OPENID)
    protected String _openUserId;

    @SerializedName("reason")
    protected String _reason;

    @SerializedName("url")
    protected String _url;

    @SerializedName("user_id")
    protected long userId;

    public BanUser() {
        super(IBanUser.class);
    }

    public String toString() {
        return "BanUser{userId=" + this.userId + ", reason='" + getReason() + "', url='" + getUrl() + "', anchorExplain='" + getAnchorExplain() + "', audienceExplain='" + getAudienceExplain() + "'}";
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.linker.IBanUser
    public boolean isAnchorLinkBan() {
        if (TextUtils.isEmpty(getAnchorExplain()) == true) goto L5;
    L7:
        return false;
    L5:
        if (TextUtils.isEmpty(getAudienceExplain()) == false) goto L7;
        return true;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.linker.IBanUser, com.bytedance.android.livesdkapi.depend.model.live.linker.IBanUserDef
    public String getAnchorExplain() {
        return this._anchorExplain;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.linker.IBanUser, com.bytedance.android.livesdkapi.depend.model.live.linker.IBanUserDef
    public String getAudienceExplain() {
        return this._audienceExplain;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.linker.IBanUser
    public long getAwemeUserId() {
        return this.userId;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.linker.IBanUser
    public String getOpenUserId() {
        return this._openUserId;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.linker.IBanUser, com.bytedance.android.livesdkapi.depend.model.live.linker.IBanUserDef
    public String getReason() {
        return this._reason;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.linker.IBanUser, com.bytedance.android.livesdkapi.depend.model.live.linker.IBanUserDef
    public String getUrl() {
        return this._url;
    }

    public final long getUserId() {
        return this.userId;
    }

    public final String get_anchorExplain() {
        return this._anchorExplain;
    }

    public final String get_audienceExplain() {
        return this._audienceExplain;
    }

    public final String get_openUserId() {
        return this._openUserId;
    }

    public final String get_reason() {
        return this._reason;
    }

    public final String get_url() {
        return this._url;
    }

    public BanUser(g r100) {
        super(IBanUser.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L24;
        g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.userId = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this._reason = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this._url = am3.h.c(r100);
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this._anchorExplain = am3.h.c(r100);
        goto L3
    L14:
        if (r102 != 5) goto L16;
        this._audienceExplain = am3.h.c(r100);
        goto L3
    L16:
        if (r102 != 5000) goto L17;
        this._openUserId = am3.h.c(r100);
        goto L3
    L17:
        am3.h.d(r103, r100);
        goto L3
    L24:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.linker.IBanUser
    public boolean isValidAudienceLinkBan(boolean r100) {
        if (r100 == false) goto L8;
        if (TextUtils.isEmpty(getAnchorExplain()) == false) goto L12;
    L10:
        return false;
    L12:
        return true;
    L8:
        if (TextUtils.isEmpty(getAudienceExplain()) == true) goto L10;
        return true;
    }

    public final void setUserId(long r100) {
        this.userId = r100;
    }

    public final void set_anchorExplain(String r100) {
        this._anchorExplain = r100;
    }

    public final void set_audienceExplain(String r100) {
        this._audienceExplain = r100;
    }

    public final void set_openUserId(String r100) {
        this._openUserId = r100;
    }

    public final void set_reason(String r100) {
        this._reason = r100;
    }

    public final void set_url(String r100) {
        this._url = r100;
    }
}
