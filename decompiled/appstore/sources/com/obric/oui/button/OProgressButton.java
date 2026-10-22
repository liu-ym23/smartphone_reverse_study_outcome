package com.obric.oui.button;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import androidx.core.content.ContextCompat;
import bg.h;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$drawable;
import com.obric.common.oui.R$styleable;
import com.tmall.wireless.tangram.structure.card.FixCard;
import jb.d;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J/\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001e\u0010\u001dJ\u000f\u0010\u001f\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001f\u0010\u001dR\u0016\u0010\"\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010%\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010(\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010*\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010'R\u0014\u0010,\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010'R\u0016\u0010-\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010'R\u0016\u00100\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00104\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103¨\u00065"}, d2 = {"Lcom/obric/oui/button/OProgressButton;", "Lcom/obric/oui/button/OButton;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "isProgressMode", "", "setProgressMode", "(Z)V", "progressPercentage", "setProgress", "(I)V", "", "progress", "n", "(F)V", "w", "h", "oldw", "oldh", "onSizeChanged", "(IIII)V", "o", "()V", "m", "p", "r", "Z", "isInProgressMode", "s", "Ljava/lang/Integer;", "defaultBackgroundColor", "t", "I", "coveredTextColor", "u", "uncoveredTextColor", "v", "progressBgDrawableRes", "currentProgress", FixCard.FixStyle.KEY_X, "F", "currentProgressFloat", "Ljb/d;", FixCard.FixStyle.KEY_Y, "Ljb/d;", "progressAnimator", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OProgressButton extends OButton {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f12512r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Integer f12513s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int f12514t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f12515u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f12516v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f12517w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f12518x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public d f12519y;

    @JvmOverloads
    public OProgressButton(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        this(r10, r11, r12, 4, null);
    }

    public static final /* synthetic */ int h(OProgressButton r10) {
        return r10.f12517w;
    }

    public static final /* synthetic */ float i(OProgressButton r10) {
        return r10.f12518x;
    }

    public static final /* synthetic */ boolean j(OProgressButton r10) {
        return r10.f12512r;
    }

    public static final /* synthetic */ void k(OProgressButton r10, float r11) {
        r10.f12518x = r11;
    }

    public static final /* synthetic */ void l(OProgressButton r10) {
        r10.p();
    }

    public final void m() {
        Drawable r10 = ContextCompat.d(getContext(), this.f12516v);
        ClipDrawable r11 = null;
        if (r10 != null) goto L5;
        Drawable r12 = null;
    L6:
        setBackground(r12);
        Drawable r13 = getBackground();
        if ((r13 instanceof LayerDrawable) == false) goto L16;
        Drawable r14 = ((LayerDrawable) r13).findDrawableByLayerId(R.id.progress);
        if ((r14 instanceof ClipDrawable) == false) goto L11;
        r11 = (ClipDrawable) r14;
    L11:
        Integer r15 = this.f12513s;
        if (r15 == null) goto L16;
        if (r11 == null) goto L16;
        q.d(r15);
        r11.setTint(r15.intValue());
    L16:
        n(this.f12518x);
        p();
        return;
    L5:
        r12 = r10.mutate();
        goto L6
    }

    public final void n(float r10) {
        Drawable r11 = getBackground();
        if ((r11 instanceof LayerDrawable) == false) goto L12;
        Drawable r12 = ((LayerDrawable) r11).findDrawableByLayerId(R.id.progress);
        if ((r12 instanceof ClipDrawable) == false) goto L7;
        ClipDrawable r13 = (ClipDrawable) r12;
    L8:
        if (r13 == null) goto L13;
        r13.setLevel((int) (r10 * 100));
        return;
    L13:
        return;
    L7:
        r13 = null;
        goto L8
    }

    public final void o() {
        if (this.f12512r == false) goto L5;
        m();
        return;
    L5:
        getPaint().setShader(null);
        setTextColor(this.f12514t);
        if (this.f12513s == null) goto L8;
        Integer r10 = this.f12513s;
        q.d(r10);
        setBackground(new ColorDrawable(r10.intValue()));
    L8:
        invalidate();
    }

    @Override // android.view.View
    public void onSizeChanged(int r10, int r11, int r12, int r13) {
        super.onSizeChanged(r10, r11, r12, r13);
        if (this.f12512r == false) goto L6;
        p();
        return;
    }

    public final void p() {
        if (getWidth() > 0) goto L5;
        return;
    L5:
        float r10 = this.f12518x / 100.0f;
        float r11 = getWidth();
        float r12 = h.j(r10, 0.0f, 1.0f);
        if (r12 > 0.0f) goto L9;
        getPaint().setShader(null);
        setTextColor(this.f12515u);
    L12:
        invalidate();
        return;
    L9:
        if (r12 < 1.0f) goto L11;
        getPaint().setShader(null);
        setTextColor(this.f12514t);
        goto L12
    L11:
        int r13 = this.f12514t;
        int r14 = this.f12515u;
        getPaint().setShader(new LinearGradient(0.0f, 0.0f, r11, 0.0f, new int[]{r13, r13, r14, r14}, new float[]{0.0f, r12, r12, 1.0f}, Shader.TileMode.CLAMP));
        setTextColor(this.f12514t);
        goto L12
    }

    public final void setProgress(int r10) {
        if (this.f12517w != r10) goto L5;
        return;
    L5:
        d r11 = this.f12519y;
        if (r11 == null) goto L9;
        d.c(r11, false, 1, null);
    L9:
        this.f12517w = r10;
        float r12 = r10;
        this.f12518x = r12;
        n(r12);
        if (this.f12512r == false) goto L13;
        p();
        return;
    }

    public final void setProgressMode(boolean r10) {
        if (this.f12512r == r10) goto L6;
        this.f12512r = r10;
        o();
        return;
    }

    public /* synthetic */ OProgressButton(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 4) == 0) goto L5;
        r12 = 0;
    L5:
        this(r10, r11, r12);
    }

    @JvmOverloads
    public OProgressButton(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        super(r10, r11, r12, 0, null, 24, null);
        TypedArray r13 = r10.obtainStyledAttributes(r11, R$styleable.OProgressButton);
        q.f(r13, "context.obtainStyledAttr…tyleable.OProgressButton)");
        this.f12514t = r13.getColor(R$styleable.OProgressButton_android_textColor, ContextCompat.b(r10, R$color.oui_on_accent_default));
        this.f12515u = r13.getColor(R$styleable.OProgressButton_oui_progress_button_uncovered_text_color, ContextCompat.b(r10, R$color.oui_accent_6_bg));
        this.f12516v = r13.getResourceId(R$styleable.OProgressButton_oui_progress_bg_resource, R$drawable.o_button_progress_drawable_primary);
        r13.recycle();
        Drawable r14 = getBackground();
        if ((r14 instanceof ColorDrawable) == false) goto L6;
        this.f12513s = Integer.valueOf(((ColorDrawable) r14).getColor());
        return;
    }
}
