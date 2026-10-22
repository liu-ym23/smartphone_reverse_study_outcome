package C2;

import android.R;
import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/* loaded from: classes.dex */
public class i {
    public static void a(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public static void b(Activity activity, View view) {
        if (activity == null) {
            return;
        }
        View viewFindViewById = activity.findViewById(R.id.content);
        if (viewFindViewById != null) {
            viewFindViewById.setFocusable(true);
            viewFindViewById.setFocusableInTouchMode(true);
            viewFindViewById.requestFocus();
        }
        if (view != null) {
            view.clearFocus();
            a(view);
        } else if (viewFindViewById != null) {
            a(viewFindViewById);
        }
        activity.getWindow().setSoftInputMode(2);
    }

    public static void c(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.showSoftInput(view, 0);
        }
    }
}
