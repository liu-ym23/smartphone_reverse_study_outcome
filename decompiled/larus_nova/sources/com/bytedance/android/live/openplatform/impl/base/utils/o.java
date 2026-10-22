package com.bytedance.android.live.openplatform.impl.base.utils;

import android.os.SystemClock;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.network.CustomApiServerException;
import com.bytedance.android.live.core.utils.f2;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes46.dex */
public final class o implements Consumer<Throwable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Unit> f84072a;

    public o(Function0<Unit> r100) {
        this.f84072a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Throwable r110) {
        Throwable r111 = r110;
        if ((r111 instanceof ApiServerException) == false) goto L34;
        String r100 = ((ApiServerException) r111).getPrompt();
        if (r100 != null) goto L7;
    L10:
        boolean r101 = true;
    L12:
        if ((!r101) == true) goto L15;
        r100 = null;
    L15:
        if (r100 == null) goto L24;
        long r102 = SystemClock.uptimeMillis();
        if ((true ^ Intrinsics.areEqual(r100, p.f84073a)) == false) goto L19;
    L20:
        p.f84073a = r100;
        p.f84074b = r102;
        f2.c(r100, 0);
        Function0<Unit> r103 = this.f84072a;
        if (r103 == null) goto L24;
        Unit r104 = r103.invoke();
        goto L24
    L19:
        if ((r102 - p.f84074b) >= 3500) goto L20;
    L24:
        if ((r111 instanceof CustomApiServerException) == false) goto L35;
        int r105 = qo0.a.f534145a;
        StringBuilder r106 = new StringBuilder("url: ");
        CustomApiServerException r112 = (CustomApiServerException) r111;
        String r107 = r112.getUrl();
        String r108 = "null";
        if (r107 != null) goto L28;
        r107 = "null";
    L28:
        r106.append(r107);
        r106.append(", logId: ");
        String r113 = r112.getXTtLogId();
        if (r113 == null) goto L32;
        r108 = r113;
    L32:
        r106.append(r108);
        qo0.a.b("ApiErrorHandler", r106.toString(), null);
        return;
    L35:
        return;
    L7:
        if (StringsKt.isBlank(r100) == true) goto L10;
        r101 = false;
        goto L12
    }
}
