package btc;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.method.Touch;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.TextView;
import kotlin.collections.ArraysKt;

/* JADX INFO: loaded from: classes5.dex */
public final class c extends LinkMovementMethod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f20714a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f20715b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f20716c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f20717d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f20718e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public a[] f20719f;

    public c() {
        this.f20714a = ViewConfiguration.getLongPressTimeout();
        this.f20719f = new a[0];
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public final void initialize(TextView r100, Spannable r101) {
        super.initialize(r100, r101);
        this.f20715b = ViewConfiguration.get(r100.getContext()).getScaledTouchSlop();
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public final boolean onTouchEvent(TextView r110, Spannable r111, MotionEvent r112) {
        if (r112.getActionMasked() != 1) goto L5;
    L8:
        float r100 = (r112.getX() - r110.getTotalPaddingLeft()) + r110.getScrollX();
        float r101 = (r112.getY() - r110.getTotalPaddingTop()) + r110.getScrollY();
        Layout r102 = r110.getLayout();
        int r103 = r102.getOffsetForHorizontal(r102.getLineForVertical((int) r101), r100);
        ClickableSpan[] r104 = (ClickableSpan[]) r111.getSpans(r103, r103, ClickableSpan.class);
        int r105 = 0;
        if (r112.getActionMasked() != 0) goto L20;
        this.f20716c = r112.getX();
        this.f20717d = r112.getY();
        this.f20718e = System.currentTimeMillis();
        a[] r106 = (a[]) r111.getSpans(r103, r103, a.class);
        this.f20719f = r106;
        int r107 = r106.length;
        int r108 = 0;
    L11:
        if (r108 >= r107) goto L14;
        r106[r108].d(r110);
        r108 = r108 + 1;
        goto L11
    L14:
        if (r104.length != 0) goto L17;
        r105 = 1;
    L17:
        if ((r105 ^ 1) == 0) goto L55;
        Selection.setSelection(r111, r111.getSpanStart(ArraysKt.first(r104)), r111.getSpanEnd(ArraysKt.first(r104)));
    L55:
        return Touch.onTouchEvent(r110, r111, r112);
    L20:
        if (r112.getActionMasked() != 1) goto L51;
        a[] r109 = this.f20719f;
        int r113 = r109.length;
        int r114 = 0;
    L22:
        if (r114 >= r113) goto L25;
        r109[r114].b(r110);
        r114 = r114 + 1;
        goto L22
    L25:
        if (Math.abs(r112.getX() - this.f20716c) < this.f20715b) goto L27;
    L49:
        Selection.removeSelection(r111);
        return Touch.onTouchEvent(r110, r111, r112);
    L27:
        if (Math.abs(r112.getY() - this.f20717d) >= this.f20715b) goto L49;
        if ((System.currentTimeMillis() - this.f20718e) >= this.f20714a) goto L49;
        if (r104.length != 0) goto L33;
        boolean r115 = true;
    L35:
        if ((!r115) == false) goto L49;
        float r116 = r102.getPrimaryHorizontal(r103);
        int r117 = r104.length;
    L37:
        if (r105 >= r117) goto L49;
        ClickableSpan r118 = r104[r105];
        if (r116 >= r100) goto L45;
        if (r111.getSpanEnd(r118) <= r103) goto L48;
        r118.onClick(r110);
        return true;
    L48:
        r105 = r105 + 1;
        goto L37
    L45:
        if (r111.getSpanStart(r118) >= r103) goto L48;
        r118.onClick(r110);
        return true;
    L33:
        r115 = false;
        goto L35
    L51:
        a[] r119 = this.f20719f;
        int r120 = r119.length;
    L52:
        if (r105 >= r120) goto L55;
        r119[r105].c(r110);
        r105 = r105 + 1;
        goto L52
    L5:
        if (r112.getActionMasked() == 0) goto L8;
        if (r112.getActionMasked() != 3) goto L55;
        goto L8
    }
}
