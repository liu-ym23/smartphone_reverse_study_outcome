package com.android.server.am;

import android.app.IApplicationThread;
import android.content.ComponentName;
import android.os.RemoteException;
import android.os.UserHandle;
import android.util.SparseArray;
import com.android.internal.os.TransferPipe;
import com.android.internal.util.CollectionUtils;
import com.android.internal.util.DumpUtils;
import com.android.server.ISmtResourceControl;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes.dex */
public final class ProviderMap {
    private static final boolean DBG = false;
    private static final String TAG = "ProviderMap";
    private final ActivityManagerService mAm;
    private final SparseArray<HashMap<ComponentName, ContentProviderRecord>> mProvidersByClassPerUser;
    private final SparseArray<HashMap<String, ContentProviderRecord>> mProvidersByNamePerUser;
    private final HashMap<ComponentName, ContentProviderRecord> mSingletonByClass;
    private final HashMap<String, ContentProviderRecord> mSingletonByName;

    ProviderMap(ActivityManagerService am) {
        this.mSingletonByName = new HashMap();
        this.mSingletonByClass = new HashMap();
        this.mProvidersByNamePerUser = new SparseArray();
        this.mProvidersByClassPerUser = new SparseArray();
        this.mAm = am;
    }

    ContentProviderRecord getProviderByName(String name) {
        return getProviderByName(name, -1);
    }

    ContentProviderRecord getProviderByName(String name, int userId) {
        ContentProviderRecord record = this.mSingletonByName.get(name);
        if (record == null) goto L6;
        return record;
    L6:
        return getProvidersByName(userId).get(name);
    }

    ContentProviderRecord getProviderByClass(ComponentName name) {
        return getProviderByClass(name, -1);
    }

    ContentProviderRecord getProviderByClass(ComponentName name, int userId) {
        ContentProviderRecord record = this.mSingletonByClass.get(name);
        if (record == null) goto L6;
        return record;
    L6:
        return getProvidersByClass(userId).get(name);
    }

    void putProviderByName(String name, ContentProviderRecord record) {
        if (record.singleton == false) goto L5;
        this.mSingletonByName.put(name, record);
        return;
    L5:
        int userId = UserHandle.getUserId(record.appInfo.uid);
        getProvidersByName(userId).put(name, record);
    }

    void putProviderByClass(ComponentName name, ContentProviderRecord record) {
        if (record.singleton == false) goto L5;
        this.mSingletonByClass.put(name, record);
        return;
    L5:
        int userId = UserHandle.getUserId(record.appInfo.uid);
        getProvidersByClass(userId).put(name, record);
    }

    void removeProviderByName(String name, int userId) {
        if (this.mSingletonByName.containsKey(name) == false) goto L5;
        this.mSingletonByName.remove(name);
        return;
    L5:
        if (userId < 0) goto L11;
        HashMap<String, ContentProviderRecord> map = getProvidersByName(userId);
        map.remove(name);
        if (map.size() != 0) goto L13;
        this.mProvidersByNamePerUser.remove(userId);
        return;
    L13:
        return;
    L11:
        throw new IllegalArgumentException("Bad user " + userId);
    }

    void removeProviderByClass(ComponentName name, int userId) {
        if (this.mSingletonByClass.containsKey(name) == false) goto L5;
        this.mSingletonByClass.remove(name);
        return;
    L5:
        if (userId < 0) goto L11;
        HashMap<ComponentName, ContentProviderRecord> map = getProvidersByClass(userId);
        map.remove(name);
        if (map.size() != 0) goto L13;
        this.mProvidersByClassPerUser.remove(userId);
        return;
    L13:
        return;
    L11:
        throw new IllegalArgumentException("Bad user " + userId);
    }

    private HashMap<String, ContentProviderRecord> getProvidersByName(int userId) {
        if (userId < 0) goto L9;
        HashMap<String, ContentProviderRecord> map = this.mProvidersByNamePerUser.get(userId);
        if (map != null) goto L7;
        HashMap<String, ContentProviderRecord> newMap = new HashMap();
        this.mProvidersByNamePerUser.put(userId, newMap);
        return newMap;
    L7:
        return map;
    L9:
        throw new IllegalArgumentException("Bad user " + userId);
    }

    HashMap<ComponentName, ContentProviderRecord> getProvidersByClass(int userId) {
        if (userId < 0) goto L9;
        HashMap<ComponentName, ContentProviderRecord> map = this.mProvidersByClassPerUser.get(userId);
        if (map != null) goto L7;
        HashMap<ComponentName, ContentProviderRecord> newMap = new HashMap();
        this.mProvidersByClassPerUser.put(userId, newMap);
        return newMap;
    L7:
        return map;
    L9:
        throw new IllegalArgumentException("Bad user " + userId);
    }

