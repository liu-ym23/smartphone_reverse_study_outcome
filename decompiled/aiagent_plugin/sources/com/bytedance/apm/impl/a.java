package com.bytedance.apm.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: compiled from: HttpRequest.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f4658a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<String, String> f4659b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f4660c;

    public a(String r3, Map<String, String> r4, byte[] r5) {
        Map<String, String> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        this.f4658a = r3;
        this.f4659b = r6;
        this.f4660c = r5;
    }
}
