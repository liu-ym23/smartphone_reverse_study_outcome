package com.obric.autoaction.app.launcherpage.module.a;

import android.app.Activity;
import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.app.launcherpage.main.IMainTab;
import com.obric.oui.popover.menu.OPopoverEntranceMenuView;
import com.obric.oui.popover.v2.OPopover;
import com.obric.oui.selection.OActionSheet;
import com.obric.oui.selection.OActionSheetButton;
import com.obric.oui.sheet.OInsetSheet;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.m;
import d.h.b.o;
import d.h.b.z;
import d.x;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PopupViewsUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f24077a = null;

    /* JADX INFO: compiled from: PopupViewsUtils.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f24078a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final d.h.a.a<x> f24079b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (o.a(this.f24078a, r6.f24078a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f24079b, r6.f24079b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            int r0 = this.f24078a.hashCode() * 31;
            d.h.a.a<x> r1 = this.f24079b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public String toString() {
            return "DeleteButtonConfig(text=" + this.f24078a + ", onClick=" + this.f24079b + ')';
        }

        public a(String r3, d.h.a.a<x> r4) {
            d.h.a.a<x> r5 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
            o.e(r3, "text");
            this.f24078a = r3;
            this.f24079b = r5;
        }

        public final String a() {
            return this.f24078a;
        }

        public final d.h.a.a<x> b() {
            return this.f24079b;
        }
    }

    static {
        f24077a = new h();
    }

    public static /* synthetic */ x lambda$3SHmKp3nK9LoMMJ_1ukDZqDOr8I(d.h.a.b r0, z.f r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ void lambda$BQhbzC4f4ZoTpzTjJoSxU1ftH8A(a r0, OActionSheet r1, View r2) {
        a(r0, r1, r2);
    }

    public static /* synthetic */ x lambda$CDk4AtrcfpYCVSDBQSqdTm3Yod4(z.f r0) {
        return b(r0);
    }

    public static /* synthetic */ x lambda$NOCo4k51H6_lXgL0Al4_LbP1kbA(d.h.a.a r0, View r1, int r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ x lambda$Qk4cWUD1nvGACHZvstNDX3q6qkY(d.h.a.a r0, View r1, int r2) {
        return b(r0, r1, r2);
    }

    public static /* synthetic */ x lambda$T3S_DtFyJr5PtI6A0jStSSxgS4c(d.h.a.a r0, View r1, int r2) {
        return c(r0, r1, r2);
    }

    public static /* synthetic */ x lambda$X4nZicFJreA3zVijVLS1tecDj74(z.f r0) {
        return a(r0);
    }

    /* JADX INFO: renamed from: lambda$eDMRGsfhc-8uSsngRc_yFQF3i80, reason: not valid java name */
    public static /* synthetic */ void m547lambda$eDMRGsfhc8uSsngRc_yFQF3i80(d.h.a.b r0, OActionSheet r1, View r2) {
        b(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$eIHTy52sVwWAkM6IAmkw_WmvpkY(d.h.a.b r0, OActionSheet r1, View r2) {
        a(r0, r1, r2);
    }

    public static /* synthetic */ x lambda$pdnENgWXiDQxA5TjscU2kF0wCBY(d.h.a.a r0, OPopoverEntranceMenuView.a r1, String r2, View r3, int r4) {
        return a(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ x lambda$s27V_BZKcgcrGi1btGvqPwSJ08c(z.f r0) {
        return c(r0);
    }

    private h() {
    }

    public final void a(OPopoverEntranceMenuView.a r16, d.h.a.a<x> r17) {
        final d.h.a.a r0 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r17, d.h.a.a.class, "com.obric.aiagent.plugin");
        o.e(r16, "<this>");
        String r2 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r16.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.task_delete, WsChannelMultiProcessSharedProvider.STRING_TYPE, "task_delete"));
        int r4 = ZeusTransformUtils.mapRes(R.drawable.ic_delete, "drawable", "ic_delete");
        int r5 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r16.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getColor(ZeusTransformUtils.mapRes(R.color.oui_functional_red_6, "color", "oui_functional_red_6"));
        OPopoverEntranceMenuView.a.a(r16, Integer.valueOf(r4), null, Integer.valueOf(r5), (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin"), null, null, true, null, new $$Lambda$h$NOCo4k51H6_lXgL0Al4_LbP1kbA(r0), 178, null);
    }

    private static final x a(d.h.a.a r1, View r2, int r3) {
        d.h.a.a r4 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r1, d.h.a.a.class, "com.obric.aiagent.plugin");
        o.e(r2, "v");
        if (r4 == null) goto L6;
        r4.invoke();
    L6:
        return x.f38692a;
    }

    public final void a(OPopoverEntranceMenuView.a r16, int r17, d.h.a.a<x> r18) {
        final d.h.a.a r0 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r18, d.h.a.a.class, "com.obric.aiagent.plugin");
        o.e(r16, "<this>");
        String r2 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r16.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(r17);
        OPopoverEntranceMenuView.a.a(r16, Integer.valueOf(ZeusTransformUtils.mapRes(R.drawable.ic_add_pin_short_cut, "drawable", "ic_add_pin_short_cut")), null, null, (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin"), null, null, false, null, new $$Lambda$h$Qk4cWUD1nvGACHZvstNDX3q6qkY(r0), 246, null);
    }

    private static final x b(d.h.a.a r1, View r2, int r3) {
        d.h.a.a r4 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r1, d.h.a.a.class, "com.obric.aiagent.plugin");
        o.e(r2, "v");
        if (r4 == null) goto L6;
        r4.invoke();
    L6:
        return x.f38692a;
    }

    public final void b(OPopoverEntranceMenuView.a r16, int r17, d.h.a.a<x> r18) {
        final d.h.a.a r0 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r18, d.h.a.a.class, "com.obric.aiagent.plugin");
        o.e(r16, "<this>");
        o.e(r0, "onConfirm");
        String r2 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r16.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(r17);
        OPopoverEntranceMenuView.a.a(r16, Integer.valueOf(ZeusTransformUtils.mapRes(R.drawable.oic_square_on_square, "drawable", "oic_square_on_square")), null, null, (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin"), null, null, false, null, new $$Lambda$h$T3S_DtFyJr5PtI6A0jStSSxgS4c(r0), 246, null);
    }

    private static final x c(d.h.a.a r1, View r2, int r3) {
        d.h.a.a r4 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r1, d.h.a.a.class, "com.obric.aiagent.plugin");
        o.e(r2, "v");
        r4.invoke();
        return x.f38692a;
    }

    public final void a(final OPopoverEntranceMenuView.a r14, final String r15, d.h.a.a<x> r16) {
        final d.h.a.a r2 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r16, d.h.a.a.class, "com.obric.aiagent.plugin");
        o.e(r14, "<this>");
        o.e(r15, "timerTaskId");
        o.e(r2, "onConfirm");
        String r4 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r14.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.task_popup_timer_task_details, WsChannelMultiProcessSharedProvider.STRING_TYPE, "task_popup_timer_task_details"));
        OPopoverEntranceMenuView.a.a(r14, Integer.valueOf(ZeusTransformUtils.mapRes(R.drawable.o_ic_list_find, "drawable", "o_ic_list_find")), null, null, (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin"), null, null, false, null, new $$Lambda$h$pdnENgWXiDQxA5TjscU2kF0wCBY(r2, r14, r15), 246, null);
    }

    private static final x a(d.h.a.a r1, OPopoverEntranceMenuView.a r2, String r3, View r4, int r5) {
        d.h.a.a r6 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r1, d.h.a.a.class, "com.obric.aiagent.plugin");
        o.e(r4, "v");
        r6.invoke();
        com.obric.autoaction.app.launcherpage.a r7 = com.obric.autoaction.app.launcherpage.a.f22698a;
        Context r8 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.a(r8, "null cannot be cast to non-null type android.app.Activity");
        Activity r9 = (Activity) ZeusTransformUtils.preCheckCast(r8, Activity.class, "com.obric.aiagent.plugin");
        String r10 = IMainTab.Companion.b();
        Bundle r11 = new Bundle();
        r11.putString("key_task_id", r3);
        x r12 = x.f38692a;
        r7.a(r9, r10, r11);
        return x.f38692a;
    }

    public static /* synthetic */ void a(h r1, Context r2, String r3, String r4, int r5, Object r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if ((r5 & 4) == 0) goto L5;
        r4 = r7.getString(ZeusTransformUtils.mapRes(R.string.launcher_page_copy_to_clipboard, WsChannelMultiProcessSharedProvider.STRING_TYPE, "launcher_page_copy_to_clipboard"));
    L5:
        r1.a(r7, r3, r4);
    }

    public final void a(Context r4, String r5, String r6) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        o.e(r5, "textToCopy");
        Object r7 = r3.getSystemService("clipboard");
        o.a(r7, "null cannot be cast to non-null type android.content.ClipboardManager");
        ((ClipboardManager) ZeusTransformUtils.preCheckCast(r7, ClipboardManager.class, "com.obric.aiagent.plugin")).setPrimaryClip(ClipData.newPlainText((CharSequence) ZeusTransformUtils.preCheckCast("label", CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin")));
        if (r6 == null) goto L6;
        Toast.makeText(r3, (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin"), 0).show();
        return;
    }

    public final void a(Activity r3, int[] r4, m<? super OPopoverEntranceMenuView.a, ? super d.h.a.a<x>, x> r5) {
        Activity r6 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin");
        m<? super OPopoverEntranceMenuView.a, ? super d.h.a.a<x>, x> r7 = (m) ZeusTransformUtils.wrapperContextForParams(r5, m.class, "com.obric.aiagent.plugin");
        o.e(r6, "activity");
        o.e(r4, "rawPos");
        o.e(r7, "buildPopup");
        a(r6, null, r4, r7);
    }

    /* JADX WARN: Type inference failed for: r1v12, types: [T, com.obric.oui.popover.v2.OPopover] */
    public final void a(Activity r16, Dialog r17, int[] r18, m<? super OPopoverEntranceMenuView.a, ? super d.h.a.a<x>, x> r19) {
        Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r16, Activity.class, "com.obric.aiagent.plugin");
        m r1 = (m) ZeusTransformUtils.wrapperContextForParams(r19, m.class, "com.obric.aiagent.plugin");
        o.e(r4, "activity");
        o.e(r18, "rawPos");
        o.e(r1, "buildPopup");
        final z.f r3 = new z.f();
        OPopover.a r5 = new OPopover.a((Context) ZeusTransformUtils.preCheckCast(r4, Context.class, "com.obric.aiagent.plugin"));
        OPopoverEntranceMenuView.a r6 = new OPopoverEntranceMenuView.a((Context) ZeusTransformUtils.preCheckCast(r4, Context.class, "com.obric.aiagent.plugin"));
        r1.invoke(r6, new $$Lambda$h$X4nZicFJreA3zVijVLS1tecDj74(r3));
        x r2 = x.f38692a;
        r3.f38504a = ((OPopover.a) ZeusTransformUtils.preCheckCast(r5.a((View) ZeusTransformUtils.preCheckCast(r6.d(), View.class, "com.obric.aiagent.plugin")), OPopover.a.class, "com.obric.aiagent.plugin")).G();
        if (r17 == null) goto L5;
        com.obric.oui.popover.v2.d.a(com.obric.oui.popover.v2.d.f36067a, r17, (OPopover) ZeusTransformUtils.preCheckCast(r3.f38504a, OPopover.class, "com.obric.aiagent.plugin"), r18[0], r18[1], false, 0, 48, null);
        return;
    L5:
        com.obric.oui.popover.v2.d.a(com.obric.oui.popover.v2.d.f36067a, r4, (OPopover) ZeusTransformUtils.preCheckCast(r3.f38504a, OPopover.class, "com.obric.aiagent.plugin"), r18[0], r18[1], false, 0, 48, null);
    }

    private static final x a(z.f r2) {
        OPopover r3 = (OPopover) ZeusTransformUtils.preCheckCast(r2.f38504a, OPopover.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L6;
        r3.dismiss();
    L6:
        return x.f38692a;
    }

    public static /* synthetic */ void a(h r7, Activity r8, View r9, int r10, d.h.a.b r11, m r12, int r13, Object r14) {
        Activity r2 = (Activity) ZeusTransformUtils.wrapperContextForParams(r8, Activity.class, "com.obric.aiagent.plugin");
        d.h.a.b<? super OPopoverEntranceMenuView, x> r15 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r11, d.h.a.b.class, "com.obric.aiagent.plugin");
        m<? super OPopoverEntranceMenuView.a, ? super d.h.a.a<x>, x> r6 = (m) ZeusTransformUtils.wrapperContextForParams(r12, m.class, "com.obric.aiagent.plugin");
        if ((r13 & 4) == 0) goto L5;
        r10 = 80;
    L5:
        int r4 = r10;
        if ((r13 & 8) == 0) goto L8;
        r15 = null;
    L8:
        r7.a(r2, r9, r4, r15, r6);
    }

    public final void a(Activity r10, View r11, int r12, d.h.a.b<? super OPopoverEntranceMenuView, x> r13, m<? super OPopoverEntranceMenuView.a, ? super d.h.a.a<x>, x> r14) {
        Activity r3 = (Activity) ZeusTransformUtils.wrapperContextForParams(r10, Activity.class, "com.obric.aiagent.plugin");
        d.h.a.b<? super OPopoverEntranceMenuView, x> r7 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r13, d.h.a.b.class, "com.obric.aiagent.plugin");
        m<? super OPopoverEntranceMenuView.a, ? super d.h.a.a<x>, x> r8 = (m) ZeusTransformUtils.wrapperContextForParams(r14, m.class, "com.obric.aiagent.plugin");
        o.e(r3, "activity");
        o.e(r11, "anchor");
        o.e(r8, "buildPopup");
        a(r3, null, r11, r12, r7, r8);
    }

    public static /* synthetic */ void a(h r9, Activity r10, Dialog r11, View r12, int r13, d.h.a.b r14, m r15, int r16, Object r17) {
        Activity r3 = (Activity) ZeusTransformUtils.wrapperContextForParams(r10, Activity.class, "com.obric.aiagent.plugin");
        d.h.a.b<? super OPopoverEntranceMenuView, x> r0 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r14, d.h.a.b.class, "com.obric.aiagent.plugin");
        m<? super OPopoverEntranceMenuView.a, ? super d.h.a.a<x>, x> r8 = (m) ZeusTransformUtils.wrapperContextForParams(r15, m.class, "com.obric.aiagent.plugin");
        if ((r16 & 8) == 0) goto L5;
        int r6 = 80;
    L7:
        if ((r16 & 16) == 0) goto L9;
        r0 = null;
    L9:
        r9.a(r3, r11, r12, r6, r0, r8);
        return;
    L5:
        r6 = r13;
        goto L7
    }

    /* JADX WARN: Type inference failed for: r1v11, types: [T, com.obric.oui.popover.v2.OPopover] */
    public final void a(Activity r18, Dialog r19, View r20, int r21, d.h.a.b<? super OPopoverEntranceMenuView, x> r22, m<? super OPopoverEntranceMenuView.a, ? super d.h.a.a<x>, x> r23) {
        Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r18, Activity.class, "com.obric.aiagent.plugin");
        d.h.a.b r5 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r22, d.h.a.b.class, "com.obric.aiagent.plugin");
        m r6 = (m) ZeusTransformUtils.wrapperContextForParams(r23, m.class, "com.obric.aiagent.plugin");
        o.e(r1, "activity");
        o.e(r20, "anchor");
        o.e(r6, "buildPopup");
        final z.f r7 = new z.f();
        OPopoverEntranceMenuView.a r8 = new OPopoverEntranceMenuView.a((Context) ZeusTransformUtils.preCheckCast(r1, Context.class, "com.obric.aiagent.plugin"));
        r6.invoke(r8, new $$Lambda$h$CDk4AtrcfpYCVSDBQSqdTm3Yod4(r7));
        OPopoverEntranceMenuView r9 = r8.d();
        if (r5 == null) goto L5;
        r5.invoke(r9);
    L5:
        r7.f38504a = ((OPopover.a) ZeusTransformUtils.preCheckCast(new OPopover.a((Context) ZeusTransformUtils.preCheckCast(r1, Context.class, "com.obric.aiagent.plugin")).a((View) ZeusTransformUtils.preCheckCast(r9, View.class, "com.obric.aiagent.plugin")), OPopover.a.class, "com.obric.aiagent.plugin")).G();
        if (r19 == null) goto L8;
        com.obric.oui.popover.v2.d.a(com.obric.oui.popover.v2.d.f36067a, r19, (OPopover) ZeusTransformUtils.preCheckCast(r7.f38504a, OPopover.class, "com.obric.aiagent.plugin"), a(r20, r21), b(r20, r21), false, 0, 48, null);
        return;
    L8:
        com.obric.oui.popover.v2.d.a(com.obric.oui.popover.v2.d.f36067a, (OPopover) ZeusTransformUtils.preCheckCast(r7.f38504a, OPopover.class, "com.obric.aiagent.plugin"), r20, r21, false, 0, false, 0, 0, 248, null);
    }

    private static final x b(z.f r2) {
        OPopover r3 = (OPopover) ZeusTransformUtils.preCheckCast(r2.f38504a, OPopover.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L6;
        r3.dismiss();
    L6:
        return x.f38692a;
    }

    private final int a(View r5, int r6) {
        int[] r0 = new int[2];
        r5.getLocationInWindow(r0);
        if ((r6 & 5) != 5) goto L6;
        return r0[0] + r5.getWidth();
    L6:
        if ((r6 & 1) != 1) goto L9;
        return r0[0] + (r5.getWidth() / 2);
    L9:
        return r0[0];
    }

    private final int b(View r5, int r6) {
        int[] r0 = new int[2];
        r5.getLocationInWindow(r0);
        if ((r6 & 80) != 80) goto L6;
        return r0[1] + r5.getHeight();
    L6:
        if ((r6 & 16) != 16) goto L9;
        return r0[1] + (r5.getHeight() / 2);
    L9:
        return r0[1];
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [T, com.obric.oui.selection.OActionSheet] */
    public final void a(Context r11, String r12, List<a> r13) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.aiagent.plugin");
        List r14 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.aiagent.plugin");
        o.e(r10, "context");
        o.e(r12, DBDefinition.TITLE);
        o.e(r14, "buttons");
        final z.f r15 = new z.f();
        final ?? r1 = new OActionSheet(r10, new OActionSheet.a.C0987a(OInsetSheet.b.f36196a, r12, null, new $$Lambda$h$s27V_BZKcgcrGi1btGvqPwSJ08c(r15), 4, null));
        LinearLayout r16 = new LinearLayout(r10);
        r16.setOrientation(1);
        r16.setDividerDrawable(androidx.appcompat.a.a.a.b(r10, ZeusTransformUtils.mapRes(R.drawable.auto_action_delete_confirm_dialog_divider, "drawable", "auto_action_delete_confirm_dialog_divider")));
        r16.setShowDividers(2);
        Iterator r17 = ((Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r17.hasNext() == false) goto L6;
        final a r3 = (a) ZeusTransformUtils.preCheckCast(r17.next(), a.class, "com.obric.aiagent.plugin");
        OActionSheetButton r4 = new OActionSheetButton(r10, null, 2, null);
        r4.setTextColor(r10.getColor(ZeusTransformUtils.mapRes(R.color.oui_functional_red_7, "color", "oui_functional_red_7")));
        r4.setText(r3.a());
        r4.setOnClickListener(new $$Lambda$h$BQhbzC4f4ZoTpzTjJoSxU1ftH8A(r3, r1));
        r16.addView((View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.aiagent.plugin"));
        goto L4
    L6:
        r1.setContainerView((View) ZeusTransformUtils.preCheckCast(r16, View.class, "com.obric.aiagent.plugin"));
        r1.show();
        r15.f38504a = r1;
    }

    private static final x c(z.f r2) {
        OActionSheet r3 = (OActionSheet) ZeusTransformUtils.preCheckCast(r2.f38504a, OActionSheet.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L6;
        r3.dismiss();
    L6:
        return x.f38692a;
    }

    private static final void a(a r1, OActionSheet r2, View r3) {
        d.h.a.a<x> r4 = r1.b();
        if (r4 == null) goto L5;
        x r5 = (x) ZeusTransformUtils.preCheckCast(r4.invoke(), x.class, "com.obric.aiagent.plugin");
    L5:
        r2.dismiss();
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [T, com.obric.oui.selection.OActionSheet] */
    public final void a(Context r14, d.h.a.b<? super Boolean, x> r15) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r14, Context.class, "com.obric.aiagent.plugin");
        final d.h.a.b r16 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r15, d.h.a.b.class, "com.obric.aiagent.plugin");
        o.e(r13, "context");
        final z.f r17 = new z.f();
        OInsetSheet.b r3 = OInsetSheet.b.f36196a;
        String r4 = r13.getString(ZeusTransformUtils.mapRes(R.string.popup_task_running_title, WsChannelMultiProcessSharedProvider.STRING_TYPE, "popup_task_running_title"));
        o.c(r4, "getString(...)");
        final ?? r1 = new OActionSheet(r13, new OActionSheet.a.C0987a(r3, r4, null, new $$Lambda$h$3SHmKp3nK9LoMMJ_1ukDZqDOr8I(r16, r17), 4, null));
        LinearLayout r2 = new LinearLayout(r13);
        r2.setOrientation(1);
        float r5 = 4;
        r2.setDividerPadding(d.i.a.a(TypedValue.applyDimension(1, r5, Resources.getSystem().getDisplayMetrics())));
        OActionSheetButton r6 = new OActionSheetButton(r13, null, 2, null);
        r6.setTextColor(r13.getColor(ZeusTransformUtils.mapRes(R.color.oui_accent_7_fg, "color", "oui_accent_7_fg")));
        String r8 = r13.getString(ZeusTransformUtils.mapRes(R.string.event_task_switch_confirm_title, WsChannelMultiProcessSharedProvider.STRING_TYPE, "event_task_switch_confirm_title"));
        o.c(r8, "getString(...)");
        r6.setText(r8);
        r6.setOnClickListener(new $$Lambda$h$eIHTy52sVwWAkM6IAmkw_WmvpkY(r16, r1));
        r2.addView((View) ZeusTransformUtils.preCheckCast(r6, View.class, "com.obric.aiagent.plugin"));
        OActionSheetButton r7 = new OActionSheetButton(r13, null, 2, null);
        r7.setTextColor(r13.getColor(ZeusTransformUtils.mapRes(R.color.oui_functional_red_7, "color", "oui_functional_red_7")));
        String r18 = r13.getString(ZeusTransformUtils.mapRes(R.string.event_task_confirm_close, WsChannelMultiProcessSharedProvider.STRING_TYPE, "event_task_confirm_close"));
        o.c(r18, "getString(...)");
        r7.setText(r18);
        r7.setOnClickListener(new $$Lambda$h$eDMRGsfhc8uSsngRc_yFQF3i80(r16, r1));
        LinearLayout.LayoutParams r19 = new LinearLayout.LayoutParams(-1, -2);
        r19.topMargin = d.i.a.a(TypedValue.applyDimension(1, r5, Resources.getSystem().getDisplayMetrics()));
        r7.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r19, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        r2.addView((View) ZeusTransformUtils.preCheckCast(r7, View.class, "com.obric.aiagent.plugin"));
        r1.setContainerView((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.aiagent.plugin"));
        r1.show();
        r17.f38504a = r1;
    }

    private static final x a(d.h.a.b r2, z.f r3) {
        d.h.a.b r4 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.b.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L5;
        r4.invoke(false);
    L5:
        OActionSheet r5 = (OActionSheet) ZeusTransformUtils.preCheckCast(r3.f38504a, OActionSheet.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L9;
        r5.dismiss();
    L9:
        return x.f38692a;
    }

    private static final void a(d.h.a.b r1, OActionSheet r2, View r3) {
        d.h.a.b r4 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r1, d.h.a.b.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L5;
        r4.invoke(false);
    L5:
        r2.dismiss();
    }

    private static final void b(d.h.a.b r1, OActionSheet r2, View r3) {
        d.h.a.b r4 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r1, d.h.a.b.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L5;
        r4.invoke(true);
    L5:
        r2.dismiss();
    }
}
