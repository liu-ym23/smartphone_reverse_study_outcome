package com.obric.appstore.base;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.u;

/* JADX INFO: loaded from: classes3.dex */
public abstract class LocaleChangeAwareKt {
    public static final void a(final Fragment r10, LocaleChangeAware r11) {
        q.g(r10, "<this>");
        q.g(r11, "localeChangeAware");
        final Function0<Fragment> r12 = new LocaleChangeAwareKt$setLocaleChangeAware$$inlined$viewModels$default$4(r10);
        final Lazy r13 = kotlin.b.a(LazyThreadSafetyMode.NONE, new LocaleChangeAwareKt$setLocaleChangeAware$$inlined$viewModels$default$5(r12));
        final Function0 r14 = null;
        Lazy r15 = FragmentViewModelLazyKt.c(r10, u.b(m.class), new LocaleChangeAwareKt$setLocaleChangeAware$$inlined$viewModels$default$6(r13), new LocaleChangeAwareKt$setLocaleChangeAware$$inlined$viewModels$default$7(r14, r13), new LocaleChangeAwareKt$setLocaleChangeAware$$inlined$viewModels$default$8(r10, r13));
        b(r15).g(r10.requireContext());
        b(r15).h(r11);
        r10.getLifecycle().a(b(r15));
    }

    public static final m b(Lazy r10) {
        return (m) r10.getValue();
    }
}
