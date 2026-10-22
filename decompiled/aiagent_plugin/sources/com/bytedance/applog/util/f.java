package com.bytedance.applog.util;

import android.content.Context;
import com.bytedance.applog.compress.CompressManager;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;

/* JADX INFO: compiled from: DefaultCompress.java */
/* JADX INFO: loaded from: classes.dex */
public class f implements com.bytedance.applog.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bytedance.applog.j.b f6034a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CompressManager f6035b;

    public f(com.bytedance.applog.c r4, com.bytedance.applog.j.b r5) {
        this.f6034a = r5;
        this.f6035b = new CompressManager((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r4.Z());
    }

    @Override // com.bytedance.applog.m
    public com.bytedance.applog.e a(byte[] r7) {
        com.bytedance.applog.e r0 = new com.bytedance.applog.e();
        com.bytedance.applog.compress.a r1 = new com.bytedance.applog.compress.a();
        r0.a(this.f6035b.compress(r7, this.f6034a.k(), r1));
        r0.a(r1.f5567c);
        HashMap r6 = new HashMap(4);
        if (r1.f5567c != 0) goto L6;
        r6.put("log-encode-type", DownloadHelper.GZIP);
        r6.put(DownloadHelper.CONTENT_ENCODING, DownloadHelper.GZIP);
        r6.put(DownloadHelper.CONTENT_TYPE, "application/octet-stream;tt-data=b");
    L14:
        r0.a(r6);
        return r0;
    L6:
        if (r1.f5567c != 1) goto L8;
    L13:
        r6.put("log-encode-type", "zstd");
        r6.put("log-encode-token", String.valueOf(0));
        r6.put(DownloadHelper.CONTENT_TYPE, "application/octet-stream;tt-data=b");
        goto L14
    L8:
        if (r1.f5567c == 2) goto L13;
        if (r1.f5567c != (-1)) goto L14;
        r6.put(DownloadHelper.CONTENT_TYPE, "application/json;charset=utf-8");
        goto L14
    }
}
