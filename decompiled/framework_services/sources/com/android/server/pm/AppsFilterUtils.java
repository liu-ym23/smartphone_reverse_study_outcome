package com.android.server.pm;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.Pair;
import android.util.SparseSetArray;
import com.android.internal.pm.parsing.pkg.AndroidPackageInternal;
import com.android.internal.pm.pkg.component.ParsedComponent;
import com.android.internal.pm.pkg.component.ParsedIntentInfo;
import com.android.internal.pm.pkg.component.ParsedMainComponent;
import com.android.internal.pm.pkg.component.ParsedProvider;
import com.android.internal.util.ArrayUtils;
import com.android.internal.util.ConcurrentUtils;
import com.android.server.pm.pkg.AndroidPackage;
import com.android.server.pm.pkg.PackageState;
import com.android.server.pm.pkg.PackageStateInternal;
import com.android.server.utils.WatchedArraySet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes2.dex */
final class AppsFilterUtils {

    public static final class ParallelComputeComponentVisibility {
        private static final int MAX_THREADS = 4;
        private final ArrayMap<String, ? extends PackageStateInternal> mExistingSettings;
        private final ArraySet<Integer> mForceQueryable;
        private final WatchedArraySet<String> mProtectedBroadcasts;

        public static /* synthetic */ ArraySet $r8$lambda$UMa2mVXysTyYjRdBqkvUdM8dmxQ(ParallelComputeComponentVisibility r0, PackageStateInternal r1) {
            return r0.lambda$execute$0(r1);
        }

        ParallelComputeComponentVisibility(ArrayMap<String, ? extends PackageStateInternal> existingSettings, ArraySet<Integer> forceQueryable, WatchedArraySet<String> protectedBroadcasts) {
            this.mExistingSettings = existingSettings;
            this.mForceQueryable = forceQueryable;
            this.mProtectedBroadcasts = protectedBroadcasts;
        }

        SparseSetArray<Integer> execute() {
            SparseSetArray<Integer> queriesViaComponent = new SparseSetArray();
            ExecutorService pool = ConcurrentUtils.newFixedThreadPool(4, ParallelComputeComponentVisibility.class.getSimpleName(), 0);
            List<Pair<PackageState, Future<ArraySet<Integer>>>> futures = new ArrayList();     // Catch: Throwable -> L15
            int i = this.mExistingSettings.size() - 1;     // Catch: Throwable -> L15
        L4:
            if (i < 0) goto L19;
            final PackageStateInternal setting = this.mExistingSettings.valueAt(i);     // Catch: Throwable -> L15
            AndroidPackageInternal r5 = setting.getPkg();     // Catch: Throwable -> L15
            if (r5 == null) goto L18;
            if (AppsFilterUtils.requestsQueryAllPackages(r5) == true) goto L18;
            if (r5.getQueriesIntents().isEmpty() == true) goto L13;
        L17:
            futures.add(new Pair(setting, pool.submit(new AppsFilterUtils$ParallelComputeComponentVisibility$$ExternalSyntheticLambda0(this, setting))));     // Catch: Throwable -> L15
            goto L18
        L13:
            if (r5.getQueriesProviders().isEmpty() == false) goto L17;
        L18:
            i = i - 1;     // Catch: Throwable -> L15
            goto L4
        L19:
            int i2 = 0;
        L21:
            if (i2 >= futures.size()) goto L33;
            int appId = ((PackageState) futures.get(i2).first).getAppId();     // Catch: Throwable -> L15
            Future<ArraySet<Integer>> future = (Future) futures.get(i2).second;     // Catch: Throwable -> L15
            ArraySet<Integer> visibleList = future.get();     // Catch: Throwable -> L15 Throwable -> L27
            if (visibleList.size() == 0) goto L29;
            queriesViaComponent.addAll(appId, visibleList);     // Catch: Throwable -> L15 Throwable -> L27
        L29:
            i2 = i2 + 1;
        L27:
            e = move-exception;
            throw new IllegalStateException(e);     // Catch: Throwable -> L15
        L33:
            pool.shutdownNow();
            return queriesViaComponent;
        L15:
            th = move-exception;
            pool.shutdownNow();
            throw th;
        }

        private /* synthetic */ ArraySet lambda$execute$0(PackageStateInternal setting) throws Exception {
            return getVisibleListOfQueryViaComponents(setting);
        }

        private ArraySet<Integer> getVisibleListOfQueryViaComponents(PackageStateInternal setting) {
            ArraySet<Integer> result = new ArraySet();
            int i = this.mExistingSettings.size() - 1;
        L3:
            if (i < 0) goto L17;
            PackageStateInternal otherSetting = this.mExistingSettings.valueAt(i);
            if (setting.getAppId() == otherSetting.getAppId()) goto L15;
            if (otherSetting.getPkg() == null) goto L15;
            if (this.mForceQueryable.contains(Integer.valueOf(otherSetting.getAppId())) == true) goto L15;
            boolean canQuery = AppsFilterUtils.canQueryViaComponents(setting.getPkg(), otherSetting.getPkg(), this.mProtectedBroadcasts);
            if (canQuery == false) goto L15;
            result.add(Integer.valueOf(otherSetting.getAppId()));
        L15:
            i = i - 1;
            goto L3
        L17:
            return result;
        }
    }

    AppsFilterUtils() {
    }

    public static boolean requestsQueryAllPackages(AndroidPackage pkg) {
        return pkg.getRequestedPermissions().contains("android.permission.QUERY_ALL_PACKAGES");
    }

