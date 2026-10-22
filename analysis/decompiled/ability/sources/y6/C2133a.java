package y6;

import android.graphics.Paint;
import android.text.style.LineHeightSpan;
import kotlin.jvm.internal.k;

/* renamed from: y6.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2133a implements LineHeightSpan {

    /* renamed from: a, reason: collision with root package name */
    public final int f6906a;

    public C2133a(int i) {
        this.f6906a = i;
    }

    @Override // android.text.style.LineHeightSpan
    public final void chooseHeight(CharSequence charSequence, int i, int i6, int i10, int i11, Paint.FontMetricsInt fm) {
        int i12;
        k.f(fm, "fm");
        int i13 = fm.descent;
        int i14 = fm.ascent;
        int i15 = i13 - i14;
        if (i15 <= 0 || (i12 = this.f6906a) <= 0) {
            return;
        }
        int i16 = i12 - i15;
        int i17 = i16 / 2;
        fm.ascent = i14 - i17;
        fm.descent = (i16 - i17) + i13;
    }
}
