package com.bytedance.android.livesdk.utils;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class w0 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f159195a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f159196b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<View, Unit> f159197c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f159198d;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ w0 f159199a;

        public a(w0 r100) {
            this.f159199a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f159199a.f159195a = true;     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.f159195a == true) goto L7;
        return;
    L7:
        this.f159195a = false;
        r100.postDelayed(this.f159196b, this.f159198d);
        this.f159197c.invoke(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public w0(Function1<? super View, Unit> r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "onClickMethod");
        this.f159197c = r100;
        this.f159198d = r101;
        this.f159195a = true;
        this.f159196b = new a(this);
    }
}
