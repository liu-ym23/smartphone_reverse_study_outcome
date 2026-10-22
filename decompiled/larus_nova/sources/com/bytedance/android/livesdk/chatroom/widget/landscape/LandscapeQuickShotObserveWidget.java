package com.bytedance.android.livesdk.chatroom.widget.landscape;

import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.net.Uri;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.ui.VideoViewParams;
import com.bytedance.android.livesdk.chatroom.widget.m0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/widget/landscape/LandscapeQuickShotObserveWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LandscapeQuickShotObserveWidget extends LiveRecyclableWidget implements Observer<KVData> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f118952o = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f118953a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f118954b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public HSImageView f118955c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f118956d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public VideoViewParams f118957e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Room f118958f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Rect f118959g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public bs1.b f118960h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public GestureDetector f118961i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ValueAnimator f118962j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ValueAnimator f118963k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ValueAnimator f118964l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f118965m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final b f118966n;

    public static final class a {
    }

    public static final class b extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LandscapeQuickShotObserveWidget f118967a;

        public b(LandscapeQuickShotObserveWidget r100) {
            this.f118967a = r100;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onScroll(MotionEvent r100, MotionEvent r101, float r102, float r103) {
            Intrinsics.checkNotNullParameter(r101, "e2");
            if (Math.abs(r102) <= Math.abs(r103)) goto L8;
            if (r102 >= 0) goto L8;
            int r104 = x8.a.f562881a;
            x8.a.d(this.f118967a.f118953a, "scroll & dismiss ____ distanceX = " + r102 + "   +   distanceY = " + r103 + ' ', false);
            LandscapeQuickShotObserveWidget.wq(this.f118967a);
        L8:
            return super.onScroll(r100, r101, r102, r103);
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LandscapeQuickShotObserveWidget f118968a;

        public c(LandscapeQuickShotObserveWidget r100) {
            this.f118968a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            LandscapeQuickShotObserveWidget r100 = this.f118968a;     // Catch: Throwable -> L9
            DataCenter r101 = r100.dataCenter;     // Catch: Throwable -> L9
            if (r101 == null) goto L6;
            VideoViewParams r102 = (VideoViewParams) r101.get("live_render_view_params");     // Catch: Throwable -> L9
            if (r102 == null) goto L6;
        L7:
            r100.f118957e = r102;     // Catch: Throwable -> L9
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

    public static final class d implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LandscapeQuickShotObserveWidget f118969a;

        public d(LandscapeQuickShotObserveWidget r100) {
            this.f118969a = r100;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r100, MotionEvent r101) {
            GestureDetector r102 = this.f118969a.f118961i;
            if (r102 == null) goto L7;
            Intrinsics.checkNotNull(r101);
            r102.onTouchEvent(r101);
            return false;
        L7:
            return false;
        }
    }

    static {
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.ttlive_dialog_quick_screenshot_landscape;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        List r100 = CollectionsKt.mutableListOf(new String[]{"data_live_quickshot_auto_observe"});
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

    public final void xq() {
        RoomContext r100 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r100 == null) goto L9;
        com.bytedance.live.datacontext.j<m0> r101 = r100.getRoomUISizeGetter();
        if (r101 == null) goto L9;
        m0 r102 = r101.getValue();
        if (r102 == null) goto L9;
        this.f118959g = r102.a();
    L9:
        ValueAnimator r103 = this.f118962j;
        if (r103 == null) goto L12;
        r103.cancel();
    L12:
        ValueAnimator r104 = this.f118963k;
        if (r104 == null) goto L15;
        r104.cancel();
    L15:
        ValueAnimator r105 = this.f118964l;
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
        View r108 = this.f118954b;
        if (r108 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("dialogContentView");
    L27:
        if (r108 == null) goto L29;
        UtilityKotlinExtentionsKt.t(r108);
    L29:
        HSImageView r109 = this.f118955c;
        if (r109 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("dialogContainerImageView");
    L32:
        if (r109 == null) goto L34;
        UtilityKotlinExtentionsKt.t(r109);
    L34:
        View r110 = this.f118956d;
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

    public LandscapeQuickShotObserveWidget() {
        this.f118953a = "LandscapeQuickShotObserveWidget";
        this.f118962j = ValueAnimator.ofInt(new int[]{1, 0}).setDuration(300);
        this.f118963k = ValueAnimator.ofInt(new int[]{1, 0}).setDuration(300);
        this.f118964l = ValueAnimator.ofInt(new int[]{0, 1}).setDuration(150);
        this.f118965m = LazyKt.lazy(LandscapeQuickShotObserveWidget$imgFinalWidth$2.INSTANCE);
        this.f118966n = new b(this);
    }

    public static final void wq(LandscapeQuickShotObserveWidget r100) {
        r100.dataCenter.put("data_live_quick_shot_layer_hide", Boolean.TRUE);
        int[] r101 = new int[2];
        View r102 = r100.contentView;
        if (r102 == null) goto L5;
        r102.getLocationOnScreen(r101);
    L5:
        r100.f118964l.addUpdateListener(new m(r100));
        r100.f118964l.start();
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r110) {
        KVData r100 = (KVData) r110;
        if (r100 == null) goto L59;
        String r101 = r100.getKey();
        if (r101.hashCode() != (-391345406)) goto L59;
        if (r101.equals("data_live_quickshot_auto_observe") == false) goto L59;
        bs1.b r102 = (bs1.b) r100.getData();
        this.f118960h = r102;
        if (r102 == null) goto L12;
        String r103 = r102.f20224c;
    L14:
        if (TextUtils.isEmpty(r103) == true) goto L59;
        xq();
        bs1.b r104 = this.f118960h;
        if (r104 == null) goto L59;
        String r105 = r104.f20224c;
        if (r105 == null) goto L59;
        UtilityKotlinExtentionsKt.w(this.contentView);
        View r106 = this.f118954b;
        if (r106 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("dialogContentView");
    L22:
        UtilityKotlinExtentionsKt.w(r106);
        HSImageView r107 = this.f118955c;
        if (r107 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("dialogContainerImageView");
    L25:
        UtilityKotlinExtentionsKt.w(r107);
        PolarisFileWrapper r108 = new PolarisFileWrapper(r105);
        HSImageView r109 = this.f118955c;
        if (r109 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("dialogContainerImageView");
    L28:
        r109.setImageURI(Uri.fromFile(r108).toString());
        float r111 = s1.e(112.0f);
        Rect r112 = this.f118959g;
        if (r112 == null) goto L31;
        int r113 = r112.height();
    L32:
        float r114 = r113;
        float r115 = 2;
        float r116 = (s1.e(96.0f) + r114) / r115;
        VideoViewParams r117 = this.f118957e;
        if (r117 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("videoParam");
    L35:
        int r118 = (int) (r116 - (((r111 / r117.f112569a) * r114) / r115));
        Ref.FloatRef r119 = new Ref.FloatRef();
        Rect r120 = this.f118959g;
        if (r120 == null) goto L38;
        int r121 = r120.width();
    L39:
        r119.element = (r121 - s1.f(14.0f)) - r111;
        Ref.IntRef r122 = new Ref.IntRef();
        VideoViewParams r123 = this.f118957e;
        if (r123 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("videoParam");
    L42:
        r122.element = r123.f112569a;
        Ref.IntRef r124 = new Ref.IntRef();
        VideoViewParams r125 = this.f118957e;
        if (r125 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("videoParam");
    L45:
        r124.element = r125.f112570b;
        Ref.FloatRef r126 = new Ref.FloatRef();
        r126.element = 0.0f;
        Ref.IntRef r127 = new Ref.IntRef();
        VideoViewParams r128 = this.f118957e;
        if (r128 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("videoParam");
    L48:
        r127.element = r128.f112571c + s1.r();
        if (r122.element > 0) goto L51;
    L52:
        r122.element = s1.t();
        r124.element = s1.r();
        r126.element = 0.0f;
        r127.element = s1.r();
    L53:
        int r129 = r122.element;
        int r130 = r124.element;
        if (r129 >= r130) goto L57;
        r129 = r130;
    L57:
        float r131 = ((Number) this.f118965m.getValue()).floatValue() / r129;
        Ref.FloatRef r132 = new Ref.FloatRef();
        r132.element = 0.0f;
        Ref.IntRef r133 = new Ref.IntRef();
        r133.element = 0;
        Ref.IntRef r134 = new Ref.IntRef();
        r134.element = 0;
        Ref.FloatRef r135 = new Ref.FloatRef();
        r135.element = 0.0f;
        Ref.IntRef r136 = new Ref.IntRef();
        r136.element = 0;
        Ref.IntRef r137 = new Ref.IntRef();
        r137.element = 0;
        r119.element = ((s1.t() - UtilityKotlinExtentionsKt.i(112)) - UtilityKotlinExtentionsKt.i(168)) - UtilityKotlinExtentionsKt.i(12);
        this.f118962j.addUpdateListener(new o(this, r132, r135, r131, r136, r122, r137, r124, r133, r126, r119, r134, r127, r118));
        this.f118962j.start();
        this.contentView.post(new n(this));
        return;
    L51:
        if (r124.element > 0) goto L53;
    L38:
        r121 = 0;
        goto L39
    L31:
        r113 = 0;
        goto L32
    L12:
        r103 = null;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        this.f118954b = findViewById(R.id.ttlive_vs_dialog_content);
        this.f118955c = (HSImageView) findViewById(R.id.ttlive_vs_quick_screenshot_img);
        this.f118956d = findViewById(R.id.btn_share);
        this.f118957e = (VideoViewParams) this.dataCenter.get("live_render_view_params", new VideoViewParams(0, 0, 0, 0.0f));
        this.contentView.post(new c(this));
        DataCenter r101 = this.dataCenter;
        if (r101 == null) goto L10;
        List r102 = CollectionsKt.mutableListOf(new String[]{"data_live_quickshot_auto_observe"});
        if (r102 == null) goto L10;
        Iterator r103 = r102.iterator();
    L8:
        if (r103.hasNext() == false) goto L10;
        r101.observe((String) r103.next(), this);
    L10:
        com.bytedance.android.livesdk.f.d().f123392a.observe(this, new AnonymousClass3(this));
        this.f118958f = (Room) this.dataCenter.get("data_room");
        xq();
        this.f118961i = new GestureDetector(this.context, this.f118966n);
        View r104 = this.f118954b;
        if (r104 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("dialogContentView");
    L13:
        if (r104 == null) goto L17;
        r104.setOnTouchListener(new d(this));
        return;
    }
}
