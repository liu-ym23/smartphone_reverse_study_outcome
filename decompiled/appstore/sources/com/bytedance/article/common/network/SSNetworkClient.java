package com.bytedance.article.common.network;

import android.net.Uri;
import android.util.Pair;
import com.bytedance.common.utility.CommonHttpException;
import com.bytedance.common.utility.d;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.ttnet.utils.RetrofitUtils;
import g6.a;
import h6.f;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class SSNetworkClient extends d {
    public SSNetworkClient() {
    }

    private static List<a> convertHeaders(Map<String, String> r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        ArrayList r11 = new ArrayList();
        Iterator<Map.Entry<String, String>> r12 = r10.entrySet().iterator();
    L7:
        if (r12.hasNext() == false) goto L9;
        Map.Entry<String, String> r13 = r12.next();
        r11.add(new a(r13.getKey(), r13.getValue()));
        goto L7
    L9:
        return r11;
    }

    private static Pair<String, String> parseUrl(String r10) throws Exception {
        Uri r11 = Uri.parse(r10);
        StringBuilder r12 = new StringBuilder();
        String r13 = r11.getScheme();
        String r14 = r11.getHost();
        int r15 = r11.getPort();
        if (r14 == null) goto L9;
        if (r13 == null) goto L6;
        r12.append(r13);
        r12.append("://");
    L6:
        r12.append(r14);
        if (r15 <= 0) goto L9;
        r12.append(':');
        r12.append(r15);
    L9:
        String r16 = r12.toString();
        String r17 = r11.getPath();
        String r18 = r11.getQuery();
        if (r18 == null) goto L13;
        r17 = r17 + "?" + r18;
    L13:
        return new Pair(r16, r17);
    }

    @Override // com.bytedance.common.utility.d
    public String get(String r10, Map<String, String> r11, d.a r12) throws Exception {
        Pair<String, String> r13 = parseUrl(r10);
        String r14 = (String) r13.first;
        String r15 = (String) r13.second;
        ICommonApi r16 = (ICommonApi) RetrofitUtils.f(r14, ICommonApi.class);
        List<a> r17 = convertHeaders(r11);
        if (r12 == null) goto L5;
        boolean r18 = r12.f6858a;
    L7:
        return (String) r16.get(-1, r15, r17, r18).execute().a();
    L5:
        r18 = false;
        goto L7
    }

    @Override // com.bytedance.common.utility.d
    public String post(String r10, List<Pair<String, String>> r11, Map<String, String> r12, d.a r13) throws CommonHttpException {
        Pair<String, String> r14 = parseUrl(r10);     // Catch: Exception -> L9
        String r15 = (String) r14.first;     // Catch: Exception -> L9
        String r16 = (String) r14.second;     // Catch: Exception -> L9
        ICommonApi r17 = (ICommonApi) RetrofitUtils.f(r15, ICommonApi.class);     // Catch: Exception -> L9
        List<a> r18 = convertHeaders(r12);     // Catch: Exception -> L9
        LinkedHashMap r19 = new LinkedHashMap();     // Catch: Exception -> L9
        if (r11 == null) goto L11;
        Iterator<Pair<String, String>> r20 = r11.iterator();     // Catch: Exception -> L9
    L7:
        if (r20.hasNext() == false) goto L11;
        Pair<String, String> r21 = r20.next();     // Catch: Exception -> L9
        r19.put(r21.first, r21.second);     // Catch: Exception -> L9
    L11:
        if (r13 == null) goto L13;
        boolean r22 = r13.f6858a;     // Catch: Exception -> L9
    L14:
        return (String) r17.postForm(-1, r16, r19, r18, r22).execute().a();
    L13:
        r22 = false;
    L9:
        e = move-exception;
        if ((e instanceof HttpResponseException) == false) goto L21;
        throw new CommonHttpException(((HttpResponseException) e).getStatusCode(), e.getMessage());
    L21:
        throw new CommonHttpException(0, e.getMessage());
    }

    public byte[] postDataStream(String r10, byte[] r11, Map<String, String> r12, d.a r13) throws CommonHttpException {
        InputStream r14 = null;
        Pair<String, String> r15 = parseUrl(r10);     // Catch: Throwable -> L6 Exception -> L8
        String r16 = (String) r15.first;     // Catch: Throwable -> L6 Exception -> L8
        String r17 = (String) r15.second;     // Catch: Throwable -> L6 Exception -> L8
        ICommonApi r18 = (ICommonApi) RetrofitUtils.f(r16, ICommonApi.class);     // Catch: Throwable -> L6 Exception -> L8
        if (r12 == null) goto L10;
        String r19 = r12.get("Content-Type");     // Catch: Throwable -> L6 Exception -> L8
        r12.remove("Content-Type");     // Catch: Throwable -> L6 Exception -> L8
    L11:
        List<a> r20 = convertHeaders(r12);     // Catch: Throwable -> L6 Exception -> L8
        if (r13 == null) goto L14;
        boolean r21 = r13.f6858a;     // Catch: Throwable -> L6 Exception -> L8
    L15:
        InputStream r110 = ((TypedInput) r18.postDataStream(-1, r17, new f(r19, r11, new String[0]), r20, r21).execute().a()).in();     // Catch: Throwable -> L6 Exception -> L8
        ByteArrayOutputStream r111 = new ByteArrayOutputStream();     // Catch: Throwable -> L36 Exception -> L38
    L70:
        byte[] r112 = new byte[1024];     // Catch: Throwable -> L22 Exception -> L24
    L19:
        int r113 = r110.read(r112);     // Catch: Throwable -> L22 Exception -> L24
        if (r113 == (-1)) goto L26;
        r111.write(r112, 0, r113);     // Catch: Throwable -> L22 Exception -> L24
        goto L19
    L26:
        byte[] r22 = r111.toByteArray();     // Catch: Throwable -> L22 Exception -> L24
        r110.close();     // Catch: IOException -> L29
    L64:
        r111.close();     // Catch: IOException -> L33
    L35:
        return r22;
    L33:
        e = move-exception;
        e.printStackTrace();
    L29:
        e = move-exception;
        e.printStackTrace();
        goto L64
    L24:
        e = move-exception;
        r14 = r110;
        e = e;
    L59:
    L44:
        th = th;
    L48:
        if (r14 != null) goto L62;
    L53:
        if (r111 == null) goto L75;
        r111.close();     // Catch: IOException -> L56
        throw th;
    L56:
        e = move-exception;
        e.printStackTrace();
        throw th;
    L75:
        throw th;
    L62:
        r14.close();     // Catch: IOException -> L51
    L51:
        e = move-exception;
        e.printStackTrace();
        goto L53
    L41:
        if ((e instanceof HttpResponseException) == false) goto L47;
        throw new CommonHttpException(((HttpResponseException) e).getStatusCode(), e.getMessage());     // Catch: Throwable -> L44
    L47:
        throw new CommonHttpException(0, e.getMessage());     // Catch: Throwable -> L44
    L22:
        th = th;
    L23:
        r14 = r110;
    L38:
        e = move-exception;
        r14 = r110;
        e = e;
        r111 = null;
    L36:
        th = th;
        r111 = null;
        goto L23
    L14:
        r21 = false;
        goto L15
    L10:
        r19 = null;
    L8:
        e = e;
        r111 = null;
    L6:
        th = th;
        r111 = null;
        goto L48
    }

    @Override // com.bytedance.common.utility.d
    public String post(String r10, byte[] r11, Map<String, String> r12, d.a r13) throws CommonHttpException {
        Pair<String, String> r14 = parseUrl(r10);     // Catch: Exception -> L6
        String r15 = (String) r14.first;     // Catch: Exception -> L6
        String r16 = (String) r14.second;     // Catch: Exception -> L6
        ICommonApi r17 = (ICommonApi) RetrofitUtils.f(r15, ICommonApi.class);     // Catch: Exception -> L6
        if (r12 == null) goto L8;
        String r18 = r12.get("Content-Type");     // Catch: Exception -> L6
        r12.remove("Content-Type");     // Catch: Exception -> L6
    L9:
        List<a> r19 = convertHeaders(r12);     // Catch: Exception -> L6
        if (r13 == null) goto L12;
        boolean r20 = r13.f6858a;     // Catch: Exception -> L6
    L13:
        return (String) r17.postData(-1, r16, new f(r18, r11, new String[0]), r19, r20).execute().a();
    L12:
        r20 = false;
        goto L13
    L8:
        r18 = null;
    L6:
        e = move-exception;
        if ((e instanceof HttpResponseException) == false) goto L20;
        throw new CommonHttpException(((HttpResponseException) e).getStatusCode(), e.getMessage());
    L20:
        throw new CommonHttpException(0, e.getMessage());
    }
}
