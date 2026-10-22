package androidx.preference;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.TextView;
import androidx.activity.result.ActivityResultCaller;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

/* JADX INFO: loaded from: classes.dex */
public abstract class PreferenceDialogFragmentCompat extends DialogFragment implements DialogInterface.OnClickListener {
    protected static final String ARG_KEY = "key";
    private static final String SAVE_STATE_ICON = "PreferenceDialogFragment.icon";
    private static final String SAVE_STATE_LAYOUT = "PreferenceDialogFragment.layout";
    private static final String SAVE_STATE_MESSAGE = "PreferenceDialogFragment.message";
    private static final String SAVE_STATE_NEGATIVE_TEXT = "PreferenceDialogFragment.negativeText";
    private static final String SAVE_STATE_POSITIVE_TEXT = "PreferenceDialogFragment.positiveText";
    private static final String SAVE_STATE_TITLE = "PreferenceDialogFragment.title";
    private BitmapDrawable mDialogIcon;
    private int mDialogLayoutRes;
    private CharSequence mDialogMessage;
    private CharSequence mDialogTitle;
    private CharSequence mNegativeButtonText;
    private CharSequence mPositiveButtonText;
    private DialogPreference mPreference;
    private int mWhichButtonClicked;

    private static class Api30Impl {
        private Api30Impl() {
        }

        static void showIme(Window r1) {
            r1.getDecorView().getWindowInsetsController().show(WindowInsets.Type.ime());
        }
    }

    protected boolean needInputMethod() {
        return false;
    }

    public abstract void onDialogClosed(boolean r1);

    protected void onPrepareDialogBuilder(AlertDialog.Builder r1) {
    }

    protected void scheduleShowSoftInput() {
    }

    public PreferenceDialogFragmentCompat() {
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r6) {
        super.onCreate(r6);
        ActivityResultCaller r0 = getTargetFragment();
        if ((r0 instanceof DialogPreference.TargetFragment) == false) goto L18;
        DialogPreference.TargetFragment r1 = (DialogPreference.TargetFragment) r0;
        String r2 = requireArguments().getString(ARG_KEY);
        if (r6 != null) goto L13;
        DialogPreference r7 = (DialogPreference) r1.findPreference(r2);
        this.mPreference = r7;
        this.mDialogTitle = r7.getDialogTitle();
        this.mPositiveButtonText = this.mPreference.getPositiveButtonText();
        this.mNegativeButtonText = this.mPreference.getNegativeButtonText();
        this.mDialogMessage = this.mPreference.getDialogMessage();
        this.mDialogLayoutRes = this.mPreference.getDialogLayoutResource();
        Drawable r8 = this.mPreference.getDialogIcon();
        if (r8 != null) goto L9;
    L12:
        this.mDialogIcon = (BitmapDrawable) r8;
        return;
    L9:
        if ((r8 instanceof BitmapDrawable) == true) goto L12;
        Bitmap r3 = Bitmap.createBitmap(r8.getIntrinsicWidth(), r8.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas r4 = new Canvas(r3);
        r8.setBounds(0, 0, r4.getWidth(), r4.getHeight());
        r8.draw(r4);
        this.mDialogIcon = new BitmapDrawable(getResources(), r3);
        return;
    L13:
        this.mDialogTitle = r6.getCharSequence(SAVE_STATE_TITLE);
        this.mPositiveButtonText = r6.getCharSequence(SAVE_STATE_POSITIVE_TEXT);
        this.mNegativeButtonText = r6.getCharSequence(SAVE_STATE_NEGATIVE_TEXT);
        this.mDialogMessage = r6.getCharSequence(SAVE_STATE_MESSAGE);
        this.mDialogLayoutRes = r6.getInt(SAVE_STATE_LAYOUT, 0);
        Bitmap r9 = (Bitmap) r6.getParcelable(SAVE_STATE_ICON);
        if (r9 == null) goto L21;
        this.mDialogIcon = new BitmapDrawable(getResources(), r9);
        return;
    L21:
        return;
    L18:
        throw new IllegalStateException("Target fragment must implement TargetFragment interface");
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle r3) {
        super.onSaveInstanceState(r3);
        r3.putCharSequence(SAVE_STATE_TITLE, this.mDialogTitle);
        r3.putCharSequence(SAVE_STATE_POSITIVE_TEXT, this.mPositiveButtonText);
        r3.putCharSequence(SAVE_STATE_NEGATIVE_TEXT, this.mNegativeButtonText);
        r3.putCharSequence(SAVE_STATE_MESSAGE, this.mDialogMessage);
        r3.putInt(SAVE_STATE_LAYOUT, this.mDialogLayoutRes);
        BitmapDrawable r2 = this.mDialogIcon;
        if (r2 == null) goto L6;
        r3.putParcelable(SAVE_STATE_ICON, r2.getBitmap());
        return;
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle r2) {
        this.mWhichButtonClicked = -2;
        AlertDialog.Builder r3 = new AlertDialog.Builder(requireContext()).setTitle(this.mDialogTitle).setIcon(this.mDialogIcon).setPositiveButton(this.mPositiveButtonText, this).setNegativeButton(this.mNegativeButtonText, this);
        View r0 = onCreateDialogView(requireContext());
        if (r0 == null) goto L5;
        onBindDialogView(r0);
        r3.setView(r0);
    L6:
        onPrepareDialogBuilder(r3);
        AlertDialog r4 = r3.create();
        if (needInputMethod() == false) goto L9;
        requestInputMethod(r4);
    L9:
        return r4;
    L5:
        r3.setMessage(this.mDialogMessage);
        goto L6
    }

    public DialogPreference getPreference() {
        if (this.mPreference != null) goto L6;
        String r0 = requireArguments().getString(ARG_KEY);
        this.mPreference = (DialogPreference) ((DialogPreference.TargetFragment) getTargetFragment()).findPreference(r0);
    L6:
        return this.mPreference;
    }

    private void requestInputMethod(Dialog r1) {
        Api30Impl.showIme(r1.getWindow());
    }

    protected View onCreateDialogView(Context r2) {
        int r3 = this.mDialogLayoutRes;
        if (r3 != 0) goto L6;
        return null;
    L6:
        return getLayoutInflater().inflate(r3, null);
    }

    protected void onBindDialogView(View r2) {
        View r3 = r2.findViewById(android.R.id.message);
        if (r3 == null) goto L15;
        CharSequence r1 = this.mDialogMessage;
        if (TextUtils.isEmpty(r1) == false) goto L7;
        int r4 = 8;
    L12:
        if (r3.getVisibility() == r4) goto L16;
        r3.setVisibility(r4);
        return;
    L16:
        return;
    L7:
        if ((r3 instanceof TextView) == false) goto L9;
        ((TextView) r3).setText(r1);
    L9:
        r4 = 0;
        goto L12
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface r1, int r2) {
        this.mWhichButtonClicked = r2;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface r2) {
        super.onDismiss(r2);
        if (this.mWhichButtonClicked != (-1)) goto L5;
        boolean r3 = true;
    L6:
        onDialogClosed(r3);
        return;
    L5:
        r3 = false;
        goto L6
    }
}
