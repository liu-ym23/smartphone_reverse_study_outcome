package b78;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.MapsKt;
import kotlin.text.StringsKt;
import ouc.d0;
import ouc.k;

/* JADX INFO: loaded from: classes24.dex */
public final class g {
    public static final d0 a(String r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L12;
        return new d0(MapsKt.emptyMap());
    L12:
        if (StringsKt.startsWith$default(r100, "{", false, 2, null) == false) goto L25;
        if (StringsKt.endsWith$default(r100, com.alipay.sdk.m.u.i.f25855d, false, 2, null) == false) goto L25;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L18
        Object r103 = Result.m9449constructorimpl(k.n(ouc.a.f526798d.e(r100)));     // Catch: Throwable -> L18
    L20:
        d0 r104 = new d0(MapsKt.emptyMap());
        if (Result.m9455isFailureimpl(r103) == false) goto L29;
        r103 = r104;
    L29:
        return (d0) r103;
    L18:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L25:
        return new d0(MapsKt.emptyMap());
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }
}
