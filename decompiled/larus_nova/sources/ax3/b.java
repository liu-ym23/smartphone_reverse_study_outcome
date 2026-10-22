package ax3;

import com.bytedance.applog.monitor.v3.EventStage;
import com.bytedance.applog.monitor.v3.StageEventType;
import com.ss.android.common.applog.EventVerify;
import ex3.e;
import ex3.i;
import jx3.c;
import jx3.d;
import jx3.g;
import jx3.k;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public static int a(e r100, jx3.a r101) {
        if (r100.g() == true) goto L6;
    L4:
        boolean r102 = false;
    L20:
        if (r102 == true) goto L22;
        return 0;
    L22:
        if (r100.f474687a.f474645o == false) goto L24;
        return 3;
    L24:
        return 1;
    L6:
        if ((r101 instanceof c) == false) goto L9;
        r102 = r100.e(((c) r101).A);
        goto L20
    L9:
        if ((r101 instanceof jx3.e) == false) goto L12;
        r102 = r100.e(((jx3.e) r101).B);
        goto L20
    L12:
        if ((r101 instanceof d) == false) goto L15;
        r102 = r100.e(((d) r101).f500798z);
        goto L20
    L15:
        if ((r101 instanceof g) == false) goto L18;
        r102 = r100.e(EventVerify.TYPE_LAUNCH);
        goto L20
    L18:
        if ((r101 instanceof k) == false) goto L4;
        r102 = r100.e(EventVerify.TYPE_TERMINATE);
        goto L20
    }

    public static void b(e r110, EventStage r111, i r112) {
        if (r110.g() == true) goto L5;
        return;
    L5:
        r110.n(r112.f474713e, r112.f474714f, r111, r112.f474709a, r112.f474710b, r112.f474711c, r112.f474712d);
    }

    public static void c(e r100, EventStage r101, jx3.a r110) {
        if (r100.g() == true) goto L6;
        return;
    L6:
        if ((r110 instanceof c) == false) goto L9;
        r100.m(r101, ((c) r110).f500796z, String.valueOf(r110.f500774r), r110.f500758b, StageEventType.V1_EVENT);
        return;
    L9:
        if ((r110 instanceof jx3.e) == false) goto L12;
        r100.m(r101, ((jx3.e) r110).B, String.valueOf(r110.f500774r), r110.f500758b, StageEventType.V3_EVENT);
        return;
    L12:
        if ((r110 instanceof d) == false) goto L15;
        r100.m(r101, ((d) r110).f500798z, String.valueOf(r110.f500774r), r110.f500758b, StageEventType.LOG_DATA);
        return;
    L15:
        if ((r110 instanceof g) == false) goto L18;
        r100.m(r101, EventVerify.TYPE_LAUNCH, String.valueOf(r110.f500774r), r110.f500758b, StageEventType.LAUNCH);
        return;
    L18:
        if ((r110 instanceof k) == false) goto L25;
        r100.m(r101, EventVerify.TYPE_TERMINATE, String.valueOf(r110.f500774r), r110.f500758b, StageEventType.TERMINATE);
        return;
    }
}
