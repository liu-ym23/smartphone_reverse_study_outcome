package com.android.contacts.common.widget;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.telecom.PhoneAccount;
import android.telecom.PhoneAccountHandle;
import android.telecom.TelecomManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.contacts.common.R;
import com.android.contacts.common.compat.PhoneAccountCompat;
import com.android.contacts.common.compat.PhoneNumberUtilsCompat;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class SelectPhoneAccountDialogFragment extends DialogFragment {
    private static final String ARG_ACCOUNT_HANDLES = "account_handles";
    private static final String ARG_CAN_SET_DEFAULT = "can_set_default";
    private static final String ARG_IS_DEFAULT_CHECKED = "is_default_checked";
    private static final String ARG_LISTENER = "listener";
    private static final String ARG_TITLE_RES_ID = "title_res_id";
    private List<PhoneAccountHandle> mAccountHandles;
    private boolean mCanSetDefault;
    private boolean mIsDefaultChecked;
    private boolean mIsSelected;
    private SelectPhoneAccountListener mListener;
    private TelecomManager mTelecomManager;
    private int mTitleResId;

    private class SelectAccountListAdapter extends ArrayAdapter<PhoneAccountHandle> {
        private int mResId;
        final /* synthetic */ SelectPhoneAccountDialogFragment this$0;

        private class ViewHolder {
            ImageView imageView;
            TextView labelTextView;
            TextView numberTextView;
            final /* synthetic */ SelectAccountListAdapter this$1;

            private ViewHolder(SelectAccountListAdapter r1) {
                this.this$1 = r1;
            }

            /* synthetic */ ViewHolder(SelectAccountListAdapter r1, AnonymousClass1 r2) {
                this(r1);
            }
        }

        public SelectAccountListAdapter(SelectPhoneAccountDialogFragment r1, Context r2, int r3, List<PhoneAccountHandle> r4) {
            this.this$0 = r1;
            super(r2, r3, r4);
            this.mResId = r3;
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int r3, View r4, ViewGroup r5) {
            LayoutInflater r6 = (LayoutInflater) getContext().getSystemService("layout_inflater");
            if (r4 != null) goto L5;
            r4 = r6.inflate(this.mResId, null);
            ViewHolder r7 = new ViewHolder(this, null);
            r7.labelTextView = (TextView) r4.findViewById(R.id.label);
            r7.numberTextView = (TextView) r4.findViewById(R.id.number);
            r7.imageView = (ImageView) r4.findViewById(R.id.icon);
            r4.setTag(r7);
        L6:
            PhoneAccountHandle r8 = getItem(r3);
            PhoneAccount r9 = SelectPhoneAccountDialogFragment.access$500(this.this$0).getPhoneAccount(r8);
            if (r9 != null) goto L9;
            return r4;
        L9:
            r7.labelTextView.setText(r9.getLabel());
            if (r9.getAddress() != null) goto L12;
        L15:
            r7.numberTextView.setVisibility(8);
        L16:
            r7.imageView.setImageDrawable(PhoneAccountCompat.createIconDrawable(r9, getContext()));
            return r4;
        L12:
            if (TextUtils.isEmpty(r9.getAddress().getSchemeSpecificPart()) == true) goto L15;
            r7.numberTextView.setVisibility(0);
            r7.numberTextView.setText(PhoneNumberUtilsCompat.createTtsSpannable(r9.getAddress().getSchemeSpecificPart()));
            goto L16
        L5:
            r7 = (ViewHolder) r4.getTag();
            goto L6
        }
    }

    public static class SelectPhoneAccountListener extends ResultReceiver {
        static final String EXTRA_SELECTED_ACCOUNT_HANDLE = "extra_selected_account_handle";
        static final String EXTRA_SET_DEFAULT = "extra_set_default";
        static final int RESULT_DISMISSED = 2;
        static final int RESULT_SELECTED = 1;

        public void onDialogDismissed() {
        }

        public void onPhoneAccountSelected(PhoneAccountHandle r1, boolean r2) {
        }

        public SelectPhoneAccountListener() {
            super(new Handler());
        }

        @Override // android.os.ResultReceiver
        protected void onReceiveResult(int r2, Bundle r3) {
            if (r2 != 1) goto L6;
            onPhoneAccountSelected((PhoneAccountHandle) r3.getParcelable(EXTRA_SELECTED_ACCOUNT_HANDLE), r3.getBoolean(EXTRA_SET_DEFAULT));
            return;
        L6:
            if (r2 != 2) goto L10;
            onDialogDismissed();
            return;
        }
    }

    static /* synthetic */ boolean access$002(SelectPhoneAccountDialogFragment r0, boolean r1) {
        r0.mIsSelected = r1;
        return r1;
    }

    static /* synthetic */ List access$100(SelectPhoneAccountDialogFragment r0) {
        return r0.mAccountHandles;
    }

    static /* synthetic */ boolean access$200(SelectPhoneAccountDialogFragment r0) {
        return r0.mIsDefaultChecked;
    }

    static /* synthetic */ boolean access$202(SelectPhoneAccountDialogFragment r0, boolean r1) {
        r0.mIsDefaultChecked = r1;
        return r1;
    }

    static /* synthetic */ SelectPhoneAccountListener access$300(SelectPhoneAccountDialogFragment r0) {
        return r0.mListener;
    }

    static /* synthetic */ TelecomManager access$500(SelectPhoneAccountDialogFragment r0) {
        return r0.mTelecomManager;
    }

    public static SelectPhoneAccountDialogFragment newInstance(List<PhoneAccountHandle> r2, SelectPhoneAccountListener r3) {
        return newInstance(R.string.select_account_dialog_title, false, r2, r3);
    }

    public static SelectPhoneAccountDialogFragment newInstance(int r3, boolean r4, List<PhoneAccountHandle> r5, SelectPhoneAccountListener r6) {
        ArrayList<? extends Parcelable> r0 = new ArrayList();
        if (r5 == null) goto L5;
        r0.addAll(r5);
    L5:
        SelectPhoneAccountDialogFragment r7 = new SelectPhoneAccountDialogFragment();
        Bundle r1 = new Bundle();
        r1.putInt(ARG_TITLE_RES_ID, r3);
        r1.putBoolean(ARG_CAN_SET_DEFAULT, r4);
        r1.putParcelableArrayList(ARG_ACCOUNT_HANDLES, r0);
        r1.putParcelable(ARG_LISTENER, r6);
        r7.setArguments(r1);
        r7.setListener(r6);
        return r7;
    }

    public SelectPhoneAccountDialogFragment() {
    }

    public void setListener(SelectPhoneAccountListener r1) {
        this.mListener = r1;
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onSaveInstanceState(Bundle r2) {
        super.onSaveInstanceState(r2);
        r2.putBoolean(ARG_IS_DEFAULT_CHECKED, this.mIsDefaultChecked);
    }

    @Override // android.app.DialogFragment
    public Dialog onCreateDialog(Bundle r7) {
        this.mTitleResId = getArguments().getInt(ARG_TITLE_RES_ID);
        this.mCanSetDefault = getArguments().getBoolean(ARG_CAN_SET_DEFAULT);
        this.mAccountHandles = getArguments().getParcelableArrayList(ARG_ACCOUNT_HANDLES);
        this.mListener = (SelectPhoneAccountListener) getArguments().getParcelable(ARG_LISTENER);
        if (r7 == null) goto L5;
        this.mIsDefaultChecked = r7.getBoolean(ARG_IS_DEFAULT_CHECKED);
    L5:
        this.mIsSelected = false;
        this.mTelecomManager = (TelecomManager) getActivity().getSystemService("telecom");
        DialogInterface.OnClickListener r8 = new AnonymousClass1(this);
        CompoundButton.OnCheckedChangeListener r0 = new AnonymousClass2(this);
        AlertDialog.Builder r1 = new AlertDialog.Builder(getActivity());
        SelectAccountListAdapter r2 = new SelectAccountListAdapter(this, r1.getContext(), R.layout.select_account_list_item, this.mAccountHandles);
        AlertDialog r9 = r1.setTitle(this.mTitleResId).setAdapter(r2, r8).create();
        if (this.mCanSetDefault == false) goto L8;
        LinearLayout r3 = (LinearLayout) getActivity().getLayoutInflater().inflate(R.layout.default_account_checkbox, null);
        CheckBox r4 = (CheckBox) r3.findViewById(R.id.default_account_checkbox_view);
        r4.setOnCheckedChangeListener(r0);
        r4.setChecked(this.mIsDefaultChecked);
        r9.getListView().addFooterView(r3);
    L8:
        return r9;
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onStop() {
        if (this.mIsSelected == true) goto L7;
        SelectPhoneAccountListener r0 = this.mListener;
        if (r0 == null) goto L7;
        r0.onReceiveResult(2, null);
    L7:
        super.onStop();
    }
}
