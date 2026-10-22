package com.stepos.ailauncher.chat.lockscreen;

import android.R;
import android.app.KeyguardManager;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.autonavi.aps.amapapi.config.Const;
import h8.C4148a;
import java.lang.ref.WeakReference;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\r\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\r\u0010\fJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001e\u0010!\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010$\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006&"}, d2 = {"Lcom/stepos/ailauncher/chat/lockscreen/H;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "message", "", "durationMs", "LY8/t;", "e", "(Landroid/content/Context;Ljava/lang/CharSequence;J)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "", "useKeyguardDialog", "Landroid/view/WindowManager$LayoutParams;", "c", "(Z)Landroid/view/WindowManager$LayoutParams;", "Landroid/view/WindowManager;", "wm", Const.INTENT_KEY_UMID, "(Landroid/view/WindowManager;)V", "", "TAG", "Ljava/lang/String;", "DEFAULT_DURATION_MS", "J", "Landroid/os/Handler;", "mainHandler", "Landroid/os/Handler;", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "currentViewRef", "Ljava/lang/ref/WeakReference;", "Ljava/lang/Runnable;", "removeRunnable", "Ljava/lang/Runnable;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class H {
    private static final long DEFAULT_DURATION_MS = 2500;
    private static final String TAG = "LockScreenNoticeOverlay";
    private static WeakReference<View> currentViewRef;
    private static Runnable removeRunnable;
    public static final H INSTANCE = new H();
    private static final Handler mainHandler = new Handler(Looper.getMainLooper());

    public static /* synthetic */ void f(H h10, Context context, CharSequence charSequence, long j10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            j10 = 2500;
        }
        h10.e(context, charSequence, j10);
    }

    public static final void g(Context context, CharSequence charSequence, long j10) {
        Object objB;
        Object objB2;
        Object systemService = context.getSystemService("window");
        final WindowManager windowManager = systemService instanceof WindowManager ? (WindowManager) systemService : null;
        if (windowManager == null) {
            return;
        }
        WeakReference<View> weakReference = currentViewRef;
        View view = weakReference != null ? weakReference.get() : null;
        if (view == null || !view.isAttachedToWindow()) {
            H h10 = INSTANCE;
            h10.d(windowManager);
            float f10 = context.getResources().getDisplayMetrics().density;
            TextView textView = new TextView(context);
            textView.setText(charSequence);
            textView.setTextColor(-1);
            textView.setTextSize(2, 14.0f);
            textView.setPadding(i(f10, 20.0f), i(f10, 12.0f), i(f10, 20.0f), i(f10, 12.0f));
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(i(f10, 12.0f));
            gradientDrawable.setColor(-13882324);
            textView.setBackground(gradientDrawable);
            FrameLayout frameLayout = new FrameLayout(context);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 49;
            layoutParams.topMargin = (int) (context.getResources().getDisplayMetrics().heightPixels * 0.5f);
            Y8.t tVar = Y8.t.f7040a;
            frameLayout.addView(textView, layoutParams);
            try {
                Result.Companion companion = Result.INSTANCE;
                windowManager.addView(frameLayout, h10.c(true));
                objB = Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                C4148a.t(TAG, "addView with TYPE_KEYGUARD_DIALOG failed, fallback", thE, false, 8, null);
            }
            if (!Result.h(objB)) {
                try {
                    windowManager.addView(frameLayout, INSTANCE.c(false));
                    objB2 = Result.b(Y8.t.f7040a);
                } catch (Throwable th2) {
                    Result.Companion companion3 = Result.INSTANCE;
                    objB2 = Result.b(C4849c.a(th2));
                }
                Throwable thE2 = Result.e(objB2);
                if (thE2 != null) {
                    C4148a.t(TAG, "addView with TYPE_APPLICATION_OVERLAY failed", thE2, false, 8, null);
                }
                if (Result.g(objB2)) {
                    return;
                }
            }
            currentViewRef = new WeakReference<>(frameLayout);
            Runnable runnable = new Runnable() { // from class: com.stepos.ailauncher.chat.lockscreen.G
                @Override // java.lang.Runnable
                public final void run() {
                    H.h(windowManager);
                }
            };
            mainHandler.postDelayed(runnable, j10);
            removeRunnable = runnable;
        }
    }

    public static final void h(WindowManager windowManager) {
        INSTANCE.d(windowManager);
    }

    public static final int i(float f10, float f11) {
        return (int) (f11 * f10);
    }

    public static /* synthetic */ void k(H h10, Context context, CharSequence charSequence, long j10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            j10 = 2500;
        }
        h10.j(context, charSequence, j10);
    }

    public final WindowManager.LayoutParams c(boolean useKeyguardDialog) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-1, -1, useKeyguardDialog ? 2009 : 2038, 2621720, -3);
        layoutParams.gravity = 8388659;
        layoutParams.windowAnimations = R.style.Animation.Toast;
        return layoutParams;
    }

    public final void d(WindowManager wm) {
        View view;
        Object objB;
        Runnable runnable = removeRunnable;
        if (runnable != null) {
            mainHandler.removeCallbacks(runnable);
        }
        removeRunnable = null;
        WeakReference<View> weakReference = currentViewRef;
        if (weakReference != null && (view = weakReference.get()) != null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                wm.removeViewImmediate(view);
                objB = Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Result.a(objB);
        }
        currentViewRef = null;
    }

    public final void e(Context context, final CharSequence message, final long durationMs) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(message, "message");
        final Context applicationContext = context.getApplicationContext();
        mainHandler.post(new Runnable() { // from class: com.stepos.ailauncher.chat.lockscreen.F
            @Override // java.lang.Runnable
            public final void run() {
                H.g(applicationContext, message, durationMs);
            }
        });
    }

    public final void j(Context context, CharSequence message, long durationMs) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(message, "message");
        Object systemService = context.getSystemService("keyguard");
        KeyguardManager keyguardManager = systemService instanceof KeyguardManager ? (KeyguardManager) systemService : null;
        if (keyguardManager == null || !keyguardManager.isKeyguardLocked()) {
            Toast.makeText(context.getApplicationContext(), message, 0).show();
        } else {
            e(context, message, durationMs);
        }
    }
}
