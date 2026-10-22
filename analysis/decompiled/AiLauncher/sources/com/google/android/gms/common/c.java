package com.google.android.gms.common;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import u2.C5572c;

/* loaded from: classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static final int f19708a = e.f19714a;

    /* renamed from: b, reason: collision with root package name */
    public static final c f19709b = new c();

    public static c f() {
        return f19709b;
    }

    public int a(Context context) {
        return e.a(context);
    }

    public Intent b(Context context, int i10, String str) {
        if (i10 != 1 && i10 != 2) {
            if (i10 != 3) {
                return null;
            }
            Uri uriFromParts = Uri.fromParts("package", "com.google.android.gms", null);
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(uriFromParts);
            return intent;
        }
        if (context != null && s2.f.c(context)) {
            Intent intent2 = new Intent("com.google.android.clockwork.home.UPDATE_ANDROID_WEAR_ACTION");
            intent2.setPackage("com.google.android.wearable.app");
            return intent2;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("gcore_");
        sb2.append(f19708a);
        sb2.append(O6.l.DATE_SEPARATOR);
        if (!TextUtils.isEmpty(str)) {
            sb2.append(str);
        }
        sb2.append(O6.l.DATE_SEPARATOR);
        if (context != null) {
            sb2.append(context.getPackageName());
        }
        sb2.append(O6.l.DATE_SEPARATOR);
        if (context != null) {
            try {
                sb2.append(C5572c.a(context).c(context.getPackageName(), 0).versionCode);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        String string = sb2.toString();
        Intent intent3 = new Intent("android.intent.action.VIEW");
        Uri.Builder builderAppendQueryParameter = Uri.parse("market://details").buildUpon().appendQueryParameter("id", "com.google.android.gms");
        if (!TextUtils.isEmpty(string)) {
            builderAppendQueryParameter.appendQueryParameter("pcampaignid", string);
        }
        intent3.setData(builderAppendQueryParameter.build());
        intent3.setPackage("com.android.vending");
        intent3.addFlags(524288);
        return intent3;
    }

    public PendingIntent c(Context context, int i10, int i11) {
        return d(context, i10, i11, null);
    }

    public PendingIntent d(Context context, int i10, int i11, String str) {
        Intent intentB = b(context, i10, str);
        if (intentB == null) {
            return null;
        }
        return PendingIntent.getActivity(context, i11, intentB, x2.b.f43472a | 134217728);
    }

    public String e(int i10) {
        return e.b(i10);
    }

    @ResultIgnorabilityUnspecified
    public int g(Context context) {
        return h(context, f19708a);
    }

    public int h(Context context, int i10) throws PackageManager.NameNotFoundException {
        int iD = e.d(context, i10);
        if (e.e(context, iD)) {
            return 18;
        }
        return iD;
    }

    public boolean i(Context context, String str) {
        return e.h(context, str);
    }

    public boolean j(int i10) {
        return e.g(i10);
    }
}
