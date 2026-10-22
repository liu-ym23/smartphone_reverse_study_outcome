package a2;

import androidx.compose.ui.semantics.AppendedSemanticsElement;
import java.lang.invoke.VarHandle;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class l {

    /* renamed from: a, reason: collision with root package name */
    public static final AtomicInteger f79a = new AtomicInteger(0);

    public static final w0.m a(w0.m mVar, boolean z10, xb.l lVar) {
        AppendedSemanticsElement appendedSemanticsElement = new AppendedSemanticsElement();
        appendedSemanticsElement.f987c = z10;
        appendedSemanticsElement.f988f = lVar;
        VarHandle.storeStoreFence();
        return mVar.d(appendedSemanticsElement);
    }
}
