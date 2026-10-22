package com.bytedance.apm6.service.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: compiled from: HttpRequest.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f5447a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<String, String> f5448b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f5449c;

    public a(String r3, Map<String, String> r4, byte[] r5) {
        Map<String, String> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        this.f5447a = r3;
        this.f5448b = r6;
        this.f5449c = r5;
    }
}
