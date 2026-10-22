package com.obric.common.oea.style.scene.qsanim;

import android.view.View;
import androidx.appcompat.widget.p;
import com.obric.common.oea.foundation.animation.engine.c;
import com.obric.common.oea.style.scene.qsanim.pulldown.b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\t\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "childId", "Landroid/view/View;", "child", "Lcom/obric/common/oea/style/scene/qsanim/pulldown/b;", "<anonymous parameter 2>", "", "invoke", "(Ljava/lang/String;Landroid/view/View;Lcom/obric/common/oea/style/scene/qsanim/pulldown/b;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class ViewGroupVerticalStretchAnimHelper$captureChildTranslations$1 extends Lambda implements Function3<String, View, b, Unit> {
    final /* synthetic */ a this$0;

    public ViewGroupVerticalStretchAnimHelper$captureChildTranslations$1(a r10) {
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
        float r13 = r11.getTranslationY();
        if (a.e(null).isEmpty() == false) goto L5;
        a.b(null).put(r10, Float.valueOf(r13));
    L5:
        c r14 = (c) a.a(null).get(r10);
        if (r14 != null) goto L8;
        return;
    L8:
        if (r14.g() == false) goto L10;
        r14.c();
        r11.setTranslationY(r13);
        a.e(null).put(r10, Float.valueOf(r13));
        return;
    L10:
        a.e(null).remove(r10);
    }
}
