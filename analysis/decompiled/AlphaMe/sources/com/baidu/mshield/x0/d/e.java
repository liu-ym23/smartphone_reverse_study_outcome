package com.baidu.mshield.x0.d;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mshield.x0.EngineImpl;

/* loaded from: classes.dex */
public final class e {
    public static String a(Context context) {
        return EngineImpl.getInstance(context).getPropertyByType("arid");
    }

    public static String b(Context context) {
        try {
            String strF = new com.baidu.mshield.x0.l.c(context).f();
            return !TextUtils.isEmpty(strF) ? strF : "";
        } catch (Throwable th) {
            d.a(th);
            return "";
        }
    }
}
