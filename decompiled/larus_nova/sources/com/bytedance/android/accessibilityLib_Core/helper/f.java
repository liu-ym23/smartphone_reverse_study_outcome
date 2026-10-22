package com.bytedance.android.accessibilityLib_Core.helper;

import com.bytedance.android.accessibilityLib_Core.base.api.AbstractAccessibilityLibIsolation$appWindowEventListener$2;
import java.lang.ref.WeakReference;
import java.util.function.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class f<T> implements Predicate<WeakReference<AppWindows.a>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AppWindows.a f38282a;

    public f(AbstractAccessibilityLibIsolation$appWindowEventListener$2.a r100) {
        this.f38282a = r100;
    }

    @Override // java.util.function.Predicate
    public final boolean test(WeakReference<AppWindows.a> r100) {
        return Intrinsics.areEqual(r100.get(), this.f38282a);
    }
}
