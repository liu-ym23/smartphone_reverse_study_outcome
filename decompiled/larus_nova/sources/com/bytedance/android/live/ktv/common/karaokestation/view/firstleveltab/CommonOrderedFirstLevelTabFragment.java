package com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.karaokestation.model.FirstLevelTab;
import com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b;
import com.larus.nova.R;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/ktv/common/karaokestation/view/firstleveltab/CommonOrderedFirstLevelTabFragment;", "Lcom/bytedance/android/live/ktv/common/karaokestation/view/firstleveltab/BaseFirstLevelTabFragment;", "<init>", "()V", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public class CommonOrderedFirstLevelTabFragment extends BaseFirstLevelTabFragment {
    public CommonOrderedFirstLevelTabFragment() {
        super(null, null);
    }

    @Override // com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.BaseFirstLevelTabFragment
    public final boolean U90() {
        return false;
    }

    @Override // com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.BaseFirstLevelTabFragment, com.bytedance.android.live.ktv.common.karaokestation.view.BaseTabFragment
    public final int getLayoutId() {
        return R.layout.ttlive_ktv_common_ordered_fragment;
    }

    @Override // com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a
    public final String aK() {
        return s1.B(R.string.ttlive_ktv_ordered_tab_name);
    }

    @Override // com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a
    public final FirstLevelTab VL() {
        return FirstLevelTab.OrderedSongTab;
    }

    public CommonOrderedFirstLevelTabFragment(String r100, b r101) {
        super(r100, r101);
    }
}
