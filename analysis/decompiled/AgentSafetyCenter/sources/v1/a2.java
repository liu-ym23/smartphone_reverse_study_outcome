package v1;

import android.view.View;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a2 implements View.OnAttachStateChangeListener {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ View f14377c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ k0.z1 f14378f;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        this.f14377c.removeOnAttachStateChangeListener(this);
        this.f14378f.s();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
    }
}
