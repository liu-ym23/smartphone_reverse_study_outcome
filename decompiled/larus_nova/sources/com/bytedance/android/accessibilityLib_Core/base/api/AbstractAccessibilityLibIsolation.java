package com.bytedance.android.accessibilityLib_Core.base.api;

import android.R;
import android.app.Application;
import android.content.Context;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import com.android.ttcjpaysdk.base.h5.cjjsb.constant.ErrorCode;
import com.bytedance.android.accessibilityLib_Core.engine.AccessibilityConfigEngine;
import com.bytedance.android.accessibilityLib_Core.engine.b;
import com.bytedance.android.accessibilityLib_Core.helper.AppWindows;
import com.bytedance.android.accessibilityLib_Core.helper.ApplifecycleManager;
import com.bytedance.android.accessibilityLib_Core.helper.WindowHelper;
import com.bytedance.android.accessibilityLib_Core.processor.TraverseFromType;
import com.bytedance.android.accessibilityLib_Core.processor.ViewTraverseProcessor;
import com.bytedance.android.accessibilityLib_Core.processor.e;
import com.bytedance.android.accessibilityLib_Core.report.AccessibilityLibReport;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractAccessibilityLibIsolation {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AccessibilityLibState f38116b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f38117c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f38118d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f38119e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f38120f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f38121g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f38122h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f38123i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f38124j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f38125k;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/accessibilityLib_Core/base/api/AbstractAccessibilityLibIsolation$AccessibilityLibState;", "", "UNINIT", ErrorCode.INIT, "START_ACCESSIBILITY_ENGINE", "START_VISIT_ROOT_VIEW", "accessibilityLib_Core_release"}, k = 1, mv = {1, 4, 1})
    public static final enum AccessibilityLibState extends Enum<AccessibilityLibState> {
        public static final AccessibilityLibState INIT = null;
        public static final AccessibilityLibState START_ACCESSIBILITY_ENGINE = null;
        public static final AccessibilityLibState START_VISIT_ROOT_VIEW = null;
        public static final AccessibilityLibState UNINIT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ AccessibilityLibState[] f38126a = null;

        static {
            AccessibilityLibState r100 = new AccessibilityLibState("UNINIT", 0);
            UNINIT = r100;
            AccessibilityLibState r101 = new AccessibilityLibState(ErrorCode.INIT, 1);
            INIT = r101;
            AccessibilityLibState r102 = new AccessibilityLibState("START_ACCESSIBILITY_ENGINE", 2);
            START_ACCESSIBILITY_ENGINE = r102;
            AccessibilityLibState r103 = new AccessibilityLibState("START_VISIT_ROOT_VIEW", 3);
            START_VISIT_ROOT_VIEW = r103;
            f38126a = new AccessibilityLibState[]{r100, r101, r102, r103};
        }

        public static AccessibilityLibState valueOf(String r100) {
            return (AccessibilityLibState) r27.a.a(AccessibilityLibState.class, r100);
        }

        public static AccessibilityLibState[] values() {
            return (AccessibilityLibState[]) f38126a.clone();
        }

        public AccessibilityLibState(String r100, int r101) {
            super(r100, r101);
        }
    }

    /* JADX INFO: loaded from: classes43.dex */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/accessibilityLib_Core/base/api/AbstractAccessibilityLibIsolation$ReStartAccessibilityEngineCondition;", "", "APP_FOREGROUND_FROM_BACKGROUND", "PRIVACY_POLICY_AGREE", "ACCESSIBILITY_STATE_CHANGE", "accessibilityLib_Core_release"}, k = 1, mv = {1, 4, 1})
    public static final enum ReStartAccessibilityEngineCondition extends Enum<ReStartAccessibilityEngineCondition> {
        public static final ReStartAccessibilityEngineCondition ACCESSIBILITY_STATE_CHANGE = null;
        public static final ReStartAccessibilityEngineCondition APP_FOREGROUND_FROM_BACKGROUND = null;
        public static final ReStartAccessibilityEngineCondition PRIVACY_POLICY_AGREE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ReStartAccessibilityEngineCondition[] f38127a = null;

        static {
            ReStartAccessibilityEngineCondition r100 = new ReStartAccessibilityEngineCondition("APP_FOREGROUND_FROM_BACKGROUND", 0);
            APP_FOREGROUND_FROM_BACKGROUND = r100;
            ReStartAccessibilityEngineCondition r101 = new ReStartAccessibilityEngineCondition("PRIVACY_POLICY_AGREE", 1);
            PRIVACY_POLICY_AGREE = r101;
            ReStartAccessibilityEngineCondition r102 = new ReStartAccessibilityEngineCondition("ACCESSIBILITY_STATE_CHANGE", 2);
            ACCESSIBILITY_STATE_CHANGE = r102;
            f38127a = new ReStartAccessibilityEngineCondition[]{r100, r101, r102};
        }

        public static ReStartAccessibilityEngineCondition valueOf(String r100) {
            return (ReStartAccessibilityEngineCondition) r27.a.a(ReStartAccessibilityEngineCondition.class, r100);
        }

        public static ReStartAccessibilityEngineCondition[] values() {
            return (ReStartAccessibilityEngineCondition[]) f38127a.clone();
        }

        public ReStartAccessibilityEngineCondition(String r100, int r101) {
            super(r100, r101);
        }
    }

    public void g() {
    }

    public boolean j() {
        return false;
    }

    public final boolean f() {
        if (this.f38117c == true) goto L5;
    L7:
        return false;
    L5:
        if (j() == false) goto L7;
        return true;
    }

    public final void l() {
        if (this.f38116b == AccessibilityLibState.INIT) goto L5;
        return;
    L5:
        Context r100 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
        if (f() == true) goto L8;
        return;
    L8:
        long r101 = System.currentTimeMillis();
        ViewTraverseProcessor.f38301c = true;
        int r102 = AccessibilityLibReport.f38309a;
    L17:
        e = move-exception;
        if (("Try exception occur " + e.getMessage()) == null) goto L21;
        Context r103 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
    L21:
        Unit r104 = Unit.INSTANCE;
    L22:
        b.f38249a = false;
        Context r105 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
        b.f38250b = true;
        g();
        b.f38251c = false;
        AccessibilityConfigEngine.e();
        ApplifecycleManager r106 = (ApplifecycleManager) this.f38118d.getValue();
        AbstractAccessibilityLibIsolation$appWindowEventListener$2.a r107 = (AbstractAccessibilityLibIsolation$appWindowEventListener$2.a) this.f38124j.getValue();
        r106.getClass();
        WindowHelper r108 = r106.a();     // Catch: Exception -> L25
        r108.getClass();     // Catch: Exception -> L25
        ((AppWindows) r108.f38275b.getValue()).f(true);     // Catch: Exception -> L25
        ((AppWindows) r108.f38275b.getValue()).f38260f.add(r108);     // Catch: Exception -> L25
        com.bytedance.android.accessibilityLib_Core.helper.b r109 = (com.bytedance.android.accessibilityLib_Core.helper.b) r106.f38273a.getValue();     // Catch: Exception -> L25
        ((ArrayList) r109.f38279a).add(r106.a());     // Catch: Exception -> L25
        ((ArrayList) r106.a().f38276c).add(new WeakReference(r107));     // Catch: Exception -> L25
    L30:
        Context r110 = com.bytedance.android.accessibilityLib_Core.helper.a.a();
        if ((r110 instanceof Application) == false) goto L33;
        Application r111 = (Application) r110;
        r111.unregisterActivityLifecycleCallbacks((AbstractAccessibilityLibIsolation$activityAndFragmentLifecycleCallback$2.a) this.f38125k.getValue());
        r111.registerActivityLifecycleCallbacks((AbstractAccessibilityLibIsolation$activityAndFragmentLifecycleCallback$2.a) this.f38125k.getValue());
    L33:
        this.f38116b = AccessibilityLibState.START_ACCESSIBILITY_ENGINE;
        new StringBuilder("startAccessibilityEngine = ").append(System.currentTimeMillis() - r101);
        return;
    L25:
        e = move-exception;
        if (("Try exception occur " + e.getMessage()) == null) goto L29;
        Context r112 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
    L29:
        Unit r113 = Unit.INSTANCE;
        goto L30
    L10:
        if (Intrinsics.areEqual("accessibilityLib_Open", "accessibilityLib_configNum") == false) goto L12;
    L15:
        Unit r114 = Unit.INSTANCE;     // Catch: Exception -> L17
        goto L22
    L12:
        if (Intrinsics.areEqual("accessibilityLib_Open", "accessibilityLib_config_download_success") == true) goto L15;
        Intrinsics.areEqual("accessibilityLib_Open", "accessibilityLib_config_success");     // Catch: Exception -> L17
        goto L15
    }

    public AbstractAccessibilityLibIsolation() {
        this.f38116b = AccessibilityLibState.UNINIT;
        this.f38118d = LazyKt.lazy(AbstractAccessibilityLibIsolation$applifecycleManager$2.INSTANCE);
        this.f38120f = LazyKt.lazy(AbstractAccessibilityLibIsolation$currentCoroutineScope$2.INSTANCE);
        this.f38121g = LazyKt.lazy(new AbstractAccessibilityLibIsolation$processLifecycleEventObserver$2(this));
        this.f38122h = LazyKt.lazy(new AbstractAccessibilityLibIsolation$accessibilityStateChangeListener$2(this));
        this.f38123i = LazyKt.lazy(new AbstractAccessibilityLibIsolation$accessibilityTouchExplorationStateChangeListener$2(this));
        this.f38124j = LazyKt.lazy(new AbstractAccessibilityLibIsolation$appWindowEventListener$2(this));
        this.f38125k = LazyKt.lazy(new AbstractAccessibilityLibIsolation$activityAndFragmentLifecycleCallback$2(this));
    }

    public static View h(View r100) {
        long r101 = System.currentTimeMillis();
        View r102 = r100.findViewById(R.id.content);     // Catch: Exception -> L6
        if (r102 == null) goto L11;
        r100 = r102;
    L11:
        if (("find app framelayout cost time = " + (System.currentTimeMillis() - r101)) == null) goto L13;
        Context r103 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
    L13:
        return r100;
    L6:
        e = move-exception;
        if (("Try exception occur " + e.getMessage()) == null) goto L11;
        Context r104 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
        goto L11
    }

    public void i(Context r100) {
        if (this.f38116b == AccessibilityLibState.UNINIT) goto L6;
        return;
    L6:
        if (("AccessibilityLibCoreIsolation init, accessibilityExp enable = " + j()) == null) goto L8;
        Context r101 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
    L8:
        com.bytedance.android.accessibilityLib_Core.helper.a.f38277a = r100;
        com.bytedance.android.accessibilityLib_Core.helper.a.f38278b = 4;
        this.f38116b = AccessibilityLibState.INIT;
        long r102 = System.currentTimeMillis();
        this.f38117c = com.bytedance.android.accessibilityLib_Core.tool.b.a(r100);
        new StringBuilder("In init func, the accessibilityEnable flag = ").append(this.f38117c);
        long r103 = System.currentTimeMillis() - r102;
        StringBuilder r104 = new StringBuilder("init accessibility switch costtime=(");
        r104.append(r103);
        r104.append(")ms");
        BuildersKt.async$default((CoroutineScope) this.f38120f.getValue(), null, null, new AbstractAccessibilityLibIsolation$registerAppLifecycleEvent$1(this, null), 3, null);     // Catch: Exception -> L11
        com.bytedance.android.accessibilityLib_Core.tool.b.c(r100, (AccessibilityManager.AccessibilityStateChangeListener) this.f38122h.getValue(), (AccessibilityManager.TouchExplorationStateChangeListener) this.f38123i.getValue());     // Catch: Exception -> L11
        Unit r105 = Unit.INSTANCE;     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        if (("Try exception occur " + e.getMessage()) == null) goto L15;
        Context r106 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
    L15:
        Unit r107 = Unit.INSTANCE;
    }

    public final void k(ReStartAccessibilityEngineCondition r100) {
        BuildersKt.launch$default((CoroutineScope) this.f38120f.getValue(), null, null, new AbstractAccessibilityLibIsolation$reStartEngineAfterSpecialCondition$$inlined$Try$lambda$1(null, this, r100), 3, null);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        if (("Try exception occur " + e.getMessage()) == null) goto L8;
        Context r101 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
    L8:
        Unit r102 = Unit.INSTANCE;
    }

    public static final void c(AbstractAccessibilityLibIsolation r100, boolean r101) {
        if (r101 == false) goto L4;
        r100.getClass();
        r100.k(ReStartAccessibilityEngineCondition.ACCESSIBILITY_STATE_CHANGE);
        return;
    L4:
        boolean r102 = r100.f();
        r100.f38117c = false;
        if (r102 == true) goto L7;
        return;
    L7:
        if (("AccessibilityLibCoreIsolation stopAccessibilityEngine, status = " + r100.f38116b.name()) == null) goto L10;
        Context r103 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
    L10:
        if (r100.f38116b != AccessibilityLibState.START_ACCESSIBILITY_ENGINE) goto L29;
        long r104 = System.currentTimeMillis();
        r100.f38117c = false;
        ViewTraverseProcessor.f38301c = false;
        ApplifecycleManager r105 = (ApplifecycleManager) r100.f38118d.getValue();
        AbstractAccessibilityLibIsolation$appWindowEventListener$2.a r106 = (AbstractAccessibilityLibIsolation$appWindowEventListener$2.a) r100.f38124j.getValue();
        r105.getClass();
        Context r107 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
        WindowHelper r108 = r105.a();     // Catch: Exception -> L15
        r108.getClass();     // Catch: Exception -> L15
        ((AppWindows) r108.f38275b.getValue()).f(false);     // Catch: Exception -> L15
        ((AppWindows) r108.f38275b.getValue()).f38260f.remove(r108);     // Catch: Exception -> L15
        com.bytedance.android.accessibilityLib_Core.helper.b r109 = (com.bytedance.android.accessibilityLib_Core.helper.b) r105.f38273a.getValue();     // Catch: Exception -> L15
        ((ArrayList) r109.f38279a).remove(r105.a());     // Catch: Exception -> L15
        r105.a().d(r106);     // Catch: Exception -> L15
        Unit r110 = Unit.INSTANCE;     // Catch: Exception -> L15
    L20:
        Context r111 = com.bytedance.android.accessibilityLib_Core.helper.a.a();
        if ((r111 instanceof Application) == false) goto L23;
        ((Application) r111).unregisterActivityLifecycleCallbacks((AbstractAccessibilityLibIsolation$activityAndFragmentLifecycleCallback$2.a) r100.f38125k.getValue());
    L23:
        r100.f38116b = AccessibilityLibState.INIT;
        new StringBuilder("stopAccessibilityEngine = ").append(System.currentTimeMillis() - r104);
        return;
    L15:
        e = move-exception;
        if (("Try exception occur " + e.getMessage()) == null) goto L19;
        Context r112 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
    L19:
        Unit r113 = Unit.INSTANCE;
        goto L20
    }

    public static final void e(AbstractAccessibilityLibIsolation r100, View r101) {
        r100.getClass();
    L8:
        e = move-exception;
        if (("Try exception occur " + e.getMessage()) == null) goto L12;
        Context r102 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
    L12:
        Unit r103 = Unit.INSTANCE;
        return;
    L4:
        if (("outAccessibilityLibFromActivity>>> rootView = " + r101) == null) goto L6;
        Context r104 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;     // Catch: Exception -> L8
    L6:
        Lazy r105 = ViewTraverseProcessor.f38299a;     // Catch: Exception -> L8
        ViewTraverseProcessor.a(r101);     // Catch: Exception -> L8
        Unit r106 = Unit.INSTANCE;     // Catch: Exception -> L8
    }

    public static final void d(AbstractAccessibilityLibIsolation r100, View r101, TraverseFromType r102) {
        r100.getClass();
        View r103 = h(r101);     // Catch: Exception -> L11
        if (("enterAccessibilityLibFromActivity, start traverse >>> " + r103 + ", traverseType = " + r102) == null) goto L7;
        Context r104 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;     // Catch: Exception -> L11
    L7:
        if (e.a(r102) == false) goto L9;
        r103.addOnAttachStateChangeListener(new a(r100, r101, r102));     // Catch: Exception -> L11
    L9:
        Unit r105 = Unit.INSTANCE;     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        if (("Try exception occur " + e.getMessage()) == null) goto L15;
        Context r106 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
    L15:
        Unit r107 = Unit.INSTANCE;
    }
}
