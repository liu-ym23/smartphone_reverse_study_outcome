package ic;

import android.net.Uri;
import android.util.Pair;
import ccom.obric.matrix.sdk.network.CustomHttpException;
import com.bytedance.article.common.network.ICommonApi;
import com.bytedance.common.utility.CommonHttpException;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetIOException;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.ttnet.utils.RetrofitUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class c extends com.bytedance.common.utility.d {
    public c() {
    }

    public static List convertHeaders(Map r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        ArrayList r11 = new ArrayList();
        Iterator r12 = r10.entrySet().iterator();
    L7:
        if (r12.hasNext() == false) goto L9;
        Map.Entry r13 = (Map.Entry) r12.next();
        r11.add(new g6.a((String) r13.getKey(), (String) r13.getValue()));
        goto L7
    L9:
        return r11;
    }

    public static Pair parseUrl(String r10) {
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
    public String get(String r10, Map r11, com.bytedance.common.utility.d.a r12) {
        Pair r13 = parseUrl(r10);
        String r14 = (String) r13.first;
        String r15 = (String) r13.second;
        ICommonApi r16 = (ICommonApi) RetrofitUtils.f(r14, ICommonApi.class);
        List<g6.a> r17 = convertHeaders(r11);
        if (r12 == null) goto L5;
        boolean r18 = r12.f6858a;
    L7:
        return (String) r16.get(-1, r15, r17, r18).execute().a();
    L5:
        r18 = false;
        goto L7
    }

    @Override // com.bytedance.common.utility.d
    public String post(String r10, List r11, Map r12, com.bytedance.common.utility.d.a r13) {
        Pair r14 = parseUrl(r10);     // Catch: Exception -> L9
        String r15 = (String) r14.first;     // Catch: Exception -> L9
        String r16 = (String) r14.second;     // Catch: Exception -> L9
        ICommonApi r17 = (ICommonApi) RetrofitUtils.f(r15, ICommonApi.class);     // Catch: Exception -> L9
        List<g6.a> r18 = convertHeaders(r12);     // Catch: Exception -> L9
        LinkedHashMap r19 = new LinkedHashMap();     // Catch: Exception -> L9
        if (r11 == null) goto L11;
        Iterator r20 = r11.iterator();     // Catch: Exception -> L9
    L7:
        if (r20.hasNext() == false) goto L11;
        Pair r21 = (Pair) r20.next();     // Catch: Exception -> L9
        r19.put((String) r21.first, (String) r21.second);     // Catch: Exception -> L9
    L11:
        if (r13 == null) goto L13;
        boolean r22 = r13.f6858a;     // Catch: Exception -> L9
    L14:
        return (String) r17.postForm(-1, r16, r19, r18, r22).execute().a();
    L13:
        r22 = false;
    L9:
        e = move-exception;
        if ((e instanceof HttpResponseException) == true) goto L25;
        if ((e instanceof CronetIOException) == false) goto L23;
        throw new CommonHttpException(((CronetIOException) e).getStatusCode(), e.getMessage());
    L23:
        throw new CommonHttpException(0, e.getMessage());
    L25:
        throw new CommonHttpException(((HttpResponseException) e).getStatusCode(), e.getMessage());
    }

    @Override // com.bytedance.common.utility.d
    public String post(String r10, byte[] r11, Map r12, com.bytedance.common.utility.d.a r13) {
        Pair r14 = parseUrl(r10);     // Catch: Exception -> L6
        String r15 = (String) r14.first;     // Catch: Exception -> L6
        String r16 = (String) r14.second;     // Catch: Exception -> L6
        ICommonApi r17 = (ICommonApi) RetrofitUtils.f(r15, ICommonApi.class);     // Catch: Exception -> L6
        if (r12 == null) goto L8;
        String r18 = (String) r12.get("Content-Type");     // Catch: Exception -> L6
        r12.remove("Content-Type");     // Catch: Exception -> L6
    L9:
        List<g6.a> r19 = convertHeaders(r12);     // Catch: Exception -> L6
        if (r13 == null) goto L12;
        boolean r20 = r13.f6858a;     // Catch: Exception -> L6
    L13:
        return (String) r17.postData(-1, r16, new h6.f(r18, r11, new String[0]), r19, r20).execute().a();
    L12:
        r20 = false;
        goto L13
    L8:
        r18 = null;
    L6:
        e = move-exception;
        if ((e instanceof HttpResponseException) == true) goto L24;
        if ((e instanceof CronetIOException) == false) goto L22;
        CronetIOException r21 = (CronetIOException) e;
        throw new CustomHttpException(r21.getStatusCode(), r21.getCronetInternalErrorCode(), e.getMessage());
    L22:
        throw new CustomHttpException(0, 0, e.getMessage());
    L24:
        throw new CustomHttpException(((HttpResponseException) e).getStatusCode(), 0, e.getMessage());
    }
}
