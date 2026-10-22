package com.android.contacts.editor;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.activity.result.ActivityResultCaller;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.android.contacts.model.AccountWithDataSet;
import com.android.contacts.util.AccountSelectionUtil;
import com.android.contacts.util.AccountsListAdapter;

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
        r7.show(r2, null);
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle r2) {
        DialogInterface.OnClickListener r3 = new AnonymousClass1(this);
        DialogInterface.OnClickListener r0 = new AnonymousClass2(this);
        return AccountSelectionUtil.getSelectAccountDialogInFragment(getActivity(), r3, r0);
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface r2) {
        super.onCancel(r2);
        ActivityResultCaller r3 = getTargetFragment();
        if (r3 != null) goto L5;
    L7:
        dismiss();
        return;
    L5:
        if ((r3 instanceof Listener) == false) goto L7;
        ((Listener) r3).onAccountSelectorCancelled();
        goto L7
    }

    private void onAccountSelected(AccountWithDataSet r3) {
        ActivityResultCaller r0 = getTargetFragment();
        if (r0 != null) goto L5;
        return;
    L5:
        if ((r0 instanceof Listener) == false) goto L9;
        ((Listener) r0).onAccountChosen(r3, getArguments().getBundle(KEY_EXTRA_ARGS));
        return;
    }
}
