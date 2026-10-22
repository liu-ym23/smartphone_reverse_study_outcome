package a2;

import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Random;
import javax.crypto.Cipher;
import l2.i;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class b extends ThreadLocal {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f80a;

    @Override // java.lang.ThreadLocal
    public final Object initialValue() {
        switch (this.f80a) {
            case 0:
                try {
                    return (Cipher) i.f3785b.f3787a.a("AES/GCM/NoPadding");
                } catch (GeneralSecurityException e9) {
                    throw new IllegalStateException(e9);
                }
            case 1:
                try {
                    return (Cipher) i.f3785b.f3787a.a("AES/GCM-SIV/NoPadding");
                } catch (GeneralSecurityException e10) {
                    throw new IllegalStateException(e10);
                }
            case 2:
                try {
                    return (Cipher) i.f3785b.f3787a.a("AES/CTR/NoPadding");
                } catch (GeneralSecurityException e11) {
                    throw new IllegalStateException(e11);
                }
            case 3:
                try {
                    return (Cipher) i.f3785b.f3787a.a("AES/ECB/NOPADDING");
                } catch (GeneralSecurityException e12) {
                    throw new IllegalStateException(e12);
                }
            case 4:
                try {
                    return (Cipher) i.f3785b.f3787a.a("AES/CTR/NOPADDING");
                } catch (GeneralSecurityException e13) {
                    throw new IllegalStateException(e13);
                }
            case 5:
                SecureRandom secureRandom = new SecureRandom();
                secureRandom.nextLong();
                return secureRandom;
            case 6:
                return new Random();
            default:
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
                simpleDateFormat.setLenient(false);
                simpleDateFormat.setTimeZone(o6.f.f4330a);
                return simpleDateFormat;
        }
    }
}
