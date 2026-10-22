package com.stepos.policy.sdk.dialog;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.stepos.policy.sdk.dialog.PolicyPermissionDialogView;
import java.util.List;
import stepos.support.v7.permission.c;

/* loaded from: classes.dex */
public interface PolicyPermissionViewHandler {
    void bindData(PolicyPermissionDialogView.Builder builder);

    View createView(ViewGroup viewGroup);

    CheckBox getCheckBox();

    List<c> getPermissions();

    TextView getTermsView();
}
