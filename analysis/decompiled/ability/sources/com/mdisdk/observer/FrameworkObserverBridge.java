package com.mdisdk.observer;

import D7.v;
import D7.w;
import H4.o;
import android.os.RemoteException;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.mdisdk.base.ALog;
import com.mdisdk.capability.framework.FrameworkRegister;
import com.mdisdk.capability.model.ActivityRecord;
import com.mdisdk.capability.model.WindowStateInfo;
import com.mdisdk.observer.VisibleWindowInfo;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import io.modelcontextprotocol.spec.McpSchema;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.EmptyList;
import kotlin.collections.a;
import kotlin.jvm.internal.k;
import s3.C1913a;

@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b*\u0002=@\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\u0003J\u000f\u0010\b\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\b\u0010\u0003J\u000f\u0010\t\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\t\u0010\u0003J\u000f\u0010\n\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\n\u0010\u0003J\u000f\u0010\u000b\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u000b\u0010\u0003J\u000f\u0010\f\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\f\u0010\u0003J\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u000e\u001a\u00020\rH\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u001a\u0010\u0019J\u0017\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001f\u0010\u001eJ'\u0010#\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u00132\u0006\u0010\"\u001a\u00020!H\u0002¢\u0006\u0004\b#\u0010$J\u0017\u0010%\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b%\u0010&JA\u0010,\u001a\u00020\u00042\u0006\u0010(\u001a\u00020'2\b\u0010)\u001a\u0004\u0018\u00010'2\u0006\u0010\u000e\u001a\u00020\r2\u0016\b\u0002\u0010+\u001a\u0010\u0012\u0004\u0012\u00020'\u0012\u0006\u0012\u0004\u0018\u00010\u00010*H\u0007¢\u0006\u0004\b,\u0010-J%\u0010/\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0012H\u0007¢\u0006\u0004\b/\u00100J/\u00104\u001a\u00020\u00042\u0006\u00101\u001a\u00020\r2\u0006\u0010(\u001a\u00020'2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u00103\u001a\u000202H\u0002¢\u0006\u0004\b4\u00105R\u0014\u00106\u001a\u00020'8\u0002X\u0082T¢\u0006\u0006\n\u0004\b6\u00107R \u00109\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000f088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:R&\u0010<\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130;088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010:R\u0014\u0010>\u001a\u00020=8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u0014\u0010A\u001a\u00020@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u0014\u0010D\u001a\u00020C8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010F\u001a\u0002028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010H\u001a\u0002028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010GR\u0016\u0010I\u001a\u0002028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010GR\u0016\u0010J\u001a\u0002028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010G¨\u0006K"}, d2 = {"Lcom/mdisdk/observer/FrameworkObserverBridge;", "", AppAgent.CONSTRUCT, "()V", "LC7/r;", McpSchema.METHOD_INITIALIZE, "ensureActivityListenerAdded", "ensureWindowListenerAdded", "removeActivityListenerIfNeeded", "removeWindowListenerIfNeeded", "ensureAppDiedListenerAdded", "removeAppDiedListenerIfNeeded", "release", "", WindowStateInfo.KEY_DISPLAY_ID, "Lcom/mdisdk/observer/ForegroundAppInfo;", "getForegroundApp", "(I)Lcom/mdisdk/observer/ForegroundAppInfo;", "", "Lcom/mdisdk/observer/WindowSnapshot;", "getVisibleWindows", "(I)Ljava/util/List;", "Lcom/mdisdk/capability/model/ActivityRecord;", "activity", "handleActivityForeground", "(Lcom/mdisdk/capability/model/ActivityRecord;)V", "handleActivityBackground", "Lcom/mdisdk/capability/model/WindowStateInfo;", "window", "handleWindowShow", "(Lcom/mdisdk/capability/model/WindowStateInfo;)V", "handleWindowHide", "changedWindow", "Lcom/mdisdk/observer/VisibleWindowInfo$ChangeType;", "changeType", "notifyWindowChanged", "(ILcom/mdisdk/observer/WindowSnapshot;Lcom/mdisdk/observer/VisibleWindowInfo$ChangeType;)V", "getWindowDisplayId", "(Lcom/mdisdk/capability/model/WindowStateInfo;)I", "", "packageName", "activityClassName", "", GuiTaskProgressKt.GuiTaskProgress_KEY_EXTRAS, "notifyForegroundAppChanged", "(Ljava/lang/String;Ljava/lang/String;ILjava/util/Map;)V", "windows", "setVisibleWindows", "(ILjava/util/List;)V", "uid", "", "restarting", "handleAppDied", "(ILjava/lang/String;IZ)V", "TAG", "Ljava/lang/String;", "Ljava/util/concurrent/ConcurrentHashMap;", "foregroundApps", "Ljava/util/concurrent/ConcurrentHashMap;", "", "visibleWindows", "com/mdisdk/observer/FrameworkObserverBridge$activityListener$1", "activityListener", "Lcom/mdisdk/observer/FrameworkObserverBridge$activityListener$1;", "com/mdisdk/observer/FrameworkObserverBridge$windowListener$1", "windowListener", "Lcom/mdisdk/observer/FrameworkObserverBridge$windowListener$1;", "Lcom/mdisdk/capability/framework/FrameworkRegister$OnAppDiedListener;", "appDiedListener", "Lcom/mdisdk/capability/framework/FrameworkRegister$OnAppDiedListener;", "isInitialized", "Z", "activityListenerAdded", "windowListenerAdded", "appDiedListenerAdded", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FrameworkObserverBridge {
    private static final String TAG = "FrameworkObserverBridge";
    private static boolean activityListenerAdded;
    private static boolean appDiedListenerAdded;
    private static boolean isInitialized;
    private static boolean windowListenerAdded;
    public static final FrameworkObserverBridge INSTANCE = new FrameworkObserverBridge();
    private static final ConcurrentHashMap<Integer, ForegroundAppInfo> foregroundApps = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<Integer, List<WindowSnapshot>> visibleWindows = new ConcurrentHashMap<>();
    private static final FrameworkObserverBridge$activityListener$1 activityListener = new FrameworkRegister.OnActivityChangeListener() { // from class: com.mdisdk.observer.FrameworkObserverBridge$activityListener$1
        @Override // com.mdisdk.capability.framework.FrameworkRegister.OnActivityChangeListener
        public void onActivityBackground(ActivityRecord activity) {
            k.f(activity, "activity");
            FrameworkObserverBridge.INSTANCE.handleActivityBackground(activity);
        }

        @Override // com.mdisdk.capability.framework.FrameworkRegister.OnActivityChangeListener
        public void onActivityForeground(ActivityRecord activity) throws IllegalStateException, NoSuchAlgorithmException, InvalidKeyException, RemoteException {
            k.f(activity, "activity");
            FrameworkObserverBridge.INSTANCE.handleActivityForeground(activity);
        }
    };
    private static final FrameworkObserverBridge$windowListener$1 windowListener = new FrameworkRegister.OnWindowChangeListener() { // from class: com.mdisdk.observer.FrameworkObserverBridge$windowListener$1
        @Override // com.mdisdk.capability.framework.FrameworkRegister.OnWindowChangeListener
        public void onWindowHide(WindowStateInfo window) throws IllegalStateException, NoSuchAlgorithmException, InvalidKeyException, RemoteException {
            k.f(window, "window");
            FrameworkObserverBridge.INSTANCE.handleWindowHide(window);
        }

        @Override // com.mdisdk.capability.framework.FrameworkRegister.OnWindowChangeListener
        public void onWindowShow(WindowStateInfo window) throws IllegalStateException, NoSuchAlgorithmException, InvalidKeyException, RemoteException {
            k.f(window, "window");
            FrameworkObserverBridge.INSTANCE.handleWindowShow(window);
        }
    };
    private static final FrameworkRegister.OnAppDiedListener appDiedListener = new C1913a();

    private FrameworkObserverBridge() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void appDiedListener$lambda$0(int i, String str, int i6, boolean z10) throws IllegalStateException, NoSuchAlgorithmException, InvalidKeyException, RemoteException {
        FrameworkObserverBridge frameworkObserverBridge = INSTANCE;
        k.c(str);
        frameworkObserverBridge.handleAppDied(i, str, i6, z10);
    }

    public static final synchronized void ensureActivityListenerAdded() {
        if (!isInitialized) {
            ALog.w$default(TAG, "Not initialized, call initialize() first", null, 4, null);
            return;
        }
        if (!activityListenerAdded) {
            FrameworkRegister.getInstance().addActivityListener(activityListener);
            activityListenerAdded = true;
            ALog.i$default(TAG, "Activity listener added", null, 4, null);
        }
    }

    public static final synchronized void ensureAppDiedListenerAdded() {
        if (!isInitialized) {
            ALog.w$default(TAG, "Not initialized, call initialize() first", null, 4, null);
            return;
        }
        if (!appDiedListenerAdded) {
            FrameworkRegister.getInstance().addAppDiedListener(appDiedListener);
            appDiedListenerAdded = true;
            ALog.i$default(TAG, "App died listener added", null, 4, null);
        }
    }

    public static final synchronized void ensureWindowListenerAdded() {
        if (!isInitialized) {
            ALog.w$default(TAG, "Not initialized, call initialize() first", null, 4, null);
            return;
        }
        if (!windowListenerAdded) {
            FrameworkRegister.getInstance().addWindowListener(windowListener);
            windowListenerAdded = true;
            ALog.i$default(TAG, "Window listener added", null, 4, null);
        }
    }

    public static final ForegroundAppInfo getForegroundApp(int displayId) {
        return foregroundApps.get(Integer.valueOf(displayId));
    }

    public static final List<WindowSnapshot> getVisibleWindows(int displayId) {
        List<WindowSnapshot> listF1;
        List<WindowSnapshot> list = visibleWindows.get(Integer.valueOf(displayId));
        return (list == null || (listF1 = v.f1(list)) == null) ? EmptyList.f4893a : listF1;
    }

    private final int getWindowDisplayId(WindowStateInfo window) {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleActivityBackground(ActivityRecord activity) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleActivityForeground(ActivityRecord activity) throws IllegalStateException, NoSuchAlgorithmException, InvalidKeyException, RemoteException {
        int displayId = activity.getDisplayId();
        ConcurrentHashMap<Integer, ForegroundAppInfo> concurrentHashMap = foregroundApps;
        ForegroundAppInfo foregroundAppInfo = concurrentHashMap.get(Integer.valueOf(displayId));
        String packageName = activity.getPackageName();
        k.e(packageName, "getPackageName(...)");
        String className = activity.getClassName();
        k.c(className);
        if (className.length() <= 0) {
            className = null;
        }
        ForegroundAppInfo foregroundAppInfo2 = new ForegroundAppInfo(packageName, className, displayId, 0L, foregroundAppInfo != null ? foregroundAppInfo.getPackageName() : null, a.Q(new Pair(ForegroundAppInfo.EXTRA_WINDOW_MODE, Integer.valueOf(activity.getWindowingMode()))), 8, null);
        concurrentHashMap.put(Integer.valueOf(displayId), foregroundAppInfo2);
        DisplayObserverManager.notifyForegroundAppChanged$default(foregroundAppInfo2, false, 2, null);
    }

    private final void handleAppDied(int uid, String packageName, int displayId, boolean restarting) throws IllegalStateException, NoSuchAlgorithmException, InvalidKeyException, RemoteException {
        StringBuilder sbK = androidx.constraintlayout.core.dsl.a.k(uid, "App died: uid=", ", packageName=", packageName, ", displayId=");
        sbK.append(displayId);
        sbK.append(", restarting=");
        sbK.append(restarting);
        ALog.d$default(TAG, sbK.toString(), null, 4, null);
        DisplayObserverManager.notifyAppDied$default(AppDiedInfo.INSTANCE.from(uid, packageName, displayId, restarting), false, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleWindowHide(WindowStateInfo window) throws IllegalStateException, NoSuchAlgorithmException, InvalidKeyException, RemoteException {
        Object next;
        int windowDisplayId = getWindowDisplayId(window);
        List<WindowSnapshot> list = visibleWindows.get(Integer.valueOf(windowDisplayId));
        if (list == null) {
            return;
        }
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            WindowSnapshot windowSnapshot = (WindowSnapshot) next;
            if (k.b(windowSnapshot.getPackageName(), window.getPackageName()) && (k.b(windowSnapshot.getWindowTitle(), window.getWindowTitle()) || k.b(windowSnapshot.getActivityClassName(), window.getActivityClassName()))) {
                break;
            }
        }
        WindowSnapshot windowSnapshot2 = (WindowSnapshot) next;
        if (windowSnapshot2 != null) {
            list.remove(windowSnapshot2);
            notifyWindowChanged(windowDisplayId, windowSnapshot2, VisibleWindowInfo.ChangeType.REMOVED);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleWindowShow(WindowStateInfo window) throws IllegalStateException, NoSuchAlgorithmException, InvalidKeyException, RemoteException {
        List<WindowSnapshot> listPutIfAbsent;
        int windowDisplayId = getWindowDisplayId(window);
        ConcurrentHashMap<Integer, List<WindowSnapshot>> concurrentHashMap = visibleWindows;
        Integer numValueOf = Integer.valueOf(windowDisplayId);
        List<WindowSnapshot> arrayList = concurrentHashMap.get(numValueOf);
        if (arrayList == null && (listPutIfAbsent = concurrentHashMap.putIfAbsent(numValueOf, (arrayList = new ArrayList<>()))) != null) {
            arrayList = listPutIfAbsent;
        }
        List<WindowSnapshot> list = arrayList;
        WindowSnapshot windowSnapshotFromWindowStateInfo = WindowSnapshot.INSTANCE.fromWindowStateInfo(window, list.size());
        Iterator<WindowSnapshot> it = list.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            WindowSnapshot next = it.next();
            if (k.b(next.getPackageName(), windowSnapshotFromWindowStateInfo.getPackageName()) && k.b(next.getWindowTitle(), windowSnapshotFromWindowStateInfo.getWindowTitle())) {
                break;
            } else {
                i++;
            }
        }
        if (i >= 0) {
            list.set(i, windowSnapshotFromWindowStateInfo);
            notifyWindowChanged(windowDisplayId, windowSnapshotFromWindowStateInfo, VisibleWindowInfo.ChangeType.UPDATED);
        } else {
            list.add(windowSnapshotFromWindowStateInfo);
            notifyWindowChanged(windowDisplayId, windowSnapshotFromWindowStateInfo, VisibleWindowInfo.ChangeType.ADDED);
        }
    }

    public static final synchronized void initialize() {
        if (isInitialized) {
            ALog.w$default(TAG, "Already initialized", null, 4, null);
            return;
        }
        FrameworkRegister.getInstance().init();
        isInitialized = true;
        ensureActivityListenerAdded();
        ALog.i$default(TAG, "Initialized (activity listener registered on init)", null, 4, null);
    }

    public static final void notifyForegroundAppChanged(String packageName, String activityClassName, int displayId, Map<String, ? extends Object> extras) throws IllegalStateException, NoSuchAlgorithmException, InvalidKeyException, RemoteException {
        k.f(packageName, "packageName");
        k.f(extras, "extras");
        ConcurrentHashMap<Integer, ForegroundAppInfo> concurrentHashMap = foregroundApps;
        ForegroundAppInfo foregroundAppInfo = concurrentHashMap.get(Integer.valueOf(displayId));
        ForegroundAppInfo foregroundAppInfo2 = new ForegroundAppInfo(packageName, activityClassName, displayId, 0L, foregroundAppInfo != null ? foregroundAppInfo.getPackageName() : null, extras, 8, null);
        concurrentHashMap.put(Integer.valueOf(displayId), foregroundAppInfo2);
        DisplayObserverManager.notifyForegroundAppChanged$default(foregroundAppInfo2, false, 2, null);
    }

    public static /* synthetic */ void notifyForegroundAppChanged$default(String str, String str2, int i, Map map, int i6, Object obj) throws IllegalStateException, NoSuchAlgorithmException, InvalidKeyException, RemoteException {
        if ((i6 & 8) != 0) {
            map = a.M();
        }
        notifyForegroundAppChanged(str, str2, i, map);
    }

    private final void notifyWindowChanged(int displayId, WindowSnapshot changedWindow, VisibleWindowInfo.ChangeType changeType) throws IllegalStateException, NoSuchAlgorithmException, InvalidKeyException, RemoteException {
        List listF1;
        List<WindowSnapshot> list = visibleWindows.get(Integer.valueOf(displayId));
        if (list == null || (listF1 = v.f1(list)) == null) {
            listF1 = EmptyList.f4893a;
        }
        DisplayObserverManager.notifyVisibleWindowChanged$default(new VisibleWindowInfo(listF1, changedWindow, changeType, displayId, 0L, null, 48, null), false, 2, null);
    }

    public static final synchronized void release() {
        try {
            if (isInitialized) {
                if (activityListenerAdded) {
                    FrameworkRegister.getInstance().removeActivityListener(activityListener);
                    activityListenerAdded = false;
                }
                if (windowListenerAdded) {
                    FrameworkRegister.getInstance().removeWindowListener(windowListener);
                    windowListenerAdded = false;
                }
                if (appDiedListenerAdded) {
                    FrameworkRegister.getInstance().removeAppDiedListener(appDiedListener);
                    appDiedListenerAdded = false;
                }
                FrameworkRegister.getInstance().release();
                foregroundApps.clear();
                visibleWindows.clear();
                isInitialized = false;
                ALog.i$default(TAG, "Released", null, 4, null);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public static final synchronized void removeActivityListenerIfNeeded() {
        if (isInitialized && activityListenerAdded) {
            FrameworkRegister.getInstance().removeActivityListener(activityListener);
            activityListenerAdded = false;
            ALog.i$default(TAG, "Activity listener removed", null, 4, null);
        }
    }

    public static final synchronized void removeAppDiedListenerIfNeeded() {
        if (isInitialized && appDiedListenerAdded) {
            FrameworkRegister.getInstance().removeAppDiedListener(appDiedListener);
            appDiedListenerAdded = false;
            ALog.i$default(TAG, "App died listener removed", null, 4, null);
        }
    }

    public static final synchronized void removeWindowListenerIfNeeded() {
        if (isInitialized && windowListenerAdded) {
            FrameworkRegister.getInstance().removeWindowListener(windowListener);
            windowListenerAdded = false;
            ALog.i$default(TAG, "Window listener removed", null, 4, null);
        }
    }

    public static final void setVisibleWindows(int displayId, List<? extends WindowStateInfo> windows) throws IllegalStateException, NoSuchAlgorithmException, InvalidKeyException, RemoteException {
        k.f(windows, "windows");
        List<? extends WindowStateInfo> list = windows;
        ArrayList arrayList = new ArrayList(w.c0(list, 10));
        int i = 0;
        for (Object obj : list) {
            int i6 = i + 1;
            if (i < 0) {
                o.X();
                throw null;
            }
            arrayList.add(WindowSnapshot.INSTANCE.fromWindowStateInfo((WindowStateInfo) obj, i));
            i = i6;
        }
        visibleWindows.put(Integer.valueOf(displayId), v.g1(arrayList));
        DisplayObserverManager.notifyVisibleWindowChanged$default(new VisibleWindowInfo(arrayList, null, VisibleWindowInfo.ChangeType.BATCH_REFRESH, displayId, 0L, null, 48, null), false, 2, null);
    }
}
