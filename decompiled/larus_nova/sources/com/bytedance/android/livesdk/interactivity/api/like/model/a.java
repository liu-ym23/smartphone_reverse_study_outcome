package com.bytedance.android.livesdk.interactivity.api.like.model;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes9.dex */
@ProtoMessage("webcast.im.DoubleLikeDetailV2")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0013\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000f¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/like/model/a;", "", "", "doubleFlag", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "setDoubleFlag", "(Z)V", "", "seqId", "J", "c", "()J", "setSeqId", "(J)V", "renewalsNum", "b", "setRenewalsNum", "triggersNum", "d", "setTriggersNum", "<init>", "()V", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a implements h {

    @SerializedName("double_flag")
    protected boolean doubleFlag;

    @SerializedName("renewals_num")
    protected long renewalsNum;

    @SerializedName("seq_id")
    protected long seqId;

    @SerializedName("triggers_num")
    protected long triggersNum;

    public a() {
    }

    public final boolean a() {
        return this.doubleFlag;
    }

    public final long b() {
        return this.renewalsNum;
    }

    public final long c() {
        return this.seqId;
    }

    public final long d() {
        return this.triggersNum;
    }

    public a(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this.doubleFlag = am3.h.a(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.seqId = r100.i();
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.renewalsNum = r100.i();
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this.triggersNum = r100.i();
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
    }
}
