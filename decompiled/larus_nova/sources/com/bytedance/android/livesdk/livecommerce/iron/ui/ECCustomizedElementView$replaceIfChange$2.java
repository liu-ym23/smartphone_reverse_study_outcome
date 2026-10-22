package com.bytedance.android.livesdk.livecommerce.iron.ui;

import android.animation.Animator;
import android.view.View;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012'\u0010\u0002\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u00032'\u0010\n\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\t0\u0003H\n¢\u0006\u0002\b\f"}, d2 = {"<anonymous>", "", "ra", "Lkotlin/Function1;", "", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "removeList", "Landroid/animation/Animator;", "aa", "addList", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class ECCustomizedElementView$replaceIfChange$2 extends Lambda implements Function2<Function1<? super List<? extends View>, ? extends Animator>, Function1<? super List<? extends View>, ? extends Animator>, Unit> {
    final /* synthetic */ ArrayList $list;
    final /* synthetic */ Runnable $removeAndAddView;
    final /* synthetic */ ECCustomizedElementView this$0;

    public ECCustomizedElementView$replaceIfChange$2(ECCustomizedElementView r100, ArrayList r101, Runnable r102) {
        this.this$0 = r100;
        this.$list = r101;
        this.$removeAndAddView = r102;
        super(2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Function1<? super List<? extends View>, ? extends Animator> r100, final Function1<? super List<? extends View>, ? extends Animator> r101) {
        Intrinsics.checkNotNullParameter(r100, "ra");
        Intrinsics.checkNotNullParameter(r101, "aa");
        ECCustomizedElementView r102 = this.this$0;
        r102.f148875i = ECCustomizedElementView.a.b.f148878a;
        ArrayList r103 = this.$list;
        ArrayList r104 = new ArrayList();
        Iterator r105 = r103.iterator();
    L4:
        if (r105.hasNext() == false) goto L11;
        Triple r106 = (Triple) r105.next();
        if (((Boolean) r106.getSecond()).booleanValue() == false) goto L8;
        View r107 = this.this$0.getChildAt(((Number) r106.getFirst()).intValue());
    L9:
        if (r107 == null) goto L4;
        r104.add(r107);
        goto L4
    L8:
        r107 = null;
        goto L9
    L11:
        Animator r108 = r100.invoke(r104);
        this.this$0.f148872f = r108;
        com.bytedance.android.livesdk.livecommerce.utils.c.a(r108, new AnonymousClass3(this, r101));
        r108.start();
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Function1<? super List<? extends View>, ? extends Animator> r100, Function1<? super List<? extends View>, ? extends Animator> r101) {
        invoke2(r100, r101);
        return Unit.INSTANCE;
    }
}
