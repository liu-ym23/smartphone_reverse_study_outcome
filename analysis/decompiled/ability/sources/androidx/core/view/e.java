package androidx.core.view;

import android.view.Lifecycle;
import android.view.LifecycleEventObserver;
import android.view.LifecycleOwner;
import android.view.compose.LifecycleEffectKt;
import android.view.compose.LifecycleResumePauseEffectScope;
import android.view.compose.LifecycleStartStopEffectScope;
import java.io.Serializable;
import kotlin.jvm.internal.Ref$ObjectRef;

/* loaded from: classes2.dex */
public final /* synthetic */ class e implements LifecycleEventObserver {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1935a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Serializable c;
    public final /* synthetic */ Object d;

    public /* synthetic */ e(Object obj, Serializable serializable, Object obj2, int i) {
        this.f1935a = i;
        this.b = obj;
        this.c = serializable;
        this.d = obj2;
    }

    @Override // android.view.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        switch (this.f1935a) {
            case 0:
                ((MenuHostHelper) this.b).lambda$addMenuProvider$1((Lifecycle.State) this.c, (MenuProvider) this.d, lifecycleOwner, event);
                break;
            case 1:
                LifecycleEffectKt.LifecycleStartEffectImpl$lambda$19$lambda$18$lambda$16((LifecycleStartStopEffectScope) this.b, (Ref$ObjectRef) this.c, (S7.k) this.d, lifecycleOwner, event);
                break;
            default:
                LifecycleEffectKt.LifecycleResumeEffectImpl$lambda$34$lambda$33$lambda$31((LifecycleResumePauseEffectScope) this.b, (Ref$ObjectRef) this.c, (S7.k) this.d, lifecycleOwner, event);
                break;
        }
    }
}
