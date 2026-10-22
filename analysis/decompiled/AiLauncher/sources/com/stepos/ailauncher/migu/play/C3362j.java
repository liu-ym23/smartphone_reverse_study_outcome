package com.stepos.ailauncher.migu.play;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.View;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.a0;
import com.autonavi.aps.amapapi.config.Const;
import com.migu.music.ipc.sdk.R$anim;
import com.migu.music.ipc.sdk.R$drawable;
import com.migu.music.ipc.sdk.R$string;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import java.lang.ref.WeakReference;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\u0003J\u001f\u0010\r\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ%\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0013\u0010\bR\u001e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/stepos/ailauncher/migu/play/j;", "", "<init>", "()V", "Landroid/content/Context;", "context", "LY8/t;", "o", "(Landroid/content/Context;)V", "m", "Landroid/view/View;", Parameters.ROOT, "panel", "f", "(Landroid/view/View;Landroid/view/View;)V", "Lkotlin/Function0;", "onAction", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Landroid/content/Context;Lp9/a;)Landroid/view/View;", "n", "Ljava/lang/ref/WeakReference;", "Landroid/app/Dialog;", "showing", "Ljava/lang/ref/WeakReference;", "", "COLOR_SCRIM", "I", "COLOR_TITLE", "COLOR_SUBTLE", "migu_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.migu.play.j, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3362j {
    private static WeakReference<Dialog> showing;
    public static final C3362j INSTANCE = new C3362j();
    private static final int COLOR_SCRIM = Color.parseColor("#80000000");
    private static final int COLOR_TITLE = Color.parseColor("#333333");
    private static final int COLOR_SUBTLE = Color.parseColor("#3D4454");

    public static final androidx.core.view.a0 g(int i10, View view, View view2, androidx.core.view.a0 insets) {
        kotlin.jvm.internal.p.i(view2, "<unused var>");
        kotlin.jvm.internal.p.i(insets, "insets");
        int i11 = i10 + insets.f(a0.o.e()).f41980d;
        if (view.getPaddingBottom() != i11) {
            view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), i11);
        }
        return insets;
    }

    public static final int i(Context context, float f10) {
        return (int) ((f10 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static final TextView j(Context context, int i10, float f10, int i11, boolean z10, float f11, float f12) {
        TextView textView = new TextView(context);
        textView.setText(i10);
        textView.setGravity(17);
        textView.setTextColor(i11);
        textView.setTextSize(f10);
        if (z10) {
            textView.setTypeface(textView.getTypeface(), 1);
        }
        if (f12 > 0.0f) {
            textView.setPadding(i(context, f12), 0, i(context, f12), 0);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = i(context, f11);
        textView.setLayoutParams(layoutParams);
        return textView;
    }

    public static /* synthetic */ TextView k(Context context, int i10, float f10, int i11, boolean z10, float f11, float f12, int i12, Object obj) {
        if ((i12 & 64) != 0) {
            f12 = 0.0f;
        }
        return j(context, i10, f10, i11, z10, f11, f12);
    }

    public static final void l(InterfaceC5063a interfaceC5063a, View view) {
        interfaceC5063a.invoke();
    }

    public static final Y8.t p(Context context) {
        INSTANCE.n(context);
        return Y8.t.f7040a;
    }

    public static final void q(View view) {
        INSTANCE.m();
    }

    public static final void r(DialogInterface dialogInterface) {
        showing = null;
    }

    public final void f(View root, final View panel) {
        final int paddingBottom = panel.getPaddingBottom();
        androidx.core.view.N.u0(root, new androidx.core.view.A() { // from class: com.stepos.ailauncher.migu.play.i
            @Override // androidx.core.view.A
            public final androidx.core.view.a0 a(View view, androidx.core.view.a0 a0Var) {
                return C3362j.g(paddingBottom, panel, view, a0Var);
            }
        });
        androidx.core.view.N.e0(root);
    }

    public final View h(Context context, final InterfaceC5063a<Y8.t> onAction) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setBackground(androidx.core.content.a.e(context, R$drawable.bg_music_ipc_dialog));
        linearLayout.setPadding(0, i(context, 20.0f), 0, i(context, 24.0f));
        linearLayout.addView(j(context, R$string.dialog_install_app_title, 17.0f, COLOR_TITLE, true, 0.0f, 16.0f));
        int i10 = R$string.dialog_install_app_message;
        int i11 = COLOR_SUBTLE;
        linearLayout.addView(k(context, i10, 15.0f, i11, false, 10.0f, 0.0f, 64, null));
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(R$drawable.ic_music_ipc_dialog_app);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        layoutParams.topMargin = i(context, 25.0f);
        imageView.setLayoutParams(layoutParams);
        linearLayout.addView(imageView);
        linearLayout.addView(k(context, R$string.dialog_app_name, 12.0f, i11, true, 7.0f, 0.0f, 64, null));
        linearLayout.addView(k(context, R$string.dialog_app_developer_label, 12.0f, i11, false, 7.0f, 0.0f, 64, null));
        Button button = new Button(context);
        button.setText(R$string.dialog_download_button);
        button.setBackgroundResource(R$drawable.shape_btn_dialog_bg);
        button.setTextColor(-1);
        button.setTextSize(16.0f);
        button.setTypeface(button.getTypeface(), 1);
        button.setElevation(0.0f);
        button.setStateListAnimator(null);
        button.setAllCaps(false);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.migu.play.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C3362j.l(onAction, view);
            }
        });
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, i(context, 44.0f));
        layoutParams2.setMarginStart(i(context, 16.0f));
        layoutParams2.setMarginEnd(i(context, 16.0f));
        layoutParams2.topMargin = i(context, 30.0f);
        button.setLayoutParams(layoutParams2);
        linearLayout.addView(button);
        return linearLayout;
    }

    public final void m() {
        Dialog dialog;
        Object objB;
        WeakReference<Dialog> weakReference = showing;
        if (weakReference != null && (dialog = weakReference.get()) != null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                dialog.dismiss();
                objB = Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Result.a(objB);
        }
        showing = null;
    }

    public final void n(Context context) {
        m();
        C3354b.INSTANCE.b(context, "installDialog");
    }

    public final void o(final Context context) {
        Dialog dialog;
        kotlin.jvm.internal.p.i(context, "context");
        WeakReference<Dialog> weakReference = showing;
        if (weakReference == null || (dialog = weakReference.get()) == null || !dialog.isShowing()) {
            Dialog dialog2 = new Dialog(context, R.style.Theme.Translucent.NoTitleBar);
            View viewH = h(context, new InterfaceC5063a() { // from class: com.stepos.ailauncher.migu.play.e
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return C3362j.p(context);
                }
            });
            FrameLayout frameLayout = new FrameLayout(context);
            frameLayout.setBackgroundColor(COLOR_SCRIM);
            frameLayout.addView(viewH, new FrameLayout.LayoutParams(-1, -2, 80));
            frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.migu.play.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    C3362j.q(view);
                }
            });
            viewH.setClickable(true);
            f(frameLayout, viewH);
            dialog2.setContentView(frameLayout);
            dialog2.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.stepos.ailauncher.migu.play.g
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    C3362j.r(dialogInterface);
                }
            });
            Window window = dialog2.getWindow();
            if (window != null) {
                window.setBackgroundDrawableResource(R.color.transparent);
                window.clearFlags(2);
                window.setDimAmount(0.0f);
                window.setLayout(-1, -1);
            }
            com.stepos.ailauncher.container.dialog.f.h(dialog2.getWindow(), context);
            if (!com.stepos.ailauncher.container.dialog.f.q(dialog2, "miguGuide.INSTALL")) {
                showing = null;
                R5.b.INSTANCE.h("music.guideDialog.showFail", Y8.j.a("variant", "INSTALL"));
            } else {
                showing = new WeakReference<>(dialog2);
                viewH.startAnimation(AnimationUtils.loadAnimation(context, R$anim.dialog_enter_from_bottom));
                R5.b.INSTANCE.c("music.guideDialog.show", Y8.j.a("variant", "INSTALL"));
            }
        }
    }
}
