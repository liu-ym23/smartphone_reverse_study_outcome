package w1;

import android.graphics.Matrix;
import android.view.Choreographer;
import android.view.View;
import android.view.inputmethod.CursorAnchorInfo;
import c7.h;
import j1.y;
import java.util.ArrayList;
import s1.g0;
import s1.z;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final View f10643a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f10644b;

    public c(View view) {
        this.f10643a = view;
        this.f10644b = s7.a.G(h.f1971g, new t9.h(8, this));
    }

    public c(View view, y yVar) {
        new c(view);
        Choreographer.getInstance();
        this.f10643a = view;
        long j2 = g0.f9268b;
        int length = new s1.e("", 0).f9246g.length();
        int i2 = g0.f9269c;
        int i10 = (int) (j2 >> 32);
        int i11 = i10 < 0 ? 0 : i10;
        i11 = i11 > length ? length : i11;
        int i12 = (int) (j2 & 4294967295L);
        int i13 = i12 >= 0 ? i12 : 0;
        length = i13 <= length ? i13 : length;
        if (i11 != i10 || length != i12) {
            z.b(i11, length);
        }
        int i14 = b.f10638e;
        new ArrayList();
        this.f10644b = s7.a.G(h.f1971g, new t9.h(9, this));
        new CursorAnchorInfo.Builder();
        new Matrix();
    }
}
