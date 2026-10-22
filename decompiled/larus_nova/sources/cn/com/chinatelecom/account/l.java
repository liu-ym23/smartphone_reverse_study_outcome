package cn.com.chinatelecom.account;

import android.content.Context;
import android.text.TextUtils;
import com.larus.utils.logger.FLogger;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes28.dex */
public class l {
    public static String a(Context r100, String r101, String r102) {
        String r103 = "";
        BufferedReader r104 = null;
        HttpURLConnection r105 = (HttpURLConnection) INVOKEVIRTUAL_cn_com_chinatelecom_account_l_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(new URL(r101));     // Catch: Throwable -> L29
        r105.setRequestProperty("accept", "*/*");     // Catch: Throwable -> L29
        r105.setRequestMethod("POST");     // Catch: Throwable -> L29
        r105.setDoOutput(true);     // Catch: Throwable -> L29
        r105.setDoInput(true);     // Catch: Throwable -> L29
        r105.setConnectTimeout(5000);     // Catch: Throwable -> L29
        r105.setReadTimeout(5000);     // Catch: Throwable -> L29
        r105.setUseCaches(false);     // Catch: Throwable -> L29
        r105.addRequestProperty("Accept-Charset", "UTF-8");     // Catch: Throwable -> L29
        if (TextUtils.isEmpty(r102) == true) goto L6;
        DataOutputStream r106 = new DataOutputStream(new BufferedOutputStream(r105.getOutputStream()));     // Catch: Throwable -> L29
        r106.write(r102.getBytes("UTF-8"));     // Catch: Throwable -> L29
        r106.flush();     // Catch: Throwable -> L29
        r106.close();     // Catch: Throwable -> L29
    L8:
        if (r105.getResponseCode() != 200) goto L20;
        InputStream r107 = r105.getInputStream();     // Catch: Throwable -> L29
        StringBuilder r108 = new StringBuilder();     // Catch: Throwable -> L18
        BufferedReader r109 = new BufferedReader(new InputStreamReader(r107));     // Catch: Throwable -> L18
    L54:
        String r110 = r109.readLine();     // Catch: Throwable -> L16
        if (r110 == null) goto L14;
        r108.append(r110);     // Catch: Throwable -> L16
        r108.append("\n");     // Catch: Throwable -> L16
        goto L54
    L14:
        r103 = r108.toString();     // Catch: Throwable -> L16
        r104 = r109;
    L21:
        if (r104 == null) goto L25;
        r104.close();     // Catch: Exception -> L23
    L25:
        if (r107 == null) goto L36;
        r107.close();     // Catch: Exception -> L23
    L36:
        return r103;
    L16:
        th = th;
        r104 = r109;
    L19:
        Throwable r111 = th;
        InputStream r112 = r107;
        th = r111;
    L47:
        th.printStackTrace();     // Catch: Throwable -> L37
        if (r104 == null) goto L34;
        r104.close();     // Catch: Exception -> L23
    L34:
        if (r112 == null) goto L36;
        r112.close();     // Catch: Exception -> L23
    L37:
        th = move-exception;
        if (r104 != null) goto L51;
    L42:
        if (r112 == null) goto L46;
        r112.close();     // Catch: Exception -> L40
    L40:
        e = move-exception;
        e.printStackTrace();
    L46:
        throw th;
    L51:
        r104.close();     // Catch: Exception -> L40
    L18:
        th = th;
        goto L19
    L20:
        r107 = null;
        goto L21
    L6:
        r105.connect();     // Catch: Throwable -> L29
    L29:
        th = th;
        r112 = null;
    L23:
        e = move-exception;
        e.printStackTrace();
        goto L36
    }

    @Skip({"com.obric.assistant.network.okhttp"})
    public static URLConnection INVOKEVIRTUAL_cn_com_chinatelecom_account_l_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(URL r100) throws IOException {
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
