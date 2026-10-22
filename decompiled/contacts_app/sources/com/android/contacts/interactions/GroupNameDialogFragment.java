package com.android.contacts.interactions;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import com.android.contacts.R;

/* JADX INFO: loaded from: classes2.dex */
public abstract class GroupNameDialogFragment extends DialogFragment implements TextWatcher, DialogInterface.OnShowListener {
    private EditText mEdit;

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    protected abstract int getTitleResourceId();

    protected abstract void initializeGroupLabelEditText(EditText r1);

    protected abstract void onCompleted(String r1);

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    public GroupNameDialogFragment() {
    }

    static /* synthetic */ EditText access$000(GroupNameDialogFragment r0) {
        return r0.mEdit;
    }

    @Override // android.app.DialogFragment
    public Dialog onCreateDialog(Bundle r4) {
        View r5 = LayoutInflater.from(getActivity()).inflate(R.layout.group_name_dialog, null);
        EditText r0 = (EditText) r5.findViewById(R.id.group_label);
        this.mEdit = r0;
        initializeGroupLabelEditText(r0);
        this.mEdit.addTextChangedListener(this);
        AlertDialog r6 = new AlertDialog.Builder(getActivity()).setIconAttribute(android.R.attr.alertDialogIcon).setTitle(getTitleResourceId()).setView(r5).setPositiveButton(android.R.string.ok, new AnonymousClass1(this)).setNegativeButton(android.R.string.cancel, null).create();
        r6.setOnShowListener(this);
        r6.getWindow().setSoftInputMode(5);
        return r6;
    }

    @Override // android.content.DialogInterface.OnShowListener
    public void onShow(DialogInterface r1) {
        updateOkButtonState((AlertDialog) r1);
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable r1) {
        AlertDialog r2 = (AlertDialog) getDialog();
        if (r2 == null) goto L6;
        updateOkButtonState(r2);
        return;
    }

    private void updateOkButtonState(AlertDialog r2) {
        r2.getButton(-1).setEnabled(!TextUtils.isEmpty(this.mEdit.getText().toString().trim()));
    }
}
