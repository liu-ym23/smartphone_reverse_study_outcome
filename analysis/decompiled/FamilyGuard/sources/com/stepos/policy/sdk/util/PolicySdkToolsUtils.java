package com.stepos.policy.sdk.util;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.stepos.policy.sdk.bean.DeleteInfoBean;
import com.stepos.policy.sdk.p;
import com.stepos.policy.sdk.q;
import com.stepos.policy.sdk.util.PolicySdkToolsUtils;
import com.stepos.xjfms.ums.sign.jdk.dto.SignDTO;
import com.stepos.xjfms.ums.sign.jdk.service.SignServiceImpl;
import g.C0728a;
import j4.k;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.libpag.BuildConfig;
import r4.C1031n;

/* loaded from: classes.dex */
public final class PolicySdkToolsUtils {
    public static final Companion Companion = new Companion(null);
    private static final String PREMISSION_INTERNET = "android.permission.INTERNET";
    private static final String PREMISSION_INTERNET_ACCESS = "android.permission.ACCESS_NETWORK_STATE";
    private static final String PREMISSION_INTERNET_CHANGE = "android.permission.CHANGE_NETWORK_STATE";
    private static final String PREMISSION_INTERNET_GROUP = "stepos.permission-group.NETWORK";
    private static Boolean sIsPoleStar;

