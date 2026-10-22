package com.bytedance.android.livesdk.feed;

import androidx.lifecycle.ViewModel;
import com.bytedance.android.livesdk.feed.viewmodel.FragmentFeedViewModel;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\u0007R0\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\nj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004`\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\"\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/feed/LiveDrawerTabViewModel;", "Landroidx/lifecycle/ViewModel;", "", "tabId", "Lcom/bytedance/android/livesdk/feed/viewmodel/FragmentFeedViewModel;", "getTabViewModel", "viewModel", "", "putTabViewModel", "doClear", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "viewModelStore", "Ljava/util/HashMap;", "Lcom/bytedance/android/livesdk/feed/LiveDrawerTabViewModel$a;", "tabStatus", "Lcom/bytedance/android/livesdk/feed/LiveDrawerTabViewModel$a;", "getTabStatus", "()Lcom/bytedance/android/livesdk/feed/LiveDrawerTabViewModel$a;", "setTabStatus", "(Lcom/bytedance/android/livesdk/feed/LiveDrawerTabViewModel$a;)V", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livefeed_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveDrawerTabViewModel extends ViewModel {
    private a tabStatus;
    private final HashMap<Long, FragmentFeedViewModel> viewModelStore;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f123557a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f123558b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f123559c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f123560d;

        public a() {
            this.f123557a = -1;
            this.f123560d = -1;
        }
    }

    public final void doClear() {
        this.viewModelStore.clear();
    }

    public LiveDrawerTabViewModel() {
        this.viewModelStore = new HashMap();
        this.tabStatus = new a();
    }

    public final a getTabStatus() {
        return this.tabStatus;
    }

    public final FragmentFeedViewModel getTabViewModel(long r100) {
        return this.viewModelStore.get(Long.valueOf(r100));
    }

    public final void setTabStatus(a r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.tabStatus = r100;
    }

    public final void putTabViewModel(long r100, FragmentFeedViewModel r101) {
        Intrinsics.checkNotNullParameter(r101, "viewModel");
        this.viewModelStore.put(Long.valueOf(r100), r101);
    }
}
