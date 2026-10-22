package com.bytedanceos.common.ui.myapplist;

import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.j;
import com.bytedanceos.common.ui.adapter.MyAppsAdapter;
import com.bytedanceos.common.ui.widget.SwipeRecyclerView;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class NewMyAppListInteraction {
    private final Callback mCallback;
    private final SwipeRecyclerView mLocalAppsListView;
    private MyAppsAdapter mLocalAppsOnlineAdapter;
    private final MyAppListData mMyAppListData;

    public interface Callback {
        void doCancelDownload(AppInfo r10);
    }

    public NewMyAppListInteraction(MyAppListData r10, SwipeRecyclerView r11, Callback r12) {
        this.mMyAppListData = r10;
        this.mLocalAppsListView = r11;
        this.mLocalAppsOnlineAdapter = (MyAppsAdapter) r11.getAdapter();     // Catch: ClassCastException -> L9
        if (r12 == null) goto L8;
        this.mCallback = r12;
        return;
    L8:
        throw new NullPointerException("Null Callback passed");
    L9:
        e = move-exception;
        e.printStackTrace();
        throw new IllegalArgumentException("MyAppSwipeListView not using InteractionAdapter");
    }

    public void dequeueDownload(AppInfo r10) {
        j.a("dequeue from download [ " + r10 + " ]");
        int r11 = this.mLocalAppsOnlineAdapter.getDataList().indexOf(r10);
        this.mMyAppListData.mPendingDequeue = r10;
        j.b("getAppInfoIndex : " + r11);
        if (r11 < 0) goto L5;
        this.mLocalAppsOnlineAdapter.notifyItemRemoved(r11);
        MyAppsAdapter r12 = this.mLocalAppsOnlineAdapter;
        r12.notifyItemRangeChanged(r11, (r12.getItemCount() - 1) - r11);
    L5:
        List<AppInfo> r13 = this.mMyAppListData.dequeue(r10);
        this.mLocalAppsOnlineAdapter.getDataList().clear();
        this.mLocalAppsOnlineAdapter.getDataList().addAll(r13);
        this.mCallback.doCancelDownload(r10);
    }
}
