package com.google.android.gms.common;

import android.R;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.util.Log;
import android.util.TypedValue;
import android.widget.ProgressBar;
import androidx.core.app.j;
import androidx.fragment.app.r;
import com.autonavi.aps.amapapi.config.Const;
import com.google.android.gms.base.R$drawable;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.internal.InterfaceC1642h;
import com.google.android.gms.common.api.internal.P;
import com.google.android.gms.common.api.internal.Q;
import com.google.android.gms.common.internal.AbstractDialogInterfaceOnClickListenerC1681w;
import com.google.android.gms.common.internal.C1669j;
import com.google.android.gms.common.internal.C1678t;
import com.google.errorprone.annotations.RestrictedInheritance;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import u2.C5570a;
import w2.C5723g;
import w2.InterfaceC5718b;
import w2.InterfaceC5719c;

@RestrictedInheritance(allowedOnPath = ".*java.*/com/google/android/gms.*", allowlistAnnotations = {InterfaceC5718b.class, InterfaceC5719c.class}, explanation = "Sub classing of GMS Core's APIs are restricted to GMS Core client libs and testing fakes.", link = "go/gmscore-restrictedinheritance")
/* loaded from: classes2.dex */
public class b extends c {

    /* renamed from: c, reason: collision with root package name */
    public String f19707c;

    /* renamed from: e, reason: collision with root package name */
    public static final Object f19705e = new Object();

    /* renamed from: f, reason: collision with root package name */
    public static final b f19706f = new b();

    /* renamed from: d, reason: collision with root package name */
    public static final int f19704d = c.f19708a;

    public static b m() {
        return f19706f;
    }

    @Override // com.google.android.gms.common.c
    public Intent b(Context context, int i10, String str) {
        return super.b(context, i10, str);
    }

    @Override // com.google.android.gms.common.c
    public PendingIntent c(Context context, int i10, int i11) {
        return super.c(context, i10, i11);
    }

    @Override // com.google.android.gms.common.c
    public final String e(int i10) {
        return super.e(i10);
    }

    @Override // com.google.android.gms.common.c
    @ResultIgnorabilityUnspecified
    public int g(Context context) {
        return super.g(context);
    }

    @Override // com.google.android.gms.common.c
    public int h(Context context, int i10) {
        return super.h(context, i10);
    }

    @Override // com.google.android.gms.common.c
    public final boolean j(int i10) {
        return super.j(i10);
    }

    public Dialog k(Activity activity, int i10, int i11, DialogInterface.OnCancelListener onCancelListener) {
        return p(activity, i10, AbstractDialogInterfaceOnClickListenerC1681w.b(activity, b(activity, i10, Const.INTENT_KEY_UMID), i11), onCancelListener, null);
    }

    public PendingIntent l(Context context, ConnectionResult connectionResult) {
        return connectionResult.hasResolution() ? connectionResult.getResolution() : c(context, connectionResult.getErrorCode(), 0);
    }

    @ResultIgnorabilityUnspecified
    public boolean n(Activity activity, int i10, int i11, DialogInterface.OnCancelListener onCancelListener) {
        Dialog dialogK = k(activity, i10, i11, onCancelListener);
        if (dialogK == null) {
            return false;
        }
        s(activity, dialogK, "GooglePlayServicesErrorDialog", onCancelListener);
        return true;
    }

