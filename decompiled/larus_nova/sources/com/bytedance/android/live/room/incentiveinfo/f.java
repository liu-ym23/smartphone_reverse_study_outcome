package com.bytedance.android.live.room.incentiveinfo;

import android.view.View;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.room.view.InterceptFrameLayout;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class f implements u81.e.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f99681a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ IncentiveInfoLayout f99682b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ u81.d f99683c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ u81.d f99684d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f99685e;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f99686a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ f f99687b;

        public a(View r100, f r101) {
            this.f99686a = r100;
            this.f99687b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            View r100 = this.f99686a;     // Catch: Throwable -> L12
            WeakReference<View> r101 = this.f99687b.f99682b.f99607c;     // Catch: Throwable -> L12
            if (r101 == null) goto L5;
            View r102 = r101.get();     // Catch: Throwable -> L12
        L7:
            if ((!Intrinsics.areEqual(r100, r102)) == false) goto L15;
            UtilityKotlinExtentionsKt.t(this.f99686a);     // Catch: Throwable -> L12
            InterceptFrameLayout r103 = x81.a.b(this.f99686a);     // Catch: Throwable -> L12
            if (r103 == null) goto L19;
            r103.setIntercept(true);     // Catch: Throwable -> L12
            return;
        L19:
            return;
        L15:
            return;
        L5:
            r102 = null;
        L12:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L20;
            throw th;
        }
    }

    @Override // u81.e.a
    public final void a() {
    }

    @Override // u81.e.a
    public final void b() {
    }

    @Override // u81.e.a
    public final void c() {
        u81.d r100 = this.f99684d;
        if (r100 == null) goto L8;
        View r101 = r100.a();
        if (r101 == null) goto L9;
        this.f99682b.post(new a(r101, this));
        return;
    L9:
        return;
    }

    @Override // u81.e.a
    public final void d() {
        IncentiveInfoLayout r100 = this.f99682b;
        r100.f99607c = new WeakReference(this.f99681a);
    }

    public f(View r100, IncentiveInfoLayout r101, u81.d r102, u81.d r103, u81.c r104, Object r105) {
        this.f99681a = r100;
        this.f99682b = r101;
        this.f99683c = r102;
        this.f99684d = r103;
        this.f99685e = r105;
    }
}
