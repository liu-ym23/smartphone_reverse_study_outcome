package com.bytedance.apm.impl;

import B.b;
import B.e;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.services.apm.api.IHttpService;
import com.bytedance.ttnet.utils.RetrofitUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import n0.InterfaceC1737c;
import n0.d;

/* loaded from: classes2.dex */
public class DefaultTTNetImpl implements IHttpService {
    private List<Header> convertHeaderMap(Map<String, String> map) {
        ArrayList arrayList = new ArrayList();
        if (map != null && !map.isEmpty()) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry != null) {
                    arrayList.add(new Header(entry.getKey(), entry.getValue()));
                }
            }
        }
        return arrayList;
    }

    public static byte[] toByteArray(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        if (inputStream == null) {
            return new byte[0];
        }
        while (true) {
            int i = inputStream.read(bArr);
            if (-1 == i) {
                inputStream.close();
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, i);
        }
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    public e buildMultipartUpload(String str, String str2, boolean z10) {
        return new d(str);
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    public b doGet(String str, Map<String, String> map) {
        URL url = new URL(str);
        RetrofitUtils.createSsService(url.getProtocol() + "://" + url.getHost(), InterfaceC1737c.class).getClass();
        throw new ClassCastException();
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    public b doPost(String str, byte[] bArr, Map<String, String> map) {
        URL url = new URL(str);
        if (RetrofitUtils.createSsService(url.getProtocol() + "://" + url.getHost(), InterfaceC1737c.class) != null) {
            throw new ClassCastException();
        }
        convertHeaderMap(map);
        new TypedByteArray("application/json; charset=utf-8", bArr, new String[0]);
        throw null;
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    public b uploadFiles(String str, List<File> list, Map<String, String> map) {
        return S0.b.f(str, list, map);
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    public e buildMultipartUpload(String str, String str2, Map<String, String> map, boolean z10) {
        return new d(str);
    }
}
