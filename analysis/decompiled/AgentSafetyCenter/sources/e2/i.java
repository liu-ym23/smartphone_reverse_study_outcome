package e2;

import ad.y;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public TextPaint f3434a;

    /* renamed from: b, reason: collision with root package name */
    public TextUtils.TruncateAt f3435b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f3436c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f3437d;

    /* renamed from: e, reason: collision with root package name */
    public Layout f3438e;

    /* renamed from: f, reason: collision with root package name */
    public int f3439f;

    /* renamed from: g, reason: collision with root package name */
    public int f3440g;

    /* renamed from: h, reason: collision with root package name */
    public int f3441h;
    public float i;

    /* renamed from: j, reason: collision with root package name */
    public float f3442j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f3443k;

    /* renamed from: l, reason: collision with root package name */
    public Paint.FontMetricsInt f3444l;

    /* renamed from: m, reason: collision with root package name */
    public int f3445m;

    /* renamed from: n, reason: collision with root package name */
    public f2.h[] f3446n;

    /* renamed from: o, reason: collision with root package name */
    public Rect f3447o;

    /* renamed from: p, reason: collision with root package name */
    public y f3448p;

    public final int a() {
        boolean z10 = this.f3437d;
        Layout layout = this.f3438e;
        return (z10 ? layout.getLineBottom(this.f3439f - 1) : layout.getHeight()) + this.f3440g + this.f3441h + this.f3445m;
    }

    public final float b(int i) {
        if (i == this.f3439f - 1) {
            return this.i + this.f3442j;
        }
        return 0.0f;
    }

    public final y c() {
        y yVar = this.f3448p;
        if (yVar != null) {
            return yVar;
        }
        Layout layout = this.f3438e;
        y yVar2 = new y();
        yVar2.f631a = layout;
        ArrayList arrayList = new ArrayList();
        int length = 0;
        do {
            int iD0 = hc.h.d0(layout.getText(), '\n', length, 4);
            length = iD0 < 0 ? layout.getText().length() : iD0 + 1;
            arrayList.add(Integer.valueOf(length));
        } while (length < layout.getText().length());
        yVar2.f632b = arrayList;
        int size = arrayList.size();
        ArrayList arrayList2 = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList2.add(null);
        }
        yVar2.f633c = arrayList2;
        yVar2.f634d = new boolean[arrayList.size()];
        arrayList.size();
        VarHandle.storeStoreFence();
        this.f3448p = yVar2;
        return yVar2;
    }

    public final float d(int i) {
        return this.f3440g + ((i != this.f3439f + (-1) || this.f3444l == null) ? this.f3438e.getLineBaseline(i) : g(i) - r0.ascent);
    }

    public final float e(int i) {
        Layout layout = this.f3438e;
        Paint.FontMetricsInt fontMetricsInt = this.f3444l;
        int i3 = this.f3439f;
        if (i != i3 - 1 || fontMetricsInt == null) {
            return this.f3440g + layout.getLineBottom(i) + (i == i3 + (-1) ? this.f3441h : 0);
        }
        return layout.getLineBottom(i - 1) + fontMetricsInt.bottom;
    }

    public final int f(int i) {
        Layout layout = this.f3438e;
        h hVar = j.f3449a;
        return (layout.getEllipsisCount(i) <= 0 || this.f3435b != TextUtils.TruncateAt.END) ? layout.getLineEnd(i) : layout.getText().length();
    }

    public final float g(int i) {
        return this.f3438e.getLineTop(i) + (i == 0 ? 0 : this.f3440g);
    }

    public final float h(int i, boolean z10) {
        return b(this.f3438e.getLineForOffset(i)) + c().i(i, true, z10);
    }

    public final float i(int i, boolean z10) {
        return b(this.f3438e.getLineForOffset(i)) + c().i(i, false, z10);
    }
}
