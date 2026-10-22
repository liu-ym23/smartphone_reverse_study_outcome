package com.amap.api.location;

import com.amap.api.location.AMapLocationClientOption;
import com.autonavi.aps.amapapi.utils.CoreUtil;

/* loaded from: classes.dex */
public class a implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public boolean f17204a = false;

    /* renamed from: b, reason: collision with root package name */
    public int f17205b = 2;

    /* renamed from: c, reason: collision with root package name */
    public int f17206c = 0;

    /* renamed from: d, reason: collision with root package name */
    public String f17207d = "UNKNOWN";

    /* renamed from: e, reason: collision with root package name */
    public long f17208e = 0;

    /* renamed from: f, reason: collision with root package name */
    public boolean f17209f = false;

    /* renamed from: g, reason: collision with root package name */
    public AMapLocationClientOption.AMapLocationMode f17210g = AMapLocationClientOption.AMapLocationMode.Hight_Accuracy;

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public a clone() {
        a aVar = new a();
        try {
            super.clone();
        } catch (Throwable unused) {
        }
        try {
            aVar.f(this.f17205b);
            aVar.d(this.f17206c);
            aVar.k(this.f17204a);
            aVar.i(this.f17208e);
            aVar.j(this.f17207d);
            aVar.h(this.f17210g);
            aVar.g(this.f17209f);
        } catch (Throwable th) {
            CoreUtil.reportError(th, "AMapLocationQualityReport", "clone");
        }
        return aVar;
    }

    public void d(int i10) {
        this.f17206c = i10;
    }

    public void f(int i10) {
        this.f17205b = i10;
    }

    public void g(boolean z10) {
        this.f17209f = z10;
    }

    public void h(AMapLocationClientOption.AMapLocationMode aMapLocationMode) {
        this.f17210g = aMapLocationMode;
    }

    public void i(long j10) {
        this.f17208e = j10;
    }

    public void j(String str) {
        this.f17207d = str;
    }

    public void k(boolean z10) {
        this.f17204a = z10;
    }
}
