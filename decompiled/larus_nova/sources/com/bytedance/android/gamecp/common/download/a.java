package com.bytedance.android.gamecp.common.download;

import android.text.TextUtils;
import com.bytedance.android.gamecp.host_api.model.network.NameValuePair;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.ss.android.socialbase.downloader.network.IDownloadHttpConnection;
import com.ss.android.socialbase.downloader.network.IDownloadHttpService;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.text.StringsKt;
import xr.s;

/* JADX INFO: loaded from: classes44.dex */
public final class a implements IDownloadHttpService {

    /* JADX INFO: renamed from: com.bytedance.android.gamecp.common.download.a$a, reason: collision with other inner class name */
    public static final class C0908a {
    }

    public static final class b implements IDownloadHttpConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f56518a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ xv.a f56519b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ zv.a f56520c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ InputStream f56521d;

        @Override // com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection
        public final void cancel() {
            this.f56520c.cancel();     // Catch: Throwable -> L4
            return;
        }

        @Override // com.ss.android.socialbase.downloader.network.IDownloadHttpConnection
        public final void end() {
            this.f56520c.cancel();     // Catch: Throwable -> L7
        L11:
            InputStream r100 = this.f56521d;     // Catch: Throwable -> L8
            if (r100 == null) goto L13;
            r100.close();     // Catch: Throwable -> L8
            return;
        L13:
            return;
        }

        @Override // com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection
        public final int getResponseCode() {
            return this.f56519b.f565130b;
        }

        @Override // com.ss.android.socialbase.downloader.network.IDownloadHttpConnection
        public final InputStream getInputStream() {
            return this.f56521d;
        }

        @Override // com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection
        public final String getResponseHeaderField(String r100) {
            a r101 = this.f56518a;
            List<NameValuePair> r102 = this.f56519b.f565131c;
            if (r100 != null) goto L5;
            r100 = "";
        L5:
            r101.getClass();
            if (r102 != null) goto L8;
            return "";
        L8:
            if (TextUtils.isEmpty(r100) == true) goto L23;
            Iterator<NameValuePair> r103 = r102.iterator();
        L11:
            if (r103.hasNext() == false) goto L25;
            NameValuePair r104 = r103.next();
            if (StringsKt.equals(r100, r104.getName(), true) == false) goto L11;
            String r105 = r104.getValue();
            if (r105 != null) goto L18;
            return "";
        L18:
            return r105;
        L25:
            return "";
        L23:
            return "";
        }

        public b(a r100, xv.a r101, zv.a r102, InputStream r103) {
            this.f56518a = r100;
            this.f56519b = r101;
            this.f56520c = r102;
            this.f56521d = r103;
        }
    }

    static {
    }

    public a() {
    }

    @Override // com.ss.android.socialbase.downloader.network.IDownloadHttpService
    public final IDownloadHttpConnection downloadWithConnection(int r100, String r101, List<HttpHeader> r102) {
        if (TextUtils.isEmpty(r101) == false) goto L5;
        return null;
    L5:
        ArrayList r103 = new ArrayList();
        if (r102 == null) goto L11;
        Iterator<HttpHeader> r104 = r102.iterator();
    L9:
        if (r104.hasNext() == false) goto L11;
        HttpHeader r105 = r104.next();
        r103.add(new NameValuePair(r105.getName(), r105.getValue()));
    L11:
        ju.a r106 = (ju.a) s.a(ju.a.class);
        if (r106 == null) goto L14;
        zv.a r107 = r106.P1(r101, r103);
    L15:
        if (r107 == null) goto L27;
        xv.a r108 = r107.execute();     // Catch: Exception -> L18
    L20:
        if (r108 != null) goto L23;
        return null;
    L23:
        return new b(this, r108, r107, r108.f565134f);
    L18:
        e = move-exception;
        yr.c.b("DownloadHttpService", String.valueOf(e.getMessage()));
        r108 = null;
        goto L20
    L27:
        return null;
    L14:
        r107 = null;
        goto L15
    }
}
