package com.bytedance.android.live.base.model.live;

import am3.g;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.x;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.tencent.connect.common.Constants;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes45.dex */
@ProtoMessage("webcast.api.feed.RankRoundBanner.Item.Rank")
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b!\u0010\"R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0018\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u001e\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001d¨\u0006#"}, d2 = {"Lcom/bytedance/android/live/base/model/live/b;", "", "", "_userId", "J", "get_userId", "()J", "set_userId", "(J)V", "", "_openId", "Ljava/lang/String;", "get_openId", "()Ljava/lang/String;", "set_openId", "(Ljava/lang/String;)V", "Lcom/bytedance/android/live/base/model/ImageModel;", "_avatar", "Lcom/bytedance/android/live/base/model/ImageModel;", "get_avatar", "()Lcom/bytedance/android/live/base/model/ImageModel;", "set_avatar", "(Lcom/bytedance/android/live/base/model/ImageModel;)V", "", "_rank", "I", "get_rank", "()I", "set_rank", "(I)V", "_score", "get_score", "set_score", "<init>", "()V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b implements h {

    @SerializedName("user_avatar")
    protected ImageModel _avatar;

    @SerializedName(Constants.JumpUrlConstants.URL_KEY_OPENID)
    protected String _openId;

    @SerializedName("rank")
    protected int _rank;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_SCORE)
    protected int _score;

    @SerializedName("user_id")
    protected long _userId;

    public b() {
    }

    public b(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L21;
        if (r102 != 1) goto L8;
        this._avatar = x.a(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this._score = (int) r100.j();
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this._userId = r100.j();
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this._rank = (int) r100.j();
        goto L3
    L14:
        if (r102 != 5000) goto L15;
        this._openId = am3.h.c(r100);
        goto L3
    L15:
        am3.h.e(r100);
        goto L3
    L21:
        r100.d(r101);
    }
}
