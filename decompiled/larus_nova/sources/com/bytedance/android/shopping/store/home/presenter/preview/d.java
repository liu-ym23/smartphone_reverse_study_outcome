package com.bytedance.android.shopping.store.home.presenter.preview;

import com.bytedance.android.ec.model.response.ECCurrentPromotion;
import com.bytedance.android.ec.model.response.s;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class d implements cf.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECShopExplainCardPresenter f184347a;

    public d(ECShopExplainCardPresenter r100) {
        this.f184347a = r100;
    }

    @Override // cf.i
    public final void a(String r100, boolean r101, Pair<Long, Long> r102, s r103, String r104, Map<String, String> r105, Function1<? super ECCurrentPromotion, Unit> r106) {
        Intrinsics.checkNotNullParameter(r106, "callback");
        o r107 = (o) this.f184347a.f184274n.getValue();
        if (r107 == null) goto L6;
        r107.g(r100, r106);
        return;
    }
}
