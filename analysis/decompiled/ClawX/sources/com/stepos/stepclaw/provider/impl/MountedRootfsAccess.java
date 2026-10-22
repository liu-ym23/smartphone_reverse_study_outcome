package com.stepos.stepclaw.provider.impl;

import c5.m;
import c5.o;
import c5.s;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.provider.backend.IRootfsAccess;
import com.stepos.stepclaw.runtime.OpenClawRuntimeConfig;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import m0.f;
import m5.l;
import x5.a;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\r\u0010\fJ)\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0015\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u001d\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000e0 2\u0006\u0010\u001f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b!\u0010\"J\u0017\u0010#\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u000eH\u0016¢\u0006\u0004\b#\u0010$R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010%R\u0016\u0010'\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(¨\u0006)"}, d2 = {"Lcom/stepos/stepclaw/provider/impl/MountedRootfsAccess;", "Lcom/stepos/stepclaw/provider/backend/IRootfsAccess;", "Lcom/stepos/stepclaw/runtime/OpenClawRuntimeConfig;", "runtimeConfig", "<init>", "(Lcom/stepos/stepclaw/runtime/OpenClawRuntimeConfig;)V", "Lb5/a0;", "ensureMountedRootfs", "()V", "Ljava/io/File;", "file", "validateRootfsReadable", "(Ljava/io/File;)V", "ensureParentWritable", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "operation", "detail", "buildFailureMessage", "(Ljava/lang/String;Ljava/io/File;Ljava/lang/String;)Ljava/lang/String;", "buildPermissionMessage", "(Ljava/io/File;)Ljava/lang/String;", "path", "readRootfsFile", "(Ljava/lang/String;)Ljava/lang/String;", "content", "writeRootfsFile", "(Ljava/lang/String;Ljava/lang/String;)V", "ensureDirectory", "(Ljava/lang/String;)V", "getRootfsSubdir", "()Ljava/lang/String;", "dirPath", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "listRootfsFilesInDirectory", "(Ljava/lang/String;)Ljava/util/List;", "resolveRootfsPath", "(Ljava/lang/String;)Ljava/io/File;", "Lcom/stepos/stepclaw/runtime/OpenClawRuntimeConfig;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "mountValidated", "Z", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MountedRootfsAccess implements IRootfsAccess {
    private volatile boolean mountValidated;
    private final OpenClawRuntimeConfig runtimeConfig;

    public MountedRootfsAccess(OpenClawRuntimeConfig runtimeConfig) {
        p.e(runtimeConfig, "runtimeConfig");
        this.runtimeConfig = runtimeConfig;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.String buildFailureMessage(java.lang.String r2, java.io.File r3, java.lang.String r4) {
        /*
            r1 = this;
            if (r4 == 0) goto L14
            boolean r1 = x5.n.t1(r4)
            if (r1 != 0) goto L9
            goto La
        L9:
            r4 = 0
        La:
            if (r4 == 0) goto L14
            java.lang.String r1 = ": "
            java.lang.String r1 = r1.concat(r4)
            if (r1 != 0) goto L16
        L14:
            java.lang.String r1 = ""
        L16:
            java.lang.String r3 = r3.getAbsolutePath()
            java.lang.String r4 = "Failed to "
            java.lang.String r0 = " mounted rootfs path "
            java.lang.StringBuilder r1 = a8.b.v(r4, r2, r0, r3, r1)
            java.lang.String r2 = ". Check mount state, owner/group/mode, or SELinux avc: denied logs."
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.provider.impl.MountedRootfsAccess.buildFailureMessage(java.lang.String, java.io.File, java.lang.String):java.lang.String");
    }

    private final String buildPermissionMessage(File file) {
        return f.d("Mounted rootfs path is not writable/readable: ", file.getAbsolutePath(), ". Check owner/group/mode or SELinux avc: denied logs.");
    }

    private final void ensureMountedRootfs() {
        if (this.mountValidated) {
            return;
        }
        File rootfsRoot = this.runtimeConfig.getRootfsRoot();
        if (!this.runtimeConfig.isMountedRootfs()) {
            throw new IllegalStateException("Mounted rootfs is not active; current rootfs mode is " + this.runtimeConfig.getRootfsMode());
        }
        if (!rootfsRoot.exists() || !rootfsRoot.isDirectory()) {
            throw new IllegalStateException(f.c("Mounted rootfs is not available at ", rootfsRoot.getAbsolutePath()));
        }
        if (!rootfsRoot.canRead()) {
            throw new IllegalStateException(f.c("Mounted rootfs is not readable at ", rootfsRoot.getAbsolutePath()));
        }
        this.mountValidated = true;
    }

    private final void ensureParentWritable(File file) {
        ensureMountedRootfs();
        File parentFile = file.getParentFile();
        if (parentFile == null) {
            parentFile = this.runtimeConfig.getRootfsRoot();
        }
        if (!parentFile.exists() && !parentFile.mkdirs()) {
            throw new IllegalStateException(buildFailureMessage("mkdir", parentFile, "mkdirs() returned false"));
        }
        if (!parentFile.canWrite()) {
            throw new IllegalStateException(buildPermissionMessage(parentFile));
        }
    }

    private final void validateRootfsReadable(File file) {
        ensureMountedRootfs();
        if (!file.canRead()) {
            throw new IllegalStateException(buildPermissionMessage(file));
        }
    }

    @Override // com.stepos.stepclaw.provider.backend.IRootfsAccess
    public void ensureDirectory(String path) {
        p.e(path, "path");
        File fileResolveRootfsPath = resolveRootfsPath(path);
        ensureMountedRootfs();
        if (!fileResolveRootfsPath.exists()) {
            if (!fileResolveRootfsPath.mkdirs()) {
                throw new IllegalStateException(buildFailureMessage("mkdir", fileResolveRootfsPath, "mkdirs() returned false"));
            }
        } else {
            if (!fileResolveRootfsPath.isDirectory()) {
                throw new IllegalStateException(f.c("Rootfs path is not a directory: ", fileResolveRootfsPath.getAbsolutePath()));
            }
            if (!fileResolveRootfsPath.canWrite()) {
                throw new IllegalStateException(buildPermissionMessage(fileResolveRootfsPath));
            }
        }
    }

    @Override // com.stepos.stepclaw.provider.backend.IRootfsAccess
    public String getRootfsSubdir() {
        String absolutePath = this.runtimeConfig.getRootfsRoot().getAbsolutePath();
        p.d(absolutePath, "getAbsolutePath(...)");
        return absolutePath;
    }

    @Override // com.stepos.stepclaw.provider.backend.IRootfsAccess
    public List<String> listRootfsFilesInDirectory(String dirPath) {
        File[] fileArrListFiles;
        p.e(dirPath, "dirPath");
        File fileResolveRootfsPath = this.runtimeConfig.resolveRootfsPath(dirPath);
        ensureMountedRootfs();
        if (!fileResolveRootfsPath.exists() || !fileResolveRootfsPath.isDirectory() || (fileArrListFiles = fileResolveRootfsPath.listFiles()) == null) {
            return s.f1092a;
        }
        ArrayList arrayList = new ArrayList();
        int i8 = 0;
        for (File file : fileArrListFiles) {
            if (file.isFile()) {
                arrayList.add(file);
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

    @Override // com.stepos.stepclaw.provider.backend.IRootfsAccess
    public String readRootfsFile(String path) {
        p.e(path, "path");
        File fileResolveRootfsPath = resolveRootfsPath(path);
        if (!fileResolveRootfsPath.exists()) {
            return null;
        }
        validateRootfsReadable(fileResolveRootfsPath);
        try {
            return l.E0(fileResolveRootfsPath, a.f6276a);
        } catch (IOException e9) {
            throw new IllegalStateException(this.buildFailureMessage("read", fileResolveRootfsPath, e9.getMessage()), e9);
        }
    }

    @Override // com.stepos.stepclaw.provider.backend.IRootfsAccess
    public File resolveRootfsPath(String path) {
        p.e(path, "path");
        ensureMountedRootfs();
        return this.runtimeConfig.resolveRootfsPath(path);
    }

    @Override // com.stepos.stepclaw.provider.backend.IRootfsAccess
    public void writeRootfsFile(String path, String content) {
        p.e(path, "path");
        p.e(content, "content");
        File fileResolveRootfsPath = resolveRootfsPath(path);
        ensureParentWritable(fileResolveRootfsPath);
        try {
            l.G0(fileResolveRootfsPath, content, a.f6276a);
        } catch (IOException e9) {
            throw new IllegalStateException(buildFailureMessage("write", fileResolveRootfsPath, e9.getMessage()), e9);
        }
    }
}
