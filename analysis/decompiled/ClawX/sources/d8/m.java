package d8;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.security.keystore.KeyGenParameterSpec;
import android.util.AttributeSet;
import android.widget.ImageView;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.ProviderException;
import java.util.Arrays;
import javax.crypto.KeyGenerator;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class m implements p7.w {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2075a;

    /* renamed from: b, reason: collision with root package name */
    public int f2076b;

    /* renamed from: c, reason: collision with root package name */
    public Object f2077c;
    public Object d;

    public /* synthetic */ m() {
        this.f2075a = 0;
    }

    public void a() {
        g.s1 s1Var;
        ImageView imageView = (ImageView) this.f2077c;
        Drawable drawable = imageView.getDrawable();
        if (drawable != null) {
            int i8 = g.n0.f2786a;
        }
        if (drawable == null || (s1Var = (g.s1) this.d) == null) {
            return;
        }
        g.r.d(drawable, s1Var, imageView.getDrawableState());
    }

    public x0.c b() {
        int i8 = this.f2076b;
        if (i8 == 0 && ((KeyGenParameterSpec) this.d) == null) {
            throw new IllegalArgumentException("build() called before setKeyGenParameterSpec or setKeyScheme.");
        }
        if (i8 == 1) {
            this.d = new KeyGenParameterSpec.Builder((String) this.f2077c, 3).setBlockModes("GCM").setEncryptionPaddings("NoPadding").setKeySize(256).build();
        }
        KeyGenParameterSpec keyGenParameterSpec = (KeyGenParameterSpec) this.d;
        if (keyGenParameterSpec == null) {
            throw new NullPointerException("KeyGenParameterSpec was null after build() check");
        }
        Object obj = x0.d.f6248a;
        if (keyGenParameterSpec.getKeySize() != 256) {
            throw new IllegalArgumentException("invalid key size, want 256 bits got " + keyGenParameterSpec.getKeySize() + " bits");
        }
        if (!Arrays.equals(keyGenParameterSpec.getBlockModes(), new String[]{"GCM"})) {
            throw new IllegalArgumentException("invalid block mode, want GCM got " + Arrays.toString(keyGenParameterSpec.getBlockModes()));
        }
        if (keyGenParameterSpec.getPurposes() != 3) {
            throw new IllegalArgumentException("invalid purposes mode, want PURPOSE_ENCRYPT | PURPOSE_DECRYPT got " + keyGenParameterSpec.getPurposes());
        }
        if (!Arrays.equals(keyGenParameterSpec.getEncryptionPaddings(), new String[]{"NoPadding"})) {
            throw new IllegalArgumentException("invalid padding mode, want NoPadding got " + Arrays.toString(keyGenParameterSpec.getEncryptionPaddings()));
        }
        if (keyGenParameterSpec.isUserAuthenticationRequired() && keyGenParameterSpec.getUserAuthenticationValidityDurationSeconds() < 1) {
            throw new IllegalArgumentException("per-operation authentication is not supported (UserAuthenticationValidityDurationSeconds must be >0)");
        }
        synchronized (x0.d.f6248a) {
            String keystoreAlias = keyGenParameterSpec.getKeystoreAlias();
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            if (!keyStore.containsAlias(keystoreAlias)) {
                try {
                    KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", "AndroidKeyStore");
                    keyGenerator.init(keyGenParameterSpec);
                    keyGenerator.generateKey();
                } catch (ProviderException e9) {
                    throw new GeneralSecurityException(e9.getMessage(), e9);
                }
            }
        }
        return new x0.c(keyGenParameterSpec.getKeystoreAlias(), (KeyGenParameterSpec) this.d);
    }

    public void c(AttributeSet attributeSet, int i8) {
        int resourceId;
        ImageView imageView = (ImageView) this.f2077c;
        Context context = imageView.getContext();
        int[] iArr = c.a.f1017e;
        a4.d dVarE = a4.d.E(context, attributeSet, iArr, i8);
        TypedArray typedArray = (TypedArray) dVarE.f97c;
        Context context2 = imageView.getContext();
        TypedArray typedArray2 = (TypedArray) dVarE.f97c;
        int[] iArr2 = e0.a0.f2285a;
        e0.y.b(imageView, context2, iArr, attributeSet, typedArray2, i8, 0);
        try {
            Drawable drawable = imageView.getDrawable();
            if (drawable == null && (resourceId = typedArray.getResourceId(1, -1)) != -1 && (drawable = b8.h.p(imageView.getContext(), resourceId)) != null) {
                imageView.setImageDrawable(drawable);
            }
            if (drawable != null) {
                int i9 = g.n0.f2786a;
            }
            if (typedArray.hasValue(2)) {
                imageView.setImageTintList(dVarE.s(2));
            }
            if (typedArray.hasValue(3)) {
                imageView.setImageTintMode(g.n0.a(typedArray.getInt(3, -1), null));
            }
            dVarE.H();
        } catch (Throwable th) {
            dVarE.H();
            throw th;
        }
    }

    public void d() {
        if (m.f.a(1) != 0) {
            throw new IllegalArgumentException("Unsupported scheme: ".concat("AES256_GCM"));
        }
        if (((KeyGenParameterSpec) this.d) != null) {
            throw new IllegalArgumentException("KeyScheme set after setting a KeyGenParamSpec");
        }
        this.f2076b = 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x010b A[PHI: r14
      0x010b: PHI (r14v6 p7.r) = (r14v4 p7.r), (r14v9 p7.r), (r14v9 p7.r), (r14v9 p7.r), (r14v9 p7.r) binds: [B:44:0x00a7, B:46:0x00b3, B:48:0x00bf, B:50:0x00cb, B:56:0x00d9] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // p7.w
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public p7.x e(p7.x r14) {
        /*
            Method dump skipped, instructions count: 331
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d8.m.e(p7.x):p7.x");
    }

    public String toString() {
        switch (this.f2075a) {
            case 3:
                StringBuilder sb = new StringBuilder();
                if (((n6.r) this.f2077c) == n6.r.f4120c) {
                    sb.append("HTTP/1.0");
                } else {
                    sb.append("HTTP/1.1");
                }
                sb.append(' ');
                sb.append(this.f2076b);
                sb.append(' ');
                sb.append((String) this.d);
                return sb.toString();
            default:
                return super.toString();
        }
    }

    public m(int i8, p7.r rVar, p7.h hVar) {
        this.f2075a = 2;
        this.f2076b = i8;
        this.f2077c = rVar;
        this.d = hVar;
    }

    public m(n6.r rVar, int i8, String str) {
        this.f2075a = 3;
        this.f2077c = rVar;
        this.f2076b = i8;
        this.d = str;
    }

    public m(ImageView imageView) {
        this.f2075a = 1;
        this.f2076b = 0;
        this.f2077c = imageView;
    }

    public m(Context context) {
        this.f2075a = 4;
        context.getApplicationContext();
        this.f2077c = "_androidx_security_master_key_";
    }
}
