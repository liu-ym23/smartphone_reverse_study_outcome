package com.obric.oui.swipeaction;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import bg.h;
import com.bytedance.apm.constant.CommonKey;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", CommonKey.KEY_VALUE, "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class OSwipeDeleteAnimator$animateRemoveImpl$1 extends Lambda implements Function1<Float, Unit> {
    final /* synthetic */ RecyclerView.ViewHolder $holder;
    final /* synthetic */ int $originalHeight;
    final /* synthetic */ View $view;
    final /* synthetic */ b this$0;

    public OSwipeDeleteAnimator$animateRemoveImpl$1(b r10, RecyclerView.ViewHolder r11, int r12, View r13) {
        this.$holder = r11;
        this.$originalHeight = r12;
        this.$view = r13;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Float r10) {
        invoke(r10.floatValue());
        return Unit.f21064a;
    }

    public final void invoke(float r10) {
        if (b.k0(null).contains(this.$holder) == false) goto L6;
        int r11 = h.k(yf.b.b(r10), 0, this.$originalHeight);
        ViewGroup.LayoutParams r12 = this.$view.getLayoutParams();
        r12.height = r11;
        this.$view.setLayoutParams(r12);
        this.$view.setClipBounds(new Rect(0, 0, this.$view.getWidth(), r11));
        return;
    }
}
