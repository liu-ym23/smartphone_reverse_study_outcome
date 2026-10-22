package com.stepos.ailauncher.migu.play;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.autonavi.aps.amapapi.config.Const;
import com.migu.music.ipc.sdk.R$style;
import java.lang.ref.WeakReference;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\u0003J\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010 R\u0014\u0010\"\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010 ¨\u0006#"}, d2 = {"Lcom/stepos/ailauncher/migu/play/z;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "message", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Landroid/content/Context;Ljava/lang/String;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Landroid/widget/LinearLayout;", "e", "(Landroid/content/Context;Ljava/lang/String;)Landroid/widget/LinearLayout;", "Landroid/os/Handler;", "mainHandler", "Landroid/os/Handler;", "Ljava/lang/ref/WeakReference;", "Landroid/app/Dialog;", "showing", "Ljava/lang/ref/WeakReference;", "Ljava/lang/Runnable;", "autoDismiss", "Ljava/lang/Runnable;", "ACTION_TEXT", "Ljava/lang/String;", "", "AUTO_DISMISS_MS", "J", "", "COLOR_BG", "I", "COLOR_TEXT", "COLOR_ACTION", "migu_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.migu.play.z, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3377z {
    private static final String ACTION_TEXT = "去开通";
    private static final long AUTO_DISMISS_MS = 5000;
    private static WeakReference<Dialog> showing;
    public static final C3377z INSTANCE = new C3377z();
    private static final Handler mainHandler = new Handler(Looper.getMainLooper());
    private static final Runnable autoDismiss = new Runnable() { // from class: com.stepos.ailauncher.migu.play.w
        @Override // java.lang.Runnable
        public final void run() {
            C3377z.d();
        }
    };
    private static final int COLOR_BG = Color.parseColor("#1C1C1E");
    private static final int COLOR_TEXT = Color.parseColor("#EEEEEE");
    private static final int COLOR_ACTION = Color.parseColor("#1564ED");

    public static final void d() {
        INSTANCE.h();
    }

    public static final int f(Context context, float f10) {
        return (int) ((f10 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static final void g(Context context, View view) {
        INSTANCE.h();
        C3354b.INSTANCE.f(context, "paidSnackbar");
    }

    public static final void j(DialogInterface dialogInterface) {
        showing = null;
    }

    public final LinearLayout e(final Context context, String message) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(COLOR_BG);
        gradientDrawable.setCornerRadius(f(context, 8.0f));
        linearLayout.setBackground(gradientDrawable);
        linearLayout.setPadding(f(context, 18.0f), 0, f(context, 18.0f), 0);
        linearLayout.setMinimumHeight(f(context, 51.0f));
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -2);
        marginLayoutParams.setMarginStart(f(context, 25.0f));
        marginLayoutParams.setMarginEnd(f(context, 25.0f));
        marginLayoutParams.bottomMargin = f(context, 76.0f);
        linearLayout.setLayoutParams(marginLayoutParams);
        TextView textView = new TextView(context);
        textView.setText(message);
        textView.setTextColor(COLOR_TEXT);
        textView.setTextSize(14.0f);
        textView.setTypeface(Typeface.create(textView.getTypeface(), 0), 0);
        textView.setTypeface(Typeface.create("sans-serif-medium", 0));
        textView.setMaxLines(2);
        textView.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
        linearLayout.addView(textView);
        TextView textView2 = new TextView(context);
        textView2.setText(ACTION_TEXT);
        textView2.setTextColor(COLOR_ACTION);
        textView2.setTextSize(13.0f);
        textView2.setTypeface(Typeface.create("sans-serif-medium", 0));
        textView2.setMaxLines(1);
        textView2.setClickable(true);
        textView2.setFocusable(true);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.migu.play.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C3377z.g(context, view);
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMarginStart(f(context, 20.0f));
        textView2.setLayoutParams(layoutParams);
        linearLayout.addView(textView2);
        return linearLayout;
    }

    public final void h() {
        Dialog dialog;
        Object objB;
        mainHandler.removeCallbacks(autoDismiss);
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

    public final void i(Context context, String message) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(message, "message");
        h();
        Dialog dialog = new Dialog(context, R.style.Theme.Translucent.NoTitleBar);
        dialog.setContentView(e(context, message));
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.stepos.ailauncher.migu.play.x
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                C3377z.j(dialogInterface);
            }
        });
        Window window = dialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(R.color.transparent);
            window.addFlags(32);
            window.clearFlags(2);
            window.setDimAmount(0.0f);
            window.setGravity(80);
            window.setWindowAnimations(R$style.DialogAnimation);
            window.setLayout(-1, -2);
        }
        com.stepos.ailauncher.container.dialog.f.h(dialog.getWindow(), context);
        if (!com.stepos.ailauncher.container.dialog.f.q(dialog, "miguPaid")) {
            showing = null;
            R5.b.INSTANCE.h("music.paidSnackbar.showFail", new Pair[0]);
        } else {
            showing = new WeakReference<>(dialog);
            mainHandler.postDelayed(autoDismiss, 5000L);
            R5.b.INSTANCE.c("music.paidSnackbar.show", new Pair[0]);
        }
    }
}
