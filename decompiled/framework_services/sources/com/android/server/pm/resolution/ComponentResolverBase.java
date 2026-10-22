package com.android.server.pm.resolution;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.os.UserHandle;
import android.util.ArrayMap;
import android.util.Pair;
import com.android.internal.pm.parsing.pkg.AndroidPackageInternal;
import com.android.internal.pm.pkg.component.ParsedActivity;
import com.android.internal.pm.pkg.component.ParsedIntentInfo;
import com.android.internal.pm.pkg.component.ParsedMainComponent;
import com.android.internal.pm.pkg.component.ParsedProvider;
import com.android.internal.pm.pkg.component.ParsedService;
import com.android.server.pm.Computer;
import com.android.server.pm.DumpState;
import com.android.server.pm.UserManagerService;
import com.android.server.pm.parsing.PackageInfoUtils;
import com.android.server.pm.parsing.pkg.AndroidPackageUtils;
import com.android.server.pm.pkg.AndroidPackage;
import com.android.server.pm.pkg.PackageStateInternal;
import com.android.server.pm.pkg.PackageUserStateInternal;
import com.android.server.utils.WatchableImpl;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ComponentResolverBase extends WatchableImpl implements ComponentResolverApi {
    protected ComponentResolver.ActivityIntentResolver mActivities;
    protected ComponentResolver.ProviderIntentResolver mProviders;
    protected ArrayMap<String, ParsedProvider> mProvidersByAuthority;
    protected ComponentResolver.ReceiverIntentResolver mReceivers;
    protected ComponentResolver.ServiceIntentResolver mServices;
    protected final UserManagerService mUserManager;

    protected ComponentResolverBase(UserManagerService userManager) {
        this.mUserManager = userManager;
    }

    @Override // com.android.server.pm.resolution.ComponentResolverApi
    public boolean componentExists(ComponentName componentName) {
        ParsedMainComponent component = this.mActivities.mActivities.get(componentName);
        if (component == null) goto L5;
        return true;
    L5:
        ParsedMainComponent component2 = this.mReceivers.mActivities.get(componentName);
        if (component2 == null) goto L8;
        return true;
    L8:
        ParsedMainComponent component3 = this.mServices.mServices.get(componentName);
        if (component3 == null) goto L12;
        return true;
    L12:
        if (this.mProviders.mProviders.get(componentName) != null) goto L16;
        return false;
    L16:
        return true;
    }

    @Override // com.android.server.pm.resolution.ComponentResolverApi
    public ParsedActivity getActivity(ComponentName component) {
        return this.mActivities.mActivities.get(component);
    }

    @Override // com.android.server.pm.resolution.ComponentResolverApi
    public ParsedProvider getProvider(ComponentName component) {
        return this.mProviders.mProviders.get(component);
    }

    @Override // com.android.server.pm.resolution.ComponentResolverApi
    public ParsedActivity getReceiver(ComponentName component) {
        return this.mReceivers.mActivities.get(component);
    }

    @Override // com.android.server.pm.resolution.ComponentResolverApi
    public ParsedService getService(ComponentName component) {
        return this.mServices.mServices.get(component);
    }

    @Override // com.android.server.pm.resolution.ComponentResolverApi
    public boolean isActivityDefined(ComponentName component) {
        if (this.mActivities.mActivities.get(component) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.android.server.pm.resolution.ComponentResolverApi
    public List<ResolveInfo> queryActivities(Computer computer, Intent intent, String resolvedType, long flags, int userId) {
        return this.mActivities.queryIntent(computer, intent, resolvedType, flags, userId);
    }

    @Override // com.android.server.pm.resolution.ComponentResolverApi
    public List<ResolveInfo> queryActivities(Computer computer, Intent intent, String resolvedType, long flags, List<ParsedActivity> activities, int userId) {
        return this.mActivities.queryIntentForPackage(computer, intent, resolvedType, flags, activities, userId);
    }

    @Override // com.android.server.pm.resolution.ComponentResolverApi
    public ProviderInfo queryProvider(Computer computer, String authority, long flags, int userId) {
        ParsedProvider p = this.mProvidersByAuthority.get(authority);
        if (p != null) goto L5;
        return null;
    L5:
        PackageStateInternal packageState = computer.getPackageStateInternal(p.getPackageName());
        if (packageState != null) goto L8;
        return null;
    L8:
        AndroidPackageInternal r1 = packageState.getPkg();
        if (r1 != null) goto L11;
        return null;
    L11:
        PackageUserStateInternal state = packageState.getUserStateOrDefault(userId);
        ApplicationInfo appInfo = PackageInfoUtils.generateApplicationInfo(r1, flags, state, userId, packageState);
        if (appInfo != null) goto L15;
        return null;
    L15:
        return PackageInfoUtils.generateProviderInfo(r1, p, flags, state, appInfo, userId, packageState);
    }

    @Override // com.android.server.pm.resolution.ComponentResolverApi
    public List<ResolveInfo> queryProviders(Computer computer, Intent intent, String resolvedType, long flags, int userId) {
        return this.mProviders.queryIntent(computer, intent, resolvedType, flags, userId);
    }

    @Override // com.android.server.pm.resolution.ComponentResolverApi
    public List<ResolveInfo> queryProviders(Computer computer, Intent intent, String resolvedType, long flags, List<ParsedProvider> providers, int userId) {
        return this.mProviders.queryIntentForPackage(computer, intent, resolvedType, flags, providers, userId);
    }

    @Override // com.android.server.pm.resolution.ComponentResolverApi
    public List<ProviderInfo> queryProviders(Computer computer, String processName, String metaDataKey, int uid, long flags, int userId) {
        int r8 = userId;
        if (this.mUserManager.exists(r8) == true) goto L6;
        return null;
    L6:
        PackageInfoUtils.CachedApplicationInfoGenerator appInfoGenerator = null;
        List<ProviderInfo> providerList = null;
        int i = this.mProviders.mProviders.size() - 1;
    L7:
        if (i < 0) goto L42;
        ParsedProvider p = this.mProviders.mProviders.valueAt(i);
        if (p.getAuthority() == null) goto L40;
        PackageStateInternal ps = computer.getPackageStateInternal(p.getPackageName());
        if (ps == null) goto L40;
        AndroidPackage pkg = ps.getPkg();
        if (pkg == null) goto L40;
        if (processName == null) goto L25;
        if (p.getProcessName().equals(processName) == false) goto L40;
        if (UserHandle.isSameApp(pkg.getUid(), uid) == false) goto L40;
    L25:
        if (metaDataKey != null) goto L27;
    L29:
        if (appInfoGenerator != null) goto L31;
        appInfoGenerator = new PackageInfoUtils.CachedApplicationInfoGenerator();
    L31:
        PackageUserStateInternal state = ps.getUserStateOrDefault(r8);
        PackageInfoUtils.CachedApplicationInfoGenerator appInfoGenerator2 = appInfoGenerator;
        ApplicationInfo appInfo = appInfoGenerator2.generate(pkg, flags, state, r8, ps);
        if (appInfo == null) goto L36;
        ProviderInfo info = PackageInfoUtils.generateProviderInfo(pkg, p, flags, state, appInfo, userId, ps);
        if (info == null) goto L36;
        if (providerList != null) goto L39;
        providerList = new ArrayList(i + 1);
    L39:
        providerList.add(info);
        appInfoGenerator = appInfoGenerator2;
    L36:
        appInfoGenerator = appInfoGenerator2;
        goto L40
    L27:
        if (p.getMetaData().containsKey(metaDataKey) == true) goto L29;
    L40:
        i = i - 1;
        r8 = userId;
        goto L7
    L42:
        return providerList;
    }

    @Override // com.android.server.pm.resolution.ComponentResolverApi
    public List<ResolveInfo> queryReceivers(Computer computer, Intent intent, String resolvedType, long flags, int userId) {
        return this.mReceivers.queryIntent(computer, intent, resolvedType, flags, userId);
    }

    @Override // com.android.server.pm.resolution.ComponentResolverApi
    public List<ResolveInfo> queryReceivers(Computer computer, Intent intent, String resolvedType, long flags, List<ParsedActivity> receivers, int userId) {
        return this.mReceivers.queryIntentForPackage(computer, intent, resolvedType, flags, receivers, userId);
    }

    @Override // com.android.server.pm.resolution.ComponentResolverApi
    public List<ResolveInfo> queryServices(Computer computer, Intent intent, String resolvedType, long flags, int userId) {
        return this.mServices.queryIntent(computer, intent, resolvedType, flags, userId);
    }

    @Override // com.android.server.pm.resolution.ComponentResolverApi
    public List<ResolveInfo> queryServices(Computer computer, Intent intent, String resolvedType, long flags, List<ParsedService> services, int userId) {
        return this.mServices.queryIntentForPackage(computer, intent, resolvedType, flags, services, userId);
    }

    @Override // com.android.server.pm.resolution.ComponentResolverApi
    public void querySyncProviders(Computer computer, List<String> outNames, List<ProviderInfo> outInfo, boolean safeMode, int userId) {
        PackageInfoUtils.CachedApplicationInfoGenerator appInfoGenerator = null;
        int i = this.mProvidersByAuthority.size() - 1;
    L3:
        if (i < 0) goto L30;
        ParsedProvider p = this.mProvidersByAuthority.valueAt(i);
        if (p.isSyncable() == false) goto L28;
        PackageStateInternal ps = computer.getPackageStateInternal(p.getPackageName());
        if (ps == null) goto L28;
        AndroidPackage pkg = ps.getPkg();
        if (pkg == null) goto L28;
        if (safeMode == true) goto L15;
    L17:
        if (appInfoGenerator != null) goto L19;
        PackageInfoUtils.CachedApplicationInfoGenerator appInfoGenerator2 = new PackageInfoUtils.CachedApplicationInfoGenerator();
        PackageInfoUtils.CachedApplicationInfoGenerator appInfoGenerator3 = appInfoGenerator2;
    L20:
        PackageUserStateInternal state = ps.getUserStateOrDefault(userId);
        ApplicationInfo appInfo = appInfoGenerator3.generate(pkg, 0, state, userId, ps);
        if (appInfo == null) goto L27;
        ProviderInfo info = PackageInfoUtils.generateProviderInfo(pkg, p, 0, state, appInfo, userId, ps);
        if (info == null) goto L27;
        outNames.add(this.mProvidersByAuthority.keyAt(i));
        outInfo.add(info);
    L27:
        appInfoGenerator = appInfoGenerator3;
        goto L28
    L19:
        appInfoGenerator3 = appInfoGenerator;
        goto L20
    L15:
        if (ps.isSystem() == true) goto L17;
    L28:
        i = i - 1;
        goto L3
    }

    @Override // com.android.server.pm.resolution.ComponentResolverApi
    public void dumpActivityResolvers(PrintWriter pw, DumpState dumpState, String packageName) {
        ComponentResolver.ActivityIntentResolver r0 = this.mActivities;
        if (dumpState.getTitlePrinted() == false) goto L5;
        String r2 = "\nActivity Resolver Table:";
    L7:
        if (r0.dump(pw, r2, "  ", packageName, dumpState.isOptionEnabled(1), true) == false) goto L10;
        dumpState.setTitlePrinted(true);
        return;
    L10:
        return;
    L5:
        r2 = "Activity Resolver Table:";
        goto L7
    }

    @Override // com.android.server.pm.resolution.ComponentResolverApi
    public void dumpProviderResolvers(PrintWriter pw, DumpState dumpState, String packageName) {
        ComponentResolver.ProviderIntentResolver r0 = this.mProviders;
        if (dumpState.getTitlePrinted() == false) goto L5;
        String r2 = "\nProvider Resolver Table:";
    L7:
        if (r0.dump(pw, r2, "  ", packageName, dumpState.isOptionEnabled(1), true) == false) goto L10;
        dumpState.setTitlePrinted(true);
        return;
    L10:
        return;
    L5:
        r2 = "Provider Resolver Table:";
        goto L7
    }

    @Override // com.android.server.pm.resolution.ComponentResolverApi
    public void dumpReceiverResolvers(PrintWriter pw, DumpState dumpState, String packageName) {
        ComponentResolver.ReceiverIntentResolver r0 = this.mReceivers;
        if (dumpState.getTitlePrinted() == false) goto L5;
        String r2 = "\nReceiver Resolver Table:";
    L7:
        if (r0.dump(pw, r2, "  ", packageName, dumpState.isOptionEnabled(1), true) == false) goto L10;
        dumpState.setTitlePrinted(true);
        return;
    L10:
        return;
    L5:
        r2 = "Receiver Resolver Table:";
        goto L7
    }

    @Override // com.android.server.pm.resolution.ComponentResolverApi
    public void dumpServiceResolvers(PrintWriter pw, DumpState dumpState, String packageName) {
        ComponentResolver.ServiceIntentResolver r0 = this.mServices;
        if (dumpState.getTitlePrinted() == false) goto L5;
        String r2 = "\nService Resolver Table:";
    L7:
        if (r0.dump(pw, r2, "  ", packageName, dumpState.isOptionEnabled(1), true) == false) goto L10;
        dumpState.setTitlePrinted(true);
        return;
    L10:
        return;
    L5:
        r2 = "Service Resolver Table:";
        goto L7
    }

    @Override // com.android.server.pm.resolution.ComponentResolverApi
    public void dumpContentProviders(Computer computer, PrintWriter pw, DumpState dumpState, String packageName) {
        boolean printedSomething = false;
        Iterator<ParsedProvider> r1 = this.mProviders.mProviders.values().iterator();
    L4:
        if (r1.hasNext() == false) goto L16;
        ParsedProvider p = r1.next();
        if (packageName == null) goto L10;
        if (packageName.equals(p.getPackageName()) == false) goto L4;
    L10:
        if (printedSomething == false) goto L12;
    L15:
        pw.print("  ");
        ComponentName.printShortString(pw, p.getPackageName(), p.getName());
        pw.println(":");
        pw.print("    ");
        pw.println(p.toString());
        goto L4
    L12:
        if (dumpState.onTitlePrinted() == false) goto L14;
        pw.println();
    L14:
        pw.println("Registered ContentProviders:");
        printedSomething = true;
        goto L15
    L16:
        boolean printedSomething2 = false;
        Iterator<Map.Entry<String, ParsedProvider>> r2 = this.mProvidersByAuthority.entrySet().iterator();
    L18:
        if (r2.hasNext() == false) goto L33;
        Map.Entry<String, ParsedProvider> entry = r2.next();
        ParsedProvider p2 = entry.getValue();
        if (packageName == null) goto L24;
        if (packageName.equals(p2.getPackageName()) == false) goto L18;
    L24:
        if (printedSomething2 == false) goto L26;
    L29:
        pw.print("  [");
        pw.print(entry.getKey());
        pw.println("]:");
        pw.print("    ");
        pw.println(p2.toString());
        AndroidPackage pkg = computer.getPackage(p2.getPackageName());
        if (pkg == null) goto L18;
        pw.print("      applicationInfo=");
        pw.println(AndroidPackageUtils.generateAppInfoWithoutState(pkg));
        goto L18
    L26:
        if (dumpState.onTitlePrinted() == false) goto L28;
        pw.println();
    L28:
        pw.println("ContentProvider Authorities:");
        printedSomething2 = true;
        goto L29
    }

    @Override // com.android.server.pm.resolution.ComponentResolverApi
    public void dumpServicePermissions(PrintWriter pw, DumpState dumpState) {
        if (dumpState.onTitlePrinted() == false) goto L5;
        pw.println();
    L5:
        pw.println("Service permissions:");
        Iterator<F> r0 = this.mServices.filterIterator();
    L7:
        if (r0.hasNext() == false) goto L12;
        Pair<ParsedService, ParsedIntentInfo> pair = (Pair) r0.next();
        ParsedService service = (ParsedService) pair.first;
        String permission = service.getPermission();
        if (permission == null) goto L7;
        pw.print("    ");
        pw.print(service.getComponentName().flattenToShortString());
        pw.print(": ");
        pw.println(permission);
        goto L7
    }
}
