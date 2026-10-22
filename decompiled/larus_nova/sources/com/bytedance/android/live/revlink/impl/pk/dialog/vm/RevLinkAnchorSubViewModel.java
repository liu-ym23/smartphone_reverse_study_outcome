package com.bytedance.android.live.revlink.impl.pk.dialog.vm;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.core.utils.JsonUtil;
import com.bytedance.android.live.core.utils.b0;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revlink.impl.control.dialog.LinkRevPanelDataContext;
import com.bytedance.android.live.revlink.impl.control.dialog.e;
import com.bytedance.android.live.revlink.impl.pk.dialog.fragment.p;
import com.bytedance.android.live.revlink.impl.utils.t;
import com.bytedance.android.live.revlink.impl.utils.x;
import com.bytedance.android.livesdk.link.model.IGroupRivals;
import com.bytedance.android.livesdk.link.model.IPanelArea;
import com.bytedance.android.livesdk.link.model.IPkSubTabKey;
import com.bytedance.android.livesdk.link.model.IRivalRankRecommendResponse;
import com.bytedance.android.livesdk.link.model.i8;
import com.bytedance.android.livesdk.link.model.m2;
import com.bytedance.android.livesdk.link.model.s2;
import com.bytedance.android.livesdk.link.model.y7;
import com.bytedance.apm.constant.UploadTypeInf;
import com.bytedance.live.datacontext.m;
import com.bytedance.revenue.platform.api.core.rx.f;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b,\u0010-J\u001e\u0010\u0007\u001a\u00020\u00062\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002H\u0002J\u001e\u0010\t\u001a\u00020\u00062\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b\u0018\u00010\u0002H\u0002J\u001c\u0010\u000b\u001a\u00020\u00062\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0003H\u0002J\b\u0010\u000f\u001a\u00020\u0003H\u0016J\u001e\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\rJ\u0006\u0010\u0015\u001a\u00020\u0006J\u0016\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0010R\u0016\u0010\u0018\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\r0\u001a8\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR#\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f0\u001a8\u0006¢\u0006\f\n\u0004\b!\u0010\u001c\u001a\u0004\b\"\u0010\u001eR#\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u001f0\u001a8\u0006¢\u0006\f\n\u0004\b$\u0010\u001c\u001a\u0004\b%\u0010\u001eR\"\u0010&\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010\u0019\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010*R\u0016\u0010\u0012\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010+R\u0016\u0010\u0013\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0019¨\u0006."}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/dialog/vm/RevLinkAnchorSubViewModel;", "Lcom/bytedance/android/live/revlink/impl/pk/dialog/vm/RevLinkAnchorBaseViewModel;", "Lkotlin/Pair;", "", "Lcom/bytedance/android/live/revlink/impl/control/dialog/e;", "data", "", "onDateLoadSuccess", "Lcom/bytedance/android/live/revlink/impl/control/dialog/f;", "onDataLoadFail", "pair", "onDataLoaded", "source", "", "checkDataNeedNotify", "getTag", "", "loadType", "activityId", "enableRank", "setArgument", "initData", "actType", "reqAction", "loadFlag", "Z", "Landroidx/lifecycle/MutableLiveData;", "loading", "Landroidx/lifecycle/MutableLiveData;", "getLoading", "()Landroidx/lifecycle/MutableLiveData;", "", "", "listData", "getListData", "Lcom/bytedance/android/livesdk/link/model/IPanelArea;", "actAreaData", "getActAreaData", "isAct", "()Z", "setAct", "(Z)V", "I", "Ljava/lang/String;", "<init>", "()V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RevLinkAnchorSubViewModel extends RevLinkAnchorBaseViewModel {
    private final MutableLiveData<List<IPanelArea>> actAreaData;
    private String activityId;
    private boolean enableRank;
    private boolean isAct;
    private final MutableLiveData<List<Object>> listData;
    private boolean loadFlag;
    private int loadType;
    private final MutableLiveData<Boolean> loading;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RevLinkAnchorSubViewModel f96329a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f96330b;

        public a(RevLinkAnchorSubViewModel r100, String r101) {
            this.f96329a = r100;
            this.f96330b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            ExtraResponse r101 = (ExtraResponse) r100;
            this.f96329a.getActAreaData().setValue(((i8) r101.data).getAreas());
            com.bytedance.android.live.revlink.impl.control.dialog.b r102 = this.f96329a.getLoader();
            if (r102 == null) goto L19;
            String r103 = this.f96330b;
            String r104 = ((i8) r101.data).getTrackingInfo();
            if (r104 != null) goto L7;
            r104 = "";
        L7:
            Intrinsics.checkNotNullParameter(r103, "activityId");
            Intrinsics.checkNotNullParameter(r104, "trackingInfo");
            Pair<String, e> r105 = r102.e(IRivalRankRecommendResponse.LoadType.OnlyCommonPanel.ordinal(), r103);
            if (r105 == null) goto L20;
            e r106 = r105.getSecond();
            if (r106 == null) goto L21;
            Map<String, String> r107 = JsonUtil.jsonObjectToMap(new JSONObject(r104));     // Catch: Exception -> L13
        L14:
            if (r107 == null) goto L22;
            r106.f92385f = r107;
            return;
        L22:
            return;
        L13:
            r107 = null;
            goto L14
        L21:
            return;
        L20:
            return;
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RevLinkAnchorSubViewModel f96331a;

        public b(RevLinkAnchorSubViewModel r100) {
            this.f96331a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            String r101 = this.f96331a.getTag();
            t.b(r101, (Throwable) r100);
        }
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.dialog.vm.RevLinkAnchorBaseViewModel
    public String getTag() {
        return "RevLinkAnchorSubViewModel";
    }

    public final void initData() {
        LinkRevPanelDataContext r100 = LinkRevPanelDataContext.Companion.getContext();
        if (r100 == null) goto L9;
        if (this.enableRank == false) goto L7;
        f.a(b0.b(r100.getLoadCompleteRankEvent(), new RevLinkAnchorSubViewModel$initData$1$1(this)), getCd());
        f.a(b0.b(r100.getLoadFailRankEvent(), new RevLinkAnchorSubViewModel$initData$1$2(this)), getCd());
        goto L9
    L7:
        PublishSubject r101 = r100.getLoadCompleteEvent().onEvent();
        final RevLinkAnchorSubViewModel$initData$1$3 r102 = new RevLinkAnchorSubViewModel$initData$1$3(this);
        f.a(r101.subscribe(new c(r102)), getCd());
        PublishSubject r103 = r100.getLoadFailEvent().onEvent();
        final RevLinkAnchorSubViewModel$initData$1$4 r104 = new RevLinkAnchorSubViewModel$initData$1$4(this);
        f.a(r103.subscribe(new c(r104)), getCd());
    L9:
        if (this.enableRank == true) goto L22;
        com.bytedance.android.live.revlink.impl.control.dialog.b r105 = getLoader();
        if (r105 == null) goto L13;
        final Pair<String, e> r106 = r105.e(this.loadType, this.activityId);
    L14:
        if (r106 == null) goto L16;
        lazyTask(this.loadType, new AnonymousClass2(this, r106));
        return;
    L16:
        com.bytedance.android.live.revlink.impl.control.dialog.b r107 = getLoader();
        if (r107 != null) goto L19;
    L20:
        this.loading.setValue(Boolean.TRUE);
        this.loadFlag = false;
        RevLinkAnchorBaseViewModel.fetchPiece$default(this, this.loadType, "init", this.activityId, null, 8, null);
        return;
    L19:
        if (r107.i(this.loadType, this.activityId) != true) goto L20;
        return;
    L13:
        r106 = null;
        goto L14
    }

    public RevLinkAnchorSubViewModel() {
        this.loading = new MutableLiveData();
        this.listData = new MutableLiveData();
        this.actAreaData = new MutableLiveData();
        this.activityId = "0";
    }

    public final MutableLiveData<List<IPanelArea>> getActAreaData() {
        return this.actAreaData;
    }

    public final MutableLiveData<List<Object>> getListData() {
        return this.listData;
    }

    public final MutableLiveData<Boolean> getLoading() {
        return this.loading;
    }

    public final boolean isAct() {
        return this.isAct;
    }

    private final boolean checkDataNeedNotify(String r100) {
        if (this.loadFlag == true) goto L6;
        return true;
    L6:
        if (this.loadType != IRivalRankRecommendResponse.LoadType.OnlyFollowRivals.ordinal()) goto L15;
        if ((!Intrinsics.areEqual(r100, "init")) == true) goto L10;
    L12:
        return false;
    L10:
        if ((!Intrinsics.areEqual(r100, "cache")) == false) goto L12;
        return true;
    L15:
        if ((!Intrinsics.areEqual(r100, "init")) == true) goto L17;
    L21:
        return false;
    L17:
        if ((!Intrinsics.areEqual(r100, "cache")) == false) goto L21;
        if ((!Intrinsics.areEqual(r100, UploadTypeInf.TIMER)) == false) goto L21;
        return true;
    }

    private final void onDataLoadFail(Pair<String, com.bytedance.android.live.revlink.impl.control.dialog.f> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        String r101 = r100.getFirst();
        int r102 = r100.getSecond().f92386a;
        String r103 = r100.getSecond().f92387b;
        if (Intrinsics.areEqual(r101, "init") == false) goto L18;
        IRivalRankRecommendResponse.LoadType r104 = IRivalRankRecommendResponse.LoadType.OnlyCommonPanel;
        if (r102 != r104.ordinal()) goto L13;
        if (r102 != this.loadType) goto L13;
        if (Intrinsics.areEqual(r103, this.activityId) == false) goto L13;
    L16:
        this.loading.setValue(Boolean.FALSE);
        return;
    L13:
        if (r102 != r104.ordinal()) goto L15;
        return;
    L15:
        if (r102 == this.loadType) goto L16;
        return;
    }

    private final void onDataLoaded(Pair<String, e> r100) {
        this.loadFlag = true;
        if (this.isAct == false) goto L22;
        List<y7> r101 = r100.getSecond().f92382c.getSubTabs();
        y7 r102 = null;
        Object r103 = null;
        if (r101 == null) goto L19;
        Iterator<T> r104 = r101.iterator();
    L8:
        if (r104.hasNext() == false) goto L18;
        Object r105 = r104.next();
        y7 r106 = (y7) r105;
        if (r106 == null) goto L14;
        IPkSubTabKey r107 = r106.getKey();
        if (r107 == null) goto L14;
        String r108 = r107.getActivityId();
    L16:
        if (Intrinsics.areEqual(r108, this.activityId) == false) goto L8;
        r103 = r105;
    L14:
        r108 = null;
    L18:
        r102 = (y7) r103;
    L19:
        if (r102 == null) goto L50;
        this.actAreaData.setValue(r102.getAreas());
        return;
    L50:
        return;
    L22:
        if (this.loadType != IRivalRankRecommendResponse.LoadType.OnlyRecommendRivals.ordinal()) goto L41;
        s2 r109 = r100.getSecond().f92382c.getTabRivals();
        if (r109 == null) goto L41;
        Map<Long, IGroupRivals> r110 = r109.getGroupRivals();
        if (r110 == null) goto L41;
        IGroupRivals r111 = r110.get(Long.valueOf(IGroupRivals.GroupType.GroupFeedRecommend.ordinal()));
        if (r111 == null) goto L41;
        List<m2> r112 = r111.getRivals();
        if (r112 == null) goto L41;
        LinkRevPanelDataContext r113 = getDataContext();
        if (r113 == null) goto L36;
        m<String> r114 = r113.getRecImplId();
        if (r114 == null) goto L36;
        r114.setValue(r111.getImprId());
    L36:
        LinkRevPanelDataContext r115 = getDataContext();
        if (r115 == null) goto L39;
        r115.setSelectType(r111.getSelectType());
    L39:
        this.listData.setValue(createRecItemList(r112, r111.getImprId(), r100.getSecond().f92382c.getSkinType(), r100.getFirst()));
    L41:
        if (getReporter() == null) goto L43;
        p.c(r100.getFirst(), this.loadType, r100.getSecond().f92383d);
    L43:
        com.bytedance.android.live.revlink.impl.control.dialog.b r116 = getLoader();
        if (r116 == null) goto L52;
        com.bytedance.android.live.revlink.impl.control.dialog.b.l(r116, r100.getFirst(), this.loadType);
        return;
    }

    private final void onDateLoadSuccess(Pair<String, e> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        String r101 = r100.getFirst();
        int r102 = r100.getSecond().f92380a;
        if (Intrinsics.areEqual(r100.getSecond().f92381b, this.activityId) == false) goto L9;
        if (this.isAct == false) goto L9;
    L15:
        if (checkDataNeedNotify(r101) == false) goto L20;
        onDataLoaded(r100);
        return;
    L20:
        return;
    L9:
        if (this.enableRank == true) goto L15;
        if (r102 != IRivalRankRecommendResponse.LoadType.OnlyCommonPanel.ordinal()) goto L13;
        return;
    L13:
        if (r102 == this.loadType) goto L15;
    }

    public final void setAct(boolean r100) {
        this.isAct = r100;
    }

    public static final /* synthetic */ void access$onDataLoadFail(RevLinkAnchorSubViewModel r100, Pair r101) {
        r100.onDataLoadFail(r101);
    }

    public static final /* synthetic */ void access$onDataLoaded(RevLinkAnchorSubViewModel r100, Pair r101) {
        r100.onDataLoaded(r101);
    }

    public static final /* synthetic */ void access$onDateLoadSuccess(RevLinkAnchorSubViewModel r100, Pair r101) {
        r100.onDateLoadSuccess(r101);
    }

    public final void reqAction(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "activityId");
        Observable<ExtraResponse<i8, Extra>> r102 = r31.b.a(r31.a.f535859a).j(r100, r101);
        if (r102 == null) goto L10;
        Observable<R> r103 = r102.compose(RxUtil.rxSchedulerHelper());
        if (r103 == 0) goto L11;
        Disposable r104 = r103.subscribe(new a(this, r100), new b(this));
        if (r104 == null) goto L12;
        f.a(r104, getCd());
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void setArgument(int r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r101, "activityId");
        this.loadType = r100;
        this.activityId = r101;
        this.isAct = x.a(r101, r100);
        this.enableRank = r102;
    }
}
