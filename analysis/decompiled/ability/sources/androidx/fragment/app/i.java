package androidx.fragment.app;

import androidx.fragment.app.DefaultSpecialEffectsController;
import androidx.fragment.app.SpecialEffectsController;

/* loaded from: classes2.dex */
public final /* synthetic */ class i implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1966a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ SpecialEffectsController.Operation c;

    public /* synthetic */ i(Object obj, SpecialEffectsController.Operation operation, int i) {
        this.f1966a = i;
        this.b = obj;
        this.c = operation;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1966a) {
            case 0:
                SpecialEffectsController.enqueue$lambda$4$lambda$2((SpecialEffectsController) this.b, (SpecialEffectsController.FragmentStateManagerOperation) this.c);
                break;
            case 1:
                SpecialEffectsController.enqueue$lambda$4$lambda$3((SpecialEffectsController) this.b, (SpecialEffectsController.FragmentStateManagerOperation) this.c);
                break;
            default:
                DefaultSpecialEffectsController.startTransitions$lambda$14$lambda$13((DefaultSpecialEffectsController.TransitionInfo) this.b, this.c);
                break;
        }
    }
}
