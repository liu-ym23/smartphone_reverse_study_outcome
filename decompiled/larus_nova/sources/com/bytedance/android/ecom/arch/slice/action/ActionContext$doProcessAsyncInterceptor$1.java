package com.bytedance.android.ecom.arch.slice.action;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class ActionContext$doProcessAsyncInterceptor$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ IAction $action;
    final /* synthetic */ Iterator $asyncInterceptorIterator;
    final /* synthetic */ c $params;
    final /* synthetic */ ActionContext this$0;

    public ActionContext$doProcessAsyncInterceptor$1(ActionContext r100, Iterator r101, IAction r102, c r103) {
        this.this$0 = r100;
        this.$asyncInterceptorIterator = r101;
        this.$action = r102;
        this.$params = r103;
        super(1);
    }

    public final void invoke(boolean r100) {
        if (r100 == false) goto L4;
        return;
    L4:
        ActionContext r101 = this.this$0;
        Iterator r102 = this.$asyncInterceptorIterator;
        IAction r103 = this.$action;
        c r104 = this.$params;
        int r105 = ActionContext.f49965h;
        r101.getClass();
        if (r102.hasNext() == false) goto L7;
        k r106 = (k) r102.next();
        new ActionContext$doProcessAsyncInterceptor$1(r101, r102, r103, r104);
        r106.a();
        return;
    L7:
        r101.a(r103, r104, null);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean r100) {
        invoke(r100.booleanValue());
        return Unit.INSTANCE;
    }
}
