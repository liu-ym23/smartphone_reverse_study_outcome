package com.bytedance.android.livesdk.gift.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R&\u0010\n\u001a\u00060\u0002j\u0002`\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R&\u0010\u000e\u001a\u00060\u0002j\u0002`\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\r\u0010\t\u001a\u0004\b\u000b\u0010\u0005\"\u0004\b\f\u0010\u0007R\"\u0010\u0015\u001a\u00020\u000f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0014\u0010\t\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u001c\u001a\u0004\u0018\u00010\u00168&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001b\u0010\t\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010 \u001a\u0004\u0018\u00010\u00168&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001f\u0010\t\u001a\u0004\b\u001d\u0010\u0018\"\u0004\b\u001e\u0010\u001a¨\u0006!"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/q3;", "Lvh7/c;", "", "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "getRelatedGiftId", "()J", "setRelatedGiftId", "(J)V", "getRelatedGiftId$annotations", "()V", "relatedGiftId", "getOfflineTimeSecond", "setOfflineTimeSecond", "getOfflineTimeSecond$annotations", "offlineTimeSecond", "", "getLeftScores", "()I", "setLeftScores", "(I)V", "getLeftScores$annotations", "leftScores", "", "getEntranceSchemeUrl", "()Ljava/lang/String;", "setEntranceSchemeUrl", "(Ljava/lang/String;)V", "getEntranceSchemeUrl$annotations", "entranceSchemeUrl", "getEntranceSchemeUrlQueryParams", "setEntranceSchemeUrlQueryParams", "getEntranceSchemeUrlQueryParams$annotations", "entranceSchemeUrlQueryParams", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface q3 extends vh7.c<q3> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "entrance_scheme_url")
    String getEntranceSchemeUrl();

    @FieldName(name = "entrance_scheme_url_query_params")
    String getEntranceSchemeUrlQueryParams();

    @FieldName(name = "left_scores")
    int getLeftScores();

    @FieldName(name = "offline_time_second")
    long getOfflineTimeSecond();

    @FieldName(name = "related_gift_id")
    long getRelatedGiftId();

    @FieldName(name = "entrance_scheme_url#setter")
    void setEntranceSchemeUrl(String r100);

    @FieldName(name = "entrance_scheme_url_query_params#setter")
    void setEntranceSchemeUrlQueryParams(String r100);

    @FieldName(name = "left_scores#setter")
    void setLeftScores(int r100);

    @FieldName(name = "offline_time_second#setter")
    void setOfflineTimeSecond(long r100);

    @FieldName(name = "related_gift_id#setter")
    void setRelatedGiftId(long r100);
}
