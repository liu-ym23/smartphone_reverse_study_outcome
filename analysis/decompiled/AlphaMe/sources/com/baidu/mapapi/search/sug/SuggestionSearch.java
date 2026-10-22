package com.baidu.mapapi.search.sug;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.search.core.b;
import com.baidu.platform.core.sug.ISuggestionSearch;
import com.baidu.platform.core.sug.a;

/* loaded from: classes.dex */
public class SuggestionSearch extends b {

    /* renamed from: b, reason: collision with root package name */
    private boolean f7573b = false;

    /* renamed from: a, reason: collision with root package name */
    ISuggestionSearch f7572a = new a();

    private SuggestionSearch() {
    }

    public static SuggestionSearch newInstance() {
        BMapManager.init();
        return new SuggestionSearch();
    }

    public void destroy() {
        if (this.f7573b) {
            return;
        }
        this.f7573b = true;
        this.f7572a.destroy();
        BMapManager.destroy();
    }

    public boolean requestSuggestion(SuggestionSearchOption suggestionSearchOption) {
        ISuggestionSearch iSuggestionSearch = this.f7572a;
        if (iSuggestionSearch == null) {
            throw new IllegalStateException("BDMapSDKException: suggestionsearch is null, please call newInstance() first.");
        }
        if (suggestionSearchOption == null || suggestionSearchOption.mKeyword == null || suggestionSearchOption.mCity == null) {
            throw new IllegalArgumentException("BDMapSDKException: option or keyword or city can not be null");
        }
        return iSuggestionSearch.requestSuggestion(suggestionSearchOption);
    }

    public void setOnGetSuggestionResultListener(OnGetSuggestionResultListener onGetSuggestionResultListener) {
        ISuggestionSearch iSuggestionSearch = this.f7572a;
        if (iSuggestionSearch == null) {
            throw new IllegalStateException("BDMapSDKException: suggestionsearch is null, please call newInstance() first.");
        }
        if (onGetSuggestionResultListener == null) {
            throw new IllegalArgumentException("BDMapSDKException: listener can not be null");
        }
        iSuggestionSearch.setOnGetSuggestionResultListener(onGetSuggestionResultListener);
    }
}
