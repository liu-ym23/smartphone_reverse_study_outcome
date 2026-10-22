package com.bytedanceos.common.ui.myapplist;

import android.view.View;
import android.view.animation.Animation;
import android.widget.HeaderViewListAdapter;
import android.widget.ListView;
import com.bytedanceos.common.CommonCache;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.j;
import com.bytedanceos.common.ui.widget.MyAppSwipeItemView;
import com.bytedanceos.common.ui.widget.MyAppSwipeListView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class MyAppListInteraction {
    public View lastClickedAppStatusView;
    private boolean mAnimating;
    private final CommonCache mCache;
    private final Callback mCallback;
    private final MyAppSwipeListView mLocalAppsListView;
    private final InteractionAdapter mLocalAppsOnlineAdapter;
    private final MyAppListData mMyAppListData;

    public interface Callback {
        void activeUI();

        void doCancelDownload(AppInfo r10);

        void freezeUI();

        int getItemRow(View r10);

        AppInfo getTaggedAppInfo(View r10);

        boolean inForeground();

        void reportAnimating(boolean r10);
    }

    public interface InteractionAdapter {
        public static final int VT_COUNT = 3;
        public static final int VT_DOWNLOAD_QUEUE = 0;
        public static final int VT_LOCAL_APP = 1;
        public static final int VT_SECTION_HEADER = 2;

        void animateAdd(int r10, Animation.AnimationListener r11);

        void animateDelete(int r10, Animation.AnimationListener r11);

        void clearAnimation();

        List<AppInfo> getDataList();

        int getItemViewType(int r10);

        void notifyDataSetChanged();

        void setCanUpdate(boolean r10);

        void setDataList(List<AppInfo> r10);
    }

    public MyAppListInteraction(CommonCache r10, MyAppListData r11, MyAppSwipeListView r12, Callback r13) {
        this.mCache = r10;
        this.mMyAppListData = r11;
        this.mLocalAppsListView = r12;
        this.mLocalAppsOnlineAdapter = (InteractionAdapter) ((HeaderViewListAdapter) r12.getAdapter()).getWrappedAdapter();     // Catch: ClassCastException -> L9
        if (r13 == null) goto L8;
        this.mCallback = r13;
        return;
    L8:
        throw new NullPointerException("Null Callback passed");
    L9:
        e = move-exception;
        e.printStackTrace();
        throw new IllegalArgumentException("MyAppSwipeListView not using InteractionAdapter");
    }

    public static /* synthetic */ Callback access$000(MyAppListInteraction r10) {
        return r10.mCallback;
    }

    public static /* synthetic */ InteractionAdapter access$100(MyAppListInteraction r10) {
        return r10.mLocalAppsOnlineAdapter;
    }

    public static /* synthetic */ MyAppListData access$200(MyAppListInteraction r10) {
        return r10.mMyAppListData;
    }

    public static /* synthetic */ MyAppSwipeListView access$300(MyAppListInteraction r10) {
        return r10.mLocalAppsListView;
    }

    public static /* synthetic */ boolean access$400(MyAppListInteraction r10, ListView r11, int r12) {
        return r10.isVisible(r11, r12);
    }

    public static /* synthetic */ void access$500(MyAppListInteraction r10, boolean r11) {
        r10.setAnimating(r11);
    }

    private boolean isVisible(ListView r10, int r11) {
        if (this.mCallback.inForeground() == true) goto L5;
    L11:
        return false;
    L5:
        if (r10.getVisibility() != 0) goto L11;
        if (r10.getFirstVisiblePosition() > r11) goto L11;
        if (r11 > r10.getLastVisiblePosition()) goto L11;
        return true;
    }

    private void setAnimating(boolean r10) {
        this.mAnimating = r10;
        this.mCallback.reportAnimating(r10);
    }

    public void animateNewAppInstall(AppInfo r10) {
        if (this.mAnimating == true) goto L38;
        if (r10 == null) goto L39;
        ArrayList r11 = new ArrayList(this.mLocalAppsOnlineAdapter.getDataList());
        int r12 = r11.indexOf(this.mMyAppListData.HEADER_LOCAL_APP);
        if (r12 != (-1)) goto L10;
        r12 = r11.size();
    L10:
        if (r12 >= r11.size()) goto L15;
        if (((AppInfo) r11.get(r12)).appPackageName.equals(r10.appPackageName) == true) goto L13;
        r12 = r12 + 1;
        goto L10
    L13:
        boolean r13 = true;
    L17:
        if (this.mMyAppListData.noDownloadAfterDequeue(r11) == false) goto L19;
        r11.remove(this.mMyAppListData.HEADER_DOWNLOAD_QUEUE);
    L19:
        final int r14 = r11.indexOf(r10);
        if (r11.contains(this.mMyAppListData.HEADER_LOCAL_APP) == true) goto L22;
        r11.add(r11.size(), this.mMyAppListData.HEADER_LOCAL_APP);
    L22:
        final int r15 = r11.indexOf(this.mMyAppListData.HEADER_LOCAL_APP) + 1;
        r11.add(r15, r10);
        this.mLocalAppsOnlineAdapter.getDataList().clear();
        this.mLocalAppsOnlineAdapter.getDataList().addAll(r11);
        if (r13 == false) goto L27;
        j.a("Delete animation lost, thus new installed app not dequeue. Remove it. App: " + r10);
        this.mLocalAppsOnlineAdapter.getDataList().remove(r10);
        this.mLocalAppsOnlineAdapter.clearAnimation();
        this.mLocalAppsOnlineAdapter.notifyDataSetChanged();
        return;
    L27:
        if (isVisible(this.mLocalAppsListView, r14) == false) goto L29;
        j.a("request animate delete at position: " + r14 + ". App: " + r10);
        this.mLocalAppsOnlineAdapter.animateDelete(r14, new AnonymousClass3(this, r14));
    L31:
        if (isVisible(this.mLocalAppsListView, r15) == false) goto L33;
        j.a("request animate add at position: " + r15 + ". App: " + r10);
        this.mLocalAppsOnlineAdapter.animateAdd(r15, new AnonymousClass4(this, r15));
    L33:
        this.mLocalAppsOnlineAdapter.notifyDataSetChanged();
        return;
    L29:
        j.a("delete without animation at position: " + r14);
        this.mLocalAppsOnlineAdapter.getDataList().remove(r14);
        goto L31
    L15:
        r13 = false;
        goto L17
    L39:
        return;
    }

    public void animateNewDownloadEnqueue() {
        j.a("animateNewDownloadEnqueue");
        View r10 = this.lastClickedAppStatusView;
        AppInfo r11 = this.mCallback.getTaggedAppInfo(r10);
        if (r10 != null) goto L5;
        return;
    L5:
        if (this.mCallback.getItemRow(r10) == (-1)) goto L28;
        if (r11 != null) goto L8;
        return;
    L8:
        if (this.mAnimating == true) goto L31;
        int r12 = 0;
        this.mLocalAppsOnlineAdapter.setCanUpdate(false);
        ArrayList r13 = new ArrayList(this.mLocalAppsOnlineAdapter.getDataList());
        int r14 = r13.indexOf(r11);
        if (r13.contains(this.mMyAppListData.HEADER_DOWNLOAD_QUEUE) == true) goto L13;
        r13.add(0, this.mMyAppListData.HEADER_DOWNLOAD_QUEUE);
        r14 = r14 + 1;
    L13:
        int r15 = r13.indexOf(this.mMyAppListData.HEADER_LOCAL_APP);
        if (r15 != (-1)) goto L17;
        this.lastClickedAppStatusView = null;
        j.a("skip new download enqueue animation, pkg: " + r11.appPackageName);
        return;
    L17:
        r13.add(r15, r11);
        final int r16 = r14 + 1;
        this.mLocalAppsOnlineAdapter.getDataList().clear();
        this.mLocalAppsOnlineAdapter.getDataList().addAll(r13);
        int r17 = r13.indexOf(r11);
        if (isVisible(this.mLocalAppsListView, r17) == false) goto L20;
        this.mLocalAppsOnlineAdapter.animateAdd(r17, new AnonymousClass5(this));
    L20:
        this.mLocalAppsOnlineAdapter.animateDelete(r16, new AnonymousClass6(this, r16));
        MyAppSwipeListView r18 = this.mLocalAppsListView;
        View r19 = r18.getChildAt((r18.getHeaderViewsCount() + this.mCallback.getItemRow(r10)) - this.mLocalAppsListView.getFirstVisiblePosition());
        if (r19 == null) goto L23;
        r12 = r19.getTop();
    L23:
        this.mLocalAppsOnlineAdapter.notifyDataSetChanged();
        if (r12 == 0) goto L30;
        MyAppSwipeListView r20 = this.mLocalAppsListView;
        r20.setSelectionFromTop(r20.getHeaderViewsCount() + r16, r12);
        return;
    L30:
        return;
    L31:
        return;
    }

    public void dequeueDownload(AppInfo r10) {
        j.a("dequeue from download [ " + r10 + " ]");
        MyAppListData r11 = this.mMyAppListData;
        r11.mPendingDequeue = r10;
        List<AppInfo> r12 = r11.dequeue(r10);
        this.mLocalAppsOnlineAdapter.getDataList().clear();
        this.mLocalAppsOnlineAdapter.getDataList().addAll(r12);
        int r13 = r12.indexOf(r10);
        if (isVisible(this.mLocalAppsListView, r13) == false) goto L5;
        this.mLocalAppsOnlineAdapter.animateAdd(r13, new AnonymousClass2(this));
    L5:
        this.mLocalAppsOnlineAdapter.notifyDataSetChanged();
        this.mCallback.doCancelDownload(r10);
    }

    public AppInfo newAppInstalled() {
        List<AppInfo> r10 = this.mLocalAppsOnlineAdapter.getDataList();
        int r11 = 0;
    L4:
        if (r11 >= r10.size()) goto L15;
        AppInfo r12 = r10.get(r11);
        if (this.mLocalAppsOnlineAdapter.getItemViewType(r11) != 0) goto L14;
        if (this.mCache.W(r12.appPackageName) == true) goto L14;
        if (this.mCache.U(r12.appPackageName) == true) goto L14;
        if (this.mCache.b0(r12.appPackageName) == false) goto L14;
        return r12;
    L14:
        r11 = r11 + 1;
        goto L4
    L15:
        return null;
    }

    public boolean newDownloadToEnqueue() {
        View r10 = this.lastClickedAppStatusView;
        if (r10 != null) goto L5;
        return false;
    L5:
        int r11 = this.mCallback.getItemRow(r10);
        if (r11 != (-1)) goto L8;
        return false;
    L8:
        AppInfo r12 = this.mCallback.getTaggedAppInfo(r10);
        if (r12 != null) goto L12;
        return false;
    L12:
        if (1 == this.mLocalAppsOnlineAdapter.getItemViewType(r11)) goto L14;
        return false;
    L14:
        return this.mCache.W(r12.appPackageName);
    }

    public void swipeOutDownloadItem(View r10, final MyAppSwipeItemView r11) {
        r11.dismissAnimation((AppInfo) r10.getTag(), new AnonymousClass1(this, r11));
    }
}
