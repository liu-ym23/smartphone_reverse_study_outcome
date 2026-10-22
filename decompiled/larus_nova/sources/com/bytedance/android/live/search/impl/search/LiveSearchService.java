package com.bytedance.android.live.search.impl.search;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.search.api.ILiveSearchService;
import com.bytedance.android.live.search.impl.search.ui.SearchHeadListView;
import com.bytedance.android.livesdk.config.ar0;
import com.bytedance.android.livesdk.config.q01;
import com.bytedance.android.livesdk.utils.e5;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b \u0010!J,\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J,\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\fH\u0016J4\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0004H\u0016J\u0018\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0004H\u0016J\b\u0010\u0015\u001a\u00020\u000fH\u0016J\u001a\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\u001b\u001a\u00020\u000f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016J\b\u0010\u001f\u001a\u00020\u001eH\u0016¨\u0006\""}, d2 = {"Lcom/bytedance/android/live/search/impl/search/LiveSearchService;", "Lcom/bytedance/android/live/search/api/ILiveSearchService;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/view/ViewGroup;", "inputContainer", "Landroid/os/Bundle;", "bundle", "Lpa1/d;", "searchCallback", "Landroidx/fragment/app/Fragment;", "createSearchResultFragment", "Lpa1/e;", "config", "createSearchUserFragment", "", "isTrial", "parent", "Landroid/view/View;", "createSearchUserHeadListView", "createSearchInputView", "supportSearch", "", "roomId", "Landroid/app/Activity;", "activity", "shouldJumpToSearch", "hasShowSearch", "", "clearCache", "", "getSearchSlideType", "<init>", "()V", "livesearchimpl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class LiveSearchService implements ILiveSearchService {
    @Override // com.bytedance.android.live.search.api.ILiveSearchService
    public void clearCache() {
        a.f100686f = null;
        a.f100685e = 0;
        a.f100681a = "";
        a.f100682b = 0;
        a.f100683c = "";
        a.f100684d = 0;
    }

    @Override // com.bytedance.android.live.search.api.ILiveSearchService
    public int getSearchSlideType() {
        return q01.f121022a.getValue().intValue();
    }

    @Override // com.bytedance.android.live.search.api.ILiveSearchService
    public boolean supportSearch() {
        return ar0.f119814a.getValue().booleanValue();
    }

    public LiveSearchService() {
        jc1.k.l(ILiveSearchService.class, this);
    }

    @Override // com.bytedance.android.live.search.api.ILiveSearchService
    public boolean hasShowSearch(Activity r100) {
        if (r100 == null) goto L6;
        int r101 = r100.hashCode();
        String r102 = a.f100681a;
        if (r101 != a.f100684d) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // com.bytedance.android.live.search.api.ILiveSearchService
    public View createSearchInputView(Context r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "parent");
        return LayoutInflater.from(r100).inflate(R.layout.ttlive_search_input_layout, r101, false);
    }

    @Override // com.bytedance.android.live.search.api.ILiveSearchService
    public View createSearchUserHeadListView(Context r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "parent");
        AttributeSet r102 = null;
        return new SearchHeadListView(r100, r102, 6, 0);
    }

    @Override // com.bytedance.android.live.search.api.ILiveSearchService
    public boolean shouldJumpToSearch(long r100, Activity r101) {
        String r102 = a.f100681a;
        if (a.f100685e == 0) goto L12;
        if (r101 == null) goto L11;
        int r103 = r101.hashCode();
        int r104 = a.f100684d;
        if (r103 == r104) goto L11;
        if (r104 == r101.hashCode()) goto L12;
        if (a.f100682b != r100) goto L12;
    L11:
        return true;
    L12:
        return false;
    }

    @Override // com.bytedance.android.live.search.api.ILiveSearchService
    public Fragment createSearchResultFragment(Context r100, ViewGroup r101, Bundle r102, pa1.d r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r103, "searchCallback");
        if (r101 == null) goto L7;
        View r104 = createSearchInputView(r100, r101);
        r101.removeAllViews();
        r101.addView(r104);
        if (e5.n() == false) goto L7;
        r104.setBackgroundResource(R.drawable.ttlive_search_input_bg_landscape);
    L7:
        LiveSearchResultFragment r105 = new LiveSearchResultFragment();
        if (r101 == null) goto L10;
        r105.Y90(r101);
    L10:
        r105.f100643r = r103;
        if (r102 != null) goto L13;
        r102 = new Bundle();
    L13:
        r105.setArguments(r102);
        Bundle r106 = r105.getArguments();
        if (r106 == null) goto L19;
        if (r101 != null) goto L17;
        boolean r107 = true;
    L18:
        r106.putBoolean("bundle_need_show_input_container_inside", r107);
        goto L19
    L17:
        r107 = false;
    L19:
        return r105;
    }

    @Override // com.bytedance.android.live.search.api.ILiveSearchService
    public Fragment createSearchUserFragment(Context r100, ViewGroup r101, Bundle r102, pa1.e r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r103, "config");
        int r104 = LiveSearchUserFragment.f100653z;
        Intrinsics.checkNotNullParameter(r103, "config");
        LiveSearchUserFragment r105 = new LiveSearchUserFragment();
        r105.f100669s = r103;
        return r105;
    }

    @Override // com.bytedance.android.live.search.api.ILiveSearchService
    public Fragment createSearchUserFragment(Context r100, ViewGroup r101, Bundle r102, pa1.e r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r103, "config");
        int r105 = LiveSearchUserFragment.f100653z;
        Intrinsics.checkNotNullParameter(r103, "config");
        LiveSearchUserFragment r106 = new LiveSearchUserFragment();
        r106.f100669s = r103;
        r106.f100671u = r104;
        return r106;
    }
}
