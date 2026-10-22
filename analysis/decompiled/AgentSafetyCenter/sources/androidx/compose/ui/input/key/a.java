package androidx.compose.ui.input.key;

import java.lang.invoke.VarHandle;
import v1.p;
import w0.m;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class a {
    public static final m a(p pVar) {
        KeyInputElement keyInputElement = new KeyInputElement();
        keyInputElement.f965c = pVar;
        VarHandle.storeStoreFence();
        return keyInputElement;
    }
}
