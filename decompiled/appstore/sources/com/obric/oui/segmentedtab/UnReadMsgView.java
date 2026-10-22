package com.obric.oui.segmentedtab;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import bg.h;
import com.google.common.primitives.Ints;
import com.obric.common.oui.R$styleable;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0011\u0010\u000fJ\u0017\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0018\u0010\u0019J7\u0010 \u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0006H\u0014¢\u0006\u0004\b \u0010!J\u0017\u0010#\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\u0006H\u0016¢\u0006\u0004\b#\u0010\u000fJ\u0015\u0010%\u001a\u00020\n2\u0006\u0010$\u001a\u00020\u0006¢\u0006\u0004\b%\u0010\u000fJ\u0015\u0010'\u001a\u00020\n2\u0006\u0010&\u001a\u00020\u001a¢\u0006\u0004\b'\u0010(J\u0015\u0010*\u001a\u00020\n2\u0006\u0010)\u001a\u00020\u001a¢\u0006\u0004\b*\u0010(J\r\u0010+\u001a\u00020\u0006¢\u0006\u0004\b+\u0010,J\r\u0010-\u001a\u00020\u0006¢\u0006\u0004\b-\u0010,J\r\u0010.\u001a\u00020\u0006¢\u0006\u0004\b.\u0010,J\r\u0010/\u001a\u00020\u0006¢\u0006\u0004\b/\u0010,J\u000f\u00100\u001a\u00020\u001aH\u0002¢\u0006\u0004\b0\u00101J\u000f\u00102\u001a\u00020\u001aH\u0002¢\u0006\u0004\b2\u00101J'\u00106\u001a\u00020\n2\u0006\u00104\u001a\u0002032\u0006\u00105\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u0006H\u0002¢\u0006\u0004\b6\u00107J\u000f\u00108\u001a\u00020\nH\u0002¢\u0006\u0004\b8\u00109R\u0014\u0010<\u001a\u0002038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010\"\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010=R\u0016\u0010\r\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u0010=R\u0016\u0010\u0010\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u0010=R\u0016\u0010$\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010=R\u0016\u0010&\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u0010>R\u0016\u0010)\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u0010>¨\u0006?"}, d2 = {"Lcom/obric/oui/segmentedtab/UnReadMsgView;", "Landroidx/appcompat/widget/AppCompatTextView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "e", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "cornerRadius", "setCornerRadius", "(I)V", "strokeWidth", "setStrokeWidth", "", "dp", "b", "(F)I", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "", "changed", "left", "top", "right", "bottom", "onLayout", "(ZIIII)V", "backgroundColor", "setBackgroundColor", "strokeColor", "setStrokeColor", "isRadiusHalfHeight", "setIsRadiusHalfHeight", "(Z)V", "isWidthHeightEqual", "setIsWidthHeightEqual", "getBackgroundColor", "()I", "getCornerRadius", "getStrokeWidth", "getStrokeColor", "c", "()Z", "d", "Landroid/graphics/drawable/GradientDrawable;", "gd", "color", "g", "(Landroid/graphics/drawable/GradientDrawable;II)V", "f", "()V", "a", "Landroid/graphics/drawable/GradientDrawable;", "gdBackground", "I", "Z", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UnReadMsgView extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final GradientDrawable f16717a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f16718b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f16719c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f16720d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f16721e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f16722f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f16723g;

    @JvmOverloads
    public UnReadMsgView(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        this(r10, r11, r12, 6, null);
    }

    private final int b(float r10) {
        return (int) ((r10 * getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    private final void e(Context r10, AttributeSet r11) {
        TypedArray r12 = r10.obtainStyledAttributes(r11, R$styleable.MsgView);
        q.f(r12, "context.obtainStyledAttr…trs, R.styleable.MsgView)");
        this.f16718b = r12.getColor(R$styleable.MsgView_mv_backgroundColor, 0);
        this.f16719c = r12.getDimensionPixelSize(R$styleable.MsgView_mv_cornerRadius, 0);
        this.f16720d = r12.getDimensionPixelSize(R$styleable.MsgView_mv_strokeWidth, 0);
        this.f16721e = r12.getColor(R$styleable.MsgView_mv_strokeColor, 0);
        this.f16722f = r12.getBoolean(R$styleable.MsgView_mv_isRadiusHalfHeight, false);
        this.f16723g = r12.getBoolean(R$styleable.MsgView_mv_isWidthHeightEqual, false);
        r12.recycle();
    }

    private final void setCornerRadius(int r10) {
        this.f16719c = b(r10);
        f();
    }

    private final void setStrokeWidth(int r10) {
        this.f16720d = b(r10);
        f();
    }

    public final boolean c() {
        return this.f16722f;
    }

    public final boolean d() {
        return this.f16723g;
    }

    public final void f() {
        StateListDrawable r10 = new StateListDrawable();
        g(this.f16717a, this.f16718b, this.f16721e);
        r10.addState(new int[]{-16842919}, this.f16717a);
        setBackground(r10);
    }

    public final void g(GradientDrawable r10, int r11, int r12) {
        r10.setColor(r11);
        r10.setCornerRadius(this.f16719c);
        r10.setStroke(this.f16720d, r12);
    }

    public final int getBackgroundColor() {
        return this.f16718b;
    }

    public final int getCornerRadius() {
        return this.f16719c;
    }

    public final int getStrokeColor() {
        return this.f16721e;
    }

    public final int getStrokeWidth() {
        return this.f16720d;
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
        if (c() == false) goto L5;
        setCornerRadius(getHeight() / 2);
        return;
    L5:
        f();
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onMeasure(int r10, int r11) {
        if (d() == true) goto L5;
    L10:
        super.onMeasure(r10, r11);
        return;
    L5:
        if (getWidth() <= 0) goto L10;
        if (getHeight() <= 0) goto L10;
        int r12 = View.MeasureSpec.makeMeasureSpec(h.d(getWidth(), getHeight()), Ints.MAX_POWER_OF_TWO);
        super.onMeasure(r12, r12);
    }

    @Override // android.view.View
    public void setBackgroundColor(int r10) {
        this.f16718b = r10;
        f();
    }

    public final void setIsRadiusHalfHeight(boolean r10) {
        this.f16722f = r10;
        f();
    }

    public final void setIsWidthHeightEqual(boolean r10) {
        this.f16723g = r10;
        f();
    }

    public final void setStrokeColor(int r10) {
        this.f16721e = r10;
        f();
    }

    @JvmOverloads
    public UnReadMsgView(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        this(r10, r11, r12, 4, null);
    }

    public /* synthetic */ UnReadMsgView(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    @JvmOverloads
    public UnReadMsgView(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        super(r10, r11, r12);
        this.f16717a = new GradientDrawable();
        e(r10, r11);
    }
}
