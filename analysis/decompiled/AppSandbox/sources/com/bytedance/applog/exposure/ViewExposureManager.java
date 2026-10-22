package com.bytedance.applog.exposure;

import android.app.Activity;
import android.app.Application;
import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.applog.InitConfig;
import com.bytedance.applog.exposure.scroll.ScrollObserveConfig;
import com.bytedance.bdtracker.d;
import com.bytedance.bdtracker.d1;
import com.bytedance.bdtracker.g4;
import com.bytedance.bdtracker.o0;
import com.bytedance.bdtracker.q0;
import com.bytedance.bdtracker.r;
import com.bytedance.bdtracker.r0;
import com.bytedance.bdtracker.s0;
import com.bytedance.bdtracker.t0;
import com.bytedance.bdtracker.u0;
import com.bytedance.bdtracker.u5;
import com.bytedance.bdtracker.v0;
import com.bytedance.bdtracker.x0;
import com.stepos.pps.reflect.ExceptionManagerStepOS;
import java.util.ArrayList;
import java.util.Collection;
import java.util.WeakHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 22\u00020\u0001:\u00012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0015\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0007H\u0000¢\u0006\u0002\b\u001eJ\u000e\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\bJ\b\u0010!\u001a\u0004\u0018\u00010\u0007J\u000e\u0010\"\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\bJ\u001e\u0010\"\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\b2\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010$J\u001e\u0010%\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020&2\u000e\b\u0002\u0010#\u001a\b\u0012\u0004\u0012\u00020'0$J\u001e\u0010%\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020(2\u000e\b\u0002\u0010#\u001a\b\u0012\u0004\u0012\u00020'0$J\u0018\u0010)\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\b2\u0006\u0010*\u001a\u00020\tH\u0002J\b\u0010+\u001a\u00020\u001cH\u0002J\u0018\u0010,\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\b2\u0006\u0010*\u001a\u00020\tH\u0002J\u0010\u0010-\u001a\u00020\u001c2\b\u0010.\u001a\u0004\u0018\u00010/J\u000e\u00100\u001a\u00020\u001c2\u0006\u00101\u001a\u00020\u000bR&\u0010\u0005\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/bytedance/applog/exposure/ViewExposureManager;", "", "appLog", "Lcom/bytedance/applog/AppLogInstance;", "(Lcom/bytedance/applog/AppLogInstance;)V", "activitiesMap", "Ljava/util/WeakHashMap;", "Landroid/app/Activity;", "Landroid/view/View;", "Lcom/bytedance/applog/exposure/ViewExposureHolder;", "globalConfig", "Lcom/bytedance/applog/exposure/ViewExposureConfig;", "scrollExposureHelper", "Lcom/bytedance/applog/exposure/scroll/ScrollExposureHelper;", "getScrollExposureHelper", "()Lcom/bytedance/applog/exposure/scroll/ScrollExposureHelper;", "scrollExposureHelper$delegate", "Lkotlin/Lazy;", "started", "", "task", "Lcom/bytedance/applog/exposure/task/ViewExposureTask;", "getTask", "()Lcom/bytedance/applog/exposure/task/ViewExposureTask;", "task$delegate", "viewTreeChangeObserver", "Lcom/bytedance/applog/exposure/ViewTreeChangeObserver;", "checkViewExposureFromActivity", "", "activity", "checkViewExposureFromActivity$agent_pickerChinaRelease", "disposeViewExposure", "view", "getCurrActivity", "observeViewExposure", ExceptionManagerStepOS.USER_CONFIG_BUNDLE_DATA, "Lcom/bytedance/applog/exposure/ViewExposureData;", "observeViewScroll", "Landroidx/recyclerview/widget/RecyclerView;", "Lcom/bytedance/applog/exposure/scroll/ScrollObserveConfig;", "Landroidx/viewpager/widget/ViewPager;", "sendViewExposureEvent", "holder", "start", "triggeredExposure", "updateExposureCheckStrategy", "exposureCheckType", "Lcom/bytedance/applog/exposure/ExposureCheckType;", "updateViewExposureConfig", "viewExposureConfig", "Companion", "agent_pickerChinaRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes.dex */
public final class ViewExposureManager {
    public final WeakHashMap<Activity, WeakHashMap<View, q0>> a;
    public boolean b;
    public v0 c;
    public ViewExposureConfig d;
    public final Lazy e;
    public final Lazy f;
    public final d g;
    public static final /* synthetic */ KProperty[] h = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(ViewExposureManager.class), "task", "getTask()Lcom/bytedance/applog/exposure/task/ViewExposureTask;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(ViewExposureManager.class), "scrollExposureHelper", "getScrollExposureHelper()Lcom/bytedance/applog/exposure/scroll/ScrollExposureHelper;"))};
    public static final ViewExposureConfig i = new ViewExposureConfig(Float.valueOf(1.0f), null, 0, null, 14, null);

