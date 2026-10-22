package com.bytedance.android.ec.hybrid.xelement.ecomlive;

import android.content.Context;
import android.content.ContextWrapper;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class ECLynxLiveView$removeObserver$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ECLynxLiveView this$0;

    public ECLynxLiveView$removeObserver$1(ECLynxLiveView r100) {
        this.this$0 = r100;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Context r100 = this.this$0.f47810a;
        Object r101 = null;
        if ((r100 instanceof ContextWrapper) == true) goto L5;
        r100 = null;
    L5:
        ContextWrapper r102 = (ContextWrapper) r100;
        if (r102 == null) goto L8;
        Context r103 = r102.getBaseContext();
    L10:
        if ((r103 instanceof LifecycleOwner) == false) goto L13;
        r101 = r103;
    L13:
        LifecycleOwner r104 = (LifecycleOwner) r101;
        if (r104 == null) goto L19;
        Lifecycle r105 = r104.getLifecycle();
        if (r105 == null) goto L20;
        r105.removeObserver(this.this$0);
        return;
    L20:
        return;
    L19:
        return;
    L8:
        r103 = null;
        goto L10
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
