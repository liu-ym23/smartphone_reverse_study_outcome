package com.android.internal.chooser.base;

import com.android.internal.chooser.QuickLookStrategy;
import com.android.internal.chooser.ShareStrategy;
import com.android.internal.chooser.bean.DisplayResolveInfo;
import java.util.List;

/* loaded from: classes.dex */
public interface OnViewClickListener {
    void onClick(DisplayResolveInfo displayResolveInfo, QuickLookStrategy quickLookStrategy, ShareStrategy shareStrategy);

    void onEditButtonClick(List<DisplayResolveInfo> list, List<DisplayResolveInfo> list2);

    void onMoreButtonClick(boolean z);

    void onPopupMenuChanged(boolean z);
}
