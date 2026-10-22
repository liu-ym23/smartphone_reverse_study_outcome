package com.baidu.platform.core.sug;

import com.baidu.mapapi.search.sug.OnGetSuggestionResultListener;
import com.baidu.mapapi.search.sug.SuggestionSearchOption;
import com.baidu.platform.base.SearchType;

/* loaded from: classes.dex */
public class a extends com.baidu.platform.base.a implements ISuggestionSearch {

    /* renamed from: g, reason: collision with root package name */
    private OnGetSuggestionResultListener f9395g = null;

    @Override // com.baidu.platform.core.sug.ISuggestionSearch
    public void destroy() {
        this.f8564c.lock();
        this.f9395g = null;
        this.f8564c.unlock();
    }

    @Override // com.baidu.platform.core.sug.ISuggestionSearch
    public boolean requestSuggestion(SuggestionSearchOption suggestionSearchOption) {
        b bVar = new b();
        bVar.a(SearchType.SUGGESTION_SEARCH_TYPE);
        return a(new c(suggestionSearchOption), this.f9395g, bVar);
    }

    @Override // com.baidu.platform.core.sug.ISuggestionSearch
    public void setOnGetSuggestionResultListener(OnGetSuggestionResultListener onGetSuggestionResultListener) {
        this.f8564c.lock();
        this.f9395g = onGetSuggestionResultListener;
        this.f8564c.unlock();
    }
}
