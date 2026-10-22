package androidx.compose.foundation;

import java.lang.invoke.VarHandle;
import k0.s;
import t.h1;
import t.i1;
import u.f0;
import w0.m;
import xb.q;
import yb.l;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d extends l implements q {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ h1 f863c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ boolean f864f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(h1 h1Var, boolean z10) {
        super(3);
        this.f863c = h1Var;
        this.f864f = z10;
    }

    @Override // xb.q
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        s sVar = (s) obj2;
        ((Number) obj3).intValue();
        sVar.X(1478351300);
        ScrollSemanticsElement scrollSemanticsElement = new ScrollSemanticsElement();
        h1 h1Var = this.f863c;
        scrollSemanticsElement.f853c = h1Var;
        scrollSemanticsElement.f854f = true;
        boolean z10 = this.f864f;
        scrollSemanticsElement.f855g = z10;
        VarHandle.storeStoreFence();
        m mVarR = i1.r(scrollSemanticsElement, h1Var, z10 ? f0.f13453c : f0.f13454f, true, null, h1Var.f13000c, sVar);
        ScrollingLayoutElement scrollingLayoutElement = new ScrollingLayoutElement();
        scrollingLayoutElement.f856c = h1Var;
        scrollingLayoutElement.f857f = z10;
        VarHandle.storeStoreFence();
        m mVarD = mVarR.d(scrollingLayoutElement);
        sVar.q(false);
        return mVarD;
    }
}
