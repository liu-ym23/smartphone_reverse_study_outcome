package org.extra.tools;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.amap.api.col.jmsl.s7;
import gc.AbstractC4115a;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONObject;
import org.libpag.PAG;

/* loaded from: classes5.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static final AtomicReference f37779a = new AtomicReference(b.Unreported);

    public class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            e.f();
        }
    }

    public enum b {
        Unreported,
        Reporting,
        Reported
    }

    public static boolean b(String str, String str2, String str3, String str4) {
        boolean z10 = false;
        try {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL("https://otheve.beacon.qq.com/analytics/v2_upload").openConnection();
            httpsURLConnection.setConnectTimeout(2000);
            httpsURLConnection.setReadTimeout(s7.DEFAULT_RETRY_TIMEOUT);
            httpsURLConnection.setDoOutput(true);
            httpsURLConnection.setRequestMethod("POST");
            httpsURLConnection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(httpsURLConnection.getOutputStream(), "UTF-8");
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
            bufferedWriter.write(d(str, str2, str3, str4));
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStreamWriter.close();
            httpsURLConnection.connect();
            if (httpsURLConnection.getResponseCode() == 200) {
                StringBuilder sb2 = new StringBuilder();
                InputStreamReader inputStreamReader = new InputStreamReader(httpsURLConnection.getInputStream(), "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    sb2.append(line);
                }
                bufferedReader.close();
                inputStreamReader.close();
                if (new JSONObject(sb2.toString()).optInt("result") == 200) {
                    z10 = true;
                }
            }
            httpsURLConnection.disconnect();
        } catch (Throwable unused) {
        }
        return z10;
    }

    public static String c() {
        return new SimpleDateFormat("yyyy-MM").format(new Date());
    }

    public static String d(String str, String str2, String str3, String str4) {
        return "{\"appVersion\":\"\",\"sdkId\":\"\",\"sdkVersion\":\"" + str + "\",\"mainAppKey\":\"0DOU0K0WD05SLYU3\",\"platformId\":\"\",\"common\":{\"A2\":\"pag_sdk_report\"},\"events\":[{\"eventCode\":\"pag_sdk_report\",\"eventTime\":\"" + System.currentTimeMillis() + "\",\"mapValue\":{\"appName\":\"" + str2 + "\",\"appID\":\"" + str3 + "\",\"appPlatform\":\"Android\",\"previousSDKVersion\":\"" + str4 + "\"}}]}";
    }

    public static void e() {
        ThreadPoolExecutor threadPoolExecutor;
        AtomicReference atomicReference = f37779a;
        if (atomicReference.get() != b.Unreported) {
            return;
        }
        atomicReference.set(b.Reporting);
        ThreadPoolExecutor threadPoolExecutor2 = null;
        try {
            threadPoolExecutor = new ThreadPoolExecutor(2, 4, 1L, TimeUnit.SECONDS, new ArrayBlockingQueue(2));
        } catch (Throwable th) {
            th = th;
        }
        try {
            threadPoolExecutor.execute(new a());
            threadPoolExecutor.shutdown();
        } catch (Throwable th2) {
            th = th2;
            threadPoolExecutor2 = threadPoolExecutor;
            try {
                th.printStackTrace();
            } finally {
                threadPoolExecutor2.shutdown();
            }
        }
    }

    public static void f() {
        Context contextA = AbstractC4115a.a();
        if (contextA == null) {
            f37779a.set(b.Unreported);
            return;
        }
        String strSDKVersion = PAG.SDKVersion();
        if (TextUtils.isEmpty(strSDKVersion)) {
            f37779a.set(b.Unreported);
            return;
        }
        SharedPreferences sharedPreferences = contextA.getSharedPreferences("pag_reporter", 0);
        String string = "";
        String string2 = sharedPreferences.getString("last_pag_version", "");
        String string3 = sharedPreferences.getString("pag_report_time", "");
        String strC = c();
        if (strSDKVersion.equals(string2) && strC.equals(string3)) {
            f37779a.set(b.Reported);
            return;
        }
        String packageName = contextA.getPackageName();
        if (TextUtils.isEmpty(packageName)) {
            f37779a.set(b.Unreported);
            return;
        }
        PackageManager packageManager = contextA.getPackageManager();
        try {
            string = packageManager.getPackageInfo(packageName, 0).applicationInfo.loadLabel(packageManager).toString();
        } catch (Throwable unused) {
        }
        if (packageManager.checkPermission("android.permission.INTERNET", packageName) != 0) {
            f37779a.set(b.Unreported);
        } else {
            if (!b(strSDKVersion, string, packageName, string2)) {
                f37779a.set(b.Unreported);
                return;
            }
            sharedPreferences.edit().putString("last_pag_version", strSDKVersion).apply();
            sharedPreferences.edit().putString("pag_report_time", strC).apply();
            f37779a.set(b.Reported);
        }
    }
}
