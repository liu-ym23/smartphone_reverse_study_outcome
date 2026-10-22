package com.bytedance.android.live.effect.common;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.effect.api.ILiveEffectComposerManager;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.LiveEffectScene;
import com.bytedance.android.live.effect.sticker.viewmodel.StickerBaseViewModel;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000_\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u001a\b\u0016\u0018\u0000 .2\u00020\u0001:\u0001/B\u001f\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\b,\u0010-J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J \u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016R!\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R!\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0013\u0010\u0010R\"\u0010\u0018\u001a\u0010\u0012\f\u0012\n \u0017*\u0004\u0018\u00010\u00160\u00160\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001e\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010 R\u0014\u0010\"\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010'\u001a\u00020$8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0017\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00160(8F¢\u0006\u0006\u001a\u0004\b)\u0010*¨\u00060"}, d2 = {"Lcom/bytedance/android/live/effect/common/LiveCommonStickerUIViewModel;", "Lcom/bytedance/android/live/effect/sticker/viewmodel/StickerBaseViewModel;", "", "startObserveRepelStatus", "stopObserveRepelStatus", "Lcom/bytedance/android/livesdkapi/depend/model/Sticker;", "sticker", "", "position", "Lcom/bytedance/android/live/effect/api/LiveEffectScene;", "scene", "sendStickerShowLog", "Lcom/bytedance/live/datacontext/k;", "stickerDownloadStartEvent$delegate", "Lcom/bytedance/live/datacontext/p;", "getStickerDownloadStartEvent", "()Lcom/bytedance/live/datacontext/k;", "stickerDownloadStartEvent", "stickerDownloadCompleteEvent$delegate", "getStickerDownloadCompleteEvent", "stickerDownloadCompleteEvent", "Landroidx/lifecycle/MutableLiveData;", "", "kotlin.jvm.PlatformType", "_repelStatus", "Landroidx/lifecycle/MutableLiveData;", "com/bytedance/android/live/effect/common/LiveCommonStickerUIViewModel$b", "repelStatusChangeListener", "Lcom/bytedance/android/live/effect/common/LiveCommonStickerUIViewModel$b;", "Lcom/bytedance/android/live/effect/api/LiveEffectContextFactoryDelegate$Type;", "type", "Lcom/bytedance/android/live/effect/api/LiveEffectContextFactoryDelegate$Type;", "Lcom/bytedance/android/live/effect/api/LiveEffectScene;", "", "panel", "Ljava/lang/String;", "Lcom/bytedance/android/live/effect/api/ILiveEffectComposerManager;", "getComposerManager", "()Lcom/bytedance/android/live/effect/api/ILiveEffectComposerManager;", "composerManager", "Landroidx/lifecycle/LiveData;", "getRepelStatus", "()Landroidx/lifecycle/LiveData;", "repelStatus", "<init>", "(Lcom/bytedance/android/live/effect/api/LiveEffectContextFactoryDelegate$Type;Lcom/bytedance/android/live/effect/api/LiveEffectScene;Ljava/lang/String;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public class LiveCommonStickerUIViewModel extends StickerBaseViewModel {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    public static final String TAG = "ttlive_anchor_effect_LiveCommonStickerUIViewModel";
    private final MutableLiveData<Boolean> _repelStatus;
    private final String panel;
    private final b repelStatusChangeListener;
    private final LiveEffectScene scene;
    private final com.bytedance.live.datacontext.p stickerDownloadCompleteEvent$delegate;
    private final com.bytedance.live.datacontext.p stickerDownloadStartEvent$delegate;
    private final LiveEffectContextFactoryDelegate$Type type;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements ILiveEffectComposerManager.i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveCommonStickerUIViewModel f67844a;

        public b(LiveCommonStickerUIViewModel r100) {
            this.f67844a = r100;
        }

        @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager.i
        public final void a(boolean r100, String r101, List<Sticker> r102) {
            Intrinsics.checkNotNullParameter(r101, "panel");
            Intrinsics.checkNotNullParameter(r102, "stickerList");
            if (Intrinsics.areEqual(r101, LiveCommonStickerUIViewModel.access$getPanel$p(this.f67844a)) == false) goto L6;
            LiveCommonStickerUIViewModel.access$get_repelStatus$p(this.f67844a).setValue(Boolean.valueOf(r100));
            return;
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(LiveCommonStickerUIViewModel.class, "stickerDownloadStartEvent", "getStickerDownloadStartEvent()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(LiveCommonStickerUIViewModel.class, "stickerDownloadCompleteEvent", "getStickerDownloadCompleteEvent()Lcom/bytedance/live/datacontext/IEventMember;", 0))};
        Companion = new a();
    }

    public final com.bytedance.live.datacontext.k<Sticker> getStickerDownloadCompleteEvent() {
        return (com.bytedance.live.datacontext.k) this.stickerDownloadCompleteEvent$delegate.a(this, $$delegatedProperties[1]);
    }

    public final com.bytedance.live.datacontext.k<Sticker> getStickerDownloadStartEvent() {
        return (com.bytedance.live.datacontext.k) this.stickerDownloadStartEvent$delegate.a(this, $$delegatedProperties[0]);
    }

    public void sendStickerShowLog(Sticker r100, int r101, LiveEffectScene r102) {
        Intrinsics.checkNotNullParameter(r100, "sticker");
        Intrinsics.checkNotNullParameter(r102, "scene");
    }

    private final ILiveEffectComposerManager getComposerManager() {
        List<String> r100 = LiveEffectContext.f66734h;
        return LiveEffectContext.a.a(this.type).a();
    }

    public final void startObserveRepelStatus() {
        getComposerManager().h(this.panel, this.repelStatusChangeListener);
    }

    public final void stopObserveRepelStatus() {
        getComposerManager().m(this.panel, this.repelStatusChangeListener);
    }

    public final LiveData<Boolean> getRepelStatus() {
        return this._repelStatus;
    }

    public static final /* synthetic */ String access$getPanel$p(LiveCommonStickerUIViewModel r100) {
        return r100.panel;
    }

    public static final /* synthetic */ MutableLiveData access$get_repelStatus$p(LiveCommonStickerUIViewModel r100) {
        return r100._repelStatus;
    }

    public LiveCommonStickerUIViewModel(LiveEffectContextFactoryDelegate$Type r100, LiveEffectScene r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "scene");
        Intrinsics.checkNotNullParameter(r102, "panel");
        this.type = r100;
        this.scene = r101;
        this.panel = r102;
        this.stickerDownloadStartEvent$delegate = com.bytedance.live.datacontext.e.b(this);
        this.stickerDownloadCompleteEvent$delegate = com.bytedance.live.datacontext.e.b(this);
        if (getComposerManager().U(r102) <= 0) goto L5;
        boolean r103 = true;
    L6:
        this._repelStatus = new MutableLiveData(Boolean.valueOf(r103));
        this.repelStatusChangeListener = new b(this);
        return;
    L5:
        r103 = false;
        goto L6
    }
}
