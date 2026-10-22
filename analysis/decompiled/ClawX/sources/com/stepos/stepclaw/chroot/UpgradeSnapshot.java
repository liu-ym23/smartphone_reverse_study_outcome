package com.stepos.stepclaw.chroot;

import a.a;
import android.util.Log;
import c5.m;
import com.stepos.stepclaw.SecurePrefs;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import m5.l;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ/\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/stepos/stepclaw/chroot/UpgradeSnapshot;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "Ljava/io/File;", "baseDir", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "maxKeep", "Lb5/a0;", "trimOldSnapshots", "(Ljava/io/File;I)V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "filesDirPath", "fromVersion", "toVersion", "create", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Ljava/io/File;", "TAG", "Ljava/lang/String;", "BASE_REL", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class UpgradeSnapshot {
    private static final String BASE_REL = "upgrade-snapshots";
    public static final UpgradeSnapshot INSTANCE = new UpgradeSnapshot();
    private static final String TAG = "UpgradeSnapshot";

    private UpgradeSnapshot() {
    }

    private final void trimOldSnapshots(File baseDir, int maxKeep) {
        File[] fileArrListFiles;
        if (maxKeep <= 0 || !baseDir.isDirectory() || (fileArrListFiles = baseDir.listFiles()) == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (File file : fileArrListFiles) {
            if (file.isDirectory()) {
                arrayList.add(file);
            }
        }
        List listJ0 = m.J0(arrayList, new Comparator() { // from class: com.stepos.stepclaw.chroot.UpgradeSnapshot$trimOldSnapshots$$inlined$sortedByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t8, T t9) {
                return a.l(((File) t9).getName(), ((File) t8).getName());
            }
        });
        if (listJ0.size() <= maxKeep) {
            return;
        }
        for (File file2 : m.r0(listJ0, maxKeep)) {
            try {
                p.b(file2);
                l.z0(file2);
                Log.d(TAG, "Removed old snapshot: " + file2.getName());
            } catch (Exception e9) {
                Log.w(TAG, "Failed to remove old snapshot " + file2.getName() + ": " + e9.getMessage());
            }
        }
    }

    public final File create(String filesDirPath, String fromVersion, String toVersion, int maxKeep) {
        p.e(filesDirPath, "filesDirPath");
        p.e(fromVersion, "fromVersion");
        p.e(toVersion, "toVersion");
        trimOldSnapshots(new File(filesDirPath, BASE_REL), maxKeep);
        return null;
    }
}
