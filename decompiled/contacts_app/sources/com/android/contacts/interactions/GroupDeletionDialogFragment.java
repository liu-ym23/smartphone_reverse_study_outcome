package com.android.contacts.interactions;

import android.app.Dialog;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import com.android.contacts.R;
import com.android.contacts.util.OAlertDialogUtils;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import com.obric.oui.dialog.v2.alert.style.ButtonStyleController;

/* JADX INFO: loaded from: classes2.dex */
public class GroupDeletionDialogFragment extends DialogFragment {
    public static final String ARG_GROUP_ID = "groupId";
    public static final String ARG_LABEL = "label";
    public static final String ARG_SHOULD_END_ACTIVITY = "endActivity";
    private static OnClickDeleteListener mOnClickDeleteListener;
    private OAlertDialog mDeleteDialog;

    public interface OnClickDeleteListener {
        void onClick();
    }

    public GroupDeletionDialogFragment() {
    }

    public void setOnClickDeleteListener(OnClickDeleteListener r1) {
        mOnClickDeleteListener = r1;
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle r3) {
        return getDeleteGroupDialog(getActivity().getString(R.string.delete_group_dialog_title), getActivity().getString(R.string.delete_group_dialog_message));
    }

    private Dialog getDeleteGroupDialog(String r11, String r12) {
        OAlertDialog r0 = this.mDeleteDialog;
        if (r0 == null) goto L5;
        r0.dismiss();
    L5:
        OAlertDialog r13 = OAlertDialogUtils.showConfirmationDialog(requireContext(), r11, r12, getString(R.string.btn_confirm_delete), new AnonymousClass1(this), ButtonStyleController.TextColorType.Negative, getString(R.string.common_cancel), new AnonymousClass2(this), null);
        this.mDeleteDialog = r13;
        r13.setCanceledOnTouchOutside(true);
        return this.mDeleteDialog;
    }

    protected void deleteGroup() {
        OnClickDeleteListener r0 = mOnClickDeleteListener;
        if (r0 == null) goto L6;
        r0.onClick();
    L6:
        if (shouldEndActivity() == false) goto L9;
        getActivity().finish();
        return;
    }

    private boolean shouldEndActivity() {
        return getArguments().getBoolean(ARG_SHOULD_END_ACTIVITY);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        OAlertDialog r0 = this.mDeleteDialog;
        if (r0 == null) goto L6;
        r0.dismiss();
        this.mDeleteDialog = null;
        return;
    }
}
