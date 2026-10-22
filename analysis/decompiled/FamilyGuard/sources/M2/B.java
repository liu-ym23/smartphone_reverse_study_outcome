package M2;

import android.content.Context;
import android.view.View;

/* loaded from: classes.dex */
public final class B implements K2.B<C> {

    /* renamed from: a, reason: collision with root package name */
    private final C0375l f4001a = new C0375l();

    /* renamed from: b, reason: collision with root package name */
    private final String f4002b = "gradient_blur";

    @Override // K2.B
    public boolean a(Context context) {
        j4.k.g(context, "context");
        return this.f4001a.a(context);
    }

    @Override // K2.B
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public K2.s c(View view, C c6) {
        j4.k.g(view, "view");
        j4.k.g(c6, "params");
        return this.f4001a.c(view, c6);
    }

    @Override // K2.B
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C b() {
        return new C();
    }

    @Override // K2.B
    public String getId() {
        return this.f4002b;
    }
}
