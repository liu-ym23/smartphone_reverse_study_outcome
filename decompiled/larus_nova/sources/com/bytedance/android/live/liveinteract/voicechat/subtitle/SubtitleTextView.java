package com.bytedance.android.live.liveinteract.voicechat.subtitle;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.text.SpannableStringBuilder;
import android.text.style.LineHeightSpan;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes46.dex */
public class SubtitleTextView extends AppCompatTextView {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f80682d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f80683a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f80684b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView.BufferType f80685c;

    public class a extends SparseIntArray {
        public a() {
            put(26, 34);
            put(24, 32);
            put(20, 28);
            put(17, 24);
            put(16, 22);
            put(14, 20);
            put(13, 18);
            put(11, 15);
            put(10, 14);
        }
    }

    public static class b extends SpannableStringBuilder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public c f80686a;

        public b() {
        }
    }

    public static class c implements LineHeightSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f80687a;

        public c(float r100) {
            this.f80687a = (int) Math.ceil(r100);
        }

        @Override // android.text.style.LineHeightSpan
        public final void chooseHeight(CharSequence r100, int r101, int r102, int r103, int r104, Paint.FontMetricsInt r105) {
            int r106 = r105.descent;
            int r107 = this.f80687a;
            if (r106 <= r107) goto L5;
            int r108 = Math.min(r107, r106);
            r105.descent = r108;
            r105.bottom = r108;
            r105.ascent = 0;
            r105.top = 0;
            return;
        L5:
            int r109 = r105.ascent;
            if (((-r109) + r106) <= r107) goto L8;
            r105.bottom = r106;
            int r110 = (-r107) + r106;
            r105.ascent = r110;
            r105.top = r110;
            return;
        L8:
            int r111 = r105.bottom;
            if (((-r109) + r111) <= r107) goto L11;
            r105.top = r109;
            r105.bottom = r109 + r107;
            return;
        L11:
            int r112 = r105.top;
            if (((-r112) + r111) <= r107) goto L14;
            r105.top = r111 - r107;
            return;
        L14:
            double r113 = r112;
            double r114 = (r107 - ((-r112) + r111)) / 2.0f;
            r105.top = (int) (r113 - Math.ceil(r114));
            int r115 = (int) (((double) r105.bottom) + Math.floor(r114));
            r105.bottom = r115;
            r105.ascent = r105.top;
            r105.descent = r115;
        }
    }

    static {
        f80682d = new a();
    }

    private b getBuilder() {
        if (this.f80683a != null) goto L6;
        this.f80683a = new b();
    L6:
        return this.f80683a;
    }

    @Override // android.widget.TextView
    public int getLineHeight() {
        return (int) this.f80684b;
    }

    public SubtitleTextView(Context r100) {
        this(r100, null);
    }

    public void setUXLineHeight(float r100) {
        this.f80684b = r100;
        setText(getText(), this.f80685c);
    }

    public SubtitleTextView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    @Override // android.widget.TextView
    public final void setText(CharSequence r100, TextView.BufferType r101) {
        if (r100 != null) goto L4;
        r100 = "";
    L4:
        this.f80685c = r101;
        if (this.f80684b > 1.0f) goto L7;
        super.setText(r100, r101);
        return;
    L7:
        b r102 = getBuilder();
        float r103 = this.f80684b;
        r102.clear();
        r102.clearSpans();
        c r104 = r102.f80686a;
        if (r104 != null) goto L10;
        r102.f80686a = new c(r103);
    L11:
        r102.append(r100);
        r102.setSpan(r102.f80686a, 0, r100.length(), 17);
        super.setText(r102, r101);
        return;
    L10:
        r104.f80687a = (int) Math.ceil(r103);
        goto L11
    }

    public SubtitleTextView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f80684b = -1.0f;
        this.f80685c = TextView.BufferType.NORMAL;
        Context r103 = getContext();
        if (r101 == null) goto L10;
        TypedArray r104 = r103.obtainStyledAttributes(r101, new int[]{R.attr.ux_line_height});
        int r105 = r104.getDimensionPixelSize(0, -1);
        if (r105 >= 0) goto L8;
        Resources r106 = getResources();
        float r107 = WindowDisplayMetricsOverride.apply(r106, r106.getDisplayMetrics()).density;
        r105 = (int) (f80682d.get((int) (getTextSize() / r107), -1) * r107);
    L8:
        setUXLineHeight(r105);
        r104.recycle();
        return;
    }
}
