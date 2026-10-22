package com.bytedance.android.ecom.arch.slice.render.elements.text;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpq/c;", "", AbsMethodDelegate.TAG_INVOKE, "(Lpq/c;)V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class SlcTextElementViewManager$warmUpTextLayoutCache$1$1 extends Lambda implements Function1<pq.c, Unit> {
    final /* synthetic */ Exception $e;

    public SlcTextElementViewManager$warmUpTextLayoutCache$1$1(Exception r100) {
        this.$e = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(pq.c r100) {
        r100.f530258a = "TextWarmUp";
        r100.f530259b = this.$e.toString();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(pq.c r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
