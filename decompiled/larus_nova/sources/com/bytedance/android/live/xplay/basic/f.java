package com.bytedance.android.live.xplay.basic;

import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class f implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<o> f102806a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Function2<q, r, Unit>> f102807b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function2<f, List<? extends o>, o> f102808c;

    /* JADX WARN: Multi-variable type inference failed */
    public f(Function2<? super f, ? super List<? extends o>, ? extends o> r100) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        this.f102808c = r100;
        this.f102806a = new ArrayList();
        this.f102807b = new ArrayList();
    }

    @Override // com.bytedance.android.live.xplay.basic.s
    public final void c(Function2<? super q, ? super r, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        ((ArrayList) this.f102807b).add(r100);
    }

    @Override // com.bytedance.android.live.xplay.basic.e
    public final void b(String r100, Function1<? super p, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "block");
        List<o> r102 = this.f102806a;
        final XplayTaskBuilderScopeImpl r103 = new XplayTaskBuilderScopeImpl(r100);
        r101.invoke(r103);
        ArrayList r104 = (ArrayList) r102;
        r104.add(new n(r103.f102768a, r103.f102770c, new XplayTaskBuilderScopeImpl$build$1(r103)));
    }
}
