package com.android.server.security;

import android.annotation.SystemApi;
import android.os.ParcelFileDescriptor;
import com.android.internal.security.VerityUtils;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
@SystemApi(client = SystemApi.Client.SYSTEM_SERVER)
public final class FileIntegrity {
    private FileIntegrity() {
    }

    @SystemApi(client = SystemApi.Client.SYSTEM_SERVER)
    public static void setUpFsVerity(File file) throws IOException {
        ParcelFileDescriptor pfd = ParcelFileDescriptor.open(file, 268435456);
        setUpFsVerity(pfd);     // Catch: Throwable -> L7
        if (pfd == null) goto L18;
        pfd.close();
        return;
    L18:
        return;
    L7:
        th = move-exception;
        if (pfd != null) goto L14;
    L13:
        throw th;
    L14:
        pfd.close();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        th.addSuppressed(th);
        goto L13
    }

    @SystemApi(client = SystemApi.Client.SYSTEM_SERVER)
    public static void setUpFsVerity(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
        VerityUtils.setUpFsverity(parcelFileDescriptor.getFd());
    }
}
