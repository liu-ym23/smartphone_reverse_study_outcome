package com.obric.oui.orecyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class ODragItemTouchHelper$CallbackImpl$animateDrop$1 extends Lambda implements Function2<Boolean, Throwable, Unit> {
    final /* synthetic */ View $item;
    final /* synthetic */ View $mirror;
    final /* synthetic */ RecyclerView.t $viewHolder;
    final /* synthetic */ e this$0;

    public ODragItemTouchHelper$CallbackImpl$animateDrop$1(View r10, View r11, e r12, RecyclerView.t r13) {
        this.$item = r10;
        this.$mirror = r11;
        this.$viewHolder = r13;
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Unit mo0invoke(Boolean r10, Throwable r11) {
        invoke(r10.booleanValue(), r11);
        return Unit.f21064a;
    }

    public final void invoke(boolean r10, @Nullable Throwable r11) {
        this.$item.setScaleX(1.0f);
        this.$item.setScaleY(1.0f);
        this.$item.setVisibility(0);
        this.$mirror.setScaleX(1.0f);
        this.$mirror.setScaleY(1.0f);
        ViewParent r12 = this.$mirror.getParent();
        if ((r12 instanceof ViewGroup) == false) goto L5;
        ViewGroup r13 = (ViewGroup) r12;
    L6:
        if (r13 == null) goto L9;
        r13.removeView(this.$mirror);
    L9:
        View r14 = (View) e.b(null).get(this.$viewHolder);
        if (r14 == null) goto L17;
        View r15 = this.$mirror;
        RecyclerView.t r16 = this.$viewHolder;
        if (q.b(r14, r15) == false) goto L16;
        e.b(null).remove(r16);
        return;
    L16:
        return;
    L17:
        return;
    L5:
        r13 = null;
        goto L6
    }
}
