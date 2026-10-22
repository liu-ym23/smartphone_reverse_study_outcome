package com.android.server.companion.devicepresence;

import android.content.ComponentName;
import android.content.Context;
import android.os.Handler;
import android.util.Pair;
import android.util.Slog;
import com.android.internal.infra.PerUser;
import com.android.server.companion.utils.PackageUtils;
import com.android.server.slice.SliceClientPermissions;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class CompanionAppBinder {
    private static final long REBIND_TIMEOUT = 10000;
    private static final String TAG = "CDM_CompanionAppBinder";
    private final Map<Pair<Integer, String>, List<CompanionServiceConnector>> mBoundCompanionApplications;
    private final CompanionServicesRegister mCompanionServicesRegister;
    private final Context mContext;
    private final Set<Pair<Integer, String>> mScheduledForRebindingCompanionApplications;

    private class CompanionServicesRegister extends PerUser<Map<String, List<ComponentName>>> {
        final /* synthetic */ CompanionAppBinder this$0;

        /* synthetic */ CompanionServicesRegister(CompanionAppBinder r1, CompanionAppBinderIA r2) {
            this(r1);
        }

        private CompanionServicesRegister(CompanionAppBinder r1) {
            this.this$0 = r1;
        }

        protected /* bridge */ /* synthetic */ Object create(int r1) {
            return m2955create(r1);
        }

        public /* bridge */ /* synthetic */ Object forUser(int r1) {
            return m2956forUser(r1);
        }

        /* JADX INFO: renamed from: forUser, reason: collision with other method in class */
        public synchronized Map<String, List<ComponentName>> m2956forUser(int userId) {
            monitor-enter(this);
            Map<String, List<ComponentName>> r0 = (Map) super.forUser(userId);     // Catch: Throwable -> L6
            monitor-exit(this);
            return r0;
        L6:
            th = move-exception;
            throw th;
        }

        synchronized List<ComponentName> forPackage(int userId, String packageName) {
            monitor-enter(this);
            List<ComponentName> r0 = m2956forUser(userId).getOrDefault(packageName, Collections.emptyList());     // Catch: Throwable -> L6
            monitor-exit(this);
            return r0;
        L6:
            th = move-exception;
            throw th;
        }

        synchronized void invalidate(int userId) {
            monitor-enter(this);
            remove(userId);     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        /* JADX INFO: renamed from: create, reason: collision with other method in class */
        protected final Map<String, List<ComponentName>> m2955create(int userId) {
            return PackageUtils.getCompanionServicesForUser(CompanionAppBinder.m2954$$Nest$fgetmContext(this.this$0), userId);
        }
    }

    public static /* synthetic */ void $r8$lambda$aDJoFe7YIlDVChwfWHPOUufycQA(CompanionAppBinder r0, int r1, String r2, CompanionServiceConnector r3) {
        r0.lambda$scheduleRebinding$0(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m2954$$Nest$fgetmContext(CompanionAppBinder r0) {
        return r0.mContext;
    }

    public CompanionAppBinder(Context context) {
        this.mContext = context;
        this.mCompanionServicesRegister = new CompanionServicesRegister(this, null);
        this.mBoundCompanionApplications = new HashMap();
        this.mScheduledForRebindingCompanionApplications = new HashSet();
    }

    public void onPackageChanged(int userId) {
        this.mCompanionServicesRegister.invalidate(userId);
    }

    public void bindCompanionApp(int userId, String packageName, boolean isSelfManaged, CompanionServiceConnector.Listener listener) {
        Slog.i(TAG, "Binding user=[" + userId + "], package=[" + packageName + "], isSelfManaged=[" + isSelfManaged + "]...");
        List<ComponentName> companionServices = this.mCompanionServicesRegister.forPackage(userId, packageName);
        if (companionServices.isEmpty() == false) goto L6;
        Slog.e(TAG, "Can not bind companion applications u" + userId + SliceClientPermissions.SliceAuthority.DELIMITER + packageName + ": eligible CompanionDeviceService not found.\nA CompanionDeviceService should declare an intent-filter for \"android.companion.CompanionDeviceService\" action and require \"android.permission.BIND_COMPANION_DEVICE_SERVICE\" permission.");
        return;
    L6:
        List<CompanionServiceConnector> serviceConnectors = new ArrayList();
        Map<Pair<Integer, String>, List<CompanionServiceConnector>> r2 = this.mBoundCompanionApplications;
        monitor-enter(r2);
    L13:
        th = move-exception;
        throw th;
    L9:
        if (this.mBoundCompanionApplications.containsKey(new Pair(Integer.valueOf(userId), packageName)) == false) goto L15;
        Slog.w(TAG, "The package is ALREADY bound.");     // Catch: Throwable -> L13
        monitor-exit(r2);     // Catch: Throwable -> L13
        return;
    L15:
        int i = 0;
    L17:
        if (i >= companionServices.size()) goto L22;
        if (i != 0) goto L20;
        boolean isPrimary = true;
    L21:
        serviceConnectors.add(CompanionServiceConnector.newInstance(this.mContext, userId, companionServices.get(i), isSelfManaged, isPrimary));     // Catch: Throwable -> L13
        i = i + 1;     // Catch: Throwable -> L13
        goto L17
    L20:
        isPrimary = false;
        goto L21
    L22:
        this.mBoundCompanionApplications.put(new Pair(Integer.valueOf(userId), packageName), serviceConnectors);     // Catch: Throwable -> L13
        monitor-exit(r2);     // Catch: Throwable -> L13
        Iterator<CompanionServiceConnector> r3 = serviceConnectors.iterator();
    L26:
        if (r3.hasNext() == false) goto L28;
        CompanionServiceConnector serviceConnector = r3.next();
        serviceConnector.setListener(listener);
        goto L26
    L28:
        Iterator<CompanionServiceConnector> r4 = serviceConnectors.iterator();
    L30:
        if (r4.hasNext() == false) goto L32;
        CompanionServiceConnector serviceConnector2 = r4.next();
        serviceConnector2.connect();
        goto L30
    }

    public void unbindCompanionApp(int userId, String packageName) {
        Slog.i(TAG, "Unbinding user=[" + userId + "], package=[" + packageName + "]...");
        Map<Pair<Integer, String>, List<CompanionServiceConnector>> r0 = this.mBoundCompanionApplications;
        monitor-enter(r0);
        List<CompanionServiceConnector> serviceConnectors = this.mBoundCompanionApplications.remove(new Pair(Integer.valueOf(userId), packageName));     // Catch: Throwable -> L21
        monitor-exit(r0);     // Catch: Throwable -> L21
        Set<Pair<Integer, String>> r2 = this.mScheduledForRebindingCompanionApplications;
        monitor-enter(r2);
        this.mScheduledForRebindingCompanionApplications.remove(new Pair(Integer.valueOf(userId), packageName));     // Catch: Throwable -> L18
        monitor-exit(r2);     // Catch: Throwable -> L18
        if (serviceConnectors != null) goto L13;
        Slog.e(TAG, "The package is not bound.");
        return;
    L13:
        Iterator<CompanionServiceConnector> r1 = serviceConnectors.iterator();
    L15:
        if (r1.hasNext() == false) goto L17;
        CompanionServiceConnector serviceConnector = r1.next();
        serviceConnector.postUnbind();
        goto L15
    L17:
        return;
    L18:
        th = move-exception;
        throw th;
    L21:
        th = move-exception;
        throw th;
    }

    public boolean isCompanionApplicationBound(int userId, String packageName) {
        Map<Pair<Integer, String>, List<CompanionServiceConnector>> r0 = this.mBoundCompanionApplications;
        monitor-enter(r0);
        boolean r1 = this.mBoundCompanionApplications.containsKey(new Pair(Integer.valueOf(userId), packageName));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public void removePackage(int userId, String packageName) {
        Map<Pair<Integer, String>, List<CompanionServiceConnector>> r0 = this.mBoundCompanionApplications;
        monitor-enter(r0);
        this.mBoundCompanionApplications.remove(new Pair(Integer.valueOf(userId), packageName));     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        Set<Pair<Integer, String>> r1 = this.mScheduledForRebindingCompanionApplications;
        monitor-enter(r1);
        this.mScheduledForRebindingCompanionApplications.remove(new Pair(Integer.valueOf(userId), packageName));     // Catch: Throwable -> L11
        monitor-exit(r1);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    L14:
        th = move-exception;
        throw th;
    }

    public void scheduleRebinding(final int userId, final String packageName, final CompanionServiceConnector serviceConnector) {
        Slog.i(TAG, "scheduleRebinding() " + userId + SliceClientPermissions.SliceAuthority.DELIMITER + packageName);
        if (isRebindingCompanionApplicationScheduled(userId, packageName) == false) goto L7;
        Slog.i(TAG, "CompanionApplication rebinding has been scheduled, skipping " + serviceConnector.getComponentName());
        return;
    L7:
        if (serviceConnector.isPrimary() == false) goto L16;
        Set<Pair<Integer, String>> r0 = this.mScheduledForRebindingCompanionApplications;
        monitor-enter(r0);
        this.mScheduledForRebindingCompanionApplications.add(new Pair(Integer.valueOf(userId), packageName));     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    L16:
        Handler.getMain().postDelayed(new CompanionAppBinder$$ExternalSyntheticLambda0(this, userId, packageName, serviceConnector), 10000);
    }

    private /* synthetic */ void lambda$scheduleRebinding$0(int userId, String packageName, CompanionServiceConnector serviceConnector) {
        onRebindingCompanionApplicationTimeout(userId, packageName, serviceConnector);
    }

    private boolean isRebindingCompanionApplicationScheduled(int userId, String packageName) {
        Set<Pair<Integer, String>> r0 = this.mScheduledForRebindingCompanionApplications;
        monitor-enter(r0);
        boolean r1 = this.mScheduledForRebindingCompanionApplications.contains(new Pair(Integer.valueOf(userId), packageName));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private void onRebindingCompanionApplicationTimeout(int userId, String packageName, CompanionServiceConnector serviceConnector) {
        if (serviceConnector.isPrimary() == false) goto L22;
        Map<Pair<Integer, String>, List<CompanionServiceConnector>> r0 = this.mBoundCompanionApplications;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (this.mBoundCompanionApplications.containsKey(new Pair(Integer.valueOf(userId), packageName)) == true) goto L11;
        List<CompanionServiceConnector> serviceConnectors = Collections.singletonList(serviceConnector);     // Catch: Throwable -> L9
        this.mBoundCompanionApplications.put(new Pair(Integer.valueOf(userId), packageName), serviceConnectors);     // Catch: Throwable -> L9
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        Set<Pair<Integer, String>> r1 = this.mScheduledForRebindingCompanionApplications;
        monitor-enter(r1);
        this.mScheduledForRebindingCompanionApplications.remove(new Pair(Integer.valueOf(userId), packageName));     // Catch: Throwable -> L17
        monitor-exit(r1);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    L22:
        serviceConnector.connect();
    }

    public void dump(PrintWriter out) {
        out.append("Companion Device Application Controller: \n");
        Map<Pair<Integer, String>, List<CompanionServiceConnector>> r0 = this.mBoundCompanionApplications;
        monitor-enter(r0);
        out.append("  Bound Companion Applications: ");     // Catch: Throwable -> L7
        if (this.mBoundCompanionApplications.isEmpty() == false) goto L9;
        out.append("<empty>\n");     // Catch: Throwable -> L7
    L17:
        monitor-exit(r0);     // Catch: Throwable -> L7
        out.append("  Companion Applications Scheduled For Rebinding: ");
        Set<Pair<Integer, String>> r1 = this.mScheduledForRebindingCompanionApplications;
        monitor-enter(r1);
    L23:
        th = move-exception;
        throw th;
    L21:
        if (this.mScheduledForRebindingCompanionApplications.isEmpty() == false) goto L25;
        out.append("<empty>\n");     // Catch: Throwable -> L23
    L29:
        monitor-exit(r1);     // Catch: Throwable -> L23
        return;
    L25:
        out.append("\n");     // Catch: Throwable -> L23
        Iterator<Pair<Integer, String>> r2 = this.mScheduledForRebindingCompanionApplications.iterator();     // Catch: Throwable -> L23
    L27:
        if (r2.hasNext() == false) goto L29;
        Pair<Integer, String> app = r2.next();     // Catch: Throwable -> L23
        out.append("<u").append(String.valueOf(app.first)).append(", ").append((CharSequence) app.second).append(">");     // Catch: Throwable -> L23
        goto L27
    L9:
        out.append("\n");     // Catch: Throwable -> L7
        Iterator<Map.Entry<Pair<Integer, String>, List<CompanionServiceConnector>>> r3 = this.mBoundCompanionApplications.entrySet().iterator();     // Catch: Throwable -> L7
    L11:
        if (r3.hasNext() == false) goto L17;
        Map.Entry<Pair<Integer, String>, List<CompanionServiceConnector>> entry = r3.next();     // Catch: Throwable -> L7
        out.append("<u").append(String.valueOf(entry.getKey().first)).append(", ").append((CharSequence) entry.getKey().second).append(">");     // Catch: Throwable -> L7
        Iterator<CompanionServiceConnector> r4 = entry.getValue().iterator();     // Catch: Throwable -> L7
    L14:
        if (r4.hasNext() == false) goto L11;
        CompanionServiceConnector serviceConnector = r4.next();     // Catch: Throwable -> L7
        out.append(", isPrimary=").append(String.valueOf(serviceConnector.isPrimary()));     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    CompanionServiceConnector getPrimaryServiceConnector(int userId, String packageName) {
        Map<Pair<Integer, String>, List<CompanionServiceConnector>> r0 = this.mBoundCompanionApplications;
        monitor-enter(r0);
        List<CompanionServiceConnector> connectors = this.mBoundCompanionApplications.get(new Pair(Integer.valueOf(userId), packageName));     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        if (connectors != null) goto L15;
        return null;
    L15:
        return connectors.get(0);
    L10:
        th = move-exception;
        throw th;
    }
}
