package D2;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Process;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.bytedance.apm.common.utility.NetworkUtils$NetworkType;
import com.bytedance.apm.common.utility.reflect.ReflectException;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import z2.l;

/* loaded from: classes2.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static NetworkUtils$NetworkType f373a = NetworkUtils$NetworkType.UNKNOWN;
    public static volatile long b = 0;
    public static volatile long c = 0;
    public static a d = null;
    public static boolean e = false;
    public static String f = null;
    public static int g = -1;
    public static String h = "";
    public static int i = -1;

    public static String a() throws IOException {
        String processName;
        String str;
        BufferedReader bufferedReader;
        if (!TextUtils.isEmpty(f)) {
            return f;
        }
        String string = null;
        try {
            processName = Application.getProcessName();
        } catch (Throwable th) {
            th.printStackTrace();
            processName = null;
        }
        f = processName;
        if (!TextUtils.isEmpty(processName)) {
            return f;
        }
        try {
            try {
                Class<?> cls = Class.forName("android.app.ActivityThread");
                G2.a aVar = new G2.a((Class) cls);
                try {
                    try {
                        str = (String) G2.a.c(aVar.a(), cls, new Object[0]).f661a;
                    } catch (NoSuchMethodException unused) {
                        aVar.d();
                        throw null;
                    }
                } catch (NoSuchMethodException e6) {
                    throw new ReflectException(e6);
                }
            } catch (Exception e9) {
                throw new ReflectException(e9);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
            str = null;
        }
        f = str;
        if (!TextUtils.isEmpty(str)) {
            return f;
        }
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    int i6 = bufferedReader.read();
                    if (i6 <= 0) {
                        break;
                    }
                    sb.append((char) i6);
                }
                string = sb.toString();
            } catch (Throwable unused2) {
            }
        } catch (Throwable unused3) {
            bufferedReader = null;
        }
        l.n(bufferedReader);
        f = string;
        return string;
    }

    public static String b(NetworkUtils$NetworkType networkUtils$NetworkType) {
        return networkUtils$NetworkType == NetworkUtils$NetworkType.WIFI ? "wifi" : networkUtils$NetworkType == NetworkUtils$NetworkType.WIFI_24GHZ ? "wifi24ghz" : networkUtils$NetworkType == NetworkUtils$NetworkType.WIFI_5GHZ ? "wifi5ghz" : networkUtils$NetworkType == NetworkUtils$NetworkType.MOBILE_2G ? "2g" : networkUtils$NetworkType == NetworkUtils$NetworkType.MOBILE_3G ? "3g" : networkUtils$NetworkType == NetworkUtils$NetworkType.MOBILE_3G_H ? "3gh" : networkUtils$NetworkType == NetworkUtils$NetworkType.MOBILE_3G_HP ? "3ghp" : networkUtils$NetworkType == NetworkUtils$NetworkType.MOBILE_4G ? "4g" : networkUtils$NetworkType == NetworkUtils$NetworkType.MOBILE_5G ? "5g" : networkUtils$NetworkType == NetworkUtils$NetworkType.MOBILE ? "mobile" : "";
    }

    public static NetworkUtils$NetworkType c(Context context) {
        if (f373a == NetworkUtils$NetworkType.UNKNOWN) {
            f373a = d(context);
        }
        if (System.currentTimeMillis() - b > 2000) {
            f373a = d(context);
            b = System.currentTimeMillis();
        }
        return f373a;
    }

    public static NetworkUtils$NetworkType d(Context context) {
        NetworkUtils$NetworkType networkUtils$NetworkType;
        NetworkUtils$NetworkType networkUtils$NetworkType2 = NetworkUtils$NetworkType.NONE;
        NetworkUtils$NetworkType networkUtils$NetworkType3 = NetworkUtils$NetworkType.WIFI;
        NetworkUtils$NetworkType networkUtils$NetworkType4 = NetworkUtils$NetworkType.MOBILE;
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                int type = activeNetworkInfo.getType();
                if (1 == type) {
                    return networkUtils$NetworkType3;
                }
                if (type != 0) {
                    f373a = networkUtils$NetworkType4;
                    return networkUtils$NetworkType4;
                }
                if (System.currentTimeMillis() - c < 60000 && (networkUtils$NetworkType = f373a) != networkUtils$NetworkType2 && networkUtils$NetworkType != NetworkUtils$NetworkType.UNKNOWN && networkUtils$NetworkType != networkUtils$NetworkType3) {
                    return networkUtils$NetworkType;
                }
                c = System.currentTimeMillis();
                int networkType = ((TelephonyManager) context.getSystemService("phone")).getNetworkType();
                if (networkType != 3) {
                    if (networkType == 20) {
                        NetworkUtils$NetworkType networkUtils$NetworkType5 = NetworkUtils$NetworkType.MOBILE_5G;
                        f373a = networkUtils$NetworkType5;
                        return networkUtils$NetworkType5;
                    }
                    if (networkType != 5 && networkType != 6) {
                        switch (networkType) {
                            case 8:
                            case 9:
                            case 10:
                                break;
                            default:
                                switch (networkType) {
                                    case 12:
                                    case 14:
                                    case 15:
                                        break;
                                    case 13:
                                        NetworkUtils$NetworkType networkUtils$NetworkType6 = NetworkUtils$NetworkType.MOBILE_4G;
                                        f373a = networkUtils$NetworkType6;
                                        return networkUtils$NetworkType6;
                                    default:
                                        f373a = networkUtils$NetworkType4;
                                        return networkUtils$NetworkType4;
                                }
                        }
                    }
                }
                NetworkUtils$NetworkType networkUtils$NetworkType7 = NetworkUtils$NetworkType.MOBILE_3G;
                f373a = networkUtils$NetworkType7;
                return networkUtils$NetworkType7;
            }
            return networkUtils$NetworkType2;
        } catch (Throwable unused) {
            f373a = networkUtils$NetworkType4;
            return networkUtils$NetworkType4;
        }
    }

    public static boolean e() {
        int i6 = g;
        if (i6 != -1) {
            return i6 == 1;
        }
        try {
            Class.forName("ohos.utils.system.SystemCapability");
            g = 1;
        } catch (Throwable unused) {
            g = 0;
        }
        return g == 1;
    }

    public static boolean f(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.isConnected()) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static void g(HttpURLConnection httpURLConnection) {
        if (httpURLConnection instanceof HttpsURLConnection) {
            try {
                SSLContext sSLContext = SSLContext.getInstance("TLS");
                sSLContext.init(null, null, null);
                ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(new d(sSLContext.getSocketFactory()));
            } catch (Throwable unused) {
            }
        }
    }
}
