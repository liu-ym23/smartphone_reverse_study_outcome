package androidx.constraintlayout.motion.widget;

import android.graphics.RectF;
import android.view.View;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public abstract class h extends c {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f1872g;

    public h() {
        this.f1872g = c.f1833f;
    }

    @Override // androidx.constraintlayout.motion.widget.c
    public void d(HashSet r10) {
    }

    public abstract boolean m(int r10, int r11, RectF r12, RectF r13, float r14, float r15);

    public abstract void n(View r10, RectF r11, RectF r12, float r13, float r14, String[] r15, float[] r16);
}
