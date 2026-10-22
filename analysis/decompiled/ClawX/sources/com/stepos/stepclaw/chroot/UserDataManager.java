package com.stepos.stepclaw.chroot;

import a8.b;
import android.content.Context;
import android.system.ErrnoException;
import android.system.Os;
import android.system.StructStat;
import android.util.Log;
import b5.g;
import c5.n;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.runtime.OpenClawRuntimeConfig;
import com.stepos.stepclaw.runtime.ShellCommandResult;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import p5.l;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 ,2\u00020\u0001:\u0001,B_\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0018\u0010\n\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0004\u0012\u00020\t0\u0006\u0012\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b0\u0006\u0012\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0015\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0018\u0010\u0017J\u001f\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010\u001f\u001a\u00020\u001c¢\u0006\u0004\b\u001f\u0010 J\r\u0010!\u001a\u00020\u000b¢\u0006\u0004\b!\u0010\u0017J\r\u0010\"\u001a\u00020\u001c¢\u0006\u0004\b\"\u0010 J\r\u0010#\u001a\u00020\u000b¢\u0006\u0004\b#\u0010\u0017J\r\u0010$\u001a\u00020\u000b¢\u0006\u0004\b$\u0010\u0017J\r\u0010%\u001a\u00020\u001c¢\u0006\u0004\b%\u0010 R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010&R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010'R&\u0010\n\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0004\u0012\u00020\t0\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010(R \u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b0\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010(R\"\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010(R\u0014\u0010+\u001a\u00020\u00198BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*¨\u0006-"}, d2 = {"Lcom/stepos/stepclaw/chroot/UserDataManager;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Landroid/content/Context;", "context", "Lcom/stepos/stepclaw/runtime/OpenClawRuntimeConfig;", "runtimeConfig", "Lkotlin/Function1;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lcom/stepos/stepclaw/runtime/ShellCommandResult;", "commandRunner", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "mountChecker", "pathIdentityProvider", "<init>", "(Landroid/content/Context;Lcom/stepos/stepclaw/runtime/OpenClawRuntimeConfig;Lp5/l;Lp5/l;Lp5/l;)V", "requireFreshDoneSignal", "waitForMountDone", "(Z)Z", "readMountDoneProperty", "()Ljava/lang/String;", "readMountProperty", "hasAnyMountedPath", "()Z", "requestSystemUnmount", "Ljava/io/File;", "src", "dst", "Lb5/a0;", "copyDir", "(Ljava/io/File;Ljava/io/File;)V", "ensureDirectories", "()V", "needsSeedFromRootfs", "seedFromRootfs", "requestBindMounts", "verifyBindMounts", "unmountAll", "Landroid/content/Context;", "Lcom/stepos/stepclaw/runtime/OpenClawRuntimeConfig;", "Lp5/l;", "getUserDataRoot", "()Ljava/io/File;", "userDataRoot", "Companion", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class UserDataManager {
    private static final String GETPROP_BIN = "/system/bin/getprop";
    private static final String MOUNT_DONE_PROP = "sys.openclaw.userdata.mount.done";
    private static final long MOUNT_POLL_MS = 200;
    private static final String MOUNT_PROP = "sys.openclaw.userdata.mount";
    private static final long MOUNT_TIMEOUT_MS = 10000;
    private static final String PROC_MOUNTS = "/proc/mounts";
    private static final String SETPROP_BIN = "/system/bin/setprop";
    private static final String TAG = "UserDataManager";
    private final l commandRunner;
    private final Context context;
    private final l mountChecker;
    private final l pathIdentityProvider;
    private final OpenClawRuntimeConfig runtimeConfig;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final List<g> BIND_MOUNT_DIRS = n.k0(new g("agents", "root/.openclaw/agents"), new g("workspace", "root/.openclaw/workspace"), new g("memory", "root/.openclaw/memory"), new g("cron", "root/.openclaw/cron"), new g("identity", "root/.openclaw/identity"), new g("credentials", "root/.openclaw/credentials"));
    private static final List<String> SKELETON_DIRS = n.k0("config", "agents", "workspace", "memory", "cron", "identity", "credentials");
    private static final List<g> SEED_DIRS = n.k0(new g("root/.openclaw/agents", "agents"), new g("root/.openclaw/workspace", "workspace"), new g("root/.openclaw/memory", "memory"), new g("root/.openclaw/cron", "cron"), new g("root/.openclaw/identity", "identity"), new g("root/.openclaw/credentials", "credentials"));

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.stepclaw.chroot.UserDataManager$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends kotlin.jvm.internal.n implements l {
        public AnonymousClass1(Object obj) {
            super(1, obj, Companion.class, "defaultMountChecker", "defaultMountChecker(Ljava/lang/String;)Z", 0);
        }

        @Override // p5.l
        public final Boolean invoke(String p02) {
            p.e(p02, "p0");
            return Boolean.valueOf(((Companion) this.receiver).defaultMountChecker(p02));
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.stepclaw.chroot.UserDataManager$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends kotlin.jvm.internal.n implements l {
        public AnonymousClass2(Object obj) {
            super(1, obj, Companion.class, "defaultPathIdentity", "defaultPathIdentity(Ljava/lang/String;)Ljava/lang/String;", 0);
        }

        @Override // p5.l
        public final String invoke(String p02) {
            p.e(p02, "p0");
            return ((Companion) this.receiver).defaultPathIdentity(p02);
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\nR,\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\f0\u000b8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u000eR&\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\f0\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u000eR\u0014\u0010\u0015\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0012R\u0014\u0010\u0018\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0012R\u0014\u0010\u0019\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0012R\u0014\u0010\u001b\u001a\u00020\u001a8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001d\u0010\u001c¨\u0006\u001e"}, d2 = {"Lcom/stepos/stepclaw/chroot/UserDataManager$Companion;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "path", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "defaultMountChecker", "(Ljava/lang/String;)Z", "defaultPathIdentity", "(Ljava/lang/String;)Ljava/lang/String;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lb5/g;", "BIND_MOUNT_DIRS", "Ljava/util/List;", "getBIND_MOUNT_DIRS$step_runtime_release", "()Ljava/util/List;", "TAG", "Ljava/lang/String;", "SKELETON_DIRS", "SEED_DIRS", "SETPROP_BIN", "GETPROP_BIN", "MOUNT_PROP", "MOUNT_DONE_PROP", "PROC_MOUNTS", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "MOUNT_TIMEOUT_MS", "J", "MOUNT_POLL_MS", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean defaultMountChecker(String path) {
            try {
                ArrayList arrayListD0 = m5.l.D0(new File(UserDataManager.PROC_MOUNTS));
                if (arrayListD0.isEmpty()) {
                    return false;
                }
                int size = arrayListD0.size();
                int i8 = 0;
                while (i8 < size) {
                    Object obj = arrayListD0.get(i8);
                    i8++;
                    if (x5.n.g1((String) obj, path, false)) {
                        return true;
                    }
                }
                return false;
            } catch (Exception unused) {
                return false;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String defaultPathIdentity(String path) throws ErrnoException {
            try {
                StructStat structStatStat = Os.stat(path);
                return structStatStat.st_dev + ":" + structStatStat.st_ino + ":" + structStatStat.st_nlink;
            } catch (Exception unused) {
                return null;
            }
        }

        public final List<g> getBIND_MOUNT_DIRS$step_runtime_release() {
            return UserDataManager.BIND_MOUNT_DIRS;
        }

        private Companion() {
        }
    }

    public UserDataManager(Context context, OpenClawRuntimeConfig runtimeConfig, l commandRunner, l mountChecker, l pathIdentityProvider) {
        p.e(context, "context");
        p.e(runtimeConfig, "runtimeConfig");
        p.e(commandRunner, "commandRunner");
        p.e(mountChecker, "mountChecker");
        p.e(pathIdentityProvider, "pathIdentityProvider");
        this.context = context;
        this.runtimeConfig = runtimeConfig;
        this.commandRunner = commandRunner;
        this.mountChecker = mountChecker;
        this.pathIdentityProvider = pathIdentityProvider;
    }

    private final void copyDir(File src, File dst) throws IOException {
        this.runtimeConfig.getRootfsRoot().getAbsolutePath();
        if (src.isDirectory()) {
            dst.mkdirs();
            File[] fileArrListFiles = src.listFiles();
            if (fileArrListFiles != null) {
                for (File file : fileArrListFiles) {
                    if (!Files.isSymbolicLink(file.toPath())) {
                        File file2 = new File(dst, file.getName());
                        if (file.isDirectory()) {
                            copyDir(file, file2);
                        } else {
                            m5.l.y0(file, file2);
                        }
                    }
                }
            }
        }
    }

    private final File getUserDataRoot() {
        return new File(this.context.getFilesDir(), OpenClawRuntimeConfig.USER_DATA_SUBDIR);
    }

    private final boolean hasAnyMountedPath() {
        String absolutePath = this.runtimeConfig.getRootfsRoot().getAbsolutePath();
        List<g> list = BIND_MOUNT_DIRS;
        if (list != null && list.isEmpty()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            String str = (String) ((g) it.next()).f893b;
            if (((Boolean) this.mountChecker.invoke(absolutePath + "/" + str)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    private final String readMountDoneProperty() {
        try {
            return x5.n.T1(((ShellCommandResult) this.commandRunner.invoke(n.k0(GETPROP_BIN, MOUNT_DONE_PROP))).getStdout()).toString();
        } catch (Exception unused) {
            return SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        }
    }

    private final String readMountProperty() {
        try {
            return x5.n.T1(((ShellCommandResult) this.commandRunner.invoke(n.k0(GETPROP_BIN, MOUNT_PROP))).getStdout()).toString();
        } catch (Exception unused) {
            return SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        }
    }

    private final boolean requestSystemUnmount() throws InterruptedException {
        Log.i(TAG, "Requesting bind mount teardown via property trigger");
        try {
            if (!p.a(readMountProperty(), "1")) {
                this.commandRunner.invoke(n.k0(SETPROP_BIN, MOUNT_PROP, "1"));
                Thread.sleep(100L);
            }
            long jCurrentTimeMillis = System.currentTimeMillis() + 10000;
            while (System.currentTimeMillis() < jCurrentTimeMillis) {
                if (!hasAnyMountedPath()) {
                    Log.i(TAG, "Bind mount teardown completed");
                    return true;
                }
                try {
                    Thread.sleep(MOUNT_POLL_MS);
                } catch (InterruptedException unused) {
                }
            }
            Log.w(TAG, "Timed out waiting for bind mount teardown (10000ms)");
            return false;
        } catch (Exception e9) {
            Log.e(TAG, "Failed to clear mount property", e9);
            return false;
        }
    }

    private final boolean waitForMountDone(boolean requireFreshDoneSignal) throws InterruptedException {
        long jCurrentTimeMillis = System.currentTimeMillis() + 10000;
        boolean z = !requireFreshDoneSignal;
        while (System.currentTimeMillis() < jCurrentTimeMillis) {
            try {
                String mountDoneProperty = this.readMountDoneProperty();
                if (!p.a(mountDoneProperty, "1")) {
                    z = true;
                }
                if (p.a(mountDoneProperty, "1") && z) {
                    Log.i(TAG, "Bind mount property trigger completed");
                    return this.verifyBindMounts();
                }
            } catch (Exception unused) {
            }
            try {
                Thread.sleep(MOUNT_POLL_MS);
            } catch (InterruptedException unused2) {
            }
        }
        Log.e(TAG, "Timed out waiting for bind mount completion (10000ms)");
        return false;
    }

    public final void ensureDirectories() {
        Iterator<String> it = SKELETON_DIRS.iterator();
        while (it.hasNext()) {
            new File(getUserDataRoot(), it.next()).mkdirs();
        }
    }

    public final boolean needsSeedFromRootfs() {
        String[] list;
        Iterator<g> it = BIND_MOUNT_DIRS.iterator();
        while (it.hasNext()) {
            File file = new File(getUserDataRoot(), (String) it.next().f892a);
            if (!file.isDirectory() || (list = file.list()) == null || list.length == 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean requestBindMounts() throws InterruptedException {
        if (verifyBindMounts()) {
            Log.d(TAG, "Bind mounts already active, skipping request");
            return true;
        }
        boolean zA = p.a(readMountDoneProperty(), "1");
        if (hasAnyMountedPath()) {
            Log.w(TAG, "Detected stale bind mounts, asking system mount trigger to unmount before remount");
            requestSystemUnmount();
            zA = p.a(readMountDoneProperty(), "1");
        }
        Log.i(TAG, "Requesting bind mounts via property trigger");
        try {
            this.commandRunner.invoke(n.k0(SETPROP_BIN, MOUNT_PROP, "0"));
            Thread.sleep(100L);
            return waitForMountDone(zA);
        } catch (Exception e9) {
            Log.e(TAG, "Failed to set mount property", e9);
            return false;
        }
    }

    public final void seedFromRootfs() throws IOException {
        OpenClawRuntimeConfig openClawRuntimeConfig = this.runtimeConfig;
        File fileResolveRootfsPath = openClawRuntimeConfig.resolveRootfsPath(openClawRuntimeConfig.getStateRootRelativePath());
        if (!fileResolveRootfsPath.isDirectory()) {
            b.y("Rootfs stateDir does not exist, skipping seed: ", fileResolveRootfsPath.getAbsolutePath(), TAG);
            return;
        }
        for (g gVar : SEED_DIRS) {
            String str = (String) gVar.f892a;
            String str2 = (String) gVar.f893b;
            File fileResolveRootfsPath2 = this.runtimeConfig.resolveRootfsPath(str);
            if (fileResolveRootfsPath2.isDirectory()) {
                copyDir(fileResolveRootfsPath2, new File(getUserDataRoot(), str2));
            }
        }
        Log.i(TAG, "Seeded user-data from rootfs");
    }

    public final void unmountAll() throws InterruptedException {
        requestSystemUnmount();
    }

    public final boolean verifyBindMounts() {
        String absolutePath = this.runtimeConfig.getRootfsRoot().getAbsolutePath();
        for (g gVar : BIND_MOUNT_DIRS) {
            String str = (String) gVar.f892a;
            String strO = b.o(absolutePath, "/", (String) gVar.f893b);
            if (!((Boolean) this.mountChecker.invoke(strO)).booleanValue()) {
                Log.e(TAG, "Bind mount verification failed: " + strO);
                return false;
            }
            String absolutePath2 = new File(getUserDataRoot(), str).getAbsolutePath();
            l lVar = this.pathIdentityProvider;
            p.b(absolutePath2);
            String str2 = (String) lVar.invoke(absolutePath2);
            String str3 = (String) this.pathIdentityProvider.invoke(strO);
            if (str2 == null || str3 == null) {
                StringBuilder sbV = b.v("Bind mount verification failed: cannot stat path identity for ", strO, " (expected=", str2, " actual=");
                sbV.append(str3);
                sbV.append(" source=");
                sbV.append(absolutePath2);
                sbV.append(")");
                Log.e(TAG, sbV.toString());
                return false;
            }
            if (!str2.equals(str3)) {
                StringBuilder sbV2 = b.v("Bind mount verification failed: stale source for ", strO, " (expected=", str2, " actual=");
                sbV2.append(str3);
                sbV2.append(" source=");
                sbV2.append(absolutePath2);
                sbV2.append(")");
                Log.e(TAG, sbV2.toString());
                return false;
            }
        }
        return true;
    }

    public /* synthetic */ UserDataManager(Context context, OpenClawRuntimeConfig openClawRuntimeConfig, l lVar, l lVar2, l lVar3, int i8, i iVar) {
        this(context, openClawRuntimeConfig, lVar, (i8 & 8) != 0 ? new AnonymousClass1(INSTANCE) : lVar2, (i8 & 16) != 0 ? new AnonymousClass2(INSTANCE) : lVar3);
    }
}
