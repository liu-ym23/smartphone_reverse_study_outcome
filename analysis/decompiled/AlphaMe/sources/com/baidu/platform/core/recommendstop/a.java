package com.baidu.platform.core.recommendstop;

import com.baidu.mapapi.search.recommendstop.OnGetRecommendStopResultListener;
import com.baidu.mapapi.search.recommendstop.RecommendStopSearchOption;
import com.baidu.platform.base.SearchType;

/* loaded from: classes.dex */
public class a extends com.baidu.platform.base.a implements IRecommendStop {

    /* renamed from: g, reason: collision with root package name */
    private OnGetRecommendStopResultListener f9387g = null;

    @Override // com.baidu.platform.core.recommendstop.IRecommendStop
    public void destroy() {
        this.f8564c.lock();
        this.f9387g = null;
        this.f8564c.unlock();
    }

    @Override // com.baidu.platform.core.recommendstop.IRecommendStop
    public boolean requestRecommendStop(RecommendStopSearchOption recommendStopSearchOption) {
        b bVar = new b();
        bVar.a(SearchType.RECOMMEND_STOP);
        return a(new c(recommendStopSearchOption), this.f9387g, bVar);
    }

    @Override // com.baidu.platform.core.recommendstop.IRecommendStop
    public void setOnGetRecommendStopResultListener(OnGetRecommendStopResultListener onGetRecommendStopResultListener) {
        this.f8564c.lock();
        this.f9387g = onGetRecommendStopResultListener;
        this.f8564c.unlock();
    }
}
