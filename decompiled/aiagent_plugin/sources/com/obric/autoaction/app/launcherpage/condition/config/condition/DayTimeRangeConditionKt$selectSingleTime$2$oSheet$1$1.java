package com.obric.autoaction.app.launcherpage.condition.config.condition;

import android.view.View;
import com.obric.oui.sheet.v2.OSheet;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlinx.coroutines.n;

/* JADX INFO: compiled from: DayTimeRangeCondition.kt */
/* JADX INFO: loaded from: classes3.dex */
final class DayTimeRangeConditionKt$selectSingleTime$2$oSheet$1$1 implements View.OnClickListener {
    final /* synthetic */ n<com.obric.oui.picker.reels.a.c.b> $cont;
    final /* synthetic */ OSheet $this_apply;

    DayTimeRangeConditionKt$selectSingleTime$2$oSheet$1$1(OSheet r3, n<? super com.obric.oui.picker.reels.a.c.b> r4) {
        n<com.obric.oui.picker.reels.a.c.b> r5 = (n) ZeusTransformUtils.wrapperContextForParams(r4, n.class, "com.obric.aiagent.plugin");
        this.$this_apply = r3;
        this.$cont = r5;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        this.$this_apply.dismiss();
        d.c.d r1 = (d.c.d) ZeusTransformUtils.preCheckCast(this.$cont, d.c.d.class, "com.obric.aiagent.plugin");
        d.n.a r3 = d.n.f38560a;
        r1.resumeWith(d.n.f(null));
    }
}
