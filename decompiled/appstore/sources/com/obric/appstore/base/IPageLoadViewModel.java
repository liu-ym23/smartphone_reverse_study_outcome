package com.obric.appstore.base;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.appstore.network.entity.PageResp;
import com.tmall.wireless.tangram.dataparser.concrete.Card;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.b0;
import kotlin.collections.t;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes3.dex */
public abstract class IPageLoadViewModel extends ILoadViewModel {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f10557i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final MutableLiveData f10558j;

    public IPageLoadViewModel() {
        this.f10557i = 1;
        this.f10558j = new MutableLiveData();
    }

    public static /* synthetic */ void C(IPageLoadViewModel r10, boolean r11, boolean r12, int r13, Object r14) {
        if (r14 != null) goto L12;
        if ((r13 & 1) == 0) goto L7;
        r11 = false;
    L7:
        if ((r13 & 2) == 0) goto L9;
        r12 = false;
    L9:
        r10.B(r11, r12);
        return;
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadMore");
    }

    public final boolean A() {
        n r10 = (n) l();
        if (r10 != null) goto L5;
        return false;
    L5:
        if (r10.c() == true) goto L7;
        return false;
    L7:
        return true;
    }

    public abstract void B(boolean r10, boolean r11);

    public void D(PageResp r10, n r11) {
        q.g(r11, Card.KEY_API_LOAD_PARAMS);
        super.t(r10, r11);
        if (r11.c() == true) goto L12;
        MutableLiveData r12 = this.f10558j;
        if (r10 == null) goto L10;
        List r13 = r10.getData();
        if (r13 == null) goto L10;
        Object r14 = b0.z0(r13);
        if (r14 == null) goto L10;
    L11:
        r12.p(r14);
        return;
    L10:
        r14 = new ArrayList();
        goto L11
    L12:
        List r15 = (List) this.f10558j.e();
        if (r15 != null) goto L15;
        r15 = new ArrayList();
    L15:
        if (r10 == null) goto L19;
        List r16 = r10.getData();
        if (r16 == null) goto L19;
    L20:
        r15.addAll(r16);
        this.f10558j.p(r15);
        return;
    L19:
        r16 = t.i();
        goto L20
    }

    public void E(com.obric.appstore.network.g r10, n r11) {
        q.g(r10, WsConstants.KEY_CONNECTION_STATE);
        q.g(r11, Card.KEY_API_LOAD_PARAMS);
        super.u(r10, r11);
        if ((r10 instanceof com.obric.appstore.network.g.d) == false) goto L6;
        this.f10557i = r11.d();
        return;
    }

    @Override // com.obric.appstore.base.ILoadViewModel
    public void a() {
        super.a();
        this.f10558j.p(new ArrayList());
    }

    @Override // com.obric.appstore.base.ILoadViewModel
    public /* bridge */ /* synthetic */ com.obric.appstore.network.g g(j r10, com.obric.appstore.network.g r11) {
        return v((n) r10, r11);
    }

    @Override // com.obric.appstore.base.ILoadViewModel
    public /* bridge */ /* synthetic */ boolean h(j r10) {
        return w((n) r10);
    }

    @Override // com.obric.appstore.base.ILoadViewModel
    public /* bridge */ /* synthetic */ void t(Object r10, j r11) {
        D((PageResp) r10, (n) r11);
    }

    @Override // com.obric.appstore.base.ILoadViewModel
    public /* bridge */ /* synthetic */ void u(com.obric.appstore.network.g r10, j r11) {
        E(r10, (n) r11);
    }

    public com.obric.appstore.network.g v(n r10, com.obric.appstore.network.g r11) {
        q.g(r10, Card.KEY_API_LOAD_PARAMS);
        q.g(r11, WsConstants.KEY_CONNECTION_STATE);
        if (r10.c() == false) goto L5;
        List r12 = (List) this.f10558j.e();
        if (r12 != null) goto L10;
        r12 = t.i();
    L10:
        if (r12.isEmpty() == true) goto L22;
        if ((r11 instanceof com.obric.appstore.network.g.d) == false) goto L22;
        PageResp r13 = (PageResp) ((com.obric.appstore.network.g.d) r11).a();
        if (r13 == null) goto L17;
        List r14 = r13.getData();
        if (r14 == null) goto L17;
    L18:
        final List r15 = x(r12, r14);
        if (r14 == r15) goto L22;
        r11 = com.obric.appstore.network.h.a(r11, new IPageLoadViewModel$afterLoad$1(r15));
    L17:
        r14 = t.i();
    L22:
        if ((r11 instanceof com.obric.appstore.network.g.d) == false) goto L36;
        com.obric.appstore.network.g.d r16 = (com.obric.appstore.network.g.d) r11;
        PageResp r17 = (PageResp) r16.a();
        if (r17 == null) goto L26;
        List r18 = r17.getData();
    L27:
        if (r18 != null) goto L29;
    L30:
        PageResp r19 = (PageResp) r16.a();
        if (r19 == null) goto L36;
        if (r19.getHasMore() != true) goto L36;
        return com.obric.appstore.network.h.a(r11, IPageLoadViewModel$afterLoad$2.INSTANCE);
    L29:
        if (r18.isEmpty() == false) goto L36;
    L26:
        r18 = null;
    L36:
        return r11;
    L5:
        return super.g(r10, r11);
    }

    public boolean w(n r10) {
        q.g(r10, Card.KEY_API_LOAD_PARAMS);
        if (r10.c() == false) goto L5;
        Object r11 = k().e();
        if ((r11 instanceof PageResp) == false) goto L9;
        PageResp r12 = (PageResp) r11;
    L11:
        if (r12 != null) goto L13;
    L25:
        return false;
    L13:
        if (r12.getHasMore() != true) goto L25;
        if (p() == false) goto L20;
        if (A() == false) goto L20;
        return false;
    L20:
        if (r10.a() == false) goto L22;
    L24:
        return true;
    L22:
        if (n() == false) goto L24;
        return false;
    L9:
        r12 = null;
        goto L11
    L5:
        return super.h(r10);
    }

    public List x(List r10, List r11) {
        q.g(r10, "currList");
        q.g(r11, "moreList");
        return r11;
    }

    public final LiveData y() {
        return this.f10558j;
    }

    public final int z() {
        return this.f10557i;
    }
}
