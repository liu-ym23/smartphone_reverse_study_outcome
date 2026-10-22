package com.stepos.policy.sdk.util;

import F1.n;
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
import ch.qos.logback.core.CoreConstants;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.google.gson.reflect.TypeToken;
import com.stepos.alphame.R;
import com.stepos.policy.sdk.bean.DeleteInfoBean;
import com.stepos.policy.sdk.util.PolicySdkToolsUtils;
import com.stepos.xjfms.ums.sign.jdk.dto.SignDTO;
import com.stepos.xjfms.ums.sign.jdk.service.SignServiceImpl;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import m2.AbstractC0770a;
import net.zetetic.database.sqlcipher.SQLiteDatabase;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import stepos.support.v7.app.DialogInterfaceC0865j;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/stepos/policy/sdk/util/PolicySdkToolsUtils;", "", "()V", "Companion", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PolicySdkToolsUtils {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String PREMISSION_INTERNET = "android.permission.INTERNET";

    @NotNull
    private static final String PREMISSION_INTERNET_ACCESS = "android.permission.ACCESS_NETWORK_STATE";

    @NotNull
    private static final String PREMISSION_INTERNET_CHANGE = "android.permission.CHANGE_NETWORK_STATE";

    @NotNull
    private static final String PREMISSION_INTERNET_GROUP = "stepos.permission-group.NETWORK";

    @Nullable
    private static Boolean sIsPoleStar;

    @Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0010\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\bR\u0010SJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004¢\u0006\u0004\b\u0013\u0010\u0014J)\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u00152\u0006\u0010\r\u001a\u00020\f2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\u001d\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u001c\u001a\u00020\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u001e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u001e\u0010\u001fJ\r\u0010 \u001a\u00020\u0002¢\u0006\u0004\b \u0010\u001dJ\u0015\u0010!\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b!\u0010\u001fJ\r\u0010\"\u001a\u00020\u0004¢\u0006\u0004\b\"\u0010#J%\u0010(\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\u00022\u0006\u0010'\u001a\u00020&¢\u0006\u0004\b(\u0010)J\u001d\u0010-\u001a\u00020,2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010+\u001a\u00020*¢\u0006\u0004\b-\u0010.J\r\u0010/\u001a\u00020\u0002¢\u0006\u0004\b/\u0010\u001dJ\u000f\u00100\u001a\u00020\u0004H\u0007¢\u0006\u0004\b0\u0010#J\u001d\u00102\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u00101\u001a\u00020\u0002¢\u0006\u0004\b2\u00103J%\u00108\u001a\u0012\u0012\u0004\u0012\u00020605j\b\u0012\u0004\u0012\u000206`72\u0006\u00104\u001a\u00020\u0002¢\u0006\u0004\b8\u00109J\u001f\u0010-\u001a\u00020,2\u0006\u0010\r\u001a\u00020\f2\b\u0010:\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b-\u0010;J\u001d\u0010<\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b<\u0010=J%\u0010A\u001a\u00020>2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010?\u001a\u00020>2\u0006\u0010@\u001a\u00020\u0002¢\u0006\u0004\bA\u0010BJ5\u0010E\u001a\u00020>2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010?\u001a\u00020>2\u0006\u0010C\u001a\u00020\u00042\u0006\u0010@\u001a\u00020\u00022\u0006\u0010D\u001a\u00020\u0002¢\u0006\u0004\bE\u0010FJ/\u0010I\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\b\u0010G\u001a\u0004\u0018\u00010\u00022\b\u0010H\u001a\u0004\u0018\u00010\u0002H\u0086@ø\u0001\u0000¢\u0006\u0004\bI\u0010JR\u0014\u0010K\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\bK\u0010LR\u0014\u0010M\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\bM\u0010LR\u0014\u0010N\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\bN\u0010LR\u0014\u0010O\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\bO\u0010LR\u0018\u0010P\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010Q\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006T"}, d2 = {"Lcom/stepos/policy/sdk/util/PolicySdkToolsUtils$Companion;", "", "", "permissionKey", "", "isNetWorkPermission", "(Ljava/lang/String;)Z", "str", "toUpperCaseFirstOne", "(Ljava/lang/String;)Ljava/lang/String;", "", "attrId", "Landroid/content/Context;", CoreConstants.CONTEXT_SCOPE_VALUE, "Landroid/util/TypedValue;", "obtainTypedValue", "(ILandroid/content/Context;)Landroid/util/TypedValue;", "firstCheck", "secondCheck", "getVerifyType", "(ZZ)Ljava/lang/String;", "", "getCustomPermissionKey", "(Landroid/content/Context;[Ljava/lang/String;)[Ljava/lang/String;", "path", "policyCategory", "checkPolicyCategoryIsSame", "(Ljava/lang/String;Ljava/lang/String;)Z", "getLanguage", "()Ljava/lang/String;", "getSystemModel", "(Landroid/content/Context;)Ljava/lang/String;", "getDeviceBrand", "getSystemVersion", "isPreAndroidP", "()Z", "appId", "appSecret", "", "reqTime", "getAppSign", "(Ljava/lang/String;Ljava/lang/String;J)Ljava/lang/String;", "Landroid/net/Uri;", "uri", "", "startBrowser", "(Landroid/content/Context;Landroid/net/Uri;)V", "getChannelToBrand", "isPolestar", "fileName", "checkFileExistsInAssets", "(Landroid/content/Context;Ljava/lang/String;)Z", "deleteJson", "Ljava/util/ArrayList;", "Lcom/stepos/policy/sdk/bean/DeleteInfoBean;", "Lkotlin/collections/ArrayList;", "getDeleteInfoBeanByGson", "(Ljava/lang/String;)Ljava/util/ArrayList;", MapBundleKey.MapObjKey.OBJ_URL, "(Landroid/content/Context;Ljava/lang/String;)V", "getIdentifierByAttrId", "(ILandroid/content/Context;)I", "Lstepos/support/v7/app/j;", "alertDialog", "checkButtonMessage", "initWithdrawalCleanDataOneCheckBox", "(Landroid/content/Context;Lstepos/support/v7/app/j;Ljava/lang/String;)Lstepos/support/v7/app/j;", "hasLogin", "secondCheckButtonMessage", "initWithdrawalCleanDataTwoCheckBox", "(Landroid/content/Context;Lstepos/support/v7/app/j;ZLjava/lang/String;Ljava/lang/String;)Lstepos/support/v7/app/j;", "newestPolicyPath", "localMd5", "isNeedSyncLocalFile", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "PREMISSION_INTERNET", "Ljava/lang/String;", "PREMISSION_INTERNET_ACCESS", "PREMISSION_INTERNET_CHANGE", "PREMISSION_INTERNET_GROUP", "sIsPoleStar", "Ljava/lang/Boolean;", "<init>", "()V", "policysdk_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void initWithdrawalCleanDataOneCheckBox$lambda$2(DialogInterfaceC0865j alertDialog, Context context, String checkButtonMessage, DialogInterface dialogInterface) {
            Intrinsics.checkNotNullParameter(alertDialog, "$alertDialog");
            Intrinsics.checkNotNullParameter(context, "$context");
            Intrinsics.checkNotNullParameter(checkButtonMessage, "$checkButtonMessage");
            Button button = alertDialog.getButton(-1);
            Intrinsics.checkNotNullExpressionValue(button, "alertDialog.getButton(Di…nterface.BUTTON_POSITIVE)");
            button.setBackground(androidx.core.content.a.b(context, R.drawable.policysdk_ic_withdrawal_btn_bg));
            button.setTextColor(androidx.core.content.b.a(context, PolicySdkToolsUtils.INSTANCE.getIdentifierByAttrId(R.attr.colorError, context)));
            View viewFindViewById = alertDialog.findViewById(R.id.stepos_permission_dialog_checkbox);
            Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.CheckBox");
            ((CheckBox) viewFindViewById).setVisibility(8);
            View viewFindViewById2 = alertDialog.findViewById(R.id.stepos_checkbox_layout_first);
            Intrinsics.checkNotNull(viewFindViewById2, "null cannot be cast to non-null type android.widget.LinearLayout");
            View viewFindViewById3 = alertDialog.findViewById(R.id.stepos_permission_dialog_checkbox_first);
            Intrinsics.checkNotNull(viewFindViewById3, "null cannot be cast to non-null type android.widget.CheckBox");
            CheckBox checkBox = (CheckBox) viewFindViewById3;
            View viewFindViewById4 = alertDialog.findViewById(R.id.stepos_permission_dialog_tv_first);
            Intrinsics.checkNotNull(viewFindViewById4, "null cannot be cast to non-null type android.widget.TextView");
            TextView textView = (TextView) viewFindViewById4;
            ((LinearLayout) viewFindViewById2).setVisibility(0);
            checkBox.setChecked(false);
            textView.setText(checkButtonMessage);
            textView.setOnClickListener(new c(checkBox, 0));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void initWithdrawalCleanDataOneCheckBox$lambda$2$lambda$1(CheckBox mzCheckboxFirst, View view) {
            Intrinsics.checkNotNullParameter(mzCheckboxFirst, "$mzCheckboxFirst");
            mzCheckboxFirst.performClick();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void initWithdrawalCleanDataTwoCheckBox$lambda$5(DialogInterfaceC0865j alertDialog, Context context, boolean z4, String checkButtonMessage, String secondCheckButtonMessage, DialogInterface dialogInterface) {
            Intrinsics.checkNotNullParameter(alertDialog, "$alertDialog");
            Intrinsics.checkNotNullParameter(context, "$context");
            Intrinsics.checkNotNullParameter(checkButtonMessage, "$checkButtonMessage");
            Intrinsics.checkNotNullParameter(secondCheckButtonMessage, "$secondCheckButtonMessage");
            Button button = alertDialog.getButton(-1);
            Intrinsics.checkNotNullExpressionValue(button, "alertDialog.getButton(Di…nterface.BUTTON_POSITIVE)");
            button.setBackground(androidx.core.content.a.b(context, R.drawable.policysdk_ic_withdrawal_btn_bg));
            button.setTextColor(androidx.core.content.b.a(context, PolicySdkToolsUtils.INSTANCE.getIdentifierByAttrId(R.attr.colorError, context)));
            View viewFindViewById = alertDialog.findViewById(R.id.stepos_permission_dialog_checkbox);
            Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.CheckBox");
            ((CheckBox) viewFindViewById).setVisibility(8);
            View viewFindViewById2 = alertDialog.findViewById(R.id.stepos_checkbox_layout_first);
            Intrinsics.checkNotNull(viewFindViewById2, "null cannot be cast to non-null type android.widget.LinearLayout");
            LinearLayout linearLayout = (LinearLayout) viewFindViewById2;
            View viewFindViewById3 = alertDialog.findViewById(R.id.stepos_permission_dialog_checkbox_first);
            Intrinsics.checkNotNull(viewFindViewById3, "null cannot be cast to non-null type android.widget.CheckBox");
            CheckBox checkBox = (CheckBox) viewFindViewById3;
            View viewFindViewById4 = alertDialog.findViewById(R.id.stepos_permission_dialog_tv_first);
            Intrinsics.checkNotNull(viewFindViewById4, "null cannot be cast to non-null type android.widget.TextView");
            TextView textView = (TextView) viewFindViewById4;
            if (z4) {
                linearLayout.setVisibility(0);
                checkBox.setChecked(false);
                textView.setText(checkButtonMessage);
                textView.setOnClickListener(new c(checkBox, 1));
            } else {
                linearLayout.setVisibility(8);
            }
            View viewFindViewById5 = alertDialog.findViewById(R.id.stepos_checkbox_layout_second);
            Intrinsics.checkNotNull(viewFindViewById5, "null cannot be cast to non-null type android.widget.LinearLayout");
            LinearLayout linearLayout2 = (LinearLayout) viewFindViewById5;
            View viewFindViewById6 = alertDialog.findViewById(R.id.stepos_permission_dialog_checkbox_second);
            Intrinsics.checkNotNull(viewFindViewById6, "null cannot be cast to non-null type android.widget.CheckBox");
            CheckBox checkBox2 = (CheckBox) viewFindViewById6;
            View viewFindViewById7 = alertDialog.findViewById(R.id.stepos_permission_dialog_tv_second);
            Intrinsics.checkNotNull(viewFindViewById7, "null cannot be cast to non-null type android.widget.TextView");
            TextView textView2 = (TextView) viewFindViewById7;
            checkBox2.setChecked(false);
            if (TextUtils.isEmpty(secondCheckButtonMessage)) {
                linearLayout2.setVisibility(8);
                return;
            }
            linearLayout2.setVisibility(0);
            textView2.setText(secondCheckButtonMessage);
            textView2.setOnClickListener(new c(checkBox2, 2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void initWithdrawalCleanDataTwoCheckBox$lambda$5$lambda$3(CheckBox mzCheckboxFirst, View view) {
            Intrinsics.checkNotNullParameter(mzCheckboxFirst, "$mzCheckboxFirst");
            mzCheckboxFirst.performClick();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void initWithdrawalCleanDataTwoCheckBox$lambda$5$lambda$4(CheckBox mzCheckboxSecond, View view) {
            Intrinsics.checkNotNullParameter(mzCheckboxSecond, "$mzCheckboxSecond");
            mzCheckboxSecond.performClick();
        }

        private final boolean isNetWorkPermission(String permissionKey) {
            return Intrinsics.areEqual(PolicySdkToolsUtils.PREMISSION_INTERNET_GROUP, permissionKey) || Intrinsics.areEqual(PolicySdkToolsUtils.PREMISSION_INTERNET, permissionKey) || Intrinsics.areEqual(PolicySdkToolsUtils.PREMISSION_INTERNET_CHANGE, permissionKey) || Intrinsics.areEqual(PolicySdkToolsUtils.PREMISSION_INTERNET_ACCESS, permissionKey);
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
                } catch (Exception e4) {
                    e4.printStackTrace();
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
            Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
            sb.append(strSubstring);
            String string = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string, "{\n                String….toString()\n            }");
            return string;
        }

        public final boolean checkFileExistsInAssets(@NotNull Context context, @NotNull String fileName) throws IOException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(fileName, "fileName");
            try {
                PolicySdkLogUtils.INSTANCE.d("checkFileExistsInAssets");
                AssetManager assets = context.getAssets();
                Intrinsics.checkNotNullExpressionValue(assets, "context.assets");
                String[] list = assets.list("");
                if (list != null) {
                    for (String str : list) {
                        if (Intrinsics.areEqual(str, fileName)) {
                            PolicySdkLogUtils.INSTANCE.d("checkFileExistsInAssets", "FileExists = true " + fileName);
                            return true;
                        }
                    }
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            PolicySdkLogUtils.INSTANCE.d("checkFileExistsInAssets", "FileExists = false " + fileName);
            return false;
        }

        public final boolean checkPolicyCategoryIsSame(@NotNull String path, @NotNull String policyCategory) {
            Intrinsics.checkNotNullParameter(path, "path");
            Intrinsics.checkNotNullParameter(policyCategory, "policyCategory");
            return StringsKt.c(path, policyCategory);
        }

        @NotNull
        public final String getAppSign(@NotNull String appId, @NotNull String appSecret, long reqTime) {
            Intrinsics.checkNotNullParameter(appId, "appId");
            Intrinsics.checkNotNullParameter(appSecret, "appSecret");
            String md5 = new SignServiceImpl().getSign(new SignDTO(appId, appSecret, Long.valueOf(reqTime)));
            Intrinsics.checkNotNullExpressionValue(md5, "md5");
            return md5;
        }

        @NotNull
        public final String getChannelToBrand() throws NoSuchMethodException, SecurityException {
            String str = null;
            try {
                if (AbstractC0770a.f13561a == null) {
                    Method declaredMethod = Build.class.getDeclaredMethod("getString", String.class);
                    AbstractC0770a.f13561a = declaredMethod;
                    declaredMethod.setAccessible(true);
                }
                str = (String) AbstractC0770a.f13561a.invoke(null, "ro.stepos.build.channel");
            } catch (Exception unused) {
            }
            try {
                Intrinsics.checkNotNullExpressionValue(str, "getSystemProperties(\"ro.stepos.build.channel\")");
                Log.d("getChannelToBrand", " channel = " + str);
                return !Intrinsics.areEqual("unknown", str) ? !TextUtils.isEmpty(str) ? str : "STEPOS" : "STEPOS";
            } catch (Exception e4) {
                Log.e("getChannelToBrand", " Exception" + e4.getMessage());
                return "STEPOS";
            }
        }

        @NotNull
        public final String[] getCustomPermissionKey(@NotNull Context context, @NotNull String[] permissionKey) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(permissionKey, "permissionKey");
            try {
                try {
                    PolicySdkLogUtils.INSTANCE.d("getCustomPermissionKey", "language = " + Locale.getDefault().getLanguage());
                    String language = Locale.getDefault().getLanguage();
                    Intrinsics.checkNotNullExpressionValue(language, "getDefault().language");
                    if (StringsKt.c(language, "en")) {
                        stepos.support.v7.permission.d dVarA = stepos.support.v7.permission.d.a(context);
                        List<stepos.support.v7.permission.c> listB = dVarA.b((String[]) dVarA.f14651b.keySet().toArray(new String[0]), true);
                        int length = permissionKey.length;
                        for (int i4 = 0; i4 < length; i4++) {
                            for (stepos.support.v7.permission.c cVar : listB) {
                                String str = permissionKey[i4];
                                String str2 = cVar.f14646b;
                                if (!Intrinsics.areEqual(str, str2)) {
                                    Iterator it = cVar.f14648d.iterator();
                                    while (it.hasNext()) {
                                        stepos.support.v7.permission.b bVar = (stepos.support.v7.permission.b) it.next();
                                        String str3 = permissionKey[i4];
                                        String str4 = bVar.f14643b;
                                        if (Intrinsics.areEqual(str3, str4) && !isNetWorkPermission(permissionKey[i4])) {
                                            PolicySdkPermissionManifestUtils policySdkPermissionManifestUtils = PolicySdkPermissionManifestUtils.INSTANCE;
                                            Intrinsics.checkNotNullExpressionValue(str4, "getSubPermission.identifier");
                                            String policyModifyPerKey = policySdkPermissionManifestUtils.getPolicyModifyPerKey(context, str4);
                                            if (Intrinsics.areEqual(policyModifyPerKey, str4)) {
                                                policyModifyPerKey = bVar.a();
                                                Intrinsics.checkNotNullExpressionValue(policyModifyPerKey, "getSubPermission.getDisplayName(context)");
                                            }
                                            PolicySdkLogUtils.INSTANCE.d("getCustomPermissionKey", " getSubPermission identifier = " + str4 + "  | displayName = " + policyModifyPerKey + "  ");
                                            permissionKey[i4] = toUpperCaseFirstOne(policyModifyPerKey);
                                        }
                                    }
                                } else if (!isNetWorkPermission(permissionKey[i4])) {
                                    PolicySdkPermissionManifestUtils policySdkPermissionManifestUtils2 = PolicySdkPermissionManifestUtils.INSTANCE;
                                    Intrinsics.checkNotNullExpressionValue(str2, "getPermissionGroup.identifier");
                                    String policyModifyPerKey2 = policySdkPermissionManifestUtils2.getPolicyModifyPerKey(context, str2);
                                    if (Intrinsics.areEqual(policyModifyPerKey2, str2)) {
                                        policyModifyPerKey2 = cVar.a(context);
                                        Intrinsics.checkNotNullExpressionValue(policyModifyPerKey2, "getPermissionGroup.getDisplayName(context)");
                                    }
                                    PolicySdkLogUtils.INSTANCE.d("getCustomPermissionKey", " getPermissionGroup identifier = " + str2 + "  | displayName = " + policyModifyPerKey2 + "  ");
                                    permissionKey[i4] = toUpperCaseFirstOne(policyModifyPerKey2);
                                }
                            }
                        }
                    }
                    return permissionKey;
                } catch (Exception e4) {
                    e4.printStackTrace();
                    return permissionKey;
                }
            } catch (Throwable unused) {
                return permissionKey;
            }
        }

        @NotNull
        public final ArrayList<DeleteInfoBean> getDeleteInfoBeanByGson(@NotNull String deleteJson) {
            Intrinsics.checkNotNullParameter(deleteJson, "deleteJson");
            Object objD = new n().d(deleteJson, new TypeToken<ArrayList<DeleteInfoBean>>() { // from class: com.stepos.policy.sdk.util.PolicySdkToolsUtils$Companion$getDeleteInfoBeanByGson$type$1
            }.getType());
            Intrinsics.checkNotNullExpressionValue(objD, "gson.fromJson(deleteJson, type)");
            ArrayList<DeleteInfoBean> arrayList = (ArrayList) objD;
            PolicySdkLogUtils.INSTANCE.d("getDeleteInfoBeanByGson", "deleteInfoList = " + arrayList);
            return arrayList;
        }

        @NotNull
        public final String getDeviceBrand() {
            String BRAND = Build.BRAND;
            Intrinsics.checkNotNullExpressionValue(BRAND, "BRAND");
            return BRAND;
        }

        public final int getIdentifierByAttrId(int attrId, @NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            TypedValue typedValueObtainTypedValue = obtainTypedValue(attrId, context);
            if (typedValueObtainTypedValue == null) {
                return 0;
            }
            return typedValueObtainTypedValue.resourceId;
        }

        @NotNull
        public final String getLanguage() {
            StringBuilder sb = new StringBuilder();
            String language = Locale.getDefault().getLanguage();
            Intrinsics.checkNotNullExpressionValue(language, "getDefault().language");
            String lowerCase = language.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
            sb.append(lowerCase);
            sb.append('_');
            String country = Locale.getDefault().getCountry();
            Intrinsics.checkNotNullExpressionValue(country, "getDefault().country");
            String upperCase = country.toUpperCase();
            Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase()");
            sb.append(upperCase);
            return sb.toString();
        }

        @NotNull
        public final String getSystemModel(@NotNull Context context) throws ClassNotFoundException, IllegalArgumentException {
            Intrinsics.checkNotNullParameter(context, "context");
            String str = PolicySdkSystemProperties.get(context, "ro.vendor.stepos.product.model");
            Intrinsics.checkNotNullExpressionValue(str, "get(context, modelKey)");
            return str;
        }

        @NotNull
        public final String getSystemVersion(@NotNull Context context) throws ClassNotFoundException, IllegalArgumentException {
            Intrinsics.checkNotNullParameter(context, "context");
            String str = PolicySdkSystemProperties.get(context, "ro.stepos.version.id", "");
            Intrinsics.checkNotNullExpressionValue(str, "get(context, \"ro.stepos.version.id\", \"\")");
            return str;
        }

        @NotNull
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

        @NotNull
        public final DialogInterfaceC0865j initWithdrawalCleanDataOneCheckBox(@NotNull final Context context, @NotNull final DialogInterfaceC0865j alertDialog, @NotNull final String checkButtonMessage) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(alertDialog, "alertDialog");
            Intrinsics.checkNotNullParameter(checkButtonMessage, "checkButtonMessage");
            try {
                alertDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.stepos.policy.sdk.util.d
                    @Override // android.content.DialogInterface.OnShowListener
                    public final void onShow(DialogInterface dialogInterface) {
                        PolicySdkToolsUtils.Companion.initWithdrawalCleanDataOneCheckBox$lambda$2(alertDialog, context, checkButtonMessage, dialogInterface);
                    }
                });
            } catch (Exception unused) {
            }
            return alertDialog;
        }

        @NotNull
        public final DialogInterfaceC0865j initWithdrawalCleanDataTwoCheckBox(@NotNull final Context context, @NotNull final DialogInterfaceC0865j alertDialog, final boolean hasLogin, @NotNull final String checkButtonMessage, @NotNull final String secondCheckButtonMessage) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(alertDialog, "alertDialog");
            Intrinsics.checkNotNullParameter(checkButtonMessage, "checkButtonMessage");
            Intrinsics.checkNotNullParameter(secondCheckButtonMessage, "secondCheckButtonMessage");
            try {
                alertDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.stepos.policy.sdk.util.b
                    @Override // android.content.DialogInterface.OnShowListener
                    public final void onShow(DialogInterface dialogInterface) {
                        PolicySdkToolsUtils.Companion.initWithdrawalCleanDataTwoCheckBox$lambda$5(alertDialog, context, hasLogin, checkButtonMessage, secondCheckButtonMessage, dialogInterface);
                    }
                });
            } catch (Exception unused) {
            }
            return alertDialog;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object isNeedSyncLocalFile(@org.jetbrains.annotations.NotNull android.content.Context r12, @org.jetbrains.annotations.Nullable java.lang.String r13, @org.jetbrains.annotations.Nullable java.lang.String r14, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Boolean> r15) {
            /*
                Method dump skipped, instructions count: 359
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.util.PolicySdkToolsUtils.Companion.isNeedSyncLocalFile(android.content.Context, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
        }

        @Deprecated(message = "没用了，只返回false")
        public final boolean isPolestar() {
            return false;
        }

        public final boolean isPreAndroidP() {
            return false;
        }

        public final void startBrowser(@NotNull Context context, @NotNull Uri uri) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(uri, "uri");
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
            } catch (Exception e4) {
                Log.e("startBrowser", "startBrowser: Exception" + e4.getMessage());
            }
        }

        public final void startBrowser(@NotNull Context context, @Nullable String url) {
            Intrinsics.checkNotNullParameter(context, "context");
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
