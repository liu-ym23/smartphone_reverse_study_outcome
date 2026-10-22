package com.obric.autoaction.app.launcherpage.history.historydetail.a;

import android.content.Context;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.app.launcherpage.a.x;
import com.obric.autoaction.app.launcherpage.utils.p;
import com.obric.autogui.common.api.agent.BizStatus;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: HistoryDetailThoughtProcessCell.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i extends com.obric.autoaction.app.launcherpage.ui.f<j> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private x f23868a;

    public static /* synthetic */ void lambda$FnusDUrVkhvS6SYPTDVWNGDVJ6M(i r0) {
        a(r0);
    }

    public i() {
    }

    @Override // com.obric.autoaction.app.launcherpage.ui.f
    public /* synthetic */ void a(com.obric.autoaction.app.launcherpage.ui.h r3, List r4) {
        com.obric.autoaction.app.launcherpage.ui.h r5 = (com.obric.autoaction.app.launcherpage.ui.h) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.autoaction.app.launcherpage.ui.h.class, "com.obric.aiagent.plugin");
        List<? extends Object> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        a((j) ZeusTransformUtils.preCheckCast(r5, j.class, "com.obric.aiagent.plugin"), r6);
    }

    @Override // com.obric.autoaction.app.launcherpage.ui.f
    public View a(ViewGroup r4) {
        o.e(r4, "parent");
        x r5 = x.a(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), r4, false);
        o.c(r5, "inflate(...)");
        this.f23868a = r5;
        if (r5 != null) goto L5;
        o.c("viewBinding");
        r5 = null;
    L5:
        LinearLayout r3 = r5.b();
        o.c(r3, "getRoot(...)");
        return (View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.aiagent.plugin");
    }

    public void a(j r8, List<? extends Object> r9) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        o.e(r8, "item");
        o.e(r10, "payloads");
        x r11 = this.f23868a;
        x r2 = null;
        if (r11 != null) goto L5;
        o.c("viewBinding");
        r11 = null;
    L5:
        r11.f22872a.setText((CharSequence) ZeusTransformUtils.preCheckCast(r8.a(), CharSequence.class, "com.obric.aiagent.plugin"));
        x r12 = this.f23868a;
        if (r12 != null) goto L8;
        o.c("viewBinding");
        r12 = null;
    L8:
        TextPaint r13 = r12.f22872a.getPaint();
        if (r8.b() != 65536) goto L11;
        boolean r3 = true;
    L12:
        r13.setFakeBoldText(r3);
        if (r8.b() <= BizStatus.values().length) goto L21;
        x r14 = this.f23868a;
        if (r14 != null) goto L17;
        o.c("viewBinding");
        r14 = null;
    L17:
        TextView r15 = r14.f22872a;
        int r16 = ZeusTransformUtils.mapRes(R.color.oui_basic_text_1, "color", "oui_basic_text_1");
        x r5 = this.f23868a;
        if (r5 != null) goto L20;
        o.c("viewBinding");
        r5 = null;
    L20:
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.b().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r1, "getContext(...)");
        r15.setTextColor(p.b(r16, r1, null, 2, null));
    L28:
        x r17 = this.f23868a;
        if (r17 != null) goto L31;
        o.c("viewBinding");
    L32:
        r2.f22872a.post(new $$Lambda$i$FnusDUrVkhvS6SYPTDVWNGDVJ6M(this));
        return;
    L31:
        r2 = r17;
        goto L32
    L21:
        x r18 = this.f23868a;
        if (r18 != null) goto L24;
        o.c("viewBinding");
        r18 = null;
    L24:
        TextView r19 = r18.f22872a;
        int r20 = ZeusTransformUtils.mapRes(R.color.oui_basic_text_3, "color", "oui_basic_text_3");
        x r6 = this.f23868a;
        if (r6 != null) goto L27;
        o.c("viewBinding");
        r6 = null;
    L27:
        Context r4 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.b().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r4, "getContext(...)");
        r19.setTextColor(p.b(r20, r4, null, 2, null));
        goto L28
    L11:
        r3 = false;
        goto L12
    }

    private static final void a(i r5) {
        x r0 = r5.f23868a;
        x r1 = null;
        if (r0 != null) goto L6;
        o.c("viewBinding");
        r0 = null;
    L6:
        if (r0.f22872a.getLineCount() <= 1) goto L12;
        x r6 = r5.f23868a;
        if (r6 != null) goto L10;
        o.c("viewBinding");
    L11:
        r1.f22873b.setImageResource(ZeusTransformUtils.mapRes(R.drawable.ic_3_line, "drawable", "ic_3_line"));
        return;
    L10:
        r1 = r6;
        goto L11
    L12:
        x r7 = r5.f23868a;
        if (r7 != null) goto L15;
        o.c("viewBinding");
    L16:
        r1.f22873b.setImageResource(ZeusTransformUtils.mapRes(R.drawable.ic_2_line, "drawable", "ic_2_line"));
        return;
    L15:
        r1 = r7;
        goto L16
    }
}
