package androidx.core.view;

import android.view.View;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes.dex */
public abstract class ViewKt {

    public static final class a implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f2703a;

        public a(Function1 r10) {
            this.f2703a = r10;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View r10, int r11, int r12, int r13, int r14, int r15, int r16, int r17, int r18) {
            kotlin.jvm.internal.q.g(r10, "view");
            r10.removeOnLayoutChangeListener(this);
            this.f2703a.invoke(r10);
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f2704a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f2705b;

        public b(Function1 r10, View r11) {
            this.f2704a = r10;
            this.f2705b = r11;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f2704a.invoke(this.f2705b);
        }
    }

    public static final void a(View r10, Function1 r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        kotlin.jvm.internal.q.g(r11, "action");
        if (ViewCompat.T(r10) == true) goto L5;
    L7:
        r10.addOnLayoutChangeListener(new a(r11));
        return;
    L5:
        if (r10.isLayoutRequested() == true) goto L7;
        r11.invoke(r10);
    }

    public static final j b(View r10, Function1 r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        kotlin.jvm.internal.q.g(r11, "action");
        j r12 = j.a(r10, new b(r11, r10));
        kotlin.jvm.internal.q.f(r12, "View.doOnPreDraw(\n    cr…dd(this) { action(this) }");
        return r12;
    }

    public static final Sequence c(View r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        return kotlin.sequences.h.b(new ViewKt$allViews$1(r10, null));
    }
}
