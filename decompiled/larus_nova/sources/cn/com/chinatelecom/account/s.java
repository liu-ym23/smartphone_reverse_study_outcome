package cn.com.chinatelecom.account;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import cn.com.chinatelecom.account.api.CtAuth;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.net.ssl.HttpsURLConnection;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes28.dex */
public abstract class s implements m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f24449b = "s";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Context f24450a;

    public s(Context r100) {
        this.f24450a = r100;
    }

    public static void a(Context r100, String r101) {
        if (TextUtils.isEmpty(r101) == false) goto L12;
        return;
    L12:
        ConnectivityManager r102 = (ConnectivityManager) r100.getSystemService("connectivity");     // Catch: Throwable -> L9
        if (r102.getNetworkInfo(5).getState().compareTo(NetworkInfo.State.CONNECTED) != 0) goto L14;
        int r103 = d0.b(d0.a(r101));     // Catch: Throwable -> L9
        Class r104 = INVOKESTATIC_cn_com_chinatelecom_account_s_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.net.ConnectivityManager");     // Catch: Throwable -> L9
        Class<?> r105 = Integer.TYPE;     // Catch: Throwable -> L9
        ((Boolean) r104.getMethod("requestRouteToHost", new Class[]{r105, r105}).invoke(r102, new Object[]{5, Integer.valueOf(r103)})).booleanValue();     // Catch: Throwable -> L9
        return;
    L14:
        return;
    L9:
        th = move-exception;
        CtAuth.warn(f24449b, "http doPost > requestUrlToRoute error", th);
    }

    private boolean a() {
        return r.l(this.f24450a);
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public HttpURLConnection a(String r100, String r101, int r102, w r103) {
        URL r104 = new URL(r100);
        if (r103.f24455c != null) goto L5;
    L7:
        URLConnection r105 = INVOKEVIRTUAL_cn_com_chinatelecom_account_s_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(r104);
    L8:
        HttpURLConnection r106 = (HttpURLConnection) r105;
        r106.setRequestProperty("accept", "*/*");
        if (r102 != 0) goto L11;
        r106.setRequestMethod("GET");
    L12:
        r106.setConnectTimeout(r103.a());
        r106.setReadTimeout(r103.b());
        r106.setUseCaches(false);
        if (a() == false) goto L15;
    L17:
        r106.addRequestProperty("Accept-Charset", "UTF-8");
        r106.addRequestProperty("reqId", r103.f24458f);
        r106.addRequestProperty("deviceId", i.e(this.f24450a));
        if (TextUtils.isEmpty(r101) == true) goto L20;
        DataOutputStream r107 = new DataOutputStream(new BufferedOutputStream(r106.getOutputStream()));
        r107.write(r101.getBytes("UTF-8"));
        r107.flush();
        r107.close();
    L21:
        return r106;
    L20:
        r106.connect();
        goto L21
    L15:
        if (b() == true) goto L17;
        r106.setInstanceFollowRedirects(false);
        goto L17
    L11:
        r106.setRequestMethod("POST");
        r106.setDoOutput(true);
        r106.setDoInput(true);
        goto L12
    L5:
        if (b() == false) goto L7;
        r105 = r103.f24455c.openConnection(r104);
        goto L8
    }

    public boolean a(String r100) {
        return r100.startsWith("https");
    }

    public boolean a(boolean r100, String r101) {
        if (r100 == false) goto L5;
        if (r101 == null) goto L5;
        return true;
    L5:
        return false;
    }

    public HttpsURLConnection b(String r100, String r101, int r102, w r103) {
        URL r104 = new URL(r100);
        if (r103.f24455c != null) goto L5;
    L7:
        URLConnection r105 = INVOKEVIRTUAL_cn_com_chinatelecom_account_s_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(r104);
    L8:
        HttpsURLConnection r106 = (HttpsURLConnection) r105;
        r106.setRequestProperty("accept", "*/*");
        if (r102 != 0) goto L11;
        r106.setRequestMethod("GET");
    L12:
        r106.setConnectTimeout(r103.a());
        r106.setReadTimeout(r103.b());
        r106.setUseCaches(false);
        if (a() == false) goto L15;
    L17:
        r106.addRequestProperty("Accept-Charset", "UTF-8");
        r106.addRequestProperty("reqId", r103.f24458f);
        r106.addRequestProperty("deviceId", i.e(this.f24450a));
        Map<String, String> r107 = r103.f24463k;
        if (r107 == null) goto L26;
        if (r107.isEmpty() == true) goto L26;
        Iterator<Map.Entry<String, String>> r108 = r103.f24463k.entrySet().iterator();
    L23:
        if (r108.hasNext() == false) goto L26;
        Map.Entry<String, String> r109 = r108.next();
        r106.addRequestProperty(r109.getKey(), r109.getValue());
    L26:
        if (TextUtils.isEmpty(r101) == true) goto L28;
        DataOutputStream r110 = new DataOutputStream(new BufferedOutputStream(r106.getOutputStream()));
        r110.write(r101.getBytes("UTF-8"));
        r110.flush();
        r110.close();
    L29:
        return r106;
    L28:
        r106.connect();
        goto L29
    L15:
        if (b() == true) goto L17;
        r106.setInstanceFollowRedirects(false);
        goto L17
    L11:
        r106.setRequestMethod("POST");
        r106.setDoOutput(true);
        r106.setDoInput(true);
        goto L12
    L5:
        if (b() == false) goto L7;
        r105 = r103.f24455c.openConnection(r104);
        goto L8
    }

    public boolean b() {
        return true;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_cn_com_chinatelecom_account_s_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    @Skip({"com.obric.assistant.network.okhttp"})
    public static URLConnection INVOKEVIRTUAL_cn_com_chinatelecom_account_s_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(URL r100) throws IOException {
        String r101 = r100.getHost();     // Catch: Throwable -> L8 IOException -> L12
        String r102 = r100.getPath();     // Catch: Throwable -> L8 IOException -> L12
        if (com.obric.assistant.network.okhttp.a.c(r101, r102) == false) goto L11;
        FLogger.f375446a.i("UrlConnLancet", "openConnection drop host=" + r101 + " path=" + r102);     // Catch: Throwable -> L8 IOException -> L12
        com.obric.assistant.network.okhttp.a.b(com.obric.assistant.network.okhttp.a.a(r101, r102), r101, r102);     // Catch: Throwable -> L8 IOException -> L12
        throw new IOException("[NetGuard] dropped " + r100);     // Catch: Throwable -> L8 IOException -> L12
    L11:
        return r100.openConnection();
    L12:
        e = move-exception;
        throw e;
    L8:
        th = move-exception;
        FLogger.f375446a.e("UrlConnLancet", "openConnection intercept failed, fallback to origin: " + th.getMessage());
        goto L11
    }
}
