package com.bytedance.android.shopping.mall.homepage.card.headercard.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.ec.hybrid.list.util.c;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import if3.b;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0002\u0019\u001aB'\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u0010\u0010\b\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0002J\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0002¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/headercard/widget/BadgeView;", "Landroidx/appcompat/widget/AppCompatTextView;", "", "mode", "", "setMode", "getMode", "color", "setBadgeColor", "count", "setCount", GXTemplateKey.FLEXBOX_PADDING, "setHorizontalPadding", "", "useDefault", "setUseDefaultDraw", "maxNumber", "setMaxNumberInCount", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Mode", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BadgeView extends AppCompatTextView {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f177918p = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f177919a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f177920b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f177921c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f177922d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CharSequence f177923e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f177924f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f177925g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f177926h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f177927i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f177928j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Rect f177929k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f177930l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f177931m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Animator f177932n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Animator f177933o;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/headercard/widget/BadgeView$Mode;", "", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface Mode {
    }

    public static final class a {
    }

    static {
    }

    public BadgeView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public BadgeView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void B() {
        setVisibility(0);
        if (this.f177920b == 3) goto L5;
        return;
    L5:
        if (this.f177921c == false) goto L12;
        Animator r100 = this.f177932n;
        if (r100 == null) goto L9;
        r100.cancel();
    L9:
        ValueAnimator r101 = ValueAnimator.ofFloat(new float[]{0.1f, 0.8f, 1.4f, 1.1f, 1.0f});
        r101.setDuration(600);
        r101.setInterpolator(new AccelerateDecelerateInterpolator());
        r101.addUpdateListener(new if3.a(this));
        r101.addListener(new b(this, this));
        Unit r102 = Unit.INSTANCE;
        this.f177932n = r101;
        r101.start();
        return;
    }

    public final void A() {
        int r100 = this.f177920b;
        if (r100 != 2) goto L5;
    L8:
        int r101 = this.f177930l;
        int r102 = r101;
    L9:
        int r103 = this.f177931m;
        super.setPadding(r101, r103, r102, r103);
        return;
    L5:
        if (r100 == 3) goto L8;
        r101 = 0;
        r102 = 0;
        goto L9
    }

    public final void x() {
        int r100 = this.f177920b;
        if (r100 != 2) goto L5;
    L7:
        Integer r101 = Integer.valueOf(this.f177926h);
        int r102 = c.f47296a;
        int r103 = c.c(r101, getContext(), true);
        int r104 = getMeasuredWidth();
        if (r104 >= r103) goto L10;
    L9:
        r104 = r103;
    L10:
        setMeasuredDimension(r104, r103);
        int r105 = getMeasuredHeight();
        if (this.f177922d == r105) goto L14;
        this.f177922d = r105;
        z(r105, this.f177919a);
        return;
    L14:
        return;
    L5:
        if (r100 == 3) goto L7;
        Integer r106 = Integer.valueOf(this.f177925g);
        int r107 = c.f47296a;
        r103 = c.c(r106, getContext(), true);
        goto L9
    }

    public final void y() {
        setVisibility(8);
        Animator r100 = this.f177932n;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        this.f177932n = null;
        Animator r101 = this.f177933o;
        if (r101 == null) goto L8;
        r101.cancel();
    L8:
        this.f177933o = null;
    }

    public final int getMode() {
        return this.f177920b;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        if (this.f177924f == false) goto L5;
        super.onDraw(r100);
        return;
    L5:
        getPaint().setTextAlign(Paint.Align.LEFT);
        getPaint().setColor(getCurrentTextColor());
        r100.getClipBounds(this.f177929k);
        int r101 = this.f177929k.height();
        int r102 = this.f177929k.width();
        getPaint().getTextBounds(getText().toString(), 0, getText().length(), this.f177929k);
        float r103 = this.f177929k.width() / 2.0f;
        String r104 = getText().toString();
        if (this.f177920b == 2) goto L8;
    L10:
        float r105 = (r102 / 2.0f) - r103;
        Rect r106 = this.f177929k;
        r100.drawText(r104, r105 - r106.left, ((r101 / 2.0f) + (r106.height() / 2.0f)) - this.f177929k.bottom, getPaint());
        return;
    L8:
        if (Intrinsics.areEqual(r104, "1") == false) goto L10;
        r103 = (this.f177929k.width() / 2.0f) + (this.f177929k.width() / 4.0f);
        goto L10
    }

    public final void setBadgeColor(int r100) {
        if (r100 != this.f177919a) goto L5;
        return;
    L5:
        this.f177919a = r100;
        z(this.f177922d, r100);
    }

    public final void setCount(int r100) {
        setText(String.valueOf(r100));
    }

    public final void setHorizontalPadding(int r100) {
        if (this.f177930l == r100) goto L6;
        this.f177930l = r100;
        A();
        return;
    }

    public final void setMaxNumberInCount(int r100) {
        this.f177928j = r100;
    }

    public final void setMode(int r100) {
        if (this.f177920b != r100) goto L5;
        return;
    L5:
        this.f177920b = r100;
        CharSequence r101 = getText();
        int r102 = this.f177920b;
        if (r102 != 2) goto L8;
    L10:
        boolean r103 = false;
        if (r101 != null) goto L13;
    L16:
        boolean r104 = true;
    L17:
        if (r104 == false) goto L25;
        CharSequence r105 = this.f177923e;
        if (r105 != null) goto L21;
    L22:
        r103 = true;
    L23:
        if (r103 == true) goto L25;
        setText(this.f177923e);
        goto L25
    L21:
        if (r105.length() != 0) goto L23;
    L25:
        A();
        x();
        return;
    L13:
        if (r101.length() == 0) goto L16;
        r104 = false;
        goto L17
    L8:
        if (r102 == 3) goto L10;
        this.f177923e = r101;
        setText("");
        goto L25
    }

    public final void setUseDefaultDraw(boolean r100) {
        this.f177924f = r100;
        invalidate();
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        x();
    }

    @Override // android.widget.TextView
    public final void setText(CharSequence r100, TextView.BufferType r101) {
        Intrinsics.checkNotNullParameter(r100, "inText");
        if (this.f177920b == 2) goto L5;
    L17:
        this.f177923e = r100;
        if (this.f177920b == 3) goto L20;
    L19:
        r100 = "";
    L20:
        super.setText(r100, r101);
        return;
    L5:
        if (r100.length() != 0) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == true) goto L17;
        int r103 = CastIntegerProtector.valueOf(r100.toString()).intValue();     // Catch: Exception -> L15
        if (r103 <= this.f177928j) goto L13;
        StringBuilder r104 = new StringBuilder();     // Catch: Exception -> L15
        r104.append(this.f177928j);     // Catch: Exception -> L15
        r104.append('+');     // Catch: Exception -> L15
        r100 = r104.toString();     // Catch: Exception -> L15
    L13:
        if (r103 >= 0) goto L20;
    L16:
        throw new IllegalArgumentException("Excepted a int but get " + getText());
    L7:
        r102 = false;
        goto L8
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public final void setTextSize(int r100, float r101) {
        Float r102 = Float.valueOf(this.f177927i);
        int r103 = c.f47296a;
        super.setTextSize(0, c.c(r102, getContext(), true));
    }

    public final void z(int r100, int r101) {
        float r102 = r100 / 2;
        Drawable r103 = DrawableCompat.wrap(new ShapeDrawable(new RoundRectShape(new float[]{r102, r102, r102, r102, r102, r102, r102, r102}, null, null)));
        DrawableCompat.setTint(r103, r101);
        setBackground(r103);
    }

    public BadgeView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f177920b = -1;
        this.f177924f = true;
        this.f177925g = 7;
        this.f177926h = 14;
        this.f177927i = 10.0f;
        this.f177928j = 99;
        this.f177929k = new Rect();
        int r103 = c.f47296a;
        this.f177930l = c.c(4, getContext(), true);
        this.f177931m = c.c(1, getContext(), true);
        this.f177919a = ContextCompat.getColor(r100, R.color.shopping_home_color_FF3344);
        setMode(1);
        setTextSize(0, c.c(Float.valueOf(10.0f), getContext(), true));
        setTextColor(ContextCompat.getColor(r100, R.color.shopping_home_color_FFFFFF));
        setGravity(17);
        setClickable(false);
        setIncludeFontPadding(false);
        setSingleLine();
    }

    public /* synthetic */ BadgeView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.widget.TextView, android.view.View
    public final void setPadding(int r100, int r101, int r102, int r103) {
        A();
    }
}
