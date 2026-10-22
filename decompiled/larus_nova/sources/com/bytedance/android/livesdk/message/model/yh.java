package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b \u0010!R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\bR\"\u0010\u001d\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0015\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019¨\u0006\""}, d2 = {"Lcom/bytedance/android/livesdk/message/model/yh;", "", "", "songId", "J", "getSongId", "()J", "setSongId", "(J)V", "", ReportConstant.COMMON_ACTION_TYPE, "I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()I", "setActionType", "(I)V", "fromUserId", "getFromUserId", "setFromUserId", "", "fromOpenUserId", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "e", "(Ljava/lang/String;)V", "singerId", "getSingerId", "setSingerId", "singerOpenId", "getSingerOpenId", "setSingerOpenId", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class yh implements vh7.h {

    @SerializedName("action_type")
    protected int actionType;

    @IgnoreProtoFieldCheck
    @SerializedName("from_open_user_id")
    private String fromOpenUserId;

    @IgnoreProtoFieldCheck
    @SerializedName("from_user_id")
    protected long fromUserId;

    @IgnoreProtoFieldCheck
    @SerializedName("singer_id")
    protected long singerId;

    @IgnoreProtoFieldCheck
    @SerializedName("singer_open_id")
    protected String singerOpenId;

    @SerializedName("song_id")
    protected long songId;

    public final String c() {
        return com.bytedance.android.livesdk.d9.c(Long.valueOf(this.fromUserId), this.fromOpenUserId);
    }

    public final String d() {
        return com.bytedance.android.livesdk.d9.c(Long.valueOf(this.singerId), this.singerOpenId);
    }

    public yh() {
        this.fromOpenUserId = "";
        this.singerOpenId = "";
    }

    public final int a() {
        return this.actionType;
    }

    public final String b() {
        return this.fromOpenUserId;
    }

    public yh(am3.g r100) {
        this.fromOpenUserId = "";
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L21;
        if (r102 != 1) goto L8;
        this.songId = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.actionType = r100.i();
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.fromUserId = r100.j();
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this.singerId = r100.j();
        goto L3
    L14:
        if (r102 != 5001) goto L15;
        this.singerOpenId = am3.h.c(r100);
        goto L3
    L15:
        am3.h.e(r100);
        goto L3
    L21:
        r100.d(r101);
        if (this.singerOpenId != null) goto L43;
        this.singerOpenId = "";
        return;
    }

    public final void e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.fromOpenUserId = r100;
    }
}
