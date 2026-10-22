package com.bytedance.apm.impl.net;

import B.b;
import B.e;
import androidx.annotation.Nullable;
import com.bytedance.services.apm.api.IHttpService;
import java.io.File;
import java.util.List;
import java.util.Map;
import p0.InterfaceC1789a;
import u0.c;

/* loaded from: classes2.dex */
public class UserHttpServiceImpl implements IHttpService {
    private static String METHOD_GET = "GET";
    private static String METHOD_POST = "POST";
    private InterfaceC1789a iNetworkClient;

    public UserHttpServiceImpl(InterfaceC1789a interfaceC1789a) {
        this.iNetworkClient = interfaceC1789a;
    }

    private b changeToHttpResponse(p0.b bVar) {
        return new b(bVar.f5536a, null, bVar.b);
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    public e buildMultipartUpload(String str, String str2, boolean z10) {
        return new c(str, str2, null, z10);
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    public b doGet(String str, Map<String, String> map) {
        ((o0.b) this.iNetworkClient).f5412a.b.getNetworkClient().getClass();
        return changeToHttpResponse(null);
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    public b doPost(String str, byte[] bArr, Map<String, String> map) {
        f2.b bVarC = ((o0.b) this.iNetworkClient).f5412a.b.getNetworkClient().c(str, bArr, map);
        return changeToHttpResponse(new p0.b(bVarC.f4434a, bVarC.b));
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    @Nullable
    public b uploadFiles(String str, List<File> list, Map<String, String> map) {
        return S0.b.f(str, list, map);
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    public e buildMultipartUpload(String str, String str2, Map<String, String> map, boolean z10) {
        return new c(str, str2, map, z10);
    }
}
