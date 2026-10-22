package com.obric.matrix.platform.sdk.ones.commonmonitor.fps;

import android.os.Looper;
import android.util.Printer;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: CommonUtil.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f33650a = null;

    static {
        f33650a = new a();
    }

    private a() {
    }

    public final Printer a() {
        Field r0 = ZeusTransformUtils.forName("android.os.Looper", "com.obric.aiagent.plugin").getDeclaredField("mLogging");     // Catch: Exception -> L8
        r0.setAccessible(true);     // Catch: Exception -> L8
        Object r1 = r0.get(Looper.getMainLooper());     // Catch: Exception -> L8
        if (r1 == null) goto L7;
        return (Printer) ZeusTransformUtils.preCheckCast(r1, Printer.class, "com.obric.aiagent.plugin");
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.util.Printer");     // Catch: Exception -> L8
    L9:
        return (Printer) ZeusTransformUtils.preCheckCast(null, Printer.class, "com.obric.aiagent.plugin");
    }
}
