package com.obric.autoaction.app.launcherpage.condition.config.condition;

import android.content.Context;
import android.view.View;
import android.widget.Toast;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.oui.sheet.v2.OSheet;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlinx.coroutines.n;

/* JADX INFO: compiled from: DayTimeRangeCondition.kt */
/* JADX INFO: loaded from: classes3.dex */
final class DayTimeRangeConditionKt$selectSingleTime$2$oSheet$1$2 implements View.OnClickListener {
    final /* synthetic */ n<com.obric.oui.picker.reels.a.c.b> $cont;
    final /* synthetic */ Context $ctx;
    final /* synthetic */ com.obric.oui.picker.reels.a.c.b $minTime;
    final /* synthetic */ com.obric.oui.picker.reels.a.c $picker;
    final /* synthetic */ OSheet $this_apply;

    DayTimeRangeConditionKt$selectSingleTime$2$oSheet$1$2(com.obric.oui.picker.reels.a.c r3, com.obric.oui.picker.reels.a.c.b r4, Context r5, OSheet r6, n<? super com.obric.oui.picker.reels.a.c.b> r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        n<com.obric.oui.picker.reels.a.c.b> r9 = (n) ZeusTransformUtils.wrapperContextForParams(r7, n.class, "com.obric.aiagent.plugin");
        this.$picker = r3;
        this.$minTime = r4;
        this.$ctx = ZeusTransformUtils.wrapperContext(r8, "com.obric.aiagent.plugin");
        this.$this_apply = r6;
        this.$cont = r9;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        com.obric.oui.picker.reels.a.c.b r5 = this.$picker.a();
        if (r5 != null) goto L6;
        return;
    L6:
        if (this.$minTime != null) goto L8;
    L15:
        this.$this_apply.dismiss();
        if (this.$cont.a() == false) goto L19;
        d.c.d r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this.$cont, d.c.d.class, "com.obric.aiagent.plugin");
        d.n.a r0 = d.n.f38560a;
        r3.resumeWith(d.n.f(r5));
        return;
    L19:
        return;
    L8:
        if (r5.a() >= this.$minTime.a()) goto L10;
    L13:
        Context r6 = this.$ctx;
        Toast.makeText(r6, (CharSequence) ZeusTransformUtils.preCheckCast(r6.getString(ZeusTransformUtils.mapRes(R.string.select_time_range__error, WsChannelMultiProcessSharedProvider.STRING_TYPE, "select_time_range__error")), CharSequence.class, "com.obric.aiagent.plugin"), 0).show();
        return;
    L10:
        if (r5.a() != this.$minTime.a()) goto L15;
        if (r5.b() > this.$minTime.b()) goto L15;
        goto L13
    }
}
