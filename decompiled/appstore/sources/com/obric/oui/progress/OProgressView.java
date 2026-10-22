package com.obric.oui.progress;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$styleable;

/* JADX INFO: loaded from: classes4.dex */
public class OProgressView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint f16443a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Path f16444b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RectF f16445c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RectF f16446d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f16447e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f16448f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f16449g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f16450h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f16451i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f16452j;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        int backgroundColor;
        int backgroundColorRes;
        int progress;
        int progressColor;
        int progressColorRes;

        public class a implements Parcelable.Creator {
            public a() {
            }

            public SavedState a(Parcel r10) {
                return new SavedState(r10, null);
            }

            public SavedState[] b(int r10) {
                return new SavedState[r10];
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Object createFromParcel(Parcel r10) {
                return a(r10);
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Object[] newArray(int r10) {
                return b(r10);
            }
        }

        static {
            CREATOR = new a();
        }

        public /* synthetic */ SavedState(Parcel r10, a r11) {
            this(r10);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r10, int r11) {
            super.writeToParcel(r10, r11);
            r10.writeInt(this.progress);
            r10.writeInt(this.progressColorRes);
            r10.writeInt(this.backgroundColorRes);
            r10.writeInt(this.progressColor);
            r10.writeInt(this.backgroundColor);
        }

        public SavedState(Parcelable r10) {
            super(r10);
        }

        private SavedState(Parcel r10) {
            super(r10);
            this.progress = r10.readInt();
            this.progressColorRes = r10.readInt();
            this.backgroundColorRes = r10.readInt();
            this.progressColor = r10.readInt();
            this.backgroundColor = r10.readInt();
        }
    }

    public static /* synthetic */ class a {
    }

    public OProgressView(Context r10) {
        this(r10, null);
    }

    public final int a(float r10) {
        return (int) (r10 * Resources.getSystem().getDisplayMetrics().density);
    }

    public final void b() {
        if (this.f16451i == 0) goto L6;
        this.f16449g = ContextCompat.b(getContext(), this.f16451i);
    L6:
        if (this.f16452j == 0) goto L8;
        this.f16450h = ContextCompat.b(getContext(), this.f16452j);
    L8:
        invalidate();
    }

    public int getBackgroundColor() {
        return this.f16450h;
    }

    public int getProgress() {
        return this.f16448f;
    }

    public int getProgressColor() {
        return this.f16449g;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration r10) {
        super.onConfigurationChanged(r10);
        b();
    }

    @Override // android.view.View
    public void onDraw(Canvas r10) {
        super.onDraw(r10);
        if (this.f16443a != null) goto L5;
        this.f16443a = new Paint();
    L5:
        this.f16443a.reset();
        this.f16443a.setStyle(Paint.Style.FILL);
        this.f16443a.setAntiAlias(true);
        float r11 = getHeight();
        float r12 = (r11 - this.f16447e) / 2.0f;
        if (this.f16445c != null) goto L8;
        this.f16445c = new RectF();
    L8:
        float r13 = r11 - r12;
        this.f16445c.set(0.0f, r12, getWidth(), r13);
        if (this.f16446d != null) goto L11;
        this.f16446d = new RectF();
    L11:
        this.f16446d.set(0.0f, r12, (getWidth() * getProgress()) / 100.0f, r13);
        r10.save();
        this.f16444b.reset();
        Path r14 = this.f16444b;
        RectF r15 = this.f16445c;
        float r16 = this.f16447e;
        r14.addRoundRect(r15, r16, r16, Path.Direction.CW);
        r10.clipPath(this.f16444b);
        this.f16443a.setColor(this.f16450h);
        r10.drawRect(this.f16445c, this.f16443a);
        this.f16443a.setColor(this.f16449g);
        r10.drawRect(this.f16446d, this.f16443a);
        r10.restore();
    }

    @Override // android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
    }

    @Override // android.view.View
    public void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable r10) {
        SavedState r11 = (SavedState) r10;
        super.onRestoreInstanceState(r11.getSuperState());
        setProgress(r11.progress);
        this.f16451i = r11.progressColorRes;
        this.f16452j = r11.backgroundColorRes;
        this.f16449g = r11.progressColor;
        this.f16450h = r11.backgroundColor;
        b();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState r10 = new SavedState(super.onSaveInstanceState());
        r10.progress = this.f16448f;
        r10.progressColorRes = this.f16451i;
        r10.backgroundColorRes = this.f16452j;
        r10.progressColor = this.f16449g;
        r10.backgroundColor = this.f16450h;
        return r10;
    }

    @Override // android.view.View
    public void setBackgroundColor(int r10) {
        this.f16452j = 0;
        this.f16450h = r10;
        invalidate();
    }

    public void setProgress(int r10) {
        if (this.f16448f != r10) goto L5;
        return;
    L5:
        if (r10 > 0) goto L8;
        r10 = 0;
    L10:
        this.f16448f = r10;
        invalidate();
        return;
    L8:
        if (r10 < 100) goto L10;
        r10 = 100;
        goto L10
    }

    public void setProgressBackgroundHeight(float r10) {
        this.f16447e = r10;
    }

    public void setProgressColor(int r10) {
        this.f16451i = 0;
        this.f16449g = r10;
        invalidate();
    }

    public OProgressView(Context r10, AttributeSet r11) {
        this(r10, r11, 0);
    }

    public OProgressView(Context r10, AttributeSet r11, int r12) {
        this(r10, r11, r12, 0);
    }

    public OProgressView(Context r10, AttributeSet r11, int r12, int r13) {
        super(r10, r11, r12, r13);
        this.f16444b = new Path();
        this.f16451i = 0;
        this.f16452j = 0;
        TypedArray r14 = r10.obtainStyledAttributes(r11, R$styleable.OProgressView, r12, r13);
        this.f16448f = r14.getInt(R$styleable.OProgressView_oui_progress, 0);
        this.f16451i = r14.getResourceId(R$styleable.OProgressView_oui_progress_color, R$color.oui_fill_highlighted);
        this.f16452j = r14.getResourceId(R$styleable.OProgressView_oui_background_color, R$color.oui_line_2);
        setProgressBackgroundHeight(r14.getDimensionPixelSize(R$styleable.OProgressView_oui_background_height, a(6.0f)));
        b();
        r14.recycle();
    }
}
