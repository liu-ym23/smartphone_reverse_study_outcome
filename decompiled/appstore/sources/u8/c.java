package u8;

import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import androidx.core.view.ViewCompat;
import com.bytedanceos.common.ktx.e2e.InitialPadding;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c {

    public static final class a implements View.OnAttachStateChangeListener {
        public a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View r10) {
            q.g(r10, "v");
            r10.removeOnAttachStateChangeListener(this);
            ViewCompat.m0(r10);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View r10) {
            q.g(r10, "v");
        }
    }

    public static /* synthetic */ WindowInsets a(Function3 r10, InitialPadding r11, View r12, WindowInsets r13) {
        return d(r10, r11, r12, r13);
    }

    public static /* synthetic */ WindowInsets b(Function3 r10, d r11, View r12, WindowInsets r13) {
        return f(r10, r11, r12, r13);
    }

    public static final void c(View r10, final Function3 r11) {
        q.g(r10, "<this>");
        q.g(r11, "f");
        final InitialPadding r12 = h(r10);
        r10.setOnApplyWindowInsetsListener(new b(r11, r12));
        i(r10);
    }

    public static final WindowInsets d(Function3 r10, InitialPadding r11, View r12, WindowInsets r13) {
        q.g(r10, "$f");
        q.g(r11, "$initialPadding");
        q.g(r12, "v");
        q.g(r13, "insets");
        r10.invoke(r12, r13, r11);
        return r13;
    }

    public static final void e(View r10, final Function3 r11) {
        q.g(r10, "<this>");
        q.g(r11, "f");
        final d r12 = g(r10);
        r10.setOnApplyWindowInsetsListener(new u8.a(r11, r12));
        i(r10);
    }

    public static final WindowInsets f(Function3 r10, d r11, View r12, WindowInsets r13) {
        q.g(r10, "$f");
        q.g(r11, "$initialMargins");
        q.g(r12, "v");
        q.g(r13, "insets");
        r10.invoke(r12, r13, r11);
        return r13;
    }

    public static final d g(View r10) {
        ViewGroup.LayoutParams r11 = r10.getLayoutParams();
        ViewGroup.MarginLayoutParams r12 = null;
        if ((r11 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r13 = (ViewGroup.MarginLayoutParams) r11;
    L6:
        int r14 = 0;
        if (r13 == null) goto L9;
        int r15 = r13.leftMargin;
    L10:
        ViewGroup.LayoutParams r16 = r10.getLayoutParams();
        if ((r16 instanceof ViewGroup.MarginLayoutParams) == false) goto L13;
        ViewGroup.MarginLayoutParams r17 = (ViewGroup.MarginLayoutParams) r16;
    L14:
        if (r17 == null) goto L16;
        int r18 = r17.topMargin;
    L17:
        ViewGroup.LayoutParams r19 = r10.getLayoutParams();
        if ((r19 instanceof ViewGroup.MarginLayoutParams) == false) goto L20;
        ViewGroup.MarginLayoutParams r20 = (ViewGroup.MarginLayoutParams) r19;
    L21:
        if (r20 == null) goto L23;
        int r21 = r20.rightMargin;
    L24:
        ViewGroup.LayoutParams r22 = r10.getLayoutParams();
        if ((r22 instanceof ViewGroup.MarginLayoutParams) == false) goto L27;
        r12 = (ViewGroup.MarginLayoutParams) r22;
    L27:
        if (r12 == null) goto L30;
        r14 = r12.bottomMargin;
    L30:
        return new d(r15, r18, r21, r14);
    L23:
        r21 = 0;
        goto L24
    L20:
        r20 = null;
        goto L21
    L16:
        r18 = 0;
        goto L17
    L13:
        r17 = null;
        goto L14
    L9:
        r15 = 0;
        goto L10
    L5:
        r13 = null;
        goto L6
    }

    public static final InitialPadding h(View r10) {
        return new InitialPadding(r10.getPaddingLeft(), r10.getPaddingTop(), r10.getPaddingRight(), r10.getPaddingBottom());
    }

    public static final void i(View r10) {
        q.g(r10, "view");
        if (ViewCompat.S(r10) == false) goto L5;
        ViewCompat.m0(r10);
        return;
    L5:
        r10.addOnAttachStateChangeListener(new a());
    }
}
