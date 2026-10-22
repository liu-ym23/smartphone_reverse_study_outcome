package com.stepos.ailauncher.foundation.appui.card.provider.amap;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.R$drawable;
import f.C4027a;
import kotlin.Metadata;
import u0.C5566a;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0011\b\u0001\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0014¢\u0006\u0004\b\u0012\u0010\u0013J/\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u000fH\u0014¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u0015\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0015\u0010\u001bR\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u001cR\u0016\u0010\u001d\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001c¨\u0006 "}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/k0;", "Landroidx/appcompat/widget/AppCompatTextView;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "", "score", "LY8/t;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;)V", "", "chosen", "setChosen", "(Z)V", "", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "w", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "oldw", "oldh", "onSizeChanged", "(IIII)V", "f", "()V", "Z", "styleApplied", "Companion", Const.INTENT_KEY_APIKEY, "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@SuppressLint({"ViewConstructor"})
/* loaded from: classes3.dex */
public final class k0 extends AppCompatTextView {

    @Deprecated
    public static final int COLOR_NORMAL_STAR = -15066598;

    @Deprecated
    public static final int COLOR_NORMAL_TEXT = -15066598;

    @Deprecated
    public static final int COLOR_SELECTED_STAR = -1;

    @Deprecated
    public static final int COLOR_SELECTED_TEXT = -1;
    private static final a Companion = new a(null);

    @Deprecated
    public static final float HEIGHT_DP = 20.0f;

    @Deprecated
    public static final float NORMAL_ELEVATION_DP = 1.0f;

    @Deprecated
    public static final float PAD_H_DP = 9.0f;

    @Deprecated
    public static final float SELECTED_ELEVATION_DP = 6.0f;

    @Deprecated
    public static final float STAR_DP = 10.0f;

    @Deprecated
    public static final float STAR_PAD_DP = 2.0f;

    @Deprecated
    public static final float TIP_DP = 3.0f;

    @Deprecated
    public static final float WIDTH_DP = 44.0f;
    private boolean chosen;
    private boolean styleApplied;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0006\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\u0006R\u0014\u0010\f\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u000e8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000e8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u000e8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u000e8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/k0$a;", "", "<init>", "()V", "", "WIDTH_DP", "F", "HEIGHT_DP", "TIP_DP", "PAD_H_DP", "STAR_DP", "STAR_PAD_DP", "SELECTED_ELEVATION_DP", "NORMAL_ELEVATION_DP", "", "COLOR_NORMAL_TEXT", "I", "COLOR_NORMAL_STAR", "COLOR_SELECTED_TEXT", "COLOR_SELECTED_STAR", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public a() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k0(Context context) {
        super(context);
        kotlin.jvm.internal.p.i(context, "context");
        setGravity(17);
        setIncludeFontPadding(false);
        setTextSize(2, 11.0f);
        setMaxLines(1);
        setChosen(false);
    }

    public final void f() {
        int i10 = this.chosen ? -1 : -15066598;
        Drawable drawableB = C4027a.b(getContext(), R$drawable.ic_card_hotel_rating);
        if (drawableB == null) {
            return;
        }
        Drawable drawableR = C5566a.r(drawableB.mutate());
        kotlin.jvm.internal.p.h(drawableR, "wrap(...)");
        C5566a.n(drawableR, i10);
        C5566a.p(drawableR, PorterDuff.Mode.SRC_IN);
        int i11 = (int) (getResources().getDisplayMetrics().density * 10.0f);
        drawableR.setBounds(0, 0, i11, i11);
        setCompoundDrawablesRelative(drawableR, null, null, null);
        setCompoundDrawablePadding((int) (getResources().getDisplayMetrics().density * 2.0f));
        androidx.core.widget.i.e(this, ColorStateList.valueOf(i10));
    }

    public final void g(String score) {
        if (score == null || La.H.x0(score)) {
            score = null;
        }
        if (score == null) {
            setText("");
            h();
        } else {
            setText(score);
            f();
        }
    }

    public final void h() {
        setCompoundDrawablesRelative(null, null, null, null);
        setCompoundDrawablePadding(0);
        androidx.core.widget.i.e(this, null);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        float f10 = getResources().getDisplayMetrics().density;
        int i10 = (int) (((this.chosen ? 3.0f : 0.0f) + 20.0f) * f10);
        super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(i10, 1073741824));
        int i11 = (int) (f10 * 44.0f);
        if (getMeasuredWidth() < i11) {
            setMeasuredDimension(i11, i10);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int w10, int h10, int oldw, int oldh) {
        super.onSizeChanged(w10, h10, oldw, oldh);
        setPivotX(w10 / 2.0f);
        setPivotY(h10);
    }

    public final void setChosen(boolean chosen) {
        if (this.styleApplied && this.chosen == chosen) {
            return;
        }
        this.styleApplied = true;
        boolean z10 = this.chosen;
        this.chosen = chosen;
        float f10 = getResources().getDisplayMetrics().density;
        int i10 = (int) (9.0f * f10);
        float f11 = 3.0f * f10;
        int i11 = (int) f11;
        if (chosen) {
            setBackgroundResource(R$drawable.bg_poi_marker_selected);
            setTextColor(-1);
            setPadding(i10, 0, i10, i11);
            setElevation(f10 * 6.0f);
        } else {
            setBackgroundResource(R$drawable.bg_poi_marker_normal);
            setTextColor(-15066598);
            setPadding(i10, 0, i10, 0);
            setElevation(f10 * 1.0f);
        }
        if (z10 != chosen) {
            float translationY = getTranslationY();
            if (chosen) {
                f11 = -f11;
            }
            setTranslationY(translationY + f11);
        }
        CharSequence text = getText();
        kotlin.jvm.internal.p.h(text, "getText(...)");
        if (text.length() > 0) {
            f();
        }
        requestLayout();
    }
}
