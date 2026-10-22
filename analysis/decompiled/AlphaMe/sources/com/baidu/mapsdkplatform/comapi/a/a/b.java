package com.baidu.mapsdkplatform.comapi.a.a;

import B0.g;
import android.content.Context;
import android.os.Build;
import com.baidu.mapapi.NetworkUtil;
import com.baidu.mapsdkplatform.comapi.util.SyncSysInfo;
import com.baidu.mapsdkplatform.comapi.util.e;
import com.baidu.mapsdkplatform.comapi.util.f;
import com.baidu.mapsdkplatform.comjni.util.JNIHandler;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.zip.GZIPOutputStream;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static String f7847a = "";

    /* renamed from: b, reason: collision with root package name */
    private static String f7848b = "";

    /* renamed from: c, reason: collision with root package name */
    private static String f7849c = "";

    /* renamed from: d, reason: collision with root package name */
    private Context f7850d;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            File[] fileArrListFiles;
            if (e.b().a() == null) {
                return;
            }
            File file = new File(b.f7847a);
            if (!file.exists() || (fileArrListFiles = file.listFiles()) == null || fileArrListFiles.length == 0) {
                return;
            }
            try {
                Arrays.sort(fileArrListFiles, new c());
            } catch (Exception unused) {
            }
            int length = fileArrListFiles.length;
            if (length > 10) {
                length = 10;
            }
            for (int i4 = 0; i4 < length; i4++) {
                File file2 = fileArrListFiles[i4];
                if (!file2.isDirectory() && file2.exists() && file2.isFile() && file2.getName().contains(b.f7848b)) {
                    if (file2.getName().endsWith(".txt")) {
                        b.this.b(file2);
                    } else if (file2.getName().endsWith(".zip") && file2.exists()) {
                        b.this.b(file2);
                    }
                }
            }
            if (fileArrListFiles.length > 10) {
                b.this.a(fileArrListFiles);
            }
        }
    }

    /* renamed from: com.baidu.mapsdkplatform.comapi.a.a.b$b, reason: collision with other inner class name */
    public static final class C0023b {

        /* renamed from: a, reason: collision with root package name */
        private static final b f7852a = new b();
    }

    public static b c() {
        return C0023b.f7852a;
    }

    private void d() {
        File filesDir;
        Context context = this.f7850d;
        if (context == null || (filesDir = context.getFilesDir()) == null) {
            return;
        }
        String path = filesDir.getPath();
        if (path.isEmpty()) {
            return;
        }
        String strR = g.r(g.s(path), File.separator, "crash");
        File file = new File(strR);
        if (file.exists()) {
            f7847a = strR;
        } else if (file.mkdir()) {
            f7847a = strR;
        } else {
            f7847a = path;
        }
    }

    private HttpURLConnection e() throws ProtocolException {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://api.map.baidu.com/lbs_sdkcc/report").openConnection();
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Connection", "keep-alive");
            httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data; boundary=bd_map_sdk_cc");
            httpURLConnection.setRequestProperty("Cache-Control", "no-cache");
            httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
            httpURLConnection.setConnectTimeout(10000);
            return httpURLConnection;
        } catch (Exception unused) {
            return null;
        }
    }

    private void f() {
        String str;
        String str2 = f7847a;
        if (str2 == null || str2.isEmpty() || (str = f7848b) == null || str.isEmpty()) {
            return;
        }
        String str3 = f7847a + File.separator + f7848b;
        com.baidu.mapsdkplatform.comapi.a.a.a.a().a(str3);
        JNIHandler.registerNativeHandler(str3);
    }

    private void g() {
        if (NetworkUtil.isNetworkAvailable(this.f7850d)) {
            new Thread(new a()).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0111 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x00f9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0120 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:128:? A[Catch: all -> 0x000f, SYNTHETIC, TRY_ENTER, TRY_LEAVE, TryCatch #11 {, blocks: (B:7:0x000b, B:45:0x00d7, B:48:0x00de, B:49:0x00e4, B:62:0x00f9, B:65:0x0100, B:67:0x0108, B:68:0x010b, B:71:0x0111, B:74:0x0118, B:76:0x0120), top: B:104:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0108 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized boolean b(java.io.File r10) {
        /*
            Method dump skipped, instructions count: 296
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapsdkplatform.comapi.a.a.b.b(java.io.File):boolean");
    }

    public void a(Context context) {
        String[] strArr = Build.SUPPORTED_ABIS;
        if (strArr.length > 0) {
            f7849c = strArr[0];
        }
        this.f7850d = context;
        String strG = f.g();
        if (strG.isEmpty()) {
            return;
        }
        if (strG.contains("_")) {
            strG = strG.replaceAll("_", "");
        }
        StringBuilder sbV = g.v(strG, "_");
        sbV.append(f.n());
        sbV.append("_");
        f7848b = sbV.toString();
        d();
        f();
        g();
    }

    public void a(String str, String str2) {
        JNIHandler.addLog(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(File[] fileArr) {
        int length = fileArr.length;
        for (int i4 = 0; i4 < length - 10; i4++) {
            int i5 = i4 + 10;
            File file = fileArr[i5];
            if (file != null && file.exists()) {
                fileArr[i5].delete();
            }
        }
    }

    private StringBuilder a(File file) {
        String[] strArrSplit = file.getName().substring(0, file.getName().length() - 4).split("_");
        StringBuilder sbS = g.s("--bd_map_sdk_cc\r\nContent-Disposition: form-data; name=\"phoneinfo\"\r\n\r\n");
        sbS.append(URLDecoder.decode(SyncSysInfo.getPhoneInfo() + "&abi=" + f7849c));
        sbS.append("\r\n--bd_map_sdk_cc\r\n");
        String str = strArrSplit[0];
        if (str != null && !str.isEmpty()) {
            sbS.append("Content-Disposition: form-data; name=\"packname\"\r\n\r\n");
            sbS.append(strArrSplit[0]);
            sbS.append("\r\n--bd_map_sdk_cc\r\n");
        }
        String str2 = strArrSplit[1];
        if (str2 != null && !str2.isEmpty()) {
            sbS.append("Content-Disposition: form-data; name=\"version\"\r\n\r\n");
            sbS.append(strArrSplit[1]);
            sbS.append("\r\n--bd_map_sdk_cc\r\n");
        }
        String str3 = strArrSplit[2];
        if (str3 != null && !str3.isEmpty()) {
            sbS.append("Content-Disposition: form-data; name=\"timestamp\"\r\n\r\n");
            sbS.append(strArrSplit[2]);
            sbS.append("\r\n--bd_map_sdk_cc\r\n");
        }
        sbS.append("Content-Disposition: form-data; name=\"os\"\r\n\r\nandroid\r\n--bd_map_sdk_cc\r\n");
        return sbS;
    }

    private byte[] a(byte[] bArr) throws Exception {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
        a(byteArrayInputStream, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.flush();
        byteArrayOutputStream.close();
        byteArrayInputStream.close();
        return byteArray;
    }

    private void a(InputStream inputStream, OutputStream outputStream) throws Exception {
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
        byte[] bArr = new byte[1024];
        while (true) {
            int i4 = inputStream.read(bArr, 0, 1024);
            if (i4 != -1) {
                gZIPOutputStream.write(bArr, 0, i4);
            } else {
                gZIPOutputStream.flush();
                gZIPOutputStream.close();
                try {
                    outputStream.close();
                    inputStream.close();
                    return;
                } catch (Exception unused) {
                    return;
                }
            }
        }
    }
}
