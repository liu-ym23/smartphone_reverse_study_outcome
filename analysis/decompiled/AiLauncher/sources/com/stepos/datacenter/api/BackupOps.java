package com.stepos.datacenter.api;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.datacenter.api.DataCenter;
import com.stepos.datacenter.core.result.DataCenterError;
import com.stepos.datacenter.core.result.DataCenterResult;
import com.stepos.datacenter.core.storage.BackupManager;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import v9.C5680i;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b\b\u0010\tJ#\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/stepos/datacenter/api/BackupOps;", "", "<init>", "()V", "Ljava/io/File;", "destZip", "Lcom/stepos/datacenter/core/result/DataCenterResult;", "Lcom/stepos/datacenter/core/storage/BackupManager$BackupManifest;", Const.INTENT_KEY_APIKEY, "(Ljava/io/File;Le9/c;)Ljava/lang/Object;", "srcZip", "dataRoot", Const.INTENT_KEY_PKGNAME, "(Ljava/io/File;Ljava/io/File;)Lcom/stepos/datacenter/core/result/DataCenterResult;", "sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BackupOps {

    /* renamed from: a, reason: collision with root package name */
    public static final BackupOps f29803a = new BackupOps();

    /* JADX WARN: Removed duplicated region for block: B:27:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(java.io.File r10, e9.InterfaceC4014c<? super com.stepos.datacenter.core.result.DataCenterResult<com.stepos.datacenter.core.storage.BackupManager.BackupManifest>> r11) throws java.lang.Throwable {
        /*
            r9 = this;
            boolean r0 = r11 instanceof com.stepos.datacenter.api.BackupOps$backupTo$1
            if (r0 == 0) goto L13
            r0 = r11
            com.stepos.datacenter.api.BackupOps$backupTo$1 r0 = (com.stepos.datacenter.api.BackupOps$backupTo$1) r0
            int r1 = r0.f29808e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f29808e = r1
            goto L18
        L13:
            com.stepos.datacenter.api.BackupOps$backupTo$1 r0 = new com.stepos.datacenter.api.BackupOps$backupTo$1
            r0.<init>(r9, r11)
        L18:
            java.lang.Object r9 = r0.f29806c
            java.lang.Object r11 = f9.C4063a.g()
            int r1 = r0.f29808e
            r2 = 1
            if (r1 == 0) goto L39
            if (r1 != r2) goto L31
            java.lang.Object r10 = r0.f29805b
            e7.o r10 = (e7.o) r10
            java.lang.Object r11 = r0.f29804a
            java.io.File r11 = (java.io.File) r11
            kotlin.C4849c.b(r9)
            goto L6b
        L31:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L39:
            kotlin.C4849c.b(r9)
            com.stepos.datacenter.api.DataCenter$Companion r9 = com.stepos.datacenter.api.DataCenter.INSTANCE
            e7.o r1 = r9.getVectorRegistry$sdk_release()
            if (r1 != 0) goto L52
            com.stepos.datacenter.core.result.DataCenterResult$Companion r3 = com.stepos.datacenter.core.result.DataCenterResult.INSTANCE
            com.stepos.datacenter.core.result.DataCenterError r4 = com.stepos.datacenter.core.result.DataCenterError.NOT_INITIALIZED
            r7 = 4
            r8 = 0
            java.lang.String r5 = "VectorRegistry not initialized; call DataCenter.init first"
            r6 = 0
            com.stepos.datacenter.core.result.DataCenterResult$Failure r9 = com.stepos.datacenter.core.result.DataCenterResult.Companion.failure$default(r3, r4, r5, r6, r7, r8)
            return r9
        L52:
            com.stepos.datacenter.api.DataCenter r9 = r9.getInstance()
            e7.p r9 = r9.getVectorStorageProvider()
            if (r9 == 0) goto L6f
            r0.f29804a = r10
            r0.f29805b = r1
            r0.f29808e = r2
            java.lang.Object r9 = r9.a(r0)
            if (r9 != r11) goto L69
            return r11
        L69:
            r11 = r10
            r10 = r1
        L6b:
            com.stepos.datacenter.core.result.DataCenterResult r9 = (com.stepos.datacenter.core.result.DataCenterResult) r9
            r1 = r10
            r10 = r11
        L6f:
            java.io.File r9 = r1.getRootDir()
            java.io.File r9 = r9.getParentFile()
            if (r9 != 0) goto L7d
            java.io.File r9 = r1.getRootDir()
        L7d:
            com.stepos.datacenter.core.storage.BackupManager r11 = com.stepos.datacenter.core.storage.BackupManager.f29992a
            com.stepos.datacenter.core.result.DataCenterResult r9 = r11.b(r9, r10, r2)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.datacenter.api.BackupOps.a(java.io.File, e9.c):java.lang.Object");
    }

    public final DataCenterResult<BackupManager.BackupManifest> b(File srcZip, File dataRoot) {
        p.i(srcZip, "srcZip");
        p.i(dataRoot, "dataRoot");
        DataCenter.Companion companion = DataCenter.INSTANCE;
        return (companion.isInitialized() || companion.getVectorRegistry$sdk_release() != null) ? DataCenterResult.Companion.failure$default(DataCenterResult.INSTANCE, DataCenterError.NOT_INITIALIZED, "DataCenter already initialized — restore requires a fresh process. Restart the app and call restoreFrom before init.", null, 4, null) : BackupManager.f29992a.j(srcZip, dataRoot, new C5680i(1, 1));
    }
}
