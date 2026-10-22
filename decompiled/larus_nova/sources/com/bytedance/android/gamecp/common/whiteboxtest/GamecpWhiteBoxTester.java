package com.bytedance.android.gamecp.common.whiteboxtest;

import com.bytedance.android.livesdk.diagnose.DiagnoseResult;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import wu.t2;

/* JADX INFO: loaded from: classes44.dex */
public final class GamecpWhiteBoxTester {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f57332d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f57333a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedList<String> f57334b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<d> f57335c;

    public static final class a {
        public static GamecpWhiteBoxTester a() {
            return (GamecpWhiteBoxTester) GamecpWhiteBoxTester.f57332d.getValue();
        }
    }

    static {
        f57332d = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, GamecpWhiteBoxTester$Companion$instance$2.INSTANCE);
    }

    public final String b() {
        String r100 = "";
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L9
        String r102 = this.f57334b.getLast();     // Catch: Throwable -> L9
        if (r102 == null) goto L7;
        r100 = r102;
    L7:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L11:
        return r100;
    L9:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    public GamecpWhiteBoxTester() {
        boolean r100 = true;
        LocalTestManager.a(new Class[]{uv.a.class});
        if (cs.a.a() == true) goto L5;
    L7:
        r100 = false;
    L8:
        this.f57333a = r100;
        this.f57334b = new LinkedList();
        this.f57335c = new ArrayList();
        return;
    L5:
        if (t2.f561392a.getValue().a() == false) goto L7;
        goto L7
    }

    public final void a(d r100) {
        if (this.f57333a == false) goto L22;
        if (r100 != null) goto L7;
        return;
    L7:
        if (Intrinsics.areEqual(r100.getScene(), b()) == false) goto L10;
        r100.a();
    L10:
        if (Intrinsics.areEqual(r100.getPriority(), DiagnoseResult.DIAGNOSE_LEVEL_P0) == true) goto L12;
        return;
    L12:
        if (this.f57333a == false) goto L32;
        Iterator<d> r101 = this.f57335c.iterator();
    L16:
        if (r101.hasNext() == false) goto L33;
        d r102 = r101.next();
        if ((!Intrinsics.areEqual(r100, r102)) == false) goto L16;
        if (Intrinsics.areEqual(r102.getScene(), b()) == false) goto L16;
        r102.a();
        goto L16
    L33:
        return;
    L32:
        return;
    }

    public final void c(d r100) {
        if (this.f57333a == false) goto L8;
        if (r100 == null) goto L9;
        this.f57335c.remove(r100);
        return;
    L9:
        return;
    }
}
