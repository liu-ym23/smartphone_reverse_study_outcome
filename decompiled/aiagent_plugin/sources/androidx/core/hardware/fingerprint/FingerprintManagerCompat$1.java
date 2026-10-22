package androidx.core.hardware.fingerprint;

import android.hardware.fingerprint.FingerprintManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
class FingerprintManagerCompat$1 extends FingerprintManager.AuthenticationCallback {
    final /* synthetic */ a.b val$callback;

    FingerprintManagerCompat$1(a.b r1) {
        this.val$callback = r1;
    }

    @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
    public void onAuthenticationError(int r3, CharSequence r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.aiagent.plugin");
        this.val$callback.a(r3, r5);
    }

    @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
    public void onAuthenticationHelp(int r3, CharSequence r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.aiagent.plugin");
        this.val$callback.b(r3, r5);
    }

    @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
    public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult r2) {
        this.val$callback.a(new a.c(a.a(a.C0029a.c(r2))));
    }

    @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
    public void onAuthenticationFailed() {
        this.val$callback.a();
    }
}
