package com.android.contacts.interactions;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.telephony.TelephonyManager;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.android.contacts.R;
import com.android.contacts.editor.SelectAccountDialogFragment;
import com.android.contacts.model.AccountTypeManager;
import com.android.contacts.model.AccountWithDataSet;
import com.android.contacts.util.AccountSelectionUtil;
import com.android.contacts.util.AccountsListAdapter;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ImportExportDialogFragment extends DialogFragment implements SelectAccountDialogFragment.Listener {
    private static final String KEY_RES_ID = "resourceId";
    public static final String TAG = "ImportExportDialogFragment";
    private final String[] LOOKUP_PROJECTION;

    public ImportExportDialogFragment() {
        this.LOOKUP_PROJECTION = new String[]{"lookup"};
    }

    static /* synthetic */ boolean access$000(ImportExportDialogFragment r0, int r1) {
        return r0.handleImportRequest(r1);
    }

    static /* synthetic */ void access$100(ImportExportDialogFragment r0) {
        r0.doShareVisibleContacts();
    }

    public static void show(FragmentManager r2) {
        new ImportExportDialogFragment().show(r2, TAG);
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle r5) {
        Resources r6 = getActivity().getResources();
        final LayoutInflater r0 = (LayoutInflater) getActivity().getSystemService("layout_inflater");
        final FragmentActivity r2 = getActivity();
        final int r3 = R.layout.select_dialog_item;
        final ArrayAdapter<Integer> r1 = new AnonymousClass1(this, r2, r3, r0);
        if (TelephonyManager.getDefault().hasIccCard() == false) goto L8;
        if (r6.getBoolean(R.bool.config_allow_sim_import) == false) goto L8;
        r1.add(Integer.valueOf(R.string.import_from_sim));
    L8:
        if (r6.getBoolean(R.bool.config_allow_import_from_sdcard) == false) goto L11;
        r1.add(Integer.valueOf(R.string.import_from_sdcard));
    L11:
        if (r6.getBoolean(R.bool.config_allow_export_to_sdcard) == false) goto L14;
        r1.add(Integer.valueOf(R.string.export_to_sdcard));
    L14:
        if (r6.getBoolean(R.bool.config_allow_share_visible_contacts) == false) goto L16;
        r1.add(Integer.valueOf(R.string.share_visible_contacts));
    L16:
        DialogInterface.OnClickListener r7 = new AnonymousClass2(this, r1);
        return new AlertDialog.Builder(getActivity()).setTitle(R.string.dialog_import_export).setSingleChoiceItems(r1, -1, r7).create();
    }

    private void doShareVisibleContacts() {
        Cursor r0 = getActivity().getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, this.LOOKUP_PROJECTION, "in_visible_group!=0", null, null);
        if (r0 != null) goto L20;
        return;
    L20:
    L16:
        th = move-exception;
        r0.close();
        throw th;
    L5:
        if (r0.moveToFirst() == true) goto L9;
        Toast.makeText(getActivity(), R.string.share_error, 0).show();     // Catch: Throwable -> L16
        r0.close();
        return;
    L9:
        StringBuilder r1 = new StringBuilder();     // Catch: Throwable -> L16
        int r3 = 0;
    L10:
        if (r3 == 0) goto L12;
        r1.append(':');     // Catch: Throwable -> L16
    L12:
        r1.append(r0.getString(0));     // Catch: Throwable -> L16
        r3 = r3 + 1;     // Catch: Throwable -> L16
        if (r0.moveToNext() == true) goto L10;
        Uri r2 = Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_MULTI_VCARD_URI, Uri.encode(r1.toString()));     // Catch: Throwable -> L16
        Intent r4 = new Intent("android.intent.action.SEND");     // Catch: Throwable -> L16
        r4.setType("text/x-vcard");     // Catch: Throwable -> L16
        r4.putExtra("android.intent.extra.STREAM", r2);     // Catch: Throwable -> L16
        getActivity().startActivity(r4);     // Catch: Throwable -> L16
        r0.close();
    }

    private boolean handleImportRequest(int r5) {
        List<AccountWithDataSet> r0 = AccountTypeManager.getInstance(getActivity()).getAccounts(true);
        int r2 = r0.size();
        if (r2 <= 1) goto L6;
        Bundle r1 = new Bundle();
        r1.putInt(KEY_RES_ID, r5);
        SelectAccountDialogFragment.show(getParentFragmentManager(), this, R.string.dialog_new_contact_account, AccountsListAdapter.AccountListFilter.ACCOUNTS_CONTACT_WRITABLE, r1);
        return false;
    L6:
        FragmentActivity r4 = getActivity();
        if (r2 != 1) goto L9;
        AccountWithDataSet r3 = r0.get(0);
    L10:
        AccountSelectionUtil.doImport(r4, r5, r3);
        return true;
    L9:
        r3 = null;
        goto L10
    }

    @Override // com.android.contacts.editor.SelectAccountDialogFragment.Listener
    public void onAccountChosen(AccountWithDataSet r3, Bundle r4) {
        AccountSelectionUtil.doImport(getActivity(), r4.getInt(KEY_RES_ID), r3);
        dismiss();
    }

    @Override // com.android.contacts.editor.SelectAccountDialogFragment.Listener
    public void onAccountSelectorCancelled() {
        dismiss();
    }
}
