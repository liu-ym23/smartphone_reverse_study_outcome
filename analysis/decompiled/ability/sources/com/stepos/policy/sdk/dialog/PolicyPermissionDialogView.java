package com.stepos.policy.sdk.dialog;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Pair;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import stepos.support.v7.app.S;
import stepos.support.v7.permission.c;

/* loaded from: classes3.dex */
public class PolicyPermissionDialogView extends RelativeLayout {
    private final PolicyPermissionViewHandler mViewHandler;

    public static class Builder {
        Activity activity;
        List<Pair<String, String>> additionalGroups;
        String appName;
        CharSequence csReminder;
        boolean isDark;
        boolean isIntl;
        boolean mShowTitle = true;
        String message;
        String[] permissionReasons;
        String[] permissions;
        String reminder;
        boolean showAlmostDenyBtn;

        public void build(PolicyPermissionDialogView policyPermissionDialogView) {
            policyPermissionDialogView.setPermissionDialogBuild(this);
        }

        public Builder isIntl(boolean z10) {
            this.isIntl = z10;
            return this;
        }

        public Builder setActivity(Activity activity) {
            this.activity = activity;
            return this;
        }

        public Builder setAdditionalGroups(List<Pair<String, String>> list) {
            this.additionalGroups = list;
            return this;
        }

        public Builder setAppName(@NonNull String str) {
            this.appName = str;
            return this;
        }

        public Builder setCsReminder(@NonNull CharSequence charSequence) {
            this.csReminder = charSequence;
            return this;
        }

        public Builder setDark(boolean z10) {
            this.isDark = z10;
            return this;
        }

        public Builder setMessage(String str) {
            this.message = str;
            return this;
        }

        public Builder setPermission(@NonNull String[] strArr, @NonNull String[] strArr2) {
            this.permissions = strArr;
            this.permissionReasons = strArr2;
            return this;
        }

        public Builder setReminder(@NonNull String str) {
            this.reminder = str;
            return this;
        }

        public Builder setShowAlmostDenyBtn(boolean z10) {
            this.showAlmostDenyBtn = z10;
            return this;
        }

        public Builder setShowTitle(boolean z10) {
            this.mShowTitle = z10;
            return this;
        }

        @Deprecated
        public Builder setTheme(int i) {
            return this;
        }
    }

    public PolicyPermissionDialogView(Context context) {
        this(context, null);
    }

    public CheckBox getCheckBox() {
        return this.mViewHandler.getCheckBox();
    }

    public Map<String, Boolean> getItemCheckedMap() {
        PolicyPermissionViewHandler policyPermissionViewHandler = this.mViewHandler;
        if (policyPermissionViewHandler instanceof PolicyPermissionViewHandlerImpl23) {
            return ((PolicyPermissionViewHandlerImpl23) policyPermissionViewHandler).getItemCheckedMap();
        }
        return null;
    }

    public List<c> getPermissions() {
        return this.mViewHandler.getPermissions();
    }

    public TextView getTermsView() {
        return this.mViewHandler.getTermsView();
    }

    public void setPermissionDialogBuild(Builder builder) {
        this.mViewHandler.bindData(builder);
    }

    public PolicyPermissionDialogView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PolicyPermissionDialogView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ArrayList arrayList = S.f6233q;
        PolicyPermissionViewHandlerImpl23 policyPermissionViewHandlerImpl23 = new PolicyPermissionViewHandlerImpl23(context);
        this.mViewHandler = policyPermissionViewHandlerImpl23;
        addView(policyPermissionViewHandlerImpl23.createView(this));
    }
}
