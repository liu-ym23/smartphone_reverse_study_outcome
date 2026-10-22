package com.danikula.videocache.headers;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class EmptyHeadersInjector implements HeaderInjector {
    public EmptyHeadersInjector() {
    }

    @Override // com.danikula.videocache.headers.HeaderInjector
    public Map<String, String> addHeaders(String r10) {
        return new HashMap();
    }
}
