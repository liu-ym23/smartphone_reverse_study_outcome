package com.bytedance.android.live.room.incentiveinfo;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class i implements u81.g<w81.b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f99699a;

    public i(g r100) {
        this.f99699a = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // u81.g
    public final void c(w81.b r100) {
        w81.b r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "data");
        g r102 = this.f99699a;
        r102.getClass();
        ALogger.d("IncentiveInfoManager", "change tab dataSet.the operate is " + r101.f558617c + "\tthe tabData is " + r101.f558618d);
        int r103 = h.f99698a[r101.f558617c.ordinal()];
        if (r103 == 1) goto L29;
        if (r103 != 2) goto L7;
        ((ArrayList) r102.f99691d).remove(r101.f558618d);
        r102.b();
        d r104 = r102.f99689b;
        if (r104 == null) goto L18;
        com.bytedance.android.live.room.incentiveinfo.datamonitor.d<w81.a> r105 = r104.f99625b;
        if (r105 == null) goto L18;
        r105.onChange();
    L18:
        x81.b<u81.d> r106 = r102.f99690c;
        int r107 = r106.a(r101.f558618d.f558613e.getValue(), r101.f558618d.f558612d);
        if (r107 == (-1)) goto L41;
        Pair r108 = r106.f562884a[r107];
        if (r108 == null) goto L27;
        u81.d r109 = (u81.d) r108.getSecond();
        if (r109 == null) goto L27;
        IncentiveInfoLayout.LayoutParams r110 = x81.a.a(r109.a());
        if (r110 == null) goto L27;
        r110.f99615a = null;
        r110.f99616b = null;
    L27:
        r106.f562884a[r107] = 0;
        return;
    L41:
        return;
    L7:
        if (r103 == 3) goto L10;
        return;
    L10:
        if (((ArrayList) r102.f99691d).contains(r101.f558618d) == false) goto L12;
        List<w81.a> r111 = r102.f99691d;
        ((w81.a) ListProtector.get(r111, ((ArrayList) r111).indexOf(r101.f558618d))).f558609a = r101.f558618d.f558609a;
        r102.b();
    L12:
        r102.f99688a.d(((ArrayList) r102.f99691d).indexOf(r101.f558618d));
        return;
    L29:
        if (((ArrayList) r102.f99691d).contains(r101.f558618d) == false) goto L31;
        List<w81.a> r112 = r102.f99691d;
        ((w81.a) ListProtector.get(r112, ((ArrayList) r112).indexOf(r101.f558618d))).f558609a = r101.f558618d.f558609a;
        r102.b();
    L37:
        if (r101.f558615a == false) goto L43;
        r102.f99688a.c(((ArrayList) r102.f99691d).indexOf(r101.f558618d), r101.f558616b);
        return;
    L43:
        return;
    L31:
        List<w81.a> r113 = r102.f99691d;
        w81.a r114 = new w81.a(r101.f558618d.f558613e);
        w81.a r115 = r101.f558618d;
        r114.f558610b = r115.f558610b;
        r114.f558609a = r115.f558609a;
        r114.f558611c = r115.f558611c;
        r114.f558612d = r115.f558612d;
        Unit r116 = Unit.INSTANCE;
        ((ArrayList) r113).add(r114);
        d r117 = r102.f99689b;
        if (r117 == null) goto L37;
        com.bytedance.android.live.room.incentiveinfo.datamonitor.d<w81.a> r118 = r117.f99625b;
        if (r118 == null) goto L37;
        r118.onChange();
        goto L37
    }
}
