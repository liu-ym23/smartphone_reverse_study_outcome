package com.bytedance.android.live.revenue.platform.room.impl;

import com.bytedance.android.live.core.utils.AnchorMainPostOptUtils;
import com.bytedance.android.livesdk.config.b0;
import com.bytedance.android.scope.o;
import com.bytedance.android.scope.r;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public abstract class g implements o, r, yz0.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<yz0.m> f91619a;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ yz0.m f91620a;

        public a(yz0.m r100) {
            this.f91620a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f91620a.i();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // yz0.m
    public final void i() {
        Iterator<T> r100 = this.f91619a.iterator();
    L4:
        if (r100.hasNext() == false) goto L9;
        yz0.m r101 = (yz0.m) r100.next();
        if (b0.a() == true) goto L7;
        r101.i();
        goto L4
    L7:
        AnchorMainPostOptUtils.b("RevRoomReady", new a(r101));
        goto L4
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        ((ArrayList) this.f91619a).clear();
    }

    @Override // yz0.m
    public final void onViewReady() {
        Iterator<T> r100 = this.f91619a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((yz0.m) r100.next()).onViewReady();
        goto L4
    }

    @Override // yz0.m
    public final void onWidgetLoaded() {
        Iterator<T> r100 = this.f91619a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((yz0.m) r100.next()).onWidgetLoaded();
        goto L4
    }

    @Override // yz0.m
    public final void x() {
        Iterator<T> r100 = this.f91619a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((yz0.m) r100.next()).x();
        goto L4
    }

    public g() {
        this.f91619a = new ArrayList();
    }

    @Override // com.bytedance.android.scope.g
    public final boolean c(com.bytedance.android.scope.j r100, com.bytedance.android.scope.j r101) {
        Intrinsics.checkNotNullParameter(r100, "parentScope");
        Intrinsics.checkNotNullParameter(r101, "childScope");
        Intrinsics.checkNotNullParameter(r100, "parentScope");
        Intrinsics.checkNotNullParameter(r101, "childScope");
        Intrinsics.checkNotNullParameter(r100, "parentScope");
        Intrinsics.checkNotNullParameter(r101, "childScope");
        return false;
    }

    @Override // com.bytedance.android.scope.r
    public final <T extends o> T a(e33.l r100, T r101, com.bytedance.android.scope.e r102) {
        Intrinsics.checkNotNullParameter(r100, "serviceDesc");
        Intrinsics.checkNotNullParameter(r101, "serviceInst");
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        if ((r101 instanceof yz0.m) == false) goto L5;
        ((ArrayList) this.f91619a).add(r101);
    L5:
        return r101;
    }
}
