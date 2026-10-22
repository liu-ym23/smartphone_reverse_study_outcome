package com.bytedanceos.common.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import androidx.activity.ComponentActivity;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.R$color;
import com.bytedanceos.common.privacy.PrivacyChecker;
import com.bytedanceos.common.privacy.PrivacyUtils;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.common.oea.style.scene.transition.TransitionAnimStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rH\u0002¨\u0006\u0011"}, d2 = {"Lcom/bytedanceos/common/ui/JumpActivity;", "Landroidx/activity/ComponentActivity;", "()V", "checkShouldShowPrivacyDialog", "", "doJump", "initFullscreenPrivacyWindow", "initWindow", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "shouldKeepFullscreenForPrivacy", "", "Companion", "appstorecommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nJumpActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JumpActivity.kt\ncom/bytedanceos/common/ui/JumpActivity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,114:1\n1#2:115\n*E\n"})
public final class JumpActivity extends ComponentActivity {

    @NotNull
    public static final String ARG_KEEP_FULLSCREEN_FOR_PRIVACY = "keep_fullscreen_for_privacy";

    @NotNull
    public static final String ARG_OVERRIDE_ENTER_ANIM = "override_enter_anim";

    @NotNull
    public static final String ARG_USER_AGREEMENT_ONLY = "user_agreement_only";

    @NotNull
    public static final Companion Companion = null;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/bytedanceos/common/ui/JumpActivity$Companion;", "", "()V", "ARG_KEEP_FULLSCREEN_FOR_PRIVACY", "", "ARG_OVERRIDE_ENTER_ANIM", "ARG_USER_AGREEMENT_ONLY", "appstorecommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public JumpActivity() {
    }

    private final void checkShouldShowPrivacyDialog() {
        boolean r10 = getIntent().getBooleanExtra(ARG_OVERRIDE_ENTER_ANIM, false);
        PrivacyUtils r11 = PrivacyUtils.f9901a;
        PrivacyChecker.Observer r12 = new k(this);
        if (r10 == false) goto L5;
        TransitionAnimStyle r13 = TransitionAnimStyle.Standard;
    L6:
        r11.g(this, r12, r13);
        return;
    L5:
        r13 = null;
        goto L6
    }

    private static final void checkShouldShowPrivacyDialog$lambda$1(JumpActivity r10) {
        q.g(r10, "this$0");
        r10.doJump();
    }

    private final void doJump() {
        if (getIntent().getBooleanExtra(ARG_USER_AGREEMENT_ONLY, false) == false) goto L7;
        finish();
        return;
    L7:
        if (com.bytedanceos.common.utils.c.o(this) == true) goto L9;
        com.bytedanceos.common.utils.c.q(this, true);
        com.bytedanceos.common.toolbox.j.n("Jump into " + BaseApplication.c().getAppName() + " fail: " + getIntent());
    L9:
        finish();
    }

    public static /* synthetic */ void i(JumpActivity r10) {
        checkShouldShowPrivacyDialog$lambda$1(r10);
    }

    private final void initFullscreenPrivacyWindow() {
        Window r10 = getWindow();
        r10.setGravity(0);
        int r11 = R$color.oui_bg_base_1;
        r10.setStatusBarColor(getColor(r11));
        r10.setNavigationBarColor(getColor(r11));
        WindowManager.LayoutParams r12 = r10.getAttributes();
        r12.x = 0;
        r12.y = 0;
        r12.height = -1;
        r12.width = -1;
        r10.setAttributes(r12);
    }

    private final void initWindow() {
        Window r10 = getWindow();
        r10.setGravity(51);
        WindowManager.LayoutParams r11 = r10.getAttributes();
        r11.x = 0;
        r11.y = 0;
        r11.height = 1;
        r11.width = 1;
        r10.setAttributes(r11);
    }

    private final boolean shouldKeepFullscreenForPrivacy(Intent r10) {
        if (r10.hasExtra(ARG_KEEP_FULLSCREEN_FOR_PRIVACY) == false) goto L6;
        return r10.getBooleanExtra(ARG_KEEP_FULLSCREEN_FOR_PRIVACY, false);
    L6:
        if (((Boolean) PrivacyUtils.f9901a.j().getValue()).booleanValue() == true) goto L10;
        return true;
    L10:
        return false;
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle r10) {
        super.onCreate(r10);
        Intent r11 = getIntent();
        q.f(r11, "getIntent(...)");
        if (shouldKeepFullscreenForPrivacy(r11) == false) goto L5;
        initFullscreenPrivacyWindow();
    L6:
        checkShouldShowPrivacyDialog();
        return;
    L5:
        initWindow();
        goto L6
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(@Nullable Intent r10) {
        super.onNewIntent(r10);
        if (r10 == null) goto L5;
        setIntent(r10);
    L5:
        Intent r11 = getIntent();
        q.f(r11, "getIntent(...)");
        if (shouldKeepFullscreenForPrivacy(r11) == false) goto L8;
        initFullscreenPrivacyWindow();
    L9:
        checkShouldShowPrivacyDialog();
        return;
    L8:
        initWindow();
        goto L9
    }
}
