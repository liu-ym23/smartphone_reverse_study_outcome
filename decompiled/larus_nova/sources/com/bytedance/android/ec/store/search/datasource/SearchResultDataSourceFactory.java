package com.bytedance.android.ec.store.search.datasource;

import androidx.paging.DataSource;
import en.b;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/ec/store/search/datasource/SearchResultDataSourceFactory;", "Landroidx/paging/DataSource$Factory;", "", "Len/b;", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class SearchResultDataSourceFactory extends DataSource.Factory<Integer, b> {
    public abstract void a();

    public SearchResultDataSourceFactory() {
    }
}
