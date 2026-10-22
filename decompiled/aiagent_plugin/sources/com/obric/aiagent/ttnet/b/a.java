package com.obric.aiagent.ttnet.b;

import android.app.Application;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.obric.aiagent.platform.depend.IAppContext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.o.o;

/* JADX INFO: compiled from: AppLocaleUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f22203a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final boolean f22204b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f22205c;

    private a() {
    }

    static {
        f22203a = new a();
        f22204b = o.a(Build.BRAND, "Xiaomi", true);
    }

    public final String a() {
        String r0 = f22205c;
        if (r0 != null) goto L22;
        a r3 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
        String r4 = null;
        Object r1 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getSystemService("phone");     // Catch: Throwable -> L16
        if (ZeusTransformUtils.instanceOf(r1, TelephonyManager.class) == false) goto L8;
        TelephonyManager r2 = (TelephonyManager) ZeusTransformUtils.preCheckCast(r1, TelephonyManager.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
    L9:
        if (r2 == null) goto L18;
        String r5 = r2.getSimCountryIso();     // Catch: Throwable -> L16
        if (r5 == null) goto L18;
        if ((!o.d((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L18;
        r4 = r5;
    L18:
        String r6 = r4;
        f22205c = r6;
        return r6;
    L8:
        r2 = null;
    L16:
        th = move-exception;
        th.printStackTrace();
        goto L18
    L22:
        return r0;
    }
}
