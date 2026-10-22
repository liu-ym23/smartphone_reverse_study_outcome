package com.obric.autoaction.app.launcherpage.detail.condition.b;

import android.content.Context;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.oui.picker.reels.views.WheelView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.m;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: ReelYearlyPickerController.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d extends a<m<? extends Integer, ? extends Integer>> {
    public d() {
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.condition.b.b
    public /* synthetic */ Object a(com.obric.oui.picker.reels.a r3) {
        return b((com.obric.oui.picker.reels.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.picker.reels.a.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.condition.b.a
    public /* synthetic */ void a(Context r3, com.obric.oui.picker.reels.a.a.C0970a r4, m<? extends Integer, ? extends Integer> r5) {
        a2((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), r4, (m) ZeusTransformUtils.preCheckCast(r5, m.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.condition.b.b
    public /* synthetic */ void a(com.obric.oui.picker.reels.a r3, Object r4) {
        a((com.obric.oui.picker.reels.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.picker.reels.a.class, "com.obric.aiagent.plugin"), (m) ZeusTransformUtils.preCheckCast(r4, m.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.condition.b.b
    public /* synthetic */ void b(com.obric.oui.picker.reels.a r3, Object r4) {
        b((com.obric.oui.picker.reels.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.picker.reels.a.class, "com.obric.aiagent.plugin"), (m) ZeusTransformUtils.preCheckCast(r4, m.class, "com.obric.aiagent.plugin"));
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public void a2(Context r9, com.obric.oui.picker.reels.a.a.C0970a r10, m<Integer, Integer> r11) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        o.e(r8, "context");
        o.e(r10, "builder");
        o.e(r11, "initSelect");
        com.obric.oui.picker.reels.a.a.C0970a.a(r10, r8, 0, (Integer) ZeusTransformUtils.preCheckCast(r11.a(), Integer.class, "com.obric.aiagent.plugin"), null, 10, null);
        com.obric.oui.picker.reels.a.a.C0970a.b(r10, r8, 0, (Integer) ZeusTransformUtils.preCheckCast(r11.b(), Integer.class, "com.obric.aiagent.plugin"), null, 10, null);
    }

    public void a(com.obric.oui.picker.reels.a r5, m<Integer, Integer> r6) {
        com.obric.oui.picker.reels.a r7 = (com.obric.oui.picker.reels.a) ZeusTransformUtils.wrapperContextForParams(r5, com.obric.oui.picker.reels.a.class, "com.obric.aiagent.plugin");
        o.e(r7, "reelPicker");
        o.e(r6, "preSelectItem");
        m<Integer, Integer> r0 = b(r7);
        if (((Number) ZeusTransformUtils.preCheckCast(r6.a(), Number.class, "com.obric.aiagent.plugin")).intValue() != ((Number) ZeusTransformUtils.preCheckCast(r0.a(), Number.class, "com.obric.aiagent.plugin")).intValue()) goto L5;
        return;
    L5:
        c(r7, r0);
    }

    public void b(com.obric.oui.picker.reels.a r3, m<Integer, Integer> r4) {
        com.obric.oui.picker.reels.a r5 = (com.obric.oui.picker.reels.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.picker.reels.a.class, "com.obric.aiagent.plugin");
        o.e(r5, "reelPicker");
        o.e(r4, "initSelect");
        c(r5, r4);
    }

    private final void c(com.obric.oui.picker.reels.a r17, m<Integer, Integer> r18) {
        com.obric.oui.picker.reels.a r0 = (com.obric.oui.picker.reels.a) ZeusTransformUtils.wrapperContextForParams(r17, com.obric.oui.picker.reels.a.class, "com.obric.aiagent.plugin");
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.asView().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        int r3 = ((Number) ZeusTransformUtils.preCheckCast(r18.a(), Number.class, "com.obric.aiagent.plugin")).intValue();
        int r1 = ((Number) ZeusTransformUtils.preCheckCast(r18.b(), Number.class, "com.obric.aiagent.plugin")).intValue();
        String r10 = r2.getString(ZeusTransformUtils.mapRes(R.string.oui_reel_picker_day_tag, WsChannelMultiProcessSharedProvider.STRING_TYPE, "oui_reel_picker_day_tag"));
        o.c(r10, "getString(...)");
        a(this, 1, 31, r10, 0, 8, null);
        if (r3 != 1) goto L5;
    L20:
        String r11 = r2.getString(ZeusTransformUtils.mapRes(R.string.oui_reel_picker_day_tag, WsChannelMultiProcessSharedProvider.STRING_TYPE, "oui_reel_picker_day_tag"));
        o.c(r11, "getString(...)");
        List<String> r4 = a(this, 1, 31, r11, 0, 8, null);
    L21:
        WheelView r5 = r0.getReelView(1);
        if (r5 == null) goto L25;
        r5.setEntries(r4);
    L25:
        if (r4.size() > r1) goto L29;
        WheelView r6 = r0.getReelView(1);
        if (r6 == null) goto L33;
        r6.setStartIndex(r4.size() - 1);
        return;
    L33:
        return;
    L29:
        WheelView r7 = r0.getReelView(1);
        if (r7 == null) goto L35;
        r7.setStartIndex(r1 - 1);
        return;
    L35:
        return;
    L5:
        if (r3 != 2) goto L7;
        String r12 = r2.getString(ZeusTransformUtils.mapRes(R.string.oui_reel_picker_day_tag, WsChannelMultiProcessSharedProvider.STRING_TYPE, "oui_reel_picker_day_tag"));
        o.c(r12, "getString(...)");
        r4 = a(this, 1, 29, r12, 0, 8, null);
        goto L21
    L7:
        if (r3 == 3) goto L20;
        if (r3 == 5) goto L20;
        if (r3 == 10) goto L20;
        if (r3 == 12) goto L20;
        if (r3 == 7) goto L20;
        if (r3 == 8) goto L20;
        String r13 = r2.getString(ZeusTransformUtils.mapRes(R.string.oui_reel_picker_day_tag, WsChannelMultiProcessSharedProvider.STRING_TYPE, "oui_reel_picker_day_tag"));
        o.c(r13, "getString(...)");
        r4 = a(this, 1, 30, r13, 0, 8, null);
        goto L21
    }

    public m<Integer, Integer> b(com.obric.oui.picker.reels.a r3) {
        com.obric.oui.picker.reels.a r2 = (com.obric.oui.picker.reels.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.picker.reels.a.class, "com.obric.aiagent.plugin");
        o.e(r2, "reelPicker");
        int r4 = 0;
        WheelView r0 = r2.getReelView(0);
        if (r0 == null) goto L5;
        int r1 = r0.getCurrentIndex();
    L6:
        WheelView r5 = r2.getReelView(1);
        if (r5 == null) goto L10;
        r4 = r5.getCurrentIndex();
    L10:
        return new m(Integer.valueOf(r1 + 1), Integer.valueOf(r4 + 1));
    L5:
        r1 = 0;
        goto L6
    }

    static /* synthetic */ List a(d r0, int r1, int r2, String r3, int r4, int r5, Object r6) {
        if ((r5 & 4) == 0) goto L6;
        r3 = "";
    L6:
        if ((r5 & 8) == 0) goto L9;
        r4 = 2;
    L9:
        return r0.a(r1, r2, r3, r4);
    }

    private final List<String> a(int r3, int r4, String r5, int r6) {
        List<String> r2 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        if (r3 > r4) goto L7;
    L4:
        r2.add(d.o.o.a(String.valueOf(r3), r6, '0') + r5);
        if (r3 == r4) goto L7;
        r3 = r3 + 1;
    L7:
        return r2;
    }
}
