package com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u00020\u00048\u0002X\u0083D¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0002X\u0083D¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00048\u0002X\u0083D¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/LiveTabliveGuideConfig;", "", "()V", "endPage", "", "innerCard", "useCommonView", "canShowCommonEndPage", "canShowCommonInnerCard", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveTabliveGuideConfig {

    @SerializedName("end_page")
    private final boolean endPage;

    @SerializedName("inner_card")
    private final boolean innerCard;

    @SerializedName("use_common_view")
    private final boolean useCommonView;

    public LiveTabliveGuideConfig() {
    }

    public final boolean canShowCommonEndPage() {
        if (this.useCommonView == true) goto L5;
    L7:
        return false;
    L5:
        if (this.endPage == false) goto L7;
        return true;
    }

    public final boolean canShowCommonInnerCard() {
        if (this.useCommonView == true) goto L5;
    L7:
        return false;
    L5:
        if (this.innerCard == false) goto L7;
        return true;
    }
}
