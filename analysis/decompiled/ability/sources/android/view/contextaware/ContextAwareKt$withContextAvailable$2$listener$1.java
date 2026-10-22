package android.view.contextaware;

import S7.k;
import android.content.Context;
import kotlin.Metadata;
import kotlin.b;
import m9.InterfaceC1717j;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"androidx/activity/contextaware/ContextAwareKt$withContextAvailable$2$listener$1", "Landroidx/activity/contextaware/OnContextAvailableListener;", "Landroid/content/Context;", "context", "LC7/r;", "onContextAvailable", "(Landroid/content/Context;)V", "activity_release"}, k = 1, mv = {2, 0, 0}, xi = 176)
/* loaded from: classes.dex */
public final class ContextAwareKt$withContextAvailable$2$listener$1 implements OnContextAvailableListener {
    final /* synthetic */ InterfaceC1717j $co;
    final /* synthetic */ k $onContextAvailable;

    public ContextAwareKt$withContextAvailable$2$listener$1(InterfaceC1717j interfaceC1717j, k kVar) {
        this.$co = interfaceC1717j;
        this.$onContextAvailable = kVar;
    }

    @Override // android.view.contextaware.OnContextAvailableListener
    public void onContextAvailable(Context context) {
        Object objA;
        kotlin.jvm.internal.k.f(context, "context");
        InterfaceC1717j interfaceC1717j = this.$co;
        try {
            objA = this.$onContextAvailable.invoke(context);
        } catch (Throwable th) {
            objA = b.a(th);
        }
        interfaceC1717j.resumeWith(objA);
    }
}
