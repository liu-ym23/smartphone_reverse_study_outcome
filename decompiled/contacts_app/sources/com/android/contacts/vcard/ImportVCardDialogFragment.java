package com.android.contacts.vcard;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.android.contacts.R;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;

/* JADX INFO: loaded from: classes2.dex */
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
    public Dialog onCreateDialog(Bundle r6) {
        Activity r7 = getActivity();
        final Uri r0 = (Uri) getArguments().getParcelable(ARG_SOURCE_URI);
        final String r1 = getArguments().getString(ARG_SOURCE_DISPLAY_NAME);
        if (r7 != null) goto L5;
        Intent r2 = null;
    L6:
        boolean r3 = ImportVCardActivity.isFromMmsIntent(r2);
        OAlertDialogBuilder r4 = new OAlertDialogBuilder(r7);
        if (r3 == false) goto L9;
        int r8 = R.string.import_from_vcf_file_confirmation_message_from_mms;
    L10:
        OAlertDialogBuilder r9 = r4.title(r8).horizontalButton().negativeButton(android.R.string.no, new AnonymousClass2(this));
        if (r3 == false) goto L13;
        int r5 = R.string.import_from_vcf_file_confirmation_button_from_mms;
    L14:
        OAlertDialogBuilder r10 = r9.positiveButton(r5, new AnonymousClass1(this, r0, r1));
        if (r3 == true) goto L17;
        r10.message(getString(R.string.import_from_vcf_file_confirmation_message));
    L17:
        OAlertDialog r11 = r10.build();
        r11.setCancelable(true);
        return r11;
    L13:
        r5 = android.R.string.yes;
        goto L14
    L9:
        r8 = R.string.common_prompt;
        goto L10
    L5:
        r2 = r7.getIntent();
        goto L6
    }

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface r1) {
        super.onCancel(r1);
        if (r1 == null) goto L5;
        r1.dismiss();
    L5:
        getActivity().finish();
    }
}
