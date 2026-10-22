package com.bytedance.android.shopping.anchorv4.nav;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.android.ec.core.utils.q;
import com.bytedance.android.shopping.anchorv4.dto.ScrollNode;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class e extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextPaint f167168a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<ScrollNode> f167169b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d f167170c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f167171d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ArrayList<Float> f167172e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f167173f;

    public static final class a {
    }

    static {
    }

    public e(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        TextPaint r101 = new TextPaint(1);
        r101.setColor(0);
        r101.setTextSize(com.bytedance.android.shopping.extensions.b.a(15));
        r101.setTextAlign(Paint.Align.CENTER);
        r101.setStyle(Paint.Style.STROKE);
        r101.setFakeBoldText(false);
        Unit r102 = Unit.INSTANCE;
        this.f167168a = r101;
        this.f167172e = new ArrayList(4);
        this.f167173f = -1;
        setBackgroundColor(-1);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        List<ScrollNode> r100 = this.f167169b;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.size();
    L6:
        if (r102 != 0) goto L8;
        return;
    L8:
        this.f167168a.setStyle(Paint.Style.FILL);
        float r103 = getWidth() / r102;
        float r104 = (getHeight() / 2.0f) - ((this.f167168a.descent() + this.f167168a.ascent()) / 2.0f);
        List<ScrollNode> r105 = this.f167169b;
        if (r105 == null) goto L27;
        Iterator<T> r106 = r105.iterator();
    L12:
        if (r106.hasNext() == false) goto L27;
        Object r107 = r106.next();
        int r108 = r101 + 1;
        if (r101 >= 0) goto L16;
        CollectionsKt.throwIndexOverflow();
    L16:
        ScrollNode r109 = (ScrollNode) r107;
        float r111 = (r101 * r103) + (r103 / 2);
        TextPaint r112 = this.f167168a;
        if (this.f167171d != r101) goto L19;
        int r113 = -15329245;
    L20:
        r112.setColor(r113);
        if (r110 == null) goto L26;
        String r114 = r109.getName();
        if (r114 != null) goto L25;
        r114 = "";
    L25:
        r110.drawText(r114, r111, r104, this.f167168a);
    L26:
        r101 = r108;
        goto L12
    L19:
        r113 = -2146035677;
    L27:
        float r115 = q.a(Float.valueOf(0.5f));
        float r116 = 2;
        float r117 = getHeight() - (r115 / r116);
        this.f167168a.setColor(857085987);
        this.f167168a.setStrokeWidth(r115);
        if (r110 == null) goto L30;
        r110.drawLine(0.0f, r117, getWidth(), r117, this.f167168a);
    L30:
        float r118 = q.a(2);
        float r119 = getHeight() - (r118 / r116);
        int r120 = this.f167171d;
        float r121 = (r103 / r116) + (r120 * r103);
        Float r122 = (Float) CollectionsKt.getOrNull(this.f167172e, r120);
        if (r122 == null) goto L33;
        float r123 = r122.floatValue();
    L34:
        float r124 = r123 / r116;
        this.f167168a.setColor(-15329245);
        this.f167168a.setStrokeWidth(r118);
        if (r110 == null) goto L41;
        r110.drawLine(r121 - r124, r119, r121 + r124, r119, this.f167168a);
        return;
    L41:
        return;
    L33:
        r123 = 0.0f;
        goto L34
    L5:
        r102 = 0;
        goto L6
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (r100 == null) goto L4;
        Integer r101 = Integer.valueOf(r100.getAction());
    L5:
        int r102 = -1;
        int r103 = 0;
        if (r101 != null) goto L9;
    L17:
        if (r101 != null) goto L20;
    L37:
        return true;
    L20:
        if (r101.intValue() != 1) goto L37;
        float r104 = r100.getX();
        List<ScrollNode> r105 = this.f167169b;
        if (r105 == null) goto L24;
        r103 = r105.size();
    L24:
        if (r103 == 0) goto L27;
        r102 = (int) (r104 / (getWidth() / r103));
    L27:
        if (r102 < 0) goto L37;
        if (r102 != this.f167173f) goto L37;
        List<ScrollNode> r106 = this.f167169b;
        if (r106 == null) goto L37;
        ScrollNode r107 = (ScrollNode) CollectionsKt.getOrNull(r106, r102);
        if (r107 == null) goto L37;
        setSelectedIndex(r102);
        d r108 = this.f167170c;
        if (r108 == null) goto L37;
        r108.a(r102, r107);
        goto L37
    L9:
        if (r101.intValue() != 0) goto L17;
        float r109 = r100.getX();
        List<ScrollNode> r110 = this.f167169b;
        if (r110 == null) goto L13;
        r103 = r110.size();
    L13:
        if (r103 == 0) goto L16;
        r102 = (int) (r109 / (getWidth() / r103));
    L16:
        this.f167173f = r102;
        goto L37
    L4:
        r101 = null;
        goto L5
    }

    public final void setCallback(d r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f167170c = r100;
    }

    public final void setSelectedIndex(int r100) {
        this.f167171d = r100;
        invalidate();
    }

    public final void setupNodes(List<ScrollNode> r100) {
        Intrinsics.checkNotNullParameter(r100, "nodeList");
        this.f167169b = r100;
        this.f167172e.clear();
        Iterator<T> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        ScrollNode r102 = (ScrollNode) r101.next();
        ArrayList<Float> r103 = this.f167172e;
        TextPaint r104 = this.f167168a;
        String r105 = r102.getName();
        if (r105 != null) goto L8;
        r105 = "";
    L8:
        r103.add(Float.valueOf(r104.measureText(r105)));
        goto L4
    L9:
        requestLayout();
    }
}
