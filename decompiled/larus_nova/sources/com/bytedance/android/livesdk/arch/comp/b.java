package com.bytedance.android.livesdk.arch.comp;

import android.view.View;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.livesdk.arch.lifecycle.ITbLifecycle;
import com.bytedance.android.livesdk.arch.task.l;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0;
import com.bytedance.android.livesdk.toolbarservice.api.IToolbarService;
import com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarMatchInterface;
import com.monitor.cloudmessage.consts.CloudControlInf;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Action;
import java.util.ArrayList;
import java.util.List;
import jc1.k;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public abstract class b implements g, ITbLifecycle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<je1.b> f103722a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<le1.c> f103723b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f103724c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f103725d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final PropertyOwner<ITbLifecycle.State> f103726e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final d f103727f;

    public static final class a implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f103728a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ je1.b f103729b;

        public a(b r100, je1.b r101) {
            this.f103728a = r100;
            this.f103729b = r101;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            List<je1.b> r100 = this.f103728a.f103722a;
            ArrayList r101 = (ArrayList) r100;
            r101.remove(this.f103729b);
        }
    }

    public abstract a0 c();

    public abstract ToolbarMatchInterface d();

    public void h() {
    }

    public void i() {
        this.f103725d = false;
    }

    public void j() {
    }

    public abstract void o(ToolbarMatchInterface r100);

    public final z51.e<ne1.e> e() {
        int r100 = me1.a.f513447a;
        com.bytedance.android.livesdk.arch.context.a r101 = f();
        if (r101 == null) goto L7;
        me1.a r102 = r101.stateDispatcher();
        if (r102 == null) goto L7;
        z51.e<ne1.e> r103 = r102.lifecycle();
    L9:
        if ((r103 instanceof z51.e) == true) goto L12;
        return null;
    L12:
        return r103;
    L7:
        r103 = null;
        goto L9
    }

    public final com.bytedance.android.livesdk.arch.context.a f() {
        IToolbarService r100 = (IToolbarService) k.f(IToolbarService.class);
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getTbContext(this.f103727f.a(), this.f103727f.getDataCenter());
    }

    public final boolean g() {
        if (this.f103726e.f64752a.compareTo(ITbLifecycle.State.Showed) >= 0) goto L5;
    L7:
        return false;
    L5:
        if (this.f103726e.f64752a.compareTo(ITbLifecycle.State.Hidden) >= 0) goto L7;
        return true;
    }

    public final void b() {
        com.bytedance.android.livesdk.arch.context.a r100 = f();
        if (r100 == null) goto L8;
        com.bytedance.android.livesdk.arch.task.f r101 = r100.taskFlower();
        if (r101 == null) goto L9;
        int r102 = l.f103897e;
        Intrinsics.checkNotNullParameter(this, "comp");
        l r103 = new l(l.b.a.f103903b, this);
        int r104 = com.bytedance.android.livesdk.arch.container.d.f103754b;
        com.bytedance.android.livesdk.arch.container.d r105 = ((h) this).p();
        Intrinsics.checkNotNullParameter(r105, "$this$isBottomRight");
        r103.f103899b = Intrinsics.areEqual(r105, com.bytedance.android.livesdk.arch.container.d.a.f103756c);
        r101.a(r103);
        return;
    L9:
        return;
    }

    public final void n() {
        com.bytedance.android.livesdk.arch.context.a r100 = f();
        if (r100 == null) goto L8;
        com.bytedance.android.livesdk.arch.task.f r101 = r100.taskFlower();
        if (r101 == null) goto L9;
        int r102 = l.f103897e;
        Intrinsics.checkNotNullParameter(this, "comp");
        r101.a(new l(l.b.C1573b.f103904b, this));
        return;
    L9:
        return;
    }

    public b(i r100) {
        Intrinsics.checkNotNullParameter(r100, "env");
        this.f103727f = r100;
        this.f103722a = new ArrayList();
        this.f103723b = new ArrayList();
        this.f103726e = new PropertyOwner(ITbLifecycle.State.Initialized, AbsTbComp$_lifecycleObserver$1.INSTANCE);
    }

    @Override // com.bytedance.android.livesdk.arch.lifecycle.ITbLifecycle
    public final void a(ITbLifecycle.State r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        int r101 = com.bytedance.android.livesdk.arch.comp.a.f103721a[r100.ordinal()];
        if (r101 != 2) goto L5;
        z51.e<ne1.e> r102 = e();
        if (r102 == null) goto L28;
        int r103 = ne1.e.f518873c;
        Intrinsics.checkNotNullParameter(this, "comp");
        r102.b(new ne1.e(this, ITbLifecycle.State.Destroyed));
    L28:
        i();
    L29:
        this.f103726e.a(r100);
        return;
    L5:
        if (r101 != 3) goto L7;
        h();
        z51.e<ne1.e> r104 = e();
        if (r104 == null) goto L29;
        int r105 = ne1.e.f518873c;
        Intrinsics.checkNotNullParameter(this, "comp");
        r104.b(new ne1.e(this, ITbLifecycle.State.Created));
        goto L29
    L7:
        if (r101 != 4) goto L9;
        z51.e<ne1.e> r106 = e();
        if (r106 == null) goto L29;
        int r107 = ne1.e.f518873c;
        Intrinsics.checkNotNullParameter(this, "comp");
        r106.b(new ne1.e(this, ITbLifecycle.State.Started));
        goto L29
    L9:
        if (r101 != 5) goto L11;
        z51.e<ne1.e> r108 = e();
        if (r108 == null) goto L29;
        int r109 = ne1.e.f518873c;
        Intrinsics.checkNotNullParameter(this, "comp");
        r108.b(new ne1.e(this, ITbLifecycle.State.Showed));
        goto L29
    L11:
        if (r101 != 6) goto L29;
        z51.e<ne1.e> r110 = e();
        if (r110 == null) goto L29;
        int r111 = ne1.e.f518873c;
        Intrinsics.checkNotNullParameter(this, "comp");
        r110.b(new ne1.e(this, ITbLifecycle.State.Hidden));
        goto L29
    }

    public final Disposable k(je1.b r100) {
        Intrinsics.checkNotNullParameter(r100, "showInterceptor");
        if (((ArrayList) this.f103722a).contains(r100) == true) goto L6;
        ((ArrayList) this.f103722a).add(r100);
    L6:
        return Disposables.fromAction(new a(this, r100));
    }

    public final Disposable l(le1.a r100) {
        Intrinsics.checkNotNullParameter(r100, CloudControlInf.PLUGIN);
        if (((ArrayList) this.f103723b).contains(r100) == true) goto L6;
        ((ArrayList) this.f103723b).add(r100);
    L6:
        return Disposables.fromAction(new c(this, r100));
    }

    @Override // com.bytedance.android.livesdk.arch.comp.g
    public <T> void update(T r100) {
        com.bytedance.android.livesdk.arch.context.a r101 = f();
        if (r101 == null) goto L8;
        com.bytedance.android.livesdk.arch.task.f r102 = r101.taskFlower();
        if (r102 == null) goto L9;
        int r103 = l.f103897e;
        Intrinsics.checkNotNullParameter(this, "comp");
        l r104 = new l(l.b.d.f103906b, this);
        r104.f103898a = r100;
        r102.a(r104);
        return;
    L9:
        return;
    }

    public final Disposable m(le1.a r100, Function0 r101) {
        Intrinsics.checkNotNullParameter(r100, CloudControlInf.PLUGIN);
        Intrinsics.checkNotNullParameter(r101, "predicate");
        if (((Boolean) r101.invoke()).booleanValue() == false) goto L7;
        return l(r100);
    L7:
        return Disposables.empty();
    }
}
