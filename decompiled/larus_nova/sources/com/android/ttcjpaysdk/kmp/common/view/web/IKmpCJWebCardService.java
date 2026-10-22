package com.android.ttcjpaysdk.kmp.common.view.web;

import android.view.View;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/view/web/IKmpCJWebCardService;", "Lcom/android/ttcjpaysdk/kmp/common/view/web/IKmpCJWebCardBaseService;", "createWebCardView", "Landroid/view/View;", "schema", "", "globalProps", NewBroadcastMonitor.STAGE.LIFECYCLE, "Lcom/android/ttcjpaysdk/kmp/common/view/web/IKmpCJWebCardLifecycle;", "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IKmpCJWebCardService extends IKmpCJWebCardBaseService {
    @Override // com.android.ttcjpaysdk.kmp.common.view.web.IKmpCJWebCardBaseService
    View createWebCardView(String r100, String r101, IKmpCJWebCardLifecycle r102);
}
