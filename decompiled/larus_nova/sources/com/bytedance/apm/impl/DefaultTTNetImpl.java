package com.bytedance.apm.impl;

import com.bytedance.apm.d;
import com.bytedance.apm.util.f;
import com.bytedance.apm.util.k;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetIOException;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.services.apm.api.IHttpService;
import com.bytedance.ttnet.utils.RetrofitUtils;
import ff7.g;
import ff7.h;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultTTNetImpl implements IHttpService {
    public DefaultTTNetImpl() {
    }

    public static List<Header> convertHeaderMap(Map<String, String> r100) {
        ArrayList r101 = new ArrayList();
        if (r100 != null) goto L5;
    L13:
        h r102 = d.f190523k;
        if (r102 == null) goto L26;
        Map<String, String> r103 = r102.getRequestTagHeader();
        if (r103 == null) goto L26;
        if (r103.isEmpty() == true) goto L26;
        Iterator<Map.Entry<String, String>> r104 = r103.entrySet().iterator();
    L21:
        if (r104.hasNext() == false) goto L26;
        Map.Entry<String, String> r105 = r104.next();
        if (r105 == null) goto L21;
        r101.add(new Header(r105.getKey(), r105.getValue()));
    L26:
        return r101;
    L5:
        if (r100.isEmpty() == true) goto L13;
        Iterator<Map.Entry<String, String>> r106 = r100.entrySet().iterator();
    L8:
        if (r106.hasNext() == false) goto L13;
        Map.Entry<String, String> r107 = r106.next();
        if (r107 == null) goto L8;
        r101.add(new Header(r107.getKey(), r107.getValue()));
        goto L8
    }

    public static byte[] toByteArray(InputStream r100) throws IOException {
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();
        byte[] r102 = new byte[8192];
        if (r100 == null) goto L5;
    L6:
        int r103 = r100.read(r102);
        if ((-1) == r103) goto L9;
        r101.write(r102, 0, r103);
        goto L6
    L9:
        r100.close();
        return r101.toByteArray();
    L5:
        return new byte[0];
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    public ff7.b doGet(String r100, Map<String, String> r101) throws Exception {
        List<Header> r102 = convertHeaderMap(null);
        RetrofitMonitorService r103 = (RetrofitMonitorService) RetrofitUtils.createSsService(r100, RetrofitMonitorService.class);
        if (r102 != null) goto L5;
    L7:
        Call<TypedInput> r104 = r103.fetch(r100, r101, false);
    L8:
        SsResponse<TypedInput> r105 = r104.execute();
        byte[] r106 = toByteArray(r105.body().in());
        return new ff7.b(r105.code(), r106);
    L5:
        if (r102.size() <= 0) goto L7;
        r104 = r103.fetch(r100, r102, r101, false);
        goto L8
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    public g buildMultipartUpload(String r100, String r101, boolean r102) throws Exception {
        return new c(r100, null);
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    public ff7.b doPost(String r100, byte[] r101, Map<String, String> r102) throws Exception {
        RetrofitMonitorService r103 = (RetrofitMonitorService) RetrofitUtils.createSsService(r100, RetrofitMonitorService.class);
        List<Header> r104 = convertHeaderMap(r102);
        int r105 = 0;
        Call<TypedInput> r106 = r103.report(r100, new TypedByteArray("application/json; charset=utf-8", r101, new String[0]), r104, false);
        HashMap r107 = new HashMap();
        byte[] r108 = null;
        SsResponse<TypedInput> r109 = r106.execute();     // Catch: Throwable -> L11
        r108 = toByteArray(r109.body().in());     // Catch: Throwable -> L11
        List<Header> r110 = r109.headers();     // Catch: Throwable -> L11
        if (k.b(r110) == true) goto L9;
        Iterator<Header> r111 = r110.iterator();     // Catch: Throwable -> L11
    L7:
        if (r111.hasNext() == false) goto L9;
        Header r112 = r111.next();     // Catch: Throwable -> L11
        r107.put(r112.getName(), r112.getValue());     // Catch: Throwable -> L11
    L9:
        int r113 = r109.code();     // Catch: Throwable -> L11
    L21:
        return new ff7.b(r113, r107, r108);
    L11:
        th = move-exception;
        if ((th instanceof HttpResponseException) == false) goto L16;
        r105 = ((HttpResponseException) th).getStatusCode();     // Catch: Exception -> L22
    L16:
        if ((th instanceof CronetIOException) == false) goto L19;
        r113 = ((CronetIOException) th).getStatusCode();     // Catch: Exception -> L22
    L19:
        r113 = r105;
        goto L21
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    public ff7.b uploadFiles(String r100, List<File> r101, Map<String, String> r102) throws Exception {
        return f.a(r100, r101, r102);
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    public g buildMultipartUpload(String r100, String r101, boolean r102, Map<String, String> r103) throws Exception {
        return new c(r100, r103);
    }
}
