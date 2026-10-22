package bsc;

import kotlin.jvm.internal.BooleanCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import ouc.g0;
import ouc.i0;

/* JADX INFO: loaded from: classes41.dex */
public final class f extends i0<Boolean> {
    public f() {
        Intrinsics.checkNotNullParameter(BooleanCompanionObject.INSTANCE, "<this>");
        super(nuc.i.f520705a);
    }

    @Override // ouc.i0
    public final ouc.i a(ouc.i r100) {
        Intrinsics.checkNotNullParameter(r100, "element");
        Integer r101 = ouc.k.l((g0) r100);
        if (r101 == null) goto L10;
        int r102 = r101.intValue();
        boolean r103 = true;
        if (r102 == 1) goto L9;
        r103 = false;
    L9:
        return ouc.k.a(Boolean.valueOf(r103));
    L10:
        return r100;
    }
}
