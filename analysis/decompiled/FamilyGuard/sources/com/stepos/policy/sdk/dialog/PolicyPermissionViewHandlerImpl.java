package com.stepos.policy.sdk.dialog;

import H1.f;
import X4.h;
import X4.j;
import Z4.d;
import Z4.e;
import android.content.Context;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.stepos.policy.sdk.dialog.PolicyPermissionDialogView;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class PolicyPermissionViewHandlerImpl implements PolicyPermissionViewHandler {
    private TextView mCenterIfNeedTextView;
    private final Context mContext;
    private e mPermissionManager;
    private TextView mTermsView;

    public PolicyPermissionViewHandlerImpl(Context context) {
        this.mContext = context;
        this.mPermissionManager = e.b(context);
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
        return (getTextWidth(textView, textView.getText().toString()) + (((textView.getPaddingLeft() + textView.getPaddingRight()) + viewGroup.getPaddingLeft()) + viewGroup.getPaddingRight())) + (((marginLayoutParams2.leftMargin + marginLayoutParams2.rightMargin) + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin) <= this.mContext.getResources().getDimensionPixelOffset(f.f2128X);
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
                    int i5 = 0;
                    while (true) {
                        String[] strArr2 = builder.permissions;
                        if (i5 >= strArr2.length) {
                            break;
                        }
                        String strD = this.mPermissionManager.d(this.mContext, strArr2[i5]);
                        if (!TextUtils.isEmpty(strD)) {
                            sb.append(strD);
                            sb.append("、");
                        }
                        i5++;
                    }
                    if (sb.length() > 0) {
                        sb.setLength(sb.length() - 1);
                    }
                    str = String.format(this.mContext.getResources().getString(j.f6061j), builder.appName, sb.toString(), Integer.valueOf(builder.permissions.length));
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
        View viewInflate = LayoutInflater.from(this.mContext).inflate(h.f6049u, viewGroup, false);
        this.mCenterIfNeedTextView = (TextView) viewInflate.findViewById(X4.f.f5986d0);
        this.mTermsView = (TextView) viewInflate.findViewById(X4.f.f6000k0);
        return viewInflate;
    }

    @Override // com.stepos.policy.sdk.dialog.PolicyPermissionViewHandler
    public CheckBox getCheckBox() {
        return new CheckBox(this.mContext);
    }

    @Override // com.stepos.policy.sdk.dialog.PolicyPermissionViewHandler
    public List<d> getPermissions() {
        return Collections.EMPTY_LIST;
    }

    @Override // com.stepos.policy.sdk.dialog.PolicyPermissionViewHandler
    public TextView getTermsView() {
        return this.mTermsView;
    }
}
