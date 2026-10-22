package androidx.core.hardware.fingerprint;

import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

/* JADX INFO: compiled from: FingerprintManagerCompat.java */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class a {

    /* JADX INFO: renamed from: androidx.core.hardware.fingerprint.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: FingerprintManagerCompat.java */
    static class C0029a {
        static boolean a(Object r2) {
            return ((FingerprintManager) ZeusTransformUtils.preCheckCast(r2, FingerprintManager.class, "com.obric.aiagent.plugin")).hasEnrolledFingerprints();
        }

        static boolean b(Object r2) {
            return ((FingerprintManager) ZeusTransformUtils.preCheckCast(r2, FingerprintManager.class, "com.obric.aiagent.plugin")).isHardwareDetected();
        }

        static void a(Object r8, Object r9, CancellationSignal r10, int r11, Object r12, Handler r13) {
            ((FingerprintManager) ZeusTransformUtils.preCheckCast(r8, FingerprintManager.class, "com.obric.aiagent.plugin")).authenticate((FingerprintManager.CryptoObject) ZeusTransformUtils.preCheckCast(r9, FingerprintManager.CryptoObject.class, "com.obric.aiagent.plugin"), r10, r11, (FingerprintManager.AuthenticationCallback) ZeusTransformUtils.preCheckCast(r12, FingerprintManager.AuthenticationCallback.class, "com.obric.aiagent.plugin"), r13);
        }

        static FingerprintManager.CryptoObject c(Object r2) {
            return ((FingerprintManager.AuthenticationResult) ZeusTransformUtils.preCheckCast(r2, FingerprintManager.AuthenticationResult.class, "com.obric.aiagent.plugin")).getCryptoObject();
        }

        public static FingerprintManager a(Context r3) {
            Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            if (Build.VERSION.SDK_INT != 23) goto L7;
            return (FingerprintManager) ZeusTransformUtils.preCheckCast(r4.getSystemService(FingerprintManager.class), FingerprintManager.class, "com.obric.aiagent.plugin");
        L7:
            if (Build.VERSION.SDK_INT > 23) goto L9;
            return null;
        L9:
            if (r4.getPackageManager().hasSystemFeature("android.hardware.fingerprint") == true) goto L11;
            return null;
        L11:
            return (FingerprintManager) ZeusTransformUtils.preCheckCast(r4.getSystemService(FingerprintManager.class), FingerprintManager.class, "com.obric.aiagent.plugin");
        }

        public static FingerprintManager.CryptoObject a(d r2) {
            if (r2 != null) goto L6;
            return null;
        L6:
            if (r2.b() == null) goto L10;
            return new FingerprintManager.CryptoObject(r2.b());
        L10:
            if (r2.a() == null) goto L14;
            return new FingerprintManager.CryptoObject(r2.a());
        L14:
            if (r2.c() != null) goto L16;
            return null;
        L16:
            return new FingerprintManager.CryptoObject(r2.c());
        }

        public static d d(Object r2) {
            FingerprintManager.CryptoObject r3 = (FingerprintManager.CryptoObject) ZeusTransformUtils.preCheckCast(r2, FingerprintManager.CryptoObject.class, "com.obric.aiagent.plugin");
            if (r3 != null) goto L6;
            return null;
        L6:
            if (r3.getCipher() == null) goto L10;
            return new d(r3.getCipher());
        L10:
            if (r3.getSignature() == null) goto L14;
            return new d(r3.getSignature());
        L14:
            if (r3.getMac() != null) goto L16;
            return null;
        L16:
            return new d(r3.getMac());
        }
    }

    /* JADX INFO: compiled from: FingerprintManagerCompat.java */
    public static abstract class b {
        public void a() {
        }

        public void a(int r1, CharSequence r2) {
            CharSequence r0 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.aiagent.plugin");
        }

        public void a(c r1) {
        }

        public void b(int r1, CharSequence r2) {
            CharSequence r0 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: FingerprintManagerCompat.java */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final d f1239a;

        public c(d r1) {
            this.f1239a = r1;
        }
    }

    /* JADX INFO: compiled from: FingerprintManagerCompat.java */
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Signature f1240a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Cipher f1241b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Mac f1242c;

        public d(Signature r1) {
            this.f1240a = r1;
            this.f1241b = null;
            this.f1242c = null;
        }

        public d(Cipher r1) {
            this.f1241b = r1;
            this.f1240a = null;
            this.f1242c = null;
        }

        public d(Mac r1) {
            this.f1242c = r1;
            this.f1241b = null;
            this.f1240a = null;
        }

        public Signature a() {
            return this.f1240a;
        }

        public Cipher b() {
            return this.f1241b;
        }

        public Mac c() {
            return this.f1242c;
        }
    }

    static d a(FingerprintManager.CryptoObject r0) {
        return C0029a.d(r0);
    }
}
