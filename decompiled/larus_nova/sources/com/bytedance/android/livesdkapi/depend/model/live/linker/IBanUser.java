package com.bytedance.android.livesdkapi.depend.model.live.linker;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.tencent.connect.common.Constants;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&R\u0014\u0010\t\u001a\u00020\u00068gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u0004\u0018\u00010\n8gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\n8gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\fR\u0016\u0010\u0011\u001a\u0004\u0018\u00010\n8gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\fR\u0016\u0010\u0013\u001a\u0004\u0018\u00010\n8gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\fR\u0016\u0010\u0015\u001a\u0004\u0018\u00010\n8gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\fR\u0014\u0010\u0016\u001a\u00020\u00038&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/linker/IBanUser;", "Lvh7/c;", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/IBanUserDef;", "", "isAnchor", "isValidAudienceLinkBan", "", "getAwemeUserId", "()J", "awemeUserId", "", "getOpenUserId", "()Ljava/lang/String;", "openUserId", "getReason", "reason", "getUrl", "url", "getAnchorExplain", "anchorExplain", "getAudienceExplain", "audienceExplain", "isAnchorLinkBan", "()Z", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IBanUser extends c<IBanUser>, IBanUserDef {
    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "anchor_explain")
    String getAnchorExplain();

    @FieldName(name = "audience_explain")
    String getAudienceExplain();

    @FieldName(name = "user_id")
    long getAwemeUserId();

    @FieldName(name = Constants.JumpUrlConstants.URL_KEY_OPENID)
    String getOpenUserId();

    @FieldName(name = "reason")
    String getReason();

    @FieldName(name = "url")
    String getUrl();

    boolean isAnchorLinkBan();

    boolean isValidAudienceLinkBan(boolean r100);
}
