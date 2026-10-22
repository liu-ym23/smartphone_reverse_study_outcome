package com.android.server.backup;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.Slog;
import com.android.internal.util.Preconditions;
import com.android.server.backup.transport.BackupTransportClient;
import com.android.server.backup.transport.OnTransportRegisteredListener;
import com.android.server.backup.transport.TransportConnection;
import com.android.server.backup.transport.TransportConnectionManager;
import com.android.server.backup.transport.TransportNotAvailableException;
import com.android.server.backup.transport.TransportNotRegisteredException;
import com.android.server.backup.transport.TransportStats;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes.dex */
public class TransportManager {
    private static final boolean DEBUG = false;
    public static final String SERVICE_ACTION_TRANSPORT_HOST = "android.backup.TRANSPORT_HOST";
    private static final String TAG = "BackupTransportManager";
    private volatile String mCurrentTransportName;
    private OnTransportRegisteredListener mOnTransportRegisteredListener;
    private final PackageManager mPackageManager;
    private final Map<ComponentName, TransportDescription> mRegisteredTransportsDescriptionMap;
    private final TransportConnectionManager mTransportConnectionManager;
    private final Object mTransportLock;
    private final Intent mTransportServiceIntent;
    private final TransportStats mTransportStats;
    private final Set<ComponentName> mTransportWhitelist;
    private final int mUserId;

    private static class TransportDescription {
        private Intent configurationIntent;
        private String currentDestinationString;
        private Intent dataManagementIntent;
        private CharSequence dataManagementLabel;
        private String name;
        private final String transportDirName;

