package com.bytedance.android.live.revlink.link.biz.component;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lyy0/c;", "", AbsMethodDelegate.TAG_INVOKE, "(Lyy0/c;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final class BreakThroughBarUIOperation$createCardFunc$1 extends Lambda implements Function1<yy0.c, Unit> {
    final /* synthetic */ Function1 $configure;
    final /* synthetic */ BreakThroughBarUIOperation this$0;

    public BreakThroughBarUIOperation$createCardFunc$1(BreakThroughBarUIOperation r100, Function1 r101) {
        this.this$0 = r100;
        this.$configure = r101;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(yy0.c r100) {
        Intrinsics.checkNotNullParameter(r100, "$receiver");
        r100.d(new AnonymousClass1(this));
        Function1 r101 = this.$configure;
        if (r101 == null) goto L6;
        Unit r102 = (Unit) r101.invoke(r100);
        return;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(yy0.c r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
