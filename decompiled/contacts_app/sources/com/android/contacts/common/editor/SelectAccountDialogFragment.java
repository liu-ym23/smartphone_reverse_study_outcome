package com.android.contacts.common.editor;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.ComponentCallbacks2;
import android.content.DialogInterface;
import android.os.Bundle;
import com.android.contacts.common.R;
import com.android.contacts.common.model.account.AccountWithDataSet;
import com.android.contacts.common.util.AccountsListAdapter;

/* JADX INFO: loaded from: classes.dex */
public final class SelectAccountDialogFragment extends DialogFragment {
    private static final String KEY_EXTRA_ARGS = "extra_args";
    private static final String KEY_LIST_FILTER = "list_filter";
    private static final String KEY_TITLE_RES_ID = "title_res_id";
    public static final String TAG = "SelectAccountDialogFragment";

    public interface Listener {
        void onAccountChosen(AccountWithDataSet r1, Bundle r2);

        void onAccountSelectorCancelled();
    }

    static /* synthetic */ void access$000(SelectAccountDialogFragment r0, AccountWithDataSet r1) {
        r0.onAccountSelected(r1);
    }

    public SelectAccountDialogFragment() {
    }

    public static <F extends Fragment & Listener> void show(FragmentManager r2, F r3, int r4, AccountsListAdapter.AccountListFilter r5, Bundle r6) {
        Bundle r0 = new Bundle();
        r0.putInt(KEY_TITLE_RES_ID, r4);
        r0.putSerializable(KEY_LIST_FILTER, r5);
        if (r6 != null) goto L5;
        r6 = Bundle.EMPTY;
    L5:
        r0.putBundle(KEY_EXTRA_ARGS, r6);
        SelectAccountDialogFragment r7 = new SelectAccountDialogFragment();
        r7.setArguments(r0);
        r7.setTargetFragment(r3, 0);
        r7.show(r2, "SelectAccountDialogFragment");
    }

    @Override // android.app.DialogFragment
    public Dialog onCreateDialog(Bundle r5) {
        AlertDialog.Builder r6 = new AlertDialog.Builder(getActivity());
        Bundle r0 = getArguments();
        AccountsListAdapter.AccountListFilter r1 = (AccountsListAdapter.AccountListFilter) r0.getSerializable(KEY_LIST_FILTER);
        final AccountsListAdapter r2 = new AccountsListAdapter(r6.getContext(), r1);
        r2.setCustomLayout(R.layout.account_selector_list_item_condensed);
        DialogInterface.OnClickListener r3 = new AnonymousClass1(this, r2);
        r6.setTitle(r0.getInt(KEY_TITLE_RES_ID));
        r6.setSingleChoiceItems(r2, 0, r3);
        return r6.create();
    }

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface r1) {
        super.onCancel(r1);
        ComponentCallbacks2 r0 = getTargetFragment();
        if (r0 != null) goto L5;
        return;
    L5:
        if ((r0 instanceof Listener) == false) goto L9;
        ((Listener) r0).onAccountSelectorCancelled();
        return;
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onSaveInstanceState(Bundle r3) {
        setTargetFragment(null, -1);
        super.onSaveInstanceState(r3);
    }

    private void onAccountSelected(AccountWithDataSet r3) {
        ComponentCallbacks2 r0 = getTargetFragment();
        if (r0 != null) goto L5;
        return;
    L5:
        if ((r0 instanceof Listener) == false) goto L9;
        ((Listener) r0).onAccountChosen(r3, getArguments().getBundle(KEY_EXTRA_ARGS));
        return;
    }
}
