package com.bytedance.android.live.revlink.impl.monitor;

import android.os.SystemClock;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.revlink.impl.pk.service.f;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import gd0.v;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import mz0.i;
import mz0.n;
import or2.j;
import or2.m;

/* JADX INFO: loaded from: classes47.dex */
public final class RevLinkStallReporter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f93043a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f93044b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f93045c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f93046d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f93047e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f93048f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f93049g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f93050h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Disposable f93051i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f93052j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f93053k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f93054l;

    public final void d() {
        if (d51.c.A0.c().getEnable() == true) goto L5;
        return;
    L5:
        j r100 = ((or2.e) vh6.c.b(or2.e.class)).getCurrentClient();
        if (r100 == null) goto L22;
        m r101 = r100.d();
        if (Intrinsics.areEqual(r101.d().getValue(), Boolean.TRUE) == false) goto L11;
        this.f93044b = SystemClock.uptimeMillis();
    L11:
        if (this.f93046d == true) goto L23;
        this.f93046d = true;
        MutableLiveData<String> r102 = r101.getSeiUpdate();
        if (r102 == null) goto L15;
        r102.observeForever((Observer) this.f93052j.getValue());
    L15:
        MutableLiveData<Boolean> r103 = r101.d();
        if (r103 == null) goto L18;
        r103.observeForever((Observer) this.f93053k.getValue());
    L18:
        MutableLiveData<Boolean> r104 = r101.c();
        if (r104 == null) goto L24;
        r104.observeForever((Observer) this.f93054l.getValue());
        return;
    L24:
        return;
    L23:
        return;
    }

    public final void e() {
        this.f93044b = -1;
        this.f93045c = -1;
        this.f93048f = -1;
        this.f93049g = null;
        Disposable r100 = this.f93051i;
        if (r100 == null) goto L6;
        r100.dispose();
        return;
    }

    public RevLinkStallReporter() {
        this.f93043a = "";
        this.f93044b = -1;
        this.f93045c = -1;
        this.f93048f = -1;
        this.f93050h = -1;
        this.f93052j = LazyKt.lazy(new RevLinkStallReporter$seiObs$2(this));
        this.f93053k = LazyKt.lazy(new RevLinkStallReporter$onStallStart$2(this));
        this.f93054l = LazyKt.lazy(new RevLinkStallReporter$onStallEnd$2(this));
    }

    public static final void a(RevLinkStallReporter r110, String r111) {
        long r100 = r110.f93048f;
        long r101 = r110.f93045c;
        long r102 = 0;
        if (1 <= r101) goto L6;
    L11:
        long r103 = r110.f93044b;
        if (1 <= r103) goto L15;
    L19:
        Disposable r104 = r110.f93051i;
        if (r104 == null) goto L22;
        r104.dispose();
    L22:
        r110.f93051i = Observable.timer(3000, TimeUnit.MILLISECONDS).subscribe(new d(r110, r111), e.f93066a);
        return;
    L15:
        if (r100 <= r103) goto L19;
        if (r101 >= 0) goto L19;
        r110.f93049g = r111;
        return;
    L6:
        if (r100 < r101) goto L11;
        if (Math.abs(r100 - r101) >= d51.c.A0.c().x2()) goto L10;
        r102 = r110.f93045c - r110.f93044b;
    L10:
        r110.f(r111, r102);
        r110.e();
    }

    public static final boolean b(RevLinkStallReporter r100, String r101) {
        r100.getClass();
        if (r101 != null) goto L5;
    L10:
        boolean r102 = false;
    L11:
        if (r102 == true) goto L24;
        if (r101 != null) goto L14;
    L19:
        boolean r103 = false;
    L20:
        if (r103 == true) goto L25;
        return false;
    L25:
        return true;
    L14:
        if (StringsKt.contains$default(r101, "\\\"ver\\\":6", false, 2, null) == true) goto L17;
        r101 = null;
    L17:
        if (r101 == null) goto L19;
        r103 = true;
        goto L20
    L24:
        return true;
    L5:
        if (StringsKt.contains$default(r101, "\\\"ver\\\":2", false, 2, null) == false) goto L7;
        String r104 = r101;
    L8:
        if (r104 == null) goto L10;
        r102 = true;
        goto L11
    L7:
        r104 = null;
        goto L8
    }

    public static final boolean c(RevLinkStallReporter r100, String r101) {
        r100.getClass();
        if (r101 != null) goto L5;
        return false;
    L5:
        if (StringsKt.contains$default(r101, "TTLiveSDK_Android", false, 2, null) == false) goto L7;
    L12:
        boolean r102 = true;
    L13:
        if (r102 == true) goto L16;
        r101 = null;
    L16:
        if (r101 == null) goto L20;
        return true;
    L20:
        return false;
    L7:
        if (StringsKt.contains$default(r101, "TTLiveSDK_IOS", false, 2, null) == true) goto L12;
        if (StringsKt.contains$default(r101, "TTLiveSDK_Windows", false, 2, null) == true) goto L12;
        r102 = false;
        goto L13
    }

    public final void f(String r100, long r101) {
        if ((SystemClock.uptimeMillis() - this.f93050h) >= d51.c.A0.c().g6()) goto L5;
        return;
    L5:
        HashMap r102 = new HashMap();
        com.bytedance.android.live.revlink.impl.service.internal.a r103 = com.bytedance.android.live.revlink.impl.global.b.n();
        if (r103 == null) goto L8;
        int r104 = r103.getCurrentMode();
    L9:
        com.bytedance.android.live.revlink.impl.multianchor.vm.b r105 = null;
        f r106 = null;
        String r107 = "normal";
        if (v.a(r104, 4) == false) goto L20;
        com.bytedance.android.live.revlink.impl.global.c r108 = com.bytedance.android.live.revlink.impl.global.b.k();
        if (r108 == null) goto L14;
        r106 = r108.Aa();
    L14:
        if (r106 == null) goto L19;
        String r109 = r106.getConnectSource();
        if (r109 == null) goto L19;
        r107 = r109;
    L19:
        r102.put(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_SOURCE, r107);
    L31:
        com.bytedance.android.live.revlink.impl.control.d r110 = com.bytedance.android.live.revlink.impl.global.b.f();
        String r111 = "";
        if (r110 == null) goto L35;
        String r112 = r110.getRequestId();
        if (r112 == null) goto L35;
    L36:
        r102.put("request_id", r112);
        r102.put("channel_id", this.f93043a);
        d31.d r113 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r113 == null) goto L42;
        String r114 = r113.a();
        if (r114 == null) goto L42;
        r111 = r114;
    L42:
        r102.put("anchor_connect_status", r111);
        if (r101 < 0) goto L45;
        String r115 = String.valueOf(r101);
    L46:
        r102.put("connection_stuck_duration", r115);
        n r116 = new n();
        Map<String, String> r117 = r116.f516447a;
        Intrinsics.checkNotNullParameter(r117, "map");
        Intrinsics.checkNotNullParameter(r102, "map");
        r117.putAll(r102);
        mz0.m r118 = new mz0.m();
        r118.b(LogCommon.ROOM);
        r118.b(LogCommon.PAGE_SOURCE_LOG);
        List<Object> r119 = r116.f516448b;
        ArrayList r120 = (ArrayList) r119;
        r120.addAll(r118.f516446a);
        cy0.e.f465759a.getClass();
        cy0.j r121 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r122 = com.bytedance.android.scope.m.b(r121).a(Reflection.getOrCreateKotlinClass(i.class));
        Intrinsics.checkNotNull(r122);
        ((i) ((f80.a) r122)).w3(r100, r116.f516447a, r116.f516448b);
        this.f93050h = SystemClock.uptimeMillis();
        return;
    L45:
        r115 = "0";
    L35:
        r112 = "";
        goto L36
    L20:
        com.bytedance.android.live.revlink.impl.global.c r123 = com.bytedance.android.live.revlink.impl.global.b.k();
        if (r123 == null) goto L23;
        r105 = r123.rb();
    L23:
        if (r105 == null) goto L30;
        com.bytedance.live.datacontext.m<String> r124 = r105.getConnectionSource();
        if (r124 == null) goto L30;
        String r125 = r124.getValue();
        if (r125 == null) goto L30;
        r107 = r125;
    L30:
        r102.put(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_SOURCE, r107);
        goto L31
    L8:
        r104 = 0;
        goto L9
    }
}
