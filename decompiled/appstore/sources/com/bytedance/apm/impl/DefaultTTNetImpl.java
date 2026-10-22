package com.bytedance.apm.impl;

import com.bytedance.apm.util.ListUtils;
import com.bytedance.apm.util.e;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetIOException;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.services.apm.api.IHttpService;
import com.bytedance.services.apm.api.IMultipartUploader;
import com.bytedance.ttnet.utils.RetrofitUtils;
import f6.f;
import g6.a;
import i6.c;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import q1.d;

/* JADX INFO: loaded from: classes.dex */
public class DefaultTTNetImpl implements IHttpService {
    public DefaultTTNetImpl() {
    }

    public static List<a> convertHeaderMap(Map<String, String> r10) {
        ArrayList r11 = new ArrayList();
        if (r10 != null) goto L5;
    L13:
        return r11;
    L5:
        if (r10.isEmpty() == true) goto L13;
        Iterator<Map.Entry<String, String>> r12 = r10.entrySet().iterator();
    L8:
        if (r12.hasNext() == false) goto L13;
        Map.Entry<String, String> r13 = r12.next();
        if (r13 == null) goto L8;
        r11.add(new a(r13.getKey(), r13.getValue()));
        goto L8
    }

    public static byte[] toByteArray(InputStream r10) throws IOException {
        ByteArrayOutputStream r11 = new ByteArrayOutputStream();
        byte[] r12 = new byte[8192];
        if (r10 == null) goto L5;
    L6:
        int r13 = r10.read(r12);
        if ((-1) == r13) goto L9;
        r11.write(r12, 0, r13);
        goto L6
    L9:
        r10.close();
        return r11.toByteArray();
    L5:
        return new byte[0];
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    public IMultipartUploader buildMultipartUpload(String r10, String r11, boolean r12) throws Exception {
        return new d(r10, r11, r12, null);
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    public c doGet(String r10, Map<String, String> r11) throws Exception {
        f r12 = ((RetrofitMonitorService) RetrofitUtils.f(r10, RetrofitMonitorService.class)).fetch(r10, r11, false).execute();
        byte[] r13 = toByteArray(((TypedInput) r12.a()).in());
        return new c(r12.b(), r13);
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    public c doPost(String r10, byte[] r11, Map<String, String> r12) throws Exception {
        RetrofitMonitorService r13 = (RetrofitMonitorService) RetrofitUtils.f(r10, RetrofitMonitorService.class);
        List<a> r14 = convertHeaderMap(r12);
        int r15 = 0;
        Call<TypedInput> r16 = r13.report(r10, new h6.f("application/json; charset=utf-8", r11, new String[0]), r14, false);
        HashMap r17 = new HashMap();
        byte[] r18 = null;
        f r19 = r16.execute();     // Catch: Throwable -> L9
        r18 = toByteArray(((TypedInput) r19.a()).in());     // Catch: Throwable -> L9
        List r20 = r19.d();     // Catch: Throwable -> L9
        if (ListUtils.b(r20) == true) goto L11;
        Iterator r21 = r20.iterator();     // Catch: Throwable -> L9
    L7:
        if (r21.hasNext() == false) goto L11;
        a r22 = (a) r21.next();     // Catch: Throwable -> L9
        r17.put(r22.a(), r22.b());     // Catch: Throwable -> L9
    L11:
        int r23 = r19.b();     // Catch: Throwable -> L9
    L22:
        return new c(r23, r17, r18);
    L9:
        th = move-exception;
        if ((th instanceof HttpResponseException) == false) goto L17;
        r15 = ((HttpResponseException) th).getStatusCode();     // Catch: Exception -> L23
    L17:
        if ((th instanceof CronetIOException) == false) goto L20;
        r23 = ((CronetIOException) th).getStatusCode();     // Catch: Exception -> L23
    L20:
        r23 = r15;
        goto L22
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    public c uploadFiles(String r10, List<File> r11, Map<String, String> r12) throws Exception {
        return e.a(r10, r11, r12);
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    public IMultipartUploader buildMultipartUpload(String r10, String r11, boolean r12, Map<String, String> r13) throws Exception {
        return new d(r10, r11, r12, r13);
    }
}
