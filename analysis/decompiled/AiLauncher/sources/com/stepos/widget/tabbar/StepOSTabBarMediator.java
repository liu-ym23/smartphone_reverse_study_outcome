package com.stepos.widget.tabbar;

import Y8.t;
import android.os.Trace;
import android.util.Log;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.widget.internal.StepOSTrace;
import com.stepos.widget.tabbar.StepOSTabBarMediator;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 U2\u00020\u0001:\u0004VWXUB+\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bB+\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u000fJ\u0017\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\rH\u0002¢\u0006\u0004\b\u001b\u0010\u000fJ\u0017\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\rH\u0002¢\u0006\u0004\b\u001f\u0010\u000fJ\u000f\u0010 \u001a\u00020\rH\u0002¢\u0006\u0004\b \u0010\u000fJ\u000f\u0010\"\u001a\u00020!H\u0002¢\u0006\u0004\b\"\u0010#J\u001b\u0010&\u001a\u00020\r2\n\u0010%\u001a\u0006\u0012\u0002\b\u00030$H\u0002¢\u0006\u0004\b&\u0010'J\u001d\u0010*\u001a\u00020\r2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\r0(H\u0002¢\u0006\u0004\b*\u0010+J\u0017\u0010,\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0003¢\u0006\u0004\b,\u0010-J\u0019\u0010/\u001a\u00020\u00152\b\b\u0001\u0010.\u001a\u00020\u0015H\u0002¢\u0006\u0004\b/\u0010-J)\u00102\u001a\u00020\u00152\u0006\u00100\u001a\u00020!2\u0006\u00101\u001a\u00020\u00152\b\b\u0001\u0010.\u001a\u00020\u0015H\u0002¢\u0006\u0004\b2\u00103J\r\u00104\u001a\u00020\r¢\u0006\u0004\b4\u0010\u000fJ\r\u00105\u001a\u00020\r¢\u0006\u0004\b5\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u00106R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u00107R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u00108R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u00109R\u001c\u0010:\u001a\b\u0012\u0002\b\u0003\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010=\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010@\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010AR$\u0010C\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r\u0018\u00010B8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010E\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010G\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u00109R\u0016\u0010H\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010J\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010IR\u0016\u0010K\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u00109R\u0016\u0010L\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u00109R\u0014\u0010N\u001a\u00020M8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010OR\"\u0010P\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bP\u00109\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\u0011\u0010T\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\bT\u0010Q¨\u0006Y"}, d2 = {"Lcom/stepos/widget/tabbar/StepOSTabBarMediator;", "", "Lcom/stepos/widget/tabbar/StepOSTabBar;", "tabBar", "Landroidx/viewpager2/widget/ViewPager2;", "viewPager", "Lcom/stepos/widget/tabbar/StepOSTabBarMediator$TabConfigurationStrategy;", "strategy", "", "autoRefresh", "<init>", "(Lcom/stepos/widget/tabbar/StepOSTabBar;Landroidx/viewpager2/widget/ViewPager2;Lcom/stepos/widget/tabbar/StepOSTabBarMediator$TabConfigurationStrategy;Z)V", "(Lcom/stepos/widget/tabbar/StepOSTabBar;Landroidx/viewpager2/widget/ViewPager2;ZLcom/stepos/widget/tabbar/StepOSTabBarMediator$TabConfigurationStrategy;)V", "LY8/t;", "wire", "()V", "unwire", "Lcom/stepos/widget/tabbar/StepOSTab;", "tab", "onTabSelectionCommitted", "(Lcom/stepos/widget/tabbar/StepOSTab;)V", "", "pagePosition", "animate", "updateIndicator", "alignTabToPager", "(IZZ)V", "populateTabsFromPagerAdapter", "pageCount", "checkExistingTabsUsable", "(I)V", "adoptExistingTabs", "refreshExistingTabsAfterAdapterChange", "", "snapshotExistingTabItemIds", "()[I", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "adapter", "checkPagerAdapterUnchanged", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V", "Lkotlin/Function0;", "action", "syncOnce", "(Lp9/a;)V", "itemIdForPage", "(I)I", "itemId", "pageForItemId", "itemIds", com.stepos.ailauncher.container.wallpaper.a.PHASE_END, "indexOfItemId", "([III)I", "attach", "detach", "Lcom/stepos/widget/tabbar/StepOSTabBar;", "Landroidx/viewpager2/widget/ViewPager2;", "Lcom/stepos/widget/tabbar/StepOSTabBarMediator$TabConfigurationStrategy;", "Z", "pagerAdapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/viewpager2/widget/ViewPager2$i;", "pageChangeCallback", "Landroidx/viewpager2/widget/ViewPager2$i;", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "adapterObserver", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "Lkotlin/Function1;", "committedHook", "Lp9/l;", "pageItemIds", "[I", "syncing", "scrollState", "I", "previousScrollState", "attached", "wired", "Landroid/view/View$OnAttachStateChangeListener;", "windowAttachListener", "Landroid/view/View$OnAttachStateChangeListener;", "isSmoothScrollEnabled", "()Z", "setSmoothScrollEnabled", "(Z)V", "isAttached", "Companion", "TabConfigurationStrategy", "PagerPageChangeCallback", "PagerAdapterObserver", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StepOSTabBarMediator {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int[] EMPTY_PAGE_ITEM_IDS = new int[0];
    private static final String TAG = "StepOSTabBarMediator";
    private RecyclerView.AdapterDataObserver adapterObserver;
    private boolean attached;
    private final boolean autoRefresh;
    private InterfaceC5074l<? super StepOSTab, t> committedHook;
    private boolean isSmoothScrollEnabled;
    private ViewPager2.i pageChangeCallback;
    private int[] pageItemIds;
    private RecyclerView.Adapter<?> pagerAdapter;
    private int previousScrollState;
    private int scrollState;
    private final TabConfigurationStrategy strategy;
    private boolean syncing;
    private final StepOSTabBar tabBar;
    private final ViewPager2 viewPager;
    private final View.OnAttachStateChangeListener windowAttachListener;
    private boolean wired;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007R\u000e\u0010\f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/stepos/widget/tabbar/StepOSTabBarMediator$Companion;", "", "<init>", "()V", "forExistingTabs", "Lcom/stepos/widget/tabbar/StepOSTabBarMediator;", "tabBar", "Lcom/stepos/widget/tabbar/StepOSTabBar;", "viewPager", "Landroidx/viewpager2/widget/ViewPager2;", "autoRefresh", "", "TAG", "", "EMPTY_PAGE_ITEM_IDS", "", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public static /* synthetic */ StepOSTabBarMediator forExistingTabs$default(Companion companion, StepOSTabBar stepOSTabBar, ViewPager2 viewPager2, boolean z10, int i10, Object obj) {
            if ((i10 & 4) != 0) {
                z10 = true;
            }
            return companion.forExistingTabs(stepOSTabBar, viewPager2, z10);
        }

        public final StepOSTabBarMediator forExistingTabs(StepOSTabBar tabBar, ViewPager2 viewPager) {
            kotlin.jvm.internal.p.i(tabBar, "tabBar");
            kotlin.jvm.internal.p.i(viewPager, "viewPager");
            return forExistingTabs$default(this, tabBar, viewPager, false, 4, null);
        }

        private Companion() {
        }

        public final StepOSTabBarMediator forExistingTabs(StepOSTabBar tabBar, ViewPager2 viewPager, boolean autoRefresh) {
            kotlin.jvm.internal.p.i(tabBar, "tabBar");
            kotlin.jvm.internal.p.i(viewPager, "viewPager");
            return new StepOSTabBarMediator(tabBar, viewPager, null, autoRefresh, null);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\t\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ)\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\n\u0010\u000eJ\u001f\u0010\u000f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000f\u0010\u000bJ\u001f\u0010\u0010\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0010\u0010\u000bJ'\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/stepos/widget/tabbar/StepOSTabBarMediator$PagerAdapterObserver;", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "<init>", "(Lcom/stepos/widget/tabbar/StepOSTabBarMediator;)V", "LY8/t;", "onChanged", "()V", "", "positionStart", "itemCount", "onItemRangeChanged", "(II)V", "", "payload", "(IILjava/lang/Object;)V", "onItemRangeInserted", "onItemRangeRemoved", "fromPosition", "toPosition", "onItemRangeMoved", "(III)V", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public final class PagerAdapterObserver extends RecyclerView.AdapterDataObserver {
        public PagerAdapterObserver() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            if (StepOSTabBarMediator.this.strategy != null) {
                StepOSTabBarMediator.this.populateTabsFromPagerAdapter();
            } else {
                StepOSTabBarMediator.this.refreshExistingTabsAfterAdapterChange();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int positionStart, int itemCount) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int positionStart, int itemCount) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int fromPosition, int toPosition, int itemCount) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int positionStart, int itemCount) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int positionStart, int itemCount, Object payload) {
            onChanged();
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\r\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\b¨\u0006\u0010"}, d2 = {"Lcom/stepos/widget/tabbar/StepOSTabBarMediator$PagerPageChangeCallback;", "Landroidx/viewpager2/widget/ViewPager2$i;", "<init>", "(Lcom/stepos/widget/tabbar/StepOSTabBarMediator;)V", "", VoiceWakeupReceiver.EXTRA_STATE, "LY8/t;", "onPageScrollStateChanged", "(I)V", "position", "", "positionOffset", "positionOffsetPixels", "onPageScrolled", "(IFI)V", "onPageSelected", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public final class PagerPageChangeCallback extends ViewPager2.i {
        public PagerPageChangeCallback() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final t onPageSelected$lambda$0(StepOSTabBarMediator stepOSTabBarMediator, int i10, boolean z10, boolean z11) {
            stepOSTabBarMediator.alignTabToPager(i10, z10, z11);
            return t.f7040a;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.i
        public void onPageScrollStateChanged(int state) {
            StepOSTabBarMediator stepOSTabBarMediator = StepOSTabBarMediator.this;
            stepOSTabBarMediator.previousScrollState = stepOSTabBarMediator.scrollState;
            StepOSTabBarMediator.this.scrollState = state;
            if (state == 0) {
                StepOSTabBarMediator.this.tabBar.endPagerIndicatorTracking$StepOSWidget_release();
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.i
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            StepOSTabBarMediator.this.tabBar.setIndicatorPositionFromPage$StepOSWidget_release(position, positionOffset);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.i
        public void onPageSelected(final int position) {
            final boolean z10 = StepOSTabBarMediator.this.scrollState == 0 || (StepOSTabBarMediator.this.scrollState == 2 && StepOSTabBarMediator.this.previousScrollState == 0);
            final boolean z11 = StepOSTabBarMediator.this.scrollState != 1;
            final StepOSTabBarMediator stepOSTabBarMediator = StepOSTabBarMediator.this;
            stepOSTabBarMediator.syncOnce(new InterfaceC5063a() { // from class: com.stepos.widget.tabbar.n
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return StepOSTabBarMediator.PagerPageChangeCallback.onPageSelected$lambda$0(stepOSTabBarMediator, position, z11, z10);
                }
            });
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/stepos/widget/tabbar/StepOSTabBarMediator$TabConfigurationStrategy;", "", "Lcom/stepos/widget/tabbar/StepOSTab;", "tab", "", "position", "LY8/t;", "onConfigureTab", "(Lcom/stepos/widget/tabbar/StepOSTab;I)V", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface TabConfigurationStrategy {
        void onConfigureTab(StepOSTab tab, int position);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSTabBarMediator(StepOSTabBar tabBar, ViewPager2 viewPager, TabConfigurationStrategy strategy) {
        this(tabBar, viewPager, false, strategy, 4, null);
        kotlin.jvm.internal.p.i(tabBar, "tabBar");
        kotlin.jvm.internal.p.i(viewPager, "viewPager");
        kotlin.jvm.internal.p.i(strategy, "strategy");
    }

    private final void adoptExistingTabs() {
        RecyclerView.Adapter<?> adapter = this.pagerAdapter;
        if (adapter == null) {
            return;
        }
        checkPagerAdapterUnchanged(adapter);
        int[] iArrSnapshotExistingTabItemIds = snapshotExistingTabItemIds();
        this.pageItemIds = iArrSnapshotExistingTabItemIds;
        if (iArrSnapshotExistingTabItemIds.length == 0) {
            return;
        }
        syncOnce(new InterfaceC5063a() { // from class: com.stepos.widget.tabbar.m
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return StepOSTabBarMediator.adoptExistingTabs$lambda$15(this.f31378a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t adoptExistingTabs$lambda$15(StepOSTabBarMediator stepOSTabBarMediator) {
        stepOSTabBarMediator.alignTabToPager(stepOSTabBarMediator.viewPager.getCurrentItem(), false, true);
        return t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void alignTabToPager(int pagePosition, boolean animate, boolean updateIndicator) {
        int iItemIdForPage = itemIdForPage(pagePosition);
        if (iItemIdForPage == 0) {
            return;
        }
        StepOSTab stepOSTabFindTabById = this.tabBar.findTabById(iItemIdForPage);
        if (stepOSTabFindTabById == null) {
            Log.w(TAG, "ViewPager2 停在第 " + pagePosition + " 页，但对应页签（itemId=0x" + Integer.toHexString(iItemIdForPage) + "）已不在 StepOSTabBar 里（被 removeTab 了？）。页签选中态保持不变。要屏蔽一页请把它从 adapter 里去掉，而不是只摘页签");
            return;
        }
        if (stepOSTabFindTabById.getVisible() && stepOSTabFindTabById.getEnabled()) {
            if (this.tabBar.getSelectedItemIdValue() == iItemIdForPage) {
                return;
            }
            this.tabBar.setSelectedItemId$StepOSWidget_release(iItemIdForPage, animate, updateIndicator);
            return;
        }
        Log.w(TAG, "ViewPager2 停在第 " + pagePosition + " 页，但对应页签 " + stepOSTabFindTabById + " 当前不可见 / 不可用，页签上没有任何项能表示这一页。页签选中态保持不变（不抛异常、也不乱选）。要真正屏蔽一页请同时把它从 adapter 里去掉 —— 只 setVisible(false) 不动 adapter 属于半吊子状态");
    }

    private final void checkExistingTabsUsable(int pageCount) {
        if (this.tabBar.getTabCount() != pageCount) {
            throw new IllegalStateException(("StepOSTabBarMediator 处于「尊重已有页签」模式（经 forExistingTabs(...) 创建，没有 TabConfigurationStrategy），但页签数与页数对不上：StepOSTabBar.tabCount=" + this.tabBar.getTabCount() + "，ViewPager2 的 adapter.itemCount=" + pageCount + "。本模式不重建页签，页与页签必须按下标 1:1 对应。两条出路：① 让两边相等 —— 改 app:steposTabBarMenu / inflateMenu() 的项数，或改 adapter 的页数；② 改用带 TabConfigurationStrategy 的构造函数 StepOSTabBarMediator(tabBar, viewPager) { tab, position -> ... }，由 Mediator 按 adapter.itemCount 重建页签（menu 填进来的项会被清掉）").toString());
        }
        int tabCount = this.tabBar.getTabCount();
        for (int i10 = 0; i10 < tabCount; i10++) {
            StepOSTab tabAt = this.tabBar.getTabAt(i10);
            if (tabAt == null || tabAt.getItemId() == 0) {
                throw new IllegalStateException(("第 " + i10 + " 个页签没有 itemId（StepOSTabBar.NO_ID）：「尊重已有页签」模式全靠 itemId 把页签与 ViewPager2 的页对齐，没有 itemId 的页签永远无法被选中。inflateMenu() 会强制每个 <item> 带 android:id；代码建的页签请在 addTab() 前 setItemId(R.id.xxx)").toString());
            }
        }
    }

    private final void checkPagerAdapterUnchanged(RecyclerView.Adapter<?> adapter) {
        if (this.viewPager.getAdapter() != adapter) {
            throw new IllegalStateException("attach() 之后 ViewPager2 换过 adapter：本 Mediator 的数据观察者仍挂在旧 adapter 上，页签与页面已经对不齐了。换 adapter 的正确姿势是 detach() → viewPager.adapter = 新的 → attach()");
        }
    }

    public static final StepOSTabBarMediator forExistingTabs(StepOSTabBar stepOSTabBar, ViewPager2 viewPager2) {
        return INSTANCE.forExistingTabs(stepOSTabBar, viewPager2);
    }

    private final int indexOfItemId(int[] itemIds, int end, int itemId) {
        for (int i10 = 0; i10 < end; i10++) {
            if (itemIds[i10] == itemId) {
                return i10;
            }
        }
        return -1;
    }

    private final int itemIdForPage(int pagePosition) {
        if (pagePosition < 0) {
            return 0;
        }
        int[] iArr = this.pageItemIds;
        if (pagePosition < iArr.length) {
            return iArr[pagePosition];
        }
        return 0;
    }

    private final void onTabSelectionCommitted(final StepOSTab tab) {
        if (this.attached) {
            syncOnce(new InterfaceC5063a() { // from class: com.stepos.widget.tabbar.i
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return StepOSTabBarMediator.onTabSelectionCommitted$lambda$8(this.f31373a, tab);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t onTabSelectionCommitted$lambda$8(StepOSTabBarMediator stepOSTabBarMediator, StepOSTab stepOSTab) {
        int iPageForItemId = stepOSTabBarMediator.pageForItemId(stepOSTab.getItemId());
        if (iPageForItemId == -1) {
            Log.w(TAG, "页签 " + stepOSTab + " 被选中，但它在 ViewPager2 里没有对应页 —— 它不在 attach() 时记下的「页序号 → itemId」快照里（attach() 之后又 addTab / setItemId 了？）。pager 保持不动。「Mediator 拥有页签」模式下要增减页请改 adapter（autoRefresh=true 时页签会跟着重建）；「尊重已有页签」模式下页签与 adapter 都要一起改，再 detach() + attach()");
            return t.f7040a;
        }
        if (stepOSTabBarMediator.viewPager.getCurrentItem() == iPageForItemId) {
            return t.f7040a;
        }
        boolean z10 = stepOSTabBarMediator.isSmoothScrollEnabled;
        StepOSTrace stepOSTrace = StepOSTrace.INSTANCE;
        Trace.beginSection("StepOS:" + (z10 ? "Mediator.setCurrentItem.smooth" : "Mediator.setCurrentItem.jump"));
        try {
            stepOSTabBarMediator.viewPager.m(iPageForItemId, z10);
            t tVar = t.f7040a;
            Trace.endSection();
            return t.f7040a;
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    private final int pageForItemId(int itemId) {
        if (itemId == 0) {
            return -1;
        }
        int[] iArr = this.pageItemIds;
        return indexOfItemId(iArr, iArr.length, itemId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void populateTabsFromPagerAdapter() {
        RecyclerView.Adapter<?> adapter = this.pagerAdapter;
        if (adapter == null) {
            return;
        }
        TabConfigurationStrategy tabConfigurationStrategy = this.strategy;
        if (tabConfigurationStrategy == null) {
            throw new IllegalStateException("populateTabsFromPagerAdapter() 只能在有 TabConfigurationStrategy 时调用");
        }
        checkPagerAdapterUnchanged(adapter);
        int itemCount = adapter.getItemCount();
        int[] iArr = new int[itemCount];
        this.tabBar.removeAllTabs();
        for (int i10 = 0; i10 < itemCount; i10++) {
            StepOSTab stepOSTabNewTab = this.tabBar.newTab();
            tabConfigurationStrategy.onConfigureTab(stepOSTabNewTab, i10);
            if (stepOSTabNewTab.getItemId() == 0) {
                throw new IllegalArgumentException(("TabConfigurationStrategy.onConfigureTab(tab, " + i10 + ") 没有给 tab 设 itemId：请在 strategy 里调 tab.setItemId(R.id.xxx)。itemId 是页签的身份依据（选中、转屏恢复、与 ViewPager2 对齐都靠它）").toString());
            }
            int iIndexOfItemId = indexOfItemId(iArr, i10, stepOSTabNewTab.getItemId());
            if (iIndexOfItemId != -1) {
                throw new IllegalArgumentException(("TabConfigurationStrategy 给第 " + iIndexOfItemId + " 页和第 " + i10 + " 页设了同一个 itemId(0x" + Integer.toHexString(stepOSTabNewTab.getItemId()) + ")：同一个 StepOSTabBar 内 itemId 必须唯一，否则无法区分该选中哪一个。请给每页一个独立的 @id").toString());
            }
            iArr[i10] = stepOSTabNewTab.getItemId();
            this.tabBar.addTab(stepOSTabNewTab, i10, false);
        }
        this.pageItemIds = iArr;
        if (itemCount == 0) {
            return;
        }
        syncOnce(new InterfaceC5063a() { // from class: com.stepos.widget.tabbar.k
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return StepOSTabBarMediator.populateTabsFromPagerAdapter$lambda$12(this.f31376a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t populateTabsFromPagerAdapter$lambda$12(StepOSTabBarMediator stepOSTabBarMediator) {
        stepOSTabBarMediator.alignTabToPager(stepOSTabBarMediator.viewPager.getCurrentItem(), false, true);
        return t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void refreshExistingTabsAfterAdapterChange() {
        RecyclerView.Adapter<?> adapter = this.pagerAdapter;
        if (adapter == null) {
            return;
        }
        checkPagerAdapterUnchanged(adapter);
        int itemCount = adapter.getItemCount();
        if (this.tabBar.getTabCount() == itemCount) {
            this.pageItemIds = snapshotExistingTabItemIds();
            if (itemCount == 0) {
                return;
            }
            syncOnce(new InterfaceC5063a() { // from class: com.stepos.widget.tabbar.l
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return StepOSTabBarMediator.refreshExistingTabsAfterAdapterChange$lambda$16(this.f31377a);
                }
            });
            return;
        }
        Log.w(TAG, "adapter 数据变化后页签数与页数对不上：StepOSTabBar.tabCount=" + this.tabBar.getTabCount() + "，adapter.itemCount=" + itemCount + "。本 Mediator 处于「尊重已有页签」模式（没有 TabConfigurationStrategy），没有重建页签的依据，已保持页签原样、不抛异常 —— 对不上的那些页在页签上没有表示。要让页签随 adapter 自动重建请改用带 TabConfigurationStrategy 的构造函数；要继续用 menu XML 驱动，请在改完 adapter 后自己 inflateMenu() / addTab() 把页签补齐，再 detach() + attach() 重新对齐");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t refreshExistingTabsAfterAdapterChange$lambda$16(StepOSTabBarMediator stepOSTabBarMediator) {
        stepOSTabBarMediator.alignTabToPager(stepOSTabBarMediator.viewPager.getCurrentItem(), false, true);
        return t.f7040a;
    }

    private final int[] snapshotExistingTabItemIds() {
        int tabCount = this.tabBar.getTabCount();
        int[] iArr = new int[tabCount];
        for (int i10 = 0; i10 < tabCount; i10++) {
            StepOSTab tabAt = this.tabBar.getTabAt(i10);
            iArr[i10] = tabAt != null ? tabAt.getItemId() : 0;
        }
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void syncOnce(InterfaceC5063a<t> action) {
        if (this.syncing) {
            return;
        }
        this.syncing = true;
        try {
            action.invoke();
        } finally {
            this.syncing = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void unwire() {
        RecyclerView.Adapter<?> adapter;
        if (this.wired) {
            RecyclerView.AdapterDataObserver adapterDataObserver = this.adapterObserver;
            if (adapterDataObserver != null && (adapter = this.pagerAdapter) != null) {
                adapter.unregisterAdapterDataObserver(adapterDataObserver);
            }
            this.adapterObserver = null;
            ViewPager2.i iVar = this.pageChangeCallback;
            if (iVar != null) {
                this.viewPager.r(iVar);
            }
            this.pageChangeCallback = null;
            if (this.tabBar.getSelectionCommittedHook$StepOSWidget_release() == this.committedHook) {
                this.tabBar.setSelectionCommittedHook$StepOSWidget_release(null);
            }
            this.committedHook = null;
            this.previousScrollState = 0;
            this.scrollState = 0;
            this.syncing = false;
            this.wired = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void wire() {
        RecyclerView.Adapter<?> adapter;
        if (this.wired || (adapter = this.pagerAdapter) == null) {
            return;
        }
        this.previousScrollState = 0;
        this.scrollState = 0;
        this.syncing = false;
        PagerPageChangeCallback pagerPageChangeCallback = new PagerPageChangeCallback();
        this.pageChangeCallback = pagerPageChangeCallback;
        this.viewPager.j(pagerPageChangeCallback);
        InterfaceC5074l<? super StepOSTab, t> interfaceC5074l = new InterfaceC5074l() { // from class: com.stepos.widget.tabbar.j
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return StepOSTabBarMediator.wire$lambda$3(this.f31375a, (StepOSTab) obj);
            }
        };
        this.committedHook = interfaceC5074l;
        this.tabBar.setSelectionCommittedHook$StepOSWidget_release(interfaceC5074l);
        if (this.autoRefresh) {
            PagerAdapterObserver pagerAdapterObserver = new PagerAdapterObserver();
            this.adapterObserver = pagerAdapterObserver;
            adapter.registerAdapterDataObserver(pagerAdapterObserver);
        }
        this.wired = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t wire$lambda$3(StepOSTabBarMediator stepOSTabBarMediator, StepOSTab tab) {
        kotlin.jvm.internal.p.i(tab, "tab");
        stepOSTabBarMediator.onTabSelectionCommitted(tab);
        return t.f7040a;
    }

    public final void attach() {
        if (this.attached) {
            throw new IllegalStateException("StepOSTabBarMediator 已经 attach 过了，不能重复 attach：attach() / detach() 必须成对。要换 adapter、换 TabConfigurationStrategy 或换页签内容，请先 detach() 再 attach()（换 strategy 需要新建一个 Mediator）");
        }
        RecyclerView.Adapter<?> adapter = this.viewPager.getAdapter();
        if (adapter == null) {
            throw new IllegalStateException("attach() 之前必须先给 ViewPager2 设 adapter：两种模式都要它 —— 「Mediator 拥有页签」按 adapter.itemCount 逐页建页签，「尊重已有页签」按 adapter.itemCount 校验页签数。请把 viewPager.adapter = ... 放到 attach() 前面");
        }
        if (this.tabBar.getSelectionCommittedHook$StepOSWidget_release() != null) {
            throw new IllegalStateException("这个 StepOSTabBar 上已经挂了另一个 StepOSTabBarMediator：一个页签控件同时联动两个 ViewPager2 无法定义（点一下该切哪个？）。请先把上一个 Mediator detach()");
        }
        if (this.strategy == null) {
            checkExistingTabsUsable(adapter.getItemCount());
        }
        this.pagerAdapter = adapter;
        this.attached = true;
        wire();
        this.tabBar.addOnAttachStateChangeListener(this.windowAttachListener);
        this.viewPager.addOnAttachStateChangeListener(this.windowAttachListener);
        if (this.strategy != null) {
            populateTabsFromPagerAdapter();
        } else {
            adoptExistingTabs();
        }
    }

    public final void detach() {
        if (!this.attached) {
            throw new IllegalStateException("StepOSTabBarMediator 还没 attach()（或已经 detach 过了），不能 detach：attach() / detach() 必须成对，通常 attach() 放 onCreate / onViewCreated，detach() 放 onDestroy / onDestroyView。当前状态可以用 isAttached 查");
        }
        this.tabBar.removeOnAttachStateChangeListener(this.windowAttachListener);
        this.viewPager.removeOnAttachStateChangeListener(this.windowAttachListener);
        unwire();
        this.pagerAdapter = null;
        this.pageItemIds = EMPTY_PAGE_ITEM_IDS;
        this.attached = false;
    }

    /* renamed from: isAttached, reason: from getter */
    public final boolean getAttached() {
        return this.attached;
    }

    /* renamed from: isSmoothScrollEnabled, reason: from getter */
    public final boolean getIsSmoothScrollEnabled() {
        return this.isSmoothScrollEnabled;
    }

    public final void setSmoothScrollEnabled(boolean z10) {
        this.isSmoothScrollEnabled = z10;
    }

    public /* synthetic */ StepOSTabBarMediator(StepOSTabBar stepOSTabBar, ViewPager2 viewPager2, TabConfigurationStrategy tabConfigurationStrategy, boolean z10, kotlin.jvm.internal.i iVar) {
        this(stepOSTabBar, viewPager2, tabConfigurationStrategy, z10);
    }

    public static final StepOSTabBarMediator forExistingTabs(StepOSTabBar stepOSTabBar, ViewPager2 viewPager2, boolean z10) {
        return INSTANCE.forExistingTabs(stepOSTabBar, viewPager2, z10);
    }

    private StepOSTabBarMediator(StepOSTabBar stepOSTabBar, ViewPager2 viewPager2, TabConfigurationStrategy tabConfigurationStrategy, boolean z10) {
        this.tabBar = stepOSTabBar;
        this.viewPager = viewPager2;
        this.strategy = tabConfigurationStrategy;
        this.autoRefresh = z10;
        this.pageItemIds = EMPTY_PAGE_ITEM_IDS;
        this.windowAttachListener = new StepOSTabBarMediator$windowAttachListener$1(this);
        this.isSmoothScrollEnabled = true;
    }

    public /* synthetic */ StepOSTabBarMediator(StepOSTabBar stepOSTabBar, ViewPager2 viewPager2, boolean z10, TabConfigurationStrategy tabConfigurationStrategy, int i10, kotlin.jvm.internal.i iVar) {
        this(stepOSTabBar, viewPager2, (i10 & 4) != 0 ? true : z10, tabConfigurationStrategy);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSTabBarMediator(StepOSTabBar tabBar, ViewPager2 viewPager, boolean z10, TabConfigurationStrategy strategy) {
        this(tabBar, viewPager, strategy, z10);
        kotlin.jvm.internal.p.i(tabBar, "tabBar");
        kotlin.jvm.internal.p.i(viewPager, "viewPager");
        kotlin.jvm.internal.p.i(strategy, "strategy");
    }
}