    public void o(Context context, int i10) throws Resources.NotFoundException {
        t(context, i10, null, d(context, i10, 0, "n"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Dialog p(Context context, int i10, AbstractDialogInterfaceOnClickListenerC1681w abstractDialogInterfaceOnClickListenerC1681w, DialogInterface.OnCancelListener onCancelListener, DialogInterface.OnClickListener onClickListener) {
        if (i10 == 0) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
        AlertDialog.Builder builder = "Theme.Dialog.Alert".equals(context.getResources().getResourceEntryName(typedValue.resourceId)) ? new AlertDialog.Builder(context, 5) : null;
        if (builder == null) {
            builder = new AlertDialog.Builder(context);
        }
        builder.setMessage(C1678t.c(context, i10));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        String strB = C1678t.b(context, i10);
        if (strB != null) {
            if (abstractDialogInterfaceOnClickListenerC1681w == null) {
                abstractDialogInterfaceOnClickListenerC1681w = onClickListener;
            }
            builder.setPositiveButton(strB, abstractDialogInterfaceOnClickListenerC1681w);
        }
        String strF = C1678t.f(context, i10);
        if (strF != null) {
            builder.setTitle(strF);
        }
        Log.w("GoogleApiAvailability", String.format("Creating dialog for Google Play services availability issue. ConnectionResult=%s", Integer.valueOf(i10)), new IllegalArgumentException());
        return builder.create();
    }

    public final Dialog q(Activity activity, DialogInterface.OnCancelListener onCancelListener) {
        ProgressBar progressBar = new ProgressBar(activity, null, R.attr.progressBarStyleLarge);
        progressBar.setIndeterminate(true);
        progressBar.setVisibility(0);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setView(progressBar);
        builder.setMessage(C1678t.c(activity, 18));
        builder.setPositiveButton("", (DialogInterface.OnClickListener) null);
        AlertDialog alertDialogCreate = builder.create();
        s(activity, alertDialogCreate, "GooglePlayServicesUpdatingDialog", onCancelListener);
        return alertDialogCreate;
    }

    @ResultIgnorabilityUnspecified
    public final Q r(Context context, P p10) {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        Q q10 = new Q(p10);
        C5723g.n(context, q10, intentFilter);
        q10.a(context);
        if (i(context, "com.google.android.gms")) {
            return q10;
        }
        p10.a();
        q10.b();
        return null;
    }

    public final void s(Activity activity, Dialog dialog, String str, DialogInterface.OnCancelListener onCancelListener) {
        try {
            if (activity instanceof r) {
                g.o(dialog, onCancelListener).show(((r) activity).getSupportFragmentManager(), str);
                return;
            }
        } catch (NoClassDefFoundError unused) {
        }
        a.a(dialog, onCancelListener).show(activity.getFragmentManager(), str);
    }

    @TargetApi(20)
    public final void t(Context context, int i10, String str, PendingIntent pendingIntent) throws Resources.NotFoundException {
        int i11;
        String str2;
        Log.w("GoogleApiAvailability", String.format("GMS core API Availability. ConnectionResult=%s, tag=%s", Integer.valueOf(i10), null), new IllegalArgumentException());
        if (i10 == 18) {
            u(context);
            return;
        }
        if (pendingIntent == null) {
            if (i10 == 6) {
                Log.w("GoogleApiAvailability", "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead.");
                return;
            }
            return;
        }
        String strE = C1678t.e(context, i10);
        String strD = C1678t.d(context, i10);
        Resources resources = context.getResources();
        NotificationManager notificationManager = (NotificationManager) C1669j.k(context.getSystemService("notification"));
        j.d dVarQ = new j.d(context).n(true).e(true).j(strE).q(new j.b().h(strD));
        if (s2.f.b(context)) {
            C1669j.n(s2.j.c());
            dVarQ.p(context.getApplicationInfo().icon).o(2);
            if (s2.f.c(context)) {
                dVarQ.a(R$drawable.common_full_open_on_phone, resources.getString(com.google.android.gms.base.R$string.common_open_on_phone), pendingIntent);
            } else {
                dVarQ.h(pendingIntent);
            }
        } else {
            dVarQ.p(R.drawable.stat_sys_warning).r(resources.getString(com.google.android.gms.base.R$string.common_google_play_services_notification_ticker)).s(System.currentTimeMillis()).h(pendingIntent).i(strD);
        }
        if (s2.j.f()) {
            C1669j.n(s2.j.f());
            synchronized (f19705e) {
                str2 = this.f19707c;
            }
            if (str2 == null) {
                str2 = "com.google.android.gms.availability";
                NotificationChannel notificationChannel = notificationManager.getNotificationChannel("com.google.android.gms.availability");
                String string = context.getResources().getString(com.google.android.gms.base.R$string.common_google_play_services_notification_channel_name);
                if (notificationChannel == null) {
                    notificationManager.createNotificationChannel(new NotificationChannel("com.google.android.gms.availability", string, 4));
                } else if (!string.contentEquals(notificationChannel.getName())) {
                    notificationChannel.setName(string);
                    notificationManager.createNotificationChannel(notificationChannel);
                }
            }
            dVarQ.g(str2);
        }
        Notification notificationB = dVarQ.b();
        if (i10 == 1 || i10 == 2 || i10 == 3) {
            e.f19715b.set(false);
            i11 = 10436;
        } else {
            i11 = 39789;
        }
        notificationManager.notify(i11, notificationB);
    }

    public final void u(Context context) {
        new h(this, context).sendEmptyMessageDelayed(1, 120000L);
    }

    @ResultIgnorabilityUnspecified
    public final boolean v(Activity activity, InterfaceC1642h interfaceC1642h, int i10, int i11, DialogInterface.OnCancelListener onCancelListener) {
        Dialog dialogP = p(activity, i10, AbstractDialogInterfaceOnClickListenerC1681w.c(interfaceC1642h, b(activity, i10, Const.INTENT_KEY_UMID), 2), onCancelListener, null);
        if (dialogP == null) {
            return false;
        }
        s(activity, dialogP, "GooglePlayServicesErrorDialog", onCancelListener);
        return true;
    }

    public final boolean w(Context context, ConnectionResult connectionResult, int i10) throws Resources.NotFoundException {
        PendingIntent pendingIntentL;
        if (C5570a.a(context) || (pendingIntentL = l(context, connectionResult)) == null) {
            return false;
        }
        t(context, connectionResult.getErrorCode(), null, PendingIntent.getActivity(context, 0, GoogleApiActivity.a(context, pendingIntentL, i10, true), w2.h.f43051a | 134217728));
        return true;
    }
}
