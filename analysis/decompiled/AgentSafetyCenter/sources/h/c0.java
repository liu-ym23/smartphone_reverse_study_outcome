package h;

import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.appcompat.widget.ContentFrameLayout;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c0 extends ContentFrameLayout {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f4755c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f4756f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c0(Object obj, k.c cVar, int i) {
        super(cVar);
        this.f4755c = i;
        this.f4756f = obj;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        switch (this.f4755c) {
            case 0:
                if (((e0) this.f4756f).s(keyEvent) || super.dispatchKeyEvent(keyEvent)) {
                }
                break;
            default:
                if (((stepos.support.v7.app.o) this.f4756f).o(keyEvent) || super.dispatchKeyEvent(keyEvent)) {
                }
                break;
        }
        return true;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (this.f4755c) {
            case 0:
                if (motionEvent.getAction() == 0) {
                    int x6 = (int) motionEvent.getX();
                    int y10 = (int) motionEvent.getY();
                    if (x6 < -5 || y10 < -5 || x6 > getWidth() + 5 || y10 > getHeight() + 5) {
                        e0 e0Var = (e0) this.f4756f;
                        e0Var.q(e0Var.x(0), true);
                        break;
                    }
                }
                break;
            default:
                if (motionEvent.getAction() == 0) {
                    int x10 = (int) motionEvent.getX();
                    int y11 = (int) motionEvent.getY();
                    if (x10 < -5 || y11 < -5 || x10 > getWidth() + 5 || y11 > getHeight() + 5) {
                        stepos.support.v7.app.o oVar = (stepos.support.v7.app.o) this.f4756f;
                        oVar.n(oVar.r(0), true);
                        break;
                    }
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public final void setBackgroundResource(int i) {
        switch (this.f4755c) {
            case 0:
                setBackgroundDrawable(id.k.v(i, getContext()));
                break;
            default:
                setBackgroundDrawable(m.s.a().b(i, getContext()));
                break;
        }
    }
}
