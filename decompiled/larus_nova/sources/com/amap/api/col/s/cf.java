package com.amap.api.col.s;

import com.ss.android.downloadlib.constants.MimeType;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes28.dex */
public final class cf extends bp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte[] f26400a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f26401b;

    @Override // com.amap.api.col.s.cy
    public final Map<String, String> e() {
        return null;
    }

    @Override // com.amap.api.col.s.cy
    public final Map<String, String> f() {
        HashMap r100 = new HashMap();
        r100.put("Content-Type", MimeType.ZIP);
        r100.put("Content-Length", String.valueOf(this.f26400a.length));
        return r100;
    }

    @Override // com.amap.api.col.s.cy
    public final String h() {
        String r100 = bs.c(cc.f26372b);
        byte[] r101 = bs.a(cc.f26371a);
        byte[] r102 = new byte[r101.length + 50];
        System.arraycopy(this.f26400a, 0, r102, 0, 50);
        System.arraycopy(r101, 0, r102, 50, r101.length);
        return String.format(r100, new Object[]{"1", this.f26401b, "1", "open", bq.a(r102)});
    }

    @Override // com.amap.api.col.s.cy
    public final byte[] g() {
        return this.f26400a;
    }

    public cf(byte[] r100, String r101) {
        this.f26401b = "1";
        this.f26400a = (byte[]) r100.clone();
        this.f26401b = r101;
    }
}
