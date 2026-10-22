package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.core.AMapException;

/* JADX INFO: loaded from: classes28.dex */
public final class t extends b<String, Integer> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Context f26641j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f26642k;

    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    public final String a() {
        StringBuffer r100 = new StringBuffer("key=");
        r100.append(bi.f(this.f26641j));
        r100.append("&userid=");
        r100.append(this.f26642k);
        return r100.toString();
    }

    @Override // com.amap.api.col.s.cy
    public final String h() {
        return h.c() + "/nearby/data/delete";
    }

    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    public final /* synthetic */ Object a(String r100) throws AMapException {
        return 0;
    }

    public t(Context r100, String r101) {
        super(r100, r101);
        this.f26641j = r100;
        this.f26642k = r101;
    }
}
