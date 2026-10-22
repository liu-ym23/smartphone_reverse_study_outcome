package com.bytedance.android.live.customize;

import com.bytedance.android.live.base.IService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0007\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/customize/ILiveFeedDrawerTool;", "Lcom/bytedance/android/live/base/IService;", "canShowMoreEntrance", "", "enterFromMerge", "", "enterMethod", "getLiveFeedUrlDrawer", "livecore-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveFeedDrawerTool extends IService {
    boolean canShowMoreEntrance(String r100, String r101);

    String getLiveFeedUrlDrawer(String r100);
}
