package com.alipay.sdk.m.x;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.io.ByteArrayInputStream;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes28.dex */
public class a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f25902i = "正在加载";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f25903j = "去支付宝付款";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f25904k = "去支付宝授权";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static String f25905l = "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";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f25906a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Activity f25907b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f25908c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f25909d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f25910e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f25911f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f25912g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Handler f25913h;

    /* JADX INFO: renamed from: com.alipay.sdk.m.x.a$a, reason: collision with other inner class name */
    public class RunnableC0497a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f25914a;

        @Override // java.lang.Runnable
        public void run() {
            com_alipay_sdk_m_x_a$a_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_alipay_sdk_m_x_a$a__run$___twin___() {
            if (a.c(this.f25914a) != null) goto L12;
            a r100 = this.f25914a;
            a r101 = this.f25914a;
            a.a(r100, new d(r101, a.a(r101)));
            a.c(this.f25914a).setCancelable(a.d(this.f25914a));
        L12:
        L9:
            e = move-exception;
            com.alipay.sdk.m.u.e.a(e);
            return;
        L6:
            if (a.c(this.f25914a).isShowing() == true) goto L14;
            INVOKEVIRTUAL_com_alipay_sdk_m_x_a$a_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(a.c(this.f25914a));     // Catch: Exception -> L9
            a.e(this.f25914a).sendEmptyMessageDelayed(1, 10000);     // Catch: Exception -> L9
            return;
        }

        public RunnableC0497a(a r100) {
            this.f25914a = r100;
        }

        public static void INVOKEVIRTUAL_com_alipay_sdk_m_x_a$a_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(AlertDialog r100) {
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

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_alipay_sdk_m_x_a$a_com_larus_apm_impl_protector_RunnableLancet_run(RunnableC0497a r100) {
            r100.com_alipay_sdk_m_x_a$a__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f25915a;

        @Override // java.lang.Runnable
        public void run() {
            com_alipay_sdk_m_x_a$b_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_alipay_sdk_m_x_a$b__run$___twin___() {
            if (a.c(this.f25915a) != null) goto L5;
            return;
        L5:
            if (a.c(this.f25915a).isShowing() == false) goto L14;
            a.e(this.f25915a).removeMessages(1);     // Catch: Exception -> L8
            INVOKEVIRTUAL_com_alipay_sdk_m_x_a$b_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(a.c(this.f25915a));     // Catch: Exception -> L8
            return;
        L8:
            e = move-exception;
            com.alipay.sdk.m.u.e.a(e);
            return;
        }

        public b(a r100) {
            this.f25915a = r100;
        }

        public static void INVOKEVIRTUAL_com_alipay_sdk_m_x_a$b_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(AlertDialog r100) {
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

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_alipay_sdk_m_x_a$b_com_larus_apm_impl_protector_RunnableLancet_run(b r100) {
            r100.com_alipay_sdk_m_x_a$b__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public class c extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f25916a;

        @Override // android.os.Handler
        public void dispatchMessage(Message r100) {
            this.f25916a.a();
        }

        public c(a r100, Looper r101) {
            this.f25916a = r100;
            super(r101);
        }
    }

    public class d extends AlertDialog {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f25917a;

        public static DisplayMetrics INVOKEVIRTUAL_com_alipay_sdk_m_x_a$d_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
            return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
        }

        private View a(Context r110) {
            LinearLayout r100 = new LinearLayout(r110);
            FrameLayout.LayoutParams r101 = new FrameLayout.LayoutParams(-2, a(r110, 50.0f));
            r101.gravity = 17;
            r100.setOrientation(0);
            r100.setLayoutParams(r101);
            GradientDrawable r102 = new GradientDrawable();
            r102.setColor(-450944201);
            r102.setCornerRadius(a(r110, 5.0f));
            r100.setBackgroundDrawable(r102);
            ImageView r103 = new ImageView(r110);
            LinearLayout.LayoutParams r104 = new LinearLayout.LayoutParams(a(r110, 20.0f), a(r110, 20.0f));
            r104.gravity = 16;
            r104.setMargins(a(a.a(this.f25917a), 17.0f), a(a.a(this.f25917a), 10.0f), a(a.a(this.f25917a), 8.0f), a(a.a(this.f25917a), 10.0f));
            r103.setLayoutParams(r104);
            r103.setScaleType(ImageView.ScaleType.FIT_CENTER);
            r103.setImageDrawable(a(r110, a.f25905l, 480));
            RotateAnimation r105 = new RotateAnimation(0.0f, 359.0f, 1, 0.5f, 1, 0.5f);
            r105.setRepeatCount(-1);
            r105.setDuration(900);
            r105.setInterpolator(new LinearInterpolator());
            r103.startAnimation(r105);
            TextView r106 = new TextView(r110);
            if (TextUtils.isEmpty(a.b(this.f25917a)) == false) goto L5;
            String r111 = a.f25902i;
        L6:
            r106.setText(r111);
            r106.setTextSize(16.0f);
            r106.setTextColor(-1);
            LinearLayout.LayoutParams r107 = new LinearLayout.LayoutParams(-2, -2);
            r107.gravity = 16;
            r107.setMargins(0, 0, a(r110, 17.0f), 0);
            r106.setLayoutParams(r107);
            r100.addView(r103);
            r100.addView(r106);
            FrameLayout r108 = new FrameLayout(r110);
            r108.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            r108.addView(r100);
            return r108;
        L5:
            r111 = a.b(this.f25917a);
            goto L6
        }

        @Override // android.app.AlertDialog, android.app.Dialog
        public void onCreate(Bundle r100) {
            super.onCreate(r100);
            setContentView(a(getContext()));
            Window r101 = getWindow();
            if (r101 == null) goto L6;
            r101.setBackgroundDrawable(new ColorDrawable(0));
            return;
        }

        public d(a r100, Context r101) {
            this.f25917a = r100;
            super(r101);
        }

        private int a(Context r100, float r101) {
            if (r100 != null) goto L4;
            Resources r102 = Resources.getSystem();
        L6:
            return (int) (r101 * INVOKEVIRTUAL_com_alipay_sdk_m_x_a$d_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r102).density);
        L4:
            r102 = r100.getResources();
            goto L6
        }

        private Drawable a(Context r100, String r101, int r102) {
            ByteArrayInputStream r103 = new ByteArrayInputStream(com.alipay.sdk.m.n.a.a(r101));     // Catch: Throwable -> L12
            BitmapFactory.Options r104 = new BitmapFactory.Options();     // Catch: Throwable -> L10
            if (r102 > 0) goto L7;
            r102 = 240;
        L7:
            r104.inDensity = r102;     // Catch: Throwable -> L10
            r104.inTargetDensity = INVOKEVIRTUAL_com_alipay_sdk_m_x_a$d_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getResources()).densityDpi;     // Catch: Throwable -> L10
            BitmapDrawable r105 = new BitmapDrawable(r100.getResources(), BitmapFactory.decodeStream(r103, null, r104));     // Catch: Throwable -> L10
            r103.close();     // Catch: Exception -> L22
        L37:
            return r105;
        L10:
            th = th;
        L25:
            com.alipay.sdk.m.u.e.a(th);     // Catch: Throwable -> L18
            if (r103 == null) goto L38;
            r103.close();     // Catch: Exception -> L23
            return null;
        L39:
            return null;
        L38:
            return null;
        L18:
            th = move-exception;
            if (r103 != null) goto L33;
        L21:
            throw th;
        L33:
            r103.close();     // Catch: Exception -> L24
        L12:
            th = th;
            r103 = null;
            goto L25
        }
    }

    public void b() {
        this.f25907b = null;
        this.f25906a = null;
    }

    public void a() {
        Activity r100 = this.f25907b;
        if (r100 == null) goto L6;
        r100.runOnUiThread(new b(this));
        return;
    }

    public void d() {
        Activity r100 = this.f25907b;
        if (r100 == null) goto L6;
        r100.runOnUiThread(new RunnableC0497a(this));
        return;
    }

    public String c() {
        return this.f25908c;
    }

    public a(Activity r100) {
        this.f25909d = -1;
        this.f25910e = 1;
        this.f25911f = 10000;
        this.f25912g = false;
        this.f25913h = new c(this, Looper.getMainLooper());
        this.f25907b = r100;
    }

    public static /* synthetic */ Activity a(a r100) {
        return r100.f25907b;
    }

    public static /* synthetic */ String b(a r100) {
        return r100.f25908c;
    }

    public static /* synthetic */ d c(a r100) {
        return r100.f25906a;
    }

    public static /* synthetic */ boolean d(a r100) {
        return r100.f25912g;
    }

    public static /* synthetic */ Handler e(a r100) {
        return r100.f25913h;
    }

    public void a(String r100) {
        this.f25908c = r100;
    }

    public void a(boolean r100) {
        this.f25912g = r100;
    }

    public a(Activity r100, String r101) {
        this.f25909d = -1;
        this.f25910e = 1;
        this.f25911f = 10000;
        this.f25912g = false;
        this.f25913h = new c(this, Looper.getMainLooper());
        this.f25907b = r100;
        this.f25908c = r101;
    }

    public static /* synthetic */ d a(a r100, d r101) {
        r100.f25906a = r101;
        return r101;
    }
}