    private boolean collectPackageProvidersLocked(String packageName, Set<String> filterByClasses, boolean doit, boolean evenPersistent, HashMap<ComponentName, ContentProviderRecord> providers, ArrayList<ContentProviderRecord> result) {
        boolean didSomething = false;
        Iterator<ContentProviderRecord> r1 = providers.values().iterator();
    L4:
        if (r1.hasNext() == false) goto L26;
        ContentProviderRecord provider = r1.next();
        if (packageName != null) goto L8;
    L14:
        boolean sameComponent = true;
    L16:
        if (sameComponent == false) goto L4;
        if (provider.proc == null) goto L22;
        if (evenPersistent == true) goto L22;
        if (provider.proc.isPersistent() == true) goto L4;
    L22:
        if (doit == false) goto L23;
        didSomething = true;
        result.add(provider);
        goto L4
    L23:
        return true;
    L8:
        if (provider.info.packageName.equals(packageName) == false) goto L13;
        if (filterByClasses == null) goto L14;
        if (filterByClasses.contains(provider.name.getClassName()) == true) goto L14;
    L13:
        sameComponent = false;
        goto L16
    L26:
        return didSomething;
    }

    boolean collectPackageProvidersLocked(String packageName, Set<String> filterByClasses, boolean doit, boolean evenPersistent, int userId, ArrayList<ContentProviderRecord> result) {
        boolean didSomething = false;
        if (userId == (-1)) goto L7;
        if (userId == 0) goto L7;
        ProviderMap r2 = this;
        String packageName2 = packageName;
        Set<String> filterByClasses2 = filterByClasses;
        boolean doit2 = doit;
        boolean evenPersistent2 = evenPersistent;
        ArrayList<ContentProviderRecord> result2 = result;
    L9:
        if (doit2 == true) goto L12;
        if (didSomething == false) goto L12;
        return true;
    L12:
        if (userId != (-1)) goto L23;
        int i = 0;
    L15:
        if (i >= r2.mProvidersByClassPerUser.size()) goto L32;
        if (r2.collectPackageProvidersLocked(packageName2, filterByClasses2, doit2, evenPersistent2, r2.mProvidersByClassPerUser.valueAt(i), result2) == false) goto L21;
        if (doit2 == false) goto L19;
        didSomething = true;
        goto L21
    L19:
        return true;
    L21:
        i = i + 1;
        goto L15
    L32:
        return didSomething;
    L23:
        HashMap<ComponentName, ContentProviderRecord> items = getProvidersByClass(userId);
        if (items != null) goto L26;
        return didSomething;
    L26:
        return didSomething | r2.collectPackageProvidersLocked(packageName2, filterByClasses2, doit2, evenPersistent2, items, result2);
    L7:
        r2 = this;
        packageName2 = packageName;
        filterByClasses2 = filterByClasses;
        doit2 = doit;
        evenPersistent2 = evenPersistent;
        result2 = result;
        didSomething = r2.collectPackageProvidersLocked(packageName2, filterByClasses2, doit2, evenPersistent2, this.mSingletonByClass, result2);
        goto L9
    }

    private boolean dumpProvidersByClassLocked(PrintWriter pw, boolean dumpAll, String dumpPackage, String header, boolean needSep, HashMap<ComponentName, ContentProviderRecord> map) {
        Iterator<Map.Entry<ComponentName, ContentProviderRecord>> it = map.entrySet().iterator();
        boolean written = false;
    L4:
        if (it.hasNext() == false) goto L15;
        Map.Entry<ComponentName, ContentProviderRecord> e = it.next();
        ContentProviderRecord r = e.getValue();
        if (dumpPackage == null) goto L10;
        if (dumpPackage.equals(r.appInfo.packageName) == false) goto L4;
    L10:
        if (needSep == false) goto L12;
        pw.println("");
        needSep = false;
    L12:
        if (header == null) goto L14;
        pw.println(header);
        header = null;
    L14:
        written = true;
        pw.print("  * ");
        pw.println(r);
        r.dump(pw, "    ", dumpAll);
        goto L4
    L15:
        return written;
    }

