package n3;

import android.view.View;
import android.view.ViewGroup;
import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class l0 implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public static final l0 f8729c = new l0();

    @Override // xb.l
    public final Object invoke(Object obj) {
        View view = (View) obj;
        ViewGroup viewGroup = view instanceof ViewGroup ? (ViewGroup) view : null;
        if (viewGroup == null) {
            return null;
        }
        kb.b bVar = new kb.b(1);
        bVar.f7386g = viewGroup;
        VarHandle.storeStoreFence();
        return bVar;
    }
}
