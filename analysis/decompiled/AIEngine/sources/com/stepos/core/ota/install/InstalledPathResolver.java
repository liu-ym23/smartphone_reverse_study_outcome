package com.stepos.core.ota.install;

import com.stepos.core.common.storage.ModelPathStore;
import com.stepos.core.ota.OtaEngine;
import gc.o;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.g;
import wb.c;
import wb.c.b;
import wb.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class InstalledPathResolver {
    public static final InstalledPathResolver INSTANCE = new InstalledPathResolver();

    private InstalledPathResolver() {
    }

    private final boolean hasPayload(String str) {
        File file = new File(str);
        if (!file.exists()) {
            return false;
        }
        if (file.isFile()) {
            return file.length() > 0;
        }
        c.b bVar = d.b0(file).new b();
        while (bVar.hasNext()) {
            File next = bVar.next();
            if (next.isFile() && next.length() > 0) {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ boolean isUsable$default(InstalledPathResolver installedPathResolver, String str, String str2, boolean z, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z = false;
        }
        return installedPathResolver.isUsable(str, str2, z);
    }

    private final File latestPayloadDir(String str) {
        File[] fileArrListFiles;
        File file = new File(OtaEngine.INSTANCE.bucketDirOf(str));
        Object next = null;
        if (!file.isDirectory() || (fileArrListFiles = file.listFiles()) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (File file2 : fileArrListFiles) {
            if (file2.isDirectory()) {
                String name = file2.getName();
                g.e(name, "getName(...)");
                if (o.k0(name, str + "-", false)) {
                    InstalledPathResolver installedPathResolver = INSTANCE;
                    String absolutePath = file2.getAbsolutePath();
                    g.e(absolutePath, "getAbsolutePath(...)");
                    if (installedPathResolver.hasPayload(absolutePath)) {
                        arrayList.add(file2);
                    }
                }
            }
        }
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            next = it.next();
            if (it.hasNext()) {
                long jLastModified = ((File) next).lastModified();
                do {
                    Object next2 = it.next();
                    long jLastModified2 = ((File) next2).lastModified();
                    if (jLastModified < jLastModified2) {
                        next = next2;
                        jLastModified = jLastModified2;
                    }
                } while (it.hasNext());
            }
        }
        return (File) next;
    }

    public static /* synthetic */ String resolve$default(InstalledPathResolver installedPathResolver, String str, String str2, boolean z, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z = false;
        }
        return installedPathResolver.resolve(str, str2, z);
    }

    private final File versionedDir(String str, int i10) {
        File file = new File(OtaEngine.INSTANCE.bucketDirOf(str), str + "-" + i10);
        if (!file.isDirectory()) {
            return null;
        }
        InstalledPathResolver installedPathResolver = INSTANCE;
        String absolutePath = file.getAbsolutePath();
        g.e(absolutePath, "getAbsolutePath(...)");
        if (installedPathResolver.hasPayload(absolutePath)) {
            return file;
        }
        return null;
    }

    public final boolean isUsable(String algorithmId, String otaId, boolean z) {
        g.f(algorithmId, "algorithmId");
        g.f(otaId, "otaId");
        return OtaBucketLegacy.INSTANCE.effectiveVersion(otaId) > 0 && resolve(algorithmId, otaId, z).length() > 0;
    }

    public final String resolve(String algorithmId, String otaId, boolean z) {
        String absolutePath;
        g.f(algorithmId, "algorithmId");
        g.f(otaId, "otaId");
        ModelPathStore modelPathStore = ModelPathStore.INSTANCE;
        String path = modelPathStore.getPath(algorithmId);
        if (path.length() > 0 && new File(path).exists() && hasPayload(path)) {
            return path;
        }
        int iEffectiveVersion = OtaBucketLegacy.INSTANCE.effectiveVersion(otaId);
        if (iEffectiveVersion <= 0) {
            if (path.length() <= 0 || !new File(path).exists()) {
                path = null;
            }
            return path == null ? "" : path;
        }
        File fileVersionedDir = versionedDir(otaId, iEffectiveVersion);
        if (fileVersionedDir != null) {
            if (z) {
                String absolutePath2 = fileVersionedDir.getAbsolutePath();
                g.e(absolutePath2, "getAbsolutePath(...)");
                modelPathStore.onDownloadComplete(otaId, absolutePath2, "");
            }
            String absolutePath3 = fileVersionedDir.getAbsolutePath();
            g.e(absolutePath3, "getAbsolutePath(...)");
            return absolutePath3;
        }
        File fileLatestPayloadDir = latestPayloadDir(otaId);
        if (fileLatestPayloadDir != null && z) {
            String absolutePath4 = fileLatestPayloadDir.getAbsolutePath();
            g.e(absolutePath4, "getAbsolutePath(...)");
            modelPathStore.onDownloadComplete(otaId, absolutePath4, "");
        }
        return (fileLatestPayloadDir == null || (absolutePath = fileLatestPayloadDir.getAbsolutePath()) == null) ? "" : absolutePath;
    }
}
