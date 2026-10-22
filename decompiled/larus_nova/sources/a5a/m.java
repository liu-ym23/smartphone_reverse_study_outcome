package a5a;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.larus.nova.R;
import com.lynx.basedevtool.logbox.LogBoxLogLevel;
import com.lynx.basedevtool.logbox.LogBoxProxy;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes32.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<Context> f1892a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakReference<l> f1893b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<LogBoxLogLevel, a> f1894c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<LogBoxLogLevel, Boolean> f1895d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Dialog f1896e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LinearLayout f1897f;

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f1898a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f1899b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final View f1900c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final LogBoxLogLevel f1901d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ m f1902e;

        /* JADX INFO: renamed from: a5a.m$a$a, reason: collision with other inner class name */
        public class ViewOnClickListenerC0019a implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f1903a;

            public ViewOnClickListenerC0019a(a r100) {
                this.f1903a = r100;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r100) {
                a r101 = this.f1903a;
                m r102 = r101.f1902e;
                LogBoxLogLevel r103 = r101.f1901d;
                l r104 = r102.f1893b.get();
                if (r104 == null) goto L11;
                l.a r105 = (l.a) ((HashMap) r104.f1885b).get(r103);
                if (r105 == null) goto L11;
                Iterator r106 = ((ArrayList) r105.f1889b).iterator();
            L8:
                if (r106.hasNext() == false) goto L10;
                ((LogBoxProxy) r106.next()).clearLogsWithLevel(r103);
                goto L8
            L10:
                ((ArrayList) r105.f1889b).clear();
                r105.f1891d = 0;
                r105.f1890c = 0;
            L11:
                r102.b(r103);
            }
        }

        public class b implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f1904a;

            public b(a r100) {
                this.f1904a = r100;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r100) {
                a r101 = this.f1904a;
                m r102 = r101.f1902e;
                LogBoxLogLevel r103 = r101.f1901d;
                l r104 = r102.f1893b.get();
                if (r104 == null) goto L24;
                Context r105 = r104.f1884a.get();
                if (r105 != null) goto L8;
                return;
            L8:
                if (r104.f1887d != null) goto L10;
                r104.f1887d = new a5a.b(r105, r104, new k(r104, r103));
            L12:
                if ((r105 instanceof Activity) == true) goto L14;
                return;
            L14:
                if (((Activity) r105).isFinishing() == true) goto L26;
                a5a.b r106 = r104.f1887d;
                r106.f1857d = r103;
                if (DialogLancet.shouldBlockDialogShow(r106) == false) goto L22;
                DialogLancet.handleBlockedDialogShow(r106);
                return;
            L22:
                DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L21
            L19:
                DialogLancet.beforeDialogShow(r106);
                r106.show();
                DialogLancet.afterDialogShow(r106);
                return;
            L26:
                return;
            L10:
                r104.d(-1, r103);
                goto L12
            }
        }

        public a(m r100, Context r101, ViewGroup r102, LogBoxLogLevel r103) {
            this.f1902e = r100;
            View r104 = LayoutInflater.from(r101).inflate(R.layout.devtool_logbox_notification, r102, false);
            this.f1900c = r104;
            TextView r105 = (TextView) r104.findViewById(R.id.notification_text_brief_log);
            this.f1898a = r105;
            this.f1899b = (TextView) r104.findViewById(R.id.notification_text_log_count);
            this.f1901d = r103;
            r104.findViewById(R.id.notification_button_cancel).setOnClickListener(new ViewOnClickListenerC0019a(this));
            r105.setOnClickListener(new b(this));
            r105.setSingleLine();
            GradientDrawable r106 = (GradientDrawable) ((ImageView) r104.findViewById(R.id.notification_view_log_count_circle)).getDrawable();
            if (r103 != LogBoxLogLevel.Error) goto L6;
            r106.setColor(r101.getResources().getColor(R.color.logbox_red));
            return;
        L6:
            if (r103 != LogBoxLogLevel.Warn) goto L10;
            r106.setColor(r101.getResources().getColor(R.color.logbox_yellow));
            return;
        }
    }

    public static void a(Dialog r100) {
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

    public final void b(LogBoxLogLevel r100) {
        if (this.f1896e != null) goto L5;
        return;
    L5:
        a r101 = (a) ((HashMap) this.f1894c).get(r100);
        if (r101 == null) goto L9;
        this.f1897f.removeView(r101.f1900c);
    L9:
        if (this.f1897f.getChildCount() == 0) goto L11;
        return;
    L11:
        if (this.f1896e.isShowing() == false) goto L15;
        a(this.f1896e);
        return;
    }

    public m(Context r100, l r101) {
        this.f1896e = null;
        this.f1897f = null;
        this.f1892a = new WeakReference(r100);
        this.f1893b = new WeakReference(r101);
        this.f1894c = new HashMap();
        this.f1895d = new HashMap();
    }

    public final void c(LogBoxLogLevel r100, String r101, int r102) {
        ((HashMap) this.f1895d).put(r100, Boolean.FALSE);
        Context r103 = this.f1892a.get();
        if (r103 != null) goto L5;
        return;
    L5:
        if (r102 > 0) goto L9;
        b(r100);
        return;
    L9:
        if (this.f1896e != null) goto L13;
        Dialog r104 = new Dialog(r103);
        this.f1896e = r104;
        r104.requestWindowFeature(1);
        LinearLayout r105 = new LinearLayout(r103);
        this.f1897f = r105;
        r105.setOrientation(1);
        this.f1896e.setContentView(this.f1897f);
        this.f1896e.setCancelable(false);
        if (this.f1896e.getWindow() == null) goto L13;
        this.f1896e.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        this.f1896e.getWindow().setDimAmount(0.0f);
        this.f1896e.getWindow().setLayout(-1, -2);
        this.f1896e.getWindow().setGravity(80);
        this.f1896e.getWindow().addFlags(32);
        this.f1896e.getWindow().addFlags(8);
        this.f1896e.getWindow().addFlags(131072);
        this.f1896e.getWindow().addFlags(256);
    L13:
        a r106 = (a) ((HashMap) this.f1894c).get(r100);
        if (r106 != null) goto L16;
        r106 = new a(this, r103, this.f1897f, r100);
        ((HashMap) this.f1894c).put(r100, r106);
    L16:
        r106.f1898a.setText(r101);
        String r107 = String.valueOf(r102);
        if (r107.length() <= 2) goto L19;
        r107 = r107.charAt(0) + "...";
    L19:
        r106.f1899b.setText(r107);
        View r108 = r106.f1900c;
        if (this.f1897f == r108.getParent()) goto L32;
        this.f1897f.addView(r108);
        if (this.f1896e.isShowing() == true) goto L33;
        Dialog r109 = this.f1896e;
        if (DialogLancet.shouldBlockDialogShow(r109) == false) goto L30;
        DialogLancet.handleBlockedDialogShow(r109);
        return;
    L30:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L29
    L27:
        DialogLancet.beforeDialogShow(r109);
        r109.show();
        DialogLancet.afterDialogShow(r109);
        return;
    L33:
        return;
    }
}
