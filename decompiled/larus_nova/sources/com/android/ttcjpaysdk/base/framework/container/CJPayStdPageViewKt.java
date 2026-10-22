package com.android.ttcjpaysdk.base.framework.container;

import androidx.lifecycle.Lifecycle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"getLifecycleScope", "Lcom/android/ttcjpaysdk/base/framework/container/LifecycleCoroutineScope;", "Landroidx/lifecycle/Lifecycle;", "base-context_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class CJPayStdPageViewKt {
    public static final LifecycleCoroutineScope getLifecycleScope(Lifecycle r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return LifecycleCoroutineScope.Companion.get(r100);
    }
}
