package com.amap.api.mapcore.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;

/* JADX INFO: loaded from: classes28.dex */
public class s8 extends v8 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f27962b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f27963c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f27964d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f27965e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f27966f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f27967g;

    @Override // com.amap.api.mapcore.util.v8
    public int a() {
        if (o5.h(this.f27963c) == 1) goto L6;
        int r100 = this.f27965e;
        if (r100 <= 0) goto L6;
    L11:
        v8 r101 = this.f28253a;
        if (r101 != null) goto L14;
        return r100;
    L14:
        return Math.max(r100, r101.a());
    L6:
        r100 = this.f27967g;
        if (r100 <= 0) goto L10;
        if (r100 < Integer.MAX_VALUE) goto L11;
    L10:
        r100 = Integer.MAX_VALUE;
        goto L11
    }

    @Override // com.amap.api.mapcore.util.v8
    public boolean c() {
        if (o5.h(this.f27963c) != 1) goto L6;
        return true;
    L6:
        if (this.f27964d == true) goto L8;
        return false;
    L8:
        String r100 = q6.b(this.f27963c, this.f27962b);
        if (TextUtils.isEmpty(r100) == false) goto L11;
        return true;
    L11:
        String[] r101 = r100.split("\\|");
        if (r101 != null) goto L14;
    L22:
        Context r102 = this.f27963c;
        String r103 = this.f27962b;
        SharedPreferences.Editor r104 = r102.getSharedPreferences("AMSKLG_CFG", 0).edit();
        r104.remove(r103);
        r104.apply();
        return true;
    L14:
        if (r101.length < 2) goto L22;
        String r105 = r101[0];
        if (x5.a(System.currentTimeMillis(), "yyyyMMdd").equals(r105) == true) goto L19;
    L21:
        return true;
    L19:
        if (CastIntegerProtector.parseInt(r101[1]) < this.f27966f) goto L21;
        return false;
    }

    @Override // com.amap.api.mapcore.util.v8
    public void a(int r100) {
        if (o5.h(this.f27963c) != 1) goto L5;
        return;
    L5:
        String r101 = x5.a(System.currentTimeMillis(), "yyyyMMdd");
        String r102 = q6.b(this.f27963c, this.f27962b);
        if (TextUtils.isEmpty(r102) == true) goto L16;
        String[] r103 = r102.split("\\|");
        if (r103 != null) goto L10;
    L15:
        Context r104 = this.f27963c;
        String r105 = this.f27962b;
        SharedPreferences.Editor r106 = r104.getSharedPreferences("AMSKLG_CFG", 0).edit();
        r106.remove(r105);
        r106.apply();
        goto L16
    L10:
        if (r103.length < 2) goto L15;
        if (r101.equals(r103[0]) == false) goto L16;
        r100 = r100 + CastIntegerProtector.parseInt(r103[1]);
    L16:
        Context r107 = this.f27963c;
        String r108 = this.f27962b;
        String r109 = r101 + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + r100;
        SharedPreferences.Editor r110 = r107.getSharedPreferences("AMSKLG_CFG", 0).edit();
        r110.putString(r108, r109);
        r110.apply();
    }

    public s8(Context r100, boolean r101, int r102, int r103, String r104, int r105) {
        this.f27962b = "iKey";
        this.f27967g = 0;
        a(r100, r101, r102, r103, r104, r105);
    }

    private void a(Context r100, boolean r101, int r102, int r103, String r104, int r105) {
        this.f27963c = r100;
        this.f27964d = r101;
        this.f27965e = r102;
        this.f27966f = r103;
        this.f27962b = r104;
        this.f27967g = r105;
    }
}
