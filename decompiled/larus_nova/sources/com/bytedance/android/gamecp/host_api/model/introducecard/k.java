package com.bytedance.android.gamecp.host_api.model.introducecard;

import com.bytedance.android.livesdkapi.minigame.SeiMessageConst;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.im.GameIntroduceShowMessage")
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001:\u0002\u0014\u0015B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/gamecp/host_api/model/introducecard/k;", "", "", "mIntroduceMessageType", "Ljava/lang/Integer;", "msgType", "Lcom/bytedance/android/gamecp/host_api/model/intruducecard2/a;", BdpAppEventConstant.PARAMS_STRATEGY_NAME, "Lcom/bytedance/android/gamecp/host_api/model/intruducecard2/a;", "", "updatedIntroduce", "Ljava/lang/String;", "Lcom/bytedance/android/gamecp/host_api/model/introducecard/k$a;", "atmosphereContent", "Lcom/bytedance/android/gamecp/host_api/model/introducecard/k$a;", "", "_introduceCardType", "J", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "gamecp-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class k implements vh7.h {

    @SerializedName("introduce_type")
    protected long _introduceCardType;

    @SerializedName("atmosphere_content")
    public a atmosphereContent;

    @SerializedName("type")
    public Integer mIntroduceMessageType;

    @SerializedName(SeiMessageConst.MSG_TYPE)
    public Integer msgType;

    @SerializedName("dispatch_strategy")
    public com.bytedance.android.gamecp.host_api.model.intruducecard2.a strategy;

    @SerializedName("updated_data")
    public String updatedIntroduce;

    @ProtoMessage("webcast.im.AtmosphereContent")
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/android/gamecp/host_api/model/introducecard/k$a;", "", "", "_showDuration", "Ljava/lang/Long;", "", "count", "Ljava/lang/String;", "<init>", "()V", "gamecp-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a implements vh7.h {

        @SerializedName("show_duration")
        protected Long _showDuration;

        @SerializedName("count")
        public String count;

        public final com.bytedance.android.gamecp.host_api.model.introducecard.a a() {
            com.bytedance.android.gamecp.host_api.model.introducecard.a r100 = new com.bytedance.android.gamecp.host_api.model.introducecard.a();
            Long r101 = this._showDuration;
            Long r102 = null;
            if (r101 == null) goto L5;
            Integer r103 = Integer.valueOf((int) r101.longValue());
        L6:
            if (r103 == null) goto L8;
            r102 = Long.valueOf(r103.intValue());
        L8:
            r100._showDuration = r102;
            r100.count = this.count;
            return r100;
        L5:
            r103 = null;
            goto L6
        }

        public a() {
            this._showDuration = 0L;
            this.count = "";
        }

        public a(am3.g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L12;
            if (r102 != 1) goto L8;
            this._showDuration = Long.valueOf(r100.j());
            goto L3
        L8:
            if (r102 != 2) goto L9;
            this.count = am3.h.c(r100);
            goto L3
        L9:
            am3.h.e(r100);
            goto L3
        L12:
            r100.d(r101);
            if (this._showDuration != null) goto L16;
            this._showDuration = 0L;
        L16:
            if (this.count != null) goto L28;
            this.count = "";
            return;
        }
    }

    public static final class b {
    }

    static {
    }

    public final int a() {
        return (int) this._introduceCardType;
    }

    public k() {
        this.mIntroduceMessageType = -1;
        this.msgType = 0;
        this.updatedIntroduce = "";
    }

    public k(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L24;
        if (r102 != 1) goto L8;
        this.mIntroduceMessageType = Integer.valueOf(r100.i());
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.msgType = Integer.valueOf(r100.i());
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.strategy = new com.bytedance.android.gamecp.host_api.model.intruducecard2.a(r100);
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this.updatedIntroduce = am3.h.c(r100);
        goto L3
    L14:
        if (r102 != 5) goto L16;
        this._introduceCardType = r100.j();
        goto L3
    L16:
        if (r102 != 11) goto L17;
        this.atmosphereContent = new a(r100);
        goto L3
    L17:
        am3.h.e(r100);
        goto L3
    L24:
        r100.d(r101);
        if (this.mIntroduceMessageType != null) goto L28;
        this.mIntroduceMessageType = -1;
    L28:
        if (this.msgType != null) goto L31;
        this.msgType = 0;
    L31:
        if (this.updatedIntroduce != null) goto L55;
        this.updatedIntroduce = "";
        return;
    }
}
