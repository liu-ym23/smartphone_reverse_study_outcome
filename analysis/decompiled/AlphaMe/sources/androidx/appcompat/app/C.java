package androidx.appcompat.app;

import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.appcompat.widget.ContentFrameLayout;
import stepos.support.v7.app.AbstractC0880z;

/* loaded from: classes.dex */
public final class C extends ContentFrameLayout {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2465a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2466b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C(Object obj, j.e eVar, int i4) {
        super(eVar, null);
        this.f2465a = i4;
        this.f2466b = obj;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int i4 = this.f2465a;
        Object obj = this.f2466b;
        switch (i4) {
            case 0:
                if (!((F) obj).g(keyEvent) && !super.dispatchKeyEvent(keyEvent)) {
                    break;
                }
                break;
            default:
                if (!((AbstractC0880z) obj).k(keyEvent) && !super.dispatchKeyEvent(keyEvent)) {
                    break;
                }
                break;
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int i4 = this.f2465a;
        Object obj = this.f2466b;
        switch (i4) {
            case 0:
                if (motionEvent.getAction() == 0) {
                    int x4 = (int) motionEvent.getX();
                    int y4 = (int) motionEvent.getY();
                    if (x4 < -5 || y4 < -5 || x4 > getWidth() + 5 || y4 > getHeight() + 5) {
                        F f4 = (F) obj;
                        f4.f(f4.o(0), true);
                        break;
                    }
                }
                break;
            default:
                if (motionEvent.getAction() == 0) {
                    int x5 = (int) motionEvent.getX();
                    int y5 = (int) motionEvent.getY();
                    if (x5 < -5 || y5 < -5 || x5 > getWidth() + 5 || y5 > getHeight() + 5) {
                        AbstractC0880z abstractC0880z = (AbstractC0880z) obj;
                        abstractC0880z.r(abstractC0880z.u(0), true);
                        break;
                    }
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public final void setBackgroundResource(int i4) {
        switch (this.f2465a) {
            case 0:
                setBackgroundDrawable(Z2.I.o(getContext(), i4));
                break;
            default:
                setBackgroundDrawable(androidx.appcompat.widget.A.a().b(getContext(), i4));
                break;
        }
    }
}
