package androidx.fragment.app;

import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.m0;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes.dex */
public abstract class FragmentViewModelLazyKt {
    public static final /* synthetic */ ViewModelStoreOwner a(Lazy r10) {
        return d(r10);
    }

    public static final /* synthetic */ ViewModelStoreOwner b(Lazy r10) {
        return e(r10);
    }

    public static final Lazy c(final Fragment r10, KClass r11, Function0 r12, Function0 r13, Function0 r14) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        kotlin.jvm.internal.q.g(r11, "viewModelClass");
        kotlin.jvm.internal.q.g(r12, "storeProducer");
        kotlin.jvm.internal.q.g(r13, "extrasProducer");
        if (r14 != null) goto L6;
        r14 = new FragmentViewModelLazyKt$createViewModelLazy$factoryPromise$1(r10);
    L6:
        return new m0(r11, r12, r14, r13);
    }

    public static final ViewModelStoreOwner d(Lazy r10) {
        return (ViewModelStoreOwner) r10.getValue();
    }

    public static final ViewModelStoreOwner e(Lazy r10) {
        return (ViewModelStoreOwner) r10.getValue();
    }
}
