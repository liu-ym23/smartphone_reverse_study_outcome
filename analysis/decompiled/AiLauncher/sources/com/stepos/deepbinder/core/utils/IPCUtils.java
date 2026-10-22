package com.stepos.deepbinder.core.utils;

import La.D;
import La.H;
import La.K;
import Y8.t;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import android.util.Log;
import com.stepos.deepbinder.core.DeepBinderInternal;
import com.stepos.deepbinder.core.constant.Constants;
import com.stepos.deepbinder.core.exception.IPCException;
import com.stepos.deepbinder.core.log.IPCLog;
import io.ktor.sse.ServerSentEventKt;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import l9.b;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u0011\u001a\u00020\u00102\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0015\u001a\u00020\u0004¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0018\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0017\u001a\u00020\t¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\u001a2\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u001e\u0010\u001fJ\u0019\u0010 \u001a\u0004\u0018\u00010\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b \u0010!J\u0017\u0010\"\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\"\u0010#J\u0017\u0010$\u001a\u00020\u00102\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b$\u0010%¨\u0006&"}, d2 = {"Lcom/stepos/deepbinder/core/utils/IPCUtils;", "", "<init>", "()V", "", "authority", "Landroid/net/Uri;", "getContentAuthorities", "(Ljava/lang/String;)Landroid/net/Uri;", "", "pid", "getProcessName", "(I)Ljava/lang/String;", "Landroid/content/ComponentName;", "component", "authorityStr", "LY8/t;", "addProviderAuthority", "(Landroid/content/ComponentName;Ljava/lang/String;)V", "getAuthorityWithoutUserId", "(Ljava/lang/String;)Ljava/lang/String;", "getCurrentProcessName", "()Ljava/lang/String;", "defaultUserId", "getUserIdFromAuthority", "(Ljava/lang/String;I)I", "", "isProcessAlive", "(Landroid/content/ComponentName;)Z", "Lcom/stepos/deepbinder/core/utils/ComponentInternalInfo;", "queryComponentInternalInfoFromProvider", "(Landroid/content/ComponentName;)Lcom/stepos/deepbinder/core/utils/ComponentInternalInfo;", "queryComponentNameFromAuthority", "(Ljava/lang/String;)Landroid/content/ComponentName;", "queryProcessNameFromService", "(Landroid/content/ComponentName;)Ljava/lang/String;", "removeProviderAuthority", "(Landroid/content/ComponentName;)V", "deepbinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class IPCUtils {
    public static final IPCUtils INSTANCE = new IPCUtils();

    private IPCUtils() {
    }

    private final Uri getContentAuthorities(String authority) {
        Uri uri = Uri.parse("content://" + authority);
        p.h(uri, "parse(...)");
        return uri;
    }

    private final String getProcessName(int pid) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        Object next;
        if (IPCUtilsKt.activityManager == null) {
            Object systemService = DeepBinderInternal.getContext().getSystemService("activity");
            p.g(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
            IPCUtilsKt.activityManager = (ActivityManager) systemService;
        }
        ActivityManager activityManager = IPCUtilsKt.activityManager;
        if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null) {
            Iterator<T> it = runningAppProcesses.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (((ActivityManager.RunningAppProcessInfo) next).pid == pid) {
                    break;
                }
            }
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = (ActivityManager.RunningAppProcessInfo) next;
            if (runningAppProcessInfo != null) {
                return runningAppProcessInfo.processName;
            }
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/" + pid + "/cmdline"));
            try {
                String line = bufferedReader.readLine();
                String string = line != null ? H.D1(line).toString() : null;
                if (string != null && string.length() != 0) {
                    b.a(bufferedReader, null);
                    return string;
                }
                t tVar = t.f7040a;
                b.a(bufferedReader, null);
                return "";
            } finally {
            }
        } catch (Throwable th) {
            Log.e("IPCUtils", "getProcessName read failed: " + th);
            return "";
        }
    }

    public final void addProviderAuthority(ComponentName component, String authorityStr) {
        Object objPutIfAbsent;
        if (component == null || authorityStr == null || authorityStr.length() == 0) {
            return;
        }
        ConcurrentHashMap concurrentHashMap = IPCUtilsKt.componentInternalInfoMap;
        Object componentInternalInfo = concurrentHashMap.get(component);
        if (componentInternalInfo == null && (objPutIfAbsent = concurrentHashMap.putIfAbsent(component, (componentInternalInfo = new ComponentInternalInfo(null, null, null)))) != null) {
            componentInternalInfo = objPutIfAbsent;
        }
        ((ComponentInternalInfo) componentInternalInfo).setAuthority(Uri.parse(authorityStr));
    }

    public final String getAuthorityWithoutUserId(String authority) {
        if (authority != null) {
            return H.s1(authority, '@', null, 2, null);
        }
        return null;
    }

    public final String getCurrentProcessName() {
        String str = IPCUtilsKt.currentProcessName;
        if (str == null || str.length() == 0) {
            IPCUtilsKt.currentProcessName = Application.getProcessName();
            String str2 = IPCUtilsKt.currentProcessName;
            if (str2 == null || str2.length() == 0) {
                IPCUtilsKt.currentProcessName = getProcessName(Process.myPid());
            }
        }
        String str3 = IPCUtilsKt.currentProcessName;
        p.f(str3);
        return str3;
    }

    public final int getUserIdFromAuthority(String authority, int defaultUserId) {
        int iA0;
        if (authority != null && (iA0 = H.A0(authority, '@', 0, false, 6, null)) != -1) {
            try {
                return Integer.parseInt(K.R1(authority, iA0));
            } catch (NumberFormatException unused) {
            }
        }
        return defaultUserId;
    }

    public final boolean isProcessAlive(ComponentName component) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (component == null) {
            return false;
        }
        try {
            ComponentInternalInfo componentInternalInfoQueryComponentInternalInfoFromProvider = queryComponentInternalInfoFromProvider(component);
            if (!p.d(component.getPackageName(), DeepBinderInternal.getContext().getPackageName())) {
                Intent intent = new Intent();
                String packageName = component.getPackageName();
                String stateServiceClassName = componentInternalInfoQueryComponentInternalInfoFromProvider.getStateServiceClassName();
                if (stateServiceClassName == null) {
                    stateServiceClassName = Constants.CLASS_PROCESS_STATE_SERVICE;
                }
                intent.setComponent(new ComponentName(packageName, stateServiceClassName));
                return DeepBinderInternal.getContext().stopService(intent);
            }
            if (componentInternalInfoQueryComponentInternalInfoFromProvider.getProcessName() == null) {
                return false;
            }
            if (IPCUtilsKt.activityManager == null) {
                Object systemService = DeepBinderInternal.getContext().getSystemService("activity");
                p.g(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
                IPCUtilsKt.activityManager = (ActivityManager) systemService;
            }
            ActivityManager activityManager = IPCUtilsKt.activityManager;
            if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null) {
                List<ActivityManager.RunningAppProcessInfo> list = runningAppProcesses;
                if (!(list instanceof Collection) || !list.isEmpty()) {
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        if (p.d(((ActivityManager.RunningAppProcessInfo) it.next()).processName, componentInternalInfoQueryComponentInternalInfoFromProvider.getProcessName())) {
                            return true;
                        }
                    }
                }
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public final ComponentInternalInfo queryComponentInternalInfoFromProvider(ComponentName component) {
        ProviderInfo[] providerInfoArr;
        ProviderInfo providerInfo;
        String str;
        String processName;
        p.i(component, "component");
        Object obj = IPCUtilsKt.componentInternalInfoMap.get(component);
        if (obj != null) {
            ComponentInternalInfo componentInternalInfo = (ComponentInternalInfo) obj;
            if (componentInternalInfo.getAuthority() != null && (processName = componentInternalInfo.getProcessName()) != null && processName.length() != 0) {
                return componentInternalInfo;
            }
        }
        try {
            PackageInfo packageInfo = DeepBinderInternal.getContext().getPackageManager().getPackageInfo(component.getPackageName(), 136);
            if (packageInfo == null || (providerInfoArr = packageInfo.providers) == null) {
                providerInfoArr = new ProviderInfo[0];
            }
            int length = providerInfoArr.length;
            int i10 = 0;
            while (true) {
                if (i10 >= length) {
                    providerInfo = null;
                    break;
                }
                providerInfo = providerInfoArr[i10];
                if (p.d(providerInfo.name, component.getClassName())) {
                    break;
                }
                i10++;
            }
            if (providerInfo != null) {
                IPCUtils iPCUtils = INSTANCE;
                String authority = providerInfo.authority;
                p.h(authority, "authority");
                Uri contentAuthorities = iPCUtils.getContentAuthorities(authority);
                String processName2 = providerInfo.processName;
                p.h(processName2, "processName");
                if (D.X(processName2, ServerSentEventKt.COLON, false, 2, null)) {
                    str = DeepBinderInternal.getContext().getPackageName() + providerInfo.processName;
                } else {
                    str = providerInfo.processName;
                }
                Bundle bundle = providerInfo.metaData;
                ComponentInternalInfo componentInternalInfo2 = new ComponentInternalInfo(str, bundle != null ? bundle.getString(Constants.META_SERVICE_NAME) : null, contentAuthorities);
                IPCUtilsKt.componentInternalInfoMap.put(component, componentInternalInfo2);
                return componentInternalInfo2;
            }
        } catch (Throwable th) {
            IPCLog.INSTANCE.w("IPCUtils", "[queryComponentInternalInfoFromProvider] Package not found or error: " + component.getPackageName() + ", error: " + th, new Object[0]);
        }
        throw new IPCException(28, "Can't find authorities for " + component.getShortClassName() + ". Ensure provider is configured in AndroidManifest.xml and package is installed.");
    }

    public final ComponentName queryComponentNameFromAuthority(String authority) {
        Object next;
        ProviderInfo providerInfo;
        Set setEntrySet = IPCUtilsKt.componentInternalInfoMap.entrySet();
        p.h(setEntrySet, "<get-entries>(...)");
        Iterator it = setEntrySet.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            Uri authority2 = ((ComponentInternalInfo) ((Map.Entry) next).getValue()).getAuthority();
            if (p.d(authority2 != null ? authority2.toString() : null, authority)) {
                break;
            }
        }
        Map.Entry entry = (Map.Entry) next;
        if (entry != null) {
            return (ComponentName) entry.getKey();
        }
        List<PackageInfo> installedPackages = DeepBinderInternal.getContext().getPackageManager().getInstalledPackages(8);
        p.h(installedPackages, "getInstalledPackages(...)");
        Iterator<T> it2 = installedPackages.iterator();
        while (it2.hasNext()) {
            ProviderInfo[] providerInfoArr = ((PackageInfo) it2.next()).providers;
            if (providerInfoArr != null) {
                int length = providerInfoArr.length;
                int i10 = 0;
                while (true) {
                    if (i10 >= length) {
                        providerInfo = null;
                        break;
                    }
                    providerInfo = providerInfoArr[i10];
                    if (p.d(providerInfo.authority, authority)) {
                        break;
                    }
                    i10++;
                }
                if (providerInfo != null) {
                    return new ComponentName(providerInfo.packageName, providerInfo.name);
                }
            }
        }
        return null;
    }

    public final String queryProcessNameFromService(ComponentName component) {
        ServiceInfo serviceInfo;
        if (component == null) {
            return "";
        }
        try {
            ServiceInfo[] serviceInfoArr = DeepBinderInternal.getContext().getPackageManager().getPackageInfo(component.getPackageName(), 4).services;
            if (serviceInfoArr == null) {
                serviceInfoArr = new ServiceInfo[0];
            }
            int length = serviceInfoArr.length;
            int i10 = 0;
            while (true) {
                if (i10 >= length) {
                    serviceInfo = null;
                    break;
                }
                serviceInfo = serviceInfoArr[i10];
                if (p.d(serviceInfo.name, component.getClassName())) {
                    break;
                }
                i10++;
            }
            if (serviceInfo != null) {
                String processName = serviceInfo.processName;
                p.h(processName, "processName");
                if (!D.X(processName, ServerSentEventKt.COLON, false, 2, null)) {
                    String processName2 = serviceInfo.processName;
                    p.h(processName2, "processName");
                    return processName2;
                }
                return DeepBinderInternal.getContext().getPackageName() + serviceInfo.processName;
            }
        } catch (Throwable th) {
            IPCLog.INSTANCE.w("IPCUtils", "[queryProcessNameFromService] error: " + th, new Object[0]);
        }
        IPCLog.INSTANCE.w("IPCUtils", "[queryProcessNameFromService] Can't find process name for " + component.getShortClassName() + ". Ensure service is configured in AndroidManifest.xml.", new Object[0]);
        return "";
    }

    public final void removeProviderAuthority(ComponentName component) {
        if (component != null) {
        }
    }
}
