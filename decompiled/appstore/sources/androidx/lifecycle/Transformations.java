package androidx.lifecycle;

import kotlin.Function;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;

/* JADX INFO: loaded from: classes.dex */
public abstract class Transformations {

    public static final class a implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f3479a;

        public a(Function1 r10) {
            kotlin.jvm.internal.q.g(r10, "function");
            this.f3479a = r10;
        }

        public final boolean equals(Object r10) {
            if ((r10 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r10 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return kotlin.jvm.internal.q.b(getFunctionDelegate(), ((FunctionAdapter) r10).getFunctionDelegate());
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function getFunctionDelegate() {
            return this.f3479a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object r10) {
            this.f3479a.invoke(r10);
        }
    }

    public static final LiveData a(LiveData r10, final Function1 r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        kotlin.jvm.internal.q.g(r11, "transform");
        final u r12 = new u();
        if (r10.h() == false) goto L5;
        r12.p(r11.invoke(r10.e()));
    L5:
        r12.q(r10, new a(new Transformations$map$1(r12, r11)));
        return r12;
    }
}
