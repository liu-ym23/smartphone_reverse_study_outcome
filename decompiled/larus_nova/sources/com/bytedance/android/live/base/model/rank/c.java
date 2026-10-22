package com.bytedance.android.live.base.model.rank;

import am3.g;
import com.alipay.sdk.m.x.d;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.x;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes45.dex */
@ProtoMessage("webcast.api.ranklist.Rank.SimpleRoom")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b&\u0010'R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010 \u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u000b\u001a\u0004\b!\u0010\r\"\u0004\b\"\u0010\u000fR$\u0010#\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010\u001b\u001a\u0004\b$\u0010\u001d\"\u0004\b%\u0010\u001f¨\u0006("}, d2 = {"Lcom/bytedance/android/live/base/model/rank/c;", "", "", "id", "Ljava/lang/Long;", "b", "()Ljava/lang/Long;", "setId", "(Ljava/lang/Long;)V", "", "idStr", "Ljava/lang/String;", "getIdStr", "()Ljava/lang/String;", "setIdStr", "(Ljava/lang/String;)V", "title", "c", d.f25925o, "userCount", "J", "d", "()J", "setUserCount", "(J)V", "Lcom/bytedance/android/live/base/model/ImageModel;", "cover", "Lcom/bytedance/android/live/base/model/ImageModel;", "getCover", "()Lcom/bytedance/android/live/base/model/ImageModel;", "setCover", "(Lcom/bytedance/android/live/base/model/ImageModel;)V", "challengeInfo", "getChallengeInfo", "setChallengeInfo", "contentLabel", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setContentLabel", "<init>", "()V", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c implements h {

    @SerializedName("challenge_info")
    protected String challengeInfo;

    @SerializedName("content_label")
    protected ImageModel contentLabel;

    @SerializedName("cover")
    protected ImageModel cover;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    protected Long f58929id;

    @SerializedName("id_str")
    protected String idStr;

    @SerializedName("title")
    protected String title;

    @SerializedName("user_count")
    protected long userCount;

    public c() {
    }

    public final ImageModel a() {
        return this.contentLabel;
    }

    public final Long b() {
        return this.f58929id;
    }

    public final String c() {
        return this.title;
    }

    public final long d() {
        return this.userCount;
    }

    public c(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L27;
        if (r102 != 1) goto L8;
        this.f58929id = Long.valueOf(r100.j());
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.idStr = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 5) goto L12;
        this.title = am3.h.c(r100);
        goto L3
    L12:
        if (r102 != 6) goto L14;
        this.userCount = r100.j();
        goto L3
    L14:
        if (r102 != 20) goto L16;
        this.cover = x.a(r100);
        goto L3
    L16:
        if (r102 != 110) goto L18;
        this.challengeInfo = am3.h.c(r100);
        goto L3
    L18:
        if (r102 != 118) goto L19;
        this.contentLabel = x.a(r100);
        goto L3
    L19:
        am3.h.e(r100);
        goto L3
    L27:
        r100.d(r101);
    }
}