    private boolean dumpProvidersByNameLocked(PrintWriter pw, String dumpPackage, String header, boolean needSep, HashMap<String, ContentProviderRecord> map) {
        Iterator<Map.Entry<String, ContentProviderRecord>> it = map.entrySet().iterator();
        boolean written = false;
    L4:
        if (it.hasNext() == false) goto L15;
        Map.Entry<String, ContentProviderRecord> e = it.next();
        ContentProviderRecord r = e.getValue();
        if (dumpPackage == null) goto L10;
        if (dumpPackage.equals(r.appInfo.packageName) == false) goto L4;
    L10:
        if (needSep == false) goto L12;
        pw.println("");
        needSep = false;
    L12:
        if (header == null) goto L14;
        pw.println(header);
        header = null;
    L14:
        written = true;
        pw.print("  ");
        pw.print(e.getKey());
        pw.print(": ");
        pw.println(r.toShortString());
        goto L4
    L15:
        return written;
    }

    boolean dumpProvidersLocked(PrintWriter pw, boolean dumpAll, String dumpPackage) {
        boolean needSep = false;
        if (this.mSingletonByClass.size() <= 0) goto L5;
        needSep = false | dumpProvidersByClassLocked(pw, dumpAll, dumpPackage, "  Published single-user content providers (by class):", false, this.mSingletonByClass);
    L5:
        int i = 0;
        boolean needSep2 = needSep;
    L7:
        if (i >= this.mProvidersByClassPerUser.size()) goto L9;
        HashMap<ComponentName, ContentProviderRecord> map = this.mProvidersByClassPerUser.valueAt(i);
        boolean needSep3 = needSep2;
        needSep2 = dumpProvidersByClassLocked(pw, dumpAll, dumpPackage, "  Published user " + this.mProvidersByClassPerUser.keyAt(i) + " content providers (by class):", needSep3, map) | needSep3;
        i = i + 1;
        goto L7
    L9:
        boolean needSep4 = needSep2;
        if (dumpAll == false) goto L16;
        boolean needSep5 = needSep4 | dumpProvidersByNameLocked(pw, dumpPackage, "  Single-user authority to provider mappings:", needSep4, this.mSingletonByName);
        int i2 = 0;
    L13:
        if (i2 >= this.mProvidersByNamePerUser.size()) goto L19;
        needSep5 = needSep5 | dumpProvidersByNameLocked(pw, dumpPackage, "  User " + this.mProvidersByNamePerUser.keyAt(i2) + " authority to provider mappings:", needSep5, this.mProvidersByNamePerUser.valueAt(i2));
        i2 = i2 + 1;
        goto L13
    L19:
        return needSep5;
    L16:
        return needSep4;
    }

