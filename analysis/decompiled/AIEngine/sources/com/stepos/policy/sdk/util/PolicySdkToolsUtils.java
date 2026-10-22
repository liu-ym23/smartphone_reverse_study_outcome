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
import com.google.android.material.datepicker.j;
import com.google.gson.reflect.TypeToken;
import com.stepos.aiengine.R;
import com.stepos.policy.sdk.bean.DeleteInfoBean;
import com.stepos.policy.sdk.util.PolicySdkLogUtils;
import com.stepos.policy.sdk.util.PolicySdkToolsUtils;
import d5.i;
import gc.q;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class PolicySdkToolsUtils {
    public static final Companion Companion = new Companion(null);
    private static final String PREMISSION_INTERNET = "android.permission.INTERNET";
    private static final String PREMISSION_INTERNET_ACCESS = "android.permission.ACCESS_NETWORK_STATE";
    private static final String PREMISSION_INTERNET_CHANGE = "android.permission.CHANGE_NETWORK_STATE";
    private static final String PREMISSION_INTERNET_GROUP = "stepos.permission-group.NETWORK";
    private static Boolean sIsPoleStar;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void initWithdrawalCleanDataOneCheckBox$lambda$2(stepos.support.v7.app.e alertDialog, Context context, String checkButtonMessage, DialogInterface dialogInterface) {
            kotlin.jvm.internal.g.f(alertDialog, "$alertDialog");
            kotlin.jvm.internal.g.f(context, "$context");
            kotlin.jvm.internal.g.f(checkButtonMessage, "$checkButtonMessage");
            Button button = alertDialog.getButton(-1);
            kotlin.jvm.internal.g.e(button, "alertDialog.getButton(Di…nterface.BUTTON_POSITIVE)");
            button.setBackground(context.getDrawable(R.drawable.policysdk_ic_withdrawal_btn_bg));
            button.setTextColor(context.getColor(PolicySdkToolsUtils.Companion.getIdentifierByAttrId(R.attr.colorError, context)));
            View viewFindViewById = alertDialog.findViewById(R.id.stepos_permission_dialog_checkbox);
            kotlin.jvm.internal.g.d(viewFindViewById, "null cannot be cast to non-null type android.widget.CheckBox");
            ((CheckBox) viewFindViewById).setVisibility(8);
            View viewFindViewById2 = alertDialog.findViewById(R.id.stepos_checkbox_layout_first);
            kotlin.jvm.internal.g.d(viewFindViewById2, "null cannot be cast to non-null type android.widget.LinearLayout");
            View viewFindViewById3 = alertDialog.findViewById(R.id.stepos_permission_dialog_checkbox_first);
            kotlin.jvm.internal.g.d(viewFindViewById3, "null cannot be cast to non-null type android.widget.CheckBox");
            CheckBox checkBox = (CheckBox) viewFindViewById3;
            View viewFindViewById4 = alertDialog.findViewById(R.id.stepos_permission_dialog_tv_first);
            kotlin.jvm.internal.g.d(viewFindViewById4, "null cannot be cast to non-null type android.widget.TextView");
            TextView textView = (TextView) viewFindViewById4;
            ((LinearLayout) viewFindViewById2).setVisibility(0);
            checkBox.setChecked(false);
            textView.setText(checkButtonMessage);
            textView.setOnClickListener(new e(checkBox, 0));
            PolicyDialogScrollHelper.ensureTermsDescendersVisible(alertDialog);
            PolicyDialogScrollHelper.limitScrollContent(alertDialog);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void initWithdrawalCleanDataOneCheckBox$lambda$2$lambda$1(CheckBox mzCheckboxFirst, View view) {
            kotlin.jvm.internal.g.f(mzCheckboxFirst, "$mzCheckboxFirst");
            mzCheckboxFirst.performClick();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void initWithdrawalCleanDataTwoCheckBox$lambda$5(stepos.support.v7.app.e alertDialog, Context context, boolean z, String checkButtonMessage, String secondCheckButtonMessage, DialogInterface dialogInterface) {
            kotlin.jvm.internal.g.f(alertDialog, "$alertDialog");
            kotlin.jvm.internal.g.f(context, "$context");
            kotlin.jvm.internal.g.f(checkButtonMessage, "$checkButtonMessage");
            kotlin.jvm.internal.g.f(secondCheckButtonMessage, "$secondCheckButtonMessage");
            Button button = alertDialog.getButton(-1);
            kotlin.jvm.internal.g.e(button, "alertDialog.getButton(Di…nterface.BUTTON_POSITIVE)");
            button.setBackground(context.getDrawable(R.drawable.policysdk_ic_withdrawal_btn_bg));
            button.setTextColor(context.getColor(PolicySdkToolsUtils.Companion.getIdentifierByAttrId(R.attr.colorError, context)));
            View viewFindViewById = alertDialog.findViewById(R.id.stepos_permission_dialog_checkbox);
            kotlin.jvm.internal.g.d(viewFindViewById, "null cannot be cast to non-null type android.widget.CheckBox");
            ((CheckBox) viewFindViewById).setVisibility(8);
            View viewFindViewById2 = alertDialog.findViewById(R.id.stepos_checkbox_layout_first);
            kotlin.jvm.internal.g.d(viewFindViewById2, "null cannot be cast to non-null type android.widget.LinearLayout");
            LinearLayout linearLayout = (LinearLayout) viewFindViewById2;
            View viewFindViewById3 = alertDialog.findViewById(R.id.stepos_permission_dialog_checkbox_first);
            kotlin.jvm.internal.g.d(viewFindViewById3, "null cannot be cast to non-null type android.widget.CheckBox");
            CheckBox checkBox = (CheckBox) viewFindViewById3;
            View viewFindViewById4 = alertDialog.findViewById(R.id.stepos_permission_dialog_tv_first);
            kotlin.jvm.internal.g.d(viewFindViewById4, "null cannot be cast to non-null type android.widget.TextView");
            TextView textView = (TextView) viewFindViewById4;
            if (z) {
                linearLayout.setVisibility(0);
                checkBox.setChecked(false);
                textView.setText(checkButtonMessage);
                textView.setOnClickListener(new e(checkBox, 1));
            } else {
                linearLayout.setVisibility(8);
            }
            View viewFindViewById5 = alertDialog.findViewById(R.id.stepos_checkbox_layout_second);
            kotlin.jvm.internal.g.d(viewFindViewById5, "null cannot be cast to non-null type android.widget.LinearLayout");
            LinearLayout linearLayout2 = (LinearLayout) viewFindViewById5;
            View viewFindViewById6 = alertDialog.findViewById(R.id.stepos_permission_dialog_checkbox_second);
            kotlin.jvm.internal.g.d(viewFindViewById6, "null cannot be cast to non-null type android.widget.CheckBox");
            CheckBox checkBox2 = (CheckBox) viewFindViewById6;
            View viewFindViewById7 = alertDialog.findViewById(R.id.stepos_permission_dialog_tv_second);
            kotlin.jvm.internal.g.d(viewFindViewById7, "null cannot be cast to non-null type android.widget.TextView");
            TextView textView2 = (TextView) viewFindViewById7;
            checkBox2.setChecked(false);
            if (TextUtils.isEmpty(secondCheckButtonMessage)) {
                linearLayout2.setVisibility(8);
            } else {
                linearLayout2.setVisibility(0);
                textView2.setText(secondCheckButtonMessage);
                textView2.setOnClickListener(new j(checkBox2, 2));
            }
            PolicyDialogScrollHelper.ensureTermsDescendersVisible(alertDialog);
            PolicyDialogScrollHelper.limitScrollContent(alertDialog);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void initWithdrawalCleanDataTwoCheckBox$lambda$5$lambda$3(CheckBox mzCheckboxFirst, View view) {
            kotlin.jvm.internal.g.f(mzCheckboxFirst, "$mzCheckboxFirst");
            mzCheckboxFirst.performClick();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void initWithdrawalCleanDataTwoCheckBox$lambda$5$lambda$4(CheckBox mzCheckboxSecond, View view) {
            kotlin.jvm.internal.g.f(mzCheckboxSecond, "$mzCheckboxSecond");
            mzCheckboxSecond.performClick();
        }

        private final boolean isNetWorkPermission(String str) {
            return PolicySdkToolsUtils.PREMISSION_INTERNET_GROUP.equals(str) || PolicySdkToolsUtils.PREMISSION_INTERNET.equals(str) || PolicySdkToolsUtils.PREMISSION_INTERNET_CHANGE.equals(str) || PolicySdkToolsUtils.PREMISSION_INTERNET_ACCESS.equals(str);
        }

        private final TypedValue obtainTypedValue(int i10, Context context) {
            Resources.Theme theme = context.getTheme();
            if (theme == null) {
                return null;
            }
            TypedValue typedValue = new TypedValue();
            try {
                try {
                    theme.resolveAttribute(i10, typedValue, true);
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            } catch (Throwable unused) {
            }
            return typedValue;
        }

        private final String toUpperCaseFirstOne(String str) {
            if (Character.isUpperCase(str.charAt(0))) {
                return str;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(Character.toUpperCase(str.charAt(0)));
            String strSubstring = str.substring(1);
            kotlin.jvm.internal.g.e(strSubstring, "this as java.lang.String).substring(startIndex)");
            sb2.append(strSubstring);
            String string = sb2.toString();
            kotlin.jvm.internal.g.e(string, "{\n                String….toString()\n            }");
            return string;
        }

        public final boolean checkFileExistsInAssets(Context context, String fileName) throws IOException {
            kotlin.jvm.internal.g.f(context, "context");
            kotlin.jvm.internal.g.f(fileName, "fileName");
            try {
                PolicySdkLogUtils.Companion.d("checkFileExistsInAssets");
                AssetManager assets = context.getAssets();
                kotlin.jvm.internal.g.e(assets, "context.assets");
                String[] list = assets.list("");
                if (list != null) {
                    for (String str : list) {
                        if (kotlin.jvm.internal.g.b(str, fileName)) {
                            PolicySdkLogUtils.Companion.d("checkFileExistsInAssets", "FileExists = true " + fileName);
                            return true;
                        }
                    }
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            PolicySdkLogUtils.Companion.d("checkFileExistsInAssets", "FileExists = false ".concat(fileName));
            return false;
        }

        public final boolean checkPolicyCategoryIsSame(String path, String policyCategory) {
            kotlin.jvm.internal.g.f(path, "path");
            kotlin.jvm.internal.g.f(policyCategory, "policyCategory");
            return q.l0(path, policyCategory, false);
        }

        public final String getAppSign(String appId, String appSecret, long j10) {
            kotlin.jvm.internal.g.f(appId, "appId");
            kotlin.jvm.internal.g.f(appSecret, "appSecret");
            Long lValueOf = Long.valueOf(j10);
            if (appId.trim().equals("")) {
                throw new RuntimeException("appId不能为空！");
            }
            if (appSecret.trim().equals("")) {
                throw new RuntimeException("appSecret不能为空！");
            }
            String str = appId + appSecret + lValueOf;
            String[] strArr = xa.a.f13774a;
            try {
                String md5 = xa.a.a(xa.a.f13775b.get().digest(new String(str).getBytes()));
                kotlin.jvm.internal.g.e(md5, "md5");
                return md5;
            } catch (Exception e10) {
                throw new RuntimeException(e10);
            }
        }

        public final String getChannelToBrand() throws NoSuchMethodException, SecurityException {
            String str = null;
            try {
                if (l8.a.f10348a == null) {
                    Method declaredMethod = Build.class.getDeclaredMethod("getString", String.class);
                    l8.a.f10348a = declaredMethod;
                    declaredMethod.setAccessible(true);
                }
                str = (String) l8.a.f10348a.invoke(null, "ro.stepos.build.channel");
            } catch (Exception unused) {
            }
            try {
                kotlin.jvm.internal.g.e(str, "getSystemProperties(\"ro.stepos.build.channel\")");
                Log.d("getChannelToBrand", " channel = ".concat(str));
                return !"unknown".equals(str) ? !TextUtils.isEmpty(str) ? str : "STEPOS" : "STEPOS";
            } catch (Exception e10) {
                Log.e("getChannelToBrand", " Exception" + e10.getMessage());
                return "STEPOS";
            }
        }

        public final String[] getCustomPermissionKey(Context context, String[] strArr) {
            Context context2 = context;
            String[] permissionKey = strArr;
            kotlin.jvm.internal.g.f(context2, "context");
            kotlin.jvm.internal.g.f(permissionKey, "permissionKey");
            try {
                try {
                    PolicySdkLogUtils.Companion.d("getCustomPermissionKey", "language = " + Locale.getDefault().getLanguage());
                    String language = Locale.getDefault().getLanguage();
                    kotlin.jvm.internal.g.e(language, "getDefault().language");
                    int i10 = 0;
                    if (q.l0(language, "en", false)) {
                        stepos.support.v7.permission.e eVarA = stepos.support.v7.permission.e.a(context2);
                        List<stepos.support.v7.permission.d> listC = eVarA.c((String[]) eVarA.f12321b.keySet().toArray(new String[0]), true);
                        int length = permissionKey.length;
                        int i11 = 0;
                        while (i11 < length) {
                            for (stepos.support.v7.permission.d dVar : listC) {
                                String str = permissionKey[i11];
                                String str2 = dVar.f12316b;
                                if (!kotlin.jvm.internal.g.b(str, str2)) {
                                    ArrayList arrayList = dVar.f12318d;
                                    int size = arrayList.size();
                                    int i12 = i10;
                                    while (i12 < size) {
                                        Object obj = arrayList.get(i12);
                                        i12++;
                                        stepos.support.v7.permission.c cVar = (stepos.support.v7.permission.c) obj;
                                        String str3 = permissionKey[i11];
                                        String str4 = cVar.f12313b;
                                        if (kotlin.jvm.internal.g.b(str3, str4) && !isNetWorkPermission(permissionKey[i11])) {
                                            PolicySdkPermissionManifestUtils policySdkPermissionManifestUtils = PolicySdkPermissionManifestUtils.INSTANCE;
                                            kotlin.jvm.internal.g.e(str4, "getSubPermission.identifier");
                                            String policyModifyPerKey = policySdkPermissionManifestUtils.getPolicyModifyPerKey(context2, str4);
                                            if (kotlin.jvm.internal.g.b(policyModifyPerKey, str4)) {
                                                policyModifyPerKey = cVar.a();
                                                kotlin.jvm.internal.g.e(policyModifyPerKey, "getSubPermission.getDisplayName(context)");
                                            }
                                            PolicySdkLogUtils.Companion.d("getCustomPermissionKey", " getSubPermission identifier = " + str4 + "  | displayName = " + policyModifyPerKey + "  ");
                                            strArr[i11] = toUpperCaseFirstOne(policyModifyPerKey);
                                        }
                                        context2 = context;
                                        permissionKey = strArr;
                                        i10 = 0;
                                    }
                                    context2 = context;
                                    permissionKey = strArr;
                                } else if (!isNetWorkPermission(permissionKey[i11])) {
                                    PolicySdkPermissionManifestUtils policySdkPermissionManifestUtils2 = PolicySdkPermissionManifestUtils.INSTANCE;
                                    kotlin.jvm.internal.g.e(str2, "getPermissionGroup.identifier");
                                    String policyModifyPerKey2 = policySdkPermissionManifestUtils2.getPolicyModifyPerKey(context2, str2);
                                    if (kotlin.jvm.internal.g.b(policyModifyPerKey2, str2)) {
                                        policyModifyPerKey2 = dVar.a(context2);
                                        kotlin.jvm.internal.g.e(policyModifyPerKey2, "getPermissionGroup.getDisplayName(context)");
                                    }
                                    PolicySdkLogUtils.Companion.d("getCustomPermissionKey", " getPermissionGroup identifier = " + str2 + "  | displayName = " + policyModifyPerKey2 + "  ");
                                    permissionKey[i11] = toUpperCaseFirstOne(policyModifyPerKey2);
                                }
                            }
                            i11++;
                            context2 = context;
                            permissionKey = strArr;
                            i10 = 0;
                        }
                    }
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            } catch (Throwable unused) {
            }
            return strArr;
        }

        public final ArrayList<DeleteInfoBean> getDeleteInfoBeanByGson(String deleteJson) {
            kotlin.jvm.internal.g.f(deleteJson, "deleteJson");
            Object objC = new i().c(deleteJson, TypeToken.get(new TypeToken<ArrayList<DeleteInfoBean>>() { // from class: com.stepos.policy.sdk.util.PolicySdkToolsUtils$Companion$getDeleteInfoBeanByGson$type$1
            }.getType()));
            kotlin.jvm.internal.g.e(objC, "gson.fromJson(deleteJson, type)");
            ArrayList<DeleteInfoBean> arrayList = (ArrayList) objC;
            PolicySdkLogUtils.Companion.d("getDeleteInfoBeanByGson", "deleteInfoList = " + arrayList);
            return arrayList;
        }

        public final String getDeviceBrand() {
            String BRAND = Build.BRAND;
            kotlin.jvm.internal.g.e(BRAND, "BRAND");
            return BRAND;
        }

        public final int getIdentifierByAttrId(int i10, Context context) {
            kotlin.jvm.internal.g.f(context, "context");
            TypedValue typedValueObtainTypedValue = obtainTypedValue(i10, context);
            if (typedValueObtainTypedValue == null) {
                return 0;
            }
            return typedValueObtainTypedValue.resourceId;
        }

        public final String getLanguage() {
            StringBuilder sb2 = new StringBuilder();
            String language = Locale.getDefault().getLanguage();
            kotlin.jvm.internal.g.e(language, "getDefault().language");
            String lowerCase = language.toLowerCase();
            kotlin.jvm.internal.g.e(lowerCase, "this as java.lang.String).toLowerCase()");
            sb2.append(lowerCase);
            sb2.append('_');
            String country = Locale.getDefault().getCountry();
            kotlin.jvm.internal.g.e(country, "getDefault().country");
            String upperCase = country.toUpperCase();
            kotlin.jvm.internal.g.e(upperCase, "this as java.lang.String).toUpperCase()");
            sb2.append(upperCase);
            return sb2.toString();
        }

        public final String getSystemModel(Context context) {
            kotlin.jvm.internal.g.f(context, "context");
            String str = PolicySdkSystemProperties.get(context, "ro.vendor.stepos.product.model");
            kotlin.jvm.internal.g.e(str, "get(context, modelKey)");
            return str;
        }

        public final String getSystemVersion(Context context) {
            kotlin.jvm.internal.g.f(context, "context");
            String str = PolicySdkSystemProperties.get(context, "ro.stepos.version.id", "");
            kotlin.jvm.internal.g.e(str, "get(context, \"ro.stepos.version.id\", \"\")");
            return str;
        }

        public final String getVerifyType(boolean z, boolean z3) {
            String str;
            if (z && z3) {
                str = "3";
            } else {
                str = "0";
                if (z || z3) {
                    if (z && !z3) {
                        str = "2";
                    } else if (!z && z3) {
                        str = "1";
                    }
                }
            }
            PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.Companion;
            StringBuilder sbM = com.stepos.core.ota.d.m("verifyType = ", str, " | firstCheck ", " | secondCheck ", z);
            sbM.append(z3);
            companion.d("getVerifyType", sbM.toString());
            return str;
        }

        public final stepos.support.v7.app.e initWithdrawalCleanDataOneCheckBox(final Context context, final stepos.support.v7.app.e alertDialog, final String checkButtonMessage) {
            kotlin.jvm.internal.g.f(context, "context");
            kotlin.jvm.internal.g.f(alertDialog, "alertDialog");
            kotlin.jvm.internal.g.f(checkButtonMessage, "checkButtonMessage");
            try {
                alertDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.stepos.policy.sdk.util.f
                    @Override // android.content.DialogInterface.OnShowListener
                    public final void onShow(DialogInterface dialogInterface) {
                        PolicySdkToolsUtils.Companion.initWithdrawalCleanDataOneCheckBox$lambda$2(alertDialog, context, checkButtonMessage, dialogInterface);
                    }
                });
            } catch (Exception unused) {
            }
            return alertDialog;
        }

        public final stepos.support.v7.app.e initWithdrawalCleanDataTwoCheckBox(final Context context, final stepos.support.v7.app.e alertDialog, final boolean z, final String checkButtonMessage, final String secondCheckButtonMessage) {
            kotlin.jvm.internal.g.f(context, "context");
            kotlin.jvm.internal.g.f(alertDialog, "alertDialog");
            kotlin.jvm.internal.g.f(checkButtonMessage, "checkButtonMessage");
            kotlin.jvm.internal.g.f(secondCheckButtonMessage, "secondCheckButtonMessage");
            try {
                try {
                    alertDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.stepos.policy.sdk.util.d
                        @Override // android.content.DialogInterface.OnShowListener
                        public final void onShow(DialogInterface dialogInterface) {
                            PolicySdkToolsUtils.Companion.initWithdrawalCleanDataTwoCheckBox$lambda$5(alertDialog, context, z, checkButtonMessage, secondCheckButtonMessage, dialogInterface);
                        }
                    });
                    return alertDialog;
                } catch (Exception unused) {
                    return alertDialog;
                }
            } catch (Exception unused2) {
                return alertDialog;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object isNeedSyncLocalFile(android.content.Context r12, java.lang.String r13, java.lang.String r14, qb.b<? super java.lang.Boolean> r15) {
            /*
                Method dump skipped, instructions count: 354
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.util.PolicySdkToolsUtils.Companion.isNeedSyncLocalFile(android.content.Context, java.lang.String, java.lang.String, qb.b):java.lang.Object");
        }

        public final boolean isPolestar() {
            return false;
        }

        public final boolean isPreAndroidP() {
            return false;
        }

        public final void startBrowser(Context context, Uri uri) {
            kotlin.jvm.internal.g.f(context, "context");
            kotlin.jvm.internal.g.f(uri, "uri");
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
            } catch (Exception e10) {
                Log.e("startBrowser", "startBrowser: Exception" + e10.getMessage());
            }
        }

        private Companion() {
        }

        public final void startBrowser(Context context, String str) {
            kotlin.jvm.internal.g.f(context, "context");
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
