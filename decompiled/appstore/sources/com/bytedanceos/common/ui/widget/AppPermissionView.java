package com.bytedanceos.common.ui.widget;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedanceos.common.R$id;
import com.bytedanceos.common.network.widget.NetworkImageView;
import com.bytedanceos.common.utils.CompatAppSecurityPermisions;
import tc.f;

/* JADX INFO: loaded from: classes2.dex */
public class AppPermissionView extends LinearLayout {
    private NetworkImageView mIcon;
    private TextView mName;
    private LinearLayout mPermsContainer;
    private TextView mVersion;

    public AppPermissionView(Context r10, AttributeSet r11) {
        super(r10, r11);
        setOrientation(1);
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.mIcon = (NetworkImageView) findViewById(R$id.app_icon);
        this.mName = (TextView) findViewById(R$id.app_name);
        this.mVersion = (TextView) findViewById(R$id.app_version);
        this.mPermsContainer = (LinearLayout) findViewById(R$id.perms_container);
    }

    public void setAppName(String r10) {
        this.mName.setText(r10);
    }

    public void setIcon(String r10) {
        this.mIcon.e(r10, f.i(20));
    }

    public void setVersion(String r10) {
        this.mVersion.setText(r10);
    }

    public void showPermissions(PackageInfo r10) {
        this.mPermsContainer.removeAllViews();
        CompatAppSecurityPermisions r11 = new CompatAppSecurityPermisions(getContext(), r10);
        this.mPermsContainer.addView(r11.k());
    }
}
