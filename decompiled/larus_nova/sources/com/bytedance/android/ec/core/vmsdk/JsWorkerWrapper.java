package com.bytedance.android.ec.core.vmsdk;

import com.bytedance.vmsdk.worker.JsWorker;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class JsWorkerWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList<Pair<String, String>> f45754a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f45755b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f45756c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f45757d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile boolean f45758e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final JsWorker f45759f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f45760g;

    public static final class a {
    }

    static {
    }

    public final void c() {
    L3:
        if ((!this.f45754a.isEmpty()) == false) goto L16;
        Pair<String, String> r100 = this.f45754a.remove(0);     // Catch: ArrayIndexOutOfBoundsException -> L17
        String r101 = r100.getFirst();     // Catch: ArrayIndexOutOfBoundsException -> L17
        int r102 = r101.hashCode();     // Catch: ArrayIndexOutOfBoundsException -> L17
        if (r102 != (-907685685)) goto L7;
        if (r101.equals("script") == false) goto L3;
        a(r100.getSecond());     // Catch: ArrayIndexOutOfBoundsException -> L17
        goto L3
    L7:
        if (r102 != 108417) goto L3;
        if (r101.equals("msg") == false) goto L3;
        e(r100.getSecond());     // Catch: ArrayIndexOutOfBoundsException -> L17
        goto L3
    }

    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "script");
        this.f45759f.evaluateJavaScript(r100);
    }

    public final void e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        if (d("msg", r100) == false) goto L5;
        return;
    L5:
        this.f45759f.postMessage(r100);
    }

    public JsWorkerWrapper(JsWorker r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "jsWorker");
        Intrinsics.checkNotNullParameter(r101, "name");
        this.f45759f = r100;
        this.f45760g = r101;
        this.f45754a = new CopyOnWriteArrayList();
        r100.setOnErrorCallback(new AnonymousClass1(this));
        this.f45755b = new AtomicBoolean(false);
        this.f45756c = new AtomicBoolean(false);
    }

    public final void b(String r110, String... r111) {
        Intrinsics.checkNotNullParameter(r110, "name");
        Intrinsics.checkNotNullParameter(r111, "params");
        String r112 = r110 + '(' + ArraysKt.joinToString$default(r111, ",", null, null, 0, null, JsWorkerWrapper$executeJsFunction$script$1.INSTANCE, 30, null) + ')';
        if (d("script", r112) == false) goto L5;
        return;
    L5:
        a(r112);
    }

    public final boolean d(String r100, String r101) {
        if (this.f45757d == true) goto L6;
        this.f45754a.add(TuplesKt.to(r100, r101));
        return true;
    L6:
        c();
        return false;
    }
}
