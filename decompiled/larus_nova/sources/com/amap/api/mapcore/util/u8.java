package com.amap.api.mapcore.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;

/* JADX INFO: loaded from: classes28.dex */
public class u8 extends v8 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected int f28132b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected long f28133c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f28134d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Context f28135e;

    @Override // com.amap.api.mapcore.util.v8
    public boolean c() {
        long r100 = 0;
        if (this.f28133c != 0) goto L10;
        String r101 = q6.b(this.f28135e, this.f28134d);
        if (TextUtils.isEmpty(r101) == true) goto L8;
        r100 = CastLongProtector.parseLong(r101);
    L8:
        this.f28133c = r100;
    L10:
        if ((System.currentTimeMillis() - this.f28133c) >= this.f28132b) goto L13;
        return false;
    L13:
        return true;
    }

    @Override // com.amap.api.mapcore.util.v8
    public void a(boolean r100) {
        v8 r101 = this.f28253a;
        if (r101 == null) goto L5;
        r101.a(r100);
    L5:
        if (r100 == false) goto L8;
        String r102 = this.f28134d;
        long r103 = System.currentTimeMillis();
        this.f28133c = r103;
        Context r104 = this.f28135e;
        String r105 = String.valueOf(r103);
        int r106 = q6.f27894c;
        SharedPreferences.Editor r107 = r104.getSharedPreferences("AMSKLG_CFG", 0).edit();
        r107.putString(r102, r105);
        r107.apply();
        return;
    }

    public u8(Context r100, int r101, String r102, v8 r103) {
        super(r103);
        this.f28132b = r101;
        this.f28134d = r102;
        this.f28135e = r100;
    }
}
