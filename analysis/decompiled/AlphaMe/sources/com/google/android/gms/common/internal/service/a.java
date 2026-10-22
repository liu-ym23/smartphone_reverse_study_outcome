package com.google.android.gms.common.internal.service;

import Z0.g;
import Z0.h;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import androidx.room.AbstractC0351g;
import com.google.android.gms.common.internal.d;
import com.google.android.gms.common.internal.e;
import k1.C0677a;

/* loaded from: classes.dex */
public final class a extends Z0.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9844a;

    public a(int i4) {
        this.f9844a = i4;
    }

    @Override // Z0.a
    public final e a(Context context, Looper looper, d dVar, Z0.b bVar, g gVar, h hVar) {
        int i4 = this.f9844a;
        switch (i4) {
            case 1:
                Integer num = dVar.f9803i;
                Bundle bundle = new Bundle();
                bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", dVar.f9795a);
                if (num != null) {
                    bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", num.intValue());
                }
                bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", false);
                bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", false);
                bundle.putString("com.google.android.gms.signin.internal.serverClientId", null);
                bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
                bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", false);
                bundle.putString("com.google.android.gms.signin.internal.hostedDomain", null);
                bundle.putString("com.google.android.gms.signin.internal.logSessionId", null);
                bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", false);
                return new C0677a(context, looper, dVar, bundle, gVar, hVar);
            case 2:
                AbstractC0351g.y(bVar);
                throw null;
            default:
                switch (i4) {
                    case 0:
                        return new c(context, looper, dVar, (com.google.android.gms.common.internal.g) bVar, gVar, hVar);
                    default:
                        throw new UnsupportedOperationException("buildClient must be implemented");
                }
        }
    }
}
