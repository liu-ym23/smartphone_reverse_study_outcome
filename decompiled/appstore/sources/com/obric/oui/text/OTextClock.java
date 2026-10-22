package com.obric.oui.text;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.SpannableString;
import android.text.style.ReplacementSpan;
import android.util.AttributeSet;
import android.widget.TextClock;
import android.widget.TextView;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes4.dex */
public class OTextClock extends TextClock {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f17245a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile float f17246b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile CharSequence f17247c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile TextView.BufferType f17248d;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f17249a = null;

        static {
            int[] r10 = new int[Layout.Alignment.values().length];
            f17249a = r10;
            r10[Layout.Alignment.ALIGN_CENTER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f17249a[Layout.Alignment.ALIGN_OPPOSITE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f17249a[Layout.Alignment.ALIGN_NORMAL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public static class b extends ReplacementSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f17250a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f17251b;

        public b(float r10) {
            this.f17251b = -1.0f;
            this.f17250a = r10;
        }

        public final float a(float r10, float r11, float r12) {
            Layout.Alignment r13 = b();
            int r14 = a.f17249a[r13.ordinal()];
            if (r14 != 1) goto L5;
            float r15 = (r11 - r12) / 2.0f;
        L9:
            return r10 - r15;
        L5:
            if (r14 == 2) goto L7;
            return r10;
        L7:
            r15 = r11 - r12;
            goto L9
        }

        public final Layout.Alignment b() {
            return Layout.Alignment.ALIGN_CENTER;
        }

        @Override // android.text.style.ReplacementSpan
        public void draw(Canvas r10, CharSequence r11, int r12, int r13, float r14, int r15, int r16, int r17, Paint r18) {
            if (this.f17251b >= 0.0f) goto L6;
            this.f17251b = r18.measureText(r11, r12, r13);
        L6:
            float r19 = this.f17251b;
            r10.drawText(r11, r12, r13, a(r14, r19, this.f17250a * r19), r16, r18);
        }

        @Override // android.text.style.ReplacementSpan
        public int getSize(Paint r10, CharSequence r11, int r12, int r13, Paint.FontMetricsInt r14) {
            if (this.f17251b >= 0.0f) goto L6;
            this.f17251b = r10.measureText(r11, r12, r13);
        L6:
            return (int) (this.f17251b * this.f17250a);
        }
    }

    public OTextClock(Context r10) {
        super(r10);
        this.f17245a = ConcurrentHashMap.newKeySet();
        this.f17246b = 1.0f;
        this.f17247c = "";
        this.f17248d = TextView.BufferType.NORMAL;
    }

    public final CharSequence a(CharSequence r10) {
        String r11 = r10.toString();
        SpannableString r12 = new SpannableString(r11);
        HashSet r13 = new HashSet(this.f17245a);
        float r14 = this.f17246b;
        Iterator r15 = r13.iterator();
    L4:
        if (r15.hasNext() == false) goto L8;
        char r16 = ((Character) r15.next()).charValue();
        int r17 = r11.indexOf(r16);
    L6:
        if (r17 < 0) goto L4;
        int r18 = r17 + 1;
        r12.setSpan(new b(r14), r17, r18, 33);
        r17 = r11.indexOf(r16, r18);
        goto L6
    L8:
        return r12;
    }

    public final void b() {
        if (this.f17247c != null) goto L5;
        return;
    L5:
        if (this.f17247c.length() > 0) goto L7;
        return;
    L7:
        if (c() == false) goto L9;
        super.setText(a(this.f17247c), this.f17248d);
    L10:
        invalidate();
        return;
    L9:
        super.setText(this.f17247c, this.f17248d);
        goto L10
    }

    public final boolean c() {
        return !this.f17245a.isEmpty();
    }

    @Override // android.widget.TextView
    public void setLineSpacing(float r10, float r11) {
        super.setLineSpacing(r10, r11);
        b();
    }

    public void setRatio(float r10) {
        this.f17246b = r10;
        b();
    }

    public void setTargetCharacters(char[] r10) {
        this.f17245a.clear();
        if (r10 == null) goto L7;
        int r11 = r10.length;
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L7;
        char r13 = r10[r12];
        this.f17245a.add(Character.valueOf(r13));
        r12 = r12 + 1;
    L7:
        b();
    }

    @Override // android.widget.TextView
    public void setText(CharSequence r10, TextView.BufferType r11) {
        this.f17247c = r10;
        this.f17248d = r11;
        b();
    }

    @Override // android.widget.TextView
    public void setTextSize(float r10) {
        super.setTextSize(r10);
        b();
    }

    @Override // android.widget.TextView
    public void setTypeface(Typeface r10) {
        super.setTypeface(r10);
        b();
    }

    @Override // android.widget.TextView
    public void setTextSize(int r10, float r11) {
        super.setTextSize(r10, r11);
        b();
    }

    @Override // android.widget.TextView
    public void setTypeface(Typeface r10, int r11) {
        super.setTypeface(r10, r11);
        b();
    }

    public OTextClock(Context r10, AttributeSet r11) {
        super(r10, r11);
        this.f17245a = ConcurrentHashMap.newKeySet();
        this.f17246b = 1.0f;
        this.f17247c = "";
        this.f17248d = TextView.BufferType.NORMAL;
    }

    public OTextClock(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.f17245a = ConcurrentHashMap.newKeySet();
        this.f17246b = 1.0f;
        this.f17247c = "";
        this.f17248d = TextView.BufferType.NORMAL;
    }
}
