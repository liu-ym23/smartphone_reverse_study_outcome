package com.stepos.policy.sdk.dialog;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.stepos.policy.sdk.dialog.PolicyPermissionDialogView;
import java.util.List;
import stepos.support.v7.permission.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface PolicyPermissionViewHandler {
    void bindData(PolicyPermissionDialogView.Builder builder);

    View createView(ViewGroup viewGroup);

    CheckBox getCheckBox();

    List<d> getPermissions();

    TextView getTermsView();
}
