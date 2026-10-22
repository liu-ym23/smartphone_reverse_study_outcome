package com.bytedance.android.live.effect.sticker.viewmodel;

import android.content.Context;
import android.net.Uri;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.effect.api.ILiveEffectComposerManager;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.LiveEffectScene;
import com.bytedance.android.live.effect.base.RenderTriggerType;
import com.bytedance.android.live.effect.sticker.chain.l;
import com.bytedance.android.live.effect.sticker.chain.m;
import com.bytedance.android.live.effect.sticker.ui.SpecialTabType;
import com.bytedance.android.live.effect.utils.q;
import com.bytedance.android.livesdk.config.et0;
import com.bytedance.android.livesdk.config.n9;
import com.bytedance.android.livesdk.config.o9;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.live.datacontext.k;
import com.bytedance.live.datacontext.p;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.effectmanager.MobConstants;
import com.ss.android.ugc.effectmanager.effect.model.EffectCategoryModel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 r2\u00020\u0001:\u0001sBI\u0012\u0006\u0010L\u001a\u00020K\u0012\u0006\u0010O\u001a\u00020N\u0012\u0006\u0010Q\u001a\u00020\u0002\u0012\b\u0010S\u001a\u0004\u0018\u00010\u000e\u0012\f\u0010W\u001a\b\u0012\u0004\u0012\u00020V0U\u0012\b\u0010Z\u001a\u0004\u0018\u00010Y\u0012\u0006\u0010]\u001a\u00020\\¢\u0006\u0004\bp\u0010qJ$\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\"\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u0002H\u0002J\u001a\u0010\u0010\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J&\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u0010\u0010\u0014\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ\u001a\u0010\u0016\u001a\u00020\u000b2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0005J\u000e\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0017J\u000e\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0017J \u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u0002J\u001e\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0017J\u0016\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eJ \u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eR\u001b\u0010$\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R!\u0010+\u001a\b\u0012\u0004\u0012\u00020&0%8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R!\u00100\u001a\b\u0012\u0004\u0012\u00020\u000b0,8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b-\u0010(\u001a\u0004\b.\u0010/R!\u00103\u001a\b\u0012\u0004\u0012\u00020\u000e0,8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b1\u0010(\u001a\u0004\b2\u0010/R!\u00106\u001a\b\u0012\u0004\u0012\u00020\u000e0,8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b4\u0010(\u001a\u0004\b5\u0010/R\u001c\u00108\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109R \u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u001a\u0010=\u001a\b\u0012\u0004\u0012\u00020\u0017078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u00109R\u001a\u0010>\u001a\b\u0012\u0004\u0012\u00020\u0017078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u00109R<\u0010A\u001a*\u0012\u0004\u0012\u00020\u0002\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070?j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0007`@0:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010<R\u0018\u0010C\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\"\u0010E\u001a\u00020&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u0014\u0010L\u001a\u00020K8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bL\u0010MR\u0014\u0010O\u001a\u00020N8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bO\u0010PR\u0014\u0010Q\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010S\u001a\u0004\u0018\u00010\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bS\u0010TR\u001a\u0010W\u001a\b\u0012\u0004\u0012\u00020V0U8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bW\u0010XR\u0016\u0010Z\u001a\u0004\u0018\u00010Y8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bZ\u0010[R\u0017\u0010]\u001a\u00020\\8\u0006¢\u0006\f\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`R\u0016\u0010d\u001a\u0004\u0018\u00010a8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bb\u0010cR\u0019\u0010h\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0e8F¢\u0006\u0006\u001a\u0004\bf\u0010gR\u001d\u0010k\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00058F¢\u0006\u0006\u001a\u0004\bi\u0010jR\u0017\u0010m\u001a\b\u0012\u0004\u0012\u00020\u00170e8F¢\u0006\u0006\u001a\u0004\bl\u0010gR\u0017\u0010o\u001a\b\u0012\u0004\u0012\u00020\u00170e8F¢\u0006\u0006\u001a\u0004\bn\u0010g¨\u0006t"}, d2 = {"Lcom/bytedance/android/live/effect/sticker/viewmodel/StickerDialogUIViewModel;", "Lcom/bytedance/android/live/effect/sticker/viewmodel/StickerBaseViewModel;", "", "tabKey", "parentTabKey", "", "generateApplyStickerExtra", "Lcom/bytedance/android/live/effect/sticker/viewmodel/g;", "params", "tabName", "subTabName", "", "sendShowStickerLog", "url", "Lcom/bytedance/android/livesdkapi/depend/model/Sticker;", "sticker", "appendParams", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "tryApplySticker", "updateSelectSticker", "extra", "updateCurrentSelectStickerExtra", "", "position", "updateCurrentTabPosition", "updateCurrentSecondaryTabPosition", "sendStickerShowLogWhenTabChange", "onStickerViewAttached", "onStickerViewDetached", "onClickHint", "Lcom/bytedance/android/live/effect/api/ILiveEffectComposerManager;", "composerManager$delegate", "Lkotlin/Lazy;", "getComposerManager", "()Lcom/bytedance/android/live/effect/api/ILiveEffectComposerManager;", "composerManager", "Lcom/bytedance/live/datacontext/m;", "", "searchPageStatus$delegate", "Lcom/bytedance/live/datacontext/p;", "getSearchPageStatus", "()Lcom/bytedance/live/datacontext/m;", "searchPageStatus", "Lcom/bytedance/live/datacontext/k;", "hideDialogEvent$delegate", "getHideDialogEvent", "()Lcom/bytedance/live/datacontext/k;", "hideDialogEvent", "stickerDownloadStartEvent$delegate", "getStickerDownloadStartEvent", "stickerDownloadStartEvent", "stickerDownloadCompleteEvent$delegate", "getStickerDownloadCompleteEvent", "stickerDownloadCompleteEvent", "Landroidx/lifecycle/MutableLiveData;", "_currentSelectStickerData", "Landroidx/lifecycle/MutableLiveData;", "", "_selectStickerExtra", "Ljava/util/Map;", "_currentTabPosition", "_currentSecondaryTabPosition", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "showingStickerMap", "Lcom/bytedance/android/live/effect/sticker/chain/l;", "currentStickerItemClickChain", "Lcom/bytedance/android/live/effect/sticker/chain/l;", "hasReportPanelShow", "Z", "getHasReportPanelShow", "()Z", "setHasReportPanelShow", "(Z)V", "Lcom/bytedance/android/live/effect/api/LiveEffectContextFactoryDelegate$Type;", "type", "Lcom/bytedance/android/live/effect/api/LiveEffectContextFactoryDelegate$Type;", "Lcom/bytedance/android/live/effect/api/LiveEffectScene;", "scene", "Lcom/bytedance/android/live/effect/api/LiveEffectScene;", "panel", "Ljava/lang/String;", "initialSelectSticker", "Lcom/bytedance/android/livesdkapi/depend/model/Sticker;", "", "Lcom/bytedance/android/live/effect/sticker/chain/m;", "stickerApplyInterceptorList", "Ljava/util/List;", "Lcom/bytedance/android/live/effect/sticker/ui/stickerdialogv2/a;", "abilityProxy", "Lcom/bytedance/android/live/effect/sticker/ui/stickerdialogv2/a;", "Lcom/bytedance/android/live/effect/base/f;", "showTraceInfo", "Lcom/bytedance/android/live/effect/base/f;", "getShowTraceInfo", "()Lcom/bytedance/android/live/effect/base/f;", "Lcom/bytedance/android/live/effect/sticker/viewmodel/StickerDataViewModel;", "getStickerDataViewModel", "()Lcom/bytedance/android/live/effect/sticker/viewmodel/StickerDataViewModel;", "stickerDataViewModel", "Landroidx/lifecycle/LiveData;", "getCurrentSelectStickerData", "()Landroidx/lifecycle/LiveData;", "currentSelectStickerData", "getSelectStickerExtra", "()Ljava/util/Map;", "selectStickerExtra", "getCurrentTabPosition", "currentTabPosition", "getCurrentSecondaryTabPosition", "currentSecondaryTabPosition", "<init>", "(Lcom/bytedance/android/live/effect/api/LiveEffectContextFactoryDelegate$Type;Lcom/bytedance/android/live/effect/api/LiveEffectScene;Ljava/lang/String;Lcom/bytedance/android/livesdkapi/depend/model/Sticker;Ljava/util/List;Lcom/bytedance/android/live/effect/sticker/ui/stickerdialogv2/a;Lcom/bytedance/android/live/effect/base/f;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StickerDialogUIViewModel extends StickerBaseViewModel {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    public static final String TAG = "ttlive_anchor_effect_StickerDialogUIViewModel";
    private final MutableLiveData<Integer> _currentSecondaryTabPosition;
    private final MutableLiveData<Sticker> _currentSelectStickerData;
    private final MutableLiveData<Integer> _currentTabPosition;
    private final Map<String, String> _selectStickerExtra;
    private final com.bytedance.android.live.effect.sticker.ui.stickerdialogv2.a abilityProxy;
    private final Lazy composerManager$delegate;
    private l currentStickerItemClickChain;
    private boolean hasReportPanelShow;
    private final p hideDialogEvent$delegate;
    private final Sticker initialSelectSticker;
    private final String panel;
    private final LiveEffectScene scene;
    private final p searchPageStatus$delegate;
    private final com.bytedance.android.live.effect.base.f showTraceInfo;
    private final Map<String, HashMap<String, g>> showingStickerMap;
    private final List<m> stickerApplyInterceptorList;
    private final p stickerDownloadCompleteEvent$delegate;
    private final p stickerDownloadStartEvent$delegate;
    private final LiveEffectContextFactoryDelegate$Type type;

    public static final class a {
        public a() {
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(StickerDialogUIViewModel.class, "searchPageStatus", "getSearchPageStatus()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(StickerDialogUIViewModel.class, "hideDialogEvent", "getHideDialogEvent()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(StickerDialogUIViewModel.class, "stickerDownloadStartEvent", "getStickerDownloadStartEvent()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(StickerDialogUIViewModel.class, "stickerDownloadCompleteEvent", "getStickerDownloadCompleteEvent()Lcom/bytedance/live/datacontext/IEventMember;", 0))};
        Companion = new a();
    }

    private final ILiveEffectComposerManager getComposerManager() {
        return (ILiveEffectComposerManager) this.composerManager$delegate.getValue();
    }

    public final k<Unit> getHideDialogEvent() {
        return (k) this.hideDialogEvent$delegate.a(this, $$delegatedProperties[1]);
    }

    public final com.bytedance.live.datacontext.m<Boolean> getSearchPageStatus() {
        return (com.bytedance.live.datacontext.m) this.searchPageStatus$delegate.a(this, $$delegatedProperties[0]);
    }

    public final k<Sticker> getStickerDownloadCompleteEvent() {
        return (k) this.stickerDownloadCompleteEvent$delegate.a(this, $$delegatedProperties[3]);
    }

    public final k<Sticker> getStickerDownloadStartEvent() {
        return (k) this.stickerDownloadStartEvent$delegate.a(this, $$delegatedProperties[2]);
    }

    private final StickerDataViewModel getStickerDataViewModel() {
        StickerBaseViewModel.a r100 = StickerBaseViewModel.Companion;
        LiveEffectScene r101 = this.scene;
        r100.getClass();
        return (StickerDataViewModel) StickerBaseViewModel.a.a(r101, StickerDataViewModel.class);
    }

    public final LiveData<Integer> getCurrentSecondaryTabPosition() {
        return this._currentSecondaryTabPosition;
    }

    public final LiveData<Sticker> getCurrentSelectStickerData() {
        return this._currentSelectStickerData;
    }

    public final LiveData<Integer> getCurrentTabPosition() {
        return this._currentTabPosition;
    }

    public final boolean getHasReportPanelShow() {
        return this.hasReportPanelShow;
    }

    public final Map<String, String> getSelectStickerExtra() {
        return this._selectStickerExtra;
    }

    public final com.bytedance.android.live.effect.base.f getShowTraceInfo() {
        return this.showTraceInfo;
    }

    public static final /* synthetic */ LiveEffectContextFactoryDelegate$Type access$getType$p(StickerDialogUIViewModel r100) {
        return r100.type;
    }

    public final void setHasReportPanelShow(boolean r100) {
        this.hasReportPanelShow = r100;
    }

    public final void updateCurrentSecondaryTabPosition(int r100) {
        this._currentSecondaryTabPosition.setValue(Integer.valueOf(r100));
        StickerDataViewModel r101 = getStickerDataViewModel();
        EffectCategoryModel r102 = null;
        if (r101 == null) goto L5;
        EffectCategoryModel r103 = r101.getCurrentTabInfo();
    L6:
        StickerDataViewModel r104 = getStickerDataViewModel();
        if (r104 == null) goto L9;
        r102 = r104.getSecondaryTabInfoByPosition(r100);
    L9:
        String r105 = "";
        if (r102 == null) goto L13;
        String r106 = r102.getKey();
        if (r106 == null) goto L13;
    L14:
        if (r103 == null) goto L17;
        String r107 = r103.getName();
        if (r107 == null) goto L17;
    L18:
        if (r102 == null) goto L23;
        String r108 = r102.getName();
        if (r108 == null) goto L23;
        r105 = r108;
    L23:
        sendStickerShowLogWhenTabChange(r106, r107, r105);
        return;
    L17:
        r107 = "";
    L13:
        r106 = "";
        goto L14
    L5:
        r103 = null;
        goto L6
    }

    public final void updateCurrentSelectStickerExtra(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "extra");
        this._selectStickerExtra.clear();
        this._selectStickerExtra.putAll(r100);
    }

    public final void updateCurrentTabPosition(int r100) {
        this._currentTabPosition.setValue(Integer.valueOf(r100));
        StickerDataViewModel r101 = getStickerDataViewModel();
        if (r101 == null) goto L5;
        EffectCategoryModel r102 = r101.getTabInfoByPosition(r100);
    L6:
        StickerDataViewModel r103 = getStickerDataViewModel();
        if (r103 != null) goto L9;
        return;
    L9:
        if (r102 == null) goto L12;
        String r104 = r102.getKey();
        if (r104 == null) goto L12;
    L14:
        if (r103.isMultiCategoryTab(r104) == true) goto L30;
        if (r102 == null) goto L20;
        String r105 = r102.getKey();
        if (r105 == null) goto L20;
        String r106 = r105;
    L21:
        if (r102 == null) goto L26;
        String r107 = r102.getName();
        if (r107 == null) goto L26;
        String r108 = r107;
    L27:
        sendStickerShowLogWhenTabChange$default(this, r106, r108, null, 4, null);
        return;
    L26:
        r108 = "";
    L20:
        r106 = "";
        goto L21
    L30:
        return;
    L12:
        r104 = "";
        goto L14
    L5:
        r102 = null;
        goto L6
    }

    public final void updateSelectSticker(Sticker r100) {
        if (et0.f120153a.getValue().booleanValue() == false) goto L12;
        Sticker r101 = this._currentSelectStickerData.getValue();
        String r102 = null;
        if (r101 == null) goto L7;
        String r103 = r101.getEffectId();
    L8:
        if (r100 == null) goto L11;
        r102 = r100.getEffectId();
    L11:
        if ((!Intrinsics.areEqual(r103, r102)) == true) goto L12;
        return;
    L7:
        r103 = null;
    L12:
        this._currentSelectStickerData.setValue(r100);
    }

    private final String appendParams(String r100, Sticker r101) {
        if (r100.length() != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
        return r100;
    L8:
        Uri.Builder r103 = UriProtector.parse(r100).buildUpon();
        String r104 = null;
        if (r101 == null) goto L11;
        String r105 = r101.getEffectId();
    L12:
        Uri.Builder r106 = r103.appendQueryParameter(MobConstants.EFFECT_ID, r105);
        if (r101 == null) goto L16;
        r104 = r101.getResourceId();
    L16:
        return r106.appendQueryParameter("resource_id", r104).build().toString();
    L11:
        r105 = null;
        goto L12
    L5:
        r102 = false;
        goto L6
    }

    private final Map<String, String> generateApplyStickerExtra(String r100, String r101) {
        LinkedHashMap r102 = new LinkedHashMap();
        StickerDataViewModel r103 = getStickerDataViewModel();
        String r104 = "";
        if (r103 != null) goto L5;
    L15:
        String r105 = "";
    L16:
        r102.put("effect_type", r105);
        StickerDataViewModel r106 = getStickerDataViewModel();
        if (r106 == null) goto L24;
        EffectCategoryModel r107 = r106.getSecondaryTabInfoByTabKey(r100, r101);
        if (r107 == null) goto L24;
        String r108 = r107.getName();
        if (r108 == null) goto L24;
        r104 = r108;
    L24:
        r102.put("sub_effect_type", r104);
        r102.put("effect_category_key", r100);
        return r102;
    L5:
        if (r101.length() != 0) goto L7;
        boolean r109 = true;
    L8:
        if (r109 == false) goto L10;
        String r110 = r100;
    L11:
        EffectCategoryModel r111 = r103.getTabInfoByTabKey(r110);
        if (r111 == null) goto L15;
        r105 = r111.getName();
        if (r105 != null) goto L16;
    L10:
        r110 = r101;
        goto L11
    L7:
        r109 = false;
        goto L8
    }

    public final void onStickerViewDetached(String r100, Sticker r101) {
        Intrinsics.checkNotNullParameter(r100, "tabKey");
        Intrinsics.checkNotNullParameter(r101, "sticker");
        HashMap<String, g> r102 = this.showingStickerMap.get(r100);
        if (r102 == null) goto L6;
        g r103 = r102.remove(String.valueOf(r101.getId()));
        return;
    }

    private final void sendShowStickerLog(g r110, String r111, String r112) {
        List<String> r100 = q.f68881a;
        q.h(String.valueOf(r110.f68826a), false, r110.f68827b + 1, r111, this.type, this.scene.getPage(), null, r110.f68828c, r112);
    }

    public final void onClickHint(Context r100, String r101, Sticker r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "url");
        appendParams(r101, r102);
    }

    public final void onStickerViewAttached(String r100, Sticker r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "tabKey");
        Intrinsics.checkNotNullParameter(r101, "sticker");
        if (this.showingStickerMap.get(r100) != null) goto L5;
        this.showingStickerMap.put(r100, new HashMap());
    L5:
        HashMap<String, g> r103 = this.showingStickerMap.get(r100);
        if (r103 != null) goto L8;
    L9:
        HashMap<String, g> r104 = this.showingStickerMap.get(r100);
        if (r104 == null) goto L12;
        g r105 = r104.put(String.valueOf(r101.getId()), new g(r101.getId(), r102, r101.getStickerType()));
    L12:
        StickerDataViewModel r106 = getStickerDataViewModel();
        String r107 = null;
        if (r106 == null) goto L15;
        EffectCategoryModel r108 = r106.getCurrentTabInfo();
    L16:
        StickerDataViewModel r109 = getStickerDataViewModel();
        if (r109 == null) goto L19;
        EffectCategoryModel r110 = r109.getCurrentSecondaryTabInfo();
    L20:
        if (r108 == null) goto L22;
        String r111 = r108.getKey();
    L24:
        if (Intrinsics.areEqual(r111, r100) == true) goto L38;
        if (r110 == null) goto L27;
        String r112 = r110.getKey();
    L29:
        if (Intrinsics.areEqual(r112, r100) == true) goto L38;
        if (r108 == null) goto L33;
        r107 = r108.getKey();
    L33:
        if (Intrinsics.areEqual(r107, SpecialTabType.SEARCH.getTabKey()) == true) goto L35;
        return;
    L35:
        if (Intrinsics.areEqual(r100, "search_0") == true) goto L37;
        return;
    L37:
        if (getSearchPageStatus().getValue().booleanValue() == true) goto L38;
        return;
    L27:
        r112 = null;
    L38:
        g r113 = new g(r101.getId(), r102, r101.getStickerType());
        String r114 = "";
        if (r108 == null) goto L42;
        String r115 = r108.getName();
        if (r115 == null) goto L42;
    L43:
        if (r110 == null) goto L48;
        String r116 = r110.getName();
        if (r116 == null) goto L48;
        r114 = r116;
    L48:
        sendShowStickerLog(r113, r115, r114);
        return;
    L42:
        r115 = "";
        goto L43
    L22:
        r111 = null;
        goto L24
    L19:
        r110 = null;
        goto L20
    L15:
        r108 = null;
        goto L16
    L8:
        if (r103.containsKey(String.valueOf(r101.getId())) != true) goto L9;
    }

    public final void sendStickerShowLogWhenTabChange(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "tabKey");
        Intrinsics.checkNotNullParameter(r101, "tabName");
        Intrinsics.checkNotNullParameter(r102, "subTabName");
        HashMap<String, g> r103 = this.showingStickerMap.get(r100);
        if (r103 == null) goto L8;
        Iterator<T> r104 = r103.values().iterator();
    L6:
        if (r104.hasNext() == false) goto L10;
        sendShowStickerLog((g) r104.next(), r101, r102);
        goto L6
    L10:
        return;
    }

    public final void tryApplySticker(Context r110, Sticker r111, String r112, String r113) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "sticker");
        Intrinsics.checkNotNullParameter(r112, "tabKey");
        Intrinsics.checkNotNullParameter(r113, "parentTabKey");
        Sticker r100 = getCurrentSelectStickerData().getValue();
        if (r100 != null) goto L5;
    L7:
        l r101 = this.currentStickerItemClickChain;
        if (r101 == null) goto L19;
        Sticker r102 = r101.f68174g;
        if (r102 == null) goto L19;
        if (r102.getId() != r111.getId()) goto L19;
        l r103 = this.currentStickerItemClickChain;
        if (r103 == null) goto L19;
        if (r103.f68169b != true) goto L19;
        return;
    L19:
        if (this.scene == LiveEffectScene.Live) goto L21;
    L28:
        l r104 = this.currentStickerItemClickChain;
        if (r104 == null) goto L31;
        r104.f68169b = false;
    L31:
        l r105 = new l(r110, this.type, this.scene, this.panel, r111, generateApplyStickerExtra(r112, r113), new LinkedList(this.stickerApplyInterceptorList));
        this.currentStickerItemClickChain = r105;
        com.bytedance.android.live.effect.base.e r106 = r105.f68168a;
        if (r106 == null) goto L34;
        r106.f66995a = true;
        String r107 = this.panel;
        Intrinsics.checkNotNullParameter(r107, "<set-?>");
        r106.f66997c = r107;
        r106.f66998d = RenderTriggerType.SelectByUser;
        r106.f67000f = System.currentTimeMillis();
    L34:
        l r108 = this.currentStickerItemClickChain;
        if (r108 == null) goto L38;
        r108.a();
        return;
    L38:
        return;
    L21:
        if (n9.f120813a.getValue().booleanValue() == false) goto L28;
        if (o9.f120885a.getValue().booleanValue() == false) goto L28;
        getComposerManager().q();
        if (r111.getTransferType() != 2) goto L28;
        f2.c("直播中无法使用，请在开播前设置", 0);
        return;
    L5:
        if (r100.getId() != r111.getId()) goto L7;
    }

    public static /* synthetic */ void sendShowStickerLog$default(StickerDialogUIViewModel r100, g r101, String r102, String r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L5;
        r103 = "";
    L5:
        r100.sendShowStickerLog(r101, r102, r103);
    }

    public static /* synthetic */ void sendStickerShowLogWhenTabChange$default(StickerDialogUIViewModel r100, String r101, String r102, String r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L5;
        r103 = "";
    L5:
        r100.sendStickerShowLogWhenTabChange(r101, r102, r103);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StickerDialogUIViewModel(LiveEffectContextFactoryDelegate$Type r100, LiveEffectScene r101, String r102, Sticker r103, List<? extends m> r104, com.bytedance.android.live.effect.sticker.ui.stickerdialogv2.a r105, com.bytedance.android.live.effect.base.f r106) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "scene");
        Intrinsics.checkNotNullParameter(r102, "panel");
        Intrinsics.checkNotNullParameter(r104, "stickerApplyInterceptorList");
        Intrinsics.checkNotNullParameter(r106, "showTraceInfo");
        this.type = r100;
        this.scene = r101;
        this.panel = r102;
        this.initialSelectSticker = r103;
        this.stickerApplyInterceptorList = r104;
        this.showTraceInfo = r106;
        this.composerManager$delegate = LazyKt.lazy(new StickerDialogUIViewModel$composerManager$2(this));
        this.searchPageStatus$delegate = com.bytedance.live.datacontext.q.d(this, Boolean.FALSE);
        this.hideDialogEvent$delegate = com.bytedance.live.datacontext.e.b(this);
        this.stickerDownloadStartEvent$delegate = com.bytedance.live.datacontext.e.b(this);
        this.stickerDownloadCompleteEvent$delegate = com.bytedance.live.datacontext.e.b(this);
        this._currentSelectStickerData = new MutableLiveData(r103);
        this._selectStickerExtra = new LinkedHashMap();
        this._currentTabPosition = new MutableLiveData();
        this._currentSecondaryTabPosition = new MutableLiveData();
        this.showingStickerMap = new LinkedHashMap();
    }
}
