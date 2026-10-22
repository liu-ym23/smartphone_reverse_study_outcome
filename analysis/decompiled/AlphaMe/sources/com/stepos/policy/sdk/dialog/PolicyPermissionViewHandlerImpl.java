package com.stepos.policy.sdk.dialog;

import android.content.Context;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.stepos.alphame.R;
import com.stepos.policy.sdk.dialog.PolicyPermissionDialogView;
import java.util.Collections;
import java.util.List;
import stepos.support.v7.permission.c;
import stepos.support.v7.permission.d;

/* loaded from: classes.dex */
public class PolicyPermissionViewHandlerImpl implements PolicyPermissionViewHandler {
    private TextView mCenterIfNeedTextView;
    private final Context mContext;
    private d mPermissionManager;
    private TextView mTermsView;

    public PolicyPermissionViewHandlerImpl(Context context) {
        this.mContext = context;
        this.mPermissionManager = d.a(context);
    }

    private int getTextWidth(TextView textView, String str) {
        TransformationMethod transformationMethod = textView.getTransformationMethod();
        if (transformationMethod != null) {
            str = transformationMethod.getTransformation(str, textView).toString();
        }
        return (int) textView.getPaint().measureText(str);
    }

    private boolean isTextViewOneLine(TextView textView) {
        ViewGroup viewGroup = (ViewGroup) textView.getParent().getParent();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) viewGroup.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
        return (getTextWidth(textView, textView.getText().toString()) + (viewGroup.getPaddingRight() + (viewGroup.getPaddingLeft() + (textView.getPaddingRight() + textView.getPaddingLeft())))) + (((marginLayoutParams2.leftMargin + marginLayoutParams2.rightMargin) + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin) <= this.mContext.getResources().getDimensionPixelOffset(R.dimen.stepos_alert_dialog_width);
    }

    @Override // com.stepos.policy.sdk.dialog.PolicyPermissionViewHandler
    public void bindData(PolicyPermissionDialogView.Builder builder) {
        String str;
        if (TextUtils.isEmpty(builder.message)) {
            String[] strArr = builder.permissions;
            if (strArr == null || strArr.length <= 0) {
                str = null;
            } else {
                try {
                    StringBuilder sb = new StringBuilder();
                    int i4 = 0;
                    while (true) {
                        String[] strArr2 = builder.permissions;
                        if (i4 >= strArr2.length) {
                            break;
                        }
                        d dVar = this.mPermissionManager;
                        String str2 = strArr2[i4];
                        String strA = new stepos.support.v7.permission.b(str2, (stepos.support.v7.permission.a) dVar.f14650a.get(str2), dVar.f14652c).a();
                        if (!TextUtils.isEmpty(strA)) {
                            sb.append(strA);
                            sb.append("、");
                        }
                        i4++;
                    }
                    if (sb.length() > 0) {
                        sb.setLength(sb.length() - 1);
                    }
                    str = String.format(this.mContext.getResources().getString(R.string.stepos_permission_message_supplement), builder.appName, sb.toString(), Integer.valueOf(builder.permissions.length));
                } catch (Exception unused) {
                }
            }
        } else {
            str = builder.message;
        }
        if (TextUtils.isEmpty(str)) {
            this.mCenterIfNeedTextView.setVisibility(8);
        } else {
            this.mCenterIfNeedTextView.setText(str);
        }
        if (isTextViewOneLine(this.mCenterIfNeedTextView)) {
            this.mCenterIfNeedTextView.setGravity(17);
        }
    }

    @Override // com.stepos.policy.sdk.dialog.PolicyPermissionViewHandler
    public View createView(ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(this.mContext).inflate(R.layout.stepos_permission_dialog_simple, viewGroup, false);
        this.mCenterIfNeedTextView = (TextView) viewInflate.findViewById(R.id.stepos_permission_dialog_message);
        this.mTermsView = (TextView) viewInflate.findViewById(R.id.stepos_permission_dialog_terms);
        return viewInflate;
    }

    @Override // com.stepos.policy.sdk.dialog.PolicyPermissionViewHandler
    public CheckBox getCheckBox() {
        return new CheckBox(this.mContext);
    }

    @Override // com.stepos.policy.sdk.dialog.PolicyPermissionViewHandler
    public List<c> getPermissions() {
        return Collections.emptyList();
    }

    @Override // com.stepos.policy.sdk.dialog.PolicyPermissionViewHandler
    public TextView getTermsView() {
        return this.mTermsView;
    }
}
