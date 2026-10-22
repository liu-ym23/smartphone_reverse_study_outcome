package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.stepos.ame.sdk.SkillStoreKt;

/* loaded from: classes2.dex */
public final class U {

    /* renamed from: f, reason: collision with root package name */
    public static final Uri f19748f = new Uri.Builder().scheme(SkillStoreKt.SKILL_DOC_TYPE_CONTENT).authority("com.google.android.gms.chimera").build();

    /* renamed from: a, reason: collision with root package name */
    public final String f19749a;

    /* renamed from: b, reason: collision with root package name */
    public final String f19750b;

    /* renamed from: c, reason: collision with root package name */
    public final ComponentName f19751c;

    /* renamed from: d, reason: collision with root package name */
    public final int f19752d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f19753e;

    public U(String str, String str2, int i10, boolean z10) {
        C1669j.e(str);
        this.f19749a = str;
        C1669j.e(str2);
        this.f19750b = str2;
        this.f19751c = null;
        this.f19752d = 4225;
        this.f19753e = z10;
    }

    public final ComponentName a() {
        return this.f19751c;
    }

    public final Intent b(Context context) {
        Bundle bundleCall;
        if (this.f19749a == null) {
            return new Intent().setComponent(this.f19751c);
        }
        if (this.f19753e) {
            Bundle bundle = new Bundle();
            bundle.putString("serviceActionBundleKey", this.f19749a);
            try {
                bundleCall = context.getContentResolver().call(f19748f, "serviceIntentCall", (String) null, bundle);
            } catch (IllegalArgumentException e10) {
                Log.w("ConnectionStatusConfig", "Dynamic intent resolution failed: ".concat(e10.toString()));
                bundleCall = null;
            }
            intent = bundleCall != null ? (Intent) bundleCall.getParcelable("serviceResponseIntentKey") : null;
            if (intent == null) {
                Log.w("ConnectionStatusConfig", "Dynamic lookup for intent failed for action: ".concat(String.valueOf(this.f19749a)));
            }
        }
        return intent == null ? new Intent(this.f19749a).setPackage(this.f19750b) : intent;
    }

    public final String c() {
        return this.f19750b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof U)) {
            return false;
        }
        U u10 = (U) obj;
        return C1668i.a(this.f19749a, u10.f19749a) && C1668i.a(this.f19750b, u10.f19750b) && C1668i.a(this.f19751c, u10.f19751c) && this.f19753e == u10.f19753e;
    }

    public final int hashCode() {
        return C1668i.b(this.f19749a, this.f19750b, this.f19751c, 4225, Boolean.valueOf(this.f19753e));
    }

    public final String toString() {
        String str = this.f19749a;
        if (str != null) {
            return str;
        }
        C1669j.k(this.f19751c);
        return this.f19751c.flattenToString();
    }
}
