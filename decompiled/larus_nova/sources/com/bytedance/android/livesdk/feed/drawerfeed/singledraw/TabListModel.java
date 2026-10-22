package com.bytedance.android.livesdk.feed.drawerfeed.singledraw;

import androidx.lifecycle.ViewModel;
import bw1.e;
import com.bytedance.android.live.base.model.banner.OperationCard;
import com.bytedance.android.live.base.model.banner.OperationMultipleRoom;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.livehostapi.business.IHostFeed;
import com.bytedance.android.livesdk.feed.IFeedRepository;
import com.bytedance.android.livesdk.feed.drawerfeed.singledraw.viewholder.OperationSingleDrawViewHolder;
import com.bytedance.android.livesdk.feed.x0;
import com.bytedance.android.livesdk.viewmodel.SingleDrawViewModel;
import com.bytedance.android.livesdk.viewmodel.j;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.feed.OpenRepisotoryKt;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import cw1.c;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 L2\u00020\u0001:\u0001MB\u0007¢\u0006\u0004\bJ\u0010KJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J&\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0001\u0010\f\u001a\u00020\u000bJ\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ\u0006\u0010\u0010\u001a\u00020\u0004R;\u0010\u0013\u001a&\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u000e0\u000e \u0012*\u0012\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u000e0\u000e\u0018\u00010\b0\u00118\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0018\u001a\u00020\u00178\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0018\u0010\u001aR$\u0010\u001b\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010\"\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R$\u0010(\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010#\u001a\u0004\b)\u0010%\"\u0004\b*\u0010'R$\u0010,\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u00102\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\"\u00108\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u00103\u001a\u0004\b9\u00105\"\u0004\b:\u00107R'\u0010=\u001a\u0012\u0012\u0004\u0012\u00020!0;j\b\u0012\u0004\u0012\u00020!`<8\u0006¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@R\u0014\u0010A\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010C\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\"\u0010E\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bE\u0010B\u001a\u0004\bF\u0010G\"\u0004\bH\u0010I¨\u0006N"}, d2 = {"Lcom/bytedance/android/livesdk/feed/drawerfeed/singledraw/TabListModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/bytedance/android/livesdk/viewmodel/SingleDrawViewModel;", "viewModel", "", "init", "", "tabId", "", "Lcom/bytedance/android/live/base/model/feed/FeedItem;", "feedList", "", "feedAction", "onDataUpdata", "Lcom/bytedance/android/livesdk/feed/feed/e;", "getFeedTabItem", "onDialogClose", "", "kotlin.jvm.PlatformType", "tabList", "Ljava/util/List;", "getTabList", "()Ljava/util/List;", "", "isMultiTab", "Z", "()Z", "defaultTab", "Lcom/bytedance/android/livesdk/feed/feed/e;", "getDefaultTab", "()Lcom/bytedance/android/livesdk/feed/feed/e;", "setDefaultTab", "(Lcom/bytedance/android/livesdk/feed/feed/e;)V", "Lbw1/e;", "currentTabModel", "Lbw1/e;", "getCurrentTabModel", "()Lbw1/e;", "setCurrentTabModel", "(Lbw1/e;)V", "chosenTab", "getChosenTab", "setChosenTab", "Lio/reactivex/disposables/Disposable;", "updateDisposable", "Lio/reactivex/disposables/Disposable;", "getUpdateDisposable", "()Lio/reactivex/disposables/Disposable;", "setUpdateDisposable", "(Lio/reactivex/disposables/Disposable;)V", "tagId", "J", "getTagId", "()J", "setTagId", "(J)V", "tabType", "getTabType", "setTabType", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "tabItemModelList", "Ljava/util/ArrayList;", "getTabItemModelList", "()Ljava/util/ArrayList;", "tabSize", "I", "singleDrawViewModel", "Lcom/bytedance/android/livesdk/viewmodel/SingleDrawViewModel;", "currentStatus", "getCurrentStatus", "()I", "setCurrentStatus", "(I)V", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livefeed_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TabListModel extends ViewModel {
    public static final a Companion = null;
    private static final String NEW_REQ_FROM_ENTER_AUTO = null;
    private static final String REQ_FROM_ENTER_AUTO = null;
    private static final String REQ_FROM_FEED_LOAD_MORE = null;
    private static final long TIME_REFRESH = 0;
    private e chosenTab;
    private int currentStatus;
    private e currentTabModel;
    private com.bytedance.android.livesdk.feed.feed.e defaultTab;
    private final boolean isMultiTab;
    private SingleDrawViewModel singleDrawViewModel;
    private final ArrayList<e> tabItemModelList;
    private final List<com.bytedance.android.livesdk.feed.feed.e> tabList;
    private final int tabSize;
    private long tabType;
    private long tagId;
    private Disposable updateDisposable;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TabListModel f123801a;

        public b(TabListModel r100) {
            this.f123801a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            this.f123801a.getTabItemModelList().clear();
            Disposable r102 = this.f123801a.getUpdateDisposable();
            if (r102 == null) goto L5;
            r102.dispose();
        L5:
            this.f123801a.setUpdateDisposable(null);
        }
    }

    static {
        Companion = new a();
        REQ_FROM_ENTER_AUTO = "enter_auto";
        REQ_FROM_FEED_LOAD_MORE = OpenRepisotoryKt.REQ_FROM_LOADMORE;
        NEW_REQ_FROM_ENTER_AUTO = "enter_auto_from_room";
        TIME_REFRESH = 5;
    }

    public final com.bytedance.android.livesdk.feed.feed.e getFeedTabItem() {
        List<com.bytedance.android.livesdk.feed.feed.e> r100 = this.tabList;
        Object r101 = null;
        if (r100 == null) goto L20;
        Iterator<T> r102 = r100.iterator();
    L6:
        if (r102.hasNext() == false) goto L14;
        Object r103 = r102.next();
        boolean r104 = true;
        if (((com.bytedance.android.livesdk.feed.feed.e) r103).getType() == 1) goto L11;
        r104 = false;
    L11:
        if (r104 == false) goto L6;
        r101 = r103;
    L14:
        return (com.bytedance.android.livesdk.feed.feed.e) r101;
    L20:
        return null;
    }

    public final void onDialogClose() {
        Observable<Long> r100 = Observable.timer(TIME_REFRESH, TimeUnit.MINUTES);
        if (r100 == null) goto L5;
        Disposable r101 = r100.subscribe(new b(this));
    L6:
        this.updateDisposable = r101;
        return;
    L5:
        r101 = null;
        goto L6
    }

    public TabListModel() {
        boolean r100 = x0.f124600d;
        List<com.bytedance.android.livesdk.feed.feed.e> r101 = x0.a.a().c();
        this.tabList = r101;
        this.isMultiTab = ((IHostFeed) k.n(IHostFeed.class)).shouldDrawerMultiTab();
        this.tagId = -1;
        this.tabType = -1;
        this.tabItemModelList = new ArrayList();
        this.tabSize = r101.size();
        this.currentStatus = -1;
    }

    public static final /* synthetic */ String access$getNEW_REQ_FROM_ENTER_AUTO$cp() {
        return NEW_REQ_FROM_ENTER_AUTO;
    }

    public static final /* synthetic */ String access$getREQ_FROM_ENTER_AUTO$cp() {
        return REQ_FROM_ENTER_AUTO;
    }

    public static final /* synthetic */ String access$getREQ_FROM_FEED_LOAD_MORE$cp() {
        return REQ_FROM_FEED_LOAD_MORE;
    }

    public static final /* synthetic */ long access$getTIME_REFRESH$cp() {
        return TIME_REFRESH;
    }

    public final e getChosenTab() {
        return this.chosenTab;
    }

    public final int getCurrentStatus() {
        return this.currentStatus;
    }

    public final e getCurrentTabModel() {
        return this.currentTabModel;
    }

    public final com.bytedance.android.livesdk.feed.feed.e getDefaultTab() {
        return this.defaultTab;
    }

    public final ArrayList<e> getTabItemModelList() {
        return this.tabItemModelList;
    }

    public final List<com.bytedance.android.livesdk.feed.feed.e> getTabList() {
        return this.tabList;
    }

    public final long getTabType() {
        return this.tabType;
    }

    public final long getTagId() {
        return this.tagId;
    }

    public final Disposable getUpdateDisposable() {
        return this.updateDisposable;
    }

    public final boolean isMultiTab() {
        return this.isMultiTab;
    }

    public final void init(SingleDrawViewModel r100) {
        this.singleDrawViewModel = r100;
        Disposable r101 = this.updateDisposable;
        if (r101 == null) goto L5;
        r101.dispose();
    L5:
        this.updateDisposable = null;
        if (this.tabItemModelList.size() <= 0) goto L9;
        return;
    L9:
        if (this.isMultiTab == false) goto L17;
        List<com.bytedance.android.livesdk.feed.feed.e> r102 = this.tabList;
        if (r102 == null) goto L21;
        Iterator<T> r103 = r102.iterator();
    L14:
        if (r103.hasNext() == false) goto L23;
        com.bytedance.android.livesdk.feed.feed.e r104 = (com.bytedance.android.livesdk.feed.feed.e) r103.next();
        this.tabItemModelList.add(new cw1.a(r104, this));
        goto L14
    L23:
        return;
    L21:
        return;
    L17:
        if (this.tabSize <= 0) goto L22;
        this.tabItemModelList.add(new c((com.bytedance.android.livesdk.feed.feed.e) ListProtector.get(this.tabList, 0), this));
        return;
    }

    public final void setChosenTab(e r100) {
        this.chosenTab = r100;
    }

    public final void setCurrentStatus(int r100) {
        this.currentStatus = r100;
    }

    public final void setCurrentTabModel(e r100) {
        this.currentTabModel = r100;
    }

    public final void setDefaultTab(com.bytedance.android.livesdk.feed.feed.e r100) {
        this.defaultTab = r100;
    }

    public final void setTabType(long r100) {
        this.tabType = r100;
    }

    public final void setTagId(long r100) {
        this.tagId = r100;
    }

    public final void setUpdateDisposable(Disposable r100) {
        this.updateDisposable = r100;
    }

    public final void onDataUpdata(long r110, List<? extends FeedItem> r111, @IFeedRepository.FEED_ACTION int r112) {
        Intrinsics.checkNotNullParameter(r111, "feedList");
        ArrayList r100 = new ArrayList();
        Iterator<T> r113 = r111.iterator();
    L3:
        boolean r101 = true;
        boolean r102 = false;
        Object r103 = null;
        Integer r104 = null;
        if (r113.hasNext() == false) goto L45;
        Object r105 = r113.next();
        FeedItem r106 = (FeedItem) r105;
        if (r106.type != 24) goto L27;
        OperationCard r107 = r106.operationCard;
        if (r107 == null) goto L10;
        Integer r108 = r107.type;
    L11:
        int r109 = OperationSingleDrawViewHolder.f123813x;
        if (r108 == null) goto L27;
        if (r108.intValue() != 3) goto L27;
        OperationCard r114 = r106.operationCard;
        if (r114 == null) goto L23;
        OperationMultipleRoom r115 = r114.operationMultipleRoom;
        if (r115 == null) goto L23;
        List<Room> r116 = r115.rooms;
        if (r116 == null) goto L23;
        int r117 = r116.size();
    L25:
        if (r117 >= 4) goto L27;
        boolean r118 = false;
    L29:
        if (r106.type != 24) goto L39;
        OperationCard r119 = r106.operationCard;
        if (r119 == null) goto L33;
        r104 = r119.type;
    L33:
        int r120 = OperationSingleDrawViewHolder.f123813x;
        if (r104 == null) goto L39;
        if (r104.intValue() != 1) goto L39;
        r118 = false;
    L39:
        SingleDrawFeedAdapter.a r121 = SingleDrawFeedAdapter.f123759h;
        int r122 = r106.type;
        r121.getClass();
        if (SingleDrawFeedAdapter.a.a(r122) == R.layout.ttlive_feed_single_draw_empty_viewholder_layout) goto L43;
        r102 = r118;
    L43:
        if (r102 == false) goto L3;
        r100.add(r105);
    L23:
        r117 = 0;
        goto L25
    L10:
        r108 = null;
    L27:
        r118 = true;
        goto L29
    L45:
        Iterator<T> r123 = this.tabItemModelList.iterator();
    L47:
        if (r123.hasNext() == false) goto L54;
        Object r124 = r123.next();
        if (((e) r124).f21008f.f() != r110) goto L51;
        boolean r125 = true;
    L52:
        if (r125 == false) goto L47;
        r103 = r124;
        goto L54
    L51:
        r125 = false;
    L54:
        e r126 = (e) r103;
        if (r112 == 0) goto L65;
        if (r112 == 1) goto L65;
        if (r112 != 2) goto L64;
        if (r126 == null) goto L64;
        LinkedList<FeedItem> r127 = r126.f21004b;
        if (r127 == null) goto L64;
        r127.addAll(r100);
    L64:
        r101 = false;
    L74:
        if (this.currentStatus != r112) goto L92;
        SingleDrawViewModel r128 = this.singleDrawViewModel;
        if (r128 == null) goto L80;
        NextLiveData<j> r129 = r128.getItemsUpdate();
        if (r129 == null) goto L80;
        r129.postValue(new j(r100, r101));
    L80:
        this.currentStatus = -1;
        return;
    L92:
        return;
    L65:
        if (r126 == null) goto L69;
        LinkedList<FeedItem> r130 = r126.f21004b;
        if (r130 == null) goto L69;
        r130.clear();
    L69:
        if (r126 == null) goto L74;
        LinkedList<FeedItem> r131 = r126.f21004b;
        if (r131 == null) goto L74;
        r131.addAll(r100);
        goto L74
    }
}
