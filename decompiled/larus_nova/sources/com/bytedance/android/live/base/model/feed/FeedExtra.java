package com.bytedance.android.live.base.model.feed;

import am3.g;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoDecode;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.android.tools.pbadapter.annotation.ProtoField;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes45.dex */
@IgnoreProtoFieldCheck
@ProtoMessage("webcast.api.feed.FeedExtra")
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001:\u00015B\u0007¢\u0006\u0004\b3\u00104R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0004R\u0016\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0004R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\nR\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001a\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\rR\u0016\u0010\u001b\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\rR\u0016\u0010\u001c\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u0004R\u0016\u0010\u001d\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\rR\u0016\u0010\u001f\u001a\u00020\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010!\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b!\u0010\nR\u0016\u0010\"\u001a\u00020\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\"\u0010 R\u0018\u0010#\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b#\u0010\nR\u0016\u0010$\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b$\u0010\u0004R\u0016\u0010%\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b%\u0010\rR\u0018\u0010&\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b&\u0010\nR\u0016\u0010'\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b'\u0010\u0004R\u0018\u0010(\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b(\u0010\nR\u0018\u0010)\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b)\u0010\nR\u0018\u0010+\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u001e\u0010.\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010-8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0013\u00102\u001a\u0004\u0018\u00010\u000e8F¢\u0006\u0006\u001a\u0004\b0\u00101¨\u00066"}, d2 = {"Lcom/bytedance/android/live/base/model/feed/FeedExtra;", "Lcom/bytedance/android/live/base/model/Extra;", "", ChameleonOpenTracker.ParamKey.COST, "J", "Lcom/bytedance/android/live/base/model/banner/c;", "rankRoundBanner", "Lcom/bytedance/android/live/base/model/banner/c;", "", "unreadExtra", "Ljava/lang/String;", "", "searchOffset", "I", "Lcom/google/gson/JsonObject;", "jsonLogPb", "Lcom/google/gson/JsonObject;", "Lcom/bytedance/android/live/base/model/feed/FeedExtra$a;", "protoLogPb", "Lcom/bytedance/android/live/base/model/feed/FeedExtra$a;", "maxTime", "minTime", "reqId", "Lcom/bytedance/android/live/base/model/banner/b;", "bannerContainer", "Lcom/bytedance/android/live/base/model/banner/b;", "total", "style", "offset", "offsetType", "", "forbidInterpose", "Z", "aggregateColumnName", "directSort", "satiParamForPitaya", "watchLayer", "isBackup", "userExtraInfo", "followSessionId", "impressionGids", "personalStrategy", "Lcom/bytedance/android/live/base/model/feed/c;", "similarCollectionText", "Lcom/bytedance/android/live/base/model/feed/c;", "", "needPushAnchorIds", "Ljava/util/List;", "getLogPb", "()Lcom/google/gson/JsonObject;", "logPb", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FeedExtra extends Extra implements h {

    @SerializedName("aggregate_column_name")
    public String aggregateColumnName;

    @SerializedName("banner")
    public com.bytedance.android.live.base.model.banner.b bannerContainer;

    @SerializedName(ChameleonOpenTracker.ParamKey.COST)
    public long cost;

    @SerializedName("direct_sort")
    public boolean directSort;

    @SerializedName("follow_session_id")
    public long followSessionId;

    @IgnoreProtoFieldCheck
    @SerializedName("forbid_interpose")
    @IgnoreProtoDecode
    public boolean forbidInterpose;

    @SerializedName("need_impression_gids")
    public String impressionGids;

    @SerializedName("is_backup")
    public int isBackup;

    @SerializedName("log_pb")
    @IgnoreProtoDecode
    private JsonObject jsonLogPb;

    @SerializedName("max_time")
    public long maxTime;

    @SerializedName("min_time")
    public long minTime;

    @SerializedName("need_push_anchor_ids")
    public List<Long> needPushAnchorIds;

    @SerializedName("offset")
    public long offset;

    @SerializedName("offset_type")
    public int offsetType;

    @IgnoreProtoFieldCheck
    @SerializedName("personal_strategy")
    public String personalStrategy;

    @ProtoField("log_pb")
    public transient a protoLogPb;

    @SerializedName("rank_round_banner")
    public com.bytedance.android.live.base.model.banner.c rankRoundBanner;

    @SerializedName("req_id")
    @IgnoreProtoDecode
    public String reqId;

    @SerializedName("sati_param_for_pitaya")
    public String satiParamForPitaya;

    @SerializedName("search_offset")
    public int searchOffset;

    @SerializedName("similar_collection_text")
    public c similarCollectionText;

    @SerializedName("style")
    public int style;

    @SerializedName("total")
    public int total;

    @SerializedName("unread_extra")
    public String unreadExtra;

    @SerializedName("user_extra_info")
    public String userExtraInfo;

    @SerializedName("watch_layer")
    public long watchLayer;

    @ProtoMessage("webcast.api.feed.FeedExtra.LogPb")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/base/model/feed/FeedExtra$a;", "", "", "content", "Ljava/lang/String;", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "<init>", "()V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a implements h {

        @SerializedName("impr_id")
        protected String content;

        public a() {
        }

        public a(g r100) {
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

    public FeedExtra() {
    }

    public final JsonObject getLogPb() {
        if (this.protoLogPb == null) goto L7;
        JsonObject r100 = GsonProtectorUtils.toJsonTree(GsonHelper.get(), this.protoLogPb).getAsJsonObject();
        this.jsonLogPb = r100;
        this.protoLogPb = null;
        return r100;
    L7:
        return this.jsonLogPb;
    }

    public FeedExtra(g r100) {
        this.needPushAnchorIds = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L43;
        if (r102 != 1) goto L8;
        this.protoLogPb = new a(r100);
        goto L3
    L8:
        if (r102 != 27) goto L10;
        this.needPushAnchorIds.add(Long.valueOf(r100.j()));
        goto L3
    L10:
        if (r102 != 33) goto L12;
        this.similarCollectionText = new c(r100);
        goto L3
    L12:
        if (r102 != 5000) goto L14;
        this.searchOffset = (int) r100.j();
        goto L3
    L14:
        if (r102 != 24) goto L16;
        this.impressionGids = am3.h.c(r100);
        goto L3
    L16:
        if (r102 != 25) goto L17;
        this.personalStrategy = am3.h.c(r100);
        goto L3
    L17:
        switch(r102) {
            case 3: goto L36;
            case 4: goto L35;
            case 5: goto L34;
            case 6: goto L33;
            case 7: goto L32;
            case 8: goto L31;
            case 9: goto L30;
            case 10: goto L29;
            case 11: goto L28;
            case 12: goto L27;
            case 13: goto L26;
            case 14: goto L25;
            case 15: goto L24;
            default: goto L18;
        };
    L24:
        this.aggregateColumnName = am3.h.c(r100);
        goto L3
    L25:
        this.offsetType = r100.i();
        goto L3
    L26:
        this.offset = r100.j();
        goto L3
    L27:
        this.style = (int) r100.j();
        goto L3
    L28:
        this.unreadExtra = am3.h.c(r100);
        goto L3
    L29:
        this.rankRoundBanner = new com.bytedance.android.live.base.model.banner.c(r100);
        goto L3
    L30:
        this.bannerContainer = new com.bytedance.android.live.base.model.banner.b(r100);
        goto L3
    L31:
        this.total = (int) r100.j();
        goto L3
    L32:
        this.minTime = r100.j();
        goto L3
    L33:
        this.maxTime = r100.j();
        goto L3
    L34:
        this.cost = r100.j();
        goto L3
    L35:
        this.isBackup = (int) r100.j();
        goto L3
    L36:
        this.hasMore = am3.h.a(r100);
        goto L3
    L18:
        switch(r102) {
            case 17: goto L23;
            case 18: goto L22;
            case 19: goto L21;
            case 20: goto L20;
            default: goto L19;
        };
    L20:
        this.followSessionId = r100.j();
        goto L3
    L21:
        this.userExtraInfo = am3.h.c(r100);
        goto L3
    L22:
        this.satiParamForPitaya = am3.h.c(r100);
        goto L3
    L23:
        this.directSort = am3.h.a(r100);
        goto L3
    L19:
        am3.h.e(r100);
        goto L3
    L43:
        r100.d(r101);
    }
}
