package c6;

import android.util.Log;
import b6.i;
import com.stepos.core.cta.CTAPermissionManager;
import com.stepos.core.cta.CtaGate;
import com.stepos.core.cta.CtaGatedInitializer;
import com.stepos.policy.sdk.PolicySdk;
import kotlin.Result;
import lb.n;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: b, reason: collision with root package name */
    public static volatile boolean f3294b;

    /* renamed from: a, reason: collision with root package name */
    public static final d f3293a = new d();

    /* renamed from: c, reason: collision with root package name */
    public static final CtaGatedInitializer f3295c = new CtaGatedInitializer("policy-sdk-network-gate", CtaGate.CTA_ONLY, new i(3), new b6.e(2), null, 16, null);

    public static void a() {
        Object objA;
        boolean z = !CTAPermissionManager.INSTANCE.hasCTAPermission();
        try {
            PolicySdk.setBlockNetworkBeforeAgree(z);
            objA = n.f10413a;
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        Throwable thB = Result.b(objA);
        if (thB != null) {
            Log.w("PolicySdkBootstrap", "setBlockNetworkBeforeAgree failed (non-fatal)", thB);
        }
        Log.i("PolicySdkBootstrap", "policy sdk network gate: blockBeforeAgree=" + z);
    }
}
