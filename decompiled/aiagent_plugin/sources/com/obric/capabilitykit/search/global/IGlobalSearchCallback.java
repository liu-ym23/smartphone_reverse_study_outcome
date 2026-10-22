package com.obric.capabilitykit.search.global;

import com.obric.capabilitykit.entity.search.global.GlobalSearchResult;

/* JADX INFO: loaded from: classes4.dex */
public interface IGlobalSearchCallback {
    void onAllCompleted();

    void onCompleted(int r1);

    void onError(int r1, int r2, String r3);

    void onSearchResult(GlobalSearchResult r1);
}
