package com.bytedance.android.livehostapi.business.depend.livead;

import com.bytedance.android.livesdkapi.app.AppConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/livead/LiveAdConstants;", "", "()V", "cardCount", "", "cardRemove", AppConstants.BUNDLE_DISLIKE, "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveAdConstants {
    public static final LiveAdConstants INSTANCE = null;
    public static final String cardCount = "/aweme/v1/commerce/webcast/card/count/";
    public static final String cardRemove = "/aweme/v1/commerce/webcast/card/remove/all/";
    public static final String dislike = "/api/ad/v1/dislike/";

    private LiveAdConstants() {
    }

    static {
        INSTANCE = new LiveAdConstants();
    }
}
