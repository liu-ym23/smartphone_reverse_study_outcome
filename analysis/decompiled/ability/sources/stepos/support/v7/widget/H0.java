package stepos.support.v7.widget;

import android.view.View;
import androidx.core.view.ViewCompat;

/* loaded from: classes4.dex */
public final class H0 {

    /* renamed from: a, reason: collision with root package name */
    public final View f6468a;
    public int b;
    public int c;
    public int d;

    public H0(View view) {
        this.f6468a = view;
    }

    public final void a() {
        int i = this.d;
        View view = this.f6468a;
        ViewCompat.offsetTopAndBottom(view, i - (view.getTop() - this.b));
        ViewCompat.offsetLeftAndRight(view, 0 - (view.getLeft() - this.c));
    }
}
