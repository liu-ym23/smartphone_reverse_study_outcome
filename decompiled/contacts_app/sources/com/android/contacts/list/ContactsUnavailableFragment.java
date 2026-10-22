package com.android.contacts.list;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.android.contacts.R;
import com.android.contacts.util.Constants;
import obric.api.ContactsContractSmt;

/* JADX INFO: loaded from: classes2.dex */
public class ContactsUnavailableFragment extends Fragment implements View.OnClickListener {
    private Button mAddAccountButton;
    private Button mCreateContactButton;
    private Button mImportContactsButton;
    private OnContactsUnavailableActionListener mListener;
    private TextView mMessageView;
    private int mNSecNoContactsMsgResId;
    private int mNoContactsMsgResId;
    private ProgressBar mProgress;
    private ProviderStatusLoader mProviderStatusLoader;
    private Button mRetryUpgradeButton;
    private TextView mSecondaryMessageView;
    private Button mUninstallAppsButton;
    private View mView;

    public ContactsUnavailableFragment() {
        this.mNoContactsMsgResId = -1;
        this.mNSecNoContactsMsgResId = -1;
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        View r4 = r1.inflate(R.layout.contacts_unavailable_fragment, null);
        this.mView = r4;
        this.mMessageView = (TextView) r4.findViewById(R.id.message);
        this.mSecondaryMessageView = (TextView) this.mView.findViewById(R.id.secondary_message);
        Button r5 = (Button) this.mView.findViewById(R.id.create_contact_button);
        this.mCreateContactButton = r5;
        r5.setOnClickListener(this);
        Button r6 = (Button) this.mView.findViewById(R.id.add_account_button);
        this.mAddAccountButton = r6;
        r6.setOnClickListener(this);
        Button r7 = (Button) this.mView.findViewById(R.id.import_contacts_button);
        this.mImportContactsButton = r7;
        r7.setOnClickListener(this);
        Button r8 = (Button) this.mView.findViewById(R.id.import_failure_uninstall_button);
        this.mUninstallAppsButton = r8;
        r8.setOnClickListener(this);
        Button r9 = (Button) this.mView.findViewById(R.id.import_failure_retry_button);
        this.mRetryUpgradeButton = r9;
        r9.setOnClickListener(this);
        this.mProgress = (ProgressBar) this.mView.findViewById(R.id.progress);
        if (Constants.ANDROID60 == false) goto L5;
        update60();
    L7:
        return this.mView;
    L5:
        update55();
        goto L7
    }

    public void setOnContactsUnavailableActionListener(OnContactsUnavailableActionListener r1) {
        this.mListener = r1;
    }

    public void setProviderStatusLoader(ProviderStatusLoader r1) {
        this.mProviderStatusLoader = r1;
    }

    public void update55() {
        int r0 = this.mProviderStatusLoader.getProviderStatus();
        if (r0 != ContactsContractSmt.get_STATUS_NO_ACCOUNTS_NO_CONTACTS()) goto L6;
        setMessageText(this.mNoContactsMsgResId, this.mNSecNoContactsMsgResId);
        this.mCreateContactButton.setVisibility(0);
        this.mAddAccountButton.setVisibility(0);
        this.mImportContactsButton.setVisibility(0);
        this.mUninstallAppsButton.setVisibility(8);
        this.mRetryUpgradeButton.setVisibility(8);
        this.mProgress.setVisibility(8);
        return;
    L6:
        if (r0 != ContactsContractSmt.get_STATUS_CHANGING_LOCALE()) goto L9;
        this.mMessageView.setText(R.string.locale_change_in_progress);
        this.mMessageView.setGravity(1);
        this.mMessageView.setVisibility(0);
        this.mCreateContactButton.setVisibility(8);
        this.mAddAccountButton.setVisibility(8);
        this.mImportContactsButton.setVisibility(8);
        this.mUninstallAppsButton.setVisibility(8);
        this.mRetryUpgradeButton.setVisibility(8);
        this.mProgress.setVisibility(0);
        return;
    L9:
        if (r0 != ContactsContractSmt.get_STATUS_UPGRADING()) goto L12;
        this.mMessageView.setText(R.string.upgrade_in_progress);
        this.mMessageView.setGravity(1);
        this.mMessageView.setVisibility(0);
        this.mCreateContactButton.setVisibility(8);
        this.mAddAccountButton.setVisibility(8);
        this.mImportContactsButton.setVisibility(8);
        this.mUninstallAppsButton.setVisibility(8);
        this.mRetryUpgradeButton.setVisibility(8);
        this.mProgress.setVisibility(0);
        return;
    L12:
        if (r0 != ContactsContractSmt.get_STATUS_UPGRADE_OUT_OF_MEMORY()) goto L18;
        this.mMessageView.setText(getResources().getString(R.string.upgrade_out_of_memory, new Object[]{this.mProviderStatusLoader.getProviderStatusData()}));
        this.mMessageView.setGravity(3);
        this.mMessageView.setVisibility(0);
        this.mCreateContactButton.setVisibility(8);
        this.mAddAccountButton.setVisibility(8);
        this.mImportContactsButton.setVisibility(8);
        this.mUninstallAppsButton.setVisibility(0);
        this.mRetryUpgradeButton.setVisibility(0);
        this.mProgress.setVisibility(8);
        return;
    }

