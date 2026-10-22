package i9;

import android.icu.text.Transliterator;
import java.text.Collator;
import java.util.Locale;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f5826a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final Collator f5827b;

    /* renamed from: c, reason: collision with root package name */
    public static final Transliterator f5828c;

    static {
        Object objL;
        Collator collator = Collator.getInstance(Locale.CHINA);
        collator.setStrength(0);
        f5827b = collator;
        try {
            objL = Transliterator.getInstance("Han-Latin/Names; Latin-ASCII");
        } catch (Throwable th) {
            objL = id.c.l(th);
        }
        if (objL instanceof jb.h) {
            objL = null;
        }
        f5828c = (Transliterator) objL;
    }

    public static int a(String str, String str2) {
        str.getClass();
        str2.getClass();
        return f5827b.compare(hc.h.w0(str).toString(), hc.h.w0(str2).toString());
    }
}
