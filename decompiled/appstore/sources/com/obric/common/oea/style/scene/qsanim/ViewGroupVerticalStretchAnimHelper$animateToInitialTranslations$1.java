package com.obric.common.oea.style.scene.qsanim;

import android.view.View;
import androidx.appcompat.widget.p;
import com.obric.common.oea.foundation.animation.engine.DynamicAnimation;
import com.obric.common.oea.style.scene.qsanim.pulldown.b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import wb.c;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\t\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "childId", "Landroid/view/View;", "child", "Lcom/obric/common/oea/style/scene/qsanim/pulldown/b;", "<anonymous parameter 2>", "", "invoke", "(Ljava/lang/String;Landroid/view/View;Lcom/obric/common/oea/style/scene/qsanim/pulldown/b;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class ViewGroupVerticalStretchAnimHelper$animateToInitialTranslations$1 extends Lambda implements Function3<String, View, b, Unit> {
    final /* synthetic */ a this$0;

    public ViewGroupVerticalStretchAnimHelper$animateToInitialTranslations$1(a r10) {
        super(3);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(String r10, View r11, b r12) {
        p.a(r12);
        invoke2(r10, r11, null);
        return Unit.f21064a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull String r11, @NotNull View r12, @NotNull b r13) {
        q.g(r11, "childId");
        q.g(r12, "child");
        q.g(r13, "<anonymous parameter 2>");
        Float r14 = (Float) a.b(null).get(r11);
        if (r14 == null) goto L6;
        float r15 = r14.floatValue();
    L5:
        float r10 = r15;
        c r16 = c.f25400c;
        DynamicAnimation.p r17 = DynamicAnimation.f11508n;
        q.f(r17, "TRANSLATION_Y");
        com.obric.common.oea.foundation.animation.engine.c r18 = c.e(r16, r12, r17, r10, 0.0f, 0.0f, null, null, 60, null);
        if (r18 == null) goto L11;
        a.a(null).put(r11, r18);
        return;
    L11:
        return;
    L6:
        r15 = 0.0f;
        goto L5
    }
}
