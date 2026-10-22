package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.SeekBar;
import g.C0728a;

/* renamed from: androidx.appcompat.widget.y, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0454y extends SeekBar {

    /* renamed from: a, reason: collision with root package name */
    private final C0455z f8617a;

    public C0454y(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0728a.f16817N);
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        this.f8617a.h();
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        this.f8617a.i();
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f8617a.g(canvas);
    }

    public C0454y(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        V.a(this, getContext());
        C0455z c0455z = new C0455z(this);
        this.f8617a = c0455z;
        c0455z.c(attributeSet, i5);
    }
}
