package com.stepos.ailauncher.container.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import androidx.core.view.A;
import androidx.core.view.N;
import androidx.core.view.a0;
import java.util.function.Consumer;
import stepos.support.v7.app.c;

/* loaded from: classes3.dex */
public class f {
    private static final String TAG = "DialogUtil";
    private static Dialog sAppDialog;

    public class a implements A {
        @Override // androidx.core.view.A
        public a0 a(View view, a0 a0Var) {
            boolean zR = a0Var.r(a0.o.g());
            if (!a0Var.r(a0.o.b()) && !zR && f.sAppDialog != null && f.sAppDialog.isShowing()) {
                f.j();
            }
            return a0Var;
        }
    }

    public class b implements Runnable {
        final /* synthetic */ Handler val$handler;
        final /* synthetic */ String val$label;
        final /* synthetic */ Button val$positive;
        final /* synthetic */ int[] val$remaining;

        public b(int[] iArr, Button button, String str, Handler handler) {
            this.val$remaining = iArr;
            this.val$positive = button;
            this.val$label = str;
            this.val$handler = handler;
        }

        @Override // java.lang.Runnable
        public void run() {
            int[] iArr = this.val$remaining;
            int i10 = iArr[0] - 1;
            iArr[0] = i10;
            if (i10 <= 0) {
                this.val$positive.setText(this.val$label);
                this.val$positive.setEnabled(true);
                this.val$positive.setAlpha(1.0f);
                return;
            }
            this.val$positive.setText(this.val$label + "(" + this.val$remaining[0] + ")");
            this.val$handler.postDelayed(this, 1000L);
        }
    }

    public static /* synthetic */ void a(Handler handler, Runnable[] runnableArr, Context context, Consumer consumer, DialogInterface dialogInterface, int i10) {
        Runnable runnable;
        if (handler != null && (runnable = runnableArr[0]) != null) {
            handler.removeCallbacks(runnable);
        }
        k(context, dialogInterface);
        if (consumer != null) {
            consumer.accept(dialogInterface);
        }
    }

    public static /* synthetic */ boolean b(Dialog dialog, DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
        Log.d(TAG, "keyCode:" + i10);
        if (keyEvent != null && (((3 == i10 && 1 == keyEvent.getAction()) || 4 == i10) && dialog != null && dialog.isShowing())) {
            dialog.dismiss();
        }
        return true;
    }

    public static /* synthetic */ void c(stepos.support.v7.app.c cVar, String str, int i10, Runnable[] runnableArr, Handler handler, DialogInterface dialogInterface) {
        Button button = cVar.getButton(-1);
        if (button == null) {
            return;
        }
        button.setEnabled(false);
        button.setAlpha(0.6f);
        button.setText(str + "(" + i10 + ")");
        b bVar = new b(new int[]{i10}, button, str, handler);
        runnableArr[0] = bVar;
        handler.postDelayed(bVar, 1000L);
    }

    public static /* synthetic */ void d(Handler handler, Runnable[] runnableArr, Context context, Consumer consumer, DialogInterface dialogInterface) {
        Runnable runnable;
        if (handler != null && (runnable = runnableArr[0]) != null) {
            handler.removeCallbacks(runnable);
        }
        k(context, dialogInterface);
        if (consumer != null) {
            consumer.accept(dialogInterface);
        }
    }

    public static /* synthetic */ void e(Handler handler, Runnable[] runnableArr, Context context, DialogInterface dialogInterface, int i10) {
        Runnable runnable;
        if (handler != null && (runnable = runnableArr[0]) != null) {
            handler.removeCallbacks(runnable);
        }
        k(context, dialogInterface);
    }

    public static boolean h(Window window, Context context) {
        if (window == null || context == null || l(context)) {
            return false;
        }
        if (Settings.canDrawOverlays(context)) {
            n(window);
            return true;
        }
        Log.w(TAG, "skip TYPE_APPLICATION_OVERLAY: canDrawOverlays=false");
        return false;
    }

    public static void i(final stepos.support.v7.app.c cVar, final Handler handler, final Runnable[] runnableArr, final String str, final int i10) {
        if (handler == null) {
            return;
        }
        cVar.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.stepos.ailauncher.container.dialog.e
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                f.c(cVar, str, i10, runnableArr, handler, dialogInterface);
            }
        });
    }

    public static void j() {
        Dialog dialog = sAppDialog;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        sAppDialog.dismiss();
        sAppDialog = null;
    }

    public static void k(Context context, DialogInterface dialogInterface) {
        if (dialogInterface != null) {
            dialogInterface.dismiss();
        }
    }

    public static boolean l(Context context) {
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return true;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return context instanceof Activity;
    }

    public static void m() {
        j();
    }

    @Deprecated
    public static void n(Window window) {
        window.setType(2038);
    }

    public static void o(final Dialog dialog, Context context) {
        if (dialog == null || context == null) {
            return;
        }
        dialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.stepos.ailauncher.container.dialog.d
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
                return f.b(dialog, dialogInterface, i10, keyEvent);
            }
        });
    }

    public static void p(View view) {
        N.u0(view, new a());
    }

    public static boolean q(Dialog dialog, String str) {
        if (dialog == null) {
            return false;
        }
        try {
            dialog.show();
            return true;
        } catch (Throwable th) {
            Log.e(TAG, "dialog.show failed (" + str + ")", th);
            return false;
        }
    }

    public static void r(final Context context, String str, String str2, String str3, String str4, int i10, final Consumer<DialogInterface> consumer, final Consumer<DialogInterface> consumer2) {
        j();
        final Handler handler = i10 > 0 ? new Handler(Looper.getMainLooper()) : null;
        final Runnable[] runnableArr = new Runnable[1];
        stepos.support.v7.app.c cVarC = new c.a(context).u(str).l(str2).s(str4, new DialogInterface.OnClickListener() { // from class: com.stepos.ailauncher.container.dialog.a
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i11) {
                f.a(handler, runnableArr, context, consumer, dialogInterface, i11);
            }
        }).n(str3, new DialogInterface.OnClickListener() { // from class: com.stepos.ailauncher.container.dialog.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i11) {
                f.e(handler, runnableArr, context, dialogInterface, i11);
            }
        }).p(new DialogInterface.OnDismissListener() { // from class: com.stepos.ailauncher.container.dialog.c
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                f.d(handler, runnableArr, context, consumer2, dialogInterface);
            }
        }).i(-1, 2).g(true).c();
        cVarC.setCanceledOnTouchOutside(true);
        o(cVarC, context);
        h(cVarC.getWindow(), context);
        sAppDialog = cVarC;
        if (i10 > 0) {
            i(cVarC, handler, runnableArr, str4, i10);
        }
        if (q(cVarC, "slidPanel")) {
            return;
        }
        sAppDialog = null;
    }
}
