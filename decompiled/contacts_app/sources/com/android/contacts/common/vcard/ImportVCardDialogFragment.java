package com.android.contacts.common.vcard;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.net.Uri;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public class ImportVCardDialogFragment extends DialogFragment {
    private static final String ARG_SOURCE_DISPLAY_NAME = "sourceDisplayName";
    private static final String ARG_SOURCE_URI = "sourceUri";
    static final String TAG = "importVCardDialog";

    public interface Listener {
        void onImportVCardConfirmed(Uri r1, String r2);

        void onImportVCardDenied();
    }

    public ImportVCardDialogFragment() {
    }

    public static void show(Activity r2, Uri r3, String r4) {
        if ((r2 instanceof Listener) == false) goto L7;
        Bundle r0 = new Bundle();
        r0.putParcelable(ARG_SOURCE_URI, r3);
        r0.putString(ARG_SOURCE_DISPLAY_NAME, r4);
        ImportVCardDialogFragment r5 = new ImportVCardDialogFragment();
        r5.setArguments(r0);
        r5.show(r2.getFragmentManager(), TAG);
        return;
    L7:
        throw new IllegalArgumentException("Activity must implement " + Listener.class.getName());
    }

    @Override // android.app.DialogFragment
    public Dialog onCreateDialog(Bundle r4) {
        final Uri r5 = (Uri) getArguments().getParcelable(ARG_SOURCE_URI);
        final String r0 = getArguments().getString(ARG_SOURCE_DISPLAY_NAME);
        return new AlertDialog.Builder(getActivity()).setIconAttribute(R.attr.alertDialogIcon).setMessage(com.android.contacts.common.R.string.import_from_vcf_file_confirmation_message).setPositiveButton(R.string.yes, new AnonymousClass2(this, r5, r0)).setNegativeButton(R.string.no, new AnonymousClass1(this)).create();
    }
}
