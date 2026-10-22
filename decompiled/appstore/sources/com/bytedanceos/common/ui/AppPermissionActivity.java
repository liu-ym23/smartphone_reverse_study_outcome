package com.bytedanceos.common.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import com.bytedanceos.common.R$anim;
import com.bytedanceos.common.R$drawable;
import com.bytedanceos.common.R$id;
import com.bytedanceos.common.R$layout;
import com.bytedanceos.common.R$string;
import com.bytedanceos.common.ui.widget.AppPermissionPresenter;
import com.bytedanceos.common.ui.widget.AppPermissionView;
import com.bytedanceos.common.utils.u;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public class AppPermissionActivity extends StatusBarActivity implements View.OnClickListener {
    public static final String EXTRA_APP_ICON_URL = "icon_url";
    public static final String EXTRA_APP_NAME = "name";
    public static final String EXTRA_APP_PKG = "pkg";
    public static final String EXTRA_APP_VERSION = "version";
    private String mIconUrl;
    private String mName;
    private String mPkg;
    private AppPermissionPresenter mPresenter;
    private String mVersion;

    public AppPermissionActivity() {
    }

    public static Intent create(Activity r10, String r11, String r12, String r13, String r14) {
        return new Intent(r10, AppPermissionActivity.class).putExtra(EXTRA_APP_PKG, r11).putExtra("name", r12).putExtra("version", r13).putExtra(EXTRA_APP_ICON_URL, r14);
    }

    private void resolveArgs(Intent r10) {
        this.mPkg = r10.getStringExtra(EXTRA_APP_PKG);     // Catch: Exception -> L4
        this.mName = r10.getStringExtra("name");     // Catch: Exception -> L4
        this.mVersion = r10.getStringExtra("version");     // Catch: Exception -> L4
        this.mIconUrl = r10.getStringExtra(EXTRA_APP_ICON_URL);     // Catch: Exception -> L4
    L7:
        if (this.mPkg == null) goto L16;
        if (this.mName == null) goto L16;
        if (this.mVersion == null) goto L16;
        if (this.mIconUrl == null) goto L16;
        return;
    L16:
        throw new IllegalArgumentException("Missing Intent extra args.");
    L4:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    @Override // com.bytedanceos.common.ui.StatusBarActivity, android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(R$anim.slide_in_from_left, R$anim.slide_out_to_right);
    }

    @Override // com.bytedanceos.common.ui.StatusBarActivity
    public View initHeaderView() {
        OFloatingTitleBar r10 = (OFloatingTitleBar) findViewById(R$id.toolbar);
        u.d(r10);
        r10.setCenterTitle(R$string.permission_detail);
        r10.k(R$drawable.oui_title_bar_back, -1, new AnonymousClass1(this));
        return r10;
    }

    public void initView() {
        resolveArgs(getIntent());
        AppPermissionView r10 = (AppPermissionView) findViewById(R$id.apv);
        ScrollView r11 = (ScrollView) findViewById(R$id.scroll_wrapper);
        AppPermissionPresenter r12 = new AppPermissionPresenter(r10, this.mPkg, this.mName, this.mVersion, this.mIconUrl);
        this.mPresenter = r12;
        r12.loadPermissionsFromServer();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r10) {
        if (com.bytedanceos.common.toolbox.e.p0() == true) goto L6;
        return;
    L6:
        if (R$id.left_action_back != r10.getId()) goto L9;
        finish();
        return;
    }

    @Override // com.bytedanceos.common.ui.StatusBarActivity, com.bytedanceos.common.ui.BasicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r10) {
        super.onCreate(r10);
        setContentView(R$layout.view_permission);
        initView();
    }

    @Override // com.bytedanceos.common.ui.StatusBarActivity, com.bytedanceos.common.ui.BasicActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mPresenter.destroy();
    }
}
