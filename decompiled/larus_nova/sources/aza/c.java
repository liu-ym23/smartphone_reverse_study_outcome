package aza;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.larkfeed.impl.mixedfeed.LarkMixedFeedFragment;
import com.ss.android.lark.flow.feed.page.FlowMixedFeedFragment;
import com.ss.android.lark.flow.feed.sidebar.adapter.FeedSidebarAdapter;
import com.ss.android.lark.flow.feed.sidebar.human.OfficeSidebarHumanFeedController;
import com.ss.android.lark.officesdk.api.base.IOfficeSDKCapacity;
import iza.e;

/* JADX INFO: loaded from: classes34.dex */
public interface c extends IOfficeSDKCapacity {
    lza.a G5();

    FeedSidebarAdapter Md(Fragment r100, RecyclerView r101, e r102, com.larus.larkfeed.impl.mixedfeed.flow.a r103);

    sza.c N1();

    void d3(String r100);

    OfficeSidebarHumanFeedController p4(Fragment r100, e r101);

    FlowMixedFeedFragment y6(LarkMixedFeedFragment r100);
}
