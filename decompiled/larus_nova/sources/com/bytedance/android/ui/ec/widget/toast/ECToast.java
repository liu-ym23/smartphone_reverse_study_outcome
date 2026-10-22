package com.bytedance.android.ui.ec.widget.toast;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.bytedance.android.ui.base.widget.icon.IconExtKt;
import com.bytedance.android.ui.base.widget.round.BackgroundDrawable;
import com.bytedance.android.ui.ec.widget.loading.ECLoadingDialog;
import com.bytedance.android.ui.ec.widget.tools.UnitExtensionKt;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J5\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0002\u0010\rJ)\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\u0010J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u0006J)\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\u0010J)\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00172\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0002\u0010\u0018J]\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0019\u001a\u00020\u001a2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0001\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0001\u0010\u001c\u001a\u00020\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0002\u0010\u001eJ3\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ+\u0010\u001f\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010 J3\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0001\u0010\u001c\u001a\u00020\u001a2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010!J)\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u001b\u001a\u00020\u001a2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\"¨\u0006#"}, d2 = {"Lcom/bytedance/android/ui/ec/widget/toast/ECToast;", "", "()V", "showCustomToast", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "text", "", "iconDrawable", "Landroid/graphics/drawable/Drawable;", "isShortDuration", "", "(Landroid/content/Context;Ljava/lang/CharSequence;Landroid/graphics/drawable/Drawable;Ljava/lang/Boolean;)V", "showFailToast", "", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Boolean;)V", "showLoadingToast", "Landroid/app/Dialog;", "showSuccessToast", "showSystemToast", "Landroid/widget/Toast;", "contentView", "Landroid/view/View;", "(Landroid/content/Context;Landroid/view/View;Ljava/lang/Boolean;)Landroid/widget/Toast;", "iconId", "", "textRes", "textIcon", "textIconDrawable", "(Landroid/content/Context;ILandroid/graphics/drawable/Drawable;ILjava/lang/CharSequence;ILandroid/graphics/drawable/Drawable;Ljava/lang/Boolean;)Landroid/widget/Toast;", "showToast", "(Landroid/content/Context;Ljava/lang/CharSequence;Ljava/lang/Boolean;)Landroid/widget/Toast;", "(Landroid/content/Context;Ljava/lang/CharSequence;ILjava/lang/Boolean;)V", "(Landroid/content/Context;ILjava/lang/Boolean;)V", "ui-ec-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECToast {
    public static final ECToast INSTANCE = null;

    private ECToast() {
    }

    static {
        INSTANCE = new ECToast();
    }

    public static void INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_toast_ECToast_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(ECLoadingDialog r100) {
        if (DialogLancet.shouldBlockDialogShow(r100) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r100);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L7:
        DialogLancet.beforeDialogShow(r100);
        r100.show();
        DialogLancet.afterDialogShow(r100);
    }

    public final Dialog showLoadingToast(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        ECLoadingDialog r101 = new ECLoadingDialog(r100, R.style.ec_popuptoast_dialog);
        r101.setShowCloseBtn(true);
        r101.setDialogCancelable(false);
        INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_toast_ECToast_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(r101);
        return new ECLoadingDialog(r100, R.style.ec_popuptoast_dialog);
    }

    private final Toast showSystemToast(Context r100, View r101, Boolean r102) {
        Toast r103 = new Toast(r100.getApplicationContext());
        if (Intrinsics.areEqual(r102, Boolean.TRUE) == false) goto L5;
        r103.setDuration(0);
    L6:
        r103.setGravity(17, 0, 0);
        r103.setView(r101);
        r103.show();
        return r103;
    L5:
        r103.setDuration(1);
        goto L6
    }

    public final void showFailToast(Context r100, String r101, Boolean r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Drawable r103 = ContextCompat.getDrawable(r100, R.drawable.ec_dux_ic_s_s_warningcircle_outlined);
        if (r103 == null) goto L6;
        Drawable r104 = DrawableCompat.wrap(r103);
        DrawableCompat.setTint(r104, ContextCompat.getColor(r100, R.color.white_75));
        INSTANCE.showCustomToast(r100, r101, r104, r102);
        return;
    }

    public final void showSuccessToast(Context r100, String r101, Boolean r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Drawable r103 = ContextCompat.getDrawable(r100, R.drawable.ec_dux_ic_s_s_checkmark_outlined);
        if (r103 == null) goto L6;
        Drawable r104 = IconExtKt.coloredDrawable(r103, ContextCompat.getColor(r100, R.color.white_75));
        INSTANCE.showCustomToast(r100, r101, r104, r102);
        return;
    }

    public final Toast showToast(Context r110, CharSequence r111, Boolean r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        return showSystemToast(r110, 0, null, 0, r111, 0, null, r112);
    }

    public final void showToast(Context r110, int r111, Boolean r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        showSystemToast(r110, 0, null, r111, null, 0, null, r112);
    }

    private final void showCustomToast(Context r110, CharSequence r111, Drawable r112, Boolean r113) {
        showSystemToast(r110, 0, r112, 0, r111, 0, null, r113);
    }

    public final void showToast(Context r110, CharSequence r111, int r112, Boolean r113) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        showSystemToast(r110, 0, null, 0, r111, r112, null, r113);
    }

    public final void showToast(Context r110, CharSequence r111, Drawable r112, Boolean r113) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        showSystemToast(r110, 0, null, 0, r111, 0, r112, r113);
    }

    public static /* synthetic */ void showFailToast$default(ECToast r100, Context r101, String r102, Boolean r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L5;
        r103 = null;
    L5:
        r100.showFailToast(r101, r102, r103);
    }

    public static /* synthetic */ void showSuccessToast$default(ECToast r100, Context r101, String r102, Boolean r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L5;
        r103 = null;
    L5:
        r100.showSuccessToast(r101, r102, r103);
    }

    public static /* synthetic */ Toast showSystemToast$default(ECToast r100, Context r101, View r102, Boolean r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L6;
        r103 = Boolean.FALSE;
    L6:
        return r100.showSystemToast(r101, r102, r103);
    }

    public static /* synthetic */ Toast showToast$default(ECToast r100, Context r101, CharSequence r102, Boolean r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L6;
        r103 = null;
    L6:
        return r100.showToast(r101, r102, r103);
    }

    public static /* synthetic */ void showToast$default(ECToast r100, Context r101, int r102, Boolean r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L5;
        r103 = null;
    L5:
        r100.showToast(r101, r102, r103);
    }

    public static /* synthetic */ void showCustomToast$default(ECToast r100, Context r101, CharSequence r102, Drawable r103, Boolean r104, int r105, Object r106) {
        if ((r105 & 8) == 0) goto L5;
        r104 = null;
    L5:
        r100.showCustomToast(r101, r102, r103, r104);
    }

    public static /* synthetic */ void showToast$default(ECToast r100, Context r101, CharSequence r102, int r103, Boolean r104, int r105, Object r106) {
        if ((r105 & 8) == 0) goto L5;
        r104 = null;
    L5:
        r100.showToast(r101, r102, r103, r104);
    }

    public static /* synthetic */ void showToast$default(ECToast r100, Context r101, CharSequence r102, Drawable r103, Boolean r104, int r105, Object r106) {
        if ((r105 & 8) == 0) goto L5;
        r104 = null;
    L5:
        r100.showToast(r101, r102, r103, r104);
    }

    private final Toast showSystemToast(Context r100, int r101, Drawable r102, int r110, CharSequence r111, int r112, Drawable r113, Boolean r114) {
        View r103 = LayoutInflater.from(r100).inflate(R.layout.ec_dux_popup_toast, null);     // Catch: Exception -> L25
        ImageView r104 = (ImageView) r103.findViewById(R.id.icon);     // Catch: Exception -> L25
        LinearLayout r105 = (LinearLayout) r103.findViewById(R.id.toast_container);     // Catch: Exception -> L25
        if (r101 == 0) goto L6;
        r104.setImageResource(r101);     // Catch: Exception -> L25
    L16:
        TextView r106 = (TextView) r103.findViewById(R.id.text);     // Catch: Exception -> L25
        r106.setTextColor(ContextCompat.getColor(r100, R.color.white));     // Catch: Exception -> L25
        if (r110 == 0) goto L19;
        r106.setText(r110);     // Catch: Exception -> L25
    L20:
        if (r112 == 0) goto L22;
        r106.setCompoundDrawablesWithIntrinsicBounds(r112, 0, 0, 0);     // Catch: Exception -> L25
    L23:
        return showSystemToast(r100, r103, r114);
    L22:
        r106.setCompoundDrawablesWithIntrinsicBounds(r113, null, null, null);     // Catch: Exception -> L25
        goto L23
    L19:
        r106.setText(r111);     // Catch: Exception -> L25
        goto L20
    L6:
        if (r102 == null) goto L8;
        r104.setImageDrawable(r102);     // Catch: Exception -> L25
        goto L16
    L8:
        r104.setVisibility(8);     // Catch: Exception -> L25
        r105.setMinimumHeight(0);     // Catch: Exception -> L25
        r105.setMinimumWidth(0);     // Catch: Exception -> L25
        r105.setPadding(UnitExtensionKt.dp2px(16), UnitExtensionKt.dp2px(10), UnitExtensionKt.dp2px(16), UnitExtensionKt.dp2px(10));     // Catch: Exception -> L25
        Drawable r107 = r105.getBackground();     // Catch: Exception -> L25
        if ((r107 instanceof BackgroundDrawable) == true) goto L11;
        r107 = null;
    L11:
        BackgroundDrawable r108 = (BackgroundDrawable) r107;     // Catch: Exception -> L25
        if (r108 == null) goto L16;
        BackgroundDrawable r109 = r108.setCornerRadius(UnitExtensionKt.dp2px(20));     // Catch: Exception -> L25
        if (r109 == null) goto L16;
        r109.invalidate();     // Catch: Exception -> L25
    L25:
        return null;
    }
}
