package com.bytedance.crypto.obfuscated;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.cert.X509Certificate;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f7851a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f7852b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<X509Certificate> f7853c;

    public g(byte[] r3, byte[] r4, List<X509Certificate> r5) {
        List<X509Certificate> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        this.f7851a = r3;
        this.f7852b = r4;
        this.f7853c = r6;
    }
}
