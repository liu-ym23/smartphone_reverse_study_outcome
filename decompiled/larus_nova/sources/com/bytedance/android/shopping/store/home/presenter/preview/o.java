package com.bytedance.android.shopping.store.home.presenter.preview;

import android.view.View;
import com.bytedance.android.ec.model.response.ECCurrentPromotion;
import com.bytedance.android.ec.store.common.headlive.StoreV3LiveRoomVO;
import com.bytedance.android.shopping.store.home.event.StoreUserActionEvent;
import com.bytedance.android.shopping.store.viewmodel.ShopStatus;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes14.dex */
public interface o extends com.bytedance.android.shopping.store.home.frame.presenter.f {
    void a(StoreV3LiveRoomVO r100);

    void b(ShopStatus r100);

    boolean c(String r100, View r101);

    void d(boolean r100);

    void doEventAction(String r100, Pair<String, String>... r101);

    void e();

    void f(StoreUserActionEvent r100);

    void g(String r100, Function1<? super ECCurrentPromotion, Unit> r101);

    void h(View r100, String r101);

    void i();
}
