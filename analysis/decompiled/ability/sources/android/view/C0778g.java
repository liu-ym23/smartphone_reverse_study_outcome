package android.view;

import android.view.Lifecycle;
import kotlinx.coroutines.flow.i;
import o9.InterfaceC1786l;

/* renamed from: androidx.lifecycle.g, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0778g implements LifecycleEventObserver {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1984a;
    public final /* synthetic */ Object b;

    public /* synthetic */ C0778g(Object obj, int i) {
        this.f1984a = i;
        this.b = obj;
    }

    @Override // android.view.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        int i = this.f1984a;
        Object obj = this.b;
        switch (i) {
            case 0:
                LifecycleKt$eventFlow$1.invokeSuspend$lambda$0((InterfaceC1786l) obj, lifecycleOwner, event);
                break;
            default:
                Lifecycle._get_currentStateFlow_$lambda$0((i) obj, lifecycleOwner, event);
                break;
        }
    }
}
