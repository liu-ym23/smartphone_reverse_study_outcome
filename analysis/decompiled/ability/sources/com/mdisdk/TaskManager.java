package com.mdisdk;

import B7.a;
import C7.r;
import R3.c;
import android.content.ComponentName;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.view.Surface;
import androidx.autofill.HintConstants;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.mdisdk.base.ALog;
import com.mdisdk.capability.framework.FrameworkBridgeFactory;
import com.mdisdk.capability.model.IntentEntity;
import com.mdisdk.capability.model.WindowStateInfo;
import com.mdisdk.capability.utils.IntentUtils;
import com.mdisdk.core.DefaultTaskImpl;
import com.mdisdk.display.OmniDisplay;
import com.mdisdk.observer.DisplayObserverManager;
import com.mdisdk.observer.ForegroundAppInfo;
import com.mdisdk.observer.FrameworkObserverBridge;
import io.modelcontextprotocol.spec.McpSchema;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000b\u0010\u0003J/\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0012\u0010\u0013J7\u0010\u0016\u001a\u0004\u0018\u00010\u00112\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00142\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0015\u001a\u00020\u0014H\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ#\u0010\u001c\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001b\u001a\u00020\f2\b\b\u0002\u0010\u0015\u001a\u00020\u0014H\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u0015\u001a\u00020\u0014H\u0007¢\u0006\u0004\b\u001f\u0010 J\u0019\u0010#\u001a\u00020\b2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0007¢\u0006\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b%\u0010&R \u0010(\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00110'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010+\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u0010-\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.¨\u0006/"}, d2 = {"Lcom/mdisdk/TaskManager;", "", AppAgent.CONSTRUCT, "()V", "Landroid/content/Context;", "context", "", "enableObserver", "LC7/r;", McpSchema.METHOD_INITIALIZE, "(Landroid/content/Context;Z)V", "release", "", HintConstants.AUTOFILL_HINT_NAME, "Landroid/view/Surface;", "outputSurface", "reuse", "Lcom/mdisdk/Task;", "create", "(Ljava/lang/String;Landroid/view/Surface;Z)Lcom/mdisdk/Task;", "", WindowStateInfo.KEY_DISPLAY_ID, "createForDisplay", "(Ljava/lang/String;ILandroid/view/Surface;Z)Lcom/mdisdk/Task;", "Lcom/mdisdk/capability/model/IntentEntity;", "getTopActivityIntent", "(I)Lcom/mdisdk/capability/model/IntentEntity;", "packageName", "getActivityIntentByPackage", "(Ljava/lang/String;I)Lcom/mdisdk/capability/model/IntentEntity;", "Lcom/mdisdk/observer/ForegroundAppInfo;", "getTopApp", "(I)Lcom/mdisdk/observer/ForegroundAppInfo;", "Landroid/content/ComponentName;", "component", "setRedirectActivity", "(Landroid/content/ComponentName;)V", "TAG", "Ljava/lang/String;", "Ljava/util/concurrent/ConcurrentHashMap;", "activeTasks", "Ljava/util/concurrent/ConcurrentHashMap;", "Landroid/hardware/display/DisplayManager;", "displayManager", "Landroid/hardware/display/DisplayManager;", "applicationContext", "Landroid/content/Context;", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TaskManager {
    private static final String TAG = "TaskManager";
    private static Context applicationContext;
    private static DisplayManager displayManager;
    public static final TaskManager INSTANCE = new TaskManager();
    private static final ConcurrentHashMap<String, Task> activeTasks = new ConcurrentHashMap<>();

    private TaskManager() {
    }

    public static final Task create(String name) {
        k.f(name, "name");
        return create$default(name, null, false, 6, null);
    }

    public static /* synthetic */ Task create$default(String str, Surface surface, boolean z10, int i, Object obj) {
        if ((i & 2) != 0) {
            surface = null;
        }
        if ((i & 4) != 0) {
            z10 = false;
        }
        return create(str, surface, z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r create$lambda$2(String str, Task it) {
        k.f(it, "it");
        activeTasks.remove(str);
        return r.f317a;
    }

    public static final Task createForDisplay(String name, int i) {
        k.f(name, "name");
        return createForDisplay$default(name, i, null, false, 12, null);
    }

    public static /* synthetic */ Task createForDisplay$default(String str, int i, Surface surface, boolean z10, int i6, Object obj) {
        if ((i6 & 4) != 0) {
            surface = null;
        }
        if ((i6 & 8) != 0) {
            z10 = false;
        }
        return createForDisplay(str, i, surface, z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r createForDisplay$lambda$6(String str, Task it) {
        k.f(it, "it");
        activeTasks.remove(str);
        return r.f317a;
    }

    public static final IntentEntity getActivityIntentByPackage(String packageName) {
        k.f(packageName, "packageName");
        return getActivityIntentByPackage$default(packageName, 0, 2, null);
    }

    public static /* synthetic */ IntentEntity getActivityIntentByPackage$default(String str, int i, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            i = 0;
        }
        return getActivityIntentByPackage(str, i);
    }

    public static final IntentEntity getTopActivityIntent(int displayId) {
        return IntentUtils.getTopActivityIntent(displayId);
    }

    public static final ForegroundAppInfo getTopApp(int displayId) {
        return DisplayObserverManager.getTopApp(displayId);
    }

    public static final void initialize(Context context) {
        k.f(context, "context");
        initialize$default(context, false, 2, null);
    }

    public static /* synthetic */ void initialize$default(Context context, boolean z10, int i, Object obj) {
        if ((i & 2) != 0) {
            z10 = true;
        }
        initialize(context, z10);
    }

    public static final void release() {
        Collection<Task> collectionValues = activeTasks.values();
        k.e(collectionValues, "<get-values>(...)");
        Iterator<T> it = collectionValues.iterator();
        while (it.hasNext()) {
            ((Task) it.next()).finish(true);
        }
        activeTasks.clear();
        FrameworkObserverBridge.release();
        displayManager = null;
        applicationContext = null;
    }

    public static final void setRedirectActivity(ComponentName component) {
        FrameworkBridgeFactory.get().setRedirectActivity(component);
    }

    public static final Task create(String name, Surface surface) {
        k.f(name, "name");
        return create$default(name, surface, false, 4, null);
    }

    public static final Task createForDisplay(String name, int i, Surface surface) {
        k.f(name, "name");
        return createForDisplay$default(name, i, surface, false, 8, null);
    }

    public static final IntentEntity getActivityIntentByPackage(String packageName, int displayId) {
        k.f(packageName, "packageName");
        return IntentUtils.getActivityIntentByPackage(packageName, displayId);
    }

    public static final void initialize(Context context, boolean enableObserver) {
        k.f(context, "context");
        if (applicationContext != null) {
            return;
        }
        Context applicationContext2 = context.getApplicationContext();
        applicationContext = applicationContext2;
        Object systemService = applicationContext2 != null ? applicationContext2.getSystemService("display") : null;
        displayManager = systemService instanceof DisplayManager ? (DisplayManager) systemService : null;
        FrameworkBridgeFactory.get().addDisplayControlPackage(context.getApplicationContext().getPackageName());
        if (enableObserver) {
            FrameworkObserverBridge.initialize();
        }
    }

    public static final Task create(String name, Surface outputSurface, boolean reuse) {
        DisplayManager displayManager2;
        k.f(name, "name");
        Context context = applicationContext;
        if (context != null && (displayManager2 = displayManager) != null) {
            ConcurrentHashMap<String, Task> concurrentHashMap = activeTasks;
            Task task = concurrentHashMap.get(name);
            if (task != null) {
                if (reuse) {
                    return task;
                }
                ALog.e$default(TAG, a.m("Task ", name, " already here, consider reuse it!"), null, 4, null);
                task.finishWithoutCallback$mdisdk_release(true);
            }
            OmniDisplay omniDisplayCreate = OmniDisplay.INSTANCE.create(displayManager2, outputSurface, outputSurface == null);
            if (omniDisplayCreate != null) {
                DefaultTaskImpl defaultTaskImpl = new DefaultTaskImpl(context, name, omniDisplayCreate, new c(name, 23));
                if (concurrentHashMap.get(name) != null) {
                    ALog.e$default(TAG, a.m("Task ", name, " already here, wtf!"), null, 4, null);
                    defaultTaskImpl.finishWithoutCallback$mdisdk_release(true);
                }
                concurrentHashMap.put(name, defaultTaskImpl);
                return defaultTaskImpl;
            }
        }
        return null;
    }

    public static final Task createForDisplay(String name, int displayId, Surface outputSurface, boolean reuse) {
        DisplayManager displayManager2;
        k.f(name, "name");
        Context context = applicationContext;
        if (context != null && (displayManager2 = displayManager) != null) {
            ConcurrentHashMap<String, Task> concurrentHashMap = activeTasks;
            Task task = concurrentHashMap.get(name);
            if (task != null) {
                if (reuse) {
                    return task;
                }
                ALog.e$default(TAG, a.m("Task ", name, " already here, consider reuse it!"), null, 4, null);
                task.finishWithoutCallback$mdisdk_release(true);
            }
            OmniDisplay omniDisplayCreateForDisplay = OmniDisplay.INSTANCE.createForDisplay(displayManager2, displayId, outputSurface, outputSurface == null);
            if (omniDisplayCreateForDisplay != null) {
                DefaultTaskImpl defaultTaskImpl = new DefaultTaskImpl(context, name, omniDisplayCreateForDisplay, new c(name, 22));
                if (concurrentHashMap.get(name) != null) {
                    ALog.e$default(TAG, a.m("Task ", name, " already here, wtf!"), null, 4, null);
                    defaultTaskImpl.finishWithoutCallback$mdisdk_release(true);
                }
                concurrentHashMap.put(name, defaultTaskImpl);
                return defaultTaskImpl;
            }
        }
        return null;
    }
}
