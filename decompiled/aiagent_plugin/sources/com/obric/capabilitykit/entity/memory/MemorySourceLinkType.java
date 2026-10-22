package com.obric.capabilitykit.entity.memory;

/* JADX INFO: loaded from: classes4.dex */
public final class MemorySourceLinkType {
    public static final String DEEPLINK = "deeplink";
    public static final MemorySourceLinkType INSTANCE = null;
    public static final String INTENT = "intent";
    public static final String URL = "url";

    static {
        INSTANCE = new MemorySourceLinkType();
    }

    private MemorySourceLinkType() {
    }
}
