package com.bytedance.bdtracker;

import android.os.Handler;
import com.bytedance.applog.aggregation.Metrics;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes.dex */
public final class p2 extends Lambda implements Function1<List<? extends Metrics>, Unit> {
    public final /* synthetic */ q2 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p2(q2 q2Var) {
        super(1);
        this.a = q2Var;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(List<? extends Metrics> list) {
        List<? extends Metrics> list2 = list;
        Intrinsics.checkParameterIsNotNull(list2, "list");
        ArrayList arrayList = new ArrayList();
        for (Metrics metrics : list2) {
            s4 s4Var = new s4();
            this.a.c.n.a(this.a.c.d, s4Var);
            s4Var.o = metrics.toParams();
            arrayList.add(s4Var);
        }
        Handler handler = this.a.a;
        handler.sendMessage(handler.obtainMessage(1, arrayList));
        this.a.a.sendEmptyMessage(2);
        return Unit.INSTANCE;
    }
}
