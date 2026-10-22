package com.bytedance.android.livesdkapi.banner;

import android.content.Context;
import com.bytedance.android.livesdk.gift.model.b1;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH&¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdkapi/banner/IBannerManager;", "", "", "roomId", "", "bannerPosition", "Lio/reactivex/Observable;", "Lcom/bytedance/android/livesdkapi/banner/BannerData;", "observeBanner", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/bytedance/android/livesdk/gift/model/b1;", "banner", "", "bannerClick", "livedynamic-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IBannerManager {
    void bannerClick(Context r100, b1 r101);

    Observable<BannerData> observeBanner(long r100, int r101);
}
