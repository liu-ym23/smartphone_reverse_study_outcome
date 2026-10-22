package com.stepos.policy.sdk.dialog;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.stepos.policy.sdk.dialog.PolicyPermissionDialogView;
import java.util.List;
import qe.c;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public interface PolicyPermissionViewHandler {
    void bindData(PolicyPermissionDialogView.Builder builder);

    View createView(ViewGroup viewGroup);

    CheckBox getCheckBox();

    List<c> getPermissions();

    TextView getTermsView();
}
