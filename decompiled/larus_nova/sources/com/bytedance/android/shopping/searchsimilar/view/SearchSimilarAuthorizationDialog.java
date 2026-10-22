package com.bytedance.android.shopping.searchsimilar.view;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialog;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.shopping.abtest.SettingKeys;
import com.bytedance.android.shopping.anchorv3.detail.vo.AuthorizationDialogImageInfo;
import com.bytedance.android.shopping.anchorv3.detail.vo.DialogImageInfo;
import com.bytedance.common.utility.UIUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import gh3.e;
import gh3.g;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/searchsimilar/view/SearchSimilarAuthorizationDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "Landroid/view/View$OnClickListener;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SearchSimilarAuthorizationDialog extends AppCompatDialog implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SimpleDraweeView f182513a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f182514b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f182515c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f182516d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f182517e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f182518f;

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        Context r100 = getContext();
        if ((r100 instanceof Activity) == true) goto L5;
        r100 = null;
    L5:
        Activity r101 = (Activity) r100;
        if (r101 == null) goto L11;
        if (r101.isFinishing() != true) goto L11;
        return;
    L11:
        if (this.f182517e == true) goto L17;
        int r102 = g.f481273a;
        if (this.f182518f == false) goto L15;
        String r103 = "open";
    L16:
        g.b(r103, "quit");
        goto L17
    L15:
        r103 = "close";
    L17:
        Handler r104 = DialogLancet.resolveDialogHandler(this);
        if (r104 != null) goto L20;
    L22:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L25 Exception -> L27
    L31:
        DialogLancet.afterDialogDismiss(this);
        return;
    L27:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L25
        Throwable r105 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L25
        if (r105 == null) goto L31;
        com.bytedance.crash.d.d(r105, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L20:
        if (Looper.myLooper() == r104.getLooper()) goto L22;
        r104.post(DialogLancet.createDismissRunnable(this));
    }

    @Override // android.app.Dialog
    public final void show() {
        Context r100 = getContext();
        if ((r100 instanceof Activity) == true) goto L5;
        r100 = null;
    L5:
        Activity r101 = (Activity) r100;
        if (r101 == null) goto L11;
        if (r101.isFinishing() != true) goto L11;
        return;
    L11:
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L22;
        DialogLancet.handleBlockedDialogShow(this);
    L15:
        int r102 = g.f481273a;
        if (this.f182518f == false) goto L18;
        String r103 = "open";
    L19:
        e r104 = new e("similar_product_notice_show");
        r104.f481269a = r103;
        r104.post(null, null);
        return;
    L18:
        r103 = "close";
        goto L19
    L22:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L21
    L14:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L15
    }

    public static void I0(SearchSimilarAuthorizationDialog r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L10;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (r100 == null) goto L4;
        Integer r101 = Integer.valueOf(r100.getId());
    L6:
        if (r101 != null) goto L9;
    L17:
        if (r101 != null) goto L20;
    L28:
        if (r101 != null) goto L31;
        return;
    L31:
        if (r101.intValue() != R.id.ec_iv_similar_product_dialog_close) goto L36;
        I0(this);
        return;
    L36:
        return;
    L20:
        if (r101.intValue() != R.id.ec_search_similar_tv_product_confirm_button) goto L28;
        if (this.f182518f == true) goto L27;
        int r102 = ECSdk.f48106a;
        s83.g r103 = (s83.g) ECSdk.a(s83.g.class);
        if (r103 == null) goto L26;
        r103.g0(getContext(), true);
    L26:
        UIUtils.displayToast(getContext(), R.string.ec_tip_turn_on_function);
        g.b("close", "open");
        this.f182517e = true;
    L27:
        I0(this);
        return;
    L9:
        if (r101.intValue() != R.id.ec_search_similar_tv_product_cancel_button) goto L17;
        if (this.f182518f == false) goto L16;
        int r104 = ECSdk.f48106a;
        s83.g r105 = (s83.g) ECSdk.a(s83.g.class);
        if (r105 == null) goto L15;
        r105.g0(getContext(), false);
    L15:
        UIUtils.displayToast(getContext(), R.string.ec_tip_turn_down_function);
        g.b("open", "close");
        this.f182517e = true;
    L16:
        I0(this);
        return;
    L4:
        r101 = null;
        goto L6
    }

    public SearchSimilarAuthorizationDialog(Context r100, boolean r101) {
        super(r100);
        this.f182518f = r101;
        Window r102 = getWindow();
        boolean r103 = false;
        if (r102 == null) goto L10;
        r102.requestFeature(1);
        View r104 = r102.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L9;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r105 = ThreadMethodProxy.currentThread();
        if (r105 == com.larus.home.impl.utils.c.f346341a) goto L9;
        com.larus.home.impl.utils.c.a(r105, "getDecorView");
    L9:
        r104.setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams r106 = r102.getAttributes();
        r106.width = -1;
        r106.height = -2;
        r106.windowAnimations = R.style.bottom_dialog_enter_exit_anim;
        r106.gravity = 80;
        r102.setAttributes(r106);
        r102.setBackgroundDrawableResource(android.R.color.transparent);
    L10:
        setContentView(R.layout.ec_search_similar_product_dialog);
        this.f182513a = (SimpleDraweeView) findViewById(R.id.ec_sv_search_similar_product_content);
        this.f182514b = (TextView) findViewById(R.id.ec_search_similar_tv_product_cancel_button);
        this.f182515c = (TextView) findViewById(R.id.ec_search_similar_tv_product_confirm_button);
        this.f182516d = findViewById(R.id.ec_iv_similar_product_dialog_close);
        setCanceledOnTouchOutside(true);
        if (com.bytedance.android.shopping.searchsimilar.utils.a.a() != 1) goto L13;
    L15:
        this.f182518f = r103;
        AuthorizationDialogImageInfo r107 = SettingKeys.getSEARCH_SIMILAR_DIALOG_IMAGE();
        if (r107 == null) goto L28;
        DialogImageInfo r108 = r107.getValues();
        if (r108 == null) goto L28;
        if (this.f182518f == false) goto L24;
        SimpleDraweeView r109 = this.f182513a;
        if (r109 == null) goto L28;
        y.a(r109, r108.getCloseStatusImage());
        goto L28
    L24:
        SimpleDraweeView r110 = this.f182513a;
        if (r110 == null) goto L28;
        y.a(r110, r108.getOpenStatusImage());
    L28:
        if (this.f182518f == false) goto L35;
        TextView r111 = this.f182514b;
        if (r111 == null) goto L32;
        r111.setText(R.string.ec_tip_close_search_similar_product);
    L32:
        TextView r112 = this.f182515c;
        if (r112 == null) goto L41;
        r112.setText(R.string.ec_tip_i_know);
    L41:
        TextView r113 = this.f182514b;
        if (r113 == null) goto L44;
        r113.setOnClickListener(this);
    L44:
        TextView r114 = this.f182515c;
        if (r114 == null) goto L47;
        r114.setOnClickListener(this);
    L47:
        View r115 = this.f182516d;
        if (r115 == null) goto L51;
        r115.setOnClickListener(this);
        return;
    L51:
        return;
    L35:
        TextView r116 = this.f182514b;
        if (r116 == null) goto L38;
        r116.setText(R.string.ec_tip_think_again);
    L38:
        TextView r117 = this.f182515c;
        if (r117 == null) goto L41;
        r117.setText(R.string.ec_tip_open_search_similar_product);
        goto L41
    L13:
        if (com.bytedance.android.shopping.searchsimilar.utils.a.a() == 2) goto L15;
        r103 = true;
        goto L15
    }
}
