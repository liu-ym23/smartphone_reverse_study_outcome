package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class r {

    /* renamed from: e, reason: collision with root package name */
    public static final Uri f9832e = new Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").build();

    /* renamed from: a, reason: collision with root package name */
    public final String f9833a;

    /* renamed from: b, reason: collision with root package name */
    public final String f9834b;

    /* renamed from: c, reason: collision with root package name */
    public final int f9835c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f9836d;

    public r(String str, String str2, int i4, boolean z4) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Given String is empty or null");
        }
        this.f9833a = str;
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("Given String is empty or null");
        }
        this.f9834b = str2;
        this.f9835c = i4;
        this.f9836d = z4;
    }

    public final Intent a(Context context) {
        Bundle bundleCall;
        String str = this.f9833a;
        if (str == null) {
            return new Intent().setComponent(null);
        }
        if (this.f9836d) {
            Bundle bundle = new Bundle();
            bundle.putString("serviceActionBundleKey", str);
            try {
                bundleCall = context.getContentResolver().call(f9832e, "serviceIntentCall", (String) null, bundle);
            } catch (IllegalArgumentException e4) {
                Log.w("ConnectionStatusConfig", "Dynamic intent resolution failed: ".concat(e4.toString()));
                bundleCall = null;
            }
            intent = bundleCall != null ? (Intent) bundleCall.getParcelable("serviceResponseIntentKey") : null;
            if (intent == null) {
                Log.w("ConnectionStatusConfig", "Dynamic lookup for intent failed for action: ".concat(String.valueOf(str)));
            }
        }
        return intent != null ? intent : new Intent(str).setPackage(this.f9834b);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        return com.airbnb.lottie.h.m(this.f9833a, rVar.f9833a) && com.airbnb.lottie.h.m(this.f9834b, rVar.f9834b) && com.airbnb.lottie.h.m(null, null) && this.f9835c == rVar.f9835c && this.f9836d == rVar.f9836d;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f9833a, this.f9834b, null, Integer.valueOf(this.f9835c), Boolean.valueOf(this.f9836d)});
    }

    public final String toString() {
        String str = this.f9833a;
        if (str != null) {
            return str;
        }
        com.stepos.statsrpk.c.l(null);
        throw null;
    }
}
