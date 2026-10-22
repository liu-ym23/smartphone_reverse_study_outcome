package cm;

import java.util.Iterator;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class b {
    public static final void a(JSONObject r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$merge");
        Intrinsics.checkNotNullParameter(r101, "json");
        Iterator<String> r102 = r101.keys();
    L4:
        if (r102.hasNext() == false) goto L10;
        String r103 = r102.next();
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L8
        Result.m9449constructorimpl(r100.putOpt(r103, r101.opt(r103)));     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L4
    }
}
