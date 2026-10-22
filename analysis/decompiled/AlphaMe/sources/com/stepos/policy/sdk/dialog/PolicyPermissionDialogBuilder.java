package com.stepos.policy.sdk.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.Pair;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.StyleRes;
import com.stepos.alphame.R;
import com.stepos.policy.sdk.dialog.PolicyPermissionDialogView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;
import m2.i;
import stepos.support.v7.app.C0861f;
import stepos.support.v7.app.C0864i;
import stepos.support.v7.app.DialogInterfaceC0865j;
import stepos.support.v7.app.InterfaceC0863h;
import stepos.support.v7.permission.e;
import stepos.support.v7.permission.f;

/* loaded from: classes.dex */
public class PolicyPermissionDialogBuilder {
    private static final String PREMISSION_INTERNET = "android.permission.INTERNET";
    private static final String PREMISSION_INTERNET_ACCESS = "android.permission.ACCESS_NETWORK_STATE";
    private static final String PREMISSION_INTERNET_CHANGE = "android.permission.CHANGE_NETWORK_STATE";
    private static final String PREMISSION_INTERNET_GROUP = "stepos.permission-group.NETWORK";
    public static final boolean sOldPermissionDialog = false;
    private List<Pair<String, String>> mAdditionalGroups;
    private String mAppName;
    private OnPermissionClickListener mCallBack;
    private boolean mCancelable;
    private boolean mCheckEnableConfirm;
    private final Context mContext;
    private CharSequence mCsReminder;
    private String mCustomNegativeButtonText;
    private String mCustomPositiveButtonText;
    private String mCustomPrivacyPolicyName;
    private String mCustomUserAgreementName;
    private boolean mHaveSecondaryConfirmation;
    private boolean mIsDark;
    private boolean mIsIntl;
    private String mMessage;
    private int mPermissionBuilderType;
    private int mPermissionInternetType;
    private String[] mPermissionReason;
    private String[] mPermissions;
    private View.OnClickListener mPrivacyPolicyListener;
    private String mReminder;
    private boolean mShowAlmostDenyBtn;
    private CharSequence mTerms;
    private int mTheme;
    private View.OnClickListener mUserAgreementListener;

    public interface OnPermissionClickListener {
        default void onPermissionClick(DialogInterface dialogInterface, boolean z4, String str) {
        }

        default void onPermissionClick(DialogInterface dialogInterface, boolean z4, boolean z5) {
        }

        default void onPermissionClick(DialogInterface dialogInterface, boolean z4, boolean z5, Map<String, Boolean> map) {
        }

        default void onPermissionClick(DialogInterface dialogInterface, boolean z4, boolean z5, boolean z6) {
        }
    }

    public static class PermissionDialog extends DialogInterfaceC0865j {
        private OnPermissionClickListener mCallBack;

        private PermissionDialog(@NonNull Context context, int i4, OnPermissionClickListener onPermissionClickListener) {
            super(context, i4);
            this.mCallBack = onPermissionClickListener;
        }

        private boolean isPerformanceTest() {
            try {
                return ((Boolean) i.b("android.os.SystemProperties").b("getBoolean", String.class, Boolean.TYPE).f13573a.invoke(null, "debug.perf.applunch", Boolean.FALSE)).booleanValue();
            } catch (Exception unused) {
                return false;
            }
        }

        private boolean isProductInternational() {
            try {
                return ((Boolean) i.b("android.os.BuildExt").b("isProductInternational", new Class[0]).f13573a.invoke(null, new Object[0])).booleanValue();
            } catch (Exception unused) {
                return false;
            }
        }

        private boolean isShopDemo() {
            try {
                return ((Boolean) i.b("android.os.BuildExt").b("isShopDemoVersion", new Class[0]).f13573a.invoke(null, new Object[0])).booleanValue();
            } catch (Exception unused) {
                return false;
            }
        }

        @Override // android.app.Dialog
        public void show() {
            if (!isPerformanceTest() && !isShopDemo()) {
                super.show();
                return;
            }
            OnPermissionClickListener onPermissionClickListener = this.mCallBack;
            if (onPermissionClickListener != null) {
                onPermissionClickListener.onPermissionClick((DialogInterface) this, false, true);
            }
        }
    }

    public PolicyPermissionDialogBuilder(Context context) {
        this(context, resolveDialogTheme(context, 0));
    }

