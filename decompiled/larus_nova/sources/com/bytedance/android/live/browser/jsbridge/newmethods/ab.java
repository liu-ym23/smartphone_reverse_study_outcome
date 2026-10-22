package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.livesdkapi.auth.AuthReportEvent;
import com.bytedance.android.livesdkapi.auth.IAuthGuideService;
import com.bytedance.android.livesdkapi.auth.INewAuthReport;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes45.dex */
public final class ab<T> implements sy.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ za f63300a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ za.b f63301b;

    public ab(za r100, za.b r101) {
        this.f63300a = r100;
        this.f63301b = r101;
    }

    @Override // sy.a
    public final void invoke(Object r100) {
        String r101 = (String) r100;
        za r102 = this.f63300a;
        za.b r103 = this.f63301b;
        r102.getClass();
        boolean r104 = false;
        if (StringsKt.equals$default(r103.a(), "pop_click", false, 2, null) == false) goto L8;
        if (Intrinsics.areEqual(r103.b(), AuthReportEvent.BTN_DOUYIN) == false) goto L8;
    L10:
        INewAuthReport r105 = ((IAuthGuideService) jc1.k.n(IAuthGuideService.class)).report();
        String r106 = this.f63301b.a();
        if (r106 == null) goto L28;
        int r107 = r106.hashCode();
        if (r107 == (-1257301478)) goto L22;
        if (r107 == 652651563) goto L19;
        return;
    L19:
        if (r106.equals("pop_show") == false) goto L25;
        r105.logAuthDialogShow(r104, this.f63301b.c());
        return;
    L25:
        return;
    L22:
        if (r106.equals("pop_click") == false) goto L27;
        r105.logAuthDialogClick(r104, this.f63301b.b(), this.f63301b.c());
        return;
    L27:
        return;
    L28:
        return;
    L8:
        if (r101.length() <= 0) goto L10;
        r104 = true;
        goto L10
    }
}
