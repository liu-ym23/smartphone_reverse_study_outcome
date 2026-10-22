package com.bytedance.android.livesdk.livecommerce.livereplay.repository;

import androidx.paging.DataSource;
import com.bytedance.android.livesdk.livecommerce.ECLiveCommerceModel_ProvideNetServiceFactory;
import el2.l;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import nl2.c;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/livereplay/repository/ECScrollProductCardDataSourceFactory;", "Landroidx/paging/DataSource$Factory;", "", "Lni2/a;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECScrollProductCardDataSourceFactory extends DataSource.Factory<Integer, ni2.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public l f149342a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final oi2.b f149343b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f149344c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f149345d;

    public final class a implements DataSource.InvalidatedCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f149346a;

        public a(Function0 r100) {
            this.f149346a = r100;
        }

        @Override // androidx.paging.DataSource.InvalidatedCallback
        public final /* synthetic */ void onInvalidated() {
            this.f149346a.invoke();
        }
    }

    @Override // androidx.paging.DataSource.Factory
    public final DataSource<Integer, ni2.a> create() {
        ECScrollProductCardDataSource r100 = new ECScrollProductCardDataSource(this.f149342a, this.f149343b, this.f149344c, this.f149345d);
        r100.addInvalidatedCallback(new a(new ECScrollProductCardDataSourceFactory$create$1$1(this.f149344c)));
        return r100;
    }

    public ECScrollProductCardDataSourceFactory(oi2.b r100, b r101, c r102) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r102, "disposableScope");
        this.f149343b = r100;
        this.f149344c = r101;
        this.f149345d = r102;
        this.f149342a = ECLiveCommerceModel_ProvideNetServiceFactory.proxyProvideNetService(hh2.a.a().f485153f);
    }
}