    public static final class b extends Lambda implements Function0<x0> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public x0 invoke() {
            return new x0(ViewExposureManager.this.g);
        }
    }

    public static final class c extends Lambda implements Function0<d1> {
        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public d1 invoke() {
            return new d1(ViewExposureManager.this);
        }
    }

    public ViewExposureManager(d appLog) {
        Intrinsics.checkParameterIsNotNull(appLog, "appLog");
        this.g = appLog;
        this.a = new WeakHashMap<>();
        Application application = appLog.n;
        if (application == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.app.Application");
        }
        this.c = new v0(application);
        this.d = i;
        this.e = LazyKt.lazy(new c());
        this.f = LazyKt.lazy(new b());
        InitConfig initConfig = appLog.getInitConfig();
        if (initConfig == null || !initConfig.isExposureEnabled()) {
            appLog.D.warn("[ViewExposure] init failed isExposureEnabled false.", new Object[0]);
        } else {
            if (this.b) {
                return;
            }
            this.c.a(new s0(this));
            this.c.a(new t0(this));
            this.b = true;
        }
    }

    public static final /* synthetic */ d1 access$getTask$p(ViewExposureManager viewExposureManager) {
        Lazy lazy = viewExposureManager.e;
        KProperty kProperty = h[0];
        return (d1) lazy.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void observeViewScroll$default(ViewExposureManager viewExposureManager, RecyclerView recyclerView, ViewExposureData viewExposureData, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            viewExposureData = viewExposureManager.a().b;
        }
        viewExposureManager.observeViewScroll(recyclerView, (ViewExposureData<ScrollObserveConfig>) viewExposureData);
    }

    public final x0 a() {
        Lazy lazy = this.f;
        KProperty kProperty = h[1];
        return (x0) lazy.getValue();
    }

    public final void a(View view, q0 q0Var) {
        Function1<ViewExposureParam, Boolean> exposureCallback;
        d dVar = this.g;
        try {
            ViewExposureData<ViewExposureConfig> viewExposureData = q0Var.a;
            String eventName = viewExposureData.getEventName();
            if (eventName == null) {
                eventName = "$bav2b_exposure";
            }
            g4 g4VarA = r.a(view, true);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("page_key", g4VarA.v);
                jSONObject.put("page_title", g4VarA.w);
                jSONObject.put("element_path", g4VarA.x);
                jSONObject.put("element_width", g4VarA.C);
                jSONObject.put("element_height", g4VarA.D);
                jSONObject.put("element_id", g4VarA.y);
                jSONObject.put("element_type", g4VarA.z);
                ArrayList<String> arrayList = g4VarA.B;
                if (arrayList != null && !arrayList.isEmpty()) {
                    jSONObject.put("positions", new JSONArray((Collection) g4VarA.B));
                }
                ArrayList<String> arrayList2 = g4VarA.A;
                if (arrayList2 != null && !arrayList2.isEmpty()) {
                    jSONObject.put("texts", new JSONArray((Collection) g4VarA.A));
                }
                jSONObject.put("$exposure_type", q0Var.c.a);
                JSONObject properties = viewExposureData.getProperties();
                if (properties != null) {
                    r.c(properties, jSONObject);
                }
            } catch (Exception e) {
                this.g.D.error(7, "[ViewExposure] JSON handle failed", e, new Object[0]);
            }
            ViewExposureConfig viewExposureConfig = (ViewExposureConfig) viewExposureData.getConfig();
            if (viewExposureConfig == null || (exposureCallback = viewExposureConfig.getExposureCallback()) == null) {
                exposureCallback = this.d.getExposureCallback();
            }
            if (exposureCallback.invoke(new ViewExposureParam(jSONObject)).booleanValue()) {
                this.g.onEventV3(eventName, jSONObject, 0);
                return;
            }
            this.g.D.warn("[ViewExposure] filter sendViewExposureEvent event " + eventName + ", " + jSONObject, new Object[0]);
        } catch (Throwable th) {
            dVar.D.error(7, "Run task failed", th, new Object[0]);
        }
    }

    public final void b(View view, q0 q0Var) {
        u0 u0Var;
        int i2 = r0.a[q0Var.c.ordinal()];
        if (i2 == 1) {
            u0Var = u0.EXPOSURE_ONCE;
        } else {
            if (i2 != 2) {
                if (i2 == 3 || i2 == 4) {
                    a(view, q0Var);
                    q0Var.a(u0.EXPOSURE_MORE_THAN_ONCE);
                } else {
                    a(view, q0Var);
                }
                q0Var.b = true;
                q0Var.d = 0L;
            }
            u0Var = u0.EXPOSURE_MORE_THAN_ONCE;
        }
        q0Var.a(u0Var);
        a(view, q0Var);
        q0Var.b = true;
        q0Var.d = 0L;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x008b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void checkViewExposureFromActivity$agent_pickerChinaRelease(android.app.Activity r17) {
        /*
            Method dump skipped, instructions count: 305
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.applog.exposure.ViewExposureManager.checkViewExposureFromActivity$agent_pickerChinaRelease(android.app.Activity):void");
    }

    public final void disposeViewExposure(View view) {
        Activity activityA;
        q0 q0VarRemove;
        Intrinsics.checkParameterIsNotNull(view, "view");
        d dVar = this.g;
        if (view == null) {
            activityA = null;
        } else {
            try {
                activityA = r.a(view.getContext());
            } catch (Throwable th) {
                dVar.D.error(7, "Run task failed", th, new Object[0]);
                return;
            }
        }
        if (activityA != null) {
            Intrinsics.checkExpressionValueIsNotNull(activityA, "ActivityUtil.findActivit…view) ?: return@runSafely");
            WeakHashMap<View, q0> weakHashMap = this.a.get(activityA);
            if (weakHashMap == null || (q0VarRemove = weakHashMap.remove(view)) == null) {
                return;
            }
            Intrinsics.checkExpressionValueIsNotNull(q0VarRemove, "activitiesMap[activity]?…view) ?: return@runSafely");
            ViewExposureConfig viewExposureConfig = (ViewExposureConfig) q0VarRemove.a.getConfig();
            if (Intrinsics.areEqual((Object) (viewExposureConfig != null ? viewExposureConfig.getVisualDiagnosis() : null), (Object) true)) {
                r.a(view);
            }
        }
    }

    public final Activity getCurrActivity() {
        return this.c.a.get();
    }

    public final void observeViewExposure(View view) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        observeViewExposure(view, null);
    }

    public final void observeViewExposure(View view, ViewExposureData<ViewExposureConfig> data) {
        Float areaRatio;
        Boolean visualDiagnosis;
        Function1<ViewExposureParam, Boolean> exposureCallback;
        Intrinsics.checkParameterIsNotNull(view, "view");
        d dVar = this.g;
        try {
            InitConfig initConfig = dVar.getInitConfig();
            if (initConfig != null && initConfig.isExposureEnabled()) {
                Activity activityA = view == null ? null : r.a(view.getContext());
                if (activityA == null) {
                    this.g.D.warn(7, "[ViewExposure] observe failed: The view context is not Activity.", new Object[0]);
                    return;
                }
                if (u5.b(view)) {
                    this.g.D.warn(7, "[ViewExposure] observe failed: The view is ignored.", new Object[0]);
                    return;
                }
                WeakHashMap<View, q0> weakHashMap = this.a.get(activityA);
                if (weakHashMap == null) {
                    weakHashMap = new WeakHashMap<>();
                    this.a.put(activityA, weakHashMap);
                }
                ViewExposureConfig copyWith = this.d;
                ViewExposureConfig viewExposureConfig = data != null ? (ViewExposureConfig) data.getConfig() : null;
                Intrinsics.checkParameterIsNotNull(copyWith, "$this$copyWith");
                if (viewExposureConfig == null || (areaRatio = viewExposureConfig.getAreaRatio()) == null) {
                    areaRatio = copyWith.getAreaRatio();
                }
                Float f = areaRatio;
                if (viewExposureConfig == null || (visualDiagnosis = viewExposureConfig.getVisualDiagnosis()) == null) {
                    visualDiagnosis = copyWith.getVisualDiagnosis();
                }
                Boolean bool = visualDiagnosis;
                long stayTriggerTime = viewExposureConfig != null ? viewExposureConfig.getStayTriggerTime() : copyWith.getStayTriggerTime();
                if (viewExposureConfig == null || (exposureCallback = viewExposureConfig.getExposureCallback()) == null) {
                    exposureCallback = copyWith.getExposureCallback();
                }
                ViewExposureConfig viewExposureConfig2 = new ViewExposureConfig(f, bool, stayTriggerTime, exposureCallback);
                weakHashMap.put(view, new q0(new ViewExposureData(data != null ? data.getEventName() : null, data != null ? data.getProperties() : null, viewExposureConfig2), false, null, 0L, 14));
                if (Intrinsics.areEqual((Object) viewExposureConfig2.getVisualDiagnosis(), (Object) true)) {
                    Intrinsics.checkParameterIsNotNull(view, "$this$enableViewExposureDebugMode");
                    if (view instanceof ImageView) {
                        ImageView imageView = (ImageView) view;
                        imageView.setImageDrawable(new o0(imageView.getDrawable()));
                    }
                    view.setBackground(new o0(view.getBackground()));
                }
                checkViewExposureFromActivity$agent_pickerChinaRelease(activityA);
                this.c.a(view);
                this.g.D.debug(7, "[ViewExposure] observe successful, data=" + data + ", view=" + view, new Object[0]);
                return;
            }
            this.g.D.warn(7, "[ViewExposure] observe failed: InitConfig.exposureEnabled is not true.", new Object[0]);
        } catch (Throwable th) {
            dVar.D.error(7, "Run task failed", th, new Object[0]);
        }
    }

    public final void observeViewScroll(RecyclerView view, ViewExposureData<ScrollObserveConfig> data) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        Intrinsics.checkParameterIsNotNull(data, "data");
        a().a(view, data);
    }

    public final void observeViewScroll(ViewPager view, ViewExposureData<ScrollObserveConfig> data) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        Intrinsics.checkParameterIsNotNull(data, "data");
        a().a(view, data);
    }

    public final void updateExposureCheckStrategy(ExposureCheckType exposureCheckType) {
        Lazy lazy = this.e;
        KProperty kProperty = h[0];
        ((d1) lazy.getValue()).a(exposureCheckType);
    }

    public final void updateViewExposureConfig(ViewExposureConfig viewExposureConfig) {
        Intrinsics.checkParameterIsNotNull(viewExposureConfig, "viewExposureConfig");
        this.d = viewExposureConfig;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void observeViewScroll$default(ViewExposureManager viewExposureManager, ViewPager viewPager, ViewExposureData viewExposureData, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            viewExposureData = viewExposureManager.a().b;
        }
        viewExposureManager.observeViewScroll(viewPager, (ViewExposureData<ScrollObserveConfig>) viewExposureData);
    }
}
