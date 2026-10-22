package com.bytedance.ai.model;

import android.app.Activity;
import android.app.AlertDialog;
import com.bytedance.ai.applet.app.foundation.performance.AppletPerformanceErrorCode;
import com.bytedance.ai.monitor.AppletErrorCode;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import m5.i1;
import m5.y0;

/* JADX INFO: loaded from: classes43.dex */
public final /* synthetic */ class p implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ai.applet.app.foundation.performance.n f36934a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AppletRuntime f36935b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f36936c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f36937d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f36938e;

    public /* synthetic */ p(com.bytedance.ai.applet.app.foundation.performance.n r100, AppletRuntime r101, String r102, String r103, String r104) {
        this.f36934a = r100;
        this.f36935b = r101;
        this.f36936c = r102;
        this.f36937d = r103;
        this.f36938e = r104;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r110) {
        com.bytedance.ai.applet.app.foundation.performance.n r100 = this.f36934a;
        final AppletRuntime r101 = this.f36935b;
        String r102 = this.f36936c;
        String r103 = this.f36937d;
        final String r104 = this.f36938e;
        String r111 = (String) r110;
        AtomicInteger r105 = AppletRuntime.f36716x;
        Intrinsics.checkNotNullParameter(r111, "errorMsg");
        if (r100 == null) goto L5;
        r100.c(AppletPerformanceErrorCode.SCRIPT_EVALUATION_ERROR, r111);
    L5:
        r101.f36725n = "evaluate Mainjs error --> " + r111;
        int r106 = com.bytedance.ai.utils.e.f37636a;
        Intrinsics.checkNotNullParameter(r111, "msg");
        Regex r107 = new Regex("Message:\\s(.*?)(?=,\\sStack:|$)");
        Regex r108 = new Regex("(?s)Stack:\\s(.*)");
        String r109 = null;
        MatchResult r112 = Regex.find$default(r107, r111, 0, 2, null);
        MatchResult r113 = Regex.find$default(r108, r111, 0, 2, null);
        if (r112 == null) goto L10;
        List<String> r114 = r112.getGroupValues();
        if (r114 == null) goto L10;
        String r115 = (String) ListProtector.get(r114, 1);
    L11:
        if (r113 == null) goto L15;
        List<String> r116 = r113.getGroupValues();
        if (r116 == null) goto L15;
        r109 = (String) ListProtector.get(r116, 1);
    L15:
        Pair r117 = new Pair(r115, r109);
        String r118 = (String) r117.component1();
        String r119 = (String) r117.component2();
        com.bytedance.ai.utils.f.j(r101.f36725n);
        AtomicBoolean r120 = com.bytedance.ai.monitor.b.f37194a;
        AppletErrorCode r121 = AppletErrorCode.JS_ERROR;
        if (r118 != null) goto L18;
        String r122 = "";
    L19:
        com.bytedance.ai.monitor.b.a(r121, r122, r119, new d(r101, r104));
        if (r102 == null) goto L27;
        if (r103 == null) goto L27;
        i1 r123 = y0.f512051a;
        if (r118 != null) goto L25;
        r118 = "";
    L25:
        y0.b(r102, r118, r121.getType(), r103);
    L27:
        if (f2.k.f475104b == false) goto L32;
        Activity r124 = f2.k.b();
        if (r124 == null) goto L32;
        final AlertDialog.Builder r125 = new AlertDialog.Builder(r124);
        r125.setTitle("MainJS evaluate Error");
        r125.setMessage(r101.f36725n);
        r125.setPositiveButton("Retry", new e(r101));
        r125.setNegativeButton("Cancel", new f());
        r124.runOnUiThread(new g(r125));
    L32:
        return Unit.INSTANCE;
    L18:
        r122 = r118;
    L10:
        r115 = null;
        goto L11
    }
}
