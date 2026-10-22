package com.obric.autoaction.presentation;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.hardware.display.DisplayManager;
import android.text.Editable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.presentation.view.PrefixLabelEditText;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.presentation.AOUserInterfaceTools;
import com.obric.autogui.common.api.presentation.IAutoActionPresentationApi;
import com.obric.oui.button.OButton;
import com.obric.oui.sheet.OInsetSheet;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.m;
import d.x;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: GlobalInputDialog.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f24844a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Dialog f24845b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Map<String, m<String, String>> f24846c = null;

    /* JADX INFO: compiled from: GlobalInputDialog.kt */
    public static final class a extends PluginBroadcastReceiver {
        a() {
        }

        public void onReceive(Context r2, Intent r3) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            if (r3 == null) goto L5;
            String r4 = r3.getAction();
        L7:
            if (o.a(r4, "android.intent.action.CLOSE_SYSTEM_DIALOGS") == false) goto L12;
            Loog.INSTANCE.d("GlobalInputDialog", "Received ACTION_CLOSE_SYSTEM_DIALOGS, reason: " + r3.getStringExtra("reason"));
            Dialog r5 = d.f24844a.a();
            if (r5 == null) goto L13;
            r5.dismiss();
            return;
        L13:
            return;
        L12:
            return;
        L5:
            r4 = null;
            goto L7
        }
    }

    public static /* synthetic */ void lambda$BwIXTRnx__rF59umqScKKGRTwSQ(com.obric.autoaction.b.f r0) {
        a(r0);
    }

    /* JADX INFO: renamed from: lambda$_o2vm4zQYEG-SvNmLnuA0mRjzKk, reason: not valid java name */
    public static /* synthetic */ void m612lambda$_o2vm4zQYEGSvNmLnuA0mRjzKk(com.obric.autoaction.b.f r0, d.h.a.m r1, IAutoActionPresentationApi.MemoryKey r2, boolean r3, DialogInterface r4) {
        a(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ x lambda$f5Dv_pJu98EhTHEjBCdmBFRh1J0(Dialog r0, com.obric.autoaction.b.f r1, Editable r2) {
        return a(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$gMgibC1IK_Z-rHQKem1w4iR6uYA, reason: not valid java name */
    public static /* synthetic */ void m613lambda$gMgibC1IK_ZrHQKem1w4iR6uYA(Dialog r0, View r1) {
        a(r0, r1);
    }

    public static /* synthetic */ void lambda$noHdyePujZNJZ7kvnFd1Y4qqEnE(TextView r0) {
        b(r0);
    }

    public static /* synthetic */ void lambda$ojDgoVSrxTNiRzB8_pOWqOoTpyY(d.h.a.m r0, com.obric.autoaction.b.f r1, Dialog r2, View r3) {
        a(r0, r1, r2, r3);
    }

    private d() {
    }

    public final Dialog a() {
        return f24845b;
    }

    static {
        d r0 = new d();
        f24844a = r0;
        f24846c = (Map) ZeusTransformUtils.preCheckCast(new HashMap(), Map.class, "com.obric.aiagent.plugin");
        r0.b();
    }

    public static /* synthetic */ Dialog a(d r15, Context r16, Integer r17, String r18, String r19, d.h.a.m r20, d.h.a.m r21, String r22, String r23, String r24, String r25, IAutoActionPresentationApi.MemoryKey r26, int r27, Object r28) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r16, Context.class, "com.obric.aiagent.plugin");
        d.h.a.m<? super String, ? super String, x> r8 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r20, d.h.a.m.class, "com.obric.aiagent.plugin");
        d.h.a.m<? super String, ? super String, x> r9 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r21, d.h.a.m.class, "com.obric.aiagent.plugin");
        if ((r27 & 64) == 0) goto L5;
        String r10 = null;
    L7:
        if ((r27 & 128) == 0) goto L9;
        String r11 = null;
    L11:
        if ((r27 & 256) == 0) goto L13;
        String r12 = null;
    L15:
        if ((r27 & 512) == 0) goto L17;
        String r13 = null;
    L19:
        if ((r27 & 1024) == 0) goto L21;
        IAutoActionPresentationApi.MemoryKey r14 = null;
    L23:
        return r15.a(r4, r17, r18, r19, r8, r9, r10, r11, r12, r13, r14);
    L21:
        r14 = r26;
        goto L23
    L17:
        r13 = r25;
        goto L19
    L13:
        r12 = r24;
        goto L15
    L9:
        r11 = r23;
        goto L11
    L5:
        r10 = r22;
        goto L7
    }

    public final Dialog a(Context r21, Integer r22, String r23, String r24, d.h.a.m<? super String, ? super String, x> r25, d.h.a.m<? super String, ? super String, x> r26, String r27, String r28, String r29, String r30, final IAutoActionPresentationApi.MemoryKey r31) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r21, Context.class, "com.obric.aiagent.plugin");
        final d.h.a.m r8 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r25, d.h.a.m.class, "com.obric.aiagent.plugin");
        final d.h.a.m r9 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r26, d.h.a.m.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        o.e(r23, DBDefinition.TITLE);
        o.e(r24, "content");
        o.e(r8, "onConfirm");
        o.e(r9, "onDismiss");
        final boolean r11 = !com.obric.autogui.util.ui.c.a(r6);
        int r13 = ZeusTransformUtils.getResources(r6, "com.obric.aiagent.plugin").getDisplayMetrics().widthPixels;
        final com.obric.autoaction.b.f r14 = com.obric.autoaction.b.f.a(LayoutInflater.from(r6));
        o.c(r14, "inflate(...)");
        r14.b().post(new $$Lambda$d$BwIXTRnx__rF59umqScKKGRTwSQ(r14));
        Object r12 = r6.getSystemService("display");
        o.a(r12, "null cannot be cast to non-null type android.hardware.display.DisplayManager");
        DisplayManager r15 = (DisplayManager) ZeusTransformUtils.preCheckCast(r12, DisplayManager.class, "com.obric.aiagent.plugin");
        DisplayMetrics r16 = new DisplayMetrics();
        r15.getDisplay(0).getRealMetrics(r16);
        if (r16.widthPixels <= r16.heightPixels) goto L5;
        boolean r10 = true;
    L7:
        if (r10 == false) goto L9;
        AOUserInterfaceTools.TitlelessDialog r17 = new AOUserInterfaceTools.TitlelessDialog(r6, 0, 2, null);
        r17.setContentView((View) ZeusTransformUtils.preCheckCast(r14.b(), View.class, "com.obric.aiagent.plugin"));
        final Dialog r3 = (Dialog) ZeusTransformUtils.preCheckCast(r17, Dialog.class, "com.obric.aiagent.plugin");
    L10:
        if (r11 == false) goto L15;
        Dialog r5 = f24845b;
        if (r5 == null) goto L14;
        r5.dismiss();
    L14:
        f24845b = r3;
    L15:
        if (r10 == false) goto L18;
        float r18 = 32;
        r14.f24608a.setRadius(d.i.a.a(TypedValue.applyDimension(1, r18, Resources.getSystem().getDisplayMetrics())), d.i.a.a(TypedValue.applyDimension(1, r18, Resources.getSystem().getDisplayMetrics())), d.i.a.a(TypedValue.applyDimension(1, r18, Resources.getSystem().getDisplayMetrics())), d.i.a.a(TypedValue.applyDimension(1, r18, Resources.getSystem().getDisplayMetrics())));
        r14.f24612e.setVisibility(8);
        FrameLayout r2 = r14.b();
        o.c(r2, "getRoot(...)");
        View r4 = (View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.aiagent.plugin");
        int r7 = d.i.a.a(TypedValue.applyDimension(1, 12, Resources.getSystem().getDisplayMetrics()));
        r4.setPadding(r7, r7, r7, r7);
        r14.f24608a.setBackgroundResource(ZeusTransformUtils.mapRes(R.drawable.card_bg_with_border_normal, "drawable", "card_bg_with_border_normal"));
        FrameLayout r19 = r14.b();
        o.c(r19, "getRoot(...)");
        View r20 = (View) ZeusTransformUtils.preCheckCast(r19, View.class, "com.obric.aiagent.plugin");
        ViewGroup.LayoutParams r32 = r20.getLayoutParams();
        Objects.requireNonNull(r32, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        r32.width = r16.heightPixels;
        r32.height = -2;
        r20.setLayoutParams(r32);
    L18:
        r3.setCanceledOnTouchOutside(true);
        if (r11 == false) goto L23;
        Window r33 = r3.getWindow();
        if (r33 == null) goto L23;
        r33.setType(2038);
    L23:
        Window r34 = r3.getWindow();
        if (r34 == null) goto L26;
        r34.setGravity(80);
        r34.setLayout(r13, -2);
        String r35 = null;
        r34.getDecorView().setBackground(null);
        r34.setBackgroundDrawable((Drawable) ZeusTransformUtils.preCheckCast(new ColorDrawable(0), Drawable.class, "com.obric.aiagent.plugin"));
    L27:
        r3.show();
        r14.h.setText((CharSequence) ZeusTransformUtils.preCheckCast(r23, CharSequence.class, "com.obric.aiagent.plugin"));
        r14.f24610c.setText((CharSequence) ZeusTransformUtils.preCheckCast(r24, CharSequence.class, "com.obric.aiagent.plugin"));
        if (r22 != null) goto L30;
        r14.f24612e.setVisibility(8);
    L32:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r24, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L34;
        boolean r0 = true;
    L35:
        if (r0 == false) goto L37;
        r14.f24610c.setVisibility(8);
        boolean r1 = false;
    L38:
        CharSequence r36 = (CharSequence) ZeusTransformUtils.preCheckCast(r30, CharSequence.class, "com.obric.aiagent.plugin");
        if (r36 != null) goto L41;
    L44:
        boolean r37 = true;
    L45:
        if (r37 == true) goto L47;
        r14.f.setHint(r30);
    L49:
        if (r27 != null) goto L51;
    L53:
        Map<String, m<String, String>> r38 = f24846c;
        if (r31 == null) goto L56;
        String r39 = r31.getCategory();
    L57:
        Object r40 = r38.get(r39);
        m r41 = (m) ZeusTransformUtils.preCheckCast(r40, m.class, "com.obric.aiagent.plugin");
        if (r41 == null) goto L60;
        String r42 = (String) ZeusTransformUtils.preCheckCast(r41.a(), String.class, "com.obric.aiagent.plugin");
    L61:
        if (r31 == null) goto L63;
        String r43 = r31.getKey();
    L65:
        if (o.a(r42, r43) == true) goto L68;
        r40 = r35;
    L68:
        m r44 = (m) ZeusTransformUtils.preCheckCast(r40, m.class, "com.obric.aiagent.plugin");
        if (r44 == null) goto L71;
        String r110 = (String) ZeusTransformUtils.preCheckCast(r44.b(), String.class, "com.obric.aiagent.plugin");
    L72:
        if (r29 == null) goto L75;
        r110 = r29;
    L75:
        if (r110 != null) goto L77;
    L80:
        PrefixLabelEditText r45 = r14.f;
        OButton r46 = r14.g;
        o.c(r46, "sendButton");
        r45.attach((View) ZeusTransformUtils.preCheckCast(r46, View.class, "com.obric.aiagent.plugin"));
        r14.f.showSoftKeyboard();
        r14.g.setOnClickListener(new $$Lambda$d$ojDgoVSrxTNiRzB8_pOWqOoTpyY(r8, r14, r3));
        r14.f24609b.setOnClickListener(new $$Lambda$d$gMgibC1IK_ZrHQKem1w4iR6uYA(r3));
        r14.f.addTextChangedListener(new $$Lambda$d$f5Dv_pJu98EhTHEjBCdmBFRh1J0(r3, r14));
        r3.setOnDismissListener(new $$Lambda$d$_o2vm4zQYEGSvNmLnuA0mRjzKk(r14, r9, r31, r11));
        return r3;
    L77:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r110, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L79;
        r1 = true;
    L79:
        r3.setCanceledOnTouchOutside(r1);
        r14.f.setText(r110);
        goto L80
    L71:
        r110 = r35;
        goto L72
    L63:
        r43 = r35;
        goto L65
    L60:
        r42 = r35;
        goto L61
    L56:
        r39 = r35;
        goto L57
    L51:
        if (r28 == null) goto L53;
        r14.f.setPrefix(r27, r28);
        goto L53
    L47:
        r14.f.setHint(r6.getString(ZeusTransformUtils.mapRes(R.string.obric_global_input_hint_example, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_global_input_hint_example")));
        goto L49
    L41:
        if (r36.length() == 0) goto L44;
        r37 = r1;
        goto L45
    L37:
        r1 = false;
        r14.f24610c.setVisibility(0);
        TextView r47 = r14.f24610c;
        o.c(r47, "content");
        a(r47);
        goto L38
    L34:
        r0 = false;
        goto L35
    L30:
        r14.f24612e.setVisibility(0);
        r14.f24612e.setImageResource(r22.intValue());
        goto L32
    L26:
        r35 = null;
        goto L27
    L9:
        OInsetSheet r48 = new OInsetSheet(r6);
        r48.setContainerView((View) ZeusTransformUtils.preCheckCast(r14.b(), View.class, "com.obric.aiagent.plugin"));
        r48.setRootWidth(OInsetSheet.b.f36197b);
        r3 = (Dialog) ZeusTransformUtils.preCheckCast(r48, Dialog.class, "com.obric.aiagent.plugin");
        goto L10
    L5:
        r10 = false;
        goto L7
    }

    private static final void a(com.obric.autoaction.b.f r3) {
        com.obric.autoaction.app.launcherpage.module.view.e r0 = com.obric.autoaction.app.launcherpage.module.view.e.f24295a;
        TextView r1 = r3.f24610c;
        o.c(r1, "content");
        r0.a(r1);
        com.obric.autoaction.app.launcherpage.module.view.e r2 = com.obric.autoaction.app.launcherpage.module.view.e.f24295a;
        OButton r4 = r3.g;
        o.c(r4, "sendButton");
        r2.a((TextView) ZeusTransformUtils.preCheckCast(r4, TextView.class, "com.obric.aiagent.plugin"));
    }

    private static final void a(d.h.a.m r1, com.obric.autoaction.b.f r2, Dialog r3, View r4) {
        ((d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r1, d.h.a.m.class, "com.obric.aiagent.plugin")).invoke(r2.f.getText(), r2.f.getFullText());
        r3.dismiss();
    }

    private static final void a(Dialog r0, View r1) {
        r0.dismiss();
    }

    private static final x a(Dialog r2, com.obric.autoaction.b.f r3, Editable r4) {
        r2.setCanceledOnTouchOutside(!r3.f.hasUserInput((CharSequence) ZeusTransformUtils.preCheckCast((Editable) ZeusTransformUtils.wrapperContextForParams(r4, Editable.class, "com.obric.aiagent.plugin"), CharSequence.class, "com.obric.aiagent.plugin")));
        return x.f38692a;
    }

    private static final void a(com.obric.autoaction.b.f r3, d.h.a.m r4, IAutoActionPresentationApi.MemoryKey r5, boolean r6, DialogInterface r7) {
        d.h.a.m r8 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.m.class, "com.obric.aiagent.plugin");
        DialogInterface r9 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r7, DialogInterface.class, "com.obric.aiagent.plugin");
        String r10 = r3.f.getText();
        r8.invoke(r10, r3.f.getFullText());
        if (r5 == null) goto L15;
        boolean r11 = true;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r5.getKey(), CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L7;
        boolean r12 = true;
    L8:
        if (r12 == false) goto L15;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r5.getCategory(), CharSequence.class, "com.obric.aiagent.plugin")).length() > 0) goto L13;
        r11 = false;
    L13:
        if (r11 == false) goto L15;
        f24846c.put(r5.getCategory(), new m(r5.getKey(), r10));
        goto L15
    L7:
        r12 = false;
    L15:
        if (r6 == false) goto L18;
        f24845b = null;
        return;
    }

    public final void a(final TextView r1) {
        o.e(r1, "<this>");
        r1.post(new $$Lambda$d$noHdyePujZNJZ7kvnFd1Y4qqEnE(r1));
    }

    private static final void b(TextView r2) {
        if (r2.getLineCount() != 1) goto L5;
        int r0 = 17;
    L6:
        r2.setGravity(r0);
        return;
    L5:
        r0 = 8388611;
        goto L6
    }

    private final void b() {
        a r4 = new a();
        IntentFilter r0 = new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS");
        ZeusTransformUtils.registerReceiver((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(r4, PluginBroadcastReceiver.class, "com.obric.aiagent.plugin"), r0, 4, "com.obric.aiagent.plugin");
    }
}
