package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.appcompat.R$attr;

/* renamed from: androidx.appcompat.widget.t, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1306t extends SeekBar {

    /* renamed from: a, reason: collision with root package name */
    public final C1307u f9233a;

    public C1306t(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.seekBarStyle);
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        this.f9233a.h();
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        this.f9233a.i();
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f9233a.g(canvas);
    }

    public C1306t(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        O.a(this, getContext());
        C1307u c1307u = new C1307u(this);
        this.f9233a = c1307u;
        c1307u.c(attributeSet, i10);
    }
}
