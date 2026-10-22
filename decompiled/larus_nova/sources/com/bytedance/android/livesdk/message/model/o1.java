package com.bytedance.android.livesdk.message.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u001dR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R\"\u0010\u0019\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000f¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/o1;", "", "Lcom/bytedance/android/livesdk/message/model/w2;", "singer", "Lcom/bytedance/android/livesdk/message/model/w2;", "getSinger", "()Lcom/bytedance/android/livesdk/message/model/w2;", "setSinger", "(Lcom/bytedance/android/livesdk/message/model/w2;)V", "", "order", "J", "getOrder", "()J", "setOrder", "(J)V", "", "needApproach", "Z", "getNeedApproach", "()Z", "setNeedApproach", "(Z)V", "isLead", "setLead", com.bytedance.android.ec.core.event.a.KEY_SCORE, "getScore", "setScore", "<init>", "()V", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class o1 implements vh7.h {

    @SerializedName("is_lead")
    protected boolean isLead;

    @SerializedName("need_approach")
    protected boolean needApproach;

    @SerializedName("order")
    protected long order;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_SCORE)
    protected long score;

    @SerializedName("singer")
    protected w2 singer;

    public o1() {
    }

    public o1(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L21;
        if (r102 != 1) goto L8;
        this.singer = new w2(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.order = r100.j();
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.needApproach = am3.h.a(r100);
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this.isLead = am3.h.a(r100);
        goto L3
    L14:
        if (r102 != 5) goto L15;
        this.score = r100.j();
        goto L3
    L15:
        am3.h.e(r100);
        goto L3
    L21:
        r100.d(r101);
    }
}
