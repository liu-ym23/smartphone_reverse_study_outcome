package com.obric.capabilitykit.entity.search;

/* JADX INFO: loaded from: classes4.dex */
public final class EntityChangeType {
    public static final int DELETE = 3;
    public static final int INSERT = 1;
    public static final EntityChangeType INSTANCE = null;
    public static final int UPDATE = 2;

    static {
        INSTANCE = new EntityChangeType();
    }

    private EntityChangeType() {
    }
}
