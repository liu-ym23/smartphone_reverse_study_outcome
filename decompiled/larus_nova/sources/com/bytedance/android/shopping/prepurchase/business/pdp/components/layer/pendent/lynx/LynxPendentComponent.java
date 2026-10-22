package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.lynx;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.LynxElementVO;
import com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.PendantContainerVO;
import com.bytedance.android.shopping.prepurchase.arch.container.ability.o;
import com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent;
import com.bytedance.android.shopping.prepurchase.arch.container.state.g;
import com.bytedance.android.shopping.prepurchase.business.pdp.components.m;
import com.bytedance.android.shopping.prepurchase.business.pdp.view.i;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import ti.l;
import vg3.a0;
import vg3.i0;

/* JADX INFO: loaded from: classes13.dex */
public final class LynxPendentComponent extends m implements a0 {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f181471o = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.lynx.c f181472m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final a f181473n;

    public static final class a implements com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.lynx.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LynxPendentComponent f181474a;

        @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.lynx.b
        public final e b() {
            vg3.e r100 = (vg3.e) this.f181474a.N1(vg3.e.class);
            if (r100 == null) goto L5;
            int r101 = r100.d1();
        L7:
            return new e(r101);
        L5:
            r101 = 0;
            goto L7
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.p
        public final Boolean d() {
            return Boolean.valueOf(((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(this.f181474a.O1())).f181849b.f181035a);
        }

        public a(LynxPendentComponent r100) {
            this.f181474a = r100;
        }

        @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.lynx.b
        public final i c(String r100) {
            Intrinsics.checkNotNullParameter(r100, "sliceKey");
            vg3.e r101 = (vg3.e) this.f181474a.N1(vg3.e.class);
            if (r101 != null) goto L7;
            return null;
        L7:
            return r101.H(r100);
        }

        @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.lynx.b
        public final i e(String r100) {
            Intrinsics.checkNotNullParameter(r100, "sliceKey");
            i0 r101 = (i0) this.f181474a.N1(i0.class);
            if (r101 != null) goto L7;
            return null;
        L7:
            return r101.H(r100);
        }

        @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.lynx.b
        public final l a(Context r110, String r111, com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.lynx.c.b r112) {
            Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r111, "url");
            Intrinsics.checkNotNullParameter(r112, "callback");
            o r100 = new o(r110, r111, null, null, true, r112, 12);
            return this.f181474a.O1().e().D0().p(r100);
        }
    }

    public static final class b<T> implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LynxPendentComponent f181475a;

        public b(LynxPendentComponent r100) {
            this.f181475a = r100;
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
        public final void onChanged(Object r100) {
            PendantContainerVO r101 = (PendantContainerVO) r100;
            if (r101 == null) goto L50;
            com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.lynx.c r102 = LynxPendentComponent.h2(this.f181475a);
            r102.getClass();
            Intrinsics.checkNotNullParameter(r101, "vo");
            r102.f181484f.removeAllViews();
            Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L37
            PendantContainerVO r104 = r102.f181479a;     // Catch: Throwable -> L37
            if (r104 == null) goto L10;
            PendantContainerVO r105 = r104.merge(r101);     // Catch: Throwable -> L37
            if (r105 == null) goto L10;
        L11:
            r102.f181479a = r105;     // Catch: Throwable -> L37
            List<LynxElementVO> r106 = r101.getLeftBottom();     // Catch: Throwable -> L37
            if (r106 == null) goto L17;
            Iterator<T> r107 = r106.iterator();     // Catch: Throwable -> L37
        L15:
            if (r107.hasNext() == false) goto L17;
            r102.b((LynxElementVO) r107.next());     // Catch: Throwable -> L37
        L17:
            List<LynxElementVO> r108 = r101.getTopRight();     // Catch: Throwable -> L37
            if (r108 == null) goto L23;
            Iterator<T> r109 = r108.iterator();     // Catch: Throwable -> L37
        L21:
            if (r109.hasNext() == false) goto L23;
            r102.b((LynxElementVO) r109.next());     // Catch: Throwable -> L37
        L23:
            List<LynxElementVO> r110 = r101.getTopLeft();     // Catch: Throwable -> L37
            if (r110 == null) goto L29;
            Iterator<T> r111 = r110.iterator();     // Catch: Throwable -> L37
        L27:
            if (r111.hasNext() == false) goto L29;
            r102.b((LynxElementVO) r111.next());     // Catch: Throwable -> L37
        L29:
            List<LynxElementVO> r112 = r101.getRightBottom();     // Catch: Throwable -> L37
            if (r112 == null) goto L35;
            Iterator<T> r113 = r112.iterator();     // Catch: Throwable -> L37
        L33:
            if (r113.hasNext() == false) goto L35;
            r102.b((LynxElementVO) r113.next());     // Catch: Throwable -> L37
        L35:
            r102.e();     // Catch: Throwable -> L37
            Object r114 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L37
        L39:
            Throwable r115 = Result.m9452exceptionOrNullimpl(r114);
            if (r115 == null) goto L49;
            ECExceptionMonitor.e(r115);
            return;
        L49:
            return;
        L10:
            r105 = r101;
        L37:
            th = move-exception;
            Result.Companion r116 = Result.Companion;
            r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L39
        }
    }

