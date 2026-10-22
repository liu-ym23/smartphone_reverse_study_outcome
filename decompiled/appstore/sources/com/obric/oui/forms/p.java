package com.obric.oui.forms;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.GetChars;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.text.style.ReplacementSpan;
import android.util.Log;
import android.view.View;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class p extends PasswordTransformationMethod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f14834a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f14835b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f14836c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f14837d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b f14838e;

    public static class a extends ReplacementSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f14839a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f14840b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f14841c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f14842d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f14843e;

        public a(int r10, float r11, float r12, int r13) {
            this.f14843e = false;
            this.f14839a = r10;
            this.f14840b = r11;
            this.f14841c = r12;
            this.f14842d = r13;
        }

        public static /* synthetic */ int a(a r10) {
            return r10.f14839a;
        }

        public final void b(Paint r10, Paint.FontMetricsInt r11) {
            if (r11 != null) goto L4;
            return;
        L4:
            Paint.FontMetricsInt r12 = r10.getFontMetricsInt();
            r11.ascent = r12.ascent;
            r11.descent = r12.descent;
            r11.top = r12.top;
            r11.bottom = r12.bottom;
        }

        public final boolean c(CharSequence r10, int r11) {
            if (r11 >= 0) goto L4;
        L8:
            return false;
        L4:
            if (r11 >= r10.length()) goto L8;
            if (r10.charAt(r11) != 8226) goto L8;
            return true;
        }

        public void d(boolean r10) {
            this.f14843e = r10;
        }

        @Override // android.text.style.ReplacementSpan
        public void draw(Canvas r12, CharSequence r13, int r14, int r15, float r16, int r17, int r18, int r19, Paint r20) {
            if (c(r13, r14) == true) goto L6;
            r12.drawText(r13, r14, r15, r16, r18, r20);
            return;
        L6:
            float r10 = r20.getTextSize();
            float r11 = this.f14840b * r10;
            float r21 = (r10 * this.f14841c) + r11;
            float r22 = r11 / 2.0f;
            float r23 = r16 + r22;
            float r24 = (r17 + r19) / 2.0f;
            Paint.Style r25 = r20.getStyle();
            r20.setStyle(Paint.Style.FILL);
            if (this.f14843e == false) goto L9;
            int r26 = r20.getColor();
            r20.setColor(this.f14842d);
            r12.drawRect(Math.round(r16), r17, Math.round((r16 + r21) + 0.5f), r19, r20);
            r20.setColor(r26);
        L9:
            r12.drawCircle(r23, r24, r22, r20);
            r20.setStyle(r25);
        }

        @Override // android.text.style.ReplacementSpan
        public int getSize(Paint r10, CharSequence r11, int r12, int r13, Paint.FontMetricsInt r14) {
            b(r10, r14);
            if (c(r11, r12) == false) goto L5;
            float r15 = r10.getTextSize();
            float r16 = (this.f14840b * r15) + (r15 * this.f14841c);
        L7:
            return (int) Math.ceil(r16);
        L5:
            r16 = r10.measureText(r11, r12, r13);
            goto L7
        }
    }

    public static class b implements Spanned, GetChars {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CharSequence f14844a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f14845b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f14846c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f14847d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f14848e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final ArrayList f14849f;

        public b(CharSequence r10, float r11, float r12, int r13) {
            this.f14848e = false;
            this.f14849f = new ArrayList();
            this.f14844a = r10;
            this.f14845b = r11;
            this.f14846c = r12;
            this.f14847d = r13;
        }

        public static Object[] d(List r10, Class r11) {
            Object[] r12 = (Object[]) Array.newInstance(r11, r10.size());
            int r13 = 0;
        L4:
            if (r13 >= r10.size()) goto L6;
            r12[r13] = r10.get(r13);
            r13 = r13 + 1;
            goto L4
        L6:
            return r12;
        }

        public final void a(int r10) {
        L3:
            if (this.f14849f.size() >= r10) goto L5;
            a r11 = new a(this.f14849f.size(), this.f14845b, this.f14846c, this.f14847d);
            r11.d(this.f14848e);
            this.f14849f.add(r11);
            goto L3
        L5:
            c(r10);
        }

        public void b(boolean r10) {
            this.f14848e = r10;
            int r11 = 0;
        L4:
            if (r11 >= this.f14849f.size()) goto L6;
            ((a) this.f14849f.get(r11)).d(r10);
            r11 = r11 + 1;
            goto L4
        }

        public final void c(int r10) {
            int r11 = r10 + 16;
            if (this.f14849f.size() > (r10 + 48)) goto L5;
            return;
        L5:
            ArrayList r12 = this.f14849f;
            r12.subList(r11, r12.size()).clear();
        }

        @Override // java.lang.CharSequence
        public char charAt(int r10) {
            return this.f14844a.charAt(r10);
        }

        @Override // android.text.GetChars
        public void getChars(int r10, int r11, char[] r12, int r13) {
            CharSequence r14 = this.f14844a;
            if ((r14 instanceof GetChars) == false) goto L5;
            ((GetChars) r14).getChars(r10, r11, r12, r13);
            return;
        L5:
            TextUtils.getChars(r14, r10, r11, r12, r13);
        }

        @Override // android.text.Spanned
        public int getSpanEnd(Object r10) {
            if ((r10 instanceof a) == true) goto L5;
            CharSequence r11 = this.f14844a;
            if ((r11 instanceof Spanned) == true) goto L9;
            return -1;
        L9:
            return ((Spanned) r11).getSpanEnd(r10);
        L5:
            return a.a((a) r10) + 1;
        }

        @Override // android.text.Spanned
        public int getSpanFlags(Object r10) {
            if ((r10 instanceof a) == false) goto L6;
            return 33;
        L6:
            CharSequence r11 = this.f14844a;
            if ((r11 instanceof Spanned) == true) goto L9;
            return 0;
        L9:
            return ((Spanned) r11).getSpanFlags(r10);
        }

        @Override // android.text.Spanned
        public int getSpanStart(Object r10) {
            if ((r10 instanceof a) == true) goto L5;
            CharSequence r11 = this.f14844a;
            if ((r11 instanceof Spanned) == true) goto L9;
            return -1;
        L9:
            return ((Spanned) r11).getSpanStart(r10);
        L5:
            return a.a((a) r10);
        }

        @Override // android.text.Spanned
        public Object[] getSpans(int r10, int r11, Class r12) {
            ArrayList r13 = new ArrayList();
            CharSequence r14 = this.f14844a;
            if ((r14 instanceof Spanned) == false) goto L8;
            Object[] r15 = ((Spanned) r14).getSpans(r10, r11, r12);
            int r16 = r15.length;
            int r17 = 0;
        L5:
            if (r17 >= r16) goto L8;
            r13.add(r15[r17]);
            r17 = r17 + 1;
        L8:
            if (r12.isAssignableFrom(a.class) == false) goto L10;
        L13:
            a(length());
            int r18 = Math.max(r10, 0);
            int r19 = Math.min(r11, length());
        L14:
            if (r18 >= r19) goto L20;
            char r20 = this.f14844a.charAt(r18);
            Log.d("OPassword", "getSpans: childChar=" + r20 + ", index=" + r18);
            if (r20 != 8226) goto L18;
            r13.add(r12.cast((a) this.f14849f.get(r18)));
        L18:
            r18 = r18 + 1;
        L20:
            return d(r13, r12);
        L10:
            if (r12.isAssignableFrom(ReplacementSpan.class) == true) goto L13;
            if (r12.isAssignableFrom(Object.class) == false) goto L20;
            goto L13
        }

        @Override // java.lang.CharSequence
        public int length() {
            return this.f14844a.length();
        }

        @Override // android.text.Spanned
        public int nextSpanTransition(int r10, int r11, Class r12) {
            CharSequence r13 = this.f14844a;
            if ((r13 instanceof Spanned) == false) goto L5;
            int r14 = ((Spanned) r13).nextSpanTransition(r10, r11, r12);
        L6:
            if (r12 != null) goto L8;
        L13:
            a(length());
            int r15 = Math.max(r10, 0);
            int r16 = Math.min(r11, length());
        L14:
            if (r15 >= r16) goto L21;
            if (this.f14844a.charAt(r15) != 8226) goto L20;
            if (r15 <= r10) goto L19;
            r14 = Math.min(r14, r15);
        L19:
            r14 = Math.min(r14, r15 + 1);
        L20:
            r15 = r15 + 1;
        L21:
            return r14;
        L8:
            if (r12.isAssignableFrom(a.class) == true) goto L13;
            if (r12.isAssignableFrom(ReplacementSpan.class) == true) goto L13;
            if (r12.isAssignableFrom(Object.class) == false) goto L21;
        L5:
            r14 = r11;
            goto L6
        }

        @Override // java.lang.CharSequence
        public CharSequence subSequence(int r10, int r11) {
            return this.f14844a.subSequence(r10, r11);
        }

        @Override // java.lang.CharSequence
        public String toString() {
            return this.f14844a.toString();
        }
    }

    public p(float r10, float r11, int r12) {
        this.f14837d = false;
        this.f14834a = r10;
        this.f14835b = r11;
        this.f14836c = r12;
    }

    public float a() {
        return this.f14834a;
    }

    public float b() {
        return this.f14835b;
    }

    public void c(boolean r10) {
        if (this.f14837d == r10) goto L8;
        this.f14837d = r10;
        b r11 = this.f14838e;
        if (r11 == null) goto L9;
        r11.b(r10);
        return;
    L9:
        return;
    }

    @Override // android.text.method.PasswordTransformationMethod, android.text.method.TransformationMethod
    public CharSequence getTransformation(CharSequence r10, View r11) {
        CharSequence r12 = super.getTransformation(r10, r11);
        if (r12 != null) goto L7;
        return "";
    L7:
        if (this.f14838e != null) goto L10;
        b r13 = new b(r12, this.f14834a, this.f14835b, this.f14836c);
        this.f14838e = r13;
        r13.b(this.f14837d);
    L10:
        return this.f14838e;
    }
}
