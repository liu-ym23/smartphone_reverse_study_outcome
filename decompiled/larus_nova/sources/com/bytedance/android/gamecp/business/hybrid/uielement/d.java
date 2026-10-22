package com.bytedance.android.gamecp.business.hybrid.uielement;

import android.util.Log;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import wu.p3;

/* JADX INFO: loaded from: classes44.dex */
public final class d {
    public static final boolean a(Map<String, ? extends Object> r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "TAG");
        boolean r102 = p3.f561369a.getValue().b();
        if (r102 == false) goto L30;
        boolean r103 = false;
        if (r100 != null) goto L7;
    L10:
        boolean r104 = true;
    L11:
        if (r104 == true) goto L31;
        String r105 = "";
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L15
        r105 = JSONObjectProtectorUtils.getString(new JSONObject(String.valueOf(r100.get("cardInfo"))), "id");     // Catch: Throwable -> L15
        Object r107 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L15
    L17:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 == null) goto L20;
        yr.c.b(r101, "cardType convert error " + Log.getStackTraceString(r108));
    L20:
        List<String> r109 = p3.f561369a.getValue().a();
        List<String> r110 = r109;
        if (r110 != null) goto L23;
    L24:
        r103 = true;
    L25:
        if (r103 == false) goto L27;
        return r102;
    L27:
        return !r109.contains(r105);
    L23:
        if (r110.isEmpty() == false) goto L25;
    L15:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L17
    L31:
        return r102;
    L7:
        if (r100.isEmpty() == true) goto L10;
        r104 = false;
        goto L11
    L30:
        return r102;
    }
}
