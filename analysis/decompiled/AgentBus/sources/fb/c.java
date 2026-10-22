package fb;

import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import g7.i;
import h4.m;
import j1.l1;
import j1.s0;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Random;
import javax.crypto.Cipher;

/* loaded from: classes.dex */
public final class c extends ThreadLocal {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3647a;

    public /* synthetic */ c(int i2) {
        this.f3647a = i2;
    }

    @Override // java.lang.ThreadLocal
    public final Object initialValue() {
        switch (this.f3647a) {
            case 0:
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
                simpleDateFormat.setLenient(false);
                simpleDateFormat.setTimeZone(bb.b.f1663e);
                return simpleDateFormat;
            case 1:
                try {
                    return (Cipher) m.f4149b.f4151a.a("AES/CTR/NoPadding");
                } catch (GeneralSecurityException e10) {
                    throw new IllegalStateException(e10);
                }
            case 2:
                try {
                    return (Cipher) m.f4149b.f4151a.a("AES/ECB/NOPADDING");
                } catch (GeneralSecurityException e11) {
                    throw new IllegalStateException(e11);
                }
            case 3:
                try {
                    return (Cipher) m.f4149b.f4151a.a("AES/CTR/NOPADDING");
                } catch (GeneralSecurityException e12) {
                    throw new IllegalStateException(e12);
                }
            case 4:
                SecureRandom secureRandom = new SecureRandom();
                secureRandom.nextLong();
                return secureRandom;
            case 5:
                try {
                    return MessageDigest.getInstance("MD5");
                } catch (NoSuchAlgorithmException unused) {
                    throw new IllegalStateException("no md5 algorythm found");
                }
            case 6:
                Choreographer choreographer = Choreographer.getInstance();
                Looper looperMyLooper = Looper.myLooper();
                if (looperMyLooper == null) {
                    throw new IllegalStateException("no Looper on this thread");
                }
                s0 s0Var = new s0(choreographer, Handler.createAsync(looperMyLooper));
                return i.plus(s0Var, s0Var.f5323q);
            case 7:
                return new l1();
            case 8:
                return new Random();
            case 9:
                try {
                    return (Cipher) m.f4149b.f4151a.a("AES/GCM/NoPadding");
                } catch (GeneralSecurityException e13) {
                    throw new IllegalStateException(e13);
                }
            default:
                try {
                    return (Cipher) m.f4149b.f4151a.a("AES/GCM-SIV/NoPadding");
                } catch (GeneralSecurityException e14) {
                    throw new IllegalStateException(e14);
                }
        }
    }
}
