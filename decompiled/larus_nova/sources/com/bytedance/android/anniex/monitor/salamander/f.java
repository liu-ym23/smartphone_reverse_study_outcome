package com.bytedance.android.anniex.monitor.salamander;

import android.webkit.WebView;
import b36.j;
import com.bytedance.anniex.bd.foundation.impl.u;
import com.bytedance.rts.foundation.q;
import com.bytedance.rts.foundation.r;
import com.bytedance.salamander.anniex.a7;
import com.bytedance.salamander.anniex.x7;
import com.bytedance.salamander.anniex.z5;
import java.util.ArrayList;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class f extends j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f41017a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Boolean f41018b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f41019c;

    public f() {
    }

    @Override // android.webkit.WebChromeClient
    public final void onProgressChanged(WebView r100, int r110) {
        super.onProgressChanged(r100, r110);
        if (com.bytedance.android.monitorV2.util.h.d() == true) goto L5;
        return;
    L5:
        boolean r101 = false;
        if (r100 == null) goto L13;
        String r102 = r100.getUrl();
        if (r102 == null) goto L13;
        if (Intrinsics.areEqual(this.f41019c, r102) == true) goto L13;
        this.f41019c = r102;
        this.f41018b = null;
        this.f41017a = false;
    L13:
        if (this.f41017a == false) goto L15;
        return;
    L15:
        if (r110 < 15) goto L78;
        if (r100 != null) goto L19;
        return;
    L19:
        if (r100.getUrl() != null) goto L21;
    L23:
        boolean r111 = false;
    L24:
        if (r111 == true) goto L27;
        r100 = null;
    L27:
        if (r100 == null) goto L76;
        String r112 = r100.getUrl();
        String r103 = "";
        if (r112 == null) goto L61;
        if (this.f41018b != null) goto L48;
        x7.f268509a.getClass();
        Intrinsics.checkNotNullParameter(r112, "urlString");
        int r104 = a7.f267970a;
        int r105 = u.f190155c;     // Catch: Throwable -> L69
        u r113 = u.a.a(r112);     // Catch: Throwable -> L69
        if (r113 == null) goto L46;
        String r114 = r113.b();     // Catch: Throwable -> L69
        if (r114 == null) goto L46;
        z5.f268541a.getClass();     // Catch: Throwable -> L69
        Set<String> r106 = z5.a.a().f267999e;     // Catch: Throwable -> L69
        ArrayList<String> r115 = r.f(r114, ".", -1);     // Catch: Throwable -> L69
        int r107 = 0;
    L41:
        if (r107 > (com.bytedance.rts.foundation.j.d(r115) - 1)) goto L46;
        if (q.a(r106, com.bytedance.rts.foundation.j.g(com.bytedance.rts.foundation.j.l(r115, r107, com.bytedance.rts.foundation.j.d(r115)), ".")) == true) goto L44;
        r107 = r107 + 1;
        goto L41
    L44:
        boolean r116 = true;
    L47:
        this.f41018b = Boolean.valueOf(r116);
    L46:
        r116 = false;
    L48:
        Boolean r117 = this.f41018b;
        if (r117 != null) goto L51;
    L56:
        String r118 = null;
    L57:
        if (r118 == null) goto L61;
        r103 = r118;
        goto L61
    L51:
        if (r117.booleanValue() == true) goto L54;
        r117 = null;
    L54:
        if (r117 == null) goto L56;
        r117.booleanValue();
        r118 = zz2.b.a(r100.getContext(), "", "SlardarHybrid('config',{sendCommonParams:{},monitors:{StaticErrorMonitor:{ignore:[]},StaticPerformanceMonitor:{slowSession:8000,sampleRate:0.1},FPSMonitor:{interval:3000},MemoryMonitor:{interval:3000},PerformanceMonitor:{interval:100,checkPoint:['DOMContentLoaded','load']}}});", true);
    L61:
        if (r103.length() <= 0) goto L63;
        r101 = true;
    L63:
        if (r101 == true) goto L65;
        return;
    L65:
        if (r100.getSettings().getJavaScriptEnabled() == true) goto L67;
        r100.getSettings().setJavaScriptEnabled(true);
    L67:
        r100.evaluateJavascript(r103, null);
        this.f41017a = true;
        return;
    L76:
        return;
    L21:
        if (r100.getContext() == null) goto L23;
        r111 = true;
        goto L24
    }
}
