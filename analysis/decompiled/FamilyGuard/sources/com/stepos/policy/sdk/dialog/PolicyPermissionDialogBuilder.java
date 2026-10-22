package com.stepos.policy.sdk.dialog;

import N1.h;
import X4.j;
import X4.k;
import Z4.f;
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
import com.stepos.policy.sdk.dialog.PolicyPermissionDialogView;
import com.stepos.policy.sdk.q;
import com.stepos.policy.sdk.r;
import com.stepos.policy.sdk.s;
import com.stepos.policy.sdk.util.PolicyDialogScrollHelper;
import g.C0728a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;
import stepos.support.v7.app.c;

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
        default void onPermissionClick(DialogInterface dialogInterface, boolean z5, String str) {
        }

        default void onPermissionClick(DialogInterface dialogInterface, boolean z5, boolean z6) {
        }

        default void onPermissionClick(DialogInterface dialogInterface, boolean z5, boolean z6, Map<String, Boolean> map) {
        }

        default void onPermissionClick(DialogInterface dialogInterface, boolean z5, boolean z6, boolean z7) {
        }
    }

    public interface OnThreeButtonClickListener {
        void onBasicOnlyClick(DialogInterface dialogInterface, boolean z5);

        void onFullAgreeClick(DialogInterface dialogInterface, boolean z5, Map<String, Boolean> map);

        void onRejectClick(DialogInterface dialogInterface, boolean z5);
    }

    private static class PermissionDialog extends c {
        private OnPermissionClickListener mCallBack;

        private boolean isPerformanceTest() {
            try {
                return ((Boolean) h.c("android.os.SystemProperties").a("getBoolean", String.class, Boolean.TYPE).a(null, "debug.perf.applunch", Boolean.FALSE)).booleanValue();
            } catch (Exception unused) {
                return false;
            }
        }

        private boolean isProductInternational() {
            try {
                return ((Boolean) h.c("android.os.BuildExt").a("isProductInternational", new Class[0]).a(null, new Object[0])).booleanValue();
            } catch (Exception unused) {
                return false;
            }
        }

        private boolean isShopDemo() {
            try {
                return ((Boolean) h.c("android.os.BuildExt").a("isShopDemoVersion", new Class[0]).a(null, new Object[0])).booleanValue();
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

        private PermissionDialog(Context context, int i5, OnPermissionClickListener onPermissionClickListener) {
            super(context, i5);
            this.mCallBack = onPermissionClickListener;
        }
    }

    public PolicyPermissionDialogBuilder(Context context) {
        this(context, resolveDialogTheme(context, 0));
    }

    private ArrayList<Integer> buildInternetPermission(String[] strArr) {
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
    public void onPermissionClick(DialogInterface dialogInterface, boolean z5, boolean z6, Map<String, Boolean> map) {
        OnPermissionClickListener onPermissionClickListener = this.mCallBack;
        if (onPermissionClickListener == null) {
            return;
        }
        if (this.mIsIntl) {
            onPermissionClickListener.onPermissionClick(dialogInterface, z5, z6, map);
        } else {
            onPermissionClickListener.onPermissionClick(dialogInterface, z5, z6);
        }
    }

    private String[] rebuildPermissions(String[] strArr, ArrayList<Integer> arrayList) {
        ArrayList arrayList2 = new ArrayList(Arrays.asList(strArr));
        ArrayList arrayList3 = new ArrayList();
        for (int i5 = 0; i5 < arrayList.size(); i5++) {
            arrayList3.add((String) arrayList2.get(arrayList.get(i5).intValue()));
        }
        for (int i6 = 0; i6 < arrayList3.size(); i6++) {
            arrayList2.remove(arrayList3.get(i6));
        }
        return (String[]) arrayList2.toArray(new String[0]);
    }

    static int resolveDialogTheme(Context context, int i5) {
        if (((i5 >>> 24) & 255) >= 1) {
            return i5;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(C0728a.f16840q, typedValue, true);
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

    public c create() throws Resources.NotFoundException {
        List<Pair<String, String>> list;
        Resources resources;
        int i5;
        String string;
        String string2 = this.mContext.getString(j.f6065n);
        if (this.mPermissionBuilderType == 0 && TextUtils.isEmpty(this.mAppName)) {
            throw new IllegalArgumentException("appName can't be null");
        }
        String[] strArr = this.mPermissions;
        boolean z5 = (strArr != null && (strArr.length > 0 || (strArr.length == 0 && this.mPermissionInternetType == 1))) || ((list = this.mAdditionalGroups) != null && list.size() > 0);
        boolean z6 = sOldPermissionDialog;
        if (z6) {
            z5 = z5 || !TextUtils.isEmpty(this.mMessage);
        }
        boolean z7 = (this.mTerms == null && this.mPrivacyPolicyListener == null && this.mUserAgreementListener == null) ? false : true;
        if (!z5 && !z7) {
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
        new PolicyPermissionDialogView.Builder().setAppName(this.mPermissionBuilderType == 0 ? this.mAppName : string2).setShowAlmostDenyBtn(this.mShowAlmostDenyBtn).setPermission(this.mPermissions, this.mPermissionReason).setAdditionalGroups(this.mAdditionalGroups).setMessage(this.mMessage).setReminder(this.mReminder).setCsReminder(this.mCsReminder).setDark(this.mIsDark).isIntl(this.mIsIntl).setShowTitle(z6).build(policyPermissionDialogView);
        c.a aVarS = new c.a(this.mContext, this.mTheme).z(policyPermissionDialogView).g(this.mCancelable).s(new DialogInterface.OnCancelListener() { // from class: com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                PolicyPermissionDialogBuilder.this.onPermissionClick(dialogInterface, policyPermissionDialogView.getCheckBox().isChecked(), false, policyPermissionDialogView.getItemCheckedMap());
            }
        });
        if (TextUtils.isEmpty(this.mCustomPositiveButtonText)) {
            if (this.mPermissionBuilderType == 1) {
                resources = this.mContext.getResources();
                i5 = j.f6057f;
            } else {
                resources = this.mContext.getResources();
                i5 = j.f6055d;
            }
            string = resources.getString(i5);
        } else {
            string = this.mCustomPositiveButtonText;
        }
        aVarS.v(string, new DialogInterface.OnClickListener() { // from class: com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i6) {
                PolicyPermissionDialogBuilder.this.onPermissionClick(dialogInterface, policyPermissionDialogView.getCheckBox().isChecked(), true, policyPermissionDialogView.getItemCheckedMap());
            }
        });
        int i6 = this.mPermissionBuilderType;
        if (i6 != 1) {
            String string3 = this.mCustomNegativeButtonText;
            if (string3 == null) {
                string3 = (this.mHaveSecondaryConfirmation || i6 == 3) ? this.mContext.getString(j.f6056e) : this.mContext.getString(j.f6052a);
            }
            aVarS.p(string3, new DialogInterface.OnClickListener() { // from class: com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i7) {
                    PolicyPermissionDialogBuilder.this.onPermissionClick(dialogInterface, policyPermissionDialogView.getCheckBox().isChecked(), false, policyPermissionDialogView.getItemCheckedMap());
                }
            });
            aVarS.i(-1, 0);
        }
        if (!z6) {
            if (this.mPermissionBuilderType == 0) {
                string2 = this.mAppName;
            }
            aVarS.y(string2);
        }
        final PermissionDialog permissionDialog = (PermissionDialog) aVarS.d(new c.a.b<PermissionDialog>() { // from class: com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder.4
            @Override // stepos.support.v7.app.c.a.b
            public PermissionDialog newDialog(Context context, int i7) {
                return new PermissionDialog(context, i7, PolicyPermissionDialogBuilder.this.mCallBack);
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
            this.mTerms = new f(this.mContext).i(z5).l(this.mPrivacyPolicyListener != null).n(this.mUserAgreementListener != null).j(this.mPermissionInternetType).h(this.mPermissionBuilderType).m(this.mCustomPrivacyPolicyName).o(this.mCustomUserAgreementName).k(new f.c() { // from class: com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder.6
                @Override // Z4.f.c
                public void onPrivacyPolicyClick(Context context) {
                    if (PolicyPermissionDialogBuilder.this.mPrivacyPolicyListener != null) {
                        PolicyPermissionDialogBuilder.this.mPrivacyPolicyListener.onClick(termsView);
                    }
                }

                @Override // Z4.f.c
                public void onUserAgreementClick(Context context) {
                    if (PolicyPermissionDialogBuilder.this.mUserAgreementListener != null) {
                        PolicyPermissionDialogBuilder.this.mUserAgreementListener.onClick(termsView);
                    }
                }
            }).e();
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

    public c createThreeButton(final OnThreeButtonClickListener onThreeButtonClickListener) {
        List<Pair<String, String>> list;
        String string = this.mContext.getString(j.f6065n);
        if (this.mPermissionBuilderType == 0 && TextUtils.isEmpty(this.mAppName)) {
            throw new IllegalArgumentException("appName can't be null");
        }
        String[] strArr = this.mPermissions;
        boolean z5 = (strArr != null && (strArr.length > 0 || (strArr.length == 0 && this.mPermissionInternetType == 1))) || ((list = this.mAdditionalGroups) != null && list.size() > 0);
        boolean z6 = sOldPermissionDialog;
        if (z6) {
            z5 = z5 || !TextUtils.isEmpty(this.mMessage);
        }
        boolean z7 = (this.mTerms == null && this.mPrivacyPolicyListener == null && this.mUserAgreementListener == null) ? false : true;
        if (!z5 && !z7) {
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
        new PolicyPermissionDialogView.Builder().setAppName(this.mPermissionBuilderType == 0 ? this.mAppName : string).setShowAlmostDenyBtn(this.mShowAlmostDenyBtn).setPermission(this.mPermissions, this.mPermissionReason).setAdditionalGroups(this.mAdditionalGroups).setMessage(this.mMessage).setReminder(this.mReminder).setCsReminder(this.mCsReminder).setDark(this.mIsDark).isIntl(this.mIsIntl).setShowTitle(z6).build(policyPermissionDialogView);
        View viewInflate = LayoutInflater.from(this.mContext).inflate(r.f15817e, (ViewGroup) null);
        ((ViewGroup) viewInflate.findViewById(q.f15808k)).addView(policyPermissionDialogView, new FrameLayout.LayoutParams(-1, getThreeButtonDialogMaxContentHeight(viewInflate.findViewById(q.f15809l))));
        if (policyPermissionDialogView.getChildCount() > 0) {
            policyPermissionDialogView.getChildAt(0).setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        }
        final TextView textView = (TextView) viewInflate.findViewById(q.f15806i);
        TextView textView2 = (TextView) viewInflate.findViewById(q.f15805h);
        TextView textView3 = (TextView) viewInflate.findViewById(q.f15807j);
        textView.setText(this.mContext.getString(s.f15827e));
        textView2.setText(this.mContext.getString(s.f15826d));
        textView3.setText(this.mContext.getString(s.f15828f));
        c.a aVarS = new c.a(this.mContext, this.mTheme).z(viewInflate).g(this.mCancelable).s(new DialogInterface.OnCancelListener() { // from class: com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder.8
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                OnThreeButtonClickListener onThreeButtonClickListener2 = onThreeButtonClickListener;
                if (onThreeButtonClickListener2 != null) {
                    onThreeButtonClickListener2.onRejectClick(dialogInterface, policyPermissionDialogView.getCheckBox().isChecked());
                }
            }
        });
        if (!z6) {
            if (this.mPermissionBuilderType == 0) {
                string = this.mAppName;
            }
            aVarS.y(string);
        }
        final PermissionDialog permissionDialog = (PermissionDialog) aVarS.d(new c.a.b<PermissionDialog>() { // from class: com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder.9
            /* JADX WARN: Multi-variable type inference failed */
            @Override // stepos.support.v7.app.c.a.b
            public PermissionDialog newDialog(Context context, int i5) {
                return new PermissionDialog(context, i5, null);
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
            public void onCheckedChanged(CompoundButton compoundButton, boolean z8) {
                if (PolicyPermissionDialogBuilder.this.mCheckEnableConfirm) {
                    return;
                }
                textView.setEnabled(!z8);
            }
        });
        final TextView termsView = policyPermissionDialogView.getTermsView();
        if (this.mTerms == null) {
            this.mTerms = new f(this.mContext).i(z5).l(this.mPrivacyPolicyListener != null).n(this.mUserAgreementListener != null).j(this.mPermissionInternetType).h(this.mPermissionBuilderType).m(this.mCustomPrivacyPolicyName).o(this.mCustomUserAgreementName).k(new f.c() { // from class: com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder.14
                @Override // Z4.f.c
                public void onPrivacyPolicyClick(Context context) {
                    if (PolicyPermissionDialogBuilder.this.mPrivacyPolicyListener != null) {
                        PolicyPermissionDialogBuilder.this.mPrivacyPolicyListener.onClick(termsView);
                    }
                }

                @Override // Z4.f.c
                public void onUserAgreementClick(Context context) {
                    if (PolicyPermissionDialogBuilder.this.mUserAgreementListener != null) {
                        PolicyPermissionDialogBuilder.this.mUserAgreementListener.onClick(termsView);
                    }
                }
            }).e();
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

    public PolicyPermissionDialogBuilder isIntl(boolean z5) {
        this.mIsIntl = z5;
        return this;
    }

    public boolean isTablet(Context context) {
        return context.getResources().getBoolean(X4.b.f5853c);
    }

    public PolicyPermissionDialogBuilder setAppName(String str) {
        this.mAppName = str;
        return this;
    }

    public PolicyPermissionDialogBuilder setBuilderDialogType(int i5) {
        this.mPermissionBuilderType = i5;
        return this;
    }

    public PolicyPermissionDialogBuilder setCancelable(boolean z5) {
        this.mCancelable = z5;
        return this;
    }

    public PolicyPermissionDialogBuilder setCheckEnableConfirmBtn(boolean z5) {
        this.mCheckEnableConfirm = z5;
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

    public PolicyPermissionDialogBuilder setDark(boolean z5) {
        if (z5) {
            this.mTheme = k.f6074b;
        }
        this.mIsDark = z5;
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

    public PolicyPermissionDialogBuilder setPermissionInternetType(int i5) {
        this.mPermissionInternetType = i5;
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

    public PolicyPermissionDialogBuilder setSecondaryConfirmation(boolean z5) {
        this.mHaveSecondaryConfirmation = z5;
        return this;
    }

    public PolicyPermissionDialogBuilder setShowAlmostDenyBtn(boolean z5) {
        this.mShowAlmostDenyBtn = z5;
        return this;
    }

    public PolicyPermissionDialogBuilder setUserAgreementName(String str) {
        this.mCustomUserAgreementName = str;
        return this;
    }

    public c show() throws Resources.NotFoundException {
        c cVarCreate = create();
        cVarCreate.show();
        return cVarCreate;
    }

    public PolicyPermissionDialogBuilder showPrivacyPolicy(View.OnClickListener onClickListener) {
        this.mPrivacyPolicyListener = onClickListener;
        return this;
    }

    public PolicyPermissionDialogBuilder showUserAgreement(View.OnClickListener onClickListener) {
        this.mUserAgreementListener = onClickListener;
        return this;
    }

    public PolicyPermissionDialogBuilder(Context context, int i5) {
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
        this.mTheme = i5;
    }

    public PolicyPermissionDialogBuilder setReminder(CharSequence charSequence) {
        this.mCsReminder = charSequence;
        return this;
    }
}
