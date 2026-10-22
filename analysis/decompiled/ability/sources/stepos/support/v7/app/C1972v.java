package stepos.support.v7.app;

import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.ContentFrameLayout;

/* renamed from: stepos.support.v7.app.v, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1972v extends ContentFrameLayout {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AbstractC1975y f6341a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1972v(AbstractC1975y abstractC1975y, ContextThemeWrapper contextThemeWrapper) {
        super(contextThemeWrapper);
        this.f6341a = abstractC1975y;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.f6341a.j(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            int x10 = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (x10 < -5 || y < -5 || x10 > getWidth() + 5 || y > getHeight() + 5) {
                AbstractC1975y abstractC1975y = this.f6341a;
                abstractC1975y.s(abstractC1975y.v(0), true);
                return true;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public final void setBackgroundResource(int i) {
        setBackgroundDrawable(AppCompatDrawableManager.get().getDrawable(getContext(), i));
    }
}
