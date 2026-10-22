package android.view;

import C7.d;
import S7.k;
import kotlin.Metadata;
import kotlin.jvm.internal.g;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CoroutineLiveDataKt$sam$androidx_lifecycle_Observer$0 implements Observer, g {
    private final /* synthetic */ k function;

    public CoroutineLiveDataKt$sam$androidx_lifecycle_Observer$0(k function) {
        kotlin.jvm.internal.k.f(function, "function");
        this.function = function;
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof Observer) && (obj instanceof g)) {
            return kotlin.jvm.internal.k.b(getFunctionDelegate(), ((g) obj).getFunctionDelegate());
        }
        return false;
    }

    @Override // kotlin.jvm.internal.g
    public final d getFunctionDelegate() {
        return this.function;
    }

    public final int hashCode() {
        return getFunctionDelegate().hashCode();
    }

    @Override // android.view.Observer
    public final /* synthetic */ void onChanged(Object obj) {
        this.function.invoke(obj);
    }
}
