package com.android.contacts.common.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import com.android.contacts.common.R;

/* JADX INFO: loaded from: classes.dex */
public class ClearFrequentsDialog extends DialogFragment {
    public ClearFrequentsDialog() {
    }

    public static void show(FragmentManager r2) {
        new ClearFrequentsDialog().show(r2, "clearFrequents");
    }

    @Override // android.app.DialogFragment
    public Dialog onCreateDialog(Bundle r3) {
        final Context r4 = getActivity().getApplicationContext();
        final ContentResolver r0 = getActivity().getContentResolver();
        DialogInterface.OnClickListener r1 = new AnonymousClass1(this, r4, r0);
        return new AlertDialog.Builder(getActivity()).setTitle(R.string.clearFrequentsConfirmation_title).setMessage(R.string.clearFrequentsConfirmation).setNegativeButton(android.R.string.cancel, null).setPositiveButton(android.R.string.ok, r1).setCancelable(true).create();
    }
}
