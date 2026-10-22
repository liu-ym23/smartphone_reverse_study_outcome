package com.bytedance.android.shopping.mall.widget;

import android.os.Handler;
import android.os.Looper;
import android.view.ViewConfiguration;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes13.dex */
public abstract class ECTouchEventDetector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f178614a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f178615b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f178616c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f178617d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f178618e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f178619f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final a f178620g;

    public final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Handler f178621a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ECTouchEventDetector f178622b;

        @Override // java.lang.Runnable
        public final void run() {
            this.f178622b.b();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(ECTouchEventDetector r100) {
            this.f178622b = r100;
            this.f178621a = new Handler(Looper.getMainLooper());
        }
    }

    public abstract void a();

    public abstract void b();

    public abstract void c(int r100, int r101, int r102, int r103);

    public ECTouchEventDetector() {
        this.f178614a = ViewConfiguration.getTapTimeout();
        this.f178615b = ViewConfiguration.getLongPressTimeout();
        this.f178616c = LazyKt.lazy(new ECTouchEventDetector$touchSlop$2(this));
        this.f178617d = Long.MAX_VALUE;
        this.f178618e = -1;
        this.f178619f = -1;
        this.f178620g = new a(this);
    }
}