    private ArrayList<ContentProviderRecord> getProvidersForName(String name) {
        ArrayList<ContentProviderRecord> allProviders = new ArrayList();
        ArrayList<ContentProviderRecord> ret = new ArrayList();
        Predicate<ContentProviderRecord> filter = DumpUtils.filterRecord(name);
        ActivityManagerService r3 = this.mAm;
        ActivityManagerService.boostPriorityForLockedSection();
        monitor-enter(r3);
        allProviders.addAll(this.mSingletonByClass.values());     // Catch: Throwable -> L8
        int i = 0;
    L6:
        if (i >= this.mProvidersByClassPerUser.size()) goto L10;
        allProviders.addAll(this.mProvidersByClassPerUser.valueAt(i).values());     // Catch: Throwable -> L8
        i = i + 1;     // Catch: Throwable -> L8
        goto L6
    L10:
        CollectionUtils.addIf(allProviders, ret, filter);     // Catch: Throwable -> L8
        monitor-exit(r3);     // Catch: Throwable -> L8
        ActivityManagerService.resetPriorityAfterLockedSection();
        ret.sort(Comparator.comparing(new ProviderMap$$ExternalSyntheticLambda0()));
        return ret;
    L8:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    protected boolean dumpProvider(FileDescriptor fd, PrintWriter pw, String name, String[] args, int opti, boolean dumpAll) {
        this.mAm.mOomAdjuster.mCachedAppOptimizer.enableFreezer(false);     // Catch: Throwable -> L12
        ArrayList<ContentProviderRecord> providers = getProvidersForName(name);     // Catch: Throwable -> L12
        if (providers.size() > 0) goto L7;
        this.mAm.mOomAdjuster.mCachedAppOptimizer.enableFreezer(true);
        return false;
    L7:
        boolean needSep = false;
        int i = 0;
    L8:
        if (i >= providers.size()) goto L16;
        if (needSep == false) goto L14;
        pw.println();     // Catch: Throwable -> L12
    L14:
        needSep = true;
        dumpProvider("", fd, pw, providers.get(i), args, dumpAll);     // Catch: Throwable -> L12
        i = i + 1;
        goto L8
    L16:
        this.mAm.mOomAdjuster.mCachedAppOptimizer.enableFreezer(true);
        return true;
    L12:
        th = move-exception;
        this.mAm.mOomAdjuster.mCachedAppOptimizer.enableFreezer(true);
        throw th;
    }

    private void dumpProvider(String prefix, FileDescriptor fd, PrintWriter pw, ContentProviderRecord r, String[] args, boolean dumpAll) {
        if (r.proc == null) goto L5;
        IApplicationThread r0 = r.proc.getThread();
    L6:
        IApplicationThread thread = r0;
        int r1 = args.length;
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L17;
        String s = args[r2];
        if (dumpAll == true) goto L16;
        if (s.contains("--proto") == false) goto L16;
        if (thread == null) goto L15;
        dumpToTransferPipe(null, fd, pw, r, thread, args);
        return;
    L15:
        return;
    L16:
        r2 = r2 + 1;
        fd = fd;
        pw = pw;
        r = r;
        args = args;
        goto L7
    L17:
        FileDescriptor fd2 = fd;
        PrintWriter pw2 = pw;
        ContentProviderRecord r3 = r;
        String[] args2 = args;
        String innerPrefix = prefix + "  ";
        ActivityManagerService r13 = this.mAm;
        ActivityManagerService.boostPriorityForLockedSection();
        monitor-enter(r13);
        pw2.print(prefix);     // Catch: Throwable -> L22
        pw2.print("PROVIDER ");     // Catch: Throwable -> L22
        pw2.print(r3);     // Catch: Throwable -> L22
        pw2.print(" pid=");     // Catch: Throwable -> L22
        if (r3.proc == null) goto L24;
        pw2.println(r3.proc.getPid());     // Catch: Throwable -> L22
    L25:
        if (dumpAll == false) goto L27;
        r3.dump(pw2, innerPrefix, true);     // Catch: Throwable -> L22
    L27:
        monitor-exit(r13);     // Catch: Throwable -> L22
        ActivityManagerService.resetPriorityAfterLockedSection();
        if (thread == null) goto L42;
        pw2.println("    Client:");
        pw2.flush();
        dumpToTransferPipe("      ", fd2, pw2, r3, thread, args2);
        return;
    L42:
        return;
    L24:
        pw2.println("(not running)");     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterLockedSection();
        throw th;
    L5:
        r0 = null;
        goto L6
    }

    protected boolean dumpProviderProto(FileDescriptor fd, PrintWriter pw, String name, String[] args) {
        String[] newArgs = (String[]) Arrays.copyOf(args, args.length + 1);
        newArgs[args.length] = "--proto";
        ArrayList<ContentProviderRecord> providers = getProvidersForName(name);
        if (providers.size() > 0) goto L5;
        return false;
    L5:
        int i = 0;
    L7:
        if (i >= providers.size()) goto L18;
        ContentProviderRecord r = providers.get(i);
        if (r.proc == null) goto L16;
        IApplicationThread thread = r.proc.getThread();
        if (thread == null) goto L16;
        dumpToTransferPipe(null, fd, pw, r, thread, newArgs);
        return true;
    L16:
        i = i + 1;
        fd = fd;
        pw = pw;
        goto L7
    L18:
        return false;
    }

    private void dumpToTransferPipe(String prefix, FileDescriptor fd, PrintWriter pw, ContentProviderRecord r, IApplicationThread thread, String[] args) {
        TransferPipe tp = new TransferPipe();     // Catch: RemoteException -> L6 IOException -> L8
        thread.dumpProvider(tp.getWriteFd(), r.provider.asBinder(), args);     // Catch: Throwable -> L10
        tp.setBufferPrefix(prefix);     // Catch: Throwable -> L10
        tp.go(fd, ISmtResourceControl.LAUNCH_CPUSET_EFFECTIVE_TIME);     // Catch: Throwable -> L10
        tp.kill();     // Catch: RemoteException -> L6 IOException -> L8
    L15:
        return;
    L10:
        th = move-exception;
        tp.kill();     // Catch: RemoteException -> L6 IOException -> L8
        throw th;     // Catch: RemoteException -> L6 IOException -> L8
    L8:
        ex = move-exception;
        pw.println("      Failure while dumping the provider: " + ex);
    L13:
        pw.println("      Got a RemoteException while dumping the service");
    }
}