    public static final class Companion {
        public /* synthetic */ Companion(j4.g gVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void initWithdrawalCleanDataOneCheckBox$lambda$2(stepos.support.v7.app.c cVar, Context context, String str, DialogInterface dialogInterface) {
            k.g(cVar, "$alertDialog");
            k.g(context, "$context");
            k.g(str, "$checkButtonMessage");
            Button button = cVar.getButton(-1);
            k.f(button, "alertDialog.getButton(Di…nterface.BUTTON_POSITIVE)");
            button.setBackground(androidx.core.content.a.e(context, p.f15797b));
            button.setTextColor(androidx.core.content.a.c(context, PolicySdkToolsUtils.Companion.getIdentifierByAttrId(C0728a.f16804A, context)));
            View viewFindViewById = cVar.findViewById(q.f15812o);
            k.e(viewFindViewById, "null cannot be cast to non-null type android.widget.CheckBox");
            ((CheckBox) viewFindViewById).setVisibility(8);
            View viewFindViewById2 = cVar.findViewById(q.stepos_checkbox_layout_first);
            k.e(viewFindViewById2, "null cannot be cast to non-null type android.widget.LinearLayout");
            View viewFindViewById3 = cVar.findViewById(q.stepos_permission_dialog_checkbox_first);
            k.e(viewFindViewById3, "null cannot be cast to non-null type android.widget.CheckBox");
            final CheckBox checkBox = (CheckBox) viewFindViewById3;
            View viewFindViewById4 = cVar.findViewById(q.stepos_permission_dialog_tv_first);
            k.e(viewFindViewById4, "null cannot be cast to non-null type android.widget.TextView");
            TextView textView = (TextView) viewFindViewById4;
            ((LinearLayout) viewFindViewById2).setVisibility(0);
            checkBox.setChecked(false);
            textView.setText(str);
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.policy.sdk.util.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PolicySdkToolsUtils.Companion.initWithdrawalCleanDataOneCheckBox$lambda$2$lambda$1(checkBox, view);
                }
            });
            PolicyDialogScrollHelper.ensureTermsDescendersVisible(cVar);
            PolicyDialogScrollHelper.limitScrollContent(cVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void initWithdrawalCleanDataOneCheckBox$lambda$2$lambda$1(CheckBox checkBox, View view) {
            k.g(checkBox, "$mzCheckboxFirst");
            checkBox.performClick();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void initWithdrawalCleanDataTwoCheckBox$lambda$5(stepos.support.v7.app.c cVar, Context context, boolean z5, String str, String str2, DialogInterface dialogInterface) {
            k.g(cVar, "$alertDialog");
            k.g(context, "$context");
            k.g(str, "$checkButtonMessage");
            k.g(str2, "$secondCheckButtonMessage");
            Button button = cVar.getButton(-1);
            k.f(button, "alertDialog.getButton(Di…nterface.BUTTON_POSITIVE)");
            button.setBackground(androidx.core.content.a.e(context, p.f15797b));
            button.setTextColor(androidx.core.content.a.c(context, PolicySdkToolsUtils.Companion.getIdentifierByAttrId(C0728a.f16804A, context)));
            View viewFindViewById = cVar.findViewById(q.f15812o);
            k.e(viewFindViewById, "null cannot be cast to non-null type android.widget.CheckBox");
            ((CheckBox) viewFindViewById).setVisibility(8);
            View viewFindViewById2 = cVar.findViewById(q.stepos_checkbox_layout_first);
            k.e(viewFindViewById2, "null cannot be cast to non-null type android.widget.LinearLayout");
            LinearLayout linearLayout = (LinearLayout) viewFindViewById2;
            View viewFindViewById3 = cVar.findViewById(q.stepos_permission_dialog_checkbox_first);
            k.e(viewFindViewById3, "null cannot be cast to non-null type android.widget.CheckBox");
            final CheckBox checkBox = (CheckBox) viewFindViewById3;
            View viewFindViewById4 = cVar.findViewById(q.stepos_permission_dialog_tv_first);
            k.e(viewFindViewById4, "null cannot be cast to non-null type android.widget.TextView");
            TextView textView = (TextView) viewFindViewById4;
            if (z5) {
                linearLayout.setVisibility(0);
                checkBox.setChecked(false);
                textView.setText(str);
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.policy.sdk.util.h
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        PolicySdkToolsUtils.Companion.initWithdrawalCleanDataTwoCheckBox$lambda$5$lambda$3(checkBox, view);
                    }
                });
            } else {
                linearLayout.setVisibility(8);
            }
            View viewFindViewById5 = cVar.findViewById(q.stepos_checkbox_layout_second);
            k.e(viewFindViewById5, "null cannot be cast to non-null type android.widget.LinearLayout");
            LinearLayout linearLayout2 = (LinearLayout) viewFindViewById5;
            View viewFindViewById6 = cVar.findViewById(q.stepos_permission_dialog_checkbox_second);
            k.e(viewFindViewById6, "null cannot be cast to non-null type android.widget.CheckBox");
            final CheckBox checkBox2 = (CheckBox) viewFindViewById6;
            View viewFindViewById7 = cVar.findViewById(q.stepos_permission_dialog_tv_second);
            k.e(viewFindViewById7, "null cannot be cast to non-null type android.widget.TextView");
            TextView textView2 = (TextView) viewFindViewById7;
            checkBox2.setChecked(false);
            if (TextUtils.isEmpty(str2)) {
                linearLayout2.setVisibility(8);
            } else {
                linearLayout2.setVisibility(0);
                textView2.setText(str2);
                textView2.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.policy.sdk.util.i
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        PolicySdkToolsUtils.Companion.initWithdrawalCleanDataTwoCheckBox$lambda$5$lambda$4(checkBox2, view);
                    }
                });
            }
            PolicyDialogScrollHelper.ensureTermsDescendersVisible(cVar);
            PolicyDialogScrollHelper.limitScrollContent(cVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void initWithdrawalCleanDataTwoCheckBox$lambda$5$lambda$3(CheckBox checkBox, View view) {
            k.g(checkBox, "$mzCheckboxFirst");
            checkBox.performClick();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void initWithdrawalCleanDataTwoCheckBox$lambda$5$lambda$4(CheckBox checkBox, View view) {
            k.g(checkBox, "$mzCheckboxSecond");
            checkBox.performClick();
        }

        private final boolean isNetWorkPermission(String str) {
            return k.b(PolicySdkToolsUtils.PREMISSION_INTERNET_GROUP, str) || k.b(PolicySdkToolsUtils.PREMISSION_INTERNET, str) || k.b(PolicySdkToolsUtils.PREMISSION_INTERNET_CHANGE, str) || k.b(PolicySdkToolsUtils.PREMISSION_INTERNET_ACCESS, str);
        }

        private final TypedValue obtainTypedValue(int i5, Context context) {
            Resources.Theme theme = context.getTheme();
            if (theme == null) {
                return null;
            }
            TypedValue typedValue = new TypedValue();
            try {
                try {
                    theme.resolveAttribute(i5, typedValue, true);
                } catch (Exception e6) {
                    e6.printStackTrace();
                }
            } catch (Throwable unused) {
            }
            return typedValue;
        }

        private final String toUpperCaseFirstOne(String str) {
            if (Character.isUpperCase(str.charAt(0))) {
                return str;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(Character.toUpperCase(str.charAt(0)));
            String strSubstring = str.substring(1);
            k.f(strSubstring, "this as java.lang.String).substring(startIndex)");
            sb.append(strSubstring);
            String string = sb.toString();
            k.f(string, "{\n                String….toString()\n            }");
            return string;
        }

        public final boolean checkFileExistsInAssets(Context context, String str) throws IOException {
            k.g(context, "context");
            k.g(str, "fileName");
            try {
                PolicySdkLogUtils.Companion.d("checkFileExistsInAssets");
                AssetManager assets = context.getAssets();
                k.f(assets, "context.assets");
                String[] list = assets.list(BuildConfig.FLAVOR);
                if (list != null) {
                    for (String str2 : list) {
                        if (k.b(str2, str)) {
                            PolicySdkLogUtils.Companion.d("checkFileExistsInAssets", "FileExists = true " + str);
                            return true;
                        }
                    }
                }
            } catch (Exception e6) {
                e6.printStackTrace();
            }
            PolicySdkLogUtils.Companion.d("checkFileExistsInAssets", "FileExists = false " + str);
            return false;
        }

        public final boolean checkPolicyCategoryIsSame(String str, String str2) {
            k.g(str, "path");
            k.g(str2, "policyCategory");
            return C1031n.u(str, str2, false, 2, null);
        }

        public final String getAppSign(String str, String str2, long j5) {
            k.g(str, "appId");
            k.g(str2, "appSecret");
            String sign = new SignServiceImpl().getSign(new SignDTO(str, str2, Long.valueOf(j5)));
            k.f(sign, "md5");
            return sign;
        }

        public final String getChannelToBrand() {
            try {
                String strB = N1.a.b("ro.stepos.build.channel");
                k.f(strB, "getSystemProperties(\"ro.stepos.build.channel\")");
                Log.d("getChannelToBrand", " channel = " + strB);
                if (!k.b("unknown", strB)) {
                    if (!TextUtils.isEmpty(strB)) {
                        return strB;
                    }
                }
                return "STEPOS";
            } catch (Exception e6) {
                Log.e("getChannelToBrand", " Exception" + e6.getMessage());
                return "STEPOS";
            }
        }

        public final String[] getCustomPermissionKey(Context context, String[] strArr) {
            k.g(context, "context");
            k.g(strArr, "permissionKey");
            try {
                try {
                    PolicySdkLogUtils.Companion.d("getCustomPermissionKey", "language = " + Locale.getDefault().getLanguage());
                    String language = Locale.getDefault().getLanguage();
                    k.f(language, "getDefault().language");
                    if (C1031n.u(language, "en", false, 2, null)) {
                        List<Z4.d> listA = Z4.e.b(context).a();
                        int length = strArr.length;
                        for (int i5 = 0; i5 < length; i5++) {
                            for (Z4.d dVar : listA) {
                                if (!k.b(strArr[i5], dVar.g())) {
                                    for (Z4.c cVar : dVar.i()) {
                                        if (k.b(strArr[i5], cVar.e()) && !isNetWorkPermission(strArr[i5])) {
                                            PolicySdkPermissionManifestUtils policySdkPermissionManifestUtils = PolicySdkPermissionManifestUtils.INSTANCE;
                                            String strE = cVar.e();
                                            k.f(strE, "getSubPermission.identifier");
                                            String policyModifyPerKey = policySdkPermissionManifestUtils.getPolicyModifyPerKey(context, strE);
                                            if (k.b(policyModifyPerKey, cVar.e())) {
                                                policyModifyPerKey = cVar.d(context);
                                                k.f(policyModifyPerKey, "getSubPermission.getDisplayName(context)");
                                            }
                                            PolicySdkLogUtils.Companion.d("getCustomPermissionKey", " getSubPermission identifier = " + cVar.e() + "  | displayName = " + policyModifyPerKey + "  ");
                                            strArr[i5] = toUpperCaseFirstOne(policyModifyPerKey);
                                        }
                                    }
                                } else if (!isNetWorkPermission(strArr[i5])) {
                                    PolicySdkPermissionManifestUtils policySdkPermissionManifestUtils2 = PolicySdkPermissionManifestUtils.INSTANCE;
                                    String strG = dVar.g();
                                    k.f(strG, "getPermissionGroup.identifier");
                                    String policyModifyPerKey2 = policySdkPermissionManifestUtils2.getPolicyModifyPerKey(context, strG);
                                    if (k.b(policyModifyPerKey2, dVar.g())) {
                                        policyModifyPerKey2 = dVar.e(context);
                                        k.f(policyModifyPerKey2, "getPermissionGroup.getDisplayName(context)");
                                    }
                                    PolicySdkLogUtils.Companion.d("getCustomPermissionKey", " getPermissionGroup identifier = " + dVar.g() + "  | displayName = " + policyModifyPerKey2 + "  ");
                                    strArr[i5] = toUpperCaseFirstOne(policyModifyPerKey2);
                                }
                            }
                        }
                    }
                } catch (Exception e6) {
                    e6.printStackTrace();
                }
            } catch (Throwable unused) {
            }
            return strArr;
        }

        public final ArrayList<DeleteInfoBean> getDeleteInfoBeanByGson(String str) {
            k.g(str, "deleteJson");
            Object objJ = new A1.e().j(str, new com.google.gson.reflect.a<ArrayList<DeleteInfoBean>>() { // from class: com.stepos.policy.sdk.util.PolicySdkToolsUtils$Companion$getDeleteInfoBeanByGson$type$1
            }.getType());
            k.f(objJ, "gson.fromJson(deleteJson, type)");
            ArrayList<DeleteInfoBean> arrayList = (ArrayList) objJ;
            PolicySdkLogUtils.Companion.d("getDeleteInfoBeanByGson", "deleteInfoList = " + arrayList);
            return arrayList;
        }

        public final String getDeviceBrand() {
            String str = Build.BRAND;
            k.f(str, "BRAND");
            return str;
        }

        public final int getIdentifierByAttrId(int i5, Context context) {
            k.g(context, "context");
            TypedValue typedValueObtainTypedValue = obtainTypedValue(i5, context);
            if (typedValueObtainTypedValue == null) {
                return 0;
            }
            return typedValueObtainTypedValue.resourceId;
        }

        public final String getLanguage() {
            StringBuilder sb = new StringBuilder();
            String language = Locale.getDefault().getLanguage();
            k.f(language, "getDefault().language");
            String lowerCase = language.toLowerCase();
            k.f(lowerCase, "this as java.lang.String).toLowerCase()");
            sb.append(lowerCase);
            sb.append('_');
            String country = Locale.getDefault().getCountry();
            k.f(country, "getDefault().country");
            String upperCase = country.toUpperCase();
            k.f(upperCase, "this as java.lang.String).toUpperCase()");
            sb.append(upperCase);
            return sb.toString();
        }

        public final String getSystemModel(Context context) throws ClassNotFoundException {
            k.g(context, "context");
            String str = PolicySdkSystemProperties.get(context, "ro.vendor.stepos.product.model");
            k.f(str, "get(context, modelKey)");
            return str;
        }

        public final String getSystemVersion(Context context) throws ClassNotFoundException {
            k.g(context, "context");
            String str = PolicySdkSystemProperties.get(context, "ro.stepos.version.id", BuildConfig.FLAVOR);
            k.f(str, "get(context, \"ro.stepos.version.id\", \"\")");
            return str;
        }

        public final String getVerifyType(boolean z5, boolean z6) {
            String str;
            if (z5 && z6) {
                str = "3";
            } else {
                str = "0";
                if (z5 || z6) {
                    if (z5 && !z6) {
                        str = "2";
                    } else if (!z5 && z6) {
                        str = "1";
                    }
                }
            }
            PolicySdkLogUtils.Companion.d("getVerifyType", "verifyType = " + str + " | firstCheck " + z5 + " | secondCheck " + z6);
            return str;
        }

        public final stepos.support.v7.app.c initWithdrawalCleanDataOneCheckBox(final Context context, final stepos.support.v7.app.c cVar, final String str) {
            k.g(context, "context");
            k.g(cVar, "alertDialog");
            k.g(str, "checkButtonMessage");
            try {
                cVar.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.stepos.policy.sdk.util.g
                    @Override // android.content.DialogInterface.OnShowListener
                    public final void onShow(DialogInterface dialogInterface) {
                        PolicySdkToolsUtils.Companion.initWithdrawalCleanDataOneCheckBox$lambda$2(cVar, context, str, dialogInterface);
                    }
                });
            } catch (Exception unused) {
            }
            return cVar;
        }

        public final stepos.support.v7.app.c initWithdrawalCleanDataTwoCheckBox(final Context context, final stepos.support.v7.app.c cVar, final boolean z5, final String str, final String str2) {
            k.g(context, "context");
            k.g(cVar, "alertDialog");
            k.g(str, "checkButtonMessage");
            k.g(str2, "secondCheckButtonMessage");
            try {
                try {
                    cVar.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.stepos.policy.sdk.util.e
                        @Override // android.content.DialogInterface.OnShowListener
                        public final void onShow(DialogInterface dialogInterface) {
                            PolicySdkToolsUtils.Companion.initWithdrawalCleanDataTwoCheckBox$lambda$5(cVar, context, z5, str, str2, dialogInterface);
                        }
                    });
                    return cVar;
                } catch (Exception unused) {
                    return cVar;
                }
            } catch (Exception unused2) {
                return cVar;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object isNeedSyncLocalFile(android.content.Context r12, java.lang.String r13, java.lang.String r14, Z3.e<? super java.lang.Boolean> r15) {
            /*
                Method dump skipped, instructions count: 377
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.util.PolicySdkToolsUtils.Companion.isNeedSyncLocalFile(android.content.Context, java.lang.String, java.lang.String, Z3.e):java.lang.Object");
        }

        public final boolean isPolestar() {
            return false;
        }

        public final boolean isPreAndroidP() {
            return false;
        }

        public final void startBrowser(Context context, Uri uri) {
            k.g(context, "context");
            k.g(uri, "uri");
            Log.d("startBrowser", "url = " + uri);
            try {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW", uri);
                    intent.addFlags(268435456);
                    intent.addFlags(1);
                    intent.setPackage("com.android.browser");
                    context.startActivity(intent);
                } catch (Exception unused) {
                    Intent intent2 = new Intent("android.intent.action.VIEW", uri);
                    intent2.addFlags(268435456);
                    intent2.addFlags(1);
                    context.startActivity(intent2);
                }
            } catch (Exception e6) {
                Log.e("startBrowser", "startBrowser: Exception" + e6.getMessage());
            }
        }

        private Companion() {
        }

        public final void startBrowser(Context context, String str) {
            k.g(context, "context");
            Uri uri = Uri.parse(str);
            try {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW", uri);
                    intent.addFlags(268435456);
                    intent.setPackage("com.android.browser");
                    context.startActivity(intent);
                } catch (Exception unused) {
                    Intent intent2 = new Intent("android.intent.action.VIEW", uri);
                    intent2.addFlags(268435456);
                    context.startActivity(intent2);
                }
            } catch (Exception unused2) {
            }
        }
    }
}
