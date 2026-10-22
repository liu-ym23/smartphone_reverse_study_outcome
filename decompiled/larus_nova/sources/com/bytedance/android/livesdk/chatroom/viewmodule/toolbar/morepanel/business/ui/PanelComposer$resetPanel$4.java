package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.ui;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.core.recycle.ComposePool;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kp1.b;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u0000¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkp1/b;", "Llp1/b;", "", "p1", "", AbsMethodDelegate.TAG_INVOKE, "(Lkp1/b;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class PanelComposer$resetPanel$4 extends FunctionReferenceImpl implements Function1<b<lp1.b<Object>>, Unit> {
    public PanelComposer$resetPanel$4(PanelComposer r100) {
        super(1, r100, PanelComposer.class, "removeElementByReset", "removeElementByReset(Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/morepanel/core/element/IComposeElement;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(b<lp1.b<Object>> r100) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        PanelComposer r101 = (PanelComposer) this.receiver;
        ComposePool.c(r101.f116591d, r100);
        View r102 = r100.e();
        if (r102 == null) goto L9;
        ViewGroup r103 = r101.f116593f;
        if (r103 == null) goto L7;
        r103.removeView(r102);
    L7:
        r100.i();
        return;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(b<lp1.b<Object>> r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
