package com.bytedance.android.latch.prefetch.internal;

import android.os.SystemClock;
import com.larus.apm.impl.protector.RunnableProtector;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List<String> f58470a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f58471b;

    public c(List<String> r100, b r101) {
        this.f58470a = r100;
        this.f58471b = r101;
    }

    public final void a() {
        long r100 = SystemClock.uptimeMillis();
        Iterator<String> r101 = this.f58470a.iterator();
    L4:
        if (r101.hasNext() == false) goto L19;
        String r102 = r101.next();
        b r103 = this.f58471b;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L12
        w r105 = new w(new JSONObject(r102));     // Catch: Throwable -> L12
        r103.f58458e.add(r105);     // Catch: Throwable -> L12
        i r106 = r103.f58456c;     // Catch: Throwable -> L12
        if (r106 == null) goto L9;
        r106.a(true, SystemClock.uptimeMillis() - r100);     // Catch: Throwable -> L12
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L12
    L10:
        Object r108 = Result.m9449constructorimpl(r107);     // Catch: Throwable -> L12
    L14:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);
        if (r109 == null) goto L4;
        b r110 = this.f58471b;
        k r111 = n.f58484a;
        Intrinsics.checkNotNullParameter("Failed to parse config json.", "message");
        n.f58484a.a("Failed to parse config json.", r109);
        i r112 = r110.f58456c;
        if (r112 == null) goto L4;
        Intrinsics.checkNotNullParameter(r109, "<this>");
        StringWriter r113 = new StringWriter();
        r109.printStackTrace(new PrintWriter(r113));
        r113.toString();
        r112.a(false, -1);
        goto L4
    L9:
        r107 = null;
    L12:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
