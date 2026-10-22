package com.obric.appstore.buss.detail;

import androidx.lifecycle.Observer;
import com.obric.oui.bouncelayout.ONestedScrollView;
import kotlin.Function;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes3.dex */
public abstract class n {

    public static final class a implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f10686a;

        public a(Function1 r10) {
            q.g(r10, "function");
            this.f10686a = r10;
        }

        public final boolean equals(Object r10) {
            if ((r10 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r10 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return q.b(getFunctionDelegate(), ((FunctionAdapter) r10).getFunctionDelegate());
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function getFunctionDelegate() {
            return this.f10686a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object r10) {
            this.f10686a.invoke(r10);
        }
    }

    public static final boolean a(ONestedScrollView r10) {
        q.g(r10, "<this>");
        if (r10.getChildCount() != 0) goto L5;
    L6:
        return true;
    L5:
        if (r10.getChildAt(0).getHeight() <= (r10.getHeight() + r10.getScrollY())) goto L6;
        return false;
    }
}
