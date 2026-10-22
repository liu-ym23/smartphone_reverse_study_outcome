package com.bytedance.android.livesdk.chatroom.widget.landscape;

import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.view.View;
import android.widget.ImageView;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.ui.VideoViewParams;
import com.bytedance.android.livesdk.chatroom.widget.m0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/widget/landscape/LandscapeQuickShotLayerWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LandscapeQuickShotLayerWidget extends LiveRecyclableWidget implements Observer<KVData> {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f118937m = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f118938a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView f118939b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f118940c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public VideoViewParams f118941d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Bitmap f118942e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public IRoom f118943f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Rect f118944g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f118945h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ValueAnimator f118946i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ValueAnimator f118947j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ValueAnimator f118948k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f118949l;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LandscapeQuickShotLayerWidget f118950a;

        public b(LandscapeQuickShotLayerWidget r100) {
            this.f118950a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            LandscapeQuickShotLayerWidget r100 = this.f118950a;     // Catch: Throwable -> L9
            DataCenter r101 = r100.dataCenter;     // Catch: Throwable -> L9
            if (r101 == null) goto L6;
            VideoViewParams r102 = (VideoViewParams) r101.get("live_render_view_params");     // Catch: Throwable -> L9
            if (r102 == null) goto L6;
        L7:
            r100.f118941d = r102;     // Catch: Throwable -> L9
            return;
        L6:
            r102 = new VideoViewParams(0, 0, 0, 0.0f);     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L13;
            return;
        L13:
            throw th;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
    }

    public final void xq() {
        vr1.u r100 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.u(null, this, 1);
        if (r100 == null) goto L9;
        com.bytedance.live.datacontext.j<m0> r101 = r100.N();
        if (r101 == null) goto L9;
        m0 r102 = r101.getValue();
        if (r102 == null) goto L9;
        this.f118944g = r102.a();
    L9:
        ValueAnimator r103 = this.f118946i;
        if (r103 == null) goto L12;
        r103.cancel();
    L12:
        ValueAnimator r104 = this.f118947j;
        if (r104 == null) goto L15;
        r104.cancel();
    L15:
        ValueAnimator r105 = this.f118948k;
        if (r105 == null) goto L18;
        r105.cancel();
    L18:
        View r106 = this.contentView;
        if (r106 == null) goto L21;
        r106.setAlpha(1.0f);
    L21:
        View r107 = this.contentView;
        if (r107 == null) goto L24;
        UtilityKotlinExtentionsKt.t(r107);
    L24:
        View r108 = this.f118938a;
        if (r108 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("dialogContentView");
    L27:
        if (r108 == null) goto L29;
        UtilityKotlinExtentionsKt.t(r108);
    L29:
        ImageView r109 = this.f118939b;
        if (r109 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("dialogContainerImageView");
    L32:
        if (r109 == null) goto L34;
        UtilityKotlinExtentionsKt.t(r109);
    L34:
        View r110 = this.f118940c;
        if (r110 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("btnShareView");
    L37:
        if (r110 == null) goto L39;
        UtilityKotlinExtentionsKt.t(r110);
    L39:
        View r111 = this.contentView;
        if (r111 == null) goto L43;
        r111.setOnClickListener(null);
        return;
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        int r100 = bs1.a.f20221a;
        return R.layout.ttlive_vs_dialog_quick_screenshot_landscape_v2;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        List r100 = CollectionsKt.mutableListOf(new String[]{"data_live_quick_shot_bitmap", "data_live_quick_shot_path", "data_live_quick_record_start", "data_live_quick_record_finish"});
        if (r100 == null) goto L8;
        Iterator r101 = r100.iterator();
    L6:
        if (r101.hasNext() == false) goto L10;
        String r102 = (String) r101.next();
        this.dataCenter.removeObserver(r102, this);
        goto L6
    L10:
        return;
    }

    public LandscapeQuickShotLayerWidget() {
        this.f118946i = ValueAnimator.ofInt(new int[]{1, 0}).setDuration(300);
        this.f118947j = ValueAnimator.ofInt(new int[]{1, 0}).setDuration(300);
        this.f118948k = ValueAnimator.ofInt(new int[]{0, 1}).setDuration(150);
        this.f118949l = LazyKt.lazy(LandscapeQuickShotLayerWidget$imgFinalWidth$2.INSTANCE);
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r210) {
        KVData r100 = (KVData) r210;
        if (r100 == null) goto L84;
        String r101 = r100.getKey();
        switch(r101.hashCode()) {
            case -1956533084: goto L81;
            case -1210674534: goto L59;
            case -904942447: goto L56;
            case 84498020: goto L8;
            default: goto L102;
        };
    L8:
        if (r101.equals("data_live_quick_shot_bitmap") == false) goto L99;
        this.dataCenter.put("data_live_quick_shot_layer_show", Boolean.TRUE);
        bs1.b r102 = (bs1.b) r100.getData();
        if (r102 == null) goto L12;
        Bitmap r103 = r102.f20223b;
    L13:
        if (r103 == null) goto L100;
        if (r102.f20222a == null) goto L101;
        com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.m().logQuickShotShareDialogShow(r102.f20225d);
        xq();
        this.f118942e = r102.f20223b;
        this.f118945h = r102.f20225d;
        View r104 = r102.f20222a;
        Intrinsics.checkNotNull(r104);
        Bitmap r105 = r102.f20223b;
        Intrinsics.checkNotNull(r105);
        UtilityKotlinExtentionsKt.w(this.contentView);
        View r106 = this.f118938a;
        if (r106 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("dialogContentView");
    L19:
        UtilityKotlinExtentionsKt.w(r106);
        ImageView r107 = this.f118939b;
        if (r107 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("dialogContainerImageView");
    L22:
        UtilityKotlinExtentionsKt.w(r107);
        ImageView r108 = this.f118939b;
        if (r108 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("dialogContainerImageView");
    L25:
        r108.setImageBitmap(r105);
        float r109 = s1.e(112.0f);
        r104.getLocationInWindow(new int[2]);
        Rect r110 = this.f118944g;
        if (r110 == null) goto L28;
        int r111 = r110.height();
    L29:
        float r112 = r111;
        float r113 = 2;
        float r114 = (s1.e(96.0f) + r112) / r113;
        VideoViewParams r115 = this.f118941d;
        if (r115 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("videoParam");
    L32:
        int r116 = (int) (r114 - (((r109 / r115.f112569a) * r112) / r113));
        Rect r117 = this.f118944g;
        if (r117 == null) goto L35;
        int r118 = r117.width();
    L36:
        float r119 = ((r118 - r104.getWidth()) - s1.f(14.0f)) - r109;
        Ref.IntRef r120 = new Ref.IntRef();
        VideoViewParams r121 = this.f118941d;
        if (r121 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("videoParam");
    L39:
        r120.element = r121.f112569a;
        Ref.IntRef r122 = new Ref.IntRef();
        VideoViewParams r123 = this.f118941d;
        if (r123 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("videoParam");
    L42:
        r122.element = r123.f112570b;
        Ref.FloatRef r124 = new Ref.FloatRef();
        r124.element = 0.0f;
        Ref.IntRef r125 = new Ref.IntRef();
        VideoViewParams r126 = this.f118941d;
        if (r126 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("videoParam");
    L45:
        r125.element = r126.f112571c + s1.r();
        if (r120.element > 0) goto L48;
    L49:
        r120.element = s1.t();
        r122.element = s1.r();
        r124.element = 0.0f;
        r125.element = s1.r();
    L50:
        int r127 = r120.element;
        int r128 = r122.element;
        if (r127 >= r128) goto L54;
        r127 = r128;
    L54:
        float r129 = ((Number) this.f118949l.getValue()).floatValue() / r127;
        Ref.FloatRef r130 = new Ref.FloatRef();
        r130.element = 0.0f;
        Ref.IntRef r131 = new Ref.IntRef();
        r131.element = 0;
        Ref.IntRef r132 = new Ref.IntRef();
        r132.element = 0;
        Ref.FloatRef r133 = new Ref.FloatRef();
        r133.element = 0.0f;
        Ref.IntRef r134 = new Ref.IntRef();
        r134.element = 0;
        Ref.IntRef r135 = new Ref.IntRef();
        r135.element = 0;
        this.f118946i.addUpdateListener(new j(this, r105, r130, r133, r129, r134, r120, r135, r122, r131, r124, r119, r132, r125, r116));
        this.f118946i.start();
        int r136 = bs1.a.f20221a;
        return;
    L48:
        if (r122.element > 0) goto L50;
    L35:
        r118 = 0;
        goto L36
    L28:
        r111 = 0;
        goto L29
    L101:
        return;
    L100:
        return;
    L12:
        r103 = null;
        goto L13
    L99:
        return;
    L56:
        if (r101.equals("data_live_quick_record_finish") == false) goto L90;
        xq();
        return;
    L90:
        return;
    L59:
        if (r101.equals("data_live_quick_shot_path") == false) goto L92;
        bs1.b r137 = (bs1.b) r100.getData();
        long r138 = this.f118945h;
        if (r137 == null) goto L63;
        long r139 = r137.f20225d;
    L64:
        int r140 = (r138 > r139 ? 1 : (r138 == r139 ? 0 : -1));
        int r141 = bs1.a.f20221a;
        if (r137 == null) goto L93;
        String r142 = r137.f20224c;
        if (r142 == null) goto L94;
        Bitmap r143 = r137.f20223b;
        IRoom r144 = this.f118943f;
        if (r144 == null) goto L76;
        IRoomAuthStatus r145 = r144.getRoomAuthStatus();
        if (r145 == null) goto L76;
        if (r145.enableLandscapeScreenShare() != true) goto L76;
        this.contentView.post(new i(this, r143, r142));
        return;
    L76:
        View r146 = this.contentView;
        if (r146 == null) goto L79;
        r146.setOnClickListener(new f(this, r143));
    L79:
        Observable.timer(1500, TimeUnit.MILLISECONDS).compose(RxUtil.rxSchedulerHelper()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new g(this, r143), h.f119076a);
        return;
    L94:
        return;
    L93:
        return;
    L63:
        r139 = 0;
        goto L64
    L92:
        return;
    L81:
        if (r101.equals("data_live_quick_record_start") == false) goto L97;
        xq();
        return;
    L97:
        return;
    L102:
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        this.f118938a = findViewById(R.id.ttlive_vs_dialog_content);
        this.f118939b = (ImageView) findViewById(R.id.ttlive_vs_quick_screenshot_img);
        this.f118940c = findViewById(R.id.btn_share);
        this.f118941d = (VideoViewParams) this.dataCenter.get("live_render_view_params", new VideoViewParams(0, 0, 0, 0.0f));
        this.contentView.post(new b(this));
        DataCenter r101 = this.dataCenter;
        if (r101 == null) goto L10;
        List r102 = CollectionsKt.mutableListOf(new String[]{"data_live_quick_shot_bitmap", "data_live_quick_shot_path", "data_live_quick_record_start", "data_live_quick_record_finish"});
        if (r102 == null) goto L10;
        Iterator r103 = r102.iterator();
    L8:
        if (r103.hasNext() == false) goto L10;
        r101.observe((String) r103.next(), this);
    L10:
        com.bytedance.android.livesdk.f.d().f123392a.observe(this, new AnonymousClass3(this));
        this.f118943f = (IRoom) this.dataCenter.get("data_room");
        xq();
    }

    public static final void wq(LandscapeQuickShotLayerWidget r100, Bitmap r101) {
        r100.dataCenter.put("data_live_quick_shot_layer_hide", Boolean.TRUE);
        int[] r102 = new int[2];
        View r103 = r100.contentView;
        if (r103 == null) goto L5;
        r103.getLocationOnScreen(r102);
    L5:
        r100.f118948k.addUpdateListener(new e(r100, r101));
        r100.f118948k.start();
    }
}
