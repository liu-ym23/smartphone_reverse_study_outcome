package com.obric.privacy;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Process;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.GlobalProxyLancet;
import com.android.contacts.R;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.obric.oui.dialog.alert.OAlertDialog;
import com.obric.oui.dialog.alert.OAlertDialogBuilder;
import com.obric.oui.window.permission.PermissionPurposeWindow;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PermissionUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JC\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u000e\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007¢\u0006\u0002\u0010\u0014JE\u0010\t\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\r\u001a\u00020\u000e2\u000e\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007¢\u0006\u0002\u0010\u0017J\u001a\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0007J-\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040\u001e2\u0006\u0010\u0015\u001a\u00020\u00192\u0010\u0010\u001f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0002\u0010 J\u0012\u0010!\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020$H\u0007J+\u0010%\u001a\u0004\u0018\u00010\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00192\u0010\u0010\u001f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0010H\u0007¢\u0006\u0002\u0010&J\u001a\u0010'\u001a\u00020\n2\b\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010\r\u001a\u00020\u000eH\u0002J/\u0010*\u001a\u00020\u001c2\u0006\u0010\u000b\u001a\u00020\f2\u0010\u0010\u001f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00102\u0006\u0010+\u001a\u00020\u000eH\u0002¢\u0006\u0002\u0010,J1\u0010*\u001a\u00020\u001c2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0010\u0010\u001f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00102\u0006\u0010+\u001a\u00020\u000eH\u0002¢\u0006\u0002\u0010-J\u001a\u0010.\u001a\u00020\u001c2\b\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010\r\u001a\u00020\u000eH\u0007J'\u0010/\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u000e\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0010H\u0002¢\u0006\u0002\u00100J\u001c\u0010/\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u0004H\u0002J<\u00101\u001a\u00020\u001c2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00192\b\u00102\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u00103\u001a\u00020\n2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u0013J!\u00105\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00192\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0010¢\u0006\u0002\u00106J\u0016\u00107\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00192\u0006\u00108\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/obric/privacy/PermissionUtils;", "", "()V", "TAG", "", "ppw", "Lcom/obric/oui/window/permission/PermissionPurposeWindow;", "sDialog", "Lcom/obric/oui/dialog/alert/OAlertDialog;", "checkPermission", "", "fragment", "Landroidx/fragment/app/Fragment;", "reqCode", "", "perms", "", "guideMsg", "click", "Landroid/content/DialogInterface$OnClickListener;", "(Landroidx/fragment/app/Fragment;I[Ljava/lang/String;Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)Z", "activity", "Landroidx/fragment/app/FragmentActivity;", "(Landroidx/fragment/app/FragmentActivity;I[Ljava/lang/String;Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)Z", "checkSelfPermission", "Landroid/app/Activity;", CloudControlInf.PERMISSION, "dismissPermissionGuideDialog", "", "getDenyPerms", "", "permissions", "(Landroid/app/Activity;[Ljava/lang/String;)Ljava/util/List;", "getPermsKey", "granted", "results", "", "hasPermissions", "(Landroid/app/Activity;[Ljava/lang/String;)Ljava/lang/Boolean;", "isPermsUserSet", "context", "Landroid/content/Context;", "requestPermission", "requestCode", "(Landroidx/fragment/app/Fragment;[Ljava/lang/String;I)V", "(Landroidx/fragment/app/FragmentActivity;[Ljava/lang/String;I)V", "setPermsUserSet", "shouldShowRationale", "(Landroidx/fragment/app/FragmentActivity;[Ljava/lang/String;)Z", "showPermissionGuideDialog", NotificationCompat.CATEGORY_MESSAGE, "nativeFinished", "positiveButtonClick", "showRequestDialog", "(Landroid/app/Activity;[Ljava/lang/String;)Z", "startAppPermissionSettings", "appName", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PermissionUtils {
    public static final PermissionUtils INSTANCE = null;
    private static final String TAG = "PermissionUtils";
    private static PermissionPurposeWindow ppw;
    private static OAlertDialog sDialog;

    /* JADX INFO: renamed from: $r8$lambda$-k9ZfEq5vK5jUqxDo0gqHxaYgTA, reason: not valid java name */
    public static /* synthetic */ void m759$r8$lambda$k9ZfEq5vK5jUqxDo0gqHxaYgTA(DialogInterface.OnClickListener r0, Activity r1, boolean r2, DialogInterface r3, int r4) {
        showPermissionGuideDialog$lambda$8(r0, r1, r2, r3, r4);
    }

    static {
        INSTANCE = new PermissionUtils();
    }

    private final String getPermsKey(int r1) {
        switch(r1) {
            case 11: goto L6;
            case 12: goto L5;
            case 13: goto L4;
            default: goto L3;
        };
    L3:
        return null;
    L4:
        return PrivacyConstantsKt.KEY_RECORD_PERM_USERSET;
    L5:
        return PrivacyConstantsKt.KEY_PHOTO_PERM_USERSET;
    L6:
        return PrivacyConstantsKt.KEY_SMS_PERM_USERSET;
    }

    private PermissionUtils() {
    }

    public final boolean startAppPermissionSettings(Activity r6, String r7) {
        Intrinsics.checkNotNullParameter(r6, "activity");
        Intrinsics.checkNotNullParameter(r7, "appName");
        Intent r5 = new Intent("com.android.permissioncontroller.permissionplus.AppPermissionGroup");
        r5.putExtra("PACKAGE_NAME", "com.android.contacts");
        r5.putExtra("APP_NAME", r7);
        r6.startActivity(r5);     // Catch: Exception -> L5
        return true;
    L5:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(PrivacyConstantsKt.PRIVACY_TAG, "PermissionUtils#startAppPermissionSettings permissionplus unavailable, fallback to app details: " + e.getClass().getSimpleName());
        r6.startActivity(new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.fromParts("package", "com.android.contacts", null)));     // Catch: Exception -> L9
        return true;
    L9:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(PrivacyConstantsKt.PRIVACY_TAG, "PermissionUtils#startAppPermissionSettings fallback failed", e);
        return false;
    }

    public static /* synthetic */ boolean checkPermission$default(Fragment r0, int r1, String[] r2, String r3, DialogInterface.OnClickListener r4, int r5, Object r6) {
        if ((r5 & 16) == 0) goto L6;
        r4 = null;
    L6:
        return checkPermission(r0, r1, r2, r3, r4);
    }

    @JvmStatic
    public static final boolean checkPermission(Fragment r10, int r11, String[] r12, String r13, DialogInterface.OnClickListener r14) {
        Intrinsics.checkNotNullParameter(r10, "fragment");
        Intrinsics.checkNotNullParameter(r12, "perms");
        PermissionUtils r1 = INSTANCE;
        Boolean r0 = hasPermissions(r10.getActivity(), r12);
        if (r0 != null) goto L6;
        return false;
    L6:
        if (r0.booleanValue() == false) goto L8;
        return true;
    L8:
        if (r1.isPermsUserSet(r10.getContext(), r11) == true) goto L10;
    L13:
        r1.requestPermission(r10, r12, r11);
    L14:
        return false;
    L10:
        if (r1.shouldShowRationale(r10.getActivity(), r12) == true) goto L13;
        showPermissionGuideDialog$default(r1, r10.getActivity(), r13, false, r14, null, 16, null);
        goto L14
    }

    public static /* synthetic */ boolean checkPermission$default(FragmentActivity r0, int r1, String[] r2, String r3, DialogInterface.OnClickListener r4, int r5, Object r6) {
        if ((r5 & 16) == 0) goto L6;
        r4 = null;
    L6:
        return checkPermission(r0, r1, r2, r3, r4);
    }

    @JvmStatic
    public static final boolean checkPermission(FragmentActivity r10, int r11, String[] r12, String r13, DialogInterface.OnClickListener r14) {
        Intrinsics.checkNotNullParameter(r12, "perms");
        PermissionUtils r1 = INSTANCE;
        FragmentActivity r2 = r10;
        Boolean r0 = hasPermissions(r2, r12);
        if (r0 != null) goto L6;
        return false;
    L6:
        if (r0.booleanValue() == false) goto L8;
        return true;
    L8:
        if (r1.isPermsUserSet(r10, r11) == true) goto L10;
    L13:
        r1.requestPermission(r10, r12, r11);
    L14:
        return false;
    L10:
        if (r1.shouldShowRationale(r10, r12) == true) goto L13;
        showPermissionGuideDialog$default(r1, r2, r13, false, r14, null, 16, null);
        goto L14
    }

    @JvmStatic
    public static final Boolean hasPermissions(Activity r2, String[] r3) {
        if (r2 == null) goto L13;
        if (r3 == null) goto L18;
        Iterator r4 = ArrayIteratorKt.iterator(r3);
    L6:
        if (r4.hasNext() == false) goto L12;
        String r0 = (String) r4.next();
        if (INSTANCE.checkSelfPermission(r2, r0) != (-1)) goto L6;
        return false;
    L12:
        return true;
    L18:
        return null;
    L13:
        return null;
    }

    @JvmStatic
    public static final boolean granted(int[] r5) {
        Intrinsics.checkNotNullParameter(r5, "results");
        int r0 = r5.length;
        boolean r1 = false;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        if (r5[r2] == (-1)) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return false;
    L9:
        if (r5.length != 0) goto L12;
        r1 = true;
    L12:
        return !r1;
    }

    @JvmStatic
    public static final void setPermsUserSet(Context r1, int r2) {
        if (r1 == null) goto L9;
        String r3 = INSTANCE.getPermsKey(r2);
        if (TextUtils.isEmpty(r3) == true) goto L10;
        SharedPreferences r4 = PreferenceManager.getDefaultSharedPreferences(r1);
        if (r3 == null) goto L11;
        r4.edit().putBoolean(r3, true).apply();
        return;
    L11:
        return;
    L10:
        return;
    }

    private final void requestPermission(Fragment r1, String[] r2, int r3) {
        Intrinsics.checkNotNull(r2);
        r1.requestPermissions(r2, r3);
    }

    private final void requestPermission(FragmentActivity r2, String[] r3, int r4) {
        if (r2 == null) goto L5;
        r2.requestPermissions((String[]) getDenyPerms(r2, r3).toArray(new String[0]), r4);
        return;
    }

    private final List<String> getDenyPerms(Activity r5, String[] r6) {
        ArrayList r4 = new ArrayList();
        if (r6 == null) goto L12;
        int r0 = r6.length;
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L12;
        if (INSTANCE.checkSelfPermission(r5, r6[r1]) != (-1)) goto L11;
        String r2 = r6[r1];
        if (r2 == null) goto L11;
        r4.add(r2);
    L11:
        r1 = r1 + 1;
    L12:
        return r4;
    }

    private final boolean shouldShowRationale(FragmentActivity r7, String[] r8) {
        if (r7 != null) goto L5;
        return false;
    L5:
        int r1 = r8.length;
        int r3 = 0;
        boolean r4 = true;
    L6:
        if (r3 >= r1) goto L13;
        if (r4 == true) goto L9;
    L11:
        r4 = false;
    L12:
        r3 = r3 + 1;
        goto L6
    L9:
        if (checkSelfPermission(r7, r8[r3]) != 0) goto L11;
        r4 = true;
        goto L12
    L13:
        if (r4 == true) goto L22;
        List<String> r9 = getDenyPerms(r7, r8);
        int r2 = r9.size();
        int r5 = 0;
    L15:
        if (r5 >= r2) goto L20;
        if (shouldShowRationale(r7, r9.get(r5)) == true) goto L18;
        r5 = r5 + 1;
        goto L15
    L18:
        return true;
    L20:
        return false;
    L22:
        return !r4;
    }

    private final boolean shouldShowRationale(FragmentActivity r1, String r2) {
        if (r1 != null) goto L5;
        return false;
    L5:
        if (r2 != null) goto L8;
        return false;
    L8:
        return ActivityCompat.shouldShowRequestPermissionRationale(r1, r2);
    }

    private final int checkSelfPermission(Activity r2, String r3) {
        if (r3 == null) goto L6;
        return r2.checkPermission(r3, Process.myPid(), Process.myUid());
    L6:
        throw new IllegalArgumentException("permission is null".toString());
    }

    private final boolean isPermsUserSet(Context r2, int r3) {
        if (r2 == null) goto L10;
        String r1 = getPermsKey(r3);
        if (TextUtils.isEmpty(r1) == true) goto L10;
        SharedPreferences r4 = PreferenceManager.getDefaultSharedPreferences(r2);
        if (r1 == null) goto L10;
        return r4.getBoolean(r1, false);
    L10:
        return false;
    }

    public static /* synthetic */ void showPermissionGuideDialog$default(PermissionUtils r6, Activity r7, String r8, boolean r9, DialogInterface.OnClickListener r10, DialogInterface.OnClickListener r11, int r12, Object r13) {
        if ((r12 & 4) == 0) goto L5;
        r9 = false;
    L5:
        boolean r3 = r9;
        if ((r12 & 8) == 0) goto L8;
        DialogInterface.OnClickListener r4 = null;
    L10:
        if ((r12 & 16) == 0) goto L12;
        DialogInterface.OnClickListener r5 = null;
    L13:
        r6.showPermissionGuideDialog(r7, r8, r3, r4, r5);
        return;
    L12:
        r5 = r11;
        goto L13
    L8:
        r4 = r10;
        goto L10
    }

    public final void showPermissionGuideDialog(final Activity r8, String r9, final boolean r10, DialogInterface.OnClickListener r11, final DialogInterface.OnClickListener r12) {
        dismissPermissionGuideDialog();
        if (r8 != null) goto L5;
        return;
    L5:
        OAlertDialogBuilder r6 = new OAlertDialogBuilder(r8);
        r6.message(r9);
        r6.title(R.string.common_prompt);
        OAlertDialogBuilder.negativeButton$default(r6, R.string.common_cancel, r11, null, 4, null);
        OAlertDialogBuilder.positiveButton$default(r6, R.string.permission_guide_positive_button, new PermissionUtils$$ExternalSyntheticLambda0(r12, r8, r10), null, 4, null);
        r6.cancelable(false);
        OAlertDialog r7 = r6.build();
        sDialog = r7;
        if (r7 == null) goto L9;
        r7.show();
        return;
    }

    private static final void showPermissionGuideDialog$lambda$8(DialogInterface.OnClickListener r0, Activity r1, boolean r2, DialogInterface r3, int r4) {
        if (r0 == null) goto L4;
        r0.onClick(r3, r4);
    L4:
        PermissionUtils r5 = INSTANCE;
        String r6 = r1.getString(R.string.common_phone);
        Intrinsics.checkNotNullExpressionValue(r6, "activity.getString(R.string.common_phone)");
        if (r5.startAppPermissionSettings(r1, r6) == false) goto L9;
        if (r2 == false) goto L10;
        PrivacyUtils.finishApplication(r1);
        return;
    L10:
        return;
    }

    @JvmStatic
    public static final void dismissPermissionGuideDialog() {
        OAlertDialog r0 = sDialog;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        if (r1 == false) goto L11;
        OAlertDialog r2 = sDialog;
        if (r2 == null) goto L11;
        r2.dismiss();
    L11:
        sDialog = null;
        return;
    L5:
        if (r0.isShowing() != true) goto L7;
        r1 = true;
        goto L7
    }

    public final boolean showRequestDialog(Activity r4, String[] r5) {
        Intrinsics.checkNotNullParameter(r4, "activity");
        Intrinsics.checkNotNullParameter(r5, "permissions");
        int r3 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r3) goto L9;
        if (ActivityCompat.shouldShowRequestPermissionRationale(r4, r5[r1]) == true) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }
}
