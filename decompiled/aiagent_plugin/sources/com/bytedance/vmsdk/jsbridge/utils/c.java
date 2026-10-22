package com.bytedance.vmsdk.jsbridge.utils;

import androidx.core.util.f;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: DynamicFromArray.java */
/* JADX INFO: loaded from: classes.dex */
public class c implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final f.b<c> f11764a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ReadableArray f11765b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f11766c;

    static {
        f11764a = new f.b(10);
    }

    private c() {
        this.f11766c = -1;
    }

    public static c a(ReadableArray r3, int r4) {
        ReadableArray r5 = (ReadableArray) ZeusTransformUtils.wrapperContextForParams(r3, ReadableArray.class, "com.obric.aiagent.plugin");
        c r0 = (c) ZeusTransformUtils.preCheckCast(f11764a.a(), c.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
        r0 = new c();
    L5:
        r0.f11765b = r5;
        r0.f11766c = r4;
        return r0;
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.b
    public ReadableType getType() {
        ReadableArray r0 = this.f11765b;
        if (r0 == null) goto L7;
        return r0.getType(this.f11766c);
    L7:
        throw new IllegalStateException("This dynamic value has been recycled");
    }
}
