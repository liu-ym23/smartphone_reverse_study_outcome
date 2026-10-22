package com.obric.oui.pullrefresh;

import kotlin.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OPullRefreshLayout.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
final class OPullRefreshLayout$sam$com_obric_oui_pullrefresh_OnStateChangeListener$0 implements OnStateChangeListener, FunctionAdapter {
    private final /* synthetic */ Function3 function;

    OPullRefreshLayout$sam$com_obric_oui_pullrefresh_OnStateChangeListener$0(Function3 r1) {
        this.function = r1;
    }

    public final boolean equals(Object r3) {
        if ((r3 instanceof OnStateChangeListener) == true) goto L5;
        return false;
    L5:
        if ((r3 instanceof FunctionAdapter) == true) goto L7;
        return false;
    L7:
        return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
    }

    @Override // kotlin.jvm.internal.FunctionAdapter
    public final Function<?> getFunctionDelegate() {
        return this.function;
    }

    public final int hashCode() {
        return getFunctionDelegate().hashCode();
    }

    @Override // com.obric.oui.pullrefresh.OnStateChangeListener
    public final /* synthetic */ void onStateChanged(OPullRefreshLayout r1, RefreshState r2, RefreshState r3) {
        this.function.invoke(r1, r2, r3);
    }
}
