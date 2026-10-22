package com.android.server.pm;

import android.app.ActivityManager;
import android.app.ActivityManagerInternal;
import android.app.ActivityThread;
import android.app.usage.NetworkStats;
import android.app.usage.NetworkStatsManager;
import android.content.Context;
import android.content.pm.IPackageManager;
import android.content.pm.PackageManagerInternal;
import android.media.AudioFocusInfo;
import android.media.AudioManager;
import android.media.AudioRecordingConfiguration;
import android.media.IAudioService;
import android.os.ServiceManager;
import android.os.SystemProperties;
import android.telecom.TelecomManager;
import android.text.TextUtils;
import android.util.ArraySet;
import com.android.internal.pm.parsing.pkg.AndroidPackageInternal;
import com.android.internal.util.ArrayUtils;
import com.android.server.LocalServices;
import com.android.server.pm.pkg.AndroidPackage;
import com.android.server.pm.pkg.PackageStateInternal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class AppStateHelper {
    private static final long ACTIVE_NETWORK_DURATION_MILLIS = 0;
    private final Context mContext;

    /* JADX INFO: renamed from: $r8$lambda$8B_hj9B1hv-457DfjQiyoDndm2U, reason: not valid java name */
    public static /* synthetic */ void m6600$r8$lambda$8B_hj9B1hv457DfjQiyoDndm2U(ArrayList r0, ArrayList r1, ArrayList r2, ArraySet r3, PackageStateInternal r4) {
        lambda$addLibraryDependency$0(r0, r1, r2, r3, r4);
    }

    static {
        ACTIVE_NETWORK_DURATION_MILLIS = TimeUnit.MINUTES.toMillis(10);
    }

    public AppStateHelper(Context context) {
        this.mContext = context;
    }

    private static boolean isPackageLoaded(ActivityManager.RunningAppProcessInfo info, String packageName) {
        if (ArrayUtils.contains(info.pkgList, packageName) == false) goto L5;
    L8:
        return true;
    L5:
        if (ArrayUtils.contains(info.pkgDeps, packageName) == true) goto L8;
        return false;
    }

    private int getImportance(String packageName) {
        ActivityManager am = (ActivityManager) this.mContext.getSystemService(ActivityManager.class);
        return am.getPackageImportance(packageName);
    }

    private boolean hasAudioFocus(String packageName) {
        IAudioService audioService = IAudioService.Stub.asInterface(ServiceManager.getService("audio"));
        List<AudioFocusInfo> focusInfos = audioService.getFocusStack();     // Catch: Exception -> L6
        int size = focusInfos.size();     // Catch: Exception -> L6
        if (size <= 0) goto L8;
        String audioFocusPackage = focusInfos.get(size - 1).getPackageName();     // Catch: Exception -> L6
    L9:
        return TextUtils.equals(packageName, audioFocusPackage);
    L8:
        audioFocusPackage = null;
    L11:
        return false;
    }

    private boolean hasVoiceCall() {
        AudioManager am = (AudioManager) this.mContext.getSystemService(AudioManager.class);
        int audioMode = am.getMode();     // Catch: Exception -> L10
        if (audioMode != 2) goto L7;
    L8:
        return true;
    L7:
        if (audioMode == 3) goto L8;
        return false;
    L11:
        return false;
    }

    private boolean isRecordingAudio(String packageName) {
        AudioManager am = (AudioManager) this.mContext.getSystemService(AudioManager.class);
        Iterator<AudioRecordingConfiguration> r1 = am.getActiveRecordingConfigurations().iterator();     // Catch: Exception -> L11
    L5:
        if (r1.hasNext() == false) goto L21;
        AudioRecordingConfiguration arc = r1.next();     // Catch: Exception -> L11
        if (TextUtils.equals(arc.getClientPackageName(), packageName) == false) goto L5;
        return true;
    L21:
        return false;
    L14:
        return false;
    }

    private boolean isAppForeground(String packageName) {
        if (getImportance(packageName) > 125) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isAppTopVisible(String packageName) {
        if (getImportance(packageName) > 100) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean hasActiveAudio(String packageName) {
        if (hasAudioFocus(packageName) == false) goto L5;
    L8:
        return true;
    L5:
        if (isRecordingAudio(packageName) == true) goto L8;
        return false;
    }

    private boolean hasActiveNetwork(List<String> packageNames, int networkType) {
        IPackageManager pm = ActivityThread.getPackageManager();
        NetworkStatsManager nsm = (NetworkStatsManager) this.mContext.getSystemService(NetworkStatsManager.class);
        long endTime = System.currentTimeMillis();
        long startTime = endTime - ACTIVE_NETWORK_DURATION_MILLIS;
        NetworkStats stats = nsm.querySummary(networkType, null, startTime, endTime);     // Catch: Exception -> L22
        NetworkStats.Bucket bucket = new NetworkStats.Bucket();     // Catch: Throwable -> L17
    L6:
        if (stats.hasNextBucket() == false) goto L24;
        stats.getNextBucket(bucket);     // Catch: Throwable -> L17
        String packageName = pm.getNameForUid(bucket.getUid());     // Catch: Throwable -> L17
        if (packageNames.contains(packageName) == false) goto L6;
        if (bucket.getRxPackets() > 0) goto L20;
        goto L33
    L14:
        if (bucket.getTxPackets() <= 0) goto L6;
    L20:
        stats.close();     // Catch: Exception -> L22
        return true;
    L24:
        stats.close();     // Catch: Exception -> L22
        return false;
    L17:
        th = move-exception;
        if (stats == null) goto L48;
        stats.close();     // Catch: Throwable -> L29
        goto L33
    L49:
        throw th;     // Catch: Exception -> L22
    L29:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L22
        throw th;     // Catch: Exception -> L22
    L48:
        throw th;     // Catch: Exception -> L22
    L33:
        return false;
    }

    private static boolean containsAny(String[] arr, List<String> which) {
        int s1 = arr.length;
        int s2 = which.size();
        int i = 0;
        int j = 0;
    L3:
        if (i >= s1) goto L13;
        if (j >= s2) goto L23;
        int val = arr[i].compareTo(which.get(j));
        if (val == 0) goto L7;
        if (val < 0) goto L10;
        j = j + 1;
        goto L3
    L10:
        i = i + 1;
        goto L3
    L7:
        return true;
    L23:
        return false;
    L13:
        return false;
    }

    private void addLibraryDependency(final ArraySet<String> results, List<String> libPackageNames) {
        PackageManagerInternal pmInternal = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        final ArrayList<String> libraryNames = new ArrayList();
        final ArrayList<String> staticSharedLibraryNames = new ArrayList();
        final ArrayList<String> sdkLibraryNames = new ArrayList();
        Iterator<String> r4 = libPackageNames.iterator();
    L4:
        if (r4.hasNext() == false) goto L16;
        String packageName = r4.next();
        AndroidPackage pkg = pmInternal.getAndroidPackage(packageName);
        if (pkg == null) goto L4;
        libraryNames.addAll(pkg.getLibraryNames());
        String libraryName = pkg.getStaticSharedLibraryName();
        if (libraryName == null) goto L11;
        staticSharedLibraryNames.add(libraryName);
    L11:
        String libraryName2 = pkg.getSdkLibraryName();
        if (libraryName2 == null) goto L4;
        sdkLibraryNames.add(libraryName2);
        goto L4
    L16:
        if (libraryNames.isEmpty() == true) goto L18;
    L22:
        Collections.sort(libraryNames);
        Collections.sort(sdkLibraryNames);
        Collections.sort(staticSharedLibraryNames);
        pmInternal.forEachPackageState(new AppStateHelper$$ExternalSyntheticLambda0(libraryNames, staticSharedLibraryNames, sdkLibraryNames, results));
        return;
    L18:
        if (staticSharedLibraryNames.isEmpty() == false) goto L22;
        if (sdkLibraryNames.isEmpty() == false) goto L22;
    }

    private static /* synthetic */ void lambda$addLibraryDependency$0(ArrayList libraryNames, ArrayList staticSharedLibraryNames, ArrayList sdkLibraryNames, ArraySet results, PackageStateInternal pkgState) {
        AndroidPackageInternal pkg = pkgState.getPkg();
        if (pkg != null) goto L6;
        return;
    L6:
        if (containsAny(pkg.getUsesLibrariesSorted(), libraryNames) == false) goto L8;
    L13:
        results.add(pkg.getPackageName());
        return;
    L8:
        if (containsAny(pkg.getUsesOptionalLibrariesSorted(), libraryNames) == true) goto L13;
        if (containsAny(pkg.getUsesStaticLibrariesSorted(), staticSharedLibraryNames) == true) goto L13;
        if (containsAny(pkg.getUsesSdkLibrariesSorted(), sdkLibraryNames) == true) goto L13;
    }

    private boolean hasActiveNetwork(List<String> packageNames) {
        if (hasActiveNetwork(packageNames, 1) == false) goto L5;
        return true;
    L5:
        if (hasActiveNetwork(packageNames, 0) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public boolean hasInteractingApp(List<String> packageNames) {
        Iterator<String> r0 = packageNames.iterator();
    L4:
        if (r0.hasNext() == false) goto L14;
        String packageName = r0.next();
        if (hasActiveAudio(packageName) == true) goto L11;
        if (isAppTopVisible(packageName) == false) goto L4;
        return true;
    L11:
        return true;
    L14:
        return hasActiveNetwork(packageNames);
    }

    public boolean hasForegroundApp(List<String> packageNames) {
        Iterator<String> r0 = packageNames.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        String packageName = r0.next();
        if (isAppForeground(packageName) == false) goto L4;
        return true;
    L10:
        return false;
    }

    public boolean hasTopVisibleApp(List<String> packageNames) {
        Iterator<String> r0 = packageNames.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        String packageName = r0.next();
        if (isAppTopVisible(packageName) == false) goto L4;
        return true;
    L10:
        return false;
    }

    public boolean isInCall() {
        if (SystemProperties.getBoolean("debug.pm.gentle_update_test.is_in_call", false) == false) goto L5;
        return true;
    L5:
        TelecomManager tm = (TelecomManager) this.mContext.getSystemService(TelecomManager.class);
        if (tm.isInCall() == true) goto L10;
        if (hasVoiceCall() == true) goto L10;
        return false;
    L10:
        return true;
    }

    public List<String> getDependencyPackages(List<String> packageNames) {
        ArraySet<String> results = new ArraySet();
        ActivityManager am = (ActivityManager) this.mContext.getSystemService(ActivityManager.class);
        Iterator<ActivityManager.RunningAppProcessInfo> r2 = am.getRunningAppProcesses().iterator();
    L4:
        if (r2.hasNext() == false) goto L17;
        ActivityManager.RunningAppProcessInfo info = r2.next();
        Iterator<String> r4 = packageNames.iterator();
    L7:
        if (r4.hasNext() == false) goto L4;
        String packageName = r4.next();
        if (isPackageLoaded(info, packageName) == false) goto L7;
        String[] r6 = info.pkgList;
        int r7 = r6.length;
        int r8 = 0;
    L13:
        if (r8 >= r7) goto L7;
        String pkg = r6[r8];
        results.add(pkg);
        r8 = r8 + 1;
        goto L13
    L17:
        ActivityManagerInternal amInternal = (ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class);
        Iterator<String> r3 = packageNames.iterator();
    L19:
        if (r3.hasNext() == false) goto L21;
        String packageName2 = r3.next();
        results.addAll(amInternal.getClientPackages(packageName2));
        goto L19
    L21:
        addLibraryDependency(results, packageNames);
        return new ArrayList(results);
    }
}
