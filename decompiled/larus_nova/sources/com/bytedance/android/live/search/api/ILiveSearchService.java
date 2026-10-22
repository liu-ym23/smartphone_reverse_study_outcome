package com.bytedance.android.live.search.api;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import pa1.d;
import pa1.e;

/* JADX INFO: loaded from: classes47.dex */
@ServiceLookup("com.bytedance.android.live.search.impl.search.LiveSearchService")
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J,\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH&J,\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\fH&J4\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH&J\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0004H&J\u0018\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0004H&J\b\u0010\u0015\u001a\u00020\u000fH&J\u001a\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H&J\u0012\u0010\u001b\u001a\u00020\u000f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H&J\b\u0010\u001d\u001a\u00020\u001cH&J\b\u0010\u001f\u001a\u00020\u001eH&¨\u0006 "}, d2 = {"Lcom/bytedance/android/live/search/api/ILiveSearchService;", "Lcom/bytedance/android/live/base/IService;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/view/ViewGroup;", "inputContainer", "Landroid/os/Bundle;", "bundle", "Lpa1/d;", "searchCallback", "Landroidx/fragment/app/Fragment;", "createSearchResultFragment", "Lpa1/e;", "config", "createSearchUserFragment", "", "isTrial", "parent", "Landroid/view/View;", "createSearchUserHeadListView", "createSearchInputView", "supportSearch", "", "roomId", "Landroid/app/Activity;", "activity", "shouldJumpToSearch", "hasShowSearch", "", "clearCache", "", "getSearchSlideType", "livesearchapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveSearchService extends IService {
    void clearCache();

    View createSearchInputView(Context r100, ViewGroup r101);

    Fragment createSearchResultFragment(Context r100, ViewGroup r101, Bundle r102, d r103);

    Fragment createSearchUserFragment(Context r100, ViewGroup r101, Bundle r102, e r103);

    Fragment createSearchUserFragment(Context r100, ViewGroup r101, Bundle r102, e r103, boolean r104);

    View createSearchUserHeadListView(Context r100, ViewGroup r101);

    int getSearchSlideType();

    boolean hasShowSearch(Activity r100);

    boolean shouldJumpToSearch(long r100, Activity r101);

    boolean supportSearch();
}
