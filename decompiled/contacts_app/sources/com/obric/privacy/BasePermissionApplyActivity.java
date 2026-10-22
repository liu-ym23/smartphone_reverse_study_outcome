package com.obric.privacy;

import android.content.DialogInterface;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import com.GlobalProxyLancet;
import com.android.contacts.R;
import com.android.contacts.util.UiUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.oui.dialog.alert.OAlertDialog;
import com.obric.oui.dialog.alert.OAlertDialogBuilder;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: compiled from: BasePermissionApplyActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\t\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J\b\u0010\f\u001a\u00020\bH\u0014J-\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\u000e\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0016¢\u0006\u0002\u0010\u0015J\b\u0010\u0016\u001a\u00020\bH\u0014J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0006H\u0016J\b\u0010\u0019\u001a\u00020\bH\u0002J\b\u0010\u001a\u001a\u00020\bH\u0002J\b\u0010\u001b\u001a\u00020\u0006H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/obric/privacy/BasePermissionApplyActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "dialog", "Lcom/obric/oui/dialog/alert/OAlertDialog;", "showPermissionDialogPending", "", "finish", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onRequestPermissionsResult", "requestCode", "", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onWindowFocusChanged", "hasFocus", "scheduleShowPermissionDialog", "showPermissionDialog", "showRequestDialog", "Companion", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BasePermissionApplyActivity extends AppCompatActivity {
    public static final Companion Companion = null;
    public static final int PERMISSION_REQUEST_CODE = 100;
    private static final String TAG = "BasePermissionApplyActivity";
    private OAlertDialog dialog;
    private boolean showPermissionDialogPending;

    /* JADX INFO: compiled from: BasePermissionApplyActivity.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/privacy/BasePermissionApplyActivity$Companion;", "", "()V", "PERMISSION_REQUEST_CODE", "", "TAG", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    public static /* synthetic */ void $r8$lambda$Sw9lOe3_niRAJW2n36vt9MHls8Y(BasePermissionApplyActivity r0) {
        scheduleShowPermissionDialog$lambda$0(r0);
    }

    public static /* synthetic */ void $r8$lambda$yFVhKYwLPbNxNrkrF9HcMJl3pJ4(BasePermissionApplyActivity r0, DialogInterface r1, int r2) {
        showPermissionDialog$lambda$1(r0, r1, r2);
    }

    static {
        Companion = new Companion(null);
    }

    public void com_obric_privacy_BasePermissionApplyActivity__onStop$___twin___() {
        super.onStop();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        com_obric_privacy_BasePermissionApplyActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    public BasePermissionApplyActivity() {
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        super.onCreate(r1);
        setContentView(R.layout.activity_permission_apply);
        overridePendingTransition(0, 0);
        UiUtils.setWindowColorStatusBar(this);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(PrivacyConstantsKt.PRIVACY_TAG, "BasePermissionApplyActivity#onCreate in permission process");
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        BasePermissionApplyActivity r0 = this;
        if (PrivacyUtils.hasBasePermission(r0) == false) goto L5;
        finish();
        PrivacyUtils.startBasePermissionApplyIfNeeded(r0);
        return;
    L5:
        PrivacyUtils.INSTANCE.onPermissionActivityOnResume(this);
        scheduleShowPermissionDialog();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean r1) {
        super.onWindowFocusChanged(r1);
        if (r1 == true) goto L5;
        return;
    L5:
        if (PrivacyUtils.hasBasePermission(this) == true) goto L9;
        scheduleShowPermissionDialog();
        return;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int r2, String[] r3, int[] r4) {
        Intrinsics.checkNotNullParameter(r3, "permissions");
        Intrinsics.checkNotNullParameter(r4, "grantResults");
        super.onRequestPermissionsResult(r2, r3, r4);
        if (r2 == 100) goto L5;
        return;
    L5:
        BasePermissionApplyActivity r5 = this;
        PermissionUtils.setPermsUserSet(r5, r2);
        if (PermissionUtils.granted(r4) == false) goto L8;
        finish();
        PrivacyUtils.startBasePermissionApplyIfNeeded(r5);
    L8:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(PrivacyConstantsKt.PRIVACY_TAG, "BasePermissionApplyActivity#onRequestPermissionsResult");
    }

    private final void scheduleShowPermissionDialog() {
        if (UiUtils.isUiFinishing(this) == true) goto L15;
        OAlertDialog r0 = this.dialog;
        boolean r1 = false;
        if (r0 != null) goto L7;
    L9:
        if (r1 == false) goto L11;
        return;
    L11:
        if (this.showPermissionDialogPending == true) goto L17;
        this.showPermissionDialogPending = true;
        getWindow().getDecorView().post(new BasePermissionApplyActivity$$ExternalSyntheticLambda0(this));
        return;
    L17:
        return;
    L7:
        if (r0.isShowing() != true) goto L9;
        r1 = true;
        goto L9
    }

    private static final void scheduleShowPermissionDialog$lambda$0(BasePermissionApplyActivity r3) {
        Intrinsics.checkNotNullParameter(r3, "this$0");
        boolean r0 = false;
        r3.showPermissionDialogPending = false;
        if (UiUtils.isUiFinishing(r3) == false) goto L5;
        return;
    L5:
        if (r3.hasWindowFocus() == false) goto L15;
        OAlertDialog r1 = r3.dialog;
        if (r1 != null) goto L9;
    L11:
        if (r0 == true) goto L16;
        r3.showPermissionDialog();
        return;
    L16:
        return;
    L9:
        if (r1.isShowing() != true) goto L11;
        r0 = true;
        goto L11
    }

    private final void showPermissionDialog() {
        if (showRequestDialog() == false) goto L5;
        String r0 = getString(R.string.permission_dialog_agree);
    L6:
        Intrinsics.checkNotNullExpressionValue(r0, "if (showRequestDialog())…ositive_button)\n        }");
        DialogInterface.OnClickListener r4 = new BasePermissionApplyActivity$$ExternalSyntheticLambda1(this);
        OAlertDialog r1 = this.dialog;
        boolean r2 = false;
        if (r1 != null) goto L9;
    L11:
        if (r2 == false) goto L15;
        OAlertDialog r3 = this.dialog;
        if (r3 == null) goto L15;
        r3.dismiss();
    L15:
        OAlertDialog r5 = OAlertDialogBuilder.positiveButton$default(new OAlertDialogBuilder(this).title(R.string.common_prompt).message(getString(R.string.permission_detail_message)), r0, r4, null, 4, null).negativeButton(R.string.common_cancel, new AnonymousClass1(this)).build();
        this.dialog = r5;
        if (r5 == null) goto L19;
        r5.show();
        return;
    L19:
        return;
    L9:
        if (r1.isShowing() != true) goto L11;
        r2 = true;
        goto L11
    L5:
        r0 = getString(R.string.permission_guide_positive_button);
        goto L6
    }

    private static final void showPermissionDialog$lambda$1(BasePermissionApplyActivity r7, DialogInterface r8, int r9) {
        Intrinsics.checkNotNullParameter(r7, "this$0");
        if (r7.showRequestDialog() == false) goto L5;
        List<String> r10 = PrivacyConstantsKt.getBasePermissionList();
        Intrinsics.checkNotNullExpressionValue(r10, "basePermissionList");
        PermissionUtils.checkPermission$default(r7, 100, (String[]) r10.toArray(new String[0]), r7.getString(R.string.permission_guide_base_msg), null, 16, null);
        return;
    L5:
        String r1 = r7.getString(R.string.common_phone);
        Intrinsics.checkNotNullExpressionValue(r1, "getString(R.string.common_phone)");
        if (PermissionUtils.INSTANCE.startAppPermissionSettings(r7, r1) == false) goto L10;
        PrivacyUtils.clearPermissionApplyCallback();
        r7.finish();
        System.exit(0);
        return;
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        OAlertDialog r0 = this.dialog;
        if (r0 == null) goto L5;
        r0.dismiss();
    L5:
        this.dialog = null;
        super.onDestroy();
    }

    private final boolean showRequestDialog() {
        List<String> r0 = PrivacyConstantsKt.getBasePermissionList();
        Intrinsics.checkNotNullExpressionValue(r0, "basePermissionList");
        Iterator<T> r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        BasePermissionApplyActivity r2 = this;
        if (ActivityCompat.shouldShowRequestPermissionRationale(r2, (String) r1.next()) == false) goto L4;
        return true;
    L9:
        return false;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_obric_privacy_BasePermissionApplyActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(BasePermissionApplyActivity r1) {
        r1.com_obric_privacy_BasePermissionApplyActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }
}
