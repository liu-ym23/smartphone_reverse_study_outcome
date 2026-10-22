package com.bytedance.android.live.base.model.data;

import com.amap.api.col.s.ce;
import com.bytedance.android.live.base.annotation.ForMain;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@ForMain
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\b¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/live/base/model/data/b;", "", "", RemoteMessageConst.MSGID, "J", "b", "()J", "setMsgId", "(J)V", "likeCount", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, ce.f26391f, "", "isLike", "Z", "e", "()Z", "f", "(Z)V", "isDislike", "d", "setDislike", "version", "c", "h", "<init>", "()V", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class b implements vh7.h {

    @SerializedName("is_dislike")
    protected boolean isDislike;

    @SerializedName("is_like")
    protected boolean isLike;

    @SerializedName("like_count")
    protected long likeCount;

    @SerializedName("target_msg_id")
    protected long msgId;

    @SerializedName("version")
    protected long version;

    public b() {
    }

    public final long a() {
        return this.likeCount;
    }

    public final long b() {
        return this.msgId;
    }

    public final long c() {
        return this.version;
    }

    public final boolean d() {
        return this.isDislike;
    }

    public final boolean e() {
        return this.isLike;
    }

    public b(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L21;
        if (r102 != 1) goto L8;
        this.msgId = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.likeCount = r100.j();
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.isLike = am3.h.a(r100);
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this.isDislike = am3.h.a(r100);
        goto L3
    L14:
        if (r102 != 5) goto L15;
        this.version = r100.j();
        goto L3
    L15:
        am3.h.e(r100);
        goto L3
    L21:
        r100.d(r101);
    }

    public final void f(boolean r100) {
        this.isLike = r100;
    }

    public final void g(long r100) {
        this.likeCount = r100;
    }

    public final void h(long r100) {
        this.version = r100;
    }
}
