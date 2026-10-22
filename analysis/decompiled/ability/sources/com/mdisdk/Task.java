package com.mdisdk;

import H7.c;
import android.view.Display;
import android.view.MotionEvent;
import android.view.Surface;
import androidx.autofill.HintConstants;
import androidx.core.app.NotificationCompat;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.mdisdk.action.Action;
import com.mdisdk.action.ActionResult;
import com.mdisdk.capability.model.IntentEntity;
import com.mdisdk.capability.model.WindowStateInfo;
import com.mdisdk.mirror.ScaleMode;
import com.mdisdk.mirror.TaskMirrorView;
import com.mdisdk.observer.AppDiedFilter;
import com.mdisdk.observer.DisplayObserver;
import com.mdisdk.observer.ForegroundAppFilter;
import com.mdisdk.observer.ForegroundAppInfo;
import com.mdisdk.observer.VisibleWindowFilter;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b&\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\n\u0010\u000bJ\u0011\u0010\r\u001a\u0004\u0018\u00010\fH&¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\fH&¢\u0006\u0004\b\u0011\u0010\u0012J \u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u00152\n\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u0013H¦@¢\u0006\u0004\b\u0016\u0010\u0017J.\u0010\u0016\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00150\u001b2\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00100\u0018H¦@¢\u0006\u0004\b\u0016\u0010\u001cJ\u0019\u0010\u001f\u001a\u00020\u00102\b\b\u0002\u0010\u001e\u001a\u00020\u001dH&¢\u0006\u0004\b\u001f\u0010 J\u0019\u0010\"\u001a\u00020\u00102\b\b\u0002\u0010\u001e\u001a\u00020\u001dH ¢\u0006\u0004\b!\u0010 J\u000f\u0010#\u001a\u00020\u001dH&¢\u0006\u0004\b#\u0010$J\u0017\u0010'\u001a\u00020\u00102\u0006\u0010&\u001a\u00020%H&¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\u0010H&¢\u0006\u0004\b)\u0010*J1\u00101\u001a\u00020\u001d2\u0006\u0010,\u001a\u00020+2\u0006\u0010-\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u00062\b\b\u0002\u00100\u001a\u00020/H&¢\u0006\u0004\b1\u00102J\u0011\u00103\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b3\u00104J\u001d\u00106\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b6\u00107J\u001d\u00109\u001a\u0004\u0018\u0001082\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b9\u0010:J!\u0010?\u001a\u00020\u00022\b\b\u0002\u0010<\u001a\u00020;2\u0006\u0010>\u001a\u00020=H&¢\u0006\u0004\b?\u0010@J)\u0010?\u001a\u00020\u00022\u0012\u0010B\u001a\u000e\u0012\u0004\u0012\u00020A\u0012\u0004\u0012\u00020\u00100\u00182\u0006\u0010>\u001a\u00020=¢\u0006\u0004\b?\u0010CJ\u0017\u0010E\u001a\u00020\u00102\u0006\u0010D\u001a\u00020\u0002H&¢\u0006\u0004\bE\u0010\u0005J!\u0010H\u001a\u00020\u00022\b\b\u0002\u0010<\u001a\u00020F2\u0006\u0010>\u001a\u00020GH&¢\u0006\u0004\bH\u0010IJ)\u0010H\u001a\u00020\u00022\u0012\u0010B\u001a\u000e\u0012\u0004\u0012\u00020J\u0012\u0004\u0012\u00020\u00100\u00182\u0006\u0010>\u001a\u00020G¢\u0006\u0004\bH\u0010KJ\u0017\u0010L\u001a\u00020\u00102\u0006\u0010D\u001a\u00020\u0002H&¢\u0006\u0004\bL\u0010\u0005J\u0015\u0010N\u001a\u00020\u00022\u0006\u0010>\u001a\u00020M¢\u0006\u0004\bN\u0010OJ\u001f\u0010N\u001a\u00020\u00022\u0006\u0010<\u001a\u00020P2\u0006\u0010>\u001a\u00020MH&¢\u0006\u0004\bN\u0010QJ)\u0010N\u001a\u00020\u00022\u0012\u0010B\u001a\u000e\u0012\u0004\u0012\u00020R\u0012\u0004\u0012\u00020\u00100\u00182\u0006\u0010>\u001a\u00020M¢\u0006\u0004\bN\u0010SJ\u0017\u0010T\u001a\u00020\u00102\u0006\u0010D\u001a\u00020\u0002H&¢\u0006\u0004\bT\u0010\u0005J\u001d\u0010V\u001a\u0004\u0018\u00010U2\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\bV\u0010WJ\u0017\u0010Y\u001a\u00020\u00062\u0006\u0010X\u001a\u00020\u0002H&¢\u0006\u0004\bY\u0010ZJ\u0017\u0010[\u001a\u00020\u001d2\u0006\u0010X\u001a\u00020\u0002H&¢\u0006\u0004\b[\u0010\\J\u000f\u0010]\u001a\u00020\u001dH&¢\u0006\u0004\b]\u0010$J\u0017\u0010_\u001a\u00020\u00102\u0006\u0010^\u001a\u00020\u001dH&¢\u0006\u0004\b_\u0010 J\u000f\u0010`\u001a\u00020\u001dH&¢\u0006\u0004\b`\u0010$J\u0017\u0010b\u001a\u00020\u00102\u0006\u0010a\u001a\u00020\u001dH&¢\u0006\u0004\bb\u0010 R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010c\u001a\u0004\bd\u00104¨\u0006e"}, d2 = {"Lcom/mdisdk/Task;", "", "", HintConstants.AUTOFILL_HINT_NAME, AppAgent.CONSTRUCT, "(Ljava/lang/String;)V", "", "getDisplayId", "()I", "Landroid/view/Display;", "getDisplay", "()Landroid/view/Display;", "Landroid/view/Surface;", "getOutputSurface", "()Landroid/view/Surface;", "surface", "LC7/r;", "setOutputSurface", "(Landroid/view/Surface;)V", "Lcom/mdisdk/action/Action;", GuiTaskProgressKt.GuiTaskProgress_KEY_ACTION, "Lcom/mdisdk/action/ActionResult;", "execute", "(Lcom/mdisdk/action/Action;LH7/c;)Ljava/lang/Object;", "Lkotlin/Function1;", "Lcom/mdisdk/TaskActionBuilder;", "block", "Lp9/c;", "(LS7/k;LH7/c;)Ljava/lang/Object;", "", "ignoreActions", "finish", "(Z)V", "finishWithoutCallback$mdisdk_release", "finishWithoutCallback", "isFinished", "()Z", "Lcom/mdisdk/mirror/TaskMirrorView;", "view", "attachMirrorView", "(Lcom/mdisdk/mirror/TaskMirrorView;)V", "detachMirrorView", "()V", "Landroid/view/MotionEvent;", NotificationCompat.CATEGORY_EVENT, "viewWidth", "viewHeight", "Lcom/mdisdk/mirror/ScaleMode;", "scaleMode", "forwardTouchEvent", "(Landroid/view/MotionEvent;IILcom/mdisdk/mirror/ScaleMode;)Z", "getLastOpenApp", "()Ljava/lang/String;", WindowStateInfo.KEY_DISPLAY_ID, "getTopApp", "(Ljava/lang/Integer;)Ljava/lang/String;", "Lcom/mdisdk/observer/ForegroundAppInfo;", "getForegroundApp", "(Ljava/lang/Integer;)Lcom/mdisdk/observer/ForegroundAppInfo;", "Lcom/mdisdk/observer/ForegroundAppFilter;", "filter", "Lcom/mdisdk/observer/DisplayObserver$OnForegroundAppChangedListener;", "listener", "registerForegroundAppObserver", "(Lcom/mdisdk/observer/ForegroundAppFilter;Lcom/mdisdk/observer/DisplayObserver$OnForegroundAppChangedListener;)Ljava/lang/String;", "Lcom/mdisdk/observer/ForegroundAppFilter$Builder;", "filterBuilder", "(LS7/k;Lcom/mdisdk/observer/DisplayObserver$OnForegroundAppChangedListener;)Ljava/lang/String;", "registrationId", "unregisterForegroundAppObserver", "Lcom/mdisdk/observer/VisibleWindowFilter;", "Lcom/mdisdk/observer/DisplayObserver$OnVisibleWindowChangedListener;", "registerVisibleWindowObserver", "(Lcom/mdisdk/observer/VisibleWindowFilter;Lcom/mdisdk/observer/DisplayObserver$OnVisibleWindowChangedListener;)Ljava/lang/String;", "Lcom/mdisdk/observer/VisibleWindowFilter$Builder;", "(LS7/k;Lcom/mdisdk/observer/DisplayObserver$OnVisibleWindowChangedListener;)Ljava/lang/String;", "unregisterVisibleWindowObserver", "Lcom/mdisdk/observer/DisplayObserver$OnAppDiedListener;", "registerAppDiedObserver", "(Lcom/mdisdk/observer/DisplayObserver$OnAppDiedListener;)Ljava/lang/String;", "Lcom/mdisdk/observer/AppDiedFilter;", "(Lcom/mdisdk/observer/AppDiedFilter;Lcom/mdisdk/observer/DisplayObserver$OnAppDiedListener;)Ljava/lang/String;", "Lcom/mdisdk/observer/AppDiedFilter$Builder;", "(LS7/k;Lcom/mdisdk/observer/DisplayObserver$OnAppDiedListener;)Ljava/lang/String;", "unregisterAppDiedObserver", "Lcom/mdisdk/capability/model/IntentEntity;", "getTopActivityIntent", "(Ljava/lang/Integer;)Lcom/mdisdk/capability/model/IntentEntity;", "packageName", "getShowingDisplayId", "(Ljava/lang/String;)I", "isOmniDisplayId", "(Ljava/lang/String;)Z", "isOmniDisplayImeEnabled", "enabled", "setOmniDisplayImeEnabled", "isOmniDisplayTakeover", "takeover", "setOmniDisplayTakeover", "Ljava/lang/String;", "getName", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class Task {
    private final String name;

    public Task(String name) {
        k.f(name, "name");
        this.name = name;
    }

    public static /* synthetic */ void finish$default(Task task, boolean z10, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: finish");
        }
        if ((i & 1) != 0) {
            z10 = false;
        }
        task.finish(z10);
    }

    public static /* synthetic */ void finishWithoutCallback$mdisdk_release$default(Task task, boolean z10, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: finishWithoutCallback");
        }
        if ((i & 1) != 0) {
            z10 = false;
        }
        task.finishWithoutCallback$mdisdk_release(z10);
    }

    public static /* synthetic */ boolean forwardTouchEvent$default(Task task, MotionEvent motionEvent, int i, int i6, ScaleMode scaleMode, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: forwardTouchEvent");
        }
        if ((i10 & 8) != 0) {
            scaleMode = ScaleMode.FIT;
        }
        return task.forwardTouchEvent(motionEvent, i, i6, scaleMode);
    }

    public static /* synthetic */ ForegroundAppInfo getForegroundApp$default(Task task, Integer num, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getForegroundApp");
        }
        if ((i & 1) != 0) {
            num = null;
        }
        return task.getForegroundApp(num);
    }

    public static /* synthetic */ IntentEntity getTopActivityIntent$default(Task task, Integer num, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getTopActivityIntent");
        }
        if ((i & 1) != 0) {
            num = null;
        }
        return task.getTopActivityIntent(num);
    }

    public static /* synthetic */ String getTopApp$default(Task task, Integer num, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getTopApp");
        }
        if ((i & 1) != 0) {
            num = null;
        }
        return task.getTopApp(num);
    }

    public static /* synthetic */ String registerForegroundAppObserver$default(Task task, ForegroundAppFilter foregroundAppFilter, DisplayObserver.OnForegroundAppChangedListener onForegroundAppChangedListener, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: registerForegroundAppObserver");
        }
        if ((i & 1) != 0) {
            foregroundAppFilter = ForegroundAppFilter.ACCEPT_ALL;
        }
        return task.registerForegroundAppObserver(foregroundAppFilter, onForegroundAppChangedListener);
    }

    public static /* synthetic */ String registerVisibleWindowObserver$default(Task task, VisibleWindowFilter visibleWindowFilter, DisplayObserver.OnVisibleWindowChangedListener onVisibleWindowChangedListener, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: registerVisibleWindowObserver");
        }
        if ((i & 1) != 0) {
            visibleWindowFilter = VisibleWindowFilter.ACCEPT_ALL;
        }
        return task.registerVisibleWindowObserver(visibleWindowFilter, onVisibleWindowChangedListener);
    }

    public abstract void attachMirrorView(TaskMirrorView view);

    public abstract void detachMirrorView();

    public abstract Object execute(S7.k kVar, c<? super p9.c> cVar);

    public abstract Object execute(Action<?> action, c<? super ActionResult<?>> cVar);

    public abstract void finish(boolean ignoreActions);

    public abstract void finishWithoutCallback$mdisdk_release(boolean ignoreActions);

    public abstract boolean forwardTouchEvent(MotionEvent event, int viewWidth, int viewHeight, ScaleMode scaleMode);

    public abstract Display getDisplay();

    public abstract int getDisplayId();

    public abstract ForegroundAppInfo getForegroundApp(Integer displayId);

    public abstract String getLastOpenApp();

    public final String getName() {
        return this.name;
    }

    public abstract Surface getOutputSurface();

    public abstract int getShowingDisplayId(String packageName);

    public abstract IntentEntity getTopActivityIntent(Integer displayId);

    public abstract String getTopApp(Integer displayId);

    public abstract boolean isFinished();

    public abstract boolean isOmniDisplayId(String packageName);

    public abstract boolean isOmniDisplayImeEnabled();

    public abstract boolean isOmniDisplayTakeover();

    public abstract String registerAppDiedObserver(AppDiedFilter filter, DisplayObserver.OnAppDiedListener listener);

    public final String registerAppDiedObserver(DisplayObserver.OnAppDiedListener listener) {
        k.f(listener, "listener");
        return registerAppDiedObserver(AppDiedFilter.ACCEPT_ALL, listener);
    }

    public final String registerForegroundAppObserver(S7.k filterBuilder, DisplayObserver.OnForegroundAppChangedListener listener) {
        k.f(filterBuilder, "filterBuilder");
        k.f(listener, "listener");
        ForegroundAppFilter.Builder builder = ForegroundAppFilter.INSTANCE.builder();
        filterBuilder.invoke(builder);
        return registerForegroundAppObserver(builder.build(), listener);
    }

    public abstract String registerForegroundAppObserver(ForegroundAppFilter filter, DisplayObserver.OnForegroundAppChangedListener listener);

    public final String registerVisibleWindowObserver(S7.k filterBuilder, DisplayObserver.OnVisibleWindowChangedListener listener) {
        k.f(filterBuilder, "filterBuilder");
        k.f(listener, "listener");
        VisibleWindowFilter.Builder builder = VisibleWindowFilter.INSTANCE.builder();
        filterBuilder.invoke(builder);
        return registerVisibleWindowObserver(builder.build(), listener);
    }

    public abstract String registerVisibleWindowObserver(VisibleWindowFilter filter, DisplayObserver.OnVisibleWindowChangedListener listener);

    public abstract void setOmniDisplayImeEnabled(boolean enabled);

    public abstract void setOmniDisplayTakeover(boolean takeover);

    public abstract void setOutputSurface(Surface surface);

    public abstract void unregisterAppDiedObserver(String registrationId);

    public abstract void unregisterForegroundAppObserver(String registrationId);

    public abstract void unregisterVisibleWindowObserver(String registrationId);

    public final String registerAppDiedObserver(S7.k filterBuilder, DisplayObserver.OnAppDiedListener listener) {
        k.f(filterBuilder, "filterBuilder");
        k.f(listener, "listener");
        AppDiedFilter.Builder builder = AppDiedFilter.INSTANCE.builder();
        filterBuilder.invoke(builder);
        return registerAppDiedObserver(builder.build(), listener);
    }
}
