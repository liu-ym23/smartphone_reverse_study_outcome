package com.obric.common.oea.style.scene.qsanim;

import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.p;
import com.obric.common.oea.style.scene.qsanim.pulldown.b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import wb.d;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\t\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "childId", "Landroid/view/View;", "child", "Lcom/obric/common/oea/style/scene/qsanim/pulldown/b;", "<anonymous parameter 2>", "", "invoke", "(Ljava/lang/String;Landroid/view/View;Lcom/obric/common/oea/style/scene/qsanim/pulldown/b;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class ViewGroupVerticalStretchAnimHelper$updateChildTranslations$1 extends Lambda implements Function3<String, View, b, Unit> {
    final /* synthetic */ float $dy;
    final /* synthetic */ ViewGroup $viewGroup;
    final /* synthetic */ a this$0;

    public ViewGroupVerticalStretchAnimHelper$updateChildTranslations$1(a r10, ViewGroup r11, float r12) {
        this.$viewGroup = r11;
        this.$dy = r12;
        super(3);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(String r10, View r11, b r12) {
        p.a(r12);
        invoke2(r10, r11, null);
        return Unit.f21064a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull String r10, @NotNull View r11, @NotNull b r12) {
        q.g(r10, "childId");
        q.g(r11, "child");
        q.g(r12, "<anonymous parameter 2>");
        float r13 = 0.0f;
        if (a.e(null).isEmpty() == false) goto L8;
        Float r14 = (Float) a.b(null).get(r10);
        if (r14 == null) goto L7;
        float r15 = r14.floatValue();
    L11:
        float r16 = ((Number) d.f25401a.a(r11, this.$viewGroup).getSecond()).floatValue() + (r11.getHeight() / 2.0f);
        if (this.$dy < a.d(null)) goto L15;
        r13 = ((this.$dy - a.d(null)) * r16) * a.c(null);
    L15:
        r11.setTranslationY(r15 + r13);
        return;
    L7:
        r15 = 0.0f;
        goto L11
    L8:
        Float r17 = (Float) a.e(null).get(r10);
        if (r17 == null) goto L7;
        r15 = r17.floatValue();
        goto L11
    }
}
