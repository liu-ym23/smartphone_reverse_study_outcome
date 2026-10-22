package com.bytedance.android.ec.window.base.floatlayout;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.camera.video.AudioStats;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.amap.api.col.s.ce;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.utils.l0;
import com.bytedance.android.ec.window.base.utils.i;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.larus.utils.logger.FLogger;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONObject;
import pd.f;
import ti.k;
import ti.l;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001 J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0007R\u001b\u0010\r\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00148\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u001a8\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006!"}, d2 = {"Lcom/bytedance/android/ec/window/base/floatlayout/WindowFloatLayout;", "Landroid/widget/FrameLayout;", "Landroidx/lifecycle/LifecycleObserver;", "Lcom/bytedance/android/ec/window/base/floatlayout/a;", "Landroid/view/ViewGroup;", "getStoreRootView", "", LiveCommonConstants.REASON_ON_DEDTROY, "Lti/k;", "d", "Lkotlin/Lazy;", "getLynxCallback", "()Lti/k;", "lynxCallback", "Landroidx/fragment/app/DialogFragment;", "e", "Landroidx/fragment/app/DialogFragment;", "getDialogFragment", "()Landroidx/fragment/app/DialogFragment;", "dialogFragment", "Lorg/json/JSONObject;", "f", "Lorg/json/JSONObject;", "getData", "()Lorg/json/JSONObject;", "data", "", ce.f26391f, "Ljava/lang/String;", "getContainerID", "()Ljava/lang/String;", "containerID", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class WindowFloatLayout extends FrameLayout implements LifecycleObserver, com.bytedance.android.ec.window.base.floatlayout.a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Map<String, Stack<WeakReference<WindowFloatLayout>>> f49322h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public l f49323a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f49324b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f49325c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f49326d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final DialogFragment f49327e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final JSONObject f49328f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f49329g;

    public static final class a {
        public static void a(String r100) {
            if (r100 != null) goto L4;
            return;
        L4:
            Map<String, Stack<WeakReference<WindowFloatLayout>>> r101 = WindowFloatLayout.f49322h;
            Stack r102 = (Stack) ((LinkedHashMap) r101).get(r100);
            if (r102 != null) goto L8;
            return;
        L8:
            if (r102.empty() == false) goto L10;
            return;
        L10:
            WindowFloatLayout r103 = (WindowFloatLayout) ((WeakReference) r102.pop()).get();
            if (r103 == null) goto L16;
            ViewGroup r104 = WindowFloatLayout.d(r103);
            if (r104 == null) goto L16;
            r104.removeView(r103);
        L16:
            if (r102.empty() == false) goto L19;
            r101.remove(r100);
            return;
        }
    }

    private final k getLynxCallback() {
        return (k) this.f49326d.getValue();
    }

    static {
        f49322h = new LinkedHashMap();
    }

    private final ViewGroup getStoreRootView() {
        DialogFragment r100 = this.f49327e;
        View r101 = null;
        if (r100 == null) goto L16;
        Dialog r102 = r100.getDialog();
        if (r102 == null) goto L9;
        Window r103 = r102.getWindow();
        if (r103 == null) goto L9;
        View r104 = c(r103);
    L11:
        if ((r104 instanceof ViewGroup) == false) goto L15;
        r101 = r104;
    L15:
        return (ViewGroup) r101;
    L9:
        r104 = null;
        goto L11
    L16:
        Activity r105 = l0.b(getContext());
        if (r105 == null) goto L24;
        View r106 = c(r105.getWindow());
        if ((r106 instanceof ViewGroup) == false) goto L23;
        r101 = r106;
    L23:
        return (ViewGroup) r101;
    L24:
        return null;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        l r100 = this.f49323a;
        if (r100 == null) goto L5;
        r100.release();
    L5:
        ECLiveHybridUtil.p("store_float_layout_close", this.f49324b);
        ECLiveHybridUtil.p("store_float_layout_click", this.f49325c);
        a.a(this.f49329g);
    }

    public final String getContainerID() {
        return this.f49329g;
    }

    public final JSONObject getData() {
        return this.f49328f;
    }

    public final DialogFragment getDialogFragment() {
        return this.f49327e;
    }

    public static View c(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static final /* synthetic */ ViewGroup d(WindowFloatLayout r100) {
        return r100.getStoreRootView();
    }

    public final void e(String r110, Map<String, ? extends Object> r111, Function1<? super l, Unit> r112) {
        Intrinsics.checkNotNullParameter(r111, "dataMap");
        if (r110 != null) goto L5;
        return;
    L5:
        l r100 = ECLiveHybridUtil.b(getContext(), r110, r111, this, getLynxCallback(), null, null, false, null, r112, false, 3040);
        this.f49323a = r100;
        boolean r101 = ECServiceManager.f42805a;
        IAdapterService r102 = (IAdapterService) ECServiceManager.c(IAdapterService.class);
        if (r102 == null) goto L12;
        pd.e r103 = r102.getIExternaHybridService();
        if (r103 == null) goto L12;
        f r104 = r103.getExternalJsBridgeMethodInjectorAdapter();
        if (r104 == null) goto L12;
        com.bytedance.android.ec.adapter.impl.adapters.browser.c r105 = r104.d(new WindowFloatLayout$registerJsbSaveData$method$1());
    L13:
        if (r100 == null) goto L15;
        r100.registerMethod("ecom.shop.handle_native_for_remote_data", new e(r105));
    L15:
        ECLiveHybridUtil.m("store_float_layout_close", this.f49324b);
        ECLiveHybridUtil.m("store_float_layout_click", this.f49325c);
        return;
    L12:
        r105 = null;
        goto L13
    }

    public WindowFloatLayout(Context r110, DialogFragment r111, JSONObject r112, String r113) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110);
        this.f49327e = r111;
        this.f49328f = r112;
        this.f49329g = r113;
        this.f49324b = new d(this);
        this.f49325c = new c(this);
        FrameLayout.LayoutParams r114 = null;
        if (r111 == null) goto L6;
        Lifecycle r115 = r111.getLifecycle();
        if (r115 == null) goto L6;
    L10:
        if (r115 == null) goto L12;
        r115.addObserver(this);
    L12:
        ViewGroup r116 = getStoreRootView();
        if (r116 != null) goto L15;
    L34:
        this.f49326d = LazyKt.lazy(new WindowFloatLayout$lynxCallback$2(this));
        return;
    L15:
        if (r112 == null) goto L26;
        JSONObject r117 = com.bytedance.android.shopping.extensions.k.w(r112.optString("layout_info"));
        if (r117 == null) goto L27;
        boolean r118 = r117.optBoolean("is_rpx", false);
        double r100 = r117.optDouble("width", AudioStats.AUDIO_AMPLITUDE_NONE);
        double r101 = 0;
        int r102 = -1;
        if (r100 <= r101) goto L21;
        int r103 = i.f49729a;
        int r104 = i.f(Double.valueOf(r100), r118);
    L22:
        double r105 = r117.optDouble("height", AudioStats.AUDIO_AMPLITUDE_NONE);
        if (r105 <= r101) goto L25;
        int r106 = i.f49729a;
        r102 = i.f(Double.valueOf(r105), r118);
    L25:
        r114 = new FrameLayout.LayoutParams(r104, r102);
        r114.gravity = 8388691;
        r114.setMargins(RangesKt.coerceAtLeast(vf4.a.b(Double.valueOf(r117.optDouble("left", AudioStats.AUDIO_AMPLITUDE_NONE))), 0), RangesKt.coerceAtLeast(vf4.a.b(Double.valueOf(r117.optDouble("top", AudioStats.AUDIO_AMPLITUDE_NONE))), 0), RangesKt.coerceAtLeast(vf4.a.b(Double.valueOf(r117.optDouble("right", AudioStats.AUDIO_AMPLITUDE_NONE))), 0), (RangesKt.coerceAtLeast(vf4.a.b(Double.valueOf(r117.optDouble("bottom", AudioStats.AUDIO_AMPLITUDE_NONE))), 0) + 0) + l0.e(getContext()));
        goto L27
    L21:
        r104 = -1;
    L27:
        if (r114 == null) goto L34;
        r116.addView(this, r114);
        if (r113 == null) goto L34;
        Map<String, Stack<WeakReference<WindowFloatLayout>>> r119 = f49322h;
        Stack<WeakReference<WindowFloatLayout>> r120 = (Stack) ((LinkedHashMap) r119).get(r113);
        if (r120 != null) goto L33;
        r120 = new Stack();
        r119.put(r113, r120);
    L33:
        r120.push(new WeakReference(this));
        goto L34
    L26:
        r114 = new FrameLayout.LayoutParams(-2, -2);
        r114.gravity = 8388691;
        r114.setMargins(0, 0, vf4.a.a(getContext(), 12.0f), vf4.a.a(getContext(), 120.0f));
    L6:
        FragmentActivity r121 = l0.c(getContext());
        if (r121 == null) goto L9;
        r115 = r121.getLifecycle();
        goto L10
    L9:
        r115 = null;
        goto L10
    }
}
