package com.stepos.policy.sdk.util;

import La.H;
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
import androidx.appcompat.R$attr;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.stepos.policy.sdk.R$drawable;
import com.stepos.policy.sdk.R$id;
import com.stepos.policy.sdk.bean.DeleteInfoBean;
import com.stepos.policy.sdk.util.PolicySdkToolsUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import net.sqlcipher.database.SQLiteDatabase;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/stepos/policy/sdk/util/PolicySdkToolsUtils;", "", "()V", "Companion", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PolicySdkToolsUtils {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String PREMISSION_INTERNET = "android.permission.INTERNET";
    private static final String PREMISSION_INTERNET_ACCESS = "android.permission.ACCESS_NETWORK_STATE";
    private static final String PREMISSION_INTERNET_CHANGE = "android.permission.CHANGE_NETWORK_STATE";
    private static final String PREMISSION_INTERNET_GROUP = "stepos.permission-group.NETWORK";
    private static Boolean sIsPoleStar;

    @Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0010\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0006¢\u0006\u0004\b\u0015\u0010\u0016J)\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u00172\u0006\u0010\u000f\u001a\u00020\u000e2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\u001d\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0004¢\u0006\u0004\b\u001c\u0010\u001dJ\r\u0010\u001e\u001a\u00020\u0004¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010 \u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b \u0010!J\r\u0010\"\u001a\u00020\u0004¢\u0006\u0004\b\"\u0010\u001fJ\u0015\u0010#\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b#\u0010!J\r\u0010$\u001a\u00020\u0006¢\u0006\u0004\b$\u0010%J%\u0010*\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u00042\u0006\u0010)\u001a\u00020(¢\u0006\u0004\b*\u0010+J\u001d\u0010/\u001a\u00020.2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020,¢\u0006\u0004\b/\u00100J\r\u00101\u001a\u00020\u0004¢\u0006\u0004\b1\u0010\u001fJ\u000f\u00102\u001a\u00020\u0006H\u0007¢\u0006\u0004\b2\u0010%J\u001d\u00104\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u00103\u001a\u00020\u0004¢\u0006\u0004\b4\u00105J%\u0010:\u001a\u0012\u0012\u0004\u0012\u00020807j\b\u0012\u0004\u0012\u000208`92\u0006\u00106\u001a\u00020\u0004¢\u0006\u0004\b:\u0010;J\u001f\u0010/\u001a\u00020.2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010<\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b/\u0010=J\u001d\u0010>\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b>\u0010?J%\u0010C\u001a\u00020@2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010A\u001a\u00020@2\u0006\u0010B\u001a\u00020\u0004¢\u0006\u0004\bC\u0010DJ5\u0010G\u001a\u00020@2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010A\u001a\u00020@2\u0006\u0010E\u001a\u00020\u00062\u0006\u0010B\u001a\u00020\u00042\u0006\u0010F\u001a\u00020\u0004¢\u0006\u0004\bG\u0010HJ/\u0010K\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010I\u001a\u0004\u0018\u00010\u00042\b\u0010J\u001a\u0004\u0018\u00010\u0004H\u0086@ø\u0001\u0000¢\u0006\u0004\bK\u0010LR\u0014\u0010M\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\bM\u0010NR\u0014\u0010O\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\bO\u0010NR\u0014\u0010P\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\bP\u0010NR\u0014\u0010Q\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\bQ\u0010NR\u0018\u0010R\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u0010S\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006T"}, d2 = {"Lcom/stepos/policy/sdk/util/PolicySdkToolsUtils$Companion;", "", "<init>", "()V", "", "permissionKey", "", "isNetWorkPermission", "(Ljava/lang/String;)Z", "str", "toUpperCaseFirstOne", "(Ljava/lang/String;)Ljava/lang/String;", "", "attrId", "Landroid/content/Context;", "context", "Landroid/util/TypedValue;", "obtainTypedValue", "(ILandroid/content/Context;)Landroid/util/TypedValue;", "firstCheck", "secondCheck", "getVerifyType", "(ZZ)Ljava/lang/String;", "", "getCustomPermissionKey", "(Landroid/content/Context;[Ljava/lang/String;)[Ljava/lang/String;", "path", "policyCategory", "checkPolicyCategoryIsSame", "(Ljava/lang/String;Ljava/lang/String;)Z", "getLanguage", "()Ljava/lang/String;", "getSystemModel", "(Landroid/content/Context;)Ljava/lang/String;", "getDeviceBrand", "getSystemVersion", "isPreAndroidP", "()Z", "appId", "appSecret", "", "reqTime", "getAppSign", "(Ljava/lang/String;Ljava/lang/String;J)Ljava/lang/String;", "Landroid/net/Uri;", "uri", "LY8/t;", "startBrowser", "(Landroid/content/Context;Landroid/net/Uri;)V", "getChannelToBrand", "isPolestar", "fileName", "checkFileExistsInAssets", "(Landroid/content/Context;Ljava/lang/String;)Z", "deleteJson", "Ljava/util/ArrayList;", "Lcom/stepos/policy/sdk/bean/DeleteInfoBean;", "Lkotlin/collections/ArrayList;", "getDeleteInfoBeanByGson", "(Ljava/lang/String;)Ljava/util/ArrayList;", "url", "(Landroid/content/Context;Ljava/lang/String;)V", "getIdentifierByAttrId", "(ILandroid/content/Context;)I", "Lstepos/support/v7/app/c;", "alertDialog", "checkButtonMessage", "initWithdrawalCleanDataOneCheckBox", "(Landroid/content/Context;Lstepos/support/v7/app/c;Ljava/lang/String;)Lstepos/support/v7/app/c;", "hasLogin", "secondCheckButtonMessage", "initWithdrawalCleanDataTwoCheckBox", "(Landroid/content/Context;Lstepos/support/v7/app/c;ZLjava/lang/String;Ljava/lang/String;)Lstepos/support/v7/app/c;", "newestPolicyPath", "localMd5", "isNeedSyncLocalFile", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "PREMISSION_INTERNET", "Ljava/lang/String;", "PREMISSION_INTERNET_ACCESS", "PREMISSION_INTERNET_CHANGE", "PREMISSION_INTERNET_GROUP", "sIsPoleStar", "Ljava/lang/Boolean;", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void initWithdrawalCleanDataOneCheckBox$lambda$2(stepos.support.v7.app.c alertDialog, Context context, String checkButtonMessage, DialogInterface dialogInterface) {
            p.i(alertDialog, "$alertDialog");
            p.i(context, "$context");
            p.i(checkButtonMessage, "$checkButtonMessage");
            Button button = alertDialog.getButton(-1);
            p.h(button, "alertDialog.getButton(Di…nterface.BUTTON_POSITIVE)");
            button.setBackground(androidx.core.content.a.e(context, R$drawable.policysdk_ic_withdrawal_btn_bg));
            button.setTextColor(androidx.core.content.a.c(context, PolicySdkToolsUtils.INSTANCE.getIdentifierByAttrId(R$attr.colorError, context)));
            View viewFindViewById = alertDialog.findViewById(R$id.stepos_permission_dialog_checkbox);
            p.g(viewFindViewById, "null cannot be cast to non-null type android.widget.CheckBox");
            ((CheckBox) viewFindViewById).setVisibility(8);
            View viewFindViewById2 = alertDialog.findViewById(R$id.stepos_checkbox_layout_first);
            p.g(viewFindViewById2, "null cannot be cast to non-null type android.widget.LinearLayout");
            View viewFindViewById3 = alertDialog.findViewById(R$id.stepos_permission_dialog_checkbox_first);
            p.g(viewFindViewById3, "null cannot be cast to non-null type android.widget.CheckBox");
            final CheckBox checkBox = (CheckBox) viewFindViewById3;
            View viewFindViewById4 = alertDialog.findViewById(R$id.stepos_permission_dialog_tv_first);
            p.g(viewFindViewById4, "null cannot be cast to non-null type android.widget.TextView");
            TextView textView = (TextView) viewFindViewById4;
            ((LinearLayout) viewFindViewById2).setVisibility(0);
            checkBox.setChecked(false);
            textView.setText(checkButtonMessage);
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.policy.sdk.util.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PolicySdkToolsUtils.Companion.initWithdrawalCleanDataOneCheckBox$lambda$2$lambda$1(checkBox, view);
                }
            });
            PolicyDialogScrollHelper.ensureTermsDescendersVisible(alertDialog);
            PolicyDialogScrollHelper.limitScrollContent(alertDialog);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void initWithdrawalCleanDataOneCheckBox$lambda$2$lambda$1(CheckBox mzCheckboxFirst, View view) {
            p.i(mzCheckboxFirst, "$mzCheckboxFirst");
            mzCheckboxFirst.performClick();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void initWithdrawalCleanDataTwoCheckBox$lambda$5(stepos.support.v7.app.c alertDialog, Context context, boolean z10, String checkButtonMessage, String secondCheckButtonMessage, DialogInterface dialogInterface) {
            p.i(alertDialog, "$alertDialog");
            p.i(context, "$context");
            p.i(checkButtonMessage, "$checkButtonMessage");
            p.i(secondCheckButtonMessage, "$secondCheckButtonMessage");
            Button button = alertDialog.getButton(-1);
            p.h(button, "alertDialog.getButton(Di…nterface.BUTTON_POSITIVE)");
            button.setBackground(androidx.core.content.a.e(context, R$drawable.policysdk_ic_withdrawal_btn_bg));
            button.setTextColor(androidx.core.content.a.c(context, PolicySdkToolsUtils.INSTANCE.getIdentifierByAttrId(R$attr.colorError, context)));
            View viewFindViewById = alertDialog.findViewById(R$id.stepos_permission_dialog_checkbox);
            p.g(viewFindViewById, "null cannot be cast to non-null type android.widget.CheckBox");
            ((CheckBox) viewFindViewById).setVisibility(8);
            View viewFindViewById2 = alertDialog.findViewById(R$id.stepos_checkbox_layout_first);
            p.g(viewFindViewById2, "null cannot be cast to non-null type android.widget.LinearLayout");
            LinearLayout linearLayout = (LinearLayout) viewFindViewById2;
            View viewFindViewById3 = alertDialog.findViewById(R$id.stepos_permission_dialog_checkbox_first);
            p.g(viewFindViewById3, "null cannot be cast to non-null type android.widget.CheckBox");
            final CheckBox checkBox = (CheckBox) viewFindViewById3;
            View viewFindViewById4 = alertDialog.findViewById(R$id.stepos_permission_dialog_tv_first);
            p.g(viewFindViewById4, "null cannot be cast to non-null type android.widget.TextView");
            TextView textView = (TextView) viewFindViewById4;
            if (z10) {
                linearLayout.setVisibility(0);
                checkBox.setChecked(false);
                textView.setText(checkButtonMessage);
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.policy.sdk.util.h
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        PolicySdkToolsUtils.Companion.initWithdrawalCleanDataTwoCheckBox$lambda$5$lambda$3(checkBox, view);
                    }
                });
            } else {
                linearLayout.setVisibility(8);
            }
            View viewFindViewById5 = alertDialog.findViewById(R$id.stepos_checkbox_layout_second);
            p.g(viewFindViewById5, "null cannot be cast to non-null type android.widget.LinearLayout");
            LinearLayout linearLayout2 = (LinearLayout) viewFindViewById5;
            View viewFindViewById6 = alertDialog.findViewById(R$id.stepos_permission_dialog_checkbox_second);
            p.g(viewFindViewById6, "null cannot be cast to non-null type android.widget.CheckBox");
            final CheckBox checkBox2 = (CheckBox) viewFindViewById6;
            View viewFindViewById7 = alertDialog.findViewById(R$id.stepos_permission_dialog_tv_second);
            p.g(viewFindViewById7, "null cannot be cast to non-null type android.widget.TextView");
            TextView textView2 = (TextView) viewFindViewById7;
            checkBox2.setChecked(false);
            if (TextUtils.isEmpty(secondCheckButtonMessage)) {
                linearLayout2.setVisibility(8);
            } else {
                linearLayout2.setVisibility(0);
                textView2.setText(secondCheckButtonMessage);
                textView2.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.policy.sdk.util.i
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        PolicySdkToolsUtils.Companion.initWithdrawalCleanDataTwoCheckBox$lambda$5$lambda$4(checkBox2, view);
                    }
                });
            }
            PolicyDialogScrollHelper.ensureTermsDescendersVisible(alertDialog);
            PolicyDialogScrollHelper.limitScrollContent(alertDialog);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void initWithdrawalCleanDataTwoCheckBox$lambda$5$lambda$3(CheckBox mzCheckboxFirst, View view) {
            p.i(mzCheckboxFirst, "$mzCheckboxFirst");
            mzCheckboxFirst.performClick();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void initWithdrawalCleanDataTwoCheckBox$lambda$5$lambda$4(CheckBox mzCheckboxSecond, View view) {
            p.i(mzCheckboxSecond, "$mzCheckboxSecond");
            mzCheckboxSecond.performClick();
        }

        private final boolean isNetWorkPermission(String permissionKey) {
            return p.d(PolicySdkToolsUtils.PREMISSION_INTERNET_GROUP, permissionKey) || p.d(PolicySdkToolsUtils.PREMISSION_INTERNET, permissionKey) || p.d(PolicySdkToolsUtils.PREMISSION_INTERNET_CHANGE, permissionKey) || p.d(PolicySdkToolsUtils.PREMISSION_INTERNET_ACCESS, permissionKey);
        }

        private final TypedValue obtainTypedValue(int attrId, Context context) {
            Resources.Theme theme = context.getTheme();
            if (theme == null) {
                return null;
            }
            TypedValue typedValue = new TypedValue();
            try {
                try {
                    theme.resolveAttribute(attrId, typedValue, true);
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
            p.h(strSubstring, "this as java.lang.String).substring(startIndex)");
            sb2.append(strSubstring);
            String string = sb2.toString();
            p.h(string, "{\n                String….toString()\n            }");
            return string;
        }

        public final boolean checkFileExistsInAssets(Context context, String fileName) throws IOException {
            p.i(context, "context");
            p.i(fileName, "fileName");
            try {
                PolicySdkLogUtils.INSTANCE.d("checkFileExistsInAssets");
                AssetManager assets = context.getAssets();
                p.h(assets, "context.assets");
                String[] list = assets.list("");
                if (list != null) {
                    for (String str : list) {
                        if (p.d(str, fileName)) {
                            PolicySdkLogUtils.INSTANCE.d("checkFileExistsInAssets", "FileExists = true " + fileName);
                            return true;
                        }
                    }
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            PolicySdkLogUtils.INSTANCE.d("checkFileExistsInAssets", "FileExists = false " + fileName);
            return false;
        }

        public final boolean checkPolicyCategoryIsSame(String path, String policyCategory) {
            p.i(path, "path");
            p.i(policyCategory, "policyCategory");
            return H.g0(path, policyCategory, false, 2, null);
        }

        public final String getAppSign(String appId, String appSecret, long reqTime) {
            p.i(appId, "appId");
            p.i(appSecret, "appSecret");
            String md5 = new T7.b().a(new S7.a(appId, appSecret, Long.valueOf(reqTime)));
            p.h(md5, "md5");
            return md5;
        }

        public final String getChannelToBrand() {
            try {
                String strB = O6.c.b("ro.stepos.build.channel");
                p.h(strB, "getSystemProperties(\"ro.stepos.build.channel\")");
                Log.d("getChannelToBrand", " channel = " + strB);
                if (!p.d("unknown", strB)) {
                    if (!TextUtils.isEmpty(strB)) {
                        return strB;
                    }
                }
                return "STEPOS";
            } catch (Exception e10) {
                Log.e("getChannelToBrand", " Exception" + e10.getMessage());
                return "STEPOS";
            }
        }

        public final String[] getCustomPermissionKey(Context context, String[] permissionKey) {
            p.i(context, "context");
            p.i(permissionKey, "permissionKey");
            try {
                try {
                    PolicySdkLogUtils.INSTANCE.d("getCustomPermissionKey", "language = " + Locale.getDefault().getLanguage());
                    String language = Locale.getDefault().getLanguage();
                    p.h(language, "getDefault().language");
                    if (H.g0(language, "en", false, 2, null)) {
                        List<stepos.support.v7.permission.d> listA = stepos.support.v7.permission.e.b(context).a();
                        int length = permissionKey.length;
                        for (int i10 = 0; i10 < length; i10++) {
                            for (stepos.support.v7.permission.d dVar : listA) {
                                if (!p.d(permissionKey[i10], dVar.e())) {
                                    for (stepos.support.v7.permission.c cVar : dVar.i()) {
                                        if (p.d(permissionKey[i10], cVar.c()) && !isNetWorkPermission(permissionKey[i10])) {
                                            PolicySdkPermissionManifestUtils policySdkPermissionManifestUtils = PolicySdkPermissionManifestUtils.INSTANCE;
                                            String strC = cVar.c();
                                            p.h(strC, "getSubPermission.identifier");
                                            String policyModifyPerKey = policySdkPermissionManifestUtils.getPolicyModifyPerKey(context, strC);
                                            if (p.d(policyModifyPerKey, cVar.c())) {
                                                policyModifyPerKey = cVar.b(context);
                                                p.h(policyModifyPerKey, "getSubPermission.getDisplayName(context)");
                                            }
                                            PolicySdkLogUtils.INSTANCE.d("getCustomPermissionKey", " getSubPermission identifier = " + cVar.c() + "  | displayName = " + policyModifyPerKey + "  ");
                                            permissionKey[i10] = toUpperCaseFirstOne(policyModifyPerKey);
                                        }
                                    }
                                } else if (!isNetWorkPermission(permissionKey[i10])) {
                                    PolicySdkPermissionManifestUtils policySdkPermissionManifestUtils2 = PolicySdkPermissionManifestUtils.INSTANCE;
                                    String strE = dVar.e();
                                    p.h(strE, "getPermissionGroup.identifier");
                                    String policyModifyPerKey2 = policySdkPermissionManifestUtils2.getPolicyModifyPerKey(context, strE);
                                    if (p.d(policyModifyPerKey2, dVar.e())) {
                                        policyModifyPerKey2 = dVar.c(context);
                                        p.h(policyModifyPerKey2, "getPermissionGroup.getDisplayName(context)");
                                    }
                                    PolicySdkLogUtils.INSTANCE.d("getCustomPermissionKey", " getPermissionGroup identifier = " + dVar.e() + "  | displayName = " + policyModifyPerKey2 + "  ");
                                    permissionKey[i10] = toUpperCaseFirstOne(policyModifyPerKey2);
                                }
                            }
                        }
                    }
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            } catch (Throwable unused) {
            }
            return permissionKey;
        }

        public final ArrayList<DeleteInfoBean> getDeleteInfoBeanByGson(String deleteJson) {
            p.i(deleteJson, "deleteJson");
            Object objFromJson = new Gson().fromJson(deleteJson, new TypeToken<ArrayList<DeleteInfoBean>>() { // from class: com.stepos.policy.sdk.util.PolicySdkToolsUtils$Companion$getDeleteInfoBeanByGson$type$1
            }.getType());
            p.h(objFromJson, "gson.fromJson(deleteJson, type)");
            ArrayList<DeleteInfoBean> arrayList = (ArrayList) objFromJson;
            PolicySdkLogUtils.INSTANCE.d("getDeleteInfoBeanByGson", "deleteInfoList = " + arrayList);
            return arrayList;
        }

        public final String getDeviceBrand() {
            String BRAND = Build.BRAND;
            p.h(BRAND, "BRAND");
            return BRAND;
        }

        public final int getIdentifierByAttrId(int attrId, Context context) {
            p.i(context, "context");
            TypedValue typedValueObtainTypedValue = obtainTypedValue(attrId, context);
            if (typedValueObtainTypedValue == null) {
                return 0;
            }
            return typedValueObtainTypedValue.resourceId;
        }

        public final String getLanguage() {
            StringBuilder sb2 = new StringBuilder();
            String language = Locale.getDefault().getLanguage();
            p.h(language, "getDefault().language");
            String lowerCase = language.toLowerCase();
            p.h(lowerCase, "this as java.lang.String).toLowerCase()");
            sb2.append(lowerCase);
            sb2.append('_');
            String country = Locale.getDefault().getCountry();
            p.h(country, "getDefault().country");
            String upperCase = country.toUpperCase();
            p.h(upperCase, "this as java.lang.String).toUpperCase()");
            sb2.append(upperCase);
            return sb2.toString();
        }

        public final String getSystemModel(Context context) throws ClassNotFoundException, IllegalArgumentException {
            p.i(context, "context");
            String str = PolicySdkSystemProperties.get(context, "ro.vendor.stepos.product.model");
            p.h(str, "get(context, modelKey)");
            return str;
        }

        public final String getSystemVersion(Context context) throws ClassNotFoundException, IllegalArgumentException {
            p.i(context, "context");
            String str = PolicySdkSystemProperties.get(context, "ro.stepos.version.id", "");
            p.h(str, "get(context, \"ro.stepos.version.id\", \"\")");
            return str;
        }

        public final String getVerifyType(boolean firstCheck, boolean secondCheck) {
            String str;
            if (firstCheck && secondCheck) {
                str = "3";
            } else {
                str = "0";
                if (firstCheck || secondCheck) {
                    if (firstCheck && !secondCheck) {
                        str = "2";
                    } else if (!firstCheck && secondCheck) {
                        str = "1";
                    }
                }
            }
            PolicySdkLogUtils.INSTANCE.d("getVerifyType", "verifyType = " + str + " | firstCheck " + firstCheck + " | secondCheck " + secondCheck);
            return str;
        }

        public final stepos.support.v7.app.c initWithdrawalCleanDataOneCheckBox(final Context context, final stepos.support.v7.app.c alertDialog, final String checkButtonMessage) {
            p.i(context, "context");
            p.i(alertDialog, "alertDialog");
            p.i(checkButtonMessage, "checkButtonMessage");
            try {
                alertDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.stepos.policy.sdk.util.g
                    @Override // android.content.DialogInterface.OnShowListener
                    public final void onShow(DialogInterface dialogInterface) {
                        PolicySdkToolsUtils.Companion.initWithdrawalCleanDataOneCheckBox$lambda$2(alertDialog, context, checkButtonMessage, dialogInterface);
                    }
                });
            } catch (Exception unused) {
            }
            return alertDialog;
        }

        public final stepos.support.v7.app.c initWithdrawalCleanDataTwoCheckBox(final Context context, final stepos.support.v7.app.c alertDialog, final boolean hasLogin, final String checkButtonMessage, final String secondCheckButtonMessage) {
            p.i(context, "context");
            p.i(alertDialog, "alertDialog");
            p.i(checkButtonMessage, "checkButtonMessage");
            p.i(secondCheckButtonMessage, "secondCheckButtonMessage");
            try {
                try {
                    alertDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.stepos.policy.sdk.util.e
                        @Override // android.content.DialogInterface.OnShowListener
                        public final void onShow(DialogInterface dialogInterface) {
                            PolicySdkToolsUtils.Companion.initWithdrawalCleanDataTwoCheckBox$lambda$5(alertDialog, context, hasLogin, checkButtonMessage, secondCheckButtonMessage, dialogInterface);
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
        public final java.lang.Object isNeedSyncLocalFile(android.content.Context r12, java.lang.String r13, java.lang.String r14, e9.InterfaceC4014c<? super java.lang.Boolean> r15) {
            /*
                Method dump skipped, instructions count: 377
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.util.PolicySdkToolsUtils.Companion.isNeedSyncLocalFile(android.content.Context, java.lang.String, java.lang.String, e9.c):java.lang.Object");
        }

        public final boolean isPolestar() {
            return false;
        }

        public final boolean isPreAndroidP() {
            return false;
        }

        public final void startBrowser(Context context, Uri uri) {
            p.i(context, "context");
            p.i(uri, "uri");
            Log.d("startBrowser", "url = " + uri);
            try {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW", uri);
                    intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                    intent.addFlags(1);
                    intent.setPackage("com.android.browser");
                    context.startActivity(intent);
                } catch (Exception unused) {
                    Intent intent2 = new Intent("android.intent.action.VIEW", uri);
                    intent2.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                    intent2.addFlags(1);
                    context.startActivity(intent2);
                }
            } catch (Exception e10) {
                Log.e("startBrowser", "startBrowser: Exception" + e10.getMessage());
            }
        }

        private Companion() {
        }

        public final void startBrowser(Context context, String url) {
            p.i(context, "context");
            Uri uri = Uri.parse(url);
            try {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW", uri);
                    intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                    intent.setPackage("com.android.browser");
                    context.startActivity(intent);
                } catch (Exception unused) {
                    Intent intent2 = new Intent("android.intent.action.VIEW", uri);
                    intent2.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                    context.startActivity(intent2);
                }
            } catch (Exception unused2) {
            }
        }
    }
}
