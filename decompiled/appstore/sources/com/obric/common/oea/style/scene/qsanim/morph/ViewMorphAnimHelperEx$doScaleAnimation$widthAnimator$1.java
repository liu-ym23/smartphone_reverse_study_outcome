package com.obric.common.oea.style.scene.qsanim.morph;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.apm.constant.CommonKey;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import yf.b;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", CommonKey.KEY_VALUE, "", "invoke"}, k = 3, mv = {1, 4, 3})
final class ViewMorphAnimHelperEx$doScaleAnimation$widthAnimator$1 extends Lambda implements Function1<Float, Unit> {
    final /* synthetic */ View $this_doScaleAnimation;

    public ViewMorphAnimHelperEx$doScaleAnimation$widthAnimator$1(View r10) {
        this.$this_doScaleAnimation = r10;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Float r10) {
        invoke(r10.floatValue());
        return Unit.f21064a;
    }

    public final void invoke(float r10) {
        View r11 = this.$this_doScaleAnimation;
        ViewGroup.LayoutParams r12 = r11.getLayoutParams();
        r12.width = b.b(r10);
        Unit r13 = Unit.f21064a;
        r11.setLayoutParams(r12);
    }
}
