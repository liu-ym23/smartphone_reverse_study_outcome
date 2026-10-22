package androidx.fragment.app;

import android.os.Bundle;
import android.view.SavedStateRegistry;
import android.view.internal.SavedStateHandleImpl;

/* loaded from: classes2.dex */
public final /* synthetic */ class e implements SavedStateRegistry.SavedStateProvider {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1962a;
    public final /* synthetic */ Object b;

    public /* synthetic */ e(Object obj, int i) {
        this.f1962a = i;
        this.b = obj;
    }

    @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
    public final Bundle saveState() {
        int i = this.f1962a;
        Object obj = this.b;
        switch (i) {
            case 0:
                return ((FragmentActivity) obj).lambda$init$0();
            case 1:
                return ((FragmentManager) obj).lambda$attachController$4();
            default:
                return SavedStateHandleImpl.savedStateProvider$lambda$0((SavedStateHandleImpl) obj);
        }
    }
}
