package com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku;

import android.graphics.PointF;
import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.ugc.live.barrage.barrage.AbsBarrage;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class b implements AbsBarrage.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f108953a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f108954b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f108955c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function2<AbsBarrage, PointF, Unit> f108956d;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f108957a;

        public a(b r100) {
            this.f108957a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f108957a.f108953a = true;     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(View r100, Function2<? super AbsBarrage, ? super PointF, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "onClickMethod");
        this.f108955c = r100;
        this.f108956d = r101;
        this.f108953a = true;
        this.f108954b = new a(this);
    }
}
