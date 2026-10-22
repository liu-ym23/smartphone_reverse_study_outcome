package Cc;

import android.graphics.Typeface;
import java.util.Locale;

/* loaded from: classes5.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public final Typeface f1978a;

    /* renamed from: b, reason: collision with root package name */
    public int f1979b;

    /* renamed from: c, reason: collision with root package name */
    public float f1980c;

    public e(String str, int i10, int i11) {
        this(c(str, i10), i10, i11);
    }

    public static Typeface a(Typeface typeface, int i10) {
        if ((typeface.isBold() | (typeface.isItalic() ? 2 : false)) != i10) {
            return Typeface.create(typeface, ((i10 & 1) != 0 ? 1 : 0) | ((i10 & 2) != 0 ? 2 : 0));
        }
        return typeface;
    }

    public static e b(Typeface typeface, float f10) {
        return new e(typeface, 0, f10);
    }

    public static Typeface c(String str, int i10) {
        Typeface typefaceCreate = Typeface.create(str.toLowerCase(Locale.US), f(i10));
        return typefaceCreate == null ? Typeface.DEFAULT : typefaceCreate;
    }

    public static int f(int i10) {
        if (i10 == 0) {
            return 0;
        }
        return ((i10 & 1) != 0 ? 1 : 0) | ((i10 & 2) != 0 ? 2 : 0);
    }

    public e d(int i10) {
        return new e(this.f1978a, i10, this.f1980c);
    }

    public float e() {
        return this.f1980c;
    }

    public Typeface g() {
        return this.f1978a;
    }

    public e(Typeface typeface, int i10, float f10) {
        this.f1978a = a(typeface, i10);
        this.f1979b = i10;
        this.f1980c = f10;
    }
}
