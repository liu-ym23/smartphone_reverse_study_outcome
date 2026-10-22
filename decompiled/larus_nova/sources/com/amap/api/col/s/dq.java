package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;

/* JADX INFO: loaded from: classes28.dex */
public final class dq extends dt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f26585a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f26586b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f26587d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f26588e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f26589f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f26590g;

    @Override // com.amap.api.col.s.dt
    public final boolean a() {
        if (bm.p(this.f26586b) != 1) goto L6;
        return true;
    L6:
        if (this.f26587d == true) goto L8;
        return false;
    L8:
        String r100 = ce.a(this.f26586b, this.f26585a);
        if (TextUtils.isEmpty(r100) == false) goto L11;
        return true;
    L11:
        String[] r101 = r100.split("\\|");
        if (r101 != null) goto L14;
    L22:
        ce.b(this.f26586b, this.f26585a);
        return true;
    L14:
        if (r101.length < 2) goto L22;
        String r102 = r101[0];
        if (bs.a(System.currentTimeMillis(), "yyyyMMdd").equals(r102) == true) goto L19;
    L21:
        return true;
    L19:
        if (CastIntegerProtector.parseInt(r101[1]) < this.f26589f) goto L21;
        return false;
    }

    @Override // com.amap.api.col.s.dt
    public final int b() {
        if (bm.p(this.f26586b) == 1) goto L6;
        int r100 = this.f26588e;
        if (r100 <= 0) goto L6;
    L11:
        dt r101 = this.f26596c;
        if (r101 != null) goto L14;
        return r100;
    L14:
        return Math.max(r100, r101.b());
    L6:
        r100 = this.f26590g;
        if (r100 <= 0) goto L10;
        if (r100 < Integer.MAX_VALUE) goto L11;
    L10:
        r100 = Integer.MAX_VALUE;
        goto L11
    }

    @Override // com.amap.api.col.s.dt
    public final void a(int r100) {
        if (bm.p(this.f26586b) != 1) goto L5;
        return;
    L5:
        String r101 = bs.a(System.currentTimeMillis(), "yyyyMMdd");
        String r102 = ce.a(this.f26586b, this.f26585a);
        if (TextUtils.isEmpty(r102) == true) goto L16;
        String[] r103 = r102.split("\\|");
        if (r103 != null) goto L10;
    L15:
        ce.b(this.f26586b, this.f26585a);
        goto L16
    L10:
        if (r103.length < 2) goto L15;
        if (r101.equals(r103[0]) == false) goto L16;
        r100 = r100 + CastIntegerProtector.parseInt(r103[1]);
    L16:
        ce.a(this.f26586b, this.f26585a, r101 + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + r100);
    }

    public dq(Context r100, boolean r101, int r102, int r103, String r104, int r105) {
        this.f26586b = r100;
        this.f26587d = r101;
        this.f26588e = r102;
        this.f26589f = r103;
        this.f26585a = r104;
        this.f26590g = r105;
    }
}
