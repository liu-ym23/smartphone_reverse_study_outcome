package com.bytedance.android.ec.core.hybrid.widgets;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.camera.video.AudioStats;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import ch.b;
import com.amap.api.col.s.ce;
import com.android.ttcjpaysdk.base.CJPayConstant;
import com.bytedance.android.ec.sdk.helper.n;
import com.bytedance.android.ec.sdk.helper.r;
import com.bytedance.android.ec.sdk.plugin.e;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.larus.avlink.aiproactive.AiProactiveTaskViewModel;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import ti.l;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u000b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0006J\b\u0010\u0004\u001a\u00020\u0003H\u0007R\u0017\u0010\n\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR%\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00018\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/ec/core/hybrid/widgets/LynxTaskBanner;", "Landroid/widget/FrameLayout;", "Landroidx/lifecycle/LifecycleObserver;", "", LiveCommonConstants.REASON_ON_DEDTROY, "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Ljava/lang/String;", "getContainerID", "()Ljava/lang/String;", "containerID", "", "", ce.f26391f, "Ljava/util/Map;", "getInitData", "()Ljava/util/Map;", "initData", "h", "Landroid/widget/FrameLayout;", "getViewGroup", "()Landroid/widget/FrameLayout;", "viewGroup", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LynxTaskBanner extends FrameLayout implements LifecycleObserver {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Map<String, LynxTaskBanner> f44339i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f44340a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public l f44341b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f44342c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f44343d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CompositeDisposable f44344e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f44345f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<String, Object> f44346g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final FrameLayout f44347h;

    public static final class a {
        public static String a(Context r100, Map r101, FrameLayout r102) {
            if (r100 != null) goto L5;
            return "context should not be null";
        L5:
            if (r101 != null) goto L8;
            return "params should not be null";
        L8:
            LynxTaskBanner r103 = new LynxTaskBanner(r100, r101, r102);
            Object r104 = r103.f44346g.get("task_enter_from");
            Object r105 = null;
            if ((r104 instanceof String) == true) goto L11;
            r104 = null;
        L11:
            r103.f44342c = (String) r104;
            Object r106 = r103.f44346g.get(AiProactiveTaskViewModel.PARAM_TASK_TYPE);
            if ((r106 instanceof String) == true) goto L14;
            r106 = null;
        L14:
            r103.f44343d = (String) r106;
            Object r107 = r103.f44346g.get("task_request_params");
            if ((r107 instanceof JSONObject) == false) goto L18;
            r105 = r107;
        L18:
            JSONObject r108 = (JSONObject) r105;
            if (r108 != null) goto L29;
            String r109 = r103.f44343d;
            if (r109 != null) goto L23;
        L26:
            boolean r110 = true;
        L27:
            if (r110 == false) goto L29;
            return "task_request_params or task_type should not be empty";
        L23:
            if (r109.length() == 0) goto L26;
            r110 = false;
        L29:
            CompositeDisposable r111 = r103.f44344e;
            ECLynxTaskBannerApi r112 = (ECLynxTaskBannerApi) n.f48128a.create(CJPayConstant.TT_CJ_PAY_FOLLOW_HOST, ECLynxTaskBannerApi.class);
            ECLynxTaskBannerApi.f44337a.getClass();
            LinkedHashMap r113 = new LinkedHashMap();
            r113.put("taskType", r103.f44343d);
            r113.put("bizID", r103.f44342c);
            r113.put("user_id", r.f48132a.getCurrentUserId());
            if (r108 == null) goto L35;
            Iterator<String> r114 = r108.keys();
        L33:
            if (r114.hasNext() == false) goto L35;
            String r115 = r114.next();
            r113.put(r115, r108.optString(r115));
        L35:
            Unit r116 = Unit.INSTANCE;
            r111.add(r112.getFloatWindowDetail("https://lianmengapi.snssdk.com/ecom/activity/biz_mesh_api/get_floating_window_detail/", r113).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new ch.a(r103), b.f23712a));
            return r103.f44340a;
        }
    }

    static {
        f44339i = new LinkedHashMap();
    }

    public final void b() {
        if (this.f44345f == false) goto L5;
        return;
    L5:
        l r100 = this.f44341b;
        if (r100 == null) goto L8;
        r100.release();
    L8:
        Object r101 = null;
        this.f44341b = null;
        this.f44344e.dispose();
        FrameLayout r102 = this.f44347h;
        if (r102 == null) goto L11;
        r102.removeView(this);
    L23:
        removeAllViews();
        Context r103 = getContext();
        if ((r103 instanceof LifecycleOwner) == false) goto L27;
        r101 = r103;
    L27:
        LifecycleOwner r104 = (LifecycleOwner) r101;
        if (r104 == null) goto L32;
        Lifecycle r105 = r104.getLifecycle();
        if (r105 == null) goto L32;
        r105.removeObserver(this);
    L32:
        this.f44345f = true;
        return;
    L11:
        Activity r106 = e.getActivity(getContext());
        if (r106 == null) goto L16;
        Window r107 = r106.getWindow();
        if (r107 == null) goto L16;
        View r108 = a(r107);
    L18:
        if ((r108 instanceof ViewGroup) == true) goto L20;
        r108 = null;
    L20:
        ViewGroup r109 = (ViewGroup) r108;
        if (r109 == null) goto L23;
        r109.removeView(this);
    L16:
        r108 = null;
        goto L18
    }

    public final String getContainerID() {
        return this.f44340a;
    }

    public final Map<String, Object> getInitData() {
        return this.f44346g;
    }

    public final FrameLayout getViewGroup() {
        return this.f44347h;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        b();
    }

    public static View a(Window r100) {
        View r101 = r100.getDecorView();
        if (c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == c.f346341a) goto L7;
        c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public LynxTaskBanner(Context r110, Map<String, ? extends Object> r111, FrameLayout r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "initData");
        super(r110);
        this.f44346g = r111;
        this.f44347h = r112;
        String r100 = UUID.randomUUID().toString();
        this.f44340a = r100;
        this.f44344e = new CompositeDisposable();
        Object r113 = r111.get("frame");
        View r101 = null;
        if ((r113 instanceof JSONObject) == true) goto L5;
        r113 = null;
    L5:
        JSONObject r114 = (JSONObject) r113;
        if ((r110 instanceof FragmentActivity) == false) goto L29;
        FragmentActivity r102 = (FragmentActivity) r110;
        r102.getLifecycle().addObserver(this);
        View r103 = a(r102.getWindow());
        if ((r103 instanceof FrameLayout) == false) goto L11;
        r101 = r103;
    L11:
        FrameLayout r104 = (FrameLayout) r101;
        if (r104 == null) goto L30;
        int r105 = -2;
        if (r114 == null) goto L23;
        double r106 = r114.optDouble("width", AudioStats.AUDIO_AMPLITUDE_NONE);
        double r107 = 0;
        if (r106 < r107) goto L18;
        int r115 = vf4.a.b(Double.valueOf(r106));
    L19:
        double r108 = r114.optDouble("height", AudioStats.AUDIO_AMPLITUDE_NONE);
        if (r108 < r107) goto L22;
        r105 = vf4.a.b(Double.valueOf(r108));
    L22:
        FrameLayout.LayoutParams r109 = new FrameLayout.LayoutParams(r115, r105);
        r109.gravity = 51;
        r109.setMargins(vf4.a.b(Double.valueOf(r114.optDouble("x", AudioStats.AUDIO_AMPLITUDE_NONE))), vf4.a.b(Double.valueOf(r114.optDouble("y", AudioStats.AUDIO_AMPLITUDE_NONE))), 0, 0);
    L24:
        if (r112 == null) goto L26;
        r112.addView(this, r109);
    L27:
        f44339i.put(r100, this);
        return;
    L26:
        r104.addView(this, r109);
        goto L27
    L18:
        r115 = -2;
        goto L19
    L23:
        r109 = new FrameLayout.LayoutParams(-2, -2);
        r109.gravity = 83;
        r109.setMargins(vf4.a.a(r110, 0.0f), 0, 0, vf4.a.a(r110, 106.0f));
        goto L24
    L30:
        return;
    }
}
