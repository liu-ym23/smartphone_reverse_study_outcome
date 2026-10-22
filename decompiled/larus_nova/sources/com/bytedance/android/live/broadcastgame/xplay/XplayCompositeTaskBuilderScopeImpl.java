package com.bytedance.android.live.broadcastgame.xplay;

import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class XplayCompositeTaskBuilderScopeImpl implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<j1> f61860a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Function2<l1, m1, Unit>> f61861b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function2<XplayCompositeTaskBuilderScopeImpl, List<? extends j1>, j1> f61862c;

    /* JADX WARN: Multi-variable type inference failed */
    public XplayCompositeTaskBuilderScopeImpl(Function2<? super XplayCompositeTaskBuilderScopeImpl, ? super List<? extends j1>, ? extends j1> r100) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        this.f61862c = r100;
        this.f61860a = new ArrayList();
        this.f61861b = new ArrayList();
    }

    @Override // com.bytedance.android.live.broadcastgame.xplay.n1
    public final void c(Function2<? super l1, ? super m1, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        ((ArrayList) this.f61861b).add(r100);
    }

    @Override // com.bytedance.android.live.broadcastgame.xplay.l
    public final void b(String r100, Function1<? super k1, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "block");
        List<j1> r102 = this.f61860a;
        final XplayTaskBuilderScopeImpl r103 = new XplayTaskBuilderScopeImpl(r100);
        r101.invoke(r103);
        ArrayList r104 = (ArrayList) r102;
        r104.add(new i1(r103.f62012a, r103.f62014c, new XplayTaskBuilderScopeImpl$build$1(r103)));
    }

    @Override // com.bytedance.android.live.broadcastgame.xplay.l
    public final void d(final String r100, Function1<? super l, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "block");
        List<j1> r102 = this.f61860a;
        XplayCompositeTaskBuilderScopeImpl r103 = new XplayCompositeTaskBuilderScopeImpl(new XplayCompositeTaskBuilderScopeImpl$parallel$1(r100));
        r101.invoke(r103);
        ArrayList r104 = (ArrayList) r102;
        r104.add(r103.f61862c.invoke(r103, r103.f61860a));
    }
}
