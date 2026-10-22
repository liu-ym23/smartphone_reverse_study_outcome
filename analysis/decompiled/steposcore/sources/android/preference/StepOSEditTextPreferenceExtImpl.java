package android.preference;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.widget.EditText;

/* loaded from: classes.dex */
public class StepOSEditTextPreferenceExtImpl implements IStepOSEditTextPreferenceExt {
    public void onAttach(EditTextPreference host) {
    }

    public EditText createDialogEditText(Context context, AttributeSet attrs) {
        int themeResId;
        Context ctx = context;
        if (context.isDeviceDefaultTheme() && (themeResId = resolveAlertDialogTheme(context)) != 0) {
            ctx = new ContextThemeWrapper(context, themeResId);
        }
        return new EditText(ctx, attrs);
    }

    public void onBindDialogEditTextPrepared(EditText editText) {
        if (editText.length() > 0) {
            editText.setSelection(0, editText.length());
        }
    }

    private static int resolveAlertDialogTheme(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }
}
