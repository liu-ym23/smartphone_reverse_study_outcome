package com.obric.capabilitykit.search;

import com.obric.capabilitykit.entity.search.InAppSearchResult;
import com.obric.capabilitykit.entity.search.InAppSearchResultWithoutEntity;

/* JADX INFO: loaded from: classes4.dex */
public interface IAppSearchCallback {
    void onCompleted();

    void onError(int r1, String r2);

    void onSearchResult(InAppSearchResult r1);

    void onSearchResultWithoutEntity(InAppSearchResultWithoutEntity r1);
}
