package com.bytedance.android.livesdk.gift.format;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.profit.format.voicechat.fragment.FormatVoiceChatFragment$onViewCreated$$inlined$apply$lambda$1;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.gift.platform.business.effect.player.i;
import com.bytedance.android.livesdk.gift.platform.business.effect.player.k;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.AssetsService;
import com.bytedance.android.livesdkapi.depend.live.gift.IPlayerActionListener;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0018B'\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016R\u001b\u0010\n\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001b\u0010\u000f\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\u0007\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdk/gift/format/GiftPlayerView;", "Landroid/widget/FrameLayout;", "Ltr/d;", "Landroid/view/View;", "getView", "Lcom/bytedance/android/livesdk/gift/platform/core/scope/service/AssetsService;", "h", "Lkotlin/Lazy;", "getAssetsManager", "()Lcom/bytedance/android/livesdk/gift/platform/core/scope/service/AssetsService;", "assetsManager", "Ljy0/a;", RXScreenCaptureService.KEY_INDEX, "getLogger", "()Ljy0/a;", "logger", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GiftPlayerView extends FrameLayout implements tr.d {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f126206k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public k f126207a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public tr.c f126208b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BehaviorSubject<tr.a> f126209c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayDeque<tr.a> f126210d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ArrayList<tr.a> f126211e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CompositeDisposable f126212f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f126213g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f126214h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f126215i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final b f126216j;

    public final class a implements IPlayerActionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GiftPlayerView f126217a;

        @Override // com.bytedance.android.livesdkapi.depend.live.gift.IPlayerActionListener
        public final void onFileLoaded(int r100, int r101) {
        }

        @Override // com.bytedance.android.livesdkapi.depend.live.gift.IPlayerActionListener
        public final /* synthetic */ void onReportPlayMetrics(Map r100) {
            IPlayerActionListener.CC.$default$onReportPlayMetrics(this, r100);
        }

        @Override // com.bytedance.android.livesdkapi.depend.live.gift.IPlayerActionListener
        public final void updateTextEffectPosition(float r100, float r101, float r102, float r103) {
        }

        @Override // com.bytedance.android.livesdkapi.depend.live.gift.IPlayerActionListener
        public final void onEnd() {
            GiftPlayerView.c(this.f126217a);
        }

        @Override // com.bytedance.android.livesdkapi.depend.live.gift.IPlayerActionListener
        public final void onFirstFrame() {
            GiftPlayerView r100 = this.f126217a;
            int r101 = GiftPlayerView.f126206k;
            r100.e("on first frame");
            tr.a r102 = r100.f126209c.getValue();
            if (r102 == null) goto L8;
            tr.c r103 = r100.f126208b;
            if (r103 == null) goto L9;
            r103.c(r102);
            return;
        L9:
            return;
        }

        @Override // com.bytedance.android.livesdkapi.depend.live.gift.IPlayerActionListener
        public final void onStart() {
            GiftPlayerView r100 = this.f126217a;
            int r101 = GiftPlayerView.f126206k;
            r100.e("on play start");
            tr.a r102 = r100.f126209c.getValue();
            if (r102 == null) goto L12;
            k r103 = r100.f126207a;
            if (r103 == null) goto L7;
            long r104 = r103.getDuration();
        L8:
            r102.f547270e = r104;
            tr.c r105 = r100.f126208b;
            if (r105 == null) goto L13;
            r105.b(r102);
            return;
        L13:
            return;
        L7:
            r104 = 0;
            goto L8
        }

        @Override // com.bytedance.android.livesdkapi.depend.live.gift.IPlayerActionListener
        public final void onStop() {
            GiftPlayerView.c(this.f126217a);
        }

        public a(GiftPlayerView r100) {
            this.f126217a = r100;
        }
    }

    public static final class b implements IAssetsManager.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GiftPlayerView f126218a;

        @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager.b
        public final void a() {
        }

        public b(GiftPlayerView r100) {
            this.f126218a = r100;
        }

        @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager.b
        public final void b(List<? extends com.bytedance.android.live.core.resources.e> r100) {
            Intrinsics.checkNotNullParameter(r100, "assetsModels");
            Iterator<tr.a> r101 = this.f126218a.f126211e.iterator();
        L4:
            if (r101.hasNext() == false) goto L8;
            tr.a r102 = r101.next();
            if (GiftPlayerView.b(this.f126218a).G1(r102.f547269d) == null) goto L4;
            this.f126218a.f126210d.addLast(r102);
            r101.remove();
            goto L4
        L8:
            GiftPlayerView r103 = this.f126218a;
            if (r103.f126213g == false) goto L11;
            return;
        L11:
            if ((!r103.f126210d.isEmpty()) == false) goto L20;
            GiftPlayerView r104 = this.f126218a;
            r104.f126209c.onNext(r104.f126210d.removeFirst());
            return;
        }
    }

    public GiftPlayerView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public GiftPlayerView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final AssetsService getAssetsManager() {
        return (AssetsService) this.f126214h.getValue();
    }

    private final jy0.a getLogger() {
        return (jy0.a) this.f126215i.getValue();
    }

    @Override // tr.d
    public View getView() {
        return this;
    }

    @Override // tr.d
    public final void release() {
        this.f126212f.dispose();
        k r100 = this.f126207a;
        if (r100 == null) goto L5;
        r100.f129469b = null;
    L5:
        if (r100 == null) goto L7;
        r100.detachAlphaView(this);
    L7:
        k r101 = this.f126207a;
        if (r101 == null) goto L10;
        r101.release();
    L10:
        this.f126207a = null;
        getAssetsManager().l0(this.f126216j);
    }

    public static final /* synthetic */ AssetsService b(GiftPlayerView r100) {
        return r100.getAssetsManager();
    }

    public static final void c(GiftPlayerView r100) {
        r100.getClass();
        r100.e("on play finished, is queue empty: " + r100.f126210d.isEmpty());
        r100.f126213g = false;
        tr.a r101 = r100.f126209c.getValue();
        if (r101 == null) goto L8;
        tr.c r102 = r100.f126208b;
        if (r102 == null) goto L8;
        r102.a(r101);
    L8:
        if ((!r100.f126210d.isEmpty()) == false) goto L11;
        r100.f126209c.onNext(r100.f126210d.removeFirst());
        return;
    }

    @Override // tr.d
    public final void a(h1 r100) {
        Intrinsics.checkNotNullParameter(r100, PbRequest.SwitchType.GIFT);
        long r101 = r100.getId();
        String r102 = r100.getName();
        py.k r103 = r100.getImage();
        if (r103 == null) goto L8;
        List<String> r104 = r103.getUrls();
        if (r104 == null) goto L8;
        String r105 = (String) CollectionsKt.firstOrNull(r104);
        if (r105 == null) goto L8;
    L9:
        tr.a r106 = new tr.a(r101, r102, r105, r100.getPrimaryEffectId());
        Intrinsics.checkNotNullParameter(r100, "$this$isMp4Gift");
        if (r100.getType() != 2) goto L12;
        boolean r107 = true;
    L13:
        if (r107 == true) goto L19;
        e("not mp4 gift, stop play");
        tr.c r108 = this.f126208b;
        if (r108 == null) goto L26;
        r108.a(r106);
        return;
    L26:
        return;
    L19:
        if (getAssetsManager().G1(r106.f547269d) != null) goto L22;
        e("assets manager is not ready");
        this.f126211e.add(r106);
        getAssetsManager().d4(2, false, r106.f547269d, "FormatGift");
        return;
    L22:
        this.f126210d.addLast(r106);
        if (this.f126213g == true) goto L27;
        this.f126209c.onNext(this.f126210d.removeFirst());
        return;
    L27:
        return;
    L12:
        r107 = false;
    L8:
        r105 = "";
        goto L9
    }

    public final void e(String r100) {
        getLogger().k("GiftPlayerView", r100);
    }

    public final void f(FormatVoiceChatFragment$onViewCreated$$inlined$apply$lambda$1 r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f126208b = r100;
    }

    public static final void d(GiftPlayerView r100, tr.a r101) {
        r100.f126213g = true;
        r100.e("on start play");
        String r102 = r100.getAssetsManager().H0(r101.f547269d);
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        com.bytedance.revenue.platform.api.core.rx.f.a(Single.just(r102).flatMap(new d(r100, r101)).subscribe(new e(r100), new f(r100, r101)), r100.f126212f);
    }

    public GiftPlayerView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        BehaviorSubject<tr.a> r103 = BehaviorSubject.create();
        this.f126209c = r103;
        this.f126210d = new ArrayDeque();
        this.f126211e = new ArrayList();
        a r104 = new a(this);
        CompositeDisposable r105 = new CompositeDisposable();
        this.f126212f = r105;
        this.f126214h = LazyKt.lazy(GiftPlayerView$assetsManager$2.INSTANCE);
        this.f126215i = LazyKt.lazy(GiftPlayerView$logger$2.INSTANCE);
        b r106 = new b(this);
        this.f126216j = r106;
        i r107 = i.a();
        Context r108 = getContext();
        if (r108 == null) goto L10;
        k r109 = (k) r107.createTextureViewPlayer((FragmentActivity) r108);
        this.f126207a = r109;
        Intrinsics.checkNotNullParameter(r104, "listener");
        r109.f129469b = r104;
        k r110 = this.f126207a;
        if (r110 == null) goto L7;
        r110.attachAlphaView(this);
    L7:
        com.bytedance.revenue.platform.api.core.rx.f.a(r103.subscribe(new c(this)), r105);
        getAssetsManager().T(r106);
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    }

    public /* synthetic */ GiftPlayerView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
