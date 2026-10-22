package com.bytedance.android.livesdk.feed.viewmodel;

import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.base.model.media.IPlayable;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.paging.Listing;
import com.bytedance.android.live.core.paging.viewmodel.PagingViewModel;
import com.bytedance.android.livesdk.feed.IFeedRepository;
import com.bytedance.android.livesdk.feed.ItemRepository;
import com.bytedance.android.livesdk.feed.b1;
import com.bytedance.android.livesdk.feed.feed.FeedDataKey;
import com.bytedance.android.livesdk.feed.repository.BaseFeedRepository;
import com.bytedance.android.livesdk.feed.repository.FeedRepository;
import com.bytedance.common.utility.StringUtils;
import io.reactivex.android.schedulers.AndroidSchedulers;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public class BaseFeedDataViewModel extends PagingViewModel<FeedItem> {
    protected MutableLiveData<List<ImageModel>> covers;
    private com.bytedance.android.livesdk.feed.feed.a<Listing<FeedItem>, com.bytedance.android.livesdk.feed.feed.b> dataPair;
    protected String eventType;
    private long extraId;
    protected Map<String, Object> extraMapForSaas;
    protected FeedDataKey feedDataKey;
    protected IFeedRepository feedRepository;
    protected MutableLiveData<BaseFeedRepository.ApiDataStatus> loadMoreApiStatus;
    protected MutableLiveData<Integer> loadMoreNum;
    private int pageSize;
    protected MutableLiveData<IPlayable> playItem;
    protected MutableLiveData<Integer> pos;
    private int prefetchSize;
    protected MutableLiveData<BaseFeedRepository.ApiDataStatus> refreshApiStatus;
    protected MutableLiveData<Integer> refreshNum;
    protected Listing<FeedItem> repoResult;
    private com.bytedance.android.livesdk.feed.feed.b shareExtra;
    protected String url;
    private hw1.a userCenter;
    private MutableLiveData<IBaseUser.Status> userStatus;

    public class a implements IFeedRepository.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseFeedDataViewModel f124551a;

        public final FeedDataKey a() {
            return this.f124551a.feedDataKey();
        }

        public a(BaseFeedDataViewModel r100) {
            this.f124551a = r100;
        }
    }

    public static /* synthetic */ void To(BaseFeedDataViewModel r100, List r101) {
        r100.onLoadMoreCover(r101);
    }

    public static /* synthetic */ void Wo(BaseFeedDataViewModel r100, BaseFeedRepository.ApiDataStatus r101) {
        r100.lambda$registerFollowStatusChange$5(r101);
    }

    public static /* synthetic */ void Yo(BaseFeedDataViewModel r100, BaseFeedRepository.ApiDataStatus r101) {
        r100.lambda$start$3(r101);
    }

    public static /* synthetic */ void Zo(BaseFeedDataViewModel r100, IPlayable r101) {
        r100.lambda$start$1(r101);
    }

    public static /* synthetic */ void ap(BaseFeedDataViewModel r100, String r101) {
        r100.lambda$start$2(r101);
    }

    public static /* synthetic */ void bp(BaseFeedDataViewModel r100, Integer r101) {
        r100.lambda$start$0(r101);
    }

    public static /* synthetic */ void cp(BaseFeedDataViewModel r100, BaseFeedRepository.ApiDataStatus r101) {
        r100.lambda$start$4(r101);
    }

    public void mocRefresh(String r100) {
    }

    public void onStarted() {
    }

    public boolean scrollTop() {
        return false;
    }

    public FeedDataKey buildFeedDataKey() {
        return FeedDataKey.a(this.eventType, getUrl(), this.extraId);
    }

    public FeedDataKey feedDataKey() {
        if (this.feedDataKey != null) goto L6;
        this.feedDataKey = buildFeedDataKey();
    L6:
        return this.feedDataKey;
    }

    public void initParams() {
        this.feedRepository.Nd(new a(this));
    }

    public void registerFollowStatusChange() {
        this.loadMoreApiStatus.observeForever(new g(this));
    }

    public void start() {
        com.bytedance.android.livesdk.feed.feed.a<Listing<FeedItem>, com.bytedance.android.livesdk.feed.feed.b> r100 = this.feedRepository.p60(getUrl(), getExtraMapForSaas());     // Catch: Exception -> L7
        this.dataPair = r100;     // Catch: Exception -> L7
        this.repoResult = r100.f124007a;     // Catch: Exception -> L7
        com.bytedance.android.livesdk.feed.feed.b r101 = r100.f124008b;     // Catch: Exception -> L7
        this.shareExtra = r101;     // Catch: Exception -> L7
        r101.f124009a.observeForever(new com.bytedance.android.livesdk.feed.viewmodel.a(this));     // Catch: Exception -> L7
        this.shareExtra.f124010b.observeForever(new b(this));     // Catch: Exception -> L7
        register(this.repoResult);     // Catch: Exception -> L7
        registerFollowStatusChange();     // Catch: Exception -> L7
        register(this.feedRepository.GZ().observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this), new g60.c()));     // Catch: Exception -> L7
        register(this.feedRepository.CP().observeOn(AndroidSchedulers.mainThread()).subscribe(new d(this), new g60.c()));     // Catch: Exception -> L7
        ItemRepository r102 = this.feedRepository;     // Catch: Exception -> L7
        if ((r102 instanceof BaseFeedRepository) == false) goto L5;
        register(((BaseFeedRepository) r102).f124311d.observeOn(AndroidSchedulers.mainThread()).subscribe(new e(this), new g60.c()));     // Catch: Exception -> L7
        register(((BaseFeedRepository) this.feedRepository).f124312e.observeOn(AndroidSchedulers.mainThread()).subscribe(new f(this), new g60.c()));     // Catch: Exception -> L7
    L5:
        mocRefresh("enter_auto");     // Catch: Exception -> L7
    L9:
        onStarted();
        return;
    L7:
        e = move-exception;
        ALogger.i("BaseFeedDataViewModel", e.getMessage());
        goto L9
    }

    @Override // com.bytedance.android.live.core.paging.viewmodel.PagingViewModel
    public boolean refresh() {
        boolean r100 = super.refresh();
        if (r100 == false) goto L5;
        this.pos.setValue(0);
    L5:
        return r100;
    }

    private Map<String, Object> getExtraMapForSaas() {
        return this.extraMapForSaas;
    }

    public LiveData<List<ImageModel>> covers() {
        return this.covers;
    }

    public String event() {
        return this.eventType;
    }

    public IFeedRepository feedRepository() {
        return this.feedRepository;
    }

    public String getUrl() {
        return this.url;
    }

    public LiveData<Integer> loadMoreNum() {
        return this.loadMoreNum;
    }

    public LiveData<BaseFeedRepository.ApiDataStatus> loadMoreStatus() {
        return this.loadMoreApiStatus;
    }

    public LiveData<IPlayable> playItem() {
        return this.playItem;
    }

    public LiveData<Integer> pos() {
        return this.pos;
    }

    public LiveData<BaseFeedRepository.ApiDataStatus> refreshApiStatus() {
        return this.refreshApiStatus;
    }

    public LiveData<Integer> refreshNum() {
        return this.refreshNum;
    }

    public LiveData<IBaseUser.Status> userStatus() {
        return this.userStatus;
    }

    public static /* synthetic */ int access$000(BaseFeedDataViewModel r100) {
        return r100.pageSize;
    }

    public static /* synthetic */ int access$100(BaseFeedDataViewModel r100) {
        return r100.prefetchSize;
    }

    private void increaseUserRefresh(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        if (TextUtils.equals(r100, "enter_auto") == false) goto L7;
        return;
    L7:
        if (TextUtils.equals(r100, "detail_loadmore") == false) goto L10;
        return;
    L10:
        if (this.userCenter.isLogin() == true) goto L12;
        return;
    L12:
        Integer r101 = this.refreshNum.getValue();
        if (r101 != null) goto L15;
        this.refreshNum.setValue(1);
        return;
    L15:
        this.refreshNum.setValue(Integer.valueOf(r101.intValue() + 1));
    }

    private /* synthetic */ void lambda$registerFollowStatusChange$5(BaseFeedRepository.ApiDataStatus r100) {
        if (r100 != BaseFeedRepository.ApiDataStatus.SUCCESS) goto L9;
        Integer r101 = this.loadMoreNum.getValue();
        if (r101 != null) goto L7;
        r101 = 0;
    L7:
        this.loadMoreNum.setValue(Integer.valueOf(r101.intValue() + 1));
        return;
    }

    private /* synthetic */ void lambda$start$0(Integer r100) {
        this.pos.setValue(r100);
    }

    private /* synthetic */ void lambda$start$1(IPlayable r100) {
        this.playItem.setValue(r100);
    }

    private /* synthetic */ void lambda$start$2(String r100) throws Exception {
        increaseUserRefresh(r100);
    }

    private /* synthetic */ void lambda$start$3(BaseFeedRepository.ApiDataStatus r100) throws Exception {
        this.refreshApiStatus.setValue(r100);
    }

    private /* synthetic */ void lambda$start$4(BaseFeedRepository.ApiDataStatus r100) throws Exception {
        this.loadMoreApiStatus.setValue(r100);
    }

    private void onLoadMoreCover(List<ImageModel> r100) {
        this.covers.setValue(r100);
    }

    public final boolean refresh(String r100) {
        this.feedRepository.setReqFrom(r100, null);
        increaseUserRefresh(r100);
        boolean r101 = refresh();
        if (r101 == false) goto L5;
        mocRefresh(r100);
    L5:
        return r101;
    }

    public void setLiveForceParams(b1 r100) {
        IFeedRepository r101 = this.feedRepository;
        if (r101 != null) goto L5;
        return;
    L5:
        if ((r101 instanceof FeedRepository) == false) goto L11;
        FeedRepository r102 = (FeedRepository) r101;
        r102.f124331w = r100;
        FeedRepository.a r103 = r102.f124328t;
        if (r103 == null) goto L12;
        r103.f124344m = r100;
        return;
    L12:
        return;
    }

    public void updateFeedDataKey(FeedDataKey r100) {
        this.feedDataKey = r100;
    }

    public void setReqFrom(String r100, String r101) {
        IFeedRepository r102 = this.feedRepository;
        if (r102 == null) goto L6;
        r102.setReqFrom(r100, r101);
        return;
    }

    public void updateUrlAndEvent(String r100, String r101) {
        if (StringUtils.isEmpty(r100) == true) goto L6;
        this.url = r100;
    L6:
        if (StringUtils.isEmpty(r101) == true) goto L9;
        this.eventType = r101;
        return;
    }

    public BaseFeedDataViewModel(IFeedRepository r100, com.bytedance.android.livesdk.feed.g r101, hw1.a r102) {
        this.pos = new MutableLiveData();
        this.playItem = new MutableLiveData();
        this.refreshNum = new MutableLiveData();
        this.loadMoreNum = new MutableLiveData();
        this.covers = new MutableLiveData();
        this.refreshApiStatus = new MutableLiveData();
        this.loadMoreApiStatus = new MutableLiveData();
        this.userStatus = new MutableLiveData();
        this.feedRepository = r100;
        if (r101 == null) goto L6;
        this.url = r101.url();
        this.pageSize = r101.f8();
        this.prefetchSize = r101.I9();
        this.eventType = r101.sR();
        this.userCenter = r102;
        this.extraId = r101.hC();
        this.extraMapForSaas = r101.SR();
        initParams();
        return;
    }
}
