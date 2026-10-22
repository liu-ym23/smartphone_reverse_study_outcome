package e3;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.bytedance.apm.config.SlardarConfigManagerImpl;
import com.stepos.ability.env.config.IEnvConfig;
import com.stepos.ability.mcpserver.security.RemoteKeyValidator$HttpTransport;
import f6.C1437b;
import io.modelcontextprotocol.spec.HttpHeaders;
import j9.AbstractC1607a;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import k2.C1621a;
import kotlin.NotImplementedError;
import w0.AbstractC2083d;
import w0.C2084e;

/* renamed from: e3.f, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1417f implements E0.a, J0.a, P4.a, IEnvConfig, RemoteKeyValidator$HttpTransport {
    public static C1417f b;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4344a;

    public /* synthetic */ C1417f(int i) {
        this.f4344a = i;
    }

    public static void l(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    @Override // E0.a
    public long a() {
        return 0L;
    }

    @Override // E0.a
    public long b() {
        return 0L;
    }

    @Override // E0.a
    public long c() {
        return 0L;
    }

    @Override // E0.a
    public long d() {
        return 0L;
    }

    @Override // P4.a
    public String e() {
        return "https://biz-gw.t-stepos.com/dictionary/";
    }

    @Override // E0.a
    public void f(boolean z10) {
    }

    @Override // E0.a
    public long g() {
        return 0L;
    }

    @Override // com.stepos.ability.env.config.IEnvConfig
    public String getBaseUrl() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // J0.a
    public boolean getLogTypeSwitch(String str) {
        SlardarConfigManagerImpl slardarConfigManagerImpl;
        J2.d dVar = J2.c.f865a;
        if (!dVar.e || (slardarConfigManagerImpl = dVar.d) == null) {
            return false;
        }
        return slardarConfigManagerImpl.getLogTypeSwitch(str);
    }

    @Override // J0.a
    public boolean getServiceSwitch(String str) {
        SlardarConfigManagerImpl slardarConfigManagerImpl;
        J2.d dVar = J2.c.f865a;
        if (!dVar.e || (slardarConfigManagerImpl = dVar.d) == null) {
            return false;
        }
        return slardarConfigManagerImpl.getServiceSwitch(str);
    }

    @Override // E0.a
    public long h() {
        return 0L;
    }

    @Override // P4.a
    public String i() {
        return "ws://connection-socket.t-stepos.com/ws";
    }

    @Override // P4.a
    public String j() {
        return "https://biz-gw.t-stepos.com/";
    }

    @Override // E0.a
    public long k() {
        return 0L;
    }

    public boolean m() {
        return this instanceof C1418g;
    }

    public void n(float f, float f7, float f9, z zVar) {
        zVar.c(f, 0.0f);
    }

    public C1437b o(Context context) {
        C1437b c1437b;
        C1437b c1437b2 = C1437b.c;
        if (c1437b2 != null) {
            return c1437b2;
        }
        synchronized (this) {
            c1437b = C1437b.c;
            if (c1437b == null) {
                Context applicationContext = context.getApplicationContext();
                kotlin.jvm.internal.k.e(applicationContext, "getApplicationContext(...)");
                c1437b = new C1437b(applicationContext);
                C1437b.c = c1437b;
            }
        }
        return c1437b;
    }

    @Override // com.stepos.ability.mcpserver.security.RemoteKeyValidator$HttpTransport
    public k4.x post(String url, Map headers, String jsonBody) throws IOException {
        String strO1;
        kotlin.jvm.internal.k.f(url, "url");
        kotlin.jvm.internal.k.f(headers, "headers");
        kotlin.jvm.internal.k.f(jsonBody, "jsonBody");
        URLConnection uRLConnectionOpenConnection = new URL(url).openConnection();
        kotlin.jvm.internal.k.d(uRLConnectionOpenConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
        HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setConnectTimeout(5000);
        httpURLConnection.setReadTimeout(10000);
        httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, "application/json; charset=utf-8");
        for (Map.Entry entry : headers.entrySet()) {
            httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
        }
        try {
            OutputStream outputStream = httpURLConnection.getOutputStream();
            try {
                Charset charset = AbstractC1607a.f4778a;
                byte[] bytes = jsonBody.getBytes(charset);
                kotlin.jvm.internal.k.e(bytes, "getBytes(...)");
                outputStream.write(bytes);
                outputStream.close();
                int responseCode = httpURLConnection.getResponseCode();
                InputStream errorStream = (200 > responseCode || responseCode >= 300) ? httpURLConnection.getErrorStream() : httpURLConnection.getInputStream();
                if (errorStream != null) {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(errorStream, charset), 8192);
                    try {
                        strO1 = S0.b.o1(bufferedReader);
                        bufferedReader.close();
                    } finally {
                    }
                } else {
                    strO1 = null;
                }
                if (strO1 == null) {
                    strO1 = "";
                }
                k4.x xVar = new k4.x(responseCode, strO1);
                httpURLConnection.disconnect();
                return xVar;
            } finally {
            }
        } catch (Throwable th) {
            httpURLConnection.disconnect();
            throw th;
        }
    }

    public static C1621a c(Context context, String[] strArr, String str) throws IOException {
        String[] strArr2;
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        String[] strArr3 = applicationInfo.splitSourceDirs;
        if (strArr3 == null || strArr3.length == 0) {
            strArr2 = new String[]{applicationInfo.sourceDir};
        } else {
            strArr2 = new String[strArr3.length + 1];
            strArr2[0] = applicationInfo.sourceDir;
            System.arraycopy(strArr3, 0, strArr2, 1, strArr3.length);
        }
        ZipFile zipFile = null;
        for (String str2 : strArr2) {
            int i = 0;
            while (true) {
                int i6 = i + 1;
                if (i >= 5) {
                    break;
                }
                try {
                    zipFile = new ZipFile(new File(str2), 1);
                    break;
                } catch (IOException unused) {
                    i = i6;
                }
            }
            if (zipFile != null) {
                int i10 = 0;
                while (true) {
                    int i11 = i10 + 1;
                    if (i10 < 5) {
                        for (String str3 : strArr) {
                            StringBuilder sb = new StringBuilder("lib");
                            char c = File.separatorChar;
                            sb.append(c);
                            sb.append(str3);
                            sb.append(c);
                            sb.append(str);
                            String string = sb.toString();
                            A5.c.i("Looking for %s in APK %s...", string, str2);
                            ZipEntry entry = zipFile.getEntry(string);
                            if (entry != null) {
                                C1621a c1621a = new C1621a();
                                c1621a.f4793a = zipFile;
                                c1621a.b = entry;
                                return c1621a;
                            }
                        }
                        i10 = i11;
                    } else {
                        try {
                            zipFile.close();
                            break;
                        } catch (IOException unused2) {
                        }
                    }
                }
            }
        }
        return null;
    }

    @Override // J0.a
    public boolean a(String str, String str2) {
        C2084e c2084e = AbstractC2083d.f6808a;
        Boolean bool = (Boolean) c2084e.b.get(str);
        return (bool != null && bool.booleanValue()) || (c2084e.h != null && c2084e.h.optInt(str2) == 1);
    }

    @Override // J0.a
    public boolean b(String str) {
        Boolean bool = (Boolean) AbstractC2083d.f6808a.f6809a.get(str);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    @Override // E0.a
    public void f() {
    }

    @Override // J0.a
    public boolean a(String str) {
        switch (this.f4344a) {
            case 2:
                Boolean bool = (Boolean) AbstractC2083d.f6808a.b.get(str);
                if (bool != null) {
                    return bool.booleanValue();
                }
                return false;
            default:
                return true;
        }
    }

    @Override // J0.a
    public boolean c(String str) {
        SlardarConfigManagerImpl slardarConfigManagerImpl;
        J2.d dVar = J2.c.f865a;
        if (!dVar.e || (slardarConfigManagerImpl = dVar.d) == null) {
            return false;
        }
        return slardarConfigManagerImpl.getMetricTypeSwitch(str);
    }
}
