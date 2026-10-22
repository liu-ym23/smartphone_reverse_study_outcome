package com.bytedance.android.livesdk.message.model.ag;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.StatsParam")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/ag/StatsParam;", "", "()V", "ep_id", "", "getEp_id", "()J", "setEp_id", "(J)V", "r_id", "getR_id", "setR_id", "sec_id", "getSec_id", "setSec_id", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StatsParam implements h {

    @SerializedName("ep_id")
    protected long ep_id;

    @SerializedName("r_id")
    protected long r_id;

    @SerializedName("sec_id")
    protected long sec_id;

    public StatsParam() {
    }

    public final long getEp_id() {
        return this.ep_id;
    }

    public final long getR_id() {
        return this.r_id;
    }

    public final long getSec_id() {
        return this.sec_id;
    }

    public StatsParam(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.ep_id = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.sec_id = r100.j();
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.r_id = r100.j();
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
    }

    public final void setEp_id(long r100) {
        this.ep_id = r100;
    }

    public final void setR_id(long r100) {
        this.r_id = r100;
    }

    public final void setSec_id(long r100) {
        this.sec_id = r100;
    }
}
