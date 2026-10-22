package com.bytedance.android.live.liveinteract.bgComponent.theme;

import com.bytedance.retrofit2.mime.TypedOutput;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ttnetuploader.uploader.api.Parameters;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes46.dex */
public final class e implements TypedOutput {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<a> f71738a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f71739b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f71740c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final File f71741d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f71742e;

    public interface a {
        void onProgress(long r100, long r101);
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public final String md5Stub() {
        return null;
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public final String fileName() {
        return this.f71741d.getName();
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public final long length() {
        return this.f71741d.length();
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public final String mimeType() {
        return this.f71742e;
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public final void writeTo(OutputStream r100) throws IOException {
        byte[] r101 = new byte[1024];
        PolarisFileInputStreamWrapper r102 = new PolarisFileInputStreamWrapper(this.f71741d);
        this.f71740c = length();
        this.f71739b = 0;
    L14:
        int r103 = r102.read(r101);     // Catch: Throwable -> L11
        if (r103 == (-1)) goto L9;
        r100.write(r101, 0, r103);     // Catch: Throwable -> L11
        this.f71739b += (long) r103;     // Catch: Throwable -> L11
        a r104 = this.f71738a.get();     // Catch: Throwable -> L11
        if (r104 == null) goto L14;
        r104.onProgress(this.f71739b, this.f71740c);     // Catch: Throwable -> L11
        goto L14
    L9:
        r102.close();
        return;
    L11:
        th = move-exception;
        r102.close();
        throw th;
    }

    public e(j.f r100, PolarisFileWrapper r101) {
        this.f71739b = 0;
        this.f71740c = 0;
        this.f71738a = new WeakReference(r100);
        this.f71741d = r101;
        this.f71742e = Parameters.CONTENT_TYPE_MULTIPART_FORM;
    }
}