    private ArrayList<Integer> buildInternetPermission(String[] strArr) {
        int i4;
        ArrayList<Integer> arrayList = new ArrayList<>();
        int i5 = 0;
        while (true) {
            if (i5 >= strArr.length) {
                break;
            }
            if (PREMISSION_INTERNET_GROUP.equals(strArr[i5])) {
                arrayList.clear();
                for (int i6 = 0; i6 < strArr.length; i6++) {
                    if (PREMISSION_INTERNET_GROUP.equals(strArr[i6]) || PREMISSION_INTERNET.equals(strArr[i6]) || PREMISSION_INTERNET_CHANGE.equals(strArr[i6]) || PREMISSION_INTERNET_ACCESS.equals(strArr[i6])) {
                        arrayList.add(Integer.valueOf(i6));
                    }
                }
            } else {
                if (PREMISSION_INTERNET.equals(strArr[i5])) {
                    arrayList.add(Integer.valueOf(i5));
                }
                i5++;
            }
        }
        if (arrayList.size() <= 0) {
            i4 = 2;
        } else {
            if (strArr.length - arrayList.size() > 0) {
                setPermissionInternetType(0);
                return arrayList;
            }
            i4 = 1;
        }
        setPermissionInternetType(i4);
        return arrayList;
    }

    private static boolean isZh(String str) {
        return Pattern.compile("[\\u4E00-\\u9FA5]+").matcher(str).find();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPermissionClick(DialogInterface dialogInterface, boolean z4, boolean z5, Map<String, Boolean> map) {
        OnPermissionClickListener onPermissionClickListener = this.mCallBack;
        if (onPermissionClickListener == null) {
            return;
        }
        if (this.mIsIntl) {
            onPermissionClickListener.onPermissionClick(dialogInterface, z4, z5, map);
        } else {
            onPermissionClickListener.onPermissionClick(dialogInterface, z4, z5);
        }
    }

    private String[] rebuildPermissions(String[] strArr, ArrayList<Integer> arrayList) {
        ArrayList arrayList2 = new ArrayList(Arrays.asList(strArr));
        ArrayList arrayList3 = new ArrayList();
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            arrayList3.add((String) arrayList2.get(arrayList.get(i4).intValue()));
        }
        for (int i5 = 0; i5 < arrayList3.size(); i5++) {
            arrayList2.remove(arrayList3.get(i5));
        }
        return (String[]) arrayList2.toArray(new String[0]);
    }

