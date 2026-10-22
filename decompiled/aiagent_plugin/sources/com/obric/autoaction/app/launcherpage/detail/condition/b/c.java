package com.obric.autoaction.app.launcherpage.detail.condition.b;

import android.content.Context;
import com.obric.oui.picker.reels.views.WheelView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.m;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: ReelTimerPickerController.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends com.obric.autoaction.app.launcherpage.detail.condition.b.a<m<? extends Integer, ? extends Integer>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f23406a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f23407b;

    /* JADX INFO: compiled from: ReelTimerPickerController.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f23406a = new a(null);
    }

    public c() {
        this(0, 1, null);
    }

    public /* synthetic */ c(int r1, int r2, h r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = 30;
    L5:
        this(r1);
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

    public c(int r1) {
        this.f23407b = r1;
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public void a2(Context r12, com.obric.oui.picker.reels.a.a.C0970a r13, m<Integer, Integer> r14) {
        Context r15 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.aiagent.plugin");
        o.e(r15, "context");
        o.e(r13, "builder");
        o.e(r14, "initSelect");
        com.obric.oui.picker.reels.a.a.C0970a.a(r13, r15, 0, false, false, (Integer) ZeusTransformUtils.preCheckCast(r14.a(), Integer.class, "com.obric.aiagent.plugin"), null, 46, null);
        if (((Number) ZeusTransformUtils.preCheckCast(r14.a(), Number.class, "com.obric.aiagent.plugin")).intValue() != 0) goto L5;
        com.obric.oui.picker.reels.a.a.C0970a.a(r13, r15, 0, false, Integer.valueOf(((Number) ZeusTransformUtils.preCheckCast(r14.b(), Number.class, "com.obric.aiagent.plugin")).intValue() - this.f23407b), null, 22, null);
        return;
    L5:
        com.obric.oui.picker.reels.a.a.C0970a.a(r13, r15, 0, false, (Integer) ZeusTransformUtils.preCheckCast(r14.b(), Integer.class, "com.obric.aiagent.plugin"), null, 22, null);
    }

    public void a(com.obric.oui.picker.reels.a r6, m<Integer, Integer> r7) {
        com.obric.oui.picker.reels.a r8 = (com.obric.oui.picker.reels.a) ZeusTransformUtils.wrapperContextForParams(r6, com.obric.oui.picker.reels.a.class, "com.obric.aiagent.plugin");
        o.e(r8, "reelPicker");
        o.e(r7, "preSelectItem");
        if (this.f23407b != 0) goto L5;
        return;
    L5:
        m<Integer, Integer> r0 = d(r8, r7);
        if (((Number) ZeusTransformUtils.preCheckCast(r7.a(), Number.class, "com.obric.aiagent.plugin")).intValue() != ((Number) ZeusTransformUtils.preCheckCast(r0.a(), Number.class, "com.obric.aiagent.plugin")).intValue()) goto L8;
        return;
    L8:
        if (((Number) ZeusTransformUtils.preCheckCast(r7.a(), Number.class, "com.obric.aiagent.plugin")).intValue() != 0) goto L10;
    L12:
        c(r8, r0);
        return;
    L10:
        if (((Number) ZeusTransformUtils.preCheckCast(r0.a(), Number.class, "com.obric.aiagent.plugin")).intValue() == 0) goto L12;
    }

    public void b(com.obric.oui.picker.reels.a r4, m<Integer, Integer> r5) {
        com.obric.oui.picker.reels.a r6 = (com.obric.oui.picker.reels.a) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.oui.picker.reels.a.class, "com.obric.aiagent.plugin");
        o.e(r6, "reelPicker");
        o.e(r5, "initSelect");
        if (((Number) ZeusTransformUtils.preCheckCast(r5.a(), Number.class, "com.obric.aiagent.plugin")).intValue() == 0) goto L5;
        return;
    L5:
        c(r6, r5);
    }

    private final void c(com.obric.oui.picker.reels.a r11, m<Integer, Integer> r12) {
        com.obric.oui.picker.reels.a r13 = (com.obric.oui.picker.reels.a) ZeusTransformUtils.wrapperContextForParams(r11, com.obric.oui.picker.reels.a.class, "com.obric.aiagent.plugin");
        if (((Number) ZeusTransformUtils.preCheckCast(r12.a(), Number.class, "com.obric.aiagent.plugin")).intValue() == 0) goto L10;
        WheelView r0 = r13.getReelView(1);
        if (r0 == null) goto L7;
        r0.setEntries(a(this, 0, 59, "", 0, 8, null));
    L7:
        WheelView r10 = r13.getReelView(1);
        if (r10 == null) goto L17;
        r10.setStartIndex(((Number) ZeusTransformUtils.preCheckCast(r12.b(), Number.class, "com.obric.aiagent.plugin")).intValue());
        return;
    L17:
        return;
    L10:
        WheelView r1 = r13.getReelView(1);
        if (r1 == null) goto L13;
        r1.setEntries(a(this, this.f23407b, 59, "", 0, 8, null));
    L13:
        WheelView r14 = r13.getReelView(1);
        if (r14 == null) goto L19;
        r14.setStartIndex(Math.max(((Number) ZeusTransformUtils.preCheckCast(r12.b(), Number.class, "com.obric.aiagent.plugin")).intValue() - this.f23407b, 0));
        return;
    }

    public m<Integer, Integer> b(com.obric.oui.picker.reels.a r4) {
        com.obric.oui.picker.reels.a r5 = (com.obric.oui.picker.reels.a) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.oui.picker.reels.a.class, "com.obric.aiagent.plugin");
        o.e(r5, "reelPicker");
        int r0 = 0;
        WheelView r1 = r5.getReelView(0);
        if (r1 == null) goto L5;
        int r2 = r1.getCurrentIndex();
    L6:
        WheelView r6 = r5.getReelView(1);
        if (r6 == null) goto L9;
        r0 = r6.getCurrentIndex();
    L9:
        if (r2 != 0) goto L12;
        r0 = r0 + this.f23407b;
    L12:
        return new m(Integer.valueOf(r2), Integer.valueOf(r0));
    L5:
        r2 = 0;
        goto L6
    }

    private final m<Integer, Integer> d(com.obric.oui.picker.reels.a r5, m<Integer, Integer> r6) {
        com.obric.oui.picker.reels.a r7 = (com.obric.oui.picker.reels.a) ZeusTransformUtils.wrapperContextForParams(r5, com.obric.oui.picker.reels.a.class, "com.obric.aiagent.plugin");
        if (((Number) ZeusTransformUtils.preCheckCast(r6.a(), Number.class, "com.obric.aiagent.plugin")).intValue() < 0) goto L27;
        if (((Number) ZeusTransformUtils.preCheckCast(r6.b(), Number.class, "com.obric.aiagent.plugin")).intValue() < 0) goto L27;
        int r0 = 0;
        WheelView r2 = r7.getReelView(0);
        if (r2 == null) goto L10;
        int r3 = r2.getCurrentIndex();
    L11:
        WheelView r8 = r7.getReelView(1);
        if (r8 == null) goto L15;
        r0 = r8.getCurrentIndex();
    L15:
        if (((Number) ZeusTransformUtils.preCheckCast(r6.a(), Number.class, "com.obric.aiagent.plugin")).intValue() != 0) goto L19;
        if (r3 == 0) goto L19;
        r0 = r0 + this.f23407b;
    L25:
        return new m(Integer.valueOf(r3), Integer.valueOf(r0));
    L19:
        if (((Number) ZeusTransformUtils.preCheckCast(r6.a(), Number.class, "com.obric.aiagent.plugin")).intValue() == 0) goto L25;
        if (r3 != 0) goto L25;
        int r4 = this.f23407b;
        if (r0 >= r4) goto L25;
        r0 = r4;
        goto L25
    L10:
        r3 = 0;
    L27:
        return b(r7);
    }

    static /* synthetic */ List a(c r0, int r1, int r2, String r3, int r4, int r5, Object r6) {
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
