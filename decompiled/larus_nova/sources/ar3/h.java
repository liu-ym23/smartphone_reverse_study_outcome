package ar3;

import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListDTO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECListItemConfigDTO;
import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import com.bytedance.android.window.shop.home.tab.WindowHybridTabViewModel;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import com.bytedance.android.window.shop.repository.dto.WindowHybridTabDataListResponseDTO;
import com.bytedance.android.window.shop.repository.tab.entity.m0;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<d> f16009a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<WindowHybridTabDataListResponseDTO, Unit> f16010b;

    /* JADX WARN: Multi-variable type inference failed */
    public h(Function1<? super WindowHybridTabDataListResponseDTO, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "consumer");
        this.f16010b = r100;
        this.f16009a = new ArrayList();
    }

    public final boolean a(WindowV2ProductItemVO r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, "itemVO");
        Intrinsics.checkNotNullParameter(r111, "categoryId");
        Iterator r100 = ((ArrayList) this.f16009a).iterator();
    L4:
        if (r100.hasNext() == false) goto L38;
        d r101 = (d) r100.next();
        if (r101.c(r110, r111) == false) goto L4;
        Intrinsics.checkNotNullParameter(r110, "itemVO");
        com.bytedance.android.window.shop.repository.tab.entity.f r102 = d.a(r110);
        WindowHybridTabDataListResponseDTO r103 = null;
        if (r102 == null) goto L31;
        ECWindowViewModel r104 = r101.f16004b;
        WindowHybridTabViewModel r105 = r101.f16005c;
        Intrinsics.checkNotNullParameter(r104, "viewModel");
        Intrinsics.checkNotNullParameter(r105, "tabViewModel");
        Intrinsics.checkNotNullParameter(r102, "itemVO");
        com.bytedance.android.window.shop.repository.tab.entity.g r106 = com.bytedance.android.window.shop.repository.tab.entity.g.f189563b;
        monitor-enter(r106);
        com.bytedance.android.window.shop.repository.tab.entity.g.f189562a++;     // Catch: Throwable -> L35
        long r107 = com.bytedance.android.window.shop.repository.tab.entity.g.f189562a;     // Catch: Throwable -> L35
        monitor-exit(r106);
        String.valueOf(r107);
        fo.b r108 = r102.f189557f;
        fo.a<Map<String, String>> r109 = m0.f189599a;
        Map r112 = (Map) r108.a(r109);
        if (r112 == null) goto L17;
        Map r113 = MapsKt.toMutableMap(r112);
        r113.put(com.bytedance.android.ec.core.event.a.KEY_CARD_TYPE, r101.b().getVaneType());
        r102.f189557f.d(r109, r113);
    L17:
        String r114 = r110.f49463a;
        Intrinsics.checkNotNullParameter(r114, "currentProductId");
        Intrinsics.checkNotNullParameter(r102, "$this$removeInsertRequestKey");
        Map<String, String> r115 = (Map) r102.f189557f.c(r109);
        if (r115 == null) goto L20;
        r102.f189557f.d(m0.f189600b, r115);
    L20:
        if (r115 != null) goto L22;
        WindowHybridTabDataListResponseDTO r116 = null;
    L23:
        if (r116 == null) goto L31;
        ECHybridListDTO r117 = r116.getFeed();
        if (r117 == null) goto L31;
        Map<String, ECListItemConfigDTO> r118 = r117.getItemConfigs();
        if (r118 == null) goto L31;
        if ((!r118.isEmpty()) != true) goto L31;
        r103 = r116;
        goto L31
    L22:
        String r119 = r104.getShopParam().getSecAuthorId();
        Set<String> r120 = r105.getExcludedList(r114);
        int r121 = zq3.d.f573297a;
        r116 = r105.prefetchInsertData(r119, r115, r120, zq3.d.a(r104.getShopParam(), z1.g(r104.getEntranceInfo())), (String) r104.getShopParam().getPassThroughParam(com.bytedance.android.ec.core.event.a.KEY_PASS_THROUGH_API));
    L35:
        th = move-exception;
        throw th;
    L31:
        if (r103 == null) goto L4;
        Observable.create(new e(r103)).subscribeOn(AndroidSchedulers.mainThread()).subscribe(new f(this), g.f16008a);
        return true;
    L38:
        return false;
    }
}
