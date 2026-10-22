package an;

import androidx.paging.PositionalDataSource;
import com.bytedance.android.ec.store.repository.dto.StoreV2ProductListResponseDTO;
import com.bytedance.android.ec.store.repository.vo.StoreV2ProductListResponseVO;
import com.bytedance.android.ec.store.search.datasource.SearchProductListDataSource;
import com.bytedance.android.ec.store.shopping.paging.ListStatusPositionalLoadRangeCallback;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes44.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SearchProductListDataSource f4480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ListStatusPositionalLoadRangeCallback f4481b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ PositionalDataSource.LoadRangeParams f4482c;

    public b(SearchProductListDataSource r100, ListStatusPositionalLoadRangeCallback r101, PositionalDataSource.LoadRangeParams r102) {
        this.f4480a = r100;
        this.f4481b = r101;
        this.f4482c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        StoreV2ProductListResponseDTO r101 = (StoreV2ProductListResponseDTO) r100;
        if (r101.getStatusCode() == 0) goto L5;
        this.f4481b.a();
        return;
    L5:
        StoreV2ProductListResponseVO.Companion.getClass();
        StoreV2ProductListResponseVO r102 = StoreV2ProductListResponseVO.a.a(r101, true);
        this.f4480a.i(r102, this.f4482c, this.f4481b);
    }
}
