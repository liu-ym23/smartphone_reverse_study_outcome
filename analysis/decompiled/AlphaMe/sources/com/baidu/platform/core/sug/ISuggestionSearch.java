package com.baidu.platform.core.sug;

import com.baidu.mapapi.search.sug.OnGetSuggestionResultListener;
import com.baidu.mapapi.search.sug.SuggestionSearchOption;

/* loaded from: classes.dex */
public interface ISuggestionSearch {
    void destroy();

    boolean requestSuggestion(SuggestionSearchOption suggestionSearchOption);

    void setOnGetSuggestionResultListener(OnGetSuggestionResultListener onGetSuggestionResultListener);
}
