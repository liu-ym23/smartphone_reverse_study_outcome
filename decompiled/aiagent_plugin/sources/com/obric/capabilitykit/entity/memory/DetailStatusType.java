package com.obric.capabilitykit.entity.memory;

/* JADX INFO: loaded from: classes4.dex */
public final class DetailStatusType {
    public static final int FAIL = 3;
    public static final int FAIL_ILLEGAL = 4;
    public static final DetailStatusType INSTANCE = null;
    public static final int LOADING = 1;
    public static final int NOTHING = 0;
    public static final int SUCCESS = 2;

    static {
        INSTANCE = new DetailStatusType();
    }

    private DetailStatusType() {
    }
}
