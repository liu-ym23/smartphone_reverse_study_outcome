package com.bytedance.crypto.obfuscated;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f7861a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<j> f7862b;

    public i(int r3, List<j> r4) {
        List<j> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        this.f7861a = r3;
        this.f7862b = r5;
    }
}
