package com.bytedance.android.live.profit.player;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.gift.IGiftService;
import com.bytedance.android.live.profit.util.AssetUtilsKt;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdkapi.depend.live.player.ITextureViewPlayerController;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class EnterEffectProfilePreviewView extends FrameLayout implements uu0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f88272a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ITextureViewPlayerController f88273b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f88274c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final uu0.b.a f88275d;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EnterEffectProfilePreviewView f88276a;

        public a(EnterEffectProfilePreviewView r100) {
            this.f88276a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Unit r101 = (Unit) r100;
            ALogger.w("EnterEffectProfilePreview", "loading effect asset: asset_id=" + this.f88276a.getPreviewData().f551722b.getProfilePreviewAssetId());
            AssetUtilsKt.a(EnterEffectProfilePreviewView.d(this.f88276a), this.f88276a.getPreviewData().f551722b.getProfilePreviewAssetId(), 4, 1001, new EnterEffectProfilePreviewView$onPreviewCreate$1$1(this));
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f88277a = null;

        static {
            f88277a = new b();
        }

        public b() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            ALogger.e("EnterEffectProfilePreview", "sync asset list: error=" + ((Throwable) r100));
        }
    }

    private final IAssetsManager getAssetManager() {
        return (IAssetsManager) this.f88274c.getValue();
    }

    @Override // uu0.a
    public final View a() {
        return this;
    }

    @Override // uu0.a
    public final void b() {
        ITextureViewPlayerController r100 = this.f88273b;
        if (r100 == null) goto L5;
        r100.detachAlphaView(this);
    L5:
        ITextureViewPlayerController r101 = this.f88273b;
        if (r101 == null) goto L9;
        r101.release();
        return;
    }

    @Override // uu0.a
    public final void c() {
        ITextureViewPlayerController r100 = ((IGiftService) com.bytedance.android.live.revenue.core.util.f.a(IGiftService.class)).giftPlayControllerManager().createTextureViewPlayer(ContextUtil.contextToFragmentActivity(getContext()));
        this.f88273b = r100;
        r100.setEnableCropView(false);
        ALogger.w("EnterEffectProfilePreview", "waiting for asset sync");
        IAssetsManager r101 = getAssetManager();
        Intrinsics.checkNotNullParameter(r101, "$this$ensureSynced");
        if (r101.B7() <= 0) goto L5;
        Single r102 = Single.just(Unit.INSTANCE);
    L6:
        RxUtilKt.c(r102.subscribe(new a(this), b.f88277a), this.f88272a);
        return;
    L5:
        r102 = Single.create(new com.bytedance.android.live.profit.util.a(r101));
        goto L6
    }

    @Override // uu0.a
    public /* bridge */ /* synthetic */ uu0.b getPreviewData() {
        return getPreviewData();
    }

    @Override // uu0.a
    public uu0.b.a getPreviewData() {
        return this.f88275d;
    }

    public static final /* synthetic */ IAssetsManager d(EnterEffectProfilePreviewView r100) {
        return r100.getAssetManager();
    }

    public EnterEffectProfilePreviewView(Context r100, uu0.b.a r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "previewData");
        super(r100);
        this.f88275d = r101;
        this.f88272a = new CompositeDisposable();
        this.f88274c = LazyKt.lazy(EnterEffectProfilePreviewView$assetManager$2.INSTANCE);
    }
}
