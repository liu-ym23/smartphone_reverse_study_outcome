package com.obric.autogui.util.e;

import android.content.Context;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.f;
import d.g;
import d.h.b.o;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: compiled from: TimestampFormatUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f31545a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final f f31546b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final f f31547c = null;

    public static /* synthetic */ SimpleDateFormat lambda$VrytS4peDYwTUOckCTaePhMWrLE() {
        return d();
    }

    public static /* synthetic */ SimpleDateFormat lambda$oTlipoHCl1Af87iz_DJhXYzQIZk() {
        return c();
    }

    private b() {
    }

    static {
        f31545a = new b();
        f31546b = g.a($$Lambda$b$oTlipoHCl1Af87iz_DJhXYzQIZk.INSTANCE);
        f31547c = g.a($$Lambda$b$VrytS4peDYwTUOckCTaePhMWrLE.INSTANCE);
    }

    private final SimpleDateFormat a() {
        return (SimpleDateFormat) ZeusTransformUtils.preCheckCast(f31546b.b(), SimpleDateFormat.class, "com.obric.aiagent.plugin");
    }

    private static final SimpleDateFormat c() {
        return new SimpleDateFormat("MM/dd", Locale.getDefault());
    }

    private final SimpleDateFormat b() {
        return (SimpleDateFormat) ZeusTransformUtils.preCheckCast(f31547c.b(), SimpleDateFormat.class, "com.obric.aiagent.plugin");
    }

    private static final SimpleDateFormat d() {
        return new SimpleDateFormat("yyyy/MM/dd", Locale.getDefault());
    }

    public final String a(long r6) {
        long r2 = 1000;
        long r0 = System.currentTimeMillis() / r2;
        Date r4 = new Date(r6 * r2);
        Date r7 = new Date(r0 * r2);
        int r8 = a(r4);
        int r1 = a(r7);
        if (a(r4, r7) == false) goto L6;
        String r5 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_today, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_today"));
        o.c(r5, "getString(...)");
        return r5;
    L6:
        if (r8 != r1) goto L8;
        String r9 = a().format(r4);
        o.a(r9);
        return r9;
    L8:
        String r10 = b().format(r4);
        o.a(r10);
        return r10;
    }

    private final boolean a(Date r3, Date r4) {
        Calendar r2 = Calendar.getInstance();
        Calendar r0 = Calendar.getInstance();
        r2.setTime(r3);
        r0.setTime(r4);
        if (r2.get(1) == r0.get(1)) goto L5;
    L7:
        return false;
    L5:
        if (r2.get(6) != r0.get(6)) goto L7;
        return true;
    }

    private final int a(Date r1) {
        Calendar r0 = Calendar.getInstance();
        r0.setTime(r1);
        return r0.get(1);
    }
}