        /* JADX INFO: renamed from: -$$Nest$fgetconfigurationIntent, reason: not valid java name */
        static /* bridge */ /* synthetic */ Intent m2490$$Nest$fgetconfigurationIntent(TransportDescription r0) {
            return r0.configurationIntent;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetcurrentDestinationString, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m2491$$Nest$fgetcurrentDestinationString(TransportDescription r0) {
            return r0.currentDestinationString;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetdataManagementIntent, reason: not valid java name */
        static /* bridge */ /* synthetic */ Intent m2492$$Nest$fgetdataManagementIntent(TransportDescription r0) {
            return r0.dataManagementIntent;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetdataManagementLabel, reason: not valid java name */
        static /* bridge */ /* synthetic */ CharSequence m2493$$Nest$fgetdataManagementLabel(TransportDescription r0) {
            return r0.dataManagementLabel;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetname, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m2494$$Nest$fgetname(TransportDescription r0) {
            return r0.name;
        }

        /* JADX INFO: renamed from: -$$Nest$fgettransportDirName, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m2495$$Nest$fgettransportDirName(TransportDescription r0) {
            return r0.transportDirName;
        }

        /* JADX INFO: renamed from: -$$Nest$fputconfigurationIntent, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m2496$$Nest$fputconfigurationIntent(TransportDescription r0, Intent r1) {
            r0.configurationIntent = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$fputcurrentDestinationString, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m2497$$Nest$fputcurrentDestinationString(TransportDescription r0, String r1) {
            r0.currentDestinationString = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$fputdataManagementIntent, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m2498$$Nest$fputdataManagementIntent(TransportDescription r0, Intent r1) {
            r0.dataManagementIntent = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$fputdataManagementLabel, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m2499$$Nest$fputdataManagementLabel(TransportDescription r0, CharSequence r1) {
            r0.dataManagementLabel = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$fputname, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m2500$$Nest$fputname(TransportDescription r0, String r1) {
            r0.name = r1;
        }

        /* synthetic */ TransportDescription(String r1, String r2, Intent r3, String r4, Intent r5, CharSequence r6, TransportManagerIA r7) {
            this(r1, r2, r3, r4, r5, r6);
        }

        private TransportDescription(String name, String transportDirName, Intent configurationIntent, String currentDestinationString, Intent dataManagementIntent, CharSequence dataManagementLabel) {
            this.name = name;
            this.transportDirName = transportDirName;
            this.configurationIntent = configurationIntent;
            this.currentDestinationString = currentDestinationString;
            this.dataManagementIntent = dataManagementIntent;
            this.dataManagementLabel = dataManagementLabel;
        }
    }

    public static /* synthetic */ void $r8$lambda$GleZFtibz2k01TszCsNrXgtNNYY(String r0, String r1) {
        lambda$new$0(r0, r1);
    }

    public static /* synthetic */ boolean $r8$lambda$GuAgwBUCTZyU_OWH69IG2pxehQk(ComponentName r0) {
        return lambda$onPackageAdded$1(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$n7ID6cQRmC-6Pr89PAOQ2mV8_O8, reason: not valid java name */
    public static /* synthetic */ boolean m2489$r8$lambda$n7ID6cQRmC6Pr89PAOQ2mV8_O8(String r0, ComponentName r1) {
        return lambda$fromPackageFilter$3(r0, r1);
    }

    public static /* synthetic */ boolean $r8$lambda$velBFHaSmoGaDDo2t7urM380RiQ(ComponentName r0) {
        return lambda$registerTransports$2(r0);
    }

    private static /* synthetic */ void lambda$new$0(String c, String n) {
    }

    TransportManager(int userId, Context context, Set<ComponentName> whitelist, String selectedTransport) {
        this.mTransportServiceIntent = new Intent(SERVICE_ACTION_TRANSPORT_HOST);
        this.mOnTransportRegisteredListener = new TransportManager$$ExternalSyntheticLambda0();
        this.mTransportLock = new Object();
        this.mRegisteredTransportsDescriptionMap = new ArrayMap();
        this.mUserId = userId;
        this.mPackageManager = context.getPackageManager();
        this.mTransportWhitelist = (Set) Preconditions.checkNotNull(whitelist);
        this.mCurrentTransportName = selectedTransport;
        this.mTransportStats = new TransportStats();
        this.mTransportConnectionManager = new TransportConnectionManager(this.mUserId, context, this.mTransportStats);
    }

    TransportManager(int userId, Context context, Set<ComponentName> whitelist, String selectedTransport, TransportConnectionManager transportConnectionManager) {
        this.mTransportServiceIntent = new Intent(SERVICE_ACTION_TRANSPORT_HOST);
        this.mOnTransportRegisteredListener = new TransportManager$$ExternalSyntheticLambda0();
        this.mTransportLock = new Object();
        this.mRegisteredTransportsDescriptionMap = new ArrayMap();
        this.mUserId = userId;
        this.mPackageManager = context.getPackageManager();
        this.mTransportWhitelist = (Set) Preconditions.checkNotNull(whitelist);
        this.mCurrentTransportName = selectedTransport;
        this.mTransportStats = new TransportStats();
        this.mTransportConnectionManager = transportConnectionManager;
    }

    public void setOnTransportRegisteredListener(OnTransportRegisteredListener listener) {
        this.mOnTransportRegisteredListener = listener;
    }

    private static /* synthetic */ boolean lambda$onPackageAdded$1(ComponentName transportComponent) {
        return true;
    }

    void onPackageAdded(String packageName) {
        registerTransportsFromPackage(packageName, new TransportManager$$ExternalSyntheticLambda3());
    }

    void onPackageRemoved(String packageName) {
        Object r0 = this.mTransportLock;
        monitor-enter(r0);
        this.mRegisteredTransportsDescriptionMap.keySet().removeIf(fromPackageFilter(packageName));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void onPackageEnabled(String packageName) {
        onPackageAdded(packageName);
    }

    void onPackageDisabled(String packageName) {
        onPackageRemoved(packageName);
    }

    void onPackageChanged(String packageName, String... components) {
        int r2 = 0;
        if (components.length == 1) goto L5;
    L20:
        final Set<ComponentName> transportComponents = new ArraySet(components.length);
        int r1 = components.length;
    L21:
        if (r2 >= r1) goto L24;
        String componentName = components[r2];
        transportComponents.add(new ComponentName(packageName, componentName));
        r2 = r2 + 1;
        goto L21
    L24:
        if (transportComponents.isEmpty() == false) goto L26;
        return;
    L26:
        Object r3 = this.mTransportLock;
        monitor-enter(r3);
        this.mRegisteredTransportsDescriptionMap.keySet().removeIf(new TransportManager$$ExternalSyntheticLambda1(transportComponents));     // Catch: Throwable -> L32
        monitor-exit(r3);     // Catch: Throwable -> L32
        registerTransportsFromPackage(packageName, new TransportManager$$ExternalSyntheticLambda1(transportComponents));
        return;
    L32:
        th = move-exception;
        throw th;
    L5:
        if (components[0].equals(packageName) == false) goto L20;
        int enabled = this.mPackageManager.getApplicationEnabledSetting(packageName);     // Catch: IllegalArgumentException -> L18
        switch(enabled) {
            case 0: goto L16;
            case 1: goto L14;
            case 2: goto L12;
            case 3: goto L10;
            default: goto L8;
        };
    L8:
        Slog.w(TAG, addUserIdToLogMessage(this.mUserId, "Package " + packageName + " enabled setting: " + enabled));
        return;
    L10:
        onPackageDisabled(packageName);
        return;
    L12:
        onPackageDisabled(packageName);
        return;
    L14:
        onPackageEnabled(packageName);
        return;
    L16:
        onPackageEnabled(packageName);
        return;
    }

    ComponentName[] getRegisteredTransportComponents() {
        Object r0 = this.mTransportLock;
        monitor-enter(r0);
        ComponentName[] r1 = (ComponentName[]) this.mRegisteredTransportsDescriptionMap.keySet().toArray(new ComponentName[this.mRegisteredTransportsDescriptionMap.size()]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    String[] getRegisteredTransportNames() {
        Object r0 = this.mTransportLock;
        monitor-enter(r0);
        String[] transportNames = new String[this.mRegisteredTransportsDescriptionMap.size()];     // Catch: Throwable -> L8
        int i = 0;
        Iterator<TransportDescription> r3 = this.mRegisteredTransportsDescriptionMap.values().iterator();     // Catch: Throwable -> L8
    L6:
        if (r3.hasNext() == false) goto L10;
        TransportDescription description = r3.next();     // Catch: Throwable -> L8
        transportNames[i] = TransportDescription.m2494$$Nest$fgetname(description);     // Catch: Throwable -> L8
        i = i + 1;     // Catch: Throwable -> L8
        goto L6
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return transportNames;
    L8:
        th = move-exception;
        throw th;
    }

    Set<ComponentName> getTransportWhitelist() {
        return this.mTransportWhitelist;
    }

    public String getCurrentTransportName() {
        return this.mCurrentTransportName;
    }

    public ComponentName getCurrentTransportComponent() throws TransportNotRegisteredException {
        Object r0 = this.mTransportLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mCurrentTransportName != null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return null;
    L11:
        ComponentName r1 = getRegisteredTransportComponentOrThrowLocked(this.mCurrentTransportName);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    }

    public String getTransportName(ComponentName transportComponent) throws TransportNotRegisteredException {
        Object r0 = this.mTransportLock;
        monitor-enter(r0);
        String r1 = TransportDescription.m2494$$Nest$fgetname(getRegisteredTransportDescriptionOrThrowLocked(transportComponent));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public String getTransportDirName(ComponentName transportComponent) throws TransportNotRegisteredException {
        Object r0 = this.mTransportLock;
        monitor-enter(r0);
        String r1 = TransportDescription.m2495$$Nest$fgettransportDirName(getRegisteredTransportDescriptionOrThrowLocked(transportComponent));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public String getTransportDirName(String transportName) throws TransportNotRegisteredException {
        Object r0 = this.mTransportLock;
        monitor-enter(r0);
        String r1 = TransportDescription.m2495$$Nest$fgettransportDirName(getRegisteredTransportDescriptionOrThrowLocked(transportName));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public Intent getTransportConfigurationIntent(String transportName) throws TransportNotRegisteredException {
        Object r0 = this.mTransportLock;
        monitor-enter(r0);
        Intent r1 = TransportDescription.m2490$$Nest$fgetconfigurationIntent(getRegisteredTransportDescriptionOrThrowLocked(transportName));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public String getTransportCurrentDestinationString(String transportName) throws TransportNotRegisteredException {
        Object r0 = this.mTransportLock;
        monitor-enter(r0);
        String r1 = TransportDescription.m2491$$Nest$fgetcurrentDestinationString(getRegisteredTransportDescriptionOrThrowLocked(transportName));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public Intent getTransportDataManagementIntent(String transportName) throws TransportNotRegisteredException {
        Object r0 = this.mTransportLock;
        monitor-enter(r0);
        Intent r1 = TransportDescription.m2492$$Nest$fgetdataManagementIntent(getRegisteredTransportDescriptionOrThrowLocked(transportName));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public CharSequence getTransportDataManagementLabel(String transportName) throws TransportNotRegisteredException {
        Object r0 = this.mTransportLock;
        monitor-enter(r0);
        CharSequence r1 = TransportDescription.m2493$$Nest$fgetdataManagementLabel(getRegisteredTransportDescriptionOrThrowLocked(transportName));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean isTransportRegistered(String transportName) {
        Object r0 = this.mTransportLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (getRegisteredTransportEntryLocked(transportName) == null) goto L7;
        boolean r1 = true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L7:
        r1 = false;
        goto L8
    }

    public void forEachRegisteredTransport(Consumer<String> transportConsumer) {
        Object r0 = this.mTransportLock;
        monitor-enter(r0);
        Iterator<TransportDescription> r1 = this.mRegisteredTransportsDescriptionMap.values().iterator();     // Catch: Throwable -> L8
    L6:
        if (r1.hasNext() == false) goto L10;
        TransportDescription transportDescription = r1.next();     // Catch: Throwable -> L8
        transportConsumer.accept(TransportDescription.m2494$$Nest$fgetname(transportDescription));     // Catch: Throwable -> L8
        goto L6
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void updateTransportAttributes(ComponentName transportComponent, String name, Intent configurationIntent, String currentDestinationString, Intent dataManagementIntent, CharSequence dataManagementLabel) {
        Object r0 = this.mTransportLock;
        monitor-enter(r0);
        TransportDescription description = this.mRegisteredTransportsDescriptionMap.get(transportComponent);     // Catch: Throwable -> L9
        if (description != null) goto L11;
        Slog.e(TAG, addUserIdToLogMessage(this.mUserId, "Transport " + name + " not registered tried to change description"));     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        TransportDescription.m2500$$Nest$fputname(description, name);     // Catch: Throwable -> L9
        TransportDescription.m2496$$Nest$fputconfigurationIntent(description, configurationIntent);     // Catch: Throwable -> L9
        TransportDescription.m2497$$Nest$fputcurrentDestinationString(description, currentDestinationString);     // Catch: Throwable -> L9
        TransportDescription.m2498$$Nest$fputdataManagementIntent(description, dataManagementIntent);     // Catch: Throwable -> L9
        TransportDescription.m2499$$Nest$fputdataManagementLabel(description, dataManagementLabel);     // Catch: Throwable -> L9
        Slog.d(TAG, addUserIdToLogMessage(this.mUserId, "Transport " + name + " updated its attributes"));     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private ComponentName getRegisteredTransportComponentOrThrowLocked(String transportName) throws TransportNotRegisteredException {
        ComponentName transportComponent = getRegisteredTransportComponentLocked(transportName);
        if (transportComponent == null) goto L6;
        return transportComponent;
    L6:
        throw new TransportNotRegisteredException(transportName);
    }

    private TransportDescription getRegisteredTransportDescriptionOrThrowLocked(ComponentName transportComponent) throws TransportNotRegisteredException {
        TransportDescription description = this.mRegisteredTransportsDescriptionMap.get(transportComponent);
        if (description == null) goto L6;
        return description;
    L6:
        throw new TransportNotRegisteredException(transportComponent);
    }

    private TransportDescription getRegisteredTransportDescriptionOrThrowLocked(String transportName) throws TransportNotRegisteredException {
        TransportDescription description = getRegisteredTransportDescriptionLocked(transportName);
        if (description == null) goto L6;
        return description;
    L6:
        throw new TransportNotRegisteredException(transportName);
    }

    private ComponentName getRegisteredTransportComponentLocked(String transportName) {
        Map.Entry<ComponentName, TransportDescription> entry = getRegisteredTransportEntryLocked(transportName);
        if (entry != null) goto L6;
        return null;
    L6:
        return entry.getKey();
    }

    private TransportDescription getRegisteredTransportDescriptionLocked(String transportName) {
        Map.Entry<ComponentName, TransportDescription> entry = getRegisteredTransportEntryLocked(transportName);
        if (entry != null) goto L6;
        return null;
    L6:
        return entry.getValue();
    }

    private Map.Entry<ComponentName, TransportDescription> getRegisteredTransportEntryLocked(String transportName) {
        Iterator<Map.Entry<ComponentName, TransportDescription>> r0 = this.mRegisteredTransportsDescriptionMap.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        Map.Entry<ComponentName, TransportDescription> entry = r0.next();
        TransportDescription description = entry.getValue();
        if (transportName.equals(TransportDescription.m2494$$Nest$fgetname(description)) == false) goto L4;
        return entry;
    L9:
        return null;
    }

    public TransportConnection getTransportClient(String transportName, String caller) {
        return getTransportClientOrThrow(transportName, caller);
    L5:
        Slog.w(TAG, addUserIdToLogMessage(this.mUserId, "Transport " + transportName + " not registered"));
        return null;
    }

    public TransportConnection getTransportClientOrThrow(String transportName, String caller) throws TransportNotRegisteredException {
        Object r0 = this.mTransportLock;
        monitor-enter(r0);
        ComponentName component = getRegisteredTransportComponentLocked(transportName);     // Catch: Throwable -> L9
        if (component == null) goto L12;
        TransportConnection r2 = this.mTransportConnectionManager.getTransportClient(component, caller);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L12:
        throw new TransportNotRegisteredException(transportName);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    public TransportConnection getCurrentTransportClient(String caller) {
        if (this.mCurrentTransportName == null) goto L13;
        Object r0 = this.mTransportLock;
        monitor-enter(r0);
        TransportConnection r1 = getTransportClient(this.mCurrentTransportName, caller);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L9:
        th = move-exception;
        throw th;
    L13:
        throw new IllegalStateException("No transport selected");
    }

    public TransportConnection getCurrentTransportClientOrThrow(String caller) throws TransportNotRegisteredException {
        if (this.mCurrentTransportName == null) goto L13;
        Object r0 = this.mTransportLock;
        monitor-enter(r0);
        TransportConnection r1 = getTransportClientOrThrow(this.mCurrentTransportName, caller);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L9:
        th = move-exception;
        throw th;
    L13:
        throw new IllegalStateException("No transport selected");
    }

    public void disposeOfTransportClient(TransportConnection transportConnection, String caller) {
        this.mTransportConnectionManager.disposeOfTransportClient(transportConnection, caller);
    }

    @Deprecated
    String selectTransport(String transportName) {
        Object r0 = this.mTransportLock;
        monitor-enter(r0);
        String prevTransport = this.mCurrentTransportName;     // Catch: Throwable -> L7
        this.mCurrentTransportName = transportName;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return prevTransport;
    L7:
        th = move-exception;
        throw th;
    }

    public int registerAndSelectTransport(ComponentName transportComponent) {
        Object r0 = this.mTransportLock;
        monitor-enter(r0);
        selectTransport(getTransportName(transportComponent));     // Catch: Throwable -> L8 TransportNotRegisteredException -> L10
        monitor-exit(r0);     // Catch: Throwable -> L8
        return 0;
    L8:
        th = move-exception;
        throw th;
    L12:
        int result = registerTransport(transportComponent);
        if (result == 0) goto L16;
        return result;
    L16:
        monitor-enter(this.mTransportLock);
        selectTransport(getTransportName(transportComponent));     // Catch: Throwable -> L20 TransportNotRegisteredException -> L22
        goto L23
    L19:
        return 0;
    L20:
        th = move-exception;
        throw th;
    L23:
        Slog.wtf(TAG, addUserIdToLogMessage(this.mUserId, "Transport got unregistered"));     // Catch: Throwable -> L20
        return -1;
    }

    private static /* synthetic */ boolean lambda$registerTransports$2(ComponentName transportComponent) {
        return true;
    }

    public void registerTransports() {
        registerTransportsForIntent(this.mTransportServiceIntent, new TransportManager$$ExternalSyntheticLambda4());
    }

    private void registerTransportsFromPackage(String packageName, Predicate<ComponentName> transportComponentFilter) {
        this.mPackageManager.getPackageInfoAsUser(packageName, 0, this.mUserId);     // Catch: PackageManager.NameNotFoundException -> L5
        registerTransportsForIntent(new Intent(this.mTransportServiceIntent).setPackage(packageName), transportComponentFilter.and(fromPackageFilter(packageName)));
        return;
    L6:
        Slog.e(TAG, addUserIdToLogMessage(this.mUserId, "Trying to register transports from package not found " + packageName));
    }

    private void registerTransportsForIntent(Intent intent, Predicate<ComponentName> transportComponentFilter) {
        List<ResolveInfo> hosts = this.mPackageManager.queryIntentServicesAsUser(intent, 0, this.mUserId);
        if (hosts != null) goto L5;
        return;
    L5:
        Iterator<ResolveInfo> r1 = hosts.iterator();
    L7:
        if (r1.hasNext() == false) goto L14;
        ResolveInfo host = r1.next();
        ComponentName transportComponent = host.serviceInfo.getComponentName();
        if (transportComponentFilter.test(transportComponent) == false) goto L7;
        if (isTransportTrusted(transportComponent) == false) goto L7;
        registerTransport(transportComponent);
        goto L7
    }

    private boolean isTransportTrusted(ComponentName transport) {
        if (this.mTransportWhitelist.contains(transport) == true) goto L16;
        Slog.w(TAG, addUserIdToLogMessage(this.mUserId, "BackupTransport " + transport.flattenToShortString() + " not whitelisted."));
        return false;
    L16:
        PackageInfo packInfo = this.mPackageManager.getPackageInfoAsUser(transport.getPackageName(), 0, this.mUserId);     // Catch: PackageManager.NameNotFoundException -> L10
        if ((packInfo.applicationInfo.privateFlags & 8) != 0) goto L12;
        Slog.w(TAG, addUserIdToLogMessage(this.mUserId, "Transport package " + transport.getPackageName() + " not privileged"));     // Catch: PackageManager.NameNotFoundException -> L10
        return false;
    L12:
        return true;
    L10:
        e = move-exception;
        Slog.w(TAG, addUserIdToLogMessage(this.mUserId, "Package not found."), e);
        return false;
    }

    private int registerTransport(ComponentName transportComponent) {
        checkCanUseTransport();
        if (isTransportTrusted(transportComponent) == true) goto L5;
        return -2;
    L5:
        String transportString = transportComponent.flattenToShortString();
        Bundle extras = new Bundle();
        extras.putBoolean("android.app.backup.extra.TRANSPORT_REGISTRATION", true);
        TransportConnection transportConnection = this.mTransportConnectionManager.getTransportClient(transportComponent, extras, "TransportManager.registerTransport()");
        BackupTransportClient transport = transportConnection.connectOrThrow("TransportManager.registerTransport()");     // Catch: TransportNotAvailableException -> L19
        String transportName = transport.name();     // Catch: RemoteException -> L13
        String transportDirName = transport.transportDirName();     // Catch: RemoteException -> L13
        if (transportName == null) goto L15;
        if (transportDirName == null) goto L15;
        registerTransport(transportComponent, transport);     // Catch: RemoteException -> L13
        Slog.d(TAG, addUserIdToLogMessage(this.mUserId, "Transport " + transportString + " registered"));     // Catch: RemoteException -> L13
        this.mOnTransportRegisteredListener.onTransportRegistered(transportName, transportDirName);     // Catch: RemoteException -> L13
        int result = 0;
    L17:
        this.mTransportConnectionManager.disposeOfTransportClient(transportConnection, "TransportManager.registerTransport()");
        return result;
    L15:
        return -2;
    L16:
        Slog.e(TAG, addUserIdToLogMessage(this.mUserId, "Transport " + transportString + " died while registering"));
        result = -1;
    L20:
        Slog.e(TAG, addUserIdToLogMessage(this.mUserId, "Couldn't connect to transport " + transportString + " for registration"));
        this.mTransportConnectionManager.disposeOfTransportClient(transportConnection, "TransportManager.registerTransport()");
        return -1;
    }

    private void registerTransport(ComponentName transportComponent, BackupTransportClient transport) throws RemoteException {
        checkCanUseTransport();
        TransportDescription description = new TransportDescription(transport.name(), transport.transportDirName(), transport.configurationIntent(), transport.currentDestinationString(), transport.dataManagementIntent(), transport.dataManagementIntentLabel(), null);
        Object r2 = this.mTransportLock;
        monitor-enter(r2);
        this.mRegisteredTransportsDescriptionMap.put(transportComponent, description);     // Catch: Throwable -> L7
        monitor-exit(r2);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void checkCanUseTransport() {
        Preconditions.checkState(!Thread.holdsLock(this.mTransportLock), "Can't call transport with transport lock held");
    }

    public void dumpTransportClients(PrintWriter pw) {
        this.mTransportConnectionManager.dump(pw);
    }

    public void dumpTransportStats(PrintWriter pw) {
        this.mTransportStats.dump(pw);
    }

    private static Predicate<ComponentName> fromPackageFilter(final String packageName) {
        return new TransportManager$$ExternalSyntheticLambda2(packageName);
    }

    private static /* synthetic */ boolean lambda$fromPackageFilter$3(String packageName, ComponentName transportComponent) {
        return packageName.equals(transportComponent.getPackageName());
    }

    private static String addUserIdToLogMessage(int userId, String message) {
        return "[UserID:" + userId + "] " + message;
    }
}
