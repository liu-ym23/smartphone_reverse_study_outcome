package com.stepos.ailauncher.chat.lowpower;

import Y8.t;
import android.annotation.SuppressLint;
import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.R$id;
import com.stepos.ailauncher.chat.R$layout;
import com.stepos.ailauncher.chat.lowpower.TempPowerLowChecker;
import com.stepos.ailauncher.common.utils.C3197a;
import com.stepos.ailauncher.container.m0;
import h8.C4148a;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/stepos/ailauncher/chat/lowpower/d;", "", "<init>", "()V", "Lcom/stepos/ailauncher/chat/lowpower/TempPowerLowChecker$a;", "stat", "LY8/t;", "f", "(Lcom/stepos/ailauncher/chat/lowpower/TempPowerLowChecker$a;)V", "Landroid/view/WindowManager$LayoutParams;", Const.INTENT_KEY_UMID, "()Landroid/view/WindowManager$LayoutParams;", "Landroid/view/WindowManager;", "wm", "e", "(Landroid/view/WindowManager;)V", "", "TAG", "Ljava/lang/String;", "Landroid/os/Handler;", "mainHandler", "Landroid/os/Handler;", "Landroid/view/View;", "currentView", "Landroid/view/View;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@SuppressLint({"StaticFieldLeak"})
/* loaded from: classes3.dex */
public final class d {
    private static final String TAG = "TempPowerLowDialog";
    private static View currentView;
    public static final d INSTANCE = new d();
    private static final Handler mainHandler = new Handler(Looper.getMainLooper());

    public static final void g(TempPowerLowChecker.Stat stat) {
        Object objB;
        if (currentView != null) {
            C4148a.d(TAG, "already showing, skip", false, 4, null);
            return;
        }
        Application applicationA = C3197a.INSTANCE.a();
        Object systemService = applicationA.getSystemService("window");
        final WindowManager windowManager = systemService instanceof WindowManager ? (WindowManager) systemService : null;
        if (windowManager == null) {
            return;
        }
        View viewInflate = LayoutInflater.from(applicationA).inflate(R$layout.dialog_temp_power_low, (ViewGroup) null);
        p.g(viewInflate, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) viewInflate;
        TextView textView = (TextView) viewGroup.findViewById(R$id.temp_power_low_title);
        if (textView != null) {
            textView.setText(TempPowerLowChecker.INSTANCE.b(stat));
        }
        TextView textView2 = (TextView) viewGroup.findViewById(R$id.temp_power_low_message);
        if (textView2 != null) {
            textView2.setText(TempPowerLowChecker.INSTANCE.a(stat));
        }
        TextView textView3 = (TextView) viewGroup.findViewById(R$id.temp_power_low_confirm);
        if (textView3 != null) {
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.lowpower.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    d.h(windowManager, view);
                }
            });
        }
        viewGroup.setFocusableInTouchMode(true);
        viewGroup.requestFocus();
        viewGroup.setOnKeyListener(new View.OnKeyListener() { // from class: com.stepos.ailauncher.chat.lowpower.c
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view, int i10, KeyEvent keyEvent) {
                return d.i(view, i10, keyEvent);
            }
        });
        d dVar = INSTANCE;
        try {
            Result.Companion companion = Result.INSTANCE;
            windowManager.addView(viewGroup, dVar.d());
            objB = Result.b(t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(TAG, "addView failed", thE, false, 8, null);
        }
        if (Result.h(objB)) {
            currentView = viewGroup;
        }
    }

    public static final void h(WindowManager windowManager, View view) {
        INSTANCE.e(windowManager);
    }

    public static final boolean i(View view, int i10, KeyEvent keyEvent) {
        return i10 == 4 && keyEvent.getAction() == 1;
    }

    public final WindowManager.LayoutParams d() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-1, -1, 2038, 16777472, -3);
        layoutParams.gravity = 8388659;
        return layoutParams;
    }

    public final void e(WindowManager wm) {
        Object objB;
        View view = currentView;
        if (view != null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                wm.removeViewImmediate(view);
                objB = Result.b(t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Result.a(objB);
        }
        currentView = null;
        if (m0.INSTANCE.h()) {
            C4148a.k(TAG, "user confirmed (overlay host) -> collapse panel", false, 4, null);
            e.INSTANCE.a();
        } else {
            C4148a.k(TAG, "user confirmed (activity host) -> hard exit", false, 4, null);
            e.INSTANCE.b();
        }
    }

    public final void f(final TempPowerLowChecker.Stat stat) {
        mainHandler.post(new Runnable() { // from class: com.stepos.ailauncher.chat.lowpower.a
            @Override // java.lang.Runnable
            public final void run() {
                d.g(stat);
            }
        });
    }
}
