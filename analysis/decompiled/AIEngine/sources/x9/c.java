package x9;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.os.Bundle;
import com.stepos.deepbinder.core.DeepBinderInternal;
import com.stepos.deepbinder.core.exception.IPCException;
import com.stepos.deepbinder.core.log.IPCLog;
import gc.o;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c {
    /* JADX WARN: Removed duplicated region for block: B:54:0x005c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String a() {
        /*
            java.lang.String r0 = x9.d.f13767c
            if (r0 == 0) goto La
            int r0 = r0.length()
            if (r0 != 0) goto Lbf
        La:
            java.lang.String r0 = android.app.Application.getProcessName()
            x9.d.f13767c = r0
            if (r0 == 0) goto L18
            int r0 = r0.length()
            if (r0 != 0) goto Lbf
        L18:
            int r0 = android.os.Process.myPid()
            android.app.ActivityManager r1 = x9.d.f13765a
            if (r1 != 0) goto L33
            android.app.Application r1 = com.stepos.deepbinder.core.DeepBinderInternal.getContext()
            java.lang.String r2 = "activity"
            java.lang.Object r1 = r1.getSystemService(r2)
            java.lang.String r2 = "null cannot be cast to non-null type android.app.ActivityManager"
            kotlin.jvm.internal.g.d(r1, r2)
            android.app.ActivityManager r1 = (android.app.ActivityManager) r1
            x9.d.f13765a = r1
        L33:
            android.app.ActivityManager r1 = x9.d.f13765a
            r2 = 0
            if (r1 == 0) goto L5c
            java.util.List r1 = r1.getRunningAppProcesses()
            if (r1 == 0) goto L5c
            java.util.Iterator r1 = r1.iterator()
        L42:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L54
            java.lang.Object r3 = r1.next()
            r4 = r3
            android.app.ActivityManager$RunningAppProcessInfo r4 = (android.app.ActivityManager.RunningAppProcessInfo) r4
            int r4 = r4.pid
            if (r4 != r0) goto L42
            goto L55
        L54:
            r3 = r2
        L55:
            android.app.ActivityManager$RunningAppProcessInfo r3 = (android.app.ActivityManager.RunningAppProcessInfo) r3
            if (r3 == 0) goto L5c
            java.lang.String r0 = r3.processName
            goto Lbd
        L5c:
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> La7
            java.io.FileReader r3 = new java.io.FileReader     // Catch: java.lang.Throwable -> La7
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La7
            r4.<init>()     // Catch: java.lang.Throwable -> La7
            java.lang.String r5 = "/proc/"
            r4.append(r5)     // Catch: java.lang.Throwable -> La7
            r4.append(r0)     // Catch: java.lang.Throwable -> La7
            java.lang.String r0 = "/cmdline"
            r4.append(r0)     // Catch: java.lang.Throwable -> La7
            java.lang.String r0 = r4.toString()     // Catch: java.lang.Throwable -> La7
            r3.<init>(r0)     // Catch: java.lang.Throwable -> La7
            r1.<init>(r3)     // Catch: java.lang.Throwable -> La7
            java.lang.String r0 = r1.readLine()     // Catch: java.lang.Throwable -> L8b
            if (r0 == 0) goto L8d
            java.lang.CharSequence r0 = gc.q.L0(r0)     // Catch: java.lang.Throwable -> L8b
            java.lang.String r2 = r0.toString()     // Catch: java.lang.Throwable -> L8b
            goto L8d
        L8b:
            r0 = move-exception
            goto La1
        L8d:
            if (r2 == 0) goto L9b
            int r0 = r2.length()     // Catch: java.lang.Throwable -> L8b
            if (r0 != 0) goto L96
            goto L9b
        L96:
            r1.close()     // Catch: java.lang.Throwable -> La7
            r0 = r2
            goto Lbd
        L9b:
            lb.n r0 = lb.n.f10413a     // Catch: java.lang.Throwable -> L8b
            r1.close()     // Catch: java.lang.Throwable -> La7
            goto Lbb
        La1:
            throw r0     // Catch: java.lang.Throwable -> La2
        La2:
            r2 = move-exception
            mb.y.q(r1, r0)     // Catch: java.lang.Throwable -> La7
            throw r2     // Catch: java.lang.Throwable -> La7
        La7:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "getProcessName read failed: "
            r1.<init>(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            java.lang.String r1 = "IPCUtils"
            android.util.Log.e(r1, r0)
        Lbb:
            java.lang.String r0 = ""
        Lbd:
            x9.d.f13767c = r0
        Lbf:
            java.lang.String r0 = x9.d.f13767c
            kotlin.jvm.internal.g.c(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: x9.c.a():java.lang.String");
    }

    public static boolean b(ComponentName componentName) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        try {
            a aVarC = c(componentName);
            String str = aVarC.f13759a;
            if (!kotlin.jvm.internal.g.b(componentName.getPackageName(), DeepBinderInternal.getContext().getPackageName())) {
                Intent intent = new Intent();
                String packageName = componentName.getPackageName();
                String str2 = aVarC.f13760b;
                if (str2 == null) {
                    str2 = "com.stepos.deepbinder.service.ProcessStateService";
                }
                intent.setComponent(new ComponentName(packageName, str2));
                return DeepBinderInternal.getContext().stopService(intent);
            }
            if (str == null) {
                return false;
            }
            if (d.f13765a == null) {
                Object systemService = DeepBinderInternal.getContext().getSystemService("activity");
                kotlin.jvm.internal.g.d(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
                d.f13765a = (ActivityManager) systemService;
            }
            ActivityManager activityManager = d.f13765a;
            if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null && !runningAppProcesses.isEmpty()) {
                Iterator<T> it = runningAppProcesses.iterator();
                while (it.hasNext()) {
                    if (kotlin.jvm.internal.g.b(((ActivityManager.RunningAppProcessInfo) it.next()).processName, str)) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static a c(ComponentName component) {
        ProviderInfo[] providerInfoArr;
        ProviderInfo providerInfo;
        String str;
        String str2;
        kotlin.jvm.internal.g.f(component, "component");
        a aVar = d.f13766b.get(component);
        if (aVar != null) {
            a aVar2 = aVar;
            if (aVar2.f13761c != null && (str2 = aVar2.f13759a) != null && str2.length() != 0) {
                return aVar2;
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
                if (kotlin.jvm.internal.g.b(providerInfo.name, component.getClassName())) {
                    break;
                }
                i10++;
            }
            if (providerInfo != null) {
                String authority = providerInfo.authority;
                kotlin.jvm.internal.g.e(authority, "authority");
                Uri uri = Uri.parse("content://" + authority);
                kotlin.jvm.internal.g.e(uri, "parse(...)");
                String processName = providerInfo.processName;
                kotlin.jvm.internal.g.e(processName, "processName");
                if (o.k0(processName, ":", false)) {
                    str = DeepBinderInternal.getContext().getPackageName() + providerInfo.processName;
                } else {
                    str = providerInfo.processName;
                }
                Bundle bundle = providerInfo.metaData;
                a aVar3 = new a(str, bundle != null ? bundle.getString("process_state_service_name") : null, uri);
                d.f13766b.put(component, aVar3);
                return aVar3;
            }
        } catch (Throwable th) {
            IPCLog.INSTANCE.w("IPCUtils", "[queryComponentInternalInfoFromProvider] Package not found or error: " + component.getPackageName() + ", error: " + th, new Object[0]);
        }
        throw new IPCException(28, a0.a.k("Can't find authorities for ", component.getShortClassName(), ". Ensure provider is configured in AndroidManifest.xml and package is installed."));
    }

    public static ComponentName d(String str) {
        Object next;
        ProviderInfo providerInfo;
        Set<Map.Entry<ComponentName, a>> setEntrySet = d.f13766b.entrySet();
        kotlin.jvm.internal.g.e(setEntrySet, "<get-entries>(...)");
        Iterator<T> it = setEntrySet.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            Uri uri = ((a) ((Map.Entry) next).getValue()).f13761c;
            if (kotlin.jvm.internal.g.b(uri != null ? uri.toString() : null, str)) {
                break;
            }
        }
        Map.Entry entry = (Map.Entry) next;
        if (entry != null) {
            return (ComponentName) entry.getKey();
        }
        List<PackageInfo> installedPackages = DeepBinderInternal.getContext().getPackageManager().getInstalledPackages(8);
        kotlin.jvm.internal.g.e(installedPackages, "getInstalledPackages(...)");
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
                    if (kotlin.jvm.internal.g.b(providerInfo.authority, str)) {
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

    public static String e(ComponentName componentName) {
        ServiceInfo serviceInfo;
        try {
            ServiceInfo[] serviceInfoArr = DeepBinderInternal.getContext().getPackageManager().getPackageInfo(componentName.getPackageName(), 4).services;
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
                if (kotlin.jvm.internal.g.b(serviceInfo.name, componentName.getClassName())) {
                    break;
                }
                i10++;
            }
            if (serviceInfo != null) {
                String processName = serviceInfo.processName;
                kotlin.jvm.internal.g.e(processName, "processName");
                if (!o.k0(processName, ":", false)) {
                    String processName2 = serviceInfo.processName;
                    kotlin.jvm.internal.g.e(processName2, "processName");
                    return processName2;
                }
                return DeepBinderInternal.getContext().getPackageName() + serviceInfo.processName;
            }
        } catch (Throwable th) {
            IPCLog.INSTANCE.w("IPCUtils", "[queryProcessNameFromService] error: " + th, new Object[0]);
        }
        IPCLog.INSTANCE.w("IPCUtils", a0.a.k("[queryProcessNameFromService] Can't find process name for ", componentName.getShortClassName(), ". Ensure service is configured in AndroidManifest.xml."), new Object[0]);
        return "";
    }
}
