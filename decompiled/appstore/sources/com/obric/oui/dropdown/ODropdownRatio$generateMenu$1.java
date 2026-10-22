package com.obric.oui.dropdown;

import android.view.View;
import com.tmall.wireless.tangram.structure.card.SlideCard;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "V", "<anonymous parameter 0>", "Landroid/view/View;", SlideCard.KEY_INDEX, "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class ODropdownRatio$generateMenu$1 extends Lambda implements Function2<View, Integer, Unit> {
    final /* synthetic */ ODropdownTrigger $caller;
    final /* synthetic */ a this$0;

    public ODropdownRatio$generateMenu$1(a r10, ODropdownTrigger r11) {
        this.$caller = r11;
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Unit mo0invoke(View r10, Integer r11) {
        invoke(r10, r11.intValue());
        return Unit.f21064a;
    }

    public final void invoke(@NotNull View r10, int r11) {
        q.g(r10, "$noName_0");
        Function0 r12 = null;
        Object r13 = a.c(null).get(r11);
        a.d(null, r13);
        Function1 r14 = a.b(null);
        if (r14 != null) goto L5;
        q.y("onTextChanged");
        r14 = null;
    L5:
        r14.invoke(String.valueOf(a.c(null).get(r11)));
        if ((r13 instanceof IconItem) == false) goto L8;
        this.$caller.getValue().setCompoundDrawablesRelativeWithIntrinsicBounds(((IconItem) r13).getIconRes(), 0, 0, 0);
    L8:
        Function0 r15 = a.a(null);
        if (r15 != null) goto L11;
        q.y("dismiss");
    L12:
        r12.invoke();
        return;
    L11:
        r12 = r15;
        goto L12
    }
}
