package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.RuleConditionBean;
import java.util.HashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Deprecated(message = "已废弃，卡片结构体见ShelfCardInfo")
@ProtoMessage("webcast.data.CustomizedCardInfo")
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001d\u0010\u001eR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u0007R\u0016\u0010\u000e\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\fR$\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0007R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0007R\u0016\u0010\u0016\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0007R\u0016\u0010\u0017\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0007R\"\u0010\u0018\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0007\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/v1;", "", "", "status", "Ljava/lang/Integer;", "", RuleConditionBean.OPEN_URL_KEY, "Ljava/lang/String;", "", "duration", "Ljava/lang/Long;", "cardType", "I", "content", "source", "J", "punishStatus", "", "startPageQuery", "Ljava/util/Map;", "imExtra", "logExtra", "coverExtra", "appId", "serverTimestamp", "getServerTimestamp", "()Ljava/lang/String;", "setServerTimestamp", "(Ljava/lang/String;)V", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class v1 implements vh7.h {

    @SerializedName("app_id")
    public String appId;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_CARD_TYPE)
    public int cardType;

    @SerializedName("content")
    public String content;

    @SerializedName("cover_extra")
    public String coverExtra;

    @SerializedName("duration")
    public Long duration;

    @SerializedName("im_extra")
    public String imExtra;

    @SerializedName("log_extra")
    public String logExtra;

    @SerializedName("open_url")
    public String openUrl;

    @SerializedName("punish_status")
    public int punishStatus;

    @SerializedName("server_timestamp")
    protected String serverTimestamp;

    @SerializedName("source")
    public long source;

    @SerializedName("start_page_query")
    public Map<String, String> startPageQuery;

    @SerializedName("status")
    public Integer status;

    public v1() {
        this.status = 0;
        this.cardType = 1;
        this.content = "";
        this.source = 1;
        this.coverExtra = "";
        this.appId = "";
        this.serverTimestamp = "";
    }

    public v1(am3.g r110) {
        this.startPageQuery = new HashMap();
        long r100 = r110.c();
        int r101 = 0;
    L3:
        int r102 = r110.f();
        if (r102 == (-1)) goto L36;
        switch(r102) {
            case 1: goto L35;
            case 2: goto L34;
            case 3: goto L33;
            case 4: goto L32;
            case 5: goto L31;
            case 6: goto L30;
            case 7: goto L29;
            default: goto L6;
        };
    L29:
        this.punishStatus = r110.i();
        goto L3
    L30:
        this.source = r110.j();
        r101 = r101 | 2;
        goto L3
    L31:
        this.content = am3.h.c(r110);
        goto L3
    L32:
        this.cardType = r110.i();
        r101 = r101 | 1;
        goto L3
    L33:
        this.duration = Long.valueOf(r110.j());
        goto L3
    L34:
        this.openUrl = am3.h.c(r110);
        goto L3
    L35:
        this.status = Integer.valueOf(r110.i());
        goto L3
    L6:
        switch(r102) {
            case 96: goto L13;
            case 97: goto L12;
            case 98: goto L11;
            case 99: goto L10;
            case 100: goto L9;
            case 101: goto L8;
            default: goto L7;
        };
    L8:
        this.serverTimestamp = am3.h.c(r110);
        goto L3
    L9:
        this.appId = am3.h.c(r110);
        goto L3
    L10:
        this.coverExtra = am3.h.c(r110);
        goto L3
    L11:
        this.logExtra = am3.h.c(r110);
        goto L3
    L12:
        this.imExtra = am3.h.c(r110);
        goto L3
    L13:
        long r103 = r110.c();
        String r104 = null;
        String r111 = null;
    L14:
        int r112 = r110.f();
        if (r112 == (-1)) goto L21;
        if (r112 != 1) goto L17;
        r104 = am3.h.c(r110);
        goto L14
    L17:
        if (r112 != 2) goto L18;
        r111 = am3.h.c(r110);
        goto L14
    L18:
        am3.h.e(r110);
        goto L14
    L21:
        r110.d(r103);
        Map<String, String> r105 = this.startPageQuery;
        if (r104 == null) goto L28;
        if (r111 == null) goto L26;
        r105.put(r104, r111);
        goto L3
    L26:
        throw new IllegalStateException("Value must not be null");
    L28:
        throw new IllegalStateException("Key must not be null");
    L7:
        am3.h.e(r110);
        goto L3
    L36:
        r110.d(r100);
        if (this.status != null) goto L40;
        this.status = 0;
    L40:
        if ((r101 & 1) != 0) goto L43;
        this.cardType = 1;
    L43:
        if (this.content != null) goto L46;
        this.content = "";
    L46:
        if ((r101 & 2) != 0) goto L49;
        this.source = 1;
    L49:
        if (this.coverExtra != null) goto L52;
        this.coverExtra = "";
    L52:
        if (this.appId != null) goto L55;
        this.appId = "";
    L55:
        if (this.serverTimestamp != null) goto L100;
        this.serverTimestamp = "";
        return;
    }
}
