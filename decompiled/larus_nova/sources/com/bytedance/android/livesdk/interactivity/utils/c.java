package com.bytedance.android.livesdk.interactivity.utils;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Map;
import kotlin.Unit;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes9.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f141350a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f141351b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f141352c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f141353d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f141354e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f141355f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f141356g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f141357h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f141358i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f141359j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f141360k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f141361l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f141362m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f141363n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f141364o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final DecimalFormat f141365p;

    public abstract void b(Map<String, String> r100);

    public void d() {
    }

    public void e() {
        this.f141352c = 0;
        this.f141353d = 0;
        this.f141354e = 0;
        this.f141356g = 0;
        this.f141355f = 0;
        this.f141357h = 0;
        this.f141358i = 0;
    }

    public c() {
        this.f141350a = 1;
        this.f141351b = 2;
        this.f141359j = "_pv";
        this.f141360k = "_arrive_delay_time";
        this.f141361l = "_show_delay_time";
        this.f141362m = "_pv_male";
        this.f141363n = "_pv_female";
        this.f141364o = "_pv_range_avg";
        DecimalFormat r100 = new DecimalFormat("0.##");
        DecimalFormatSymbols r101 = new DecimalFormatSymbols();
        r101.setDecimalSeparator('.');
        Unit r102 = Unit.INSTANCE;
        r100.setDecimalFormatSymbols(r101);
        this.f141365p = r100;
    }

    public void a(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f141352c++;
        long r101 = this.f141355f;
        IBaseUser r102 = r100.x();
        if (r102 == null) goto L9;
        py.d r103 = r102.getUserHonor();
        if (r103 == null) goto L9;
        int r104 = r103.getLevel();
    L10:
        this.f141355f = r101 + ((long) r104);
        IBaseUser r105 = r100.x();
        if (r105 == null) goto L18;
        int r106 = r105.getGender();
        if (r106 != this.f141350a) goto L16;
        this.f141353d++;
    L16:
        if (r106 != this.f141351b) goto L18;
        this.f141354e++;
    L18:
        this.f141356g += r100.f133154o.longValue();
        this.f141357h += r100.f133155p.longValue();
        return;
    L9:
        r104 = 0;
        goto L10
    }

    public final float c(long r110, long r111) {
        if (r111 == 0) goto L11;
        return CastFloatProtector.parseFloat(StringsKt.replace$default(this.f141365p.format(Float.valueOf(r110 / r111)), ",", ".", false, 4, null));
    L7:
        ALogger.e("PublicScreenStatTrack", "get avg NumberFormat error,stat:" + r110 + " , pv:" + r111);
        return 0.0f;
    L11:
        return 0.0f;
    }
}
