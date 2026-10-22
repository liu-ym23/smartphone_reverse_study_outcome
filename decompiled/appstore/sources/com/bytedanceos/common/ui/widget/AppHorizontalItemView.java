package com.bytedanceos.common.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.bytedanceos.common.R$drawable;
import com.bytedanceos.common.R$id;
import com.bytedanceos.common.R$layout;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.network.widget.NetworkImageView;
import com.bytedanceos.common.ui.widget.oui.OUIAppStatusView;
import tc.f;

/* JADX INFO: loaded from: classes2.dex */
public class AppHorizontalItemView extends ParentView {
    private TextView mAppName;
    private OUIAppStatusView mAppStatusView;
    private NetworkImageView mIcon;
    private View.OnClickListener mOnBtnClickListener;
    private View.OnClickListener mOnItemClickListener;

    public AppHorizontalItemView(Context r10) {
        super(r10);
        this.mOnBtnClickListener = null;
        this.mOnItemClickListener = null;
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R$layout.search_hot_apps_item, this);
        setDescendantFocusability(393216);
        this.mIcon = (NetworkImageView) findViewById(R$id.search_hot_apps_item_icon);
        this.mAppName = (TextView) findViewById(R$id.search_hot_apps_item_name);
        this.mAppStatusView = (OUIAppStatusView) findViewById(R$id.search_hot_apps_status_view);
        setFocusable(true);
        setClickable(true);
        setFocusableInTouchMode(true);
    }

    public void bindData(AppInfo r10) {
        updateItemView(r10);
    }

    public void disableClick() {
        setFocusable(false);
        setClickable(false);
        setFocusableInTouchMode(false);
    }

    public void setOnClickListener(View.OnClickListener r10, View.OnClickListener r11) {
        this.mOnBtnClickListener = r10;
        this.mOnItemClickListener = r11;
    }

    public void updateAppStatus(AppInfo r10) {
        OUIAppStatusView r11 = this.mAppStatusView;
        if (r11 == null) goto L6;
        r11.updateDownloadStatus(r10);
        return;
    }

    public void updateItemView(AppInfo r10) {
        setTag(R$id.appinfo, r10);
        View.OnClickListener r11 = this.mOnItemClickListener;
        if (r11 == null) goto L5;
        setOnClickListener(r11);
    L5:
        this.mAppName.setText(r10.appName);
        NetworkImageView r12 = this.mIcon;
        int r13 = R$drawable.oui_default_app_icon;
        r12.setErrorImageResId(r13);
        this.mIcon.setDefaultImageResId(r13);
        this.mIcon.e(r10.appIcon, f.i(30));
        this.mAppStatusView.updateDownloadStatus(r10);
        this.mAppStatusView.setTag(r10);
        View.OnClickListener r14 = this.mOnBtnClickListener;
        if (r14 == null) goto L9;
        this.mAppStatusView.setOnClickListener(r14);
        return;
    }

    public AppHorizontalItemView(Context r10, AttributeSet r11) {
        super(r10, r11);
        this.mOnBtnClickListener = null;
        this.mOnItemClickListener = null;
        init();
    }

    public AppHorizontalItemView(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.mOnBtnClickListener = null;
        this.mOnItemClickListener = null;
        init();
    }
}
