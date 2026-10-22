package com.bytedance.android.live.base.service;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.base.IService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/base/service/ILiveDrawerFeed;", "Lcom/bytedance/android/live/base/IService;", "clearDrawerData", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveDrawerFeed extends IService {
    void clearDrawerData(FragmentActivity r100);
}
