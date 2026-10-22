package com.bytedance.android.shopping.prepurchase.arch.standard.component.pref;

import android.os.Handler;
import com.bytedance.android.shopping.prepurchase.arch.container.ability.l;
import com.bytedance.android.shopping.prepurchase.arch.container.aware.RenderLifecycleDispatcher;
import com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent;
import com.bytedance.android.shopping.prepurchase.arch.container.component.i;
import com.bytedance.android.shopping.prepurchase.arch.container.intf.j;
import com.bytedance.android.shopping.prepurchase.arch.container.state.h;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public class StandardPrefService<STATE extends h, STORE> extends i<STATE, STORE> implements l {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f180983i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f180984j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f180985k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final com.bytedance.android.shopping.prepurchase.arch.container.aware.e f180986l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final com.bytedance.android.shopping.prepurchase.arch.standard.component.pref.a f180987m;

    public static final class a extends com.bytedance.android.shopping.prepurchase.arch.container.ability.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ StandardPrefService f180988c;

        @Override // java.lang.Runnable
        public final void run() {
            this.f180988c.f180986l.onFirstScreen();
        }

        public a(StandardPrefService r100) {
            this.f180988c = r100;
            super("first_screen_callback");
        }
    }

    public final TaskScheduler b2() {
        return (TaskScheduler) this.f180985k.getValue();
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final List<Class<?>> M1() {
        return CollectionsKt.listOf(j.class);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.ability.l
    public final void C0() {
        final TaskScheduler r100 = b2();
        r100.getClass();
        com.bytedance.android.shopping.prepurchase.arch.utils.a.a(new TaskScheduler$onFirstFrameRender$1(r100));
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public void T1() {
        super.T1();
        Z1(j.class, new StandardPrefService$onAttach$1(this, null));
        e1(new a(this));
        AbsComponent.Y1(this, l.class, this, false, 12);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.ability.l
    public final void U() {
        final TaskScheduler r100 = b2();
        r100.getClass();
        com.bytedance.android.shopping.prepurchase.arch.utils.a.a(new TaskScheduler$onPreviewRender$1(r100));
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public void U1() {
        super.U1();
        com.bytedance.android.shopping.prepurchase.arch.container.component.b.c(this, "onDetach");
        ((Handler) this.f180984j.getValue()).removeCallbacksAndMessages(null);
        final TaskScheduler r100 = b2();
        r100.getClass();
        com.bytedance.android.shopping.prepurchase.arch.utils.a.a(new TaskScheduler$stop$1(r100));
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.ability.l
    public final boolean e0() {
        if (b2().f180996a < 3) goto L5;
        return true;
    L5:
        return false;
    }

    public static final Handler a2(StandardPrefService r100) {
        return (Handler) r100.f180984j.getValue();
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.ability.l
    public final void e1(com.bytedance.android.shopping.prepurchase.arch.container.ability.b r100) {
        Intrinsics.checkNotNullParameter(r100, "task");
        TaskScheduler r101 = b2();
        int r102 = TaskScheduler.f180995i;
        r101.b(3, r100, null);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.ability.l
    public final void n0(com.bytedance.android.shopping.prepurchase.arch.container.ability.b r100) {
        Intrinsics.checkNotNullParameter(r100, "task");
        TaskScheduler r101 = b2();
        int r102 = TaskScheduler.f180995i;
        r101.b(4, r100, null);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.ability.l
    public final void s1(com.bytedance.android.shopping.prepurchase.arch.container.ability.b r100) {
        Intrinsics.checkNotNullParameter(r100, "task");
        TaskScheduler r101 = b2();
        int r102 = TaskScheduler.f180995i;
        r101.b(2, r100, null);
    }

    public StandardPrefService(RenderLifecycleDispatcher r100, com.bytedance.android.shopping.prepurchase.business.pdp.f r101) {
        Intrinsics.checkNotNullParameter(r100, "renderListener");
        Intrinsics.checkNotNullParameter(r101, ShortVideoSegments.KEY_PROP_PROVIDER);
        this.f180986l = r100;
        this.f180987m = r101;
        this.f180984j = LazyKt.lazy(StandardPrefService$handler$2.INSTANCE);
        this.f180985k = LazyKt.lazy(new StandardPrefService$taskScheduler$2(this));
    }
}
