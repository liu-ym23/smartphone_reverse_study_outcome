package com.bytedance.android.livesdk.gecko.offline;

import android.net.Uri;
import com.bytedance.android.live.core.setting.f1;
import com.bytedance.ies.bullet.kit.resourceloader.j;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.regex.Pattern;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class h {
    static {
    }

    public static boolean a(String r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if (f1.f65294a.getValue().booleanValue() == false) goto L29;
        j r101 = j.f246830a;
        Uri r102 = UriProtector.parse(r100);
        r101.getClass();
        if (r102 != null) goto L9;
    L22:
        boolean r103 = false;
    L23:
        if (r103 == false) goto L30;
        return true;
    L30:
        return false;
    L9:
        if (r102.getPath() == null) goto L22;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L13
        Pattern r105 = j.f246831b;     // Catch: Throwable -> L13
        String r106 = r102.getPath();     // Catch: Throwable -> L13
        Intrinsics.checkNotNull(r106);     // Catch: Throwable -> L13
        Object r107 = Result.m9449constructorimpl(Boolean.valueOf(r105.matcher(r106).find()));     // Catch: Throwable -> L13
    L15:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 == null) goto L18;
        r108.printStackTrace();
    L18:
        Boolean r109 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r107) == false) goto L21;
        r107 = r109;
    L21:
        r103 = ((Boolean) r107).booleanValue();
    L13:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    L29:
        return false;
    }
}
