package stepai.aios.guiexecutor.core;

import C7.f;
import J7.c;
import N9.j;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.mdisdk.capability.model.RequestInfo;
import com.mdisdk.capability.model.WindowStateInfo;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.a;
import kotlin.b;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.k;
import n5.C1741a;
import stepai.aios.accessibility.DefaultAccessibilityService;
import stepai.aios.guiagent.config.Action;
import stepai.aios.guiexecutor.api.GuiActionExecutor;
import stepai.aios.guiexecutor.api.SystemNavigationAction;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001?B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\f\u0010\u000bJ\u0017\u0010\r\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\r\u0010\u000bJ\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0082@¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0014\u0010\u0013J8\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00170\u001d2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0096@¢\u0006\u0004\b\u001e\u0010\u001fJ:\u0010%\u001a\u00020\t2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0096@¢\u0006\u0004\b%\u0010&J@\u0010*\u001a\u00020\t2\u0006\u0010'\u001a\u00020\u00172\u0014\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019\u0018\u00010(2\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0096@¢\u0006\u0004\b*\u0010+JR\u00100\u001a\u00020\t2\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00190(2\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00190(2\u0006\u0010/\u001a\u00020.2\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0096@¢\u0006\u0004\b0\u00101J*\u00104\u001a\u00020\t2\u0006\u00103\u001a\u0002022\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0096@¢\u0006\u0004\b4\u00105R\u001b\u0010;\u001a\u0002068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u001a\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00100<8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010>¨\u0006@"}, d2 = {"Lstepai/aios/guiexecutor/core/AccessibleGuiActionExecutor;", "Lstepai/aios/guiexecutor/api/GuiActionExecutor;", AppAgent.CONSTRUCT, "()V", "LC7/r;", "performActionStart", "performActionEnd", "Lstepai/aios/accessibility/DefaultAccessibilityService;", NotificationCompat.CATEGORY_SERVICE, "", "performBackNavigation", "(Lstepai/aios/accessibility/DefaultAccessibilityService;)Z", "performHomeNavigation", "performEnterNavigation", "performRecentAppsNavigation", "(Lstepai/aios/accessibility/DefaultAccessibilityService;LH7/c;)Ljava/lang/Object;", "Lstepai/aios/guiexecutor/core/AccessibleGuiActionExecutor$ActionListener;", "listener", "addListener", "(Lstepai/aios/guiexecutor/core/AccessibleGuiActionExecutor$ActionListener;)V", "removeListener", "Landroid/content/Context;", "context", "", "packageName", "", WindowStateInfo.KEY_DISPLAY_ID, "Lstepai/aios/guiagent/config/Action;", GuiTaskProgressKt.GuiTaskProgress_KEY_ACTION, "Lkotlin/Result;", "openApp-yxL6bBk", "(Landroid/content/Context;Ljava/lang/String;ILstepai/aios/guiagent/config/Action;LH7/c;)Ljava/lang/Object;", "openApp", "", "x", "y", RequestInfo.FUNCTION_LONG_CLICK, RequestInfo.FUNCTION_CLICK, "(FFZILstepai/aios/guiagent/config/Action;LH7/c;)Ljava/lang/Object;", "text", "Lkotlin/Pair;", "coordinates", "input", "(Ljava/lang/String;Lkotlin/Pair;ILstepai/aios/guiagent/config/Action;LH7/c;)Ljava/lang/Object;", "startPoint", "endPoint", "", TypedValues.TransitionType.S_DURATION, RequestInfo.FUNCTION_SWIPE, "(Lkotlin/Pair;Lkotlin/Pair;JILstepai/aios/guiagent/config/Action;LH7/c;)Ljava/lang/Object;", "Lstepai/aios/guiexecutor/api/SystemNavigationAction;", "systemNavigationAction", "systemNavigation", "(Lstepai/aios/guiexecutor/api/SystemNavigationAction;ILstepai/aios/guiagent/config/Action;LH7/c;)Ljava/lang/Object;", "Lstepai/aios/accessibility/a;", "accessibilityActionExecutor$delegate", "LC7/f;", "getAccessibilityActionExecutor", "()Lstepai/aios/accessibility/a;", "accessibilityActionExecutor", "", "listeners", "Ljava/util/List;", "ActionListener", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AccessibleGuiActionExecutor implements GuiActionExecutor {
    public static final AccessibleGuiActionExecutor INSTANCE = new AccessibleGuiActionExecutor();

    /* renamed from: accessibilityActionExecutor$delegate, reason: from kotlin metadata */
    private static final f accessibilityActionExecutor = a.b(LazyThreadSafetyMode.f4885a, new C1741a(7));
    private static final List<ActionListener> listeners = new ArrayList();

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lstepai/aios/guiexecutor/core/AccessibleGuiActionExecutor$ActionListener;", "", "LC7/r;", "onActionStart", "()V", "onActionEnd", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface ActionListener {
        void onActionEnd();

        void onActionStart();
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SystemNavigationAction.values().length];
            try {
                iArr[SystemNavigationAction.BACK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SystemNavigationAction.HOME.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SystemNavigationAction.ENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SystemNavigationAction.RECENT_APPS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @c(c = "stepai.aios.guiexecutor.core.AccessibleGuiActionExecutor", f = "AccessibleGuiActionExecutor.kt", l = {72, 262}, m = RequestInfo.FUNCTION_CLICK, v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: stepai.aios.guiexecutor.core.AccessibleGuiActionExecutor$click$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        float F$0;
        float F$1;
        int I$0;
        int I$1;
        Object L$0;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(H7.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AccessibleGuiActionExecutor.this.click(0.0f, 0.0f, false, 0, null, this);
        }
    }

    @c(c = "stepai.aios.guiexecutor.core.AccessibleGuiActionExecutor", f = "AccessibleGuiActionExecutor.kt", l = {105, AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY}, m = "input", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: stepai.aios.guiexecutor.core.AccessibleGuiActionExecutor$input$1, reason: invalid class name and case insensitive filesystem */
    public static final class C19481 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C19481(H7.c<? super C19481> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AccessibleGuiActionExecutor.this.input(null, null, 0, null, this);
        }
    }

    @c(c = "stepai.aios.guiexecutor.core.AccessibleGuiActionExecutor", f = "AccessibleGuiActionExecutor.kt", l = {128, 262}, m = RequestInfo.FUNCTION_SWIPE, v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: stepai.aios.guiexecutor.core.AccessibleGuiActionExecutor$swipe$1, reason: invalid class name and case insensitive filesystem */
    public static final class C19491 extends ContinuationImpl {
        int I$0;
        int I$1;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C19491(H7.c<? super C19491> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AccessibleGuiActionExecutor.this.swipe(null, null, 0L, 0, null, this);
        }
    }

    private AccessibleGuiActionExecutor() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final stepai.aios.accessibility.a accessibilityActionExecutor_delegate$lambda$0() {
        if (DefaultAccessibilityService.d == null) {
            j.J("BabelfishAccessibilityService getInstance: service is null", "DefaultAccessibilityService");
        }
        WeakReference weakReference = DefaultAccessibilityService.d;
        DefaultAccessibilityService defaultAccessibilityService = weakReference != null ? (DefaultAccessibilityService) weakReference.get() : null;
        if (defaultAccessibilityService != null) {
            return new stepai.aios.accessibility.a(defaultAccessibilityService);
        }
        throw new IllegalArgumentException("AccessibilityService is null!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final stepai.aios.accessibility.a getAccessibilityActionExecutor() {
        return (stepai.aios.accessibility.a) accessibilityActionExecutor.getF4884a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void performActionEnd() {
        Iterator<T> it = listeners.iterator();
        while (it.hasNext()) {
            ((ActionListener) it.next()).onActionEnd();
        }
    }

    private final void performActionStart() {
        Iterator<T> it = listeners.iterator();
        while (it.hasNext()) {
            ((ActionListener) it.next()).onActionStart();
        }
    }

    private final boolean performBackNavigation(DefaultAccessibilityService service) {
        try {
            j.F("Performing back navigation", "AccessibleGuiActionExecutor");
            boolean zPerformGlobalAction = service.performGlobalAction(1);
            if (zPerformGlobalAction) {
                j.F("Back navigation completed successfully", "AccessibleGuiActionExecutor");
                return zPerformGlobalAction;
            }
            j.J("Back navigation failed", "AccessibleGuiActionExecutor");
            return zPerformGlobalAction;
        } catch (Exception e) {
            com.stepos.statsrpk.service.c.n("Back navigation error: ", e.getMessage(), "AccessibleGuiActionExecutor");
            return false;
        }
    }

    private final boolean performEnterNavigation(DefaultAccessibilityService service) {
        try {
            j.F("Performing enter key navigation", "AccessibleGuiActionExecutor");
            boolean zPerformGlobalAction = service.performGlobalAction(20);
            if (zPerformGlobalAction) {
                j.F("Enter key navigation completed successfully", "AccessibleGuiActionExecutor");
                return zPerformGlobalAction;
            }
            j.J("Enter key navigation failed", "AccessibleGuiActionExecutor");
            return zPerformGlobalAction;
        } catch (Exception e) {
            com.stepos.statsrpk.service.c.n("Enter key navigation error: ", e.getMessage(), "AccessibleGuiActionExecutor");
            return false;
        }
    }

    private final boolean performHomeNavigation(DefaultAccessibilityService service) {
        try {
            j.F("Performing home navigation", "AccessibleGuiActionExecutor");
            boolean zPerformGlobalAction = service.performGlobalAction(2);
            if (zPerformGlobalAction) {
                j.F("Home navigation completed successfully", "AccessibleGuiActionExecutor");
                return zPerformGlobalAction;
            }
            j.J("Home navigation failed", "AccessibleGuiActionExecutor");
            return zPerformGlobalAction;
        } catch (Exception e) {
            com.stepos.statsrpk.service.c.n("Home navigation error: ", e.getMessage(), "AccessibleGuiActionExecutor");
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object performRecentAppsNavigation(DefaultAccessibilityService defaultAccessibilityService, H7.c<? super Boolean> cVar) {
        boolean zPerformGlobalAction;
        try {
            j.F("Performing recent apps navigation", "AccessibleGuiActionExecutor");
            zPerformGlobalAction = defaultAccessibilityService.performGlobalAction(3);
            if (zPerformGlobalAction) {
                j.F("Recent apps navigation completed successfully", "AccessibleGuiActionExecutor");
            } else {
                j.J("Recent apps navigation failed", "AccessibleGuiActionExecutor");
            }
        } catch (Exception e) {
            com.stepos.statsrpk.service.c.n("Recent apps navigation error: ", e.getMessage(), "AccessibleGuiActionExecutor");
            zPerformGlobalAction = false;
        }
        return Boolean.valueOf(zPerformGlobalAction);
    }

    public final void addListener(ActionListener listener) {
        k.f(listener, "listener");
        List<ActionListener> list = listeners;
        if (list.contains(listener)) {
            return;
        }
        list.add(listener);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    @Override // stepai.aios.guiexecutor.api.GuiActionExecutor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object click(float r15, float r16, boolean r17, int r18, stepai.aios.guiagent.config.Action r19, H7.c<? super java.lang.Boolean> r20) {
        /*
            Method dump skipped, instructions count: 257
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiexecutor.core.AccessibleGuiActionExecutor.click(float, float, boolean, int, stepai.aios.guiagent.config.Action, H7.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x00a3, code lost:
    
        if (r11 == r12) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    @Override // stepai.aios.guiexecutor.api.GuiActionExecutor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object input(java.lang.String r8, kotlin.Pair<java.lang.Integer, java.lang.Integer> r9, int r10, stepai.aios.guiagent.config.Action r11, H7.c<? super java.lang.Boolean> r12) {
        /*
            r7 = this;
            boolean r11 = r12 instanceof stepai.aios.guiexecutor.core.AccessibleGuiActionExecutor.C19481
            if (r11 == 0) goto L14
            r11 = r12
            stepai.aios.guiexecutor.core.AccessibleGuiActionExecutor$input$1 r11 = (stepai.aios.guiexecutor.core.AccessibleGuiActionExecutor.C19481) r11
            int r0 = r11.label
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r0 & r1
            if (r2 == 0) goto L14
            int r0 = r0 - r1
            r11.label = r0
        L12:
            r6 = r11
            goto L1a
        L14:
            stepai.aios.guiexecutor.core.AccessibleGuiActionExecutor$input$1 r11 = new stepai.aios.guiexecutor.core.AccessibleGuiActionExecutor$input$1
            r11.<init>(r12)
            goto L12
        L1a:
            java.lang.Object r11 = r6.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r12 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r0 = r6.label
            r1 = 2
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L59
            if (r0 == r2) goto L45
            if (r0 != r1) goto L3d
            java.lang.Object r8 = r6.L$3
            android.graphics.Point r8 = (android.graphics.Point) r8
            java.lang.Object r8 = r6.L$2
            stepai.aios.guiagent.config.Action r8 = (stepai.aios.guiagent.config.Action) r8
            java.lang.Object r8 = r6.L$1
            kotlin.Pair r8 = (kotlin.Pair) r8
            java.lang.Object r8 = r6.L$0
            java.lang.String r8 = (java.lang.String) r8
            kotlin.b.b(r11)
            goto La6
        L3d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L45:
            int r10 = r6.I$0
            java.lang.Object r8 = r6.L$2
            stepai.aios.guiagent.config.Action r8 = (stepai.aios.guiagent.config.Action) r8
            java.lang.Object r8 = r6.L$1
            r9 = r8
            kotlin.Pair r9 = (kotlin.Pair) r9
            java.lang.Object r8 = r6.L$0
            java.lang.String r8 = (java.lang.String) r8
            kotlin.b.b(r11)
        L57:
            r5 = r10
            goto L72
        L59:
            kotlin.b.b(r11)
            r7.performActionStart()
            r6.L$0 = r8
            r6.L$1 = r9
            r6.L$2 = r3
            r6.I$0 = r10
            r6.label = r2
            r4 = 50
            java.lang.Object r11 = kotlinx.coroutines.a.f(r4, r6)
            if (r11 != r12) goto L57
            goto La5
        L72:
            if (r9 == 0) goto L8b
            android.graphics.Point r10 = new android.graphics.Point
            java.lang.Object r11 = r9.f4886a
            java.lang.Number r11 = (java.lang.Number) r11
            int r11 = r11.intValue()
            java.lang.Object r9 = r9.b
            java.lang.Number r9 = (java.lang.Number) r9
            int r9 = r9.intValue()
            r10.<init>(r11, r9)
            r2 = r10
            goto L8c
        L8b:
            r2 = r3
        L8c:
            stepai.aios.accessibility.a r0 = r7.getAccessibilityActionExecutor()
            r6.L$0 = r3
            r6.L$1 = r3
            r6.L$2 = r3
            r6.L$3 = r3
            r6.I$0 = r5
            r6.label = r1
            r3 = 1
            r4 = 1
            r1 = r8
            java.lang.Object r11 = r0.c(r1, r2, r3, r4, r5, r6)
            if (r11 != r12) goto La6
        La5:
            return r12
        La6:
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            r11.booleanValue()
            r7.performActionEnd()
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiexecutor.core.AccessibleGuiActionExecutor.input(java.lang.String, kotlin.Pair, int, stepai.aios.guiagent.config.Action, H7.c):java.lang.Object");
    }

    @Override // stepai.aios.guiexecutor.api.GuiActionExecutor
    /* renamed from: openApp-yxL6bBk */
    public Object mo7351openAppyxL6bBk(final Context context, final String str, int i, Action action, H7.c<? super Result<String>> cVar) throws IntentSender.SendIntentException {
        Integer num = new Integer(i);
        k.f(str, "<this>");
        k.f(context, "context");
        try {
            PackageManager packageManager = context.getPackageManager();
            final ActivityOptions activityOptionsMakeBasic = ActivityOptions.makeBasic();
            activityOptionsMakeBasic.setLaunchDisplayId(num.intValue());
            Handler handler = new Handler(Looper.getMainLooper());
            IntentSender launchIntentSenderForPackage = packageManager.getLaunchIntentSenderForPackage(str);
            k.e(launchIntentSenderForPackage, "getLaunchIntentSenderForPackage(...)");
            launchIntentSenderForPackage.sendIntent(context, 0, null, new IntentSender.OnFinished() { // from class: Ia.a
                @Override // android.content.IntentSender.OnFinished
                public final void onSendFinished(IntentSender intentSender, Intent intent, int i6, String str2, Bundle bundle) {
                    if (intent == null) {
                        j.G("Launch intent is null: ".concat(str), "AppExt");
                        return;
                    }
                    intent.addFlags(268435456);
                    intent.addFlags(32768);
                    ActivityOptions activityOptions = activityOptionsMakeBasic;
                    Context context2 = context;
                    if (activityOptions != null) {
                        context2.startActivity(intent, activityOptions.toBundle());
                    } else {
                        context2.startActivity(intent);
                    }
                }
            }, handler);
            return str;
        } catch (Exception e) {
            j.G("App launch exception: " + str + ", " + e.getMessage(), "AppExt");
            return b.a(new Exception("Failed to open app: ".concat(str)));
        }
    }

    public final void removeListener(ActionListener listener) {
        k.f(listener, "listener");
        List<ActionListener> list = listeners;
        if (list.contains(listener)) {
            list.remove(listener);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x00f6, code lost:
    
        if (r0 == r2) goto L22;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    @Override // stepai.aios.guiexecutor.api.GuiActionExecutor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object swipe(kotlin.Pair<java.lang.Integer, java.lang.Integer> r13, kotlin.Pair<java.lang.Integer, java.lang.Integer> r14, long r15, int r17, stepai.aios.guiagent.config.Action r18, H7.c<? super java.lang.Boolean> r19) {
        /*
            Method dump skipped, instructions count: 258
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiexecutor.core.AccessibleGuiActionExecutor.swipe(kotlin.Pair, kotlin.Pair, long, int, stepai.aios.guiagent.config.Action, H7.c):java.lang.Object");
    }

    @Override // stepai.aios.guiexecutor.api.GuiActionExecutor
    public Object systemNavigation(SystemNavigationAction systemNavigationAction, int i, Action action, H7.c<? super Boolean> cVar) {
        boolean zPerformBackNavigation;
        DefaultAccessibilityService defaultAccessibilityService = getAccessibilityActionExecutor().f6017a;
        int i6 = WhenMappings.$EnumSwitchMapping$0[systemNavigationAction.ordinal()];
        if (i6 == 1) {
            zPerformBackNavigation = performBackNavigation(defaultAccessibilityService);
        } else if (i6 == 2) {
            zPerformBackNavigation = performHomeNavigation(defaultAccessibilityService);
        } else {
            if (i6 != 3) {
                if (i6 == 4) {
                    return performRecentAppsNavigation(defaultAccessibilityService, cVar);
                }
                throw new NoWhenBranchMatchedException();
            }
            zPerformBackNavigation = performEnterNavigation(defaultAccessibilityService);
        }
        return Boolean.valueOf(zPerformBackNavigation);
    }
}
