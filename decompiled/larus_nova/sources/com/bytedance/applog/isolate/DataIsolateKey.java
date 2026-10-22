package com.bytedance.applog.isolate;

import r27.a;

/* JADX INFO: loaded from: classes6.dex */
public final enum DataIsolateKey extends Enum<DataIsolateKey> {
    public static final DataIsolateKey USER_ID = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DataIsolateKey[] f192454a = null;
    private final String key;

    static {
        DataIsolateKey r100 = new DataIsolateKey();
        USER_ID = r100;
        f192454a = new DataIsolateKey[]{r100};
    }

    public DataIsolateKey() {
        super("USER_ID", 0);
        this.key = "user_id";
    }

    public static DataIsolateKey[] values() {
        return (DataIsolateKey[]) f192454a.clone();
    }

    public String getKey() {
        return this.key;
    }

    public static DataIsolateKey fromKey(String r100) {
        DataIsolateKey[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        DataIsolateKey r104 = r101[r103];
        if (r104.getKey().equals(r100) == true) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static DataIsolateKey valueOf(String r100) {
        return (DataIsolateKey) a.a(DataIsolateKey.class, r100);
    }
}
