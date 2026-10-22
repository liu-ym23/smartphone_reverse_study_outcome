package com.bytedance.android.shopping.feed.model;

import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.bytedance.android.ec.model.response.anchorv3.PromotionLogPbData;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import rd3.a;
import rd3.f;
import rd3.l;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/shopping/feed/model/InflowGuessFeedResponse;", "Lcom/bytedance/android/ec/model/api/CommerceBaseResponse;", "", "Lrd3/a;", "feedItemAnchors", "Ljava/util/List;", "getFeedItemAnchors", "()Ljava/util/List;", "Lrd3/l;", "page", "Lrd3/l;", "getPage", "()Lrd3/l;", "Lrd3/f;", "extra", "Lrd3/f;", "getExtra", "()Lrd3/f;", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionLogPbData;", "logPb", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionLogPbData;", "getLogPb", "()Lcom/bytedance/android/ec/model/response/anchorv3/PromotionLogPbData;", "<init>", "()V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InflowGuessFeedResponse extends CommerceBaseResponse {

    @SerializedName("extra")
    private final f extra;

    @SerializedName("feed")
    private final List<a> feedItemAnchors;

    @SerializedName("log_pb")
    private final PromotionLogPbData logPb;

    @SerializedName("page")
    private final l page;

    public InflowGuessFeedResponse() {
        this.feedItemAnchors = CollectionsKt.emptyList();
    }

    public final f getExtra() {
        return this.extra;
    }

    public final List<a> getFeedItemAnchors() {
        return this.feedItemAnchors;
    }

    public final PromotionLogPbData getLogPb() {
        return this.logPb;
    }

    public final l getPage() {
        return this.page;
    }
}
