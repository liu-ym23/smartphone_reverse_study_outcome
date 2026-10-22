package am4;

import android.text.InputFilter;
import android.text.Spanned;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;

/* JADX INFO: loaded from: classes15.dex */
public final class g implements InputFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f4391a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f4392b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f4393c;

    public interface a {
        void a();
    }

    public g(int r100, int r101, f r102) {
        this.f4391a = r100;
        this.f4392b = r101;
        this.f4393c = r102;
    }

    @Override // android.text.InputFilter
    public final CharSequence filter(CharSequence r100, int r101, int r102, Spanned r103, int r104, int r105) {
        int r106 = CastIntegerProtector.parseInt(r103.toString() + r100.toString());     // Catch: NumberFormatException -> L19
        int r107 = this.f4391a;     // Catch: NumberFormatException -> L19
        int r108 = this.f4392b;     // Catch: NumberFormatException -> L19
        if (r108 <= r107) goto L7;
        if (r106 < r107) goto L10;
        if (r106 > r108) goto L10;
    L9:
        boolean r109 = true;
    L11:
        if (r109 == false) goto L14;
        return null;
    L14:
        a r110 = this.f4393c;     // Catch: NumberFormatException -> L19
        if (r110 == null) goto L22;
        r110.a();     // Catch: NumberFormatException -> L19
        return "";
    L22:
        return "";
    L10:
        r109 = false;
        goto L11
    L7:
        if (r106 < r108) goto L10;
        if (r106 > r107) goto L10;
    L23:
        return "";
    }
}
