package com.obric.appstore.base;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.l0;
import com.bytedance.common.wschannel.WsConstants;
import com.tmall.wireless.tangram.dataparser.concrete.Card;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ILoadViewModel extends f {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f10552h = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MutableLiveData f10553d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MutableLiveData f10554e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public l f10555f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.obric.appstore.util.g f10556g;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    static {
        f10552h = new a(null);
    }

    public ILoadViewModel() {
        this.f10553d = new MutableLiveData(com.obric.appstore.network.g.c.f10973a);
        this.f10554e = new MutableLiveData();
        this.f10556g = new com.obric.appstore.util.g(1);
    }

    public static final /* synthetic */ com.obric.appstore.util.g f(ILoadViewModel r10) {
        return r10.f10556g;
    }

    public static /* synthetic */ void s(ILoadViewModel r10, boolean r11, boolean r12, int r13, Object r14) {
        if (r14 != null) goto L12;
        if ((r13 & 1) == 0) goto L7;
        r11 = false;
    L7:
        if ((r13 & 2) == 0) goto L9;
        r12 = false;
    L9:
        r10.r(r11, r12);
        return;
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: refresh");
    }

    public void a() {
        this.f10554e.p(null);
    }

    @Override // androidx.lifecycle.k0
    public void d() {
        super.d();
        l r10 = this.f10555f;
        if (r10 == null) goto L5;
        r10.a();
    L5:
        this.f10555f = null;
    }

    public com.obric.appstore.network.g g(j r10, com.obric.appstore.network.g r11) {
        q.g(r10, Card.KEY_API_LOAD_PARAMS);
        q.g(r11, WsConstants.KEY_CONNECTION_STATE);
        return r11;
    }

    public boolean h(j r10) {
        q.g(r10, Card.KEY_API_LOAD_PARAMS);
        if (r10.a() == true) goto L8;
        if (p() == false) goto L8;
        return false;
    L8:
        if (r10.a() == false) goto L10;
        return true;
    L10:
        if (n() == false) goto L14;
        return false;
    L14:
        return true;
    }

    public final Object i(Function1 r10, Continuation r11) {
        if ((r11 instanceof ILoadViewModel$doInBlockLoad$1) == false) goto L7;
        ILoadViewModel$doInBlockLoad$1 r12 = (ILoadViewModel$doInBlockLoad$1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = kotlin.coroutines.intrinsics.a.d();
        int r16 = r12.label;
        if (r16 == 0) goto L18;
        if (r16 != 1) goto L17;
        ILoadViewModel this = (ILoadViewModel) r12.L$0;
        kotlin.c.b(r14);     // Catch: Throwable -> L14
    L22:
        Result.m35constructorimpl(Unit.f21064a);     // Catch: Throwable -> L14
    L25:
        this.f10556g.c(2);
        return Unit.f21064a;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        kotlin.c.b(r14);
        this.f10556g.b(2);
        Result.a r17 = Result.Companion;     // Catch: Throwable -> L14
        r12.L$0 = this;     // Catch: Throwable -> L14
        r12.label = 1;     // Catch: Throwable -> L14
        if (r10.invoke(r12) != r15) goto L22;
        return r15;
    L14:
        th = move-exception;
        Result.a r18 = Result.Companion;
        Result.m35constructorimpl(kotlin.c.a(th));
    L7:
        r12 = new ILoadViewModel$doInBlockLoad$1(this, r11);
        goto L8
    }

    public abstract Object j(j r10, Continuation r11);

    public final LiveData k() {
        return this.f10554e;
    }

    public final j l() {
        l r10 = this.f10555f;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.c();
    }

    public final LiveData m() {
        return this.f10553d;
    }

    public final boolean n() {
        return this.f10556g.a(2);
    }

    public final boolean o() {
        return this.f10556g.a(1);
    }

    public final boolean p() {
        if ((m().e() instanceof com.obric.appstore.network.g.b) == false) goto L11;
        l r10 = this.f10555f;
        if (r10 == null) goto L11;
        Job r11 = r10.b();
        if (r11 == null) goto L11;
        if (r11.isActive() != true) goto L11;
        return true;
    L11:
        return false;
    }

    public final void q(j r10) {
        q.g(r10, Card.KEY_API_LOAD_PARAMS);
        com.obric.appstore.util.k.f11081a.a();
        if (h(r10) == true) goto L5;
        return;
    L5:
        u(com.obric.appstore.network.g.b.f10972a, r10);
        l r11 = this.f10555f;
        if (r11 == null) goto L8;
        r11.a();
    L8:
        this.f10555f = new l(r10, kotlinx.coroutines.h.d(l0.a(this), null, null, new ILoadViewModel$load$1(this, r10, null), 3, null));
    }

    public abstract void r(boolean r10, boolean r11);

    public void t(Object r10, j r11) {
        q.g(r11, Card.KEY_API_LOAD_PARAMS);
        this.f10554e.p(r10);
    }

    public void u(com.obric.appstore.network.g r10, j r11) {
        q.g(r10, WsConstants.KEY_CONNECTION_STATE);
        q.g(r11, Card.KEY_API_LOAD_PARAMS);
        this.f10553d.p(r10);
    }
}
