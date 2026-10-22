package com.bytedance.android.livesdkapi.feed.open;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.bytedance.android.livesdkapi.feed.manager.ILiveListManager;
import com.bytedance.android.livesdkapi.feed.model.HorFollowListParams;
import com.bytedance.android.livesdkapi.feed.model.OpenFeedParams;
import com.bytedance.android.livesdkapi.feed.ui.ILiveBlock;
import com.bytedance.android.livesdkapi.feed.ui.ILiveCardView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0006\u001a\u00020\tH&J\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\tH&¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdkapi/feed/open/IOpenLiveListFactory;", "", "createHorizontalLiveBlock", "Lcom/bytedance/android/livesdkapi/feed/ui/ILiveBlock;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "params", "Lcom/bytedance/android/livesdkapi/feed/model/HorFollowListParams;", "createLiveBlock", "Lcom/bytedance/android/livesdkapi/feed/model/OpenFeedParams;", "createLiveCardManager", "Lcom/bytedance/android/livesdkapi/feed/manager/ILiveListManager;", "createLiveFragment", "Landroidx/fragment/app/Fragment;", "createSingleLiveCard", "Lcom/bytedance/android/livesdkapi/feed/ui/ILiveCardView;", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IOpenLiveListFactory {
    ILiveBlock createHorizontalLiveBlock(Context r100, HorFollowListParams r101);

    ILiveBlock createLiveBlock(Context r100, OpenFeedParams r101);

    ILiveListManager createLiveCardManager(Context r100);

    Fragment createLiveFragment(OpenFeedParams r100);

    ILiveCardView createSingleLiveCard(Context r100, OpenFeedParams r101);
}
