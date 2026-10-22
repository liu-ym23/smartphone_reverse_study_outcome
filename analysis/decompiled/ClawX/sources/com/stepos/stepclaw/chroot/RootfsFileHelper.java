package com.stepos.stepclaw.chroot;

import a8.b;
import android.system.ErrnoException;
import android.system.Os;
import android.util.Log;
import c5.m;
import c5.o;
import c5.s;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.runtime.OpenClawRuntimeConfig;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import m0.f;
import m5.l;
import x.e;
import x5.a;
import x5.h;
import x5.j;
import x5.k;
import x5.n;
import x5.u;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u000e\u0018\u0000 +2\u00020\u0001:\u0001+B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\r\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0013\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u001b\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u0002¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010\"\u001a\u00020\b2\u0006\u0010!\u001a\u00020\u0002¢\u0006\u0004\b\"\u0010\u0005J\r\u0010#\u001a\u00020\b¢\u0006\u0004\b#\u0010$R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010%\u001a\u0004\b&\u0010'R\u0014\u0010*\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)¨\u0006,"}, d2 = {"Lcom/stepos/stepclaw/chroot/RootfsFileHelper;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "rootfsDir", "<init>", "(Ljava/lang/String;)V", "Ljava/io/File;", "file", "Lb5/a0;", "ensureParentDirectoryExists", "(Ljava/io/File;)V", "binFile", "script", "installGatewayBinScript", "(Ljava/io/File;Ljava/lang/String;)V", "dir", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "ensureDirectoryHierarchy", "(Ljava/io/File;)Z", "path", "content", "writeRootfsFile", "(Ljava/lang/String;Ljava/lang/String;)V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "data", "writeRootfsBinaryFile", "(Ljava/lang/String;[B)V", "readRootfsFile", "(Ljava/lang/String;)Ljava/lang/String;", "dirPath", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "listRootfsFilesInDirectory", "(Ljava/lang/String;)Ljava/util/List;", "packageName", "createBinWrappers", "tightenOpenClawExtensionsPermissions", "()V", "Ljava/lang/String;", "getRootfsDir", "()Ljava/lang/String;", "getBinDir", "()Ljava/io/File;", "binDir", "Companion", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RootfsFileHelper {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String GATEWAY_HOST = "127.0.0.1";
    public static final int GATEWAY_PORT = 18789;
    private static final String TAG = "RootfsFileHelper";
    private final String rootfsDir;

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/stepos/stepclaw/chroot/RootfsFileHelper$Companion;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "TAG", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "GATEWAY_HOST", "GATEWAY_PORT", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "forMountedRootfs", "Lcom/stepos/stepclaw/chroot/RootfsFileHelper;", "runtimeConfig", "Lcom/stepos/stepclaw/runtime/OpenClawRuntimeConfig;", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final RootfsFileHelper forMountedRootfs(OpenClawRuntimeConfig runtimeConfig) {
            p.e(runtimeConfig, "runtimeConfig");
            String absolutePath = runtimeConfig.getRootfsRoot().getAbsolutePath();
            p.d(absolutePath, "getAbsolutePath(...)");
            return new RootfsFileHelper(absolutePath);
        }

        private Companion() {
        }
    }

    public RootfsFileHelper(String rootfsDir) {
        p.e(rootfsDir, "rootfsDir");
        this.rootfsDir = rootfsDir;
    }

    private final boolean ensureDirectoryHierarchy(File dir) {
        if (dir.isDirectory()) {
            return true;
        }
        dir.mkdirs();
        return dir.isDirectory();
    }

    private final void ensureParentDirectoryExists(File file) throws IOException {
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.isDirectory() && !parentFile.mkdirs() && !parentFile.isDirectory()) {
            throw new IOException(f.c("cannot create parent directory: ", parentFile.getAbsolutePath()));
        }
    }

    private final File getBinDir() {
        return new File(b.n(this.rootfsDir, "/usr/local/bin"));
    }

    private final void installGatewayBinScript(File binFile, String script) throws Exception {
        try {
            if (ensureDirectoryHierarchy(getBinDir())) {
                l.G0(binFile, script, a.f6276a);
                binFile.setExecutable(true, false);
                binFile.setReadable(true, false);
            } else {
                throw new IOException("cannot create directory " + getBinDir().getAbsolutePath());
            }
        } catch (Exception e9) {
            Log.e(TAG, "createBinWrappers: cannot install " + binFile.getAbsolutePath() + "; openclaw_env does not consume root/.openclaw/bin", e9);
            throw e9;
        }
    }

    private static final void tightenOpenClawExtensionsPermissions$applySafeChmod(File file) throws ErrnoException {
        try {
            int i8 = Os.stat(file.getAbsolutePath()).st_mode & 511;
            int i9 = 493;
            if (!file.isDirectory()) {
                i9 = 493 & (i8 | 420);
            }
            if (i8 != i9) {
                Os.chmod(file.getAbsolutePath(), i9);
            }
        } catch (Exception unused) {
        }
    }

    private static final void tightenOpenClawExtensionsPermissions$visit(File file) throws ErrnoException {
        boolean zIsSymbolicLink;
        File[] fileArrListFiles;
        try {
            zIsSymbolicLink = Files.isSymbolicLink(file.toPath());
        } catch (Exception unused) {
            zIsSymbolicLink = false;
        }
        if (zIsSymbolicLink) {
            return;
        }
        tightenOpenClawExtensionsPermissions$applySafeChmod(file);
        if (!file.isDirectory() || (fileArrListFiles = file.listFiles()) == null) {
            return;
        }
        for (File file2 : fileArrListFiles) {
            p.b(file2);
            tightenOpenClawExtensionsPermissions$visit(file2);
        }
    }

    public final void createBinWrappers(String packageName) throws Exception {
        p.e(packageName, "packageName");
        File file = new File(b.o(this.rootfsDir, "/usr/local/lib/node_modules/", packageName));
        File file2 = new File(file, "package.json");
        if (!file2.exists()) {
            throw new RuntimeException("Package not found: " + file);
        }
        String strE0 = l.E0(file2, a.f6276a);
        if (!ensureDirectoryHierarchy(getBinDir())) {
            Log.w(TAG, "createBinWrappers: could not create " + getBinDir().getAbsolutePath() + "; per-wrapper install may still recover");
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Pattern patternCompile = Pattern.compile("\"bin\"\\s*:\\s*(\\{[^}]*\\}|\"[^\"]*\")");
        p.d(patternCompile, "compile(...)");
        Matcher matcher = patternCompile.matcher(strE0);
        p.d(matcher, "matcher(...)");
        j jVarA = e.a(matcher, 0, strE0);
        if (jVarA != null) {
            String str = (String) ((h) jVarA.a()).get(1);
            if (u.c1(str, "{", false)) {
                x5.l lVar = new x5.l("\"([^\"]+)\"\\s*:\\s*\"([^\"]+)\"");
                if (str.length() < 0) {
                    throw new IndexOutOfBoundsException("Start index out of bounds: 0, input length: " + str.length());
                }
                com.stepos.stepclaw.memory.lightmem.f fVar = new com.stepos.stepclaw.memory.lightmem.f(str, 14, (Object) lVar);
                k kVar = k.f6300a;
                w5.h hVar = new w5.h(new c5.k(fVar));
                while (hVar.hasNext()) {
                    j jVar = (j) hVar.next();
                    linkedHashMap.put(((h) jVar.a()).get(1), ((h) jVar.a()).get(2));
                }
            } else {
                linkedHashMap.put(packageName, n.U1(str, AbstractJsonLexerKt.STRING));
            }
        }
        if (linkedHashMap.isEmpty()) {
            Iterator it = c5.l.S(new String[]{f.d("bin/", packageName, ".js"), "bin/".concat(packageName), "cli.js", "index.js"}).iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String str2 = (String) it.next();
                if (new File(file, str2).exists()) {
                    linkedHashMap.put(packageName, str2);
                    break;
                }
            }
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            String str3 = (String) entry.getKey();
            String str4 = (String) entry.getValue();
            File file3 = new File(getBinDir(), str3);
            if (!file3.exists() || !file3.canExecute()) {
                installGatewayBinScript(file3, f.d("#!/bin/sh\nexec node \"", b.p("/usr/local/lib/node_modules/", packageName, "/", str4), "\" \"$@\"\n"));
            }
        }
    }

    public final String getRootfsDir() {
        return this.rootfsDir;
    }

    public final List<String> listRootfsFilesInDirectory(String dirPath) {
        File[] fileArrListFiles;
        p.e(dirPath, "dirPath");
        int i8 = 0;
        File file = new File(this.rootfsDir, n.V1(dirPath, '/'));
        if (!file.isDirectory() || (fileArrListFiles = file.listFiles()) == null) {
            return s.f1092a;
        }
        ArrayList arrayList = new ArrayList();
        for (File file2 : fileArrListFiles) {
            if (file2.isFile()) {
                arrayList.add(file2);
            }
        }
        ArrayList arrayList2 = new ArrayList(o.n0(arrayList, 10));
        int size = arrayList.size();
        while (i8 < size) {
            Object obj = arrayList.get(i8);
            i8++;
            arrayList2.add(((File) obj).getName());
        }
        return m.I0(arrayList2);
    }

    public final String readRootfsFile(String path) {
        p.e(path, "path");
        File file = new File(b.o(this.rootfsDir, "/", path));
        if (file.exists()) {
            return l.E0(file, a.f6276a);
        }
        return null;
    }

    public final void tightenOpenClawExtensionsPermissions() {
        File file = new File(b.n(this.rootfsDir, "/root/.openclaw/extensions"));
        if (file.isDirectory()) {
            try {
                tightenOpenClawExtensionsPermissions$visit(file);
            } catch (Exception unused) {
            }
        }
    }

    public final void writeRootfsBinaryFile(String path, byte[] data) throws IOException {
        p.e(path, "path");
        p.e(data, "data");
        File file = new File(b.o(this.rootfsDir, "/", path));
        ensureParentDirectoryExists(file);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            fileOutputStream.write(data);
            fileOutputStream.close();
        } finally {
        }
    }

    public final void writeRootfsFile(String path, String content) {
        p.e(path, "path");
        p.e(content, "content");
        File file = new File(b.o(this.rootfsDir, "/", path));
        ensureParentDirectoryExists(file);
        l.G0(file, content, a.f6276a);
    }
}
