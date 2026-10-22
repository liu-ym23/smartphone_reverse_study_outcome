package com.bytedance.android.livesdk.livecommerce.view.aligntext;

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
import pl2.a;

/* JADX INFO: loaded from: classes10.dex */
public class ECAlignTextView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<a> f153203a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f153204b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<Rect> f153205c;

    public ECAlignTextView(Context r100) {
        super(r100);
        this.f153204b = new Paint();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        super.onDraw(r110);
        int r100 = getHeight();
        if (this.f153203a != null) goto L5;
        return;
    L5:
        if (this.f153205c == null) goto L20;
        int r101 = 0;
        int r102 = 0;
    L9:
        if (r101 >= this.f153203a.size()) goto L21;
        a r103 = (a) ListProtector.get(this.f153203a, r101);
        Rect r104 = (Rect) ListProtector.get(this.f153205c, r101);
        Paint r105 = this.f153204b;
        if (r103 == null) goto L14;
        if (r105 == null) goto L14;
        r105.setTextSize(0.0f);
        r105.setColor(0);
        r105.setTypeface(null);
        r105.setAntiAlias(true);
    L14:
        r103.getClass();
        int r106 = r102 + 0;
        r110.drawText(null, r106 - r104.left, ((r100 - r104.bottom) - 0) + 0, this.f153204b);
        r102 = r106 + r104.width();
        r101 = r101 + 1;
        goto L9
    L21:
        return;
    }

    public void setTextList(List<a> r100) {
        if (r100 != null) goto L5;
        List<a> r101 = null;
    L14:
        this.f153203a = r101;
        if (r101 != null) goto L17;
    L28:
        this.f153205c = null;
        return;
    L17:
        if (r101.isEmpty() == true) goto L28;
        this.f153205c = new ArrayList();
        Iterator<a> r102 = r100.iterator();
        if (r102.hasNext() == true) goto L22;
        return;
    L22:
        a r103 = r102.next();
        new Rect();
        Paint r104 = this.f153204b;
        if (r103 == null) goto L26;
        if (r104 == null) goto L26;
        r104.setTextSize(0.0f);
        r104.setColor(0);
        r104.setTypeface(null);
        r104.setAntiAlias(true);
    L26:
        r103.getClass();
        throw null;
    L5:
        Iterator<a> r105 = r100.iterator();
    L7:
        if (r105.hasNext() == false) goto L13;
        if (r105.next() == null) goto L12;
        if (TextUtils.isEmpty(null) == false) goto L7;
    L12:
        r105.remove();
        goto L7
    L13:
        r101 = r100;
        goto L14
    }

    public ECAlignTextView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f153204b = new Paint();
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = View.MeasureSpec.getMode(r100);
        int r103 = View.MeasureSpec.getSize(r100);
        int r104 = 0;
        if (r102 != 1073741824) goto L6;
    L18:
        int r105 = View.MeasureSpec.getMode(r101);
        int r106 = View.getDefaultSize(getMinimumHeight(), r101);
        if (r105 != 1073741824) goto L22;
        r104 = r106;
    L37:
        setMeasuredDimension(r103, r104);
        return;
    L22:
        if (this.f153205c == null) goto L37;
        if (this.f153203a == null) goto L37;
        int r107 = 0;
        int r108 = 0;
    L28:
        if (r107 >= this.f153203a.size()) goto L33;
        Rect r109 = (Rect) ListProtector.get(this.f153205c, r107);
        a r110 = (a) ListProtector.get(this.f153203a, r107);
        int r111 = r109.height();
        r110.getClass();
        if ((r111 - 0) <= r108) goto L32;
        r108 = r109.height() - 0;
    L32:
        r107 = r107 + 1;
        goto L28
    L33:
        r104 = 0 + r108;
        if (r106 == 0) goto L37;
        r104 = Math.min(r104, r106);
        goto L37
    L6:
        if (this.f153203a != null) goto L8;
    L17:
        r103 = 0;
        goto L18
    L8:
        if (this.f153205c == null) goto L17;
        int r112 = 0;
        int r113 = 0;
    L12:
        if (r112 >= this.f153203a.size()) goto L14;
        Rect r114 = (Rect) ListProtector.get(this.f153205c, r112);
        ((a) ListProtector.get(this.f153203a, r112)).getClass();
        r113 = (r113 + 0) + r114.width();
        r112 = r112 + 1;
        goto L12
    L14:
        if (r103 != 0) goto L16;
        r103 = r113;
        goto L18
    L16:
        r103 = Math.min(r113, r103);
        goto L18
    }

    public ECAlignTextView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f153204b = new Paint();
    }
}
