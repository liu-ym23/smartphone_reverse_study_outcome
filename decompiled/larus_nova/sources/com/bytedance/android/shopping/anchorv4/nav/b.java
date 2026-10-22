package com.bytedance.android.shopping.anchorv4.nav;

import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnchorV4NavArea f167112a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.shopping.anchorv3.widget.f f167113b;

    public b(AnchorV4NavArea r100, com.bytedance.android.shopping.anchorv3.widget.f r101) {
        this.f167112a = r100;
        this.f167113b = r101;
    }

    public final void a() {
        AnchorV4SearchEditView r100 = this.f167112a.getSearchEditView();
        com.bytedance.android.shopping.anchorv3.widget.f r101 = this.f167113b;
        r100.f165575c = r101;
        Lazy r102 = ECAppInfoService.f48110a;
        boolean r103 = true;
        int r104 = 0;
        Boolean r105 = null;
        if (we.a.f559330a == false) goto L15;
        if (r101 == null) goto L6;
        String r106 = r101.f165611i;
    L7:
        if (r106 != null) goto L9;
    L12:
        boolean r107 = true;
    L13:
        if (r107 == false) goto L15;
        boolean r108 = true;
    L16:
        if (r101 == null) goto L18;
        Boolean r109 = r101.f165603a;
    L19:
        Boolean r110 = Boolean.TRUE;
        if ((!Intrinsics.areEqual(r109, r110)) == false) goto L28;
        if (r101 == null) goto L23;
        Boolean r111 = r101.f165604b;
    L25:
        if ((!Intrinsics.areEqual(r111, r110)) == false) goto L28;
        if (r108 == true) goto L28;
    L29:
        if (r103 == false) goto L37;
        if (r101 == null) goto L33;
        r105 = r101.f165606d;
    L33:
        if (Intrinsics.areEqual(r105, r110) == false) goto L38;
        com.bytedance.android.shopping.anchorv3.widget.e r112 = r100.f165576d;
        if (r112 == null) goto L38;
        String r113 = r101.f165605c;
        r112.c();
    L38:
        r100.setVisibility(r104);
        r100.setOnClickListener(new com.bytedance.android.shopping.anchorv3.widget.a(r100));
        return;
    L37:
        r104 = 4;
        goto L38
    L23:
        r111 = null;
    L28:
        r103 = false;
        goto L29
    L18:
        r109 = null;
        goto L19
    L9:
        if (r106.length() == 0) goto L12;
        r107 = false;
        goto L13
    L6:
        r106 = null;
    L15:
        r108 = false;
        goto L16
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
