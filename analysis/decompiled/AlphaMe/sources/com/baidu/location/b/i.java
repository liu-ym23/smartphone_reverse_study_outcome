package com.baidu.location.b;

import android.content.Context;
import android.location.Location;
import android.os.Handler;
import com.baidu.location.Jni;
import com.baidu.mapapi.http.HttpClient;
import com.baidu.platform.comapi.UIMsg;
import com.stepos.alphame.awareness.AwarenessDataItem;
import com.stepos.alphame.utils.Property;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import kotlin.jvm.internal.ByteCompanionObject;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class i {

    /* renamed from: f, reason: collision with root package name */
    public static String f5263f = "0";

    /* renamed from: j, reason: collision with root package name */
    private static i f5264j;

    /* renamed from: I, reason: collision with root package name */
    private Handler f5273I;

    /* renamed from: k, reason: collision with root package name */
    private int f5287k = 1;

    /* renamed from: l, reason: collision with root package name */
    private double f5288l = 0.699999988079071d;

    /* renamed from: m, reason: collision with root package name */
    private String f5289m = "3G|4G";

    /* renamed from: n, reason: collision with root package name */
    private int f5290n = 1;

    /* renamed from: o, reason: collision with root package name */
    private int f5291o = 307200;

    /* renamed from: p, reason: collision with root package name */
    private int f5292p = 15;

    /* renamed from: q, reason: collision with root package name */
    private int f5293q = 1;

    /* renamed from: r, reason: collision with root package name */
    private double f5294r = 3.5d;

    /* renamed from: s, reason: collision with root package name */
    private double f5295s = 3.0d;

    /* renamed from: t, reason: collision with root package name */
    private double f5296t = 0.5d;

    /* renamed from: u, reason: collision with root package name */
    private int f5297u = UIMsg.MsgDefine.RENDER_STATE_FIRST_FRAME;

    /* renamed from: v, reason: collision with root package name */
    private int f5298v = 60;

    /* renamed from: w, reason: collision with root package name */
    private int f5299w = 0;

    /* renamed from: x, reason: collision with root package name */
    private int f5300x = 60;

    /* renamed from: y, reason: collision with root package name */
    private int f5301y = 0;

    /* renamed from: z, reason: collision with root package name */
    private long f5302z = 0;

    /* renamed from: A, reason: collision with root package name */
    private b f5265A = null;

    /* renamed from: B, reason: collision with root package name */
    private boolean f5266B = false;

    /* renamed from: C, reason: collision with root package name */
    private boolean f5267C = false;

    /* renamed from: D, reason: collision with root package name */
    private int f5268D = 0;

    /* renamed from: E, reason: collision with root package name */
    private float f5269E = Property.DEFAULT_FLOAT_VALUE;

    /* renamed from: F, reason: collision with root package name */
    private float f5270F = Property.DEFAULT_FLOAT_VALUE;

    /* renamed from: G, reason: collision with root package name */
    private long f5271G = 0;

    /* renamed from: H, reason: collision with root package name */
    private int f5272H = 500;

    /* renamed from: a, reason: collision with root package name */
    long f5279a = 0;

    /* renamed from: b, reason: collision with root package name */
    Location f5280b = null;

    /* renamed from: c, reason: collision with root package name */
    Location f5281c = null;

    /* renamed from: d, reason: collision with root package name */
    StringBuilder f5282d = null;

    /* renamed from: e, reason: collision with root package name */
    long f5283e = 0;

    /* renamed from: J, reason: collision with root package name */
    private byte[] f5274J = new byte[4];

    /* renamed from: K, reason: collision with root package name */
    private byte[] f5275K = null;

    /* renamed from: L, reason: collision with root package name */
    private int f5276L = 0;

    /* renamed from: M, reason: collision with root package name */
    private List<Byte> f5277M = null;

    /* renamed from: N, reason: collision with root package name */
    private boolean f5278N = false;

    /* renamed from: g, reason: collision with root package name */
    int f5284g = 0;

    /* renamed from: h, reason: collision with root package name */
    double f5285h = 116.22345545d;

    /* renamed from: i, reason: collision with root package name */
    double f5286i = 40.245667323d;

    public static class a implements HostnameVerifier {

        /* renamed from: a, reason: collision with root package name */
        private URL f5306a;

        public a(URL url) {
            this.f5306a = url;
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return this.f5306a.getHost().equals(str);
        }
    }

    public class b extends com.baidu.location.e.f {

        /* renamed from: a, reason: collision with root package name */
        String f5307a = null;

        public b() {
            this.el = new HashMap();
        }

        @Override // com.baidu.location.e.f
        public void a() {
            this.eh = com.baidu.location.e.d.f5858t;
            String strEncode = Jni.encode(this.f5307a);
            this.f5307a = null;
            this.el.put("q", strEncode);
        }

        public void a(String str) {
            this.f5307a = str;
            b(com.baidu.location.e.d.f5858t);
        }

        @Override // com.baidu.location.e.f
        public void a(boolean z4) throws JSONException {
            String str;
            if (z4 && (str = this.ej) != null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    jSONObject.put("prod", com.baidu.location.e.b.f5798e);
                    jSONObject.put("uptime", System.currentTimeMillis());
                    i.this.e(jSONObject.toString());
                } catch (Exception unused) {
                }
            }
            Map<String, Object> map = this.el;
            if (map != null) {
                map.clear();
            }
        }
    }

    private i() {
        this.f5273I = null;
        this.f5273I = new Handler();
    }

    public static i a() {
        if (f5264j == null) {
            f5264j = new i();
        }
        return f5264j;
    }

    private String b(String str) {
        Calendar calendar = Calendar.getInstance();
        return String.format(str, Integer.valueOf(calendar.get(1)), Integer.valueOf(calendar.get(2) + 1), Integer.valueOf(calendar.get(5)));
    }

    private void c() throws IOException {
        if (this.f5278N) {
            return;
        }
        this.f5278N = true;
        d(com.baidu.location.e.b.f5798e);
        j();
        d();
    }

    private void d() {
        String[] strArrSplit = "9.6.4.3".split("\\.");
        int length = strArrSplit.length;
        byte[] bArr = this.f5274J;
        bArr[0] = 0;
        bArr[1] = 0;
        bArr[2] = 0;
        bArr[3] = 0;
        if (length >= 4) {
            length = 4;
        }
        for (int i4 = 0; i4 < length; i4++) {
            try {
                this.f5274J[i4] = (byte) (Integer.valueOf(strArrSplit[i4]).intValue() & 255);
            } catch (Exception unused) {
            }
        }
        this.f5275K = a(com.baidu.location.e.b.f5798e + AwarenessDataItem.USERID_SPLITTER + com.baidu.location.e.b.a().f5808c);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00fd A[PHI: r2
      0x00fd: PHI (r2v23 byte) = (r2v18 byte), (r2v27 byte) binds: [B:36:0x011d, B:30:0x00fb] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void e(android.location.Location r22) {
        /*
            Method dump skipped, instructions count: 327
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.b.i.e(android.location.Location):void");
    }

    private boolean f() {
        if (this.f5266B) {
            if (!this.f5267C) {
                if (this.f5269E >= this.f5296t) {
                    return true;
                }
                this.f5267C = true;
                this.f5268D = this.f5292p;
                return true;
            }
            if (this.f5269E >= this.f5296t) {
                this.f5268D = 0;
                this.f5267C = false;
                return true;
            }
            int i4 = this.f5268D + this.f5292p;
            this.f5268D = i4;
            if (i4 <= this.f5297u || System.currentTimeMillis() - this.f5271G > this.f5298v * 1000) {
                return true;
            }
        } else {
            if (this.f5269E >= this.f5294r || this.f5270F >= this.f5295s) {
                this.f5266B = true;
                return true;
            }
            if (this.f5299w == 1 && System.currentTimeMillis() - this.f5271G > this.f5300x * 1000) {
                return true;
            }
        }
        return false;
    }

    private void g() {
        this.f5277M = null;
        this.f5283e = 0L;
        this.f5276L = 0;
        this.f5280b = null;
        this.f5281c = null;
        this.f5269E = Property.DEFAULT_FLOAT_VALUE;
        this.f5270F = Property.DEFAULT_FLOAT_VALUE;
    }

    private void h() throws IOException {
        if (this.f5283e == 0 || System.currentTimeMillis() - this.f5283e < this.f5292p * 1000) {
            return;
        }
        if (com.baidu.location.f.getServiceContext().getSharedPreferences("loc_navi_mode", 4).getBoolean("is_navi_on", false)) {
            g();
            return;
        }
        if (this.f5290n == 1 && !f()) {
            g();
            return;
        }
        if (com.baidu.location.e.b.f5798e.equals("com.ubercab.driver")) {
            if (e()) {
                g();
                return;
            }
        } else if (!a(com.baidu.location.e.b.f5798e, com.baidu.location.f.getServiceContext())) {
            g();
            return;
        }
        List<Byte> list = this.f5277M;
        if (list != null) {
            try {
                int size = list.size();
                this.f5277M.set(0, Byte.valueOf((byte) (size & 255)));
                this.f5277M.set(1, Byte.valueOf((byte) ((65280 & size) >> 8)));
                this.f5277M.set(3, Byte.valueOf((byte) (this.f5276L & 255)));
                byte[] bArr = new byte[size];
                for (int i4 = 0; i4 < size; i4++) {
                    bArr[i4] = this.f5277M.get(i4).byteValue();
                }
                File file = new File(com.baidu.location.e.h.h(), "baidu/tempdata");
                if (!file.exists()) {
                    file.mkdirs();
                }
                if (file.exists()) {
                    File file2 = new File(file, "intime.dat");
                    if (file2.exists()) {
                        file2.delete();
                    }
                    try {
                        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
                        bufferedOutputStream.write(bArr);
                        bufferedOutputStream.flush();
                        bufferedOutputStream.close();
                        new Thread() { // from class: com.baidu.location.b.i.2
                            @Override // java.lang.Thread, java.lang.Runnable
                            public void run() throws IOException {
                                i.this.a(new File(com.baidu.location.e.h.h() + "/baidu/tempdata", "intime.dat"), "https://itsdata.map.baidu.com/long-conn-gps/sdk.php");
                            }
                        }.start();
                    } catch (Exception unused) {
                    }
                }
                g();
                this.f5271G = System.currentTimeMillis();
            } catch (Exception unused2) {
            }
        }
    }

    private void i() {
        List<Byte> list;
        byte b4;
        this.f5277M.add((byte) 0);
        this.f5277M.add((byte) 0);
        if (f5263f.equals("0")) {
            list = this.f5277M;
            b4 = -82;
        } else {
            list = this.f5277M;
            b4 = -66;
        }
        list.add(Byte.valueOf(b4));
        this.f5277M.add((byte) 0);
        this.f5277M.add(Byte.valueOf(this.f5274J[0]));
        this.f5277M.add(Byte.valueOf(this.f5274J[1]));
        this.f5277M.add(Byte.valueOf(this.f5274J[2]));
        this.f5277M.add(Byte.valueOf(this.f5274J[3]));
        int length = this.f5275K.length;
        this.f5277M.add(Byte.valueOf((byte) ((length + 1) & 255)));
        for (int i4 = 0; i4 < length; i4++) {
            this.f5277M.add(Byte.valueOf(this.f5275K[i4]));
        }
    }

    private void j() {
        if (System.currentTimeMillis() - this.f5302z > 86400000) {
            if (this.f5265A == null) {
                this.f5265A = new b();
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(com.baidu.location.e.b.a().a(false));
            stringBuffer.append(com.baidu.location.b.b.a().c());
            stringBuffer.append("&cnloc=");
            stringBuffer.append(l.a().b());
            this.f5265A.a(stringBuffer.toString());
        }
        k();
    }

    private void k() {
    }

    private void c(int i4) throws IOException {
        if (i4 == 0) {
            return;
        }
        try {
            File file = new File(B0.g.r(new StringBuilder(), com.baidu.location.e.g.f5888a, "/grtcf.dat"));
            if (!file.exists()) {
                File file2 = new File(com.baidu.location.e.g.f5888a);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                if (!file.createNewFile()) {
                    return;
                }
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.seek(2L);
                randomAccessFile.writeInt(0);
                randomAccessFile.seek(8L);
                byte[] bytes = "1980_01_01:0".getBytes();
                randomAccessFile.writeInt(bytes.length);
                randomAccessFile.write(bytes);
                randomAccessFile.seek(200L);
                randomAccessFile.writeBoolean(false);
                randomAccessFile.seek(800L);
                randomAccessFile.writeBoolean(false);
                randomAccessFile.close();
            }
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "rw");
            randomAccessFile2.seek(8L);
            byte[] bytes2 = (b("%d_%02d_%02d") + AwarenessDataItem.USERID_SPLITTER + i4).getBytes();
            randomAccessFile2.writeInt(bytes2.length);
            randomAccessFile2.write(bytes2);
            randomAccessFile2.close();
        } catch (Exception unused) {
        }
    }

    private void d(Location location) {
        this.f5283e = System.currentTimeMillis();
        b((int) (location.getTime() / 1000));
        b((int) (location.getLongitude() * 1000000.0d));
        b((int) (location.getLatitude() * 1000000.0d));
        int i4 = !location.hasBearing() ? 1 : 0;
        int i5 = !location.hasSpeed() ? 1 : 0;
        if (i4 > 0) {
            this.f5277M.add((byte) 32);
        } else {
            this.f5277M.add(Byte.valueOf((byte) (((byte) (((int) (location.getBearing() / 15.0f)) & 255)) & (-33))));
        }
        if (i5 > 0) {
            this.f5277M.add(Byte.valueOf(ByteCompanionObject.MIN_VALUE));
        } else {
            this.f5277M.add(Byte.valueOf((byte) (((byte) (((int) ((location.getSpeed() * 3.6d) / 4.0d)) & 255)) & ByteCompanionObject.MAX_VALUE)));
        }
        this.f5280b = location;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str) throws IOException {
        try {
            File file = new File(B0.g.r(new StringBuilder(), com.baidu.location.e.g.f5888a, "/grtcf.dat"));
            if (!file.exists()) {
                File file2 = new File(com.baidu.location.e.g.f5888a);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                if (!file.createNewFile()) {
                    return;
                }
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.seek(2L);
                randomAccessFile.writeInt(0);
                randomAccessFile.seek(8L);
                byte[] bytes = "1980_01_01:0".getBytes();
                randomAccessFile.writeInt(bytes.length);
                randomAccessFile.write(bytes);
                randomAccessFile.seek(200L);
                randomAccessFile.writeBoolean(false);
                randomAccessFile.seek(800L);
                randomAccessFile.writeBoolean(false);
                randomAccessFile.close();
            }
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "rw");
            randomAccessFile2.seek(2L);
            int i4 = randomAccessFile2.readInt();
            int i5 = 1;
            while (i5 <= i4) {
                randomAccessFile2.seek(i5 * 2048);
                int i6 = randomAccessFile2.readInt();
                byte[] bArr = new byte[i6];
                randomAccessFile2.read(bArr, 0, i6);
                if (new String(bArr).contains(com.baidu.location.e.b.f5798e)) {
                    break;
                } else {
                    i5++;
                }
            }
            if (i5 >= i4) {
                randomAccessFile2.seek(2L);
                randomAccessFile2.writeInt(i5);
            }
            randomAccessFile2.seek(i5 * 2048);
            byte[] bytes2 = str.getBytes();
            randomAccessFile2.writeInt(bytes2.length);
            randomAccessFile2.write(bytes2);
            randomAccessFile2.close();
        } catch (Exception unused) {
        }
    }

    public void b() {
        if (this.f5278N) {
            this.f5278N = false;
            g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(File file, String str) throws IOException {
        String string = UUID.randomUUID().toString();
        try {
            HttpsURLConnection.setDefaultSSLSocketFactory(com.baidu.location.e.h.k());
            URL url = new URL(str);
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
            httpsURLConnection.setReadTimeout(10000);
            httpsURLConnection.setConnectTimeout(10000);
            httpsURLConnection.setDoInput(true);
            httpsURLConnection.setDoOutput(true);
            httpsURLConnection.setUseCaches(false);
            httpsURLConnection.setRequestMethod("POST");
            httpsURLConnection.setRequestProperty("Charset", "utf-8");
            httpsURLConnection.setHostnameVerifier(new a(url));
            httpsURLConnection.setRequestProperty("connection", "close");
            httpsURLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + string);
            if (file == null || !file.exists()) {
                return "0";
            }
            OutputStream outputStream = httpsURLConnection.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            StringBuffer stringBuffer = new StringBuffer(HttpClient.ENDFLAG);
            stringBuffer.append(string);
            stringBuffer.append(HttpClient.NEWLINE);
            stringBuffer.append("Content-Disposition: form-data; name=\"location_dat\"; filename=\"" + file.getName() + "\"\r\n");
            stringBuffer.append("Content-Type: application/octet-stream; charset=utf-8\r\n\r\n");
            dataOutputStream.write(stringBuffer.toString().getBytes());
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bArr = new byte[1024];
            while (true) {
                int i4 = fileInputStream.read(bArr);
                if (i4 == -1) {
                    break;
                }
                dataOutputStream.write(bArr, 0, i4);
            }
            fileInputStream.close();
            dataOutputStream.write(HttpClient.NEWLINE.getBytes());
            dataOutputStream.write((HttpClient.ENDFLAG + string + HttpClient.ENDFLAG + HttpClient.NEWLINE).getBytes());
            dataOutputStream.flush();
            dataOutputStream.close();
            int responseCode = httpsURLConnection.getResponseCode();
            outputStream.close();
            httpsURLConnection.disconnect();
            int i5 = this.f5301y + UIMsg.MsgDefine.RENDER_STATE_FIRST_TILE;
            this.f5301y = i5;
            c(i5);
            return responseCode == 200 ? "1" : "0";
        } catch (MalformedURLException | IOException unused) {
            return "0";
        } catch (Exception e4) {
            e4.printStackTrace();
            return "0";
        }
    }

    private void b(int i4) {
        byte[] bArrA = a(i4);
        for (int i5 = 0; i5 < 4; i5++) {
            this.f5277M.add(Byte.valueOf(bArrA[i5]));
        }
    }

    private void d(String str) throws IOException {
        try {
            File file = new File(B0.g.r(new StringBuilder(), com.baidu.location.e.g.f5888a, "/grtcf.dat"));
            if (file.exists()) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.seek(2L);
                int i4 = randomAccessFile.readInt();
                randomAccessFile.seek(8L);
                int i5 = randomAccessFile.readInt();
                int i6 = 1;
                if (i5 < 4096) {
                    byte[] bArr = new byte[i5];
                    randomAccessFile.read(bArr, 0, i5);
                    String str2 = new String(bArr);
                    if (str2.contains(b("%d_%02d_%02d")) && str2.contains(AwarenessDataItem.USERID_SPLITTER)) {
                        try {
                            String[] strArrSplit = str2.split(AwarenessDataItem.USERID_SPLITTER);
                            if (strArrSplit.length > 1) {
                                this.f5301y = Integer.valueOf(strArrSplit[1]).intValue();
                            }
                        } catch (Exception unused) {
                        }
                    }
                }
                while (true) {
                    if (i6 > i4) {
                        break;
                    }
                    randomAccessFile.seek(i6 * 2048);
                    int i7 = randomAccessFile.readInt();
                    if (i7 <= 4096) {
                        byte[] bArr2 = new byte[i7];
                        randomAccessFile.read(bArr2, 0, i7);
                        String str3 = new String(bArr2);
                        if (str != null && str3.contains(str)) {
                            c(str3);
                            break;
                        }
                    }
                    i6++;
                }
                randomAccessFile.close();
            }
        } catch (Exception unused2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Location location) throws IOException {
        c(location);
        h();
    }

    public void a(final Location location) {
        if (!this.f5278N) {
            c();
        }
        if (this.f5287k == 1 && this.f5289m.contains(com.baidu.location.c.b.a(com.baidu.location.c.f.a().g()))) {
            if (this.f5290n != 1 || this.f5301y <= this.f5291o) {
                this.f5273I.post(new Runnable() { // from class: com.baidu.location.b.i.1
                    @Override // java.lang.Runnable
                    public void run() throws IOException {
                        i.this.b(location);
                    }
                });
            }
        }
    }

    private boolean a(String str, Context context) {
        return true;
    }

    private void c(Location location) {
        if (System.currentTimeMillis() - this.f5279a < this.f5272H || location == null) {
            return;
        }
        if (location.hasSpeed() && location.getSpeed() > this.f5269E) {
            this.f5269E = location.getSpeed();
        }
        try {
            if (this.f5277M == null) {
                this.f5277M = new ArrayList();
                i();
                d(location);
            } else {
                e(location);
            }
        } catch (Exception unused) {
        }
        this.f5276L++;
    }

    private boolean e() throws Throwable {
        RandomAccessFile randomAccessFile;
        FileChannel channel;
        FileChannel fileChannel = null;
        FileLock fileLockTryLock = null;
        fileChannel = null;
        RandomAccessFile randomAccessFile2 = null;
        boolean z4 = false;
        try {
            try {
                File file = new File(com.baidu.location.e.h.f() + File.separator + "gflk.dat");
                if (!file.exists()) {
                    file.createNewFile();
                }
                randomAccessFile = new RandomAccessFile(file, "rw");
            } catch (Exception unused) {
            }
            try {
                channel = randomAccessFile.getChannel();
            } catch (Exception unused2) {
                randomAccessFile2 = randomAccessFile;
                if (randomAccessFile2 != null) {
                    randomAccessFile2.close();
                }
                return z4;
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception unused3) {
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile = null;
        }
        try {
            fileLockTryLock = channel.tryLock();
        } catch (Exception unused4) {
            z4 = true;
        } catch (Throwable th3) {
            th = th3;
            fileChannel = channel;
            if (fileChannel != null) {
                try {
                    fileChannel.close();
                } catch (Exception unused5) {
                    throw th;
                }
            }
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            throw th;
        }
        if (fileLockTryLock != null) {
            fileLockTryLock.release();
        }
        if (channel != null) {
            channel.close();
        }
        randomAccessFile.close();
        return z4;
    }

    private byte[] a(int i4) {
        return new byte[]{(byte) (i4 & 255), (byte) ((65280 & i4) >> 8), (byte) ((16711680 & i4) >> 16), (byte) ((i4 & (-16777216)) >> 24)};
    }

    private void c(String str) {
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("on")) {
                    this.f5287k = jSONObject.getInt("on");
                }
                if (jSONObject.has("bash")) {
                    this.f5288l = jSONObject.getDouble("bash");
                }
                if (jSONObject.has("net")) {
                    this.f5289m = jSONObject.getString("net");
                }
                if (jSONObject.has("tcon")) {
                    this.f5290n = jSONObject.getInt("tcon");
                }
                if (jSONObject.has("tcsh")) {
                    this.f5291o = jSONObject.getInt("tcsh");
                }
                if (jSONObject.has("per")) {
                    this.f5292p = jSONObject.getInt("per");
                }
                if (jSONObject.has("chdron")) {
                    this.f5293q = jSONObject.getInt("chdron");
                }
                if (jSONObject.has("spsh")) {
                    this.f5294r = jSONObject.getDouble("spsh");
                }
                if (jSONObject.has("acsh")) {
                    this.f5295s = jSONObject.getDouble("acsh");
                }
                if (jSONObject.has("stspsh")) {
                    this.f5296t = jSONObject.getDouble("stspsh");
                }
                if (jSONObject.has("drstsh")) {
                    this.f5297u = jSONObject.getInt("drstsh");
                }
                if (jSONObject.has("stper")) {
                    this.f5298v = jSONObject.getInt("stper");
                }
                if (jSONObject.has("nondron")) {
                    this.f5299w = jSONObject.getInt("nondron");
                }
                if (jSONObject.has("nondrper")) {
                    this.f5300x = jSONObject.getInt("nondrper");
                }
                if (jSONObject.has("uptime")) {
                    this.f5302z = jSONObject.getLong("uptime");
                }
                k();
            } catch (JSONException unused) {
            }
        }
    }

    private byte[] a(String str) {
        if (str == null) {
            return null;
        }
        byte[] bytes = str.getBytes();
        byte bNextInt = (byte) new SecureRandom().nextInt(255);
        byte bNextInt2 = (byte) new SecureRandom().nextInt(255);
        byte[] bArr = new byte[bytes.length + 2];
        int length = bytes.length;
        int i4 = 0;
        int i5 = 0;
        while (i4 < length) {
            bArr[i5] = (byte) (bytes[i4] ^ bNextInt);
            i4++;
            i5++;
        }
        bArr[i5] = bNextInt;
        bArr[i5 + 1] = bNextInt2;
        return bArr;
    }
}
