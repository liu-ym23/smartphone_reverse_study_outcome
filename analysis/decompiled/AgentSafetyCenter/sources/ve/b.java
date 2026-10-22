package ve;

import android.view.ViewGroup;
import z3.f;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class b implements f {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ boolean f14918a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ d f14919b;

    @Override // z3.f
    public final void a(float f5) {
        d dVar = this.f14919b;
        ViewGroup viewGroup = dVar.f14924b;
        dVar.d(viewGroup.getTranslationX(), viewGroup.getTranslationY());
        dVar.B = this.f14918a ? viewGroup.getTranslationY() : viewGroup.getTranslationX();
    }
}
