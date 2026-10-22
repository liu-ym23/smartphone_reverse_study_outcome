package androidx.compose.ui.layout;

import java.lang.invoke.VarHandle;
import w0.m;
import xb.l;
import xb.q;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class a {
    public static final m a(m mVar, q qVar) {
        LayoutElement layoutElement = new LayoutElement();
        layoutElement.f973c = qVar;
        VarHandle.storeStoreFence();
        return mVar.d(layoutElement);
    }

    public static final m b(m mVar, l lVar) {
        OnGloballyPositionedElement onGloballyPositionedElement = new OnGloballyPositionedElement();
        onGloballyPositionedElement.f974c = lVar;
        VarHandle.storeStoreFence();
        return mVar.d(onGloballyPositionedElement);
    }

    public static final m c(m mVar, l lVar) {
        OnSizeChangedModifier onSizeChangedModifier = new OnSizeChangedModifier();
        onSizeChangedModifier.f975c = lVar;
        VarHandle.storeStoreFence();
        return mVar.d(onSizeChangedModifier);
    }
}
