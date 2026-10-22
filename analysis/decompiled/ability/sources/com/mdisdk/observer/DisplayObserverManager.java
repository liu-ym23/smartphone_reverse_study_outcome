package com.mdisdk.observer;

import A6.i;
import Ba.g;
import C7.r;
import D7.v;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.mdisdk.base.ALog;
import com.mdisdk.capability.model.WindowStateInfo;
import com.mdisdk.observer.DisplayObserver;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import io.modelcontextprotocol.spec.c;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.EmptySet;
import kotlin.jvm.internal.k;
import m5.a;

@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ)\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0014\u0010\u000fJ5\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\u00162\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u001b\u0010\u000fJ\u0017\u0010\u001c\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u001c\u0010\u000fJ!\u0010!\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001d2\b\b\u0002\u0010 \u001a\u00020\u001fH\u0007¢\u0006\u0004\b!\u0010\"J!\u0010$\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020#2\b\b\u0002\u0010 \u001a\u00020\u001fH\u0007¢\u0006\u0004\b$\u0010%J!\u0010'\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020&2\b\b\u0002\u0010 \u001a\u00020\u001fH\u0007¢\u0006\u0004\b'\u0010(J\u001d\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00040)2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020\u0017H\u0007¢\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020\u0017H\u0007¢\u0006\u0004\b.\u0010-J\u0019\u0010/\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0018\u001a\u00020\u0017H\u0007¢\u0006\u0004\b/\u00100J\u001f\u00102\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u00101\u001a\u00020\u0004H\u0002¢\u0006\u0004\b2\u00103J\u001f\u00104\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u00101\u001a\u00020\u0004H\u0002¢\u0006\u0004\b4\u00103R\u0014\u00105\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b5\u00106R0\u0010:\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000608j\u0002`9078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010;R0\u0010=\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u001008j\u0002`<078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010;R0\u0010?\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u001508j\u0002`>078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010;R&\u0010A\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040@078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010;R\u0014\u0010C\u001a\u00020B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010D¨\u0006E"}, d2 = {"Lcom/mdisdk/observer/DisplayObserverManager;", "", AppAgent.CONSTRUCT, "()V", "", GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_NAME, "Lcom/mdisdk/observer/ForegroundAppFilter;", "filter", "Lcom/mdisdk/observer/DisplayObserver$OnForegroundAppChangedListener;", "listener", "registerForegroundAppObserver", "(Ljava/lang/String;Lcom/mdisdk/observer/ForegroundAppFilter;Lcom/mdisdk/observer/DisplayObserver$OnForegroundAppChangedListener;)Ljava/lang/String;", "registrationId", "LC7/r;", "unregisterForegroundAppObserver", "(Ljava/lang/String;)V", "Lcom/mdisdk/observer/VisibleWindowFilter;", "Lcom/mdisdk/observer/DisplayObserver$OnVisibleWindowChangedListener;", "registerVisibleWindowObserver", "(Ljava/lang/String;Lcom/mdisdk/observer/VisibleWindowFilter;Lcom/mdisdk/observer/DisplayObserver$OnVisibleWindowChangedListener;)Ljava/lang/String;", "unregisterVisibleWindowObserver", "Lcom/mdisdk/observer/AppDiedFilter;", "Lcom/mdisdk/observer/DisplayObserver$OnAppDiedListener;", "", WindowStateInfo.KEY_DISPLAY_ID, "registerAppDiedObserver", "(Ljava/lang/String;Lcom/mdisdk/observer/AppDiedFilter;Lcom/mdisdk/observer/DisplayObserver$OnAppDiedListener;Ljava/lang/Integer;)Ljava/lang/String;", "unregisterAppDiedObserver", "cleanupForTask", "Lcom/mdisdk/observer/ForegroundAppInfo;", "info", "", "callbackOnMainThread", "notifyForegroundAppChanged", "(Lcom/mdisdk/observer/ForegroundAppInfo;Z)V", "Lcom/mdisdk/observer/VisibleWindowInfo;", "notifyVisibleWindowChanged", "(Lcom/mdisdk/observer/VisibleWindowInfo;Z)V", "Lcom/mdisdk/observer/AppDiedInfo;", "notifyAppDied", "(Lcom/mdisdk/observer/AppDiedInfo;Z)V", "", "getObserverIdsForTask", "(Ljava/lang/String;)Ljava/util/Set;", "getForegroundAppObserverCount", "()I", "getVisibleWindowObserverCount", "getTopApp", "(I)Lcom/mdisdk/observer/ForegroundAppInfo;", "observerId", "addTaskObserverId", "(Ljava/lang/String;Ljava/lang/String;)V", "removeTaskObserverId", "TAG", "Ljava/lang/String;", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/mdisdk/observer/ObserverRegistration;", "Lcom/mdisdk/observer/ForegroundAppObserverRegistration;", "foregroundAppObservers", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/mdisdk/observer/VisibleWindowObserverRegistration;", "visibleWindowObservers", "Lcom/mdisdk/observer/AppDiedObserverRegistration;", "appDiedObservers", "", "taskObserverIds", "Landroid/os/Handler;", "mainHandler", "Landroid/os/Handler;", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DisplayObserverManager {
    private static final String TAG = "DisplayObserverManager";
    public static final DisplayObserverManager INSTANCE = new DisplayObserverManager();
    private static final ConcurrentHashMap<String, ObserverRegistration<DisplayObserver.OnForegroundAppChangedListener, ForegroundAppFilter>> foregroundAppObservers = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, ObserverRegistration<DisplayObserver.OnVisibleWindowChangedListener, VisibleWindowFilter>> visibleWindowObservers = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, ObserverRegistration<DisplayObserver.OnAppDiedListener, AppDiedFilter>> appDiedObservers = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, Set<String>> taskObserverIds = new ConcurrentHashMap<>();
    private static final Handler mainHandler = new Handler(Looper.getMainLooper());

    private DisplayObserverManager() {
    }

    private final void addTaskObserverId(String taskName, String observerId) {
        taskObserverIds.computeIfAbsent(taskName, new g(new a(9), 6)).add(observerId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Set addTaskObserverId$lambda$6(String it) {
        k.f(it, "it");
        return ConcurrentHashMap.newKeySet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Set addTaskObserverId$lambda$7(S7.k kVar, Object obj) {
        return (Set) kVar.invoke(obj);
    }

    public static final void cleanupForTask(String taskName) {
        k.f(taskName, "taskName");
        Set<String> setRemove = taskObserverIds.remove(taskName);
        if (setRemove == null) {
            return;
        }
        int i = 0;
        boolean z10 = false;
        boolean z11 = false;
        for (String str : setRemove) {
            if (foregroundAppObservers.remove(str) != null) {
                i++;
            }
            if (visibleWindowObservers.remove(str) != null) {
                i++;
                z10 = true;
            }
            if (appDiedObservers.remove(str) != null) {
                i++;
                z11 = true;
            }
        }
        ALog.i$default(TAG, androidx.constraintlayout.core.dsl.a.c(i, "Cleaned up ", " observers for task: ", taskName), null, 4, null);
        if (z10 && visibleWindowObservers.isEmpty()) {
            FrameworkObserverBridge.removeWindowListenerIfNeeded();
        }
        if (z11 && appDiedObservers.isEmpty()) {
            FrameworkObserverBridge.removeAppDiedListenerIfNeeded();
        }
    }

    public static final int getForegroundAppObserverCount() {
        return foregroundAppObservers.size();
    }

    public static final Set<String> getObserverIdsForTask(String taskName) {
        Set<String> setJ1;
        k.f(taskName, "taskName");
        Set<String> set = taskObserverIds.get(taskName);
        return (set == null || (setJ1 = v.j1(set)) == null) ? EmptySet.f4895a : setJ1;
    }

    public static final ForegroundAppInfo getTopApp(int displayId) {
        return FrameworkObserverBridge.getForegroundApp(displayId);
    }

    public static final int getVisibleWindowObserverCount() {
        return visibleWindowObservers.size();
    }

    public static final void notifyAppDied(AppDiedInfo info, boolean callbackOnMainThread) throws IllegalStateException, NoSuchAlgorithmException, InvalidKeyException, RemoteException {
        k.f(info, "info");
        Collection<ObserverRegistration<DisplayObserver.OnAppDiedListener, AppDiedFilter>> collectionValues = appDiedObservers.values();
        k.e(collectionValues, "<get-values>(...)");
        List listF1 = v.f1(collectionValues);
        if (listF1.isEmpty()) {
            return;
        }
        i iVar = new i(18, listF1, info);
        if (!callbackOnMainThread || k.b(Looper.myLooper(), Looper.getMainLooper())) {
            iVar.invoke();
        } else {
            mainHandler.post(new c(iVar, 3));
        }
    }

    public static /* synthetic */ void notifyAppDied$default(AppDiedInfo appDiedInfo, boolean z10, int i, Object obj) throws IllegalStateException, NoSuchAlgorithmException, InvalidKeyException, RemoteException {
        if ((i & 2) != 0) {
            z10 = false;
        }
        notifyAppDied(appDiedInfo, z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r notifyAppDied$lambda$4(List list, AppDiedInfo appDiedInfo) {
        for (Object obj : list) {
            k.e(obj, "next(...)");
            ObserverRegistration observerRegistration = (ObserverRegistration) obj;
            try {
                if (((AppDiedFilter) observerRegistration.getFilter()).accept(appDiedInfo)) {
                    ((DisplayObserver.OnAppDiedListener) observerRegistration.getListener()).onAppDied(appDiedInfo);
                }
            } catch (Exception e) {
                ALog.e(TAG, "Error dispatching app died to " + observerRegistration.getId(), e);
            }
        }
        return r.f317a;
    }

    public static final void notifyForegroundAppChanged(ForegroundAppInfo info, boolean callbackOnMainThread) throws IllegalStateException, NoSuchAlgorithmException, InvalidKeyException, RemoteException {
        k.f(info, "info");
        Collection<ObserverRegistration<DisplayObserver.OnForegroundAppChangedListener, ForegroundAppFilter>> collectionValues = foregroundAppObservers.values();
        k.e(collectionValues, "<get-values>(...)");
        List listF1 = v.f1(collectionValues);
        if (listF1.isEmpty()) {
            return;
        }
        i iVar = new i(19, listF1, info);
        if (!callbackOnMainThread || k.b(Looper.myLooper(), Looper.getMainLooper())) {
            iVar.invoke();
        } else {
            mainHandler.post(new c(iVar, 4));
        }
    }

    public static /* synthetic */ void notifyForegroundAppChanged$default(ForegroundAppInfo foregroundAppInfo, boolean z10, int i, Object obj) throws IllegalStateException, NoSuchAlgorithmException, InvalidKeyException, RemoteException {
        if ((i & 2) != 0) {
            z10 = false;
        }
        notifyForegroundAppChanged(foregroundAppInfo, z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r notifyForegroundAppChanged$lambda$0(List list, ForegroundAppInfo foregroundAppInfo) {
        for (Object obj : list) {
            k.e(obj, "next(...)");
            ObserverRegistration observerRegistration = (ObserverRegistration) obj;
            try {
                if (((ForegroundAppFilter) observerRegistration.getFilter()).accept(foregroundAppInfo)) {
                    ((DisplayObserver.OnForegroundAppChangedListener) observerRegistration.getListener()).onForegroundAppChanged(foregroundAppInfo);
                }
            } catch (Exception e) {
                ALog.e(TAG, "Error dispatching foreground app change to " + observerRegistration.getId(), e);
            }
        }
        return r.f317a;
    }

    public static final void notifyVisibleWindowChanged(VisibleWindowInfo info, boolean callbackOnMainThread) throws IllegalStateException, NoSuchAlgorithmException, InvalidKeyException, RemoteException {
        k.f(info, "info");
        Collection<ObserverRegistration<DisplayObserver.OnVisibleWindowChangedListener, VisibleWindowFilter>> collectionValues = visibleWindowObservers.values();
        k.e(collectionValues, "<get-values>(...)");
        List listF1 = v.f1(collectionValues);
        if (listF1.isEmpty()) {
            return;
        }
        i iVar = new i(20, listF1, info);
        if (!callbackOnMainThread || k.b(Looper.myLooper(), Looper.getMainLooper())) {
            iVar.invoke();
        } else {
            mainHandler.post(new c(iVar, 5));
        }
    }

    public static /* synthetic */ void notifyVisibleWindowChanged$default(VisibleWindowInfo visibleWindowInfo, boolean z10, int i, Object obj) throws IllegalStateException, NoSuchAlgorithmException, InvalidKeyException, RemoteException {
        if ((i & 2) != 0) {
            z10 = false;
        }
        notifyVisibleWindowChanged(visibleWindowInfo, z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r notifyVisibleWindowChanged$lambda$2(List list, VisibleWindowInfo visibleWindowInfo) {
        for (Object obj : list) {
            k.e(obj, "next(...)");
            ObserverRegistration observerRegistration = (ObserverRegistration) obj;
            try {
                if (((VisibleWindowFilter) observerRegistration.getFilter()).accept(visibleWindowInfo)) {
                    ((DisplayObserver.OnVisibleWindowChangedListener) observerRegistration.getListener()).onVisibleWindowChanged(visibleWindowInfo);
                }
            } catch (Exception e) {
                ALog.e(TAG, "Error dispatching visible window change to " + observerRegistration.getId(), e);
            }
        }
        return r.f317a;
    }

    public static final String registerAppDiedObserver(String taskName, AppDiedFilter filter, DisplayObserver.OnAppDiedListener listener) {
        k.f(taskName, "taskName");
        k.f(filter, "filter");
        k.f(listener, "listener");
        return registerAppDiedObserver$default(taskName, filter, listener, null, 8, null);
    }

    public static /* synthetic */ String registerAppDiedObserver$default(String str, AppDiedFilter appDiedFilter, DisplayObserver.OnAppDiedListener onAppDiedListener, Integer num, int i, Object obj) {
        if ((i & 2) != 0) {
            appDiedFilter = AppDiedFilter.ACCEPT_ALL;
        }
        if ((i & 8) != 0) {
            num = null;
        }
        return registerAppDiedObserver(str, appDiedFilter, onAppDiedListener, num);
    }

    public static final String registerForegroundAppObserver(String taskName, ForegroundAppFilter filter, DisplayObserver.OnForegroundAppChangedListener listener) {
        k.f(taskName, "taskName");
        k.f(filter, "filter");
        k.f(listener, "listener");
        String strGenerateId = ObserverRegistration.INSTANCE.generateId(taskName);
        foregroundAppObservers.put(strGenerateId, new ObserverRegistration<>(strGenerateId, listener, filter, taskName));
        INSTANCE.addTaskObserverId(taskName, strGenerateId);
        ALog.d$default(TAG, B7.a.n("Registered foreground app observer: ", strGenerateId, " for task: ", taskName), null, 4, null);
        return strGenerateId;
    }

    public static /* synthetic */ String registerForegroundAppObserver$default(String str, ForegroundAppFilter foregroundAppFilter, DisplayObserver.OnForegroundAppChangedListener onForegroundAppChangedListener, int i, Object obj) {
        if ((i & 2) != 0) {
            foregroundAppFilter = ForegroundAppFilter.ACCEPT_ALL;
        }
        return registerForegroundAppObserver(str, foregroundAppFilter, onForegroundAppChangedListener);
    }

    public static final String registerVisibleWindowObserver(String taskName, VisibleWindowFilter filter, DisplayObserver.OnVisibleWindowChangedListener listener) {
        k.f(taskName, "taskName");
        k.f(filter, "filter");
        k.f(listener, "listener");
        ConcurrentHashMap<String, ObserverRegistration<DisplayObserver.OnVisibleWindowChangedListener, VisibleWindowFilter>> concurrentHashMap = visibleWindowObservers;
        if (concurrentHashMap.isEmpty()) {
            FrameworkObserverBridge.ensureWindowListenerAdded();
        }
        String strGenerateId = ObserverRegistration.INSTANCE.generateId(taskName);
        concurrentHashMap.put(strGenerateId, new ObserverRegistration<>(strGenerateId, listener, filter, taskName));
        INSTANCE.addTaskObserverId(taskName, strGenerateId);
        ALog.d$default(TAG, B7.a.n("Registered visible window observer: ", strGenerateId, " for task: ", taskName), null, 4, null);
        return strGenerateId;
    }

    public static /* synthetic */ String registerVisibleWindowObserver$default(String str, VisibleWindowFilter visibleWindowFilter, DisplayObserver.OnVisibleWindowChangedListener onVisibleWindowChangedListener, int i, Object obj) {
        if ((i & 2) != 0) {
            visibleWindowFilter = VisibleWindowFilter.ACCEPT_ALL;
        }
        return registerVisibleWindowObserver(str, visibleWindowFilter, onVisibleWindowChangedListener);
    }

    private final void removeTaskObserverId(String taskName, String observerId) {
        Set<String> set = taskObserverIds.get(taskName);
        if (set != null) {
            set.remove(observerId);
        }
    }

    public static final void unregisterAppDiedObserver(String registrationId) {
        k.f(registrationId, "registrationId");
        ConcurrentHashMap<String, ObserverRegistration<DisplayObserver.OnAppDiedListener, AppDiedFilter>> concurrentHashMap = appDiedObservers;
        ObserverRegistration<DisplayObserver.OnAppDiedListener, AppDiedFilter> observerRegistrationRemove = concurrentHashMap.remove(registrationId);
        if (observerRegistrationRemove != null) {
            INSTANCE.removeTaskObserverId(observerRegistrationRemove.getTaskName(), registrationId);
            ALog.d$default(TAG, "Unregistered app died observer: ".concat(registrationId), null, 4, null);
            if (concurrentHashMap.isEmpty()) {
                FrameworkObserverBridge.removeAppDiedListenerIfNeeded();
            }
        }
    }

    public static final void unregisterForegroundAppObserver(String registrationId) {
        k.f(registrationId, "registrationId");
        ObserverRegistration<DisplayObserver.OnForegroundAppChangedListener, ForegroundAppFilter> observerRegistrationRemove = foregroundAppObservers.remove(registrationId);
        if (observerRegistrationRemove != null) {
            INSTANCE.removeTaskObserverId(observerRegistrationRemove.getTaskName(), registrationId);
            ALog.d$default(TAG, "Unregistered foreground app observer: ".concat(registrationId), null, 4, null);
        }
    }

    public static final void unregisterVisibleWindowObserver(String registrationId) {
        k.f(registrationId, "registrationId");
        ConcurrentHashMap<String, ObserverRegistration<DisplayObserver.OnVisibleWindowChangedListener, VisibleWindowFilter>> concurrentHashMap = visibleWindowObservers;
        ObserverRegistration<DisplayObserver.OnVisibleWindowChangedListener, VisibleWindowFilter> observerRegistrationRemove = concurrentHashMap.remove(registrationId);
        if (observerRegistrationRemove != null) {
            INSTANCE.removeTaskObserverId(observerRegistrationRemove.getTaskName(), registrationId);
            ALog.d$default(TAG, "Unregistered visible window observer: ".concat(registrationId), null, 4, null);
            if (concurrentHashMap.isEmpty()) {
                FrameworkObserverBridge.removeWindowListenerIfNeeded();
            }
        }
    }

    public static final String registerAppDiedObserver(String taskName, DisplayObserver.OnAppDiedListener listener) {
        k.f(taskName, "taskName");
        k.f(listener, "listener");
        return registerAppDiedObserver$default(taskName, null, listener, null, 10, null);
    }

    public static final String registerAppDiedObserver(String taskName, AppDiedFilter filter, DisplayObserver.OnAppDiedListener listener, Integer displayId) {
        k.f(taskName, "taskName");
        k.f(filter, "filter");
        k.f(listener, "listener");
        ConcurrentHashMap<String, ObserverRegistration<DisplayObserver.OnAppDiedListener, AppDiedFilter>> concurrentHashMap = appDiedObservers;
        if (concurrentHashMap.isEmpty()) {
            FrameworkObserverBridge.ensureAppDiedListenerAdded();
        }
        if (displayId != null && filter.getDisplayId() == null) {
            filter = filter.withDisplayId$mdisdk_release(displayId.intValue());
        }
        String strGenerateId = ObserverRegistration.INSTANCE.generateId(taskName);
        concurrentHashMap.put(strGenerateId, new ObserverRegistration<>(strGenerateId, listener, filter, taskName));
        INSTANCE.addTaskObserverId(taskName, strGenerateId);
        StringBuilder sbW = B7.a.w("Registered app died observer: ", strGenerateId, " for task: ", taskName, ", displayId: ");
        sbW.append(filter.getDisplayId());
        ALog.d$default(TAG, sbW.toString(), null, 4, null);
        return strGenerateId;
    }
}
