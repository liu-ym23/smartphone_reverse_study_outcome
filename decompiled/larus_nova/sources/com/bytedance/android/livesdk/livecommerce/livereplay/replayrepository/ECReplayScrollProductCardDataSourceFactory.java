package com.bytedance.android.livesdk.livecommerce.livereplay.replayrepository;

import androidx.paging.DataSource;
import com.bytedance.android.livesdk.livecommerce.ECLiveCommerceModel_ProvideNetServiceFactory;
import el2.l;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import nl2.c;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/livereplay/replayrepository/ECReplayScrollProductCardDataSourceFactory;", "Landroidx/paging/DataSource$Factory;", "", "Lni2/a;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECReplayScrollProductCardDataSourceFactory extends DataSource.Factory<Integer, ni2.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public l f149323a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final oi2.a f149324b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.android.livesdk.livecommerce.livereplay.replayrepository.a f149325c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f149326d;

    public final class a implements DataSource.InvalidatedCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f149327a;

        public a(Function0 r100) {
            this.f149327a = r100;
        }

        @Override // androidx.paging.DataSource.InvalidatedCallback
        public final /* synthetic */ void onInvalidated() {
            this.f149327a.invoke();
        }
    }

    @Override // androidx.paging.DataSource.Factory
    public final DataSource<Integer, ni2.a> create() {
        ECReplayScrollProductCardDataSource r100 = new ECReplayScrollProductCardDataSource(this.f149323a, this.f149324b, this.f149325c, this.f149326d);
        r100.addInvalidatedCallback(new a(new ECReplayScrollProductCardDataSourceFactory$create$1$1(this.f149325c)));
        return r100;
    }

    public ECReplayScrollProductCardDataSourceFactory(oi2.a r100, com.bytedance.android.livesdk.livecommerce.livereplay.replayrepository.a r101, c r102) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r102, "disposableScope");
        this.f149324b = r100;
        this.f149325c = r101;
        this.f149326d = r102;
        this.f149323a = ECLiveCommerceModel_ProvideNetServiceFactory.proxyProvideNetService(hh2.a.a().f485153f);
    }
}
