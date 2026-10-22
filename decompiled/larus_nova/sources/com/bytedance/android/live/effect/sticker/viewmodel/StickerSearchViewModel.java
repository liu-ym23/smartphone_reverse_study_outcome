package com.bytedance.android.live.effect.sticker.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.LiveEffectScene;
import com.bytedance.android.live.effect.utils.q;
import com.bytedance.live.datacontext.k;
import com.bytedance.live.datacontext.p;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.effectmanager.common.task.ExceptionResult;
import com.ss.android.ugc.effectmanager.effect.listener.ISearchEffectListenerV2;
import com.ss.android.ugc.effectmanager.effect.model.SearchEffectModel;
import com.ss.android.ugc.effectmanager.effect.model.net.SearchEffectResponseV2;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 32\u00020\u0001:\u0003456B\u001f\u0012\u0006\u0010\"\u001a\u00020!\u0012\u0006\u0010%\u001a\u00020$\u0012\u0006\u0010'\u001a\u00020\u0002¢\u0006\u0004\b1\u00102J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\t\u001a\u00020\u0006R&\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00040\u000b0\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u000eR!\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u00128FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R!\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u00128FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0014\u001a\u0004\b\u0019\u0010\u0016R!\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00060\u00128FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0014\u001a\u0004\b\u001c\u0010\u0016R!\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00020\u00128FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0014\u001a\u0004\b\u001f\u0010\u0016R\u0014\u0010\"\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010%\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R#\u0010,\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00040\u000b0)8F¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0017\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00020)8F¢\u0006\u0006\u001a\u0004\b-\u0010+R\u0017\u00100\u001a\b\u0012\u0004\u0012\u00020\u00100)8F¢\u0006\u0006\u001a\u0004\b/\u0010+¨\u00067"}, d2 = {"Lcom/bytedance/android/live/effect/sticker/viewmodel/StickerSearchViewModel;", "Lcom/bytedance/android/live/effect/sticker/viewmodel/StickerBaseViewModel;", "", "newContent", "Lcom/bytedance/android/live/effect/sticker/viewmodel/StickerSearchViewModel$b;", "trace", "", "doSearchSticker", "updateSearchContent", "resetSearchStatus", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/android/live/effect/sticker/viewmodel/a;", "Lcom/ss/android/ugc/effectmanager/effect/model/SearchEffectModel;", "_stickerSearchResultData", "Landroidx/lifecycle/MutableLiveData;", "_searchContent", "Lcom/bytedance/android/live/effect/sticker/viewmodel/StickerSearchViewModel$SearchStatus;", "_searchStatus", "Lcom/bytedance/live/datacontext/k;", "tabViewClearContentEvent$delegate", "Lcom/bytedance/live/datacontext/p;", "getTabViewClearContentEvent", "()Lcom/bytedance/live/datacontext/k;", "tabViewClearContentEvent", "tabViewCoverClickEvent$delegate", "getTabViewCoverClickEvent", "tabViewCoverClickEvent", "tabViewSearchFailEvent$delegate", "getTabViewSearchFailEvent", "tabViewSearchFailEvent", "tabViewKeywordClickEvent$delegate", "getTabViewKeywordClickEvent", "tabViewKeywordClickEvent", "Lcom/bytedance/android/live/effect/api/LiveEffectContextFactoryDelegate$Type;", "type", "Lcom/bytedance/android/live/effect/api/LiveEffectContextFactoryDelegate$Type;", "Lcom/bytedance/android/live/effect/api/LiveEffectScene;", "scene", "Lcom/bytedance/android/live/effect/api/LiveEffectScene;", "panel", "Ljava/lang/String;", "Landroidx/lifecycle/LiveData;", "getStickerSearchResultData", "()Landroidx/lifecycle/LiveData;", "stickerSearchResultData", "getSearchContent", "searchContent", "getSearchStatus", "searchStatus", "<init>", "(Lcom/bytedance/android/live/effect/api/LiveEffectContextFactoryDelegate$Type;Lcom/bytedance/android/live/effect/api/LiveEffectScene;Ljava/lang/String;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "SearchStatus", "b", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StickerSearchViewModel extends StickerBaseViewModel {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    public static final int SEARCH_COUNT = 60;
    public static final String TAG = "ttlive_anchor_effect_StickerSearchViewModel";
    private final MutableLiveData<String> _searchContent;
    private final MutableLiveData<SearchStatus> _searchStatus;
    private final MutableLiveData<com.bytedance.android.live.effect.sticker.viewmodel.a<SearchEffectModel, b>> _stickerSearchResultData;
    private final String panel;
    private final LiveEffectScene scene;
    private final p tabViewClearContentEvent$delegate;
    private final p tabViewCoverClickEvent$delegate;
    private final p tabViewKeywordClickEvent$delegate;
    private final p tabViewSearchFailEvent$delegate;
    private final LiveEffectContextFactoryDelegate$Type type;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/effect/sticker/viewmodel/StickerSearchViewModel$SearchStatus;", "", "None", "Searching", "SearchFinish", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum SearchStatus extends Enum<SearchStatus> {
        public static final SearchStatus None = null;
        public static final SearchStatus SearchFinish = null;
        public static final SearchStatus Searching = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ SearchStatus[] f68808a = null;

        static {
            SearchStatus r100 = new SearchStatus("None", 0);
            None = r100;
            SearchStatus r101 = new SearchStatus("Searching", 1);
            Searching = r101;
            SearchStatus r102 = new SearchStatus("SearchFinish", 2);
            SearchFinish = r102;
            f68808a = new SearchStatus[]{r100, r101, r102};
        }

        public static SearchStatus valueOf(String r100) {
            return (SearchStatus) r27.a.a(SearchStatus.class, r100);
        }

        public static SearchStatus[] values() {
            return (SearchStatus[]) f68808a.clone();
        }

        public SearchStatus(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
        public a() {
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f68809a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f68810b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f68811c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f68812d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f68813e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == false) goto L16;
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f68809a, r101.f68809a) == true) goto L8;
            return false;
        L8:
            if (this.f68810b == r101.f68810b) goto L10;
            return false;
        L10:
            if (this.f68811c == r101.f68811c) goto L12;
            return false;
        L12:
            if (this.f68812d == r101.f68812d) goto L14;
            return false;
        L14:
            if (this.f68813e == r101.f68813e) goto L25;
            return false;
        L25:
            return true;
        L16:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v4, types: [int] */
        /* JADX WARN: Type inference failed for: r0v8, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v6 */
        /* JADX WARN: Type inference failed for: r1v7 */
        /* JADX WARN: Type inference failed for: r2v0 */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v3 */
        public final int hashCode() {
            String r100 = this.f68809a;
            if (r100 == null) goto L5;
            int r101 = r100.hashCode();
        L6:
            int r102 = r101 * 31;
            boolean r103 = this.f68810b;
            ?? r104 = 1;
            ?? r105 = r103;
            if (r103 == false) goto L9;
            r105 = 1;
        L9:
            int r106 = (((r102 + r105) * 31) + this.f68811c) * 31;
            boolean r107 = this.f68812d;
            if (r107 == true) goto L13;
            r104 = r107;
        L13:
            long r108 = this.f68813e;
            return ((r106 + r104) * 31) + ((int) (r108 ^ (r108 >>> 32)));
        L5:
            r101 = 0;
            goto L6
        }

        public final String toString() {
            return "StickerSearchTraceInfo(searchContent=" + this.f68809a + ", searchWithKeyBoard=" + this.f68810b + ", currentSearchIndex=" + this.f68811c + ", clickRecommendKeyword=" + this.f68812d + ", searchStartTime=" + this.f68813e + ")";
        }

        public b(String r100, boolean r101, int r102, long r103) {
            Intrinsics.checkNotNullParameter(r100, "searchContent");
            this.f68809a = r100;
            this.f68810b = r101;
            this.f68811c = r102;
            this.f68812d = false;
            this.f68813e = r103;
        }
    }

    public static final class c implements ISearchEffectListenerV2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ StickerSearchViewModel f68814a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f68815b;

        @Override // com.ss.android.ugc.effectmanager.effect.listener.ISearchEffectListenerV2
        public final void onFail(ExceptionResult r100) {
            Intrinsics.checkNotNullParameter(r100, "e");
            StickerSearchViewModel.access$get_stickerSearchResultData$p(this.f68814a).setValue(new com.bytedance.android.live.effect.sticker.viewmodel.a.C1121a(r100.getException(), this.f68815b));
            StickerSearchViewModel.access$get_searchStatus$p(this.f68814a).setValue(SearchStatus.SearchFinish);
        }

        @Override // com.ss.android.ugc.effectmanager.common.task.IEffectPlatformBaseListener
        public final void onSuccess(SearchEffectResponseV2 r110) {
            SearchEffectResponseV2 r111 = r110;
            Intrinsics.checkNotNullParameter(r111, "response");
            SearchEffectModel r112 = r111.getData();
            if (r112 != null) goto L5;
            StickerSearchViewModel.access$get_stickerSearchResultData$p(this.f68814a).setValue(new com.bytedance.android.live.effect.sticker.viewmodel.a.C1121a(new Exception("effect model is null"), this.f68815b));
        L17:
            StickerSearchViewModel.access$get_searchStatus$p(this.f68814a).setValue(SearchStatus.SearchFinish);
            return;
        L5:
            List<String> r100 = q.f68881a;
            String r101 = r112.getSearch_id();
            if (r101 != null) goto L8;
            r101 = "";
        L8:
            b r102 = this.f68815b;
            String r103 = r102.f68809a;
            boolean r104 = r102.f68812d;
            boolean r105 = Intrinsics.areEqual(r112.getUse_hot(), Boolean.TRUE);
            long r106 = System.currentTimeMillis() - this.f68815b.f68813e;
            String r107 = StickerSearchViewModel.access$getScene$p(this.f68814a).getPage();
            Intrinsics.checkNotNullParameter(r101, "searchID");
            Intrinsics.checkNotNullParameter(r103, "keyword");
            Intrinsics.checkNotNullParameter(r107, "page");
            Pair[] r108 = new Pair[6];
            r108[0] = TuplesKt.to("live_type", "video_live");
            r108[1] = TuplesKt.to("search_keyword", r103);
            r108[2] = TuplesKt.to("search_id", r101);
            if (r104 == false) goto L11;
            String r109 = "search_rec";
        L12:
            r108[3] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_SEARCH_METHOD, r109);
            if (r105 == false) goto L15;
            String r113 = "0";
        L16:
            r108[4] = TuplesKt.to("is_success", r113);
            r108[5] = TuplesKt.to("duration", String.valueOf(r106));
            q.e("livesdk_live_sticker_search", MapsKt.hashMapOf(r108), r107);
            StickerSearchViewModel.access$get_stickerSearchResultData$p(this.f68814a).setValue(new com.bytedance.android.live.effect.sticker.viewmodel.a.b(r112, this.f68815b));
            goto L17
        L15:
            r113 = "1";
            goto L16
        L11:
            r109 = "search_sug";
            goto L12
        }

        public c(StickerSearchViewModel r100, b r101) {
            this.f68814a = r100;
            this.f68815b = r101;
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(StickerSearchViewModel.class, "tabViewClearContentEvent", "getTabViewClearContentEvent()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(StickerSearchViewModel.class, "tabViewCoverClickEvent", "getTabViewCoverClickEvent()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(StickerSearchViewModel.class, "tabViewSearchFailEvent", "getTabViewSearchFailEvent()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(StickerSearchViewModel.class, "tabViewKeywordClickEvent", "getTabViewKeywordClickEvent()Lcom/bytedance/live/datacontext/IEventMember;", 0))};
        Companion = new a();
    }

    public final k<Unit> getTabViewClearContentEvent() {
        return (k) this.tabViewClearContentEvent$delegate.a(this, $$delegatedProperties[0]);
    }

    public final k<Unit> getTabViewCoverClickEvent() {
        return (k) this.tabViewCoverClickEvent$delegate.a(this, $$delegatedProperties[1]);
    }

    public final k<String> getTabViewKeywordClickEvent() {
        return (k) this.tabViewKeywordClickEvent$delegate.a(this, $$delegatedProperties[3]);
    }

    public final k<Unit> getTabViewSearchFailEvent() {
        return (k) this.tabViewSearchFailEvent$delegate.a(this, $$delegatedProperties[2]);
    }

    public final void resetSearchStatus() {
        this._searchStatus.setValue(SearchStatus.None);
    }

    public final LiveData<String> getSearchContent() {
        return this._searchContent;
    }

    public final LiveData<SearchStatus> getSearchStatus() {
        return this._searchStatus;
    }

    public final LiveData<com.bytedance.android.live.effect.sticker.viewmodel.a<SearchEffectModel, b>> getStickerSearchResultData() {
        return this._stickerSearchResultData;
    }

    public static final /* synthetic */ LiveEffectScene access$getScene$p(StickerSearchViewModel r100) {
        return r100.scene;
    }

    public static final /* synthetic */ MutableLiveData access$get_searchStatus$p(StickerSearchViewModel r100) {
        return r100._searchStatus;
    }

    public static final /* synthetic */ MutableLiveData access$get_stickerSearchResultData$p(StickerSearchViewModel r100) {
        return r100._stickerSearchResultData;
    }

    public final void updateSearchContent(String r100) {
        Intrinsics.checkNotNullParameter(r100, "newContent");
        this._searchContent.setValue(r100);
    }

    public final void doSearchSticker(String r100, b r110) {
        Intrinsics.checkNotNullParameter(r100, "newContent");
        Intrinsics.checkNotNullParameter(r110, "trace");
        this._searchStatus.setValue(SearchStatus.Searching);
        List<String> r101 = LiveEffectContext.f66734h;
        LiveEffectContext.a.a(this.type).d().searchEffects("0", r100, 60, 0, MapsKt.mapOf(TuplesKt.to("panel", this.panel)), new c(this, r110));
    }

    public StickerSearchViewModel(LiveEffectContextFactoryDelegate$Type r100, LiveEffectScene r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "scene");
        Intrinsics.checkNotNullParameter(r102, "panel");
        this.type = r100;
        this.scene = r101;
        this.panel = r102;
        this._stickerSearchResultData = new MutableLiveData();
        this._searchContent = new MutableLiveData();
        this._searchStatus = new MutableLiveData(SearchStatus.None);
        this.tabViewClearContentEvent$delegate = com.bytedance.live.datacontext.e.b(this);
        this.tabViewCoverClickEvent$delegate = com.bytedance.live.datacontext.e.b(this);
        this.tabViewSearchFailEvent$delegate = com.bytedance.live.datacontext.e.b(this);
        this.tabViewKeywordClickEvent$delegate = com.bytedance.live.datacontext.e.b(this);
    }
}
