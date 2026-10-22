package com.amap.api.mapcore.util;

/* JADX INFO: loaded from: classes28.dex */
@c7(tableName = "update_item_download_info")
class o1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @d7(fieldName = "mAdcode", fieldType = 6)
    private String f27703a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @d7(fieldName = "fileLength", fieldType = 5)
    private long f27704b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @d7(fieldName = "splitter", fieldType = 2)
    private int f27705c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @d7(fieldName = "startPos", fieldType = 5)
    private long f27706d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @d7(fieldName = "endPos", fieldType = 5)
    private long f27707e;

    public o1() {
        this.f27703a = "";
        this.f27704b = 0;
        this.f27705c = 0;
        this.f27706d = 0;
        this.f27707e = 0;
    }

    public static String a(String r100) {
        return "mAdcode='" + r100 + "'";
    }

    public o1(String r100, long r101, int r102, long r103, long r104) {
        this.f27703a = r100;
        this.f27704b = r101;
        this.f27705c = r102;
        this.f27706d = r103;
        this.f27707e = r104;
    }
}
