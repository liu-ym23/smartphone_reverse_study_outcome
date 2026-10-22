package com.bytedance.common.utility;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class b extends d {
    public b() {
    }

    @Override // com.bytedance.common.utility.d
    public String get(String r10, Map r11, d.a r12) {
        throw new IOException("not implemented");
    }

    @Override // com.bytedance.common.utility.d
    public String post(String r10, List r11, Map r12, d.a r13) {
        throw new CommonHttpException(0, "not implemented");
    }

    @Override // com.bytedance.common.utility.d
    public String post(String r10, byte[] r11, Map r12, d.a r13) {
        throw new CommonHttpException(0, "not implemented");
    }
}
