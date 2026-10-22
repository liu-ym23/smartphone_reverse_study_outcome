package com.bytedance.android.gamecp.business.gamedetail.component.tab;

import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.ies.viewpager.PagerItemWidget;
import com.bytedance.ies.viewpager.PagerWidget;
import com.larus.nova.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/component/tab/CustomGameViewPagerWidget;", "Lcom/bytedance/ies/viewpager/PagerWidget;", "", "Lcom/bytedance/android/gamecp/business/gamedetail/component/tab/GameDetailTabViewPager;", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CustomGameViewPagerWidget extends PagerWidget<Object, GameDetailTabViewPager> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f55032g;

    @Override // com.bytedance.ies.viewpager.PagerWidget, com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.gamecp_game_promote_custom_view_pager_widget;
    }

    @Override // com.bytedance.ies.viewpager.PagerWidget
    public final ViewPager Nq() {
        View r100 = this.contentView;
        if ((r100 instanceof GameDetailTabViewPager) == true) goto L6;
        r100 = null;
    L6:
        return (GameDetailTabViewPager) r100;
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final View getLayoutView() {
        if (this.f55032g != null) goto L6;
        int r100 = com.bytedance.android.gamecp.business.gamedetail.asyncinflate.a.f53475a;
        this.f55032g = com.bytedance.android.gamecp.business.gamedetail.asyncinflate.a.a(this.context, R.layout.gamecp_game_promote_custom_view_pager_widget);
    L6:
        return this.f55032g;
    }

    public CustomGameViewPagerWidget(List<? extends m56.a> r100, Function1<? super String, ? extends PagerItemWidget<?>> r101, Function1<? super ViewPager, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "tabName");
        Intrinsics.checkNotNullParameter(r101, "factory");
        super(r100, r101, r102);
    }
}
