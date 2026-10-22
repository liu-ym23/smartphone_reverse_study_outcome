package androidx.core.view;

import android.content.Context;
import android.view.PointerIcon;

/* loaded from: classes.dex */
public final class E {

    /* renamed from: a, reason: collision with root package name */
    public final PointerIcon f13099a;

    public static class a {
        public static PointerIcon a(Context context, int i10) {
            return PointerIcon.getSystemIcon(context, i10);
        }
    }

    public E(PointerIcon pointerIcon) {
        this.f13099a = pointerIcon;
    }

    public static E b(Context context, int i10) {
        return new E(a.a(context, i10));
    }

    public Object a() {
        return this.f13099a;
    }
}
