package com.obric.privacy;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.core.content.ContextCompat;
import com.android.contacts.R;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.immersive.Immersive;
import com.obric.oui.window.permission.PrivacyStatementActivity;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: compiled from: BasePrivacyStatementActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\tH\u0002J\b\u0010\n\u001a\u00020\u000bH\u0002J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014J\u0012\u0010\u0010\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0014J\b\u0010\u0013\u001a\u00020\rH\u0014J\b\u0010\u0014\u001a\u00020\u0006H\u0002J\b\u0010\u0015\u001a\u00020\rH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/obric/privacy/BasePrivacyStatementActivity;", "Lcom/obric/oui/window/permission/PrivacyStatementActivity;", "()V", "immersive", "Lcom/obric/immersive/Immersive;", "relaunchingForConfig", "", "canFinishSelfInOnCreateIfCallbackNotSet", "currentLocaleTag", "", "currentNightMode", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "onResume", "relaunchIfUiConfigChanged", "relaunchWithCurrentConfig", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BasePrivacyStatementActivity extends PrivacyStatementActivity {
    private final Immersive immersive;
    private boolean relaunchingForConfig;

    public static /* synthetic */ void $r8$lambda$fRCO4svC0813ygdXLXVqLrvw7f4(BasePrivacyStatementActivity r0) {
        relaunchWithCurrentConfig$lambda$0(r0);
    }

    @Override // com.obric.oui.window.permission.PrivacyStatementActivity
    public boolean canFinishSelfInOnCreateIfCallbackNotSet() {
        return false;
    }

    public void com_obric_privacy_BasePrivacyStatementActivity__onStop$___twin___() {
        super.onStop();
    }

    @Override // com.obric.oui.window.permission.PrivacyStatementActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        com_obric_privacy_BasePrivacyStatementActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    public BasePrivacyStatementActivity() {
        this.immersive = new Immersive(this);
    }

    @Override // com.obric.oui.window.permission.PrivacyStatementActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r2) {
        super.onCreate(null);
        if (relaunchIfUiConfigChanged() == false) goto L5;
        return;
    L5:
        int r3 = ContextCompat.getColor(this, R.color.oui_bg_base_1);
        this.immersive.setSystemBarColor(r3);
        this.immersive.setBackgroundColor(r3);
        this.immersive.setup();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    protected void onNewIntent(Intent r1) {
        super.onNewIntent(r1);
        setIntent(r1);
    }

    @Override // com.obric.oui.window.permission.PrivacyStatementActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (relaunchIfUiConfigChanged() == false) goto L5;
        return;
    L5:
        PrivacyUtils.INSTANCE.onPermissionActivityOnResume(this);
    }

    private final String currentLocaleTag() {
        Locale r1 = getResources().getConfiguration().getLocales().get(0);
        if (r1 == null) goto L5;
        String r2 = r1.toLanguageTag();
    L6:
        if (r2 != null) goto L9;
        return "und";
    L9:
        return r2;
    L5:
        r2 = null;
        goto L6
    }

    private final int currentNightMode() {
        return getResources().getConfiguration().uiMode & 48;
    }

    private final boolean relaunchIfUiConfigChanged() {
        String r0 = currentLocaleTag();
        Intent r1 = getIntent();
        if (r1 == null) goto L5;
        String r2 = r1.getStringExtra(PrivacyConstantsKt.EXTRA_PRIVACY_SHEET_LOCALE_TAG);
    L6:
        int r3 = currentNightMode();
        Intent r4 = getIntent();
        if (r4 == null) goto L9;
        int r5 = r4.getIntExtra(PrivacyConstantsKt.EXTRA_PRIVACY_SHEET_NIGHT_MODE, r3);
    L10:
        String r6 = r2;
        if (r6 != null) goto L13;
    L16:
        boolean r7 = true;
    L17:
        if (r7 == false) goto L19;
    L21:
        boolean r8 = false;
    L22:
        if (r5 == r3) goto L24;
        boolean r9 = true;
    L26:
        if (this.relaunchingForConfig == true) goto L32;
        if (r8 == true) goto L30;
        if (r9 == false) goto L32;
    L30:
        this.relaunchingForConfig = true;
        relaunchWithCurrentConfig();
        return true;
    L32:
        return false;
    L24:
        r9 = false;
        goto L26
    L19:
        if (Intrinsics.areEqual(r2, r0) == true) goto L21;
        r8 = true;
        goto L22
    L13:
        if (StringsKt.isBlank(r6) == true) goto L16;
        r7 = false;
        goto L17
    L9:
        r5 = r3;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    private final void relaunchWithCurrentConfig() {
        finish();
        new Handler(Looper.getMainLooper()).postDelayed(new BasePrivacyStatementActivity$$ExternalSyntheticLambda0(this), 200);
    }

    private static final void relaunchWithCurrentConfig$lambda$0(BasePrivacyStatementActivity r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Context r2 = r1.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(r2, "applicationContext");
        PrivacyUtils.startBasePermissionApplyIfNeeded(r2);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_obric_privacy_BasePrivacyStatementActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(BasePrivacyStatementActivity r1) {
        r1.com_obric_privacy_BasePrivacyStatementActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }
}
