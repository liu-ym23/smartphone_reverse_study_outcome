package com.amap.api.mapcore.util;

/* JADX INFO: loaded from: classes28.dex */
@c7(tableName = "update_item_file")
class p1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @d7(fieldName = "mAdcode", fieldType = 6)
    private String f27818a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @d7(fieldName = "file", fieldType = 6)
    private String f27819b;

    public p1() {
        this.f27818a = "";
        this.f27819b = "";
    }

    public String a() {
        return this.f27819b;
    }

    public static String a(String r100) {
        return "mAdcode='" + r100 + "'";
    }

    public p1(String r100, String r101) {
        this.f27818a = r100;
        this.f27819b = r101;
    }
}
