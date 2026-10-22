package com.baidu.platform.core.recommendstop;

import com.baidu.mapapi.search.recommendstop.OnGetRecommendStopResultListener;
import com.baidu.mapapi.search.recommendstop.RecommendStopSearchOption;

/* loaded from: classes.dex */
public interface IRecommendStop {
    void destroy();

    boolean requestRecommendStop(RecommendStopSearchOption recommendStopSearchOption);

    void setOnGetRecommendStopResultListener(OnGetRecommendStopResultListener onGetRecommendStopResultListener);
}
