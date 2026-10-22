package com.bytedance.android.shopping.mall.homepage.card;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewConfiguration;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f177418a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f177419b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f177420c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ViewConfiguration f177421d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f177422e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f177423f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final View f177424g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final View.OnLongClickListener f177425h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Map<String, Object> f177426i;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f177427a;

        public b(c r100) {
            this.f177427a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            c r100 = this.f177427a;     // Catch: Throwable -> L4
            r100.f177420c = r100.f177425h.onLongClick(r100.f177424g);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public final void a() {
        Object r100 = this.f177426i.get("long_click_optimize");
        if ((r100 instanceof Boolean) == true) goto L6;
        r100 = null;
    L6:
        if (Intrinsics.areEqual((Boolean) r100, Boolean.TRUE) == false) goto L9;
        this.f177424g.setOnLongClickListener(null);
        this.f177424g.setOnTouchListener(new d(this));
        return;
    }

    public c(View r100, View.OnLongClickListener r101, Map<String, ? extends Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "targetView");
        Intrinsics.checkNotNullParameter(r101, "listener");
        Intrinsics.checkNotNullParameter(r102, "config");
        this.f177424g = r100;
        this.f177425h = r101;
        this.f177426i = r102;
        this.f177418a = new Handler(Looper.getMainLooper());
        this.f177419b = new b(this);
        this.f177421d = ViewConfiguration.get(r100.getContext());
    }
}
