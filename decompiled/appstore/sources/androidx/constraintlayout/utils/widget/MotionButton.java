package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.R$styleable;

/* JADX INFO: loaded from: classes.dex */
public class MotionButton extends AppCompatButton {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f2122a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f2123b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Path f2124c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ViewOutlineProvider f2125d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public RectF f2126e;

    public class a extends ViewOutlineProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MotionButton f2127a;

        public a(MotionButton r10) {
            this.f2127a = r10;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View r10, Outline r11) {
            int r12 = this.f2127a.getWidth();
            int r13 = this.f2127a.getHeight();
            r11.setRoundRect(0, 0, r12, r13, (Math.min(r12, r13) * MotionButton.a(this.f2127a)) / 2.0f);
        }
    }

    public class b extends ViewOutlineProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MotionButton f2128a;

        public b(MotionButton r10) {
            this.f2128a = r10;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View r10, Outline r11) {
            r11.setRoundRect(0, 0, this.f2128a.getWidth(), this.f2128a.getHeight(), MotionButton.b(this.f2128a));
        }
    }

    public MotionButton(Context r10) {
        super(r10);
        this.f2122a = 0.0f;
        this.f2123b = Float.NaN;
        c(r10, null);
    }

    public static /* synthetic */ float a(MotionButton r10) {
        return r10.f2122a;
    }

    public static /* synthetic */ float b(MotionButton r10) {
        return r10.f2123b;
    }

    private void c(Context r10, AttributeSet r11) {
        int r12 = 0;
        setPadding(0, 0, 0, 0);
        if (r11 == null) goto L19;
        TypedArray r13 = getContext().obtainStyledAttributes(r11, R$styleable.ImageFilterView);
        int r14 = r13.getIndexCount();
    L5:
        if (r12 >= r14) goto L13;
        int r15 = r13.getIndex(r12);
        if (r15 != R$styleable.ImageFilterView_round) goto L10;
        setRound(r13.getDimension(r15, 0.0f));
    L12:
        r12 = r12 + 1;
        goto L5
    L10:
        if (r15 != R$styleable.ImageFilterView_roundPercent) goto L12;
        setRoundPercent(r13.getFloat(r15, 0.0f));
        goto L12
    L13:
        r13.recycle();
        return;
    }

    @Override // android.view.View
    public void draw(Canvas r10) {
        super.draw(r10);
    }

    public float getRound() {
        return this.f2123b;
    }

    public float getRoundPercent() {
        return this.f2122a;
    }

    @RequiresApi(21)
    public void setRound(float r10) {
        if (Float.isNaN(r10) == false) goto L7;
        this.f2123b = r10;
        float r11 = this.f2122a;
        this.f2122a = -1.0f;
        setRoundPercent(r11);
        return;
    L7:
        if (this.f2123b == r10) goto L9;
        boolean r12 = true;
    L10:
        this.f2123b = r10;
        if (r10 != 0.0f) goto L13;
        setClipToOutline(false);
    L23:
        if (r12 == false) goto L26;
        invalidateOutline();
        return;
    L26:
        return;
    L13:
        if (this.f2124c != null) goto L16;
        this.f2124c = new Path();
    L16:
        if (this.f2126e != null) goto L19;
        this.f2126e = new RectF();
    L19:
        if (this.f2125d != null) goto L21;
        b r13 = new b(this);
        this.f2125d = r13;
        setOutlineProvider(r13);
    L21:
        setClipToOutline(true);
        this.f2126e.set(0.0f, 0.0f, getWidth(), getHeight());
        this.f2124c.reset();
        Path r14 = this.f2124c;
        RectF r15 = this.f2126e;
        float r16 = this.f2123b;
        r14.addRoundRect(r15, r16, r16, Path.Direction.CW);
        goto L23
    L9:
        r12 = false;
        goto L10
    }

    @RequiresApi(21)
    public void setRoundPercent(float r10) {
        if (this.f2122a == r10) goto L5;
        boolean r11 = true;
    L6:
        this.f2122a = r10;
        if (r10 != 0.0f) goto L9;
        setClipToOutline(false);
    L19:
        if (r11 == false) goto L22;
        invalidateOutline();
        return;
    L22:
        return;
    L9:
        if (this.f2124c != null) goto L12;
        this.f2124c = new Path();
    L12:
        if (this.f2126e != null) goto L15;
        this.f2126e = new RectF();
    L15:
        if (this.f2125d != null) goto L17;
        a r12 = new a(this);
        this.f2125d = r12;
        setOutlineProvider(r12);
    L17:
        setClipToOutline(true);
        int r13 = getWidth();
        int r14 = getHeight();
        float r15 = (Math.min(r13, r14) * this.f2122a) / 2.0f;
        this.f2126e.set(0.0f, 0.0f, r13, r14);
        this.f2124c.reset();
        this.f2124c.addRoundRect(this.f2126e, r15, r15, Path.Direction.CW);
        goto L19
    L5:
        r11 = false;
        goto L6
    }

    public MotionButton(Context r10, AttributeSet r11) {
        super(r10, r11);
        this.f2122a = 0.0f;
        this.f2123b = Float.NaN;
        c(r10, r11);
    }

    public MotionButton(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.f2122a = 0.0f;
        this.f2123b = Float.NaN;
        c(r10, r11);
    }
}
