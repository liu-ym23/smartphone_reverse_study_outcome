package com.stepos.stepclaw.chroot;

import a6.z;
import a8.b;
import android.content.Context;
import android.util.Log;
import b5.a0;
import c5.m;
import c5.n;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.c;
import com.stepos.stepclaw.runtime.OpenClawRuntimeConfig;
import com.stepos.stepclaw.runtime.RuntimeShellCommandRunner;
import com.stepos.stepclaw.runtime.ShellCommandResult;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;
import k4.v;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import m0.f;
import p5.a;
import p5.l;
import p5.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\t\b\u0016\u0018\u0000 +2\u00020\u0001:\u0001+Bu\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u001a\b\u0002\u0010\n\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0004\u0012\u00020\t0\u0006\u0012\u001a\b\u0002\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b\u0012\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\r0\u0006\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\u0006\u0010\u0017\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u001b\u0010\u001e\u001a\u00020\r*\u00020\t2\u0006\u0010\u001d\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\r\u0010 \u001a\u00020\b¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\rH\u0016¢\u0006\u0004\b\"\u0010\u0016J\u000f\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b$\u0010%R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010&R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010'R&\u0010\n\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0004\u0012\u00020\t0\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010(R&\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010)R \u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\r0\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010(R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010*¨\u0006,"}, d2 = {"Lcom/stepos/stepclaw/chroot/OpenClawPackageInstaller;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Landroid/content/Context;", "context", "Lcom/stepos/stepclaw/runtime/OpenClawRuntimeConfig;", "runtimeConfig", "Lkotlin/Function1;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lcom/stepos/stepclaw/runtime/ShellCommandResult;", "commandRunner", "Lkotlin/Function2;", "Ljava/io/File;", "Lb5/a0;", "assetWriter", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "sleep", "Lkotlin/Function0;", "nowNs", "<init>", "(Landroid/content/Context;Lcom/stepos/stepclaw/runtime/OpenClawRuntimeConfig;Lp5/l;Lp5/p;Lp5/l;Lp5/a;)V", "verifyInstalled", "()V", "packageRoot", "missingInstalledPackagePaths", "(Ljava/io/File;)Ljava/util/List;", "name", "readProperty", "(Ljava/lang/String;)Ljava/lang/String;", "action", "requireSuccessOrThrow", "(Lcom/stepos/stepclaw/runtime/ShellCommandResult;Ljava/lang/String;)V", "releaseProfileId", "()Ljava/lang/String;", "installFromAssets", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "isInstalledPackageValid", "()Z", "Landroid/content/Context;", "Lcom/stepos/stepclaw/runtime/OpenClawRuntimeConfig;", "Lp5/l;", "Lp5/p;", "Lp5/a;", "Companion", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public class OpenClawPackageInstaller {
    private static final String GETPROP_BIN = "/system/bin/getprop";
    private static final long INSTALL_TIMEOUT_SEC = 1800;
    private static final String PACKAGE_ASSET = "openclaw/openclaw.tgz";
    private static final long POLL_INTERVAL_MS = 1000;
    public static final String PROP_DONE = "sys.openclaw.install.done";
    public static final String PROP_RUN = "sys.openclaw.install.run";
    public static final String PROP_TGZ = "persist.openclaw.install.tgz";
    private static final String RELEASE_PROFILE_ID = "stepclaw-android";
    private static final String SETPROP_BIN = "/system/bin/setprop";
    private static final String TAG = "OpenClawPackageInstaller";
    private static final String TMP_TGZ_IN_CHROOT = "/tmp/openclaw-stepclaw-release.tgz";
    private static final String TMP_TGZ_NAME = "openclaw-stepclaw-release.tgz";
    private final p assetWriter;
    private final l commandRunner;
    private final Context context;
    private final a nowNs;
    private final OpenClawRuntimeConfig runtimeConfig;
    private final l sleep;
    private static final List<String> REQUIRED_PACKAGE_LAYOUT_RELATIVE_PATHS = n.k0("package.json", "openclaw.mjs", "dist/postinstall-inventory.json", "dist/extensions/android-node/index.js", "dist/extensions/android-node/openclaw.plugin.json", "dist/extensions/stepclaw-intercept/index.js", "dist/extensions/stepclaw-intercept/openclaw.plugin.json", "dist/extensions/speech-core/package.json", "dist/extensions/speech-core/runtime-api.js");

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.stepclaw.chroot.OpenClawPackageInstaller$3, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass3 extends kotlin.jvm.internal.n implements l {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        public AnonymousClass3() {
            super(1, Thread.class, "sleep", "sleep(J)V", 0);
        }

        @Override // p5.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) throws InterruptedException {
            invoke(((Number) obj).longValue());
            return a0.f883a;
        }

        public final void invoke(long j4) throws InterruptedException {
            Thread.sleep(j4);
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.stepclaw.chroot.OpenClawPackageInstaller$4, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass4 extends kotlin.jvm.internal.n implements a {
        public static final AnonymousClass4 INSTANCE = new AnonymousClass4();

        public AnonymousClass4() {
            super(0, System.class, "nanoTime", "nanoTime()J", 0);
        }

        @Override // p5.a
        public final Long invoke() {
            return Long.valueOf(System.nanoTime());
        }
    }

    public OpenClawPackageInstaller(Context context, OpenClawRuntimeConfig runtimeConfig, l commandRunner, p assetWriter, l sleep, a nowNs) {
        kotlin.jvm.internal.p.e(context, "context");
        kotlin.jvm.internal.p.e(runtimeConfig, "runtimeConfig");
        kotlin.jvm.internal.p.e(commandRunner, "commandRunner");
        kotlin.jvm.internal.p.e(assetWriter, "assetWriter");
        kotlin.jvm.internal.p.e(sleep, "sleep");
        kotlin.jvm.internal.p.e(nowNs, "nowNs");
        this.context = context;
        this.runtimeConfig = runtimeConfig;
        this.commandRunner = commandRunner;
        this.assetWriter = assetWriter;
        this.sleep = sleep;
        this.nowNs = nowNs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ShellCommandResult _init_$lambda$0(List command) {
        kotlin.jvm.internal.p.e(command, "command");
        return RuntimeShellCommandRunner.INSTANCE.execute(command, 10L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a0 _init_$lambda$1(Context context, String asset, File dest) throws IOException {
        kotlin.jvm.internal.p.e(asset, "asset");
        kotlin.jvm.internal.p.e(dest, "dest");
        InputStream inputStreamOpen = context.getAssets().open(asset);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(dest);
            try {
                kotlin.jvm.internal.p.b(inputStreamOpen);
                v.u(inputStreamOpen, fileOutputStream);
                fileOutputStream.close();
                inputStreamOpen.close();
                return a0.f883a;
            } finally {
            }
        } finally {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0054  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.util.List<java.io.File> missingInstalledPackagePaths(java.io.File r7) {
        /*
            r6 = this;
            java.util.List<java.lang.String> r6 = com.stepos.stepclaw.chroot.OpenClawPackageInstaller.REQUIRED_PACKAGE_LAYOUT_RELATIVE_PATHS
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = 10
            int r1 = c5.o.n0(r6, r1)
            r0.<init>(r1)
            java.util.Iterator r6 = r6.iterator()
        L11:
            boolean r1 = r6.hasNext()
            if (r1 == 0) goto L86
            java.lang.Object r1 = r6.next()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r2 = "<this>"
            kotlin.jvm.internal.p.e(r7, r2)
            java.lang.String r2 = "relative"
            kotlin.jvm.internal.p.e(r1, r2)
            java.io.File r2 = new java.io.File
            r2.<init>(r1)
            java.lang.String r1 = r2.getPath()
            java.lang.String r3 = "getPath(...)"
            kotlin.jvm.internal.p.d(r1, r3)
            int r1 = k4.v.P(r1)
            if (r1 <= 0) goto L3c
            goto L82
        L3c:
            java.lang.String r1 = r7.toString()
            java.lang.String r3 = "toString(...)"
            kotlin.jvm.internal.p.d(r1, r3)
            int r3 = r1.length()
            if (r3 != 0) goto L4c
            goto L54
        L4c:
            char r3 = java.io.File.separatorChar
            boolean r4 = x5.n.l1(r1, r3)
            if (r4 == 0) goto L6a
        L54:
            java.io.File r3 = new java.io.File
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r1)
            r4.append(r2)
            java.lang.String r1 = r4.toString()
            r3.<init>(r1)
            r2 = r3
            goto L82
        L6a:
            java.io.File r4 = new java.io.File
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r1)
            r5.append(r3)
            r5.append(r2)
            java.lang.String r1 = r5.toString()
            r4.<init>(r1)
            r2 = r4
        L82:
            r0.add(r2)
            goto L11
        L86:
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            int r7 = r0.size()
            r1 = 0
        L90:
            if (r1 >= r7) goto La5
            java.lang.Object r2 = r0.get(r1)
            int r1 = r1 + 1
            r3 = r2
            java.io.File r3 = (java.io.File) r3
            boolean r3 = r3.isFile()
            if (r3 != 0) goto L90
            r6.add(r2)
            goto L90
        La5:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.chroot.OpenClawPackageInstaller.missingInstalledPackagePaths(java.io.File):java.util.List");
    }

    private final String readProperty(String name) {
        return x5.n.T1(((ShellCommandResult) this.commandRunner.invoke(n.k0(GETPROP_BIN, name))).getStdout()).toString();
    }

    private final void requireSuccessOrThrow(ShellCommandResult shellCommandResult, String str) {
        if (shellCommandResult.getExitCode() == 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        if (!x5.n.t1(shellCommandResult.getStderr())) {
            sb.append(shellCommandResult.getStderr());
        }
        if (!x5.n.t1(shellCommandResult.getStdout())) {
            if (sb.length() > 0) {
                sb.append(" | ");
            }
            sb.append(shellCommandResult.getStdout());
        }
        String string = sb.toString();
        if (x5.n.t1(string)) {
            string = b.j(shellCommandResult.getExitCode(), "exit=");
        }
        throw new IllegalStateException(b.p("Failed to ", str, ": ", string));
    }

    private final void verifyInstalled() {
        List<File> listMissingInstalledPackagePaths = missingInstalledPackagePaths(this.runtimeConfig.resolveRootfsPath("usr/local/lib/node_modules/openclaw"));
        if (!listMissingInstalledPackagePaths.isEmpty()) {
            throw new IllegalStateException(f.c("installation verification failed: missing ", m.A0(listMissingInstalledPackagePaths, null, null, null, new z(22), 31)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence verifyInstalled$lambda$0(File it) {
        kotlin.jvm.internal.p.e(it, "it");
        String absolutePath = it.getAbsolutePath();
        kotlin.jvm.internal.p.d(absolutePath, "getAbsolutePath(...)");
        return absolutePath;
    }

    public void installFromAssets() {
        File fileResolveRootfsPath = this.runtimeConfig.resolveRootfsPath("tmp/openclaw-stepclaw-release.tgz");
        File parentFile = fileResolveRootfsPath.getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
        }
        this.assetWriter.invoke(PACKAGE_ASSET, fileResolveRootfsPath);
        Log.i(TAG, "Wrote tgz: " + fileResolveRootfsPath.getAbsolutePath() + " (size=" + fileResolveRootfsPath.length() + " bytes)");
        ShellCommandResult shellCommandResult = (ShellCommandResult) this.commandRunner.invoke(n.k0(SETPROP_BIN, PROP_DONE, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID));
        if (shellCommandResult.getExitCode() != 0) {
            Log.w(TAG, "setprop sys.openclaw.install.done \"\" exit=" + shellCommandResult.getExitCode() + " stderr=" + shellCommandResult.getStderr());
        }
        requireSuccessOrThrow((ShellCommandResult) this.commandRunner.invoke(n.k0(SETPROP_BIN, PROP_TGZ, TMP_TGZ_IN_CHROOT)), "setprop persist.openclaw.install.tgz");
        requireSuccessOrThrow((ShellCommandResult) this.commandRunner.invoke(n.k0(SETPROP_BIN, PROP_RUN, "0")), "setprop sys.openclaw.install.run 0");
        requireSuccessOrThrow((ShellCommandResult) this.commandRunner.invoke(n.k0(SETPROP_BIN, PROP_RUN, "1")), "setprop sys.openclaw.install.run 1");
        Log.i(TAG, "Install request submitted; polling sys.openclaw.install.done …");
        long nanos = TimeUnit.SECONDS.toNanos(INSTALL_TIMEOUT_SEC) + ((Number) this.nowNs.invoke()).longValue();
        while (((Number) this.nowNs.invoke()).longValue() < nanos) {
            String property = readProperty(PROP_DONE);
            if (property.length() > 0) {
                Log.i(TAG, "Install finished: sys.openclaw.install.done=" + property);
                if (!kotlin.jvm.internal.p.a(property, "0")) {
                    throw new IllegalStateException(f.d("openclaw_install service reported failure: sys.openclaw.install.done=", property, ". 查看 logcat -s openclaw_install 定位 npm 错误。"));
                }
                verifyInstalled();
                return;
            }
            this.sleep.invoke(Long.valueOf(POLL_INTERVAL_MS));
        }
        throw new IllegalStateException("openclaw_install timed out after 1800s waiting for sys.openclaw.install.done");
    }

    public boolean isInstalledPackageValid() {
        return missingInstalledPackagePaths(this.runtimeConfig.resolveRootfsPath("usr/local/lib/node_modules/openclaw")).isEmpty();
    }

    public final String releaseProfileId() {
        return RELEASE_PROFILE_ID;
    }

    public /* synthetic */ OpenClawPackageInstaller(Context context, OpenClawRuntimeConfig openClawRuntimeConfig, l lVar, p pVar, l lVar2, a aVar, int i8, i iVar) {
        this(context, openClawRuntimeConfig, (i8 & 4) != 0 ? new z(23) : lVar, (i8 & 8) != 0 ? new c(2, context) : pVar, (i8 & 16) != 0 ? AnonymousClass3.INSTANCE : lVar2, (i8 & 32) != 0 ? AnonymousClass4.INSTANCE : aVar);
    }
}
