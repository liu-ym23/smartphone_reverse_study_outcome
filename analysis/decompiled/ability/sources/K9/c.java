package K9;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Random;

/* loaded from: classes4.dex */
public final class c extends ThreadLocal {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f913a;

    public /* synthetic */ c(int i) {
        this.f913a = i;
    }

    @Override // java.lang.ThreadLocal
    public final Object initialValue() {
        switch (this.f913a) {
            case 0:
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
                simpleDateFormat.setLenient(false);
                simpleDateFormat.setTimeZone(G9.b.f);
                return simpleDateFormat;
            case 1:
                try {
                    return MessageDigest.getInstance("MD5");
                } catch (NoSuchAlgorithmException unused) {
                    throw new IllegalStateException("no md5 algorythm found");
                }
            case 2:
                return new Random();
            default:
                return new char[1024];
        }
    }
}
