package com.bytedance.android.live.livepkaudience.rtc;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.config.pd1;
import com.bytedance.live.livelink.kmp.api.core.mixer.RTCWaterMarkRegion;
import com.larus.nova.R;
import dl0.n;
import gy.f;
import io.reactivex.disposables.CompositeDisposable;
import java.util.HashMap;
import kotlin.Unit;

/* JADX INFO: loaded from: classes46.dex */
public final class d {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final float f82216f = 0.0f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final double f82217g = 0.0d;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final double f82218h = 0.0d;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final double f82219i = 0.0d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bitmap f82220a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Bitmap f82221b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap<String, Bitmap> f82222c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CompositeDisposable f82223d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f82224e;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f82225a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f82226b;

        public a() {
        }
    }

    public static final class b {
    }

    static {
        f82216f = pd1.f120971a.getValue().floatValue() + 0.17f;
        f82217g = 0.25d;
        f82218h = 0.40625d;
        f82219i = (((double) 360) * 0.25d) / ((double) 640);
    }

    public final void c() {
        CompositeDisposable r100 = this.f82223d;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        gy.c.f483309c2.getClass();
        gy.c r101 = gy.c.a.a();
        if (r101 == null) goto L11;
        f r102 = r101.getRtcManager();
        if (r102 == null) goto L12;
        r102.n();
        return;
    L12:
        return;
    }

    public d() {
        this.f82220a = BitmapFactory.decodeResource(s1.getResources(), R.drawable.ttlive_pk_guest_empty_stream_icon);
        this.f82221b = BitmapFactory.decodeResource(s1.getResources(), R.drawable.ttlive_pk_self_audience_empty_stream_icon);
        this.f82222c = new HashMap();
        this.f82223d = new CompositeDisposable();
        a r100 = new a();
        r100.f82225a = 288;
        r100.f82226b = 288;
        Unit r101 = Unit.INSTANCE;
        this.f82224e = r100;
    }

    public static String a(int r100) {
        return n.d() + "_" + String.valueOf(r100);
    }

    public static void d(int r100) {
        gy.c.f483309c2.getClass();
        gy.c r101 = gy.c.a.a();
        if (r101 == null) goto L7;
        f r102 = r101.getRtcManager();
        if (r102 == null) goto L7;
        r102.k(a(r100));
    L7:
        gy.c r103 = gy.c.a.a();
        if (r103 == null) goto L13;
        f r104 = r103.getRtcManager();
        if (r104 == null) goto L14;
        r104.o();
        return;
    L14:
        return;
    }

    public static void b(Bitmap r110, int r111) {
        RTCWaterMarkRegion r100 = new RTCWaterMarkRegion();
        ti6.f r101 = new ti6.f();
        double r102 = f82217g;
        double r103 = f82219i;
        r101.f546164f = r102;
        r101.f546165g = r103;
        double r104 = ((double) r111) * r102;
        double r105 = (((double) f82216f) + f82218h) - r103;
        r101.f546162d = r104;
        r101.f546163e = r105;
        r101.f546173o = 0;
        r101.a("0");
        r100.f255235a = (float) r101.f546162d;
        r100.f255237c = (float) r101.f546164f;
        r100.f255236b = (float) r101.f546163e;
        r100.f255238d = (float) r101.f546165g;
        r100.f255239e = 0;
        r100.f255242h = r110;
        gy.c.f483309c2.getClass();
        gy.c r112 = gy.c.a.a();
        if (r112 == null) goto L7;
        f r113 = r112.getRtcManager();
        if (r113 == null) goto L7;
        r113.i(a(r111), r100, System.currentTimeMillis() * ((long) 1000));
    L7:
        gy.c r114 = gy.c.a.a();
        if (r114 == null) goto L13;
        f r115 = r114.getRtcManager();
        if (r115 == null) goto L14;
        r115.o();
        return;
    L14:
        return;
    }
}
