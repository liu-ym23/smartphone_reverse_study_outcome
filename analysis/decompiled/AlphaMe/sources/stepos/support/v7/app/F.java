package stepos.support.v7.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.util.Log;

/* loaded from: classes2.dex */
public final class F extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14267a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ G f14268b;

    public /* synthetic */ F(G g4, int i4) {
        this.f14267a = i4;
        this.f14268b = g4;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.f14267a) {
            case 1:
                super.onAnimationEnd(animator);
                G g4 = this.f14268b;
                g4.f14273d.superFinish();
                g4.f14273d.overridePendingTransition(0, 0);
                g4.f14277h = null;
                I.b().getClass();
                I.f14282g = null;
                break;
            default:
                super.onAnimationEnd(animator);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        int i4 = this.f14267a;
        G g4 = this.f14268b;
        switch (i4) {
            case 0:
                if (!g4.c()) {
                    I iB = I.b();
                    if (iB.f14283a != null) {
                        if (iB.f14284b.getPositionState() == iB.f14288f || iB.f14284b.getPositionState() == 1) {
                            Log.d(D.POPUP_STACK_TAG, " bottom stack pause , enter stack state ");
                            int iC = (int) m2.o.c(iB.f14283a, 10.0f);
                            if (iB.f14284b.getPositionState() == 0) {
                                iC = (int) m2.o.c(iB.f14283a, 40.0f);
                            }
                            W.n nVar = new W.n();
                            nVar.a(0.88f);
                            nVar.b(340.0f);
                            W.m mVar = iB.f14285c;
                            mVar.f1974m = nVar;
                            mVar.g(iB.f14284b.getCurrentScrollY());
                            mVar.f1974m.f1985i = iB.f14284b.getCurrentScrollY() + iC;
                            mVar.i();
                            W.n nVar2 = new W.n();
                            nVar2.a(0.88f);
                            nVar2.b(340.0f);
                            W.m mVar2 = iB.f14286d;
                            mVar2.f1974m = nVar2;
                            mVar2.g(100.0f);
                            mVar2.f1974m.f1985i = 93.0f;
                            mVar2.i();
                            iB.f14287e = true;
                            break;
                        }
                    }
                }
                break;
            default:
                if (!g4.c()) {
                    Log.d(D.POPUP_STACK_TAG, " top stack start exit Anim, try to call bottom stack do stackExit ");
                    I.b().a();
                    break;
                }
                break;
        }
    }
}
