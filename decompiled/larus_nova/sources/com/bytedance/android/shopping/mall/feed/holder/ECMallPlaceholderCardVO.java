package com.bytedance.android.shopping.mall.feed.holder;

import com.amap.api.col.s.ce;
import com.bytedance.android.shopping.api.mall.homepage.ECMallDeliveryReduceConfig;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Pair;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bL\u0010MR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0019\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\bR$\u0010!\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0014\u001a\u0004\b\u001f\u0010\u0016\"\u0004\b \u0010\u0018R0\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R0\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012\u0018\u00010\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010$\u001a\u0004\b+\u0010&\"\u0004\b,\u0010(R4\u00101\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010$\u001a\u0004\b/\u0010&\"\u0004\b0\u0010(R0\u00105\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012\u0018\u00010\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u0010$\u001a\u0004\b3\u0010&\"\u0004\b4\u0010(R\"\u0010=\u001a\u0002068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R$\u0010E\u001a\u0004\u0018\u00010>8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR$\u0010F\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bF\u0010\u0004\u001a\u0004\bG\u0010\u0006\"\u0004\bH\u0010\bR$\u0010I\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bI\u0010\u0004\u001a\u0004\bJ\u0010\u0006\"\u0004\bK\u0010\b¨\u0006N"}, d2 = {"Lcom/bytedance/android/shopping/mall/feed/holder/ECMallPlaceholderCardVO;", "Ljava/io/Serializable;", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Ljava/lang/String;", "getDeliverySessionId", "()Ljava/lang/String;", "setDeliverySessionId", "(Ljava/lang/String;)V", "deliverySessionId", "", "b", "Ljava/lang/Integer;", "getBackgroundResId", "()Ljava/lang/Integer;", "setBackgroundResId", "(Ljava/lang/Integer;)V", "backgroundResId", "", "c", "Ljava/lang/Float;", "getBackgroundResIdRatio", "()Ljava/lang/Float;", "setBackgroundResIdRatio", "(Ljava/lang/Float;)V", "backgroundResIdRatio", "d", "getBackgroundUrl", "setBackgroundUrl", "backgroundUrl", "e", "getBackgroundUrlRatio", "setBackgroundUrlRatio", "backgroundUrlRatio", "Lkotlin/Pair;", "f", "Lkotlin/Pair;", "getBackgroundResIdPair", "()Lkotlin/Pair;", "setBackgroundResIdPair", "(Lkotlin/Pair;)V", "backgroundResIdPair", ce.f26391f, "getBackgroundResIdRatioPair", "setBackgroundResIdRatioPair", "backgroundResIdRatioPair", "h", "getBackgroundUrlPair", "setBackgroundUrlPair", "backgroundUrlPair", RXScreenCaptureService.KEY_INDEX, "getBackgroundUrlRatioPair", "setBackgroundUrlRatioPair", "backgroundUrlRatioPair", "", ce.f26395j, "Z", "getShouldNotifyDelivery", "()Z", "setShouldNotifyDelivery", "(Z)V", "shouldNotifyDelivery", "Lcom/bytedance/android/shopping/api/mall/homepage/ECMallDeliveryReduceConfig;", ce.f26396k, "Lcom/bytedance/android/shopping/api/mall/homepage/ECMallDeliveryReduceConfig;", "getReduceConfig", "()Lcom/bytedance/android/shopping/api/mall/homepage/ECMallDeliveryReduceConfig;", "setReduceConfig", "(Lcom/bytedance/android/shopping/api/mall/homepage/ECMallDeliveryReduceConfig;)V", "reduceConfig", "cover", "getCover", "setCover", "schema", "getSchema", "setSchema", "<init>", "()V", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECMallPlaceholderCardVO implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient String f177050a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient Integer f177051b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient Float f177052c;

    @SerializedName("cover")
    private String cover;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public transient String f177053d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public transient Float f177054e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public transient Pair<Integer, Integer> f177055f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public transient Pair<Float, Float> f177056g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public transient Pair<String, String> f177057h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public transient Pair<Float, Float> f177058i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public transient boolean f177059j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public transient ECMallDeliveryReduceConfig f177060k;

    @SerializedName("schema")
    private String schema;

    public ECMallPlaceholderCardVO() {
    }

    public final Integer getBackgroundResId() {
        return this.f177051b;
    }

    public final Pair<Integer, Integer> getBackgroundResIdPair() {
        return this.f177055f;
    }

    public final Float getBackgroundResIdRatio() {
        return this.f177052c;
    }

    public final Pair<Float, Float> getBackgroundResIdRatioPair() {
        return this.f177056g;
    }

    public final String getBackgroundUrl() {
        return this.f177053d;
    }

    public final Pair<String, String> getBackgroundUrlPair() {
        return this.f177057h;
    }

    public final Float getBackgroundUrlRatio() {
        return this.f177054e;
    }

    public final Pair<Float, Float> getBackgroundUrlRatioPair() {
        return this.f177058i;
    }

    public final String getCover() {
        return this.cover;
    }

    public final String getDeliverySessionId() {
        return this.f177050a;
    }

    public final ECMallDeliveryReduceConfig getReduceConfig() {
        return this.f177060k;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final boolean getShouldNotifyDelivery() {
        return this.f177059j;
    }

    public final void setBackgroundResId(Integer r100) {
        this.f177051b = r100;
    }

    public final void setBackgroundResIdPair(Pair<Integer, Integer> r100) {
        this.f177055f = r100;
    }

    public final void setBackgroundResIdRatio(Float r100) {
        this.f177052c = r100;
    }

    public final void setBackgroundResIdRatioPair(Pair<Float, Float> r100) {
        this.f177056g = r100;
    }

    public final void setBackgroundUrl(String r100) {
        this.f177053d = r100;
    }

    public final void setBackgroundUrlPair(Pair<String, String> r100) {
        this.f177057h = r100;
    }

    public final void setBackgroundUrlRatio(Float r100) {
        this.f177054e = r100;
    }

    public final void setBackgroundUrlRatioPair(Pair<Float, Float> r100) {
        this.f177058i = r100;
    }

    public final void setCover(String r100) {
        this.cover = r100;
    }

    public final void setDeliverySessionId(String r100) {
        this.f177050a = r100;
    }

    public final void setReduceConfig(ECMallDeliveryReduceConfig r100) {
        this.f177060k = r100;
    }

    public final void setSchema(String r100) {
        this.schema = r100;
    }

    public final void setShouldNotifyDelivery(boolean r100) {
        this.f177059j = r100;
    }
}
