package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import com.stepos.alphame.R;
import f1.AbstractC0557a;
import f1.C0558b;
import j.C0622a;
import java.util.Locale;

/* loaded from: classes.dex */
public abstract class h {

    /* renamed from: a, reason: collision with root package name */
    public static final q.l f9810a = new q.l();

    /* renamed from: b, reason: collision with root package name */
    public static Locale f9811b;

    public static String a(Context context) {
        String packageName = context.getPackageName();
        try {
            C0622a c0622aA = C0558b.a(context);
            return c0622aA.f13046b.getPackageManager().getApplicationLabel(c0622aA.f13046b.getPackageManager().getApplicationInfo(packageName, 0)).toString();
        } catch (PackageManager.NameNotFoundException | NullPointerException unused) {
            String str = context.getApplicationInfo().name;
            return TextUtils.isEmpty(str) ? packageName : str;
        }
    }

    public static String b(int i4, Context context) {
        Resources resources = context.getResources();
        String strA = a(context);
        if (i4 == 1) {
            return resources.getString(R.string.common_google_play_services_install_text, strA);
        }
        if (i4 == 2) {
            return AbstractC0557a.K(context) ? resources.getString(R.string.common_google_play_services_wear_update_text) : resources.getString(R.string.common_google_play_services_update_text, strA);
        }
        if (i4 == 3) {
            return resources.getString(R.string.common_google_play_services_enable_text, strA);
        }
        if (i4 == 5) {
            return d(context, "common_google_play_services_invalid_account_text", strA);
        }
        if (i4 == 7) {
            return d(context, "common_google_play_services_network_error_text", strA);
        }
        if (i4 == 9) {
            return resources.getString(R.string.common_google_play_services_unsupported_text, strA);
        }
        if (i4 == 20) {
            return d(context, "common_google_play_services_restricted_profile_text", strA);
        }
        switch (i4) {
            case 16:
                return d(context, "common_google_play_services_api_unavailable_text", strA);
            case 17:
                return d(context, "common_google_play_services_sign_in_failed_text", strA);
            case 18:
                return resources.getString(R.string.common_google_play_services_updating_text, strA);
            default:
                return resources.getString(R.string.common_google_play_services_unknown_issue, strA);
        }
    }

    public static String c(int i4, Context context) {
        Resources resources = context.getResources();
        switch (i4) {
            case 1:
                return resources.getString(R.string.common_google_play_services_install_title);
            case 2:
                return resources.getString(R.string.common_google_play_services_update_title);
            case 3:
                return resources.getString(R.string.common_google_play_services_enable_title);
            case 4:
            case 6:
            case 18:
                return null;
            case 5:
                Log.e("GoogleApiAvailability", "An invalid account was specified when connecting. Please provide a valid account.");
                return e(context, "common_google_play_services_invalid_account_title");
            case 7:
                Log.e("GoogleApiAvailability", "Network error occurred. Please retry request later.");
                return e(context, "common_google_play_services_network_error_title");
            case 8:
                Log.e("GoogleApiAvailability", "Internal error occurred. Please see logs for detailed information");
                return null;
            case 9:
                Log.e("GoogleApiAvailability", "Google Play services is invalid. Cannot recover.");
                return null;
            case 10:
                Log.e("GoogleApiAvailability", "Developer error occurred. Please see logs for detailed information");
                return null;
            case 11:
                Log.e("GoogleApiAvailability", "The application is not licensed to the user.");
                return null;
            case 12:
            case 13:
            case 14:
            case 15:
            case 19:
            default:
                Log.e("GoogleApiAvailability", "Unexpected error code " + i4);
                return null;
            case 16:
                Log.e("GoogleApiAvailability", "One of the API components you attempted to connect to is not available.");
                return null;
            case 17:
                Log.e("GoogleApiAvailability", "The specified account could not be signed in.");
                return e(context, "common_google_play_services_sign_in_failed_title");
            case 20:
                Log.e("GoogleApiAvailability", "The current user profile is restricted and could not use authenticated features.");
                return e(context, "common_google_play_services_restricted_profile_title");
        }
    }

    public static String d(Context context, String str, String str2) throws Resources.NotFoundException {
        Resources resources = context.getResources();
        String strE = e(context, str);
        if (strE == null) {
            strE = resources.getString(R.string.common_google_play_services_unknown_issue);
        }
        return String.format(resources.getConfiguration().locale, strE, str2);
    }

    public static String e(Context context, String str) {
        Resources resourcesForApplication;
        q.l lVar = f9810a;
        synchronized (lVar) {
            try {
                Locale locale = G.d.a(context.getResources().getConfiguration()).get(0);
                if (!locale.equals(f9811b)) {
                    lVar.clear();
                    f9811b = locale;
                }
                String str2 = (String) lVar.get(str);
                if (str2 != null) {
                    return str2;
                }
                int i4 = com.google.android.gms.common.d.f9703c;
                try {
                    resourcesForApplication = context.getPackageManager().getResourcesForApplication("com.google.android.gms");
                } catch (PackageManager.NameNotFoundException unused) {
                    resourcesForApplication = null;
                }
                if (resourcesForApplication == null) {
                    return null;
                }
                int identifier = resourcesForApplication.getIdentifier(str, "string", "com.google.android.gms");
                if (identifier == 0) {
                    Log.w("GoogleApiAvailability", "Missing resource: ".concat(str));
                    return null;
                }
                String string = resourcesForApplication.getString(identifier);
                if (TextUtils.isEmpty(string)) {
                    Log.w("GoogleApiAvailability", "Got empty resource: ".concat(str));
                    return null;
                }
                f9810a.put(str, string);
                return string;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
