package com.obric.autoaction.presentation;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.common.api.presentation.AOUserInterfaceTools;
import com.obric.oui.button.OIconButton;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import d.x;

/* JADX INFO: compiled from: SurfaceCardActivityDialog.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h {
    public static /* synthetic */ void lambda$9u0e1AQqgfFiupZlgWkCCes0T48(com.obric.autoaction.b.e r0, boolean r1, SurfaceCardActivity r2, AOUserInterfaceTools.TitlelessDialog r3, View r4) {
        a(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ void lambda$D4XIdyKtxTulEXC2wMPkZhW8g_8(com.obric.autoaction.b.e r0, d.h.a.b r1, AOUserInterfaceTools.TitlelessDialog r2, View r3) {
        a(r0, r1, r2, r3);
    }

    public static /* synthetic */ void lambda$Wh_8tJEi474tsqTTjSbQUmv2lz8(boolean r0, SurfaceCardActivity r1, com.obric.autoaction.b.e r2, DialogInterface r3) {
        a(r0, r1, r2, r3);
    }

    public static /* synthetic */ void lambda$cnqc20W3Mi_0NHG3_qvCszH7xmI(SurfaceCardActivity r0, DialogInterface r1) {
        a(r0, r1);
    }

    public static final void a(SurfaceCardActivity r10, final boolean r11) {
        final SurfaceCardActivity r12 = (SurfaceCardActivity) ZeusTransformUtils.wrapperContextForParams(r10, SurfaceCardActivity.class, "com.obric.aiagent.plugin");
        o.e(r12, "<this>");
        int r0 = ZeusTransformUtils.getResources(r12, "com.obric.aiagent.plugin").getDisplayMetrics().widthPixels;
        final com.obric.autoaction.b.e r2 = com.obric.autoaction.b.e.a(r12.getLayoutInflater());
        o.c(r2, "inflate(...)");
        r2.f24604b.f24595b.setText((CharSequence) ZeusTransformUtils.preCheckCast(r12.getUserAdditionContent(), CharSequence.class, "com.obric.aiagent.plugin"));
        r2.f24603a.setImageDrawable(androidx.core.content.b.h.a(ZeusTransformUtils.getResources(r12, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.drawable.auto_icon_adding, "drawable", "auto_icon_adding"), null));
        r2.f24605c.setText((CharSequence) ZeusTransformUtils.preCheckCast(r12.getString(ZeusTransformUtils.mapRes(R.string.auto_card_dialog_title, WsChannelMultiProcessSharedProvider.STRING_TYPE, "auto_card_dialog_title")), CharSequence.class, "com.obric.aiagent.plugin"));
        Typeface r3 = Typeface.create(r2.f24605c.getTypeface(), 600, false);
        o.c(r3, "create(...)");
        r2.f24605c.setTypeface(r3);
        final AOUserInterfaceTools.TitlelessDialog r4 = new AOUserInterfaceTools.TitlelessDialog((Context) ZeusTransformUtils.preCheckCast(r12, Context.class, "com.obric.aiagent.plugin"), 0, 2, null);
        r4.setContentView((View) ZeusTransformUtils.preCheckCast(r2.b(), View.class, "com.obric.aiagent.plugin"));
        Window r5 = r4.getWindow();
        if (r5 == null) goto L5;
        r5.setGravity(80);
        r5.setLayout(r0 - d.i.a.a(TypedValue.applyDimension(1, 16, Resources.getSystem().getDisplayMetrics())), -2);
        r5.getDecorView().setBackground(null);
        r5.setBackgroundDrawable((Drawable) ZeusTransformUtils.preCheckCast(new ColorDrawable(0), Drawable.class, "com.obric.aiagent.plugin"));
    L5:
        r2.f24604b.f24596c.setOnClickListener(new $$Lambda$h$9u0e1AQqgfFiupZlgWkCCes0T48(r2, r11, r12, r4));
        OIconButton r1 = r2.f24604b.f24596c;
        o.c(r1, "sendButton");
        k.a((View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.aiagent.plugin"), r2.f24604b.f24595b);
        r4.show();
        r4.setOnDismissListener(new $$Lambda$h$Wh_8tJEi474tsqTTjSbQUmv2lz8(r11, r12, r2));
        r4.show();
        EditText r13 = r2.f24604b.f24595b;
        o.c(r13, "inputText");
        k.a(r13);
    }

    private static final void a(com.obric.autoaction.b.e r2, boolean r3, SurfaceCardActivity r4, AOUserInterfaceTools.TitlelessDialog r5, View r6) {
        SurfaceCardActivity r7 = (SurfaceCardActivity) ZeusTransformUtils.wrapperContextForParams(r4, SurfaceCardActivity.class, "com.obric.aiagent.plugin");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r2.f24604b.f24595b.getText().toString(), CharSequence.class, "com.obric.aiagent.plugin")).toString(), CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L5;
        boolean r8 = true;
    L6:
        if (r8 == false) goto L12;
        if (r3 == false) goto L9;
        r7.getReadyToSubmitAdditionContent().add(r2.f24604b.f24595b.getText().toString());
        r2.f24604b.f24595b.setText((CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin"));
    L10:
        r5.dismiss();
        return;
    L9:
        r7.getViewModel().a(r2.f24604b.f24595b.getText().toString(), true, 3, null);
        r7.updateCardContentToIdle();
        goto L10
    L12:
        return;
    L5:
        r8 = false;
        goto L6
    }

    private static final void a(boolean r11, SurfaceCardActivity r12, com.obric.autoaction.b.e r13, DialogInterface r14) {
        SurfaceCardActivity r15 = (SurfaceCardActivity) ZeusTransformUtils.wrapperContextForParams(r12, SurfaceCardActivity.class, "com.obric.aiagent.plugin");
        DialogInterface r16 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r14, DialogInterface.class, "com.obric.aiagent.plugin");
        if (r11 == false) goto L5;
        r15.getViewModel().a(p.a((Iterable) ZeusTransformUtils.preCheckCast(r15.getReadyToSubmitAdditionContent(), Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(";", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, null, 62, null));
    L5:
        r15.setUserAdditionContent(r13.f24604b.f24595b.getText().toString());
    }

    public static final Dialog a(SurfaceCardActivity r10, d.h.a.b<? super String, x> r11) {
        final SurfaceCardActivity r12 = (SurfaceCardActivity) ZeusTransformUtils.wrapperContextForParams(r10, SurfaceCardActivity.class, "com.obric.aiagent.plugin");
        final d.h.a.b r13 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r11, d.h.a.b.class, "com.obric.aiagent.plugin");
        o.e(r12, "<this>");
        o.e(r13, "onConfirm");
        int r0 = ZeusTransformUtils.getResources(r12, "com.obric.aiagent.plugin").getDisplayMetrics().widthPixels;
        final com.obric.autoaction.b.e r2 = com.obric.autoaction.b.e.a(r12.getLayoutInflater());
        o.c(r2, "inflate(...)");
        r2.f24604b.f24595b.setText((CharSequence) ZeusTransformUtils.preCheckCast(r12.getUserAdditionContent(), CharSequence.class, "com.obric.aiagent.plugin"));
        r2.f24603a.setImageDrawable(androidx.core.content.b.h.a(ZeusTransformUtils.getResources(r12, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.drawable.auto_icon_adding, "drawable", "auto_icon_adding"), null));
        r2.f24605c.setText((CharSequence) ZeusTransformUtils.preCheckCast(r12.getString(ZeusTransformUtils.mapRes(R.string.obric_dialog_other_ideas, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_dialog_other_ideas")), CharSequence.class, "com.obric.aiagent.plugin"));
        Typeface r3 = Typeface.create(r2.f24605c.getTypeface(), 600, false);
        o.c(r3, "create(...)");
        r2.f24605c.setTypeface(r3);
        final AOUserInterfaceTools.TitlelessDialog r4 = new AOUserInterfaceTools.TitlelessDialog((Context) ZeusTransformUtils.preCheckCast(r12, Context.class, "com.obric.aiagent.plugin"), 0, 2, null);
        r4.setContentView((View) ZeusTransformUtils.preCheckCast(r2.b(), View.class, "com.obric.aiagent.plugin"));
        Window r5 = r4.getWindow();
        if (r5 == null) goto L5;
        r5.setGravity(80);
        r5.setLayout(r0 - d.i.a.a(TypedValue.applyDimension(1, 16, Resources.getSystem().getDisplayMetrics())), -2);
        r5.getDecorView().setBackground(null);
        r5.setBackgroundDrawable((Drawable) ZeusTransformUtils.preCheckCast(new ColorDrawable(0), Drawable.class, "com.obric.aiagent.plugin"));
    L5:
        r2.f24604b.f24595b.setText((CharSequence) ZeusTransformUtils.preCheckCast(r12.getDraftUserClarifyInfo(), CharSequence.class, "com.obric.aiagent.plugin"));
        EditText r1 = r2.f24604b.f24595b;
        o.c(r1, "inputText");
        TextView r6 = (TextView) ZeusTransformUtils.preCheckCast(r1, TextView.class, "com.obric.aiagent.plugin");
        TextWatcher r7 = new SurfaceCardActivityDialogKt$showInputDialogForClarifyAdding$$inlined$doAfterTextChanged$1(r12);
        r6.addTextChangedListener((TextWatcher) ZeusTransformUtils.preCheckCast(r7, TextWatcher.class, "com.obric.aiagent.plugin"));
        TextWatcher r8 = (TextWatcher) ZeusTransformUtils.preCheckCast(r7, TextWatcher.class, "com.obric.aiagent.plugin");
        r2.f24604b.f24596c.setOnClickListener(new $$Lambda$h$D4XIdyKtxTulEXC2wMPkZhW8g_8(r2, r13, r4));
        r4.setOnDismissListener(new $$Lambda$h$cnqc20W3Mi_0NHG3_qvCszH7xmI(r12));
        OIconButton r14 = r2.f24604b.f24596c;
        o.c(r14, "sendButton");
        k.a((View) ZeusTransformUtils.preCheckCast(r14, View.class, "com.obric.aiagent.plugin"), r2.f24604b.f24595b);
        EditText r15 = r2.f24604b.f24595b;
        o.c(r15, "inputText");
        k.a(r15);
        r4.show();
        return (Dialog) ZeusTransformUtils.preCheckCast(r4, Dialog.class, "com.obric.aiagent.plugin");
    }

    private static final void a(com.obric.autoaction.b.e r1, d.h.a.b r2, AOUserInterfaceTools.TitlelessDialog r3, View r4) {
        d.h.a.b r5 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.b.class, "com.obric.aiagent.plugin");
        String r6 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r1.f24604b.f24595b.getText().toString(), CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L5;
        boolean r7 = true;
    L6:
        if (r7 == false) goto L9;
        r5.invoke(r6);
        r3.dismiss();
        return;
    L9:
        return;
    L5:
        r7 = false;
        goto L6
    }

    private static final void a(SurfaceCardActivity r2, DialogInterface r3) {
        SurfaceCardActivity r4 = (SurfaceCardActivity) ZeusTransformUtils.wrapperContextForParams(r2, SurfaceCardActivity.class, "com.obric.aiagent.plugin");
        DialogInterface r5 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.class, "com.obric.aiagent.plugin");
        r4.setClarifyAddingDialog(null);
    }
}
