package com.bytedance.android.ec.core.arch.lifecycle;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes43.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f43848a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lifecycle f43849b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lifecycle.State f43850c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f43851d;

    public static final class a implements LifecycleEventObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f43852a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Job f43853b;

        public a(c r100, Job r101) {
            this.f43852a = r100;
            this.f43853b = r101;
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public final void onStateChanged(LifecycleOwner r100, Lifecycle.Event r101) {
            Intrinsics.checkNotNullParameter(r100, "source");
            Intrinsics.checkNotNullParameter(r101, "<anonymous parameter 1>");
            if (r100.getLifecycle().getCurrentState() != Lifecycle.State.DESTROYED) goto L6;
            c r102 = this.f43852a;
            Job.DefaultImpls.cancel$default(this.f43853b, null, 1, null);
            r102.a();
            return;
        L6:
            if (r100.getLifecycle().getCurrentState().compareTo(this.f43852a.f43850c) >= 0) goto L8;
            this.f43852a.f43851d.f43844a = true;
            return;
        L8:
            b r103 = this.f43852a.f43851d;
            if (r103.f43844a == true) goto L12;
            return;
        L12:
            if ((!r103.f43845b) == false) goto L16;
            r103.f43844a = false;
            r103.a();
            return;
        L16:
            throw new IllegalStateException("Cannot resume a finished dispatcher".toString());
        }
    }

    public final void a() {
        this.f43849b.removeObserver(this.f43848a);
        b r100 = this.f43851d;
        r100.f43845b = true;
        r100.a();
    }

    public c(Lifecycle r100, Lifecycle.State r101, b r102, Job r103) {
        Intrinsics.checkNotNullParameter(r100, NewBroadcastMonitor.STAGE.LIFECYCLE);
        Intrinsics.checkNotNullParameter(r101, "minState");
        Intrinsics.checkNotNullParameter(r102, "dispatchQueue");
        Intrinsics.checkNotNullParameter(r103, "parentJob");
        this.f43849b = r100;
        this.f43850c = r101;
        this.f43851d = r102;
        a r104 = new a(this, r103);
        this.f43848a = r104;
        if (r100.getCurrentState() != Lifecycle.State.DESTROYED) goto L5;
        Job.DefaultImpls.cancel$default(r103, null, 1, null);
        a();
        return;
    L5:
        r100.addObserver(r104);
    }
}
