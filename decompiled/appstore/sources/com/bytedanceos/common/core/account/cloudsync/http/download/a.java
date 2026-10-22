package com.bytedanceos.common.core.account.cloudsync.http.download;

import com.bytedance.keva.KevaImpl;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.core.account.cloudsync.util.CloudSyncFile;
import com.bytedanceos.common.networkv2.params.NetKey;
import java.io.Closeable;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;
import p8.b;

/* JADX INFO: loaded from: classes2.dex */
public class a implements DownloadExcutor {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f9608b = 4096;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile int f9609a;

    static {
    }

    public a() {
        this.f9609a = 1;
    }

    public final void a(Closeable r10) {
        if (r10 == null) goto L10;
        r10.close();     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public final void b(CloudSyncFile r17, InputStream r18, OutputStream r19, DownloadExcutor.DownloadProgressListener r20, long r21) {
        byte[] r10 = new byte[f9608b];
        this.f9609a = 3;
        long r11 = 0;
    L3:
        int r12 = r18.read(r10);
        if (r12 == (-1)) goto L28;
        if (this.f9609a == 2) goto L21;
        if (this.f9609a == 5) goto L21;
        if (r17.getDownloadedLength() > 0) goto L13;
    L18:
        r11 = r11 + ((long) r12);
        b.i("CommonDownloadExcutor", "has downloaded length :" + r11);
        r19.write(r10, 0, r12);
        r19.flush();
        r17.setDownloadedLength(r11);
        if (r20 == null) goto L3;
        r20.onProgress(r17);
        goto L3
    L13:
        if (r17.exists() == false) goto L16;
        if ((r17.length() - r11) == 0) goto L18;
    L16:
        if (r20 == null) goto L28;
        r20.onError(r17);
        r17.setDownloadedLength(0);
    L21:
        if (r20 == null) goto L28;
        if (this.f9609a != 2) goto L26;
        r20.onStop(r17);
        goto L28
    L26:
        if (this.f9609a != 5) goto L28;
        r20.onPause(r17);
    L28:
        b.i("CommonDownloadExcutor", "the file totalDownloaded : " + r11);
        b.i("CommonDownloadExcutor", "the file Length():" + r17.getFileLength());
        if ((r11 - r17.getFileLength()) != 0) goto L38;
        this.f9609a = 4;
        b.i("CommonDownloadExcutor", "the file is downloaded : " + r17);
        b.i("CommonDownloadExcutor", "totalDownloaded :" + r11);
        CloudSyncFile r13 = new CloudSyncFile(r17.getFileName());
        boolean r14 = r17.renameTo(r13);
        if (r14 == false) goto L34;
        if (r20 == null) goto L34;
        b.i("CommonDownloadExcutor", "the file is renamed sucessfully : " + r13);
        r20.onCompleted(r13);
        return;
    L34:
        if (r14 == true) goto L57;
        if (r20 == null) goto L58;
        b.i("CommonDownloadExcutor", "the file is renamed error : " + r17);
        r20.onError(r17);
        return;
    L58:
        return;
    L57:
        return;
    L38:
        if (r17.exists() == false) goto L40;
        r17.delete();
    L40:
        if (r20 != null) goto L42;
        return;
    L42:
        if (this.f9609a != 2) goto L44;
        return;
    L44:
        if (this.f9609a == 5) goto L62;
        r20.onError(r17);
        return;
    }

    public void c(String r10, String r11, DownloadExcutor.DownloadProgressListener r12) {
        startDownloadFile(r10, r11, r12, null);
    }

    @Override // com.bytedanceos.common.core.account.cloudsync.http.download.DownloadExcutor
    public synchronized void startDownloadFile(String r12, String r13, DownloadExcutor.DownloadProgressListener r14, HashMap r15) {
        monitor-enter(this);
        this.f9609a = 1;     // Catch: Throwable -> L53
        b.i("CommonDownloadExcutor", "start DownloadFile:" + r12);     // Catch: Throwable -> L53
        CloudSyncFile r10 = new CloudSyncFile(r13 + ".tmp");     // Catch: Throwable -> L53
        r10.setFileName(r13);     // Catch: Throwable -> L53
        b.i("CommonDownloadExcutor", "tmpEntiyFile = " + r10);     // Catch: Throwable -> L53
        Closeable r16 = null;
        Closeable r17 = null;
        InputStream r18 = null;
        r18 = null;
        r16 = null;
        HttpURLConnection r19 = null;
    L11:
        e = e;
    L99:
        e.printStackTrace();     // Catch: Throwable -> L80
        if (r14 == null) goto L82;
        r14.onError(r10);     // Catch: Throwable -> L80
    L82:
        a(r17);     // Catch: Throwable -> L53
        if ((r19 instanceof HttpsURLConnection) == false) goto L85;
        o8.a.a(r19);     // Catch: Throwable -> L53
    L85:
        a(null);     // Catch: Throwable -> L53
        if (r19 == null) goto L88;
        r19.disconnect();     // Catch: Throwable -> L53
    L88:
        monitor-exit(this);
        return;
    L80:
        th = th;
        Closeable r110 = r16;
        HttpURLConnection r11 = r19;
        r16 = r17;
    L90:
        a(r16);     // Catch: Throwable -> L53
        if ((r11 instanceof HttpsURLConnection) == false) goto L93;
        o8.a.a(r11);     // Catch: Throwable -> L53
    L93:
        a(r110);     // Catch: Throwable -> L53
        if (r11 == null) goto L96;
        r11.disconnect();     // Catch: Throwable -> L53
    L96:
        throw th;     // Catch: Throwable -> L53
    L9:
        th = th;
        r110 = null;
        r11 = null;
        goto L90
    L7:
        if (r10.exists() == true) goto L14;
        r10.createNewFile();     // Catch: Throwable -> L9 Exception -> L11
    L14:
        URL r20 = new URL(r12);     // Catch: Throwable -> L9 Exception -> L11
        if (r20.getProtocol().equals("https") == false) goto L17;
        r11 = (HttpsURLConnection) r20.openConnection();     // Catch: Throwable -> L9 Exception -> L11
    L103:
        r11.setRequestProperty("Accept-Encoding", "gzip, deflate");     // Catch: Throwable -> L21 Exception -> L23
        r11.setRequestProperty("User-Agent", b.f());     // Catch: Throwable -> L21 Exception -> L23
        r11.setRequestProperty(NetKey.DEVICE_ID, BaseApplication.c().i().getClientId());     // Catch: Throwable -> L21 Exception -> L23
        r11.setRequestProperty("S-Ver", b.d(r12));     // Catch: Throwable -> L21 Exception -> L23
        r11.setConnectTimeout(KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD);     // Catch: Throwable -> L21 Exception -> L23
        r11.setReadTimeout(40000);     // Catch: Throwable -> L21 Exception -> L23
        if (r15 != null) goto L25;
        r15 = new HashMap();     // Catch: Throwable -> L21 Exception -> L23
    L25:
        r15.put("App-Id", "1");     // Catch: Throwable -> L21 Exception -> L23
        r15.put("Date", b.b());     // Catch: Throwable -> L21 Exception -> L23
        Iterator r111 = r15.keySet().iterator();     // Catch: Throwable -> L21 Exception -> L23
    L27:
        if (r111.hasNext() == false) goto L29;
        String r21 = (String) r111.next();     // Catch: Throwable -> L21 Exception -> L23
        r11.setRequestProperty(r21, (String) r15.get(r21));     // Catch: Throwable -> L21 Exception -> L23
        goto L27
    L29:
        Iterator<String> r112 = r11.getRequestProperties().keySet().iterator();     // Catch: Throwable -> L21 Exception -> L23
    L31:
        if (r112.hasNext() == false) goto L33;
        String r113 = r112.next();     // Catch: Throwable -> L21 Exception -> L23
        b.i("CommonDownloadExcutor", r113 + ":" + r11.getRequestProperty(r113));     // Catch: Throwable -> L21 Exception -> L23
        goto L31
    L33:
        FileOutputStream r114 = new FileOutputStream(r10);     // Catch: Throwable -> L21 Exception -> L23
        r11.connect();     // Catch: Throwable -> L40 Exception -> L42
        int r115 = 0;
    L35:
        String r22 = r11.getHeaderField(r115);     // Catch: Throwable -> L40 Exception -> L42
        if (r22 == null) goto L37;
        b.i("CommonDownloadExcutor", r11.getHeaderFieldKey(r115) + " = " + r22);     // Catch: Throwable -> L40 Exception -> L42
        r115 = r115 + 1;
        goto L35
    L37:
        int r116 = r11.getHeaderFieldInt("Cloud-Status", -1);     // Catch: Throwable -> L40 Exception -> L42
        if (r116 != (-1)) goto L44;
        r116 = r11.getResponseCode();     // Catch: Throwable -> L40 Exception -> L42
    L44:
        b.i("CommonDownloadExcutor", "Download file And Response Code is : " + r116);     // Catch: Throwable -> L40 Exception -> L42
        if ((r116 / 100) != 2) goto L64;
        if (this.f9609a != 2) goto L59;
        if (r14 == null) goto L50;
        r14.onStop(r10);     // Catch: Throwable -> L40 Exception -> L42
    L50:
        a(r114);     // Catch: Throwable -> L53
        if ((r11 instanceof HttpsURLConnection) == false) goto L55;
        o8.a.a(r11);     // Catch: Throwable -> L53
    L55:
        a(null);     // Catch: Throwable -> L53
        r11.disconnect();     // Catch: Throwable -> L53
        monitor-exit(this);
        return;
    L59:
        if ("gzip".equals(r11.getContentEncoding()) == false) goto L61;
        r18 = new GZIPInputStream(r11.getInputStream());     // Catch: Throwable -> L40 Exception -> L42
    L62:
        b(r10, r18, r114, r14, r10.getFileLength());     // Catch: Throwable -> L40 Exception -> L42
        r114.flush();     // Catch: Throwable -> L40 Exception -> L42
    L67:
        a(r114);     // Catch: Throwable -> L53
        if ((r11 instanceof HttpsURLConnection) == false) goto L70;
        o8.a.a(r11);     // Catch: Throwable -> L53
    L70:
        a(r18);     // Catch: Throwable -> L53
        r11.disconnect();     // Catch: Throwable -> L53
        goto L88
    L61:
        r18 = r11.getInputStream();     // Catch: Throwable -> L40 Exception -> L42
        goto L62
    L64:
        if (r116 != 404) goto L73;
        if (r14 == null) goto L67;
        r14.onError(r10);     // Catch: Throwable -> L40 Exception -> L42
        goto L67
    L73:
        throw new Exception();     // Catch: Throwable -> L40 Exception -> L42
    L42:
        e = move-exception;
        r17 = r114;
        e = e;
        r19 = r11;
    L40:
        th = move-exception;
        r16 = r114;
        th = th;
        r110 = null;
        goto L90
    L23:
        e = e;
        r19 = r11;
    L21:
        th = th;
        r110 = null;
        goto L90
    L17:
        r11 = (HttpURLConnection) r20.openConnection();     // Catch: Throwable -> L9 Exception -> L11
    L53:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedanceos.common.core.account.cloudsync.http.download.DownloadExcutor
    public void stopDownloadFile(int r10) {
        this.f9609a = r10;
    }
}
