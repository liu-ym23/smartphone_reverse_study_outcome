package com.bytedanceos.common.core.ui;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import com.bytedanceos.common.R$drawable;
import com.bytedanceos.common.R$id;
import com.bytedanceos.common.R$layout;
import com.bytedanceos.common.R$string;
import com.bytedanceos.common.ui.StatusBarActivity;
import com.bytedanceos.common.utils.ActivityUtilKt;
import com.obric.common.oea.style.scene.transition.TransitionAnimStyle;
import com.obric.oui.image.OImageAppIcon;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.tmall.wireless.tangram.structure.card.FixCard;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.internal.x;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\u0003J\u000f\u0010\u0010\u001a\u00020\u0006H\u0003¢\u0006\u0004\b\u0010\u0010\u0003J\u000f\u0010\u0011\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0011\u0010\u0003J\u0013\u0010\u0014\u001a\u00020\u0013*\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/bytedanceos/common/core/ui/AboutActivity;", "Lcom/bytedanceos/common/ui/StatusBarActivity;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "", "useEdgeToEdgeStatusBar", "()Z", "Landroid/view/View;", "initHeaderView", "()Landroid/view/View;", "finish", "initContentView", "F", "Landroid/content/Context;", "", FixCard.FixStyle.KEY_Y, "(Landroid/content/Context;)Ljava/lang/String;", "appstorecommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AboutActivity extends StatusBarActivity {
    public AboutActivity() {
    }

    public static final void A(AboutActivity r10, View r11) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        AppStoreWebViewActivity.Z(r10, "https://beian.miit.gov.cn/", r10.getString(R$string.icp_page_title));
    }

    public static final void B(AboutActivity r10, View r11) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        AppStoreWebViewActivity.Z(r10, "https://os.obriccloud.com/agreement/appstore_privacy", r10.getString(R$string.privacy_policy));
    }

    public static final void C(AboutActivity r10, View r11) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        AppStoreWebViewActivity.Z(r10, "https://os.obriccloud.com/agreement/appstore_permissions", r10.getString(R$string.app_permissions_desc));
    }

    public static final void D(AboutActivity r10, View r11) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        AppStoreWebViewActivity.Z(r10, "https://os.oceancloudapi.com/agreement/appstore_user_agreement", r10.getString(R$string.app_user_agreement));
    }

    public static final void E(AboutActivity r10, View r11) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        r10.onBackPressed();
    }

    public static /* synthetic */ void s(AboutActivity r10, View r11) {
        A(r10, r11);
    }

    public static /* synthetic */ void t(AboutActivity r10, View r11) {
        E(r10, r11);
    }

    public static /* synthetic */ void u(AboutActivity r10, View r11) {
        D(r10, r11);
    }

    public static /* synthetic */ void v(OCardListItem r10, AboutActivity r11, View r12) {
        z(r10, r11, r12);
    }

    public static /* synthetic */ void w(AboutActivity r10, View r11) {
        C(r10, r11);
    }

    public static /* synthetic */ void x(AboutActivity r10, View r11) {
        B(r10, r11);
    }

    public static final void z(OCardListItem r10, AboutActivity r11, View r12) {
        kotlin.jvm.internal.q.g(r10, "$this_apply");
        kotlin.jvm.internal.q.g(r11, "this$0");
        Intent r13 = new Intent("com.android.permissioncontroller.permissionplus.AppPermissionGroup");
        r13.putExtra("PACKAGE_NAME", r10.getContext().getPackageName());
        Result.a r14 = Result.Companion;     // Catch: Throwable -> L5
        r11.startActivity(r13);     // Catch: Throwable -> L5
        Object r15 = Result.m35constructorimpl(Unit.f21064a);     // Catch: Throwable -> L5
    L7:
        Throwable r16 = Result.m38exceptionOrNullimpl(r15);
        if (r16 == null) goto L13;
        com.bytedanceos.common.toolbox.j.q("AboutActivity startActivity fail", r16);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.a r17 = Result.Companion;
        r15 = Result.m35constructorimpl(kotlin.c.a(th));
        goto L7
    }

    public final void F() {
        OImageAppIcon r10 = (OImageAppIcon) findViewById(R$id.app_icon);
        if (r10 != null) goto L5;
        return;
    L5:
        r10.setImageResource(R$drawable.app_store_icon);
        kotlinx.coroutines.h.d(androidx.lifecycle.s.a(this), null, null, new AboutActivity$loadAppIconAsync$1(this, r10, null), 3, null);
    }

    @Override // com.bytedanceos.common.ui.StatusBarActivity, android.app.Activity
    public void finish() {
        super.finish();
        xb.b.b(this, TransitionAnimStyle.Standard);
    }

    public final void initContentView() {
        F();
        OTextView r10 = (OTextView) findViewById(R$id.app_version);
        if (r10 == null) goto L5;
        x r11 = x.f21192a;
        String r12 = getString(R$string.app_detail_label_version);
        kotlin.jvm.internal.q.f(r12, "getString(...)");
        Context r13 = r10.getContext();
        kotlin.jvm.internal.q.f(r13, "getContext(...)");
        String r14 = String.format(r12, Arrays.copyOf(new Object[]{y(r13)}, 1));
        kotlin.jvm.internal.q.f(r14, "format(...)");
        r10.setText(r14);
    L5:
        OCardListItem r15 = (OCardListItem) findViewById(R$id.privacy_policy);
        if (r15 == null) goto L8;
        r15.setTitle(getString(R$string.privacy_policy));
        r15.H(true);
        r15.setOnContentClickListener(new c(this));
    L8:
        OCardListItem r16 = (OCardListItem) findViewById(R$id.permission_desc);
        if (r16 == null) goto L11;
        r16.setTitle(getString(R$string.app_permissions_desc));
        r16.H(true);
        r16.setOnContentClickListener(new d(this));
    L11:
        OCardListItem r17 = (OCardListItem) findViewById(R$id.user_agreement);
        if (r17 == null) goto L14;
        r17.setTitle(getString(R$string.app_user_agreement));
        r17.H(true);
        r17.setOnContentClickListener(new e(this));
    L14:
        final OCardListItem r18 = (OCardListItem) findViewById(R$id.permission_manager);
        if (r18 == null) goto L17;
        r18.setTitle(getString(R$string.app_permission_manager));
        r18.H(true);
        r18.setOnContentClickListener(new f(r18, this));
    L17:
        View r19 = findViewById(R$id.icp_view);
        if (r19 == null) goto L21;
        r19.setOnClickListener(new g(this));
        return;
    }

    @Override // com.bytedanceos.common.ui.StatusBarActivity
    public View initHeaderView() {
        OFloatingTitleBar r10 = (OFloatingTitleBar) findViewById(R$id.toolbar);
        if (r10 == null) goto L5;
        r10.k(R$drawable.oui_title_bar_back, -1, new h(this));
    L5:
        kotlin.jvm.internal.q.d(r10);
        return r10;
    }

    @Override // com.bytedanceos.common.ui.StatusBarActivity, com.bytedanceos.common.ui.BasicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r10) {
        super.onCreate(r10);
        ActivityUtilKt.a(this);
        xb.b.a(this, TransitionAnimStyle.Standard);
        setContentView(R$layout.activity_about);
        initContentView();
    }

    @Override // com.bytedanceos.common.ui.StatusBarActivity
    public boolean useEdgeToEdgeStatusBar() {
        return true;
    }

    public final String y(Context r10) {
        String r11 = r10.getPackageManager().getPackageInfo(r10.getPackageName(), 0).versionName;     // Catch: PackageManager.NameNotFoundException -> L6
        if (r11 != null) goto L10;
        return "unknown";
    L10:
        return r11;
    L6:
        return "no package";
    }
}
