package com.bytedance.apm.impl;

import com.bytedance.apm.util.k;
import com.bytedance.apm.util.s;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.mime.TypedFile;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.bytedance.retrofit2.mime.TypedString;
import com.bytedance.ttnet.utils.RetrofitUtils;
import ff7.g;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class c implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f190565a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, String> f190566b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, TypedOutput> f190567c;

    @Override // ff7.g
    public final ff7.b finish() throws IOException {
        String r100 = this.f190565a;
        Map<String, TypedOutput> r101 = this.f190567c;
        Map<String, String> r102 = this.f190566b;
        RetrofitMonitorService r103 = (RetrofitMonitorService) RetrofitUtils.createSsService(r100, RetrofitMonitorService.class);
        HashMap r104 = new HashMap();
        SsResponse<TypedInput> r105 = r103.uploadFiles(r100, r101, DefaultTTNetImpl.convertHeaderMap(r102)).execute();     // Catch: Throwable -> L11
        byte[] r106 = DefaultTTNetImpl.toByteArray(r105.body().in());     // Catch: Throwable -> L11
        List<Header> r107 = r105.headers();     // Catch: Throwable -> L11
        if (k.b(r107) == true) goto L9;
        Iterator<Header> r108 = r107.iterator();     // Catch: Throwable -> L11
    L7:
        if (r108.hasNext() == false) goto L9;
        Header r109 = r108.next();     // Catch: Throwable -> L11
        r104.put(r109.getName(), r109.getValue());     // Catch: Throwable -> L11
    L9:
        int r110 = r105.code();     // Catch: Throwable -> L11
    L19:
        return new ff7.b(r110, r104, r106);
    L11:
        th = move-exception;
        th.printStackTrace();
        JSONObject r111 = new JSONObject();
        r111.put("message", th.getMessage());     // Catch: Exception -> L15
        r111.put(com.bytedance.android.ec.core.event.a.KEY_EXCEPTION, th.getMessage() + s.a(th, 30));     // Catch: Exception -> L15
        r111.put("exception_object", th.toString());     // Catch: Exception -> L15
    L17:
        r106 = r111.toString().getBytes();
        r110 = 100001;
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L17
    }

    public c(String r100, Map r101) {
        this.f190567c = new HashMap();
        this.f190565a = r100;
        this.f190566b = r101;
    }

    @Override // ff7.g
    public final void a(String r100, String r101) {
        Map<String, TypedOutput> r102 = this.f190567c;
        HashMap r103 = (HashMap) r102;
        r103.put(r100, new TypedString(r101));
    }

    @Override // ff7.g
    public final void c(String r100, Map r101) throws IOException {
        Map<String, TypedOutput> r102 = this.f190567c;
        HashMap r103 = (HashMap) r102;
        r103.put("params.txt", new a(r100, r101));
    }

    @Override // ff7.g
    public final void b(String r100, File r101, String r102, Map<String, String> r103) throws IOException {
        Map<String, TypedOutput> r104 = this.f190567c;
        HashMap r105 = (HashMap) r104;
        r105.put(r100, new b(r103, new TypedFile(null, r101)));
    }
}
