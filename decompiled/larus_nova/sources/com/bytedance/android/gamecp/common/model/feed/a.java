package com.bytedance.android.gamecp.common.model.feed;

import am3.g;
import com.bytedance.android.gamecp.common.model.banner.b;
import com.bytedance.android.gamecp.common.model.banner.c;
import com.bytedance.android.gamecp.host_api.model.network.Extra;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoDecode;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes44.dex */
@IgnoreProtoFieldCheck
@ProtoMessage("webcast.api.feed.FeedExtra")
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0013\b\u0007\u0018\u00002\u00020\u0001:\u0001<B\u0007¢\u0006\u0004\b:\u0010;R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\bR\"\u0010\u001d\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006\"\u0004\b\u001f\u0010\bR$\u0010 \u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u0012\u001a\u0004\b!\u0010\u0014\"\u0004\b\"\u0010\u0016R$\u0010$\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010+\u001a\u00020*8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u00101\u001a\u00020*8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b1\u0010,\u001a\u0004\b2\u0010.\"\u0004\b3\u00100R\"\u00104\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b4\u0010\u0004\u001a\u0004\b5\u0010\u0006\"\u0004\b6\u0010\bR\"\u00107\u001a\u00020*8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b7\u0010,\u001a\u0004\b8\u0010.\"\u0004\b9\u00100¨\u0006="}, d2 = {"Lcom/bytedance/android/gamecp/common/model/feed/a;", "Lcom/bytedance/android/gamecp/host_api/model/network/Extra;", "", ChameleonOpenTracker.ParamKey.COST, "J", "getCost", "()J", "setCost", "(J)V", "Lcom/bytedance/android/gamecp/common/model/banner/c;", "rankRoundBanner", "Lcom/bytedance/android/gamecp/common/model/banner/c;", "getRankRoundBanner", "()Lcom/bytedance/android/gamecp/common/model/banner/c;", "setRankRoundBanner", "(Lcom/bytedance/android/gamecp/common/model/banner/c;)V", "", "unreadExtra", "Ljava/lang/String;", "getUnreadExtra", "()Ljava/lang/String;", "setUnreadExtra", "(Ljava/lang/String;)V", "Lcom/google/gson/JsonObject;", "jsonLogPb", "Lcom/google/gson/JsonObject;", "maxTime", "getMaxTime", "setMaxTime", "minTime", "getMinTime", "setMinTime", "reqId", "getReqId", "setReqId", "Lcom/bytedance/android/gamecp/common/model/banner/b;", "bannerContainer", "Lcom/bytedance/android/gamecp/common/model/banner/b;", "getBannerContainer", "()Lcom/bytedance/android/gamecp/common/model/banner/b;", "setBannerContainer", "(Lcom/bytedance/android/gamecp/common/model/banner/b;)V", "", "total", "I", "getTotal", "()I", "setTotal", "(I)V", "style", "getStyle", "setStyle", "offset", "getOffset", "setOffset", "offsetType", "getOffsetType", "setOffsetType", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a extends Extra implements h {

    @SerializedName("banner")
    protected b bannerContainer;

    @SerializedName(ChameleonOpenTracker.ParamKey.COST)
    protected long cost;

    @SerializedName("log_pb")
    @IgnoreProtoDecode
    private final JsonObject jsonLogPb;

    @SerializedName("max_time")
    protected long maxTime;

    @SerializedName("min_time")
    protected long minTime;

    @SerializedName("offset")
    protected long offset;

    @SerializedName("offset_type")
    protected int offsetType;

    @SerializedName("rank_round_banner")
    protected c rankRoundBanner;

    @SerializedName("req_id")
    @IgnoreProtoDecode
    private String reqId;

    @SerializedName("style")
    protected int style;

    @SerializedName("total")
    protected int total;

    @SerializedName("unread_extra")
    protected String unreadExtra;

    /* JADX INFO: renamed from: com.bytedance.android.gamecp.common.model.feed.a$a, reason: collision with other inner class name */
    @ProtoMessage("webcast.api.feed.FeedExtra.LogPb")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/gamecp/common/model/feed/a$a;", "", "", "content", "Ljava/lang/String;", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "<init>", "()V", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class C0911a implements h {

        @SerializedName("impr_id")
        protected String content;

        public C0911a() {
        }

        public C0911a(g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L9;
            if (r102 != 1) goto L7;
            this.content = am3.h.c(r100);
            goto L3
        L7:
            am3.h.e(r100);
            goto L3
        L9:
            r100.d(r101);
        }
    }

    public a() {
    }

    public a(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L23;
        if (r102 != 1) goto L8;
        new C0911a(r100);
        goto L3
    L8:
        if (r102 != 3) goto L9;
        this.hasMore = am3.h.a(r100);
        goto L3
    L9:
        switch(r102) {
            case 5: goto L20;
            case 6: goto L19;
            case 7: goto L18;
            case 8: goto L17;
            case 9: goto L16;
            case 10: goto L15;
            case 11: goto L14;
            case 12: goto L13;
            case 13: goto L12;
            case 14: goto L11;
            default: goto L10;
        };
    L11:
        this.offsetType = r100.i();
        goto L3
    L12:
        this.offset = r100.j();
        goto L3
    L13:
        this.style = (int) r100.j();
        goto L3
    L14:
        this.unreadExtra = am3.h.c(r100);
        goto L3
    L15:
        this.rankRoundBanner = new c(r100);
        goto L3
    L16:
        this.bannerContainer = new b(r100);
        goto L3
    L17:
        this.total = (int) r100.j();
        goto L3
    L18:
        this.minTime = r100.j();
        goto L3
    L19:
        this.maxTime = r100.j();
        goto L3
    L20:
        this.cost = r100.j();
        goto L3
    L10:
        am3.h.e(r100);
        goto L3
    L23:
        r100.d(r101);
    }
}
