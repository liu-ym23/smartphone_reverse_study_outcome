package K;

import android.view.View;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import com.stepos.alphame.R;
import java.util.Objects;

/* loaded from: classes.dex */
public abstract class N {
    @DoNotInline
    public static void a(@NonNull View view, @NonNull Q q4) {
        q.l lVar = (q.l) view.getTag(R.id.tag_unhandled_key_listeners);
        if (lVar == null) {
            lVar = new q.l();
            view.setTag(R.id.tag_unhandled_key_listeners, lVar);
        }
        Objects.requireNonNull(q4);
        View.OnUnhandledKeyEventListener m4 = new M();
        lVar.put(q4, m4);
        view.addOnUnhandledKeyEventListener(m4);
    }

    @DoNotInline
    public static CharSequence b(View view) {
        return view.getAccessibilityPaneTitle();
    }

    @DoNotInline
    public static boolean c(View view) {
        return view.isAccessibilityHeading();
    }

    @DoNotInline
    public static boolean d(View view) {
        return view.isScreenReaderFocusable();
    }

    @DoNotInline
    public static void e(@NonNull View view, @NonNull Q q4) {
        View.OnUnhandledKeyEventListener onUnhandledKeyEventListener;
        q.l lVar = (q.l) view.getTag(R.id.tag_unhandled_key_listeners);
        if (lVar == null || (onUnhandledKeyEventListener = (View.OnUnhandledKeyEventListener) lVar.get(q4)) == null) {
            return;
        }
        view.removeOnUnhandledKeyEventListener(onUnhandledKeyEventListener);
    }

    @DoNotInline
    public static <T> T f(View view, int i4) {
        return (T) view.requireViewById(i4);
    }

    @DoNotInline
    public static void g(View view, boolean z4) {
        view.setAccessibilityHeading(z4);
    }

    @DoNotInline
    public static void h(View view, CharSequence charSequence) {
        view.setAccessibilityPaneTitle(charSequence);
    }

    @DoNotInline
    public static void i(View view, N.a aVar) {
        view.setAutofillId(null);
    }

    @DoNotInline
    public static void j(View view, boolean z4) {
        view.setScreenReaderFocusable(z4);
    }
}
