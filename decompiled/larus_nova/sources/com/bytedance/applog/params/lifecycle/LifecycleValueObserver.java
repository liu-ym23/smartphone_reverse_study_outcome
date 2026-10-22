package com.bytedance.applog.params.lifecycle;

import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.applog.log.n;
import com.bytedance.applog.params.f;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/applog/params/lifecycle/LifecycleValueObserver;", "Landroidx/lifecycle/LifecycleEventObserver;", "params_release"}, k = 1, mv = {1, 6, 0})
public final class LifecycleValueObserver implements LifecycleEventObserver {

    /* JADX INFO: renamed from: com.bytedance.applog.params.lifecycle.LifecycleValueObserver$1, reason: invalid class name */
    /* JADX INFO: loaded from: classes14.dex */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 6, 0}, xi = 48)
    final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        final /* synthetic */ LifecycleValueObserver this$0;

        public AnonymousClass1(LifecycleValueObserver r100) {
            this.this$0 = r100;
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            this.this$0.getClass();
            throw null;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }
    }

    public final void a() {
        final Function0<Unit> r100 = new LifecycleValueObserver$destroy$1(this);
        Intrinsics.checkNotNullParameter(r100, "f");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L5;
        new Handler(Looper.getMainLooper()).post(new f(r100));
        return;
    L5:
        r100.invoke();
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner r100, Lifecycle.Event r101) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, "event");
        if (r101 == Lifecycle.Event.ON_DESTROY) goto L5;
        return;
    L5:
        n.w().e(null, "params with lifecycle owner destroyed and onDestroy callback invoke start...", new Object[0]);
        throw null;
    }
}
