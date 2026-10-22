package com.stepos.ability.voicewakeup.ui;

import C7.r;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.RenderEffect;
import android.graphics.Shader;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.content.ContextCompat;
import com.stepos.ability.R;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import m9.C1718k;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001R\u0014\u0010\u0005\u001a\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/stepos/ability/voicewakeup/ui/TrainingPhraseCarousel;", "Landroid/widget/FrameLayout;", "", "getCurrentIndex$voicewakeup_release", "()I", "currentIndex", "voicewakeup_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TrainingPhraseCarousel extends FrameLayout {
    public static final /* synthetic */ int m = 0;

    /* renamed from: a, reason: collision with root package name */
    public final int f3429a;
    public final float b;
    public final int c;
    public final int d;
    public final Handler e;
    public final ArrayList f;
    public final int[] g;
    public ValueAnimator h;
    public C1718k i;

    /* renamed from: j, reason: collision with root package name */
    public CharSequence f3430j;
    public int k;
    public int l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TrainingPhraseCarousel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        k.f(context, "context");
        this.f3429a = (int) TypedValue.applyDimension(1, 47, getResources().getDisplayMetrics());
        this.b = 6 * getResources().getDisplayMetrics().density;
        this.c = ContextCompat.getColor(context, R.color.voicewakeup_text_current);
        this.d = ContextCompat.getColor(context, R.color.voicewakeup_text_ghost);
        this.e = new Handler(Looper.getMainLooper());
        int[] iArr = new int[4];
        for (int i = 0; i < 4; i++) {
            iArr[i] = i;
        }
        this.g = iArr;
        this.f3430j = "";
        setClipChildren(true);
        ArrayList arrayList = new ArrayList(4);
        for (int i6 = 0; i6 < 4; i6++) {
            TextView textView = new TextView(context);
            textView.setLayoutParams(new FrameLayout.LayoutParams(-1, this.f3429a));
            textView.setGravity(17);
            textView.setTypeface(null, 1);
            textView.setIncludeFontPadding(false);
            textView.setMaxLines(1);
            textView.setTextSize(2, 30.0f);
            textView.setPivotY(this.f3429a / 2.0f);
            textView.setImportantForAccessibility(2);
            addView(textView);
            arrayList.add(textView);
        }
        this.f = arrayList;
        a();
    }

    public final void a() {
        RenderEffect renderEffectCreateBlurEffect;
        ArrayList arrayList = this.f;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            TextView textView = (TextView) arrayList.get(i);
            int i6 = this.g[i];
            int i10 = (i6 - 1) + this.l;
            textView.setText((i10 < 0 || i10 >= this.k) ? "" : this.f3430j);
            textView.setTranslationY(this.f3429a * i6);
            textView.setAlpha(1.0f);
            b(textView, i6 != 1 ? 0.0f : 1.0f);
            if (i6 == 0) {
                float f = this.b;
                renderEffectCreateBlurEffect = RenderEffect.createBlurEffect(f, f, Shader.TileMode.CLAMP);
            } else {
                renderEffectCreateBlurEffect = null;
            }
            textView.setRenderEffect(renderEffectCreateBlurEffect);
        }
    }

    public final void b(TextView textView, float f) {
        float f7 = (0.19999999f * f) + 0.8f;
        textView.setScaleX(f7);
        textView.setScaleY(f7);
        float fAlpha = Color.alpha(this.d);
        int i = this.c;
        textView.setTextColor(Color.argb((int) (((Color.alpha(i) - Color.alpha(r0)) * f) + fAlpha + 0.5f), (int) (((Color.red(i) - Color.red(r0)) * f) + Color.red(r0) + 0.5f), (int) (((Color.green(i) - Color.green(r0)) * f) + Color.green(r0) + 0.5f), (int) (((Color.blue(i) - Color.blue(r0)) * f) + Color.blue(r0) + 0.5f)));
    }

    public final void c() {
        ValueAnimator valueAnimator = this.h;
        this.h = null;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        a();
        C1718k c1718k = this.i;
        if (c1718k != null) {
            this.i = null;
            if (c1718k.isActive()) {
                c1718k.resumeWith(r.f317a);
            }
        }
    }

    public final void d() {
        c();
        this.l = 0;
        int[] iArr = this.g;
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            iArr[i] = i;
        }
        a();
    }

    /* renamed from: getCurrentIndex$voicewakeup_release, reason: from getter */
    public final int getL() {
        return this.l;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        c();
        super.onDetachedFromWindow();
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i, int i6) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(this.f3429a * 3, BasicMeasure.EXACTLY));
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i6, int i10, int i11) {
        super.onSizeChanged(i, i6, i10, i11);
        setClipBounds(new Rect(0, 0, i, i6));
        float f = i / 2.0f;
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            ((TextView) it.next()).setPivotX(f);
        }
    }
}
