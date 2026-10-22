package com.bytedance.android.livesdk.commerce.coupon;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public class LiveAlignTextView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<m> f119540a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f119541b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<Rect> f119542c;

    public LiveAlignTextView(Context r100) {
        super(r100);
        this.f119541b = new Paint();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        super.onDraw(r100);
        int r101 = getHeight();
        if (this.f119540a != null) goto L5;
        return;
    L5:
        if (this.f119542c == null) goto L20;
        int r102 = 0;
        int r103 = 0;
    L9:
        if (r102 >= this.f119540a.size()) goto L21;
        m r104 = (m) ListProtector.get(this.f119540a, r102);
        Rect r105 = (Rect) ListProtector.get(this.f119542c, r102);
        Paint r106 = this.f119541b;
        if (r104 == null) goto L14;
        if (r106 == null) goto L14;
        r106.setTextSize(r104.f119627b);
        r106.setColor(r104.f119628c);
        r106.setTypeface(r104.f119630e);
    L14:
        int r107 = r103 + r104.f119629d;
        r100.drawText(r104.f119626a, r107 - r105.left, r101 - r105.bottom, this.f119541b);
        r103 = r107 + r105.width();
        r102 = r102 + 1;
        goto L9
    L21:
        return;
    }

    public void setTextList(List<m> r100) {
        if (r100 != null) goto L5;
        List<m> r101 = null;
    L14:
        this.f119540a = r101;
        if (r101 != null) goto L17;
    L28:
        this.f119542c = null;
        return;
    L17:
        if (r101.isEmpty() == true) goto L28;
        this.f119542c = new ArrayList();
        Iterator<m> r102 = r100.iterator();
    L21:
        if (r102.hasNext() == false) goto L27;
        m r103 = r102.next();
        Rect r104 = new Rect();
        Paint r105 = this.f119541b;
        if (r103 == null) goto L26;
        if (r105 == null) goto L26;
        r105.setTextSize(r103.f119627b);
        r105.setColor(r103.f119628c);
        r105.setTypeface(r103.f119630e);
    L26:
        String r106 = r103.f119626a;
        this.f119541b.getTextBounds(r106, 0, r106.length(), r104);
        ((ArrayList) this.f119542c).add(r104);
        goto L21
    L27:
        return;
    L5:
        Iterator<m> r107 = r100.iterator();
    L7:
        if (r107.hasNext() == false) goto L13;
        m r108 = r107.next();
        if (r108 == null) goto L12;
        if (TextUtils.isEmpty(r108.f119626a) == false) goto L7;
    L12:
        r107.remove();
        goto L7
    L13:
        r101 = r100;
        goto L14
    }

    public LiveAlignTextView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f119541b = new Paint();
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = View.MeasureSpec.getMode(r100);
        int r103 = View.getDefaultSize(getMinimumWidth(), r100);
        int r104 = 0;
        if (r102 != 1073741824) goto L6;
    L18:
        int r105 = View.MeasureSpec.getMode(r101);
        int r106 = View.getDefaultSize(getMinimumHeight(), r101);
        if (r105 != 1073741824) goto L21;
        r104 = r106;
    L33:
        setMeasuredDimension(r103, r104);
        return;
    L21:
        List<Rect> r107 = this.f119542c;
        if (r107 == null) goto L33;
        Iterator r108 = ((ArrayList) r107).iterator();
    L26:
        if (r108.hasNext() == false) goto L30;
        Rect r109 = (Rect) r108.next();
        if (r109.height() <= r104) goto L26;
        r104 = r109.height();
        goto L26
    L30:
        if (r106 == 0) goto L33;
        r104 = Math.min(r104, r106);
        goto L33
    L6:
        if (this.f119540a != null) goto L8;
    L17:
        r103 = 0;
        goto L18
    L8:
        if (this.f119542c == null) goto L17;
        int r110 = 0;
        int r111 = 0;
    L12:
        if (r110 >= this.f119540a.size()) goto L14;
        Rect r112 = (Rect) ListProtector.get(this.f119542c, r110);
        r111 = (r111 + ((m) ListProtector.get(this.f119540a, r110)).f119629d) + r112.width();
        r110 = r110 + 1;
        goto L12
    L14:
        if (r103 != 0) goto L16;
        r103 = r111;
        goto L18
    L16:
        r103 = Math.min(r111, r103);
        goto L18
    }

    public LiveAlignTextView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f119541b = new Paint();
    }
}
