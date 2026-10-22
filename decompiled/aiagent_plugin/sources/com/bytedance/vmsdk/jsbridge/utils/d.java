package com.bytedance.vmsdk.jsbridge.utils;

import androidx.core.util.f;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: DynamicFromMap.java */
/* JADX INFO: loaded from: classes.dex */
public class d implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final f.b<d> f11767a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ReadableMap f11768b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f11769c;

    static {
        f11767a = new f.b(10);
    }

    private d() {
    }

    public static d a(ReadableMap r3, String r4) {
        ReadableMap r5 = (ReadableMap) ZeusTransformUtils.wrapperContextForParams(r3, ReadableMap.class, "com.obric.aiagent.plugin");
        d r0 = (d) ZeusTransformUtils.preCheckCast(f11767a.a(), d.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
        r0 = new d();
    L5:
        r0.f11768b = r5;
        r0.f11769c = r4;
        return r0;
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.b
    public ReadableType getType() {
        ReadableMap r0 = this.f11768b;
        if (r0 == null) goto L9;
        String r1 = this.f11769c;
        if (r1 == null) goto L9;
        return r0.getType(r1);
    L9:
        throw new IllegalStateException("This dynamic value has been recycled");
    }
}
