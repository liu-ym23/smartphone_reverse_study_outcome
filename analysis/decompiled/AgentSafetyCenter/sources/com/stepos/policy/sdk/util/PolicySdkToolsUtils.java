package com.stepos.policy.sdk.util;

import ad.o;
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
import com.stepos.policy.sdk.R;
import com.stepos.policy.sdk.bean.DeleteInfoBean;
import hc.h;
import java.io.IOException;
import java.lang.invoke.VarHandle;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import stepos.support.v7.app.i;
import yb.f;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class PolicySdkToolsUtils {
    public static final Companion Companion = new Companion(null);
    private static final String PREMISSION_INTERNET = "android.permission.INTERNET";
    private static final String PREMISSION_INTERNET_ACCESS = "android.permission.ACCESS_NETWORK_STATE";
    private static final String PREMISSION_INTERNET_CHANGE = "android.permission.CHANGE_NETWORK_STATE";
    private static final String PREMISSION_INTERNET_GROUP = "stepos.permission-group.NETWORK";
    private static Boolean sIsPoleStar;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void initWithdrawalCleanDataOneCheckBox$lambda$2(i iVar, Context context, String str, DialogInterface dialogInterface) {
            iVar.getClass();
            context.getClass();
            str.getClass();
            Button button = iVar.getButton(-1);
            button.getClass();
            button.setBackground(context.getDrawable(R.drawable.policysdk_ic_withdrawal_btn_bg));
            button.setTextColor(context.getColor(PolicySdkToolsUtils.Companion.getIdentifierByAttrId(com.stepos.agentsafetycenter.R.attr.colorError, context)));
            View viewFindViewById = iVar.findViewById(R.id.stepos_permission_dialog_checkbox);
            viewFindViewById.getClass();
            ((CheckBox) viewFindViewById).setVisibility(8);
            View viewFindViewById2 = iVar.findViewById(R.id.stepos_checkbox_layout_first);
            viewFindViewById2.getClass();
            View viewFindViewById3 = iVar.findViewById(R.id.stepos_permission_dialog_checkbox_first);
            viewFindViewById3.getClass();
            CheckBox checkBox = (CheckBox) viewFindViewById3;
            View viewFindViewById4 = iVar.findViewById(R.id.stepos_permission_dialog_tv_first);
            viewFindViewById4.getClass();
            TextView textView = (TextView) viewFindViewById4;
            ((LinearLayout) viewFindViewById2).setVisibility(0);
            checkBox.setChecked(false);
            textView.setText(str);
            b bVar = new b(0);
            bVar.f2797f = checkBox;
            VarHandle.storeStoreFence();
            textView.setOnClickListener(bVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void initWithdrawalCleanDataOneCheckBox$lambda$2$lambda$1(CheckBox checkBox, View view) {
            checkBox.getClass();
            checkBox.performClick();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void initWithdrawalCleanDataTwoCheckBox$lambda$5(i iVar, Context context, boolean z10, String str, String str2, DialogInterface dialogInterface) {
            iVar.getClass();
            context.getClass();
            str.getClass();
            str2.getClass();
            Button button = iVar.getButton(-1);
            button.getClass();
            button.setBackground(context.getDrawable(R.drawable.policysdk_ic_withdrawal_btn_bg));
            button.setTextColor(context.getColor(PolicySdkToolsUtils.Companion.getIdentifierByAttrId(com.stepos.agentsafetycenter.R.attr.colorError, context)));
            View viewFindViewById = iVar.findViewById(R.id.stepos_permission_dialog_checkbox);
            viewFindViewById.getClass();
            ((CheckBox) viewFindViewById).setVisibility(8);
            View viewFindViewById2 = iVar.findViewById(R.id.stepos_checkbox_layout_first);
            viewFindViewById2.getClass();
            LinearLayout linearLayout = (LinearLayout) viewFindViewById2;
            View viewFindViewById3 = iVar.findViewById(R.id.stepos_permission_dialog_checkbox_first);
            viewFindViewById3.getClass();
            CheckBox checkBox = (CheckBox) viewFindViewById3;
            View viewFindViewById4 = iVar.findViewById(R.id.stepos_permission_dialog_tv_first);
            viewFindViewById4.getClass();
            TextView textView = (TextView) viewFindViewById4;
            if (z10) {
                linearLayout.setVisibility(0);
                checkBox.setChecked(false);
                textView.setText(str);
                b bVar = new b(1);
                bVar.f2797f = checkBox;
                VarHandle.storeStoreFence();
                textView.setOnClickListener(bVar);
            } else {
                linearLayout.setVisibility(8);
            }
            View viewFindViewById5 = iVar.findViewById(R.id.stepos_checkbox_layout_second);
            viewFindViewById5.getClass();
            LinearLayout linearLayout2 = (LinearLayout) viewFindViewById5;
            View viewFindViewById6 = iVar.findViewById(R.id.stepos_permission_dialog_checkbox_second);
            viewFindViewById6.getClass();
            CheckBox checkBox2 = (CheckBox) viewFindViewById6;
            View viewFindViewById7 = iVar.findViewById(R.id.stepos_permission_dialog_tv_second);
            viewFindViewById7.getClass();
            TextView textView2 = (TextView) viewFindViewById7;
            checkBox2.setChecked(false);
            if (TextUtils.isEmpty(str2)) {
                linearLayout2.setVisibility(8);
                return;
            }
            linearLayout2.setVisibility(0);
            textView2.setText(str2);
            b bVar2 = new b(2);
            bVar2.f2797f = checkBox2;
            VarHandle.storeStoreFence();
            textView2.setOnClickListener(bVar2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void initWithdrawalCleanDataTwoCheckBox$lambda$5$lambda$3(CheckBox checkBox, View view) {
            checkBox.getClass();
            checkBox.performClick();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void initWithdrawalCleanDataTwoCheckBox$lambda$5$lambda$4(CheckBox checkBox, View view) {
            checkBox.getClass();
            checkBox.performClick();
        }

        private final boolean isNetWorkPermission(String str) {
            return PolicySdkToolsUtils.PREMISSION_INTERNET_GROUP.equals(str) || PolicySdkToolsUtils.PREMISSION_INTERNET.equals(str) || PolicySdkToolsUtils.PREMISSION_INTERNET_CHANGE.equals(str) || PolicySdkToolsUtils.PREMISSION_INTERNET_ACCESS.equals(str);
        }

        private final TypedValue obtainTypedValue(int i, Context context) {
            Resources.Theme theme = context.getTheme();
            if (theme == null) {
                return null;
            }
            TypedValue typedValue = new TypedValue();
            try {
                try {
                    theme.resolveAttribute(i, typedValue, true);
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
            return Character.toUpperCase(str.charAt(0)) + str.substring(1);
        }

        public final boolean checkFileExistsInAssets(Context context, String str) throws IOException {
            context.getClass();
            str.getClass();
            try {
                PolicySdkLogUtils.Companion.d("checkFileExistsInAssets");
                AssetManager assets = context.getAssets();
                assets.getClass();
                String[] list = assets.list("");
                if (list != null) {
                    for (String str2 : list) {
                        if (k.a(str2, str)) {
                            PolicySdkLogUtils.Companion.d("checkFileExistsInAssets", "FileExists = true " + str);
                            return true;
                        }
                    }
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            PolicySdkLogUtils.Companion.d("checkFileExistsInAssets", "FileExists = false ".concat(str));
            return false;
        }

        public final boolean checkPolicyCategoryIsSame(String str, String str2) {
            str.getClass();
            str2.getClass();
            return h.X(str, str2, false);
        }

        public final String getAppSign(String str, String str2, long j10) {
            str.getClass();
            str2.getClass();
            Long lValueOf = Long.valueOf(j10);
            if (str.trim().equals("")) {
                od.f.o("appId不能为空！");
                return null;
            }
            if (str2.trim().equals("")) {
                od.f.o("appSecret不能为空！");
                return null;
            }
            String str3 = str + str2 + lValueOf;
            String[] strArr = gb.a.f4675a;
            try {
                String strA = gb.a.a(((MessageDigest) gb.a.f4676b.get()).digest(new String(str3).getBytes()));
                strA.getClass();
                return strA;
            } catch (Exception e10) {
                o.h(e10);
                return null;
            }
        }

        public final String getChannelToBrand() throws NoSuchMethodException, SecurityException {
            String str = null;
            try {
                if (u9.a.f14259a == null) {
                    Method declaredMethod = Build.class.getDeclaredMethod("getString", String.class);
                    u9.a.f14259a = declaredMethod;
                    declaredMethod.setAccessible(true);
                }
                str = (String) u9.a.f14259a.invoke(null, "ro.stepos.build.channel");
            } catch (Exception unused) {
            }
            try {
                str.getClass();
                Log.d("getChannelToBrand", " channel = ".concat(str));
                return !"unknown".equals(str) ? !TextUtils.isEmpty(str) ? str : "STEPOS" : "STEPOS";
            } catch (Exception e10) {
                Log.e("getChannelToBrand", " Exception" + e10.getMessage());
                return "STEPOS";
            }
        }

        public final String[] getCustomPermissionKey(Context context, String[] strArr) {
            Context context2 = context;
            String[] strArr2 = strArr;
            context2.getClass();
            strArr2.getClass();
            try {
                try {
                    PolicySdkLogUtils.Companion.d("getCustomPermissionKey", "language = " + Locale.getDefault().getLanguage());
                    String language = Locale.getDefault().getLanguage();
                    language.getClass();
                    int i = 0;
                    if (h.X(language, "en", false)) {
                        qe.d dVarA = qe.d.a(context2);
                        List<qe.c> listC = dVarA.c((String[]) dVarA.f10229b.keySet().toArray(new String[0]), true);
                        int length = strArr2.length;
                        int i3 = 0;
                        while (i3 < length) {
                            for (qe.c cVar : listC) {
                                String str = strArr2[i3];
                                String str2 = cVar.f10224f;
                                if (!k.a(str, str2)) {
                                    ArrayList arrayList = cVar.f10226h;
                                    int size = arrayList.size();
                                    int i10 = i;
                                    while (i10 < size) {
                                        Object obj = arrayList.get(i10);
                                        i10++;
                                        qe.b bVar = (qe.b) obj;
                                        String str3 = strArr2[i3];
                                        String str4 = bVar.f10221f;
                                        if (k.a(str3, str4) && !isNetWorkPermission(strArr2[i3])) {
                                            PolicySdkPermissionManifestUtils policySdkPermissionManifestUtils = PolicySdkPermissionManifestUtils.INSTANCE;
                                            str4.getClass();
                                            String policyModifyPerKey = policySdkPermissionManifestUtils.getPolicyModifyPerKey(context2, str4);
                                            if (k.a(policyModifyPerKey, str4)) {
                                                policyModifyPerKey = bVar.a();
                                                policyModifyPerKey.getClass();
                                            }
                                            PolicySdkLogUtils.Companion.d("getCustomPermissionKey", " getSubPermission identifier = " + str4 + "  | displayName = " + policyModifyPerKey + "  ");
                                            strArr[i3] = toUpperCaseFirstOne(policyModifyPerKey);
                                        }
                                        context2 = context;
                                        strArr2 = strArr;
                                        i = 0;
                                    }
                                    context2 = context;
                                    strArr2 = strArr;
                                } else if (!isNetWorkPermission(strArr2[i3])) {
                                    PolicySdkPermissionManifestUtils policySdkPermissionManifestUtils2 = PolicySdkPermissionManifestUtils.INSTANCE;
                                    str2.getClass();
                                    String policyModifyPerKey2 = policySdkPermissionManifestUtils2.getPolicyModifyPerKey(context2, str2);
                                    if (k.a(policyModifyPerKey2, str2)) {
                                        policyModifyPerKey2 = cVar.a(context2);
                                        policyModifyPerKey2.getClass();
                                    }
                                    PolicySdkLogUtils.Companion.d("getCustomPermissionKey", " getPermissionGroup identifier = " + str2 + "  | displayName = " + policyModifyPerKey2 + "  ");
                                    strArr2[i3] = toUpperCaseFirstOne(policyModifyPerKey2);
                                }
                            }
                            i3++;
                            context2 = context;
                            strArr2 = strArr;
                            i = 0;
                        }
                    }
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            } catch (Throwable unused) {
            }
            return strArr;
        }

        public final ArrayList<DeleteInfoBean> getDeleteInfoBeanByGson(String str) {
            str.getClass();
            Object objB = new m7.e().b(str, t7.a.get(new t7.a<ArrayList<DeleteInfoBean>>() { // from class: com.stepos.policy.sdk.util.PolicySdkToolsUtils$Companion$getDeleteInfoBeanByGson$type$1
            }.getType()));
            objB.getClass();
            ArrayList<DeleteInfoBean> arrayList = (ArrayList) objB;
            PolicySdkLogUtils.Companion.d("getDeleteInfoBeanByGson", "deleteInfoList = " + arrayList);
            return arrayList;
        }

        public final String getDeviceBrand() {
            String str = Build.BRAND;
            str.getClass();
            return str;
        }

        public final int getIdentifierByAttrId(int i, Context context) {
            context.getClass();
            TypedValue typedValueObtainTypedValue = obtainTypedValue(i, context);
            if (typedValueObtainTypedValue == null) {
                return 0;
            }
            return typedValueObtainTypedValue.resourceId;
        }

        public final String getLanguage() {
            StringBuilder sb2 = new StringBuilder();
            String language = Locale.getDefault().getLanguage();
            language.getClass();
            String lowerCase = language.toLowerCase();
            lowerCase.getClass();
            sb2.append(lowerCase);
            sb2.append('_');
            String country = Locale.getDefault().getCountry();
            country.getClass();
            String upperCase = country.toUpperCase();
            upperCase.getClass();
            sb2.append(upperCase);
            return sb2.toString();
        }

        public final String getSystemModel(Context context) throws ClassNotFoundException {
            context.getClass();
            String str = PolicySdkSystemProperties.get(context, "ro.vendor.stepos.product.model");
            str.getClass();
            return str;
        }

        public final String getSystemVersion(Context context) throws ClassNotFoundException {
            context.getClass();
            String str = PolicySdkSystemProperties.get(context, "ro.stepos.version.id", "");
            str.getClass();
            return str;
        }

        public final String getVerifyType(boolean z10, boolean z11) {
            String str;
            if (z10 && z11) {
                str = "3";
            } else {
                str = "0";
                if (z10 || z11) {
                    if (z10 && !z11) {
                        str = "2";
                    } else if (!z10 && z11) {
                        str = "1";
                    }
                }
            }
            PolicySdkLogUtils.Companion.d("getVerifyType", "verifyType = " + str + " | firstCheck " + z10 + " | secondCheck " + z11);
            return str;
        }

        public final i initWithdrawalCleanDataOneCheckBox(Context context, i iVar, String str) {
            context.getClass();
            iVar.getClass();
            str.getClass();
            try {
                c cVar = new c();
                cVar.f2798a = iVar;
                cVar.f2799b = context;
                cVar.f2800c = str;
                VarHandle.storeStoreFence();
                iVar.setOnShowListener(cVar);
            } catch (Exception unused) {
            }
            return iVar;
        }

        public final i initWithdrawalCleanDataTwoCheckBox(Context context, i iVar, boolean z10, String str, String str2) {
            context.getClass();
            iVar.getClass();
            str.getClass();
            str2.getClass();
            try {
                a aVar = new a();
                aVar.f2791a = iVar;
                aVar.f2792b = context;
                aVar.f2793c = z10;
                aVar.f2794d = str;
                aVar.f2795e = str2;
                VarHandle.storeStoreFence();
                iVar.setOnShowListener(aVar);
            } catch (Exception unused) {
            }
            return iVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object isNeedSyncLocalFile(android.content.Context r12, java.lang.String r13, java.lang.String r14, nb.c r15) {
            /*
                Method dump skipped, instructions count: 351
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.util.PolicySdkToolsUtils.Companion.isNeedSyncLocalFile(android.content.Context, java.lang.String, java.lang.String, nb.c):java.lang.Object");
        }

        @jb.a
        public final boolean isPolestar() {
            return false;
        }

        public final boolean isPreAndroidP() {
            return false;
        }

        public final void startBrowser(Context context, Uri uri) {
            context.getClass();
            uri.getClass();
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
            context.getClass();
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
