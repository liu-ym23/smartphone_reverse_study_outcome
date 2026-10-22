package com.bytedance.android.annie.monitor.web;

import android.os.SystemClock;
import android.text.TextUtils;
import android.webkit.WebView;
import com.bytedance.android.monitorV2.webview.m;
import com.bytedance.ies.web.jsbridge2.TimeLineEvent;
import com.bytedance.ies.web.jsbridge2.c0;
import com.bytedance.ies.web.jsbridge2.o0;
import com.bytedance.ies.web.jsbridge2.u;
import java.lang.ref.SoftReference;
import java.util.Iterator;
import java.util.List;
import jz2.h;
import jz2.i;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class c implements u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SoftReference<WebView> f39642a;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ies.web.jsbridge2.u
    public final /* synthetic */ void b(c0 r100, int r101) {
    }

    public c(WebView r100) {
        Intrinsics.checkNotNullParameter(r100, "webview");
        this.f39642a = new SoftReference(r100);
    }

    public static i d(String r100, int r101, o0 r102) {
        long r103 = SystemClock.elapsedRealtime();
        i r104 = new i();
        r104.f501150a = r100;
        r104.f501151b = r101;
        List<TimeLineEvent> r105 = r102.f249419c;
        if (r105 == null) goto L12;
        Iterator<TimeLineEvent> r106 = r105.iterator();
    L6:
        if (r106.hasNext() == false) goto L12;
        TimeLineEvent r107 = r106.next();
        if (r107 == null) goto L6;
        if (Intrinsics.areEqual("label_create_java_call", r107.getLabel()) == false) goto L6;
        long r108 = r107.getElapsedTimestamp();
    L13:
        r104.f501155f = r108;
        if (r108 == 0) goto L16;
        r104.f501156g = r103;
        r104.f501154e = r103 - r108;
    L16:
        return r104;
    L12:
        r108 = 0;
        goto L13
    }

    @Override // com.bytedance.ies.web.jsbridge2.u
    public final void a(String r100, String r101, o0 r102) {
        WebView r103 = this.f39642a.get();
        if (r103 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L10;
        i r104 = d(r101, 1, r102);
        m.f163358f.p(r103, r104);
        return;
    }

    @Override // com.bytedance.ies.web.jsbridge2.u
    public final void c(String r100, String r110, int r111, String r112, o0 r113) {
        WebView r101 = this.f39642a.get();
        if (r101 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r110) == true) goto L26;
        int r102 = 0;
        if (r111 == 1) goto L14;
        if (r111 == 2) goto L13;
        if (r111 == 3) goto L12;
        int r103 = 0;
    L15:
        i r114 = d(r110, r103, r113);
        m r104 = m.f163358f;
        r104.p(r101, r114);
        if (r111 == 1) goto L22;
        if (r111 == 2) goto L21;
        if (r111 != 3) goto L23;
        r102 = -3;
    L23:
        h r115 = new h();
        r115.f501149c = r110;
        r115.f501147a = r102;
        r115.f501148b = r112;
        r104.o(r101, r115);
        return;
    L21:
        r102 = -2;
        goto L23
    L22:
        r102 = -1;
        goto L23
    L12:
        r103 = -3;
        goto L15
    L13:
        r103 = -2;
        goto L15
    L14:
        r103 = -1;
        goto L15
    }
}
