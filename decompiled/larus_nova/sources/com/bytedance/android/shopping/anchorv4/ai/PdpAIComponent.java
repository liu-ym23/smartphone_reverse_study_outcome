package com.bytedance.android.shopping.anchorv4.ai;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.ec.base.api.ai.conversation.ConversationContext;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.shopping.anchorv4.dto.components.LongTitleComponent;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextElement;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.anchorv4.voavhs.baseinfo.AnchorV4BaseInfoDisplay;
import com.bytedance.android.shopping.anchorv4.voavhs.baseinfo.BaseInfoVO;
import com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes12.dex */
public final class PdpAIComponent extends com.bytedance.android.shopping.prepurchase.business.pdp.components.m {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ int f165614r = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public PdpAIRuntime f165615m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f165616n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final com.bytedance.android.shopping.prepurchase.arch.container.state.d<vg3.l0> f165617o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final p0 f165618p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final View f165619q;

    public final class V2PdpAIRuntimeHostAdapter implements k0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Lazy f165620a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Lazy f165621b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ PdpAIComponent f165622c;

        @Override // com.bytedance.android.shopping.anchorv4.ai.k0
        public final g0 e() {
            return (g0) this.f165620a.getValue();
        }

        @Override // com.bytedance.android.shopping.anchorv4.ai.k0
        public final ConversationContext h() {
            return (ConversationContext) this.f165621b.getValue();
        }

        @Override // com.bytedance.android.shopping.anchorv4.ai.k0
        public final String b() {
            return this.f165622c.O1().f().f523187a.f523190b;
        }

        @Override // com.bytedance.android.shopping.anchorv4.ai.k0
        public final View c() {
            return this.f165622c.f165619q;
        }

        @Override // com.bytedance.android.shopping.anchorv4.ai.k0
        public final String d() {
            com.bytedance.android.shopping.prepurchase.business.pdp.repository.n r100 = (com.bytedance.android.shopping.prepurchase.business.pdp.repository.n) this.f165622c.O1().d().getData().f181891a.a();
            if (r100 == null) goto L5;
            String r101 = r100.K;
        L6:
            if (r101 != null) goto L8;
            return null;
        L8:
            if ((!StringsKt.isBlank(r101)) == true) goto L10;
            return null;
        L10:
            return r101;
        L5:
            r101 = null;
            goto L6
        }

        @Override // com.bytedance.android.shopping.anchorv4.ai.k0
        public final String f() {
            PdpAIComponent r100 = this.f165622c;
            int r101 = PdpAIComponent.f165614r;
            List<com.bytedance.android.ecom.arch.slice.adapter.b> r102 = r100.O1().d().getData().b().a();
            if (r102 == null) goto L12;
            Iterator<T> r103 = r102.iterator();
        L6:
            if (r103.hasNext() == false) goto L10;
            Object r104 = r103.next();
            if ((((com.bytedance.android.ecom.arch.slice.adapter.b) r104) instanceof com.bytedance.android.shopping.anchorv4.voavhs.baseinfo.c) == false) goto L6;
        L11:
            com.bytedance.android.ecom.arch.slice.adapter.b r105 = (com.bytedance.android.ecom.arch.slice.adapter.b) r104;
        L14:
            if ((r105 instanceof com.bytedance.android.shopping.anchorv4.voavhs.baseinfo.c) == true) goto L16;
            r105 = null;
        L16:
            com.bytedance.android.shopping.anchorv4.voavhs.baseinfo.c r106 = (com.bytedance.android.shopping.anchorv4.voavhs.baseinfo.c) r105;
            if (r106 == null) goto L31;
            AnchorV4BaseInfoDisplay r107 = r106.f167953b;
            if (r107 == null) goto L32;
            BaseInfoVO r108 = r107.getBaseInfo();
            if (r108 == null) goto L33;
            LongTitleComponent r109 = r108.getGoodsTitle();
            if (r109 == null) goto L34;
            TextElement r110 = r109.getContent();
            if (r110 != null) goto L27;
            return null;
        L27:
            return r110.getText();
        L34:
            return null;
        L33:
            return null;
        L32:
            return null;
        L31:
            return null;
        L10:
            r104 = null;
            goto L11
        L12:
            r105 = null;
            goto L14
        }

        @Override // com.bytedance.android.shopping.anchorv4.ai.k0
        public final int g() {
            return this.f165622c.e2().getId();
        }

        @Override // com.bytedance.android.shopping.anchorv4.ai.k0
        public FragmentActivity getActivity() {
            return this.f165622c.O1().getContainerAbility().getContext();
        }

        @Override // com.bytedance.android.shopping.anchorv4.ai.k0
        public final FragmentManager getFragmentManager() {
            return this.f165622c.O1().getContainerAbility().g7();
        }

        @Override // com.bytedance.android.shopping.anchorv4.ai.k0
        public final String getProductId() {
            CommonMeta r100 = this.f165622c.O1().d().getData().a().a();
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.getProductId();
        }

        @Override // com.bytedance.android.shopping.anchorv4.ai.k0
        public final View i() {
            return this.f165622c.e2();
        }

        public V2PdpAIRuntimeHostAdapter(PdpAIComponent r100) {
            this.f165622c = r100;
            this.f165620a = LazyKt.lazy(new PdpAIComponent$V2PdpAIRuntimeHostAdapter$pageEventObserver$2(this));
            this.f165621b = LazyKt.lazy(new PdpAIComponent$V2PdpAIRuntimeHostAdapter$conversationContext$2(this));
        }

        @Override // com.bytedance.android.shopping.anchorv4.ai.k0
        public final void a(int r100) {
            Intrinsics.checkNotNullParameter("pdp_ai_chat", "source");
            this.f165622c.f165617o.g(new vg3.l0(r100));
            View r101 = this.f165622c.e2();
            if ((r101 instanceof e) == true) goto L5;
            r101 = null;
        L5:
            e r102 = (e) r101;
            if (r102 == null) goto L9;
            r102.setInputBackgroundHeight(r100);
            return;
        }
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final List<Class<?>> M1() {
        return CollectionsKt.listOf(vg3.u.class);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void U1() {
        PdpAIRuntime r100 = this.f165615m;
        if (r100 == null) goto L5;
        r100.b();
    L5:
        this.f165615m = null;
        super.U1();
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void T1() {
        super.T1();
        AbsComponent.Y1(this, vg3.f.class, new n(this), false, 12);
        if (this.f165616n == true) goto L6;
        O1().getContainerAbility().a(new q(this));
        this.f165616n = true;
    L6:
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a(((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(O1())).f181849b.f181037c, this, new p(this));
        PdpAIRuntime r100 = new PdpAIRuntime(this.f165618p, new V2PdpAIRuntimeHostAdapter(this));
        if (r100.a() == false) goto L9;
        this.f165615m = r100;
        O1().b().e1(new o(this));
        return;
    L9:
        e2().setVisibility(8);
    }

    public PdpAIComponent(p0 r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, "gateway");
        this.f165618p = r100;
        this.f165619q = r101;
        this.f165617o = new com.bytedance.android.shopping.prepurchase.arch.container.state.d();
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.Component
    public final View c2(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, KtvSubElement.CONTAINER);
        return new e(r100.getContext());
    }
}
