package com.obric.privacy;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Handler;
import androidx.core.content.ContextCompat;
import com.GlobalProxyLancet;
import com.android.contacts.R;
import com.android.contacts.activities.DialtactsActivity;
import com.android.contacts.numberassistant.MarkInfoUtil;
import com.obric.appintents.IntentPrivacyHelper;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.matrix.platform.sdk.ones.producttype.ProductTypeUtils;
import com.obric.matrix.platform.sdk.ones.region.RegionUtil;
import com.obric.oui.privacy.PrivacyItem;
import com.obric.oui.window.permission.PrivacyStatementActivity;
import com.obric.settings.SettingsProviderHelper;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PrivacyUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0014\u001a\u00020\u0015J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u001c\u001a\u00020\u0015H\u0007J\u0010\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J\b\u0010\u001e\u001a\u00020\u0004H\u0007J\u001a\u0010\u001f\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010 \u001a\u0004\u0018\u00010!H\u0007J\u0010\u0010\"\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J\u0010\u0010#\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J\u0010\u0010$\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J\u0012\u0010%\u001a\u00020\r2\b\u0010 \u001a\u0004\u0018\u00010!H\u0007J\u000e\u0010&\u001a\u00020\u00152\u0006\u0010'\u001a\u00020(J\u0010\u0010)\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J\u0010\u0010*\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010+\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J\u001a\u0010+\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010,\u001a\u0004\u0018\u00010\u0007H\u0007J\u0010\u0010-\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J\u0010\u0010.\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0018\u0010/\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010 \u001a\u00020!H\u0007J\u001a\u00100\u001a\u00020\r2\b\u00101\u001a\u0004\u0018\u00010\u00042\u0006\u00102\u001a\u00020\rH\u0002J\u0010\u00103\u001a\u00020\u00152\u0006\u00104\u001a\u00020\rH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\u0004\u0018\u00010\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\t¨\u00065"}, d2 = {"Lcom/obric/privacy/PrivacyUtils;", "", "()V", "PRIVACY_URL", "", "TEDDY_PRIVACY_URL", "applicationInitCallback", "Ljava/lang/Runnable;", "getApplicationInitCallback", "()Ljava/lang/Runnable;", "setApplicationInitCallback", "(Ljava/lang/Runnable;)V", "isUseIntents", "", "()Z", "setUseIntents", "(Z)V", "<set-?>", "permissionApplyCallback", "getPermissionApplyCallback", "applicationInit", "", "basePermissionActivityFinished", "context", "Landroid/content/Context;", "buildPrivacySheetItems", "", "Lcom/obric/oui/privacy/PrivacyItem;", "clearPermissionApplyCallback", "finishApplication", "getPrivacyPolicyUrl", "grantUriPermission", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "hasBasePermission", "hasBasePermissionAndAgree", "isPrivacyDialogAgree", "isPrivacyPermissionIntent", "onPermissionActivityOnResume", "activity", "Landroid/app/Activity;", "setPrivacyDialogAgree", "startBasePermissionApply", "startBasePermissionApplyIfNeeded", "callback", "startDialtactsActivity", "startPrivacyDialogIfNeeded", "startPrivacyFlowHomeWithoutAnimation", "typeISVcf", "type", "isNfc", "updateActionResult", "useIntents", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PrivacyUtils {
    public static final PrivacyUtils INSTANCE = null;
    private static final String PRIVACY_URL = "https://os.oceancloudapi.com/agreement/contacts_privacy";
    private static final String TEDDY_PRIVACY_URL = "https://os.obriccloud.com/agreement/phone_privacy";
    private static Runnable applicationInitCallback;
    private static boolean isUseIntents;
    private static Runnable permissionApplyCallback;

    /* JADX INFO: renamed from: com.obric.privacy.PrivacyUtils$startPrivacyDialogIfNeeded$1, reason: invalid class name */
    /* JADX INFO: compiled from: PrivacyUtils.kt */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0002\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"com/obric/privacy/PrivacyUtils$startPrivacyDialogIfNeeded$1", "Lcom/obric/oui/window/permission/PrivacyStatementActivity$PrivacyConsentCallback;", "onAgree", "", "", "activity", "Landroid/app/Activity;", "onCancel", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class AnonymousClass1 implements PrivacyStatementActivity.PrivacyConsentCallback {
        /* JADX INFO: renamed from: $r8$lambda$aeXHFXkpkxQMN-iaEtAsVc8aaso, reason: not valid java name */
        public static /* synthetic */ void m760$r8$lambda$aeXHFXkpkxQMNiaEtAsVc8aaso(Activity r0) {
            onAgree$lambda$0(r0);
        }

        @Override // com.obric.oui.window.permission.PrivacyStatementActivity.PrivacyConsentCallback
        public void onAgree() {
        }

        @Override // com.obric.oui.window.permission.PrivacyStatementActivity.PrivacyConsentCallback
        public void onCancel() {
        }

        AnonymousClass1() {
        }

        @Override // com.obric.oui.window.permission.PrivacyStatementActivity.PrivacyConsentCallback
        public boolean onAgree(final Activity r4) {
            Intrinsics.checkNotNullParameter(r4, "activity");
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(PrivacyConstantsKt.PRIVACY_TAG, "BasePrivacyStatementActivity agree");
            PrivacyUtils.setPrivacyDialogAgree(r4);
            new Handler().postDelayed(new PrivacyUtils$startPrivacyDialogIfNeeded$1$$ExternalSyntheticLambda0(r4), 140);
            return false;
        }

        private static final void onAgree$lambda$0(Activity r1) {
            Intrinsics.checkNotNullParameter(r1, "$activity");
            PrivacyUtils.startBasePermissionApplyIfNeeded(r1);
        }

        @Override // com.obric.oui.window.permission.PrivacyStatementActivity.PrivacyConsentCallback
        public boolean onCancel(Activity r2) {
            Intrinsics.checkNotNullParameter(r2, "activity");
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(PrivacyConstantsKt.PRIVACY_TAG, "BasePrivacyStatementActivity disagreed");
            PrivacyUtils.clearPermissionApplyCallback();
            r2.overridePendingTransition(0, 0);
            r2.finish();
            return false;
        }
    }

    static {
        INSTANCE = new PrivacyUtils();
    }

    private PrivacyUtils() {
    }

    public final Runnable getApplicationInitCallback() {
        return applicationInitCallback;
    }

    public final void setApplicationInitCallback(Runnable r1) {
        applicationInitCallback = r1;
    }

    public final Runnable getPermissionApplyCallback() {
        return permissionApplyCallback;
    }

    public final boolean isUseIntents() {
        return isUseIntents;
    }

    public final void setUseIntents(boolean r1) {
        isUseIntents = r1;
    }

    @JvmStatic
    public static final void startPrivacyFlowHomeWithoutAnimation(Context r1, Intent r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, MemorySourceLinkType.INTENT);
        Intent r0 = new Intent(r2);
        r0.addFlags(65536);
        r1.startActivity(r0);
        if ((r1 instanceof Activity) == false) goto L6;
        ((Activity) r1).overridePendingTransition(0, 0);
        return;
    }

    @JvmStatic
    public static final void startBasePermissionApplyIfNeeded(Context r3, Runnable r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(PrivacyConstantsKt.PRIVACY_TAG, "startBasePermissionApplyIfNeeded called");
        PrivacyUtils r0 = INSTANCE;
        if (hasBasePermissionAndAgree(r3) == false) goto L10;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(PrivacyConstantsKt.PRIVACY_TAG, "startBasePermissionApplyIfNeeded hasBasePermissionAndAgree");
        r0.applicationInit();
        if (isUseIntents == false) goto L7;
        IntentPrivacyHelper.INSTANCE.updateResult(r3);
    L8:
        updateActionResult(false);
        clearPermissionApplyCallback();
        return;
    L7:
        r0.basePermissionActivityFinished(r3);
        goto L8
    L10:
        permissionApplyCallback = r4;
        if (isPrivacyDialogAgree(r3) == true) goto L15;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(PrivacyConstantsKt.PRIVACY_TAG, "startBasePermissionApplyIfNeeded not agree");
        r0.startPrivacyDialogIfNeeded(r3);
        return;
    L15:
        if (hasBasePermission(r3) == true) goto L18;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(PrivacyConstantsKt.PRIVACY_TAG, "startBasePermissionApplyIfNeeded not hasBasePermission");
        r0.startBasePermissionApply(r3);
        return;
    }

    @JvmStatic
    public static final void startBasePermissionApplyIfNeeded(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "context");
        startBasePermissionApplyIfNeeded(r1, permissionApplyCallback);
    }

    @JvmStatic
    public static final String getPrivacyPolicyUrl() {
        if (RegionUtil.INSTANCE.isCN() == true) goto L5;
    L9:
        return PRIVACY_URL;
    L5:
        if (ProductTypeUtils.INSTANCE.isNerida() == false) goto L7;
    L8:
        return TEDDY_PRIVACY_URL;
    L7:
        if (ProductTypeUtils.INSTANCE.isPike() == false) goto L9;
        goto L8
    }

    @JvmStatic
    public static final boolean isPrivacyPermissionIntent(Intent r1) {
        if (r1 == null) goto L4;
        String r2 = r1.getAction();
    L6:
        return Intrinsics.areEqual(r2, PrivacyConstantsKt.ACTION_PERMISSION_APPLY);
    L4:
        r2 = null;
        goto L6
    }

    @JvmStatic
    public static final void finishApplication(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "context");
        updateActionResult(false);
        clearPermissionApplyCallback();
        Object r2 = r1.getSystemService("activity");
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type android.app.ActivityManager");
        Iterator<ActivityManager.AppTask> r3 = ((ActivityManager) r2).getAppTasks().iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        r3.next().finishAndRemoveTask();
        goto L4
    }

    @JvmStatic
    public static final boolean hasBasePermission(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        List<String> r0 = PrivacyConstantsKt.getBasePermissionList();
        Intrinsics.checkNotNullExpressionValue(r0, "basePermissionList");
        List<String> r1 = r0;
        boolean r2 = true;
        if ((r1 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r3 = r1.iterator();
    L9:
        if (r3.hasNext() == false) goto L16;
        if (ContextCompat.checkSelfPermission(r4, (String) r3.next()) != 0) goto L13;
        boolean r5 = true;
    L14:
        if (r5 == true) goto L9;
        r2 = false;
        goto L16
    L13:
        r5 = false;
    L16:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(PrivacyConstantsKt.PRIVACY_TAG, "hasBasePermission called res " + r2);
        return r2;
    L5:
        if (r1.isEmpty() == false) goto L7;
        goto L7
    }

    private final void basePermissionActivityFinished(Context r2) {
        applicationInit();
        Runnable r1 = permissionApplyCallback;
        permissionApplyCallback = null;
        if (r1 != null) goto L5;
        startDialtactsActivity(r2);
        return;
    L5:
        r1.run();
    }

    @JvmStatic
    public static final void startDialtactsActivity(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intent r0 = new Intent(r2, DialtactsActivity.class);
        r0.addFlags(268435456);
        startPrivacyFlowHomeWithoutAnimation(r2, r0);
    }

    public final void applicationInit() {
        Runnable r0 = applicationInitCallback;
        if (r0 == null) goto L5;
        r0.run();
    L5:
        applicationInitCallback = null;
    }

    @JvmStatic
    public static final void clearPermissionApplyCallback() {
        permissionApplyCallback = null;
    }

    @JvmStatic
    public static final void setPrivacyDialogAgree(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(PrivacyConstantsKt.PRIVACY_TAG, "setPrivacyDialogAgree called");
        SettingsProviderHelper.INSTANCE.setContactsPrivacyDialogAgree(r2);
    }

    @JvmStatic
    public static final boolean isPrivacyDialogAgree(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        boolean r3 = SettingsProviderHelper.INSTANCE.getContactsPrivacyDialogAgree(r2);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(PrivacyConstantsKt.PRIVACY_TAG, "isPrivacyDialogAgree res = " + r3);
        return r3;
    }

    @JvmStatic
    public static final boolean hasBasePermissionAndAgree(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "context");
        if (hasBasePermission(r1) == true) goto L5;
    L7:
        return false;
    L5:
        if (isPrivacyDialogAgree(r1) == false) goto L7;
        return true;
    }

    @JvmStatic
    public static final void grantUriPermission(Context r4, Intent r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        if (r5 != null) goto L5;
        return;
    L5:
        Uri r0 = r5.getData();
        if (r0 != null) goto L8;
        return;
    L8:
        String r1 = r5.getType();
        if (r1 != null) goto L11;
        return;
    L11:
        String r6 = r5.getAction();
        if (r6 != null) goto L15;
        return;
    L15:
        if (INSTANCE.typeISVcf(r1, Intrinsics.areEqual(r6, "android.nfc.action.NDEF_DISCOVERED")) == false) goto L29;
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L18
        r4.grantUriPermission(r4.getPackageName(), r0, 1);     // Catch: Throwable -> L18
        Object r8 = Result.m803constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L18
    L20:
        Throwable r9 = Result.m806exceptionOrNullimpl(r8);
        if (r9 == null) goto L24;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(PrivacyConstantsKt.PRIVACY_TAG, "grantUriPermission, onFailure", r9);
    L24:
        if (Result.m810isSuccessimpl(r8) == false) goto L30;
        Unit r10 = (Unit) r8;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(PrivacyConstantsKt.PRIVACY_TAG, "grantUriPermission success");
        return;
    L30:
        return;
    L18:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r8 = Result.m803constructorimpl(ResultKt.createFailure(th));
        goto L20
    }

    private final boolean typeISVcf(String r1, boolean r2) {
        if (Intrinsics.areEqual(r1, "text/x-vCard") == false) goto L5;
    L13:
        return true;
    L5:
        if (Intrinsics.areEqual(r1, "text/x-vcard") == true) goto L13;
        if (Intrinsics.areEqual(r1, "text/vcard") == true) goto L13;
        if (r2 == false) goto L10;
    L12:
        return false;
    L10:
        if (Intrinsics.areEqual(r1, "text/directory") == false) goto L12;
        goto L12
    }

    @JvmStatic
    public static final void updateActionResult(boolean r0) {
        isUseIntents = r0;
    }

    public final void onPermissionActivityOnResume(Activity r5) {
        Intrinsics.checkNotNullParameter(r5, "activity");
        if (isUseIntents == true) goto L22;
        return;
    L22:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L16
        KeyguardManager r2 = (KeyguardManager) r5.getApplicationContext().getSystemService("keyguard");     // Catch: Throwable -> L16
        StringBuilder r3 = new StringBuilder("onPermissionActivityOnCreate, isKeyguardLocked: ");     // Catch: Throwable -> L16
        if (r2 == null) goto L8;
        Boolean r4 = Boolean.valueOf(r2.isKeyguardLocked());     // Catch: Throwable -> L16
    L9:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(PrivacyConstantsKt.PRIVACY_TAG, r3.append(r4).toString());     // Catch: Throwable -> L16
        if (r2 != null) goto L12;
    L14:
        Object r6 = Result.m803constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L16
    L18:
        Throwable r7 = Result.m806exceptionOrNullimpl(r6);
        if (r7 == null) goto L24;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(PrivacyConstantsKt.PRIVACY_TAG, "onPermissionActivityOnCreate, onFailure", r7);
        return;
    L24:
        return;
    L12:
        if (r2.isKeyguardLocked() == false) goto L14;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(PrivacyConstantsKt.PRIVACY_TAG, "onPermissionActivityOnCreate, isKeyguardLocked true, do requestDismissKeyguard");     // Catch: Throwable -> L16
        r2.requestDismissKeyguard(r5, null);     // Catch: Throwable -> L16
        goto L14
    L8:
        r4 = null;
    L16:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        r6 = Result.m803constructorimpl(ResultKt.createFailure(th));
        goto L18
    }

    private final void startPrivacyDialogIfNeeded(Context r8) {
        Configuration r0 = r8.getResources().getConfiguration();
        Locale r1 = r0.getLocales().get(0);
        if (r1 == null) goto L5;
        String r2 = r1.toLanguageTag();
    L6:
        if (r2 != null) goto L8;
        r2 = "und";
    L8:
        int r3 = r0.uiMode & 48;
        PrivacyStatementActivity.Companion.Builder r4 = new PrivacyStatementActivity.Companion.Builder(r8);
        String r5 = r8.getString(R.string.common_phone);
        Intrinsics.checkNotNullExpressionValue(r5, "context.getString(R.string.common_phone)");
        PrivacyStatementActivity.Companion.Builder r6 = r4.setTitle(r5);
        String r7 = r8.getString(R.string.privacy_subtitle);
        Intrinsics.checkNotNullExpressionValue(r7, "context.getString(R.string.privacy_subtitle)");
        PrivacyStatementActivity.Companion.Builder r9 = r6.setDescription(r7).setPrivacyUrls(new String[]{getPrivacyPolicyUrl()});
        String r10 = r8.getString(R.string.privacy_policy_prompt);
        Intrinsics.checkNotNullExpressionValue(r10, "context.getString(R.string.privacy_policy_prompt)");
        PrivacyStatementActivity.Companion.Builder r11 = r9.setPrivacyText(r10).setPrivacyPolicyLinkTexts(CollectionsKt.listOf(r8.getString(R.string.privacy_policy_link_text))).setItems(buildPrivacySheetItems(r8)).setConsentCallback(new AnonymousClass1());
        Intent r12 = new Intent(r8, BasePrivacyStatementActivity.class);
        r12.addFlags(268435456);
        r12.addFlags(67108864);
        r12.putExtra(PrivacyConstantsKt.EXTRA_PRIVACY_SHEET_LOCALE_TAG, r2);
        r12.putExtra(PrivacyConstantsKt.EXTRA_PRIVACY_SHEET_NIGHT_MODE, r3);
        PrivacyStatementActivity.Companion.Builder.show$default(r11, r12, null, 2, null);
        return;
    L5:
        r2 = null;
        goto L6
    }

    private final List<PrivacyItem> buildPrivacySheetItems(Context r5) {
        String r0 = r5.getString(R.string.privacy_permission_desc);
        Intrinsics.checkNotNullExpressionValue(r0, "context.getString(R.stri….privacy_permission_desc)");
        return CollectionsKt.listOf(new PrivacyItem.PermissionItem(r0, CollectionsKt.listOf(new String[]{r5.getString(R.string.privacy_permission_call_log), r5.getString(R.string.privacy_permission_contacts), r5.getString(R.string.common_make_phone_calls), r5.getString(R.string.privacy_permission_record_audio), r5.getString(R.string.privacy_permission_sms), r5.getString(R.string.privacy_permission_device_id), r5.getString(R.string.privacy_permission_media), r5.getString(R.string.privacy_permission_phone_number), r5.getString(R.string.privacy_permission_notifications), r5.getString(R.string.privacy_permission_camera), r5.getString(R.string.privacy_permission_location)})));
    }

    private final void startBasePermissionApply(Context r3) {
        boolean r2 = r3 instanceof Activity;
        Intent r0 = new Intent(r3, BasePermissionApplyActivity.class);
        if (r2 == true) goto L5;
        r0.addFlags(268435456);
    L5:
        r0.addFlags(MarkInfoUtil.MARK_CLASSIFY_ZTE_BLACKLIST);
        r3.startActivity(r0);
    }
}