    public static boolean canQueryViaComponents(AndroidPackage querying, AndroidPackage potentialTarget, WatchedArraySet<String> protectedBroadcasts) {
        if (querying.getQueriesIntents().isEmpty() == true) goto L12;
        Iterator r0 = querying.getQueriesIntents().iterator();
    L6:
        if (r0.hasNext() == false) goto L12;
        Intent intent = (Intent) r0.next();
        if (matchesPackage(intent, potentialTarget, protectedBroadcasts) == false) goto L6;
        return true;
    L12:
        if (querying.getQueriesProviders().isEmpty() == false) goto L14;
        return false;
    L14:
        if (matchesProviders(querying.getQueriesProviders(), potentialTarget) == false) goto L21;
        return true;
    L21:
        return false;
    }

    public static boolean canQueryViaPackage(AndroidPackage querying, AndroidPackage potentialTarget) {
        if (querying.getQueriesPackages().isEmpty() == false) goto L5;
    L7:
        return false;
    L5:
        if (querying.getQueriesPackages().contains(potentialTarget.getPackageName()) == false) goto L7;
        return true;
    }

    public static boolean canQueryAsInstaller(PackageStateInternal querying, AndroidPackage potentialTarget) {
        InstallSource installSource = querying.getInstallSource();
        if (potentialTarget.getPackageName().equals(installSource.mInstallerPackageName) == false) goto L6;
        return true;
    L6:
        if (installSource.mIsInitiatingPackageUninstalled == false) goto L8;
        return false;
    L8:
        if (potentialTarget.getPackageName().equals(installSource.mInitiatingPackageName) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public static boolean canQueryAsUpdateOwner(PackageStateInternal querying, AndroidPackage potentialTarget) {
        InstallSource installSource = querying.getInstallSource();
        if (potentialTarget.getPackageName().equals(installSource.mUpdateOwnerPackageName) == false) goto L6;
        return true;
    L6:
        return false;
    }

    public static boolean canQueryViaUsesLibrary(AndroidPackage querying, AndroidPackage potentialTarget) {
        if (potentialTarget.getLibraryNames().isEmpty() == false) goto L5;
        return false;
    L5:
        List<String> libNames = potentialTarget.getLibraryNames();
        int i = 0;
        int size = libNames.size();
    L6:
        if (i >= size) goto L16;
        String libName = libNames.get(i);
        if (querying.getUsesLibraries().contains(libName) == true) goto L13;
        if (querying.getUsesOptionalLibraries().contains(libName) == true) goto L20;
        i = i + 1;
        goto L6
    L20:
        return true;
    L13:
        return true;
    L16:
        return false;
    }

    private static boolean matchesProviders(Set<String> queriesAuthorities, AndroidPackage potentialTarget) {
        int p = ArrayUtils.size(potentialTarget.getProviders()) - 1;
    L4:
        if (p < 0) goto L19;
        ParsedProvider provider = (ParsedProvider) potentialTarget.getProviders().get(p);
        if (provider.isExported() == false) goto L17;
        if (provider.getAuthority() == null) goto L17;
        StringTokenizer authorities = new StringTokenizer(provider.getAuthority(), ";", false);
    L13:
        if (authorities.hasMoreElements() == false) goto L17;
        if (queriesAuthorities.contains(authorities.nextToken()) == false) goto L13;
        return true;
    L17:
        p = p - 1;
        goto L4
    L19:
        return false;
    }

    private static boolean matchesPackage(Intent intent, AndroidPackage potentialTarget, WatchedArraySet<String> protectedBroadcasts) {
        if (matchesAnyComponents(intent, potentialTarget.getServices(), null) == false) goto L6;
        return true;
    L6:
        if (matchesAnyComponents(intent, potentialTarget.getActivities(), null) == false) goto L9;
        return true;
    L9:
        if (matchesAnyComponents(intent, potentialTarget.getReceivers(), protectedBroadcasts) == false) goto L12;
        return true;
    L12:
        if (matchesAnyComponents(intent, potentialTarget.getProviders(), null) == false) goto L14;
        return true;
    L14:
        return false;
    }

    private static boolean matchesAnyComponents(Intent intent, List<? extends ParsedMainComponent> components, WatchedArraySet<String> protectedBroadcasts) {
        int i = ArrayUtils.size(components) - 1;
    L3:
        if (i < 0) goto L11;
        ParsedMainComponent component = components.get(i);
        if (component.isExported() == false) goto L10;
        if (matchesAnyFilter(intent, component, protectedBroadcasts) == false) goto L10;
        return true;
    L10:
        i = i - 1;
        goto L3
    L11:
        return false;
    }

    private static boolean matchesAnyFilter(Intent intent, ParsedComponent component, WatchedArraySet<String> protectedBroadcasts) {
        List<ParsedIntentInfo> intents = component.getIntents();
        int i = ArrayUtils.size(intents) - 1;
    L3:
        if (i < 0) goto L8;
        IntentFilter intentFilter = intents.get(i).getIntentFilter();
        if (matchesIntentFilter(intent, intentFilter, protectedBroadcasts) == true) goto L6;
        i = i - 1;
        goto L3
    L6:
        return true;
    L8:
        return false;
    }

    private static boolean matchesIntentFilter(Intent intent, IntentFilter intentFilter, WatchedArraySet<String> protectedBroadcasts) {
        String r1 = intent.getAction();
        String r2 = intent.getType();
        String r3 = intent.getScheme();
        Uri r4 = intent.getData();
        Set<String> r5 = intent.getCategories();
        if (protectedBroadcasts == null) goto L6;
        ArraySet<String> r0 = protectedBroadcasts.untrackedStorage();
    L8:
        if (intentFilter.match(r1, r2, r3, r4, r5, "AppsFilter", true, r0) <= 0) goto L10;
        return true;
    L10:
        return false;
    L6:
        r0 = null;
        goto L8
    }
}
