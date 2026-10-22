package com.bytedance.android.livesdk.saas;

import android.content.Context;
import com.bytedance.android.livehostapi.IHostService;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import wa1.c;
import wa1.d;
import wa1.e;

/* JADX INFO: loaded from: classes11.dex */
public final class SaasSettingsInstaller {
    static {
    }

    @JvmStatic
    public static final void a(final IHostService r100) {
        Intrinsics.checkNotNullParameter(r100, "hostService");
        final Context r101 = r100.appContext().context();
        if (r101 != null) goto L5;
        return;
    L5:
        int r102 = c.f558801b;
        Function1<c, Unit> r103 = new SaasSettingsInstaller$init$1(r101, r100);
        Intrinsics.checkNotNullParameter(r103, "init");
        c r104 = new c();
        r103.invoke(r104);
        boolean r105 = e.f558807a;
        Intrinsics.checkNotNullParameter(r104, "builder");
        if (e.f558807a == true) goto L18;
        wa1.a r106 = d.f558803a;
        wa1.a r107 = r104.f558802a;
        d.f558803a = r107;
        if (r107 == null) goto L10;
        boolean r108 = r107.a();
    L11:
        d.f558804b = r108;
        wa1.a r109 = d.f558803a;
        if (r109 == null) goto L15;
        x60.c.a r110 = r109.c();
        if (r110 == null) goto L15;
    L16:
        d.f558805c = r110;
        e.f558807a = true;
        return;
    L15:
        r110 = new x60.c.a(false, false, false, false);
        goto L16
    L10:
        r108 = false;
        goto L11
    }
}
