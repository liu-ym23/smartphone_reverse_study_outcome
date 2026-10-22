package com.bytedance.android.shopping.store.tabkit.mixframe;

import com.bytedance.android.ec.core.arch.viewmodel.BaseViewModel;
import com.bytedance.android.ec.hybrid.list.util.l;
import com.bytedance.android.ec.store.shopping.paging.LoadStatus;
import com.bytedance.android.shopping.store.moments.dto.HybridListDTO;
import com.bytedance.android.shopping.store.moments.dto.ItemDTO;
import com.bytedance.android.shopping.store.moments.dto.SectionDTO;
import com.bytedance.android.shopping.store.tabkit.monitor.TabkitFirstFramePref;
import com.bytedance.android.shopping.store.tabkit.monitor.TabkitFramePref;
import com.bytedance.locallife.dito.data.DitoNode;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010$\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\"\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bv\u0010wJ\u001e\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002JR\u0010\u0012\u001a\u00020\u00112\b\u0010\b\u001a\u0004\u0018\u00010\u00052\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00042\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fJ3\u0010\u0019\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00022!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00110\u0014J)\u0010\u0003\u001a\u00020\u00112!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00110\u0014JG\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u00022\u0014\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00042!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00110\u0014J\u000e\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\fR$\u0010\u001f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R2\u0010&\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010%8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R*\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R*\u00102\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u0010-\u001a\u0004\b3\u0010/\"\u0004\b4\u00101R0\u00105\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010%8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u0010'\u001a\u0004\b6\u0010)\"\u0004\b7\u0010+R0\u00108\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u0010'\u001a\u0004\b9\u0010)\"\u0004\b:\u0010+R\u0017\u0010<\u001a\u00020;8\u0006¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R(\u0010B\u001a\b\u0012\u0004\u0012\u00020A0@8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010H\u001a\u0004\b\u0013\u0010I\"\u0004\bJ\u0010KR\"\u0010M\u001a\u00020L8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bM\u0010N\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\"\u0010S\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bS\u0010H\u001a\u0004\bT\u0010I\"\u0004\bU\u0010KR(\u0010W\u001a\b\u0012\u0004\u0012\u00020V0@8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bW\u0010C\u001a\u0004\bX\u0010E\"\u0004\bY\u0010GR\"\u0010Z\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bZ\u0010H\u001a\u0004\b[\u0010I\"\u0004\b\\\u0010KR\u0017\u0010]\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b]\u0010 \u001a\u0004\b^\u0010\"R$\u0010_\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b_\u0010`\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR\"\u0010e\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\be\u0010H\u001a\u0004\be\u0010I\"\u0004\bf\u0010KR\"\u0010g\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bg\u0010h\u001a\u0004\bi\u0010j\"\u0004\bk\u0010lR\"\u0010m\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bm\u0010H\u001a\u0004\bn\u0010I\"\u0004\bo\u0010KR\"\u0010p\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bp\u0010H\u001a\u0004\bq\u0010I\"\u0004\br\u0010KR$\u0010s\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bs\u0010 \u001a\u0004\bt\u0010\"\"\u0004\bu\u0010$¨\u0006x"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/mixframe/MixFrameViewModel;", "Lcom/bytedance/android/ec/core/arch/viewmodel/BaseViewModel;", "", DitoNode.LOAD_MORE, "", "", "", "mixFrameApiConfig", "url", "apiParams", "", "paramsKeyList", "", "tabID", "anchorTab", "Lok3/a;", "tabKitMonitor", "", "init", "isRefresh", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "success", "callback", "initFetch", "showEmpty", "apiConfig", "fetchMixFrameData", "status", "reportMonitorPageShow", "mixFrameUrl", "Ljava/lang/String;", "getMixFrameUrl", "()Ljava/lang/String;", "setMixFrameUrl", "(Ljava/lang/String;)V", "", "mixFrameApiParams", "Ljava/util/Map;", "getMixFrameApiParams", "()Ljava/util/Map;", "setMixFrameApiParams", "(Ljava/util/Map;)V", "apiParamsKeyList", "Ljava/util/List;", "getApiParamsKeyList", "()Ljava/util/List;", "setApiParamsKeyList", "(Ljava/util/List;)V", "appendAPIParamsKeyList", "getAppendAPIParamsKeyList", "setAppendAPIParamsKeyList", "passThroghParams", "getPassThroghParams", "setPassThroghParams", "paramsMap", "getParamsMap", "setParamsMap", "Lcom/bytedance/android/ec/hybrid/list/util/l;", "hybridListSession", "Lcom/bytedance/android/ec/hybrid/list/util/l;", "getHybridListSession", "()Lcom/bytedance/android/ec/hybrid/list/util/l;", "Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QLiveData;", "Lcom/bytedance/android/shopping/store/tabkit/mixframe/ECTabKitMixFrameResponse;", "response", "Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QLiveData;", "getResponse", "()Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QLiveData;", "setResponse", "(Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QLiveData;)V", "Z", "()Z", "setRefresh", "(Z)V", "", EffectConfiguration.KEY_CURSOR, "J", "getCursor", "()J", "setCursor", "(J)V", "hasMore", "getHasMore", "setHasMore", "Lcom/bytedance/android/ec/store/shopping/paging/LoadStatus;", "loadStatus", "getLoadStatus", "setLoadStatus", "fetchLock", "getFetchLock", "setFetchLock", "sceneId", "getSceneId", "tabMonitor", "Lok3/a;", "getTabMonitor", "()Lok3/a;", "setTabMonitor", "(Lok3/a;)V", "isAnchorTab", "setAnchorTab", "tabId", "I", "getTabId", "()I", "setTabId", "(I)V", "hasReportMonitor", "getHasReportMonitor", "setHasReportMonitor", "firstRequestSuccess", "getFirstRequestSuccess", "setFirstRequestSuccess", "noMoreText", "getNoMoreText", "setNoMoreText", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MixFrameViewModel extends BaseViewModel {
    private List<String> apiParamsKeyList;
    private List<String> appendAPIParamsKeyList;
    private long cursor;
    private boolean fetchLock;
    private boolean firstRequestSuccess;
    private boolean hasMore;
    private boolean hasReportMonitor;
    private final l hybridListSession;
    private boolean isAnchorTab;
    private boolean isRefresh;
    private QLiveData<LoadStatus> loadStatus;
    private Map<String, ? extends Object> mixFrameApiParams;
    private String mixFrameUrl;
    private String noMoreText;
    private Map<String, String> paramsMap;
    private Map<String, String> passThroghParams;
    private QLiveData<ECTabKitMixFrameResponse> response;
    private final String sceneId;
    private int tabId;
    private ok3.a tabMonitor;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MixFrameViewModel f186763a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1 f186764b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f186765c;

        public a(MixFrameViewModel r100, Function1 r101, boolean r102) {
            this.f186763a = r100;
            this.f186764b = r101;
            this.f186765c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            ECTabKitMixFrameResponse r101 = (ECTabKitMixFrameResponse) r100;
            this.f186764b.invoke(Boolean.TRUE);
            String r102 = null;
            if (this.f186763a.getHasReportMonitor() == true) goto L16;
            if (this.f186763a.isAnchorTab() == false) goto L11;
            ok3.a r103 = this.f186763a.getTabMonitor();
            if (r103 == null) goto L14;
            TabkitFirstFramePref r104 = r103.f523626d;
            if (r104 == null) goto L14;
            TabkitFramePref.recordTime$default(r104, "t_tab_request_end", null, 2, null);
        L14:
            this.f186763a.setHasReportMonitor(true);
            goto L16
        L11:
            ok3.a r105 = this.f186763a.getTabMonitor();
            if (r105 == null) goto L14;
            TabkitFramePref.recordTime$default(r105.c(this.f186763a.getTabId()), "t_tab_request_end", null, 2, null);
        L16:
            if (r101.getStatusCode() == 0) goto L18;
            this.f186763a.getLoadStatus().g(LoadStatus.InitializeError);
            this.f186763a.reportMonitorPageShow(2);
            return;
        L18:
            MixFrameViewModel r106 = this.f186763a;
            r106.setCursor(r106.getCursor());
            if (this.f186765c == false) goto L39;
            HybridListDTO r107 = r101.getHybridList();
            if (r107 == null) goto L35;
            List<SectionDTO> r108 = r107.getSections();
            if (r108 == null) goto L35;
            if ((!r108.isEmpty()) == true) goto L28;
            r108 = null;
        L28:
            if (r108 == null) goto L35;
            SectionDTO r109 = (SectionDTO) ListProtector.get(r108, 0);
            if (r109 == null) goto L35;
            ArrayList<ItemDTO> r110 = r109.getItems();
            if (r110 == null) goto L35;
            if (r110.isEmpty() == false) goto L39;
        L35:
            this.f186763a.setFetchLock(false);
            this.f186763a.getLoadStatus().g(LoadStatus.InitializeEmpty);
            this.f186763a.reportMonitorPageShow(5);
            MixFrameViewModel r111 = this.f186763a;
            BizConfig r112 = r101.getBizConfig();
            if (r112 == null) goto L38;
            r102 = r112.getNoMoreText();
        L38:
            r111.setNoMoreText(r102);
            return;
        L39:
            this.f186763a.setFirstRequestSuccess(true);
            this.f186763a.getLoadStatus().g(LoadStatus.InitializeSuccess);
            this.f186763a.setCursor(r101.getCursor());
            this.f186763a.setHasMore(r101.getHasMore());
            this.f186763a.getResponse().g(r101);
            MixFrameViewModel r113 = this.f186763a;
            BizConfig r114 = r101.getBizConfig();
            if (r114 == null) goto L42;
            r102 = r114.getNoMoreText();
        L42:
            r113.setNoMoreText(r102);
            this.f186763a.setPassThroghParams(r101.getPassThroughParams());
            if (this.f186763a.getHasMore() == true) goto L48;
            this.f186763a.getLoadStatus().g(LoadStatus.LoadMoreEnd);
            return;
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MixFrameViewModel f186766a;

        public b(MixFrameViewModel r100) {
            this.f186766a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            this.f186766a.getLoadStatus().g(LoadStatus.InitializeError);
            this.f186766a.reportMonitorPageShow(2);
            this.f186766a.setFetchLock(false);
        }
    }

    public static final class c implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MixFrameViewModel f186767a;

        public c(MixFrameViewModel r100) {
            this.f186767a = r100;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            this.f186767a.setFetchLock(false);
            l r100 = this.f186767a.getHybridListSession();
            r100.f47338d = Long.valueOf(new Date().getTime());
        }
    }

    public MixFrameViewModel() {
        super(null, null, 3, null);
        this.hybridListSession = new l();
        this.response = new QLiveData();
        this.hasMore = true;
        this.loadStatus = new QLiveData();
        this.sceneId = UUID.randomUUID().toString();
        this.isAnchorTab = true;
    }

    public final List<String> getApiParamsKeyList() {
        return this.apiParamsKeyList;
    }

    public final List<String> getAppendAPIParamsKeyList() {
        return this.appendAPIParamsKeyList;
    }

    public final long getCursor() {
        return this.cursor;
    }

    public final boolean getFetchLock() {
        return this.fetchLock;
    }

    public final boolean getFirstRequestSuccess() {
        return this.firstRequestSuccess;
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final boolean getHasReportMonitor() {
        return this.hasReportMonitor;
    }

    public final l getHybridListSession() {
        return this.hybridListSession;
    }

    public final QLiveData<LoadStatus> getLoadStatus() {
        return this.loadStatus;
    }

    public final Map<String, Object> getMixFrameApiParams() {
        return this.mixFrameApiParams;
    }

    public final String getMixFrameUrl() {
        return this.mixFrameUrl;
    }

    public final String getNoMoreText() {
        return this.noMoreText;
    }

    public final Map<String, String> getParamsMap() {
        return this.paramsMap;
    }

    public final Map<String, String> getPassThroghParams() {
        return this.passThroghParams;
    }

    public final QLiveData<ECTabKitMixFrameResponse> getResponse() {
        return this.response;
    }

    public final String getSceneId() {
        return this.sceneId;
    }

    public final int getTabId() {
        return this.tabId;
    }

    public final ok3.a getTabMonitor() {
        return this.tabMonitor;
    }

    public final boolean isAnchorTab() {
        return this.isAnchorTab;
    }

    public final boolean isRefresh() {
        return this.isRefresh;
    }

    private final Map<String, Object> mixFrameApiConfig(boolean r100) {
        LinkedHashMap r101 = new LinkedHashMap();
        Map<String, ? extends Object> r102 = this.mixFrameApiParams;
        if (r102 == null) goto L5;
        r101.putAll(r102);
    L5:
        LinkedHashMap r103 = new LinkedHashMap();
        List<String> r104 = this.apiParamsKeyList;
        if (r104 == null) goto L15;
        Iterator<T> r105 = r104.iterator();
    L9:
        if (r105.hasNext() == false) goto L15;
        String r106 = (String) r105.next();
        Map<String, String> r107 = this.paramsMap;
        if (r107 == null) goto L9;
        String r108 = r107.get(r106);
        if (r108 == null) goto L9;
        r103.put(r106, r108);
    L15:
        r101.putAll(r103);
        if (r100 == false) goto L30;
        LinkedHashMap r109 = new LinkedHashMap();
        List<String> r110 = this.appendAPIParamsKeyList;
        if (r110 == null) goto L27;
        Iterator<T> r111 = r110.iterator();
    L21:
        if (r111.hasNext() == false) goto L27;
        String r112 = (String) r111.next();
        Map<String, String> r113 = this.paramsMap;
        if (r113 == null) goto L21;
        String r114 = r113.get(r112);
        if (r114 == null) goto L21;
        r109.put(r112, r114);
    L27:
        r101.putAll(r109);
        Map<String, String> r115 = this.passThroghParams;
        if (r115 == null) goto L30;
        r101.putAll(r115);
    L30:
        Map<String, String> r116 = this.paramsMap;
        if (r116 == null) goto L33;
        String r117 = r116.get("feed_back");
    L34:
        r101.put("feed_back", r117);
        return r101;
    L33:
        r117 = null;
        goto L34
    }

    public final void loadMore(Function1<? super Boolean, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        if (this.fetchLock == false) goto L5;
        return;
    L5:
        if (this.hasMore == false) goto L10;
        this.fetchLock = true;
        this.loadStatus.g(LoadStatus.LoadMoreIn);
        l r101 = this.hybridListSession;
        r101.f47337c = Long.valueOf(new Date().getTime());
        fetchMixFrameData(false, mixFrameApiConfig(true), r100);
        return;
    }

    public final void reportMonitorPageShow(int r100) {
        if (this.isAnchorTab == false) goto L9;
        ok3.a r101 = this.tabMonitor;
        if (r101 == null) goto L13;
        TabkitFirstFramePref r102 = r101.f523626d;
        if (r102 == null) goto L13;
        TabkitFramePref.recordTime$default(r102, "t_page_show", null, 2, null);
    L13:
        if (this.isAnchorTab == false) goto L17;
        ok3.a r103 = this.tabMonitor;
        if (r103 == null) goto L21;
        Map<Long, TabkitFirstFramePref> r104 = ok3.a.f523622e;
        r103.e(r100, null, null);
        return;
    L21:
        return;
    L17:
        ok3.a r105 = this.tabMonitor;
        if (r105 == null) goto L23;
        int r106 = this.tabId;
        Map<Long, TabkitFirstFramePref> r107 = ok3.a.f523622e;
        r105.f(r106, r100, null, null);
        return;
    L23:
        return;
    L9:
        ok3.a r108 = this.tabMonitor;
        if (r108 == null) goto L13;
        TabkitFramePref.recordTime$default(r108.c(this.tabId), "t_page_show", null, 2, null);
        goto L13
    }

    public final void setAnchorTab(boolean r100) {
        this.isAnchorTab = r100;
    }

    public final void setApiParamsKeyList(List<String> r100) {
        this.apiParamsKeyList = r100;
    }

    public final void setAppendAPIParamsKeyList(List<String> r100) {
        this.appendAPIParamsKeyList = r100;
    }

    public final void setCursor(long r100) {
        this.cursor = r100;
    }

    public final void setFetchLock(boolean r100) {
        this.fetchLock = r100;
    }

    public final void setFirstRequestSuccess(boolean r100) {
        this.firstRequestSuccess = r100;
    }

    public final void setHasMore(boolean r100) {
        this.hasMore = r100;
    }

    public final void setHasReportMonitor(boolean r100) {
        this.hasReportMonitor = r100;
    }

    public final void setLoadStatus(QLiveData<LoadStatus> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.loadStatus = r100;
    }

    public final void setMixFrameApiParams(Map<String, ? extends Object> r100) {
        this.mixFrameApiParams = r100;
    }

    public final void setMixFrameUrl(String r100) {
        this.mixFrameUrl = r100;
    }

    public final void setNoMoreText(String r100) {
        this.noMoreText = r100;
    }

    public final void setParamsMap(Map<String, String> r100) {
        this.paramsMap = r100;
    }

    public final void setPassThroghParams(Map<String, String> r100) {
        this.passThroghParams = r100;
    }

    public final void setRefresh(boolean r100) {
        this.isRefresh = r100;
    }

    public final void setResponse(QLiveData<ECTabKitMixFrameResponse> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.response = r100;
    }

    public final void setTabId(int r100) {
        this.tabId = r100;
    }

    public final void setTabMonitor(ok3.a r100) {
        this.tabMonitor = r100;
    }

    public final void initFetch(boolean r100, Function1<? super Boolean, Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "callback");
        if (this.fetchLock == false) goto L5;
        return;
    L5:
        this.fetchLock = true;
        this.loadStatus.g(LoadStatus.Initialize);
        this.hybridListSession.f47337c = Long.valueOf(new Date().getTime());
        fetchMixFrameData(!r100, mixFrameApiConfig(false), r101);
        if (r100 == true) goto L11;
        ok3.a r102 = this.tabMonitor;
        if (r102 == null) goto L12;
        TabkitFramePref.recordTime$default(r102.c(this.tabId), "t_tab_request_start", null, 2, null);
        return;
    L12:
        return;
    }

    public final void fetchMixFrameData(boolean r100, Map<String, Object> r101, Function1<? super Boolean, Unit> r102) {
        Intrinsics.checkNotNullParameter(r101, "apiConfig");
        Intrinsics.checkNotNullParameter(r102, "callback");
        String r103 = this.mixFrameUrl;
        if (r103 != null) goto L5;
        return;
    L5:
        TabKitMixFrameApi.f186768a.getClass();
        TabKitMixFrameApi r104 = TabKitMixFrameApi.a.f186769a;
        if (r104 == null) goto L15;
        Observable<ECTabKitMixFrameResponse> r105 = r104.getMixFrameData(r103, Long.valueOf(this.cursor), (HashMap) r101);
        if (r105 == null) goto L16;
        Observable r106 = bg4.b.b(r105);
        if (r106 == null) goto L17;
        Disposable r107 = r106.subscribe(new a(this, r102, r100), new b(this), new c(this));
        if (r107 == null) goto L18;
        com.bytedance.android.ec.core.async.a.a(r107, this);
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    }

    public static /* synthetic */ void initFetch$default(MixFrameViewModel r100, boolean r101, Function1 r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L5;
        r101 = false;
    L5:
        r100.initFetch(r101, r102);
    }

    public final void init(String r100, Map<String, Object> r101, List<String> r102, int r103, boolean r104, ok3.a r105) {
        this.mixFrameUrl = r100;
        this.mixFrameApiParams = r101;
        this.apiParamsKeyList = r102;
        this.tabMonitor = r105;
        this.isAnchorTab = r104;
        this.tabId = r103;
        initFetch(false, AnonymousClass1.INSTANCE);
    }
}
