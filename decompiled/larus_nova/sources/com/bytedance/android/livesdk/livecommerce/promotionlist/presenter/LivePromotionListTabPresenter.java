package com.bytedance.android.livesdk.livecommerce.promotionlist.presenter;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.livesdk.livecommerce.iron.category.CategoryRecyclerView;
import com.bytedance.android.livesdk.livecommerce.iron.ui.tab.CategoryExpandView;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes10.dex */
public final class LivePromotionListTabPresenter extends com.bytedance.android.livesdk.livecommerce.promotionlist.base.a {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f150997n = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public CategoryRecyclerView f150998j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public View f150999k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public CategoryExpandView f151000l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f151001m;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotionlist.base.a
    public final void e0() {
        this.f150998j = (CategoryRecyclerView) a0().findViewById(R.id.category_list);
        this.f150999k = a0().findViewById(R.id.view_category_list_place_holder);
        this.f151000l = (CategoryExpandView) a0().findViewById(R.id.category_expand);
        com.bytedance.android.ec.core.arch.state.c.a(d0(), ECQuickUtilKt.a(Y()), LivePromotionListTabPresenter$init$1.INSTANCE, new LivePromotionListTabPresenter$init$2(this));
        com.bytedance.android.ec.core.arch.state.c.a(d0(), ECQuickUtilKt.a(Y()), LivePromotionListTabPresenter$init$3.INSTANCE, new LivePromotionListTabPresenter$init$4(this));
        com.bytedance.android.ec.core.arch.state.c.a(d0(), ECQuickUtilKt.a(Y()), LivePromotionListTabPresenter$init$5.INSTANCE, new LivePromotionListTabPresenter$init$6(this));
        com.bytedance.android.ec.core.arch.event.c.c(d0(), ECQuickUtilKt.a(Y()), Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.d.class), new LivePromotionListTabPresenter$init$7(this));
        com.bytedance.android.ec.core.arch.event.c.c(d0(), ECQuickUtilKt.a(Y()), Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.f.class), new LivePromotionListTabPresenter$init$8(this));
    }

    public static final /* synthetic */ CategoryRecyclerView h0(LivePromotionListTabPresenter r100) {
        CategoryRecyclerView r101 = r100.f150998j;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("categoryList");
    L5:
        return r101;
    }

    public LivePromotionListTabPresenter(Fragment r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        super(r100, r101);
    }
}
