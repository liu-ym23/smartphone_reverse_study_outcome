package com.ss.android.socialbase.downloader.impls;

import android.net.Uri;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.constants.DownloadInnerConstants;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.ss.android.socialbase.downloader.network.IDownloadHttpConnection;
import com.ss.android.socialbase.downloader.network.IDownloadHttpService;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.ss.android.socialbase.downloader.utils.LruCache;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.zip.GZIPInputStream;
import okhttp3.ab;
import okhttp3.ad;
import okhttp3.ae;
import okhttp3.e;
import okhttp3.u;
import okhttp3.z;

/* JADX INFO: loaded from: classes4.dex */
public class DefaultDownloadHttpService implements IDownloadHttpService {
    private static final String TAG = "DefaultDownloadHttpService";
    private final LruCache<String, z> hostIpClientCache;

    public DefaultDownloadHttpService() {
        this.hostIpClientCache = new LruCache(4, 8);
    }

    @Override // com.ss.android.socialbase.downloader.network.IDownloadHttpService
    public IDownloadHttpConnection downloadWithConnection(int r12, String r13, List<HttpHeader> r14) {
        List r15 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.aiagent.plugin");
        ab.a r16 = new ab.a().a(r13);
        int r2 = -1;
        if (r15 != null) goto L5;
    L25:
        String r3 = null;
    L27:
        if (TextUtils.isEmpty(r3) == true) goto L29;
        z r17 = createSpecialHostIpClient(r13, r3);
    L30:
        if (r17 == null) goto L59;
        ab r18 = r16.b();
        if (Logger.alog() == false) goto L36;
        Logger.globalDebug(TAG, "downloadWithConnection", r2 + "|Request Url:" + r13);
        u r19 = r18.c();
        if (r19 == null) goto L36;
        Logger.globalDebug(TAG, "downloadWithConnection", r2 + "|Request Headers: " + r19.toString());
    L36:
        final e r9 = r17.a(r18);
        final ad r8 = r9.b();
        if (r8 == null) goto L57;
        if (Logger.alog() == false) goto L43;
        u r110 = r8.f();
        if (r110 == null) goto L43;
        Logger.globalDebug(TAG, "downloadWithConnection", r2 + "|Response Header");
        Logger.globalDebug(TAG, "downloadWithConnection", r2 + "|Response Headers: " + r110.toString());
    L43:
        final ae r10 = r8.g();
        if (r10 == null) goto L55;
        InputStream r111 = r10.e();
        String r112 = r8.b(DownloadHelper.CONTENT_ENCODING);
        if (r112 != null) goto L48;
    L52:
        final InputStream r7 = r111;
    L54:
        return new AnonymousClass1(this, r7, r8, r9, r10);
    L48:
        if (DownloadHelper.GZIP.equalsIgnoreCase(r112) == false) goto L52;
        if (ZeusTransformUtils.instanceOf(r111, GZIPInputStream.class) == true) goto L52;
        r7 = new GZIPInputStream(r111);
        goto L54
    L55:
        return null;
    L57:
        throw new IOException("can't get response");
    L59:
        throw new IOException("can't get httpClient");
    L29:
        r17 = DownloadComponentManager.getDownloadClient();
        goto L30
    L5:
        if (r15.size() <= 0) goto L25;
        Iterator r113 = r15.iterator();
        r3 = null;
    L8:
        if (r113.hasNext() == false) goto L27;
        HttpHeader r4 = (HttpHeader) ZeusTransformUtils.preCheckCast(r113.next(), HttpHeader.class, "com.obric.aiagent.plugin");
        String r5 = r4.getName();
        if (DownloadInnerConstants.TTNET_BIZ_ID_HEADER_NAME.equals(r5) == true) goto L8;
        if (DownloadInnerConstants.TTNET_BIZ_VERSION_HEADER_NAME.equals(r5) == true) goto L8;
        if ("extra_download_id".equalsIgnoreCase(r4.getName()) == false) goto L20;
        r2 = Integer.parseInt(r4.getValue());     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        th.printStackTrace();
        goto L8
    L20:
        if (r3 != null) goto L24;
        if (DownloadConstants.EXTRA_REQUEST_HOST_IP.equals(r5) == false) goto L24;
        r3 = r4.getValue();
    L24:
        r16.b(r5, DownloadUtils.getEncodedStr(r4.getValue()));
        goto L8
    }

    private z createSpecialHostIpClient(String r6, final String r7) {
        final String r8 = Uri.parse(r6).getHost();     // Catch: Throwable -> L24
        if (TextUtils.isEmpty(r8) == true) goto L27;
        if (TextUtils.isEmpty(r7) == true) goto L27;
        String r0 = r8 + "_" + r7;     // Catch: Throwable -> L24
        LruCache<String, z> r1 = this.hostIpClientCache;     // Catch: Throwable -> L24
        monitor-enter(r1);     // Catch: Throwable -> L24
        z r2 = (z) ZeusTransformUtils.preCheckCast(this.hostIpClientCache.get(r0), z.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L21
        if (r2 == null) goto L12;
        monitor-exit(r1);     // Catch: Throwable -> L21
        return r2;
    L12:
        monitor-exit(r1);     // Catch: Throwable -> L21
        z.a r3 = DownloadComponentManager.createDownloadClientBuilder();     // Catch: Throwable -> L24
        r3.a(new AnonymousClass2(this, r8, r7));     // Catch: Throwable -> L24
        z r9 = r3.E();     // Catch: Throwable -> L24
        LruCache<String, z> r10 = this.hostIpClientCache;     // Catch: Throwable -> L24
        monitor-enter(r10);     // Catch: Throwable -> L24
        this.hostIpClientCache.put(r0, r9);     // Catch: Throwable -> L18
        monitor-exit(r10);     // Catch: Throwable -> L18
        return r9;
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L24
    L21:
        th = move-exception;
        throw th;     // Catch: Throwable -> L24
    L27:
        return DownloadComponentManager.getDownloadClient();
    L24:
        th = move-exception;
        th.printStackTrace();
        goto L27
    }
}
