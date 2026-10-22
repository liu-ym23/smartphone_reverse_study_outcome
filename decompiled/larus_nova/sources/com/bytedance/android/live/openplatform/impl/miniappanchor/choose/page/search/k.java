package com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.search;

import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.MiniAppEntranceCell;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.utils.RecyclerViewScrollReportHelper;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.view.error.OpenPlatformFullScreenErrorView;
import com.bytedance.android.livesdk.chatroom.ui.LiveDoubleColorBallAnimationView;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class k<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MiniAppChooseSearchFragment f84284a;

    public k(MiniAppChooseSearchFragment r100) {
        this.f84284a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        com.bytedance.android.live.openplatform.impl.base.utils.b r101 = (com.bytedance.android.live.openplatform.impl.base.utils.b) r100;
        if (r101.f84042a == false) goto L5;
        T r102 = (T) null;
    L6:
        p r103 = r102;
        if (r103 != null) goto L10;
        return;
    L10:
        if ((r103 instanceof p.c) == false) goto L13;
        MiniAppChooseSearchFragment r104 = this.f84284a;
        int r105 = MiniAppChooseSearchFragment.f84255j;
        ((LiveDoubleColorBallAnimationView) r104.S90(R.id.loading_view)).setVisibility(0);
        ((OpenPlatformFullScreenErrorView) this.f84284a.S90(R.id.error_view)).R5();
        ((RecyclerView) this.f84284a.S90(R.id.search_history)).setVisibility(8);
        ((TextView) this.f84284a.S90(R.id.clear_all_histories)).setVisibility(8);
        int r106 = com.bytedance.android.live.openplatform.impl.base.utils.k.f84065a;
        com.bytedance.android.live.openplatform.impl.base.utils.k.a(this.f84284a.getContext(), this.f84284a.S90(R.id.search_edit));
        return;
    L13:
        if ((r103 instanceof p.d) == false) goto L18;
        MiniAppChooseSearchFragment r107 = this.f84284a;
        int r108 = MiniAppChooseSearchFragment.f84255j;
        r107.hideLoading();
        ((RecyclerView) this.f84284a.S90(R.id.search_result)).setVisibility(0);
        SearchResultAdapter r109 = (SearchResultAdapter) this.f84284a.f84260h.getValue();
        p.d r110 = (p.d) r103;
        List<MiniAppEntranceCell> r111 = r110.f84294a;
        r109.getClass();
        Intrinsics.checkNotNullParameter(r111, "data");
        r109.f84272a = r111;
        r109.notifyDataSetChanged();
        RecyclerViewScrollReportHelper<MiniAppEntranceCell> r112 = this.f84284a.f84261i;
        if (r112 == null) goto L25;
        r112.d(r110.f84294a);
        return;
    L25:
        return;
    L18:
        if ((r103 instanceof p.a) == false) goto L21;
        MiniAppChooseSearchFragment r113 = this.f84284a;
        int r114 = MiniAppChooseSearchFragment.f84255j;
        r113.hideLoading();
        ((RecyclerView) this.f84284a.S90(R.id.search_result)).setVisibility(8);
        ((OpenPlatformFullScreenErrorView) this.f84284a.S90(R.id.error_view)).S5(this.f84284a.getString(R.string.ttlive_mini_app_choose_search_no_relevant_result));
        return;
    L21:
        if ((r103 instanceof p.b) == false) goto L28;
        MiniAppChooseSearchFragment r115 = this.f84284a;
        int r116 = MiniAppChooseSearchFragment.f84255j;
        r115.hideLoading();
        ((RecyclerView) this.f84284a.S90(R.id.search_result)).setVisibility(8);
        ((OpenPlatformFullScreenErrorView) this.f84284a.S90(R.id.error_view)).U5(new j(this));
        return;
    L28:
        return;
    L5:
        r101.f84042a = true;
        r102 = r101.f84043b;
        goto L6
    }
}
