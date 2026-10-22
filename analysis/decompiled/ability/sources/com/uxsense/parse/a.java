package com.uxsense.parse;

import F9.C0233k;
import F9.E;
import android.util.Log;
import java.util.concurrent.TimeUnit;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.jvm.internal.k;
import n4.AbstractC1740a;

/* loaded from: classes3.dex */
public final /* synthetic */ class a implements S7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4205a;

    public /* synthetic */ a(int i) {
        this.f4205a = i;
    }

    @Override // S7.a
    public final Object invoke() {
        switch (this.f4205a) {
            case 14:
                com.zyql.agentfront.sdk.client.b.f4243s.getClass();
                Log.d("AgentFrontClient", "[API] setPushMessageListener: service connected, listener registered");
                break;
            case 20:
                E e = new E();
                TimeUnit timeUnit = TimeUnit.SECONDS;
                e.b(15L, timeUnit);
                e.c(30L, timeUnit);
                e.e(15L, timeUnit);
                e.b = new C0233k(5, 5L, TimeUnit.MINUTES);
                e.f = true;
                break;
            case 28:
                byte[] bArr = AbstractC1740a.f5347a;
                try {
                    byte[] bArrA = AbstractC1740a.a();
                    Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
                    cipher.init(2, new SecretKeySpec(bArrA, "AES"), new GCMParameterSpec(128, bArr, 0, 12));
                    byte[] bArrDoFinal = cipher.doFinal(bArr, 12, 26);
                    k.e(bArrDoFinal, "doFinal(...)");
                    break;
                } catch (Throwable th) {
                    Log.e("ApiConfigs", "decrypt APP_SECRET failed (repack or wrong signature?): " + th.getMessage());
                    return "";
                }
        }
        return "";
    }
}