    private void update60() {
        int r0 = this.mProviderStatusLoader.getProviderStatus();
        if (r0 != 1) goto L5;
        this.mMessageView.setText(R.string.locale_change_in_progress);
        this.mMessageView.setGravity(1);
        this.mMessageView.setVisibility(0);
        this.mCreateContactButton.setVisibility(8);
        this.mAddAccountButton.setVisibility(8);
        this.mImportContactsButton.setVisibility(8);
        this.mUninstallAppsButton.setVisibility(8);
        this.mRetryUpgradeButton.setVisibility(8);
        this.mProgress.setVisibility(0);
        return;
    L5:
        if (r0 != 2) goto L11;
        setMessageText(this.mNoContactsMsgResId, this.mNSecNoContactsMsgResId);
        this.mCreateContactButton.setVisibility(0);
        this.mAddAccountButton.setVisibility(0);
        this.mImportContactsButton.setVisibility(0);
        this.mUninstallAppsButton.setVisibility(8);
        this.mRetryUpgradeButton.setVisibility(8);
        this.mProgress.setVisibility(8);
        return;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r2) {
        if (this.mListener != null) goto L5;
        return;
    L5:
        int r3 = r2.getId();
        if (r3 != R.id.add_account_button) goto L8;
        this.mListener.onAddAccountAction();
        return;
    L8:
        if (r3 == R.id.create_contact_button) goto L14;
        switch(r3) {
            case 2131362804: goto L13;
            case 2131362805: goto L12;
            case 2131362806: goto L11;
            default: goto L21;
        };
    L11:
        this.mListener.onFreeInternalStorageAction();
        return;
    L12:
        this.mProviderStatusLoader.retryUpgrade();
        return;
    L13:
        this.mListener.onImportContactsFromFileAction();
        return;
    L21:
        return;
    L14:
        this.mListener.onCreateNewContactAction();
    }

    public void setMessageText(int r4, int r5) {
        this.mNoContactsMsgResId = r4;
        this.mNSecNoContactsMsgResId = r5;
        if (this.mMessageView != null) goto L5;
        return;
    L5:
        if (this.mProviderStatusLoader.getProviderStatus() == ContactsContractSmt.get_STATUS_NO_ACCOUNTS_NO_CONTACTS()) goto L7;
        return;
    L7:
        if (r4 == (-1)) goto L12;
        this.mMessageView.setText(this.mNoContactsMsgResId);
        this.mMessageView.setGravity(1);
        this.mMessageView.setVisibility(0);
        if (r5 == (-1)) goto L11;
        this.mSecondaryMessageView.setText(this.mNSecNoContactsMsgResId);
        this.mSecondaryMessageView.setGravity(1);
        this.mSecondaryMessageView.setVisibility(0);
        return;
    L11:
        this.mSecondaryMessageView.setVisibility(4);
        return;
    L12:
        this.mSecondaryMessageView.setVisibility(8);
        this.mMessageView.setVisibility(8);
    }
}
