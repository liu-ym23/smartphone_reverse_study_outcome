package com.stepos.policy.sdk.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.stepos.aiengine.R;
import com.stepos.policy.sdk.dialog.PolicyPermissionDialogView;
import com.stepos.policy.sdk.util.PolicyDialogScrollHelper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;
import stepos.support.v7.app.c;
import stepos.support.v7.app.e;
import stepos.support.v7.permission.TermsStringBuilder;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
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

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface OnPermissionClickListener {
        default void onPermissionClick(DialogInterface dialogInterface, boolean z, String str) {
        }

        default void onPermissionClick(DialogInterface dialogInterface, boolean z, boolean z3) {
        }

        default void onPermissionClick(DialogInterface dialogInterface, boolean z, boolean z3, Map<String, Boolean> map) {
        }

        default void onPermissionClick(DialogInterface dialogInterface, boolean z, boolean z3, boolean z10) {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface OnThreeButtonClickListener {
        void onBasicOnlyClick(DialogInterface dialogInterface, boolean z);

        void onFullAgreeClick(DialogInterface dialogInterface, boolean z, Map<String, Boolean> map);

        void onRejectClick(DialogInterface dialogInterface, boolean z);
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class PermissionDialog extends e {
        private OnPermissionClickListener mCallBack;

        private boolean isPerformanceTest() {
            try {
                return ((Boolean) l8.e.b("android.os.SystemProperties").a("getBoolean", String.class, Boolean.TYPE).a(null, "debug.perf.applunch", Boolean.FALSE)).booleanValue();
            } catch (Exception unused) {
                return false;
            }
        }

        private boolean isProductInternational() {
            try {
                return ((Boolean) l8.e.b("android.os.BuildExt").a("isProductInternational", new Class[0]).a(null, new Object[0])).booleanValue();
            } catch (Exception unused) {
                return false;
            }
        }

        private boolean isShopDemo() {
            try {
                return ((Boolean) l8.e.b("android.os.BuildExt").a("isShopDemoVersion", new Class[0]).a(null, new Object[0])).booleanValue();
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

        private PermissionDialog(Context context, int i10, OnPermissionClickListener onPermissionClickListener) {
            super(context, i10);
            this.mCallBack = onPermissionClickListener;
        }
    }

    public PolicyPermissionDialogBuilder(Context context) {
        this(context, resolveDialogTheme(context, 0));
    }

    private ArrayList<Integer> buildInternetPermission(String[] strArr) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int i10 = 0;
        while (true) {
            if (i10 >= strArr.length) {
                break;
            }
            if (PREMISSION_INTERNET_GROUP.equals(strArr[i10])) {
                arrayList.clear();
                for (int i11 = 0; i11 < strArr.length; i11++) {
                    if (PREMISSION_INTERNET_GROUP.equals(strArr[i11]) || PREMISSION_INTERNET.equals(strArr[i11]) || PREMISSION_INTERNET_CHANGE.equals(strArr[i11]) || PREMISSION_INTERNET_ACCESS.equals(strArr[i11])) {
                        arrayList.add(Integer.valueOf(i11));
                    }
                }
            } else {
                if (PREMISSION_INTERNET.equals(strArr[i10])) {
                    arrayList.add(Integer.valueOf(i10));
                }
                i10++;
            }
        }
        if (arrayList.size() <= 0) {
            setPermissionInternetType(2);
            return arrayList;
        }
        if (strArr.length - arrayList.size() > 0) {
            setPermissionInternetType(0);
            return arrayList;
        }
        setPermissionInternetType(1);
        return arrayList;
    }

    private int getThreeButtonDialogMaxContentHeight(View view) {
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        float f8 = displayMetrics.density;
        view.measure(View.MeasureSpec.makeMeasureSpec(displayMetrics.widthPixels, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        return Math.max(((((int) (displayMetrics.heightPixels * 0.88f)) - view.getMeasuredHeight()) - ((int) (56.0f * f8))) - ((int) (48.0f * f8)), (int) (f8 * 180.0f));
    }

    private static boolean isZh(String str) {
        return Pattern.compile("[\\u4E00-\\u9FA5]+").matcher(str).find();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPermissionClick(DialogInterface dialogInterface, boolean z, boolean z3, Map<String, Boolean> map) {
        OnPermissionClickListener onPermissionClickListener = this.mCallBack;
        if (onPermissionClickListener == null) {
            return;
        }
        if (this.mIsIntl) {
            onPermissionClickListener.onPermissionClick(dialogInterface, z, z3, map);
        } else {
            onPermissionClickListener.onPermissionClick(dialogInterface, z, z3);
        }
    }

    private String[] rebuildPermissions(String[] strArr, ArrayList<Integer> arrayList) {
        ArrayList arrayList2 = new ArrayList(Arrays.asList(strArr));
        ArrayList arrayList3 = new ArrayList();
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            arrayList3.add((String) arrayList2.get(arrayList.get(i10).intValue()));
        }
        for (int i11 = 0; i11 < arrayList3.size(); i11++) {
            arrayList2.remove(arrayList3.get(i11));
        }
        return (String[]) arrayList2.toArray(new String[0]);
    }

    public static int resolveDialogTheme(Context context, int i10) {
        if (((i10 >>> 24) & 255) >= 1) {
            return i10;
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

    public e create() {
        List<Pair<String, String>> list;
        Resources resources;
        int i10;
        String string;
        String string2 = this.mContext.getString(R.string.stepos_permission_use_info);
        if (this.mPermissionBuilderType == 0 && TextUtils.isEmpty(this.mAppName)) {
            throw new IllegalArgumentException("appName can't be null");
        }
        String[] strArr = this.mPermissions;
        boolean z = (strArr != null && (strArr.length > 0 || (strArr.length == 0 && this.mPermissionInternetType == 1))) || ((list = this.mAdditionalGroups) != null && list.size() > 0);
        boolean z3 = sOldPermissionDialog;
        if (z3) {
            z = z || !TextUtils.isEmpty(this.mMessage);
        }
        boolean z10 = (this.mTerms == null && this.mPrivacyPolicyListener == null && this.mUserAgreementListener == null) ? false : true;
        if (!z && !z10) {
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
        final PolicyPermissionDialogView policyPermissionDialogView = new PolicyPermissionDialogView(this.mContext);
        new PolicyPermissionDialogView.Builder().setAppName(this.mPermissionBuilderType == 0 ? this.mAppName : string2).setShowAlmostDenyBtn(this.mShowAlmostDenyBtn).setPermission(this.mPermissions, this.mPermissionReason).setAdditionalGroups(this.mAdditionalGroups).setMessage(this.mMessage).setReminder(this.mReminder).setCsReminder(this.mCsReminder).setDark(this.mIsDark).isIntl(this.mIsIntl).setShowTitle(z3).build(policyPermissionDialogView);
        e.a aVar = new e.a(this.mContext, this.mTheme);
        c.a aVar2 = aVar.f12101a;
        aVar2.f12094o = policyPermissionDialogView;
        aVar2.f12089j = this.mCancelable;
        aVar2.f12090k = new DialogInterface.OnCancelListener() { // from class: com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                PolicyPermissionDialogBuilder.this.onPermissionClick(dialogInterface, policyPermissionDialogView.getCheckBox().isChecked(), false, policyPermissionDialogView.getItemCheckedMap());
            }
        };
        if (TextUtils.isEmpty(this.mCustomPositiveButtonText)) {
            if (this.mPermissionBuilderType == 1) {
                resources = this.mContext.getResources();
                i10 = R.string.stepos_permission_i_know;
            } else {
                resources = this.mContext.getResources();
                i10 = R.string.stepos_permission_agree;
            }
            string = resources.getString(i10);
        } else {
            string = this.mCustomPositiveButtonText;
        }
        DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i11) {
                PolicyPermissionDialogBuilder.this.onPermissionClick(dialogInterface, policyPermissionDialogView.getCheckBox().isChecked(), true, policyPermissionDialogView.getItemCheckedMap());
            }
        };
        aVar2.f12086f = string;
        aVar2.f12087g = onClickListener;
        int i11 = this.mPermissionBuilderType;
        if (i11 != 1) {
            String string3 = this.mCustomNegativeButtonText;
            if (string3 == null) {
                string3 = (this.mHaveSecondaryConfirmation || i11 == 3) ? this.mContext.getString(R.string.stepos_permission_deny) : this.mContext.getString(R.string.stepos_action_bar_multi_choice_cancel);
            }
            DialogInterface.OnClickListener onClickListener2 = new DialogInterface.OnClickListener() { // from class: com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i12) {
                    PolicyPermissionDialogBuilder.this.onPermissionClick(dialogInterface, policyPermissionDialogView.getCheckBox().isChecked(), false, policyPermissionDialogView.getItemCheckedMap());
                }
            };
            aVar2.h = string3;
            aVar2.f12088i = onClickListener2;
            aVar2.f12095p = -1;
            aVar2.f12096q = 0;
        }
        if (!z3) {
            if (this.mPermissionBuilderType == 0) {
                string2 = this.mAppName;
            }
            aVar2.f12084d = string2;
        }
        final PermissionDialog permissionDialog = (PermissionDialog) aVar.a(new e.a.InterfaceC0143a<PermissionDialog>() { // from class: com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder.4
            @Override // stepos.support.v7.app.e.a.InterfaceC0143a
            public PermissionDialog newDialog(Context context, int i12) {
                return new PermissionDialog(context, i12, PolicyPermissionDialogBuilder.this.mCallBack);
            }
        });
        policyPermissionDialogView.getCheckBox().setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder.5
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z11) {
                if (PolicyPermissionDialogBuilder.this.mCheckEnableConfirm) {
                    return;
                }
                permissionDialog.getButton(-1).setEnabled(!z11);
            }
        });
        final TextView termsView = policyPermissionDialogView.getTermsView();
        if (this.mTerms == null) {
            TermsStringBuilder termsStringBuilder = new TermsStringBuilder(this.mContext);
            termsStringBuilder.f12304d = z;
            termsStringBuilder.f12302b = this.mPrivacyPolicyListener != null;
            termsStringBuilder.f12303c = this.mUserAgreementListener != null;
            termsStringBuilder.f12306f = this.mPermissionInternetType;
            termsStringBuilder.f12307g = this.mPermissionBuilderType;
            termsStringBuilder.h = this.mCustomPrivacyPolicyName;
            termsStringBuilder.f12308i = this.mCustomUserAgreementName;
            termsStringBuilder.f12305e = new TermsStringBuilder.a() { // from class: com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder.6
                @Override // stepos.support.v7.permission.TermsStringBuilder.a
                public void onPrivacyPolicyClick(Context context) {
                    if (PolicyPermissionDialogBuilder.this.mPrivacyPolicyListener != null) {
                        PolicyPermissionDialogBuilder.this.mPrivacyPolicyListener.onClick(termsView);
                    }
                }

                @Override // stepos.support.v7.permission.TermsStringBuilder.a
                public void onUserAgreementClick(Context context) {
                    if (PolicyPermissionDialogBuilder.this.mUserAgreementListener != null) {
                        PolicyPermissionDialogBuilder.this.mUserAgreementListener.onClick(termsView);
                    }
                }
            };
            this.mTerms = termsStringBuilder.b();
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
        PolicyDialogScrollHelper.attach(permissionDialog);
        return permissionDialog;
    }

    public e createThreeButton(final OnThreeButtonClickListener onThreeButtonClickListener) {
        List<Pair<String, String>> list;
        String string = this.mContext.getString(R.string.stepos_permission_use_info);
        if (this.mPermissionBuilderType == 0 && TextUtils.isEmpty(this.mAppName)) {
            throw new IllegalArgumentException("appName can't be null");
        }
        String[] strArr = this.mPermissions;
        boolean z = (strArr != null && (strArr.length > 0 || (strArr.length == 0 && this.mPermissionInternetType == 1))) || ((list = this.mAdditionalGroups) != null && list.size() > 0);
        boolean z3 = sOldPermissionDialog;
        if (z3) {
            z = z || !TextUtils.isEmpty(this.mMessage);
        }
        boolean z10 = (this.mTerms == null && this.mPrivacyPolicyListener == null && this.mUserAgreementListener == null) ? false : true;
        if (!z && !z10) {
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
        final PolicyPermissionDialogView policyPermissionDialogView = new PolicyPermissionDialogView(this.mContext);
        new PolicyPermissionDialogView.Builder().setAppName(this.mPermissionBuilderType == 0 ? this.mAppName : string).setShowAlmostDenyBtn(this.mShowAlmostDenyBtn).setPermission(this.mPermissions, this.mPermissionReason).setAdditionalGroups(this.mAdditionalGroups).setMessage(this.mMessage).setReminder(this.mReminder).setCsReminder(this.mCsReminder).setDark(this.mIsDark).isIntl(this.mIsIntl).setShowTitle(z3).build(policyPermissionDialogView);
        View viewInflate = LayoutInflater.from(this.mContext).inflate(R.layout.policysdk_permission_three_button_dialog, (ViewGroup) null);
        ((ViewGroup) viewInflate.findViewById(R.id.policysdk_three_button_content)).addView(policyPermissionDialogView, new FrameLayout.LayoutParams(-1, getThreeButtonDialogMaxContentHeight(viewInflate.findViewById(R.id.policysdk_three_button_footer))));
        if (policyPermissionDialogView.getChildCount() > 0) {
            policyPermissionDialogView.getChildAt(0).setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        }
        final TextView textView = (TextView) viewInflate.findViewById(R.id.policysdk_btn_full_agree);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.policysdk_btn_basic_only);
        TextView textView3 = (TextView) viewInflate.findViewById(R.id.policysdk_btn_reject);
        textView.setText(this.mContext.getString(R.string.policy_sdk_btn_full_agree));
        textView2.setText(this.mContext.getString(R.string.policy_sdk_btn_basic_only));
        textView3.setText(this.mContext.getString(R.string.policy_sdk_btn_reject));
        e.a aVar = new e.a(this.mContext, this.mTheme);
        c.a aVar2 = aVar.f12101a;
        aVar2.f12094o = viewInflate;
        aVar2.f12089j = this.mCancelable;
        aVar2.f12090k = new DialogInterface.OnCancelListener() { // from class: com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder.8
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                OnThreeButtonClickListener onThreeButtonClickListener2 = onThreeButtonClickListener;
                if (onThreeButtonClickListener2 != null) {
                    onThreeButtonClickListener2.onRejectClick(dialogInterface, policyPermissionDialogView.getCheckBox().isChecked());
                }
            }
        };
        if (!z3) {
            if (this.mPermissionBuilderType == 0) {
                string = this.mAppName;
            }
            aVar2.f12084d = string;
        }
        final PermissionDialog permissionDialog = (PermissionDialog) aVar.a(new e.a.InterfaceC0143a<PermissionDialog>() { // from class: com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder.9
            /* JADX WARN: Multi-variable type inference failed */
            @Override // stepos.support.v7.app.e.a.InterfaceC0143a
            public PermissionDialog newDialog(Context context, int i10) {
                return new PermissionDialog(context, i10, null);
            }
        });
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (textView.isEnabled()) {
                    permissionDialog.dismiss();
                    OnThreeButtonClickListener onThreeButtonClickListener2 = onThreeButtonClickListener;
                    if (onThreeButtonClickListener2 != null) {
                        onThreeButtonClickListener2.onFullAgreeClick(permissionDialog, policyPermissionDialogView.getCheckBox().isChecked(), policyPermissionDialogView.getItemCheckedMap());
                    }
                }
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                permissionDialog.dismiss();
                OnThreeButtonClickListener onThreeButtonClickListener2 = onThreeButtonClickListener;
                if (onThreeButtonClickListener2 != null) {
                    onThreeButtonClickListener2.onBasicOnlyClick(permissionDialog, policyPermissionDialogView.getCheckBox().isChecked());
                }
            }
        });
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                permissionDialog.dismiss();
                OnThreeButtonClickListener onThreeButtonClickListener2 = onThreeButtonClickListener;
                if (onThreeButtonClickListener2 != null) {
                    onThreeButtonClickListener2.onRejectClick(permissionDialog, policyPermissionDialogView.getCheckBox().isChecked());
                }
            }
        });
        policyPermissionDialogView.getCheckBox().setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder.13
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z11) {
                if (PolicyPermissionDialogBuilder.this.mCheckEnableConfirm) {
                    return;
                }
                textView.setEnabled(!z11);
            }
        });
        final TextView termsView = policyPermissionDialogView.getTermsView();
        if (this.mTerms == null) {
            TermsStringBuilder termsStringBuilder = new TermsStringBuilder(this.mContext);
            termsStringBuilder.f12304d = z;
            termsStringBuilder.f12302b = this.mPrivacyPolicyListener != null;
            termsStringBuilder.f12303c = this.mUserAgreementListener != null;
            termsStringBuilder.f12306f = this.mPermissionInternetType;
            termsStringBuilder.f12307g = this.mPermissionBuilderType;
            termsStringBuilder.h = this.mCustomPrivacyPolicyName;
            termsStringBuilder.f12308i = this.mCustomUserAgreementName;
            termsStringBuilder.f12305e = new TermsStringBuilder.a() { // from class: com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder.14
                @Override // stepos.support.v7.permission.TermsStringBuilder.a
                public void onPrivacyPolicyClick(Context context) {
                    if (PolicyPermissionDialogBuilder.this.mPrivacyPolicyListener != null) {
                        PolicyPermissionDialogBuilder.this.mPrivacyPolicyListener.onClick(termsView);
                    }
                }

                @Override // stepos.support.v7.permission.TermsStringBuilder.a
                public void onUserAgreementClick(Context context) {
                    if (PolicyPermissionDialogBuilder.this.mUserAgreementListener != null) {
                        PolicyPermissionDialogBuilder.this.mUserAgreementListener.onClick(termsView);
                    }
                }
            };
            this.mTerms = termsStringBuilder.b();
        }
        termsView.setText(this.mTerms);
        termsView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder.15
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                termsView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
        termsView.setMovementMethod(LinkMovementMethod.getInstance());
        termsView.setHighlightColor(0);
        return permissionDialog;
    }

    public PolicyPermissionDialogBuilder isIntl(boolean z) {
        this.mIsIntl = z;
        return this;
    }

    public boolean isTablet(Context context) {
        return context.getResources().getBoolean(R.bool.isTablet);
    }

    public PolicyPermissionDialogBuilder setAppName(String str) {
        this.mAppName = str;
        return this;
    }

    public PolicyPermissionDialogBuilder setBuilderDialogType(int i10) {
        this.mPermissionBuilderType = i10;
        return this;
    }

    public PolicyPermissionDialogBuilder setCancelable(boolean z) {
        this.mCancelable = z;
        return this;
    }

    public PolicyPermissionDialogBuilder setCheckEnableConfirmBtn(boolean z) {
        this.mCheckEnableConfirm = z;
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

    public PolicyPermissionDialogBuilder setDark(boolean z) {
        if (z) {
            this.mTheme = R.style.Theme_StepOS_AppCompat_Light_Dialog_Alert_Dark;
        }
        this.mIsDark = z;
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

    public PolicyPermissionDialogBuilder setPermission(String[] strArr, String[] strArr2) {
        ArrayList<Integer> arrayListBuildInternetPermission = buildInternetPermission(strArr);
        if (arrayListBuildInternetPermission.size() > 0) {
            this.mPermissions = rebuildPermissions(strArr, arrayListBuildInternetPermission);
            this.mPermissionReason = rebuildPermissions(strArr2, arrayListBuildInternetPermission);
            return this;
        }
        this.mPermissions = strArr;
        this.mPermissionReason = strArr2;
        return this;
    }

    public PolicyPermissionDialogBuilder setPermissionInternetType(int i10) {
        this.mPermissionInternetType = i10;
        return this;
    }

    public PolicyPermissionDialogBuilder setPrivacyPolicyName(String str) {
        this.mCustomPrivacyPolicyName = str;
        return this;
    }

    public PolicyPermissionDialogBuilder setReminder(String str) {
        this.mReminder = str;
        return this;
    }

    public PolicyPermissionDialogBuilder setSecondaryConfirmation(boolean z) {
        this.mHaveSecondaryConfirmation = z;
        return this;
    }

    public PolicyPermissionDialogBuilder setShowAlmostDenyBtn(boolean z) {
        this.mShowAlmostDenyBtn = z;
        return this;
    }

    public PolicyPermissionDialogBuilder setUserAgreementName(String str) {
        this.mCustomUserAgreementName = str;
        return this;
    }

    public e show() {
        e eVarCreate = create();
        eVarCreate.show();
        return eVarCreate;
    }

    public PolicyPermissionDialogBuilder showPrivacyPolicy(View.OnClickListener onClickListener) {
        this.mPrivacyPolicyListener = onClickListener;
        return this;
    }

    public PolicyPermissionDialogBuilder showUserAgreement(View.OnClickListener onClickListener) {
        this.mUserAgreementListener = onClickListener;
        return this;
    }

    public PolicyPermissionDialogBuilder(Context context, int i10) {
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
        this.mTheme = i10;
    }

    public PolicyPermissionDialogBuilder setReminder(CharSequence charSequence) {
        this.mCsReminder = charSequence;
        return this;
    }
}
