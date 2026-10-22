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
import com.stepos.agentsafetycenter.R;
import com.stepos.policy.sdk.dialog.PolicyPermissionDialogView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;
import stepos.support.v7.app.d;
import stepos.support.v7.app.h;
import stepos.support.v7.app.i;
import u9.f;
import u9.g;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
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

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public interface OnPermissionClickListener {
        default void onPermissionClick(DialogInterface dialogInterface, boolean z10, boolean z11) {
        }

        default void onPermissionClick(DialogInterface dialogInterface, boolean z10, boolean z11, Map<String, Boolean> map) {
        }

        default void onPermissionClick(DialogInterface dialogInterface, boolean z10, boolean z11, boolean z12) {
        }

        default void onPermissionClick(DialogInterface dialogInterface, boolean z10, String str) {
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public interface OnThreeButtonClickListener {
        void onBasicOnlyClick(DialogInterface dialogInterface, boolean z10);

        void onFullAgreeClick(DialogInterface dialogInterface, boolean z10, Map<String, Boolean> map);

        void onRejectClick(DialogInterface dialogInterface, boolean z10);
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class PermissionDialog extends i {
        private OnPermissionClickListener mCallBack;

        private PermissionDialog(Context context, int i, OnPermissionClickListener onPermissionClickListener) {
            super(context, i);
            this.mCallBack = onPermissionClickListener;
        }

        private boolean isPerformanceTest() {
            try {
                f fVarA = g.b("android.os.SystemProperties").a("getBoolean", String.class, Boolean.TYPE);
                return ((Boolean) fVarA.f14264a.invoke(null, "debug.perf.applunch", Boolean.FALSE)).booleanValue();
            } catch (Exception unused) {
                return false;
            }
        }

        private boolean isProductInternational() {
            try {
                return ((Boolean) g.b("android.os.BuildExt").a("isProductInternational", new Class[0]).f14264a.invoke(null, null)).booleanValue();
            } catch (Exception unused) {
                return false;
            }
        }

        private boolean isShopDemo() {
            try {
                return ((Boolean) g.b("android.os.BuildExt").a("isShopDemoVersion", new Class[0]).f14264a.invoke(null, null)).booleanValue();
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

    public PolicyPermissionDialogBuilder(Context context, int i) {
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
        this.mTheme = i;
    }

    private ArrayList<Integer> buildInternetPermission(String[] strArr) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            if (i >= strArr.length) {
                break;
            }
            if (PREMISSION_INTERNET_GROUP.equals(strArr[i])) {
                arrayList.clear();
                for (int i3 = 0; i3 < strArr.length; i3++) {
                    if (PREMISSION_INTERNET_GROUP.equals(strArr[i3]) || PREMISSION_INTERNET.equals(strArr[i3]) || PREMISSION_INTERNET_CHANGE.equals(strArr[i3]) || PREMISSION_INTERNET_ACCESS.equals(strArr[i3])) {
                        arrayList.add(Integer.valueOf(i3));
                    }
                }
            } else {
                if (PREMISSION_INTERNET.equals(strArr[i])) {
                    arrayList.add(Integer.valueOf(i));
                }
                i++;
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
        float f5 = displayMetrics.density;
        view.measure(View.MeasureSpec.makeMeasureSpec(displayMetrics.widthPixels, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        return Math.max(((((int) (displayMetrics.heightPixels * 0.88f)) - view.getMeasuredHeight()) - ((int) (56.0f * f5))) - ((int) (48.0f * f5)), (int) (f5 * 180.0f));
    }

    private static boolean isZh(String str) {
        return Pattern.compile("[\\u4E00-\\u9FA5]+").matcher(str).find();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPermissionClick(DialogInterface dialogInterface, boolean z10, boolean z11, Map<String, Boolean> map) {
        OnPermissionClickListener onPermissionClickListener = this.mCallBack;
        if (onPermissionClickListener == null) {
            return;
        }
        if (this.mIsIntl) {
            onPermissionClickListener.onPermissionClick(dialogInterface, z10, z11, map);
        } else {
            onPermissionClickListener.onPermissionClick(dialogInterface, z10, z11);
        }
    }

    private String[] rebuildPermissions(String[] strArr, ArrayList<Integer> arrayList) {
        ArrayList arrayList2 = new ArrayList(Arrays.asList(strArr));
        ArrayList arrayList3 = new ArrayList();
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList3.add((String) arrayList2.get(arrayList.get(i).intValue()));
        }
        for (int i3 = 0; i3 < arrayList3.size(); i3++) {
            arrayList2.remove(arrayList3.get(i3));
        }
        return (String[]) arrayList2.toArray(new String[0]);
    }

    public static int resolveDialogTheme(Context context, int i) {
        if (((i >>> 24) & 255) >= 1) {
            return i;
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

    public i create() {
        List<Pair<String, String>> list;
        Resources resources;
        int i;
        String string;
        String string2 = this.mContext.getString(R.string.stepos_permission_use_info);
        if (this.mPermissionBuilderType == 0 && TextUtils.isEmpty(this.mAppName)) {
            g5.f.s("appName can't be null");
            return null;
        }
        String[] strArr = this.mPermissions;
        boolean z10 = (strArr != null && (strArr.length > 0 || (strArr.length == 0 && this.mPermissionInternetType == 1))) || ((list = this.mAdditionalGroups) != null && list.size() > 0);
        boolean z11 = sOldPermissionDialog;
        if (z11) {
            z10 = z10 || !TextUtils.isEmpty(this.mMessage);
        }
        boolean z12 = (this.mTerms == null && this.mPrivacyPolicyListener == null && this.mUserAgreementListener == null) ? false : true;
        if (!z10 && !z12) {
            g5.f.s("[permissions], [additional groups] and [terms] both null");
            return null;
        }
        String[] strArr2 = this.mPermissions;
        if (strArr2 != null) {
            String[] strArr3 = this.mPermissionReason;
            if (strArr3 == null) {
                g5.f.s("permissionReason can't be null");
                return null;
            }
            if (strArr3.length != strArr2.length) {
                g5.f.s("permissionReason.length must equal permissions.length");
                return null;
            }
        }
        final PolicyPermissionDialogView policyPermissionDialogView = new PolicyPermissionDialogView(this.mContext);
        new PolicyPermissionDialogView.Builder().setAppName(this.mPermissionBuilderType == 0 ? this.mAppName : string2).setShowAlmostDenyBtn(this.mShowAlmostDenyBtn).setPermission(this.mPermissions, this.mPermissionReason).setAdditionalGroups(this.mAdditionalGroups).setMessage(this.mMessage).setReminder(this.mReminder).setCsReminder(this.mCsReminder).setDark(this.mIsDark).isIntl(this.mIsIntl).setShowTitle(z11).build(policyPermissionDialogView);
        h hVar = new h(this.mContext, this.mTheme);
        d dVar = hVar.f12317a;
        dVar.f12306o = policyPermissionDialogView;
        dVar.f12301j = this.mCancelable;
        dVar.f12302k = new DialogInterface.OnCancelListener() { // from class: com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                PolicyPermissionDialogBuilder.this.onPermissionClick(dialogInterface, policyPermissionDialogView.getCheckBox().isChecked(), false, policyPermissionDialogView.getItemCheckedMap());
            }
        };
        if (TextUtils.isEmpty(this.mCustomPositiveButtonText)) {
            int i3 = this.mPermissionBuilderType;
            Context context = this.mContext;
            if (i3 == 1) {
                resources = context.getResources();
                i = R.string.stepos_permission_i_know;
            } else {
                resources = context.getResources();
                i = R.string.stepos_permission_agree;
            }
            string = resources.getString(i);
        } else {
            string = this.mCustomPositiveButtonText;
        }
        DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i10) {
                PolicyPermissionDialogBuilder.this.onPermissionClick(dialogInterface, policyPermissionDialogView.getCheckBox().isChecked(), true, policyPermissionDialogView.getItemCheckedMap());
            }
        };
        dVar.f12298f = string;
        dVar.f12299g = onClickListener;
        int i10 = this.mPermissionBuilderType;
        if (i10 != 1) {
            String string3 = this.mCustomNegativeButtonText;
            if (string3 == null) {
                string3 = (this.mHaveSecondaryConfirmation || i10 == 3) ? this.mContext.getString(R.string.stepos_permission_deny) : this.mContext.getString(R.string.stepos_action_bar_multi_choice_cancel);
            }
            DialogInterface.OnClickListener onClickListener2 = new DialogInterface.OnClickListener() { // from class: com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i11) {
                    PolicyPermissionDialogBuilder.this.onPermissionClick(dialogInterface, policyPermissionDialogView.getCheckBox().isChecked(), false, policyPermissionDialogView.getItemCheckedMap());
                }
            };
            dVar.f12300h = string3;
            dVar.i = onClickListener2;
            dVar.f12307p = -1;
            dVar.f12308q = 0;
        }
        if (!z11) {
            if (this.mPermissionBuilderType == 0) {
                string2 = this.mAppName;
            }
            dVar.f12296d = string2;
        }
        final PermissionDialog permissionDialog = (PermissionDialog) hVar.a(new stepos.support.v7.app.g() { // from class: com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder.4
            @Override // stepos.support.v7.app.g
            public PermissionDialog newDialog(Context context2, int i11) {
                return new PermissionDialog(context2, i11, PolicyPermissionDialogBuilder.this.mCallBack);
            }
        });
        policyPermissionDialogView.getCheckBox().setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder.5
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z13) {
                if (PolicyPermissionDialogBuilder.this.mCheckEnableConfirm) {
                    return;
                }
                permissionDialog.getButton(-1).setEnabled(!z13);
            }
        });
        final TextView termsView = policyPermissionDialogView.getTermsView();
        if (this.mTerms == null) {
            qe.g gVar = new qe.g(this.mContext);
            gVar.f10236d = z10;
            gVar.f10234b = this.mPrivacyPolicyListener != null;
            gVar.f10235c = this.mUserAgreementListener != null;
            gVar.f10238f = this.mPermissionInternetType;
            gVar.f10239g = this.mPermissionBuilderType;
            gVar.f10240h = this.mCustomPrivacyPolicyName;
            gVar.i = this.mCustomUserAgreementName;
            gVar.f10237e = new qe.f() { // from class: com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder.6
                @Override // qe.f
                public void onPrivacyPolicyClick(Context context2) {
                    if (PolicyPermissionDialogBuilder.this.mPrivacyPolicyListener != null) {
                        PolicyPermissionDialogBuilder.this.mPrivacyPolicyListener.onClick(termsView);
                    }
                }

                @Override // qe.f
                public void onUserAgreementClick(Context context2) {
                    if (PolicyPermissionDialogBuilder.this.mUserAgreementListener != null) {
                        PolicyPermissionDialogBuilder.this.mUserAgreementListener.onClick(termsView);
                    }
                }
            };
            this.mTerms = gVar.b();
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

    public i createThreeButton(final OnThreeButtonClickListener onThreeButtonClickListener) {
        List<Pair<String, String>> list;
        String string = this.mContext.getString(R.string.stepos_permission_use_info);
        if (this.mPermissionBuilderType == 0 && TextUtils.isEmpty(this.mAppName)) {
            g5.f.s("appName can't be null");
            return null;
        }
        String[] strArr = this.mPermissions;
        boolean z10 = (strArr != null && (strArr.length > 0 || (strArr.length == 0 && this.mPermissionInternetType == 1))) || ((list = this.mAdditionalGroups) != null && list.size() > 0);
        boolean z11 = sOldPermissionDialog;
        if (z11) {
            z10 = z10 || !TextUtils.isEmpty(this.mMessage);
        }
        boolean z12 = (this.mTerms == null && this.mPrivacyPolicyListener == null && this.mUserAgreementListener == null) ? false : true;
        if (!z10 && !z12) {
            g5.f.s("[permissions], [additional groups] and [terms] both null");
            return null;
        }
        String[] strArr2 = this.mPermissions;
        if (strArr2 != null) {
            String[] strArr3 = this.mPermissionReason;
            if (strArr3 == null) {
                g5.f.s("permissionReason can't be null");
                return null;
            }
            if (strArr3.length != strArr2.length) {
                g5.f.s("permissionReason.length must equal permissions.length");
                return null;
            }
        }
        final PolicyPermissionDialogView policyPermissionDialogView = new PolicyPermissionDialogView(this.mContext);
        new PolicyPermissionDialogView.Builder().setAppName(this.mPermissionBuilderType == 0 ? this.mAppName : string).setShowAlmostDenyBtn(this.mShowAlmostDenyBtn).setPermission(this.mPermissions, this.mPermissionReason).setAdditionalGroups(this.mAdditionalGroups).setMessage(this.mMessage).setReminder(this.mReminder).setCsReminder(this.mCsReminder).setDark(this.mIsDark).isIntl(this.mIsIntl).setShowTitle(z11).build(policyPermissionDialogView);
        View viewInflate = LayoutInflater.from(this.mContext).inflate(com.stepos.policy.sdk.R.layout.policysdk_permission_three_button_dialog, (ViewGroup) null);
        ((ViewGroup) viewInflate.findViewById(com.stepos.policy.sdk.R.id.policysdk_three_button_content)).addView(policyPermissionDialogView, new FrameLayout.LayoutParams(-1, getThreeButtonDialogMaxContentHeight(viewInflate.findViewById(com.stepos.policy.sdk.R.id.policysdk_three_button_footer))));
        if (policyPermissionDialogView.getChildCount() > 0) {
            policyPermissionDialogView.getChildAt(0).setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        }
        final TextView textView = (TextView) viewInflate.findViewById(com.stepos.policy.sdk.R.id.policysdk_btn_full_agree);
        TextView textView2 = (TextView) viewInflate.findViewById(com.stepos.policy.sdk.R.id.policysdk_btn_basic_only);
        TextView textView3 = (TextView) viewInflate.findViewById(com.stepos.policy.sdk.R.id.policysdk_btn_reject);
        textView.setText(this.mContext.getString(com.stepos.policy.sdk.R.string.policy_sdk_btn_full_agree));
        textView2.setText(this.mContext.getString(com.stepos.policy.sdk.R.string.policy_sdk_btn_basic_only));
        textView3.setText(this.mContext.getString(com.stepos.policy.sdk.R.string.policy_sdk_btn_reject));
        h hVar = new h(this.mContext, this.mTheme);
        d dVar = hVar.f12317a;
        dVar.f12306o = viewInflate;
        dVar.f12301j = this.mCancelable;
        dVar.f12302k = new DialogInterface.OnCancelListener() { // from class: com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder.8
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                OnThreeButtonClickListener onThreeButtonClickListener2 = onThreeButtonClickListener;
                if (onThreeButtonClickListener2 != null) {
                    onThreeButtonClickListener2.onRejectClick(dialogInterface, policyPermissionDialogView.getCheckBox().isChecked());
                }
            }
        };
        if (!z11) {
            if (this.mPermissionBuilderType == 0) {
                string = this.mAppName;
            }
            dVar.f12296d = string;
        }
        final PermissionDialog permissionDialog = (PermissionDialog) hVar.a(new stepos.support.v7.app.g() { // from class: com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder.9
            /* JADX WARN: Multi-variable type inference failed */
            @Override // stepos.support.v7.app.g
            public PermissionDialog newDialog(Context context, int i) {
                return new PermissionDialog(context, i, null);
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
            public void onCheckedChanged(CompoundButton compoundButton, boolean z13) {
                if (PolicyPermissionDialogBuilder.this.mCheckEnableConfirm) {
                    return;
                }
                textView.setEnabled(!z13);
            }
        });
        final TextView termsView = policyPermissionDialogView.getTermsView();
        if (this.mTerms == null) {
            qe.g gVar = new qe.g(this.mContext);
            gVar.f10236d = z10;
            gVar.f10234b = this.mPrivacyPolicyListener != null;
            gVar.f10235c = this.mUserAgreementListener != null;
            gVar.f10238f = this.mPermissionInternetType;
            gVar.f10239g = this.mPermissionBuilderType;
            gVar.f10240h = this.mCustomPrivacyPolicyName;
            gVar.i = this.mCustomUserAgreementName;
            gVar.f10237e = new qe.f() { // from class: com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder.14
                @Override // qe.f
                public void onPrivacyPolicyClick(Context context) {
                    if (PolicyPermissionDialogBuilder.this.mPrivacyPolicyListener != null) {
                        PolicyPermissionDialogBuilder.this.mPrivacyPolicyListener.onClick(termsView);
                    }
                }

                @Override // qe.f
                public void onUserAgreementClick(Context context) {
                    if (PolicyPermissionDialogBuilder.this.mUserAgreementListener != null) {
                        PolicyPermissionDialogBuilder.this.mUserAgreementListener.onClick(termsView);
                    }
                }
            };
            this.mTerms = gVar.b();
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

    public PolicyPermissionDialogBuilder isIntl(boolean z10) {
        this.mIsIntl = z10;
        return this;
    }

    public boolean isTablet(Context context) {
        return context.getResources().getBoolean(R.bool.isTablet);
    }

    public PolicyPermissionDialogBuilder setAppName(String str) {
        this.mAppName = str;
        return this;
    }

    public PolicyPermissionDialogBuilder setBuilderDialogType(int i) {
        this.mPermissionBuilderType = i;
        return this;
    }

    public PolicyPermissionDialogBuilder setCancelable(boolean z10) {
        this.mCancelable = z10;
        return this;
    }

    public PolicyPermissionDialogBuilder setCheckEnableConfirmBtn(boolean z10) {
        this.mCheckEnableConfirm = z10;
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

    public PolicyPermissionDialogBuilder setDark(boolean z10) {
        if (z10) {
            this.mTheme = R.style.Theme_StepOS_AppCompat_Light_Dialog_Alert_Dark;
        }
        this.mIsDark = z10;
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

    public PolicyPermissionDialogBuilder setPermissionInternetType(int i) {
        this.mPermissionInternetType = i;
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

    public PolicyPermissionDialogBuilder setSecondaryConfirmation(boolean z10) {
        this.mHaveSecondaryConfirmation = z10;
        return this;
    }

    public PolicyPermissionDialogBuilder setShowAlmostDenyBtn(boolean z10) {
        this.mShowAlmostDenyBtn = z10;
        return this;
    }

    public PolicyPermissionDialogBuilder setUserAgreementName(String str) {
        this.mCustomUserAgreementName = str;
        return this;
    }

    public i show() {
        i iVarCreate = create();
        iVarCreate.show();
        return iVarCreate;
    }

    public PolicyPermissionDialogBuilder showPrivacyPolicy(View.OnClickListener onClickListener) {
        this.mPrivacyPolicyListener = onClickListener;
        return this;
    }

    public PolicyPermissionDialogBuilder showUserAgreement(View.OnClickListener onClickListener) {
        this.mUserAgreementListener = onClickListener;
        return this;
    }

    public PolicyPermissionDialogBuilder setReminder(CharSequence charSequence) {
        this.mCsReminder = charSequence;
        return this;
    }

    public PolicyPermissionDialogBuilder(Context context) {
        this(context, resolveDialogTheme(context, 0));
    }
}
