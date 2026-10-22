package com.bytedance.vmsdk.a.a.a;

import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;

/* JADX INFO: compiled from: LightHttpResponse.java */
/* JADX INFO: loaded from: classes.dex */
public class g extends e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f11685c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f11686d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public d f11687e;

    public g() {
    }

    public void b() {
        d r0 = this.f11687e;
        if (r0 == null) goto L6;
        a(DownloadHelper.CONTENT_TYPE, r0.a());
        a(DownloadUtils.CONTENT_LENGTH, String.valueOf(this.f11687e.b()));
        return;
    }

    @Override // com.bytedance.vmsdk.a.a.a.e
    public void a() {
        super.a();
        this.f11685c = -1;
        this.f11686d = null;
        this.f11687e = null;
    }
}