    public static final class c<T> implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LynxPendentComponent f181476a;

        public c(LynxPendentComponent r100) {
            this.f181476a = r100;
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
        public final void onChanged(Object r100) {
            float r101 = (-((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(this.f181476a.O1())).f181849b.f181036b) * RangesKt.coerceAtMost(((Number) r100).floatValue(), 0.0f);
            com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.lynx.c r102 = LynxPendentComponent.h2(this.f181476a);
            if (r102.f181481c == r101) goto L17;
            r102.f181481c = r101;
            Iterator<T> r103 = r102.f181480b.values().iterator();
        L7:
            if (r103.hasNext() == false) goto L27;
            com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c r104 = (com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c) r103.next();
            if (r104 == null) goto L7;
            LynxElementVO r105 = r104.f166771f;
            if (r105 == null) goto L7;
            View r106 = r104.f166766a;
            if (r106 == null) goto L7;
            r102.a(r105, r106);
            goto L7
        L27:
            return;
        }
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final List<Class<?>> M1() {
        return CollectionsKt.listOf(new Class[]{i0.class, vg3.e.class, a0.class});
    }

    public LynxPendentComponent() {
        this.f181473n = new a(this);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void T1() {
        super.T1();
        com.bytedance.android.shopping.prepurchase.arch.container.ability.g.b(O1().e(), "pdp_async_event_send", true, new LynxPendentComponent$registerJsEvent$1(this));
        String r100 = g2().getSessionId();
        View r101 = e2();
        if (r101 == null) goto L10;
        this.f181472m = new com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.lynx.c(r100, (FrameLayout) r101, this.f181473n);
        Z1(vg3.e.class, new LynxPendentComponent$onAttach$1(this, null));
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a((com.bytedance.android.shopping.prepurchase.arch.container.state.e) O1().d().getData().f181905o.getValue(), this, new b(this));
        if (ECSettingKeys.z0() == false) goto L7;
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a(((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(O1())).f181849b.f181037c, this, new c(this));
    L7:
        Z1(i0.class, new LynxPendentComponent$onAttach$4(this, null));
        O1().getContainerAbility().b(new LynxPendentComponent$onAttach$5(this));
        AbsComponent.Y1(this, a0.class, this, false, 12);
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout");
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void U1() {
        super.U1();
        com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.lynx.c r100 = this.f181472m;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("helper");
    L5:
        Iterator<Map.Entry<String, com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c>> r101 = r100.f181480b.entrySet().iterator();
    L7:
        if (r101.hasNext() == false) goto L13;
        com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c r102 = r101.next().getValue();
        if (r102 == null) goto L7;
        l r103 = r102.f166767b;
        if (r103 == null) goto L7;
        r103.release();
        goto L7
    L13:
        r100.f181480b.clear();
        r100.f181484f.removeAllViews();
    }

    public static final /* synthetic */ com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.lynx.c h2(LynxPendentComponent r100) {
        com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.lynx.c r101 = r100.f181472m;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("helper");
    L5:
        return r101;
    }

    @Override // vg3.a0
    public final View L(String r100) {
        Intrinsics.checkNotNullParameter(r100, "pendentId");
        com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.lynx.c r101 = this.f181472m;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("helper");
    L5:
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "pendantId");
        Iterator<Map.Entry<String, com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c>> r102 = r101.f181480b.entrySet().iterator();
    L7:
        if (r102.hasNext() == false) goto L22;
        Map.Entry<String, com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c> r103 = r102.next();
        com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c r104 = r103.getValue();
        if (r104 == null) goto L11;
        String r105 = r104.f166768c;
    L13:
        if (Intrinsics.areEqual(r105, r100) == false) goto L7;
        com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c r106 = r103.getValue();
        if (r106 != null) goto L17;
        return null;
    L17:
        return r106.f166766a;
    L11:
        r105 = null;
        goto L13
    L22:
        return null;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.Component
    public final View c2(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, KtvSubElement.CONTAINER);
        FrameLayout r102 = new FrameLayout(r100.getContext());
        r102.setId(R.id.lynx_pendent_container);
        return r102;
    }
}
