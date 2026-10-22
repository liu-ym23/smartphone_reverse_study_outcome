package com.android.contacts.interactions;

import android.app.FragmentManager;
import android.os.Bundle;
import android.widget.EditText;
import com.android.contacts.ContactSaveService;
import com.android.contacts.R;
import com.android.contacts.model.AccountWithDataSet;

/* JADX INFO: loaded from: classes2.dex */
public class GroupCreationDialogFragment extends GroupNameDialogFragment {
    private static final String ARG_ACCOUNT_NAME = "accountName";
    private static final String ARG_ACCOUNT_TYPE = "accountType";
    private static final String ARG_DATA_SET = "dataSet";

    @Override // com.android.contacts.interactions.GroupNameDialogFragment
    protected int getTitleResourceId() {
        return R.string.common_create_new_group;
    }

    @Override // com.android.contacts.interactions.GroupNameDialogFragment
    protected void initializeGroupLabelEditText(EditText r1) {
    }

    public GroupCreationDialogFragment() {
    }

    public static void show(FragmentManager r3, String r4, String r5, String r6) {
        GroupCreationDialogFragment r0 = new GroupCreationDialogFragment();
        Bundle r1 = new Bundle();
        r1.putString("accountType", r4);
        r1.putString("accountName", r5);
        r1.putString("dataSet", r6);
        r0.setArguments(r1);
        r0.show(r3, ContactSaveService.ACTION_CREATE_GROUP);
    }

    @Override // com.android.contacts.interactions.GroupNameDialogFragment
    protected void onCompleted(String r11) {
        Bundle r0 = getArguments();
        String r1 = r0.getString("accountType");
        String r2 = r0.getString("accountName");
        String r3 = r0.getString("dataSet");
        getActivity().startService(ContactSaveService.createNewGroupIntent(getActivity(), new AccountWithDataSet(r2, r1, r3), r11, null, getActivity().getClass(), "android.intent.action.EDIT"));
    }
}
