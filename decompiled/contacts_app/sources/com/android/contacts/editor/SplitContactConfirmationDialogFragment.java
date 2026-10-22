package com.android.contacts.editor;

import android.app.Dialog;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import com.android.contacts.R;

/* JADX INFO: loaded from: classes.dex */
public class SplitContactConfirmationDialogFragment extends DialogFragment {
    public static final String TAG = "SplitContactConfirmationDialog";

    public interface Listener {
        void onSplitContactConfirmed();
    }

    public SplitContactConfirmationDialogFragment() {
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle r2) {
        AlertDialog.Builder r3 = new AlertDialog.Builder(getActivity());
        r3.setTitle(R.string.splitConfirmation_title);
        r3.setIconAttribute(android.R.attr.alertDialogIcon);
        r3.setMessage(R.string.splitConfirmation);
        r3.setPositiveButton(android.R.string.ok, new AnonymousClass1(this));
        r3.setNegativeButton(android.R.string.cancel, null);
        r3.setCancelable(false);
        return r3.create();
    }
}