    public static int resolveDialogTheme(@NonNull Context context, @StyleRes int i4) {
        if (((i4 >>> 24) & 255) >= 1) {
            return i4;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    private boolean showTermsCheckBox() {
        return ("en".equals(Locale.getDefault().getLanguage()) || "zh".equals(Locale.getDefault().getLanguage())) && !TextUtils.isEmpty(this.mTerms);
    }

    public PolicyPermissionDialogBuilder addAdditionalGroup(String str, String str2) {
        if (this.mAdditionalGroups == null) {
            this.mAdditionalGroups = new ArrayList();
        }
        this.mAdditionalGroups.add(Pair.create(str, str2));
        return this;
    }

    public DialogInterfaceC0865j create() {
        List<Pair<String, String>> list;
        Resources resources;
        int i4;
        String string;
        Context context;
        int i5;
        String string2 = this.mContext.getString(R.string.stepos_permission_use_info);
        if (this.mPermissionBuilderType == 0 && TextUtils.isEmpty(this.mAppName)) {
            throw new IllegalArgumentException("appName can't be null");
        }
        String[] strArr = this.mPermissions;
        boolean z4 = (strArr != null && (strArr.length > 0 || (strArr.length == 0 && this.mPermissionInternetType == 1))) || ((list = this.mAdditionalGroups) != null && list.size() > 0);
        boolean z5 = sOldPermissionDialog;
        if (z5) {
            z4 = z4 || !TextUtils.isEmpty(this.mMessage);
        }
        boolean z6 = (this.mTerms == null && this.mPrivacyPolicyListener == null && this.mUserAgreementListener == null) ? false : true;
        if (!z4 && !z6) {
            throw new IllegalArgumentException("[permissions], [additional groups] and [terms] both null");
        }
        String[] strArr2 = this.mPermissions;
        if (strArr2 != null) {
            String[] strArr3 = this.mPermissionReason;
            if (strArr3 == null) {
                throw new IllegalArgumentException("permissionReason can't be null");
            }
            if (strArr3.length != strArr2.length) {
                throw new IllegalArgumentException("permissionReason.length must equal permissions.length");
            }
        }
        boolean z7 = !z5;
        final PolicyPermissionDialogView policyPermissionDialogView = new PolicyPermissionDialogView(this.mContext);
        new PolicyPermissionDialogView.Builder().setAppName(this.mPermissionBuilderType == 0 ? this.mAppName : string2).setShowAlmostDenyBtn(this.mShowAlmostDenyBtn).setPermission(this.mPermissions, this.mPermissionReason).setAdditionalGroups(this.mAdditionalGroups).setMessage(this.mMessage).setReminder(this.mReminder).setCsReminder(this.mCsReminder).setDark(this.mIsDark).isIntl(this.mIsIntl).setShowTitle(z5).build(policyPermissionDialogView);
        C0864i c0864i = new C0864i(this.mContext, this.mTheme);
        C0861f c0861f = c0864i.f14506a;
        c0861f.f14466r = policyPermissionDialogView;
        c0861f.f14459k = this.mCancelable;
        c0861f.f14460l = new DialogInterface.OnCancelListener() { // from class: com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                PolicyPermissionDialogBuilder.this.onPermissionClick(dialogInterface, policyPermissionDialogView.getCheckBox().isChecked(), false, policyPermissionDialogView.getItemCheckedMap());
            }
        };
        if (TextUtils.isEmpty(this.mCustomPositiveButtonText)) {
            if (this.mPermissionBuilderType == 1) {
                resources = this.mContext.getResources();
                i4 = R.string.stepos_permission_i_know;
            } else {
                resources = this.mContext.getResources();
                i4 = R.string.stepos_permission_agree;
            }
            string = resources.getString(i4);
        } else {
            string = this.mCustomPositiveButtonText;
        }
        DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i6) {
                PolicyPermissionDialogBuilder.this.onPermissionClick(dialogInterface, policyPermissionDialogView.getCheckBox().isChecked(), true, policyPermissionDialogView.getItemCheckedMap());
            }
        };
        c0861f.f14455g = string;
        c0861f.f14456h = onClickListener;
        int i6 = this.mPermissionBuilderType;
        if (i6 != 1) {
            String string3 = this.mCustomNegativeButtonText;
            if (string3 == null) {
                if (this.mHaveSecondaryConfirmation || i6 == 3) {
                    context = this.mContext;
                    i5 = R.string.stepos_permission_deny;
                } else {
                    context = this.mContext;
                    i5 = R.string.stepos_action_bar_multi_choice_cancel;
                }
                string3 = context.getString(i5);
            }
            DialogInterface.OnClickListener onClickListener2 = new DialogInterface.OnClickListener() { // from class: com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i7) {
                    PolicyPermissionDialogBuilder.this.onPermissionClick(dialogInterface, policyPermissionDialogView.getCheckBox().isChecked(), false, policyPermissionDialogView.getItemCheckedMap());
                }
            };
            c0861f.f14457i = string3;
            c0861f.f14458j = onClickListener2;
            c0861f.f14469u = -1;
            c0861f.f14470v = 0;
        }
        if (z7) {
            if (this.mPermissionBuilderType == 0) {
                string2 = this.mAppName;
            }
            c0861f.f14452d = string2;
        }
        final PermissionDialog permissionDialog = (PermissionDialog) c0864i.a(new InterfaceC0863h() { // from class: com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder.4
            @Override // stepos.support.v7.app.InterfaceC0863h
            public PermissionDialog newDialog(@NonNull Context context2, int i7) {
                return new PermissionDialog(context2, i7, PolicyPermissionDialogBuilder.this.mCallBack);
            }
        });
        policyPermissionDialogView.getCheckBox().setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder.5
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z8) {
                if (PolicyPermissionDialogBuilder.this.mCheckEnableConfirm) {
                    return;
                }
                permissionDialog.getButton(-1).setEnabled(!z8);
            }
        });
        final TextView termsView = policyPermissionDialogView.getTermsView();
        if (this.mTerms == null) {
            f fVar = new f(this.mContext);
            fVar.f14656d = z4;
            fVar.f14654b = this.mPrivacyPolicyListener != null;
            fVar.f14655c = this.mUserAgreementListener != null;
            fVar.f14658f = this.mPermissionInternetType;
            fVar.f14659g = this.mPermissionBuilderType;
            fVar.f14660h = this.mCustomPrivacyPolicyName;
            fVar.f14661i = this.mCustomUserAgreementName;
            fVar.f14657e = new e() { // from class: com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder.6
                @Override // stepos.support.v7.permission.e
                public void onPrivacyPolicyClick(Context context2) {
                    if (PolicyPermissionDialogBuilder.this.mPrivacyPolicyListener != null) {
                        PolicyPermissionDialogBuilder.this.mPrivacyPolicyListener.onClick(termsView);
                    }
                }

                @Override // stepos.support.v7.permission.e
                public void onUserAgreementClick(Context context2) {
                    if (PolicyPermissionDialogBuilder.this.mUserAgreementListener != null) {
                        PolicyPermissionDialogBuilder.this.mUserAgreementListener.onClick(termsView);
                    }
                }
            };
            this.mTerms = fVar.b();
        }
        termsView.setText(this.mTerms);
        termsView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder.7
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                termsView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                termsView.getLineCount();
            }
        });
        termsView.setMovementMethod(LinkMovementMethod.getInstance());
        termsView.setHighlightColor(0);
        return permissionDialog;
    }

    public PolicyPermissionDialogBuilder isIntl(boolean z4) {
        this.mIsIntl = z4;
        return this;
    }

    public boolean isTablet(Context context) {
        return context.getResources().getBoolean(R.bool.isTablet);
    }

    public PolicyPermissionDialogBuilder setAppName(String str) {
        this.mAppName = str;
        return this;
    }

    public PolicyPermissionDialogBuilder setBuilderDialogType(int i4) {
        this.mPermissionBuilderType = i4;
        return this;
    }

    public PolicyPermissionDialogBuilder setCancelable(boolean z4) {
        this.mCancelable = z4;
        return this;
    }

    public PolicyPermissionDialogBuilder setCheckEnableConfirmBtn(boolean z4) {
        this.mCheckEnableConfirm = z4;
        return this;
    }

    public PolicyPermissionDialogBuilder setCustomNegativeButtonText(String str) {
        this.mCustomNegativeButtonText = str;
        return this;
    }

    public PolicyPermissionDialogBuilder setCustomPositiveButtonText(String str) {
        this.mCustomPositiveButtonText = str;
        return this;
    }

    public PolicyPermissionDialogBuilder setCustomTerms(CharSequence charSequence) {
        this.mTerms = charSequence;
        return this;
    }

    public PolicyPermissionDialogBuilder setDark(boolean z4) {
        if (z4) {
            this.mTheme = R.style.Theme_StepOS_AppCompat_Light_Dialog_Alert_Dark;
        }
        this.mIsDark = z4;
        return this;
    }

    public PolicyPermissionDialogBuilder setMessage(String str) {
        this.mMessage = str;
        return this;
    }

    public PolicyPermissionDialogBuilder setOnPermissionListener(OnPermissionClickListener onPermissionClickListener) {
        this.mCallBack = onPermissionClickListener;
        return this;
    }

    public PolicyPermissionDialogBuilder setPermission(@NonNull String[] strArr, @NonNull String[] strArr2) {
        ArrayList<Integer> arrayListBuildInternetPermission = buildInternetPermission(strArr);
        if (arrayListBuildInternetPermission.size() > 0) {
            this.mPermissions = rebuildPermissions(strArr, arrayListBuildInternetPermission);
            this.mPermissionReason = rebuildPermissions(strArr2, arrayListBuildInternetPermission);
        } else {
            this.mPermissions = strArr;
            this.mPermissionReason = strArr2;
        }
        return this;
    }

    public PolicyPermissionDialogBuilder setPermissionInternetType(int i4) {
        this.mPermissionInternetType = i4;
        return this;
    }

    public PolicyPermissionDialogBuilder setPrivacyPolicyName(String str) {
        this.mCustomPrivacyPolicyName = str;
        return this;
    }

    public PolicyPermissionDialogBuilder setReminder(CharSequence charSequence) {
        this.mCsReminder = charSequence;
        return this;
    }

    public PolicyPermissionDialogBuilder setSecondaryConfirmation(boolean z4) {
        this.mHaveSecondaryConfirmation = z4;
        return this;
    }

    public PolicyPermissionDialogBuilder setShowAlmostDenyBtn(boolean z4) {
        this.mShowAlmostDenyBtn = z4;
        return this;
    }

    public PolicyPermissionDialogBuilder setUserAgreementName(String str) {
        this.mCustomUserAgreementName = str;
        return this;
    }

    public DialogInterfaceC0865j show() {
        DialogInterfaceC0865j dialogInterfaceC0865jCreate = create();
        dialogInterfaceC0865jCreate.show();
        return dialogInterfaceC0865jCreate;
    }

    public PolicyPermissionDialogBuilder showPrivacyPolicy(View.OnClickListener onClickListener) {
        this.mPrivacyPolicyListener = onClickListener;
        return this;
    }

    public PolicyPermissionDialogBuilder showUserAgreement(View.OnClickListener onClickListener) {
        this.mUserAgreementListener = onClickListener;
        return this;
    }

    public PolicyPermissionDialogBuilder(Context context, int i4) {
        this.mPrivacyPolicyListener = null;
        this.mUserAgreementListener = null;
        this.mCancelable = false;
        this.mCheckEnableConfirm = false;
        this.mPermissionInternetType = 0;
        this.mPermissionBuilderType = 0;
        this.mCustomPrivacyPolicyName = null;
        this.mCustomUserAgreementName = null;
        this.mCustomNegativeButtonText = null;
        this.mCustomPositiveButtonText = null;
        this.mContext = context;
        this.mTheme = i4;
    }

    public PolicyPermissionDialogBuilder setReminder(String str) {
        this.mReminder = str;
        return this;
    }
}
