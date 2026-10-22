package com.bytedance.android.livesdk.chatroom.vs_base.base.view;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f117975a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f117976b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<View, Unit> f117977c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f117978d;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f117979a;

        public a(c r100) {
            this.f117979a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f117979a.f117975a = true;     // Catch: Throwable -> L4
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
        if (this.f117975a == true) goto L7;
        return;
    L7:
        this.f117975a = false;
        r100.postDelayed(this.f117976b, this.f117978d);
        this.f117977c.invoke(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(Function1<? super View, Unit> r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "onClickMethod");
        this.f117977c = r100;
        this.f117978d = r101;
        this.f117975a = true;
        this.f117976b = new a(this);
    }
}
