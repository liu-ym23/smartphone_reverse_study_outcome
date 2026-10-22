package com.stepos.core.ota.domain.install;

import a0.a;
import com.stepos.core.ota.domain.model.ModelManifest;
import java.io.InputStream;
import kotlin.c;
import kotlin.jvm.internal.g;
import lb.n;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class InstallContext {
    private final String bucketDir;
    private InputStream decryptedStream;
    private final String downloadedFilePath;
    private boolean encryptedPayload;
    private final String installer;
    private final ModelManifest manifest;
    private final String targetDir;
    private final String tempDir;

    public InstallContext(ModelManifest manifest, String downloadedFilePath, String bucketDir, String installer) {
        g.f(manifest, "manifest");
        g.f(downloadedFilePath, "downloadedFilePath");
        g.f(bucketDir, "bucketDir");
        g.f(installer, "installer");
        this.manifest = manifest;
        this.downloadedFilePath = downloadedFilePath;
        this.bucketDir = bucketDir;
        this.installer = installer;
        String str = bucketDir + "/" + manifest.getOtaId() + "-" + manifest.getVersion();
        this.targetDir = str;
        this.tempDir = a.j(str, ".tmp");
    }

    public final String getBucketDir() {
        return this.bucketDir;
    }

    public final InputStream getDecryptedStream() {
        return this.decryptedStream;
    }

    public final String getDownloadedFilePath() {
        return this.downloadedFilePath;
    }

    public final boolean getEncryptedPayload() {
        return this.encryptedPayload;
    }

    public final String getInstaller() {
        return this.installer;
    }

    public final ModelManifest getManifest() {
        return this.manifest;
    }

    public final String getTargetDir() {
        return this.targetDir;
    }

    public final String getTempDir() {
        return this.tempDir;
    }

    public final void releaseResources$ota_release() {
        InputStream inputStream = this.decryptedStream;
        if (inputStream != null) {
            try {
                inputStream.close();
                n nVar = n.f10413a;
            } catch (Throwable th) {
                c.a(th);
            }
        }
        this.decryptedStream = null;
    }

    public final void setDecryptedStream$ota_release(InputStream inputStream) {
        this.decryptedStream = inputStream;
    }

    public final void setEncryptedPayload$ota_release(boolean z) {
        this.encryptedPayload = z;
    }
}
