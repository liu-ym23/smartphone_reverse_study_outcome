package com.bytedance.android.livesdk.viewmodel;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.locallife.dito.data.DitoNode;
import com.ss.android.dypay.api.DyPayConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b(\u0010)J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00068\u0006¢\u0006\f\n\u0004\b\u000f\u0010\t\u001a\u0004\b\u0010\u0010\u000bR(\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\t\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006¢\u0006\f\n\u0004\b\u0015\u0010\t\u001a\u0004\b\u0016\u0010\u000bR\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00068\u0006¢\u0006\f\n\u0004\b\u0018\u0010\t\u001a\u0004\b\u0019\u0010\u000bR\u001d\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00068\u0006¢\u0006\f\n\u0004\b\u001b\u0010\t\u001a\u0004\b\u001c\u0010\u000bR\"\u0010\u001d\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001d\u0010\u001f\"\u0004\b \u0010!R\"\u0010\"\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u001e\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!R\"\u0010%\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010\u001e\u001a\u0004\b&\u0010\u001f\"\u0004\b'\u0010!¨\u0006*"}, d2 = {"Lcom/bytedance/android/livesdk/viewmodel/SingleDrawViewModel;", "Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/LifecycleOwner;", "owner", "", "clear", "Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "", "tabRefresh", "Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "getTabRefresh", "()Lcom/bytedance/ies/sdk/widgets/NextLiveData;", DitoNode.LOAD_MORE, "getLoadMore", "Lcom/bytedance/android/livesdk/viewmodel/j;", "itemsUpdate", "getItemsUpdate", "changeTab", "getChangeTab", "setChangeTab", "(Lcom/bytedance/ies/sdk/widgets/NextLiveData;)V", "onRoomSelect", "getOnRoomSelect", "", "closeDialog", "getCloseDialog", "Lcom/bytedance/android/livesdk/viewmodel/i;", DyPayConstant.KEY_SHOW_LOADING, "getShowLoading", "isFetchingData", "Z", "()Z", "setFetchingData", "(Z)V", "openSearch", "getOpenSearch", "setOpenSearch", "openHistory", "getOpenHistory", "setOpenHistory", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SingleDrawViewModel extends ViewModel {
    private NextLiveData<Long> changeTab;
    private final NextLiveData<Boolean> closeDialog;
    private boolean isFetchingData;
    private final NextLiveData<j> itemsUpdate;
    private final NextLiveData<Long> loadMore;
    private final NextLiveData<Long> onRoomSelect;
    private boolean openHistory;
    private boolean openSearch;
    private final NextLiveData<i> showLoading;
    private final NextLiveData<Long> tabRefresh;

    public SingleDrawViewModel() {
        this.tabRefresh = new NextLiveData();
        this.loadMore = new NextLiveData();
        this.itemsUpdate = new NextLiveData();
        this.changeTab = new NextLiveData();
        this.onRoomSelect = new NextLiveData();
        this.closeDialog = new NextLiveData();
        this.showLoading = new NextLiveData();
    }

    public final NextLiveData<Long> getChangeTab() {
        return this.changeTab;
    }

    public final NextLiveData<Boolean> getCloseDialog() {
        return this.closeDialog;
    }

    public final NextLiveData<j> getItemsUpdate() {
        return this.itemsUpdate;
    }

    public final NextLiveData<Long> getLoadMore() {
        return this.loadMore;
    }

    public final NextLiveData<Long> getOnRoomSelect() {
        return this.onRoomSelect;
    }

    public final boolean getOpenHistory() {
        return this.openHistory;
    }

    public final boolean getOpenSearch() {
        return this.openSearch;
    }

    public final NextLiveData<i> getShowLoading() {
        return this.showLoading;
    }

    public final NextLiveData<Long> getTabRefresh() {
        return this.tabRefresh;
    }

    public final boolean isFetchingData() {
        return this.isFetchingData;
    }

    public final void clear(LifecycleOwner r100) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        this.tabRefresh.removeObservers(r100);
        this.loadMore.removeObservers(r100);
        this.itemsUpdate.removeObservers(r100);
        this.changeTab.removeObservers(r100);
        this.onRoomSelect.removeObservers(r100);
        this.closeDialog.removeObservers(r100);
        this.showLoading.removeObservers(r100);
    }

    public final void setChangeTab(NextLiveData<Long> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.changeTab = r100;
    }

    public final void setFetchingData(boolean r100) {
        this.isFetchingData = r100;
    }

    public final void setOpenHistory(boolean r100) {
        this.openHistory = r100;
    }

    public final void setOpenSearch(boolean r100) {
        this.openSearch = r100;
    }
}
