package com.bumptech.glide.load.model;

import java.util.Map;

/* JADX INFO: loaded from: classes39.dex */
public interface Headers {
    public static final Headers DEFAULT = null;
    public static final Headers NONE = null;

    Map<String, String> getHeaders();

    static {
        NONE = new AnonymousClass1();
        DEFAULT = new LazyHeaders.Builder().build();
    }
}
