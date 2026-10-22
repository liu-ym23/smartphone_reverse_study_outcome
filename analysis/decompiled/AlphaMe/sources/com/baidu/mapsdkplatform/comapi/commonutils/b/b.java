package com.baidu.mapsdkplatform.comapi.commonutils.b;

import com.baidu.mapsdkplatform.comapi.commonutils.b.c;
import java.io.File;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

/* loaded from: classes.dex */
public class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private String f7933a;

    /* renamed from: b, reason: collision with root package name */
    private File f7934b;

    /* renamed from: c, reason: collision with root package name */
    private com.baidu.mapsdkplatform.comapi.commonutils.b.a f7935c;

    /* renamed from: d, reason: collision with root package name */
    private c.InterfaceC0026c f7936d;

    /* renamed from: e, reason: collision with root package name */
    private volatile boolean f7937e = false;

    public static class a implements HostnameVerifier {
        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return HttpsURLConnection.getDefaultHostnameVerifier().verify(str, sSLSession);
        }
    }

    public b(String str, File file, com.baidu.mapsdkplatform.comapi.commonutils.b.a aVar, c.InterfaceC0026c interfaceC0026c) {
        this.f7933a = str;
        this.f7934b = file;
        this.f7935c = aVar;
        this.f7936d = interfaceC0026c;
    }

    public boolean a() {
        return this.f7937e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00d2 A[Catch: IOException -> 0x00ce, TRY_LEAVE, TryCatch #5 {IOException -> 0x00ce, blocks: (B:44:0x00ca, B:48:0x00d2), top: B:60:0x00ca }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ca A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void run() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 218
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapsdkplatform.comapi.commonutils.b.b.run():void");
    }
}
