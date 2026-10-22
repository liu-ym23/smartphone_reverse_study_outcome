package com.google.android.gms.common;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.FragmentManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import androidx.core.app.m;
import androidx.core.app.n;
import androidx.core.app.o;
import androidx.core.app.p;
import androidx.core.app.q;
import androidx.core.app.r;
import androidx.core.app.s;
import androidx.core.app.t;
import androidx.core.app.u;
import androidx.core.app.v;
import androidx.core.app.w;
import androidx.core.app.x;
import androidx.core.graphics.drawable.IconCompat;
import androidx.fragment.app.G;
import androidx.fragment.app.Y;
import androidx.room.AbstractC0351g;
import ch.qos.logback.core.rolling.helper.DateTokenConverter;
import com.google.android.gms.common.api.internal.l;
import f1.AbstractC0557a;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class b extends c {

    /* renamed from: b, reason: collision with root package name */
    public static final Object f9700b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public static final b f9701c = new b();

    public static AlertDialog d(Context context, int i4, com.google.android.gms.common.internal.k kVar, DialogInterface.OnCancelListener onCancelListener) {
        if (i4 == 0) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
        AlertDialog.Builder builder = "Theme.Dialog.Alert".equals(context.getResources().getResourceEntryName(typedValue.resourceId)) ? new AlertDialog.Builder(context, 5) : null;
        if (builder == null) {
            builder = new AlertDialog.Builder(context);
        }
        builder.setMessage(com.google.android.gms.common.internal.h.b(i4, context));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        Resources resources = context.getResources();
        String string = i4 != 1 ? i4 != 2 ? i4 != 3 ? resources.getString(R.string.ok) : resources.getString(com.stepos.alphame.R.string.common_google_play_services_enable_button) : resources.getString(com.stepos.alphame.R.string.common_google_play_services_update_button) : resources.getString(com.stepos.alphame.R.string.common_google_play_services_install_button);
        if (string != null) {
            builder.setPositiveButton(string, kVar);
        }
        String strC = com.google.android.gms.common.internal.h.c(i4, context);
        if (strC != null) {
            builder.setTitle(strC);
        }
        Log.w("GoogleApiAvailability", AbstractC0351g.m("Creating dialog for Google Play services availability issue. ConnectionResult=", i4), new IllegalArgumentException());
        return builder.create();
    }

    public static void e(Activity activity, AlertDialog alertDialog, String str, DialogInterface.OnCancelListener onCancelListener) {
        try {
            if (activity instanceof G) {
                Y supportFragmentManager = ((G) activity).getSupportFragmentManager();
                g gVar = new g();
                com.stepos.statsrpk.c.m(alertDialog, "Cannot display null dialog");
                alertDialog.setOnCancelListener(null);
                alertDialog.setOnDismissListener(null);
                gVar.f9719q = alertDialog;
                if (onCancelListener != null) {
                    gVar.f9720r = onCancelListener;
                }
                gVar.i(supportFragmentManager, str);
                return;
            }
        } catch (NoClassDefFoundError unused) {
        }
        FragmentManager fragmentManager = activity.getFragmentManager();
        a aVar = new a();
        com.stepos.statsrpk.c.m(alertDialog, "Cannot display null dialog");
        alertDialog.setOnCancelListener(null);
        alertDialog.setOnDismissListener(null);
        aVar.f9604a = alertDialog;
        if (onCancelListener != null) {
            aVar.f9605b = onCancelListener;
        }
        aVar.show(fragmentManager, str);
    }

    @Override // com.google.android.gms.common.c
    public final Intent a(Context context, String str, int i4) {
        return super.a(context, str, i4);
    }

    @Override // com.google.android.gms.common.c
    public final int b(int i4, Context context) {
        return super.b(i4, context);
    }

    public final void c(Activity activity, int i4, DialogInterface.OnCancelListener onCancelListener) {
        AlertDialog alertDialogD = d(activity, i4, new com.google.android.gms.common.internal.i(activity, super.a(activity, DateTokenConverter.CONVERTER_KEY, i4)), onCancelListener);
        if (alertDialogD == null) {
            return;
        }
        e(activity, alertDialogD, "GooglePlayServicesErrorDialog", onCancelListener);
    }

    public final void f(Context context, int i4, PendingIntent pendingIntent) throws Resources.NotFoundException {
        int i5;
        Bundle bundle;
        ArrayList arrayList;
        int iB;
        int i6;
        int i7;
        Log.w("GoogleApiAvailability", B0.g.j("GMS core API Availability. ConnectionResult=", i4, ", tag=null"), new IllegalArgumentException());
        if (i4 == 18) {
            new h(this, context).sendEmptyMessageDelayed(1, 120000L);
            return;
        }
        if (pendingIntent == null) {
            if (i4 == 6) {
                Log.w("GoogleApiAvailability", "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead.");
                return;
            }
            return;
        }
        String strE = i4 == 6 ? com.google.android.gms.common.internal.h.e(context, "common_google_play_services_resolution_required_title") : com.google.android.gms.common.internal.h.c(i4, context);
        if (strE == null) {
            strE = context.getResources().getString(com.stepos.alphame.R.string.common_google_play_services_notification_ticker);
        }
        String strD = (i4 == 6 || i4 == 19) ? com.google.android.gms.common.internal.h.d(context, "common_google_play_services_resolution_required_text", com.google.android.gms.common.internal.h.a(context)) : com.google.android.gms.common.internal.h.b(i4, context);
        Resources resources = context.getResources();
        Object systemService = context.getSystemService("notification");
        com.stepos.statsrpk.c.l(systemService);
        NotificationManager notificationManager = (NotificationManager) systemService;
        o oVar = new o();
        ArrayList arrayList2 = new ArrayList();
        oVar.f3295b = arrayList2;
        oVar.f3296c = new ArrayList();
        oVar.f3297d = new ArrayList();
        oVar.f3302i = true;
        oVar.f3304k = false;
        Notification notification = new Notification();
        oVar.f3308o = notification;
        oVar.f3294a = context;
        oVar.f3306m = null;
        notification.when = System.currentTimeMillis();
        notification.audioStreamType = -1;
        oVar.f3301h = 0;
        oVar.f3309p = new ArrayList();
        oVar.f3307n = true;
        oVar.f3304k = true;
        notification.flags |= 16;
        oVar.f3298e = o.a(strE);
        n nVar = new n();
        nVar.f3293b = o.a(strD);
        oVar.b(nVar);
        PackageManager packageManager = context.getPackageManager();
        if (AbstractC0557a.f12519c == null) {
            AbstractC0557a.f12519c = Boolean.valueOf(packageManager.hasSystemFeature("android.hardware.type.watch"));
        }
        if (AbstractC0557a.f12519c.booleanValue()) {
            notification.icon = context.getApplicationInfo().icon;
            oVar.f3301h = 2;
            if (AbstractC0557a.K(context)) {
                arrayList2.add(new m(resources.getString(com.stepos.alphame.R.string.common_open_on_phone), pendingIntent));
            } else {
                oVar.f3300g = pendingIntent;
            }
        } else {
            notification.icon = R.drawable.stat_sys_warning;
            notification.tickerText = o.a(resources.getString(com.stepos.alphame.R.string.common_google_play_services_notification_ticker));
            notification.when = System.currentTimeMillis();
            oVar.f3300g = pendingIntent;
            oVar.f3299f = o.a(strD);
        }
        synchronized (f9700b) {
        }
        NotificationChannel notificationChannel = notificationManager.getNotificationChannel("com.google.android.gms.availability");
        String string = context.getResources().getString(com.stepos.alphame.R.string.common_google_play_services_notification_channel_name);
        if (notificationChannel == null) {
            notificationManager.createNotificationChannel(new NotificationChannel("com.google.android.gms.availability", string, 4));
        } else if (!string.contentEquals(notificationChannel.getName())) {
            notificationChannel.setName(string);
            notificationManager.createNotificationChannel(notificationChannel);
        }
        oVar.f3306m = "com.google.android.gms.availability";
        new ArrayList();
        Bundle bundle2 = new Bundle();
        Notification.Builder builderA = u.a(oVar.f3294a, oVar.f3306m);
        Notification notification2 = oVar.f3308o;
        builderA.setWhen(notification2.when).setSmallIcon(notification2.icon, notification2.iconLevel).setContent(notification2.contentView).setTicker(notification2.tickerText, null).setVibrate(notification2.vibrate).setLights(notification2.ledARGB, notification2.ledOnMS, notification2.ledOffMS).setOngoing((notification2.flags & 2) != 0).setOnlyAlertOnce((notification2.flags & 8) != 0).setAutoCancel((notification2.flags & 16) != 0).setDefaults(notification2.defaults).setContentTitle(oVar.f3298e).setContentText(oVar.f3299f).setContentInfo(null).setContentIntent(oVar.f3300g).setDeleteIntent(notification2.deleteIntent).setFullScreenIntent(null, (notification2.flags & 128) != 0).setNumber(0).setProgress(0, 0, false);
        s.b(builderA, null);
        builderA.setSubText(null).setUsesChronometer(false).setPriority(oVar.f3301h);
        Iterator it = oVar.f3295b.iterator();
        while (it.hasNext()) {
            m mVar = (m) it.next();
            if (mVar.f3287b == null && (i7 = mVar.f3290e) != 0) {
                mVar.f3287b = IconCompat.a(i7);
            }
            IconCompat iconCompat = mVar.f3287b;
            Notification.Action.Builder builderA2 = s.a(iconCompat != null ? E.c.c(iconCompat, null) : null, mVar.f3291f, mVar.f3292g);
            Bundle bundle3 = mVar.f3286a;
            Bundle bundle4 = bundle3 != null ? new Bundle(bundle3) : new Bundle();
            boolean z4 = mVar.f3288c;
            bundle4.putBoolean("android.support.allowGeneratedReplies", z4);
            t.a(builderA2, z4);
            bundle4.putInt("android.support.action.semanticAction", 0);
            v.b(builderA2, 0);
            w.c(builderA2, false);
            x.a(builderA2, false);
            bundle4.putBoolean("android.support.action.showsUserInterface", mVar.f3289d);
            q.b(builderA2, bundle4);
            q.a(builderA, q.d(builderA2));
        }
        Bundle bundle5 = oVar.f3305l;
        if (bundle5 != null) {
            bundle2.putAll(bundle5);
        }
        builderA.setShowWhen(oVar.f3302i);
        q.i(builderA, oVar.f3304k);
        q.g(builderA, null);
        q.j(builderA, null);
        q.h(builderA, false);
        r.b(builderA, null);
        r.c(builderA, 0);
        r.f(builderA, 0);
        r.d(builderA, null);
        r.e(builderA, notification2.sound, notification2.audioAttributes);
        ArrayList arrayList3 = oVar.f3309p;
        if (arrayList3 != null && !arrayList3.isEmpty()) {
            Iterator it2 = arrayList3.iterator();
            while (it2.hasNext()) {
                r.a(builderA, (String) it2.next());
            }
        }
        ArrayList arrayList4 = oVar.f3297d;
        if (arrayList4.size() > 0) {
            if (oVar.f3305l == null) {
                oVar.f3305l = new Bundle();
            }
            Bundle bundle6 = oVar.f3305l.getBundle("android.car.EXTENSIONS");
            if (bundle6 == null) {
                bundle6 = new Bundle();
            }
            Bundle bundle7 = new Bundle(bundle6);
            Bundle bundle8 = new Bundle();
            int i8 = 0;
            while (i8 < arrayList4.size()) {
                String string2 = Integer.toString(i8);
                m mVar2 = (m) arrayList4.get(i8);
                Bundle bundle9 = new Bundle();
                if (mVar2.f3287b == null && (i6 = mVar2.f3290e) != 0) {
                    mVar2.f3287b = IconCompat.a(i6);
                }
                IconCompat iconCompat2 = mVar2.f3287b;
                if (iconCompat2 != null) {
                    iB = iconCompat2.b();
                    arrayList = arrayList4;
                } else {
                    arrayList = arrayList4;
                    iB = 0;
                }
                bundle9.putInt("icon", iB);
                bundle9.putCharSequence("title", mVar2.f3291f);
                bundle9.putParcelable("actionIntent", mVar2.f3292g);
                Bundle bundle10 = mVar2.f3286a;
                Bundle bundle11 = bundle10 != null ? new Bundle(bundle10) : new Bundle();
                bundle11.putBoolean("android.support.allowGeneratedReplies", mVar2.f3288c);
                bundle9.putBundle("extras", bundle11);
                bundle9.putParcelableArray("remoteInputs", null);
                bundle9.putBoolean("showsUserInterface", mVar2.f3289d);
                bundle9.putInt("semanticAction", 0);
                bundle8.putBundle(string2, bundle9);
                i8++;
                arrayList4 = arrayList;
            }
            bundle6.putBundle("invisible_actions", bundle8);
            bundle7.putBundle("invisible_actions", bundle8);
            if (oVar.f3305l == null) {
                oVar.f3305l = new Bundle();
            }
            oVar.f3305l.putBundle("android.car.EXTENSIONS", bundle6);
            bundle2.putBundle("android.car.EXTENSIONS", bundle7);
        }
        builderA.setExtras(oVar.f3305l);
        t.e(builderA, null);
        u.b(builderA, 0);
        u.e(builderA, null);
        u.f(builderA, null);
        u.g(builderA, 0L);
        u.d(builderA, 0);
        if (!TextUtils.isEmpty(oVar.f3306m)) {
            builderA.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
        }
        Iterator it3 = oVar.f3296c.iterator();
        if (it3.hasNext()) {
            B0.g.y(it3.next());
            throw null;
        }
        w.a(builderA, oVar.f3307n);
        w.b(builderA, null);
        p pVar = oVar.f3303j;
        if (pVar != null) {
            new Notification.BigTextStyle(builderA).setBigContentTitle(null).bigText(((n) pVar).f3293b);
        }
        Notification notificationBuild = builderA.build();
        if (pVar != null) {
            oVar.f3303j.getClass();
        }
        if (pVar != null && (bundle = notificationBuild.extras) != null) {
            bundle.putString("androidx.core.app.extra.COMPAT_TEMPLATE", "androidx.core.app.NotificationCompat$BigTextStyle");
        }
        if (i4 == 1 || i4 == 2 || i4 == 3) {
            e.f9716a.set(false);
            i5 = 10436;
        } else {
            i5 = 39789;
        }
        notificationManager.notify(i5, notificationBuild);
    }

    public final void g(Activity activity, com.google.android.gms.common.api.internal.g gVar, int i4, l lVar) {
        AlertDialog alertDialogD = d(activity, i4, new com.google.android.gms.common.internal.j(super.a(activity, DateTokenConverter.CONVERTER_KEY, i4), gVar), lVar);
        if (alertDialogD == null) {
            return;
        }
        e(activity, alertDialogD, "GooglePlayServicesErrorDialog", lVar);
    }
}
