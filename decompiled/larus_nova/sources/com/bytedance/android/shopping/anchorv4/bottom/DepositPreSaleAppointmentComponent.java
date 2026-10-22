package com.bytedance.android.shopping.anchorv4.bottom;

import com.bytedance.android.shopping.anchorv3.repository.api.AnchorV3Api;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class DepositPreSaleAppointmentComponent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y f165753a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final nl.d f165754b;

    public DepositPreSaleAppointmentComponent(y r100, nl.d r101) {
        Intrinsics.checkNotNullParameter(r100, "depositPreSaleAppointmentMeta");
        this.f165753a = r100;
        this.f165754b = r101;
    }

    public final void a(final Function0<Unit> r110, final Function0<Unit> r111) {
        AnchorV3Api.a r100 = AnchorV3Api.f165264a;
        y r101 = this.f165753a;
        String r102 = r101.f165896a;
        if (r102 != null) goto L5;
        String r103 = "";
    L6:
        String r104 = r101.f165897b;
        if (r104 != null) goto L9;
        String r105 = "";
    L10:
        String r106 = r101.f165898c;
        if (r106 != null) goto L13;
        String r107 = "";
    L15:
        if (r101.f165899d == false) goto L19;
        String r108 = "live";
    L17:
        String r109 = r108;
        String r112 = r101.f165901f;
        if (r112 != null) goto L25;
        String r113 = "";
    L26:
        Function1<Boolean, Unit> r114 = new DepositPreSaleAppointmentComponent$reserve$1(this, r111, r110);
        r100.getClass();
        AnchorV3Api.a.e(r103, r105, r107, r109, r113, r114);
        nl.d r115 = this.f165754b;
        if (r115 == null) goto L30;
        r115.b("5", null);
        return;
    L30:
        return;
    L25:
        r113 = r112;
        goto L26
    L19:
        if (r101.f165900e == false) goto L21;
        r108 = "video";
        goto L17
    L21:
        r108 = "other";
        goto L17
    L13:
        r107 = r106;
        goto L15
    L9:
        r105 = r104;
        goto L10
    L5:
        r103 = r102;
        goto L6
    }
}
