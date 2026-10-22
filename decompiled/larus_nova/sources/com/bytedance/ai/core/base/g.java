package com.bytedance.ai.core.base;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes43.dex */
public abstract class g extends d implements u4.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f36149f;

    public g() {
        super(0);
        ConcurrentHashMap<String, String> r100 = x4.a.f562420a;
        this.f36149f = UUID.randomUUID().toString();
    }
}
