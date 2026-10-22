package com.android.ttcjpaysdk.kmp.common.view.amount;

import com.baidu.platform.comapi.map.MapBundleKey;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/view/amount/ScrollAnimation;", "", "<init>", "()V", "durationMillis", "", MapBundleKey.OfflineMapKey.OFFLINE_RATION, "", "finishEpsilon", "", "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class ScrollAnimation {
    public static final ScrollAnimation INSTANCE = null;
    public static final int durationMillis = 750;
    public static final float finishEpsilon = 0.001f;
    public static final double ratio = 1.2d;

    static {
        INSTANCE = new ScrollAnimation();
    }

    private ScrollAnimation() {
    }
}
